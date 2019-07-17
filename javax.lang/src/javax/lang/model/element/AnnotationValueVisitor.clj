(ns javax.lang.model.element.AnnotationValueVisitor
  "A visitor of the values of annotation type elements, using a
  variant of the visitor design pattern.  Unlike a standard visitor
  which dispatches based on the concrete type of a member of a type
  hierarchy, this visitor dispatches based on the type of data
  stored; there are no distinct subclasses for storing, for example,
  boolean values versus int values.  Classes
  implementing this interface are used to operate on a value when the
  type of that value is unknown at compile time.  When a visitor is
  passed to a value's accept method,
  the visitXYZ method applicable to that value is
  invoked.

   Classes implementing this interface may or may not throw a
  NullPointerException if the additional parameter p
  is null; see documentation of the implementing class for
  details.

   WARNING: It is possible that methods will be added to
  this interface to accommodate new, currently unknown, language
  structures added to future versions of the Java™ programming
  language.  Therefore, visitor classes directly implementing this
  interface may be source incompatible with future versions of the
  platform.  To avoid this source incompatibility, visitor
  implementations are encouraged to instead extend the appropriate
  abstract visitor class that implements this interface.  However, an
  API should generally use this visitor interface as the type for
  parameters, return type, etc. rather than one of the abstract
  classes.

  Note that methods to accommodate new language constructs could
  be added in a source compatible way if they were added as
  default methods.  However, default methods are only
  available on Java SE 8 and higher releases and the javax.lang.model.* packages bundled in Java SE 8 are required to
  also be runnable on Java SE 7.  Therefore, default methods
  cannot be used when extending javax.lang.model.*
  to cover Java SE 8 language features.  However, default methods may
  be used in subsequent revisions of the javax.lang.model.*
  packages that are only required to run on Java SE 8 and higher
  platform versions."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.element AnnotationValueVisitor]))

(defn visit-double
  "Visits a double value in an annotation.

  d - the value being visited - `double`
  p - a visitor-specified parameter - `AnnotationValueVisitor.P`

  returns: the result of the visit - `AnnotationValueVisitor.R`"
  ([^. this ^Double d ^AnnotationValueVisitor.P p]
    (-> this (.visitDouble d p))))

(defn visit
  "Visits an annotation value.

  av - the value to visit - `javax.lang.model.element.AnnotationValue`
  p - a visitor-specified parameter - `AnnotationValueVisitor.P`

  returns: a visitor-specified result - `AnnotationValueVisitor.R`"
  ([^. this ^javax.lang.model.element.AnnotationValue av ^AnnotationValueVisitor.P p]
    (-> this (.visit av p)))
  ([^. this ^javax.lang.model.element.AnnotationValue av]
    (-> this (.visit av))))

(defn visit-annotation
  "Visits an annotation value in an annotation.

  a - the value being visited - `javax.lang.model.element.AnnotationMirror`
  p - a visitor-specified parameter - `AnnotationValueVisitor.P`

  returns: the result of the visit - `AnnotationValueVisitor.R`"
  ([^. this ^javax.lang.model.element.AnnotationMirror a ^AnnotationValueVisitor.P p]
    (-> this (.visitAnnotation a p))))

(defn visit-long
  "Visits a long value in an annotation.

  i - the value being visited - `long`
  p - a visitor-specified parameter - `AnnotationValueVisitor.P`

  returns: the result of the visit - `AnnotationValueVisitor.R`"
  ([^. this ^Long i ^AnnotationValueVisitor.P p]
    (-> this (.visitLong i p))))

(defn visit-short
  "Visits a short value in an annotation.

  s - the value being visited - `short`
  p - a visitor-specified parameter - `AnnotationValueVisitor.P`

  returns: the result of the visit - `AnnotationValueVisitor.R`"
  ([^. this ^Short s ^AnnotationValueVisitor.P p]
    (-> this (.visitShort s p))))

(defn visit-string
  "Visits a string value in an annotation.

  s - the value being visited - `java.lang.String`
  p - a visitor-specified parameter - `AnnotationValueVisitor.P`

  returns: the result of the visit - `AnnotationValueVisitor.R`"
  ([^. this ^java.lang.String s ^AnnotationValueVisitor.P p]
    (-> this (.visitString s p))))

(defn visit-float
  "Visits a float value in an annotation.

  f - the value being visited - `float`
  p - a visitor-specified parameter - `AnnotationValueVisitor.P`

  returns: the result of the visit - `AnnotationValueVisitor.R`"
  ([^. this ^Float f ^AnnotationValueVisitor.P p]
    (-> this (.visitFloat f p))))

(defn visit-char
  "Visits a char value in an annotation.

  c - the value being visited - `char`
  p - a visitor-specified parameter - `AnnotationValueVisitor.P`

  returns: the result of the visit - `AnnotationValueVisitor.R`"
  ([^. this ^Character c ^AnnotationValueVisitor.P p]
    (-> this (.visitChar c p))))

(defn visit-array
  "Visits an array value in an annotation.

  vals - the value being visited - `javax.lang.model.element.AnnotationValue>`
  p - a visitor-specified parameter - `AnnotationValueVisitor.P`

  returns: the result of the visit - `AnnotationValueVisitor.R`"
  ([^. this ^javax.lang.model.element.AnnotationValue> vals ^AnnotationValueVisitor.P p]
    (-> this (.visitArray vals p))))

(defn visit-int
  "Visits an int value in an annotation.

  i - the value being visited - `int`
  p - a visitor-specified parameter - `AnnotationValueVisitor.P`

  returns: the result of the visit - `AnnotationValueVisitor.R`"
  ([^. this ^Integer i ^AnnotationValueVisitor.P p]
    (-> this (.visitInt i p))))

(defn visit-enum-constant
  "Visits an enum value in an annotation.

  c - the value being visited - `javax.lang.model.element.VariableElement`
  p - a visitor-specified parameter - `AnnotationValueVisitor.P`

  returns: the result of the visit - `AnnotationValueVisitor.R`"
  ([^. this ^javax.lang.model.element.VariableElement c ^AnnotationValueVisitor.P p]
    (-> this (.visitEnumConstant c p))))

(defn visit-type
  "Visits a type value in an annotation.

  t - the value being visited - `javax.lang.model.type.TypeMirror`
  p - a visitor-specified parameter - `AnnotationValueVisitor.P`

  returns: the result of the visit - `AnnotationValueVisitor.R`"
  ([^. this ^javax.lang.model.type.TypeMirror t ^AnnotationValueVisitor.P p]
    (-> this (.visitType t p))))

(defn visit-byte
  "Visits a byte value in an annotation.

  b - the value being visited - `byte`
  p - a visitor-specified parameter - `AnnotationValueVisitor.P`

  returns: the result of the visit - `AnnotationValueVisitor.R`"
  ([^. this ^Byte b ^AnnotationValueVisitor.P p]
    (-> this (.visitByte b p))))

(defn visit-boolean
  "Visits a boolean value in an annotation.

  b - the value being visited - `boolean`
  p - a visitor-specified parameter - `AnnotationValueVisitor.P`

  returns: the result of the visit - `AnnotationValueVisitor.R`"
  ([^. this ^Boolean b ^AnnotationValueVisitor.P p]
    (-> this (.visitBoolean b p))))

(defn visit-unknown
  "Visits an unknown kind of annotation value.
   This can occur if the language evolves and new kinds
   of value can be stored in an annotation.

  av - the unknown value being visited - `javax.lang.model.element.AnnotationValue`
  p - a visitor-specified parameter - `AnnotationValueVisitor.P`

  returns: the result of the visit - `AnnotationValueVisitor.R`

  throws: javax.lang.model.element.UnknownAnnotationValueException - a visitor implementation may optionally throw this exception"
  ([^. this ^javax.lang.model.element.AnnotationValue av ^AnnotationValueVisitor.P p]
    (-> this (.visitUnknown av p))))

