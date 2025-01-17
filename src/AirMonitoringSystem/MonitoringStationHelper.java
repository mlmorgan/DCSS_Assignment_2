package AirMonitoringSystem;


/**
 * Generated from IDL interface "MonitoringStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 16 Apr 2020, 12:31:26
 */

public abstract class MonitoringStationHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(MonitoringStationHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_interface_tc("IDL:AirMonitoringSystem/MonitoringStation:1.0", "MonitoringStation");
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final AirMonitoringSystem.MonitoringStation s)
	{
			any.insert_Object(s);
	}
	public static AirMonitoringSystem.MonitoringStation extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static String id()
	{
		return "IDL:AirMonitoringSystem/MonitoringStation:1.0";
	}
	public static MonitoringStation read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object(AirMonitoringSystem._MonitoringStationStub.class));
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final AirMonitoringSystem.MonitoringStation s)
	{
		_out.write_Object(s);
	}
	public static AirMonitoringSystem.MonitoringStation narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof AirMonitoringSystem.MonitoringStation)
		{
			return (AirMonitoringSystem.MonitoringStation)obj;
		}
		else if (obj._is_a("IDL:AirMonitoringSystem/MonitoringStation:1.0"))
		{
			AirMonitoringSystem._MonitoringStationStub stub;
			stub = new AirMonitoringSystem._MonitoringStationStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
		else
		{
			throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
		}
	}
	public static AirMonitoringSystem.MonitoringStation unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof AirMonitoringSystem.MonitoringStation)
		{
			return (AirMonitoringSystem.MonitoringStation)obj;
		}
		else
		{
			AirMonitoringSystem._MonitoringStationStub stub;
			stub = new AirMonitoringSystem._MonitoringStationStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
	}
}
