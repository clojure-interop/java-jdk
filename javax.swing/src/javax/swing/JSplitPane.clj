(ns javax.swing.JSplitPane
  "JSplitPane is used to divide two (and only two)
  Components. The two Components
  are graphically divided based on the look and feel
  implementation, and the two Components can then be
  interactively resized by the user.
  Information on using JSplitPane is in
  How to Use Split Panes in
  The Java Tutorial.

  The two Components in a split pane can be aligned
  left to right using
  JSplitPane.HORIZONTAL_SPLIT, or top to bottom using
  JSplitPane.VERTICAL_SPLIT.
  The preferred way to change the size of the Components
  is to invoke
  setDividerLocation where location is either
  the new x or y position, depending on the orientation of the
  JSplitPane.

  To resize the Components to their preferred sizes invoke
  resetToPreferredSizes.

  When the user is resizing the Components the minimum
  size of the Components is used to determine the
  maximum/minimum position the Components
  can be set to. If the minimum size of the two
  components is greater than the size of the split pane the divider
  will not allow you to resize it. To alter the minimum size of a
  JComponent, see JComponent.setMinimumSize(java.awt.Dimension).

  When the user resizes the split pane the new space is distributed between
  the two components based on the resizeWeight property.
  A value of 0,
  the default, indicates the right/bottom component gets all the space,
  where as a value of 1 indicates the left/top component gets all the space.

  Warning: Swing is not thread safe. For more
  information see Swing's Threading
  Policy.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JSplitPane]))

(defn ->j-split-pane
  "Constructor.

  Creates a new JSplitPane with the specified
   orientation and
   redrawing style, and with the specified components.

  new-orientation - JSplitPane.HORIZONTAL_SPLIT or JSplitPane.VERTICAL_SPLIT - `int`
  new-continuous-layout - a boolean, true for the components to redraw continuously as the divider changes position, false to wait until the divider position stops changing to redraw - `boolean`
  new-left-component - the Component that will appear on the left of a horizontally-split pane, or at the top of a vertically-split pane - `java.awt.Component`
  new-right-component - the Component that will appear on the right of a horizontally-split pane, or at the bottom of a vertically-split pane - `java.awt.Component`

  throws: java.lang.IllegalArgumentException - if orientation is not one of HORIZONTAL_SPLIT or VERTICAL_SPLIT"
  ([^Integer new-orientation ^Boolean new-continuous-layout ^java.awt.Component new-left-component ^java.awt.Component new-right-component]
    (new JSplitPane new-orientation new-continuous-layout new-left-component new-right-component))
  ([^Integer new-orientation ^java.awt.Component new-left-component ^java.awt.Component new-right-component]
    (new JSplitPane new-orientation new-left-component new-right-component))
  ([^Integer new-orientation ^Boolean new-continuous-layout]
    (new JSplitPane new-orientation new-continuous-layout))
  ([^Integer new-orientation]
    (new JSplitPane new-orientation))
  ([]
    (new JSplitPane )))

(def *-vertical-split
  "Static Constant.

  Vertical split indicates the Components are
   split along the y axis.  For example the two
   Components will be split one on top of the other.

  type: int"
  JSplitPane/VERTICAL_SPLIT)

(def *-horizontal-split
  "Static Constant.

  Horizontal split indicates the Components are
   split along the x axis.  For example the two
   Components will be split one to the left of the
   other.

  type: int"
  JSplitPane/HORIZONTAL_SPLIT)

(def *-left
  "Static Constant.

  Used to add a Component to the left of the other
   Component.

  type: java.lang.String"
  JSplitPane/LEFT)

(def *-right
  "Static Constant.

  Used to add a Component to the right of the other
   Component.

  type: java.lang.String"
  JSplitPane/RIGHT)

(def *-top
  "Static Constant.

  Used to add a Component above the other
   Component.

  type: java.lang.String"
  JSplitPane/TOP)

(def *-bottom
  "Static Constant.

  Used to add a Component below the other
   Component.

  type: java.lang.String"
  JSplitPane/BOTTOM)

