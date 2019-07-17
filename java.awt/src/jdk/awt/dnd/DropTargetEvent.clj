(ns jdk.awt.dnd.DropTargetEvent
  "The DropTargetEvent is the base
  class for both the DropTargetDragEvent
  and the DropTargetDropEvent.
  It encapsulates the current state of the Drag and
  Drop operations, in particular the current
  DropTargetContext."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.dnd DropTargetEvent]))

(defn ->drop-target-event
  "Constructor.

  Construct a DropTargetEvent object with
   the specified DropTargetContext.

  dtc - The DropTargetContext - `java.awt.dnd.DropTargetContext`

  throws: java.lang.NullPointerException - if dtc equals null."
  ([dtc]
    (new DropTargetEvent dtc)))

(defn get-drop-target-context
  "This method returns the DropTargetContext
   associated with this DropTargetEvent.

  returns: the DropTargetContext - `java.awt.dnd.DropTargetContext`"
  ([this]
    (-> this (.getDropTargetContext))))

