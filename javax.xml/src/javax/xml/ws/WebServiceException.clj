(ns javax.xml.ws.WebServiceException
  "The WebServiceException class is the base
   exception class for all JAX-WS API runtime exceptions."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws WebServiceException]))

(defn ->web-service-exception
  "Constructor.

  Constructs a new exception with the specified detail
    message and cause.

  message - The detail message which is later retrieved using the getMessage method - `java.lang.String`
  cause - The cause which is saved for the later retrieval throw by the getCause method - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.Throwable cause]
    (new WebServiceException message cause))
  ([^java.lang.String message]
    (new WebServiceException message))
  ([]
    (new WebServiceException )))

