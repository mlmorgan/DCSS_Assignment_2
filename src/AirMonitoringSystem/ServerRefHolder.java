package AirMonitoringSystem;

/**
 * Generated from IDL struct "ServerRef".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 7 Apr 2020, 15:57:47
 */

public final class ServerRefHolder
	implements org.omg.CORBA.portable.Streamable
{
	public AirMonitoringSystem.ServerRef value;

	public ServerRefHolder ()
	{
	}
	public ServerRefHolder(final AirMonitoringSystem.ServerRef initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return AirMonitoringSystem.ServerRefHelper.type ();
	}
	public void _read(final org.omg.CORBA.portable.InputStream _in)
	{
		value = AirMonitoringSystem.ServerRefHelper.read(_in);
	}
	public void _write(final org.omg.CORBA.portable.OutputStream _out)
	{
		AirMonitoringSystem.ServerRefHelper.write(_out, value);
	}
}
