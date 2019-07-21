(ns jdk.awt.ScrollPane
  "A container class which implements automatic horizontal and/or
  vertical scrolling for a single child component.  The display
  policy for the scrollbars can be set to:

  as needed: scrollbars created and shown only when needed by scrollpane
  always: scrollbars created and always shown by the scrollpane
  never: scrollbars never created or shown by the scrollpane


  The state of the horizontal and vertical scrollbars is represented
  by two ScrollPaneAdjustable objects (one for each
  dimension) which implement the Adjustable interface.
  The API provides methods to access those objects such that the
  attributes on the Adjustable object (such as unitIncrement, value,
  etc.) can be manipulated.

  Certain adjustable properties (minimum, maximum, blockIncrement,
  and visibleAmount) are set internally by the scrollpane in accordance
  with the geometry of the scrollpane and its child and these should
  not be set by programs using the scrollpane.

  If the scrollbar display policy is defined as \"never\", then the
  scrollpane can still be programmatically scrolled using the
  setScrollPosition() method and the scrollpane will move and clip
  the child's contents appropriately.  This policy is useful if the
  program needs to create and manage its own adjustable controls.

  The placement of the scrollbars is controlled by platform-specific
  properties set by the user outside of the program.

  The initial size of this container is set to 100x100, but can
  be reset using setSize().

  Scrolling with the wheel on a wheel-equipped mouse is enabled by default.
  This can be disabled using setWheelScrollingEnabled.
  Wheel scrolling can be customized by setting the block and
  unit increment of the horizontal and vertical Adjustables.
  For information on how mouse wheel events are dispatched, see
  the class description for MouseWheelEvent.

  Insets are used to define any space used by scrollbars and any
  borders created by the scroll pane. getInsets() can be used
  to get the current value for the insets.  If the value of
  scrollbarsAlwaysVisible is false, then the value of the insets
  will change dynamically depending on whether the scrollbars are
  currently visible or not."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt ScrollPane]))

(defn ->scroll-pane
  "Constructor.

  Create a new scrollpane container.

  scrollbar-display-policy - policy for when scrollbars should be shown - `int`

  throws: java.lang.IllegalArgumentException - if the specified scrollbar display policy is invalid"
  (^ScrollPane [^Integer scrollbar-display-policy]
    (new ScrollPane scrollbar-display-policy))
  (^ScrollPane []
    (new ScrollPane )))

(def *-scrollbars-as-needed
  "Static Constant.

  Specifies that horizontal/vertical scrollbar should be shown
   only when the size of the child exceeds the size of the scrollpane
   in the horizontal/vertical dimension.

  type: int"
  ScrollPane/SCROLLBARS_AS_NEEDED)

(def *-scrollbars-always
  "Static Constant.

  Specifies that horizontal/vertical scrollbars should always be
   shown regardless of the respective sizes of the scrollpane and child.

  type: int"
  ScrollPane/SCROLLBARS_ALWAYS)

(def *-scrollbars-never
  "Static Constant.

  Specifies that horizontal/vertical scrollbars should never be shown
   regardless of the respective sizes of the scrollpane and child.

  type: int"
  ScrollPane/SCROLLBARS_NEVER)

(defn set-layout
  "Sets the layout manager for this container.  This method is
   overridden to prevent the layout mgr from being set.

  mgr - the specified layout manager - `java.awt.LayoutManager`"
  ([^ScrollPane this ^java.awt.LayoutManager mgr]
    (-> this (.setLayout mgr))))

(defn get-scroll-position
  "Returns the current x,y position within the child which is displayed
   at the 0,0 location of the scrolled panel's view port.
   This is a convenience method which interfaces with the adjustable
   objects which represent the state of the scrollbars.

  returns: the coordinate position for the current scroll position - `java.awt.Point`

  throws: java.lang.NullPointerException - if the scrollpane does not contain a child"
  (^java.awt.Point [^ScrollPane this]
    (-> this (.getScrollPosition))))

(defn get-v-scrollbar-width
  "Returns the width that would be occupied by a vertical
   scrollbar, which is independent of whether it is currently
   displayed by the scroll pane or not.

  returns: the width of a vertical scrollbar in pixels - `int`"
  (^Integer [^ScrollPane this]
    (-> this (.getVScrollbarWidth))))

(defn get-v-adjustable
  "Returns the ScrollPaneAdjustable object which
   represents the state of the vertical scrollbar.
   The declared return type of this method is
   Adjustable to maintain backward compatibility.

  returns: `java.awt.Adjustable`"
  (^java.awt.Adjustable [^ScrollPane this]
    (-> this (.getVAdjustable))))

(defn get-scrollbar-display-policy
  "Returns the display policy for the scrollbars.

  returns: the display policy for the scrollbars - `int`"
  (^Integer [^ScrollPane this]
    (-> this (.getScrollbarDisplayPolicy))))

(defn get-viewport-size
  "Returns the current size of the scroll pane's view port.

  returns: the size of the view port in pixels - `java.awt.Dimension`"
  (^java.awt.Dimension [^ScrollPane this]
    (-> this (.getViewportSize))))

(defn get-h-scrollbar-height
  "Returns the height that would be occupied by a horizontal
   scrollbar, which is independent of whether it is currently
   displayed by the scroll pane or not.

  returns: the height of a horizontal scrollbar in pixels - `int`"
  (^Integer [^ScrollPane this]
    (-> this (.getHScrollbarHeight))))

(defn add-notify
  "Creates the scroll pane's peer."
  ([^ScrollPane this]
    (-> this (.addNotify))))

(defn layout
  "Deprecated. As of JDK version 1.1,
   replaced by doLayout()."
  ([^ScrollPane this]
    (-> this (.layout))))

(defn set-wheel-scrolling-enabled
  "Enables/disables scrolling in response to movement of the mouse wheel.
   Wheel scrolling is enabled by default.

  handle-wheel - true if scrolling should be done automatically for a MouseWheelEvent, false otherwise. - `boolean`"
  ([^ScrollPane this ^Boolean handle-wheel]
    (-> this (.setWheelScrollingEnabled handle-wheel))))

(defn print-components
  "Prints the component in this scroll pane.

  g - the specified Graphics window - `java.awt.Graphics`"
  ([^ScrollPane this ^java.awt.Graphics g]
    (-> this (.printComponents g))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this ScrollPane.
   For scroll panes, the AccessibleContext takes the form of an
   AccessibleAWTScrollPane.
   A new AccessibleAWTScrollPane instance is created if necessary.

  returns: an AccessibleAWTScrollPane that serves as the
           AccessibleContext of this ScrollPane - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^ScrollPane this]
    (-> this (.getAccessibleContext))))

