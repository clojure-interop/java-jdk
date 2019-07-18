(ns javax.swing.event.MenuDragMouseListener
  "Defines a menu mouse-drag listener."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event MenuDragMouseListener]))

(defn menu-drag-mouse-entered
  "Invoked when the dragged mouse has entered a menu component's
   display area.

  e - a MenuDragMouseEvent object - `javax.swing.event.MenuDragMouseEvent`"
  ([^MenuDragMouseListener this e]
    (-> this (.menuDragMouseEntered e))))

(defn menu-drag-mouse-exited
  "Invoked when the dragged mouse has left a menu component's
   display area.

  e - a MenuDragMouseEvent object - `javax.swing.event.MenuDragMouseEvent`"
  ([^MenuDragMouseListener this e]
    (-> this (.menuDragMouseExited e))))

(defn menu-drag-mouse-dragged
  "Invoked when the mouse is being dragged in a menu component's
   display area.

  e - a MenuDragMouseEvent object - `javax.swing.event.MenuDragMouseEvent`"
  ([^MenuDragMouseListener this e]
    (-> this (.menuDragMouseDragged e))))

(defn menu-drag-mouse-released
  "Invoked when a dragged mouse is release in a menu component's
   display area.

  e - a MenuDragMouseEvent object - `javax.swing.event.MenuDragMouseEvent`"
  ([^MenuDragMouseListener this e]
    (-> this (.menuDragMouseReleased e))))

