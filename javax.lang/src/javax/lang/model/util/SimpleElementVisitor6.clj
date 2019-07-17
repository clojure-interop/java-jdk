(ns javax.lang.model.util.SimpleElementVisitor6
  "A simple visitor of program elements with default behavior
  appropriate for the RELEASE_6
  source version.

  Visit methods corresponding to RELEASE_6 language
  constructs call defaultAction, passing their
  arguments to defaultAction's corresponding parameters.

  For constructs introduced in RELEASE_7 and later, visitUnknown is called instead.

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
  implementation in this class will be to call the visitUnknown method.  A new simple element visitor
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
  (:import [javax.lang.model.util SimpleElementVisitor6]))

(defn visit-package
  "Visits a package element. This implementation calls defaultAction.

  e - the element to visit - `javax.lang.model.element.PackageElement`
  p - a visitor-specified parameter - `SimpleElementVisitor6.P`

  returns: the result of defaultAction - `SimpleElementVisitor6.R`"
  ([^javax.lang.model.util.SimpleElementVisitor6 this ^javax.lang.model.element.PackageElement e ^SimpleElementVisitor6.P p]
    (-> this (.visitPackage e p))))

(defn visit-type
  "Visits a type element. This implementation calls defaultAction.

  e - the element to visit - `javax.lang.model.element.TypeElement`
  p - a visitor-specified parameter - `SimpleElementVisitor6.P`

  returns: the result of defaultAction - `SimpleElementVisitor6.R`"
  ([^javax.lang.model.util.SimpleElementVisitor6 this ^javax.lang.model.element.TypeElement e ^SimpleElementVisitor6.P p]
    (-> this (.visitType e p))))

(defn visit-variable
  "Visits a variable element.

   This implementation calls defaultAction, unless the
   element is a RESOURCE_VARIABLE in which case visitUnknown is called.

  e - the element to visit - `javax.lang.model.element.VariableElement`
  p - a visitor-specified parameter - `SimpleElementVisitor6.P`

  returns: the result of defaultAction or visitUnknown - `SimpleElementVisitor6.R`"
  ([^javax.lang.model.util.SimpleElementVisitor6 this ^javax.lang.model.element.VariableElement e ^SimpleElementVisitor6.P p]
    (-> this (.visitVariable e p))))

(defn visit-executable
  "Visits an executable element. This implementation calls defaultAction.

  e - the element to visit - `javax.lang.model.element.ExecutableElement`
  p - a visitor-specified parameter - `SimpleElementVisitor6.P`

  returns: the result of defaultAction - `SimpleElementVisitor6.R`"
  ([^javax.lang.model.util.SimpleElementVisitor6 this ^javax.lang.model.element.ExecutableElement e ^SimpleElementVisitor6.P p]
    (-> this (.visitExecutable e p))))

(defn visit-type-parameter
  "Visits a type parameter element. This implementation calls defaultAction.

  e - the element to visit - `javax.lang.model.element.TypeParameterElement`
  p - a visitor-specified parameter - `SimpleElementVisitor6.P`

  returns: the result of defaultAction - `SimpleElementVisitor6.R`"
  ([^javax.lang.model.util.SimpleElementVisitor6 this ^javax.lang.model.element.TypeParameterElement e ^SimpleElementVisitor6.P p]
    (-> this (.visitTypeParameter e p))))

