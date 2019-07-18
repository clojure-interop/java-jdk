(ns jdk.net.SocketImpl
  "The abstract class SocketImpl is a common superclass
  of all classes that actually implement sockets. It is used to
  create both client and server sockets.

  A `plain` socket implements these methods exactly as
  described, without attempting to go through a firewall or proxy."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net SocketImpl]))

(defn ->socket-impl
  "Constructor."
  (^SocketImpl []
    (new SocketImpl )))

(defn to-string
  "Returns the address and port of this socket as a String.

  returns: a string representation of this socket. - `java.lang.String`"
  (^java.lang.String [^SocketImpl this]
    (-> this (.toString))))

