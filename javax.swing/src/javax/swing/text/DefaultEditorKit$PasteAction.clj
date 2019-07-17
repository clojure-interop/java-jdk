(ns javax.swing.text.DefaultEditorKit$PasteAction
  "Pastes the contents of the system clipboard into the
  selected region, or before the caret if nothing is
  selected.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text DefaultEditorKit$PasteAction]))

(defn ->paste-action
  "Constructor.

  Create this object with the appropriate identifier."
  ([]
    (new DefaultEditorKit$PasteAction )))

(defn action-performed
  "The operation to perform when this action is triggered.

  e - the action event - `java.awt.event.ActionEvent`"
  ([^javax.swing.text.DefaultEditorKit$PasteAction this ^java.awt.event.ActionEvent e]
    (-> this (.actionPerformed e))))

