(ns javax.xml.bind.ValidationException
  "This exception indicates that an error has occurred while performing
  a validate operation.


  The ValidationEventHandler can cause this exception to be thrown
  during the validate operations.  See
  ValidationEventHandler.handleEvent(ValidationEvent)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind ValidationException]))

(defn ->validation-exception
  "Constructor.

  Construct an ValidationException with the specified detail message, vendor
   specific errorCode, and linkedException.

  message - a description of the exception - `java.lang.String`
  error-code - a string specifying the vendor specific error code - `java.lang.String`
  exception - the linked exception - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.String error-code ^java.lang.Throwable exception]
    (new ValidationException message error-code exception))
  ([^java.lang.String message ^java.lang.String error-code]
    (new ValidationException message error-code))
  ([^java.lang.String message]
    (new ValidationException message)))

