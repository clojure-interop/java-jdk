(ns jdk.util.function.BooleanSupplier
  "Represents a supplier of boolean-valued results.  This is the
  boolean-producing primitive specialization of Supplier.

  There is no requirement that a new or distinct result be returned each
  time the supplier is invoked.

  This is a functional interface
  whose functional method is getAsBoolean()."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function BooleanSupplier]))

(defn get-as-boolean?
  "Gets a result.

  returns: a result - `boolean`"
  (^Boolean [^BooleanSupplier this]
    (-> this (.getAsBoolean))))

