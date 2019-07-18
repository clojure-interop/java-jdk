(ns javax.xml.soap.SOAPHeader
  "A representation of the SOAP header
  element. A SOAP header element consists of XML data that affects
  the way the application-specific content is processed by the message
  provider. For example, transaction semantics, authentication information,
  and so on, can be specified as the content of a SOAPHeader
  object.

  A SOAPEnvelope object contains an empty
  SOAPHeader object by default. If the SOAPHeader
  object, which is optional, is not needed, it can be retrieved and deleted
  with the following line of code. The variable se is a
  SOAPEnvelope object.


       se.getHeader().detachNode();

  A SOAPHeader object is created with the SOAPEnvelope
  method addHeader. This method, which creates a new header and adds it
  to the envelope, may be called only after the existing header has been removed.



       se.getHeader().detachNode();
       SOAPHeader sh = se.addHeader();

  A SOAPHeader object can have only SOAPHeaderElement
  objects as its immediate children. The method addHeaderElement
  creates a new HeaderElement object and adds it to the
  SOAPHeader object. In the following line of code, the
  argument to the method addHeaderElement is a Name
  object that is the name for the new HeaderElement object.


       SOAPHeaderElement shElement = sh.addHeaderElement(name);"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.soap SOAPHeader]))

(defn add-header-element
  "Creates a new SOAPHeaderElement object initialized with the
   specified name and adds it to this SOAPHeader object.

  name - a Name object with the name of the new SOAPHeaderElement object - `javax.xml.soap.Name`

  returns: the new SOAPHeaderElement object that was
            inserted into this SOAPHeader object - `javax.xml.soap.SOAPHeaderElement`

  throws: javax.xml.soap.SOAPException - if a SOAP error occurs"
  (^javax.xml.soap.SOAPHeaderElement [^SOAPHeader this ^javax.xml.soap.Name name]
    (-> this (.addHeaderElement name))))

(defn examine-must-understand-header-elements
  "Returns an Iterator over all the SOAPHeaderElement objects
   in this SOAPHeader object
   that have the specified actor and that have a MustUnderstand attribute
   whose value is equivalent to true.

   In SOAP 1.2 the env:actor attribute is replaced by the env:role
   attribute, but with essentially the same semantics.

  actor - a String giving the URI of the actor / role for which to search - `java.lang.String`

  returns: an Iterator object over all the
           SOAPHeaderElement objects that contain the specified
            actor / role and are marked as MustUnderstand - `java.util.Iterator`"
  (^java.util.Iterator [^SOAPHeader this ^java.lang.String actor]
    (-> this (.examineMustUnderstandHeaderElements actor))))

(defn examine-header-elements
  "Returns an Iterator over all the SOAPHeaderElement objects
   in this SOAPHeader object
   that have the specified actor.

   An actor is a global attribute that indicates the intermediate
   parties that should process a message before it reaches its ultimate
   receiver. An actor receives the message and processes it before sending
   it on to the next actor. The default actor is the ultimate intended
   recipient for the message, so if no actor attribute is included in a
   SOAPHeader object, it is sent to the ultimate receiver
   along with the message body.

   In SOAP 1.2 the env:actor attribute is replaced by the env:role
   attribute, but with essentially the same semantics.

  actor - a String giving the URI of the actor / role for which to search - `java.lang.String`

  returns: an Iterator object over all the
           SOAPHeaderElement objects that contain the specified
            actor / role - `java.util.Iterator`"
  (^java.util.Iterator [^SOAPHeader this ^java.lang.String actor]
    (-> this (.examineHeaderElements actor))))

(defn extract-header-elements
  "Returns an Iterator over all the SOAPHeaderElement objects
   in this SOAPHeader object
   that have the specified actor and detaches them
   from this SOAPHeader object.

   This method allows an actor to process the parts of the
   SOAPHeader object that apply to it and to remove
   them before passing the message on to the next actor.

   In SOAP 1.2 the env:actor attribute is replaced by the env:role
   attribute, but with essentially the same semantics.

  actor - a String giving the URI of the actor / role for which to search - `java.lang.String`

  returns: an Iterator object over all the
           SOAPHeaderElement objects that contain the specified
            actor / role - `java.util.Iterator`"
  (^java.util.Iterator [^SOAPHeader this ^java.lang.String actor]
    (-> this (.extractHeaderElements actor))))

(defn add-not-understood-header-element
  "Creates a new NotUnderstood SOAPHeaderElement object initialized
   with the specified name and adds it to this SOAPHeader object.
   This operation is supported only by SOAP 1.2.

  name - a QName object with the name of the SOAPHeaderElement object that was not understood. - `javax.xml.namespace.QName`

  returns: the new SOAPHeaderElement object that was
            inserted into this SOAPHeader object - `javax.xml.soap.SOAPHeaderElement`

  throws: javax.xml.soap.SOAPException - if a SOAP error occurs."
  (^javax.xml.soap.SOAPHeaderElement [^SOAPHeader this ^javax.xml.namespace.QName name]
    (-> this (.addNotUnderstoodHeaderElement name))))

(defn add-upgrade-header-element
  "Creates a new Upgrade SOAPHeaderElement object initialized
   with the specified List of supported SOAP URIs and adds it to this
   SOAPHeader object.
   This operation is supported on both SOAP 1.1 and SOAP 1.2 header.

  supported-soapur-is - an Iterator object with the URIs of SOAP versions supported. - `java.util.Iterator`

  returns: the new SOAPHeaderElement object that was
            inserted into this SOAPHeader object - `javax.xml.soap.SOAPHeaderElement`

  throws: javax.xml.soap.SOAPException - if a SOAP error occurs."
  (^javax.xml.soap.SOAPHeaderElement [^SOAPHeader this ^java.util.Iterator supported-soapur-is]
    (-> this (.addUpgradeHeaderElement supported-soapur-is))))

(defn examine-all-header-elements
  "Returns an Iterator over all the SOAPHeaderElement objects
   in this SOAPHeader object.

  returns: an Iterator object over all the
            SOAPHeaderElement objects contained by this
            SOAPHeader - `java.util.Iterator`"
  (^java.util.Iterator [^SOAPHeader this]
    (-> this (.examineAllHeaderElements))))

(defn extract-all-header-elements
  "Returns an Iterator over all the SOAPHeaderElement objects
   in this SOAPHeader object and detaches them
   from this SOAPHeader object.

  returns: an Iterator object over all the
            SOAPHeaderElement objects contained by this
            SOAPHeader - `java.util.Iterator`"
  (^java.util.Iterator [^SOAPHeader this]
    (-> this (.extractAllHeaderElements))))

