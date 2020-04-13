package AirMonitoringSystem;


/**
 * Generated from IDL interface "RegionalCentre".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 13 Apr 2020, 20:49:38
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
