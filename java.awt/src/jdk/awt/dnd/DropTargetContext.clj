(ns jdk.awt.dnd.DropTargetContext
  "A DropTargetContext is created
  whenever the logical cursor associated
  with a Drag and Drop operation coincides with the visible geometry of
  a Component associated with a DropTarget.
  The DropTargetContext provides
  the mechanism for a potential receiver
  of a drop operation to both provide the end user with the appropriate
  drag under feedback, but also to effect the subsequent data transfer
  if appropriate."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.dnd DropTargetContext]))

(defn get-drop-target
  "This method returns the DropTarget associated with this
   DropTargetContext.

  returns: the DropTarget associated with this DropTargetContext - `java.awt.dnd.DropTarget`"
  (^java.awt.dnd.DropTarget [^java.awt.dnd.DropTargetContext this]
    (-> this (.getDropTarget))))

(defn get-component
  "This method returns the Component associated with
   this DropTargetContext.

  returns: the Component associated with this Context - `java.awt.Component`"
  (^java.awt.Component [^java.awt.dnd.DropTargetContext this]
    (-> this (.getComponent))))

(defn add-notify
  "Called when associated with the DropTargetContextPeer.

  dtcp - the DropTargetContextPeer - `java.awt.dnd.peer.DropTargetContextPeer`"
  ([^java.awt.dnd.DropTargetContext this ^java.awt.dnd.peer.DropTargetContextPeer dtcp]
    (-> this (.addNotify dtcp))))

(defn remove-notify
  "Called when disassociated with the DropTargetContextPeer."
  ([^java.awt.dnd.DropTargetContext this]
    (-> this (.removeNotify))))

(defn drop-complete
  "This method signals that the drop is completed and
   if it was successful or not.

  success - true for success, false if not - `boolean`

  throws: java.awt.dnd.InvalidDnDOperationException - if a drop is not outstanding/extant"
  ([^java.awt.dnd.DropTargetContext this ^Boolean success]
    (-> this (.dropComplete success))))

