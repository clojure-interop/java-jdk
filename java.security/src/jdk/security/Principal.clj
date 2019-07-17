(ns jdk.security.Principal
  "This interface represents the abstract notion of a principal, which
  can be used to represent any entity, such as an individual, a
  corporation, and a login id."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security Principal]))

(defn equals
  "Compares this principal to the specified object.  Returns true
   if the object passed in matches the principal represented by
   the implementation of this interface.

  another - principal to compare with. - `java.lang.Object`

  returns: true if the principal passed in is the same as that
   encapsulated by this principal, and false otherwise. - `boolean`"
  ([^java.security.Principal this ^java.lang.Object another]
    (-> this (.equals another))))

(defn to-string
  "Returns a string representation of this principal.

  returns: a string representation of this principal. - `java.lang.String`"
  ([^java.security.Principal this]
    (-> this (.toString))))

(defn hash-code
  "Returns a hashcode for this principal.

  returns: a hashcode for this principal. - `int`"
  ([^java.security.Principal this]
    (-> this (.hashCode))))

(defn get-name
  "Returns the name of this principal.

  returns: the name of this principal. - `java.lang.String`"
  ([^java.security.Principal this]
    (-> this (.getName))))

(defn implies
  "Returns true if the specified subject is implied by this principal.

   The default implementation of this method returns true if
   subject is non-null and contains at least one principal that
   is equal to this principal.

   Subclasses may override this with a different implementation, if
   necessary.

  subject - the Subject - `javax.security.auth.Subject`

  returns: true if subject is non-null and is
                implied by this principal, or false otherwise. - `default boolean`"
  ([^java.security.Principal this ^javax.security.auth.Subject subject]
    (-> this (.implies subject))))

