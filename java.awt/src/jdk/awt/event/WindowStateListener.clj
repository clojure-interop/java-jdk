(ns jdk.awt.event.WindowStateListener
  "The listener interface for receiving window state events.

  The class that is interested in processing a window state event
  either implements this interface (and all the methods it contains)
  or extends the abstract WindowAdapter class
  (overriding only the methods of interest).

  The listener object created from that class is then registered with
  a window using the Window's
  addWindowStateListener method.  When the window's
  state changes by virtue of being iconified, maximized etc., the
  windowStateChanged method in the listener object is
  invoked, and the WindowEvent is passed to it."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event WindowStateListener]))

(defn window-state-changed
  "Invoked when window state is changed.

  e - `java.awt.event.WindowEvent`"
  ([^. this ^java.awt.event.WindowEvent e]
    (-> this (.windowStateChanged e))))

