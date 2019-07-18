(ns javax.swing.MenuSelectionManager
  "A MenuSelectionManager owns the selection in menu hierarchy."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing MenuSelectionManager]))

(defn ->menu-selection-manager
  "Constructor."
  (^MenuSelectionManager []
    (new MenuSelectionManager )))

(defn *default-manager
  "Returns the default menu selection manager.

  returns: a MenuSelectionManager object - `javax.swing.MenuSelectionManager`"
  (^javax.swing.MenuSelectionManager []
    (MenuSelectionManager/defaultManager )))

(defn add-change-listener
  "Adds a ChangeListener to the button.

  l - the listener to add - `javax.swing.event.ChangeListener`"
  ([^MenuSelectionManager this ^javax.swing.event.ChangeListener l]
    (-> this (.addChangeListener l))))

(defn component-for-point
  "Returns the component in the currently selected path
   which contains sourcePoint.

  source - The component in whose coordinate space sourcePoint is given - `java.awt.Component`
  source-point - The point which is being tested - `java.awt.Point`

  returns: The component in the currently selected path which
           contains sourcePoint (relative to the source component's
           coordinate space.  If sourcePoint is not inside a component
           on the currently selected path, null is returned. - `java.awt.Component`"
  (^java.awt.Component [^MenuSelectionManager this ^java.awt.Component source ^java.awt.Point source-point]
    (-> this (.componentForPoint source source-point))))

(defn set-selected-path
  "Changes the selection in the menu hierarchy.  The elements
   in the array are sorted in order from the root menu
   element to the currently selected menu element.

   Note that this method is public but is used by the look and
   feel engine and should not be called by client applications.

  path - an array of MenuElement objects specifying the selected path - `javax.swing.MenuElement[]`"
  ([^MenuSelectionManager this path]
    (-> this (.setSelectedPath path))))

(defn remove-change-listener
  "Removes a ChangeListener from the button.

  l - the listener to remove - `javax.swing.event.ChangeListener`"
  ([^MenuSelectionManager this ^javax.swing.event.ChangeListener l]
    (-> this (.removeChangeListener l))))

(defn get-change-listeners
  "Returns an array of all the ChangeListeners added
   to this MenuSelectionManager with addChangeListener().

  returns: all of the ChangeListeners added or an empty
           array if no listeners have been added - `javax.swing.event.ChangeListener[]`"
  ([^MenuSelectionManager this]
    (-> this (.getChangeListeners))))

(defn clear-selected-path
  "Tell the menu selection to close and unselect all the menu components. Call this method
   when a choice has been made"
  ([^MenuSelectionManager this]
    (-> this (.clearSelectedPath))))

(defn process-key-event
  "When a MenuElement receives an event from a KeyListener, it should never process the event
   directly. Instead all MenuElements should call this method with the event.

  e - a KeyEvent object - `java.awt.event.KeyEvent`"
  ([^MenuSelectionManager this ^java.awt.event.KeyEvent e]
    (-> this (.processKeyEvent e))))

(defn process-mouse-event
  "When a MenuElement receives an event from a MouseListener, it should never process the event
   directly. Instead all MenuElements should call this method with the event.

  event - a MouseEvent object - `java.awt.event.MouseEvent`"
  ([^MenuSelectionManager this event]
    (-> this (.processMouseEvent event))))

(defn component-part-of-current-menu?
  "Return true if c is part of the currently used menu

  c - `java.awt.Component`

  returns: `boolean`"
  (^Boolean [^MenuSelectionManager this ^java.awt.Component c]
    (-> this (.isComponentPartOfCurrentMenu c))))

(defn get-selected-path
  "Returns the path to the currently selected menu item

  returns: an array of MenuElement objects representing the selected path - `javax.swing.MenuElement[]`"
  ([^MenuSelectionManager this]
    (-> this (.getSelectedPath))))

