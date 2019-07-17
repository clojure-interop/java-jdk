(ns jdk.lang.NoSuchFieldException
  "Signals that the class doesn't have a field of a specified name."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang NoSuchFieldException]))

(defn ->no-such-field-exception
  "Constructor.

  Constructor with a detail message.

  s - the detail message - `java.lang.String`"
  ([^java.lang.String s]
    (new NoSuchFieldException s))
  ([]
    (new NoSuchFieldException )))

