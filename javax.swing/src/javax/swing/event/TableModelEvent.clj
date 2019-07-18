(ns javax.swing.event.TableModelEvent
  "TableModelEvent is used to notify listeners that a table model
  has changed. The model event describes changes to a TableModel
  and all references to rows and columns are in the co-ordinate
  system of the model.
  Depending on the parameters used in the constructors, the TableModelevent
  can be used to specify the following types of changes:



  TableModelEvent(source);              //  The data, ie. all rows changed
  TableModelEvent(source, HEADER_ROW);  //  Structure change, reallocate TableColumns
  TableModelEvent(source, 1);           //  Row 1 changed
  TableModelEvent(source, 3, 6);        //  Rows 3 to 6 inclusive changed
  TableModelEvent(source, 2, 2, 6);     //  Cell at (2, 6) changed
  TableModelEvent(source, 3, 6, ALL_COLUMNS, INSERT); // Rows (3, 6) were inserted
  TableModelEvent(source, 3, 6, ALL_COLUMNS, DELETE); // Rows (3, 6) were deleted

  It is possible to use other combinations of the parameters, not all of them
  are meaningful. By subclassing, you can add other information, for example:
  whether the event WILL happen or DID happen. This makes the specification
  of rows in DELETE events more useful but has not been included in
  the swing package as the JTable only needs post-event notification.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event TableModelEvent]))

(defn ->table-model-event
  "Constructor.

  The cells from (firstRow, column) to (lastRow, column) have been changed.
    The column refers to the column index of the cell in the model's
    co-ordinate system. When column is ALL_COLUMNS, all cells in the
    specified range of rows are considered changed.

    The type should be one of: INSERT, UPDATE and DELETE.

  source - `javax.swing.table.TableModel`
  first-row - `int`
  last-row - `int`
  column - `int`
  type - `int`"
  (^TableModelEvent [^javax.swing.table.TableModel source ^Integer first-row ^Integer last-row ^Integer column ^Integer type]
    (new TableModelEvent source first-row last-row column type))
  (^TableModelEvent [^javax.swing.table.TableModel source ^Integer first-row ^Integer last-row ^Integer column]
    (new TableModelEvent source first-row last-row column))
  (^TableModelEvent [^javax.swing.table.TableModel source ^Integer first-row ^Integer last-row]
    (new TableModelEvent source first-row last-row))
  (^TableModelEvent [^javax.swing.table.TableModel source ^Integer row]
    (new TableModelEvent source row))
  (^TableModelEvent [^javax.swing.table.TableModel source]
    (new TableModelEvent source)))

(def *-insert
  "Static Constant.

  Identifies the addition of new rows or columns.

  type: int"
  TableModelEvent/INSERT)

(def *-update
  "Static Constant.

  Identifies a change to existing data.

  type: int"
  TableModelEvent/UPDATE)

(def *-delete
  "Static Constant.

  Identifies the removal of rows or columns.

  type: int"
  TableModelEvent/DELETE)

(def *-header-row
  "Static Constant.

  Identifies the header row.

  type: int"
  TableModelEvent/HEADER_ROW)

(def *-all-columns
  "Static Constant.

  Specifies all columns in a row or rows.

  type: int"
  TableModelEvent/ALL_COLUMNS)

(defn get-first-row
  "Returns the first row that changed.  HEADER_ROW means the meta data,
   ie. names, types and order of the columns.

  returns: `int`"
  (^Integer [^TableModelEvent this]
    (-> this (.getFirstRow))))

(defn get-last-row
  "Returns the last row that changed.

  returns: `int`"
  (^Integer [^TableModelEvent this]
    (-> this (.getLastRow))))

(defn get-column
  "Returns the column for the event.  If the return
    value is ALL_COLUMNS; it means every column in the specified
    rows changed.

  returns: `int`"
  (^Integer [^TableModelEvent this]
    (-> this (.getColumn))))

(defn get-type
  "Returns the type of event - one of: INSERT, UPDATE and DELETE.

  returns: `int`"
  (^Integer [^TableModelEvent this]
    (-> this (.getType))))

