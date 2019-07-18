(ns javax.lang.model.util.ElementScanner6
  "A scanning visitor of program elements with default behavior
  appropriate for the RELEASE_6
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
  (:import [javax.lang.model.util ElementScanner6]))

(defn scan
  "Iterates over the given elements and calls scan(Element, P) on each one.  Returns
   the result of the last call to scan or DEFAULT_VALUE for an empty iterable.

  iterable - the elements to scan - `java.lang.Iterable`
  p - additional parameter - `P`

  returns: the scan of the last element or DEFAULT_VALUE if no elements - `R`"
  ([^ElementScanner6 this ^java.lang.Iterable iterable p]
    (-> this (.scan iterable p)))
  ([^ElementScanner6 this ^javax.lang.model.element.Element e]
    (-> this (.scan e))))

(defn visit-package
  "Visits a package element. This implementation scans the enclosed elements.

  e - the element to visit - `javax.lang.model.element.PackageElement`
  p - a visitor-specified parameter - `P`

  returns: the result of scanning - `R`"
  ([^ElementScanner6 this ^javax.lang.model.element.PackageElement e p]
    (-> this (.visitPackage e p))))

(defn visit-type
  "Visits a type element. This implementation scans the enclosed elements.

  e - the element to visit - `javax.lang.model.element.TypeElement`
  p - a visitor-specified parameter - `P`

  returns: the result of scanning - `R`"
  ([^ElementScanner6 this ^javax.lang.model.element.TypeElement e p]
    (-> this (.visitType e p))))

(defn visit-variable
  "Visits a variable element.

   This implementation scans the enclosed elements, unless the
   element is a RESOURCE_VARIABLE in which case visitUnknown is called.

  e - the element to visit - `javax.lang.model.element.VariableElement`
  p - a visitor-specified parameter - `P`

  returns: the result of scanning - `R`"
  ([^ElementScanner6 this ^javax.lang.model.element.VariableElement e p]
    (-> this (.visitVariable e p))))

(defn visit-executable
  "Visits an executable element. This implementation scans the parameters.

  e - the element to visit - `javax.lang.model.element.ExecutableElement`
  p - a visitor-specified parameter - `P`

  returns: the result of scanning - `R`"
  ([^ElementScanner6 this ^javax.lang.model.element.ExecutableElement e p]
    (-> this (.visitExecutable e p))))

(defn visit-type-parameter
  "Visits a type parameter element. This implementation scans the enclosed elements.

  e - the element to visit - `javax.lang.model.element.TypeParameterElement`
  p - a visitor-specified parameter - `P`

  returns: the result of scanning - `R`"
  ([^ElementScanner6 this ^javax.lang.model.element.TypeParameterElement e p]
    (-> this (.visitTypeParameter e p))))

