(ns javax.annotation.processing.FilerException
  "Indicates a Filer detected an attempt to open a file that
  would violate the guarantees provided by the Filer.  Those
  guarantees include not creating the same file more than once, not
  creating multiple files corresponding to the same type, and not
  creating files for types with invalid names."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.annotation.processing FilerException]))

(defn ->filer-exception
  "Constructor.

  Constructs an exception with the specified detail message.

  s - the detail message, which should include the name of the file attempting to be opened; may be null - `java.lang.String`"
  ([^java.lang.String s]
    (new FilerException s)))

