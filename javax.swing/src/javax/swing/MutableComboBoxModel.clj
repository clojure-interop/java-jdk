(ns javax.swing.MutableComboBoxModel
  "A mutable version of ComboBoxModel."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing MutableComboBoxModel]))

(defn add-element
  "Adds an item at the end of the model. The implementation of this method
   should notify all registered ListDataListeners that the
   item has been added.

  item - the item to be added - `MutableComboBoxModel.E`"
  ([^javax.swing.MutableComboBoxModel this ^MutableComboBoxModel.E item]
    (-> this (.addElement item))))

(defn remove-element
  "Removes an item from the model. The implementation of this method should
   should notify all registered ListDataListeners that the
   item has been removed.

  obj - the Object to be removed - `java.lang.Object`"
  ([^javax.swing.MutableComboBoxModel this ^java.lang.Object obj]
    (-> this (.removeElement obj))))

(defn insert-element-at
  "Adds an item at a specific index.  The implementation of this method
   should notify all registered ListDataListeners that the
   item has been added.

  item - the item to be added - `MutableComboBoxModel.E`
  index - location to add the object - `int`"
  ([^javax.swing.MutableComboBoxModel this ^MutableComboBoxModel.E item ^Integer index]
    (-> this (.insertElementAt item index))))

(defn remove-element-at
  "Removes an item at a specific index. The implementation of this method
   should notify all registered ListDataListeners that the
   item has been removed.

  index - location of the item to be removed - `int`"
  ([^javax.swing.MutableComboBoxModel this ^Integer index]
    (-> this (.removeElementAt index))))

