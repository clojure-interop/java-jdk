(ns jdk.awt.ItemSelectable
  "The interface for objects which contain a set of items for
  which zero or more can be selected."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt ItemSelectable]))

(defn get-selected-objects
  "Returns the selected items or null if no
   items are selected.

  returns: `java.lang.Object[]`"
  ([^. this]
    (-> this (.getSelectedObjects))))

(defn add-item-listener
  "Adds a listener to receive item events when the state of an item is
   changed by the user. Item events are not sent when an item's
   state is set programmatically.  If l is
   null, no exception is thrown and no action is performed.

  l - the listener to receive events - `java.awt.event.ItemListener`"
  ([^. this ^java.awt.event.ItemListener l]
    (-> this (.addItemListener l))))

(defn remove-item-listener
  "Removes an item listener.
   If l is null,
   no exception is thrown and no action is performed.

  l - the listener being removed - `java.awt.event.ItemListener`"
  ([^. this ^java.awt.event.ItemListener l]
    (-> this (.removeItemListener l))))

