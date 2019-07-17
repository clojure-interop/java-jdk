(ns javax.swing.table.DefaultTableModel
  "This is an implementation of TableModel that
  uses a Vector of Vectors to store the
  cell value objects.

  Warning: DefaultTableModel returns a
  column class of Object.  When
  DefaultTableModel is used with a
  TableRowSorter this will result in extensive use of
  toString, which for non-String data types
  is expensive.  If you use DefaultTableModel with a
  TableRowSorter you are strongly encouraged to override
  getColumnClass to return the appropriate type.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.table DefaultTableModel]))

(defn ->default-table-model
  "Constructor.

  Constructs a DefaultTableModel with
    rowCount and columnCount of
    null object values.

  row-count - the number of rows the table holds - `int`
  column-count - the number of columns the table holds - `int`"
  ([row-count column-count]
    (new DefaultTableModel row-count column-count))
  ([]
    (new DefaultTableModel )))

(defn rows-removed
  "Equivalent to fireTableChanged.

  event - the change event - `javax.swing.event.TableModelEvent`"
  ([this event]
    (-> this (.rowsRemoved event))))

(defn set-column-identifiers
  "Replaces the column identifiers in the model.  If the number of
   newIdentifiers is greater than the current number
   of columns, new columns are added to the end of each row in the model.
   If the number of newIdentifiers is less than the current
   number of columns, all the extra columns at the end of a row are
   discarded.

  column-identifiers - vector of column identifiers. If null, set the model to zero columns - `java.util.Vector`"
  ([this column-identifiers]
    (-> this (.setColumnIdentifiers column-identifiers))))

(defn get-value-at
  "Returns an attribute value for the cell at row
   and column.

  row - the row whose value is to be queried - `int`
  column - the column whose value is to be queried - `int`

  returns: the value Object at the specified cell - `java.lang.Object`

  throws: java.lang.ArrayIndexOutOfBoundsException - if an invalid row or column was given"
  ([this row column]
    (-> this (.getValueAt row column))))

(defn remove-row
  "Removes the row at row from the model.  Notification
    of the row being removed will be sent to all the listeners.

  row - the row index of the row to be removed - `int`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the row was invalid"
  ([this row]
    (-> this (.removeRow row))))

(defn get-column-count
  "Returns the number of columns in this data table.

  returns: the number of columns in the model - `int`"
  ([this]
    (-> this (.getColumnCount))))

(defn get-row-count
  "Returns the number of rows in this data table.

  returns: the number of rows in the model - `int`"
  ([this]
    (-> this (.getRowCount))))

(defn set-row-count
  "Sets the number of rows in the model.  If the new size is greater
    than the current size, new rows are added to the end of the model
    If the new size is less than the current size, all
    rows at index rowCount and greater are discarded.

  row-count - `int`"
  ([this row-count]
    (-> this (.setRowCount row-count))))

(defn set-num-rows
  "Obsolete as of Java 2 platform v1.3.  Please use setRowCount instead.

  row-count - `int`"
  ([this row-count]
    (-> this (.setNumRows row-count))))

(defn new-rows-added
  "Ensures that the new rows have the correct number of columns.
    This is accomplished by  using the setSize method in
    Vector which truncates vectors
    which are too long, and appends nulls if they
    are too short.
    This method also sends out a tableChanged
    notification message to all the listeners.

  e - this TableModelEvent describes where the rows were added. If null it assumes all the rows were newly added - `javax.swing.event.TableModelEvent`"
  ([this e]
    (-> this (.newRowsAdded e))))

(defn cell-editable?
  "Returns true regardless of parameter values.

  row - the row whose value is to be queried - `int`
  column - the column whose value is to be queried - `int`

  returns: true - `boolean`"
  ([this row column]
    (-> this (.isCellEditable row column))))

(defn new-data-available
  "Equivalent to fireTableChanged.

  event - the change event - `javax.swing.event.TableModelEvent`"
  ([this event]
    (-> this (.newDataAvailable event))))

(defn get-data-vector
  "Returns the Vector of Vectors
    that contains the table's
    data values.  The vectors contained in the outer vector are
    each a single row of values.  In other words, to get to the cell
    at row 1, column 5:

    ((Vector)getDataVector().elementAt(1)).elementAt(5);

  returns: the vector of vectors containing the tables data values - `java.util.Vector`"
  ([this]
    (-> this (.getDataVector))))

