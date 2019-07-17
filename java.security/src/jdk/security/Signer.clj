(ns jdk.security.Signer
  "Deprecated.
 This class is no longer used. Its functionality has been
  replaced by java.security.KeyStore, the
  java.security.cert package, and
  java.security.Principal."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security Signer]))

(defn ->signer
  "Constructor.

  Deprecated.

  name - the identity name. - `java.lang.String`
  scope - the scope of the identity. - `java.security.IdentityScope`

  throws: java.security.KeyManagementException - if there is already an identity with the same name in the scope."
  ([name scope]
    (new Signer name scope))
  ([name]
    (new Signer name)))

(defn get-private-key
  "Deprecated.

  returns: this signer's private key, or null if the private key has
   not yet been set. - `java.security.PrivateKey`

  throws: java.lang.SecurityException - if a security manager exists and its checkSecurityAccess method doesn't allow returning the private key."
  ([this]
    (-> this (.getPrivateKey))))

(defn set-key-pair
  "Deprecated.

  pair - an initialized key pair. - `java.security.KeyPair`

  throws: java.security.InvalidParameterException - if the key pair is not properly initialized."
  ([this pair]
    (-> this (.setKeyPair pair))))

(defn to-string
  "Deprecated.

  returns: a string of information about the signer. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

