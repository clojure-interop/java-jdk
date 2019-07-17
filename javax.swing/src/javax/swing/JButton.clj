(ns javax.swing.JButton
  "An implementation of a `push` button.

  Buttons can be configured, and to some degree controlled, by
  Actions.  Using an
  Action with a button has many benefits beyond directly
  configuring a button.  Refer to
  Swing Components Supporting Action for more
  details, and you can find more information in How
  to Use Actions, a section in The Java Tutorial.

  See How to Use Buttons, Check Boxes, and Radio Buttons
  in The Java Tutorial
  for information and examples of using buttons.

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
  (:import [javax.swing JButton]))

(defn ->j-button
  "Constructor.

  Creates a button with initial text and an icon.

  text - the text of the button - `java.lang.String`
  icon - the Icon image to display on the button - `javax.swing.Icon`"
  ([^java.lang.String text ^javax.swing.Icon icon]
    (new JButton text icon))
  ([^javax.swing.Icon icon]
    (new JButton icon))
  ([]
    (new JButton )))

(defn update-ui
  "Resets the UI property to a value from the current look and
   feel."
  ([^javax.swing.JButton this]
    (-> this (.updateUI))))

(defn get-ui-class-id
  "Returns a string that specifies the name of the L&F class
   that renders this component.

  returns: the string `ButtonUI` - `java.lang.String`"
  (^java.lang.String [^javax.swing.JButton this]
    (-> this (.getUIClassID))))

(defn default-button?
  "Gets the value of the defaultButton property,
   which if true means that this button is the current
   default button for its JRootPane.
   Most look and feels render the default button
   differently, and may potentially provide bindings
   to access the default button.

  returns: the value of the defaultButton property - `boolean`"
  (^Boolean [^javax.swing.JButton this]
    (-> this (.isDefaultButton))))

(defn default-capable?
  "Gets the value of the defaultCapable property.

  returns: the value of the defaultCapable property - `boolean`"
  (^Boolean [^javax.swing.JButton this]
    (-> this (.isDefaultCapable))))

(defn set-default-capable
  "Sets the defaultCapable property,
   which determines whether this button can be
   made the default button for its root pane.
   The default value of the defaultCapable
   property is true unless otherwise
   specified by the look and feel.

  default-capable - true if this button will be capable of being the default button on the RootPane; otherwise false - `boolean`"
  ([^javax.swing.JButton this ^Boolean default-capable]
    (-> this (.setDefaultCapable default-capable))))

(defn remove-notify
  "Overrides JComponent.removeNotify to check if
   this button is currently set as the default button on the
   RootPane, and if so, sets the RootPane's
   default button to null to ensure the
   RootPane doesn't hold onto an invalid button reference."
  ([^javax.swing.JButton this]
    (-> this (.removeNotify))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this
   JButton. For JButtons,
   the AccessibleContext takes the form of an
   AccessibleJButton.
   A new AccessibleJButton instance is created if necessary.

  returns: an AccessibleJButton that serves as the
           AccessibleContext of this JButton - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^javax.swing.JButton this]
    (-> this (.getAccessibleContext))))

