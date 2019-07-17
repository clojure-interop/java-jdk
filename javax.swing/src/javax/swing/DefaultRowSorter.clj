(ns javax.swing.DefaultRowSorter
  "An implementation of RowSorter that provides sorting and
  filtering around a grid-based data model.
  Beyond creating and installing a RowSorter, you very rarely
  need to interact with one directly.  Refer to
  TableRowSorter for a concrete
  implementation of RowSorter for JTable.

  Sorting is done based on the current SortKeys, in order.
  If two objects are equal (the Comparator for the
  column returns 0) the next SortKey is used.  If no
  SortKeys remain or the order is UNSORTED, then
  the order of the rows in the model is used.

  Sorting of each column is done by way of a Comparator
  that you can specify using the setComparator method.
  If a Comparator has not been specified, the
  Comparator returned by
  Collator.getInstance() is used on the results of
  calling toString on the underlying objects.  The
  Comparator is never passed null.  A
  null value is treated as occurring before a
  non-null value, and two null values are
  considered equal.

  If you specify a Comparator that casts its argument to
  a type other than that provided by the model, a
  ClassCastException will be thrown when the data is sorted.

  In addition to sorting, DefaultRowSorter provides the
  ability to filter rows.  Filtering is done by way of a
  RowFilter that is specified using the
  setRowFilter method.  If no filter has been specified all
  rows are included.

  By default, rows are in unsorted order (the same as the model) and
  every column is sortable. The default Comparators are
  documented in the subclasses (for example, TableRowSorter).

  If the underlying model structure changes (the
  modelStructureChanged method is invoked) the following
  are reset to their default values: Comparators by
  column, current sort order, and whether each column is sortable. To
  find the default Comparators, see the concrete
  implementation (for example, TableRowSorter).  The default
  sort order is unsorted (the same as the model), and columns are
  sortable by default.

  If the underlying model structure changes (the
  modelStructureChanged method is invoked) the following
  are reset to their default values: Comparators by column,
  current sort order and whether a column is sortable.

  DefaultRowSorter is an abstract class.  Concrete
  subclasses must provide access to the underlying data by invoking
  setModelWrapper. The setModelWrapper method
  must be invoked soon after the constructor is
  called, ideally from within the subclass's constructor.
  Undefined behavior will result if you use a DefaultRowSorter without specifying a ModelWrapper.

  DefaultRowSorter has two formal type parameters.  The
  first type parameter corresponds to the class of the model, for example
  DefaultTableModel.  The second type parameter
  corresponds to the class of the identifier passed to the
  RowFilter.  Refer to TableRowSorter and
  RowFilter for more details on the type parameters."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing DefaultRowSorter]))

(defn ->default-row-sorter
  "Constructor.

  Creates an empty DefaultRowSorter."
  ([]
    (new DefaultRowSorter )))

(defn get-max-sort-keys
  "Returns the maximum number of sort keys.

  returns: the maximum number of sort keys - `int`"
  (^Integer [^javax.swing.DefaultRowSorter this]
    (-> this (.getMaxSortKeys))))

(defn set-sort-keys
  "Sets the sort keys. This creates a copy of the supplied
   List; subsequent changes to the supplied
   List do not effect this DefaultRowSorter.
   If the sort keys have changed this triggers a sort.

  sort-keys - the new SortKeys; null is a shorthand for specifying an empty list, indicating that the view should be unsorted - `javax.swing.RowSorter.SortKey>`

  throws: java.lang.IllegalArgumentException - if any of the values in sortKeys are null or have a column index outside the range of the model"
  ([^javax.swing.DefaultRowSorter this ^javax.swing.RowSorter.SortKey> sort-keys]
    (-> this (.setSortKeys sort-keys))))

(defn all-rows-changed
  "Invoked when the contents of the underlying model have
   completely changed. The structure of the table is the same,
   only the contents have changed. This is typically sent when it
   is too expensive to characterize the change in terms of the
   other methods.

   You normally do not call this method.  This method is public
   to allow view classes to call it."
  ([^javax.swing.DefaultRowSorter this]
    (-> this (.allRowsChanged))))

(defn toggle-sort-order
  "Reverses the sort order from ascending to descending (or
   descending to ascending) if the specified column is already the
   primary sorted column; otherwise, makes the specified column
   the primary sorted column, with an ascending sort order.  If
   the specified column is not sortable, this method has no
   effect.

  column - index of the column to make the primary sorted column, in terms of the underlying model - `int`

  throws: java.lang.IndexOutOfBoundsException - if column is outside the range of the underlying model"
  ([^javax.swing.DefaultRowSorter this ^Integer column]
    (-> this (.toggleSortOrder column))))

