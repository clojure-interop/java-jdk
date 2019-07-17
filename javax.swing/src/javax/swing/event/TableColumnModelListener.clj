(ns javax.swing.event.TableColumnModelListener
  "TableColumnModelListener defines the interface for an object that listens
  to changes in a TableColumnModel."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event TableColumnModelListener]))

(defn column-added
  "Tells listeners that a column was added to the model.

  e - `javax.swing.event.TableColumnModelEvent`"
  ([^. this ^javax.swing.event.TableColumnModelEvent e]
    (-> this (.columnAdded e))))

(defn column-removed
  "Tells listeners that a column was removed from the model.

  e - `javax.swing.event.TableColumnModelEvent`"
  ([^. this ^javax.swing.event.TableColumnModelEvent e]
    (-> this (.columnRemoved e))))

(defn column-moved
  "Tells listeners that a column was repositioned.

  e - `javax.swing.event.TableColumnModelEvent`"
  ([^. this ^javax.swing.event.TableColumnModelEvent e]
    (-> this (.columnMoved e))))

(defn column-margin-changed
  "Tells listeners that a column was moved due to a margin change.

  e - `javax.swing.event.ChangeEvent`"
  ([^. this ^javax.swing.event.ChangeEvent e]
    (-> this (.columnMarginChanged e))))

(defn column-selection-changed
  "Tells listeners that the selection model of the
   TableColumnModel changed.

  e - `javax.swing.event.ListSelectionEvent`"
  ([^. this ^javax.swing.event.ListSelectionEvent e]
    (-> this (.columnSelectionChanged e))))

