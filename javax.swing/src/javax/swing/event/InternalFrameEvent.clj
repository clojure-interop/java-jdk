(ns javax.swing.event.InternalFrameEvent
  "An AWTEvent that adds support for
  JInternalFrame objects as the event source.  This class has the
  same event types as WindowEvent,
  although different IDs are used.
  Help on handling internal frame events
  is in
  How to Write an Internal Frame Listener,
  a section in The Java Tutorial.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event InternalFrameEvent]))

(defn ->internal-frame-event
  "Constructor.

  Constructs an InternalFrameEvent object.

  source - the JInternalFrame object that originated the event - `javax.swing.JInternalFrame`
  id - an integer indicating the type of event - `int`"
  ([^javax.swing.JInternalFrame source ^Integer id]
    (new InternalFrameEvent source id)))

(def *-internal-frame-first
  "Static Constant.

  The first number in the range of IDs used for internal frame events.

  type: int"
  InternalFrameEvent/INTERNAL_FRAME_FIRST)

(def *-internal-frame-last
  "Static Constant.

  The last number in the range of IDs used for internal frame events.

  type: int"
  InternalFrameEvent/INTERNAL_FRAME_LAST)

(def *-internal-frame-opened
  "Static Constant.

  The `window opened` event.  This event is delivered only
   the first time the internal frame is made visible.

  type: int"
  InternalFrameEvent/INTERNAL_FRAME_OPENED)

(def *-internal-frame-closing
  "Static Constant.

  The `window is closing` event. This event is delivered when
   the user attempts to close the internal frame, such as by
   clicking the internal frame's close button,
   or when a program attempts to close the internal frame
   by invoking the setClosed method.

  type: int"
  InternalFrameEvent/INTERNAL_FRAME_CLOSING)

(def *-internal-frame-closed
  "Static Constant.

  The `window closed` event. This event is delivered after
   the internal frame has been closed as the result of a call to
   the setClosed or
   dispose method.

  type: int"
  InternalFrameEvent/INTERNAL_FRAME_CLOSED)

(def *-internal-frame-iconified
  "Static Constant.

  The `window iconified` event.
   This event indicates that the internal frame
   was shrunk down to a small icon.

  type: int"
  InternalFrameEvent/INTERNAL_FRAME_ICONIFIED)

(def *-internal-frame-deiconified
  "Static Constant.

  The `window deiconified` event type. This event indicates that the
   internal frame has been restored to its normal size.

  type: int"
  InternalFrameEvent/INTERNAL_FRAME_DEICONIFIED)

(def *-internal-frame-activated
  "Static Constant.

  The `window activated` event type. This event indicates that keystrokes
   and mouse clicks are directed towards this internal frame.

  type: int"
  InternalFrameEvent/INTERNAL_FRAME_ACTIVATED)

(def *-internal-frame-deactivated
  "Static Constant.

  The `window deactivated` event type. This event indicates that keystrokes
   and mouse clicks are no longer directed to the internal frame.

  type: int"
  InternalFrameEvent/INTERNAL_FRAME_DEACTIVATED)

(defn param-string
  "Returns a parameter string identifying this event.
   This method is useful for event logging and for debugging.

  returns: a string identifying the event and its attributes - `java.lang.String`"
  ([^javax.swing.event.InternalFrameEvent this]
    (-> this (.paramString))))

(defn get-internal-frame
  "Returns the originator of the event.

  returns: the JInternalFrame object that originated the event - `javax.swing.JInternalFrame`"
  ([^javax.swing.event.InternalFrameEvent this]
    (-> this (.getInternalFrame))))

