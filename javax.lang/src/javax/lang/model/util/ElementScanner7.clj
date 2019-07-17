(ns javax.lang.model.util.ElementScanner7
  "A scanning visitor of program elements with default behavior
  appropriate for the RELEASE_7
  source version.  The visitXYZ methods in this
  class scan their component elements by calling scan on
  their enclosed elements,
  parameters, etc., as
  indicated in the individual method specifications.  A subclass can
  control the order elements are visited by overriding the
  visitXYZ methods.  Note that clients of a scanner
  may get the desired behavior be invoking v.scan(e, p) rather
  than v.visit(e, p) on the root objects of interest.

  When a subclass overrides a visitXYZ method, the
  new method can cause the enclosed elements to be scanned in the
  default way by calling super.visitXYZ.  In this
  fashion, the concrete visitor can control the ordering of traversal
  over the component elements with respect to the additional
  processing; for example, consistently calling
  super.visitXYZ at the start of the overridden
  methods will yield a preorder traversal, etc.  If the component
  elements should be traversed in some other order, instead of
  calling super.visitXYZ, an overriding visit method
  should call scan with the elements in the desired order.

   Methods in this class may be overridden subject to their
  general contract.  Note that annotating methods in concrete
  subclasses with @Override will help
  ensure that methods are overridden as intended.

   WARNING: The ElementVisitor interface
  implemented by this class may have methods added to it in the
  future to accommodate new, currently unknown, language structures
  added to future versions of the Java™ programming language.
  Therefore, methods whose names begin with `visit` may be
  added to this class in the future; to avoid incompatibilities,
  classes which extend this class should not declare any instance
  methods with names beginning with `visit`.

  When such a new visit method is added, the default
  implementation in this class will be to call the visitUnknown method.  A new element scanner visitor
  class will also be introduced to correspond to the new language
  level; this visitor will have different default behavior for the
  visit method in question.  When the new visitor is introduced, all
  or portions of this visitor may be deprecated."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.util ElementScanner7]))

(defn visit-variable
  "This implementation scans the enclosed elements.

  e - the element to visit - `javax.lang.model.element.VariableElement`
  p - a visitor-specified parameter - `ElementScanner7.P`

  returns: the result of scanning - `ElementScanner7.R`"
  (^ElementScanner7.R [^javax.lang.model.util.ElementScanner7 this ^javax.lang.model.element.VariableElement e ^ElementScanner7.P p]
    (-> this (.visitVariable e p))))

