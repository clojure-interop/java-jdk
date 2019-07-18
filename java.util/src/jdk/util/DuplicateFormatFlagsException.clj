(ns jdk.util.DuplicateFormatFlagsException
  "Unchecked exception thrown when duplicate flags are provided in the format
  specifier.

   Unless otherwise specified, passing a null argument to any
  method or constructor in this class will cause a NullPointerException to be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util DuplicateFormatFlagsException]))

(defn ->duplicate-format-flags-exception
  "Constructor.

  Constructs an instance of this class with the specified flags.

  f - The set of format flags which contain a duplicate flag. - `java.lang.String`"
  (^DuplicateFormatFlagsException [^java.lang.String f]
    (new DuplicateFormatFlagsException f)))

(defn get-flags
  "Returns the set of flags which contains a duplicate flag.

  returns: The flags - `java.lang.String`"
  (^java.lang.String [^DuplicateFormatFlagsException this]
    (-> this (.getFlags))))

(defn get-message
  "Description copied from class: Throwable

  returns: the detail message string of this Throwable instance
            (which may be null). - `java.lang.String`"
  (^java.lang.String [^DuplicateFormatFlagsException this]
    (-> this (.getMessage))))

