(ns jdk.awt.Menu
  "A Menu object is a pull-down menu component
  that is deployed from a menu bar.

  A menu can optionally be a tear-off menu. A tear-off menu
  can be opened and dragged away from its parent menu bar or menu.
  It remains on the screen after the mouse button has been released.
  The mechanism for tearing off a menu is platform dependent, since
  the look and feel of the tear-off menu is determined by its peer.
  On platforms that do not support tear-off menus, the tear-off
  property is ignored.

  Each item in a menu must belong to the MenuItem
  class. It can be an instance of MenuItem, a submenu
  (an instance of Menu), or a check box (an instance of
  CheckboxMenuItem)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Menu]))

(defn ->menu
  "Constructor.

  Constructs a new menu with the specified label,
   indicating whether the menu can be torn off.

   Tear-off functionality may not be supported by all
   implementations of AWT.  If a particular implementation doesn't
   support tear-off menus, this value is silently ignored.

  label - the menu's label in the menu bar, or in another menu of which this menu is a submenu. - `java.lang.String`
  tear-off - if true, the menu is a tear-off menu. - `boolean`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true."
  ([^java.lang.String label ^Boolean tear-off]
    (new Menu label tear-off))
  ([^java.lang.String label]
    (new Menu label))
  ([]
    (new Menu )))

(defn get-item
  "Gets the item located at the specified index of this menu.

  index - the position of the item to be returned. - `int`

  returns: the item located at the specified index. - `java.awt.MenuItem`"
  ([^java.awt.Menu this ^Integer index]
    (-> this (.getItem index))))

(defn get-item-count
  "Get the number of items in this menu.

  returns: the number of items in this menu. - `int`"
  ([^java.awt.Menu this]
    (-> this (.getItemCount))))

(defn add-separator
  "Adds a separator line, or a hypen, to the menu at the current position."
  ([^java.awt.Menu this]
    (-> this (.addSeparator))))

(defn insert-separator
  "Inserts a separator at the specified position.

  index - the position at which the menu separator should be inserted. - `int`

  throws: java.lang.IllegalArgumentException - if the value of index is less than 0."
  ([^java.awt.Menu this ^Integer index]
    (-> this (.insertSeparator index))))

(defn add-notify
  "Creates the menu's peer.  The peer allows us to modify the
   appearance of the menu without changing its functionality."
  ([^java.awt.Menu this]
    (-> this (.addNotify))))

(defn remove-notify
  "Removes the menu's peer.  The peer allows us to modify the appearance
   of the menu without changing its functionality."
  ([^java.awt.Menu this]
    (-> this (.removeNotify))))

(defn remove
  "Removes the menu item at the specified index from this menu.

  index - the position of the item to be removed. - `int`"
  ([^java.awt.Menu this ^Integer index]
    (-> this (.remove index))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this Menu.
   For menus, the AccessibleContext takes the form of an
   AccessibleAWTMenu.
   A new AccessibleAWTMenu instance is created if necessary.

  returns: an AccessibleAWTMenu that serves as the
           AccessibleContext of this Menu - `javax.accessibility.AccessibleContext`"
  ([^java.awt.Menu this]
    (-> this (.getAccessibleContext))))

(defn param-string
  "Returns a string representing the state of this Menu.
   This method is intended to be used only for debugging purposes, and the
   content and format of the returned string may vary between
   implementations. The returned string may be empty but may not be
   null.

  returns: the parameter string of this menu - `java.lang.String`"
  ([^java.awt.Menu this]
    (-> this (.paramString))))

(defn tear-off?
  "Indicates whether this menu is a tear-off menu.

   Tear-off functionality may not be supported by all
   implementations of AWT.  If a particular implementation doesn't
   support tear-off menus, this value is silently ignored.

  returns: true if this is a tear-off menu;
                           false otherwise. - `boolean`"
  ([^java.awt.Menu this]
    (-> this (.isTearOff))))

(defn insert
  "Inserts a menu item into this menu
   at the specified position.

  menuitem - the menu item to be inserted. - `java.awt.MenuItem`
  index - the position at which the menu item should be inserted. - `int`

  throws: java.lang.IllegalArgumentException - if the value of index is less than zero"
  ([^java.awt.Menu this ^java.awt.MenuItem menuitem ^Integer index]
    (-> this (.insert menuitem index))))

(defn add
  "Adds the specified menu item to this menu. If the
   menu item has been part of another menu, removes it
   from that menu.

  mi - the menu item to be added - `java.awt.MenuItem`

  returns: the menu item added - `java.awt.MenuItem`"
  ([^java.awt.Menu this ^java.awt.MenuItem mi]
    (-> this (.add mi))))

(defn remove-all
  "Removes all items from this menu."
  ([^java.awt.Menu this]
    (-> this (.removeAll))))

(defn count-items
  "Deprecated. As of JDK version 1.1,
   replaced by getItemCount().

  returns: `java.lang.  int`"
  ([^java.awt.Menu this]
    (-> this (.countItems))))

