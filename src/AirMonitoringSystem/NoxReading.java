package AirMonitoringSystem;

/**
 * Generated from IDL struct "NoxReading".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 16 Apr 2020, 12:31:26
 */

public final class NoxReading
	implements org.omg.CORBA.portable.IDLEntity
{
	/** Serial version UID. */
	private static final long serialVersionUID = 1L;
	public NoxReading(){}
	public double date;
	public java.lang.String station_name = "";
	public int value;
	public NoxReading(double date, java.lang.String station_name, int value)
	{
		this.date = date;
		this.station_name = station_name;
		this.value = value;
	}
}
