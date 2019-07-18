(ns javax.crypto.spec.GCMParameterSpec
  "Specifies the set of parameters required by a Cipher using the Galois/Counter Mode (GCM) mode.

  Simple block cipher modes (such as CBC) generally require only an
  initialization vector (such as IvParameterSpec),
  but GCM needs these parameters:

  IV: Initialization Vector (IV)
  tLen: length (in bits) of authentication tag T


  In addition to the parameters described here, other GCM inputs/output
  (Additional Authenticated Data (AAD), Keys, block ciphers,
  plain/ciphertext and authentication tags) are handled in the Cipher class.

  Please see  RFC 5116
   for more information on the Authenticated Encryption with
  Associated Data (AEAD) algorithm, and
  NIST Special Publication 800-38D, `NIST Recommendation for Block
  Cipher Modes of Operation:  Galois/Counter Mode (GCM) and GMAC.`

  The GCM specification states that tLen may only have the
  values {128, 120, 112, 104, 96}, or {64, 32} for certain
  applications.  Other values can be specified for this class, but not
  all CSP implementations will support them."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto.spec GCMParameterSpec]))

(defn ->gcm-parameter-spec
  "Constructor.

  Constructs a GCMParameterSpec object using the specified
   authentication tag bit-length and a subset of the specified
   buffer as the IV.

  t-len - the authentication tag length (in bits) - `int`
  src - the IV source buffer. The contents of the buffer are copied to protect against subsequent modification. - `byte[]`
  offset - the offset in src where the IV starts - `int`
  len - the number of IV bytes - `int`

  throws: java.lang.IllegalArgumentException - if tLen is negative, src is null, len or offset is negative, or the sum of offset and len is greater than the length of the src byte array."
  (^GCMParameterSpec [^Integer t-len src ^Integer offset ^Integer len]
    (new GCMParameterSpec t-len src offset len))
  (^GCMParameterSpec [^Integer t-len src]
    (new GCMParameterSpec t-len src)))

(defn get-t-len
  "Returns the authentication tag length.

  returns: the authentication tag length (in bits) - `int`"
  (^Integer [^GCMParameterSpec this]
    (-> this (.getTLen))))

(defn get-iv
  "Returns the Initialization Vector (IV).

  returns: the IV.  Creates a new array each time this method
   is called. - `byte[]`"
  ([^GCMParameterSpec this]
    (-> this (.getIV))))

