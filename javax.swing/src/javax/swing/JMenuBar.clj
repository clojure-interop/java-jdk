(ns javax.swing.JMenuBar
  "An implementation of a menu bar. You add JMenu objects to the
  menu bar to construct a menu. When the user selects a JMenu
  object, its associated JPopupMenu is displayed, allowing the
  user to select one of the JMenuItems on it.

  For information and examples of using menu bars see
  How to Use Menus,
  a section in The Java Tutorial.

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
  Please see XMLEncoder.

  Warning:
  By default, pressing the Tab key does not transfer focus from a
  JMenuBar which is added to a container together with other Swing
  components, because the focusTraversalKeysEnabled property
  of JMenuBar is set to false. To resolve this,
  you should call the JMenuBar.setFocusTraversalKeysEnabled(true)
  method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JMenuBar]))

(defn ->j-menu-bar
  "Constructor.

  Creates a new menu bar."
  ([]
    (new JMenuBar )))

(defn get-component
  "Implemented to be a MenuElement. Returns this object.

  returns: the current Component (this) - `java.awt.Component`"
  ([^javax.swing.JMenuBar this]
    (-> this (.getComponent))))

(defn get-component-index
  "Returns the index of the specified component.

  c - the Component to find - `java.awt.Component`

  returns: an integer giving the component's position, where 0 is first;
            or -1 if it can't be found - `int`"
  ([^javax.swing.JMenuBar this ^java.awt.Component c]
    (-> this (.getComponentIndex c))))

(defn get-component-at-index
  "Deprecated. replaced by getComponent(int i)

  i - an integer specifying the position, where 0 is first - `int`

  returns: the Component at the position,
            or null for an invalid index - `java.lang.  java.awt.Component`"
  ([^javax.swing.JMenuBar this ^Integer i]
    (-> this (.getComponentAtIndex i))))

(defn set-margin
  "Sets the margin between the menubar's border and
   its menus. Setting to null will cause the menubar to
   use the default margins.

  m - an Insets object containing the margin values - `java.awt.Insets`"
  ([^javax.swing.JMenuBar this ^java.awt.Insets m]
    (-> this (.setMargin m))))

(defn set-selected
  "Sets the currently selected component, producing a
   a change to the selection model.

  sel - the Component to select - `java.awt.Component`"
  ([^javax.swing.JMenuBar this ^java.awt.Component sel]
    (-> this (.setSelected sel))))

(defn get-ui-class-id
  "Returns the name of the L&F class that renders this component.

  returns: the string `MenuBarUI` - `java.lang.String`"
  ([^javax.swing.JMenuBar this]
    (-> this (.getUIClassID))))

(defn set-selection-model
  "Sets the model object to handle single selections.

  model - the SingleSelectionModel to use - `javax.swing.SingleSelectionModel`"
  ([^javax.swing.JMenuBar this ^javax.swing.SingleSelectionModel model]
    (-> this (.setSelectionModel model))))

(defn menu-selection-changed
  "Implemented to be a MenuElement -- does nothing.

  is-included - `boolean`"
  ([^javax.swing.JMenuBar this ^Boolean is-included]
    (-> this (.menuSelectionChanged is-included))))

(defn set-border-painted
  "Sets whether the border should be painted.

  b - if true and border property is not null, the border is painted. - `boolean`"
  ([^javax.swing.JMenuBar this ^Boolean b]
    (-> this (.setBorderPainted b))))

(defn add-notify
  "Overrides JComponent.addNotify to register this
   menu bar with the current keyboard manager."
  ([^javax.swing.JMenuBar this]
    (-> this (.addNotify))))

(defn get-selection-model
  "Returns the model object that handles single selections.

  returns: the SingleSelectionModel property - `javax.swing.SingleSelectionModel`"
  ([^javax.swing.JMenuBar this]
    (-> this (.getSelectionModel))))

(defn set-ui
  "Sets the L&F object that renders this component.

  ui - the new MenuBarUI L&F object - `javax.swing.plaf.MenuBarUI`"
  ([^javax.swing.JMenuBar this ^javax.swing.plaf.MenuBarUI ui]
    (-> this (.setUI ui))))

(defn remove-notify
  "Overrides JComponent.removeNotify to unregister this
   menu bar with the current keyboard manager."
  ([^javax.swing.JMenuBar this]
    (-> this (.removeNotify))))

