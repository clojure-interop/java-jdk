(ns javax.xml.bind.UnmarshalException
  "This exception indicates that an error has occurred while performing
  an unmarshal operation that prevents the JAXB Provider from completing
  the operation.


  The ValidationEventHandler can cause this exception to be thrown
  during the unmarshal operations.  See
  ValidationEventHandler.handleEvent(ValidationEvent)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind UnmarshalException]))

(defn ->unmarshal-exception
  "Constructor.

  Construct an UnmarshalException with the specified detail message, vendor
   specific errorCode, and linkedException.

  message - a description of the exception - `java.lang.String`
  error-code - a string specifying the vendor specific error code - `java.lang.String`
  exception - the linked exception - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.String error-code ^java.lang.Throwable exception]
    (new UnmarshalException message error-code exception))
  ([^java.lang.String message ^java.lang.String error-code]
    (new UnmarshalException message error-code))
  ([^java.lang.String message]
    (new UnmarshalException message)))

