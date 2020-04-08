package AirMonitoringSystem;

/**
 * Generated from IDL alias "List_of_servers".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 7 Apr 2020, 15:57:47
 */

public abstract class List_of_serversHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;

	public static void insert (org.omg.CORBA.Any any, AirMonitoringSystem.ServerRef[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static AirMonitoringSystem.ServerRef[] extract (final org.omg.CORBA.Any any)
	{
		if ( any.type().kind() == org.omg.CORBA.TCKind.tk_null)
		{
			throw new org.omg.CORBA.BAD_OPERATION ("Can't extract from Any with null type.");
		}
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(List_of_serversHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_alias_tc(AirMonitoringSystem.List_of_serversHelper.id(), "List_of_servers",org.omg.CORBA.ORB.init().create_sequence_tc(0, org.omg.CORBA.ORB.init().create_struct_tc(AirMonitoringSystem.ServerRefHelper.id(),"ServerRef",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("name", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("location", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("ior", org.omg.CORBA.ORB.init().create_string_tc(0), null)})));
				}
			}
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:AirMonitoringSystem/List_of_servers:1.0";
	}
	public static AirMonitoringSystem.ServerRef[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		AirMonitoringSystem.ServerRef[] _result;
		int _l_result2 = _in.read_long();
		try
		{
			 int x = _in.available();
			 if ( x > 0 && _l_result2 > x )
				{
					throw new org.omg.CORBA.MARSHAL("Sequence length too large. Only " + x + " available and trying to assign " + _l_result2);
				}
		}
		catch (java.io.IOException e)
		{
		}
		_result = new AirMonitoringSystem.ServerRef[_l_result2];
		for (int i=0;i<_result.length;i++)
		{
			_result[i]=AirMonitoringSystem.ServerRefHelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, AirMonitoringSystem.ServerRef[] _s)
	{
		
		_out.write_long(_s.length);
		for (int i=0; i<_s.length;i++)
		{
			AirMonitoringSystem.ServerRefHelper.write(_out,_s[i]);
		}

	}
}
