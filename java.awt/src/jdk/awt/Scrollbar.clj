(ns jdk.awt.Scrollbar
  "The Scrollbar class embodies a scroll bar, a
  familiar user-interface object. A scroll bar provides a
  convenient means for allowing a user to select from a
  range of values. The following three vertical
  scroll bars could be used as slider controls to pick
  the red, green, and blue components of a color:



  Each scroll bar in this example could be created with
  code similar to the following:



  redSlider=new Scrollbar(Scrollbar.VERTICAL, 0, 1, 0, 255);
  add(redSlider);

  Alternatively, a scroll bar can represent a range of values. For
  example, if a scroll bar is used for scrolling through text, the
  width of the `bubble` (also called the `thumb` or `scroll box`)
  can be used to represent the amount of text that is visible.
  Here is an example of a scroll bar that represents a range:



  The value range represented by the bubble in this example
  is the visible amount. The horizontal scroll bar
  in this example could be created with code like the following:



  ranger = new Scrollbar(Scrollbar.HORIZONTAL, 0, 60, 0, 300);
  add(ranger);

  Note that the actual maximum value of the scroll bar is the
  maximum minus the visible amount.
  In the previous example, because the maximum is
  300 and the visible amount is 60, the actual maximum
  value is 240.  The range of the scrollbar track is 0 - 300.
  The left side of the bubble indicates the value of the
  scroll bar.

  Normally, the user changes the value of the scroll bar by
  making a gesture with the mouse. For example, the user can
  drag the scroll bar's bubble up and down, or click in the
  scroll bar's unit increment or block increment areas. Keyboard
  gestures can also be mapped to the scroll bar. By convention,
  the Page Up and Page Down
  keys are equivalent to clicking in the scroll bar's block
  increment and block decrement areas.

  When the user changes the value of the scroll bar, the scroll bar
  receives an instance of AdjustmentEvent.
  The scroll bar processes this event, passing it along to
  any registered listeners.

  Any object that wishes to be notified of changes to the
  scroll bar's value should implement
  AdjustmentListener, an interface defined in
  the package java.awt.event.
  Listeners can be added and removed dynamically by calling
  the methods addAdjustmentListener and
  removeAdjustmentListener.

  The AdjustmentEvent class defines five types
  of adjustment event, listed here:


  AdjustmentEvent.TRACK is sent out when the
  user drags the scroll bar's bubble.
  AdjustmentEvent.UNIT_INCREMENT is sent out
  when the user clicks in the left arrow of a horizontal scroll
  bar, or the top arrow of a vertical scroll bar, or makes the
  equivalent gesture from the keyboard.
  AdjustmentEvent.UNIT_DECREMENT is sent out
  when the user clicks in the right arrow of a horizontal scroll
  bar, or the bottom arrow of a vertical scroll bar, or makes the
  equivalent gesture from the keyboard.
  AdjustmentEvent.BLOCK_INCREMENT is sent out
  when the user clicks in the track, to the left of the bubble
  on a horizontal scroll bar, or above the bubble on a vertical
  scroll bar. By convention, the Page Up
  key is equivalent, if the user is using a keyboard that
  defines a Page Up key.
  AdjustmentEvent.BLOCK_DECREMENT is sent out
  when the user clicks in the track, to the right of the bubble
  on a horizontal scroll bar, or below the bubble on a vertical
  scroll bar. By convention, the Page Down
  key is equivalent, if the user is using a keyboard that
  defines a Page Down key.


  The JDK 1.0 event system is supported for backwards
  compatibility, but its use with newer versions of the platform is
  discouraged. The five types of adjustment events introduced
  with JDK 1.1 correspond to the five event types
  that are associated with scroll bars in previous platform versions.
  The following list gives the adjustment event type,
  and the corresponding JDK 1.0 event type it replaces.


  AdjustmentEvent.TRACK replaces
  Event.SCROLL_ABSOLUTE
  AdjustmentEvent.UNIT_INCREMENT replaces
  Event.SCROLL_LINE_UP
  AdjustmentEvent.UNIT_DECREMENT replaces
  Event.SCROLL_LINE_DOWN
  AdjustmentEvent.BLOCK_INCREMENT replaces
  Event.SCROLL_PAGE_UP
  AdjustmentEvent.BLOCK_DECREMENT replaces
  Event.SCROLL_PAGE_DOWN


  Note: We recommend using a Scrollbar
  for value selection only.  If you want to implement
  a scrollable component inside a container, we recommend you use
  a ScrollPane. If you use a
  Scrollbar for this purpose, you are likely to
  encounter issues with painting, key handling, sizing and
  positioning."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Scrollbar]))

(defn ->scrollbar
  "Constructor.

  Constructs a new scroll bar with the specified orientation,
   initial value, visible amount, and minimum and maximum values.

   The orientation argument must take one of the two
   values Scrollbar.HORIZONTAL,
   or Scrollbar.VERTICAL,
   indicating a horizontal or vertical scroll bar, respectively.

   The parameters supplied to this constructor are subject to the
   constraints described in setValues(int, int, int, int).

  orientation - indicates the orientation of the scroll bar. - `int`
  value - the initial value of the scroll bar - `int`
  visible - the visible amount of the scroll bar, typically represented by the size of the bubble - `int`
  minimum - the minimum value of the scroll bar - `int`
  maximum - the maximum value of the scroll bar - `int`

  throws: java.lang.IllegalArgumentException - when an illegal value for the orientation argument is supplied"
  ([orientation value visible minimum maximum]
    (new Scrollbar orientation value visible minimum maximum))
  ([orientation]
    (new Scrollbar orientation))
  ([]
    (new Scrollbar )))

(def *-horizontal
  "Static Constant.

  A constant that indicates a horizontal scroll bar.

  type: int"
  Scrollbar/HORIZONTAL)

(def *-vertical
  "Static Constant.

  A constant that indicates a vertical scroll bar.

  type: int"
  Scrollbar/VERTICAL)

(defn get-adjustment-listeners
  "Returns an array of all the adjustment listeners
   registered on this scrollbar.

  returns: all of this scrollbar's AdjustmentListeners
           or an empty array if no adjustment
           listeners are currently registered - `java.awt.event.AdjustmentListener[]`"
  ([this]
    (-> this (.getAdjustmentListeners))))

(defn get-visible-amount
  "Gets the visible amount of this scroll bar.

   When a scroll bar is used to select a range of values,
   the visible amount is used to represent the range of values
   that are currently visible.  The size of the scroll bar's
   bubble (also called a thumb or scroll box), usually gives a
   visual representation of the relationship of the visible
   amount to the range of the scroll bar.
   Note that depending on platform, the value of the visible amount property
   may not be visually indicated by the size of the bubble.

   The scroll bar's bubble may not be displayed when it is not
   moveable (e.g. when it takes up the entire length of the
   scroll bar's track, or when the scroll bar is disabled).
   Whether the bubble is displayed or not will not affect
   the value returned by getVisibleAmount.

  returns: the visible amount of this scroll bar - `int`"
  ([this]
    (-> this (.getVisibleAmount))))

(defn set-block-increment
  "Sets the block increment for this scroll bar.

   The block increment is the value that is added or subtracted
   when the user activates the block increment area of the
   scroll bar, generally through a mouse or keyboard gesture
   that the scroll bar receives as an adjustment event.
   The block increment must be greater than zero.
   Attepts to set the block increment to a value lower than 1
   will result in a value of 1 being set.

  v - the amount by which to increment or decrement the scroll bar's value - `int`"
  ([this v]
    (-> this (.setBlockIncrement v))))

(defn get-value-is-adjusting?
  "Returns true if the value is in the process of changing as a
   result of actions being taken by the user.

  returns: the value of the valueIsAdjusting property - `boolean`"
  ([this]
    (-> this (.getValueIsAdjusting))))

(defn get-orientation
  "Returns the orientation of this scroll bar.

  returns: the orientation of this scroll bar, either
                 Scrollbar.HORIZONTAL or
                 Scrollbar.VERTICAL - `int`"
  ([this]
    (-> this (.getOrientation))))

(defn get-minimum
  "Gets the minimum value of this scroll bar.

  returns: the minimum value of this scroll bar - `int`"
  ([this]
    (-> this (.getMinimum))))

(defn get-unit-increment
  "Gets the unit increment for this scrollbar.

   The unit increment is the value that is added or subtracted
   when the user activates the unit increment area of the
   scroll bar, generally through a mouse or keyboard gesture
   that the scroll bar receives as an adjustment event.
   The unit increment must be greater than zero.

   In some operating systems, this property
   can be ignored by the underlying controls.

  returns: the unit increment of this scroll bar - `int`"
  ([this]
    (-> this (.getUnitIncrement))))

(defn get-block-increment
  "Gets the block increment of this scroll bar.

   The block increment is the value that is added or subtracted
   when the user activates the block increment area of the
   scroll bar, generally through a mouse or keyboard gesture
   that the scroll bar receives as an adjustment event.
   The block increment must be greater than zero.

  returns: the block increment of this scroll bar - `int`"
  ([this]
    (-> this (.getBlockIncrement))))

(defn add-adjustment-listener
  "Adds the specified adjustment listener to receive instances of
   AdjustmentEvent from this scroll bar.
   If l is null, no exception is thrown and no
   action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the adjustment listener - `java.awt.event.AdjustmentListener`"
  ([this l]
    (-> this (.addAdjustmentListener l))))

(defn set-line-increment
  "Deprecated. As of JDK version 1.1,
   replaced by setUnitIncrement(int).

  v - `int`

  returns: `java.lang.  void`"
  ([this v]
    (-> this (.setLineIncrement v))))

(defn get-value
  "Gets the current value of this scroll bar.

  returns: the current value of this scroll bar - `int`"
  ([this]
    (-> this (.getValue))))

(defn remove-adjustment-listener
  "Removes the specified adjustment listener so that it no longer
   receives instances of AdjustmentEvent from this scroll bar.
   If l is null, no exception is thrown and no action
   is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the adjustment listener - `java.awt.event.AdjustmentListener`"
  ([this l]
    (-> this (.removeAdjustmentListener l))))

(defn add-notify
  "Creates the Scrollbar's peer.  The peer allows you to modify
   the appearance of the Scrollbar without changing any of its
   functionality."
  ([this]
    (-> this (.addNotify))))

(defn set-maximum
  "Sets the maximum value of this scroll bar.

   When setMaximum is called, the maximum value
   is changed, and other values (including the minimum, the
   visible amount, and the current scroll bar value)
   are changed to be consistent with the new maximum.

   Normally, a program should change a scroll bar's maximum
   value only by calling setValues.
   The setValues method simultaneously
   and synchronously sets the minimum, maximum, visible amount,
   and value properties of a scroll bar, so that they are
   mutually consistent.

   Note that setting the maximum value to Integer.MIN_VALUE
   will result in the new maximum value being set to
   Integer.MIN_VALUE  1.

  new-maximum - the new maximum value for this scroll bar - `int`"
  ([this new-maximum]
    (-> this (.setMaximum new-maximum))))

(defn set-value-is-adjusting
  "Sets the valueIsAdjusting property.

  b - new adjustment-in-progress status - `boolean`"
  ([this b]
    (-> this (.setValueIsAdjusting b))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this
   Scrollbar. For scrollbars, the
   AccessibleContext takes the form of an
   AccessibleAWTScrollBar. A new
   AccessibleAWTScrollBar instance is created if necessary.

  returns: an AccessibleAWTScrollBar that serves as the
           AccessibleContext of this ScrollBar - `javax.accessibility.AccessibleContext`"
  ([this]
    (-> this (.getAccessibleContext))))

(defn set-values
  "Sets the values of four properties for this scroll bar:
   value, visibleAmount,
   minimum, and maximum.
   If the values supplied for these properties are inconsistent
   or incorrect, they will be changed to ensure consistency.

   This method simultaneously and synchronously sets the values
   of four scroll bar properties, assuring that the values of
   these properties are mutually consistent. It enforces the
   following constraints:
   maximum must be greater than minimum,
   maximum - minimum must not be greater
       than Integer.MAX_VALUE,
   visibleAmount must be greater than zero.
   visibleAmount must not be greater than
       maximum - minimum,
   value must not be less than minimum,
   and value must not be greater than
       maximum - visibleAmount

   Calling this method does not fire an
   AdjustmentEvent.

  value - is the position in the current window - `int`
  visible - is the visible amount of the scroll bar - `int`
  minimum - is the minimum value of the scroll bar - `int`
  maximum - is the maximum value of the scroll bar - `int`"
  ([this value visible minimum maximum]
    (-> this (.setValues value visible minimum maximum))))

(defn set-unit-increment
  "Sets the unit increment for this scroll bar.

   The unit increment is the value that is added or subtracted
   when the user activates the unit increment area of the
   scroll bar, generally through a mouse or keyboard gesture
   that the scroll bar receives as an adjustment event.
   The unit increment must be greater than zero.
   Attepts to set the unit increment to a value lower than 1
   will result in a value of 1 being set.

   In some operating systems, this property
   can be ignored by the underlying controls.

  v - the amount by which to increment or decrement the scroll bar's value - `int`"
  ([this v]
    (-> this (.setUnitIncrement v))))

(defn set-value
  "Sets the value of this scroll bar to the specified value.

   If the value supplied is less than the current minimum
   or greater than the current maximum - visibleAmount,
   then either minimum or maximum - visibleAmount
   is substituted, as appropriate.

   Normally, a program should change a scroll bar's
   value only by calling setValues.
   The setValues method simultaneously
   and synchronously sets the minimum, maximum, visible amount,
   and value properties of a scroll bar, so that they are
   mutually consistent.

   Calling this method does not fire an
   AdjustmentEvent.

  new-value - the new value of the scroll bar - `int`"
  ([this new-value]
    (-> this (.setValue new-value))))

(defn set-orientation
  "Sets the orientation for this scroll bar.

  orientation - the orientation of this scroll bar, either Scrollbar.HORIZONTAL or Scrollbar.VERTICAL - `int`

  throws: java.lang.IllegalArgumentException - if the value supplied for orientation is not a legal value"
  ([this orientation]
    (-> this (.setOrientation orientation))))

(defn set-page-increment
  "Deprecated. As of JDK version 1.1,
   replaced by setBlockIncrement().

  v - `int`

  returns: `java.lang.  void`"
  ([this v]
    (-> this (.setPageIncrement v))))

(defn get-visible
  "Deprecated. As of JDK version 1.1,
   replaced by getVisibleAmount().

  returns: `java.lang.  int`"
  ([this]
    (-> this (.getVisible))))

(defn get-line-increment
  "Deprecated. As of JDK version 1.1,
   replaced by getUnitIncrement().

  returns: `java.lang.  int`"
  ([this]
    (-> this (.getLineIncrement))))

(defn set-visible-amount
  "Sets the visible amount of this scroll bar.

   When a scroll bar is used to select a range of values,
   the visible amount is used to represent the range of values
   that are currently visible.  The size of the scroll bar's
   bubble (also called a thumb or scroll box), usually gives a
   visual representation of the relationship of the visible
   amount to the range of the scroll bar.
   Note that depending on platform, the value of the visible amount property
   may not be visually indicated by the size of the bubble.

   The scroll bar's bubble may not be displayed when it is not
   moveable (e.g. when it takes up the entire length of the
   scroll bar's track, or when the scroll bar is disabled).
   Whether the bubble is displayed or not will not affect
   the value returned by getVisibleAmount.

   If the visible amount supplied is less than one
   or greater than the current maximum - minimum,
   then either one or maximum - minimum
   is substituted, as appropriate.

   Normally, a program should change a scroll bar's
   value only by calling setValues.
   The setValues method simultaneously
   and synchronously sets the minimum, maximum, visible amount,
   and value properties of a scroll bar, so that they are
   mutually consistent.

  new-amount - the new visible amount - `int`"
  ([this new-amount]
    (-> this (.setVisibleAmount new-amount))))

(defn get-listeners
  "Returns an array of all the objects currently registered
   as FooListeners
   upon this Scrollbar.
   FooListeners are registered using the
   addFooListener method.

   You can specify the listenerType argument
   with a class literal,  such as
   FooListener.class.
   For example, you can query a
   Scrollbar c
   for its mouse listeners with the following code:



  MouseListener[] mls = (MouseListener[])(c.getListeners(MouseListener.class));

   If no such listeners exist, this method returns an empty array.

  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class<T>`

  returns: an array of all objects registered as
            FooListeners on this component,
            or an empty array if no such listeners have been added - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if listenerType doesn't specify a class or interface that implements java.util.EventListener"
  ([this listener-type]
    (-> this (.getListeners listener-type))))

(defn set-minimum
  "Sets the minimum value of this scroll bar.

   When setMinimum is called, the minimum value
   is changed, and other values (including the maximum, the
   visible amount, and the current scroll bar value)
   are changed to be consistent with the new minimum.

   Normally, a program should change a scroll bar's minimum
   value only by calling setValues.
   The setValues method simultaneously
   and synchronously sets the minimum, maximum, visible amount,
   and value properties of a scroll bar, so that they are
   mutually consistent.

   Note that setting the minimum value to Integer.MAX_VALUE
   will result in the new minimum value being set to
   Integer.MAX_VALUE - 1.

  new-minimum - the new minimum value for this scroll bar - `int`"
  ([this new-minimum]
    (-> this (.setMinimum new-minimum))))

(defn get-maximum
  "Gets the maximum value of this scroll bar.

  returns: the maximum value of this scroll bar - `int`"
  ([this]
    (-> this (.getMaximum))))

(defn get-page-increment
  "Deprecated. As of JDK version 1.1,
   replaced by getBlockIncrement().

  returns: `java.lang.  int`"
  ([this]
    (-> this (.getPageIncrement))))

