(ns jdk.security.Identity
  "Deprecated.
 This class is no longer used. Its functionality has been
  replaced by java.security.KeyStore, the
  java.security.cert package, and
  java.security.Principal."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security Identity]))

(defn ->identity
  "Constructor.

  Deprecated.

  name - the identity name. - `java.lang.String`
  scope - the scope of the identity. - `java.security.IdentityScope`

  throws: java.security.KeyManagementException - if there is already an identity with the same name in the scope."
  ([name scope]
    (new Identity name scope))
  ([name]
    (new Identity name)))

(defn to-string
  "Deprecated.

  detailed - whether or not to provide detailed information. - `boolean`

  returns: information about this identity. If detailed
   is true, then this method returns more information than that
   provided by the toString method without any arguments. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and its checkSecurityAccess method doesn't allow returning a string describing this identity."
  ([this detailed]
    (-> this (.toString detailed)))
  ([this]
    (-> this (.toString))))

(defn certificates
  "Deprecated.

  returns: a copy of all the certificates for this identity. - `java.security.Certificate[]`"
  ([this]
    (-> this (.certificates))))

(defn get-name
  "Deprecated.

  returns: the name of this identity. - `java.lang.String`"
  ([this]
    (-> this (.getName))))

(defn get-info
  "Deprecated.

  returns: general information about this identity. - `java.lang.String`"
  ([this]
    (-> this (.getInfo))))

(defn get-public-key
  "Deprecated.

  returns: the public key for this identity. - `java.security.PublicKey`"
  ([this]
    (-> this (.getPublicKey))))

(defn set-public-key
  "Deprecated.

  key - the public key for this identity. - `java.security.PublicKey`

  throws: java.security.KeyManagementException - if another identity in the identity's scope has the same public key, or if another exception occurs."
  ([this key]
    (-> this (.setPublicKey key))))

(defn hash-code
  "Deprecated.

  returns: a hashcode for this identity. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn remove-certificate
  "Deprecated.

  certificate - the certificate to be removed. - `java.security.Certificate`

  throws: java.security.KeyManagementException - if the certificate is missing, or if another exception occurs."
  ([this certificate]
    (-> this (.removeCertificate certificate))))

(defn set-info
  "Deprecated.

  info - the information string. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and its checkSecurityAccess method doesn't allow setting the information string."
  ([this info]
    (-> this (.setInfo info))))

(defn add-certificate
  "Deprecated.

  certificate - the certificate to be added. - `java.security.Certificate`

  throws: java.security.KeyManagementException - if the certificate is not valid, if the public key in the certificate being added conflicts with this identity's public key, or if another exception occurs."
  ([this certificate]
    (-> this (.addCertificate certificate))))

(defn equals
  "Deprecated.

  identity - the object to test for equality with this identity. - `java.lang.Object`

  returns: true if the objects are considered equal, false otherwise. - `boolean`"
  ([this identity]
    (-> this (.equals identity))))

(defn get-scope
  "Deprecated.

  returns: the scope of this identity. - `java.security.IdentityScope`"
  ([this]
    (-> this (.getScope))))

