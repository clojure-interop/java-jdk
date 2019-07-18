(ns jdk.awt.event.MouseWheelEvent
  "An event which indicates that the mouse wheel was rotated in a component.

  A wheel mouse is a mouse which has a wheel in place of the middle button.
  This wheel can be rotated towards or away from the user.  Mouse wheels are
  most often used for scrolling, though other uses are possible.

  A MouseWheelEvent object is passed to every MouseWheelListener
  object which registered to receive the `interesting` mouse events using the
  component's addMouseWheelListener method.  Each such listener
  object gets a MouseEvent containing the mouse event.

  Due to the mouse wheel's special relationship to scrolling Components,
  MouseWheelEvents are delivered somewhat differently than other MouseEvents.
  This is because while other MouseEvents usually affect a change on
  the Component directly under the mouse
  cursor (for instance, when clicking a button), MouseWheelEvents often have
  an effect away from the mouse cursor (moving the wheel while
  over a Component inside a ScrollPane should scroll one of the
  Scrollbars on the ScrollPane).

  MouseWheelEvents start delivery from the Component underneath the
  mouse cursor.  If MouseWheelEvents are not enabled on the
  Component, the event is delivered to the first ancestor
  Container with MouseWheelEvents enabled.  This will usually be
  a ScrollPane with wheel scrolling enabled.  The source
  Component and x,y coordinates will be relative to the event's
  final destination (the ScrollPane).  This allows a complex
  GUI to be installed without modification into a ScrollPane, and
  for all MouseWheelEvents to be delivered to the ScrollPane for
  scrolling.

  Some AWT Components are implemented using native widgets which
  display their own scrollbars and handle their own scrolling.
  The particular Components for which this is true will vary from
  platform to platform.  When the mouse wheel is
  moved over one of these Components, the event is delivered straight to
  the native widget, and not propagated to ancestors.

  Platforms offer customization of the amount of scrolling that
  should take place when the mouse wheel is moved.  The two most
  common settings are to scroll a certain number of `units`
  (commonly lines of text in a text-based component) or an entire `block`
  (similar to page-up/page-down).  The MouseWheelEvent offers
  methods for conforming to the underlying platform settings.  These
  platform settings can be changed at any time by the user.  MouseWheelEvents
  reflect the most recent settings.

  The MouseWheelEvent class includes methods for
  getting the number of `clicks` by which the mouse wheel is rotated.
  The getWheelRotation() method returns the integer number
  of `clicks` corresponding to the number of notches by which the wheel was
  rotated. In addition to this method, the MouseWheelEvent
  class provides the getPreciseWheelRotation() method which returns
  a double number of `clicks` in case a partial rotation occurred.
  The getPreciseWheelRotation() method is useful if a mouse supports
  a high-resolution wheel, such as a freely rotating wheel with no
  notches. Applications can benefit by using this method to process
  mouse wheel events more precisely, and thus, making visual perception
  smoother."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event MouseWheelEvent]))

(defn ->mouse-wheel-event
  "Constructor.

  Constructs a MouseWheelEvent object with the specified
   source component, type, modifiers, coordinates, absolute coordinates,
   scroll type, scroll amount, and wheel rotation.
   Note that passing in an invalid id parameter results
   in unspecified behavior. This method throws an
   IllegalArgumentException if source equals
   null.
   Even if inconsistent values for relative and absolute coordinates
   are passed to the constructor, a MouseWheelEvent instance
   is still created and no exception is thrown.

  source - the Component that originated the event - `java.awt.Component`
  id - the integer value that identifies the event - `int`
  when - a long value that gives the time when the event occurred - `long`
  modifiers - the modifier keys down during event (shift, ctrl, alt, meta) - `int`
  x - the horizontal x coordinate for the mouse location - `int`
  y - the vertical y coordinate for the mouse location - `int`
  x-abs - the absolute horizontal x coordinate for the mouse location - `int`
  y-abs - the absolute vertical y coordinate for the mouse location - `int`
  click-count - the number of mouse clicks associated with the event - `int`
  popup-trigger - a boolean value, true if this event is a trigger for a popup-menu - `boolean`
  scroll-type - the type of scrolling which should take place in response to this event; valid values are WHEEL_UNIT_SCROLL and WHEEL_BLOCK_SCROLL - `int`
  scroll-amount - for scrollType WHEEL_UNIT_SCROLL, the number of units to be scrolled - `int`
  wheel-rotation - the integer number of `clicks` by which the mouse wheel was rotated - `int`
  precise-wheel-rotation - the double number of `clicks` by which the mouse wheel was rotated - `double`

  throws: java.lang.IllegalArgumentException - if source is null"
  (^MouseWheelEvent [^java.awt.Component source ^Integer id ^Long when ^Integer modifiers ^Integer x ^Integer y ^Integer x-abs ^Integer y-abs ^Integer click-count ^Boolean popup-trigger ^Integer scroll-type ^Integer scroll-amount ^Integer wheel-rotation ^Double precise-wheel-rotation]
    (new MouseWheelEvent source id when modifiers x y x-abs y-abs click-count popup-trigger scroll-type scroll-amount wheel-rotation precise-wheel-rotation))
  (^MouseWheelEvent [^java.awt.Component source ^Integer id ^Long when ^Integer modifiers ^Integer x ^Integer y ^Integer x-abs ^Integer y-abs ^Integer click-count ^Boolean popup-trigger ^Integer scroll-type ^Integer scroll-amount ^Integer wheel-rotation]
    (new MouseWheelEvent source id when modifiers x y x-abs y-abs click-count popup-trigger scroll-type scroll-amount wheel-rotation))
  (^MouseWheelEvent [^java.awt.Component source ^Integer id ^Long when ^Integer modifiers ^Integer x ^Integer y ^Integer click-count ^Boolean popup-trigger ^Integer scroll-type ^Integer scroll-amount ^Integer wheel-rotation]
    (new MouseWheelEvent source id when modifiers x y click-count popup-trigger scroll-type scroll-amount wheel-rotation)))

(def *-wheel-unit-scroll
  "Static Constant.

  Constant representing scrolling by `units` (like scrolling with the
   arrow keys)

  type: int"
  MouseWheelEvent/WHEEL_UNIT_SCROLL)

(def *-wheel-block-scroll
  "Static Constant.

  Constant representing scrolling by a `block` (like scrolling
   with page-up, page-down keys)

  type: int"
  MouseWheelEvent/WHEEL_BLOCK_SCROLL)

(defn get-scroll-type
  "Returns the type of scrolling that should take place in response to this
   event.  This is determined by the native platform.  Legal values are:

    MouseWheelEvent.WHEEL_UNIT_SCROLL
    MouseWheelEvent.WHEEL_BLOCK_SCROLL

  returns: either MouseWheelEvent.WHEEL_UNIT_SCROLL or
    MouseWheelEvent.WHEEL_BLOCK_SCROLL, depending on the configuration of
    the native platform. - `int`"
  (^Integer [^MouseWheelEvent this]
    (-> this (.getScrollType))))

(defn get-scroll-amount
  "Returns the number of units that should be scrolled per
   click of mouse wheel rotation.
   Only valid if getScrollType returns
   MouseWheelEvent.WHEEL_UNIT_SCROLL

  returns: number of units to scroll, or an undefined value if
    getScrollType returns
    MouseWheelEvent.WHEEL_BLOCK_SCROLL - `int`"
  (^Integer [^MouseWheelEvent this]
    (-> this (.getScrollAmount))))

(defn get-wheel-rotation
  "Returns the number of `clicks` the mouse wheel was rotated, as an integer.
   A partial rotation may occur if the mouse supports a high-resolution wheel.
   In this case, the method returns zero until a full `click` has been accumulated.

  returns: negative values if the mouse wheel was rotated up/away from
   the user, and positive values if the mouse wheel was rotated down/
   towards the user - `int`"
  (^Integer [^MouseWheelEvent this]
    (-> this (.getWheelRotation))))

(defn get-precise-wheel-rotation
  "Returns the number of `clicks` the mouse wheel was rotated, as a double.
   A partial rotation may occur if the mouse supports a high-resolution wheel.
   In this case, the return value will include a fractional `click`.

  returns: negative values if the mouse wheel was rotated up or away from
   the user, and positive values if the mouse wheel was rotated down or
   towards the user - `double`"
  (^Double [^MouseWheelEvent this]
    (-> this (.getPreciseWheelRotation))))

(defn get-units-to-scroll
  "This is a convenience method to aid in the implementation of
   the common-case MouseWheelListener - to scroll a ScrollPane or
   JScrollPane by an amount which conforms to the platform settings.
   (Note, however, that ScrollPane and
   JScrollPane already have this functionality built in.)

   This method returns the number of units to scroll when scroll type is
   MouseWheelEvent.WHEEL_UNIT_SCROLL, and should only be called if
   getScrollType returns MouseWheelEvent.WHEEL_UNIT_SCROLL.

   Direction of scroll, amount of wheel movement,
   and platform settings for wheel scrolling are all accounted for.
   This method does not and cannot take into account value of the
   Adjustable/Scrollable unit increment, as this will vary among
   scrolling components.

   A simplified example of how this method might be used in a
   listener:


    mouseWheelMoved(MouseWheelEvent event) {
        ScrollPane sp = getScrollPaneFromSomewhere();
        Adjustable adj = sp.getVAdjustable()
        if (MouseWheelEvent.getScrollType() == WHEEL_UNIT_SCROLL) {
            int totalScrollAmount =
                event.getUnitsToScroll() *
                adj.getUnitIncrement();
            adj.setValue(adj.getValue()  totalScrollAmount);
        }
    }

  returns: the number of units to scroll based on the direction and amount
    of mouse wheel rotation, and on the wheel scrolling settings of the
    native platform - `int`"
  (^Integer [^MouseWheelEvent this]
    (-> this (.getUnitsToScroll))))

(defn param-string
  "Returns a parameter string identifying this event.
   This method is useful for event-logging and for debugging.

  returns: a string identifying the event and its attributes - `java.lang.String`"
  (^java.lang.String [^MouseWheelEvent this]
    (-> this (.paramString))))

