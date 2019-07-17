(ns jdk.awt.event.InputMethodListener
  "The listener interface for receiving input method events. A text editing
  component has to install an input method event listener in order to work
  with input methods.


  The text editing component also has to provide an instance of InputMethodRequests."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event InputMethodListener]))

(defn input-method-text-changed
  "Invoked when the text entered through an input method has changed.

  event - `java.awt.event.InputMethodEvent`"
  ([this event]
    (-> this (.inputMethodTextChanged event))))

(defn caret-position-changed
  "Invoked when the caret within composed text has changed.

  event - `java.awt.event.InputMethodEvent`"
  ([this event]
    (-> this (.caretPositionChanged event))))

