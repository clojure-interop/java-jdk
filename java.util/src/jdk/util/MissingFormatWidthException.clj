(ns jdk.util.MissingFormatWidthException
  "Unchecked exception thrown when the format width is required.

   Unless otherwise specified, passing a null argument to any
  method or constructor in this class will cause a NullPointerException to be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util MissingFormatWidthException]))

(defn ->missing-format-width-exception
  "Constructor.

  Constructs an instance of this class with the specified format
   specifier.

  s - The format specifier which does not have a width - `java.lang.String`"
  ([^java.lang.String s]
    (new MissingFormatWidthException s)))

(defn get-format-specifier
  "Returns the format specifier which does not have a width.

  returns: The format specifier which does not have a width - `java.lang.String`"
  (^java.lang.String [^java.util.MissingFormatWidthException this]
    (-> this (.getFormatSpecifier))))

(defn get-message
  "Description copied from class: Throwable

  returns: the detail message string of this Throwable instance
            (which may be null). - `java.lang.String`"
  (^java.lang.String [^java.util.MissingFormatWidthException this]
    (-> this (.getMessage))))

