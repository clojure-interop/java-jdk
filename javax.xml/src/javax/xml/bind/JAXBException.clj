(ns javax.xml.bind.JAXBException
  "This is the root exception class for all JAXB exceptions."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind JAXBException]))

(defn ->jaxb-exception
  "Constructor.

  Construct a JAXBException with the specified detail message, vendor
   specific errorCode, and linkedException.

  message - a description of the exception - `java.lang.String`
  error-code - a string specifying the vendor specific error code - `java.lang.String`
  exception - the linked exception - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.String error-code ^java.lang.Throwable exception]
    (new JAXBException message error-code exception))
  ([^java.lang.String message ^java.lang.String error-code]
    (new JAXBException message error-code))
  ([^java.lang.String message]
    (new JAXBException message)))

(defn get-error-code
  "Get the vendor specific error code

  returns: a string specifying the vendor specific error code - `java.lang.String`"
  (^java.lang.String [^javax.xml.bind.JAXBException this]
    (-> this (.getErrorCode))))

(defn get-linked-exception
  "Get the linked exception

  returns: the linked Exception, null if none exists - `java.lang.Throwable`"
  (^java.lang.Throwable [^javax.xml.bind.JAXBException this]
    (-> this (.getLinkedException))))

(defn set-linked-exception
  "Add a linked Exception.

  exception - the linked Exception (A null value is permitted and indicates that the linked exception does not exist or is unknown). - `java.lang.Throwable`"
  ([^javax.xml.bind.JAXBException this ^java.lang.Throwable exception]
    (-> this (.setLinkedException exception))))

(defn to-string
  "Returns a short description of this JAXBException.

  returns: a string representation of this throwable. - `java.lang.String`"
  (^java.lang.String [^javax.xml.bind.JAXBException this]
    (-> this (.toString))))

(defn print-stack-trace
  "Prints this JAXBException and its stack trace (including the stack trace
   of the linkedException if it is non-null) to the PrintStream.

  s - PrintStream to use for output - `java.io.PrintStream`"
  ([^javax.xml.bind.JAXBException this ^java.io.PrintStream s]
    (-> this (.printStackTrace s)))
  ([^javax.xml.bind.JAXBException this]
    (-> this (.printStackTrace))))

(defn get-cause
  "Description copied from class: Throwable

  returns: the cause of this throwable or null if the
            cause is nonexistent or unknown. - `java.lang.Throwable`"
  (^java.lang.Throwable [^javax.xml.bind.JAXBException this]
    (-> this (.getCause))))

