(ns jdk.util.function.LongSupplier
  "Represents a supplier of long-valued results.  This is the
  long-producing primitive specialization of Supplier.

  There is no requirement that a distinct result be returned each
  time the supplier is invoked.

  This is a functional interface
  whose functional method is getAsLong()."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function LongSupplier]))

(defn get-as-long
  "Gets a result.

  returns: a result - `long`"
  ([^java.util.function.LongSupplier this]
    (-> this (.getAsLong))))

