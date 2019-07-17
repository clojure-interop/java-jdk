(ns jdk.awt.event.FocusListener
  "The listener interface for receiving keyboard focus events on
  a component.
  The class that is interested in processing a focus event
  either implements this interface (and all the methods it
  contains) or extends the abstract FocusAdapter class
  (overriding only the methods of interest).
  The listener object created from that class is then registered with a
  component using the component's addFocusListener
  method. When the component gains or loses the keyboard focus,
  the relevant method in the listener object
  is invoked, and the FocusEvent is passed to it."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event FocusListener]))

(defn focus-gained
  "Invoked when a component gains the keyboard focus.

  e - `java.awt.event.FocusEvent`"
  ([^java.awt.event.FocusListener this ^java.awt.event.FocusEvent e]
    (-> this (.focusGained e))))

(defn focus-lost
  "Invoked when a component loses the keyboard focus.

  e - `java.awt.event.FocusEvent`"
  ([^java.awt.event.FocusListener this ^java.awt.event.FocusEvent e]
    (-> this (.focusLost e))))

