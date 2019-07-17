(ns jdk.net.UnknownHostException
  "Thrown to indicate that the IP address of a host could not be determined."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net UnknownHostException]))

(defn ->unknown-host-exception
  "Constructor.

  Constructs a new UnknownHostException with the
   specified detail message.

  host - the detail message. - `java.lang.String`"
  ([^java.lang.String host]
    (new UnknownHostException host))
  ([]
    (new UnknownHostException )))

