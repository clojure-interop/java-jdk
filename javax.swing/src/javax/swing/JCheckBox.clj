(ns javax.swing.JCheckBox
  "An implementation of a check box -- an item that can be selected or
  deselected, and which displays its state to the user.
  By convention, any number of check boxes in a group can be selected.
  See How to Use Buttons, Check Boxes, and Radio Buttons
  in The Java Tutorial
  for examples and information on using check boxes.

  Buttons can be configured, and to some degree controlled, by
  Actions.  Using an
  Action with a button has many benefits beyond directly
  configuring a button.  Refer to
  Swing Components Supporting Action for more
  details, and you can find more information in How
  to Use Actions, a section in The Java Tutorial.

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
  (:import [javax.swing JCheckBox]))

(defn ->j-check-box
  "Constructor.

  Creates a check box with text and icon,
   and specifies whether or not it is initially selected.

  text - the text of the check box. - `java.lang.String`
  icon - the Icon image to display - `javax.swing.Icon`
  selected - a boolean value indicating the initial selection state. If true the check box is selected - `boolean`"
  (^JCheckBox [^java.lang.String text ^javax.swing.Icon icon ^Boolean selected]
    (new JCheckBox text icon selected))
  (^JCheckBox [^javax.swing.Icon icon ^Boolean selected]
    (new JCheckBox icon selected))
  (^JCheckBox [^javax.swing.Icon icon]
    (new JCheckBox icon))
  (^JCheckBox []
    (new JCheckBox )))

(def *-border-painted-flat-changed-property
  "Static Constant.

  Identifies a change to the flat property.

  type: java.lang.String"
  JCheckBox/BORDER_PAINTED_FLAT_CHANGED_PROPERTY)

(defn set-border-painted-flat
  "Sets the borderPaintedFlat property,
   which gives a hint to the look and feel as to the
   appearance of the check box border.
   This is usually set to true when a
   JCheckBox instance is used as a
   renderer in a component such as a JTable or
   JTree.  The default value for the
   borderPaintedFlat property is false.
   This method fires a property changed event.
   Some look and feels might not implement flat borders;
   they will ignore this property.

  b - true requests that the border be painted flat; false requests normal borders - `boolean`"
  ([^JCheckBox this ^Boolean b]
    (-> this (.setBorderPaintedFlat b))))

(defn border-painted-flat?
  "Gets the value of the borderPaintedFlat property.

  returns: the value of the borderPaintedFlat property - `boolean`"
  (^Boolean [^JCheckBox this]
    (-> this (.isBorderPaintedFlat))))

(defn update-ui
  "Resets the UI property to a value from the current look and feel."
  ([^JCheckBox this]
    (-> this (.updateUI))))

(defn get-ui-class-id
  "Returns a string that specifies the name of the L&F class
   that renders this component.

  returns: the string `CheckBoxUI` - `java.lang.String`"
  (^java.lang.String [^JCheckBox this]
    (-> this (.getUIClassID))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JCheckBox.
   For JCheckBoxes, the AccessibleContext takes the form of an
   AccessibleJCheckBox.
   A new AccessibleJCheckBox instance is created if necessary.

  returns: an AccessibleJCheckBox that serves as the
           AccessibleContext of this JCheckBox - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^JCheckBox this]
    (-> this (.getAccessibleContext))))

