package AirMonitoringSystem;

/**
 * Generated from IDL interface "MonitoringStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 7 Apr 2020, 15:57:47
 */

public final class MonitoringStationHolder	implements org.omg.CORBA.portable.Streamable{
	 public MonitoringStation value;
	public MonitoringStationHolder()
	{
	}
	public MonitoringStationHolder (final MonitoringStation initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return MonitoringStationHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = MonitoringStationHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		MonitoringStationHelper.write (_out,value);
	}
}
