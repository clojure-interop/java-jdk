(ns javax.lang.model.element.UnknownAnnotationValueException
  "Indicates that an unknown kind of annotation value was encountered.
  This can occur if the language evolves and new kinds of annotation
  values can be stored in an annotation.  May be thrown by an
  javax.lang.model.element.annotation value visitor to
  indicate that the visitor was created for a prior version of the
  language."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.element UnknownAnnotationValueException]))

(defn ->unknown-annotation-value-exception
  "Constructor.

  Creates a new UnknownAnnotationValueException.  The
   p parameter may be used to pass in an additional
   argument with information about the context in which the
   unknown annotation value was encountered; for example, the
   visit methods of AnnotationValueVisitor may pass in
   their additional parameter.

  av - the unknown annotation value, may be null - `javax.lang.model.element.AnnotationValue`
  p - an additional parameter, may be null - `java.lang.Object`"
  (^UnknownAnnotationValueException [^javax.lang.model.element.AnnotationValue av ^java.lang.Object p]
    (new UnknownAnnotationValueException av p)))

(defn get-unknown-annotation-value
  "Returns the unknown annotation value.
   The value may be unavailable if this exception has been
   serialized and then read back in.

  returns: the unknown element, or null if unavailable - `javax.lang.model.element.AnnotationValue`"
  (^javax.lang.model.element.AnnotationValue [^UnknownAnnotationValueException this]
    (-> this (.getUnknownAnnotationValue))))

(defn get-argument
  "Returns the additional argument.

  returns: the additional argument - `java.lang.Object`"
  (^java.lang.Object [^UnknownAnnotationValueException this]
    (-> this (.getArgument))))

