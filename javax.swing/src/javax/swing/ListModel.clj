(ns javax.swing.ListModel
  "This interface defines the methods components like JList use
  to get the value of each cell in a list and the length of the list.
  Logically the model is a vector, indices vary from 0 to
  ListDataModel.getSize() - 1.  Any change to the contents or
  length of the data model must be reported to all of the
  ListDataListeners."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing ListModel]))

(defn get-size
  "Returns the length of the list.

  returns: the length of the list - `int`"
  (^Integer [^javax.swing.ListModel this]
    (-> this (.getSize))))

(defn get-element-at
  "Returns the value at the specified index.

  index - the requested index - `int`

  returns: the value at index - `ListModel.E`"
  (^ListModel.E [^javax.swing.ListModel this ^Integer index]
    (-> this (.getElementAt index))))

(defn add-list-data-listener
  "Adds a listener to the list that's notified each time a change
   to the data model occurs.

  l - the ListDataListener to be added - `javax.swing.event.ListDataListener`"
  ([^javax.swing.ListModel this ^javax.swing.event.ListDataListener l]
    (-> this (.addListDataListener l))))

(defn remove-list-data-listener
  "Removes a listener from the list that's notified each time a
   change to the data model occurs.

  l - the ListDataListener to be removed - `javax.swing.event.ListDataListener`"
  ([^javax.swing.ListModel this ^javax.swing.event.ListDataListener l]
    (-> this (.removeListDataListener l))))

