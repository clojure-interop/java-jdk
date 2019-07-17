(ns javax.swing.TransferHandler$TransferSupport
  "This class encapsulates all relevant details of a clipboard
  or drag and drop transfer, and also allows for customizing
  aspects of the drag and drop experience.

  The main purpose of this class is to provide the information
  needed by a developer to determine the suitability of a
  transfer or to import the data contained within. But it also
  doubles as a controller for customizing properties during drag
  and drop, such as whether or not to show the drop location,
  and which drop action to use.

  Developers typically need not create instances of this
  class. Instead, they are something provided by the DnD
  implementation to certain methods in TransferHandler."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing TransferHandler$TransferSupport]))

(defn ->transfer-support
  "Constructor.

  Create a TransferSupport with isDrop()
   false for the given component and
   Transferable.

  component - the target component - `java.awt.Component`
  transferable - the transferable - `java.awt.datatransfer.Transferable`

  throws: java.lang.NullPointerException - if either parameter is null"
  ([component transferable]
    (new TransferHandler$TransferSupport component transferable)))

(defn get-component
  "Returns the target component of this transfer.

  returns: the target component - `java.awt.Component`"
  ([this]
    (-> this (.getComponent))))

(defn drop?
  "Returns whether or not this TransferSupport
   represents a drop operation.

  returns: true if this is a drop operation,
           false otherwise. - `boolean`"
  ([this]
    (-> this (.isDrop))))

(defn get-source-drop-actions
  "Returns the drag source's supported drop actions, when this
   TransferSupport represents a drop.

   The source actions represent the set of actions supported by the
   source of this transfer, and are represented as some bitwise-OR
   combination of COPY, MOVE and LINK.
   You may wish to query this in TransferHandler's
   canImport method when determining the suitability of a drop
   or when deciding on a drop action to explicitly choose. To determine
   if a particular action is supported by the source, bitwise-AND
   the action with the source drop actions, and then compare the result
   against the original action. For example:


   boolean copySupported = (COPY & getSourceDropActions()) == COPY;

   This method is only for use with drag and drop transfers.
   Calling it when isDrop() is false results
   in an IllegalStateException.

  returns: the drag source's supported drop actions - `int`

  throws: java.lang.IllegalStateException - if this is not a drop"
  ([this]
    (-> this (.getSourceDropActions))))

(defn get-drop-action
  "Returns the action chosen for the drop, when this
   TransferSupport represents a drop.

   Unless explicitly chosen by way of setDropAction,
   this returns the user drop action provided by
   getUserDropAction.

   You may wish to query this in TransferHandler's
   importData method to customize processing based
   on the action.

   This method is only for use with drag and drop transfers.
   Calling it when isDrop() is false results
   in an IllegalStateException.

  returns: the action chosen for the drop - `int`

  throws: java.lang.IllegalStateException - if this is not a drop"
  ([this]
    (-> this (.getDropAction))))

(defn get-drop-location
  "Returns the current (non-null) drop location for the component,
   when this TransferSupport represents a drop.

   Note: For components with built-in drop support, this location
   will be a subclass of DropLocation of the same type
   returned by that component's getDropLocation method.

   This method is only for use with drag and drop transfers.
   Calling it when isDrop() is false results
   in an IllegalStateException.

  returns: the drop location - `javax.swing.TransferHandler.DropLocation`

  throws: java.lang.IllegalStateException - if this is not a drop"
  ([this]
    (-> this (.getDropLocation))))

(defn get-transferable
  "Returns the Transferable associated with this transfer.

   Note: Unless it is necessary to fetch the Transferable
   directly, use one of the other methods on this class to inquire about
   the transfer. This may perform better than fetching the
   Transferable and asking it directly.

  returns: the Transferable associated with this transfer - `java.awt.datatransfer.Transferable`"
  ([this]
    (-> this (.getTransferable))))

(defn set-show-drop-location
  "Sets whether or not the drop location should be visually indicated
   for the transfer - which must represent a drop. This is applicable to
   those components that automatically
   show the drop location when appropriate during a drag and drop
   operation). By default, the drop location is shown only when the
   TransferHandler has said it can accept the import represented
   by this TransferSupport. With this method you can force the
   drop location to always be shown, or always not be shown.

   This method is only for use with drag and drop transfers.
   Calling it when isDrop() is false results
   in an IllegalStateException.

  show-drop-location - whether or not to indicate the drop location - `boolean`

  throws: java.lang.IllegalStateException - if this is not a drop"
  ([this show-drop-location]
    (-> this (.setShowDropLocation show-drop-location))))

(defn set-drop-action
  "Sets the drop action for the transfer - which must represent a drop
   - to the given action,
   instead of the default user drop action. The action must be
   supported by the source's drop actions, and must be one
   of COPY, MOVE or LINK.

   This method is only for use with drag and drop transfers.
   Calling it when isDrop() is false results
   in an IllegalStateException.

  drop-action - the drop action - `int`

  throws: java.lang.IllegalStateException - if this is not a drop"
  ([this drop-action]
    (-> this (.setDropAction drop-action))))

(defn get-user-drop-action
  "Returns the user drop action for the drop, when this
   TransferSupport represents a drop.

   The user drop action is chosen for a drop as described in the
   documentation for DropTargetDragEvent and
   DropTargetDropEvent. A different action
   may be chosen as the drop action by way of the setDropAction
   method.

   You may wish to query this in TransferHandler's
   canImport method when determining the suitability of a
   drop or when deciding on a drop action to explicitly choose.

   This method is only for use with drag and drop transfers.
   Calling it when isDrop() is false results
   in an IllegalStateException.

  returns: the user drop action - `int`

  throws: java.lang.IllegalStateException - if this is not a drop"
  ([this]
    (-> this (.getUserDropAction))))

(defn get-data-flavors
  "Returns the data flavors for this transfer.

  returns: the data flavors for this transfer - `java.awt.datatransfer.DataFlavor[]`"
  ([this]
    (-> this (.getDataFlavors))))

(defn data-flavor-supported?
  "Returns whether or not the given data flavor is supported.

  df - the DataFlavor to test - `java.awt.datatransfer.DataFlavor`

  returns: whether or not the given flavor is supported. - `boolean`"
  ([this df]
    (-> this (.isDataFlavorSupported df))))

