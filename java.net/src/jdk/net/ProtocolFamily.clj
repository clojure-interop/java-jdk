(ns jdk.net.ProtocolFamily
  "Represents a family of communication protocols."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net ProtocolFamily]))

(defn name
  "Returns the name of the protocol family.

  returns: the name of the protocol family - `java.lang.String`"
  ([^java.net.ProtocolFamily this]
    (-> this (.name))))

