(ns jdk.awt.dnd.DragSourceContext
  "The DragSourceContext class is responsible for managing the
  initiator side of the Drag and Drop protocol. In particular, it is responsible
  for managing drag event notifications to the
  java.awt.dnd.DragSourceListeners
  and java.awt.dnd.DragSourceMotionListeners, and providing the
  Transferable representing the source data for the drag operation.

  Note that the DragSourceContext itself
  implements the DragSourceListener and
  DragSourceMotionListener interfaces.
  This is to allow the platform peer
  (the DragSourceContextPeer instance)
  created by the DragSource to notify
  the DragSourceContext of
  state changes in the ongoing operation. This allows the
  DragSourceContext object to interpose
  itself between the platform and the
  listeners provided by the initiator of the drag operation.


  By default, DragSourceContext sets the cursor as appropriate
  for the current state of the drag and drop operation. For example, if
  the user has chosen the move action,
  and the pointer is over a target that accepts
  the move action, the default move cursor is shown. When
  the pointer is over an area that does not accept the transfer,
  the default `no drop` cursor is shown.

  This default handling mechanism is disabled when a custom cursor is set
  by the setCursor(java.awt.Cursor) method. When the default handling is disabled,
  it becomes the responsibility
  of the developer to keep the cursor up to date, by listening
  to the DragSource events and calling the setCursor() method.
  Alternatively, you can provide custom cursor behavior by providing
  custom implementations of the DragSource
  and the DragSourceContext classes."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.dnd DragSourceContext]))

(defn ->drag-source-context
  "Constructor.

  Called from DragSource, this constructor creates a new
   DragSourceContext given the
   DragSourceContextPeer for this Drag, the
   DragGestureEvent that triggered the Drag, the initial
   Cursor to use for the Drag, an (optional)
   Image to display while the Drag is taking place, the offset
   of the Image origin from the hotspot at the instant of the
   triggering event, the Transferable subject data, and the
   DragSourceListener to use during the Drag and Drop
   operation.

   If DragSourceContextPeer is null
   NullPointerException is thrown.

   If DragGestureEvent is null
   NullPointerException is thrown.

   If Cursor is null no exception is thrown and
   the default drag cursor behavior is activated for this drag operation.

   If Image is null no exception is thrown.

   If Image is not null and the offset is
   null NullPointerException is thrown.

   If Transferable is null
   NullPointerException is thrown.

   If DragSourceListener is null no exception
   is thrown.

  dscp - the DragSourceContextPeer for this drag - `java.awt.dnd.peer.DragSourceContextPeer`
  trigger - the triggering event - `java.awt.dnd.DragGestureEvent`
  drag-cursor - the initial Cursor for this drag operation or null for the default cursor handling; see class level documentation for more details on the cursor handling mechanism during drag and drop - `java.awt.Cursor`
  drag-image - the Image to drag (or null) - `java.awt.Image`
  offset - the offset of the image origin from the hotspot at the instant of the triggering event - `java.awt.Point`
  t - the Transferable - `java.awt.datatransfer.Transferable`
  dsl - the DragSourceListener - `java.awt.dnd.DragSourceListener`

  throws: java.lang.IllegalArgumentException - if the source actions for the DragGestureRecognizer associated with the trigger event are equal to DnDConstants.ACTION_NONE."
  ([dscp trigger drag-cursor drag-image offset t dsl]
    (new DragSourceContext dscp trigger drag-cursor drag-image offset t dsl)))

(defn drag-drop-end
  "Calls dragDropEnd on the
   DragSourceListeners registered with this
   DragSourceContext and with the associated
   DragSource, and passes them the specified
   DragSourceDropEvent.

  dsde - the DragSourceDropEvent - `java.awt.dnd.DragSourceDropEvent`"
  ([this dsde]
    (-> this (.dragDropEnd dsde))))

(defn get-trigger
  "Returns the DragGestureEvent
   that initially triggered the drag.

  returns: the Event that triggered the drag - `java.awt.dnd.DragGestureEvent`"
  ([this]
    (-> this (.getTrigger))))

(defn get-component
  "Returns the Component associated with this
   DragSourceContext.

  returns: the Component that started the drag - `java.awt.Component`"
  ([this]
    (-> this (.getComponent))))

(defn drag-mouse-moved
  "Calls dragMouseMoved on the
   DragSourceMotionListeners registered with the
   DragSource associated with this
   DragSourceContext, and them passes the specified
   DragSourceDragEvent.

  dsde - the DragSourceDragEvent - `java.awt.dnd.DragSourceDragEvent`"
  ([this dsde]
    (-> this (.dragMouseMoved dsde))))

(defn get-cursor
  "Returns the current drag Cursor.

  returns: the current drag Cursor - `java.awt.Cursor`"
  ([this]
    (-> this (.getCursor))))

(defn drag-exit
  "Calls dragExit on the
   DragSourceListeners registered with this
   DragSourceContext and with the associated
   DragSource, and passes them the specified
   DragSourceEvent.

  dse - the DragSourceEvent - `java.awt.dnd.DragSourceEvent`"
  ([this dse]
    (-> this (.dragExit dse))))

(defn get-source-actions
  "Returns a bitwise mask of DnDConstants that
   represent the set of drop actions supported by the drag source for the
   drag operation associated with this DragSourceContext.

  returns: the drop actions supported by the drag source - `int`"
  ([this]
    (-> this (.getSourceActions))))

(defn get-drag-source
  "Returns the DragSource
   that instantiated this DragSourceContext.

  returns: the DragSource that
     instantiated this DragSourceContext - `java.awt.dnd.DragSource`"
  ([this]
    (-> this (.getDragSource))))

(defn remove-drag-source-listener
  "Removes the specified DragSourceListener
   from  this DragSourceContext.

  dsl - the DragSourceListener to remove; note that while null is not prohibited, it is not acceptable as a parameter - `java.awt.dnd.DragSourceListener`"
  ([this dsl]
    (-> this (.removeDragSourceListener dsl))))

(defn get-transferable
  "Returns the Transferable associated with
   this DragSourceContext.

  returns: the Transferable - `java.awt.datatransfer.Transferable`"
  ([this]
    (-> this (.getTransferable))))

(defn transferables-flavors-changed
  "Notifies the peer that the Transferable's
   DataFlavors have changed."
  ([this]
    (-> this (.transferablesFlavorsChanged))))

(defn drop-action-changed
  "Calls dropActionChanged on the
   DragSourceListeners registered with this
   DragSourceContext and with the associated
   DragSource, and passes them the specified
   DragSourceDragEvent.

  dsde - the DragSourceDragEvent - `java.awt.dnd.DragSourceDragEvent`"
  ([this dsde]
    (-> this (.dropActionChanged dsde))))

(defn drag-enter
  "Calls dragEnter on the
   DragSourceListeners registered with this
   DragSourceContext and with the associated
   DragSource, and passes them the specified
   DragSourceDragEvent.

  dsde - the DragSourceDragEvent - `java.awt.dnd.DragSourceDragEvent`"
  ([this dsde]
    (-> this (.dragEnter dsde))))

(defn set-cursor
  "Sets the cursor for this drag operation to the specified
   Cursor.  If the specified Cursor
   is null, the default drag cursor behavior is
   activated for this drag operation, otherwise it is deactivated.

  c - the initial Cursor for this drag operation, or null for the default cursor handling; see java.awt.class level documentation for more details on the cursor handling during drag and drop - `java.awt.Cursor`"
  ([this c]
    (-> this (.setCursor c))))

(defn add-drag-source-listener
  "Add a DragSourceListener to this
   DragSourceContext if one has not already been added.
   If a DragSourceListener already exists,
   this method throws a TooManyListenersException.

  dsl - the DragSourceListener to add. Note that while null is not prohibited, it is not acceptable as a parameter. - `java.awt.dnd.DragSourceListener`

  throws: java.util.TooManyListenersException - if a DragSourceListener has already been added"
  ([this dsl]
    (-> this (.addDragSourceListener dsl))))

(defn drag-over
  "Calls dragOver on the
   DragSourceListeners registered with this
   DragSourceContext and with the associated
   DragSource, and passes them the specified
   DragSourceDragEvent.

  dsde - the DragSourceDragEvent - `java.awt.dnd.DragSourceDragEvent`"
  ([this dsde]
    (-> this (.dragOver dsde))))

