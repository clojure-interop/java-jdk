(ns jdk.util.function.Supplier
  "Represents a supplier of results.

  There is no requirement that a new or distinct result be returned each
  time the supplier is invoked.

  This is a functional interface
  whose functional method is get()."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function Supplier]))

(defn get
  "Gets a result.

  returns: a result - `T`"
  ([^Supplier this]
    (-> this (.get))))

