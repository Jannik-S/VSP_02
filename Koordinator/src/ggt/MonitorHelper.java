package ggt;


/**
* ggt/MonitorHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Aufgabe2.idl
* Donnerstag, 24. April 2014 13:47 Uhr MESZ
*/

abstract public class MonitorHelper
{
  private static String  _id = "IDL:ggt/Monitor:1.0";

  public static void insert (org.omg.CORBA.Any a, monitor.Monitor that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static monitor.Monitor extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = monitor.MonitorHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (ggt.MonitorHelper.id (), "Monitor", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static monitor.Monitor read (org.omg.CORBA.portable.InputStream istream)
  {
    monitor.Monitor value = null;
    value = monitor.MonitorHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, monitor.Monitor value)
  {
    monitor.MonitorHelper.write (ostream, value);
  }

}
