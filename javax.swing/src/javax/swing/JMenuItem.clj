(ns javax.swing.JMenuItem
  "An implementation of an item in a menu. A menu item is essentially a button
  sitting in a list. When the user selects the `button`, the action
  associated with the menu item is performed. A JMenuItem
  contained in a JPopupMenu performs exactly that function.

  Menu items can be configured, and to some degree controlled, by
  Actions.  Using an
  Action with a menu item has many benefits beyond directly
  configuring a menu item.  Refer to
  Swing Components Supporting Action for more
  details, and you can find more information in How
  to Use Actions, a section in The Java Tutorial.

  For further documentation and for examples, see
  How to Use Menus
  in The Java Tutorial.

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
  (:import [javax.swing JMenuItem]))

(defn ->j-menu-item
  "Constructor.

  Creates a JMenuItem with the specified text and icon.

  text - the text of the JMenuItem - `java.lang.String`
  icon - the icon of the JMenuItem - `javax.swing.Icon`"
  ([^java.lang.String text ^javax.swing.Icon icon]
    (new JMenuItem text icon))
  ([^javax.swing.Icon icon]
    (new JMenuItem icon))
  ([]
    (new JMenuItem )))

(defn process-menu-drag-mouse-event
  "Handles mouse drag in a menu.

  e - a MenuDragMouseEvent object - `javax.swing.event.MenuDragMouseEvent`"
  ([^javax.swing.JMenuItem this ^javax.swing.event.MenuDragMouseEvent e]
    (-> this (.processMenuDragMouseEvent e))))

(defn get-component
  "Returns the java.awt.Component used to paint
   this object. The returned component will be used to convert
   events and detect if an event is inside a menu component.

  returns: the Component that paints this menu item - `java.awt.Component`"
  (^java.awt.Component [^javax.swing.JMenuItem this]
    (-> this (.getComponent))))

(defn armed?
  "Returns whether the menu item is `armed`.

  returns: true if the menu item is armed, and it can be selected - `boolean`"
  (^Boolean [^javax.swing.JMenuItem this]
    (-> this (.isArmed))))

(defn get-ui-class-id
  "Returns the suffix used to construct the name of the L&F class used to
   render this component.

  returns: the string `MenuItemUI` - `java.lang.String`"
  (^java.lang.String [^javax.swing.JMenuItem this]
    (-> this (.getUIClassID))))

(defn add-menu-drag-mouse-listener
  "Adds a MenuDragMouseListener to the menu item.

  l - the MenuDragMouseListener to be added - `javax.swing.event.MenuDragMouseListener`"
  ([^javax.swing.JMenuItem this ^javax.swing.event.MenuDragMouseListener l]
    (-> this (.addMenuDragMouseListener l))))

(defn menu-selection-changed
  "Called by the MenuSelectionManager when the
   MenuElement is selected or unselected.

  is-included - true if this menu item is on the part of the menu path that changed, false if this menu is part of the a menu path that changed, but this particular part of that path is still the same - `boolean`"
  ([^javax.swing.JMenuItem this ^Boolean is-included]
    (-> this (.menuSelectionChanged is-included))))

(defn set-armed
  "Identifies the menu item as `armed`. If the mouse button is
   released while it is over this item, the menu's action event
   will fire. If the mouse button is released elsewhere, the
   event will not fire and the menu item will be disarmed.

  b - true to arm the menu item so it can be selected - `boolean`"
  ([^javax.swing.JMenuItem this ^Boolean b]
    (-> this (.setArmed b))))

(defn get-menu-key-listeners
  "Returns an array of all the MenuKeyListeners added
   to this JMenuItem with addMenuKeyListener().

  returns: all of the MenuKeyListeners added or an empty
           array if no listeners have been added - `javax.swing.event.MenuKeyListener[]`"
  ([^javax.swing.JMenuItem this]
    (-> this (.getMenuKeyListeners))))

(defn add-menu-key-listener
  "Adds a MenuKeyListener to the menu item.

  l - the MenuKeyListener to be added - `javax.swing.event.MenuKeyListener`"
  ([^javax.swing.JMenuItem this ^javax.swing.event.MenuKeyListener l]
    (-> this (.addMenuKeyListener l))))

(defn set-accelerator
  "Sets the key combination which invokes the menu item's
   action listeners without navigating the menu hierarchy. It is the
   UI's responsibility to install the correct action.  Note that
   when the keyboard accelerator is typed, it will work whether or
   not the menu is currently displayed.

  key-stroke - the KeyStroke which will serve as an accelerator - `javax.swing.KeyStroke`"
  ([^javax.swing.JMenuItem this ^javax.swing.KeyStroke key-stroke]
    (-> this (.setAccelerator key-stroke))))

