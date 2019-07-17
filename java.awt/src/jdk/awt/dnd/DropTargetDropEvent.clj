(ns jdk.awt.dnd.DropTargetDropEvent
  "The DropTargetDropEvent is delivered
  via the DropTargetListener drop() method.

  The DropTargetDropEvent reports the source drop actions
  and the user drop action that reflect the current state of the
  drag-and-drop operation.

  Source drop actions is a bitwise mask of DnDConstants
  that represents the set of drop actions supported by the drag source for
  this drag-and-drop operation.

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
  (:import [java.awt.dnd DropTargetDropEvent]))

(defn ->drop-target-drop-event
  "Constructor.

  Construct a DropTargetEvent given the
   DropTargetContext for this operation,
   the location of the drag Cursor's hotspot
   in the Component's
   coordinates, the currently selected user drop action,
   the current set of actions supported by the source,
   and a boolean indicating if the source is in the same JVM
   as the target.

  dtc - The DropTargetContext for this operation - `java.awt.dnd.DropTargetContext`
  cursor-locn - The location of the `Drag` Cursor's hotspot in Component's coordinates - `java.awt.Point`
  drop-action - the user drop action. - `int`
  src-actions - the source drop actions. - `int`
  is-local - True if the source is in the same JVM as the target - `boolean`

  throws: java.lang.NullPointerException - if cursorLocn is null"
  ([^java.awt.dnd.DropTargetContext dtc ^java.awt.Point cursor-locn ^Integer drop-action ^Integer src-actions ^Boolean is-local]
    (new DropTargetDropEvent dtc cursor-locn drop-action src-actions is-local))
  ([^java.awt.dnd.DropTargetContext dtc ^java.awt.Point cursor-locn ^Integer drop-action ^Integer src-actions]
    (new DropTargetDropEvent dtc cursor-locn drop-action src-actions)))

(defn accept-drop
  "accept the drop, using the specified action.

  drop-action - the specified action - `int`"
  ([^java.awt.dnd.DropTargetDropEvent this ^Integer drop-action]
    (-> this (.acceptDrop drop-action))))

(defn get-location
  "This method returns a Point
   indicating the Cursor's current
   location in the Component's coordinates.

  returns: the current Cursor location in Component's coords. - `java.awt.Point`"
  ([^java.awt.dnd.DropTargetDropEvent this]
    (-> this (.getLocation))))

(defn drop-complete
  "This method notifies the DragSource
   that the drop transfer(s) are completed.

  success - a boolean indicating that the drop transfer(s) are completed. - `boolean`"
  ([^java.awt.dnd.DropTargetDropEvent this ^Boolean success]
    (-> this (.dropComplete success))))

(defn get-drop-action
  "This method returns the user drop action.

  returns: the user drop actions. - `int`"
  ([^java.awt.dnd.DropTargetDropEvent this]
    (-> this (.getDropAction))))

(defn get-current-data-flavors-as-list
  "This method returns the currently available
   DataFlavors as a java.util.List.

  returns: the currently available DataFlavors as a java.util.List - `java.util.List<java.awt.datatransfer.DataFlavor>`"
  ([^java.awt.dnd.DropTargetDropEvent this]
    (-> this (.getCurrentDataFlavorsAsList))))

(defn get-source-actions
  "This method returns the source drop actions.

  returns: the source drop actions. - `int`"
  ([^java.awt.dnd.DropTargetDropEvent this]
    (-> this (.getSourceActions))))

(defn get-transferable
  "This method returns the Transferable object
   associated with the drop.

  returns: the Transferable associated with the drop - `java.awt.datatransfer.Transferable`"
  ([^java.awt.dnd.DropTargetDropEvent this]
    (-> this (.getTransferable))))

(defn get-current-data-flavors
  "This method returns the current DataFlavors.

  returns: current DataFlavors - `java.awt.datatransfer.DataFlavor[]`"
  ([^java.awt.dnd.DropTargetDropEvent this]
    (-> this (.getCurrentDataFlavors))))

(defn reject-drop
  "reject the Drop."
  ([^java.awt.dnd.DropTargetDropEvent this]
    (-> this (.rejectDrop))))

(defn local-transfer?
  "This method returns an int indicating if
   the source is in the same JVM as the target.

  returns: if the Source is in the same JVM - `boolean`"
  ([^java.awt.dnd.DropTargetDropEvent this]
    (-> this (.isLocalTransfer))))

(defn data-flavor-supported?
  "This method returns a boolean indicating if the
   specified DataFlavor is available
   from the source.

  df - the DataFlavor to test - `java.awt.datatransfer.DataFlavor`

  returns: if the DataFlavor specified is available from the source - `boolean`"
  ([^java.awt.dnd.DropTargetDropEvent this ^java.awt.datatransfer.DataFlavor df]
    (-> this (.isDataFlavorSupported df))))

