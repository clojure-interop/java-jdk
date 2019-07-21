(ns javax.swing.JRadioButton
  "An implementation of a radio button -- an item that can be selected or
  deselected, and which displays its state to the user.
  Used with a ButtonGroup object to create a group of buttons
  in which only one button at a time can be selected. (Create a ButtonGroup
  object and use its add method to include the JRadioButton objects
  in the group.)

  Note:
  The ButtonGroup object is a logical grouping -- not a physical grouping.
  To create a button panel, you should still create a JPanel or similar
  container-object and add a Border to it to set it off from surrounding
  components.


  Buttons can be configured, and to some degree controlled, by
  Actions.  Using an
  Action with a button has many benefits beyond directly
  configuring a button.  Refer to
  Swing Components Supporting Action for more
  details, and you can find more information in How
  to Use Actions, a section in The Java Tutorial.

  See How to Use Buttons, Check Boxes, and Radio Buttons
  in The Java Tutorial
  for further documentation.

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
  (:import [javax.swing JRadioButton]))

(defn ->j-radio-button
  "Constructor.

  Creates a radio button that has the specified text, image,
   and selection state.

  text - the string displayed on the radio button - `java.lang.String`
  icon - the image that the button should display - `javax.swing.Icon`
  selected - `boolean`"
  (^JRadioButton [^java.lang.String text ^javax.swing.Icon icon ^Boolean selected]
    (new JRadioButton text icon selected))
  (^JRadioButton [^javax.swing.Icon icon ^Boolean selected]
    (new JRadioButton icon selected))
  (^JRadioButton [^javax.swing.Icon icon]
    (new JRadioButton icon))
  (^JRadioButton []
    (new JRadioButton )))

(defn update-ui
  "Resets the UI property to a value from the current look and feel."
  ([^JRadioButton this]
    (-> this (.updateUI))))

(defn get-ui-class-id
  "Returns the name of the L&F class
   that renders this component.

  returns: String \"RadioButtonUI\" - `java.lang.String`"
  (^java.lang.String [^JRadioButton this]
    (-> this (.getUIClassID))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JRadioButton.
   For JRadioButtons, the AccessibleContext takes the form of an
   AccessibleJRadioButton.
   A new AccessibleJRadioButton instance is created if necessary.

  returns: an AccessibleJRadioButton that serves as the
           AccessibleContext of this JRadioButton - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^JRadioButton this]
    (-> this (.getAccessibleContext))))

