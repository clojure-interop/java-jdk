(ns jdk.awt.event.WindowAdapter
  "An abstract adapter class for receiving window events.
  The methods in this class are empty. This class exists as
  convenience for creating listener objects.

  Extend this class to create a WindowEvent listener
  and override the methods for the events of interest. (If you implement the
  WindowListener interface, you have to define all of
  the methods in it. This abstract class defines null methods for them
  all, so you can only have to define methods for events you care about.)

  Create a listener object using the extended class and then register it with
  a Window using the window's addWindowListener
  method. When the window's status changes by virtue of being opened,
  closed, activated or deactivated, iconified or deiconified,
  the relevant method in the listener
  object is invoked, and the WindowEvent is passed to it."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event WindowAdapter]))

(defn ->window-adapter
  "Constructor."
  ([]
    (new WindowAdapter )))

(defn window-opened
  "Invoked when a window has been opened.

  e - `java.awt.event.WindowEvent`"
  ([this e]
    (-> this (.windowOpened e))))

(defn window-state-changed
  "Invoked when a window state is changed.

  e - `java.awt.event.WindowEvent`"
  ([this e]
    (-> this (.windowStateChanged e))))

(defn window-gained-focus
  "Invoked when the Window is set to be the focused Window, which means
   that the Window, or one of its subcomponents, will receive keyboard
   events.

  e - `java.awt.event.WindowEvent`"
  ([this e]
    (-> this (.windowGainedFocus e))))

(defn window-closing
  "Invoked when a window is in the process of being closed.
   The close operation can be overridden at this point.

  e - `java.awt.event.WindowEvent`"
  ([this e]
    (-> this (.windowClosing e))))

(defn window-closed
  "Invoked when a window has been closed.

  e - `java.awt.event.WindowEvent`"
  ([this e]
    (-> this (.windowClosed e))))

(defn window-activated
  "Invoked when a window is activated.

  e - `java.awt.event.WindowEvent`"
  ([this e]
    (-> this (.windowActivated e))))

(defn window-iconified
  "Invoked when a window is iconified.

  e - `java.awt.event.WindowEvent`"
  ([this e]
    (-> this (.windowIconified e))))

(defn window-deactivated
  "Invoked when a window is de-activated.

  e - `java.awt.event.WindowEvent`"
  ([this e]
    (-> this (.windowDeactivated e))))

(defn window-lost-focus
  "Invoked when the Window is no longer the focused Window, which means
   that keyboard events will no longer be delivered to the Window or any of
   its subcomponents.

  e - `java.awt.event.WindowEvent`"
  ([this e]
    (-> this (.windowLostFocus e))))

(defn window-deiconified
  "Invoked when a window is de-iconified.

  e - `java.awt.event.WindowEvent`"
  ([this e]
    (-> this (.windowDeiconified e))))

