(ns javax.xml.soap.SOAPEnvelope
  "The container for the SOAPHeader and SOAPBody portions of a
  SOAPPart object. By default, a SOAPMessage
  object is created with a SOAPPart object that has a
  SOAPEnvelope object. The SOAPEnvelope object
  by default has an empty SOAPBody object and an empty
  SOAPHeader object.  The SOAPBody object is
  required, and the SOAPHeader object, though
  optional, is used in the majority of cases. If the
  SOAPHeader object is not needed, it can be deleted,
  which is shown later.

  A client can access the SOAPHeader and SOAPBody
  objects by calling the methods SOAPEnvelope.getHeader and
  SOAPEnvelope.getBody. The
  following  lines of code use these two methods after starting with
  the SOAPMessage
  object message to get the SOAPPart object sp,
  which is then used to get the SOAPEnvelope object se.



      SOAPPart sp = message.getSOAPPart();
      SOAPEnvelope se = sp.getEnvelope();
      SOAPHeader sh = se.getHeader();
      SOAPBody sb = se.getBody();

  It is possible to change the body or header of a SOAPEnvelope
  object by retrieving the current one, deleting it, and then adding
  a new body or header. The javax.xml.soap.Node method
  deleteNode deletes the XML element (node) on which it is
  called.  For example, the following line of code deletes the
  SOAPBody object that is retrieved by the method getBody.


       se.getBody().detachNode();
  To create a SOAPHeader object to replace the one that was removed,
  a client uses
  the method SOAPEnvelope.addHeader, which creates a new header and
  adds it to the SOAPEnvelope object. Similarly, the method
  addBody creates a new SOAPBody object and adds
  it to the SOAPEnvelope object. The following code fragment
  retrieves the current header, removes it, and adds a new one. Then
  it retrieves the current body, removes it, and adds a new one.



      SOAPPart sp = message.getSOAPPart();
      SOAPEnvelope se = sp.getEnvelope();
      se.getHeader().detachNode();
      SOAPHeader sh = se.addHeader();
      se.getBody().detachNode();
      SOAPBody sb = se.addBody();
  It is an error to add a SOAPBody or SOAPHeader
  object if one already exists.

  The SOAPEnvelope interface provides three methods for creating
  Name objects. One method creates Name objects with
  a local name, a namespace prefix, and a namesapce URI. The second method creates
  Name objects with a local name and a namespace prefix, and the third
  creates Name objects with just a local name.  The following line of
  code, in which se is a SOAPEnvelope object, creates a new
  Name object with all three.


      Name name = se.createName(`GetLastTradePrice`, `WOMBAT`,
                                 `http://www.wombat.org/trader`);"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.soap SOAPEnvelope]))

(defn create-name
  "Creates a new Name object initialized with the
   given local name, namespace prefix, and namespace URI.

   This factory method creates Name objects for use in
   the SOAP/XML document.

  local-name - a String giving the local name - `java.lang.String`
  prefix - a String giving the prefix of the namespace - `java.lang.String`
  uri - a String giving the URI of the namespace - `java.lang.String`

  returns: a Name object initialized with the given
           local name, namespace prefix, and namespace URI - `javax.xml.soap.Name`

  throws: javax.xml.soap.SOAPException - if there is a SOAP error"
  ([^javax.xml.soap.SOAPEnvelope this ^java.lang.String local-name ^java.lang.String prefix ^java.lang.String uri]
    (-> this (.createName local-name prefix uri)))
  ([^javax.xml.soap.SOAPEnvelope this ^java.lang.String local-name]
    (-> this (.createName local-name))))

(defn get-header
  "Returns the SOAPHeader object for
   this SOAPEnvelope object.

   A new SOAPMessage object is by default created with a
   SOAPEnvelope object that contains an empty
   SOAPHeader object.  As a result, the method
   getHeader will always return a SOAPHeader
   object unless the header has been removed and a new one has not
   been added.

  returns: the SOAPHeader object or null if
           there is none - `javax.xml.soap.SOAPHeader`

  throws: javax.xml.soap.SOAPException - if there is a problem obtaining the SOAPHeader object"
  ([^javax.xml.soap.SOAPEnvelope this]
    (-> this (.getHeader))))

(defn get-body
  "Returns the SOAPBody object associated with this
   SOAPEnvelope object.

   A new SOAPMessage object is by default created with a
   SOAPEnvelope object that contains an empty
   SOAPBody object.  As a result, the method
   getBody will always return a SOAPBody
   object unless the body has been removed and a new one has not
   been added.

  returns: the SOAPBody object for this
           SOAPEnvelope object or null
           if there is none - `javax.xml.soap.SOAPBody`

  throws: javax.xml.soap.SOAPException - if there is a problem obtaining the SOAPBody object"
  ([^javax.xml.soap.SOAPEnvelope this]
    (-> this (.getBody))))

(defn add-header
  "Creates a SOAPHeader object and sets it as the
   SOAPHeader object for this SOAPEnvelope
   object.

   It is illegal to add a header when the envelope already
   contains a header.  Therefore, this method should be called
   only after the existing header has been removed.

  returns: the new SOAPHeader object - `javax.xml.soap.SOAPHeader`

  throws: javax.xml.soap.SOAPException - if this SOAPEnvelope object already contains a valid SOAPHeader object"
  ([^javax.xml.soap.SOAPEnvelope this]
    (-> this (.addHeader))))

(defn add-body
  "Creates a SOAPBody object and sets it as the
   SOAPBody object for this SOAPEnvelope
   object.

   It is illegal to add a body when the envelope already
   contains a body. Therefore, this method should be called
   only after the existing body has been removed.

  returns: the new SOAPBody object - `javax.xml.soap.SOAPBody`

  throws: javax.xml.soap.SOAPException - if this SOAPEnvelope object already contains a valid SOAPBody object"
  ([^javax.xml.soap.SOAPEnvelope this]
    (-> this (.addBody))))

