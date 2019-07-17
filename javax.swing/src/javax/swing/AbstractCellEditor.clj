(ns javax.swing.AbstractCellEditor
  "A base class for CellEditors, providing default
  implementations for the methods in the CellEditor
  interface except getCellEditorValue().
  Like the other abstract implementations in Swing, also manages a list
  of listeners.


  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing AbstractCellEditor]))

(defn ->abstract-cell-editor
  "Constructor."
  ([]
    (new AbstractCellEditor )))

(defn cell-editable?
  "Returns true.

  e - an event object - `java.util.EventObject`

  returns: true - `boolean`"
  ([^javax.swing.AbstractCellEditor this ^java.util.EventObject e]
    (-> this (.isCellEditable e))))

(defn should-select-cell?
  "Returns true.

  an-event - an event object - `java.util.EventObject`

  returns: true - `boolean`"
  ([^javax.swing.AbstractCellEditor this ^java.util.EventObject an-event]
    (-> this (.shouldSelectCell an-event))))

(defn stop-cell-editing
  "Calls fireEditingStopped and returns true.

  returns: true - `boolean`"
  ([^javax.swing.AbstractCellEditor this]
    (-> this (.stopCellEditing))))

(defn cancel-cell-editing
  "Calls fireEditingCanceled."
  ([^javax.swing.AbstractCellEditor this]
    (-> this (.cancelCellEditing))))

(defn add-cell-editor-listener
  "Adds a CellEditorListener to the listener list.

  l - the new listener to be added - `javax.swing.event.CellEditorListener`"
  ([^javax.swing.AbstractCellEditor this ^javax.swing.event.CellEditorListener l]
    (-> this (.addCellEditorListener l))))

(defn remove-cell-editor-listener
  "Removes a CellEditorListener from the listener list.

  l - the listener to be removed - `javax.swing.event.CellEditorListener`"
  ([^javax.swing.AbstractCellEditor this ^javax.swing.event.CellEditorListener l]
    (-> this (.removeCellEditorListener l))))

(defn get-cell-editor-listeners
  "Returns an array of all the CellEditorListeners added
   to this AbstractCellEditor with addCellEditorListener().

  returns: all of the CellEditorListeners added or an empty
           array if no listeners have been added - `javax.swing.event.CellEditorListener[]`"
  ([^javax.swing.AbstractCellEditor this]
    (-> this (.getCellEditorListeners))))

