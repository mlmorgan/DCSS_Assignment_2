package AirMonitoringSystem;


/**
 * Generated from IDL interface "MonitoringStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 7 Apr 2020, 15:57:47
 */

public interface MonitoringStationOperations
{
	/* constants */
	/* operations  */
	java.lang.String name();
	java.lang.String location();
	AirMonitoringSystem.NoxReading get_reading();
	void activate();
	void deactivate();
	void reset();
}
