(ns jdk.net.UnknownServiceException
  "Thrown to indicate that an unknown service exception has
  occurred. Either the MIME type returned by a URL connection does
  not make sense, or the application is attempting to write to a
  read-only URL connection."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net UnknownServiceException]))

(defn ->unknown-service-exception
  "Constructor.

  Constructs a new UnknownServiceException with the
   specified detail message.

  msg - the detail message. - `java.lang.String`"
  ([msg]
    (new UnknownServiceException msg))
  ([]
    (new UnknownServiceException )))