(def *-divider
  "Static Constant.

  Used to add a Component that will represent the divider.

  type: java.lang.String"
  JSplitPane/DIVIDER)

(def *-orientation-property
  "Static Constant.

  Bound property name for orientation (horizontal or vertical).

  type: java.lang.String"
  JSplitPane/ORIENTATION_PROPERTY)

(def *-continuous-layout-property
  "Static Constant.

  Bound property name for continuousLayout.

  type: java.lang.String"
  JSplitPane/CONTINUOUS_LAYOUT_PROPERTY)

(def *-divider-size-property
  "Static Constant.

  Bound property name for border.

  type: java.lang.String"
  JSplitPane/DIVIDER_SIZE_PROPERTY)

(def *-one-touch-expandable-property
  "Static Constant.

  Bound property for oneTouchExpandable.

  type: java.lang.String"
  JSplitPane/ONE_TOUCH_EXPANDABLE_PROPERTY)

(def *-last-divider-location-property
  "Static Constant.

  Bound property for lastLocation.

  type: java.lang.String"
  JSplitPane/LAST_DIVIDER_LOCATION_PROPERTY)

(def *-divider-location-property
  "Static Constant.

  Bound property for the dividerLocation.

  type: java.lang.String"
  JSplitPane/DIVIDER_LOCATION_PROPERTY)

(def *-resize-weight-property
  "Static Constant.

  Bound property for weight.

  type: java.lang.String"
  JSplitPane/RESIZE_WEIGHT_PROPERTY)

(defn get-top-component
  "Returns the component above, or to the left of the divider.

  returns: the Component displayed in that position - `java.awt.Component`"
  (^java.awt.Component [^javax.swing.JSplitPane this]
    (-> this (.getTopComponent))))

(defn get-right-component
  "Returns the component to the right (or below) the divider.

  returns: the Component displayed in that position - `java.awt.Component`"
  (^java.awt.Component [^javax.swing.JSplitPane this]
    (-> this (.getRightComponent))))

(defn get-orientation
  "Returns the orientation.

  returns: an integer giving the orientation - `int`"
  (^Integer [^javax.swing.JSplitPane this]
    (-> this (.getOrientation))))

(defn get-divider-location
  "Returns the last value passed to setDividerLocation.
   The value returned from this method may differ from the actual
   divider location (if setDividerLocation was passed a
   value bigger than the current size).

  returns: an integer specifying the location of the divider - `int`"
  (^Integer [^javax.swing.JSplitPane this]
    (-> this (.getDividerLocation))))

(defn set-divider-size
  "Sets the size of the divider.

  new-size - an integer giving the size of the divider in pixels - `int`"
  ([^javax.swing.JSplitPane this ^Integer new-size]
    (-> this (.setDividerSize new-size))))

(defn get-maximum-divider-location
  "Returns the maximum location of the divider from the look and feel
   implementation.

  returns: an integer specifying a UI-specific value for the maximum
            location (typically a pixel count); or -1 if the  UI is
            null - `int`"
  (^Integer [^javax.swing.JSplitPane this]
    (-> this (.getMaximumDividerLocation))))

(defn set-one-touch-expandable
  "Sets the value of the oneTouchExpandable property,
   which must be true for the
   JSplitPane to provide a UI widget
   on the divider to quickly expand/collapse the divider.
   The default value of this property is false.
   Some look and feels might not support one-touch expanding;
   they will ignore this property.

  new-value - true to specify that the split pane should provide a collapse/expand widget - `boolean`"
  ([^javax.swing.JSplitPane this ^Boolean new-value]
    (-> this (.setOneTouchExpandable new-value))))

(defn get-bottom-component
  "Returns the component below, or to the right of the divider.

  returns: the Component displayed in that position - `java.awt.Component`"
  (^java.awt.Component [^javax.swing.JSplitPane this]
    (-> this (.getBottomComponent))))

