package AirMonitoringSystem;


/**
 * Generated from IDL interface "MonitoringStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 16 Apr 2020, 12:31:26
 */

public interface MonitoringStationOperations
{
	/* constants */
	/* operations  */
	boolean isActivated();
	AirMonitoringSystem.NoxReading get_reading();
	void activate();
	void deactivate();
	void reset();
}
