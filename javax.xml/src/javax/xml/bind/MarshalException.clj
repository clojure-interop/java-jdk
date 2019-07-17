(ns javax.xml.bind.MarshalException
  "This exception indicates that an error has occurred while performing
  a marshal operation that the provider is unable to recover from.


  The ValidationEventHandler can cause this exception to be thrown
  during the marshal operations.  See
  ValidationEventHandler.handleEvent(ValidationEvent)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind MarshalException]))

(defn ->marshal-exception
  "Constructor.

  Construct a MarshalException with the specified detail message, vendor
   specific errorCode, and linkedException.

  message - a description of the exception - `java.lang.String`
  error-code - a string specifying the vendor specific error code - `java.lang.String`
  exception - the linked exception - `java.lang.Throwable`"
  ([message error-code exception]
    (new MarshalException message error-code exception))
  ([message error-code]
    (new MarshalException message error-code))
  ([message]
    (new MarshalException message)))

