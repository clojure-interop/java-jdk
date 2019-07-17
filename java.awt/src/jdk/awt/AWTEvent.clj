(ns jdk.awt.AWTEvent
  "The root event class for all AWT events.
  This class and its subclasses supercede the original
  java.awt.Event class.
  Subclasses of this root AWTEvent class defined outside of the
  java.awt.event package should define event ID values greater than
  the value defined by RESERVED_ID_MAX.

  The event masks defined in this class are needed by Component subclasses
  which are using Component.enableEvents() to select for event types not
  selected by registered listeners. If a listener is registered on a
  component, the appropriate event mask is already set internally by the
  component.

  The masks are also used to specify to which types of events an
  AWTEventListener should listen. The masks are bitwise-ORed together
  and passed to Toolkit.addAWTEventListener."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt AWTEvent]))

(defn ->awt-event
  "Constructor.

  Constructs an AWTEvent object with the specified source object and type.

  source - the object where the event originated - `java.lang.Object`
  id - the event type - `int`"
  ([source id]
    (new AWTEvent source id))
  ([event]
    (new AWTEvent event)))

(def *-component-event-mask
  "Static Constant.

  The event mask for selecting component events.

  type: long"
  AWTEvent/COMPONENT_EVENT_MASK)

(def *-container-event-mask
  "Static Constant.

  The event mask for selecting container events.

  type: long"
  AWTEvent/CONTAINER_EVENT_MASK)

(def *-focus-event-mask
  "Static Constant.

  The event mask for selecting focus events.

  type: long"
  AWTEvent/FOCUS_EVENT_MASK)

(def *-key-event-mask
  "Static Constant.

  The event mask for selecting key events.

  type: long"
  AWTEvent/KEY_EVENT_MASK)

(def *-mouse-event-mask
  "Static Constant.

  The event mask for selecting mouse events.

  type: long"
  AWTEvent/MOUSE_EVENT_MASK)

(def *-mouse-motion-event-mask
  "Static Constant.

  The event mask for selecting mouse motion events.

  type: long"
  AWTEvent/MOUSE_MOTION_EVENT_MASK)

(def *-window-event-mask
  "Static Constant.

  The event mask for selecting window events.

  type: long"
  AWTEvent/WINDOW_EVENT_MASK)

(def *-action-event-mask
  "Static Constant.

  The event mask for selecting action events.

  type: long"
  AWTEvent/ACTION_EVENT_MASK)

(def *-adjustment-event-mask
  "Static Constant.

  The event mask for selecting adjustment events.

  type: long"
  AWTEvent/ADJUSTMENT_EVENT_MASK)

(def *-item-event-mask
  "Static Constant.

  The event mask for selecting item events.

  type: long"
  AWTEvent/ITEM_EVENT_MASK)

(def *-text-event-mask
  "Static Constant.

  The event mask for selecting text events.

  type: long"
  AWTEvent/TEXT_EVENT_MASK)

(def *-input-method-event-mask
  "Static Constant.

  The event mask for selecting input method events.

  type: long"
  AWTEvent/INPUT_METHOD_EVENT_MASK)

(def *-paint-event-mask
  "Static Constant.

  The event mask for selecting paint events.

  type: long"
  AWTEvent/PAINT_EVENT_MASK)

(def *-invocation-event-mask
  "Static Constant.

  The event mask for selecting invocation events.

  type: long"
  AWTEvent/INVOCATION_EVENT_MASK)

(def *-hierarchy-event-mask
  "Static Constant.

  The event mask for selecting hierarchy events.

  type: long"
  AWTEvent/HIERARCHY_EVENT_MASK)

(def *-hierarchy-bounds-event-mask
  "Static Constant.

  The event mask for selecting hierarchy bounds events.

  type: long"
  AWTEvent/HIERARCHY_BOUNDS_EVENT_MASK)

(def *-mouse-wheel-event-mask
  "Static Constant.

  The event mask for selecting mouse wheel events.

  type: long"
  AWTEvent/MOUSE_WHEEL_EVENT_MASK)

(def *-window-state-event-mask
  "Static Constant.

  The event mask for selecting window state events.

  type: long"
  AWTEvent/WINDOW_STATE_EVENT_MASK)

(def *-window-focus-event-mask
  "Static Constant.

  The event mask for selecting window focus events.

  type: long"
  AWTEvent/WINDOW_FOCUS_EVENT_MASK)

(def *-reserved-id-max
  "Static Constant.

  The maximum value for reserved AWT event IDs. Programs defining
   their own event IDs should use IDs greater than this value.

  type: int"
  AWTEvent/RESERVED_ID_MAX)

(defn set-source
  "Retargets an event to a new source. This method is typically used to
   retarget an event to a lightweight child Component of the original
   heavyweight source.

   This method is intended to be used only by event targeting subsystems,
   such as client-defined KeyboardFocusManagers. It is not for general
   client use.

  new-source - the new Object to which the event should be dispatched - `java.lang.Object`"
  ([this new-source]
    (-> this (.setSource new-source))))

(defn get-id
  "Returns the event type.

  returns: `int`"
  ([this]
    (-> this (.getID))))

(defn to-string
  "Returns a String representation of this object.

  returns: A a String representation of this EventObject. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn param-string
  "Returns a string representing the state of this Event.
   This method is intended to be used only for debugging purposes, and the
   content and format of the returned string may vary between
   implementations. The returned string may be empty but may not be
   null.

  returns: a string representation of this event - `java.lang.String`"
  ([this]
    (-> this (.paramString))))

