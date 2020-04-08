package AirMonitoringSystem;


/**
 * Generated from IDL interface "MonitoringCentre".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 7 Apr 2020, 15:57:47
 */

public class _MonitoringCentreStub
	extends org.omg.CORBA.portable.ObjectImpl
	implements AirMonitoringSystem.MonitoringCentre
{
	/** Serial version UID. */
	private static final long serialVersionUID = 1L;
	private String[] ids = {"IDL:AirMonitoringSystem/MonitoringCentre:1.0"};
	public String[] _ids()
	{
		return ids;
	}

	public final static java.lang.Class _opsClass = AirMonitoringSystem.MonitoringCentreOperations.class;
	public void raise_alarm(AirMonitoringSystem.NoxReading alarm_reading)
	{
		while(true)
		{
			if(! this._is_local())
			{
				org.omg.CORBA.portable.InputStream _is = null;
				org.omg.CORBA.portable.OutputStream _os = null;
				try
				{
					_os = _request( "raise_alarm", true);
					AirMonitoringSystem.NoxReadingHelper.write(_os,alarm_reading);
					_is = _invoke(_os);
					return;
				}
				catch( org.omg.CORBA.portable.RemarshalException _rx )
					{
						continue;
					}
				catch( org.omg.CORBA.portable.ApplicationException _ax )
				{
					String _id = _ax.getId();
					try
					{
							_ax.getInputStream().close();
					}
					catch (java.io.IOException e)
					{
						throw new RuntimeException("Unexpected exception " + e.toString() );
					}
					throw new RuntimeException("Unexpected exception " + _id );
			}
			finally
			{
				if (_os != null)
				{
					try
					{
						_os.close();
					}
					catch (java.io.IOException e)
					{
						throw new RuntimeException("Unexpected exception " + e.toString() );
					}
				}
				this._releaseReply(_is);
			}
		}
		else
		{
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "raise_alarm", _opsClass );
			if( _so == null )
				continue;
			MonitoringCentreOperations _localServant = (MonitoringCentreOperations)_so.servant;
			try
			{
				_localServant.raise_alarm(alarm_reading);
				if ( _so instanceof org.omg.CORBA.portable.ServantObjectExt) 
					((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
				return;
			}
			catch (RuntimeException re) 
			{
				if ( _so instanceof org.omg.CORBA.portable.ServantObjectExt) 
					((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion(re);
				throw re;
			}
			catch (java.lang.Error err) 
			{
				if ( _so instanceof org.omg.CORBA.portable.ServantObjectExt) 
					((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion(err);
				throw err;
			}
			finally
			{
				_servant_postinvoke(_so);
			}
		}

		}

	}

	public void register_regional_centre(java.lang.String name, java.lang.String location, java.lang.String centre_ior)
	{
		while(true)
		{
			if(! this._is_local())
			{
				org.omg.CORBA.portable.InputStream _is = null;
				org.omg.CORBA.portable.OutputStream _os = null;
				try
				{
					_os = _request( "register_regional_centre", true);
					java.lang.String tmpResult11 = name;
_os.write_string( tmpResult11 );
					java.lang.String tmpResult12 = location;
_os.write_string( tmpResult12 );
					java.lang.String tmpResult13 = centre_ior;
_os.write_string( tmpResult13 );
					_is = _invoke(_os);
					return;
				}
				catch( org.omg.CORBA.portable.RemarshalException _rx )
					{
						continue;
					}
				catch( org.omg.CORBA.portable.ApplicationException _ax )
				{
					String _id = _ax.getId();
					try
					{
							_ax.getInputStream().close();
					}
					catch (java.io.IOException e)
					{
						throw new RuntimeException("Unexpected exception " + e.toString() );
					}
					throw new RuntimeException("Unexpected exception " + _id );
			}
			finally
			{
				if (_os != null)
				{
					try
					{
						_os.close();
					}
					catch (java.io.IOException e)
					{
						throw new RuntimeException("Unexpected exception " + e.toString() );
					}
				}
				this._releaseReply(_is);
			}
		}
		else
		{
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "register_regional_centre", _opsClass );
			if( _so == null )
				continue;
			MonitoringCentreOperations _localServant = (MonitoringCentreOperations)_so.servant;
			try
			{
				_localServant.register_regional_centre(name,location,centre_ior);
				if ( _so instanceof org.omg.CORBA.portable.ServantObjectExt) 
					((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
				return;
			}
			catch (RuntimeException re) 
			{
				if ( _so instanceof org.omg.CORBA.portable.ServantObjectExt) 
					((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion(re);
				throw re;
			}
			catch (java.lang.Error err) 
			{
				if ( _so instanceof org.omg.CORBA.portable.ServantObjectExt) 
					((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion(err);
				throw err;
			}
			finally
			{
				_servant_postinvoke(_so);
			}
		}

		}

	}

	public AirMonitoringSystem.ServerRef[] List_of_centres()
	{
		while(true)
		{
			if(! this._is_local())
			{
				org.omg.CORBA.portable.InputStream _is = null;
				org.omg.CORBA.portable.OutputStream _os = null;
				try
				{
					_os = _request("_get_List_of_centres",true);
					_is = _invoke(_os);
					return AirMonitoringSystem.List_of_serversHelper.read(_is);
				}
				catch( org.omg.CORBA.portable.RemarshalException _rx )
					{
						continue;
					}
				catch( org.omg.CORBA.portable.ApplicationException _ax )
				{
					String _id = _ax.getId();
					try
					{
						_ax.getInputStream().close();
					}
					catch (java.io.IOException e)
					{
						throw new RuntimeException("Unexpected exception " + e.toString() );
					}
						throw new RuntimeException("Unexpected exception " + _id );
				}
				finally
				{
					if (_os != null)
					{
						try
						{
							_os.close();
						}
						catch (java.io.IOException e)
						{
							throw new RuntimeException("Unexpected exception " + e.toString() );
						}
					}
					this._releaseReply(_is);
				}
			}

			else
			{
				org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "_get_List_of_centres", _opsClass);
				if( _so == null )
					continue;
				MonitoringCentreOperations _localServant = (MonitoringCentreOperations)_so.servant;
				AirMonitoringSystem.ServerRef[] _result;
				try
				{
					_result = _localServant.List_of_centres();
					if ( _so instanceof org.omg.CORBA.portable.ServantObjectExt) 
						((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
						return _result;
				}
				catch (RuntimeException re) 
				{
					if ( _so instanceof org.omg.CORBA.portable.ServantObjectExt) 
						((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion(re);
					throw re;
				}
				catch (java.lang.Error err) 
				{
					if ( _so instanceof org.omg.CORBA.portable.ServantObjectExt) 
						((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion(err);
					throw err;
				}
				finally
				{
					_servant_postinvoke(_so);
				}
			}

		}

	}

	public void register_agency(java.lang.String name, java.lang.String contact_details, java.lang.String area_of_interest)
	{
		while(true)
		{
			if(! this._is_local())
			{
				org.omg.CORBA.portable.InputStream _is = null;
				org.omg.CORBA.portable.OutputStream _os = null;
				try
				{
					_os = _request( "register_agency", true);
					java.lang.String tmpResult14 = name;
_os.write_string( tmpResult14 );
					java.lang.String tmpResult15 = contact_details;
_os.write_string( tmpResult15 );
					java.lang.String tmpResult16 = area_of_interest;
_os.write_string( tmpResult16 );
					_is = _invoke(_os);
					return;
				}
				catch( org.omg.CORBA.portable.RemarshalException _rx )
					{
						continue;
					}
				catch( org.omg.CORBA.portable.ApplicationException _ax )
				{
					String _id = _ax.getId();
					try
					{
							_ax.getInputStream().close();
					}
					catch (java.io.IOException e)
					{
						throw new RuntimeException("Unexpected exception " + e.toString() );
					}
					throw new RuntimeException("Unexpected exception " + _id );
			}
			finally
			{
				if (_os != null)
				{
					try
					{
						_os.close();
					}
					catch (java.io.IOException e)
					{
						throw new RuntimeException("Unexpected exception " + e.toString() );
					}
				}
				this._releaseReply(_is);
			}
		}
		else
		{
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "register_agency", _opsClass );
			if( _so == null )
				continue;
			MonitoringCentreOperations _localServant = (MonitoringCentreOperations)_so.servant;
			try
			{
				_localServant.register_agency(name,contact_details,area_of_interest);
				if ( _so instanceof org.omg.CORBA.portable.ServantObjectExt) 
					((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
				return;
			}
			catch (RuntimeException re) 
			{
				if ( _so instanceof org.omg.CORBA.portable.ServantObjectExt) 
					((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion(re);
				throw re;
			}
			catch (java.lang.Error err) 
			{
				if ( _so instanceof org.omg.CORBA.portable.ServantObjectExt) 
					((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion(err);
				throw err;
			}
			finally
			{
				_servant_postinvoke(_so);
			}
		}

		}

	}

}
