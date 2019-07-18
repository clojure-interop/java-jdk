(ns jdk.awt.dnd.DragGestureEvent
  "A DragGestureEvent is passed
  to DragGestureListener's
  dragGestureRecognized() method
  when a particular DragGestureRecognizer detects that a
  platform dependent drag initiating gesture has occurred
  on the Component that it is tracking.

  The action field of any DragGestureEvent instance should take one of the following
  values:

   DnDConstants.ACTION_COPY
   DnDConstants.ACTION_MOVE
   DnDConstants.ACTION_LINK

  Assigning the value different from listed above will cause an unspecified behavior."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.dnd DragGestureEvent]))

(defn ->drag-gesture-event
  "Constructor.

  Constructs a DragGestureEvent object given by the
   DragGestureRecognizer instance firing this event,
   an act parameter representing
   the user's preferred action, an ori parameter
   indicating the origin of the drag, and a List of
   events that comprise the gesture(evs parameter).

  dgr - The DragGestureRecognizer firing this event - `java.awt.dnd.DragGestureRecognizer`
  act - The user's preferred action. For information on allowable values, see the class description for DragGestureEvent - `int`
  ori - The origin of the drag - `java.awt.Point`
  evs - The List of events that comprise the gesture - `java.util.List`

  throws: java.lang.IllegalArgumentException - if the act parameter does not comply with the values given in the class description for DragGestureEvent"
  (^DragGestureEvent [^java.awt.dnd.DragGestureRecognizer dgr ^Integer act ^java.awt.Point ori ^java.util.List evs]
    (new DragGestureEvent dgr act ori evs)))

(defn get-component
  "Returns the Component associated
   with this DragGestureEvent.

  returns: the Component - `java.awt.Component`"
  (^java.awt.Component [^DragGestureEvent this]
    (-> this (.getComponent))))

(defn iterator
  "Returns an Iterator for the events
   comprising the gesture.

  returns: an Iterator for the events comprising the gesture - `java.util.Iterator<java.awt.event.InputEvent>`"
  (^java.util.Iterator [^DragGestureEvent this]
    (-> this (.iterator))))

(defn get-source-as-drag-gesture-recognizer
  "Returns the source as a DragGestureRecognizer.

  returns: the source as a DragGestureRecognizer - `java.awt.dnd.DragGestureRecognizer`"
  (^java.awt.dnd.DragGestureRecognizer [^DragGestureEvent this]
    (-> this (.getSourceAsDragGestureRecognizer))))

(defn get-drag-source
  "Returns the DragSource.

  returns: the DragSource - `java.awt.dnd.DragSource`"
  (^java.awt.dnd.DragSource [^DragGestureEvent this]
    (-> this (.getDragSource))))

(defn get-trigger-event
  "Returns the initial event that triggered the gesture.

  returns: the first `triggering` event in the sequence of the gesture - `java.awt.event.InputEvent`"
  (^java.awt.event.InputEvent [^DragGestureEvent this]
    (-> this (.getTriggerEvent))))

(defn get-drag-action
  "Returns an int representing the
   action selected by the user.

  returns: the action selected by the user - `int`"
  (^Integer [^DragGestureEvent this]
    (-> this (.getDragAction))))

(defn get-drag-origin
  "Returns a Point in the coordinates
   of the Component over which the drag originated.

  returns: the Point where the drag originated in Component coords. - `java.awt.Point`"
  (^java.awt.Point [^DragGestureEvent this]
    (-> this (.getDragOrigin))))

(defn start-drag
  "Start the drag given the initial Cursor to display,
   a drag Image, the offset of
   the Image,
   the Transferable object, and
   the DragSourceListener to use.

  drag-cursor - The initial Cursor for this drag operation or null for the default cursor handling; see DragSourceContext for more details on the cursor handling mechanism during drag and drop - `java.awt.Cursor`
  drag-image - The source's dragImage - `java.awt.Image`
  image-offset - The dragImage's offset - `java.awt.Point`
  transferable - The source's Transferable - `java.awt.datatransfer.Transferable`
  dsl - The source's DragSourceListener - `java.awt.dnd.DragSourceListener`

  throws: java.awt.dnd.InvalidDnDOperationException - if the Drag and Drop system is unable to initiate a drag operation, or if the user attempts to start a drag while an existing drag operation is still executing."
  ([^DragGestureEvent this ^java.awt.Cursor drag-cursor ^java.awt.Image drag-image ^java.awt.Point image-offset ^java.awt.datatransfer.Transferable transferable ^java.awt.dnd.DragSourceListener dsl]
    (-> this (.startDrag drag-cursor drag-image image-offset transferable dsl)))
  ([^DragGestureEvent this ^java.awt.Cursor drag-cursor ^java.awt.datatransfer.Transferable transferable ^java.awt.dnd.DragSourceListener dsl]
    (-> this (.startDrag drag-cursor transferable dsl)))
  ([^DragGestureEvent this ^java.awt.Cursor drag-cursor ^java.awt.datatransfer.Transferable transferable]
    (-> this (.startDrag drag-cursor transferable))))

(defn to-array
  "Returns an array of the events comprising the drag gesture.

  array - the array of EventObject sub(types) - `java.lang.Object[]`

  returns: an array of the events comprising the gesture - `java.lang.Object[]`"
  ([^DragGestureEvent this array]
    (-> this (.toArray array)))
  ([^DragGestureEvent this]
    (-> this (.toArray))))

