(ns javax.crypto.SealedObject
  "This class enables a programmer to create an object and protect its
  confidentiality with a cryptographic algorithm.

   Given any Serializable object, one can create a SealedObject
  that encapsulates the original object, in serialized
  format (i.e., a `deep copy`), and seals (encrypts) its serialized contents,
  using a cryptographic algorithm such as AES, to protect its
  confidentiality.  The encrypted content can later be decrypted (with
  the corresponding algorithm using the correct decryption key) and
  de-serialized, yielding the original object.

   Note that the Cipher object must be fully initialized with the
  correct algorithm, key, padding scheme, etc., before being applied
  to a SealedObject.

   The original object that was sealed can be recovered in two different
  ways:



  by using the getObject
  method that takes a Cipher object.

   This method requires a fully initialized Cipher object,
  initialized with the
  exact same algorithm, key, padding scheme, etc., that were used to seal the
  object.

   This approach has the advantage that the party who unseals the
  sealed object does not require knowledge of the decryption key. For example,
  after one party has initialized the cipher object with the required
  decryption key, it could hand over the cipher object to
  another party who then unseals the sealed object.

  by using one of the
  getObject methods
  that take a Key object.

   In this approach, the getObject method creates a cipher
  object for the appropriate decryption algorithm and initializes it with the
  given decryption key and the algorithm parameters (if any) that were stored
  in the sealed object.

   This approach has the advantage that the party who
  unseals the object does not need to keep track of the parameters (e.g., an
  IV) that were used to seal the object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto SealedObject]))

(defn ->sealed-object
  "Constructor.

  Constructs a SealedObject from any Serializable object.

   The given object is serialized, and its serialized contents are
   encrypted using the given Cipher, which must be fully initialized.

   Any algorithm parameters that may be used in the encryption
   operation are stored inside of the new SealedObject.

  object - the object to be sealed; can be null. - `java.io.Serializable`
  c - the cipher used to seal the object. - `javax.crypto.Cipher`

  throws: java.lang.NullPointerException - if the given cipher is null."
  ([^java.io.Serializable object ^javax.crypto.Cipher c]
    (new SealedObject object c)))

(defn get-algorithm
  "Returns the algorithm that was used to seal this object.

  returns: the algorithm that was used to seal this object. - `java.lang.String`"
  ([^javax.crypto.SealedObject this]
    (-> this (.getAlgorithm))))

(defn get-object
  "Retrieves the original (encapsulated) object.

   This method creates a cipher for the algorithm that had been used in
   the sealing operation, using an implementation of that algorithm from
   the given provider.
   The Cipher object is initialized for decryption, using the given
   key and the parameters (if any) that had been used in the
   sealing operation.

   The encapsulated object is unsealed and de-serialized, before it is
   returned.

  key - the key used to unseal the object. - `java.security.Key`
  provider - the name of the provider of the algorithm to unseal the object. - `java.lang.String`

  returns: the original object. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if the given provider is null or empty."
  ([^javax.crypto.SealedObject this ^java.security.Key key ^java.lang.String provider]
    (-> this (.getObject key provider)))
  ([^javax.crypto.SealedObject this ^java.security.Key key]
    (-> this (.getObject key))))

