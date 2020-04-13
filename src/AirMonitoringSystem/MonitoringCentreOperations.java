package AirMonitoringSystem;


/**
 * Generated from IDL interface "MonitoringCentre".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 13 Apr 2020, 20:49:38
 */

public interface MonitoringCentreOperations
{
	/* constants */
	/* operations  */
	void raise_alarm(AirMonitoringSystem.NoxReading alarm_reading);
	void register_agency(java.lang.String name, java.lang.String contact_details, java.lang.String area_of_interest);
	void register_regional_centre(java.lang.String centre_name);
	void register_monitoring_station(java.lang.String station_name);
}
