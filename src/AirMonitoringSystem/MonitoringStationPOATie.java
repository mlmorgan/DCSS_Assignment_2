package AirMonitoringSystem;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "MonitoringStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 12 Apr 2020, 11:28:37
 */

public class MonitoringStationPOATie
	extends MonitoringStationPOA
{
	private MonitoringStationOperations _delegate;

	private POA _poa;
	public MonitoringStationPOATie(MonitoringStationOperations delegate)
	{
		_delegate = delegate;
	}
	public MonitoringStationPOATie(MonitoringStationOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public AirMonitoringSystem.MonitoringStation _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		AirMonitoringSystem.MonitoringStation __r = AirMonitoringSystem.MonitoringStationHelper.narrow(__o);
		return __r;
	}
	public AirMonitoringSystem.MonitoringStation _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		AirMonitoringSystem.MonitoringStation __r = AirMonitoringSystem.MonitoringStationHelper.narrow(__o);
		return __r;
	}
	public MonitoringStationOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(MonitoringStationOperations delegate)
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
	public java.lang.String name()
	{
		return _delegate.name();
	}

	public void activate()
	{
_delegate.activate();
	}

	public void deactivate()
	{
_delegate.deactivate();
	}

	public AirMonitoringSystem.NoxReading get_reading()
	{
		return _delegate.get_reading();
	}

	public void reset()
	{
_delegate.reset();
	}

	public java.lang.String location()
	{
		return _delegate.location();
	}

}
