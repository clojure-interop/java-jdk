(ns jdk.util.IllegalFormatConversionException
  "Unchecked exception thrown when the argument corresponding to the format
  specifier is of an incompatible type.

   Unless otherwise specified, passing a null argument to any
  method or constructor in this class will cause a NullPointerException to be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util IllegalFormatConversionException]))

(defn ->illegal-format-conversion-exception
  "Constructor.

  Constructs an instance of this class with the mismatched conversion and
   the corresponding argument class.

  c - Inapplicable conversion - `char`
  arg - Class of the mismatched argument - `java.lang.Class<?>`"
  ([^Character c ^java.lang.Class arg]
    (new IllegalFormatConversionException c arg)))

(defn get-conversion
  "Returns the inapplicable conversion.

  returns: The inapplicable conversion - `char`"
  ([^java.util.IllegalFormatConversionException this]
    (-> this (.getConversion))))

(defn get-argument-class
  "Returns the class of the mismatched argument.

  returns: The class of the mismatched argument - `java.lang.Class<?>`"
  ([^java.util.IllegalFormatConversionException this]
    (-> this (.getArgumentClass))))

(defn get-message
  "Description copied from class: Throwable

  returns: the detail message string of this Throwable instance
            (which may be null). - `java.lang.String`"
  ([^java.util.IllegalFormatConversionException this]
    (-> this (.getMessage))))

