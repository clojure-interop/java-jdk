(ns jdk.awt.datatransfer.MimeTypeParseException
  "A class to encapsulate MimeType parsing related exceptions"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.datatransfer MimeTypeParseException]))

(defn ->mime-type-parse-exception
  "Constructor.

  Constructs a MimeTypeParseException with the specified detail message.

  s - the detail message. - `java.lang.String`"
  (^MimeTypeParseException [^java.lang.String s]
    (new MimeTypeParseException s))
  (^MimeTypeParseException []
    (new MimeTypeParseException )))

