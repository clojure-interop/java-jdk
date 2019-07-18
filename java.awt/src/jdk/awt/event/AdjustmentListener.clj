(ns jdk.awt.event.AdjustmentListener
  "The listener interface for receiving adjustment events."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event AdjustmentListener]))

(defn adjustment-value-changed
  "Invoked when the value of the adjustable has changed.

  e - `java.awt.event.AdjustmentEvent`"
  ([^AdjustmentListener this ^java.awt.event.AdjustmentEvent e]
    (-> this (.adjustmentValueChanged e))))

