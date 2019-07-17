(ns jdk.awt.dnd.DragGestureListener
  "The listener interface for receiving drag gesture events.
  This interface is intended for a drag gesture recognition
  implementation. See a specification for DragGestureRecognizer
  for details on how to register the listener interface.
  Upon recognition of a drag gesture the DragGestureRecognizer calls this interface's
  dragGestureRecognized()
  method and passes a DragGestureEvent."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.dnd DragGestureListener]))

(defn drag-gesture-recognized
  "This method is invoked by the DragGestureRecognizer
   when the DragGestureRecognizer detects a platform-dependent
   drag initiating gesture. To initiate the drag and drop operation,
   if appropriate, startDrag() method on
   the DragGestureEvent has to be invoked.

  dge - the DragGestureEvent describing the gesture that has just occurred - `java.awt.dnd.DragGestureEvent`"
  ([^. this ^java.awt.dnd.DragGestureEvent dge]
    (-> this (.dragGestureRecognized dge))))

