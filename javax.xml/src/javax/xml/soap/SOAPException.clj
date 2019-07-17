(ns javax.xml.soap.SOAPException
  "An exception that signals that a SOAP exception has occurred. A
  SOAPException object may contain a String
  that gives the reason for the exception, an embedded
  Throwable object, or both. This class provides methods
  for retrieving reason messages and for retrieving the embedded
  Throwable object.

   Typical reasons for throwing a SOAPException
  object are problems such as difficulty setting a header, not being
  able to send a message, and not being able to get a connection with
  the provider.  Reasons for embedding a Throwable
  object include problems such as input/output errors or a parsing
  problem, such as an error in parsing a header."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.soap SOAPException]))

(defn ->soap-exception
  "Constructor.

  Constructs a SOAPException object with the given
   String as the reason for the exception being thrown
   and the given Throwable object as an embedded
   exception.

  reason - a description of what caused the exception - `java.lang.String`
  cause - a Throwable object that is to be embedded in this SOAPException object - `java.lang.Throwable`"
  ([reason cause]
    (new SOAPException reason cause))
  ([reason]
    (new SOAPException reason))
  ([]
    (new SOAPException )))

(defn get-message
  "Returns the detail message for this SOAPException
   object.

   If there is an embedded Throwable object, and if the
   SOAPException object has no detail message of its
   own, this method will return the detail message from the embedded
   Throwable object.

  returns: the error or warning message for this
           SOAPException or, if it has none, the
           message of the embedded Throwable object,
           if there is one - `java.lang.String`"
  ([this]
    (-> this (.getMessage))))

(defn get-cause
  "Returns the Throwable object embedded in this
   SOAPException if there is one. Otherwise, this method
   returns null.

  returns: the embedded Throwable object or null
           if there is none - `java.lang.Throwable`"
  ([this]
    (-> this (.getCause))))

(defn init-cause
  "Initializes the cause field of this SOAPException
   object with the given Throwable object.

   This method can be called at most once.  It is generally called from
   within the constructor or immediately after the constructor has
   returned a new SOAPException object.
   If this SOAPException object was created with the
   constructor SOAPException(Throwable) or
   SOAPException(String,Throwable), meaning that its
   cause field already has a value, this method cannot be
   called even once.

  cause - the Throwable object that caused this SOAPException object to be thrown. The value of this parameter is saved for later retrieval by the getCause() method. A null value is permitted and indicates that the cause is nonexistent or unknown. - `java.lang.Throwable`

  returns: a reference to this SOAPException instance - `java.lang.Throwable`

  throws: java.lang.IllegalArgumentException - if cause is this Throwable object. (A Throwable object cannot be its own cause.)"
  ([this cause]
    (-> this (.initCause cause))))

