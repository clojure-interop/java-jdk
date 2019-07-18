(ns jdk.util.IllegalFormatPrecisionException
  "Unchecked exception thrown when the precision is a negative value other than
  -1, the conversion does not support a precision, or the value is
  otherwise unsupported."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util IllegalFormatPrecisionException]))

(defn ->illegal-format-precision-exception
  "Constructor.

  Constructs an instance of this class with the specified precision.

  p - The precision - `int`"
  (^IllegalFormatPrecisionException [^Integer p]
    (new IllegalFormatPrecisionException p)))

(defn get-precision
  "Returns the precision

  returns: The precision - `int`"
  (^Integer [^IllegalFormatPrecisionException this]
    (-> this (.getPrecision))))

(defn get-message
  "Description copied from class: Throwable

  returns: the detail message string of this Throwable instance
            (which may be null). - `java.lang.String`"
  (^java.lang.String [^IllegalFormatPrecisionException this]
    (-> this (.getMessage))))

