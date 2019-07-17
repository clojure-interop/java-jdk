(ns javax.swing.event.ListDataListener
  "ListDataListener"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event ListDataListener]))

(defn interval-added
  "Sent after the indices in the index0,index1
   interval have been inserted in the data model.
   The new interval includes both index0 and index1.

  e - a ListDataEvent encapsulating the event information - `javax.swing.event.ListDataEvent`"
  ([^javax.swing.event.ListDataListener this ^javax.swing.event.ListDataEvent e]
    (-> this (.intervalAdded e))))

(defn interval-removed
  "Sent after the indices in the index0,index1 interval
   have been removed from the data model.  The interval
   includes both index0 and index1.

  e - a ListDataEvent encapsulating the event information - `javax.swing.event.ListDataEvent`"
  ([^javax.swing.event.ListDataListener this ^javax.swing.event.ListDataEvent e]
    (-> this (.intervalRemoved e))))

(defn contents-changed
  "Sent when the contents of the list has changed in a way
   that's too complex to characterize with the previous
   methods. For example, this is sent when an item has been
   replaced. Index0 and index1 bracket the change.

  e - a ListDataEvent encapsulating the event information - `javax.swing.event.ListDataEvent`"
  ([^javax.swing.event.ListDataListener this ^javax.swing.event.ListDataEvent e]
    (-> this (.contentsChanged e))))

