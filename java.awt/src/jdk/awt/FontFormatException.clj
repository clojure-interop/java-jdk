(ns jdk.awt.FontFormatException
  "Thrown by method createFont in the Font class to indicate
  that the specified font is bad."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt FontFormatException]))

(defn ->font-format-exception
  "Constructor.

  Report a FontFormatException for the reason specified.

  reason - a String message indicating why the font is not accepted. - `java.lang.String`"
  ([reason]
    (new FontFormatException reason)))

