(ns jdk.net.PortUnreachableException
  "Signals that an ICMP Port Unreachable message has been
  received on a connected datagram."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net PortUnreachableException]))

(defn ->port-unreachable-exception
  "Constructor.

  Constructs a new PortUnreachableException with a
   detail message.

  msg - the detail message - `java.lang.String`"
  (^PortUnreachableException [^java.lang.String msg]
    (new PortUnreachableException msg))
  (^PortUnreachableException []
    (new PortUnreachableException )))

