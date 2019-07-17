(ns jdk.awt.AWTError
  "Thrown when a serious Abstract Window Toolkit error has occurred."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt AWTError]))

(defn ->awt-error
  "Constructor.

  Constructs an instance of AWTError with the specified
   detail message.

  msg - the detail message. - `java.lang.String`"
  ([^java.lang.String msg]
    (new AWTError msg)))

