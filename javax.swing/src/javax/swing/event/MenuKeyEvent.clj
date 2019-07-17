(ns javax.swing.event.MenuKeyEvent
  "MenuKeyEvent is used to notify interested parties that
  the menu element has received a KeyEvent forwarded to it
  in a menu tree.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event MenuKeyEvent]))

(defn ->menu-key-event
  "Constructor.

  Constructs a MenuKeyEvent object.

  source - the Component that originated the event (typically this) - `java.awt.Component`
  id - an int specifying the type of event, as defined in KeyEvent - `int`
  when - a long identifying the time the event occurred - `long`
  modifiers - an int specifying any modifier keys held down, as specified in InputEvent - `int`
  key-code - an int specifying the specific key that was pressed - `int`
  key-char - a char specifying the key's character value, if any -- null if the key has no character value - `char`
  p - an array of MenuElement objects specifying a path to a menu item affected by the drag - `javax.swing.MenuElement[]`
  m - a MenuSelectionManager object that handles selections - `javax.swing.MenuSelectionManager`"
  ([^java.awt.Component source ^Integer id ^Long when ^Integer modifiers ^Integer key-code ^Character key-char p ^javax.swing.MenuSelectionManager m]
    (new MenuKeyEvent source id when modifiers key-code key-char p m)))

(defn get-path
  "Returns the path to the menu item referenced by this event.

  returns: an array of MenuElement objects representing the path value - `javax.swing.MenuElement[]`"
  ([^javax.swing.event.MenuKeyEvent this]
    (-> this (.getPath))))

(defn get-menu-selection-manager
  "Returns the current menu selection manager.

  returns: a MenuSelectionManager object - `javax.swing.MenuSelectionManager`"
  (^javax.swing.MenuSelectionManager [^javax.swing.event.MenuKeyEvent this]
    (-> this (.getMenuSelectionManager))))

