(ns jdk.security.KeyPair
  "This class is a simple holder for a key pair (a public key and a
  private key). It does not enforce any security, and, when initialized,
  should be treated like a PrivateKey."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security KeyPair]))

(defn ->key-pair
  "Constructor.

  Constructs a key pair from the given public key and private key.

   Note that this constructor only stores references to the public
   and private key components in the generated key pair. This is safe,
   because Key objects are immutable.

  public-key - the public key. - `java.security.PublicKey`
  private-key - the private key. - `java.security.PrivateKey`"
  (^KeyPair [^java.security.PublicKey public-key ^java.security.PrivateKey private-key]
    (new KeyPair public-key private-key)))

(defn get-public
  "Returns a reference to the public key component of this key pair.

  returns: a reference to the public key. - `java.security.PublicKey`"
  (^java.security.PublicKey [^KeyPair this]
    (-> this (.getPublic))))

(defn get-private
  "Returns a reference to the private key component of this key pair.

  returns: a reference to the private key. - `java.security.PrivateKey`"
  (^java.security.PrivateKey [^KeyPair this]
    (-> this (.getPrivate))))

