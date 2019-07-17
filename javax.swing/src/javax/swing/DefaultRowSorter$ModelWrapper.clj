(ns javax.swing.DefaultRowSorter$ModelWrapper
  "DefaultRowSorter.ModelWrapper is responsible for providing
  the data that gets sorted by DefaultRowSorter.  You
  normally do not interact directly with ModelWrapper.
  Subclasses of DefaultRowSorter provide an
  implementation of ModelWrapper wrapping another model.
  For example,
  TableRowSorter provides a ModelWrapper that
  wraps a TableModel.

  ModelWrapper makes a distinction between values as
  Objects and Strings.  This allows
  implementations to provide a custom string
  converter to be used instead of invoking toString on the
  object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing DefaultRowSorter$ModelWrapper]))

(defn get-model
  "Returns the underlying model that this Model is
   wrapping.

  returns: the underlying model - `DefaultRowSorter.ModelWrapper.M`"
  ([^javax.swing.DefaultRowSorter$ModelWrapper this]
    (-> this (.getModel))))

(defn get-column-count
  "Returns the number of columns in the model.

  returns: the number of columns in the model - `int`"
  ([^javax.swing.DefaultRowSorter$ModelWrapper this]
    (-> this (.getColumnCount))))

(defn get-row-count
  "Returns the number of rows in the model.

  returns: the number of rows in the model - `int`"
  ([^javax.swing.DefaultRowSorter$ModelWrapper this]
    (-> this (.getRowCount))))

(defn get-value-at
  "Returns the value at the specified index.

  row - the row index - `int`
  column - the column index - `int`

  returns: the value at the specified index - `java.lang.Object`

  throws: java.lang.IndexOutOfBoundsException - if the indices are outside the range of the model"
  ([^javax.swing.DefaultRowSorter$ModelWrapper this ^Integer row ^Integer column]
    (-> this (.getValueAt row column))))

(defn get-string-value-at
  "Returns the value as a String at the specified
   index.  This implementation uses toString on
   the result from getValueAt (making sure
   to return an empty string for null values).  Subclasses that
   override this method should never return null.

  row - the row index - `int`
  column - the column index - `int`

  returns: the value at the specified index as a String - `java.lang.String`

  throws: java.lang.IndexOutOfBoundsException - if the indices are outside the range of the model"
  ([^javax.swing.DefaultRowSorter$ModelWrapper this ^Integer row ^Integer column]
    (-> this (.getStringValueAt row column))))

(defn get-identifier
  "Returns the identifier for the specified row.  The return value
   of this is used as the identifier for the
   RowFilter.Entry that is passed to the
   RowFilter.

  row - the row to return the identifier for, in terms of the underlying model - `int`

  returns: the identifier - `DefaultRowSorter.ModelWrapper.I`"
  ([^javax.swing.DefaultRowSorter$ModelWrapper this ^Integer row]
    (-> this (.getIdentifier row))))

