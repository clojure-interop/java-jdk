(ns jdk.awt.dnd.DragSourceListener
  "The DragSourceListener defines the
  event interface for originators of
  Drag and Drop operations to track the state of the user's gesture, and to
  provide appropriate `drag over`
  feedback to the user throughout the
  Drag and Drop operation.

  The drop site is associated with the previous dragEnter()
  invocation if the latest invocation of dragEnter() on this
  listener:

  corresponds to that drop site and
   is not followed by a dragExit() invocation on this listener."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.dnd DragSourceListener]))

(defn drag-enter
  "Called as the cursor's hotspot enters a platform-dependent drop site.
   This method is invoked when all the following conditions are true:

   The cursor's hotspot enters the operable part of a platform-
   dependent drop site.
   The drop site is active.
   The drop site accepts the drag.

  dsde - the DragSourceDragEvent - `java.awt.dnd.DragSourceDragEvent`"
  ([^java.awt.dnd.DragSourceListener this ^java.awt.dnd.DragSourceDragEvent dsde]
    (-> this (.dragEnter dsde))))

(defn drag-over
  "Called as the cursor's hotspot moves over a platform-dependent drop site.
   This method is invoked when all the following conditions are true:

   The cursor's hotspot has moved, but still intersects the
   operable part of the drop site associated with the previous
   dragEnter() invocation.
   The drop site is still active.
   The drop site accepts the drag.

  dsde - the DragSourceDragEvent - `java.awt.dnd.DragSourceDragEvent`"
  ([^java.awt.dnd.DragSourceListener this ^java.awt.dnd.DragSourceDragEvent dsde]
    (-> this (.dragOver dsde))))

(defn drop-action-changed
  "Called when the user has modified the drop gesture.
   This method is invoked when the state of the input
   device(s) that the user is interacting with changes.
   Such devices are typically the mouse buttons or keyboard
   modifiers that the user is interacting with.

  dsde - the DragSourceDragEvent - `java.awt.dnd.DragSourceDragEvent`"
  ([^java.awt.dnd.DragSourceListener this ^java.awt.dnd.DragSourceDragEvent dsde]
    (-> this (.dropActionChanged dsde))))

(defn drag-exit
  "Called as the cursor's hotspot exits a platform-dependent drop site.
   This method is invoked when any of the following conditions are true:

   The cursor's hotspot no longer intersects the operable part
   of the drop site associated with the previous dragEnter() invocation.

   OR

   The drop site associated with the previous dragEnter() invocation
   is no longer active.

   OR

    The drop site associated with the previous dragEnter() invocation
   has rejected the drag.

  dse - the DragSourceEvent - `java.awt.dnd.DragSourceEvent`"
  ([^java.awt.dnd.DragSourceListener this ^java.awt.dnd.DragSourceEvent dse]
    (-> this (.dragExit dse))))

(defn drag-drop-end
  "This method is invoked to signify that the Drag and Drop
   operation is complete. The getDropSuccess() method of
   the DragSourceDropEvent can be used to
   determine the termination state. The getDropAction() method
   returns the operation that the drop site selected
   to apply to the Drop operation. Once this method is complete, the
   current DragSourceContext and
   associated resources become invalid.

  dsde - the DragSourceDropEvent - `java.awt.dnd.DragSourceDropEvent`"
  ([^java.awt.dnd.DragSourceListener this ^java.awt.dnd.DragSourceDropEvent dsde]
    (-> this (.dragDropEnd dsde))))

