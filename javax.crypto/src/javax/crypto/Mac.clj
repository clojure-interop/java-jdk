(ns javax.crypto.Mac
  "This class provides the functionality of a `Message Authentication Code`
  (MAC) algorithm.

   A MAC provides a way to check
  the integrity of information transmitted over or stored in an unreliable
  medium, based on a secret key. Typically, message
  authentication codes are used between two parties that share a secret
  key in order to validate information transmitted between these
  parties.

   A MAC mechanism that is based on cryptographic hash functions is
  referred to as HMAC. HMAC can be used with any cryptographic hash function,
  e.g., SHA256 or SHA384, in combination with a secret shared key. HMAC is
  specified in RFC 2104.

   Every implementation of the Java platform is required to support
  the following standard Mac algorithms:

  HmacMD5
  HmacSHA1
  HmacSHA256

  These algorithms are described in the

  Mac section of the
  Java Cryptography Architecture Standard Algorithm Name Documentation.
  Consult the release documentation for your implementation to see if any
  other algorithms are supported."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto Mac]))

(defn *get-instance
  "Returns a Mac object that implements the
   specified MAC algorithm.

    A new Mac object encapsulating the
   MacSpi implementation from the specified provider
   is returned.  The specified provider must be registered
   in the security provider list.

    Note that the list of registered providers may be retrieved via
   the Security.getProviders() method.

  algorithm - the standard name of the requested MAC algorithm. See the Mac section in the Java Cryptography Architecture Standard Algorithm Name Documentation for information about standard algorithm names. - `java.lang.String`
  provider - the name of the provider. - `java.lang.String`

  returns: the new Mac object. - `javax.crypto.Mac`

  throws: java.security.NoSuchAlgorithmException - if a MacSpi implementation for the specified algorithm is not available from the specified provider."
  ([algorithm provider]
    (Mac/getInstance algorithm provider))
  ([algorithm]
    (Mac/getInstance algorithm)))

(defn get-algorithm
  "Returns the algorithm name of this Mac object.

   This is the same name that was specified in one of the
   getInstance calls that created this
   Mac object.

  returns: the algorithm name of this Mac object. - `java.lang.String`"
  ([this]
    (-> this (.getAlgorithm))))

(defn get-provider
  "Returns the provider of this Mac object.

  returns: the provider of this Mac object. - `java.security.Provider`"
  ([this]
    (-> this (.getProvider))))

(defn get-mac-length
  "Returns the length of the MAC in bytes.

  returns: the MAC length in bytes. - `int`"
  ([this]
    (-> this (.getMacLength))))

(defn init
  "Initializes this Mac object with the given key and
   algorithm parameters.

  key - the key. - `java.security.Key`
  params - the algorithm parameters. - `java.security.spec.AlgorithmParameterSpec`

  throws: java.security.InvalidKeyException - if the given key is inappropriate for initializing this MAC."
  ([this key params]
    (-> this (.init key params)))
  ([this key]
    (-> this (.init key))))

(defn update
  "Processes the first len bytes in input,
   starting at offset inclusive.

  input - the input buffer. - `byte[]`
  offset - the offset in input where the input starts. - `int`
  len - the number of bytes to process. - `int`

  throws: java.lang.IllegalStateException - if this Mac has not been initialized."
  ([this input offset len]
    (-> this (.update input offset len)))
  ([this input]
    (-> this (.update input))))

(defn do-final
  "Finishes the MAC operation.

   A call to this method resets this Mac object to the
   state it was in when previously initialized via a call to
   init(Key) or
   init(Key, AlgorithmParameterSpec).
   That is, the object is reset and available to generate another MAC from
   the same key, if desired, via new calls to update and
   doFinal.
   (In order to reuse this Mac object with a different key,
   it must be reinitialized via a call to init(Key) or
   init(Key, AlgorithmParameterSpec).

   The MAC result is stored in output, starting at
   outOffset inclusive.

  output - the buffer where the MAC result is stored - `byte[]`
  out-offset - the offset in output where the MAC is stored - `int`

  throws: javax.crypto.ShortBufferException - if the given output buffer is too small to hold the result"
  ([this output out-offset]
    (-> this (.doFinal output out-offset)))
  ([this input]
    (-> this (.doFinal input)))
  ([this]
    (-> this (.doFinal))))

(defn reset
  "Resets this Mac object.

   A call to this method resets this Mac object to the
   state it was in when previously initialized via a call to
   init(Key) or
   init(Key, AlgorithmParameterSpec).
   That is, the object is reset and available to generate another MAC from
   the same key, if desired, via new calls to update and
   doFinal.
   (In order to reuse this Mac object with a different key,
   it must be reinitialized via a call to init(Key) or
   init(Key, AlgorithmParameterSpec)."
  ([this]
    (-> this (.reset))))

(defn clone
  "Returns a clone if the provider implementation is cloneable.

  returns: a clone if the provider implementation is cloneable. - `java.lang.Object`

  throws: java.lang.CloneNotSupportedException - if this is called on a delegate that does not support Cloneable."
  ([this]
    (-> this (.clone))))

