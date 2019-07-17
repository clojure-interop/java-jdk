(ns jdk.net.SocketImplFactory
  "This interface defines a factory for socket implementations. It
  is used by the classes Socket and
  ServerSocket to create actual socket
  implementations."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net SocketImplFactory]))

(defn create-socket-impl
  "Creates a new SocketImpl instance.

  returns: a new instance of SocketImpl. - `java.net.SocketImpl`"
  (^java.net.SocketImpl [^java.net.SocketImplFactory this]
    (-> this (.createSocketImpl))))

