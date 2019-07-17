(ns javax.swing.text.StyledEditorKit$FontSizeAction
  "An action to set the font size in the associated
  JEditorPane.  This will use the size specified as
  the command string on the ActionEvent if there is one,
  otherwise the size that was initialized with will be used.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text StyledEditorKit$FontSizeAction]))

(defn ->font-size-action
  "Constructor.

  Creates a new FontSizeAction.

  nm - the action name - `java.lang.String`
  size - the font size - `int`"
  ([^java.lang.String nm ^Integer size]
    (new StyledEditorKit$FontSizeAction nm size)))

(defn action-performed
  "Sets the font size.

  e - the action event - `java.awt.event.ActionEvent`"
  ([^javax.swing.text.StyledEditorKit$FontSizeAction this ^java.awt.event.ActionEvent e]
    (-> this (.actionPerformed e))))

