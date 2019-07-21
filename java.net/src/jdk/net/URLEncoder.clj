(ns jdk.net.URLEncoder
  "Utility class for HTML form encoding. This class contains static methods
  for converting a String to the application/x-www-form-urlencoded MIME
  format. For more information about HTML form encoding, consult the HTML
  specification.


  When encoding a String, the following rules apply:


  The alphanumeric characters \"a\" through
      \"z\", \"A\" through
      \"Z\" and \"0\"
      through \"9\" remain the same.
  The special characters \".\",
      \"-\", \"*\", and
      \"_\" remain the same.
  The space character \"   \" is
      converted into a plus sign \"+\".
  All other characters are unsafe and are first converted into
      one or more bytes using some encoding scheme. Then each byte is
      represented by the 3-character string
      \"%xy\", where xy is the
      two-digit hexadecimal representation of the byte.
      The recommended encoding scheme to use is UTF-8. However,
      for compatibility reasons, if an encoding is not specified,
      then the default encoding of the platform is used.



  For example using UTF-8 as the encoding scheme the string \"The
  string ü@foo-bar\" would get converted to
  \"The+string+%C3%BC%40foo-bar\" because in UTF-8 the character
  ü is encoded as two bytes C3 (hex) and BC (hex), and the
  character @ is encoded as one byte 40 (hex)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net URLEncoder]))

(defn *encode
  "Translates a string into application/x-www-form-urlencoded
   format using a specific encoding scheme. This method uses the
   supplied encoding scheme to obtain the bytes for unsafe
   characters.

   Note: The
   World Wide Web Consortium Recommendation states that
   UTF-8 should be used. Not doing so may introduce
   incompatibilities.

  s - String to be translated. - `java.lang.String`
  enc - The name of a supported character encoding. - `java.lang.String`

  returns: the translated String. - `java.lang.String`

  throws: java.io.UnsupportedEncodingException - If the named encoding is not supported"
  (^java.lang.String [^java.lang.String s ^java.lang.String enc]
    (URLEncoder/encode s enc))
  (^java.lang.String [^java.lang.String s]
    (URLEncoder/encode s)))

