(ns jdk.awt.dnd.DragSource
  "The DragSource is the entity responsible
  for the initiation of the Drag
  and Drop operation, and may be used in a number of scenarios:

  1 default instance per JVM for the lifetime of that JVM.
  1 instance per class of potential Drag Initiator object (e.g
  TextField). [implementation dependent]
  1 per instance of a particular
  Component, or application specific
  object associated with a Component
  instance in the GUI. [implementation dependent]
  Some other arbitrary association. [implementation dependent]


  Once the DragSource is
  obtained, a DragGestureRecognizer should
  also be obtained to associate the DragSource
  with a particular
  Component.

  The initial interpretation of the user's gesture,
  and the subsequent starting of the drag operation
  are the responsibility of the implementing
  Component, which is usually
  implemented by a DragGestureRecognizer.

  When a drag gesture occurs, the
  DragSource's
  startDrag() method shall be
  invoked in order to cause processing
  of the user's navigational
  gestures and delivery of Drag and Drop
  protocol notifications. A
  DragSource shall only
  permit a single Drag and Drop operation to be
  current at any one time, and shall
  reject any further startDrag() requests
  by throwing an IllegalDnDOperationException
  until such time as the extant operation is complete.

  The startDrag() method invokes the
  createDragSourceContext() method to
  instantiate an appropriate
  DragSourceContext
  and associate the DragSourceContextPeer
  with that.

  If the Drag and Drop System is
  unable to initiate a drag operation for
  some reason, the startDrag() method throws
  a java.awt.dnd.InvalidDnDOperationException
  to signal such a condition. Typically this
  exception is thrown when the underlying platform
  system is either not in a state to
  initiate a drag, or the parameters specified are invalid.

  Note that during the drag, the
  set of operations exposed by the source
  at the start of the drag operation may not change
  until the operation is complete.
  The operation(s) are constant for the
  duration of the operation with respect to the
  DragSource."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.dnd DragSource]))

(defn ->drag-source
  "Constructor.

  Creates a new DragSource.

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true"
  ([]
    (new DragSource )))

(def *-default-copy-drop
  "Static Constant.

  The default Cursor to use with a copy operation indicating
   that a drop is currently allowed. null if
   GraphicsEnvironment.isHeadless() returns true.

  type: java.awt.Cursor"
  DragSource/DefaultCopyDrop)

(def *-default-move-drop
  "Static Constant.

  The default Cursor to use with a move operation indicating
   that a drop is currently allowed. null if
   GraphicsEnvironment.isHeadless() returns true.

  type: java.awt.Cursor"
  DragSource/DefaultMoveDrop)

(def *-default-link-drop
  "Static Constant.

  The default Cursor to use with a link operation indicating
   that a drop is currently allowed. null if
   GraphicsEnvironment.isHeadless() returns true.

  type: java.awt.Cursor"
  DragSource/DefaultLinkDrop)

(def *-default-copy-no-drop
  "Static Constant.

  The default Cursor to use with a copy operation indicating
   that a drop is currently not allowed. null if
   GraphicsEnvironment.isHeadless() returns true.

  type: java.awt.Cursor"
  DragSource/DefaultCopyNoDrop)

(def *-default-move-no-drop
  "Static Constant.

  The default Cursor to use with a move operation indicating
   that a drop is currently not allowed. null if
   GraphicsEnvironment.isHeadless() returns true.

  type: java.awt.Cursor"
  DragSource/DefaultMoveNoDrop)

(def *-default-link-no-drop
  "Static Constant.

  The default Cursor to use with a link operation indicating
   that a drop is currently not allowed. null if
   GraphicsEnvironment.isHeadless() returns true.

  type: java.awt.Cursor"
  DragSource/DefaultLinkNoDrop)

(defn *get-default-drag-source
  "Gets the DragSource object associated with
   the underlying platform.

  returns: the platform DragSource - `java.awt.dnd.DragSource`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true"
  ([]
    (DragSource/getDefaultDragSource )))

(defn *drag-image-supported?
  "Reports
   whether or not drag
   Image support
   is available on the underlying platform.

  returns: if the Drag Image support is available on this platform - `boolean`"
  ([]
    (DragSource/isDragImageSupported )))

(defn *get-drag-threshold
  "Returns the drag gesture motion threshold. The drag gesture motion threshold
   defines the recommended behavior for MouseDragGestureRecognizers.

   If the system property awt.dnd.drag.threshold is set to
   a positive integer, this method returns the value of the system property;
   otherwise if a pertinent desktop property is available and supported by
   the implementation of the Java platform, this method returns the value of
   that property; otherwise this method returns some default value.
   The pertinent desktop property can be queried using
   java.awt.Toolkit.getDesktopProperty(`DnD.gestureMotionThreshold`).

  returns: the drag gesture motion threshold - `int`"
  ([]
    (DragSource/getDragThreshold )))

(defn get-drag-source-motion-listeners
  "Gets all of the  DragSourceMotionListeners
   registered with this DragSource.

  returns: all of this DragSource's
           DragSourceMotionListeners or an empty array if no
           such listeners are currently registered - `java.awt.dnd.DragSourceMotionListener[]`"
  ([this]
    (-> this (.getDragSourceMotionListeners))))

(defn get-flavor-map
  "This method returns the
   FlavorMap for this DragSource.

  returns: the FlavorMap for this DragSource - `java.awt.datatransfer.FlavorMap`"
  ([this]
    (-> this (.getFlavorMap))))

(defn get-drag-source-listeners
  "Gets all the DragSourceListeners
   registered with this DragSource.

  returns: all of this DragSource's
           DragSourceListeners or an empty array if no
           such listeners are currently registered - `java.awt.dnd.DragSourceListener[]`"
  ([this]
    (-> this (.getDragSourceListeners))))

(defn create-drag-gesture-recognizer
  "Creates a new DragGestureRecognizer
   that implements the specified
   abstract subclass of
   DragGestureRecognizer, and
   sets the specified Component
   and DragGestureListener on
   the newly created object.

  recognizer-abstract-class - the requested abstract type - `java.lang.Class<T>`
  c - the Component target - `java.awt.Component`
  actions - the permitted source drag actions - `int`
  dgl - the DragGestureListener to notify - `java.awt.dnd.DragGestureListener`

  returns: the new DragGestureRecognizer or null
      if the Toolkit.createDragGestureRecognizer method
      has no implementation available for
      the requested DragGestureRecognizer
      subclass and returns null - `<T extends java.awt.dnd.DragGestureRecognizer> T`"
  ([this recognizer-abstract-class c actions dgl]
    (-> this (.createDragGestureRecognizer recognizer-abstract-class c actions dgl))))

(defn remove-drag-source-motion-listener
  "Removes the specified DragSourceMotionListener from this
   DragSource.
   If a null listener is specified, no action is taken and no
   exception is thrown.
   If the listener specified by the argument was not previously added to
   this DragSource, no action is taken and no exception
   is thrown.

  dsml - the DragSourceMotionListener to remove - `java.awt.dnd.DragSourceMotionListener`"
  ([this dsml]
    (-> this (.removeDragSourceMotionListener dsml))))

(defn remove-drag-source-listener
  "Removes the specified DragSourceListener from this
   DragSource.
   If a null listener is specified, no action is taken and no
   exception is thrown.
   If the listener specified by the argument was not previously added to
   this DragSource, no action is taken and no exception
   is thrown.

  dsl - the DragSourceListener to remove - `java.awt.dnd.DragSourceListener`"
  ([this dsl]
    (-> this (.removeDragSourceListener dsl))))

(defn start-drag
  "Start a drag, given the DragGestureEvent
   that initiated the drag, the initial
   Cursor to use,
   the Image to drag,
   the offset of the Image origin
   from the hotspot of the Cursor at
   the instant of the trigger,
   the Transferable subject data
   of the drag, the DragSourceListener,
   and the FlavorMap.

  trigger - the DragGestureEvent that initiated the drag - `java.awt.dnd.DragGestureEvent`
  drag-cursor - the initial Cursor for this drag operation or null for the default cursor handling; see DragSourceContext for more details on the cursor handling mechanism during drag and drop - `java.awt.Cursor`
  drag-image - the image to drag or null - `java.awt.Image`
  image-offset - the offset of the Image origin from the hotspot of the Cursor at the instant of the trigger - `java.awt.Point`
  transferable - the subject data of the drag - `java.awt.datatransfer.Transferable`
  dsl - the DragSourceListener - `java.awt.dnd.DragSourceListener`
  flavor-map - the FlavorMap to use, or null - `java.awt.datatransfer.FlavorMap`

  throws: java.awt.dnd.InvalidDnDOperationException - if the Drag and Drop system is unable to initiate a drag operation, or if the user attempts to start a drag while an existing drag operation is still executing"
  ([this trigger drag-cursor drag-image image-offset transferable dsl flavor-map]
    (-> this (.startDrag trigger drag-cursor drag-image image-offset transferable dsl flavor-map)))
  ([this trigger drag-cursor drag-image drag-offset transferable dsl]
    (-> this (.startDrag trigger drag-cursor drag-image drag-offset transferable dsl)))
  ([this trigger drag-cursor transferable dsl flavor-map]
    (-> this (.startDrag trigger drag-cursor transferable dsl flavor-map)))
  ([this trigger drag-cursor transferable dsl]
    (-> this (.startDrag trigger drag-cursor transferable dsl))))

(defn add-drag-source-motion-listener
  "Adds the specified DragSourceMotionListener to this
   DragSource to receive drag motion events during drag
   operations intiated with this DragSource.
   If a null listener is specified, no action is taken and no
   exception is thrown.

  dsml - the DragSourceMotionListener to add - `java.awt.dnd.DragSourceMotionListener`"
  ([this dsml]
    (-> this (.addDragSourceMotionListener dsml))))

(defn create-default-drag-gesture-recognizer
  "Creates a new DragGestureRecognizer
   that implements the default
   abstract subclass of DragGestureRecognizer
   for this DragSource,
   and sets the specified Component
   and DragGestureListener on the
   newly created object.

   For this DragSource
   the default is MouseDragGestureRecognizer.

  c - the Component target for the recognizer - `java.awt.Component`
  actions - the permitted source actions - `int`
  dgl - the DragGestureListener to notify - `java.awt.dnd.DragGestureListener`

  returns: the new DragGestureRecognizer or null
      if the Toolkit.createDragGestureRecognizer method
      has no implementation available for
      the requested DragGestureRecognizer
      subclass and returns null - `java.awt.dnd.DragGestureRecognizer`"
  ([this c actions dgl]
    (-> this (.createDefaultDragGestureRecognizer c actions dgl))))

(defn get-listeners
  "Gets all the objects currently registered as
   FooListeners upon this DragSource.
   FooListeners are registered using the
   addFooListener method.

  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class<T>`

  returns: an array of all objects registered as
            FooListeners on this
            DragSource, or an empty array if no such listeners
            have been added - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if listenerType doesn't specify a class or interface that implements java.util.EventListener"
  ([this listener-type]
    (-> this (.getListeners listener-type))))

(defn add-drag-source-listener
  "Adds the specified DragSourceListener to this
   DragSource to receive drag source events during drag
   operations intiated with this DragSource.
   If a null listener is specified, no action is taken and no
   exception is thrown.

  dsl - the DragSourceListener to add - `java.awt.dnd.DragSourceListener`"
  ([this dsl]
    (-> this (.addDragSourceListener dsl))))

