(ns jdk.util.concurrent.Callable
  "A task that returns a result and may throw an exception.
  Implementors define a single method with no arguments called
  call.

  The Callable interface is similar to Runnable, in that both are designed for classes whose
  instances are potentially executed by another thread.  A
  Runnable, however, does not return a result and cannot
  throw a checked exception.

  The Executors class contains utility methods to
  convert from other common forms to Callable classes."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent Callable]))

(defn call
  "Computes a result, or throws an exception if unable to do so.

  returns: computed result - `Callable.V`

  throws: java.lang.Exception - if unable to compute a result"
  ([^java.util.concurrent.Callable this]
    (-> this (.call))))

