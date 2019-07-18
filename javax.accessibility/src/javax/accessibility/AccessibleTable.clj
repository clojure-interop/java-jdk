(ns javax.accessibility.AccessibleTable
  "Class AccessibleTable describes a user-interface component that
  presents data in a two-dimensional table format."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleTable]))

(defn get-accessible-row-extent-at
  "Returns the number of rows occupied by the Accessible at
   a specified row and column in the table.

  r - zero-based row of the table - `int`
  c - zero-based column of the table - `int`

  returns: the number of rows occupied by the Accessible at a
   given specified (row, column) - `int`"
  (^Integer [^AccessibleTable this ^Integer r ^Integer c]
    (-> this (.getAccessibleRowExtentAt r c))))

(defn get-accessible-caption
  "Returns the caption for the table.

  returns: the caption for the table - `javax.accessibility.Accessible`"
  (^javax.accessibility.Accessible [^AccessibleTable this]
    (-> this (.getAccessibleCaption))))

(defn get-accessible-row-header
  "Returns the row headers as an AccessibleTable.

  returns: an AccessibleTable representing the row
   headers - `javax.accessibility.AccessibleTable`"
  (^javax.accessibility.AccessibleTable [^AccessibleTable this]
    (-> this (.getAccessibleRowHeader))))

(defn get-accessible-row-count
  "Returns the number of rows in the table.

  returns: the number of rows in the table - `int`"
  (^Integer [^AccessibleTable this]
    (-> this (.getAccessibleRowCount))))

(defn set-accessible-summary
  "Sets the summary description of the table

  a - the summary description of the table - `javax.accessibility.Accessible`"
  ([^AccessibleTable this ^javax.accessibility.Accessible a]
    (-> this (.setAccessibleSummary a))))

(defn get-accessible-column-header
  "Returns the column headers as an AccessibleTable.

  returns: an AccessibleTable representing the column
   headers - `javax.accessibility.AccessibleTable`"
  (^javax.accessibility.AccessibleTable [^AccessibleTable this]
    (-> this (.getAccessibleColumnHeader))))

(defn set-accessible-row-header
  "Sets the row headers.

  table - an AccessibleTable representing the row headers - `javax.accessibility.AccessibleTable`"
  ([^AccessibleTable this ^javax.accessibility.AccessibleTable table]
    (-> this (.setAccessibleRowHeader table))))

(defn get-accessible-column-extent-at
  "Returns the number of columns occupied by the Accessible at
   a specified row and column in the table.

  r - zero-based row of the table - `int`
  c - zero-based column of the table - `int`

  returns: the number of columns occupied by the Accessible at a
   given specified row and column - `int`"
  (^Integer [^AccessibleTable this ^Integer r ^Integer c]
    (-> this (.getAccessibleColumnExtentAt r c))))

(defn accessible-selected?
  "Returns a boolean value indicating whether the accessible at
   a specified row and column is selected.

  r - zero-based row of the table - `int`
  c - zero-based column of the table - `int`

  returns: the boolean value true if the accessible at the
   row and column is selected. Otherwise, the boolean value
   false - `boolean`"
  (^Boolean [^AccessibleTable this ^Integer r ^Integer c]
    (-> this (.isAccessibleSelected r c))))

(defn get-selected-accessible-columns
  "Returns the selected columns in a table.

  returns: an array of selected columns where each element is a
   zero-based column of the table - `int[]`"
  ([^AccessibleTable this]
    (-> this (.getSelectedAccessibleColumns))))

(defn set-accessible-column-description
  "Sets the description text of the specified column in the table.

  c - zero-based column of the table - `int`
  a - the text description of the column - `javax.accessibility.Accessible`"
  ([^AccessibleTable this ^Integer c ^javax.accessibility.Accessible a]
    (-> this (.setAccessibleColumnDescription c a))))

(defn set-accessible-row-description
  "Sets the description text of the specified row of the table.

  r - zero-based row of the table - `int`
  a - the description of the row - `javax.accessibility.Accessible`"
  ([^AccessibleTable this ^Integer r ^javax.accessibility.Accessible a]
    (-> this (.setAccessibleRowDescription r a))))

(defn get-accessible-column-description
  "Returns the description text of the specified column in the table.

  c - zero-based column of the table - `int`

  returns: the text description of the column - `javax.accessibility.Accessible`"
  (^javax.accessibility.Accessible [^AccessibleTable this ^Integer c]
    (-> this (.getAccessibleColumnDescription c))))

(defn get-accessible-summary
  "Returns the summary description of the table.

  returns: the summary description of the table - `javax.accessibility.Accessible`"
  (^javax.accessibility.Accessible [^AccessibleTable this]
    (-> this (.getAccessibleSummary))))

(defn accessible-row-selected?
  "Returns a boolean value indicating whether the specified row
   is selected.

  r - zero-based row of the table - `int`

  returns: the boolean value true if the specified row is selected.
   Otherwise, false. - `boolean`"
  (^Boolean [^AccessibleTable this ^Integer r]
    (-> this (.isAccessibleRowSelected r))))

(defn accessible-column-selected?
  "Returns a boolean value indicating whether the specified column
   is selected.

  c - zero-based column of the table - `int`

  returns: the boolean value true if the specified column is selected.
   Otherwise, false. - `boolean`"
  (^Boolean [^AccessibleTable this ^Integer c]
    (-> this (.isAccessibleColumnSelected c))))

(defn get-accessible-row-description
  "Returns the description of the specified row in the table.

  r - zero-based row of the table - `int`

  returns: the description of the row - `javax.accessibility.Accessible`"
  (^javax.accessibility.Accessible [^AccessibleTable this ^Integer r]
    (-> this (.getAccessibleRowDescription r))))

(defn get-selected-accessible-rows
  "Returns the selected rows in a table.

  returns: an array of selected rows where each element is a
   zero-based row of the table - `int[]`"
  ([^AccessibleTable this]
    (-> this (.getSelectedAccessibleRows))))

(defn get-accessible-column-count
  "Returns the number of columns in the table.

  returns: the number of columns in the table - `int`"
  (^Integer [^AccessibleTable this]
    (-> this (.getAccessibleColumnCount))))

(defn get-accessible-at
  "Returns the Accessible at a specified row and column
   in the table.

  r - zero-based row of the table - `int`
  c - zero-based column of the table - `int`

  returns: the Accessible at the specified row and column - `javax.accessibility.Accessible`"
  (^javax.accessibility.Accessible [^AccessibleTable this ^Integer r ^Integer c]
    (-> this (.getAccessibleAt r c))))

(defn set-accessible-column-header
  "Sets the column headers.

  table - an AccessibleTable representing the column headers - `javax.accessibility.AccessibleTable`"
  ([^AccessibleTable this ^javax.accessibility.AccessibleTable table]
    (-> this (.setAccessibleColumnHeader table))))

(defn set-accessible-caption
  "Sets the caption for the table.

  a - the caption for the table - `javax.accessibility.Accessible`"
  ([^AccessibleTable this ^javax.accessibility.Accessible a]
    (-> this (.setAccessibleCaption a))))

