(ns jdk.nio.file.attribute.UserPrincipalNotFoundException
  "Checked exception thrown when a lookup of UserPrincipal fails because
  the principal does not exist."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file.attribute UserPrincipalNotFoundException]))

(defn ->user-principal-not-found-exception
  "Constructor.

  Constructs an instance of this class.

  name - the principal name; may be null - `java.lang.String`"
  ([^java.lang.String name]
    (new UserPrincipalNotFoundException name)))

(defn get-name
  "Returns the user principal name if this exception was created with the
   user principal name that was not found, otherwise null.

  returns: the user principal name or null - `java.lang.String`"
  (^java.lang.String [^java.nio.file.attribute.UserPrincipalNotFoundException this]
    (-> this (.getName))))

