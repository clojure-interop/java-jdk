(ns javax.swing.event.InternalFrameListener
  "The listener interface for receiving internal frame events.
  This class is functionally equivalent to the WindowListener class
  in the AWT.

  See How to Write an Internal Frame Listener
  in The Java Tutorial for further documentation."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event InternalFrameListener]))

(defn internal-frame-opened
  "Invoked when a internal frame has been opened.

  e - `javax.swing.event.InternalFrameEvent`"
  ([this e]
    (-> this (.internalFrameOpened e))))

(defn internal-frame-closing
  "Invoked when an internal frame is in the process of being closed.
   The close operation can be overridden at this point.

  e - `javax.swing.event.InternalFrameEvent`"
  ([this e]
    (-> this (.internalFrameClosing e))))

(defn internal-frame-closed
  "Invoked when an internal frame has been closed.

  e - `javax.swing.event.InternalFrameEvent`"
  ([this e]
    (-> this (.internalFrameClosed e))))

(defn internal-frame-iconified
  "Invoked when an internal frame is iconified.

  e - `javax.swing.event.InternalFrameEvent`"
  ([this e]
    (-> this (.internalFrameIconified e))))

(defn internal-frame-deiconified
  "Invoked when an internal frame is de-iconified.

  e - `javax.swing.event.InternalFrameEvent`"
  ([this e]
    (-> this (.internalFrameDeiconified e))))

(defn internal-frame-activated
  "Invoked when an internal frame is activated.

  e - `javax.swing.event.InternalFrameEvent`"
  ([this e]
    (-> this (.internalFrameActivated e))))

(defn internal-frame-deactivated
  "Invoked when an internal frame is de-activated.

  e - `javax.swing.event.InternalFrameEvent`"
  ([this e]
    (-> this (.internalFrameDeactivated e))))

