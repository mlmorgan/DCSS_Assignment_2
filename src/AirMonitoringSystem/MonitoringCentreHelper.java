package AirMonitoringSystem;


/**
 * Generated from IDL interface "MonitoringCentre".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 7 Apr 2020, 15:57:47
 */

public abstract class MonitoringCentreHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(MonitoringCentreHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_interface_tc("IDL:AirMonitoringSystem/MonitoringCentre:1.0", "MonitoringCentre");
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final AirMonitoringSystem.MonitoringCentre s)
	{
			any.insert_Object(s);
	}
	public static AirMonitoringSystem.MonitoringCentre extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static String id()
	{
		return "IDL:AirMonitoringSystem/MonitoringCentre:1.0";
	}
	public static MonitoringCentre read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object(AirMonitoringSystem._MonitoringCentreStub.class));
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final AirMonitoringSystem.MonitoringCentre s)
	{
		_out.write_Object(s);
	}
	public static AirMonitoringSystem.MonitoringCentre narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof AirMonitoringSystem.MonitoringCentre)
		{
			return (AirMonitoringSystem.MonitoringCentre)obj;
		}
		else if (obj._is_a("IDL:AirMonitoringSystem/MonitoringCentre:1.0"))
		{
			AirMonitoringSystem._MonitoringCentreStub stub;
			stub = new AirMonitoringSystem._MonitoringCentreStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
		else
		{
			throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
		}
	}
	public static AirMonitoringSystem.MonitoringCentre unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof AirMonitoringSystem.MonitoringCentre)
		{
			return (AirMonitoringSystem.MonitoringCentre)obj;
		}
		else
		{
			AirMonitoringSystem._MonitoringCentreStub stub;
			stub = new AirMonitoringSystem._MonitoringCentreStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
	}
}
