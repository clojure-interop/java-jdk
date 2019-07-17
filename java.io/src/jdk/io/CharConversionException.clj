(ns jdk.io.CharConversionException
  "Base class for character conversion exceptions."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io CharConversionException]))

(defn ->char-conversion-exception
  "Constructor.

  This provides a detailed message.

  s - the detailed message associated with the exception. - `java.lang.String`"
  ([s]
    (new CharConversionException s))
  ([]
    (new CharConversionException )))