(defn set-divider-location
  "Sets the divider location as a percentage of the
   JSplitPane's size.

   This method is implemented in terms of
   setDividerLocation(int).
   This method immediately changes the size of the split pane based on
   its current size. If the split pane is not correctly realized and on
   screen, this method will have no effect (new divider location will
   become (current size * proportionalLocation) which is 0).

  proportional-location - a double-precision floating point value that specifies a percentage, from zero (top/left) to 1.0 (bottom/right) - `double`

  throws: java.lang.IllegalArgumentException - if the specified location is < 0 or > 1.0"
  ([^javax.swing.JSplitPane this ^Double proportional-location]
    (-> this (.setDividerLocation proportional-location))))

(defn set-bottom-component
  "Sets the component below, or to the right of the divider.

  comp - the Component to display in that position - `java.awt.Component`"
  ([^javax.swing.JSplitPane this ^java.awt.Component comp]
    (-> this (.setBottomComponent comp))))

(defn get-left-component
  "Returns the component to the left (or above) the divider.

  returns: the Component displayed in that position - `java.awt.Component`"
  (^java.awt.Component [^javax.swing.JSplitPane this]
    (-> this (.getLeftComponent))))

(defn get-ui-class-id
  "Returns the name of the L&F class that renders this component.

  returns: the string `SplitPaneUI` - `java.lang.String`"
  (^java.lang.String [^javax.swing.JSplitPane this]
    (-> this (.getUIClassID))))

(defn validate-root?
  "Returns true, so that calls to revalidate
   on any descendant of this JSplitPane
   will cause a request to be queued that
   will validate the JSplitPane and all its descendants.

  returns: true - `boolean`"
  (^Boolean [^javax.swing.JSplitPane this]
    (-> this (.isValidateRoot))))

(defn one-touch-expandable?
  "Gets the oneTouchExpandable property.

  returns: the value of the oneTouchExpandable property - `boolean`"
  (^Boolean [^javax.swing.JSplitPane this]
    (-> this (.isOneTouchExpandable))))

(defn set-ui
  "Sets the L&F object that renders this component.

  ui - the SplitPaneUI L&F object - `javax.swing.plaf.SplitPaneUI`"
  ([^javax.swing.JSplitPane this ^javax.swing.plaf.SplitPaneUI ui]
    (-> this (.setUI ui))))

(defn get-divider-size
  "Returns the size of the divider.

  returns: an integer giving the size of the divider in pixels - `int`"
  (^Integer [^javax.swing.JSplitPane this]
    (-> this (.getDividerSize))))

(defn reset-to-preferred-sizes
  "Lays out the JSplitPane layout based on the preferred size
   of the children components. This will likely result in changing
   the divider location."
  ([^javax.swing.JSplitPane this]
    (-> this (.resetToPreferredSizes))))

(defn remove
  "Removes the child component, component from the
   pane. Resets the leftComponent or
   rightComponent instance variable, as necessary.

  component - the Component to remove - `java.awt.Component`"
  ([^javax.swing.JSplitPane this ^java.awt.Component component]
    (-> this (.remove component))))

(defn set-last-divider-location
  "Sets the last location the divider was at to
   newLastLocation.

  new-last-location - an integer specifying the last divider location in pixels, from the left (or upper) edge of the pane to the left (or upper) edge of the divider - `int`"
  ([^javax.swing.JSplitPane this ^Integer new-last-location]
    (-> this (.setLastDividerLocation new-last-location))))

(defn get-ui
  "Returns the SplitPaneUI that is providing the
   current look and feel.

  returns: the SplitPaneUI object that renders this component - `javax.swing.plaf.SplitPaneUI`"
  (^javax.swing.plaf.SplitPaneUI [^javax.swing.JSplitPane this]
    (-> this (.getUI))))

(defn get-minimum-divider-location
  "Returns the minimum location of the divider from the look and feel
   implementation.

  returns: an integer specifying a UI-specific value for the minimum
            location (typically a pixel count); or -1 if the UI is
            null - `int`"
  (^Integer [^javax.swing.JSplitPane this]
    (-> this (.getMinimumDividerLocation))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JSplitPane.
   For split panes, the AccessibleContext takes the form of an
   AccessibleJSplitPane.
   A new AccessibleJSplitPane instance is created if necessary.

  returns: an AccessibleJSplitPane that serves as the
           AccessibleContext of this JSplitPane - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^javax.swing.JSplitPane this]
    (-> this (.getAccessibleContext))))

