(ns javax.swing.event.RowSorterListener
  "RowSorterListeners are notified of changes to a
  RowSorter."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event RowSorterListener]))

(defn sorter-changed
  "Notification that the RowSorter has changed.  The event
   describes the scope of the change.

  e - the event, will not be null - `javax.swing.event.RowSorterEvent`"
  ([^. this ^javax.swing.event.RowSorterEvent e]
    (-> this (.sorterChanged e))))

