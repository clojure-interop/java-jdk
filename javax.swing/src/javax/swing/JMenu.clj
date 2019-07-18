(ns javax.swing.JMenu
  "An implementation of a menu -- a popup window containing
  JMenuItems that
  is displayed when the user selects an item on the JMenuBar.
  In addition to JMenuItems, a JMenu can
  also contain JSeparators.

  In essence, a menu is a button with an associated JPopupMenu.
  When the `button` is pressed, the JPopupMenu appears. If the
  `button` is on the JMenuBar, the menu is a top-level window.
  If the `button` is another menu item, then the JPopupMenu is
  `pull-right` menu.

  Menus can be configured, and to some degree controlled, by
  Actions.  Using an
  Action with a menu has many benefits beyond directly
  configuring a menu.  Refer to
  Swing Components Supporting Action for more
  details, and you can find more information in How
  to Use Actions, a section in The Java Tutorial.

  For information and examples of using menus see
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
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JMenu]))

(defn ->j-menu
  "Constructor.

  Constructs a new JMenu with the supplied string as
   its text and specified as a tear-off menu or not.

  s - the text for the menu label - `java.lang.String`
  b - can the menu be torn off (not yet implemented) - `boolean`"
  (^JMenu [^java.lang.String s ^Boolean b]
    (new JMenu s b))
  (^JMenu [^java.lang.String s]
    (new JMenu s))
  (^JMenu []
    (new JMenu )))

(defn set-delay
  "Sets the suggested delay before the menu's PopupMenu
   is popped up or down.  Each look and feel (L&F) may determine
   it's own policy for observing the delay property.  In most cases,
   the delay is not observed for top level menus or while dragging.
   This method is a property of the look and feel code and is used
   to manage the idiosyncrasies of the various UI implementations.

  d - the number of milliseconds to delay - `int`

  throws: java.lang.IllegalArgumentException - if d is less than 0"
  ([^JMenu this ^Integer d]
    (-> this (.setDelay d))))

(defn get-component
  "Returns the java.awt.Component used to
   paint this MenuElement.
   The returned component is used to convert events and detect if
   an event is inside a menu component.

  returns: the Component that paints this menu item - `java.awt.Component`"
  (^java.awt.Component [^JMenu this]
    (-> this (.getComponent))))

(defn get-item
  "Returns the JMenuItem at the specified position.
   If the component at pos is not a menu item,
   null is returned.
   This method is included for AWT compatibility.

  pos - an integer specifying the position - `int`

  returns: the menu item at the specified position; or null
            if the item as the specified position is not a menu item - `javax.swing.JMenuItem`

  throws: java.lang.IllegalArgumentException - if the value of pos < 0"
  (^javax.swing.JMenuItem [^JMenu this ^Integer pos]
    (-> this (.getItem pos))))

(defn get-menu-component
  "Returns the component at position n.

  n - the position of the component to be returned - `int`

  returns: the component requested, or null
                    if there is no popup menu - `java.awt.Component`"
  (^java.awt.Component [^JMenu this ^Integer n]
    (-> this (.getMenuComponent n))))

(defn get-popup-menu
  "Returns the popupmenu associated with this menu.  If there is
   no popupmenu, it will create one.

  returns: `javax.swing.JPopupMenu`"
  (^javax.swing.JPopupMenu [^JMenu this]
    (-> this (.getPopupMenu))))

(defn get-item-count
  "Returns the number of items on the menu, including separators.
   This method is included for AWT compatibility.

  returns: an integer equal to the number of items on the menu - `int`"
  (^Integer [^JMenu this]
    (-> this (.getItemCount))))

(defn add-menu-listener
  "Adds a listener for menu events.

  l - the listener to be added - `javax.swing.event.MenuListener`"
  ([^JMenu this ^javax.swing.event.MenuListener l]
    (-> this (.addMenuListener l))))

(defn get-menu-components
  "Returns an array of Components of the menu's
   subcomponents.  Note that this returns all Components
   in the popup menu, including separators.

  returns: an array of Components or an empty array
            if there is no popup menu - `java.awt.Component[]`"
  ([^JMenu this]
    (-> this (.getMenuComponents))))

