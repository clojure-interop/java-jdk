(ns javax.swing.text.StyledEditorKit$UnderlineAction
  "An action to toggle the underline attribute.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text StyledEditorKit$UnderlineAction]))

(defn ->underline-action
  "Constructor.

  Constructs a new UnderlineAction."
  ([]
    (new StyledEditorKit$UnderlineAction )))

(defn action-performed
  "Toggles the Underline attribute.

  e - the action event - `java.awt.event.ActionEvent`"
  ([this e]
    (-> this (.actionPerformed e))))