(defn rows-inserted
  "Invoked when rows have been inserted into the underlying model
   in the specified range (inclusive).

   The arguments give the indices of the effected range.
   The first argument is in terms of the model before the change, and
   must be less than or equal to the size of the model before the change.
   The second argument is in terms of the model after the change and must
   be less than the size of the model after the change. For example,
   if you have a 5-row model and add 3 items to the end of the model
   the indices are 5, 7.

   You normally do not call this method.  This method is public
   to allow view classes to call it.

  first-row - the first row - `int`
  end-row - the last row - `int`

  throws: java.lang.IndexOutOfBoundsException - if either argument is invalid, or firstRow > endRow"
  ([^javax.swing.DefaultRowSorter this ^Integer first-row ^Integer end-row]
    (-> this (.rowsInserted first-row end-row))))

(defn set-sorts-on-updates
  "If true, specifies that a sort should happen when the underlying
   model is updated (rowsUpdated is invoked).  For
   example, if this is true and the user edits an entry the
   location of that item in the view may change.  The default is
   false.

  sorts-on-updates - whether or not to sort on update events - `boolean`"
  ([^javax.swing.DefaultRowSorter this ^Boolean sorts-on-updates]
    (-> this (.setSortsOnUpdates sorts-on-updates))))

(defn model-structure-changed
  "Invoked when the underlying model structure has completely
   changed.  For example, if the number of columns in a
   TableModel changed, this method would be invoked.

   You normally do not call this method.  This method is public
   to allow view classes to call it."
  ([^javax.swing.DefaultRowSorter this]
    (-> this (.modelStructureChanged))))

(defn set-row-filter
  "Sets the filter that determines which rows, if any, should be
   hidden from the view.  The filter is applied before sorting.  A value
   of null indicates all values from the model should be
   included.

   RowFilter's include method is passed an
   Entry that wraps the underlying model.  The number
   of columns in the Entry corresponds to the
   number of columns in the ModelWrapper.  The identifier
   comes from the ModelWrapper as well.

   This method triggers a sort.

  filter - the filter used to determine what entries should be included - `DefaultRowSorter.I>`"
  ([^javax.swing.DefaultRowSorter this ^DefaultRowSorter.I> filter]
    (-> this (.setRowFilter filter))))

(defn sortable?
  "Returns true if the specified column is sortable; otherwise, false.

  column - the column to check sorting for, in terms of the underlying model - `int`

  returns: true if the column is sortable - `boolean`

  throws: java.lang.IndexOutOfBoundsException - if column is outside the range of the underlying model"
  (^Boolean [^javax.swing.DefaultRowSorter this ^Integer column]
    (-> this (.isSortable column))))

(defn set-max-sort-keys
  "Sets the maximum number of sort keys.  The number of sort keys
   determines how equal values are resolved when sorting.  For
   example, assume a table row sorter is created and
   setMaxSortKeys(2) is invoked on it. The user
   clicks the header for column 1, causing the table rows to be
   sorted based on the items in column 1.  Next, the user clicks
   the header for column 2, causing the table to be sorted based
   on the items in column 2; if any items in column 2 are equal,
   then those particular rows are ordered based on the items in
   column 1. In this case, we say that the rows are primarily
   sorted on column 2, and secondarily on column 1.  If the user
   then clicks the header for column 3, then the items are
   primarily sorted on column 3 and secondarily sorted on column
   2.  Because the maximum number of sort keys has been set to 2
   with setMaxSortKeys, column 1 no longer has an
   effect on the order.

   The maximum number of sort keys is enforced by
   toggleSortOrder.  You can specify more sort
   keys by invoking setSortKeys directly and they will
   all be honored.  However if toggleSortOrder is subsequently
   invoked the maximum number of sort keys will be enforced.
   The default value is 3.

  max - the maximum number of sort keys - `int`

  throws: java.lang.IllegalArgumentException - if max < 1"
  ([^javax.swing.DefaultRowSorter this ^Integer max]
    (-> this (.setMaxSortKeys max))))

(defn rows-updated
  "Invoked when the column in the rows have been updated in
   the underlying model between the specified range.

   You normally do not call this method.  This method is public
   to allow view classes to call it.

  first-row - the first row, in terms of the underlying model - `int`
  end-row - the last row, in terms of the underlying model - `int`
  column - the column that has changed, in terms of the underlying model - `int`

  throws: java.lang.IndexOutOfBoundsException - if either argument is outside the range of the underlying model after the change, firstRow > endRow, or column is outside the range of the underlying model"
  ([^javax.swing.DefaultRowSorter this ^Integer first-row ^Integer end-row ^Integer column]
    (-> this (.rowsUpdated first-row end-row column)))
  ([^javax.swing.DefaultRowSorter this ^Integer first-row ^Integer end-row]
    (-> this (.rowsUpdated first-row end-row))))

(defn set-comparator
  "Sets the Comparator to use when sorting the specified
   column.  This does not trigger a sort.  If you want to sort after
   setting the comparator you need to explicitly invoke sort.

  column - the index of the column the Comparator is to be used for, in terms of the underlying model - `int`
  comparator - the Comparator to use - `java.util.Comparator<?>`

  throws: java.lang.IndexOutOfBoundsException - if column is outside the range of the underlying model"
  ([^javax.swing.DefaultRowSorter this ^Integer column ^java.util.Comparator comparator]
    (-> this (.setComparator column comparator))))

