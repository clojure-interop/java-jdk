(ns jdk.util.IllegalFormatWidthException
  "Unchecked exception thrown when the format width is a negative value other
  than -1 or is otherwise unsupported."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util IllegalFormatWidthException]))

(defn ->illegal-format-width-exception
  "Constructor.

  Constructs an instance of this class with the specified width.

  w - The width - `int`"
  (^IllegalFormatWidthException [^Integer w]
    (new IllegalFormatWidthException w)))

(defn get-width
  "Returns the width

  returns: The width - `int`"
  (^Integer [^IllegalFormatWidthException this]
    (-> this (.getWidth))))

(defn get-message
  "Description copied from class: Throwable

  returns: the detail message string of this Throwable instance
            (which may be null). - `java.lang.String`"
  (^java.lang.String [^IllegalFormatWidthException this]
    (-> this (.getMessage))))

