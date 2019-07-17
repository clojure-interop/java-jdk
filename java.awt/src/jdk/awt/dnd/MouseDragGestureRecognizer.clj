(ns jdk.awt.dnd.MouseDragGestureRecognizer
  "This abstract subclass of DragGestureRecognizer
  defines a DragGestureRecognizer
  for mouse-based gestures.

  Each platform implements its own concrete subclass of this class,
  available via the Toolkit.createDragGestureRecognizer() method,
  to encapsulate
  the recognition of the platform dependent mouse gesture(s) that initiate
  a Drag and Drop operation.

  Mouse drag gesture recognizers should honor the
  drag gesture motion threshold, available through
  DragSource.getDragThreshold().
  A drag gesture should be recognized only when the distance
  in either the horizontal or vertical direction between
  the location of the latest mouse dragged event and the
  location of the corresponding mouse button pressed event
  is greater than the drag gesture motion threshold.

  Drag gesture recognizers created with
  DragSource.createDefaultDragGestureRecognizer(java.awt.Component, int, java.awt.dnd.DragGestureListener)
  follow this convention."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.dnd MouseDragGestureRecognizer]))

(defn mouse-clicked
  "Invoked when the mouse has been clicked on a component.

  e - the MouseEvent - `java.awt.event.MouseEvent`"
  ([^java.awt.dnd.MouseDragGestureRecognizer this ^java.awt.event.MouseEvent e]
    (-> this (.mouseClicked e))))

(defn mouse-pressed
  "Invoked when a mouse button has been
   pressed on a Component.

  e - the MouseEvent - `java.awt.event.MouseEvent`"
  ([^java.awt.dnd.MouseDragGestureRecognizer this ^java.awt.event.MouseEvent e]
    (-> this (.mousePressed e))))

(defn mouse-released
  "Invoked when a mouse button has been released on a component.

  e - the MouseEvent - `java.awt.event.MouseEvent`"
  ([^java.awt.dnd.MouseDragGestureRecognizer this ^java.awt.event.MouseEvent e]
    (-> this (.mouseReleased e))))

(defn mouse-entered
  "Invoked when the mouse enters a component.

  e - the MouseEvent - `java.awt.event.MouseEvent`"
  ([^java.awt.dnd.MouseDragGestureRecognizer this ^java.awt.event.MouseEvent e]
    (-> this (.mouseEntered e))))

(defn mouse-exited
  "Invoked when the mouse exits a component.

  e - the MouseEvent - `java.awt.event.MouseEvent`"
  ([^java.awt.dnd.MouseDragGestureRecognizer this ^java.awt.event.MouseEvent e]
    (-> this (.mouseExited e))))

(defn mouse-dragged
  "Invoked when a mouse button is pressed on a component.

  e - the MouseEvent - `java.awt.event.MouseEvent`"
  ([^java.awt.dnd.MouseDragGestureRecognizer this ^java.awt.event.MouseEvent e]
    (-> this (.mouseDragged e))))

(defn mouse-moved
  "Invoked when the mouse button has been moved on a component
   (with no buttons no down).

  e - the MouseEvent - `java.awt.event.MouseEvent`"
  ([^java.awt.dnd.MouseDragGestureRecognizer this ^java.awt.event.MouseEvent e]
    (-> this (.mouseMoved e))))

