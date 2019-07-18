(ns javax.swing.JPopupMenu
  "An implementation of a popup menu -- a small window that pops up
  and displays a series of choices. A JPopupMenu is used for the
  menu that appears when the user selects an item on the menu bar.
  It is also used for `pull-right` menu that appears when the
  selects a menu item that activates it. Finally, a JPopupMenu
  can also be used anywhere else you want a menu to appear.  For
  example, when the user right-clicks in a specified area.

  For information and examples of using popup menus, see
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
  (:import [javax.swing JPopupMenu]))

(defn ->j-popup-menu
  "Constructor.

  Constructs a JPopupMenu with the specified title.

  label - the string that a UI may use to display as a title for the popup menu. - `java.lang.String`"
  (^JPopupMenu [^java.lang.String label]
    (new JPopupMenu label))
  (^JPopupMenu []
    (new JPopupMenu )))

(defn *set-default-light-weight-popup-enabled
  "Sets the default value of the lightWeightPopupEnabled
    property.

  a-flag - true if popups can be lightweight, otherwise false - `boolean`"
  ([^Boolean a-flag]
    (JPopupMenu/setDefaultLightWeightPopupEnabled a-flag)))

(defn *get-default-light-weight-popup-enabled?
  "Gets the defaultLightWeightPopupEnabled property,
    which by default is true.

  returns: the value of the defaultLightWeightPopupEnabled
            property - `boolean`"
  (^Boolean []
    (JPopupMenu/getDefaultLightWeightPopupEnabled )))

(defn set-popup-size
  "Sets the size of the Popup window to the specified width and
   height. This is equivalent to
    setPreferredSize(new Dimension(width, height)).

  width - the new width of the Popup in pixels - `int`
  height - the new height of the Popup in pixels - `int`"
  ([^JPopupMenu this ^Integer width ^Integer height]
    (-> this (.setPopupSize width height)))
  ([^JPopupMenu this ^java.awt.Dimension d]
    (-> this (.setPopupSize d))))

(defn light-weight-popup-enabled?
  "Gets the lightWeightPopupEnabled property.

  returns: the value of the lightWeightPopupEnabled property - `boolean`"
  (^Boolean [^JPopupMenu this]
    (-> this (.isLightWeightPopupEnabled))))

(defn get-component
  "Returns this JPopupMenu component.

  returns: this JPopupMenu object - `java.awt.Component`"
  (^java.awt.Component [^JPopupMenu this]
    (-> this (.getComponent))))

(defn set-location
  "Sets the location of the upper left corner of the
   popup menu using x, y coordinates.

   The method changes the geometry-related data. Therefore,
   the native windowing system may ignore such requests, or it may modify
   the requested data, so that the JPopupMenu object is placed and sized
   in a way that corresponds closely to the desktop settings.

  x - the x coordinate of the popup's new position in the screen's coordinate space - `int`
  y - the y coordinate of the popup's new position in the screen's coordinate space - `int`"
  ([^JPopupMenu this ^Integer x ^Integer y]
    (-> this (.setLocation x y))))

(defn get-component-index
  "Returns the index of the specified component.

  c - the Component to find - `java.awt.Component`

  returns: the index of the component, where 0 is the first;
           or -1 if the component is not found - `int`"
  (^Integer [^JPopupMenu this ^java.awt.Component c]
    (-> this (.getComponentIndex c))))

(defn pack
  "Lays out the container so that it uses the minimum space
   needed to display its contents."
  ([^JPopupMenu this]
    (-> this (.pack))))

(defn get-component-at-index
  "Deprecated. replaced by Container.getComponent(int)

  i - the index of the component, where 0 is the first - `int`

  returns: the Component at that index - `java.awt.Component`"
  (^java.awt.Component [^JPopupMenu this ^Integer i]
    (-> this (.getComponentAtIndex i))))

(defn set-selected
  "Sets the currently selected component,  This will result
   in a change to the selection model.

  sel - the Component to select - `java.awt.Component`"
  ([^JPopupMenu this ^java.awt.Component sel]
    (-> this (.setSelected sel))))

(defn get-invoker
  "Returns the component which is the 'invoker' of this
   popup menu.

  returns: the Component in which the popup menu is displayed - `java.awt.Component`"
  (^java.awt.Component [^JPopupMenu this]
    (-> this (.getInvoker))))

(defn add-popup-menu-listener
  "Adds a PopupMenu listener.

  l - the PopupMenuListener to add - `javax.swing.event.PopupMenuListener`"
  ([^JPopupMenu this ^javax.swing.event.PopupMenuListener l]
    (-> this (.addPopupMenuListener l))))

(defn remove-popup-menu-listener
  "Removes a PopupMenu listener.

  l - the PopupMenuListener to remove - `javax.swing.event.PopupMenuListener`"
  ([^JPopupMenu this ^javax.swing.event.PopupMenuListener l]
    (-> this (.removePopupMenuListener l))))

