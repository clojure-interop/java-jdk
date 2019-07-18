(ns jdk.util.Base64$Decoder
  "This class implements a decoder for decoding byte data using the
  Base64 encoding scheme as specified in RFC 4648 and RFC 2045.

   The Base64 padding character '=' is accepted and
  interpreted as the end of the encoded byte data, but is not
  required. So if the final unit of the encoded byte data only has
  two or three Base64 characters (without the corresponding padding
  character(s) padded), they are decoded as if followed by padding
  character(s). If there is a padding character present in the
  final unit, the correct number of padding character(s) must be
  present, otherwise IllegalArgumentException (
  IOException when reading from a Base64 stream) is thrown
  during decoding.

   Instances of Base64.Decoder class are safe for use by
  multiple concurrent threads.

   Unless otherwise noted, passing a null argument to
  a method of this class will cause a
  NullPointerException to
  be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Base64$Decoder]))

(defn decode
  "Decodes all bytes from the input byte array using the Base64
   encoding scheme, writing the results into the given output byte array,
   starting at offset 0.

    It is the responsibility of the invoker of this method to make
   sure the output byte array dst has enough space for decoding
   all bytes from the input byte array. No bytes will be be written to
   the output byte array if the output byte array is not big enough.

    If the input byte array is not in valid Base64 encoding scheme
   then some bytes may have been written to the output byte array before
   IllegalargumentException is thrown.

  src - the byte array to decode - `byte[]`
  dst - the output byte array - `byte[]`

  returns: The number of bytes written to the output byte array - `int`

  throws: java.lang.IllegalArgumentException - if src is not in valid Base64 scheme, or dst does not have enough space for decoding all input bytes."
  (^Integer [^Base64$Decoder this src dst]
    (-> this (.decode src dst)))
  ([^Base64$Decoder this src]
    (-> this (.decode src))))

(defn wrap
  "Returns an input stream for decoding Base64 encoded byte stream.

    The read  methods of the returned InputStream will
   throw IOException when reading bytes that cannot be decoded.

    Closing the returned input stream will close the underlying
   input stream.

  is - the input stream - `java.io.InputStream`

  returns: the input stream for decoding the specified Base64 encoded
            byte stream - `java.io.InputStream`"
  (^java.io.InputStream [^Base64$Decoder this ^java.io.InputStream is]
    (-> this (.wrap is))))

