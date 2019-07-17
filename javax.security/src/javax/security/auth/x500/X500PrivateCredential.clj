(ns javax.security.auth.x500.X500PrivateCredential
  " This class represents an X500PrivateCredential.
  It associates an X.509 certificate, corresponding private key and the
  KeyStore alias used to reference that exact key pair in the KeyStore.
  This enables looking up the private credentials for an X.500 principal
  in a subject."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.x500 X500PrivateCredential]))

(defn ->x-500-private-credential
  "Constructor.

  Creates an X500PrivateCredential that associates an X.509 certificate,
   a private key and the KeyStore alias.

  cert - X509Certificate - `java.security.cert.X509Certificate`
  key - PrivateKey for the certificate - `java.security.PrivateKey`
  alias - KeyStore alias - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if either cert, key or alias is null"
  ([cert key alias]
    (new X500PrivateCredential cert key alias))
  ([cert key]
    (new X500PrivateCredential cert key)))

(defn get-certificate
  "Returns the X.509 certificate.

  returns: the X509Certificate - `java.security.cert.X509Certificate`"
  ([this]
    (-> this (.getCertificate))))

(defn get-private-key
  "Returns the PrivateKey.

  returns: the PrivateKey - `java.security.PrivateKey`"
  ([this]
    (-> this (.getPrivateKey))))

(defn get-alias
  "Returns the KeyStore alias.

  returns: the KeyStore alias - `java.lang.String`"
  ([this]
    (-> this (.getAlias))))

(defn destroy
  "Clears the references to the X.509 certificate, private key and the
   KeyStore alias in this object."
  ([this]
    (-> this (.destroy))))

(defn destroyed?
  "Determines if the references to the X.509 certificate and private key
   in this object have been cleared.

  returns: true if X509Certificate and the PrivateKey are null - `boolean`"
  ([this]
    (-> this (.isDestroyed))))

