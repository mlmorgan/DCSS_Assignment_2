package AirMonitoringSystem;


/**
 * Generated from IDL interface "MonitoringStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 12 Apr 2020, 11:28:37
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
