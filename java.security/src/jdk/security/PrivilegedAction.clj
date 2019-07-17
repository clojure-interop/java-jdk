(ns jdk.security.PrivilegedAction
  "A computation to be performed with privileges enabled.  The computation is
  performed by invoking AccessController.doPrivileged on the
  PrivilegedAction object.  This interface is used only for
  computations that do not throw checked exceptions; computations that
  throw checked exceptions must use PrivilegedExceptionAction
  instead."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security PrivilegedAction]))

(defn run
  "Performs the computation.  This method will be called by
   AccessController.doPrivileged after enabling privileges.

  returns: a class-dependent value that may represent the results of the
           computation. Each class that implements
           PrivilegedAction
           should document what (if anything) this value represents. - `PrivilegedAction.T`"
  (^PrivilegedAction.T [^java.security.PrivilegedAction this]
    (-> this (.run))))

