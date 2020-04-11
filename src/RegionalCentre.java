import AirMonitoringSystem.*;

import AirMonitoringSystem.MonitoringCentre;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import org.omg.CORBA.*;

import javax.swing.*;
import java.io.*;

class RegionalCentreServant extends RegionalCentrePOA {

    private ORB orb;
    private AirMonitoringSystem.MonitoringCentre monitoringCentre;
    private RegionalCentre parent;

    RegionalCentreServant(RegionalCentre parentGUI, ORB orb_val) {
        parent = parentGUI;
        orb = orb_val;

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
            NamingContextExt nameService = NamingContextExtHelper.narrow(nameServiceObj);
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

    public ServerRef[] List_of_stations() {
        return new ServerRef[0];
    }

    public NoxReading[] log() {
        return new NoxReading[0];
    }

    public void raise_alarm(NoxReading alarmReading) {
        parent.addMessage("Alarm raised!\n\n");
        monitoringCentre.raise_alarm(alarmReading);
    }

    public NoxReading[] take_readings() {
        return new NoxReading[0];
    }

    public void add_monitoring_station(String name, String location) {

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
            //String rcname = "regionalCentreName";
            String rcname = args[1];
            NameComponent[] regionalCentreName = nameService.to_name(rcname);
            nameService.rebind(regionalCentreName, rcref);

//            String mcname = "monitoring_centre";
//            MonitoringCentre monitoringCentre = MonitoringCentreHelper.narrow(nameService.resolve_str(mcname));

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

            // wait for invocations from clients
            textarea.append("Regional Centre online.\n\n");

            // remove the "orb.run()" command,
            // or the server will run but the GUI will not be visible
            // orb.run();

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