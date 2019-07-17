(ns jdk.awt.dnd.DropTargetDragEvent
  "The DropTargetDragEvent is delivered to a
  DropTargetListener via its
  dragEnter() and dragOver() methods.

  The DropTargetDragEvent reports the source drop actions
  and the user drop action that reflect the current state of
  the drag operation.

  Source drop actions is a bitwise mask of DnDConstants
  that represents the set of drop actions supported by the drag source for
  this drag operation.

  User drop action depends on the drop actions supported by the drag
  source and the drop action selected by the user. The user can select a drop
  action by pressing modifier keys during the drag operation:


    Ctrl  Shift -> ACTION_LINK
    Ctrl         -> ACTION_COPY
    Shift        -> ACTION_MOVE
  If the user selects a drop action, the user drop action is one of
  DnDConstants that represents the selected drop action if this
  drop action is supported by the drag source or
  DnDConstants.ACTION_NONE if this drop action is not supported
  by the drag source.

  If the user doesn't select a drop action, the set of
  DnDConstants that represents the set of drop actions supported
  by the drag source is searched for DnDConstants.ACTION_MOVE,
  then for DnDConstants.ACTION_COPY, then for
  DnDConstants.ACTION_LINK and the user drop action is the
  first constant found. If no constant is found the user drop action
  is DnDConstants.ACTION_NONE."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.dnd DropTargetDragEvent]))

(defn ->drop-target-drag-event
  "Constructor.

  Construct a DropTargetDragEvent given the
   DropTargetContext for this operation,
   the location of the `Drag` Cursor's hotspot
   in the Component's coordinates, the
   user drop action, and the source drop actions.

  dtc - The DropTargetContext for this operation - `java.awt.dnd.DropTargetContext`
  cursor-locn - The location of the `Drag` Cursor's hotspot in Component coordinates - `java.awt.Point`
  drop-action - The user drop action - `int`
  src-actions - The source drop actions - `int`

  throws: java.lang.NullPointerException - if cursorLocn is null"
  ([dtc cursor-locn drop-action src-actions]
    (new DropTargetDragEvent dtc cursor-locn drop-action src-actions)))

(defn get-location
  "This method returns a Point
   indicating the Cursor's current
   location within the Component's
   coordinates.

  returns: the current cursor location in
   Component's coords. - `java.awt.Point`"
  ([this]
    (-> this (.getLocation))))

(defn reject-drag
  "Rejects the drag as a result of examining either the
   dropAction or the available DataFlavor
   types."
  ([this]
    (-> this (.rejectDrag))))

(defn accept-drag
  "Accepts the drag.

   This method should be called from a
   DropTargetListeners dragEnter,
   dragOver, and dropActionChanged
   methods if the implementation wishes to accept an operation
   from the srcActions other than the one selected by
   the user as represented by the dropAction.

  drag-operation - the operation accepted by the target - `int`"
  ([this drag-operation]
    (-> this (.acceptDrag drag-operation))))

(defn get-drop-action
  "This method returns the user drop action.

  returns: the user drop action - `int`"
  ([this]
    (-> this (.getDropAction))))

(defn get-current-data-flavors-as-list
  "This method returns the current DataFlavors
   as a java.util.List

  returns: a java.util.List of the Current DataFlavors - `java.util.List<java.awt.datatransfer.DataFlavor>`"
  ([this]
    (-> this (.getCurrentDataFlavorsAsList))))

(defn get-source-actions
  "This method returns the source drop actions.

  returns: the source drop actions - `int`"
  ([this]
    (-> this (.getSourceActions))))

(defn get-transferable
  "This method returns the Transferable object that represents
   the data associated with the current drag operation.

  returns: the Transferable associated with the drag operation - `java.awt.datatransfer.Transferable`

  throws: java.awt.dnd.InvalidDnDOperationException - if the data associated with the drag operation is not available"
  ([this]
    (-> this (.getTransferable))))

(defn get-current-data-flavors
  "This method returns the current DataFlavors from the
   DropTargetContext.

  returns: current DataFlavors from the DropTargetContext - `java.awt.datatransfer.DataFlavor[]`"
  ([this]
    (-> this (.getCurrentDataFlavors))))

(defn data-flavor-supported?
  "This method returns a boolean indicating
   if the specified DataFlavor is supported.

  df - the DataFlavor to test - `java.awt.datatransfer.DataFlavor`

  returns: if a particular DataFlavor is supported - `boolean`"
  ([this df]
    (-> this (.isDataFlavorSupported df))))

