(ns javax.swing.event.HyperlinkEvent$EventType
  "Defines the ENTERED, EXITED, and ACTIVATED event types, along
  with their string representations, returned by toString()."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event HyperlinkEvent$EventType]))

(def *-entered
  "Static Constant.

  Entered type.

  type: javax.swing.event.HyperlinkEvent$EventType"
  HyperlinkEvent$EventType/ENTERED)

(def *-exited
  "Static Constant.

  Exited type.

  type: javax.swing.event.HyperlinkEvent$EventType"
  HyperlinkEvent$EventType/EXITED)

(def *-activated
  "Static Constant.

  Activated type.

  type: javax.swing.event.HyperlinkEvent$EventType"
  HyperlinkEvent$EventType/ACTIVATED)

(defn to-string
  "Converts the type to a string.

  returns: the string - `java.lang.String`"
  (^java.lang.String [^HyperlinkEvent$EventType this]
    (-> this (.toString))))

