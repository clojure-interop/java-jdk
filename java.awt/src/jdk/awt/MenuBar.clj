(ns jdk.awt.MenuBar
  "The MenuBar class encapsulates the platform's
  concept of a menu bar bound to a frame. In order to associate
  the menu bar with a Frame object, call the
  frame's setMenuBar method.

   target for cross references
  This is what a menu bar might look like:



  A menu bar handles keyboard shortcuts for menu items, passing them
  along to its child menus.
  (Keyboard shortcuts, which are optional, provide the user with
  an alternative to the mouse for invoking a menu item and the
  action that is associated with it.)
  Each menu item can maintain an instance of MenuShortcut.
  The MenuBar class defines several methods,
  shortcuts() and
  getShortcutMenuItem(java.awt.MenuShortcut)
  that retrieve information about the shortcuts a given
  menu bar is managing."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt MenuBar]))

(defn ->menu-bar
  "Constructor.

  Creates a new menu bar.

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true."
  ([]
    (new MenuBar )))

(defn get-shortcut-menu-item
  "Gets the instance of MenuItem associated
   with the specified MenuShortcut object,
   or null if none of the menu items being managed
   by this menu bar is associated with the specified menu
   shortcut.

  s - the specified menu shortcut. - `java.awt.MenuShortcut`

  returns: `java.awt.MenuItem`"
  ([this s]
    (-> this (.getShortcutMenuItem s))))

(defn shortcuts
  "Gets an enumeration of all menu shortcuts this menu bar
   is managing.

  returns: an enumeration of menu shortcuts that this
                        menu bar is managing. - `java.util.Enumeration<java.awt.MenuShortcut>`"
  ([this]
    (-> this (.shortcuts))))

(defn delete-shortcut
  "Deletes the specified menu shortcut.

  s - the menu shortcut to delete. - `java.awt.MenuShortcut`"
  ([this s]
    (-> this (.deleteShortcut s))))

(defn count-menus
  "Deprecated. As of JDK version 1.1,
   replaced by getMenuCount().

  returns: `java.lang.  int`"
  ([this]
    (-> this (.countMenus))))

(defn add-notify
  "Creates the menu bar's peer.  The peer allows us to change the
   appearance of the menu bar without changing any of the menu bar's
   functionality."
  ([this]
    (-> this (.addNotify))))

(defn remove-notify
  "Removes the menu bar's peer.  The peer allows us to change the
   appearance of the menu bar without changing any of the menu bar's
   functionality."
  ([this]
    (-> this (.removeNotify))))

(defn remove
  "Removes the menu located at the specified
   index from this menu bar.

  index - the position of the menu to be removed. - `int`"
  ([this index]
    (-> this (.remove index))))

(defn get-menu
  "Gets the specified menu.

  i - the index position of the menu to be returned. - `int`

  returns: the menu at the specified index of this menu bar. - `java.awt.Menu`"
  ([this i]
    (-> this (.getMenu i))))

(defn get-menu-count
  "Gets the number of menus on the menu bar.

  returns: the number of menus on the menu bar. - `int`"
  ([this]
    (-> this (.getMenuCount))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this MenuBar.
   For menu bars, the AccessibleContext takes the form of an
   AccessibleAWTMenuBar.
   A new AccessibleAWTMenuBar instance is created if necessary.

  returns: an AccessibleAWTMenuBar that serves as the
           AccessibleContext of this MenuBar - `javax.accessibility.AccessibleContext`"
  ([this]
    (-> this (.getAccessibleContext))))

(defn add
  "Adds the specified menu to the menu bar.
   If the menu has been part of another menu bar,
   removes it from that menu bar.

  m - the menu to be added - `java.awt.Menu`

  returns: the menu added - `java.awt.Menu`"
  ([this m]
    (-> this (.add m))))

(defn get-help-menu
  "Gets the help menu on the menu bar.

  returns: the help menu on this menu bar. - `java.awt.Menu`"
  ([this]
    (-> this (.getHelpMenu))))

(defn set-help-menu
  "Sets the specified menu to be this menu bar's help menu.
   If this menu bar has an existing help menu, the old help menu is
   removed from the menu bar, and replaced with the specified menu.

  m - the menu to be set as the help menu - `java.awt.Menu`"
  ([this m]
    (-> this (.setHelpMenu m))))

