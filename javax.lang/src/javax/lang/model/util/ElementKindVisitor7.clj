(ns javax.lang.model.util.ElementKindVisitor7
  "A visitor of program elements based on their javax.lang.model.element.kind with default behavior appropriate for the RELEASE_7 source version.  For javax.lang.model.element.elements XYZ that may have more than one
  kind, the visitXYZ methods in this class delegate
  to the visitXYZKind method corresponding to the
  first argument's kind.  The visitXYZKind methods
  call defaultAction, passing their arguments
  to defaultAction's corresponding parameters.

   Methods in this class may be overridden subject to their
  general contract.  Note that annotating methods in concrete
  subclasses with @Override will help
  ensure that methods are overridden as intended.

   WARNING: The ElementVisitor interface
  implemented by this class may have methods added to it or the
  ElementKind enum used in this case may have
  constants added to it in the future to accommodate new, currently
  unknown, language structures added to future versions of the
  Java™ programming language.  Therefore, methods whose names
  begin with `visit` may be added to this class in the
  future; to avoid incompatibilities, classes which extend this class
  should not declare any instance methods with names beginning with
  `visit`.

  When such a new visit method is added, the default
  implementation in this class will be to call the visitUnknown method.  A new abstract element kind
  visitor class will also be introduced to correspond to the new
  language level; this visitor will have different default behavior
  for the visit method in question.  When the new visitor is
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
  (:import [javax.lang.model.util ElementKindVisitor7]))

(defn visit-variable-as-resource-variable
  "Visits a RESOURCE_VARIABLE variable element by calling
   defaultAction.

  e - the element to visit - `javax.lang.model.element.VariableElement`
  p - a visitor-specified parameter - `ElementKindVisitor7.P`

  returns: the result of defaultAction - `ElementKindVisitor7.R`"
  ([^javax.lang.model.util.ElementKindVisitor7 this ^javax.lang.model.element.VariableElement e ^ElementKindVisitor7.P p]
    (-> this (.visitVariableAsResourceVariable e p))))

