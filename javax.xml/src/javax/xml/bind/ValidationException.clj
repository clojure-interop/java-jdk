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
  ([message error-code exception]
    (new ValidationException message error-code exception))
  ([message error-code]
    (new ValidationException message error-code))
  ([message]
    (new ValidationException message)))

