(ns javax.swing.event.MenuDragMouseEvent
  "MenuDragMouseEvent is used to notify interested parties that
  the menu element has received a MouseEvent forwarded to it
  under drag conditions.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event MenuDragMouseEvent]))

(defn ->menu-drag-mouse-event
  "Constructor.

  Constructs a MenuDragMouseEvent object.
   Even if inconsistent values for relative and absolute coordinates are
   passed to the constructor, the MenuDragMouseEvent instance is still
   created.

  source - the Component that originated the event (typically this) - `java.awt.Component`
  id - an int specifying the type of event, as defined in MouseEvent - `int`
  when - a long identifying the time the event occurred - `long`
  modifiers - an int specifying any modifier keys held down, as specified in InputEvent - `int`
  x - an int specifying the horizontal position at which the event occurred, in pixels - `int`
  y - an int specifying the vertical position at which the event occurred, in pixels - `int`
  x-abs - an int specifying the horizontal absolute position at which the event occurred, in pixels - `int`
  y-abs - an int specifying the vertical absolute position at which the event occurred, in pixels - `int`
  click-count - an int specifying the number of mouse-clicks - `int`
  popup-trigger - a boolean -- true if the event {should?/did?} trigger a popup - `boolean`
  p - an array of MenuElement objects specifying a path to a menu item affected by the drag - `javax.swing.MenuElement[]`
  m - a MenuSelectionManager object that handles selections - `javax.swing.MenuSelectionManager`"
  ([^java.awt.Component source ^Integer id ^Long when ^Integer modifiers ^Integer x ^Integer y ^Integer x-abs ^Integer y-abs ^Integer click-count ^Boolean popup-trigger p ^javax.swing.MenuSelectionManager m]
    (new MenuDragMouseEvent source id when modifiers x y x-abs y-abs click-count popup-trigger p m))
  ([^java.awt.Component source ^Integer id ^Long when ^Integer modifiers ^Integer x ^Integer y ^Integer click-count ^Boolean popup-trigger p ^javax.swing.MenuSelectionManager m]
    (new MenuDragMouseEvent source id when modifiers x y click-count popup-trigger p m)))

(defn get-path
  "Returns the path to the selected menu item.

  returns: an array of MenuElement objects representing the path value - `javax.swing.MenuElement[]`"
  ([^javax.swing.event.MenuDragMouseEvent this]
    (-> this (.getPath))))

(defn get-menu-selection-manager
  "Returns the current menu selection manager.

  returns: a MenuSelectionManager object - `javax.swing.MenuSelectionManager`"
  (^javax.swing.MenuSelectionManager [^javax.swing.event.MenuDragMouseEvent this]
    (-> this (.getMenuSelectionManager))))

