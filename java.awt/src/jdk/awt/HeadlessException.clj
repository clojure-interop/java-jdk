(ns jdk.awt.HeadlessException
  "Thrown when code that is dependent on a keyboard, display, or mouse
  is called in an environment that does not support a keyboard, display,
  or mouse."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt HeadlessException]))

(defn ->headless-exception
  "Constructor.

  msg - `java.lang.String`"
  ([msg]
    (new HeadlessException msg))
  ([]
    (new HeadlessException )))

(defn get-message
  "Description copied from class: Throwable

  returns: the detail message string of this Throwable instance
            (which may be null). - `java.lang.String`"
  ([this]
    (-> this (.getMessage))))

