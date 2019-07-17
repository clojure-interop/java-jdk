(ns javax.swing.JToolBar
  "JToolBar provides a component that is useful for
  displaying commonly used Actions or controls.
  For examples and information on using tool bars see
  How to Use Tool Bars,
  a section in The Java Tutorial.


  With most look and feels,
  the user can drag out a tool bar into a separate window
  (unless the floatable property is set to false).
  For drag-out to work correctly, it is recommended that you add
  JToolBar instances to one of the four `sides` of a
  container whose layout manager is a BorderLayout,
  and do not add children to any of the other four `sides`.

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
  (:import [javax.swing JToolBar]))

(defn ->j-tool-bar
  "Constructor.

  Creates a new tool bar with a specified name and
   orientation.
   All other constructors call this constructor.
   If orientation is an invalid value, an exception will
   be thrown.

  name - the name of the tool bar - `java.lang.String`
  orientation - the initial orientation -- it must be either HORIZONTAL or VERTICAL - `int`

  throws: java.lang.IllegalArgumentException - if orientation is neither HORIZONTAL nor VERTICAL"
  ([^java.lang.String name ^Integer orientation]
    (new JToolBar name orientation))
  ([^Integer orientation]
    (new JToolBar orientation))
  ([]
    (new JToolBar )))

(defn get-orientation
  "Returns the current orientation of the tool bar.  The value is either
   HORIZONTAL or VERTICAL.

  returns: an integer representing the current orientation -- either
            HORIZONTAL or VERTICAL - `int`"
  ([^javax.swing.JToolBar this]
    (-> this (.getOrientation))))

(defn set-floatable
  "Sets the floatable property,
   which must be true for the user to move the tool bar.
   Typically, a floatable tool bar can be
   dragged into a different position within the same container
   or out into its own window.
   The default value of this property is true.
   Some look and feels might not implement floatable tool bars;
   they will ignore this property.

  b - if true, the tool bar can be moved; false otherwise - `boolean`"
  ([^javax.swing.JToolBar this ^Boolean b]
    (-> this (.setFloatable b))))

(defn set-layout
  "Description copied from class: Container

  mgr - the specified layout manager - `java.awt.LayoutManager`"
  ([^javax.swing.JToolBar this ^java.awt.LayoutManager mgr]
    (-> this (.setLayout mgr))))

(defn get-component-index
  "Returns the index of the specified component.
   (Note: Separators occupy index positions.)

  c - the Component to find - `java.awt.Component`

  returns: an integer indicating the component's position,
            where 0 is first - `int`"
  ([^javax.swing.JToolBar this ^java.awt.Component c]
    (-> this (.getComponentIndex c))))

(defn get-component-at-index
  "Returns the component at the specified index.

  i - the component's position, where 0 is first - `int`

  returns: the Component at that position,
            or null for an invalid index - `java.awt.Component`"
  ([^javax.swing.JToolBar this ^Integer i]
    (-> this (.getComponentAtIndex i))))

(defn set-margin
  "Sets the margin between the tool bar's border and
   its buttons. Setting to null causes the tool bar to
   use the default margins. The tool bar's default Border
   object uses this value to create the proper margin.
   However, if a non-default border is set on the tool bar,
   it is that Border object's responsibility to create the
   appropriate margin space (otherwise this property will
   effectively be ignored).

  m - an Insets object that defines the space between the border and the buttons - `java.awt.Insets`"
  ([^javax.swing.JToolBar this ^java.awt.Insets m]
    (-> this (.setMargin m))))

(defn get-ui-class-id
  "Returns the name of the L&F class that renders this component.

  returns: the string `ToolBarUI` - `java.lang.String`"
  ([^javax.swing.JToolBar this]
    (-> this (.getUIClassID))))

(defn add-separator
  "Appends a separator of a specified size to the end
   of the tool bar.

  size - the Dimension of the separator - `java.awt.Dimension`"
  ([^javax.swing.JToolBar this ^java.awt.Dimension size]
    (-> this (.addSeparator size)))
  ([^javax.swing.JToolBar this]
    (-> this (.addSeparator))))

(defn set-border-painted
  "Sets the borderPainted property, which is
   true if the border should be painted.
   The default value for this property is true.
   Some look and feels might not implement painted borders;
   they will ignore this property.

  b - if true, the border is painted - `boolean`"
  ([^javax.swing.JToolBar this ^Boolean b]
    (-> this (.setBorderPainted b))))

(defn set-ui
  "Sets the L&F object that renders this component.

  ui - the ToolBarUI L&F object - `javax.swing.plaf.ToolBarUI`"
  ([^javax.swing.JToolBar this ^javax.swing.plaf.ToolBarUI ui]
    (-> this (.setUI ui))))

(defn get-ui
  "Returns the tool bar's current UI.

  returns: `javax.swing.plaf.ToolBarUI`"
  ([^javax.swing.JToolBar this]
    (-> this (.getUI))))

(defn rollover?
  "Returns the rollover state.

  returns: true if rollover toolbar buttons are to be drawn; otherwise false - `boolean`"
  ([^javax.swing.JToolBar this]
    (-> this (.isRollover))))

(defn floatable?
  "Gets the floatable property.

  returns: the value of the floatable property - `boolean`"
  ([^javax.swing.JToolBar this]
    (-> this (.isFloatable))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JToolBar.
   For tool bars, the AccessibleContext takes the form of an
   AccessibleJToolBar.
   A new AccessibleJToolBar instance is created if necessary.

  returns: an AccessibleJToolBar that serves as the
           AccessibleContext of this JToolBar - `javax.accessibility.AccessibleContext`"
  ([^javax.swing.JToolBar this]
    (-> this (.getAccessibleContext))))

(defn set-orientation
  "Sets the orientation of the tool bar.  The orientation must have
   either the value HORIZONTAL or VERTICAL.
   If orientation is
   an invalid value, an exception will be thrown.

  o - the new orientation -- either HORIZONTAL or VERTICAL - `int`

  throws: java.lang.IllegalArgumentException - if orientation is neither HORIZONTAL nor VERTICAL"
  ([^javax.swing.JToolBar this ^Integer o]
    (-> this (.setOrientation o))))

(defn add
  "Adds a new JButton which dispatches the action.

  a - the Action object to add as a new menu item - `javax.swing.Action`

  returns: the new button which dispatches the action - `javax.swing.JButton`"
  ([^javax.swing.JToolBar this ^javax.swing.Action a]
    (-> this (.add a))))

(defn border-painted?
  "Gets the borderPainted property.

  returns: the value of the borderPainted property - `boolean`"
  ([^javax.swing.JToolBar this]
    (-> this (.isBorderPainted))))

(defn set-rollover
  "Sets the rollover state of this toolbar. If the rollover state is true
   then the border of the toolbar buttons will be drawn only when the
   mouse pointer hovers over them. The default value of this property
   is false.

   The implementation of a look and feel may choose to ignore this
   property.

  rollover - true for rollover toolbar buttons; otherwise false - `boolean`"
  ([^javax.swing.JToolBar this ^Boolean rollover]
    (-> this (.setRollover rollover))))

(defn update-ui
  "Notification from the UIFactory that the L&F has changed.
   Called to replace the UI with the latest version from the
   UIFactory."
  ([^javax.swing.JToolBar this]
    (-> this (.updateUI))))

(defn get-margin
  "Returns the margin between the tool bar's border and
   its buttons.

  returns: an Insets object containing the margin values - `java.awt.Insets`"
  ([^javax.swing.JToolBar this]
    (-> this (.getMargin))))

