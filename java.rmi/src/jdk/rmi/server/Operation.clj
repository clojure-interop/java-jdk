(ns jdk.rmi.server.Operation
  "Deprecated.
 no replacement"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.server Operation]))

(defn ->operation
  "Constructor.

  Deprecated. no replacement

  op - method name - `java.lang.String`"
  (^Operation [^java.lang.String op]
    (new Operation op)))

(defn get-operation
  "Deprecated. no replacement

  returns: method name - `java.lang.String`"
  (^java.lang.String [^Operation this]
    (-> this (.getOperation))))

(defn to-string
  "Deprecated. no replacement

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^Operation this]
    (-> this (.toString))))

