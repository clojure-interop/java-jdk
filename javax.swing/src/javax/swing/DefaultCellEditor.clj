(ns javax.swing.DefaultCellEditor
  "The default editor for table and tree cells.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing DefaultCellEditor]))

(defn ->default-cell-editor
  "Constructor.

  Constructs a DefaultCellEditor that uses a text field.

  text-field - a JTextField object - `javax.swing.JTextField`"
  (^DefaultCellEditor [^javax.swing.JTextField text-field]
    (new DefaultCellEditor text-field)))

(defn cancel-cell-editing
  "Forwards the message from the CellEditor to
   the delegate."
  ([^DefaultCellEditor this]
    (-> this (.cancelCellEditing))))

(defn get-component
  "Returns a reference to the editor component.

  returns: the editor Component - `java.awt.Component`"
  (^java.awt.Component [^DefaultCellEditor this]
    (-> this (.getComponent))))

(defn stop-cell-editing
  "Forwards the message from the CellEditor to
   the delegate.

  returns: true - `boolean`"
  (^Boolean [^DefaultCellEditor this]
    (-> this (.stopCellEditing))))

(defn get-cell-editor-value
  "Forwards the message from the CellEditor to
   the delegate.

  returns: the value contained in the editor - `java.lang.Object`"
  (^java.lang.Object [^DefaultCellEditor this]
    (-> this (.getCellEditorValue))))

(defn get-tree-cell-editor-component
  "Implements the TreeCellEditor interface.

  tree - the JTree that is asking the editor to edit; this parameter can be null - `javax.swing.JTree`
  value - the value of the cell to be edited - `java.lang.Object`
  is-selected - true if the cell is to be rendered with selection highlighting - `boolean`
  expanded - true if the node is expanded - `boolean`
  leaf - true if the node is a leaf node - `boolean`
  row - the row index of the node being edited - `int`

  returns: the component for editing - `java.awt.Component`"
  (^java.awt.Component [^DefaultCellEditor this ^javax.swing.JTree tree ^java.lang.Object value ^Boolean is-selected ^Boolean expanded ^Boolean leaf ^Integer row]
    (-> this (.getTreeCellEditorComponent tree value is-selected expanded leaf row))))

(defn get-click-count-to-start
  "Returns the number of clicks needed to start editing.

  returns: the number of clicks needed to start editing - `int`"
  (^Integer [^DefaultCellEditor this]
    (-> this (.getClickCountToStart))))

(defn cell-editable?
  "Forwards the message from the CellEditor to
   the delegate.

  an-event - an event object - `java.util.EventObject`

  returns: true - `boolean`"
  (^Boolean [^DefaultCellEditor this ^java.util.EventObject an-event]
    (-> this (.isCellEditable an-event))))

(defn should-select-cell?
  "Forwards the message from the CellEditor to
   the delegate.

  an-event - an event object - `java.util.EventObject`

  returns: true - `boolean`"
  (^Boolean [^DefaultCellEditor this ^java.util.EventObject an-event]
    (-> this (.shouldSelectCell an-event))))

(defn set-click-count-to-start
  "Specifies the number of clicks needed to start editing.

  count - an int specifying the number of clicks needed to start editing - `int`"
  ([^DefaultCellEditor this ^Integer count]
    (-> this (.setClickCountToStart count))))

(defn get-table-cell-editor-component
  "Implements the TableCellEditor interface.

  table - the JTable that is asking the editor to edit; can be null - `javax.swing.JTable`
  value - the value of the cell to be edited; it is up to the specific editor to interpret and draw the value. For example, if value is the string \"true\", it could be rendered as a string or it could be rendered as a check box that is checked. null is a valid value - `java.lang.Object`
  is-selected - true if the cell is to be rendered with highlighting - `boolean`
  row - the row of the cell being edited - `int`
  column - the column of the cell being edited - `int`

  returns: the component for editing - `java.awt.Component`"
  (^java.awt.Component [^DefaultCellEditor this ^javax.swing.JTable table ^java.lang.Object value ^Boolean is-selected ^Integer row ^Integer column]
    (-> this (.getTableCellEditorComponent table value is-selected row column))))

