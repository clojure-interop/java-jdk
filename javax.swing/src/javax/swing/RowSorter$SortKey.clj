(ns javax.swing.RowSorter$SortKey
  "SortKey describes the sort order for a particular column.  The
  column index is in terms of the underlying model, which may differ
  from that of the view."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing RowSorter$SortKey]))

(defn ->sort-key
  "Constructor.

  Creates a SortKey for the specified column with
   the specified sort order.

  column - index of the column, in terms of the model - `int`
  sort-order - the sorter order - `javax.swing.SortOrder`

  throws: java.lang.IllegalArgumentException - if sortOrder is null"
  (^RowSorter$SortKey [^Integer column ^javax.swing.SortOrder sort-order]
    (new RowSorter$SortKey column sort-order)))

(defn get-column
  "Returns the index of the column.

  returns: index of column - `int`"
  (^Integer [^RowSorter$SortKey this]
    (-> this (.getColumn))))

(defn get-sort-order
  "Returns the sort order of the column.

  returns: the sort order of the column - `javax.swing.SortOrder`"
  (^javax.swing.SortOrder [^RowSorter$SortKey this]
    (-> this (.getSortOrder))))

(defn hash-code
  "Returns the hash code for this SortKey.

  returns: hash code - `int`"
  (^Integer [^RowSorter$SortKey this]
    (-> this (.hashCode))))

(defn equals
  "Returns true if this object equals the specified object.
   If the specified object is a SortKey and
   references the same column and sort order, the two objects
   are equal.

  o - the object to compare to - `java.lang.Object`

  returns: true if o is equal to this SortKey - `boolean`"
  (^Boolean [^RowSorter$SortKey this ^java.lang.Object o]
    (-> this (.equals o))))

