(ns jdk.awt.IllegalComponentStateException
  "Signals that an AWT component is not in an appropriate state for
  the requested operation."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt IllegalComponentStateException]))

(defn ->illegal-component-state-exception
  "Constructor.

  Constructs an IllegalComponentStateException with the specified detail
   message.  A detail message is a String that describes this particular
   exception.

  s - the String that contains a detailed message - `java.lang.String`"
  (^IllegalComponentStateException [^java.lang.String s]
    (new IllegalComponentStateException s))
  (^IllegalComponentStateException []
    (new IllegalComponentStateException )))

