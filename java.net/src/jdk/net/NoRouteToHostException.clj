(ns jdk.net.NoRouteToHostException
  "Signals that an error occurred while attempting to connect a
  socket to a remote address and port.  Typically, the remote
  host cannot be reached because of an intervening firewall, or
  if an intermediate router is down."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net NoRouteToHostException]))

(defn ->no-route-to-host-exception
  "Constructor.

  Constructs a new NoRouteToHostException with the specified detail
   message as to why the remote host cannot be reached.
   A detail message is a String that gives a specific
   description of this error.

  msg - the detail message - `java.lang.String`"
  (^NoRouteToHostException [^java.lang.String msg]
    (new NoRouteToHostException msg))
  (^NoRouteToHostException []
    (new NoRouteToHostException )))

