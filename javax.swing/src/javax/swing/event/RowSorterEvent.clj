(ns javax.swing.event.RowSorterEvent
  "RowSorterEvent provides notification of changes to
  a RowSorter.  Two types of notification are possible:

  Type.SORT_ORDER_CHANGED: indicates the sort order has
      changed.  This is typically followed by a notification of:
  Type.SORTED: indicates the contents of the model have
      been transformed in some way.  For example, the contents may have
      been sorted or filtered."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event RowSorterEvent]))

(defn ->row-sorter-event
  "Constructor.

  Creates a RowSorterEvent.

  source - the source of the change - `javax.swing.RowSorter`
  type - the type of event - `javax.swing.event.RowSorterEvent.Type`
  previous-row-index-to-model - the mapping from model indices to view indices prior to the sort, may be null - `int[]`

  throws: java.lang.IllegalArgumentException - if source or type is null"
  ([^javax.swing.RowSorter source ^javax.swing.event.RowSorterEvent.Type type previous-row-index-to-model]
    (new RowSorterEvent source type previous-row-index-to-model))
  ([^javax.swing.RowSorter source]
    (new RowSorterEvent source)))

(defn get-source
  "Returns the source of the event as a RowSorter.

  returns: the source of the event as a RowSorter - `javax.swing.RowSorter`"
  ([^javax.swing.event.RowSorterEvent this]
    (-> this (.getSource))))

(defn get-type
  "Returns the type of event.

  returns: the type of event - `javax.swing.event.RowSorterEvent.Type`"
  ([^javax.swing.event.RowSorterEvent this]
    (-> this (.getType))))

(defn convert-previous-row-index-to-model
  "Returns the location of index in terms of the
   model prior to the sort.  This method is only useful for events
   of type SORTED.  This method will return -1 if the
   index is not valid, or the locations prior to the sort have not
   been provided.

  index - the index in terms of the view - `int`

  returns: the index in terms of the model prior to the sort, or -1 if
           the location is not valid or the mapping was not provided. - `int`"
  ([^javax.swing.event.RowSorterEvent this ^Integer index]
    (-> this (.convertPreviousRowIndexToModel index))))

(defn get-previous-row-count
  "Returns the number of rows before the sort.  This method is only
   useful for events of type SORTED and if the
   last locations have not been provided will return 0.

  returns: the number of rows in terms of the view prior to the sort - `int`"
  ([^javax.swing.event.RowSorterEvent this]
    (-> this (.getPreviousRowCount))))