(defn param-string
  "Returns a string representing the state of this
   ScrollPane. This
   method is intended to be used only for debugging purposes, and the
   content and format of the returned string may vary between
   implementations. The returned string may be empty but may not be
   null.

  returns: the parameter string of this scroll pane - `java.lang.String`"
  (^java.lang.String [^ScrollPane this]
    (-> this (.paramString))))

(defn set-scroll-position
  "Scrolls to the specified position within the child component.
   A call to this method is only valid if the scroll pane contains
   a child.  Specifying a position outside of the legal scrolling bounds
   of the child will scroll to the closest legal position.
   Legal bounds are defined to be the rectangle:
   x = 0, y = 0, width = (child width - view port width),
   height = (child height - view port height).
   This is a convenience method which interfaces with the Adjustable
   objects which represent the state of the scrollbars.

  x - the x position to scroll to - `int`
  y - the y position to scroll to - `int`

  throws: java.lang.NullPointerException - if the scrollpane does not contain a child"
  ([^ScrollPane this ^Integer x ^Integer y]
    (-> this (.setScrollPosition x y)))
  ([^ScrollPane this ^java.awt.Point p]
    (-> this (.setScrollPosition p))))

(defn do-layout
  "Lays out this container by resizing its child to its preferred size.
   If the new preferred size of the child causes the current scroll
   position to be invalid, the scroll position is set to the closest
   valid position."
  ([^ScrollPane this]
    (-> this (.doLayout))))

(defn get-h-adjustable
  "Returns the ScrollPaneAdjustable object which
   represents the state of the horizontal scrollbar.
   The declared return type of this method is
   Adjustable to maintain backward compatibility.

  returns: `java.awt.Adjustable`"
  (^java.awt.Adjustable [^ScrollPane this]
    (-> this (.getHAdjustable))))

(defn wheel-scrolling-enabled?
  "Indicates whether or not scrolling will take place in response to
   the mouse wheel.  Wheel scrolling is enabled by default.

  returns: `boolean`"
  (^Boolean [^ScrollPane this]
    (-> this (.isWheelScrollingEnabled))))

