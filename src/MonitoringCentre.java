import AirMonitoringSystem.*;

import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

class MonitoringCentreServant extends MonitoringCentrePOA {
    private ORB orb;
    private MonitoringCentre parent;
    private ArrayList<String> listOfCentres;
    NamingContextExt nameService;

    MonitoringCentreServant(MonitoringCentre parentGUI, ORB orb_val) {
        parent = parentGUI;
        orb = orb_val;
        listOfCentres = new ArrayList<>();

        try {
            // Get a reference to the Naming service
            org.omg.CORBA.Object nameServiceObj =
                    orb.resolve_initial_references ("NameService");
            if (nameServiceObj == null) {
                System.out.println("nameServiceObj = null");
                return;
            }

            // Use NamingContextExt instead of NamingContext. This is
            // part of the Interoperable naming Service.
            nameService = NamingContextExtHelper.narrow(nameServiceObj);
            if (nameService == null) {
                System.out.println("nameService = null");
                return;
            }

        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        };
    }

    public void raise_alarm(NoxReading alarm_reading) {
        parent.addMessage("Alarm raised by: " + alarm_reading.station_name);
    }

    public void register_agency(String name, String contact_details, String area_of_interest) {

    }

    public void register_regional_centre(String centre_name) {
        listOfCentres.add(centre_name);
        parent.addCentre(centre_name);
        parent.addMessage("Regional Centre '" + centre_name + "' registered.\n\n");
    }

    public void register_monitoring_station(String centre_name) {
        parent.addStation(centre_name);
        parent.addMessage("Monitoring Station '" + centre_name + "' registered.\n\n");
    }

    public void poll_centres() {
        parent.addMessage("Polling all centres...\n");
        for (String centreName : listOfCentres) {
            parent.addMessage("  Polling: " + centreName + "\n");
            try {
                AirMonitoringSystem.RegionalCentre regionalCentre = RegionalCentreHelper.narrow(nameService.resolve_str(centreName));
                NoxReading[] readings = regionalCentre.take_readings();
                for (NoxReading reading : readings) {
                    if (reading.value > 50) {
                        parent.addMessage("    HIGH POLLUTANT LEVELS DETECTED:\n");
                    }
                    parent.addMessage("    Station: " + reading.station_name + " Reading: " + reading.value + "\n");
                }
            } catch (Exception e) {
                System.err.println("ERROR: " + e);
                e.printStackTrace(System.out);
            }
        }
        parent.addMessage("\n");
    }

}

class MonitoringCentre extends JFrame {
    private JTextArea textArea;
    private DefaultComboBoxModel rcNameModel, msNameModel;

