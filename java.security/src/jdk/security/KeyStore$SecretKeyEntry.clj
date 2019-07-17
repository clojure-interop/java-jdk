(ns jdk.security.KeyStore$SecretKeyEntry
  "A KeyStore entry that holds a SecretKey."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security KeyStore$SecretKeyEntry]))

(defn ->secret-key-entry
  "Constructor.

  Constructs a SecretKeyEntry with a SecretKey and
   associated entry attributes.

    The specified attributes is cloned before it is stored
   in the new SecretKeyEntry object.

  secret-key - the SecretKey - `javax.crypto.SecretKey`
  attributes - the attributes - `java.util.Set<java.security.KeyStore.Entry.Attribute>`

  throws: java.lang.NullPointerException - if secretKey or attributes is null"
  ([secret-key attributes]
    (new KeyStore$SecretKeyEntry secret-key attributes))
  ([secret-key]
    (new KeyStore$SecretKeyEntry secret-key)))

(defn get-secret-key
  "Gets the SecretKey from this entry.

  returns: the SecretKey from this entry - `javax.crypto.SecretKey`"
  ([this]
    (-> this (.getSecretKey))))

(defn get-attributes
  "Retrieves the attributes associated with an entry.

  returns: an unmodifiable Set of attributes, possibly empty - `java.util.Set<java.security.KeyStore.Entry.Attribute>`"
  ([this]
    (-> this (.getAttributes))))

(defn to-string
  "Returns a string representation of this SecretKeyEntry.

  returns: a string representation of this SecretKeyEntry. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

