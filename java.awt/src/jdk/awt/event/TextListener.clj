(ns jdk.awt.event.TextListener
  "The listener interface for receiving text events.

  The class that is interested in processing a text event
  implements this interface. The object created with that
  class is then registered with a component using the
  component's addTextListener method. When the
  component's text changes, the listener object's
  textValueChanged method is invoked."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event TextListener]))

(defn text-value-changed
  "Invoked when the value of the text has changed.
   The code written for this method performs the operations
   that need to occur when text changes.

  e - `java.awt.event.TextEvent`"
  ([^. this ^java.awt.event.TextEvent e]
    (-> this (.textValueChanged e))))