(defn get-accelerator
  "Returns the KeyStroke which serves as an accelerator
   for the menu item.

  returns: a KeyStroke object identifying the
            accelerator key - `javax.swing.KeyStroke`"
  (^javax.swing.KeyStroke [^javax.swing.JMenuItem this]
    (-> this (.getAccelerator))))

(defn set-ui
  "Sets the look and feel object that renders this component.

  ui - the JMenuItemUI L&F object - `javax.swing.plaf.MenuItemUI`"
  ([^javax.swing.JMenuItem this ^javax.swing.plaf.MenuItemUI ui]
    (-> this (.setUI ui))))

(defn process-menu-key-event
  "Handles a keystroke in a menu.

  e - a MenuKeyEvent object - `javax.swing.event.MenuKeyEvent`"
  ([^javax.swing.JMenuItem this ^javax.swing.event.MenuKeyEvent e]
    (-> this (.processMenuKeyEvent e))))

(defn get-accessible-context
  "Returns the AccessibleContext associated with this
   JMenuItem. For JMenuItems,
   the AccessibleContext takes the form of an
   AccessibleJMenuItem.
   A new AccessibleJMenuItme instance is created if necessary.

  returns: an AccessibleJMenuItem that serves as the
           AccessibleContext of this JMenuItem - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^javax.swing.JMenuItem this]
    (-> this (.getAccessibleContext))))

(defn remove-menu-key-listener
  "Removes a MenuKeyListener from the menu item.

  l - the MenuKeyListener to be removed - `javax.swing.event.MenuKeyListener`"
  ([^javax.swing.JMenuItem this ^javax.swing.event.MenuKeyListener l]
    (-> this (.removeMenuKeyListener l))))

(defn get-sub-elements
  "This method returns an array containing the sub-menu
   components for this menu component.

  returns: an array of MenuElements - `javax.swing.MenuElement[]`"
  ([^javax.swing.JMenuItem this]
    (-> this (.getSubElements))))

(defn set-enabled
  "Enables or disables the menu item.

  b - true to enable the item - `boolean`"
  ([^javax.swing.JMenuItem this ^Boolean b]
    (-> this (.setEnabled b))))

(defn process-key-event
  "Processes a key event forwarded from the
   MenuSelectionManager and changes the menu selection,
   if necessary, by using MenuSelectionManager's API.

   Note: you do not have to forward the event to sub-components.
   This is done automatically by the MenuSelectionManager.

  e - a KeyEvent - `java.awt.event.KeyEvent`
  path - the MenuElement path array - `javax.swing.MenuElement[]`
  manager - the MenuSelectionManager - `javax.swing.MenuSelectionManager`"
  ([^javax.swing.JMenuItem this ^java.awt.event.KeyEvent e path ^javax.swing.MenuSelectionManager manager]
    (-> this (.processKeyEvent e path manager))))

(defn get-menu-drag-mouse-listeners
  "Returns an array of all the MenuDragMouseListeners added
   to this JMenuItem with addMenuDragMouseListener().

  returns: all of the MenuDragMouseListeners added or an empty
           array if no listeners have been added - `javax.swing.event.MenuDragMouseListener[]`"
  ([^javax.swing.JMenuItem this]
    (-> this (.getMenuDragMouseListeners))))

(defn process-mouse-event
  "Processes a mouse event forwarded from the
   MenuSelectionManager and changes the menu
   selection, if necessary, by using the
   MenuSelectionManager's API.

   Note: you do not have to forward the event to sub-components.
   This is done automatically by the MenuSelectionManager.

  e - a MouseEvent - `java.awt.event.MouseEvent`
  path - the MenuElement path array - `javax.swing.MenuElement[]`
  manager - the MenuSelectionManager - `javax.swing.MenuSelectionManager`"
  ([^javax.swing.JMenuItem this ^java.awt.event.MouseEvent e path ^javax.swing.MenuSelectionManager manager]
    (-> this (.processMouseEvent e path manager))))

(defn remove-menu-drag-mouse-listener
  "Removes a MenuDragMouseListener from the menu item.

  l - the MenuDragMouseListener to be removed - `javax.swing.event.MenuDragMouseListener`"
  ([^javax.swing.JMenuItem this ^javax.swing.event.MenuDragMouseListener l]
    (-> this (.removeMenuDragMouseListener l))))

(defn set-model
  "Sets the model that this button represents.

  new-model - the new ButtonModel - `javax.swing.ButtonModel`"
  ([^javax.swing.JMenuItem this ^javax.swing.ButtonModel new-model]
    (-> this (.setModel new-model))))

(defn update-ui
  "Resets the UI property with a value from the current look and feel."
  ([^javax.swing.JMenuItem this]
    (-> this (.updateUI))))

