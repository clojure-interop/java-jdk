(ns javax.lang.model.util.SimpleAnnotationValueVisitor6
  "A simple visitor for annotation values with default behavior
  appropriate for the RELEASE_6
  source version.  Visit methods call defaultAction(java.lang.Object, P) passing their arguments to defaultAction's
  corresponding parameters.

   Methods in this class may be overridden subject to their
  general contract.  Note that annotating methods in concrete
  subclasses with @Override will help
  ensure that methods are overridden as intended.

   WARNING: The AnnotationValueVisitor interface
  implemented by this class may have methods added to it in the
  future to accommodate new, currently unknown, language structures
  added to future versions of the Java™ programming language.
  Therefore, methods whose names begin with `visit` may be
  added to this class in the future; to avoid incompatibilities,
  classes which extend this class should not declare any instance
  methods with names beginning with `visit`.

  When such a new visit method is added, the default
  implementation in this class will be to call the visitUnknown method.  A new simple annotation
  value visitor class will also be introduced to correspond to the
  new language level; this visitor will have different default
  behavior for the visit method in question.  When the new visitor is
  introduced, all or portions of this visitor may be deprecated.

  Note that adding a default implementation of a new visit method
  in a visitor class will occur instead of adding a default
  method directly in the visitor interface since a Java SE 8
  language feature cannot be used to this version of the API since
  this version is required to be runnable on Java SE 7
  implementations.  Future versions of the API that are only required
  to run on Java SE 8 and later may take advantage of default methods
  in this situation."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.util SimpleAnnotationValueVisitor6]))

(defn visit-double
  "Visits a double value in an annotation. This implementation calls defaultAction.

  d - the value being visited - `double`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^SimpleAnnotationValueVisitor6 this ^Double d p]
    (-> this (.visitDouble d p))))

(defn visit-annotation
  "Visits an annotation value in an annotation. This implementation calls defaultAction.

  a - the value being visited - `javax.lang.model.element.AnnotationMirror`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^SimpleAnnotationValueVisitor6 this ^javax.lang.model.element.AnnotationMirror a p]
    (-> this (.visitAnnotation a p))))

(defn visit-long
  "Visits a long value in an annotation. This implementation calls defaultAction.

  i - the value being visited - `long`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^SimpleAnnotationValueVisitor6 this ^Long i p]
    (-> this (.visitLong i p))))

(defn visit-short
  "Visits a short value in an annotation. This implementation calls defaultAction.

  s - the value being visited - `short`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^SimpleAnnotationValueVisitor6 this ^Short s p]
    (-> this (.visitShort s p))))

(defn visit-string
  "Visits a string value in an annotation. This implementation calls defaultAction.

  s - the value being visited - `java.lang.String`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^SimpleAnnotationValueVisitor6 this ^java.lang.String s p]
    (-> this (.visitString s p))))

(defn visit-float
  "Visits a float value in an annotation. This implementation calls defaultAction.

  f - the value being visited - `float`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^SimpleAnnotationValueVisitor6 this ^Float f p]
    (-> this (.visitFloat f p))))

(defn visit-char
  "Visits a char value in an annotation. This implementation calls defaultAction.

  c - the value being visited - `char`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^SimpleAnnotationValueVisitor6 this ^Character c p]
    (-> this (.visitChar c p))))

(defn visit-array
  "Visits an array value in an annotation. This implementation calls defaultAction.

  vals - the value being visited - `java.util.List`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^SimpleAnnotationValueVisitor6 this ^java.util.List vals p]
    (-> this (.visitArray vals p))))

(defn visit-int
  "Visits an int value in an annotation. This implementation calls defaultAction.

  i - the value being visited - `int`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^SimpleAnnotationValueVisitor6 this ^Integer i p]
    (-> this (.visitInt i p))))

(defn visit-enum-constant
  "Visits an enum value in an annotation. This implementation calls defaultAction.

  c - the value being visited - `javax.lang.model.element.VariableElement`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^SimpleAnnotationValueVisitor6 this ^javax.lang.model.element.VariableElement c p]
    (-> this (.visitEnumConstant c p))))

(defn visit-type
  "Visits a type value in an annotation. This implementation calls defaultAction.

  t - the value being visited - `javax.lang.model.type.TypeMirror`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^SimpleAnnotationValueVisitor6 this ^javax.lang.model.type.TypeMirror t p]
    (-> this (.visitType t p))))

(defn visit-byte
  "Visits a byte value in an annotation. This implementation calls defaultAction.

  b - the value being visited - `byte`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^SimpleAnnotationValueVisitor6 this ^Byte b p]
    (-> this (.visitByte b p))))

(defn visit-boolean
  "Visits a boolean value in an annotation. This implementation calls defaultAction.

  b - the value being visited - `boolean`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^SimpleAnnotationValueVisitor6 this ^Boolean b p]
    (-> this (.visitBoolean b p))))

