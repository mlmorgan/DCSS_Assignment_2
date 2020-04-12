package AirMonitoringSystem;


/**
 * Generated from IDL interface "RegionalCentre".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 12 Apr 2020, 11:28:37
 */

public interface RegionalCentreOperations
{
	/* constants */
	/* operations  */
	java.lang.String name();
	java.lang.String location();
	AirMonitoringSystem.NoxReading[] log();
	void raise_alarm(AirMonitoringSystem.NoxReading alarmReading);
	AirMonitoringSystem.NoxReading[] take_readings();
	void add_monitoring_station(java.lang.String station_name);
}
