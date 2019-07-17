(ns jdk.nio.charset.IllegalCharsetNameException
  "Unchecked exception thrown when a string that is not a
  legal charset name is used as such."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.charset IllegalCharsetNameException]))

(defn ->illegal-charset-name-exception
  "Constructor.

  Constructs an instance of this class.

  charset-name - The illegal charset name - `java.lang.String`"
  ([^java.lang.String charset-name]
    (new IllegalCharsetNameException charset-name)))

(defn get-charset-name
  "Retrieves the illegal charset name.

  returns: The illegal charset name - `java.lang.String`"
  ([^java.nio.charset.IllegalCharsetNameException this]
    (-> this (.getCharsetName))))

