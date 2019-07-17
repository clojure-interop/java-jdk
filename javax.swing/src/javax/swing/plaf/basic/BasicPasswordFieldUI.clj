(ns javax.swing.plaf.basic.BasicPasswordFieldUI
  "Provides the Windows look and feel for a password field.
  The only difference from the standard text field is that
  the view of the text is simply a string of the echo
  character as specified in JPasswordField, rather than the
  real text contained in the field."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicPasswordFieldUI]))

(defn ->basic-password-field-ui
  "Constructor."
  ([]
    (new BasicPasswordFieldUI )))

(defn *create-ui
  "Creates a UI for a JPasswordField.

  c - the JPasswordField - `javax.swing.JComponent`

  returns: the UI - `javax.swing.plaf.ComponentUI`"
  ([^javax.swing.JComponent c]
    (BasicPasswordFieldUI/createUI c)))

(defn create
  "Creates a view (PasswordView) for an element.

  elem - the element - `javax.swing.text.Element`

  returns: the view - `javax.swing.text.View`"
  ([^javax.swing.plaf.basic.BasicPasswordFieldUI this ^javax.swing.text.Element elem]
    (-> this (.create elem))))