(defn get-ui-class-id
  "Returns the name of the L&F class that renders this component.

  returns: the string `PopupMenuUI` - `java.lang.String`"
  (^java.lang.String [^JPopupMenu this]
    (-> this (.getUIClassID))))

(defn popup-trigger?
  "Returns true if the MouseEvent is considered a popup trigger
   by the JPopupMenu's currently installed UI.

  e - `java.awt.event.MouseEvent`

  returns: true if the mouse event is a popup trigger - `boolean`"
  (^Boolean [^JPopupMenu this e]
    (-> this (.isPopupTrigger e))))

(defn set-selection-model
  "Sets the model object to handle single selections.

  model - the new SingleSelectionModel - `javax.swing.SingleSelectionModel`"
  ([^JPopupMenu this ^javax.swing.SingleSelectionModel model]
    (-> this (.setSelectionModel model))))

(defn menu-selection-changed
  "Messaged when the menubar selection changes to activate or
   deactivate this menu. This implements the
   javax.swing.MenuElement interface.
   Overrides MenuElement.menuSelectionChanged.

  is-included - true if this menu is active, false if it is not - `boolean`"
  ([^JPopupMenu this ^Boolean is-included]
    (-> this (.menuSelectionChanged is-included))))

(defn add-separator
  "Appends a new separator at the end of the menu."
  ([^JPopupMenu this]
    (-> this (.addSeparator))))

(defn set-border-painted
  "Sets whether the border should be painted.

  b - if true, the border is painted. - `boolean`"
  ([^JPopupMenu this ^Boolean b]
    (-> this (.setBorderPainted b))))

(defn get-menu-key-listeners
  "Returns an array of all the MenuKeyListeners added
   to this JPopupMenu with addMenuKeyListener().

  returns: all of the MenuKeyListeners added or an empty
           array if no listeners have been added - `javax.swing.event.MenuKeyListener[]`"
  ([^JPopupMenu this]
    (-> this (.getMenuKeyListeners))))

(defn add-menu-key-listener
  "Adds a MenuKeyListener to the popup menu.

  l - the MenuKeyListener to be added - `javax.swing.event.MenuKeyListener`"
  ([^JPopupMenu this ^javax.swing.event.MenuKeyListener l]
    (-> this (.addMenuKeyListener l))))

(defn get-selection-model
  "Returns the model object that handles single selections.

  returns: the selectionModel property - `javax.swing.SingleSelectionModel`"
  (^javax.swing.SingleSelectionModel [^JPopupMenu this]
    (-> this (.getSelectionModel))))

(defn show
  "Displays the popup menu at the position x,y in the coordinate
   space of the component invoker.

  invoker - the component in whose space the popup menu is to appear - `java.awt.Component`
  x - the x coordinate in invoker's coordinate space at which the popup menu is to be displayed - `int`
  y - the y coordinate in invoker's coordinate space at which the popup menu is to be displayed - `int`"
  ([^JPopupMenu this ^java.awt.Component invoker ^Integer x ^Integer y]
    (-> this (.show invoker x y))))

(defn set-ui
  "Sets the L&F object that renders this component.

  ui - the new PopupMenuUI L&F object - `javax.swing.plaf.PopupMenuUI`"
  ([^JPopupMenu this ^javax.swing.plaf.PopupMenuUI ui]
    (-> this (.setUI ui))))

(defn remove
  "Removes the component at the specified index from this popup menu.

  pos - the position of the item to be removed - `int`

  throws: java.lang.IllegalArgumentException - if the value of pos < 0, or if the value of pos is greater than the number of items"
  ([^JPopupMenu this ^Integer pos]
    (-> this (.remove pos))))

(defn get-ui
  "Returns the look and feel (L&F) object that renders this component.

  returns: the PopupMenuUI object that renders this component - `javax.swing.plaf.PopupMenuUI`"
  (^javax.swing.plaf.PopupMenuUI [^JPopupMenu this]
    (-> this (.getUI))))

(defn get-label
  "Returns the popup menu's label

  returns: a string containing the popup menu's label - `java.lang.String`"
  (^java.lang.String [^JPopupMenu this]
    (-> this (.getLabel))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JPopupMenu.
   For JPopupMenus, the AccessibleContext takes the form of an
   AccessibleJPopupMenu.
   A new AccessibleJPopupMenu instance is created if necessary.

  returns: an AccessibleJPopupMenu that serves as the
           AccessibleContext of this JPopupMenu - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^JPopupMenu this]
    (-> this (.getAccessibleContext))))

(defn remove-menu-key-listener
  "Removes a MenuKeyListener from the popup menu.

  l - the MenuKeyListener to be removed - `javax.swing.event.MenuKeyListener`"
  ([^JPopupMenu this ^javax.swing.event.MenuKeyListener l]
    (-> this (.removeMenuKeyListener l))))

