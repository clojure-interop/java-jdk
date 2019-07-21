(ns javax.xml.ws.Holder
  "Holds a value of type T."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws Holder]))

(defn ->holder
  "Constructor.

  Create a new holder with the specified value.

  value - The value to be stored in the holder. - `T`"
  (^Holder [value]
    (new Holder value))
  (^Holder []
    (new Holder )))

(defn value
  "Instance Field.

  The value contained in the holder.

  type: T"
  ([^Holder this]
    (-> this .-value)))

