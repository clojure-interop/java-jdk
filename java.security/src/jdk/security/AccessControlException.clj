(ns jdk.security.AccessControlException
  " This exception is thrown by the AccessController to indicate
  that a requested access (to a critical system resource such as the
  file system or the network) is denied.

   The reason to deny access can vary.  For example, the requested
  permission might be of an incorrect type,  contain an invalid
  value, or request access that is not allowed according to the
  security policy.  Such information should be given whenever
  possible at the time the exception is thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security AccessControlException]))

(defn ->access-control-exception
  "Constructor.

  Constructs an AccessControlException with the
   specified, detailed message, and the requested permission that caused
   the exception.

  s - the detail message. - `java.lang.String`
  p - the permission that caused the exception. - `java.security.Permission`"
  ([^java.lang.String s ^java.security.Permission p]
    (new AccessControlException s p))
  ([^java.lang.String s]
    (new AccessControlException s)))

(defn get-permission
  "Gets the Permission object associated with this exception, or
   null if there was no corresponding Permission object.

  returns: the Permission object. - `java.security.Permission`"
  (^java.security.Permission [^java.security.AccessControlException this]
    (-> this (.getPermission))))

