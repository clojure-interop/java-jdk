(ns javax.xml.soap.SOAPHeaderElement
  "An object representing the contents in the SOAP header part of the
  SOAP envelope.
  The immediate children of a SOAPHeader object can
  be represented only as SOAPHeaderElement objects.

  A SOAPHeaderElement object can have other
  SOAPElement objects as its children."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.soap SOAPHeaderElement]))

(defn set-actor
  "Sets the actor associated with this SOAPHeaderElement
   object to the specified actor. The default value of an actor is:
            SOAPConstants.URI_SOAP_ACTOR_NEXT

   If this SOAPHeaderElement supports SOAP 1.2 then this call is
   equivalent to setRole(String)

  actor-uri - a String giving the URI of the actor to set - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if there is a problem in setting the actor."
  ([^SOAPHeaderElement this ^java.lang.String actor-uri]
    (-> this (.setActor actor-uri))))

(defn set-role
  "Sets the Role associated with this SOAPHeaderElement
   object to the specified Role.

  uri - - the URI of the Role - `java.lang.String`

  throws: javax.xml.soap.SOAPException - if there is an error in setting the role"
  ([^SOAPHeaderElement this ^java.lang.String uri]
    (-> this (.setRole uri))))

(defn get-actor
  "Returns the uri of the actor attribute of this
   SOAPHeaderElement.

   If this SOAPHeaderElement supports SOAP 1.2 then this call is
   equivalent to getRole()

  returns: a String giving the URI of the actor - `java.lang.String`"
  (^java.lang.String [^SOAPHeaderElement this]
    (-> this (.getActor))))

(defn get-role
  "Returns the value of the Role attribute of this
   SOAPHeaderElement.

  returns: a String giving the URI of the Role - `java.lang.String`

  throws: java.lang.UnsupportedOperationException - if this message does not support the SOAP 1.2 concept of Fault Role."
  (^java.lang.String [^SOAPHeaderElement this]
    (-> this (.getRole))))

(defn set-must-understand
  "Sets the mustUnderstand attribute for this SOAPHeaderElement
   object to be either true or false.

   If the mustUnderstand attribute is on, the actor who receives the
   SOAPHeaderElement must process it correctly. This
   ensures, for example, that if the SOAPHeaderElement
   object modifies the message, that the message is being modified correctly.

  must-understand - true to set the mustUnderstand attribute to true; false to set it to false - `boolean`

  throws: java.lang.IllegalArgumentException - if there is a problem in setting the mustUnderstand attribute"
  ([^SOAPHeaderElement this ^Boolean must-understand]
    (-> this (.setMustUnderstand must-understand))))

(defn get-must-understand?
  "Returns the boolean value of the mustUnderstand attribute for this
   SOAPHeaderElement.

  returns: true if the mustUnderstand attribute of this
          SOAPHeaderElement object is turned on; false
           otherwise - `boolean`"
  (^Boolean [^SOAPHeaderElement this]
    (-> this (.getMustUnderstand))))

(defn set-relay
  "Sets the relay attribute for this SOAPHeaderElement to be
   either true or false.

   The SOAP relay attribute is set to true to indicate that the SOAP header
   block must be relayed by any node that is targeted by the header block
   but not actually process it. This attribute is ignored on header blocks
   whose mustUnderstand attribute is set to true or that are targeted at
   the ultimate reciever (which is the default). The default value of this
   attribute is false.

  relay - the new value of the relay attribute - `boolean`

  throws: javax.xml.soap.SOAPException - if there is a problem in setting the relay attribute."
  ([^SOAPHeaderElement this ^Boolean relay]
    (-> this (.setRelay relay))))

(defn get-relay?
  "Returns the boolean value of the relay attribute for this
   SOAPHeaderElement

  returns: true if the relay attribute is turned on;
   false otherwise - `boolean`

  throws: java.lang.UnsupportedOperationException - if this message does not support the SOAP 1.2 concept of Relay attribute."
  (^Boolean [^SOAPHeaderElement this]
    (-> this (.getRelay))))

