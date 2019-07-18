(ns javax.crypto.spec.DESKeySpec
  "This class specifies a DES key."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto.spec DESKeySpec]))

(defn ->des-key-spec
  "Constructor.

  Creates a DESKeySpec object using the first 8 bytes in
   key, beginning at offset inclusive,
   as the key material for the DES key.

    The bytes that constitute the DES key are those between
   key[offset] and key[offset+7] inclusive.

  key - the buffer with the DES key material. The first 8 bytes of the buffer beginning at offset inclusive are copied to protect against subsequent modification. - `byte[]`
  offset - the offset in key, where the DES key material starts. - `int`

  throws: java.lang.NullPointerException - if the given key material is null"
  (^DESKeySpec [key ^Integer offset]
    (new DESKeySpec key offset))
  (^DESKeySpec [key]
    (new DESKeySpec key)))

(def *-des-key-len
  "Static Constant.

  The constant which defines the length of a DES key in bytes.

  type: int"
  DESKeySpec/DES_KEY_LEN)

(defn *parity-adjusted?
  "Checks if the given DES key material, starting at offset
   inclusive, is parity-adjusted.

  key - the buffer with the DES key material. - `byte[]`
  offset - the offset in key, where the DES key material starts. - `int`

  returns: true if the given DES key material is parity-adjusted, false
   otherwise. - `boolean`

  throws: java.security.InvalidKeyException - if the given key material is null, or starting at offset inclusive, is shorter than 8 bytes."
  (^Boolean [key ^Integer offset]
    (DESKeySpec/isParityAdjusted key offset)))

(defn *weak?
  "Checks if the given DES key material is weak or semi-weak.

  key - the buffer with the DES key material. - `byte[]`
  offset - the offset in key, where the DES key material starts. - `int`

  returns: true if the given DES key material is weak or semi-weak, false
   otherwise. - `boolean`

  throws: java.security.InvalidKeyException - if the given key material is null, or starting at offset inclusive, is shorter than 8 bytes."
  (^Boolean [key ^Integer offset]
    (DESKeySpec/isWeak key offset)))

(defn get-key
  "Returns the DES key material.

  returns: the DES key material. Returns a new array
   each time this method is called. - `byte[]`"
  ([^DESKeySpec this]
    (-> this (.getKey))))

