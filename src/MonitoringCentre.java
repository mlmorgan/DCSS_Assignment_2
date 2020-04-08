import AirMonitoringSystem.MonitoringCentrePOA;
import AirMonitoringSystem.NoxReading;
import AirMonitoringSystem.ServerRef;

import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

class MonitoringCentreServant extends MonitoringCentrePOA {
    private MonitoringCentre parent;

    MonitoringCentreServant(MonitoringCentre parentGUI) {
        parent = parentGUI;
    }

    public ServerRef[] List_of_centres() {
        return new ServerRef[0];
    }

    public void raise_alarm(NoxReading alarm_reading) {

    }

    public void register_agency(String name, String contact_details, String area_of_interest) {

    }

    public void register_regional_centre(String name, String location, String centre_ior) {

    }

}

class MonitoringCentre extends JFrame {
    private JTextArea textarea;

    public MonitoringCentre(String[] args) {
        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // get reference to rootpoa & activate the POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // create servant and register it with the ORB
            MonitoringCentreServant monitoringCentreRef = new MonitoringCentreServant((this));

            // get the 'stringified IOR'
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(monitoringCentreRef);
            String stringified_ior = orb.object_to_string(ref);

            // Save IOR to file
            BufferedWriter out = new BufferedWriter(new FileWriter("server.ref"));
            out.write(stringified_ior);
            out.close();

            // set up the GUI
            textarea = new JTextArea(20,25);
            JScrollPane scrollpane = new JScrollPane(textarea);
            JPanel panel = new JPanel();

            panel.add(scrollpane);
            getContentPane().add(panel, "Center");

            setSize(400, 500);
            setTitle("Relay Demo Relay");

            addWindowListener (new java.awt.event.WindowAdapter () {
                public void windowClosing (java.awt.event.WindowEvent evt) {
                    System.exit(0);
                }
            } );

        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
    }

    public static void main(String[] args) {
        final String[] arguments = args;
        java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() { new MonitoringCentre(arguments).setVisible(true); }
        });
    }
}