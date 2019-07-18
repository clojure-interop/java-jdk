(ns jdk.security.Guard
  " This interface represents a guard, which is an object that is used
  to protect access to another object.

  This interface contains a single method, checkGuard,
  with a single object argument. checkGuard is
  invoked (by the GuardedObject getObject method)
  to determine whether or not to allow access to the object."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security Guard]))

(defn check-guard
  "Determines whether or not to allow access to the guarded object
   object. Returns silently if access is allowed.
   Otherwise, throws a SecurityException.

  object - the object being protected by the guard. - `java.lang.Object`

  throws: java.lang.SecurityException - if access is denied."
  ([^Guard this ^java.lang.Object object]
    (-> this (.checkGuard object))))

