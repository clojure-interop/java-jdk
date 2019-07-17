(ns javax.lang.model.util.AbstractElementVisitor6
  "A skeletal visitor of program elements with default behavior
  appropriate for the RELEASE_6
  source version.

   WARNING: The ElementVisitor interface
  implemented by this class may have methods added to it in the
  future to accommodate new, currently unknown, language structures
  added to future versions of the Java™ programming language.
  Therefore, methods whose names begin with `visit` may be
  added to this class in the future; to avoid incompatibilities,
  classes which extend this class should not declare any instance
  methods with names beginning with `visit`.

  When such a new visit method is added, the default
  implementation in this class will be to call the visitUnknown method.  A new abstract element visitor
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
  (:import [javax.lang.model.util AbstractElementVisitor6]))

(defn visit
  "Visits any program element as if by passing itself to that
   element's accept method.  The invocation
   v.visit(elem) is equivalent to elem.accept(v,
   p).

  e - the element to visit - `javax.lang.model.element.Element`
  p - a visitor-specified parameter - `AbstractElementVisitor6.P`

  returns: a visitor-specified result - `AbstractElementVisitor6.R`"
  ([this e p]
    (-> this (.visit e p)))
  ([this e]
    (-> this (.visit e))))

(defn visit-unknown
  "Visits an unknown kind of element.
   This can occur if the language evolves and new kinds
   of elements are added to the Element hierarchy.

    The default implementation of this method in
   AbstractElementVisitor6 will always throw
   UnknownElementException.
   This behavior is not required of a subclass.

  e - the element to visit - `javax.lang.model.element.Element`
  p - a visitor-specified parameter - `AbstractElementVisitor6.P`

  returns: a visitor-specified result - `AbstractElementVisitor6.R`

  throws: javax.lang.model.element.UnknownElementException - a visitor implementation may optionally throw this exception"
  ([this e p]
    (-> this (.visitUnknown e p))))

