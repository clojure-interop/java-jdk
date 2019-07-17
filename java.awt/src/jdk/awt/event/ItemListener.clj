(ns jdk.awt.event.ItemListener
  "The listener interface for receiving item events.
  The class that is interested in processing an item event
  implements this interface. The object created with that
  class is then registered with a component using the
  component's addItemListener method. When an
  item-selection event occurs, the listener object's
  itemStateChanged method is invoked."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event ItemListener]))

(defn item-state-changed
  "Invoked when an item has been selected or deselected by the user.
   The code written for this method performs the operations
   that need to occur when an item is selected (or deselected).

  e - `java.awt.event.ItemEvent`"
  ([^java.awt.event.ItemListener this ^java.awt.event.ItemEvent e]
    (-> this (.itemStateChanged e))))

