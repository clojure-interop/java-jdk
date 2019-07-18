(ns jdk.security.IdentityScope
  "Deprecated.
 This class is no longer used. Its functionality has been
  replaced by java.security.KeyStore, the
  java.security.cert package, and
  java.security.Principal."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security IdentityScope]))

(defn ->identity-scope
  "Constructor.

  Deprecated.

  name - the scope name. - `java.lang.String`
  scope - the scope for the new identity scope. - `java.security.IdentityScope`

  throws: java.security.KeyManagementException - if there is already an identity with the same name in the scope."
  (^IdentityScope [^java.lang.String name ^java.security.IdentityScope scope]
    (new IdentityScope name scope))
  (^IdentityScope [^java.lang.String name]
    (new IdentityScope name)))

(defn *get-system-scope
  "Deprecated.

  returns: the system's identity scope, or null if none has been
           set. - `java.security.IdentityScope`"
  (^java.security.IdentityScope []
    (IdentityScope/getSystemScope )))

(defn size
  "Deprecated.

  returns: the number of identities within this identity scope. - `int`"
  (^Integer [^IdentityScope this]
    (-> this (.size))))

(defn get-identity
  "Deprecated.

  name - the name of the identity to be retrieved. - `java.lang.String`

  returns: the identity named name, or null if there are
   no identities named name in this scope. - `java.security.Identity`"
  (^java.security.Identity [^IdentityScope this ^java.lang.String name]
    (-> this (.getIdentity name))))

(defn add-identity
  "Deprecated.

  identity - the identity to be added. - `java.security.Identity`

  throws: java.security.KeyManagementException - if the identity is not valid, a name conflict occurs, another identity has the same public key as the identity being added, or another exception occurs."
  ([^IdentityScope this ^java.security.Identity identity]
    (-> this (.addIdentity identity))))

(defn remove-identity
  "Deprecated.

  identity - the identity to be removed. - `java.security.Identity`

  throws: java.security.KeyManagementException - if the identity is missing, or another exception occurs."
  ([^IdentityScope this ^java.security.Identity identity]
    (-> this (.removeIdentity identity))))

(defn identities
  "Deprecated.

  returns: an enumeration of all identities in this identity scope. - `java.util.Enumeration<java.security.Identity>`"
  (^java.util.Enumeration [^IdentityScope this]
    (-> this (.identities))))

(defn to-string
  "Deprecated.

  returns: a string representation of this identity scope. - `java.lang.String`"
  (^java.lang.String [^IdentityScope this]
    (-> this (.toString))))

