(ns jdk.awt.event.MouseAdapter
  "An abstract adapter class for receiving mouse events.
  The methods in this class are empty. This class exists as
  convenience for creating listener objects.

  Mouse events let you track when a mouse is pressed, released, clicked,
  moved, dragged, when it enters a component, when it exits and
  when a mouse wheel is moved.

  Extend this class to create a MouseEvent
  (including drag and motion events) or/and MouseWheelEvent
  listener and override the methods for the events of interest. (If you implement the
  MouseListener,
  MouseMotionListener
  interface, you have to define all of
  the methods in it. This abstract class defines null methods for them
  all, so you can only have to define methods for events you care about.)

  Create a listener object using the extended class and then register it with
  a component using the component's addMouseListener
  addMouseMotionListener, addMouseWheelListener
  methods.
  The relevant method in the listener object is invoked  and the MouseEvent
  or MouseWheelEvent  is passed to it in following cases:

  when a mouse button is pressed, released, or clicked (pressed and  released)
  when the mouse cursor enters or exits the component
  when the mouse wheel rotated, or mouse moved or dragged"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event MouseAdapter]))

(defn ->mouse-adapter
  "Constructor."
  (^MouseAdapter []
    (new MouseAdapter )))

(defn mouse-clicked
  "Invoked when the mouse button has been clicked (pressed
   and released) on a component.

  e - `java.awt.event.MouseEvent`"
  ([^MouseAdapter this e]
    (-> this (.mouseClicked e))))

(defn mouse-pressed
  "Invoked when a mouse button has been pressed on a component.

  e - `java.awt.event.MouseEvent`"
  ([^MouseAdapter this e]
    (-> this (.mousePressed e))))

(defn mouse-released
  "Invoked when a mouse button has been released on a component.

  e - `java.awt.event.MouseEvent`"
  ([^MouseAdapter this e]
    (-> this (.mouseReleased e))))

(defn mouse-entered
  "Invoked when the mouse enters a component.

  e - `java.awt.event.MouseEvent`"
  ([^MouseAdapter this e]
    (-> this (.mouseEntered e))))

(defn mouse-exited
  "Invoked when the mouse exits a component.

  e - `java.awt.event.MouseEvent`"
  ([^MouseAdapter this e]
    (-> this (.mouseExited e))))

(defn mouse-wheel-moved
  "Invoked when the mouse wheel is rotated.

  e - `java.awt.event.MouseWheelEvent`"
  ([^MouseAdapter this ^java.awt.event.MouseWheelEvent e]
    (-> this (.mouseWheelMoved e))))

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
  ([^MouseAdapter this e]
    (-> this (.mouseDragged e))))

(defn mouse-moved
  "Invoked when the mouse cursor has been moved onto a component
   but no buttons have been pushed.

  e - `java.awt.event.MouseEvent`"
  ([^MouseAdapter this e]
    (-> this (.mouseMoved e))))

