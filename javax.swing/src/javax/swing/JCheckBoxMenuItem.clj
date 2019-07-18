(ns javax.swing.JCheckBoxMenuItem
  "A menu item that can be selected or deselected. If selected, the menu
  item typically appears with a checkmark next to it. If unselected or
  deselected, the menu item appears without a checkmark. Like a regular
  menu item, a check box menu item can have either text or a graphic
  icon associated with it, or both.

  Either isSelected/setSelected or
  getState/setState can be used
  to determine/specify the menu item's selection state. The
  preferred methods are isSelected and
  setSelected, which work for all menus and buttons.
  The getState and setState methods exist for
  compatibility with other component sets.

  Menu items can be configured, and to some degree controlled, by
  Actions.  Using an
  Action with a menu item has many benefits beyond directly
  configuring a menu item.  Refer to
  Swing Components Supporting Action for more
  details, and you can find more information in How
  to Use Actions, a section in The Java Tutorial.

  For further information and examples of using check box menu items,
  see How to Use Menus,
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
  (:import [javax.swing JCheckBoxMenuItem]))

(defn ->j-check-box-menu-item
  "Constructor.

  Creates a check box menu item with the specified text, icon, and selection state.

  text - the text of the check box menu item - `java.lang.String`
  icon - the icon of the check box menu item - `javax.swing.Icon`
  b - the selected state of the check box menu item - `boolean`"
  (^JCheckBoxMenuItem [^java.lang.String text ^javax.swing.Icon icon ^Boolean b]
    (new JCheckBoxMenuItem text icon b))
  (^JCheckBoxMenuItem [^java.lang.String text ^javax.swing.Icon icon]
    (new JCheckBoxMenuItem text icon))
  (^JCheckBoxMenuItem [^javax.swing.Icon icon]
    (new JCheckBoxMenuItem icon))
  (^JCheckBoxMenuItem []
    (new JCheckBoxMenuItem )))

(defn get-ui-class-id
  "Returns the name of the L&F class
   that renders this component.

  returns: `CheckBoxMenuItemUI` - `java.lang.String`"
  (^java.lang.String [^JCheckBoxMenuItem this]
    (-> this (.getUIClassID))))

(defn get-state?
  "Returns the selected-state of the item. This method
   exists for AWT compatibility only.  New code should
   use isSelected() instead.

  returns: true  if the item is selected - `boolean`"
  (^Boolean [^JCheckBoxMenuItem this]
    (-> this (.getState))))

(defn set-state
  "Sets the selected-state of the item. This method
   exists for AWT compatibility only.  New code should
   use setSelected() instead.

  b - a boolean value indicating the item's selected-state, where true=selected - `boolean`"
  ([^JCheckBoxMenuItem this ^Boolean b]
    (-> this (.setState b))))

(defn get-selected-objects
  "Returns an array (length 1) containing the check box menu item
   label or null if the check box is not selected.

  returns: an array containing one Object -- the text of the menu item
           -- if the item is selected; otherwise null - `java.lang.Object[]`"
  ([^JCheckBoxMenuItem this]
    (-> this (.getSelectedObjects))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JCheckBoxMenuItem.
   For JCheckBoxMenuItems, the AccessibleContext takes the form of an
   AccessibleJCheckBoxMenuItem.
   A new AccessibleJCheckBoxMenuItem instance is created if necessary.

  returns: an AccessibleJCheckBoxMenuItem that serves as the
           AccessibleContext of this AccessibleJCheckBoxMenuItem - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^JCheckBoxMenuItem this]
    (-> this (.getAccessibleContext))))

