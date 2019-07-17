(ns jdk.awt.dnd.DropTarget$DropTargetAutoScroller
  "this protected nested class implements autoscrolling"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.dnd DropTarget$DropTargetAutoScroller]))

(defn action-performed
  "cause autoscroll to occur

  e - the ActionEvent - `java.awt.event.ActionEvent`"
  ([this e]
    (-> this (.actionPerformed e))))

