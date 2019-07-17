(ns javax.lang.model.element.AnnotationValue
  "Represents a value of an annotation type element.
  A value is of one of the following types:
   a wrapper class (such as Integer) for a primitive type
       String
       TypeMirror
       VariableElement (representing an enum constant)
       AnnotationMirror
       List<? extends AnnotationValue>
               (representing the elements, in declared order, if the value is an array)"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.element AnnotationValue]))

(defn get-value
  "Returns the value.

  returns: the value - `java.lang.Object`"
  (^java.lang.Object [^javax.lang.model.element.AnnotationValue this]
    (-> this (.getValue))))

(defn to-string
  "Returns a string representation of this value.
   This is returned in a form suitable for representing this value
   in the source code of an annotation.

  returns: a string representation of this value - `java.lang.String`"
  (^java.lang.String [^javax.lang.model.element.AnnotationValue this]
    (-> this (.toString))))

(defn accept
  "Applies a visitor to this value.

  v - the visitor operating on this value - `javax.lang.model.element.AnnotationValueVisitor<R,P>`
  p - additional parameter to the visitor - `P`

  returns: a visitor-specified result - `<R,P> R`"
  ([^javax.lang.model.element.AnnotationValue this ^javax.lang.model.element.AnnotationValueVisitor v p]
    (-> this (.accept v p))))

