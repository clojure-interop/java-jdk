(ns javax.lang.model.element.AnnotationMirror
  "Represents an annotation.  An annotation associates a value with
  each element of an annotation type.

   Annotations should be compared using the equals
  method.  There is no guarantee that any particular annotation will
  always be represented by the same object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.element AnnotationMirror]))

(defn get-annotation-type
  "Returns the type of this annotation.

  returns: the type of this annotation - `javax.lang.model.type.DeclaredType`"
  ([^. this]
    (-> this (.getAnnotationType))))

(defn get-element-values
  "Returns the values of this annotation's elements.
   This is returned in the form of a map that associates elements
   with their corresponding values.
   Only those elements with values explicitly present in the
   annotation are included, not those that are implicitly assuming
   their default values.
   The order of the map matches the order in which the
   values appear in the annotation's source.

   Note that an annotation mirror of a marker annotation type
   will by definition have an empty map.

   To fill in default values, use getElementValuesWithDefaults.

  returns: the values of this annotation's elements,
            or an empty map if there are none - `java.util.Map<? extends javax.lang.model.element.ExecutableElement,? extends javax.lang.model.element.AnnotationValue>`"
  ([^. this]
    (-> this (.getElementValues))))

