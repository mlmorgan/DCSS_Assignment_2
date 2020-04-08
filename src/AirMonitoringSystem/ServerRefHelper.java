package AirMonitoringSystem;


/**
 * Generated from IDL struct "ServerRef".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 7 Apr 2020, 15:57:47
 */

public abstract class ServerRefHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(ServerRefHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_struct_tc(AirMonitoringSystem.ServerRefHelper.id(),"ServerRef",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("name", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("location", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("ior", org.omg.CORBA.ORB.init().create_string_tc(0), null)});
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final AirMonitoringSystem.ServerRef s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static AirMonitoringSystem.ServerRef extract (final org.omg.CORBA.Any any)
	{
		org.omg.CORBA.portable.InputStream in = any.create_input_stream();
		try
		{
			return read (in);
		}
		finally
		{
			try
			{
				in.close();
			}
			catch (java.io.IOException e)
			{
			throw new RuntimeException("Unexpected exception " + e.toString() );
			}
		}
	}

	public static String id()
	{
		return "IDL:AirMonitoringSystem/ServerRef:1.0";
	}
	public static AirMonitoringSystem.ServerRef read (final org.omg.CORBA.portable.InputStream in)
	{
		AirMonitoringSystem.ServerRef result = new AirMonitoringSystem.ServerRef();
		result.name=in.read_string();
		result.location=in.read_string();
		result.ior=in.read_string();
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final AirMonitoringSystem.ServerRef s)
	{
		java.lang.String tmpResult1 = s.name;
out.write_string( tmpResult1 );
		java.lang.String tmpResult2 = s.location;
out.write_string( tmpResult2 );
		java.lang.String tmpResult3 = s.ior;
out.write_string( tmpResult3 );
	}
}
