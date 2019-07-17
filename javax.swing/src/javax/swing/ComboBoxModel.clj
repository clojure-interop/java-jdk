(ns javax.swing.ComboBoxModel
  "A data model for a combo box. This interface extends ListDataModel
  and adds the concept of a selected item. The selected item is generally
  the item which is visible in the combo box display area.

  The selected item may not necessarily be managed by the underlying
  ListModel. This disjoint behavior allows for the temporary
  storage and retrieval of a selected item in the model."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing ComboBoxModel]))

(defn set-selected-item
  "Set the selected item. The implementation of this  method should notify
   all registered ListDataListeners that the contents
   have changed.

  an-item - the list object to select or null to clear the selection - `java.lang.Object`"
  ([^. this ^java.lang.Object an-item]
    (-> this (.setSelectedItem an-item))))

(defn get-selected-item
  "Returns the selected item

  returns: The selected item or null if there is no selection - `java.lang.Object`"
  ([^. this]
    (-> this (.getSelectedItem))))