(defn get-resize-weight
  "Returns the number that determines how extra space is distributed.

  returns: how extra space is to be distributed on a resize of the
           split pane - `double`"
  (^Double [^javax.swing.JSplitPane this]
    (-> this (.getResizeWeight))))

(defn set-orientation
  "Sets the orientation, or how the splitter is divided. The options
   are:
   JSplitPane.VERTICAL_SPLIT  (above/below orientation of components)
   JSplitPane.HORIZONTAL_SPLIT  (left/right orientation of components)

  orientation - an integer specifying the orientation - `int`

  throws: java.lang.IllegalArgumentException - if orientation is not one of: HORIZONTAL_SPLIT or VERTICAL_SPLIT."
  ([^javax.swing.JSplitPane this ^Integer orientation]
    (-> this (.setOrientation orientation))))

(defn set-resize-weight
  "Specifies how to distribute extra space when the size of the split pane
   changes. A value of 0, the default,
   indicates the right/bottom component gets all the extra space (the
   left/top component acts fixed), where as a value of 1 specifies the
   left/top component gets all the extra space (the right/bottom component
   acts fixed). Specifically, the left/top component gets (weight * diff)
   extra space and the right/bottom component gets (1 - weight) * diff
   extra space.

  value - as described above - `double`

  throws: java.lang.IllegalArgumentException - if value is < 0 or > 1"
  ([^javax.swing.JSplitPane this ^Double value]
    (-> this (.setResizeWeight value))))

(defn set-top-component
  "Sets the component above, or to the left of the divider.

  comp - the Component to display in that position - `java.awt.Component`"
  ([^javax.swing.JSplitPane this ^java.awt.Component comp]
    (-> this (.setTopComponent comp))))

(defn get-last-divider-location
  "Returns the last location the divider was at.

  returns: an integer specifying the last divider location as a count
         of pixels from the left (or upper) edge of the pane to the
         left (or upper) edge of the divider - `int`"
  (^Integer [^javax.swing.JSplitPane this]
    (-> this (.getLastDividerLocation))))

(defn set-continuous-layout
  "Sets the value of the continuousLayout property,
   which must be true for the child components
   to be continuously
   redisplayed and laid out during user intervention.
   The default value of this property is look and feel dependent.
   Some look and feels might not support continuous layout;
   they will ignore this property.

  new-continuous-layout - true if the components should continuously be redrawn as the divider changes position - `boolean`"
  ([^javax.swing.JSplitPane this ^Boolean new-continuous-layout]
    (-> this (.setContinuousLayout new-continuous-layout))))

(defn remove-all
  "Removes all the child components from the split pane. Resets the
   leftComonent and rightComponent
   instance variables."
  ([^javax.swing.JSplitPane this]
    (-> this (.removeAll))))

(defn continuous-layout?
  "Gets the continuousLayout property.

  returns: the value of the continuousLayout property - `boolean`"
  (^Boolean [^javax.swing.JSplitPane this]
    (-> this (.isContinuousLayout))))

(defn set-left-component
  "Sets the component to the left (or above) the divider.

  comp - the Component to display in that position - `java.awt.Component`"
  ([^javax.swing.JSplitPane this ^java.awt.Component comp]
    (-> this (.setLeftComponent comp))))

(defn update-ui
  "Notification from the UIManager that the L&F has changed.
   Replaces the current UI object with the latest version from the
   UIManager."
  ([^javax.swing.JSplitPane this]
    (-> this (.updateUI))))

(defn set-right-component
  "Sets the component to the right (or below) the divider.

  comp - the Component to display in that position - `java.awt.Component`"
  ([^javax.swing.JSplitPane this ^java.awt.Component comp]
    (-> this (.setRightComponent comp))))

