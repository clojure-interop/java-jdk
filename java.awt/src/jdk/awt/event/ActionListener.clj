(ns jdk.awt.event.ActionListener
  "The listener interface for receiving action events.
  The class that is interested in processing an action event
  implements this interface, and the object created with that
  class is registered with a component, using the component's
  addActionListener method. When the action event
  occurs, that object's actionPerformed method is
  invoked."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event ActionListener]))

(defn action-performed
  "Invoked when an action occurs.

  e - `java.awt.event.ActionEvent`"
  ([^java.awt.event.ActionListener this ^java.awt.event.ActionEvent e]
    (-> this (.actionPerformed e))))

