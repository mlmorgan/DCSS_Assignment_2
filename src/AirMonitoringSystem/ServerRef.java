package AirMonitoringSystem;

/**
 * Generated from IDL struct "ServerRef".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 7 Apr 2020, 15:57:47
 */

public final class ServerRef
	implements org.omg.CORBA.portable.IDLEntity
{
	/** Serial version UID. */
	private static final long serialVersionUID = 1L;
	public ServerRef(){}
	public java.lang.String name = "";
	public java.lang.String location = "";
	public java.lang.String ior = "";
	public ServerRef(java.lang.String name, java.lang.String location, java.lang.String ior)
	{
		this.name = name;
		this.location = location;
		this.ior = ior;
	}
}
