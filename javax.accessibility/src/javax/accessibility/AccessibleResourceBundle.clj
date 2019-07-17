(ns javax.accessibility.AccessibleResourceBundle
  "Deprecated.
 This class is deprecated as of version 1.3 of the
              Java Platform."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleResourceBundle]))

(defn ->accessible-resource-bundle
  "Constructor.

  Deprecated."
  ([]
    (new AccessibleResourceBundle )))

(defn get-contents
  "Deprecated.

  returns: an array of an Object array representing a
   key-value pair. - `java.lang.Object[][]`"
  ([this]
    (-> this (.getContents))))

