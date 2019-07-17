(ns jdk.awt.dnd.DragSourceMotionListener
  "A listener interface for receiving mouse motion events during a drag
  operation.

  The class that is interested in processing mouse motion events during
  a drag operation either implements this interface or extends the abstract
  DragSourceAdapter class (overriding only the methods of
  interest).

  Create a listener object using that class and then register it with
  a DragSource. Whenever the mouse moves during a drag
  operation initiated with this DragSource, that object's
  dragMouseMoved method is invoked, and the
  DragSourceDragEvent is passed to it."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.dnd DragSourceMotionListener]))

(defn drag-mouse-moved
  "Called whenever the mouse is moved during a drag operation.

  dsde - the DragSourceDragEvent - `java.awt.dnd.DragSourceDragEvent`"
  ([^java.awt.dnd.DragSourceMotionListener this ^java.awt.dnd.DragSourceDragEvent dsde]
    (-> this (.dragMouseMoved dsde))))

