(ns javax.swing.JToggleButton
  "An implementation of a two-state button.
  The JRadioButton and JCheckBox classes
  are subclasses of this class.
  For information on using them see
  How to Use Buttons, Check Boxes, and Radio Buttons,
  a section in The Java Tutorial.

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
  (:import [javax.swing JToggleButton]))

(defn ->j-toggle-button
  "Constructor.

  Creates a toggle button with the specified text, image, and
   selection state.

  text - the text of the toggle button - `java.lang.String`
  icon - the image that the button should display - `javax.swing.Icon`
  selected - if true, the button is initially selected; otherwise, the button is initially unselected - `boolean`"
  ([^java.lang.String text ^javax.swing.Icon icon ^Boolean selected]
    (new JToggleButton text icon selected))
  ([^javax.swing.Icon icon ^Boolean selected]
    (new JToggleButton icon selected))
  ([^javax.swing.Icon icon]
    (new JToggleButton icon))
  ([]
    (new JToggleButton )))

(defn update-ui
  "Resets the UI property to a value from the current look and feel."
  ([^javax.swing.JToggleButton this]
    (-> this (.updateUI))))

(defn get-ui-class-id
  "Returns a string that specifies the name of the l&f class
   that renders this component.

  returns: String `ToggleButtonUI` - `java.lang.String`"
  ([^javax.swing.JToggleButton this]
    (-> this (.getUIClassID))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JToggleButton.
   For toggle buttons, the AccessibleContext takes the form of an
   AccessibleJToggleButton.
   A new AccessibleJToggleButton instance is created if necessary.

  returns: an AccessibleJToggleButton that serves as the
           AccessibleContext of this JToggleButton - `javax.accessibility.AccessibleContext`"
  ([^javax.swing.JToggleButton this]
    (-> this (.getAccessibleContext))))

