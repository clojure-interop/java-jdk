(ns jdk.awt.dnd.DropTargetListener
  "The DropTargetListener interface
  is the callback interface used by the
  DropTarget class to provide
  notification of DnD operations that involve
  the subject DropTarget. Methods of
  this interface may be implemented to provide
  \"drag under\" visual feedback to the user throughout
  the Drag and Drop operation.

  Create a listener object by implementing the interface and then register it
  with a DropTarget. When the drag enters, moves over, or exits
  the operable part of the drop site for that DropTarget, when
  the drop action changes, and when the drop occurs, the relevant method in
  the listener object is invoked, and the DropTargetEvent is
  passed to it.

  The operable part of the drop site for the DropTarget is
  the part of the associated Component's geometry that is not
  obscured by an overlapping top-level window or by another
  Component higher in the Z-order that has an associated active
  DropTarget.

  During the drag, the data associated with the current drag operation can be
  retrieved by calling getTransferable() on
  DropTargetDragEvent instances passed to the listener's
  methods.

  Note that getTransferable() on the
  DropTargetDragEvent instance should only be called within the
  respective listener's method and all the necessary data should be retrieved
  from the returned Transferable before that method returns."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.dnd DropTargetListener]))

(defn drag-enter
  "Called while a drag operation is ongoing, when the mouse pointer enters
   the operable part of the drop site for the DropTarget
   registered with this listener.

  dtde - the DropTargetDragEvent - `java.awt.dnd.DropTargetDragEvent`"
  ([^DropTargetListener this ^java.awt.dnd.DropTargetDragEvent dtde]
    (-> this (.dragEnter dtde))))

(defn drag-over
  "Called when a drag operation is ongoing, while the mouse pointer is still
   over the operable part of the drop site for the DropTarget
   registered with this listener.

  dtde - the DropTargetDragEvent - `java.awt.dnd.DropTargetDragEvent`"
  ([^DropTargetListener this ^java.awt.dnd.DropTargetDragEvent dtde]
    (-> this (.dragOver dtde))))

(defn drop-action-changed
  "Called if the user has modified
   the current drop gesture.

  dtde - the DropTargetDragEvent - `java.awt.dnd.DropTargetDragEvent`"
  ([^DropTargetListener this ^java.awt.dnd.DropTargetDragEvent dtde]
    (-> this (.dropActionChanged dtde))))

(defn drag-exit
  "Called while a drag operation is ongoing, when the mouse pointer has
   exited the operable part of the drop site for the
   DropTarget registered with this listener.

  dte - the DropTargetEvent - `java.awt.dnd.DropTargetEvent`"
  ([^DropTargetListener this ^java.awt.dnd.DropTargetEvent dte]
    (-> this (.dragExit dte))))

(defn drop
  "Called when the drag operation has terminated with a drop on
   the operable part of the drop site for the DropTarget
   registered with this listener.

   This method is responsible for undertaking
   the transfer of the data associated with the
   gesture. The DropTargetDropEvent
   provides a means to obtain a Transferable
   object that represents the data object(s) to
   be transfered.
   From this method, the DropTargetListener
   shall accept or reject the drop via the
   acceptDrop(int dropAction) or rejectDrop() methods of the
   DropTargetDropEvent parameter.

   Subsequent to acceptDrop(), but not before,
   DropTargetDropEvent's getTransferable()
   method may be invoked, and data transfer may be
   performed via the returned Transferable's
   getTransferData() method.

   At the completion of a drop, an implementation
   of this method is required to signal the success/failure
   of the drop by passing an appropriate
   boolean to the DropTargetDropEvent's
   dropComplete(boolean success) method.

   Note: The data transfer should be completed before the call  to the
   DropTargetDropEvent's dropComplete(boolean success) method.
   After that, a call to the getTransferData() method of the
   Transferable returned by
   DropTargetDropEvent.getTransferable() is guaranteed to
   succeed only if the data transfer is local; that is, only if
   DropTargetDropEvent.isLocalTransfer() returns
   true. Otherwise, the behavior of the call is
   implementation-dependent.

  dtde - the DropTargetDropEvent - `java.awt.dnd.DropTargetDropEvent`"
  ([^DropTargetListener this ^java.awt.dnd.DropTargetDropEvent dtde]
    (-> this (.drop dtde))))

