(ns jdk.security.PrivilegedExceptionAction
  "A computation to be performed with privileges enabled, that throws one or
  more checked exceptions.  The computation is performed by invoking
  AccessController.doPrivileged on the
  PrivilegedExceptionAction object.  This interface is
  used only for computations that throw checked exceptions;
  computations that do not throw
  checked exceptions should use PrivilegedAction instead."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security PrivilegedExceptionAction]))

(defn run
  "Performs the computation.  This method will be called by
   AccessController.doPrivileged after enabling privileges.

  returns: a class-dependent value that may represent the results of the
           computation.  Each class that implements
           PrivilegedExceptionAction should document what
           (if anything) this value represents. - `PrivilegedExceptionAction.T`

  throws: java.lang.Exception - an exceptional condition has occurred. Each class that implements PrivilegedExceptionAction should document the exceptions that its run method can throw."
  (^PrivilegedExceptionAction.T [^java.security.PrivilegedExceptionAction this]
    (-> this (.run))))

