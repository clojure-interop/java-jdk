(ns javax.swing.table.TableModel
  "The TableModel interface specifies the methods the
   JTable will use to interrogate a tabular data model.

   The JTable can be set up to display any data
   model which implements the
   TableModel interface with a couple of lines of code:


       TableModel myData = new MyTableModel();
       JTable table = new JTable(myData);

  For further documentation, see Creating a Table Model
  in The Java Tutorial."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.table TableModel]))

(defn get-column-class
  "Returns the most specific superclass for all the cell values
   in the column.  This is used by the JTable to set up a
   default renderer and editor for the column.

  column-index - the index of the column - `int`

  returns: the common ancestor class of the object values in the model. - `java.lang.Class<?>`"
  (^java.lang.Class [^TableModel this ^Integer column-index]
    (-> this (.getColumnClass column-index))))

(defn add-table-model-listener
  "Adds a listener to the list that is notified each time a change
   to the data model occurs.

  l - the TableModelListener - `javax.swing.event.TableModelListener`"
  ([^TableModel this ^javax.swing.event.TableModelListener l]
    (-> this (.addTableModelListener l))))

(defn get-value-at
  "Returns the value for the cell at columnIndex and
   rowIndex.

  row-index - the row whose value is to be queried - `int`
  column-index - the column whose value is to be queried - `int`

  returns: the value Object at the specified cell - `java.lang.Object`"
  (^java.lang.Object [^TableModel this ^Integer row-index ^Integer column-index]
    (-> this (.getValueAt row-index column-index))))

(defn get-column-count
  "Returns the number of columns in the model. A
   JTable uses this method to determine how many columns it
   should create and display by default.

  returns: the number of columns in the model - `int`"
  (^Integer [^TableModel this]
    (-> this (.getColumnCount))))

(defn remove-table-model-listener
  "Removes a listener from the list that is notified each time a
   change to the data model occurs.

  l - the TableModelListener - `javax.swing.event.TableModelListener`"
  ([^TableModel this ^javax.swing.event.TableModelListener l]
    (-> this (.removeTableModelListener l))))

(defn get-row-count
  "Returns the number of rows in the model. A
   JTable uses this method to determine how many rows it
   should display.  This method should be quick, as it
   is called frequently during rendering.

  returns: the number of rows in the model - `int`"
  (^Integer [^TableModel this]
    (-> this (.getRowCount))))

(defn cell-editable?
  "Returns true if the cell at rowIndex and
   columnIndex
   is editable.  Otherwise, setValueAt on the cell will not
   change the value of that cell.

  row-index - the row whose value to be queried - `int`
  column-index - the column whose value to be queried - `int`

  returns: true if the cell is editable - `boolean`"
  (^Boolean [^TableModel this ^Integer row-index ^Integer column-index]
    (-> this (.isCellEditable row-index column-index))))

(defn get-column-name
  "Returns the name of the column at columnIndex.  This is used
   to initialize the table's column header name.  Note: this name does
   not need to be unique; two columns in a table can have the same name.

  column-index - the index of the column - `int`

  returns: the name of the column - `java.lang.String`"
  (^java.lang.String [^TableModel this ^Integer column-index]
    (-> this (.getColumnName column-index))))

(defn set-value-at
  "Sets the value in the cell at columnIndex and
   rowIndex to aValue.

  a-value - the new value - `java.lang.Object`
  row-index - the row whose value is to be changed - `int`
  column-index - the column whose value is to be changed - `int`"
  ([^TableModel this ^java.lang.Object a-value ^Integer row-index ^Integer column-index]
    (-> this (.setValueAt a-value row-index column-index))))

