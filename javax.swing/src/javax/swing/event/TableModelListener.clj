(ns javax.swing.event.TableModelListener
  "TableModelListener defines the interface for an object that listens
  to changes in a TableModel."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event TableModelListener]))

(defn table-changed
  "This fine grain notification tells listeners the exact range
   of cells, rows, or columns that changed.

  e - `javax.swing.event.TableModelEvent`"
  ([^TableModelListener this ^javax.swing.event.TableModelEvent e]
    (-> this (.tableChanged e))))

