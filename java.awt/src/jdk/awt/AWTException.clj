(ns jdk.awt.AWTException
  "Signals that an Abstract Window Toolkit exception has occurred."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt AWTException]))

(defn ->awt-exception
  "Constructor.

  Constructs an instance of AWTException with the
   specified detail message. A detail message is an
   instance of String that describes this particular
   exception.

  msg - the detail message - `java.lang.String`"
  ([^java.lang.String msg]
    (new AWTException msg)))

