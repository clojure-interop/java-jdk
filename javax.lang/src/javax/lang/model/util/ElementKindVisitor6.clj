(ns javax.lang.model.util.ElementKindVisitor6
  "A visitor of program elements based on their javax.lang.model.element.kind with default behavior appropriate for the RELEASE_6 source version.  For javax.lang.model.element.elements XYZ that may have more than one
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
  begin with \"visit\" may be added to this class in the
  future; to avoid incompatibilities, classes which extend this class
  should not declare any instance methods with names beginning with
  \"visit\".

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
  (:import [javax.lang.model.util ElementKindVisitor6]))

(defn visit-variable-as-local-variable
  "Visits a LOCAL_VARIABLE variable element by calling
   defaultAction.

  e - the element to visit - `javax.lang.model.element.VariableElement`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^ElementKindVisitor6 this ^javax.lang.model.element.VariableElement e p]
    (-> this (.visitVariableAsLocalVariable e p))))

(defn visit-type-as-interface
  "Visits an INTERFACE type element by calling defaultAction.
  .

  e - the element to visit - `javax.lang.model.element.TypeElement`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^ElementKindVisitor6 this ^javax.lang.model.element.TypeElement e p]
    (-> this (.visitTypeAsInterface e p))))

(defn visit-type-as-enum
  "Visits an ENUM type element by calling defaultAction.

  e - the element to visit - `javax.lang.model.element.TypeElement`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^ElementKindVisitor6 this ^javax.lang.model.element.TypeElement e p]
    (-> this (.visitTypeAsEnum e p))))

(defn visit-executable-as-constructor
  "Visits a CONSTRUCTOR executable element by calling
   defaultAction.

  e - the element to visit - `javax.lang.model.element.ExecutableElement`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^ElementKindVisitor6 this ^javax.lang.model.element.ExecutableElement e p]
    (-> this (.visitExecutableAsConstructor e p))))

(defn visit-variable-as-field
  "Visits a FIELD variable element by calling
   defaultAction.

  e - the element to visit - `javax.lang.model.element.VariableElement`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^ElementKindVisitor6 this ^javax.lang.model.element.VariableElement e p]
    (-> this (.visitVariableAsField e p))))

(defn visit-package
  "Visits a package element. This implementation calls defaultAction.

   The element argument has kind PACKAGE.

  e - the element to visit - `javax.lang.model.element.PackageElement`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^ElementKindVisitor6 this ^javax.lang.model.element.PackageElement e p]
    (-> this (.visitPackage e p))))

(defn visit-variable-as-resource-variable
  "Visits a RESOURCE_VARIABLE variable element by calling
   visitUnknown.

  e - the element to visit - `javax.lang.model.element.VariableElement`
  p - a visitor-specified parameter - `P`

  returns: the result of visitUnknown - `R`"
  ([^ElementKindVisitor6 this ^javax.lang.model.element.VariableElement e p]
    (-> this (.visitVariableAsResourceVariable e p))))

(defn visit-variable-as-enum-constant
  "Visits an ENUM_CONSTANT variable element by calling
   defaultAction.

  e - the element to visit - `javax.lang.model.element.VariableElement`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^ElementKindVisitor6 this ^javax.lang.model.element.VariableElement e p]
    (-> this (.visitVariableAsEnumConstant e p))))

(defn visit-type-as-annotation-type
  "Visits an ANNOTATION_TYPE type element by calling
   defaultAction.

  e - the element to visit - `javax.lang.model.element.TypeElement`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^ElementKindVisitor6 this ^javax.lang.model.element.TypeElement e p]
    (-> this (.visitTypeAsAnnotationType e p))))

(defn visit-executable
  "Visits an executable element, dispatching to the visit method
   for the specific javax.lang.model.element.kind of executable,
   CONSTRUCTOR, INSTANCE_INIT, METHOD, or
   STATIC_INIT.

  e - the element to visit - `javax.lang.model.element.ExecutableElement`
  p - a visitor-specified parameter - `P`

  returns: the result of the kind-specific visit method - `R`"
  ([^ElementKindVisitor6 this ^javax.lang.model.element.ExecutableElement e p]
    (-> this (.visitExecutable e p))))

(defn visit-executable-as-method
  "Visits a METHOD executable element by calling
   defaultAction.

  e - the element to visit - `javax.lang.model.element.ExecutableElement`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^ElementKindVisitor6 this ^javax.lang.model.element.ExecutableElement e p]
    (-> this (.visitExecutableAsMethod e p))))

(defn visit-executable-as-static-init
  "Visits a STATIC_INIT executable element by calling
   defaultAction.

  e - the element to visit - `javax.lang.model.element.ExecutableElement`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^ElementKindVisitor6 this ^javax.lang.model.element.ExecutableElement e p]
    (-> this (.visitExecutableAsStaticInit e p))))

(defn visit-type
  "Visits a type element, dispatching to the visit method for the
   specific javax.lang.model.element.kind of type, ANNOTATION_TYPE, CLASS, ENUM, or INTERFACE.

  e - the element to visit - `javax.lang.model.element.TypeElement`
  p - a visitor-specified parameter - `P`

  returns: the result of the kind-specific visit method - `R`"
  ([^ElementKindVisitor6 this ^javax.lang.model.element.TypeElement e p]
    (-> this (.visitType e p))))

(defn visit-variable-as-exception-parameter
  "Visits an EXCEPTION_PARAMETER variable element by calling
   defaultAction.

  e - the element to visit - `javax.lang.model.element.VariableElement`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^ElementKindVisitor6 this ^javax.lang.model.element.VariableElement e p]
    (-> this (.visitVariableAsExceptionParameter e p))))

(defn visit-type-parameter
  "Visits a type parameter element. This implementation calls defaultAction.

   The element argument has kind TYPE_PARAMETER.

  e - the element to visit - `javax.lang.model.element.TypeParameterElement`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^ElementKindVisitor6 this ^javax.lang.model.element.TypeParameterElement e p]
    (-> this (.visitTypeParameter e p))))

(defn visit-variable-as-parameter
  "Visits a PARAMETER variable element by calling
   defaultAction.

  e - the element to visit - `javax.lang.model.element.VariableElement`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^ElementKindVisitor6 this ^javax.lang.model.element.VariableElement e p]
    (-> this (.visitVariableAsParameter e p))))

(defn visit-type-as-class
  "Visits a CLASS type element by calling defaultAction.

  e - the element to visit - `javax.lang.model.element.TypeElement`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^ElementKindVisitor6 this ^javax.lang.model.element.TypeElement e p]
    (-> this (.visitTypeAsClass e p))))

(defn visit-variable
  "Visits a variable element, dispatching to the visit method for
   the specific javax.lang.model.element.kind of variable, ENUM_CONSTANT, EXCEPTION_PARAMETER, FIELD,
   LOCAL_VARIABLE, PARAMETER, or RESOURCE_VARIABLE.

  e - the element to visit - `javax.lang.model.element.VariableElement`
  p - a visitor-specified parameter - `P`

  returns: the result of the kind-specific visit method - `R`"
  ([^ElementKindVisitor6 this ^javax.lang.model.element.VariableElement e p]
    (-> this (.visitVariable e p))))

(defn visit-executable-as-instance-init
  "Visits an INSTANCE_INIT executable element by calling
   defaultAction.

  e - the element to visit - `javax.lang.model.element.ExecutableElement`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^ElementKindVisitor6 this ^javax.lang.model.element.ExecutableElement e p]
    (-> this (.visitExecutableAsInstanceInit e p))))