    public MonitoringCentre(String[] args) {
        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // get reference to rootpoa & activate the POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            //Create the servant object
            MonitoringCentreServant monitoringCentreRef = new MonitoringCentreServant(this, orb);

            // Register it with the ORB
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(monitoringCentreRef);
            AirMonitoringSystem.MonitoringCentre mcref = MonitoringCentreHelper.narrow(ref);

            // Get a reference to the naming service
            org.omg.CORBA.Object nameServiceObj = orb.resolve_initial_references("NameService");
            if (nameServiceObj == null) {
                System.out.println("nameServiceObj = null");
                return;
            }

            // Use NamingContextExt which is part of the Interoperable
            // Naming Service (INS) specification.
            NamingContextExt nameService = NamingContextExtHelper.narrow(nameServiceObj);
            if (nameService == null) {
                System.out.println("nameService = null");
                return;
            }

            // bind the Count object in the Naming service
            String name = "monitoring_centre";
            NameComponent[] monitoringCentreName = nameService.to_name(name);
            nameService.rebind(monitoringCentreName, mcref);

            // set up the GUI

            JFrame mainFrame = new JFrame("Monitoring Centre");

            addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent evt) {
                    System.exit(0);
                }
            });

            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(700, 400);
            mainFrame.setLayout(new GridLayout(1, 2));

            JPanel logPanel = new JPanel();
            JPanel actionPanel = new JPanel();

            logPanel.setLayout(new BoxLayout(logPanel, BoxLayout.PAGE_AXIS));
            actionPanel.setLayout(new BoxLayout(actionPanel, BoxLayout.PAGE_AXIS));

            textArea = new JTextArea(20,25);

            JButton pollCentresButton = new JButton("Poll All Centres");
            pollCentresButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    monitoringCentreRef.poll_centres();
                }
            });

            rcNameModel = new DefaultComboBoxModel();
            JComboBox rcNameList = new JComboBox(rcNameModel);

            JButton retrieveLogButton = new JButton("Retrieve Log from Regional Centre");
            retrieveLogButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    String centreName = rcNameList.getSelectedItem().toString();
                    try {
                        AirMonitoringSystem.RegionalCentre regionalCentre = RegionalCentreHelper.narrow(nameService.resolve_str(centreName));
                        NoxReading[] log = regionalCentre.log();
                        addMessage("Log for " + centreName + ":\n");
                        displayLog(log);
                    } catch (Exception e) {
                        System.err.println("ERROR: " + e);
                        e.printStackTrace(System.out);
                    }
                }
            });

            msNameModel = new DefaultComboBoxModel();
            JComboBox msNameList = new JComboBox(msNameModel);

            JButton activateButton = new JButton("Activate Station");
            activateButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    String stationName = msNameList.getSelectedItem().toString();
                    try {
                        AirMonitoringSystem.MonitoringStation monitoringStation = MonitoringStationHelper.narrow(nameService.resolve_str(stationName));
                        monitoringStation.activate();
                    } catch (Exception e) {
                        System.err.println("ERROR: " + e);
                        e.printStackTrace(System.out);
                    }
                }
            });

            JButton deactivateButton = new JButton("Deactivate Station");
            deactivateButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    String stationName = msNameList.getSelectedItem().toString();
                    try {
                        AirMonitoringSystem.MonitoringStation monitoringStation = MonitoringStationHelper.narrow(nameService.resolve_str(stationName));
                        monitoringStation.deactivate();
                    } catch (Exception e) {
                        System.err.println("ERROR: " + e);
                        e.printStackTrace(System.out);
                    }
                }
            });

            JButton resetButton = new JButton("Reset Station");
            resetButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    String stationName = msNameList.getSelectedItem().toString();
                    try {
                        AirMonitoringSystem.MonitoringStation monitoringStation = MonitoringStationHelper.narrow(nameService.resolve_str(stationName));
                        monitoringStation.reset();
                    } catch (Exception e) {
                        System.err.println("ERROR: " + e);
                        e.printStackTrace(System.out);
                    }
                }
            });

            logPanel.add(textArea);

            actionPanel.add(pollCentresButton);
            actionPanel.add(rcNameList);
            actionPanel.add(retrieveLogButton);
            actionPanel.add(msNameList);
            actionPanel.add(activateButton);
            actionPanel.add(deactivateButton);
            actionPanel.add(resetButton);

            mainFrame.add(logPanel);
            mainFrame.add(actionPanel);
            mainFrame.setVisible(true);

            // wait for invocations from clients
            textArea.append("Monitoring Centre online.\n\n");

        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
    }

    void addMessage(String message){
        textArea.append(message);
    }

    void addCentre(String name) { rcNameModel.addElement(name);}

    void addStation(String name) { msNameModel.addElement(name);}

    void displayLog(NoxReading[] log) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
        for(NoxReading reading : log) {
            addMessage("  " + reading.station_name + ": " + reading.value + " at " + formatter.format(reading.date) + "\n");
        }
        addMessage("\n");
    }

    public static void main(String[] args) {
        final String[] arguments = args;
        java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() { new MonitoringCentre(arguments); }
        });
    }
}