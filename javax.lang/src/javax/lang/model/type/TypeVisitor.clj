(ns javax.lang.model.type.TypeVisitor
  "A visitor of types, in the style of the
  visitor design pattern.  Classes implementing this
  interface are used to operate on a type when the kind of
  type is unknown at compile time.  When a visitor is passed to a
  type's accept method, the visitXYZ
  method most applicable to that type is invoked.

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
  (:import [javax.lang.model.type TypeVisitor]))

(defn visit
  "Visits a type.

  t - the type to visit - `javax.lang.model.type.TypeMirror`
  p - a visitor-specified parameter - `P`

  returns: a visitor-specified result - `R`"
  ([^TypeVisitor this ^javax.lang.model.type.TypeMirror t p]
    (-> this (.visit t p)))
  ([^TypeVisitor this ^javax.lang.model.type.TypeMirror t]
    (-> this (.visit t))))

(defn visit-intersection
  "Visits an intersection type.

  t - the type to visit - `javax.lang.model.type.IntersectionType`
  p - a visitor-specified parameter - `P`

  returns: a visitor-specified result - `R`"
  ([^TypeVisitor this ^javax.lang.model.type.IntersectionType t p]
    (-> this (.visitIntersection t p))))

(defn visit-declared
  "Visits a declared type.

  t - the type to visit - `javax.lang.model.type.DeclaredType`
  p - a visitor-specified parameter - `P`

  returns: a visitor-specified result - `R`"
  ([^TypeVisitor this ^javax.lang.model.type.DeclaredType t p]
    (-> this (.visitDeclared t p))))

(defn visit-array
  "Visits an array type.

  t - the type to visit - `javax.lang.model.type.ArrayType`
  p - a visitor-specified parameter - `P`

  returns: a visitor-specified result - `R`"
  ([^TypeVisitor this ^javax.lang.model.type.ArrayType t p]
    (-> this (.visitArray t p))))

(defn visit-type-variable
  "Visits a type variable.

  t - the type to visit - `javax.lang.model.type.TypeVariable`
  p - a visitor-specified parameter - `P`

  returns: a visitor-specified result - `R`"
  ([^TypeVisitor this ^javax.lang.model.type.TypeVariable t p]
    (-> this (.visitTypeVariable t p))))

(defn visit-null
  "Visits the null type.

  t - the type to visit - `javax.lang.model.type.NullType`
  p - a visitor-specified parameter - `P`

  returns: a visitor-specified result - `R`"
  ([^TypeVisitor this ^javax.lang.model.type.NullType t p]
    (-> this (.visitNull t p))))

(defn visit-no-type
  "Visits a NoType instance.

  t - the type to visit - `javax.lang.model.type.NoType`
  p - a visitor-specified parameter - `P`

  returns: a visitor-specified result - `R`"
  ([^TypeVisitor this ^javax.lang.model.type.NoType t p]
    (-> this (.visitNoType t p))))

(defn visit-wildcard
  "Visits a wildcard type.

  t - the type to visit - `javax.lang.model.type.WildcardType`
  p - a visitor-specified parameter - `P`

  returns: a visitor-specified result - `R`"
  ([^TypeVisitor this ^javax.lang.model.type.WildcardType t p]
    (-> this (.visitWildcard t p))))

(defn visit-primitive
  "Visits a primitive type.

  t - the type to visit - `javax.lang.model.type.PrimitiveType`
  p - a visitor-specified parameter - `P`

  returns: a visitor-specified result - `R`"
  ([^TypeVisitor this ^javax.lang.model.type.PrimitiveType t p]
    (-> this (.visitPrimitive t p))))

(defn visit-union
  "Visits a union type.

  t - the type to visit - `javax.lang.model.type.UnionType`
  p - a visitor-specified parameter - `P`

  returns: a visitor-specified result - `R`"
  ([^TypeVisitor this ^javax.lang.model.type.UnionType t p]
    (-> this (.visitUnion t p))))

(defn visit-executable
  "Visits an executable type.

  t - the type to visit - `javax.lang.model.type.ExecutableType`
  p - a visitor-specified parameter - `P`

  returns: a visitor-specified result - `R`"
  ([^TypeVisitor this ^javax.lang.model.type.ExecutableType t p]
    (-> this (.visitExecutable t p))))

(defn visit-error
  "Visits an error type.

  t - the type to visit - `javax.lang.model.type.ErrorType`
  p - a visitor-specified parameter - `P`

  returns: a visitor-specified result - `R`"
  ([^TypeVisitor this ^javax.lang.model.type.ErrorType t p]
    (-> this (.visitError t p))))

(defn visit-unknown
  "Visits an unknown kind of type.
   This can occur if the language evolves and new kinds
   of types are added to the TypeMirror hierarchy.

  t - the type to visit - `javax.lang.model.type.TypeMirror`
  p - a visitor-specified parameter - `P`

  returns: a visitor-specified result - `R`

  throws: javax.lang.model.type.UnknownTypeException - a visitor implementation may optionally throw this exception"
  ([^TypeVisitor this ^javax.lang.model.type.TypeMirror t p]
    (-> this (.visitUnknown t p))))

