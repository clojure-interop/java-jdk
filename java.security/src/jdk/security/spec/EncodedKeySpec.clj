(ns jdk.security.spec.EncodedKeySpec
  "This class represents a public or private key in encoded format."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec EncodedKeySpec]))

(defn ->encoded-key-spec
  "Constructor.

  Creates a new EncodedKeySpec with the given encoded key.

  encoded-key - the encoded key. The contents of the array are copied to protect against subsequent modification. - `byte[]`

  throws: java.lang.NullPointerException - if encodedKey is null."
  ([encoded-key]
    (new EncodedKeySpec encoded-key)))

(defn get-encoded
  "Returns the encoded key.

  returns: the encoded key. Returns a new array each time
   this method is called. - `byte[]`"
  ([this]
    (-> this (.getEncoded))))

(defn get-format
  "Returns the name of the encoding format associated with this
   key specification.

   If the opaque representation of a key
   (see Key) can be transformed
   (see KeyFactory)
   into this key specification (or a subclass of it),
   getFormat called
   on the opaque key returns the same value as the
   getFormat method
   of this key specification.

  returns: a string representation of the encoding format. - `java.lang.String`"
  ([this]
    (-> this (.getFormat))))

