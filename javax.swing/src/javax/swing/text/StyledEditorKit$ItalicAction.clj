(ns javax.swing.text.StyledEditorKit$ItalicAction
  "An action to toggle the italic attribute.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text StyledEditorKit$ItalicAction]))

(defn ->italic-action
  "Constructor.

  Constructs a new ItalicAction."
  ([]
    (new StyledEditorKit$ItalicAction )))

(defn action-performed
  "Toggles the italic attribute.

  e - the action event - `java.awt.event.ActionEvent`"
  ([this e]
    (-> this (.actionPerformed e))))

