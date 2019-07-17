(ns javax.lang.model.type.ArrayType
  "Represents an array type.
  A multidimensional array type is represented as an array type
  whose component type is also an array type."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.type ArrayType]))

(defn get-component-type
  "Returns the component type of this array type.

  returns: the component type of this array type - `javax.lang.model.type.TypeMirror`"
  ([^javax.lang.model.type.ArrayType this]
    (-> this (.getComponentType))))

