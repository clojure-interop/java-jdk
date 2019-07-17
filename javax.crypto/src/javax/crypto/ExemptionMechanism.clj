(ns javax.crypto.ExemptionMechanism
  "This class provides the functionality of an exemption mechanism, examples
  of which are key recovery, key weakening, and
  key escrow.

  Applications or applets that use an exemption mechanism may be granted
  stronger encryption capabilities than those which don't."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto ExemptionMechanism]))

(defn *get-instance
  "Returns an ExemptionMechanism object that implements the
   specified exemption mechanism algorithm.

    A new ExemptionMechanism object encapsulating the
   ExemptionMechanismSpi implementation from the specified provider
   is returned.  The specified provider must be registered
   in the security provider list.

    Note that the list of registered providers may be retrieved via
   the Security.getProviders() method.

  algorithm - the standard name of the requested exemption mechanism. See the ExemptionMechanism section in the Java Cryptography Architecture Standard Algorithm Name Documentation for information about standard exemption mechanism names. - `java.lang.String`
  provider - the name of the provider. - `java.lang.String`

  returns: the new ExemptionMechanism object. - `javax.crypto.ExemptionMechanism`

  throws: java.lang.NullPointerException - if algorithm is null."
  (^javax.crypto.ExemptionMechanism [^java.lang.String algorithm ^java.lang.String provider]
    (ExemptionMechanism/getInstance algorithm provider))
  (^javax.crypto.ExemptionMechanism [^java.lang.String algorithm]
    (ExemptionMechanism/getInstance algorithm)))

(defn get-name
  "Returns the exemption mechanism name of this
   ExemptionMechanism object.

   This is the same name that was specified in one of the
   getInstance calls that created this
   ExemptionMechanism object.

  returns: the exemption mechanism name of this
   ExemptionMechanism object. - `java.lang.String`"
  (^java.lang.String [^javax.crypto.ExemptionMechanism this]
    (-> this (.getName))))

(defn get-provider
  "Returns the provider of this ExemptionMechanism object.

  returns: the provider of this ExemptionMechanism object. - `java.security.Provider`"
  (^java.security.Provider [^javax.crypto.ExemptionMechanism this]
    (-> this (.getProvider))))

(defn crypto-allowed?
  "Returns whether the result blob has been generated successfully by this
   exemption mechanism.

   The method also makes sure that the key passed in is the same as
   the one this exemption mechanism used in initializing and generating
   phases.

  key - the key the crypto is going to use. - `java.security.Key`

  returns: whether the result blob of the same key has been generated
   successfully by this exemption mechanism; false if key
   is null. - `boolean`

  throws: javax.crypto.ExemptionMechanismException - if problem(s) encountered while determining whether the result blob has been generated successfully by this exemption mechanism object."
  (^Boolean [^javax.crypto.ExemptionMechanism this ^java.security.Key key]
    (-> this (.isCryptoAllowed key))))

(defn get-output-size
  "Returns the length in bytes that an output buffer would need to be in
   order to hold the result of the next
   genExemptionBlob
   operation, given the input length inputLen (in bytes).

   The actual output length of the next
   genExemptionBlob
   call may be smaller than the length returned by this method.

  input-len - the input length (in bytes) - `int`

  returns: the required output buffer size (in bytes) - `int`

  throws: java.lang.IllegalStateException - if this exemption mechanism is in a wrong state (e.g., has not yet been initialized)"
  (^Integer [^javax.crypto.ExemptionMechanism this ^Integer input-len]
    (-> this (.getOutputSize input-len))))

(defn init
  "Initializes this exemption mechanism with a key and a set of algorithm
   parameters.

   If this exemption mechanism requires any algorithm parameters
   and params is null, the underlying exemption
   mechanism implementation is supposed to generate the required
   parameters itself (using provider-specific default values); in the case
   that algorithm parameters must be specified by the caller, an
   InvalidAlgorithmParameterException is raised.

  key - the key for this exemption mechanism - `java.security.Key`
  params - the algorithm parameters - `java.security.spec.AlgorithmParameterSpec`

  throws: java.security.InvalidKeyException - if the given key is inappropriate for this exemption mechanism."
  ([^javax.crypto.ExemptionMechanism this ^java.security.Key key ^java.security.spec.AlgorithmParameterSpec params]
    (-> this (.init key params)))
  ([^javax.crypto.ExemptionMechanism this ^java.security.Key key]
    (-> this (.init key))))

(defn gen-exemption-blob
  "Generates the exemption mechanism key blob, and stores the result in
   the output buffer, starting at outputOffset
   inclusive.

   If the output buffer is too small to hold the result,
   a ShortBufferException is thrown. In this case, repeat this
   call with a larger output buffer. Use
   getOutputSize to determine how big
   the output buffer should be.

  output - the buffer for the result - `byte[]`
  output-offset - the offset in output where the result is stored - `int`

  returns: the number of bytes stored in output - `int`

  throws: java.lang.IllegalStateException - if this exemption mechanism is in a wrong state (e.g., has not been initialized)."
  (^Integer [^javax.crypto.ExemptionMechanism this output ^Integer output-offset]
    (-> this (.genExemptionBlob output output-offset)))
  (^Integer [^javax.crypto.ExemptionMechanism this output]
    (-> this (.genExemptionBlob output)))
  ([^javax.crypto.ExemptionMechanism this]
    (-> this (.genExemptionBlob))))

