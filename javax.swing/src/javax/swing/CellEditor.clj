(ns javax.swing.CellEditor
  "This interface defines the methods any general editor should be able
  to implement.

  Having this interface enables complex components (the client of the
  editor) such as JTree and
  JTable to allow any generic editor to
  edit values in a table cell, or tree cell, etc.  Without this generic
  editor interface, JTable would have to know about specific editors,
  such as JTextField, JCheckBox, JComboBox,
  etc.  In addition, without this interface, clients of editors such as
  JTable would not be able
  to work with any editors developed in the future by the user
  or a 3rd party ISV.

  To use this interface, a developer creating a new editor can have the
  new component implement the interface.  Or the developer can
  choose a wrapper based approach and provide a companion object which
  implements the CellEditor interface (See
  DefaultCellEditor for example).  The wrapper approach
  is particularly useful if the user want to use a 3rd party ISV
  editor with JTable, but the ISV didn't implement the
  CellEditor interface.  The user can simply create an object
  that contains an instance of the 3rd party editor object and `translate`
  the CellEditor API into the 3rd party editor's API."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing CellEditor]))

(defn get-cell-editor-value
  "Returns the value contained in the editor.

  returns: the value contained in the editor - `java.lang.Object`"
  ([this]
    (-> this (.getCellEditorValue))))

(defn cell-editable?
  "Asks the editor if it can start editing using anEvent.
   anEvent is in the invoking component coordinate system.
   The editor can not assume the Component returned by
   getCellEditorComponent is installed.  This method
   is intended for the use of client to avoid the cost of setting up
   and installing the editor component if editing is not possible.
   If editing can be started this method returns true.

  an-event - the event the editor should use to consider whether to begin editing or not - `java.util.EventObject`

  returns: true if editing can be started - `boolean`"
  ([this an-event]
    (-> this (.isCellEditable an-event))))

(defn should-select-cell?
  "Returns true if the editing cell should be selected, false otherwise.
   Typically, the return value is true, because is most cases the editing
   cell should be selected.  However, it is useful to return false to
   keep the selection from changing for some types of edits.
   eg. A table that contains a column of check boxes, the user might
   want to be able to change those checkboxes without altering the
   selection.  (See Netscape Communicator for just such an example)
   Of course, it is up to the client of the editor to use the return
   value, but it doesn't need to if it doesn't want to.

  an-event - the event the editor should use to start editing - `java.util.EventObject`

  returns: true if the editor would like the editing cell to be selected;
      otherwise returns false - `boolean`"
  ([this an-event]
    (-> this (.shouldSelectCell an-event))))

(defn stop-cell-editing
  "Tells the editor to stop editing and accept any partially edited
   value as the value of the editor.  The editor returns false if
   editing was not stopped; this is useful for editors that validate
   and can not accept invalid entries.

  returns: true if editing was stopped; false otherwise - `boolean`"
  ([this]
    (-> this (.stopCellEditing))))

(defn cancel-cell-editing
  "Tells the editor to cancel editing and not accept any partially
   edited value."
  ([this]
    (-> this (.cancelCellEditing))))

(defn add-cell-editor-listener
  "Adds a listener to the list that's notified when the editor
   stops, or cancels editing.

  l - the CellEditorListener - `javax.swing.event.CellEditorListener`"
  ([this l]
    (-> this (.addCellEditorListener l))))

(defn remove-cell-editor-listener
  "Removes a listener from the list that's notified

  l - the CellEditorListener - `javax.swing.event.CellEditorListener`"
  ([this l]
    (-> this (.removeCellEditorListener l))))

