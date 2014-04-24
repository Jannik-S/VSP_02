package monitor;


/**
* monitor/MonitorPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Aufgabe2.idl
* Donnerstag, 24. April 2014 13:47 Uhr MESZ
*/

public abstract class MonitorPOA extends org.omg.PortableServer.Servant
 implements monitor.MonitorOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("ring", new java.lang.Integer (0));
    _methods.put ("startzahlen", new java.lang.Integer (1));
    _methods.put ("rechnen", new java.lang.Integer (2));
    _methods.put ("terminieren", new java.lang.Integer (3));
    _methods.put ("ergebnis", new java.lang.Integer (4));
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

  /*
       * Bekanntgabe der Ringzusammensetzung. 
       * Ring wird als String-Array uebergeben.
       * In dem Array sind die IDs der beteiligten Prozesse anzugeben.
       * Die Ids sollen sich zusammensetzen aus dem Namen des Starters 
       * und einer vom Starter vergebenen fortlaufenden Nummer.
       */
       case 0:  // monitor/Monitor/ring
       {
         String prozessIds[] = monitor.ProzessIdsHelper.read (in);
         this.ring (prozessIds);
         out = $rh.createReply();
         break;
       }


  /*
       * Bekanntgabe der Startzahlen der beteiligten Prozesse.
       * Zahlen werden in einem Integer-Array uebergeben.
       * Laenge des Startzahlen-Arrays muss mit der Laenge des Prozessids-Arrays uebereinstimmen.
       */
       case 1:  // monitor/Monitor/startzahlen
       {
         int startzahlen[] = monitor.StartzahlenHelper.read (in);
         this.startzahlen (startzahlen);
         out = $rh.createReply();
         break;
       }


  /*
       * Mitteilung an den Monitor, dass von einem Prozess eine neue Zahl empfangen wurde.
       * Mitteilung soll auch gesendet werden, wenn die Zahl vom Prozess nicht bearbeitet wurde, 
       * weil sie zu gross war.
       * Parameter enthalten die Angaben, welcher Prozess die Zahl empfangen hat, von welchem
       * Prozess sie gesendet wurde und welche Zahl uebertragen wurde.
       */
       case 2:  // monitor/Monitor/rechnen
       {
         String prozessId = in.read_string ();
         String prozessIdAbsender = in.read_string ();
         int num = in.read_long ();
         this.rechnen (prozessId, prozessIdAbsender, num);
         out = $rh.createReply();
         break;
       }


  /*
       * Mitteilung an den Monitor, dass von einem Prozess eine Terminierungsanfrage empfangen wurde.
       * Parameter enthalten die Angaben, welcher Prozess die Anfrage empfangen hat, von wem sie
       * urspruenglich gesendet wurde und ob terminiert werden soll.
       */
       case 3:  // monitor/Monitor/terminieren
       {
         String prozessId = in.read_string ();
         String prozessIdAbsender = in.read_string ();
         boolean terminiere = in.read_boolean ();
         this.terminieren (prozessId, prozessIdAbsender, terminiere);
         out = $rh.createReply();
         break;
       }


  /*
       * Mit diesem Aufruf soll der Koordinator das Ergebnis seiner Berechnung an den
       * Monitor uebergeben.
       */
       case 4:  // monitor/Monitor/ergebnis
       {
         String prozessId = in.read_string ();
         int num = in.read_long ();
         this.ergebnis (prozessId, num);
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
    "IDL:monitor/Monitor:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Monitor _this() 
  {
    return MonitorHelper.narrow(
    super._this_object());
  }

  public Monitor _this(org.omg.CORBA.ORB orb) 
  {
    return MonitorHelper.narrow(
    super._this_object(orb));
  }


} // class MonitorPOA
