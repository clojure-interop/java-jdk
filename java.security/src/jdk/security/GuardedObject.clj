(ns jdk.security.GuardedObject
  "A GuardedObject is an object that is used to protect access to
  another object.

  A GuardedObject encapsulates a target object and a Guard object,
  such that access to the target object is possible
  only if the Guard object allows it.
  Once an object is encapsulated by a GuardedObject,
  access to that object is controlled by the getObject
  method, which invokes the
  checkGuard method on the Guard object that is
  guarding access. If access is not allowed,
  an exception is thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security GuardedObject]))

(defn ->guarded-object
  "Constructor.

  Constructs a GuardedObject using the specified object and guard.
   If the Guard object is null, then no restrictions will
   be placed on who can access the object.

  object - the object to be guarded. - `java.lang.Object`
  guard - the Guard object that guards access to the object. - `java.security.Guard`"
  (^GuardedObject [^java.lang.Object object ^java.security.Guard guard]
    (new GuardedObject object guard)))

(defn get-object
  "Retrieves the guarded object, or throws an exception if access
   to the guarded object is denied by the guard.

  returns: the guarded object. - `java.lang.Object`

  throws: java.lang.SecurityException - if access to the guarded object is denied."
  (^java.lang.Object [^GuardedObject this]
    (-> this (.getObject))))

