(ns jdk.util.logging.LoggingPermission
  "The permission which the SecurityManager will check when code
  that is running with a SecurityManager calls one of the logging
  control methods (such as Logger.setLevel).

  Currently there is only one named LoggingPermission.  This is `control`
  and it grants the ability to control the logging configuration, for
  example by adding or removing Handlers, by adding or removing Filters,
  or by changing logging levels.

  Programmers do not normally create LoggingPermission objects directly.
  Instead they are created by the security policy code based on reading
  the security policy file."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.logging LoggingPermission]))

(defn ->logging-permission
  "Constructor.

  Creates a new LoggingPermission object.

  name - Permission name. Must be `control`. - `java.lang.String`
  actions - Must be either null or the empty string. - `java.lang.String`

  throws: java.lang.NullPointerException - if name is null."
  ([^java.lang.String name ^java.lang.String actions]
    (new LoggingPermission name actions)))

