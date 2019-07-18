(ns jdk.awt.dnd.DragGestureRecognizer
  "The DragGestureRecognizer is an
  abstract base class for the specification
  of a platform-dependent listener that can be associated with a particular
  Component in order to
  identify platform-dependent drag initiating gestures.

  The appropriate DragGestureRecognizer
  subclass instance is obtained from the
  DragSource associated with
  a particular Component, or from the Toolkit object via its
  createDragGestureRecognizer()
  method.

  Once the DragGestureRecognizer
  is associated with a particular Component
  it will register the appropriate listener interfaces on that
  Component
  in order to track the input events delivered to the Component.

  Once the DragGestureRecognizer identifies a sequence of events
  on the Component as a drag initiating gesture, it will notify
  its unicast DragGestureListener by
  invoking its
  gestureRecognized()
  method.

  When a concrete DragGestureRecognizer
  instance detects a drag initiating
  gesture on the Component it is associated with,
  it fires a DragGestureEvent to
  the DragGestureListener registered on
  its unicast event source for DragGestureListener
  events. This DragGestureListener is responsible
  for causing the associated
  DragSource to start the Drag and Drop operation (if
  appropriate)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.dnd DragGestureRecognizer]))

(defn get-component
  "This method returns the Component
   that is to be `observed` by the
   DragGestureRecognizer
   for drag initiating gestures.

  returns: The Component this DragGestureRecognizer
   is associated with - `java.awt.Component`"
  (^java.awt.Component [^DragGestureRecognizer this]
    (-> this (.getComponent))))

(defn get-source-actions
  "This method returns an int representing the
   type of action(s) this Drag and Drop
   operation will support.

  returns: the currently permitted source action(s) - `int`"
  (^Integer [^DragGestureRecognizer this]
    (-> this (.getSourceActions))))

(defn get-drag-source
  "This method returns the DragSource
   this DragGestureRecognizer
   will use in order to process the Drag and Drop
   operation.

  returns: the DragSource - `java.awt.dnd.DragSource`"
  (^java.awt.dnd.DragSource [^DragGestureRecognizer this]
    (-> this (.getDragSource))))

(defn get-trigger-event
  "This method returns the first event in the
   series of events that initiated
   the Drag and Drop operation.

  returns: the initial event that triggered the drag gesture - `java.awt.event.InputEvent`"
  (^java.awt.event.InputEvent [^DragGestureRecognizer this]
    (-> this (.getTriggerEvent))))

(defn set-source-actions
  "This method sets the permitted source drag action(s)
   for this Drag and Drop operation.

  actions - the permitted source drag action(s) - `int`"
  ([^DragGestureRecognizer this ^Integer actions]
    (-> this (.setSourceActions actions))))

(defn set-component
  "set the Component that the DragGestureRecognizer is associated with

   registerListeners() and unregisterListeners() are called as a side
   effect as appropriate.

  c - The Component or null - `java.awt.Component`"
  ([^DragGestureRecognizer this ^java.awt.Component c]
    (-> this (.setComponent c))))

(defn remove-drag-gesture-listener
  "unregister the current DragGestureListener

  dgl - the DragGestureListener to unregister from this DragGestureRecognizer - `java.awt.dnd.DragGestureListener`

  throws: java.lang.IllegalArgumentException - if dgl is not (equal to) the currently registered DragGestureListener."
  ([^DragGestureRecognizer this ^java.awt.dnd.DragGestureListener dgl]
    (-> this (.removeDragGestureListener dgl))))

(defn reset-recognizer
  "Reset the Recognizer, if its currently recognizing a gesture, ignore
   it."
  ([^DragGestureRecognizer this]
    (-> this (.resetRecognizer))))

(defn add-drag-gesture-listener
  "Register a new DragGestureListener.

  dgl - the DragGestureListener to register with this DragGestureRecognizer. - `java.awt.dnd.DragGestureListener`

  throws: java.util.TooManyListenersException - if a DragGestureListener has already been added."
  ([^DragGestureRecognizer this ^java.awt.dnd.DragGestureListener dgl]
    (-> this (.addDragGestureListener dgl))))