(defn get-menu
  "Returns the menu at the specified position in the menu bar.

  index - an integer giving the position in the menu bar, where 0 is the first position - `int`

  returns: the JMenu at that position, or null if
            if there is no JMenu at that position (ie. if
            it is a JMenuItem) - `javax.swing.JMenu`"
  ([^javax.swing.JMenuBar this ^Integer index]
    (-> this (.getMenu index))))

(defn get-ui
  "Returns the menubar's current UI.

  returns: `javax.swing.plaf.MenuBarUI`"
  ([^javax.swing.JMenuBar this]
    (-> this (.getUI))))

(defn get-menu-count
  "Returns the number of items in the menu bar.

  returns: the number of items in the menu bar - `int`"
  ([^javax.swing.JMenuBar this]
    (-> this (.getMenuCount))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JMenuBar.
   For JMenuBars, the AccessibleContext takes the form of an
   AccessibleJMenuBar.
   A new AccessibleJMenuBar instance is created if necessary.

  returns: an AccessibleJMenuBar that serves as the
           AccessibleContext of this JMenuBar - `javax.accessibility.AccessibleContext`"
  ([^javax.swing.JMenuBar this]
    (-> this (.getAccessibleContext))))

(defn get-sub-elements
  "Implemented to be a MenuElement -- returns the
   menus in this menu bar.
   This is the reason for implementing the MenuElement
   interface -- so that the menu bar can be treated the same as
   other menu elements.

  returns: an array of menu items in the menu bar. - `javax.swing.MenuElement[]`"
  ([^javax.swing.JMenuBar this]
    (-> this (.getSubElements))))

(defn process-key-event
  "Implemented to be a MenuElement -- does nothing.

  e - `java.awt.event.KeyEvent`
  path - `javax.swing.MenuElement[]`
  manager - `javax.swing.MenuSelectionManager`"
  ([^javax.swing.JMenuBar this ^java.awt.event.KeyEvent e ^javax.swing.MenuElement[] path ^javax.swing.MenuSelectionManager manager]
    (-> this (.processKeyEvent e path manager))))

(defn selected?
  "Returns true if the menu bar currently has a component selected.

  returns: true if a selection has been made, else false - `boolean`"
  ([^javax.swing.JMenuBar this]
    (-> this (.isSelected))))

(defn process-mouse-event
  "Implemented to be a MenuElement -- does nothing.

  event - `java.awt.event.MouseEvent`
  path - `javax.swing.MenuElement[]`
  manager - `javax.swing.MenuSelectionManager`"
  ([^javax.swing.JMenuBar this ^java.awt.event.MouseEvent event ^javax.swing.MenuElement[] path ^javax.swing.MenuSelectionManager manager]
    (-> this (.processMouseEvent event path manager))))

(defn add
  "Appends the specified menu to the end of the menu bar.

  c - the JMenu component to add - `javax.swing.JMenu`

  returns: the menu component - `javax.swing.JMenu`"
  ([^javax.swing.JMenuBar this ^javax.swing.JMenu c]
    (-> this (.add c))))

(defn border-painted?
  "Returns true if the menu bars border should be painted.

  returns: true if the border should be painted, else false - `boolean`"
  ([^javax.swing.JMenuBar this]
    (-> this (.isBorderPainted))))

(defn get-help-menu
  "Gets the help menu for the menu bar.  This method is not yet
   implemented and will throw an exception.

  returns: the JMenu that delivers help to the user - `javax.swing.JMenu`"
  ([^javax.swing.JMenuBar this]
    (-> this (.getHelpMenu))))

(defn set-help-menu
  "Sets the help menu that appears when the user selects the
   `help` option in the menu bar. This method is not yet implemented
   and will throw an exception.

  menu - the JMenu that delivers help to the user - `javax.swing.JMenu`"
  ([^javax.swing.JMenuBar this ^javax.swing.JMenu menu]
    (-> this (.setHelpMenu menu))))

(defn update-ui
  "Resets the UI property with a value from the current look and feel."
  ([^javax.swing.JMenuBar this]
    (-> this (.updateUI))))

(defn get-margin
  "Returns the margin between the menubar's border and
   its menus.  If there is no previous margin, it will create
   a default margin with zero size.

  returns: an Insets object containing the margin values - `java.awt.Insets`"
  ([^javax.swing.JMenuBar this]
    (-> this (.getMargin))))

