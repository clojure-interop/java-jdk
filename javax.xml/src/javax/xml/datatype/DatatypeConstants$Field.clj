(ns javax.xml.datatype.DatatypeConstants$Field
  "Type-safe enum class that represents six fields
  of the Duration class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.datatype DatatypeConstants$Field]))

(defn to-string
  "Returns a field name in English. This method
   is intended to be used for debugging/diagnosis
   and not for display to end-users.

  returns: a non-null valid String constant. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn get-id
  "Get id of this Field.

  returns: Id of field. - `int`"
  ([this]
    (-> this (.getId))))

