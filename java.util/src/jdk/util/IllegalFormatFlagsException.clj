(ns jdk.util.IllegalFormatFlagsException
  "Unchecked exception thrown when an illegal combination flags is given.

   Unless otherwise specified, passing a null argument to any
  method or constructor in this class will cause a NullPointerException to be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util IllegalFormatFlagsException]))

(defn ->illegal-format-flags-exception
  "Constructor.

  Constructs an instance of this class with the specified flags.

  f - The set of format flags which contain an illegal combination - `java.lang.String`"
  (^IllegalFormatFlagsException [^java.lang.String f]
    (new IllegalFormatFlagsException f)))

(defn get-flags
  "Returns the set of flags which contains an illegal combination.

  returns: The flags - `java.lang.String`"
  (^java.lang.String [^IllegalFormatFlagsException this]
    (-> this (.getFlags))))

(defn get-message
  "Description copied from class: Throwable

  returns: the detail message string of this Throwable instance
            (which may be null). - `java.lang.String`"
  (^java.lang.String [^IllegalFormatFlagsException this]
    (-> this (.getMessage))))

