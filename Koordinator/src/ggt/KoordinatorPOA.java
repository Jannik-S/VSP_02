package ggt;


/**
* ggt/KoordinatorPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Aufgabe2.idl
* Donnerstag, 24. April 2014 16:14 Uhr MESZ
*/

public abstract class KoordinatorPOA extends org.omg.PortableServer.Servant
 implements ggt.KoordinatorOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("registerProcess", new java.lang.Integer (0));
    _methods.put ("terminationComplete", new java.lang.Integer (1));
    _methods.put ("activateStarter", new java.lang.Integer (2));
    _methods.put ("deleteStarter", new java.lang.Integer (3));
    _methods.put ("registerMonitor", new java.lang.Integer (4));
    _methods.put ("deleteMonitor", new java.lang.Integer (5));
    _methods.put ("startCalculation", new java.lang.Integer (6));
    _methods.put ("getStarterListe", new java.lang.Integer (7));
    _methods.put ("exit", new java.lang.Integer (8));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {

  // Methods for the Process
       case 0:  // ggt/Koordinator/registerProcess
       {
         try {
           ggt.Process process = ggt.ProcessHelper.read (in);
           this.registerProcess (process);
           out = $rh.createReply();
         } catch (ggt.KoordinatorPackage.exAlreadyExists $ex) {
           out = $rh.createExceptionReply ();
           ggt.KoordinatorPackage.exAlreadyExistsHelper.write (out, $ex);
         }
         break;
       }

       case 1:  // ggt/Koordinator/terminationComplete
       {
         ggt.Process terminator = ggt.ProcessHelper.read (in);
         int seqN = in.read_long ();
         boolean status = in.read_boolean ();
         boolean $result = false;
         $result = this.terminationComplete (terminator, seqN, status);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }


  // Methods for the Starter
       case 2:  // ggt/Koordinator/activateStarter
       {
         try {
           ggt.Starter starter = ggt.StarterHelper.read (in);
           String starterName = in.read_string ();
           this.activateStarter (starter, starterName);
           out = $rh.createReply();
         } catch (ggt.KoordinatorPackage.exAlreadyExists $ex) {
           out = $rh.createExceptionReply ();
           ggt.KoordinatorPackage.exAlreadyExistsHelper.write (out, $ex);
         }
         break;
       }

       case 3:  // ggt/Koordinator/deleteStarter
       {
         ggt.Starter starter = ggt.StarterHelper.read (in);
         this.deleteStarter (starter);
         out = $rh.createReply();
         break;
       }


  // Methods for the Monitor
       case 4:  // ggt/Koordinator/registerMonitor
       {
         monitor.Monitor monitor = ggt.MonitorHelper.read (in);
         this.registerMonitor (monitor);
         out = $rh.createReply();
         break;
       }

       case 5:  // ggt/Koordinator/deleteMonitor
       {
         this.deleteMonitor ();
         out = $rh.createReply();
         break;
       }


  // Methods for the Client
       case 6:  // ggt/Koordinator/startCalculation
       {
         int minProcesses = in.read_long ();
         int maxProcesses = in.read_long ();
         int minDelay = in.read_long ();
         int maxDelay = in.read_long ();
         int timeout = in.read_long ();
         int ggt = in.read_long ();
         this.startCalculation (minProcesses, maxProcesses, minDelay, maxDelay, timeout, ggt);
         out = $rh.createReply();
         break;
       }

       case 7:  // ggt/Koordinator/getStarterListe
       {
         ggt.Starter $result[] = null;
         $result = this.getStarterListe ();
         out = $rh.createReply();
         ggt.StarterListHelper.write (out, $result);
         break;
       }

       case 8:  // ggt/Koordinator/exit
       {
         this.exit ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:ggt/Koordinator:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Koordinator _this() 
  {
    return KoordinatorHelper.narrow(
    super._this_object());
  }

  public Koordinator _this(org.omg.CORBA.ORB orb) 
  {
    return KoordinatorHelper.narrow(
    super._this_object(orb));
  }


} // class KoordinatorPOA
