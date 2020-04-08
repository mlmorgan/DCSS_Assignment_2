package AirMonitoringSystem;


/**
 * Generated from IDL interface "RegionalCentre".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 7 Apr 2020, 15:57:47
 */

public interface RegionalCentreOperations
{
	/* constants */
	/* operations  */
	java.lang.String name();
	java.lang.String location();
	AirMonitoringSystem.ServerRef[] List_of_stations();
	AirMonitoringSystem.NoxReading[] log();
	void raise_alarm(AirMonitoringSystem.NoxReading alarmReading);
	AirMonitoringSystem.NoxReading[] take_readings();
	void add_monitoring_station(java.lang.String name, java.lang.String location, java.lang.String station_ior);
}
