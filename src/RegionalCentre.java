import AirMonitoringSystem.*;

import AirMonitoringSystem.MonitoringCentre;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import org.omg.CORBA.*;

import javax.swing.*;
import java.util.ArrayList;

class RegionalCentreServant extends RegionalCentrePOA {

    private ORB orb;
    private AirMonitoringSystem.MonitoringCentre monitoringCentre;
    private RegionalCentre parent;
    private ArrayList<String> listOfStations;
    private ArrayList<NoxReading> logOfReadings;
    NamingContextExt nameService;

    RegionalCentreServant(RegionalCentre parentGUI, ORB orb_val) {
        parent = parentGUI;
        orb = orb_val;
        listOfStations = new ArrayList<>();
        logOfReadings = new ArrayList<>();

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

            String mcname = "monitoring_centre";
            monitoringCentre = MonitoringCentreHelper.narrow(nameService.resolve_str(mcname));
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        };

    }

    public String name() {
        return null;
    }

    public String location() {
        return null;
    }

    public NoxReading[] log() {
        return new NoxReading[0];
    }

    public void raise_alarm(NoxReading alarmReading) {
        parent.addMessage("Alarm raised by: " + alarmReading.station_name + "\n\n");
        boolean falseAlarm = true;
        for (NoxReading reading : logOfReadings) {
            if (((alarmReading.date - reading.date) < 30000) && !alarmReading.station_name.equals(reading.station_name)) {
                falseAlarm = false;
            }
        }

        if(falseAlarm) {
            parent.addMessage("Possible false alarm. Not escalating alert.\n\n");
        } else {
            parent.addMessage("Alerted by multiple stations. Escalating alarm!\n\n");
            monitoringCentre.raise_alarm(alarmReading);
        }

        logOfReadings.add(alarmReading);
    }

    public NoxReading[] take_readings() {
        ArrayList<NoxReading> readings = new ArrayList<>();
        for (String stationName : listOfStations) {
            try {
                AirMonitoringSystem.MonitoringStation monitoringStation = MonitoringStationHelper.narrow(nameService.resolve_str(stationName));
                NoxReading reading = monitoringStation.get_reading();
                readings.add(reading);
            } catch (Exception e) {
                System.err.println("ERROR: " + e);
                e.printStackTrace(System.out);
            }
        }
        return readings.toArray(NoxReading[]::new);
    };

    public void add_monitoring_station(String stationName) {
        listOfStations.add(stationName);
        parent.addMessage("Monitoring Station registered\n\n");
    }
}

class RegionalCentre extends JFrame {
    private JTextArea textarea;

    public RegionalCentre(String[] args) {
        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // get reference to rootpoa & activate the POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            //Create the servant object
            RegionalCentreServant regionalCentreRef = new RegionalCentreServant(this, orb);

            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(regionalCentreRef);
            AirMonitoringSystem.RegionalCentre rcref = RegionalCentreHelper.narrow(ref);

            // Get a reference to the Naming service
            org.omg.CORBA.Object nameServiceObj =
                    orb.resolve_initial_references ("NameService");
            if (nameServiceObj == null) {
                System.out.println("nameServiceObj = null");
                return;
            }

            // Use NamingContextExt instead of NamingContext. This is
            // part of the Interoperable naming Service.
            NamingContextExt nameService = NamingContextExtHelper.narrow(nameServiceObj);
            if (nameService == null) {
                System.out.println("nameService = null");
                return;
            }

            // bind the Count object in the Naming service
            String rcname = args[1];
            NameComponent[] regionalCentreName = nameService.to_name(rcname);
            nameService.rebind(regionalCentreName, rcref);

            String mcname = "monitoring_centre";
            MonitoringCentre monitoringCentre = MonitoringCentreHelper.narrow(nameService.resolve_str(mcname));

            monitoringCentre.register_regional_centre(rcname);

            // set up the GUI
            textarea = new JTextArea(20, 25);
            JScrollPane scrollpane = new JScrollPane(textarea);
            JPanel panel = new JPanel();

            panel.add(scrollpane);
            getContentPane().add(panel, "Center");

            setSize(400, 500);
            setTitle("Regional Centre");

            addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent evt) {
                    System.exit(0);
                }
            });

            textarea.append("Regional Centre online.\n\n");

        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
    }

    void addMessage(String message) {
        textarea.append(message);
    }

    public static void main(String[] args) {
        final String[] arguments = args;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegionalCentre(arguments).setVisible(true);
            }
        });
    }
}