(ns jdk.io.UnsupportedEncodingException
  "The Character Encoding is not supported."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io UnsupportedEncodingException]))

(defn ->unsupported-encoding-exception
  "Constructor.

  Constructs an UnsupportedEncodingException with a detail message.

  s - Describes the reason for the exception. - `java.lang.String`"
  ([^java.lang.String s]
    (new UnsupportedEncodingException s))
  ([]
    (new UnsupportedEncodingException )))

