(ns jdk.util.Base64$Encoder
  "This class implements an encoder for encoding byte data using
  the Base64 encoding scheme as specified in RFC 4648 and RFC 2045.

   Instances of Base64.Encoder class are safe for use by
  multiple concurrent threads.

   Unless otherwise noted, passing a null argument to
  a method of this class will cause a
  NullPointerException to
  be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Base64$Encoder]))

(defn encode
  "Encodes all bytes from the specified byte array using the
   Base64 encoding scheme, writing the resulting bytes to the
   given output byte array, starting at offset 0.

    It is the responsibility of the invoker of this method to make
   sure the output byte array dst has enough space for encoding
   all bytes from the input byte array. No bytes will be written to the
   output byte array if the output byte array is not big enough.

  src - the byte array to encode - `byte[]`
  dst - the output byte array - `byte[]`

  returns: The number of bytes written to the output byte array - `int`

  throws: java.lang.IllegalArgumentException - if dst does not have enough space for encoding all input bytes."
  (^Integer [^Base64$Encoder this src dst]
    (-> this (.encode src dst)))
  ([^Base64$Encoder this src]
    (-> this (.encode src))))

(defn encode-to-string
  "Encodes the specified byte array into a String using the Base64
   encoding scheme.

    This method first encodes all input bytes into a base64 encoded
   byte array and then constructs a new String by using the encoded byte
   array and the ISO-8859-1 charset.

    In other words, an invocation of this method has exactly the same
   effect as invoking
   new String(encode(src), StandardCharsets.ISO_8859_1).

  src - the byte array to encode - `byte[]`

  returns: A String containing the resulting Base64 encoded characters - `java.lang.String`"
  (^java.lang.String [^Base64$Encoder this src]
    (-> this (.encodeToString src))))

(defn wrap
  "Wraps an output stream for encoding byte data using the Base64
   encoding scheme.

    It is recommended to promptly close the returned output stream after
   use, during which it will flush all possible leftover bytes to the underlying
   output stream. Closing the returned output stream will close the underlying
   output stream.

  os - the output stream. - `java.io.OutputStream`

  returns: the output stream for encoding the byte data into the
            specified Base64 encoded format - `java.io.OutputStream`"
  (^java.io.OutputStream [^Base64$Encoder this ^java.io.OutputStream os]
    (-> this (.wrap os))))

(defn without-padding
  "Returns an encoder instance that encodes equivalently to this one,
   but without adding any padding character at the end of the encoded
   byte data.

    The encoding scheme of this encoder instance is unaffected by
   this invocation. The returned encoder instance should be used for
   non-padding encoding operation.

  returns: an equivalent encoder that encodes without adding any
           padding character at the end - `java.util.Base64$Encoder`"
  (^java.util.Base64$Encoder [^Base64$Encoder this]
    (-> this (.withoutPadding))))

