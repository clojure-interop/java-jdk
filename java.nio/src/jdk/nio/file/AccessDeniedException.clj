(ns jdk.nio.file.AccessDeniedException
  "Checked exception thrown when a file system operation is denied, typically
  due to a file permission or other access check.

   This exception is not related to the AccessControlException or SecurityException thrown by access controllers or security managers when
  access to a file is denied."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file AccessDeniedException]))

(defn ->access-denied-exception
  "Constructor.

  Constructs an instance of this class.

  file - a string identifying the file or null if not known - `java.lang.String`
  other - a string identifying the other file or null if not known - `java.lang.String`
  reason - a reason message with additional information or null - `java.lang.String`"
  (^AccessDeniedException [^java.lang.String file ^java.lang.String other ^java.lang.String reason]
    (new AccessDeniedException file other reason))
  (^AccessDeniedException [^java.lang.String file]
    (new AccessDeniedException file)))

