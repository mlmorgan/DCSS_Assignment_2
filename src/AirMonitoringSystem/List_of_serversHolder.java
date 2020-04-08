package AirMonitoringSystem;

/**
 * Generated from IDL alias "List_of_servers".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 7 Apr 2020, 15:57:47
 */

public final class List_of_serversHolder
	implements org.omg.CORBA.portable.Streamable
{
	public AirMonitoringSystem.ServerRef[] value;

	public List_of_serversHolder ()
	{
	}
	public List_of_serversHolder (final AirMonitoringSystem.ServerRef[] initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return List_of_serversHelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = List_of_serversHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		List_of_serversHelper.write (out,value);
	}
}
