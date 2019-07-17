(ns javax.xml.bind.PropertyException
  "This exception indicates that an error was encountered while getting or
  setting a property."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind PropertyException]))

(defn ->property-exception
  "Constructor.

  Construct a PropertyException with the specified detail message, vendor
   specific errorCode, and linkedException.

  message - a description of the exception - `java.lang.String`
  error-code - a string specifying the vendor specific error code - `java.lang.String`
  exception - the linked exception - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.String error-code ^java.lang.Throwable exception]
    (new PropertyException message error-code exception))
  ([^java.lang.String message ^java.lang.String error-code]
    (new PropertyException message error-code))
  ([^java.lang.String message]
    (new PropertyException message)))

