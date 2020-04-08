package AirMonitoringSystem;

/**
 * Generated from IDL struct "NoxReading".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 7 Apr 2020, 15:57:47
 */

public final class NoxReadingHolder
	implements org.omg.CORBA.portable.Streamable
{
	public AirMonitoringSystem.NoxReading value;

	public NoxReadingHolder ()
	{
	}
	public NoxReadingHolder(final AirMonitoringSystem.NoxReading initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return AirMonitoringSystem.NoxReadingHelper.type ();
	}
	public void _read(final org.omg.CORBA.portable.InputStream _in)
	{
		value = AirMonitoringSystem.NoxReadingHelper.read(_in);
	}
	public void _write(final org.omg.CORBA.portable.OutputStream _out)
	{
		AirMonitoringSystem.NoxReadingHelper.write(_out, value);
	}
}
