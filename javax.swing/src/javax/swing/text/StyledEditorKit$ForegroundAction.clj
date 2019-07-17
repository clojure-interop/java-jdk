(ns javax.swing.text.StyledEditorKit$ForegroundAction
  "An action to set foreground color.  This sets the
  StyleConstants.Foreground attribute for the
  currently selected range of the target JEditorPane.
  This is done by calling
  StyledDocument.setCharacterAttributes
  on the styled document associated with the target
  JEditorPane.

  If the target text component is specified as the
  source of the ActionEvent and there is a command string,
  the command string will be interpreted as the foreground
  color.  It will be interpreted by called
  Color.decode, and should therefore be
  legal input for that method.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text StyledEditorKit$ForegroundAction]))

(defn ->foreground-action
  "Constructor.

  Creates a new ForegroundAction.

  nm - the action name - `java.lang.String`
  fg - the foreground color - `java.awt.Color`"
  ([^java.lang.String nm ^java.awt.Color fg]
    (new StyledEditorKit$ForegroundAction nm fg)))

(defn action-performed
  "Sets the foreground color.

  e - the action event - `java.awt.event.ActionEvent`"
  ([^javax.swing.text.StyledEditorKit$ForegroundAction this ^java.awt.event.ActionEvent e]
    (-> this (.actionPerformed e))))

