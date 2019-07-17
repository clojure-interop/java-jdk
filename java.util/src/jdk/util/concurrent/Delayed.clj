(ns jdk.util.concurrent.Delayed
  "A mix-in style interface for marking objects that should be
  acted upon after a given delay.

  An implementation of this interface must define a
  compareTo method that provides an ordering consistent with
  its getDelay method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent Delayed]))

(defn get-delay
  "Returns the remaining delay associated with this object, in the
   given time unit.

  unit - the time unit - `java.util.concurrent.TimeUnit`

  returns: the remaining delay; zero or negative values indicate
   that the delay has already elapsed - `long`"
  (^Long [^java.util.concurrent.Delayed this ^java.util.concurrent.TimeUnit unit]
    (-> this (.getDelay unit))))

