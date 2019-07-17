(ns javax.swing.DefaultComboBoxModel
  "The default model for combo boxes."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing DefaultComboBoxModel]))

(defn ->default-combo-box-model
  "Constructor.

  Constructs a DefaultComboBoxModel object initialized with
   an array of objects.

  items - an array of Object objects - `DefaultComboBoxModel.E[]`"
  ([items]
    (new DefaultComboBoxModel items))
  ([]
    (new DefaultComboBoxModel )))

(defn set-selected-item
  "Set the value of the selected item. The selected item may be null.

  an-object - The combo box value or null for no selection. - `java.lang.Object`"
  ([this an-object]
    (-> this (.setSelectedItem an-object))))

(defn get-index-of
  "Returns the index-position of the specified object in the list.

  an-object - `java.lang.Object`

  returns: an int representing the index position, where 0 is
           the first position - `int`"
  ([this an-object]
    (-> this (.getIndexOf an-object))))

(defn add-element
  "Description copied from interface: MutableComboBoxModel

  an-object - the item to be added - `DefaultComboBoxModel.E`"
  ([this an-object]
    (-> this (.addElement an-object))))

(defn insert-element-at
  "Description copied from interface: MutableComboBoxModel

  an-object - the item to be added - `DefaultComboBoxModel.E`
  index - location to add the object - `int`"
  ([this an-object index]
    (-> this (.insertElementAt an-object index))))

(defn remove-all-elements
  "Empties the list."
  ([this]
    (-> this (.removeAllElements))))

(defn get-element-at
  "Description copied from interface: ListModel

  index - the requested index - `int`

  returns: the value at index - `DefaultComboBoxModel.E`"
  ([this index]
    (-> this (.getElementAt index))))

(defn remove-element
  "Description copied from interface: MutableComboBoxModel

  an-object - the Object to be removed - `java.lang.Object`"
  ([this an-object]
    (-> this (.removeElement an-object))))

(defn get-selected-item
  "Description copied from interface: ComboBoxModel

  returns: The selected item or null if there is no selection - `java.lang.Object`"
  ([this]
    (-> this (.getSelectedItem))))

(defn get-size
  "Description copied from interface: ListModel

  returns: the length of the list - `int`"
  ([this]
    (-> this (.getSize))))

(defn remove-element-at
  "Description copied from interface: MutableComboBoxModel

  index - location of the item to be removed - `int`"
  ([this index]
    (-> this (.removeElementAt index))))

