(ns jdk.awt.PopupMenu
  "A class that implements a menu which can be dynamically popped up
  at a specified position within a component.

  As the inheritance hierarchy implies, a PopupMenu
   can be used anywhere a Menu can be used.
  However, if you use a PopupMenu like a Menu
  (e.g., you add it to a MenuBar), then you cannot
  call show on that PopupMenu."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt PopupMenu]))

(defn ->popup-menu
  "Constructor.

  Creates a new popup menu with the specified name.

  label - a non-null string specifying the popup menu's label - `java.lang.String`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true."
  ([^java.lang.String label]
    (new PopupMenu label))
  ([]
    (new PopupMenu )))

(defn get-parent
  "Returns the parent container for this menu component.

  returns: the menu component containing this menu component,
                   or null if this menu component
                   is the outermost component, the menu bar itself - `java.awt.MenuContainer`"
  ([^java.awt.PopupMenu this]
    (-> this (.getParent))))

(defn add-notify
  "Creates the popup menu's peer.
   The peer allows us to change the appearance of the popup menu without
   changing any of the popup menu's functionality."
  ([^java.awt.PopupMenu this]
    (-> this (.addNotify))))

(defn show
  "Shows the popup menu at the x, y position relative to an origin
   component.
   The origin component must be contained within the component
   hierarchy of the popup menu's parent.  Both the origin and the parent
   must be showing on the screen for this method to be valid.

   If this PopupMenu is being used as a Menu
   (i.e., it has a non-Component parent),
   then you cannot call this method on the PopupMenu.

  origin - the component which defines the coordinate space - `java.awt.Component`
  x - the x coordinate position to popup the menu - `int`
  y - the y coordinate position to popup the menu - `int`

  throws: java.lang.NullPointerException - if the parent is null"
  ([^java.awt.PopupMenu this ^java.awt.Component origin ^Integer x ^Integer y]
    (-> this (.show origin x y))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this
   PopupMenu.

  returns: the AccessibleContext of this
                  PopupMenu - `javax.accessibility.AccessibleContext`"
  ([^java.awt.PopupMenu this]
    (-> this (.getAccessibleContext))))

