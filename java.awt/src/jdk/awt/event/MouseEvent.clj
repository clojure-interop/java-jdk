(ns jdk.awt.event.MouseEvent
  "An event which indicates that a mouse action occurred in a component.
  A mouse action is considered to occur in a particular component if and only
  if the mouse cursor is over the unobscured part of the component's bounds
  when the action happens.
  For lightweight components, such as Swing's components, mouse events
  are only dispatched to the component if the mouse event type has been
  enabled on the component. A mouse event type is enabled by adding the
  appropriate mouse-based EventListener to the component
  (MouseListener or MouseMotionListener), or by invoking
  Component.enableEvents(long) with the appropriate mask parameter
  (AWTEvent.MOUSE_EVENT_MASK or AWTEvent.MOUSE_MOTION_EVENT_MASK).
  If the mouse event type has not been enabled on the component, the
  corresponding mouse events are dispatched to the first ancestor that
  has enabled the mouse event type.

  For example, if a MouseListener has been added to a component, or
  enableEvents(AWTEvent.MOUSE_EVENT_MASK) has been invoked, then all
  the events defined by MouseListener are dispatched to the component.
  On the other hand, if a MouseMotionListener has not been added and
  enableEvents has not been invoked with
  AWTEvent.MOUSE_MOTION_EVENT_MASK, then mouse motion events are not
  dispatched to the component. Instead the mouse motion events are
  dispatched to the first ancestors that has enabled mouse motion
  events.

  This low-level event is generated by a component object for:

  Mouse Events

      a mouse button is pressed
      a mouse button is released
      a mouse button is clicked (pressed and released)
      the mouse cursor enters the unobscured part of component's geometry
      the mouse cursor exits the unobscured part of component's geometry

   Mouse Motion Events

      the mouse is moved
      the mouse is dragged



  A MouseEvent object is passed to every
  MouseListener
  or MouseAdapter object which is registered to receive
  the \"interesting\" mouse events using the component's
  addMouseListener method.
  (MouseAdapter objects implement the
  MouseListener interface.) Each such listener object
  gets a MouseEvent containing the mouse event.

  A MouseEvent object is also passed to every
  MouseMotionListener or
  MouseMotionAdapter object which is registered to receive
  mouse motion events using the component's
  addMouseMotionListener
  method. (MouseMotionAdapter objects implement the
  MouseMotionListener interface.) Each such listener object
  gets a MouseEvent containing the mouse motion event.

  When a mouse button is clicked, events are generated and sent to the
  registered MouseListeners.
  The state of modal keys can be retrieved using InputEvent.getModifiers()
  and InputEvent.getModifiersEx().
  The button mask returned by InputEvent.getModifiers() reflects
  only the button that changed state, not the current state of all buttons.
  (Note: Due to overlap in the values of ALT_MASK/BUTTON2_MASK and
  META_MASK/BUTTON3_MASK, this is not always true for mouse events involving
  modifier keys).
  To get the state of all buttons and modifier keys, use
  InputEvent.getModifiersEx().
  The button which has changed state is returned by getButton()

  For example, if the first mouse button is pressed, events are sent in the
  following order:


     id              modifiers    button
     MOUSE_PRESSED:  BUTTON1_MASK BUTTON1
     MOUSE_RELEASED: BUTTON1_MASK BUTTON1
     MOUSE_CLICKED:  BUTTON1_MASK BUTTON1
  When multiple mouse buttons are pressed, each press, release, and click
  results in a separate event.

  For example, if the user presses button 1 followed by
  button 2, and then releases them in the same order,
  the following sequence of events is generated:


     id              modifiers    button
     MOUSE_PRESSED:  BUTTON1_MASK BUTTON1
     MOUSE_PRESSED:  BUTTON2_MASK BUTTON2
     MOUSE_RELEASED: BUTTON1_MASK BUTTON1
     MOUSE_CLICKED:  BUTTON1_MASK BUTTON1
     MOUSE_RELEASED: BUTTON2_MASK BUTTON2
     MOUSE_CLICKED:  BUTTON2_MASK BUTTON2
  If button 2 is released first, the
  MOUSE_RELEASED/MOUSE_CLICKED pair
  for BUTTON2_MASK arrives first,
  followed by the pair for BUTTON1_MASK.

  Some extra mouse buttons are added to extend the standard set of buttons
  represented by the following constants:BUTTON1, BUTTON2, and BUTTON3.
  Extra buttons have no assigned BUTTONx
  constants as well as their button masks have no assigned BUTTONx_DOWN_MASK
  constants. Nevertheless, ordinal numbers starting from 4 may be
  used as button numbers (button ids). Values obtained by the
  getMaskForButton(button) method may be used
  as button masks.

  MOUSE_DRAGGED events are delivered to the Component
  in which the mouse button was pressed until the mouse button is released
  (regardless of whether the mouse position is within the bounds of the
  Component).  Due to platform-dependent Drag&Drop implementations,
  MOUSE_DRAGGED events may not be delivered during a native
  Drag&Drop operation.

  In a multi-screen environment mouse drag events are delivered to the
  Component even if the mouse position is outside the bounds of the
  GraphicsConfiguration associated with that
  Component. However, the reported position for mouse drag events
  in this case may differ from the actual mouse position:

  In a multi-screen environment without a virtual device:

  The reported coordinates for mouse drag events are clipped to fit within the
  bounds of the GraphicsConfiguration associated with
  the Component.
  In a multi-screen environment with a virtual device:

  The reported coordinates for mouse drag events are clipped to fit within the
  bounds of the virtual device associated with the Component.


  An unspecified behavior will be caused if the id parameter
  of any particular MouseEvent instance is not
  in the range from MOUSE_FIRST to MOUSE_LAST-1
  (MOUSE_WHEEL is not acceptable)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event MouseEvent]))

