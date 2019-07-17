(ns javax.swing.MenuElement
  "Any component that can be placed into a menu should implement this interface.
  This interface is used by MenuSelectionManager
  to handle selection and navigation in menu hierarchies."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing MenuElement]))

(defn process-mouse-event
  "Processes a mouse event. event is a MouseEvent
   with source being the receiving element's component.
   path is the path of the receiving element in the menu
   hierarchy including the receiving element itself.
   manager is the MenuSelectionManager
   for the menu hierarchy.
   This method should process the MouseEvent and change
   the menu selection if necessary
   by using MenuSelectionManager's API
   Note: you do not have to forward the event to sub-components.
   This is done automatically by the MenuSelectionManager.

  event - `java.awt.event.MouseEvent`
  path - `javax.swing.MenuElement[]`
  manager - `javax.swing.MenuSelectionManager`"
  ([^. this ^java.awt.event.MouseEvent event ^javax.swing.MenuElement[] path ^javax.swing.MenuSelectionManager manager]
    (-> this (.processMouseEvent event path manager))))

(defn process-key-event
  "Process a key event.

  event - `java.awt.event.KeyEvent`
  path - `javax.swing.MenuElement[]`
  manager - `javax.swing.MenuSelectionManager`"
  ([^. this ^java.awt.event.KeyEvent event ^javax.swing.MenuElement[] path ^javax.swing.MenuSelectionManager manager]
    (-> this (.processKeyEvent event path manager))))

(defn menu-selection-changed
  "Call by the MenuSelectionManager when the
   MenuElement is added or remove from
   the menu selection.

  is-included - `boolean`"
  ([^. this ^Boolean is-included]
    (-> this (.menuSelectionChanged is-included))))

(defn get-sub-elements
  "This method should return an array containing the sub-elements for the receiving menu element

  returns: an array of MenuElements - `javax.swing.MenuElement[]`"
  ([^. this]
    (-> this (.getSubElements))))

(defn get-component
  "This method should return the java.awt.Component used to paint the receiving element.
   The returned component will be used to convert events and detect if an event is inside
   a MenuElement's component.

  returns: the Component value - `java.awt.Component`"
  ([^. this]
    (-> this (.getComponent))))

