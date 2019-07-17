(ns jdk.net.SocketAddress
  "This class represents a Socket Address with no protocol attachment.
  As an abstract class, it is meant to be subclassed with a specific,
  protocol dependent, implementation.

  It provides an immutable object used by sockets for binding, connecting, or
  as returned values."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net SocketAddress]))

(defn ->socket-address
  "Constructor."
  ([]
    (new SocketAddress )))

