(ns jdk.awt.event.WindowListener
  "The listener interface for receiving window events.
  The class that is interested in processing a window event
  either implements this interface (and all the methods it
  contains) or extends the abstract WindowAdapter class
  (overriding only the methods of interest).
  The listener object created from that class is then registered with a
  Window using the window's addWindowListener
  method. When the window's status changes by virtue of being opened,
  closed, activated or deactivated, iconified or deiconified,
  the relevant method in the listener object is invoked, and the
  WindowEvent is passed to it."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event WindowListener]))

(defn window-opened
  "Invoked the first time a window is made visible.

  e - `java.awt.event.WindowEvent`"
  ([this e]
    (-> this (.windowOpened e))))

(defn window-closing
  "Invoked when the user attempts to close the window
   from the window's system menu.

  e - `java.awt.event.WindowEvent`"
  ([this e]
    (-> this (.windowClosing e))))

(defn window-closed
  "Invoked when a window has been closed as the result
   of calling dispose on the window.

  e - `java.awt.event.WindowEvent`"
  ([this e]
    (-> this (.windowClosed e))))

(defn window-iconified
  "Invoked when a window is changed from a normal to a
   minimized state. For many platforms, a minimized window
   is displayed as the icon specified in the window's
   iconImage property.

  e - `java.awt.event.WindowEvent`"
  ([this e]
    (-> this (.windowIconified e))))

(defn window-deiconified
  "Invoked when a window is changed from a minimized
   to a normal state.

  e - `java.awt.event.WindowEvent`"
  ([this e]
    (-> this (.windowDeiconified e))))

(defn window-activated
  "Invoked when the Window is set to be the active Window. Only a Frame or
   a Dialog can be the active Window. The native windowing system may
   denote the active Window or its children with special decorations, such
   as a highlighted title bar. The active Window is always either the
   focused Window, or the first Frame or Dialog that is an owner of the
   focused Window.

  e - `java.awt.event.WindowEvent`"
  ([this e]
    (-> this (.windowActivated e))))

(defn window-deactivated
  "Invoked when a Window is no longer the active Window. Only a Frame or a
   Dialog can be the active Window. The native windowing system may denote
   the active Window or its children with special decorations, such as a
   highlighted title bar. The active Window is always either the focused
   Window, or the first Frame or Dialog that is an owner of the focused
   Window.

  e - `java.awt.event.WindowEvent`"
  ([this e]
    (-> this (.windowDeactivated e))))

