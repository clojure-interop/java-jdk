(ns javax.accessibility.AccessibleExtendedTable
  "Class AccessibleExtendedTable provides extended information about
  a user-interface component that presents data in a two-dimensional
  table format.
  Applications can determine if an object supports the
  AccessibleExtendedTable interface by first obtaining its
  AccessibleContext and then calling the
  AccessibleContext.getAccessibleTable() method.
  If the return value is not null and the type of the return value is
  AccessibleExtendedTable, the object supports this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleExtendedTable]))

(defn get-accessible-row
  "Returns the row number of an index in the table.

  index - the zero-based index in the table. The index is the table cell offset from row == 0 and column == 0. - `int`

  returns: the zero-based row of the table if one exists;
   otherwise -1. - `int`"
  (^Integer [^javax.accessibility.AccessibleExtendedTable this ^Integer index]
    (-> this (.getAccessibleRow index))))

(defn get-accessible-column
  "Returns the column number of an index in the table.

  index - the zero-based index in the table. The index is the table cell offset from row == 0 and column == 0. - `int`

  returns: the zero-based column of the table if one exists;
   otherwise -1. - `int`"
  (^Integer [^javax.accessibility.AccessibleExtendedTable this ^Integer index]
    (-> this (.getAccessibleColumn index))))

(defn get-accessible-index
  "Returns the index at a row and column in the table.

  r - zero-based row of the table - `int`
  c - zero-based column of the table - `int`

  returns: the zero-based index in the table if one exists;
   otherwise -1.  The index is  the table cell offset from
   row == 0 and column == 0. - `int`"
  (^Integer [^javax.accessibility.AccessibleExtendedTable this ^Integer r ^Integer c]
    (-> this (.getAccessibleIndex r c))))

