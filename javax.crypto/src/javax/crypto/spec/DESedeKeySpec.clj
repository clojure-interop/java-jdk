(ns javax.crypto.spec.DESedeKeySpec
  "This class specifies a DES-EDE (`triple-DES`) key."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto.spec DESedeKeySpec]))

(defn ->de-sede-key-spec
  "Constructor.

  Creates a DESedeKeySpec object using the first 24 bytes in
   key, beginning at offset inclusive,
   as the key material for the DES-EDE key.

    The bytes that constitute the DES-EDE key are those between
   key[offset] and key[offset+23] inclusive.

  key - the buffer with the DES-EDE key material. The first 24 bytes of the buffer beginning at offset inclusive are copied to protect against subsequent modification. - `byte[]`
  offset - the offset in key, where the DES-EDE key material starts. - `int`

  throws: java.lang.NullPointerException - if key is null."
  (^DESedeKeySpec [key ^Integer offset]
    (new DESedeKeySpec key offset))
  (^DESedeKeySpec [key]
    (new DESedeKeySpec key)))

(def *-des-ede-key-len
  "Static Constant.

  The constant which defines the length of a DESede key in bytes.

  type: int"
  DESedeKeySpec/DES_EDE_KEY_LEN)

(defn *parity-adjusted?
  "Checks if the given DES-EDE key, starting at offset
   inclusive, is parity-adjusted.

  key - a byte array which holds the key value - `byte[]`
  offset - the offset into the byte array - `int`

  returns: true if the given DES-EDE key is parity-adjusted, false
   otherwise - `boolean`

  throws: java.lang.NullPointerException - if key is null."
  (^Boolean [key ^Integer offset]
    (DESedeKeySpec/isParityAdjusted key offset)))

(defn get-key
  "Returns the DES-EDE key.

  returns: the DES-EDE key. Returns a new array
   each time this method is called. - `byte[]`"
  ([^DESedeKeySpec this]
    (-> this (.getKey))))

