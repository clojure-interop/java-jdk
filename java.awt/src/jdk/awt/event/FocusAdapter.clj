(ns jdk.awt.event.FocusAdapter
  "An abstract adapter class for receiving keyboard focus events.
  The methods in this class are empty. This class exists as
  convenience for creating listener objects.

  Extend this class to create a FocusEvent listener
  and override the methods for the events of interest. (If you implement the
  FocusListener interface, you have to define all of
  the methods in it. This abstract class defines null methods for them
  all, so you can only have to define methods for events you care about.)

  Create a listener object using the extended class and then register it with
  a component using the component's addFocusListener
  method. When the component gains or loses the keyboard focus,
  the relevant method in the listener object is invoked,
  and the FocusEvent is passed to it."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event FocusAdapter]))

(defn ->focus-adapter
  "Constructor."
  (^FocusAdapter []
    (new FocusAdapter )))

(defn focus-gained
  "Invoked when a component gains the keyboard focus.

  e - `java.awt.event.FocusEvent`"
  ([^FocusAdapter this ^java.awt.event.FocusEvent e]
    (-> this (.focusGained e))))

(defn focus-lost
  "Invoked when a component loses the keyboard focus.

  e - `java.awt.event.FocusEvent`"
  ([^FocusAdapter this ^java.awt.event.FocusEvent e]
    (-> this (.focusLost e))))

