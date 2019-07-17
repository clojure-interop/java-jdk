(ns javax.xml.ws.Holder
  "Holds a value of type T."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws Holder]))

(defn ->holder
  "Constructor.

  Create a new holder with the specified value.

  value - The value to be stored in the holder. - `Holder.T`"
  ([value]
    (new Holder value))
  ([]
    (new Holder )))

(defn -value
  "Instance Field.

  The value contained in the holder.

  type: Holder.T"
  [this]
  (-> this .-value))