(defn get-sub-elements
  "Returns an array of MenuElements containing the submenu
   for this menu component.  It will only return items conforming to
   the JMenuElement interface.
   If popup menu is null returns
   an empty array.  This method is required to conform to the
   MenuElement interface.

  returns: an array of MenuElement objects - `javax.swing.MenuElement[]`"
  ([^JPopupMenu this]
    (-> this (.getSubElements))))

(defn set-visible
  "Sets the visibility of the popup menu.

  b - true to make the popup visible, or false to hide it - `boolean`"
  ([^JPopupMenu this ^Boolean b]
    (-> this (.setVisible b))))

(defn set-invoker
  "Sets the invoker of this popup menu -- the component in which
   the popup menu menu is to be displayed.

  invoker - the Component in which the popup menu is displayed - `java.awt.Component`"
  ([^JPopupMenu this ^java.awt.Component invoker]
    (-> this (.setInvoker invoker))))

(defn process-key-event
  "Processes a key event forwarded from the
   MenuSelectionManager and changes the menu selection,
   if necessary, by using MenuSelectionManager's API.

   Note: you do not have to forward the event to sub-components.
   This is done automatically by the MenuSelectionManager.

  e - a KeyEvent - `java.awt.event.KeyEvent`
  path - the MenuElement path array - `javax.swing.MenuElement[]`
  manager - the MenuSelectionManager - `javax.swing.MenuSelectionManager`"
  ([^JPopupMenu this ^java.awt.event.KeyEvent e path ^javax.swing.MenuSelectionManager manager]
    (-> this (.processKeyEvent e path manager))))

(defn visible?
  "Returns true if the popup menu is visible (currently
   being displayed).

  returns: true if the component is visible,
   false otherwise - `boolean`"
  (^Boolean [^JPopupMenu this]
    (-> this (.isVisible))))

(defn insert
  "Inserts a menu item for the specified Action object at
   a given position.

  a - the Action object to insert - `javax.swing.Action`
  index - specifies the position at which to insert the Action, where 0 is the first - `int`

  throws: java.lang.IllegalArgumentException - if index < 0"
  ([^JPopupMenu this ^javax.swing.Action a ^Integer index]
    (-> this (.insert a index))))

(defn process-mouse-event
  "This method is required to conform to the
   MenuElement interface, but it not implemented.

  event - `java.awt.event.MouseEvent`
  path - `javax.swing.MenuElement[]`
  manager - `javax.swing.MenuSelectionManager`"
  ([^JPopupMenu this event path ^javax.swing.MenuSelectionManager manager]
    (-> this (.processMouseEvent event path manager))))

(defn add
  "Appends the specified menu item to the end of this menu.

  menu-item - the JMenuItem to add - `javax.swing.JMenuItem`

  returns: the JMenuItem added - `javax.swing.JMenuItem`"
  (^javax.swing.JMenuItem [^JPopupMenu this ^javax.swing.JMenuItem menu-item]
    (-> this (.add menu-item))))

(defn set-light-weight-popup-enabled
  "Sets the value of the lightWeightPopupEnabled property,
   which by default is true.
   By default, when a look and feel displays a popup,
   it can choose to
   use a lightweight (all-Java) popup.
   Lightweight popup windows are more efficient than heavyweight
   (native peer) windows,
   but lightweight and heavyweight components do not mix well in a GUI.
   If your application mixes lightweight and heavyweight components,
   you should disable lightweight popups.
   Some look and feels might always use heavyweight popups,
   no matter what the value of this property.

  a-flag - false to disable lightweight popups - `boolean`"
  ([^JPopupMenu this ^Boolean a-flag]
    (-> this (.setLightWeightPopupEnabled a-flag))))

(defn border-painted?
  "Checks whether the border should be painted.

  returns: true if the border is painted, false otherwise - `boolean`"
  (^Boolean [^JPopupMenu this]
    (-> this (.isBorderPainted))))

(defn update-ui
  "Resets the UI property to a value from the current look and feel."
  ([^JPopupMenu this]
    (-> this (.updateUI))))

(defn get-popup-menu-listeners
  "Returns an array of all the PopupMenuListeners added
   to this JMenuItem with addPopupMenuListener().

  returns: all of the PopupMenuListeners added or an empty
           array if no listeners have been added - `javax.swing.event.PopupMenuListener[]`"
  ([^JPopupMenu this]
    (-> this (.getPopupMenuListeners))))

(defn set-label
  "Sets the popup menu's label.  Different look and feels may choose
   to display or not display this.

  label - a string specifying the label for the popup menu - `java.lang.String`"
  ([^JPopupMenu this ^java.lang.String label]
    (-> this (.setLabel label))))

(defn get-margin
  "Returns the margin, in pixels, between the popup menu's border and
   its containers.

  returns: an Insets object containing the margin values. - `java.awt.Insets`"
  (^java.awt.Insets [^JPopupMenu this]
    (-> this (.getMargin))))