(defn convert-row-index-to-model
  "Returns the location of index in terms of the
   underlying model.  That is, for the row index in
   the coordinates of the view this returns the row index in terms
   of the underlying model.

  index - the row index in terms of the underlying view - `int`

  returns: row index in terms of the view - `int`

  throws: java.lang.IndexOutOfBoundsException - if index is outside the range of the view"
  (^Integer [^javax.swing.DefaultRowSorter this ^Integer index]
    (-> this (.convertRowIndexToModel index))))

(defn get-sort-keys
  "Returns the current sort keys.  This returns an unmodifiable
   non-null List. If you need to change the sort keys,
   make a copy of the returned List, mutate the copy
   and invoke setSortKeys with the new list.

  returns: the current sort order - `java.util.List<? extends javax.swing.RowSorter.SortKey>`"
  ([^javax.swing.DefaultRowSorter this]
    (-> this (.getSortKeys))))

(defn sort
  "Sorts and filters the rows in the view based on the sort keys
   of the columns currently being sorted and the filter, if any,
   associated with this sorter.  An empty sortKeys list
   indicates that the view should unsorted, the same as the model."
  ([^javax.swing.DefaultRowSorter this]
    (-> this (.sort))))

(defn get-sorts-on-updates?
  "Returns true if  a sort should happen when the underlying
   model is updated; otherwise, returns false.

  returns: whether or not to sort when the model is updated - `boolean`"
  (^Boolean [^javax.swing.DefaultRowSorter this]
    (-> this (.getSortsOnUpdates))))

(defn get-view-row-count
  "Returns the number of rows in the view.  If the contents have
   been filtered this might differ from the row count of the
   underlying model.

  returns: number of rows in the view - `int`"
  (^Integer [^javax.swing.DefaultRowSorter this]
    (-> this (.getViewRowCount))))

(defn set-sortable
  "Sets whether or not the specified column is sortable.  The specified
   value is only checked when toggleSortOrder is invoked.
   It is still possible to sort on a column that has been marked as
   unsortable by directly setting the sort keys.  The default is
   true.

  column - the column to enable or disable sorting on, in terms of the underlying model - `int`
  sortable - whether or not the specified column is sortable - `boolean`

  throws: java.lang.IndexOutOfBoundsException - if column is outside the range of the model"
  ([^javax.swing.DefaultRowSorter this ^Integer column ^Boolean sortable]
    (-> this (.setSortable column sortable))))

(defn get-comparator
  "Returns the Comparator for the specified
   column.  This will return null if a Comparator
   has not been specified for the column.

  column - the column to fetch the Comparator for, in terms of the underlying model - `int`

  returns: the Comparator for the specified column - `java.util.Comparator<?>`

  throws: java.lang.IndexOutOfBoundsException - if column is outside the range of the underlying model"
  (^java.util.Comparator [^javax.swing.DefaultRowSorter this ^Integer column]
    (-> this (.getComparator column))))

(defn convert-row-index-to-view
  "Returns the location of index in terms of the
   view.  That is, for the row index in the
   coordinates of the underlying model this returns the row index
   in terms of the view.

  index - the row index in terms of the underlying model - `int`

  returns: row index in terms of the view, or -1 if index has been
           filtered out of the view - `int`

  throws: java.lang.IndexOutOfBoundsException - if index is outside the range of the model"
  (^Integer [^javax.swing.DefaultRowSorter this ^Integer index]
    (-> this (.convertRowIndexToView index))))

(defn get-model
  "Returns the underlying model.

  returns: the underlying model - `DefaultRowSorter.M`"
  (^DefaultRowSorter.M [^javax.swing.DefaultRowSorter this]
    (-> this (.getModel))))

(defn get-row-filter
  "Returns the filter that determines which rows, if any, should
   be hidden from view.

  returns: the filter - `javax.swing.RowFilter<? super DefaultRowSorter.M,? super DefaultRowSorter.I>`"
  ([^javax.swing.DefaultRowSorter this]
    (-> this (.getRowFilter))))

(defn rows-deleted
  "Invoked when rows have been deleted from the underlying model
   in the specified range (inclusive).

   The arguments give the indices of the effected range and
   are in terms of the model before the change.
   For example, if you have a 5-row model and delete 3 items from the end
   of the model the indices are 2, 4.

   You normally do not call this method.  This method is public
   to allow view classes to call it.

  first-row - the first row - `int`
  end-row - the last row - `int`

  throws: java.lang.IndexOutOfBoundsException - if either argument is outside the range of the model before the change, or firstRow > endRow"
  ([^javax.swing.DefaultRowSorter this ^Integer first-row ^Integer end-row]
    (-> this (.rowsDeleted first-row end-row))))

(defn get-model-row-count
  "Returns the number of rows in the underlying model.

  returns: number of rows in the underlying model - `int`"
  (^Integer [^javax.swing.DefaultRowSorter this]
    (-> this (.getModelRowCount))))

