(ns javax.swing.table.TableCellEditor
  "This interface defines the method any object that would like to be
  an editor of values for components such as JListBox,
  JComboBox, JTree, or JTable
  needs to implement."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.table TableCellEditor]))

(defn get-table-cell-editor-component
  "Sets an initial value for the editor.  This will cause
    the editor to stopEditing and lose any partially
    edited value if the editor is editing when this method is called.

    Returns the component that should be added to the client's
    Component hierarchy.  Once installed in the client's
    hierarchy this component will then be able to draw and receive
    user input.

  table - the JTable that is asking the editor to edit; can be null - `javax.swing.JTable`
  value - the value of the cell to be edited; it is up to the specific editor to interpret and draw the value. For example, if value is the string `true`, it could be rendered as a string or it could be rendered as a check box that is checked. null is a valid value - `java.lang.Object`
  is-selected - true if the cell is to be rendered with highlighting - `boolean`
  row - the row of the cell being edited - `int`
  column - the column of the cell being edited - `int`

  returns: the component for editing - `java.awt.Component`"
  ([^. this ^javax.swing.JTable table ^java.lang.Object value ^Boolean is-selected ^Integer row ^Integer column]
    (-> this (.getTableCellEditorComponent table value is-selected row column))))

