(ns jdk.security.acl.Permission
  "This interface represents a permission, such as that used to grant
  a particular type of access to a resource."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.acl Permission]))

(defn equals
  "Returns true if the object passed matches the permission represented
   in this interface.

  another - the Permission object to compare with. - `java.lang.Object`

  returns: true if the Permission objects are equal, false otherwise - `boolean`"
  ([^. this ^java.lang.Object another]
    (-> this (.equals another))))

(defn to-string
  "Prints a string representation of this permission.

  returns: the string representation of the permission. - `java.lang.String`"
  ([^. this]
    (-> this (.toString))))

