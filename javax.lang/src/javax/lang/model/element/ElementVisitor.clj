(ns javax.lang.model.element.ElementVisitor
  "A visitor of program elements, in the style of the visitor design
  pattern.  Classes implementing this interface are used to operate
  on an element when the kind of element is unknown at compile time.
  When a visitor is passed to an element's accept method, the visitXYZ method most applicable
  to that element is invoked.

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
  (:import [javax.lang.model.element ElementVisitor]))

(defn visit
  "Visits an element.

  e - the element to visit - `javax.lang.model.element.Element`
  p - a visitor-specified parameter - `P`

  returns: a visitor-specified result - `R`"
  ([^ElementVisitor this ^javax.lang.model.element.Element e p]
    (-> this (.visit e p)))
  ([^ElementVisitor this ^javax.lang.model.element.Element e]
    (-> this (.visit e))))

(defn visit-package
  "Visits a package element.

  e - the element to visit - `javax.lang.model.element.PackageElement`
  p - a visitor-specified parameter - `P`

  returns: a visitor-specified result - `R`"
  ([^ElementVisitor this ^javax.lang.model.element.PackageElement e p]
    (-> this (.visitPackage e p))))

(defn visit-type
  "Visits a type element.

  e - the element to visit - `javax.lang.model.element.TypeElement`
  p - a visitor-specified parameter - `P`

  returns: a visitor-specified result - `R`"
  ([^ElementVisitor this ^javax.lang.model.element.TypeElement e p]
    (-> this (.visitType e p))))

(defn visit-variable
  "Visits a variable element.

  e - the element to visit - `javax.lang.model.element.VariableElement`
  p - a visitor-specified parameter - `P`

  returns: a visitor-specified result - `R`"
  ([^ElementVisitor this ^javax.lang.model.element.VariableElement e p]
    (-> this (.visitVariable e p))))

(defn visit-executable
  "Visits an executable element.

  e - the element to visit - `javax.lang.model.element.ExecutableElement`
  p - a visitor-specified parameter - `P`

  returns: a visitor-specified result - `R`"
  ([^ElementVisitor this ^javax.lang.model.element.ExecutableElement e p]
    (-> this (.visitExecutable e p))))

(defn visit-type-parameter
  "Visits a type parameter element.

  e - the element to visit - `javax.lang.model.element.TypeParameterElement`
  p - a visitor-specified parameter - `P`

  returns: a visitor-specified result - `R`"
  ([^ElementVisitor this ^javax.lang.model.element.TypeParameterElement e p]
    (-> this (.visitTypeParameter e p))))

(defn visit-unknown
  "Visits an unknown kind of element.
   This can occur if the language evolves and new kinds
   of elements are added to the Element hierarchy.

  e - the element to visit - `javax.lang.model.element.Element`
  p - a visitor-specified parameter - `P`

  returns: a visitor-specified result - `R`

  throws: javax.lang.model.element.UnknownElementException - a visitor implementation may optionally throw this exception"
  ([^ElementVisitor this ^javax.lang.model.element.Element e p]
    (-> this (.visitUnknown e p))))