(defn get-column-name
  "Returns the column name.

  column - the column being queried - `int`

  returns: a name for this column using the string value of the
   appropriate member in columnIdentifiers.
   If columnIdentifiers does not have an entry
   for this index, returns the default
   name provided by the superclass. - `java.lang.String`"
  ([this column]
    (-> this (.getColumnName column))))

(defn add-column
  "Adds a column to the model.  The new column will have the
    identifier columnName, which may be null.
    columnData is the
    optional vector of data for the column.  If it is null
    the column is filled with null values.  Otherwise,
    the new data will be added to model starting with the first
    element going to row 0, etc.  This method will send a
    tableChanged notification message to all the listeners.

  column-name - the identifier of the column being added - `java.lang.Object`
  column-data - optional data of the column being added - `java.util.Vector`"
  ([this column-name column-data]
    (-> this (.addColumn column-name column-data)))
  ([this column-name]
    (-> this (.addColumn column-name))))

(defn set-value-at
  "Sets the object value for the cell at column and
   row.  aValue is the new value.  This method
   will generate a tableChanged notification.

  a-value - the new value; this can be null - `java.lang.Object`
  row - the row whose value is to be changed - `int`
  column - the column whose value is to be changed - `int`

  throws: java.lang.ArrayIndexOutOfBoundsException - if an invalid row or column was given"
  ([this a-value row column]
    (-> this (.setValueAt a-value row column))))

(defn set-column-count
  "Sets the number of columns in the model.  If the new size is greater
    than the current size, new columns are added to the end of the model
    with null cell values.
    If the new size is less than the current size, all columns at index
    columnCount and greater are discarded.

  column-count - the new number of columns in the model - `int`"
  ([this column-count]
    (-> this (.setColumnCount column-count))))

(defn add-row
  "Adds a row to the end of the model.  The new row will contain
    null values unless rowData is specified.
    Notification of the row being added will be generated.

  row-data - optional data of the row being added - `java.util.Vector`"
  ([this row-data]
    (-> this (.addRow row-data))))

(defn move-row
  "Moves one or more rows from the inclusive range start to
    end to the to position in the model.
    After the move, the row that was at index start
    will be at index to.
    This method will send a tableChanged notification
         message to all the listeners.



    Examples of moves:

    1. moveRow(1,3,5);
            a|B|C|D|e|f|g|h|i|j|k   - before
            a|e|f|g|h|B|C|D|i|j|k   - after

    2. moveRow(6,7,1);
            a|b|c|d|e|f|G|H|i|j|k   - before
            a|G|H|b|c|d|e|f|i|j|k   - after

  start - the starting row index to be moved - `int`
  end - the ending row index to be moved - `int`
  to - the destination of the rows to be moved - `int`

  throws: java.lang.ArrayIndexOutOfBoundsException - if any of the elements would be moved out of the table's range"
  ([this start end to]
    (-> this (.moveRow start end to))))

(defn set-data-vector
  "Replaces the current dataVector instance variable
    with the new Vector of rows, dataVector.
    Each row is represented in dataVector as a
    Vector of Object values.
    columnIdentifiers are the names of the new
    columns.  The first name in columnIdentifiers is
    mapped to column 0 in dataVector. Each row in
    dataVector is adjusted to match the number of
    columns in columnIdentifiers
    either by truncating the Vector if it is too long,
    or adding null values if it is too short.
    Note that passing in a null value for
    dataVector results in unspecified behavior,
    an possibly an exception.

  data-vector - the new data vector - `java.util.Vector`
  column-identifiers - the names of the columns - `java.util.Vector`"
  ([this data-vector column-identifiers]
    (-> this (.setDataVector data-vector column-identifiers))))

(defn insert-row
  "Inserts a row at row in the model.  The new row
    will contain null values unless rowData
    is specified.  Notification of the row being added will be generated.

  row - the row index of the row to be inserted - `int`
  row-data - optional data of the row being added - `java.util.Vector`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the row was invalid"
  ([this row row-data]
    (-> this (.insertRow row row-data))))

