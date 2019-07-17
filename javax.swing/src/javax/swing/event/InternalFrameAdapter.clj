(ns javax.swing.event.InternalFrameAdapter
  "An abstract adapter class for receiving internal frame events.
  The methods in this class are empty. This class exists as
  convenience for creating listener objects, and is functionally
  equivalent to the WindowAdapter class in the AWT.

  See How to Write an Internal Frame Listener
  in The Java Tutorial"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event InternalFrameAdapter]))

(defn ->internal-frame-adapter
  "Constructor."
  ([]
    (new InternalFrameAdapter )))

(defn internal-frame-opened
  "Invoked when an internal frame has been opened.

  e - `javax.swing.event.InternalFrameEvent`"
  ([^javax.swing.event.InternalFrameAdapter this ^javax.swing.event.InternalFrameEvent e]
    (-> this (.internalFrameOpened e))))

(defn internal-frame-closing
  "Invoked when an internal frame is in the process of being closed.
   The close operation can be overridden at this point.

  e - `javax.swing.event.InternalFrameEvent`"
  ([^javax.swing.event.InternalFrameAdapter this ^javax.swing.event.InternalFrameEvent e]
    (-> this (.internalFrameClosing e))))

(defn internal-frame-closed
  "Invoked when an internal frame has been closed.

  e - `javax.swing.event.InternalFrameEvent`"
  ([^javax.swing.event.InternalFrameAdapter this ^javax.swing.event.InternalFrameEvent e]
    (-> this (.internalFrameClosed e))))

(defn internal-frame-iconified
  "Invoked when an internal frame is iconified.

  e - `javax.swing.event.InternalFrameEvent`"
  ([^javax.swing.event.InternalFrameAdapter this ^javax.swing.event.InternalFrameEvent e]
    (-> this (.internalFrameIconified e))))

(defn internal-frame-deiconified
  "Invoked when an internal frame is de-iconified.

  e - `javax.swing.event.InternalFrameEvent`"
  ([^javax.swing.event.InternalFrameAdapter this ^javax.swing.event.InternalFrameEvent e]
    (-> this (.internalFrameDeiconified e))))

(defn internal-frame-activated
  "Invoked when an internal frame is activated.

  e - `javax.swing.event.InternalFrameEvent`"
  ([^javax.swing.event.InternalFrameAdapter this ^javax.swing.event.InternalFrameEvent e]
    (-> this (.internalFrameActivated e))))

(defn internal-frame-deactivated
  "Invoked when an internal frame is de-activated.

  e - `javax.swing.event.InternalFrameEvent`"
  ([^javax.swing.event.InternalFrameAdapter this ^javax.swing.event.InternalFrameEvent e]
    (-> this (.internalFrameDeactivated e))))

