(ns javax.activation.MimeTypeParseException
  "A class to encapsulate MimeType parsing related exceptions."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.activation MimeTypeParseException]))

(defn ->mime-type-parse-exception
  "Constructor.

  Constructs a MimeTypeParseException with the specified detail message.

  s - the detail message. - `java.lang.String`"
  ([^java.lang.String s]
    (new MimeTypeParseException s))
  ([]
    (new MimeTypeParseException )))

