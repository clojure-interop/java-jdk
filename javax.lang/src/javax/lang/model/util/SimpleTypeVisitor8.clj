(ns javax.lang.model.util.SimpleTypeVisitor8
  "A simple visitor of types with default behavior appropriate for the
  RELEASE_7 source version.

  Visit methods corresponding to RELEASE_8 and earlier
  language constructs call defaultAction,
  passing their arguments to defaultAction's corresponding
  parameters.

   Methods in this class may be overridden subject to their
  general contract.  Note that annotating methods in concrete
  subclasses with @Override will help
  ensure that methods are overridden as intended.

   WARNING: The TypeVisitor interface implemented
  by this class may have methods added to it in the future to
  accommodate new, currently unknown, language structures added to
  future versions of the Java™ programming language.
  Therefore, methods whose names begin with \"visit\" may be
  added to this class in the future; to avoid incompatibilities,
  classes which extend this class should not declare any instance
  methods with names beginning with \"visit\".

  When such a new visit method is added, the default
  implementation in this class will be to call the visitUnknown method.  A new simple type visitor
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
  (:import [javax.lang.model.util SimpleTypeVisitor8]))

(defn visit-intersection
  "This implementation visits an IntersectionType by calling
   defaultAction.

  t - the type to visit - `javax.lang.model.type.IntersectionType`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^SimpleTypeVisitor8 this ^javax.lang.model.type.IntersectionType t p]
    (-> this (.visitIntersection t p))))

