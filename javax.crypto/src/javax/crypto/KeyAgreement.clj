(ns javax.crypto.KeyAgreement
  "This class provides the functionality of a key agreement (or key
  exchange) protocol.

  The keys involved in establishing a shared secret are created by one of the
  key generators (KeyPairGenerator or
  KeyGenerator), a KeyFactory, or as a result from
  an intermediate phase of the key agreement protocol.

   For each of the correspondents in the key exchange, doPhase
  needs to be called. For example, if this key exchange is with one other
  party, doPhase needs to be called once, with the
  lastPhase flag set to true.
  If this key exchange is
  with two other parties, doPhase needs to be called twice,
  the first time setting the lastPhase flag to
  false, and the second time setting it to true.
  There may be any number of parties involved in a key exchange.

   Every implementation of the Java platform is required to support the
  following standard KeyAgreement algorithm:

  DiffieHellman

  This algorithm is described in the
  KeyAgreement section of the
  Java Cryptography Architecture Standard Algorithm Name Documentation.
  Consult the release documentation for your implementation to see if any
  other algorithms are supported."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto KeyAgreement]))

(defn *get-instance
  "Returns a KeyAgreement object that implements the
   specified key agreement algorithm.

    A new KeyAgreement object encapsulating the
   KeyAgreementSpi implementation from the specified provider
   is returned.  The specified provider must be registered
   in the security provider list.

    Note that the list of registered providers may be retrieved via
   the Security.getProviders() method.

  algorithm - the standard name of the requested key agreement algorithm. See the KeyAgreement section in the Java Cryptography Architecture Standard Algorithm Name Documentation for information about standard algorithm names. - `java.lang.String`
  provider - the name of the provider. - `java.lang.String`

  returns: the new KeyAgreement object. - `javax.crypto.KeyAgreement`

  throws: java.lang.NullPointerException - if the specified algorithm is null."
  ([algorithm provider]
    (KeyAgreement/getInstance algorithm provider))
  ([algorithm]
    (KeyAgreement/getInstance algorithm)))

(defn get-algorithm
  "Returns the algorithm name of this KeyAgreement object.

   This is the same name that was specified in one of the
   getInstance calls that created this
   KeyAgreement object.

  returns: the algorithm name of this KeyAgreement object. - `java.lang.String`"
  ([this]
    (-> this (.getAlgorithm))))

(defn get-provider
  "Returns the provider of this KeyAgreement object.

  returns: the provider of this KeyAgreement object - `java.security.Provider`"
  ([this]
    (-> this (.getProvider))))

(defn init
  "Initializes this key agreement with the given key, set of
   algorithm parameters, and source of randomness.

  key - the party's private information. For example, in the case of the Diffie-Hellman key agreement, this would be the party's own Diffie-Hellman private key. - `java.security.Key`
  params - the key agreement parameters - `java.security.spec.AlgorithmParameterSpec`
  random - the source of randomness - `java.security.SecureRandom`

  throws: java.security.InvalidKeyException - if the given key is inappropriate for this key agreement, e.g., is of the wrong type or has an incompatible algorithm type."
  ([this key params random]
    (-> this (.init key params random)))
  ([this key random]
    (-> this (.init key random)))
  ([this key]
    (-> this (.init key))))

(defn do-phase
  "Executes the next phase of this key agreement with the given
   key that was received from one of the other parties involved in this key
   agreement.

  key - the key for this phase. For example, in the case of Diffie-Hellman between 2 parties, this would be the other party's Diffie-Hellman public key. - `java.security.Key`
  last-phase - flag which indicates whether or not this is the last phase of this key agreement. - `boolean`

  returns: the (intermediate) key resulting from this phase, or null
   if this phase does not yield a key - `java.security.Key`

  throws: java.security.InvalidKeyException - if the given key is inappropriate for this phase."
  ([this key last-phase]
    (-> this (.doPhase key last-phase))))

(defn generate-secret
  "Generates the shared secret, and places it into the buffer
   sharedSecret, beginning at offset inclusive.

   If the sharedSecret buffer is too small to hold the
   result, a ShortBufferException is thrown.
   In this case, this call should be repeated with a larger output buffer.

   This method resets this KeyAgreement object, so that it
   can be reused for further key agreements. Unless this key agreement is
   reinitialized with one of the init methods, the same
   private information and algorithm parameters will be used for
   subsequent key agreements.

  shared-secret - the buffer for the shared secret - `byte[]`
  offset - the offset in sharedSecret where the shared secret will be stored - `int`

  returns: the number of bytes placed into sharedSecret - `int`

  throws: java.lang.IllegalStateException - if this key agreement has not been completed yet"
  ([this shared-secret offset]
    (-> this (.generateSecret shared-secret offset)))
  ([this algorithm]
    (-> this (.generateSecret algorithm)))
  ([this]
    (-> this (.generateSecret))))

