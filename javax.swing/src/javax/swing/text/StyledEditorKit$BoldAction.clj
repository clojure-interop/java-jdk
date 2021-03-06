(ns javax.swing.text.StyledEditorKit$BoldAction
  "An action to toggle the bold attribute.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text StyledEditorKit$BoldAction]))

(defn ->bold-action
  "Constructor.

  Constructs a new BoldAction."
  (^StyledEditorKit$BoldAction []
    (new StyledEditorKit$BoldAction )))

(defn action-performed
  "Toggles the bold attribute.

  e - the action event - `java.awt.event.ActionEvent`"
  ([^StyledEditorKit$BoldAction this ^java.awt.event.ActionEvent e]
    (-> this (.actionPerformed e))))

