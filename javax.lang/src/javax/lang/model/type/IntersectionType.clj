(ns javax.lang.model.type.IntersectionType
  "Represents an intersection type.

  An intersection type can be either implicitly or explicitly
  declared in a program. For example, the bound of the type parameter
  <T extends Number & Runnable> is an (implicit) intersection
  type.  As of RELEASE_8, this is represented by an IntersectionType with
  Number and Runnable as its bounds."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.type IntersectionType]))

(defn get-bounds
  "Return the bounds comprising this intersection type.

  returns: the bounds of this intersection types. - `java.util.List<? extends javax.lang.model.type.TypeMirror>`"
  ([^javax.lang.model.type.IntersectionType this]
    (-> this (.getBounds))))

