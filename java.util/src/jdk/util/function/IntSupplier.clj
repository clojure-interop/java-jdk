(ns jdk.util.function.IntSupplier
  "Represents a supplier of int-valued results.  This is the
  int-producing primitive specialization of Supplier.

  There is no requirement that a distinct result be returned each
  time the supplier is invoked.

  This is a functional interface
  whose functional method is getAsInt()."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function IntSupplier]))

(defn get-as-int
  "Gets a result.

  returns: a result - `int`"
  (^Integer [^java.util.function.IntSupplier this]
    (-> this (.getAsInt))))

