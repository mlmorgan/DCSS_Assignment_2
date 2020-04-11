import AirMonitoringSystem.*;

import org.omg.CORBA.*;
import org.omg.CosNaming.*;
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
        parent.addMessage("Alarm raised!\n\n");
    }

    public void register_agency(String name, String contact_details, String area_of_interest) {

    }

    public void register_regional_centre(String name, String location) {
        parent.addMessage("Regional Centre registered");
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

            //Create the servant object
            MonitoringCentreServant monitoringCentreRef = new MonitoringCentreServant(this);

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
            textarea = new JTextArea(20,25);
            JScrollPane scrollpane = new JScrollPane(textarea);
            JPanel panel = new JPanel();

            panel.add(scrollpane);
            getContentPane().add(panel, "Center");

            setSize(400, 500);
            setTitle("Monitoring Centre");

            addWindowListener (new java.awt.event.WindowAdapter () {
                public void windowClosing (java.awt.event.WindowEvent evt) {
                    System.exit(0);
                }
            } );

            // wait for invocations from clients
            textarea.append("Monitoring Centre online.\n\n");

        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
    }

    void addMessage(String message){
        textarea.append(message);
    }

    public static void main(String[] args) {
        final String[] arguments = args;
        java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() { new MonitoringCentre(arguments).setVisible(true); }
        });
    }
}