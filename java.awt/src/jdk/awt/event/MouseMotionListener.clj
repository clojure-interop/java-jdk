(ns jdk.awt.event.MouseMotionListener
  "The listener interface for receiving mouse motion events on a component.
  (For clicks and other mouse events, use the MouseListener.)

  The class that is interested in processing a mouse motion event
  either implements this interface (and all the methods it
  contains) or extends the abstract MouseMotionAdapter class
  (overriding only the methods of interest).

  The listener object created from that class is then registered with a
  component using the component's addMouseMotionListener
  method. A mouse motion event is generated when the mouse is moved
  or dragged. (Many such events will be generated). When a mouse motion event
  occurs, the relevant method in the listener object is invoked, and
  the MouseEvent is passed to it."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event MouseMotionListener]))

(defn mouse-dragged
  "Invoked when a mouse button is pressed on a component and then
   dragged.  MOUSE_DRAGGED events will continue to be
   delivered to the component where the drag originated until the
   mouse button is released (regardless of whether the mouse position
   is within the bounds of the component).

   Due to platform-dependent Drag&Drop implementations,
   MOUSE_DRAGGED events may not be delivered during a native
   Drag&Drop operation.

  e - `java.awt.event.MouseEvent`"
  ([this e]
    (-> this (.mouseDragged e))))

(defn mouse-moved
  "Invoked when the mouse cursor has been moved onto a component
   but no buttons have been pushed.

  e - `java.awt.event.MouseEvent`"
  ([this e]
    (-> this (.mouseMoved e))))

