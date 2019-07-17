(ns javax.swing.ButtonGroup
  "This class is used to create a multiple-exclusion scope for
  a set of buttons. Creating a set of buttons with the
  same ButtonGroup object means that
  turning `on` one of those buttons
  turns off all other buttons in the group.

  A ButtonGroup can be used with
  any set of objects that inherit from AbstractButton.
  Typically a button group contains instances of
  JRadioButton,
  JRadioButtonMenuItem,
  or JToggleButton.
  It wouldn't make sense to put an instance of
  JButton or JMenuItem
  in a button group
  because JButton and JMenuItem
  don't implement the selected state.

  Initially, all buttons in the group are unselected.

  For examples and further information on using button groups see
  How to Use Radio Buttons,
  a section in The Java Tutorial.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing ButtonGroup]))

(defn ->button-group
  "Constructor.

  Creates a new ButtonGroup."
  ([]
    (new ButtonGroup )))

(defn add
  "Adds the button to the group.

  b - the button to be added - `javax.swing.AbstractButton`"
  ([^javax.swing.ButtonGroup this ^javax.swing.AbstractButton b]
    (-> this (.add b))))

(defn remove
  "Removes the button from the group.

  b - the button to be removed - `javax.swing.AbstractButton`"
  ([^javax.swing.ButtonGroup this ^javax.swing.AbstractButton b]
    (-> this (.remove b))))

(defn clear-selection
  "Clears the selection such that none of the buttons
   in the ButtonGroup are selected."
  ([^javax.swing.ButtonGroup this]
    (-> this (.clearSelection))))

(defn get-elements
  "Returns all the buttons that are participating in
   this group.

  returns: an Enumeration of the buttons in this group - `java.util.Enumeration<javax.swing.AbstractButton>`"
  (^java.util.Enumeration [^javax.swing.ButtonGroup this]
    (-> this (.getElements))))

(defn get-selection
  "Returns the model of the selected button.

  returns: the selected button model - `javax.swing.ButtonModel`"
  (^javax.swing.ButtonModel [^javax.swing.ButtonGroup this]
    (-> this (.getSelection))))

(defn set-selected
  "Sets the selected value for the ButtonModel.
   Only one button in the group may be selected at a time.

  m - the ButtonModel - `javax.swing.ButtonModel`
  b - true if this button is to be selected, otherwise false - `boolean`"
  ([^javax.swing.ButtonGroup this ^javax.swing.ButtonModel m ^Boolean b]
    (-> this (.setSelected m b))))

(defn selected?
  "Returns whether a ButtonModel is selected.

  m - `javax.swing.ButtonModel`

  returns: true if the button is selected,
     otherwise returns false - `boolean`"
  (^Boolean [^javax.swing.ButtonGroup this ^javax.swing.ButtonModel m]
    (-> this (.isSelected m))))

(defn get-button-count
  "Returns the number of buttons in the group.

  returns: the button count - `int`"
  (^Integer [^javax.swing.ButtonGroup this]
    (-> this (.getButtonCount))))

