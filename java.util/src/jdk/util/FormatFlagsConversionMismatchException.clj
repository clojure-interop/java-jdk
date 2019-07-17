(ns jdk.util.FormatFlagsConversionMismatchException
  "Unchecked exception thrown when a conversion and flag are incompatible.

   Unless otherwise specified, passing a null argument to any
  method or constructor in this class will cause a NullPointerException to be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util FormatFlagsConversionMismatchException]))

(defn ->format-flags-conversion-mismatch-exception
  "Constructor.

  Constructs an instance of this class with the specified flag
   and conversion.

  f - The flag - `java.lang.String`
  c - The conversion - `char`"
  ([^java.lang.String f ^Character c]
    (new FormatFlagsConversionMismatchException f c)))

(defn get-flags
  "Returns the incompatible flag.

  returns: The flag - `java.lang.String`"
  ([^java.util.FormatFlagsConversionMismatchException this]
    (-> this (.getFlags))))

(defn get-conversion
  "Returns the incompatible conversion.

  returns: The conversion - `char`"
  ([^java.util.FormatFlagsConversionMismatchException this]
    (-> this (.getConversion))))

(defn get-message
  "Description copied from class: Throwable

  returns: the detail message string of this Throwable instance
            (which may be null). - `java.lang.String`"
  ([^java.util.FormatFlagsConversionMismatchException this]
    (-> this (.getMessage))))

