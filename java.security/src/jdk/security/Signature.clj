(ns jdk.security.Signature
  "The Signature class is used to provide applications the functionality
  of a digital signature algorithm. Digital signatures are used for
  authentication and integrity assurance of digital data.

   The signature algorithm can be, among others, the NIST standard
  DSA, using DSA and SHA-256. The DSA algorithm using the
  SHA-256 message digest algorithm can be specified as SHA256withDSA.
  In the case of RSA the signing algorithm could be specified as, for example,
  SHA256withRSA.
  The algorithm name must be specified, as there is no default.

   A Signature object can be used to generate and verify digital
  signatures.

   There are three phases to the use of a Signature object for
  either signing data or verifying a signature:

  Initialization, with either



      a public key, which initializes the signature for
      verification (see initVerify), or

      a private key (and optionally a Secure Random Number Generator),
      which initializes the signature for signing
      (see initSign(PrivateKey)
      and initSign(PrivateKey, SecureRandom)).



  Updating

  Depending on the type of initialization, this will update the
  bytes to be signed or verified. See the
  update methods.

  Signing or Verifying a signature on all updated bytes. See the
  sign methods and the verify
  method.



  Note that this class is abstract and extends from
  SignatureSpi for historical reasons.
  Application developers should only take notice of the methods defined in
  this Signature class; all the methods in
  the superclass are intended for cryptographic service providers who wish to
  supply their own implementations of digital signature algorithms.

   Every implementation of the Java platform is required to support the
  following standard Signature algorithms:

  SHA1withDSA
  SHA1withRSA
  SHA256withRSA

  These algorithms are described in the
  Signature section of the
  Java Cryptography Architecture Standard Algorithm Name Documentation.
  Consult the release documentation for your implementation to see if any
  other algorithms are supported."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security Signature]))

(defn *get-instance
  "Returns a Signature object that implements the specified signature
   algorithm.

    A new Signature object encapsulating the
   SignatureSpi implementation from the specified provider
   is returned.  The specified provider must be registered
   in the security provider list.

    Note that the list of registered providers may be retrieved via
   the Security.getProviders() method.

  algorithm - the name of the algorithm requested. See the Signature section in the Java Cryptography Architecture Standard Algorithm Name Documentation for information about standard algorithm names. - `java.lang.String`
  provider - the name of the provider. - `java.lang.String`

  returns: the new Signature object. - `java.security.Signature`

  throws: java.security.NoSuchAlgorithmException - if a SignatureSpi implementation for the specified algorithm is not available from the specified provider."
  (^java.security.Signature [^java.lang.String algorithm ^java.lang.String provider]
    (Signature/getInstance algorithm provider))
  (^java.security.Signature [^java.lang.String algorithm]
    (Signature/getInstance algorithm)))

(defn to-string
  "Returns a string representation of this signature object,
   providing information that includes the state of the object
   and the name of the algorithm used.

  returns: a string representation of this signature object. - `java.lang.String`"
  (^java.lang.String [^java.security.Signature this]
    (-> this (.toString))))

(defn get-parameters
  "Returns the parameters used with this signature object.

   The returned parameters may be the same that were used to initialize
   this signature, or may contain a combination of default and randomly
   generated parameter values used by the underlying signature
   implementation if this signature requires algorithm parameters but
   was not initialized with any.

  returns: the parameters used with this signature, or null if this
   signature does not use any parameters. - `java.security.AlgorithmParameters`"
  (^java.security.AlgorithmParameters [^java.security.Signature this]
    (-> this (.getParameters))))

(defn get-provider
  "Returns the provider of this signature object.

  returns: the provider of this signature object - `java.security.Provider`"
  (^java.security.Provider [^java.security.Signature this]
    (-> this (.getProvider))))

(defn update
  "Updates the data to be signed or verified, using the specified
   array of bytes, starting at the specified offset.

  data - the array of bytes. - `byte[]`
  off - the offset to start from in the array of bytes. - `int`
  len - the number of bytes to use, starting at offset. - `int`

  throws: java.security.SignatureException - if this signature object is not initialized properly."
  ([^java.security.Signature this data ^Integer off ^Integer len]
    (-> this (.update data off len)))
  ([^java.security.Signature this ^Byte b]
    (-> this (.update b))))

(defn verify
  "Verifies the passed-in signature in the specified array
   of bytes, starting at the specified offset.

   A call to this method resets this signature object to the state
   it was in when previously initialized for verification via a
   call to initVerify(PublicKey). That is, the object is
   reset and available to verify another signature from the identity
   whose public key was specified in the call to initVerify.

  signature - the signature bytes to be verified. - `byte[]`
  offset - the offset to start from in the array of bytes. - `int`
  length - the number of bytes to use, starting at offset. - `int`

  returns: true if the signature was verified, false if not. - `boolean`

  throws: java.security.SignatureException - if this signature object is not initialized properly, the passed-in signature is improperly encoded or of the wrong type, if this signature algorithm is unable to process the input data provided, etc."
  (^Boolean [^java.security.Signature this signature ^Integer offset ^Integer length]
    (-> this (.verify signature offset length)))
  (^Boolean [^java.security.Signature this signature]
    (-> this (.verify signature))))

(defn get-algorithm
  "Returns the name of the algorithm for this signature object.

  returns: the name of the algorithm for this signature object. - `java.lang.String`"
  (^java.lang.String [^java.security.Signature this]
    (-> this (.getAlgorithm))))

(defn get-parameter
  "Deprecated.

  param - the string name of the parameter. - `java.lang.String`

  returns: the object that represents the parameter value, or null if
   there is none. - `java.lang.   java.lang.Object`

  throws: java.security.InvalidParameterException - if param is an invalid parameter for this engine, or another exception occurs while trying to get this parameter."
  ([^java.security.Signature this ^java.lang.String param]
    (-> this (.getParameter param))))

(defn init-verify
  "Initializes this object for verification. If this method is called
   again with a different argument, it negates the effect
   of this call.

  public-key - the public key of the identity whose signature is going to be verified. - `java.security.PublicKey`

  throws: java.security.InvalidKeyException - if the key is invalid."
  ([^java.security.Signature this ^java.security.PublicKey public-key]
    (-> this (.initVerify public-key))))

(defn clone
  "Returns a clone if the implementation is cloneable.

  returns: a clone if the implementation is cloneable. - `java.lang.Object`

  throws: java.lang.CloneNotSupportedException - if this is called on an implementation that does not support Cloneable."
  (^java.lang.Object [^java.security.Signature this]
    (-> this (.clone))))

(defn init-sign
  "Initialize this object for signing. If this method is called
   again with a different argument, it negates the effect
   of this call.

  private-key - the private key of the identity whose signature is going to be generated. - `java.security.PrivateKey`
  random - the source of randomness for this signature. - `java.security.SecureRandom`

  throws: java.security.InvalidKeyException - if the key is invalid."
  ([^java.security.Signature this ^java.security.PrivateKey private-key ^java.security.SecureRandom random]
    (-> this (.initSign private-key random)))
  ([^java.security.Signature this ^java.security.PrivateKey private-key]
    (-> this (.initSign private-key))))

(defn set-parameter
  "Initializes this signature engine with the specified parameter set.

  params - the parameters - `java.security.spec.AlgorithmParameterSpec`

  throws: java.security.InvalidAlgorithmParameterException - if the given parameters are inappropriate for this signature engine"
  ([^java.security.Signature this ^java.security.spec.AlgorithmParameterSpec params]
    (-> this (.setParameter params)))
  ([^java.security.Signature this ^java.lang.String param ^java.lang.Object value]
    (-> this (.setParameter param value))))

(defn sign
  "Finishes the signature operation and stores the resulting signature
   bytes in the provided buffer outbuf, starting at
   offset.
   The format of the signature depends on the underlying
   signature scheme.

   This signature object is reset to its initial state (the state it
   was in after a call to one of the initSign methods) and
   can be reused to generate further signatures with the same private key.

  outbuf - buffer for the signature result. - `byte[]`
  offset - offset into outbuf where the signature is stored. - `int`
  len - number of bytes within outbuf allotted for the signature. - `int`

  returns: the number of bytes placed into outbuf. - `int`

  throws: java.security.SignatureException - if this signature object is not initialized properly, if this signature algorithm is unable to process the input data provided, or if len is less than the actual signature length."
  (^Integer [^java.security.Signature this outbuf ^Integer offset ^Integer len]
    (-> this (.sign outbuf offset len)))
  ([^java.security.Signature this]
    (-> this (.sign))))

