(ns jdk.net.DatagramSocketImpl
  "Abstract datagram and multicast socket implementation base class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net DatagramSocketImpl]))

(defn ->datagram-socket-impl
  "Constructor."
  (^DatagramSocketImpl []
    (new DatagramSocketImpl )))

