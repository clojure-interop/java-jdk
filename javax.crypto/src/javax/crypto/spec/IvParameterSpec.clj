(ns javax.crypto.spec.IvParameterSpec
  "This class specifies an initialization vector (IV).
  Examples which use IVs are ciphers in feedback mode,
  e.g., DES in CBC mode and RSA ciphers with OAEP encoding
  operation."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto.spec IvParameterSpec]))

(defn ->iv-parameter-spec
  "Constructor.

  Creates an IvParameterSpec object using the first len
   bytes in iv, beginning at offset
   inclusive, as the IV.

    The bytes that constitute the IV are those between
   iv[offset] and iv[offset+len-1] inclusive.

  iv - the buffer with the IV. The first len bytes of the buffer beginning at offset inclusive are copied to protect against subsequent modification. - `byte[]`
  offset - the offset in iv where the IV starts. - `int`
  len - the number of IV bytes. - `int`

  throws: java.lang.IllegalArgumentException - if iv is null or (iv.length - offset < len)"
  ([iv ^Integer offset ^Integer len]
    (new IvParameterSpec iv offset len))
  ([iv]
    (new IvParameterSpec iv)))

(defn get-iv
  "Returns the initialization vector (IV).

  returns: the initialization vector (IV). Returns a new array
   each time this method is called. - `byte[]`"
  ([^javax.crypto.spec.IvParameterSpec this]
    (-> this (.getIV))))

