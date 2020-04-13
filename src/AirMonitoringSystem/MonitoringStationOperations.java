package AirMonitoringSystem;


/**
 * Generated from IDL interface "MonitoringStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 13 Apr 2020, 20:49:38
 */

public interface MonitoringStationOperations
{
	/* constants */
	/* operations  */
	java.lang.String name();
	java.lang.String location();
	boolean isActivated();
	AirMonitoringSystem.NoxReading get_reading();
	void activate();
	void deactivate();
	void reset();
}
