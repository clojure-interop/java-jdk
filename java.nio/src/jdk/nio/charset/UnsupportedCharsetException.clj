(ns jdk.nio.charset.UnsupportedCharsetException
  "Unchecked exception thrown when no support is available
  for a requested charset."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.charset UnsupportedCharsetException]))

(defn ->unsupported-charset-exception
  "Constructor.

  Constructs an instance of this class.

  charset-name - The name of the unsupported charset - `java.lang.String`"
  (^UnsupportedCharsetException [^java.lang.String charset-name]
    (new UnsupportedCharsetException charset-name)))

(defn get-charset-name
  "Retrieves the name of the unsupported charset.

  returns: The name of the unsupported charset - `java.lang.String`"
  (^java.lang.String [^UnsupportedCharsetException this]
    (-> this (.getCharsetName))))

