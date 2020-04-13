import AirMonitoringSystem.*;

import AirMonitoringSystem.MonitoringCentre;
import AirMonitoringSystem.RegionalCentre;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import org.omg.CORBA.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

class MonitoringStationServant extends MonitoringStationPOA {

    private ORB orb;
    private AirMonitoringSystem.RegionalCentre regionalCentre;
    private MonitoringStation parent;

    MonitoringStationServant(MonitoringStation parentGUI, ORB orb_val) {
        parent = parentGUI;
        orb = orb_val;
    }

    public String name() {
        return null;
    }

    public String location() {
        return null;
    }

    public NoxReading get_reading() {
        return parent.getCurrentReading();
    }

    public void activate() {

    }

    public void deactivate() {

    }

    public void reset() {

    }
}

public class MonitoringStation extends JFrame {
    private JTextArea textarea;
    private JSlider currentReadingSlider;
    private String msname;

    public MonitoringStation(String[] args) {
        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // get reference to rootpoa & activate the POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            //Create the servant object
            MonitoringStationServant monitoringStationRef = new MonitoringStationServant(this, orb);

            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(monitoringStationRef);
            AirMonitoringSystem.MonitoringStation msref = MonitoringStationHelper.narrow(ref);

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
            msname = args[1]+"_"+args[2];
            NameComponent[] monitoringStationName = nameService.to_name(msname);
            nameService.rebind(monitoringStationName, msref);

            String rcname = args[1];
            RegionalCentre regionalCentre = RegionalCentreHelper.narrow(nameService.resolve_str(rcname));

            // Register with regional centre upon activation
            regionalCentre.add_monitoring_station(msname);

            // set up the GUI
            currentReadingSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
            JPanel buttonpanel = new JPanel();
            JButton takeReadingButton = new JButton("Take Reading");
            takeReadingButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    NoxReading currentReading = getCurrentReading();
                    if(currentReading.value >= 50) {
                        textarea.append("High pollutant level detected. Raising Alarm!\n\n");
                        regionalCentre.raise_alarm(currentReading);
                    }
                }
            });

            textarea = new JTextArea(20, 25);
            JScrollPane scrollpane = new JScrollPane(textarea);
            JPanel textpanel = new JPanel();
            JLabel alarmThresholdLabel = new JLabel("Over 50% = Alarm Sent");

            Date date = new Date();
            date.getTime();
            textpanel.add(scrollpane);
            buttonpanel.add(takeReadingButton);
            buttonpanel.add(alarmThresholdLabel);
            getContentPane().add(currentReadingSlider, "North");
            getContentPane().add(buttonpanel, "Center");
            getContentPane().add(textpanel, "South");


            setSize(400, 500);
            setTitle("Monitoring Station - " + msname);

            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    System.exit(0);
                }
            });

            textarea.append("Client started.  Click the button to contact relay...\n\n");

        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }

    public NoxReading getCurrentReading() {
        Date date = new Date();
        NoxReading reading = new NoxReading(date.getTime(),msname,currentReadingSlider.getValue());
        return reading;
    };

    public static void main(String[] args) {
        final String[] arguments = args;
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new  MonitoringStation(arguments).setVisible(true);
            }
        });
    }
}