(ns jdk.net.DatagramSocketImplFactory
  "This interface defines a factory for datagram socket implementations. It
  is used by the classes DatagramSocket to create actual socket
  implementations."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net DatagramSocketImplFactory]))

(defn create-datagram-socket-impl
  "Creates a new DatagramSocketImpl instance.

  returns: a new instance of DatagramSocketImpl. - `java.net.DatagramSocketImpl`"
  ([^. this]
    (-> this (.createDatagramSocketImpl))))

