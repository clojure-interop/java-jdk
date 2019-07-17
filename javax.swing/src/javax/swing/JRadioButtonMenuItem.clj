(ns javax.swing.JRadioButtonMenuItem
  "An implementation of a radio button menu item.
  A JRadioButtonMenuItem is
  a menu item that is part of a group of menu items in which only one
  item in the group can be selected. The selected item displays its
  selected state. Selecting it causes any other selected item to
  switch to the unselected state.
  To control the selected state of a group of radio button menu items,
  use a ButtonGroup object.

  Menu items can be configured, and to some degree controlled, by
  Actions.  Using an
  Action with a menu item has many benefits beyond directly
  configuring a menu item.  Refer to
  Swing Components Supporting Action for more
  details, and you can find more information in How
  to Use Actions, a section in The Java Tutorial.

  For further documentation and examples see
  How to Use Menus,
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
  (:import [javax.swing JRadioButtonMenuItem]))

(defn ->j-radio-button-menu-item
  "Constructor.

  Creates a radio button menu item that has the specified
   text, image, and selection state.  All other constructors
   defer to this one.

  text - the string displayed on the radio button - `java.lang.String`
  icon - the image that the button should display - `javax.swing.Icon`
  selected - `boolean`"
  ([text icon selected]
    (new JRadioButtonMenuItem text icon selected))
  ([text icon]
    (new JRadioButtonMenuItem text icon))
  ([icon]
    (new JRadioButtonMenuItem icon))
  ([]
    (new JRadioButtonMenuItem )))

(defn get-ui-class-id
  "Returns the name of the L&F class that renders this component.

  returns: the string `RadioButtonMenuItemUI` - `java.lang.String`"
  ([this]
    (-> this (.getUIClassID))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JRadioButtonMenuItem.
   For JRadioButtonMenuItems, the AccessibleContext takes the form of an
   AccessibleJRadioButtonMenuItem.
   A new AccessibleJRadioButtonMenuItem instance is created if necessary.

  returns: an AccessibleJRadioButtonMenuItem that serves as the
           AccessibleContext of this JRadioButtonMenuItem - `javax.accessibility.AccessibleContext`"
  ([this]
    (-> this (.getAccessibleContext))))

