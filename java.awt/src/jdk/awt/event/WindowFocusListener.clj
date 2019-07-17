(ns jdk.awt.event.WindowFocusListener
  "The listener interface for receiving WindowEvents, including
  WINDOW_GAINED_FOCUS and WINDOW_LOST_FOCUS events.
  The class that is interested in processing a WindowEvent
  either implements this interface (and
  all the methods it contains) or extends the abstract
  WindowAdapter class (overriding only the methods of interest).
  The listener object created from that class is then registered with a
  Window
  using the Window's addWindowFocusListener method.
  When the Window's
  status changes by virtue of it being opened, closed, activated, deactivated,
  iconified, or deiconified, or by focus being transfered into or out of the
  Window, the relevant method in the listener object is invoked,
  and the WindowEvent is passed to it."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event WindowFocusListener]))

(defn window-gained-focus
  "Invoked when the Window is set to be the focused Window, which means
   that the Window, or one of its subcomponents, will receive keyboard
   events.

  e - `java.awt.event.WindowEvent`"
  ([this e]
    (-> this (.windowGainedFocus e))))

(defn window-lost-focus
  "Invoked when the Window is no longer the focused Window, which means
   that keyboard events will no longer be delivered to the Window or any of
   its subcomponents.

  e - `java.awt.event.WindowEvent`"
  ([this e]
    (-> this (.windowLostFocus e))))

