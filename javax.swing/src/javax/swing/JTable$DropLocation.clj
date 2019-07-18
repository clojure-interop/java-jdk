(ns javax.swing.JTable$DropLocation
  "A subclass of TransferHandler.DropLocation representing
  a drop location for a JTable."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JTable$DropLocation]))

(defn get-row
  "Returns the row index where a dropped item should be placed in the
   table. Interpretation of the value depends on the return of
   isInsertRow(). If that method returns
   true this value indicates the index where a new
   row should be inserted. Otherwise, it represents the value
   of an existing row on which the data was dropped. This index is
   in terms of the view.

   -1 indicates that the drop occurred over empty space,
   and no row could be calculated.

  returns: the drop row - `int`"
  (^Integer [^JTable$DropLocation this]
    (-> this (.getRow))))

(defn get-column
  "Returns the column index where a dropped item should be placed in the
   table. Interpretation of the value depends on the return of
   isInsertColumn(). If that method returns
   true this value indicates the index where a new
   column should be inserted. Otherwise, it represents the value
   of an existing column on which the data was dropped. This index is
   in terms of the view.

   -1 indicates that the drop occurred over empty space,
   and no column could be calculated.

  returns: the drop row - `int`"
  (^Integer [^JTable$DropLocation this]
    (-> this (.getColumn))))

(defn insert-row?
  "Returns whether or not this location represents an insert
   of a row.

  returns: whether or not this is an insert row - `boolean`"
  (^Boolean [^JTable$DropLocation this]
    (-> this (.isInsertRow))))

(defn insert-column?
  "Returns whether or not this location represents an insert
   of a column.

  returns: whether or not this is an insert column - `boolean`"
  (^Boolean [^JTable$DropLocation this]
    (-> this (.isInsertColumn))))

(defn to-string
  "Returns a string representation of this drop location.
   This method is intended to be used for debugging purposes,
   and the content and format of the returned string may vary
   between implementations.

  returns: a string representation of this drop location - `java.lang.String`"
  (^java.lang.String [^JTable$DropLocation this]
    (-> this (.toString))))

