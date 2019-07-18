(ns jdk.util.zip.DataFormatException
  "Signals that a data format error has occurred."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.zip DataFormatException]))

(defn ->data-format-exception
  "Constructor.

  Constructs a DataFormatException with the specified detail message.
   A detail message is a String that describes this particular exception.

  s - the String containing a detail message - `java.lang.String`"
  (^DataFormatException [^java.lang.String s]
    (new DataFormatException s))
  (^DataFormatException []
    (new DataFormatException )))

