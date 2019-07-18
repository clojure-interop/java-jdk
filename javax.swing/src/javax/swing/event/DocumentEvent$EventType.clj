(ns javax.swing.event.DocumentEvent$EventType
  "Enumeration for document event types"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event DocumentEvent$EventType]))

(def *-insert
  "Static Constant.

  Insert type.

  type: javax.swing.event.DocumentEvent$EventType"
  DocumentEvent$EventType/INSERT)

(def *-remove
  "Static Constant.

  Remove type.

  type: javax.swing.event.DocumentEvent$EventType"
  DocumentEvent$EventType/REMOVE)

(def *-change
  "Static Constant.

  Change type.

  type: javax.swing.event.DocumentEvent$EventType"
  DocumentEvent$EventType/CHANGE)

(defn to-string
  "Converts the type to a string.

  returns: the string - `java.lang.String`"
  (^java.lang.String [^DocumentEvent$EventType this]
    (-> this (.toString))))

