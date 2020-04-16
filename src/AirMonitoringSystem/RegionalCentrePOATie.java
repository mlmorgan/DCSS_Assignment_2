package AirMonitoringSystem;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "RegionalCentre".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 16 Apr 2020, 12:31:26
 */

public class RegionalCentrePOATie
	extends RegionalCentrePOA
{
	private RegionalCentreOperations _delegate;

	private POA _poa;
	public RegionalCentrePOATie(RegionalCentreOperations delegate)
	{
		_delegate = delegate;
	}
	public RegionalCentrePOATie(RegionalCentreOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public AirMonitoringSystem.RegionalCentre _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		AirMonitoringSystem.RegionalCentre __r = AirMonitoringSystem.RegionalCentreHelper.narrow(__o);
		return __r;
	}
	public AirMonitoringSystem.RegionalCentre _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		AirMonitoringSystem.RegionalCentre __r = AirMonitoringSystem.RegionalCentreHelper.narrow(__o);
		return __r;
	}
	public RegionalCentreOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(RegionalCentreOperations delegate)
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
	public void add_monitoring_station(java.lang.String station_name)
	{
_delegate.add_monitoring_station(station_name);
	}

	public void raise_alarm(AirMonitoringSystem.NoxReading alarmReading)
	{
_delegate.raise_alarm(alarmReading);
	}

	public AirMonitoringSystem.NoxReading[] take_readings()
	{
		return _delegate.take_readings();
	}

	public AirMonitoringSystem.NoxReading[] log()
	{
		return _delegate.log();
	}

}
