(ns javax.swing.JList$DropLocation
  "A subclass of TransferHandler.DropLocation representing
  a drop location for a JList."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JList$DropLocation]))

(defn get-index
  "Returns the index where dropped data should be placed in the
   list. Interpretation of the value depends on the drop mode set on
   the associated component. If the drop mode is either
   DropMode.USE_SELECTION or DropMode.ON,
   the return value is an index of a row in the list. If the drop mode is
   DropMode.INSERT, the return value refers to the index
   where the data should be inserted. If the drop mode is
   DropMode.ON_OR_INSERT, the value of
   isInsert() indicates whether the index is an index
   of a row, or an insert index.

   -1 indicates that the drop occurred over empty space,
   and no index could be calculated.

  returns: the drop index - `int`"
  ([^javax.swing.JList$DropLocation this]
    (-> this (.getIndex))))

(defn insert?
  "Returns whether or not this location represents an insert
   location.

  returns: whether or not this is an insert location - `boolean`"
  ([^javax.swing.JList$DropLocation this]
    (-> this (.isInsert))))

(defn to-string
  "Returns a string representation of this drop location.
   This method is intended to be used for debugging purposes,
   and the content and format of the returned string may vary
   between implementations.

  returns: a string representation of this drop location - `java.lang.String`"
  ([^javax.swing.JList$DropLocation this]
    (-> this (.toString))))

