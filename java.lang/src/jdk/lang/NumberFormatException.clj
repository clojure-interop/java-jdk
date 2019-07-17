(ns jdk.lang.NumberFormatException
  "Thrown to indicate that the application has attempted to convert
  a string to one of the numeric types, but that the string does not
  have the appropriate format."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang NumberFormatException]))

(defn ->number-format-exception
  "Constructor.

  Constructs a NumberFormatException with the
   specified detail message.

  s - the detail message. - `java.lang.String`"
  ([s]
    (new NumberFormatException s))
  ([]
    (new NumberFormatException )))

