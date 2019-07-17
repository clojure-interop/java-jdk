(ns jdk.awt.event.MouseMotionAdapter
  "An abstract adapter class for receiving mouse motion events.
  The methods in this class are empty. This class exists as
  convenience for creating listener objects.

  Mouse motion events occur when a mouse is moved or dragged.
  (Many such events will be generated in a normal program.
  To track clicks and other mouse events, use the MouseAdapter.)

  Extend this class to create a MouseEvent listener
  and override the methods for the events of interest. (If you implement the
  MouseMotionListener interface, you have to define all of
  the methods in it. This abstract class defines null methods for them
  all, so you can only have to define methods for events you care about.)

  Create a listener object using the extended class and then register it with
  a component using the component's addMouseMotionListener
  method. When the mouse is moved or dragged, the relevant method in the
  listener object is invoked and the MouseEvent is passed to it."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event MouseMotionAdapter]))

(defn ->mouse-motion-adapter
  "Constructor."
  ([]
    (new MouseMotionAdapter )))

(defn mouse-dragged
  "Invoked when a mouse button is pressed on a component and then
   dragged.  Mouse drag events will continue to be delivered to
   the component where the first originated until the mouse button is
   released (regardless of whether the mouse position is within the
   bounds of the component).

  e - `java.awt.event.MouseEvent`"
  ([this e]
    (-> this (.mouseDragged e))))

(defn mouse-moved
  "Invoked when the mouse button has been moved on a component
   (with no buttons no down).

  e - `java.awt.event.MouseEvent`"
  ([this e]
    (-> this (.mouseMoved e))))

