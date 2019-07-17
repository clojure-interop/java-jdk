(ns jdk.util.MissingFormatArgumentException
  "Unchecked exception thrown when there is a format specifier which does not
  have a corresponding argument or if an argument index refers to an argument
  that does not exist.

   Unless otherwise specified, passing a null argument to any
  method or constructor in this class will cause a NullPointerException to be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util MissingFormatArgumentException]))

(defn ->missing-format-argument-exception
  "Constructor.

  Constructs an instance of this class with the unmatched format
   specifier.

  s - Format specifier which does not have a corresponding argument - `java.lang.String`"
  ([^java.lang.String s]
    (new MissingFormatArgumentException s)))

(defn get-format-specifier
  "Returns the unmatched format specifier.

  returns: The unmatched format specifier - `java.lang.String`"
  ([^java.util.MissingFormatArgumentException this]
    (-> this (.getFormatSpecifier))))

(defn get-message
  "Description copied from class: Throwable

  returns: the detail message string of this Throwable instance
            (which may be null). - `java.lang.String`"
  ([^java.util.MissingFormatArgumentException this]
    (-> this (.getMessage))))

