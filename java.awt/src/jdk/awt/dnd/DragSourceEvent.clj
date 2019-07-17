(ns jdk.awt.dnd.DragSourceEvent
  "This class is the base class for
  DragSourceDragEvent and
  DragSourceDropEvent.

  DragSourceEvents are generated whenever the drag enters, moves
  over, or exits a drop site, when the drop action changes, and when the drag
  ends. The location for the generated DragSourceEvent specifies
  the mouse cursor location in screen coordinates at the moment this event
  occurred.

  In a multi-screen environment without a virtual device, the cursor location is
  specified in the coordinate system of the initiator
  GraphicsConfiguration. The initiator
  GraphicsConfiguration is the GraphicsConfiguration
  of the Component on which the drag gesture for the current drag
  operation was recognized. If the cursor location is outside the bounds of
  the initiator GraphicsConfiguration, the reported coordinates are
  clipped to fit within the bounds of that GraphicsConfiguration.

  In a multi-screen environment with a virtual device, the location is specified
  in the corresponding virtual coordinate system. If the cursor location is
  outside the bounds of the virtual device the reported coordinates are
  clipped to fit within the bounds of the virtual device."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.dnd DragSourceEvent]))

(defn ->drag-source-event
  "Constructor.

  Construct a DragSourceEvent given a specified
   DragSourceContext, and coordinates of the cursor
   location.

  dsc - the DragSourceContext - `java.awt.dnd.DragSourceContext`
  x - the horizontal coordinate for the cursor location - `int`
  y - the vertical coordinate for the cursor location - `int`

  throws: java.lang.IllegalArgumentException - if dsc is null."
  ([dsc x y]
    (new DragSourceEvent dsc x y))
  ([dsc]
    (new DragSourceEvent dsc)))

(defn get-drag-source-context
  "This method returns the DragSourceContext that
   originated the event.

  returns: the DragSourceContext that originated the event - `java.awt.dnd.DragSourceContext`"
  ([this]
    (-> this (.getDragSourceContext))))

(defn get-location
  "This method returns a Point indicating the cursor
   location in screen coordinates at the moment this event occurred, or
   null if the cursor location is not specified for this
   event.

  returns: the Point indicating the cursor location
           or null if the cursor location is not specified - `java.awt.Point`"
  ([this]
    (-> this (.getLocation))))

(defn get-x
  "This method returns the horizontal coordinate of the cursor location in
   screen coordinates at the moment this event occurred, or zero if the
   cursor location is not specified for this event.

  returns: an integer indicating the horizontal coordinate of the cursor
           location or zero if the cursor location is not specified - `int`"
  ([this]
    (-> this (.getX))))

(defn get-y
  "This method returns the vertical coordinate of the cursor location in
   screen coordinates at the moment this event occurred, or zero if the
   cursor location is not specified for this event.

  returns: an integer indicating the vertical coordinate of the cursor
           location or zero if the cursor location is not specified - `int`"
  ([this]
    (-> this (.getY))))

