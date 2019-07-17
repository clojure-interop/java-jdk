(ns javax.swing.RowSorter
  "RowSorter provides the basis for sorting and filtering.
  Beyond creating and installing a RowSorter, you very rarely
  need to interact with one directly.  Refer to
  TableRowSorter for a concrete
  implementation of RowSorter for JTable.

  RowSorter's primary role is to provide a mapping between
  two coordinate systems: that of the view (for example a
  JTable) and that of the underlying data source, typically a
  model.

  The view invokes the following methods on the RowSorter:

  toggleSortOrder  The view invokes this when the
      appropriate user gesture has occurred to trigger a sort.  For example,
      the user clicked a column header in a table.
  One of the model change methods  The view invokes a model
      change method when the underlying model
      has changed.  There may be order dependencies in how the events are
      delivered, so a RowSorter should not update its mapping
      until one of these methods is invoked.

  Because the view makes extensive use of  the
  convertRowIndexToModel,
  convertRowIndexToView and getViewRowCount methods,
  these methods need to be fast.

  RowSorter provides notification of changes by way of
  RowSorterListener.  Two types of notification are sent:

  RowSorterEvent.Type.SORT_ORDER_CHANGED  notifies
      listeners that the sort order has changed.  This is typically followed
      by a notification that the sort has changed.
  RowSorterEvent.Type.SORTED  notifies listeners that
      the mapping maintained by the RowSorter has changed in
      some way.

  RowSorter implementations typically don't have a one-to-one
  mapping with the underlying model, but they can.
  For example, if a database does the sorting,
  toggleSortOrder might call through to the database
  (on a background thread), and override the mapping methods to return the
  argument that is passed in.

  Concrete implementations of RowSorter
  need to reference a model such as TableModel or
  ListModel.  The view classes, such as
  JTable and JList, will also have a
  reference to the model.  To avoid ordering dependencies,
  RowSorter implementations should not install a
  listener on the model.  Instead the view class will call into the
  RowSorter when the model changes.  For
  example, if a row is updated in a TableModel
  JTable invokes rowsUpdated.
  When the model changes, the view may call into any of the following methods:
  modelStructureChanged, allRowsChanged,
  rowsInserted, rowsDeleted and
  rowsUpdated."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing RowSorter]))

(defn ->row-sorter
  "Constructor.

  Creates a RowSorter."
  ([]
    (new RowSorter )))

(defn set-sort-keys
  "Sets the current sort keys.

  keys - the new SortKeys; null is a shorthand for specifying an empty list, indicating that the view should be unsorted - `javax.swing.RowSorter.SortKey>`"
  ([this keys]
    (-> this (.setSortKeys keys))))

(defn all-rows-changed
  "Invoked when the contents of the underlying model have
   completely changed. The structure of the table is the same,
   only the contents have changed. This is typically sent when it
   is too expensive to characterize the change in terms of the
   other methods.

   You normally do not call this method.  This method is public
   to allow view classes to call it."
  ([this]
    (-> this (.allRowsChanged))))

(defn toggle-sort-order
  "Reverses the sort order of the specified column.  It is up to
   subclasses to provide the exact behavior when invoked.  Typically
   this will reverse the sort order from ascending to descending (or
   descending to ascending) if the specified column is already the
   primary sorted column; otherwise, makes the specified column
   the primary sorted column, with an ascending sort order.  If
   the specified column is not sortable, this method has no
   effect.

   If this results in changing the sort order and sorting, the
   appropriate RowSorterListener notification will be
   sent.

  column - the column to toggle the sort ordering of, in terms of the underlying model - `int`

  throws: java.lang.IndexOutOfBoundsException - if column is outside the range of the underlying model"
  ([this column]
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
  ([this first-row end-row]
    (-> this (.rowsInserted first-row end-row))))

(defn model-structure-changed
  "Invoked when the underlying model structure has completely
   changed.  For example, if the number of columns in a
   TableModel changed, this method would be invoked.

   You normally do not call this method.  This method is public
   to allow view classes to call it."
  ([this]
    (-> this (.modelStructureChanged))))

(defn rows-updated
  "Invoked when the column in the rows have been updated in
   the underlying model between the specified range.

   You normally do not call this method.  This method is public
   to allow view classes to call it.

  first-row - the first row, in terms of the underlying model - `int`
  end-row - the last row, in terms of the underlying model - `int`
  column - the column that has changed, in terms of the underlying model - `int`

  throws: java.lang.IndexOutOfBoundsException - if either argument is outside the range of the underlying model after the change, firstRow > endRow, or column is outside the range of the underlying model"
  ([this first-row end-row column]
    (-> this (.rowsUpdated first-row end-row column)))
  ([this first-row end-row]
    (-> this (.rowsUpdated first-row end-row))))

(defn convert-row-index-to-model
  "Returns the location of index in terms of the
   underlying model.  That is, for the row index in
   the coordinates of the view this returns the row index in terms
   of the underlying model.

  index - the row index in terms of the underlying view - `int`

  returns: row index in terms of the view - `int`

  throws: java.lang.IndexOutOfBoundsException - if index is outside the range of the view"
  ([this index]
    (-> this (.convertRowIndexToModel index))))

(defn get-sort-keys
  "Returns the current sort keys.  This must return a non-null List and may return an unmodifiable List. If
   you need to change the sort keys, make a copy of the returned
   List, mutate the copy and invoke setSortKeys
   with the new list.

  returns: the current sort order - `java.util.List<? extends javax.swing.RowSorter.SortKey>`"
  ([this]
    (-> this (.getSortKeys))))

(defn get-view-row-count
  "Returns the number of rows in the view.  If the contents have
   been filtered this might differ from the row count of the
   underlying model.

  returns: number of rows in the view - `int`"
  ([this]
    (-> this (.getViewRowCount))))

(defn add-row-sorter-listener
  "Adds a RowSorterListener to receive notification
   about this RowSorter.  If the same
   listener is added more than once it will receive multiple
   notifications.  If l is null nothing
   is done.

  l - the RowSorterListener - `javax.swing.event.RowSorterListener`"
  ([this l]
    (-> this (.addRowSorterListener l))))

(defn remove-row-sorter-listener
  "Removes a RowSorterListener.  If
   l is null nothing is done.

  l - the RowSorterListener - `javax.swing.event.RowSorterListener`"
  ([this l]
    (-> this (.removeRowSorterListener l))))

(defn convert-row-index-to-view
  "Returns the location of index in terms of the
   view.  That is, for the row index in the
   coordinates of the underlying model this returns the row index
   in terms of the view.

  index - the row index in terms of the underlying model - `int`

  returns: row index in terms of the view, or -1 if index has been
           filtered out of the view - `int`

  throws: java.lang.IndexOutOfBoundsException - if index is outside the range of the model"
  ([this index]
    (-> this (.convertRowIndexToView index))))

(defn get-model
  "Returns the underlying model.

  returns: the underlying model - `RowSorter.M`"
  ([this]
    (-> this (.getModel))))

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
  ([this first-row end-row]
    (-> this (.rowsDeleted first-row end-row))))

(defn get-model-row-count
  "Returns the number of rows in the underlying model.

  returns: number of rows in the underlying model - `int`"
  ([this]
    (-> this (.getModelRowCount))))