(defn ->mouse-event
  "Constructor.

  Constructs a MouseEvent object with the
   specified source component,
   type, time, modifiers, coordinates, absolute coordinates, click count, popupTrigger flag,
   and button number.

   Creating an invalid event (such
   as by using more than one of the old _MASKs, or modifier/button
   values which don't match) results in unspecified behavior.
   Even if inconsistent values for relative and absolute coordinates are
   passed to the constructor, the mouse event instance is still
   created and no exception is thrown.
   This method throws an
   IllegalArgumentException if source
   is null.

  source - The Component that originated the event - `java.awt.Component`
  id - An integer indicating the type of event. For information on allowable values, see the class description for MouseEvent - `int`
  when - A long integer that gives the time the event occurred. Passing negative or zero value is not recommended - `long`
  modifiers - a modifier mask describing the modifier keys and mouse buttons (for example, shift, ctrl, alt, and meta) that are down during the event. Only extended modifiers are allowed to be used as a value for this parameter (see the InputEvent.getModifiersEx() class for the description of extended modifiers). Passing negative parameter is not recommended. Zero value means that no modifiers were passed - `int`
  x - The horizontal x coordinate for the mouse location. It is allowed to pass negative values - `int`
  y - The vertical y coordinate for the mouse location. It is allowed to pass negative values - `int`
  x-abs - The absolute horizontal x coordinate for the mouse location It is allowed to pass negative values - `int`
  y-abs - The absolute vertical y coordinate for the mouse location It is allowed to pass negative values - `int`
  click-count - The number of mouse clicks associated with event. Passing negative value is not recommended - `int`
  popup-trigger - A boolean that equals true if this event is a trigger for a popup menu - `boolean`
  button - An integer that indicates, which of the mouse buttons has changed its state. The following rules are applied to this parameter: If support for the extended mouse buttons is disabled by Java then it is allowed to create MouseEvent objects only with the standard buttons: NOBUTTON, BUTTON1, BUTTON2, and BUTTON3. If support for the extended mouse buttons is enabled by Java then it is allowed to create MouseEvent objects with the standard buttons. In case the support for extended mouse buttons is enabled by Java, then in addition to the standard buttons, MouseEvent objects can be created using buttons from the range starting from 4 to MouseInfo.getNumberOfButtons() if the mouse has more than three buttons. - `int`

  throws: java.lang.IllegalArgumentException - if source is null"
  (^MouseEvent [^java.awt.Component source ^Integer id ^Long when ^Integer modifiers ^Integer x ^Integer y ^Integer x-abs ^Integer y-abs ^Integer click-count ^Boolean popup-trigger ^Integer button]
    (new MouseEvent source id when modifiers x y x-abs y-abs click-count popup-trigger button))
  (^MouseEvent [^java.awt.Component source ^Integer id ^Long when ^Integer modifiers ^Integer x ^Integer y ^Integer click-count ^Boolean popup-trigger ^Integer button]
    (new MouseEvent source id when modifiers x y click-count popup-trigger button))
  (^MouseEvent [^java.awt.Component source ^Integer id ^Long when ^Integer modifiers ^Integer x ^Integer y ^Integer click-count ^Boolean popup-trigger]
    (new MouseEvent source id when modifiers x y click-count popup-trigger)))

(def *-mouse-first
  "Static Constant.

  The first number in the range of ids used for mouse events.

  type: int"
  MouseEvent/MOUSE_FIRST)

(def *-mouse-last
  "Static Constant.

  The last number in the range of ids used for mouse events.

  type: int"
  MouseEvent/MOUSE_LAST)

(def *-mouse-clicked
  "Static Constant.

  The \"mouse clicked\" event. This MouseEvent
   occurs when a mouse button is pressed and released.

  type: int"
  MouseEvent/MOUSE_CLICKED)

(def *-mouse-pressed
  "Static Constant.

  The \"mouse pressed\" event. This MouseEvent
   occurs when a mouse button is pushed down.

  type: int"
  MouseEvent/MOUSE_PRESSED)

(def *-mouse-released
  "Static Constant.

  The \"mouse released\" event. This MouseEvent
   occurs when a mouse button is let up.

  type: int"
  MouseEvent/MOUSE_RELEASED)

(def *-mouse-moved
  "Static Constant.

  The \"mouse moved\" event. This MouseEvent
   occurs when the mouse position changes.

  type: int"
  MouseEvent/MOUSE_MOVED)

(def *-mouse-entered
  "Static Constant.

  The \"mouse entered\" event. This MouseEvent
   occurs when the mouse cursor enters the unobscured part of component's
   geometry.

  type: int"
  MouseEvent/MOUSE_ENTERED)

(def *-mouse-exited
  "Static Constant.

  The \"mouse exited\" event. This MouseEvent
   occurs when the mouse cursor exits the unobscured part of component's
   geometry.

  type: int"
  MouseEvent/MOUSE_EXITED)

(def *-mouse-dragged
  "Static Constant.

  The \"mouse dragged\" event. This MouseEvent
   occurs when the mouse position changes while a mouse button is pressed.

  type: int"
  MouseEvent/MOUSE_DRAGGED)

(def *-mouse-wheel
  "Static Constant.

  The \"mouse wheel\" event.  This is the only MouseWheelEvent.
   It occurs when a mouse equipped with a wheel has its wheel rotated.

  type: int"
  MouseEvent/MOUSE_WHEEL)

(def *-nobutton
  "Static Constant.

  Indicates no mouse buttons; used by getButton().

  type: int"
  MouseEvent/NOBUTTON)

(def *-button-1
  "Static Constant.

  Indicates mouse button #1; used by getButton().

  type: int"
  MouseEvent/BUTTON1)

(def *-button-2
  "Static Constant.

  Indicates mouse button #2; used by getButton().

  type: int"
  MouseEvent/BUTTON2)

(def *-button-3
  "Static Constant.

  Indicates mouse button #3; used by getButton().

  type: int"
  MouseEvent/BUTTON3)

(defn *get-mouse-modifiers-text
  "Returns a String instance describing the modifier keys and
   mouse buttons that were down during the event, such as \"Shift\",
   or \"Ctrl+Shift\". These strings can be localized by changing
   the awt.properties file.

   Note that the InputEvent.ALT_MASK and
   InputEvent.BUTTON2_MASK have equal values,
   so the \"Alt\" string is returned for both modifiers.  Likewise,
   the InputEvent.META_MASK and
   InputEvent.BUTTON3_MASK have equal values,
   so the \"Meta\" string is returned for both modifiers.

   Note that passing negative parameter is incorrect,
   and will cause the returning an unspecified string.
   Zero parameter means that no modifiers were passed and will
   cause the returning an empty string.

  modifiers - A modifier mask describing the modifier keys and mouse buttons that were down during the event - `int`

  returns: string   string text description of the combination of modifier
                    keys and mouse buttons that were down during the event - `java.lang.String`"
  (^java.lang.String [^Integer modifiers]
    (MouseEvent/getMouseModifiersText modifiers)))

(defn translate-point
  "Translates the event's coordinates to a new position
   by adding specified x (horizontal) and y
   (vertical) offsets.

  x - the horizontal x value to add to the current x coordinate position - `int`
  y - the vertical y value to add to the current y coordinate position - `int`"
  ([^MouseEvent this ^Integer x ^Integer y]
    (-> this (.translatePoint x y))))

(defn get-click-count
  "Returns the number of mouse clicks associated with this event.

  returns: integer value for the number of clicks - `int`"
  (^Integer [^MouseEvent this]
    (-> this (.getClickCount))))

(defn get-x-on-screen
  "Returns the absolute horizontal x position of the event.
   In a virtual device multi-screen environment in which the
   desktop area could span multiple physical screen devices,
   this coordinate is relative to the virtual coordinate system.
   Otherwise, this coordinate is relative to the coordinate system
   associated with the Component's GraphicsConfiguration.

  returns: x  an integer indicating absolute horizontal position. - `int`"
  (^Integer [^MouseEvent this]
    (-> this (.getXOnScreen))))

(defn get-location-on-screen
  "Returns the absolute x, y position of the event.
   In a virtual device multi-screen environment in which the
   desktop area could span multiple physical screen devices,
   these coordinates are relative to the virtual coordinate system.
   Otherwise, these coordinates are relative to the coordinate system
   associated with the Component's GraphicsConfiguration.

  returns: a Point object containing the absolute  x
    and y coordinates. - `java.awt.Point`"
  (^java.awt.Point [^MouseEvent this]
    (-> this (.getLocationOnScreen))))

(defn popup-trigger?
  "Returns whether or not this mouse event is the popup menu
   trigger event for the platform.
   Note: Popup menus are triggered differently
   on different systems. Therefore, isPopupTrigger
   should be checked in both mousePressed
   and mouseReleased
   for proper cross-platform functionality.

  returns: boolean, true if this event is the popup menu trigger
           for this platform - `boolean`"
  (^Boolean [^MouseEvent this]
    (-> this (.isPopupTrigger))))

(defn get-modifiers-ex
  "Returns the extended modifier mask for this event.

   Extended modifiers are the modifiers that ends with the _DOWN_MASK suffix,
   such as ALT_DOWN_MASK, BUTTON1_DOWN_MASK, and others.

   Extended modifiers represent the state of all modal keys,
   such as ALT, CTRL, META, and the mouse buttons just after
   the event occurred.

   For example, if the user presses button 1 followed by
   button 2, and then releases them in the same order,
   the following sequence of events is generated:


      MOUSE_PRESSED:  BUTTON1_DOWN_MASK
      MOUSE_PRESSED:  BUTTON1_DOWN_MASK | BUTTON2_DOWN_MASK
      MOUSE_RELEASED: BUTTON2_DOWN_MASK
      MOUSE_CLICKED:  BUTTON2_DOWN_MASK
      MOUSE_RELEASED:
      MOUSE_CLICKED:

   It is not recommended to compare the return value of this method
   using == because new modifiers can be added in the future.
   For example, the appropriate way to check that SHIFT and BUTTON1 are
   down, but CTRL is up is demonstrated by the following code:


      int onmask = SHIFT_DOWN_MASK | BUTTON1_DOWN_MASK;
      int offmask = CTRL_DOWN_MASK;
      if ((event.getModifiersEx() & (onmask | offmask)) == onmask) {
          ...
      }
   The above code will work even if new modifiers are added.

  returns: `int`"
  (^Integer [^MouseEvent this]
    (-> this (.getModifiersEx))))

(defn get-y-on-screen
  "Returns the absolute vertical y position of the event.
   In a virtual device multi-screen environment in which the
   desktop area could span multiple physical screen devices,
   this coordinate is relative to the virtual coordinate system.
   Otherwise, this coordinate is relative to the coordinate system
   associated with the Component's GraphicsConfiguration.

  returns: y  an integer indicating absolute vertical position. - `int`"
  (^Integer [^MouseEvent this]
    (-> this (.getYOnScreen))))

(defn get-y
  "Returns the vertical y position of the event relative to the
   source component.

  returns: y  an integer indicating vertical position relative to
              the component - `int`"
  (^Integer [^MouseEvent this]
    (-> this (.getY))))

(defn get-x
  "Returns the horizontal x position of the event relative to the
   source component.

  returns: x  an integer indicating horizontal position relative to
              the component - `int`"
  (^Integer [^MouseEvent this]
    (-> this (.getX))))

(defn get-button
  "Returns which, if any, of the mouse buttons has changed state.
   The returned value is ranged
   from 0 to the MouseInfo.getNumberOfButtons()
   value.
   The returned value includes at least the following constants:

    NOBUTTON
    BUTTON1
    BUTTON2
    BUTTON3

   It is allowed to use those constants to compare with the returned button number in the application.
   For example,


   if (anEvent.getButton() == MouseEvent.BUTTON1) {
   In particular, for a mouse with one, two, or three buttons this method may return the following values:

    0 (NOBUTTON)
    1 (BUTTON1)
    2 (BUTTON2)
    3 (BUTTON3)

   Button numbers greater then BUTTON3 have no constant identifier. So if a mouse with five buttons is
   installed, this method may return the following values:

    0 (NOBUTTON)
    1 (BUTTON1)
    2 (BUTTON2)
    3 (BUTTON3)
    4
    5


   Note: If support for extended mouse buttons is disabled by Java
   then the AWT event subsystem does not produce mouse events for the extended mouse
   buttons. So it is not expected that this method returns anything except NOBUTTON, BUTTON1,
   BUTTON2, BUTTON3.

  returns: one of the values from 0 to MouseInfo.getNumberOfButtons()
           if support for the extended mouse buttons is enabled by Java.
           That range includes NOBUTTON, BUTTON1, BUTTON2, BUTTON3;

           NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
           if support for the extended mouse buttons is disabled by Java - `int`"
  (^Integer [^MouseEvent this]
    (-> this (.getButton))))

(defn param-string
  "Returns a parameter string identifying this event.
   This method is useful for event-logging and for debugging.

  returns: a string identifying the event and its attributes - `java.lang.String`"
  (^java.lang.String [^MouseEvent this]
    (-> this (.paramString))))

(defn get-point
  "Returns the x,y position of the event relative to the source component.

  returns: a Point object containing the x and y coordinates
           relative to the source component - `java.awt.Point`"
  (^java.awt.Point [^MouseEvent this]
    (-> this (.getPoint))))

