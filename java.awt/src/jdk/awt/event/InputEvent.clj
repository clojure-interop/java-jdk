(ns jdk.awt.event.InputEvent
  "The root event class for all component-level input events.

  Input events are delivered to listeners before they are
  processed normally by the source where they originated.
  This allows listeners and component subclasses to `consume`
  the event so that the source will not process them in their
  default manner.  For example, consuming mousePressed events
  on a Button component will prevent the Button from being
  activated."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event InputEvent]))

(def *-shift-mask
  "Static Constant.

  The Shift key modifier constant.
   It is recommended that SHIFT_DOWN_MASK be used instead.

  type: int"
  InputEvent/SHIFT_MASK)

(def *-ctrl-mask
  "Static Constant.

  The Control key modifier constant.
   It is recommended that CTRL_DOWN_MASK be used instead.

  type: int"
  InputEvent/CTRL_MASK)

(def *-meta-mask
  "Static Constant.

  The Meta key modifier constant.
   It is recommended that META_DOWN_MASK be used instead.

  type: int"
  InputEvent/META_MASK)

(def *-alt-mask
  "Static Constant.

  The Alt key modifier constant.
   It is recommended that ALT_DOWN_MASK be used instead.

  type: int"
  InputEvent/ALT_MASK)

(def *-alt-graph-mask
  "Static Constant.

  The AltGraph key modifier constant.

  type: int"
  InputEvent/ALT_GRAPH_MASK)

(def *-button-1-mask
  "Static Constant.

  The Mouse Button1 modifier constant.
   It is recommended that BUTTON1_DOWN_MASK be used instead.

  type: int"
  InputEvent/BUTTON1_MASK)

(def *-button-2-mask
  "Static Constant.

  The Mouse Button2 modifier constant.
   It is recommended that BUTTON2_DOWN_MASK be used instead.
   Note that BUTTON2_MASK has the same value as ALT_MASK.

  type: int"
  InputEvent/BUTTON2_MASK)

(def *-button-3-mask
  "Static Constant.

  The Mouse Button3 modifier constant.
   It is recommended that BUTTON3_DOWN_MASK be used instead.
   Note that BUTTON3_MASK has the same value as META_MASK.

  type: int"
  InputEvent/BUTTON3_MASK)

(def *-shift-down-mask
  "Static Constant.

  The Shift key extended modifier constant.

  type: int"
  InputEvent/SHIFT_DOWN_MASK)

(def *-ctrl-down-mask
  "Static Constant.

  The Control key extended modifier constant.

  type: int"
  InputEvent/CTRL_DOWN_MASK)

(def *-meta-down-mask
  "Static Constant.

  The Meta key extended modifier constant.

  type: int"
  InputEvent/META_DOWN_MASK)

(def *-alt-down-mask
  "Static Constant.

  The Alt key extended modifier constant.

  type: int"
  InputEvent/ALT_DOWN_MASK)

(def *-button-1-down-mask
  "Static Constant.

  The Mouse Button1 extended modifier constant.

  type: int"
  InputEvent/BUTTON1_DOWN_MASK)

(def *-button-2-down-mask
  "Static Constant.

  The Mouse Button2 extended modifier constant.

  type: int"
  InputEvent/BUTTON2_DOWN_MASK)

(def *-button-3-down-mask
  "Static Constant.

  The Mouse Button3 extended modifier constant.

  type: int"
  InputEvent/BUTTON3_DOWN_MASK)

(def *-alt-graph-down-mask
  "Static Constant.

  The AltGraph key extended modifier constant.

  type: int"
  InputEvent/ALT_GRAPH_DOWN_MASK)

(defn *get-mask-for-button
  "A method to obtain a mask for any existing mouse button.
   The returned mask may be used for different purposes. Following are some of them:

    mousePress(buttons) and
        mouseRelease(buttons)
    as a modifiers parameter when creating a new MouseEvent instance
    to check modifiersEx of existing MouseEvent

  button - is a number to represent a button starting from 1. For example, int button = InputEvent.getMaskForButton(1); will have the same meaning as int button = InputEvent.getMaskForButton(MouseEvent.BUTTON1); because MouseEvent.BUTTON1 equals to 1. If a mouse has three enabled buttons(see MouseInfo.getNumberOfButtons()) then the values from the left column passed into the method will return corresponding values from the right column: button returned mask BUTTON1 BUTTON1_DOWN_MASK BUTTON2 BUTTON2_DOWN_MASK BUTTON3 BUTTON3_DOWN_MASK If a mouse has more than three enabled buttons then more values are admissible (4, 5, etc.). There is no assigned constants for these extended buttons. The button masks for the extra buttons returned by this method have no assigned names like the first three button masks. This method has the following implementation restriction. It returns masks for a limited number of buttons only. The maximum number is implementation dependent and may vary. This limit is defined by the relevant number of buttons that may hypothetically exist on the mouse but it is greater than the MouseInfo.getNumberOfButtons(). - `int`

  returns: `int`

  throws: java.lang.IllegalArgumentException - if button is less than zero or greater than the number of button masks reserved for buttons"
  ([button]
    (InputEvent/getMaskForButton button)))

(defn *get-modifiers-ex-text
  "Returns a String describing the extended modifier keys and
   mouse buttons, such as `Shift`, `Button1`, or `Ctrl+Shift`.
   These strings can be localized by changing the
   awt.properties file.

   Note that passing negative parameter is incorrect,
   and will cause the returning an unspecified string.
   Zero parameter means that no modifiers were passed and will
   cause the returning an empty string.

  modifiers - a modifier mask describing the extended modifier keys and mouse buttons for the event - `int`

  returns: a text description of the combination of extended
           modifier keys and mouse buttons that were held down
           during the event. - `java.lang.String`"
  ([modifiers]
    (InputEvent/getModifiersExText modifiers)))

(defn get-when
  "Returns the difference in milliseconds between the timestamp of when this event occurred and
   midnight, January 1, 1970 UTC.

  returns: `long`"
  ([this]
    (-> this (.getWhen))))

(defn consume
  "Consumes this event so that it will not be processed
   in the default manner by the source which originated it."
  ([this]
    (-> this (.consume))))

(defn alt-graph-down?
  "Returns whether or not the AltGraph modifier is down on this event.

  returns: `boolean`"
  ([this]
    (-> this (.isAltGraphDown))))

(defn get-modifiers
  "Returns the modifier mask for this event.

  returns: `int`"
  ([this]
    (-> this (.getModifiers))))

(defn control-down?
  "Returns whether or not the Control modifier is down on this event.

  returns: `boolean`"
  ([this]
    (-> this (.isControlDown))))

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
  ([this]
    (-> this (.getModifiersEx))))

(defn meta-down?
  "Returns whether or not the Meta modifier is down on this event.

  returns: `boolean`"
  ([this]
    (-> this (.isMetaDown))))

(defn consumed?
  "Returns whether or not this event has been consumed.

  returns: `boolean`"
  ([this]
    (-> this (.isConsumed))))

(defn alt-down?
  "Returns whether or not the Alt modifier is down on this event.

  returns: `boolean`"
  ([this]
    (-> this (.isAltDown))))

(defn shift-down?
  "Returns whether or not the Shift modifier is down on this event.

  returns: `boolean`"
  ([this]
    (-> this (.isShiftDown))))

