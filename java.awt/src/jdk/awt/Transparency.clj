(ns jdk.awt.Transparency
  "The Transparency interface defines the common transparency
  modes for implementing classes."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Transparency]))

(defn get-transparency
  "Returns the type of this Transparency.

  returns: the field type of this Transparency, which is
            either OPAQUE, BITMASK or TRANSLUCENT. - `int`"
  ([this]
    (-> this (.getTransparency))))

