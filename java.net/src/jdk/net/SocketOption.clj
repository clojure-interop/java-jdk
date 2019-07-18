(ns jdk.net.SocketOption
  "A socket option associated with a socket.

   In the channels package, the NetworkChannel interface defines the setOption
  and getOption
  methods to set and query the channel's socket options."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net SocketOption]))

(defn name
  "Returns the name of the socket option.

  returns: the name of the socket option - `java.lang.String`"
  (^java.lang.String [^SocketOption this]
    (-> this (.name))))

(defn type
  "Returns the type of the socket option value.

  returns: the type of the socket option value - `java.lang.Class<T>`"
  (^java.lang.Class [^SocketOption this]
    (-> this (.type))))

