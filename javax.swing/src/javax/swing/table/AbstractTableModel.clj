(ns javax.swing.table.AbstractTableModel
  "This abstract class provides default implementations for most of
   the methods in the TableModel interface. It takes care of
   the management of listeners and provides some conveniences for generating
   TableModelEvents and dispatching them to the listeners.
   To create a concrete TableModel as a subclass of
   AbstractTableModel you need only provide implementations
   for the following three methods:



   public int getRowCount();
   public int getColumnCount();
   public Object getValueAt(int row, int column);

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.table AbstractTableModel]))

(defn ->abstract-table-model
  "Constructor."
  ([]
    (new AbstractTableModel )))

(defn fire-table-structure-changed
  "Notifies all listeners that the table's structure has changed.
   The number of columns in the table, and the names and types of
   the new columns may be different from the previous state.
   If the JTable receives this event and its
   autoCreateColumnsFromModel
   flag is set it discards any table columns that it had and reallocates
   default columns in the order they appear in the model. This is the
   same as calling setModel(TableModel) on the
   JTable."
  ([^javax.swing.table.AbstractTableModel this]
    (-> this (.fireTableStructureChanged))))

(defn get-column-class
  "Returns Object.class regardless of columnIndex.

  column-index - the column being queried - `int`

  returns: the Object.class - `java.lang.Class<?>`"
  ([^javax.swing.table.AbstractTableModel this ^Integer column-index]
    (-> this (.getColumnClass column-index))))

(defn fire-table-data-changed
  "Notifies all listeners that all cell values in the table's
   rows may have changed. The number of rows may also have changed
   and the JTable should redraw the
   table from scratch. The structure of the table (as in the order of the
   columns) is assumed to be the same."
  ([^javax.swing.table.AbstractTableModel this]
    (-> this (.fireTableDataChanged))))

(defn add-table-model-listener
  "Adds a listener to the list that's notified each time a change
   to the data model occurs.

  l - the TableModelListener - `javax.swing.event.TableModelListener`"
  ([^javax.swing.table.AbstractTableModel this ^javax.swing.event.TableModelListener l]
    (-> this (.addTableModelListener l))))

(defn remove-table-model-listener
  "Removes a listener from the list that's notified each time a
   change to the data model occurs.

  l - the TableModelListener - `javax.swing.event.TableModelListener`"
  ([^javax.swing.table.AbstractTableModel this ^javax.swing.event.TableModelListener l]
    (-> this (.removeTableModelListener l))))

(defn cell-editable?
  "Returns false.  This is the default implementation for all cells.

  row-index - the row being queried - `int`
  column-index - the column being queried - `int`

  returns: false - `boolean`"
  ([^javax.swing.table.AbstractTableModel this ^Integer row-index ^Integer column-index]
    (-> this (.isCellEditable row-index column-index))))

(defn fire-table-rows-updated
  "Notifies all listeners that rows in the range
   [firstRow, lastRow], inclusive, have been updated.

  first-row - the first row - `int`
  last-row - the last row - `int`"
  ([^javax.swing.table.AbstractTableModel this ^Integer first-row ^Integer last-row]
    (-> this (.fireTableRowsUpdated first-row last-row))))

(defn get-column-name
  "Returns a default name for the column using spreadsheet conventions:
    A, B, C, ... Z, AA, AB, etc.  If column cannot be found,
    returns an empty string.

  column - the column being queried - `int`

  returns: a string containing the default name of column - `java.lang.String`"
  ([^javax.swing.table.AbstractTableModel this ^Integer column]
    (-> this (.getColumnName column))))

(defn fire-table-rows-deleted
  "Notifies all listeners that rows in the range
   [firstRow, lastRow], inclusive, have been deleted.

  first-row - the first row - `int`
  last-row - the last row - `int`"
  ([^javax.swing.table.AbstractTableModel this ^Integer first-row ^Integer last-row]
    (-> this (.fireTableRowsDeleted first-row last-row))))

(defn fire-table-rows-inserted
  "Notifies all listeners that rows in the range
   [firstRow, lastRow], inclusive, have been inserted.

  first-row - the first row - `int`
  last-row - the last row - `int`"
  ([^javax.swing.table.AbstractTableModel this ^Integer first-row ^Integer last-row]
    (-> this (.fireTableRowsInserted first-row last-row))))

(defn find-column
  "Returns a column given its name.
   Implementation is naive so this should be overridden if
   this method is to be called often. This method is not
   in the TableModel interface and is not used by the
   JTable.

  column-name - string containing name of column to be located - `java.lang.String`

  returns: the column with columnName, or -1 if not found - `int`"
  ([^javax.swing.table.AbstractTableModel this ^java.lang.String column-name]
    (-> this (.findColumn column-name))))

(defn set-value-at
  "This empty implementation is provided so users don't have to implement
    this method if their data model is not editable.

  a-value - value to assign to cell - `java.lang.Object`
  row-index - row of cell - `int`
  column-index - column of cell - `int`"
  ([^javax.swing.table.AbstractTableModel this ^java.lang.Object a-value ^Integer row-index ^Integer column-index]
    (-> this (.setValueAt a-value row-index column-index))))

(defn fire-table-cell-updated
  "Notifies all listeners that the value of the cell at
   [row, column] has been updated.

  row - row of cell which has been updated - `int`
  column - column of cell which has been updated - `int`"
  ([^javax.swing.table.AbstractTableModel this ^Integer row ^Integer column]
    (-> this (.fireTableCellUpdated row column))))

(defn get-table-model-listeners
  "Returns an array of all the table model listeners
   registered on this model.

  returns: all of this model's TableModelListeners
           or an empty
           array if no table model listeners are currently registered - `javax.swing.event.TableModelListener[]`"
  ([^javax.swing.table.AbstractTableModel this]
    (-> this (.getTableModelListeners))))

(defn fire-table-changed
  "Forwards the given notification event to all
   TableModelListeners that registered
   themselves as listeners for this table model.

  e - the event to be forwarded - `javax.swing.event.TableModelEvent`"
  ([^javax.swing.table.AbstractTableModel this ^javax.swing.event.TableModelEvent e]
    (-> this (.fireTableChanged e))))

(defn get-listeners
  "Returns an array of all the objects currently registered
   as FooListeners
   upon this AbstractTableModel.
   FooListeners are registered using the
   addFooListener method.



   You can specify the listenerType argument
   with a class literal,
   such as
   FooListener.class.
   For example, you can query a
   model m
   for its table model listeners with the following code:



  TableModelListener[] tmls = (TableModelListener[])(m.getListeners(TableModelListener.class));

   If no such listeners exist, this method returns an empty array.

  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class<T>`

  returns: an array of all objects registered as
            FooListeners on this component,
            or an empty array if no such
            listeners have been added - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if listenerType doesn't specify a class or interface that implements java.util.EventListener"
  ([^javax.swing.table.AbstractTableModel this ^java.lang.Class listener-type]
    (-> this (.getListeners listener-type))))

