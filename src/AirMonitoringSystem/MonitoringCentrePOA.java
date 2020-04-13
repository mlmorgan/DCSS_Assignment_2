package AirMonitoringSystem;


/**
 * Generated from IDL interface "MonitoringCentre".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 13 Apr 2020, 20:49:38
 */

public abstract class MonitoringCentrePOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, AirMonitoringSystem.MonitoringCentreOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "register_monitoring_station", Integer.valueOf(0));
		m_opsHash.put ( "raise_alarm", Integer.valueOf(1));
		m_opsHash.put ( "register_regional_centre", Integer.valueOf(2));
		m_opsHash.put ( "register_agency", Integer.valueOf(3));
	}
	private String[] ids = {"IDL:AirMonitoringSystem/MonitoringCentre:1.0"};
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
	public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.ResponseHandler handler)
		throws org.omg.CORBA.SystemException
	{
		org.omg.CORBA.portable.OutputStream _out = null;
		// do something
		// quick lookup of operation
		java.lang.Integer opsIndex = (java.lang.Integer)m_opsHash.get ( method );
		if ( null == opsIndex )
			throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
		switch ( opsIndex.intValue() )
		{
			case 0: // register_monitoring_station
			{
				java.lang.String _arg0=_input.read_string();
				_out = handler.createReply();
				register_monitoring_station(_arg0);
				break;
			}
			case 1: // raise_alarm
			{
				AirMonitoringSystem.NoxReading _arg0=AirMonitoringSystem.NoxReadingHelper.read(_input);
				_out = handler.createReply();
				raise_alarm(_arg0);
				break;
			}
			case 2: // register_regional_centre
			{
				java.lang.String _arg0=_input.read_string();
				_out = handler.createReply();
				register_regional_centre(_arg0);
				break;
			}
			case 3: // register_agency
			{
				java.lang.String _arg0=_input.read_string();
				java.lang.String _arg1=_input.read_string();
				java.lang.String _arg2=_input.read_string();
				_out = handler.createReply();
				register_agency(_arg0,_arg1,_arg2);
				break;
			}
		}
		return _out;
	}

	public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id)
	{
		return ids;
	}
}
