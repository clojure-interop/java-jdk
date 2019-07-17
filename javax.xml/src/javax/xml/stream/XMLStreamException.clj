(ns javax.xml.stream.XMLStreamException
  "The base exception for unexpected processing errors.  This Exception
  class is used to report well-formedness errors as well as unexpected
  processing conditions."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream XMLStreamException]))

(defn ->xml-stream-exception
  "Constructor.

  Construct an exception with the assocated message, exception and location.

  msg - the message to report - `java.lang.String`
  location - the location of the error - `javax.xml.stream.Location`
  th - a nested exception - `java.lang.Throwable`"
  ([^java.lang.String msg ^javax.xml.stream.Location location ^java.lang.Throwable th]
    (new XMLStreamException msg location th))
  ([^java.lang.String msg ^java.lang.Throwable th]
    (new XMLStreamException msg th))
  ([^java.lang.String msg]
    (new XMLStreamException msg))
  ([]
    (new XMLStreamException )))

(defn get-nested-exception
  "Gets the nested exception.

  returns: Nested exception - `java.lang.Throwable`"
  ([^javax.xml.stream.XMLStreamException this]
    (-> this (.getNestedException))))

(defn get-location
  "Gets the location of the exception

  returns: the location of the exception, may be null if none is available - `javax.xml.stream.Location`"
  ([^javax.xml.stream.XMLStreamException this]
    (-> this (.getLocation))))

