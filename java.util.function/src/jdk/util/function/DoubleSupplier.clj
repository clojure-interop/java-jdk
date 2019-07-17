(ns jdk.util.function.DoubleSupplier
  "Represents a supplier of double-valued results.  This is the
  double-producing primitive specialization of Supplier.

  There is no requirement that a distinct result be returned each
  time the supplier is invoked.

  This is a functional interface
  whose functional method is getAsDouble()."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function DoubleSupplier]))

(defn get-as-double
  "Gets a result.

  returns: a result - `double`"
  ([^. this]
    (-> this (.getAsDouble))))

