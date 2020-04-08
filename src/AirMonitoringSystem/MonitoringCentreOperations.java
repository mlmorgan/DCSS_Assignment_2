package AirMonitoringSystem;


/**
 * Generated from IDL interface "MonitoringCentre".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 7 Apr 2020, 15:57:47
 */

public interface MonitoringCentreOperations
{
	/* constants */
	/* operations  */
	AirMonitoringSystem.ServerRef[] List_of_centres();
	void raise_alarm(AirMonitoringSystem.NoxReading alarm_reading);
	void register_agency(java.lang.String name, java.lang.String contact_details, java.lang.String area_of_interest);
	void register_regional_centre(java.lang.String name, java.lang.String location, java.lang.String centre_ior);
}
