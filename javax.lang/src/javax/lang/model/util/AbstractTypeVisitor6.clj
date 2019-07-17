(ns javax.lang.model.util.AbstractTypeVisitor6
  "A skeletal visitor of types with default behavior appropriate for
  the RELEASE_6
  source version.

   WARNING: The TypeVisitor interface implemented
  by this class may have methods added to it in the future to
  accommodate new, currently unknown, language structures added to
  future versions of the Java™ programming language.
  Therefore, methods whose names begin with `visit` may be
  added to this class in the future; to avoid incompatibilities,
  classes which extend this class should not declare any instance
  methods with names beginning with `visit`.

  When such a new visit method is added, the default
  implementation in this class will be to call the visitUnknown method.  A new abstract type visitor
  class will also be introduced to correspond to the new language
  level; this visitor will have different default behavior for the
  visit method in question.  When the new visitor is introduced, all
  or portions of this visitor may be deprecated.

  Note that adding a default implementation of a new visit method
  in a visitor class will occur instead of adding a default
  method directly in the visitor interface since a Java SE 8
  language feature cannot be used to this version of the API since
  this version is required to be runnable on Java SE 7
  implementations.  Future versions of the API that are only required
  to run on Java SE 8 and later may take advantage of default methods
  in this situation."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.util AbstractTypeVisitor6]))

(defn visit
  "Visits any type mirror as if by passing itself to that type
   mirror's accept method.  The
   invocation v.visit(t, p) is equivalent to t.accept(v, p).

  t - the type to visit - `javax.lang.model.type.TypeMirror`
  p - a visitor-specified parameter - `AbstractTypeVisitor6.P`

  returns: a visitor-specified result - `AbstractTypeVisitor6.R`"
  (^AbstractTypeVisitor6.R [^javax.lang.model.util.AbstractTypeVisitor6 this ^javax.lang.model.type.TypeMirror t ^AbstractTypeVisitor6.P p]
    (-> this (.visit t p)))
  (^AbstractTypeVisitor6.R [^javax.lang.model.util.AbstractTypeVisitor6 this ^javax.lang.model.type.TypeMirror t]
    (-> this (.visit t))))

(defn visit-union
  "Visits a UnionType element by calling visitUnknown.

  t - the type to visit - `javax.lang.model.type.UnionType`
  p - a visitor-specified parameter - `AbstractTypeVisitor6.P`

  returns: the result of visitUnknown - `AbstractTypeVisitor6.R`"
  (^AbstractTypeVisitor6.R [^javax.lang.model.util.AbstractTypeVisitor6 this ^javax.lang.model.type.UnionType t ^AbstractTypeVisitor6.P p]
    (-> this (.visitUnion t p))))

(defn visit-intersection
  "Visits an IntersectionType element by calling visitUnknown.

  t - the type to visit - `javax.lang.model.type.IntersectionType`
  p - a visitor-specified parameter - `AbstractTypeVisitor6.P`

  returns: the result of visitUnknown - `AbstractTypeVisitor6.R`"
  (^AbstractTypeVisitor6.R [^javax.lang.model.util.AbstractTypeVisitor6 this ^javax.lang.model.type.IntersectionType t ^AbstractTypeVisitor6.P p]
    (-> this (.visitIntersection t p))))

(defn visit-unknown
  "Visits an unknown kind of type.
   This can occur if the language evolves and new kinds
   of types are added to the TypeMirror hierarchy.

    The default implementation of this method in AbstractTypeVisitor6 will always throw UnknownTypeException.  This behavior is not required of a
   subclass.

  t - the type to visit - `javax.lang.model.type.TypeMirror`
  p - a visitor-specified parameter - `AbstractTypeVisitor6.P`

  returns: a visitor-specified result - `AbstractTypeVisitor6.R`

  throws: javax.lang.model.type.UnknownTypeException - a visitor implementation may optionally throw this exception"
  (^AbstractTypeVisitor6.R [^javax.lang.model.util.AbstractTypeVisitor6 this ^javax.lang.model.type.TypeMirror t ^AbstractTypeVisitor6.P p]
    (-> this (.visitUnknown t p))))

