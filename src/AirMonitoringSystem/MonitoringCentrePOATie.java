package AirMonitoringSystem;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "MonitoringCentre".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 12 Apr 2020, 11:28:37
 */

public class MonitoringCentrePOATie
	extends MonitoringCentrePOA
{
	private MonitoringCentreOperations _delegate;

	private POA _poa;
	public MonitoringCentrePOATie(MonitoringCentreOperations delegate)
	{
		_delegate = delegate;
	}
	public MonitoringCentrePOATie(MonitoringCentreOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public AirMonitoringSystem.MonitoringCentre _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		AirMonitoringSystem.MonitoringCentre __r = AirMonitoringSystem.MonitoringCentreHelper.narrow(__o);
		return __r;
	}
	public AirMonitoringSystem.MonitoringCentre _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		AirMonitoringSystem.MonitoringCentre __r = AirMonitoringSystem.MonitoringCentreHelper.narrow(__o);
		return __r;
	}
	public MonitoringCentreOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(MonitoringCentreOperations delegate)
	{
		_delegate = delegate;
	}
	public POA _default_POA()
	{
		if (_poa != null)
		{
			return _poa;
		}
		return super._default_POA();
	}
	public void raise_alarm(AirMonitoringSystem.NoxReading alarm_reading)
	{
_delegate.raise_alarm(alarm_reading);
	}

	public void register_regional_centre(java.lang.String centre_name)
	{
_delegate.register_regional_centre(centre_name);
	}

	public void register_agency(java.lang.String name, java.lang.String contact_details, java.lang.String area_of_interest)
	{
_delegate.register_agency(name,contact_details,area_of_interest);
	}

}
