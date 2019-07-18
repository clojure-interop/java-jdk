(ns javax.swing.text.DefaultEditorKit$InsertTabAction
  "Places a tab character into the document. If there
  is a selection, it is removed before the tab is added.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text DefaultEditorKit$InsertTabAction]))

(defn ->insert-tab-action
  "Constructor.

  Creates this object with the appropriate identifier."
  (^DefaultEditorKit$InsertTabAction []
    (new DefaultEditorKit$InsertTabAction )))

(defn action-performed
  "The operation to perform when this action is triggered.

  e - the action event - `java.awt.event.ActionEvent`"
  ([^DefaultEditorKit$InsertTabAction this ^java.awt.event.ActionEvent e]
    (-> this (.actionPerformed e))))

