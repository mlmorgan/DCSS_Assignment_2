package AirMonitoringSystem;


/**
 * Generated from IDL interface "MonitoringStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 13 Apr 2020, 20:49:38
 */

public abstract class MonitoringStationPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, AirMonitoringSystem.MonitoringStationOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "_get_name", Integer.valueOf(0));
		m_opsHash.put ( "activate", Integer.valueOf(1));
		m_opsHash.put ( "deactivate", Integer.valueOf(2));
		m_opsHash.put ( "get_reading", Integer.valueOf(3));
		m_opsHash.put ( "reset", Integer.valueOf(4));
		m_opsHash.put ( "_get_location", Integer.valueOf(5));
		m_opsHash.put ( "_get_isActivated", Integer.valueOf(6));
	}
	private String[] ids = {"IDL:AirMonitoringSystem/MonitoringStation:1.0"};
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
			case 0: // _get_name
			{
			_out = handler.createReply();
			java.lang.String tmpResult1 = name();
_out.write_string( tmpResult1 );
				break;
			}
			case 1: // activate
			{
				_out = handler.createReply();
				activate();
				break;
			}
			case 2: // deactivate
			{
				_out = handler.createReply();
				deactivate();
				break;
			}
			case 3: // get_reading
			{
				_out = handler.createReply();
				AirMonitoringSystem.NoxReadingHelper.write(_out,get_reading());
				break;
			}
			case 4: // reset
			{
				_out = handler.createReply();
				reset();
				break;
			}
			case 5: // _get_location
			{
			_out = handler.createReply();
			java.lang.String tmpResult2 = location();
_out.write_string( tmpResult2 );
				break;
			}
			case 6: // _get_isActivated
			{
			_out = handler.createReply();
			_out.write_boolean(isActivated());
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
