(ns jdk.util.Base64
  "This class consists exclusively of static methods for obtaining
  encoders and decoders for the Base64 encoding scheme. The
  implementation of this class supports the following types of Base64
  as specified in
  RFC 4648 and
  RFC 2045.


  Basic
   Uses `The Base64 Alphabet` as specified in Table 1 of
      RFC 4648 and RFC 2045 for encoding and decoding operation.
      The encoder does not add any line feed (line separator)
      character. The decoder rejects data that contains characters
      outside the base64 alphabet.

  URL and Filename safe
   Uses the `URL and Filename safe Base64 Alphabet` as specified
      in Table 2 of RFC 4648 for encoding and decoding. The
      encoder does not add any line feed (line separator) character.
      The decoder rejects data that contains characters outside the
      base64 alphabet.

  MIME
   Uses the `The Base64 Alphabet` as specified in Table 1 of
      RFC 2045 for encoding and decoding operation. The encoded output
      must be represented in lines of no more than 76 characters each
      and uses a carriage return '\r' followed immediately by
      a linefeed '\n' as the line separator. No line separator
      is added to the end of the encoded output. All line separators
      or other characters not found in the base64 alphabet table are
      ignored in decoding operation.


   Unless otherwise noted, passing a null argument to a
  method of this class will cause a NullPointerException to be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Base64]))

(defn *get-encoder
  "Returns a Base64.Encoder that encodes using the
   Basic type base64 encoding scheme.

  returns: A Base64 encoder. - `java.util.Base64$Encoder`"
  (^java.util.Base64$Encoder []
    (Base64/getEncoder )))

(defn *get-url-encoder
  "Returns a Base64.Encoder that encodes using the
   URL and Filename safe type base64
   encoding scheme.

  returns: A Base64 encoder. - `java.util.Base64$Encoder`"
  (^java.util.Base64$Encoder []
    (Base64/getUrlEncoder )))

(defn *get-mime-encoder
  "Returns a Base64.Encoder that encodes using the
   MIME type base64 encoding scheme
   with specified line length and line separators.

  line-length - the length of each output line (rounded down to nearest multiple of 4). If lineLength <= 0 the output will not be separated in lines - `int`
  line-separator - the line separator for each output line - `byte[]`

  returns: A Base64 encoder. - `java.util.Base64$Encoder`

  throws: java.lang.IllegalArgumentException - if lineSeparator includes any character of `The Base64 Alphabet` as specified in Table 1 of RFC 2045."
  (^java.util.Base64$Encoder [^Integer line-length line-separator]
    (Base64/getMimeEncoder line-length line-separator))
  (^java.util.Base64$Encoder []
    (Base64/getMimeEncoder )))

(defn *get-decoder
  "Returns a Base64.Decoder that decodes using the
   Basic type base64 encoding scheme.

  returns: A Base64 decoder. - `java.util.Base64$Decoder`"
  (^java.util.Base64$Decoder []
    (Base64/getDecoder )))

(defn *get-url-decoder
  "Returns a Base64.Decoder that decodes using the
   URL and Filename safe type base64
   encoding scheme.

  returns: A Base64 decoder. - `java.util.Base64$Decoder`"
  (^java.util.Base64$Decoder []
    (Base64/getUrlDecoder )))

(defn *get-mime-decoder
  "Returns a Base64.Decoder that decodes using the
   MIME type base64 decoding scheme.

  returns: A Base64 decoder. - `java.util.Base64$Decoder`"
  (^java.util.Base64$Decoder []
    (Base64/getMimeDecoder )))

