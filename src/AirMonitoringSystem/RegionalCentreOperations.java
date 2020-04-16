package AirMonitoringSystem;


/**
 * Generated from IDL interface "RegionalCentre".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 16 Apr 2020, 12:31:26
 */

public interface RegionalCentreOperations
{
	/* constants */
	/* operations  */
	AirMonitoringSystem.NoxReading[] log();
	void raise_alarm(AirMonitoringSystem.NoxReading alarmReading);
	AirMonitoringSystem.NoxReading[] take_readings();
	void add_monitoring_station(java.lang.String station_name);
}
