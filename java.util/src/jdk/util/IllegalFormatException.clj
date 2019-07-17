(ns jdk.util.IllegalFormatException
  "Unchecked exception thrown when a format string contains an illegal syntax
  or a format specifier that is incompatible with the given arguments.  Only
  explicit subtypes of this exception which correspond to specific errors
  should be instantiated."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util IllegalFormatException]))

