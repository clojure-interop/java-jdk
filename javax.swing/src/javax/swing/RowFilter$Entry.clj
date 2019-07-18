(ns javax.swing.RowFilter$Entry
  "An Entry object is passed to instances of
  RowFilter, allowing the filter to get the value of the
  entry's data, and thus to determine whether the entry should be shown.
  An Entry object contains information about the model
  as well as methods for getting the underlying values from the model."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing RowFilter$Entry]))

(defn ->entry
  "Constructor.

  Creates an Entry."
  (^RowFilter$Entry []
    (new RowFilter$Entry )))

(defn get-model
  "Returns the underlying model.

  returns: the model containing the data that this entry represents - `M`"
  ([^RowFilter$Entry this]
    (-> this (.getModel))))

(defn get-value-count
  "Returns the number of values in the entry.  For
   example, when used with a table this corresponds to the
   number of columns.

  returns: number of values in the object being filtered - `int`"
  (^Integer [^RowFilter$Entry this]
    (-> this (.getValueCount))))

(defn get-value
  "Returns the value at the specified index.  This may return
   null.  When used with a table, index
   corresponds to the column number in the model.

  index - the index of the value to get - `int`

  returns: value at the specified index - `java.lang.Object`

  throws: java.lang.IndexOutOfBoundsException - if index < 0 or >= getValueCount"
  (^java.lang.Object [^RowFilter$Entry this ^Integer index]
    (-> this (.getValue index))))

(defn get-string-value
  "Returns the string value at the specified index.  If
   filtering is being done based on String values
   this method is preferred to that of getValue
   as getValue(index).toString() may return a
   different result than getStringValue(index).

   This implementation calls getValue(index).toString()
   after checking for null.  Subclasses that provide
   different string conversion should override this method if
   necessary.

  index - the index of the value to get - `int`

  returns: non-null string at the specified index - `java.lang.String`

  throws: java.lang.IndexOutOfBoundsException - if index < 0 || >= getValueCount"
  (^java.lang.String [^RowFilter$Entry this ^Integer index]
    (-> this (.getStringValue index))))

(defn get-identifier
  "Returns the identifer (in the model) of the entry.
   For a table this corresponds to the index of the row in the model,
   expressed as an Integer.

  returns: a model-based (not view-based) identifier for
           this entry - `I`"
  ([^RowFilter$Entry this]
    (-> this (.getIdentifier))))

