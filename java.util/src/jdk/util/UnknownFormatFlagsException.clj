(ns jdk.util.UnknownFormatFlagsException
  "Unchecked exception thrown when an unknown flag is given.

   Unless otherwise specified, passing a null argument to any
  method or constructor in this class will cause a NullPointerException to be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util UnknownFormatFlagsException]))

(defn ->unknown-format-flags-exception
  "Constructor.

  Constructs an instance of this class with the specified flags.

  f - The set of format flags which contain an unknown flag - `java.lang.String`"
  ([^java.lang.String f]
    (new UnknownFormatFlagsException f)))

(defn get-flags
  "Returns the set of flags which contains an unknown flag.

  returns: The flags - `java.lang.String`"
  (^java.lang.String [^java.util.UnknownFormatFlagsException this]
    (-> this (.getFlags))))

(defn get-message
  "Description copied from class: Throwable

  returns: the detail message string of this Throwable instance
            (which may be null). - `java.lang.String`"
  (^java.lang.String [^java.util.UnknownFormatFlagsException this]
    (-> this (.getMessage))))