(defn remove-menu-listener
  "Removes a listener for menu events.

  l - the listener to be removed - `javax.swing.event.MenuListener`"
  ([^JMenu this ^javax.swing.event.MenuListener l]
    (-> this (.removeMenuListener l))))

(defn get-delay
  "Returns the suggested delay, in milliseconds, before submenus
   are popped up or down.
   Each look and feel (L&F) may determine its own policy for
   observing the delay property.
   In most cases, the delay is not observed for top level menus
   or while dragging.  The default for delay is 0.
   This method is a property of the look and feel code and is used
   to manage the idiosyncrasies of the various UI implementations.

  returns: the delay property - `int`"
  (^Integer [^JMenu this]
    (-> this (.getDelay))))

(defn set-selected
  "Sets the selection status of the menu.

  b - true to select (highlight) the menu; false to de-select the menu - `boolean`"
  ([^JMenu this ^Boolean b]
    (-> this (.setSelected b))))

(defn do-click
  "Programmatically performs a `click`.  This overrides the method
   AbstractButton.doClick in order to make the menu pop up.

  press-time - indicates the number of milliseconds the button was pressed for - `int`"
  ([^JMenu this ^Integer press-time]
    (-> this (.doClick press-time))))

(defn get-ui-class-id
  "Returns the name of the L&F class that renders this component.

  returns: the string `MenuUI` - `java.lang.String`"
  (^java.lang.String [^JMenu this]
    (-> this (.getUIClassID))))

(defn menu-selection-changed
  "Messaged when the menubar selection changes to activate or
   deactivate this menu.
   Overrides JMenuItem.menuSelectionChanged.

  is-included - true if this menu is active, false if it is not - `boolean`"
  ([^JMenu this ^Boolean is-included]
    (-> this (.menuSelectionChanged is-included))))

(defn add-separator
  "Appends a new separator to the end of the menu."
  ([^JMenu this]
    (-> this (.addSeparator))))

(defn insert-separator
  "Inserts a separator at the specified position.

  index - an integer specifying the position at which to insert the menu separator - `int`

  throws: java.lang.IllegalArgumentException - if the value of index < 0"
  ([^JMenu this ^Integer index]
    (-> this (.insertSeparator index))))

(defn set-popup-menu-visible
  "Sets the visibility of the menu's popup.  If the menu is
   not enabled, this method will have no effect.

  b - a boolean value -- true to make the menu visible, false to hide it - `boolean`"
  ([^JMenu this ^Boolean b]
    (-> this (.setPopupMenuVisible b))))

(defn set-menu-location
  "Sets the location of the popup component.

  x - the x coordinate of the popup's new position - `int`
  y - the y coordinate of the popup's new position - `int`"
  ([^JMenu this ^Integer x ^Integer y]
    (-> this (.setMenuLocation x y))))

(defn set-accelerator
  "setAccelerator is not defined for JMenu.
   Use setMnemonic instead.

  key-stroke - the keystroke combination which will invoke the JMenuItem's actionlisteners without navigating the menu hierarchy - `javax.swing.KeyStroke`

  throws: java.lang.Error - if invoked -- this method is not defined for JMenu. Use setMnemonic instead"
  ([^JMenu this ^javax.swing.KeyStroke key-stroke]
    (-> this (.setAccelerator key-stroke))))

(defn top-level-menu?
  "Returns true if the menu is a 'top-level menu', that is, if it is
   the direct child of a menubar.

  returns: true if the menu is activated from the menu bar;
           false if the menu is activated from a menu item
           on another menu - `boolean`"
  (^Boolean [^JMenu this]
    (-> this (.isTopLevelMenu))))

(defn remove
  "Removes the specified menu item from this menu.  If there is no
   popup menu, this method will have no effect.

  item - the JMenuItem to be removed from the menu - `javax.swing.JMenuItem`"
  ([^JMenu this ^javax.swing.JMenuItem item]
    (-> this (.remove item))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JMenu.
   For JMenus, the AccessibleContext takes the form of an
   AccessibleJMenu.
   A new AccessibleJMenu instance is created if necessary.

  returns: an AccessibleJMenu that serves as the
           AccessibleContext of this JMenu - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^JMenu this]
    (-> this (.getAccessibleContext))))

