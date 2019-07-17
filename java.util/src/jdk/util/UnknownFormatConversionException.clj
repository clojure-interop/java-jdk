(ns jdk.util.UnknownFormatConversionException
  "Unchecked exception thrown when an unknown conversion is given.

   Unless otherwise specified, passing a null argument to
  any method or constructor in this class will cause a NullPointerException to be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util UnknownFormatConversionException]))

(defn ->unknown-format-conversion-exception
  "Constructor.

  Constructs an instance of this class with the unknown conversion.

  s - Unknown conversion - `java.lang.String`"
  ([s]
    (new UnknownFormatConversionException s)))

(defn get-conversion
  "Returns the unknown conversion.

  returns: The unknown conversion. - `java.lang.String`"
  ([this]
    (-> this (.getConversion))))

(defn get-message
  "Description copied from class: Throwable

  returns: the detail message string of this Throwable instance
            (which may be null). - `java.lang.String`"
  ([this]
    (-> this (.getMessage))))