(defn get-sub-elements
  "Returns an array of MenuElements containing the submenu
   for this menu component.  If popup menu is null returns
   an empty array.  This method is required to conform to the
   MenuElement interface.  Note that since
   JSeparators do not conform to the MenuElement
   interface, this array will only contain JMenuItems.

  returns: an array of MenuElement objects - `javax.swing.MenuElement[]`"
  ([^JMenu this]
    (-> this (.getSubElements))))

(defn apply-component-orientation
  "Sets the ComponentOrientation property of this menu
   and all components contained within it. This includes all
   components returned by getMenuComponents.

  o - the new component orientation of this menu and the components contained within it. - `java.awt.ComponentOrientation`

  throws: java.lang.NullPointerException - if orientation is null."
  ([^JMenu this ^java.awt.ComponentOrientation o]
    (-> this (.applyComponentOrientation o))))

(defn tear-off?
  "Returns true if the menu can be torn off.  This method is not
   yet implemented.

  returns: true if the menu can be torn off, else false - `boolean`

  throws: java.lang.Error - if invoked -- this method is not yet implemented"
  (^Boolean [^JMenu this]
    (-> this (.isTearOff))))

(defn insert
  "Inserts a new menu item with the specified text at a
   given position.

  s - the text for the menu item to add - `java.lang.String`
  pos - an integer specifying the position at which to add the new menu item - `int`

  throws: java.lang.IllegalArgumentException - when the value of pos < 0"
  ([^JMenu this ^java.lang.String s ^Integer pos]
    (-> this (.insert s pos))))

(defn selected?
  "Returns true if the menu is currently selected (highlighted).

  returns: true if the menu is selected, else false - `boolean`"
  (^Boolean [^JMenu this]
    (-> this (.isSelected))))

(defn menu-component?
  "Returns true if the specified component exists in the
   submenu hierarchy.

  c - the Component to be tested - `java.awt.Component`

  returns: true if the Component exists, false otherwise - `boolean`"
  (^Boolean [^JMenu this ^java.awt.Component c]
    (-> this (.isMenuComponent c))))

(defn get-menu-listeners
  "Returns an array of all the MenuListeners added
   to this JMenu with addMenuListener().

  returns: all of the MenuListeners added or an empty
           array if no listeners have been added - `javax.swing.event.MenuListener[]`"
  ([^JMenu this]
    (-> this (.getMenuListeners))))

(defn add
  "Adds the specified component to this container at the given
   position. If index equals -1, the component will
   be appended to the end.

  c - the Component to add - `java.awt.Component`
  index - the position at which to insert the component - `int`

  returns: the Component added - `java.awt.Component`"
  (^java.awt.Component [^JMenu this ^java.awt.Component c ^Integer index]
    (-> this (.add c index)))
  (^javax.swing.JMenuItem [^JMenu this ^javax.swing.JMenuItem menu-item]
    (-> this (.add menu-item))))

(defn set-component-orientation
  "Description copied from class: Component

  o - `java.awt.ComponentOrientation`"
  ([^JMenu this ^java.awt.ComponentOrientation o]
    (-> this (.setComponentOrientation o))))

(defn remove-all
  "Removes all menu items from this menu."
  ([^JMenu this]
    (-> this (.removeAll))))

(defn set-model
  "Sets the data model for the `menu button` -- the label
   that the user clicks to open or close the menu.

  new-model - the ButtonModel - `javax.swing.ButtonModel`"
  ([^JMenu this ^javax.swing.ButtonModel new-model]
    (-> this (.setModel new-model))))

(defn popup-menu-visible?
  "Returns true if the menu's popup window is visible.

  returns: true if the menu is visible, else false - `boolean`"
  (^Boolean [^JMenu this]
    (-> this (.isPopupMenuVisible))))

(defn update-ui
  "Resets the UI property with a value from the current look and feel."
  ([^JMenu this]
    (-> this (.updateUI))))

(defn get-menu-component-count
  "Returns the number of components on the menu.

  returns: an integer containing the number of components on the menu - `int`"
  (^Integer [^JMenu this]
    (-> this (.getMenuComponentCount))))

