(ns javax.lang.model.util.TypeKindVisitor6
  "A visitor of types based on their javax.lang.model.type.kind with
  default behavior appropriate for the RELEASE_6 source version.  For javax.lang.model.type.types XYZ that may have more than one
  kind, the visitXYZ methods in this class delegate
  to the visitXYZKind method corresponding to the
  first argument's kind.  The visitXYZKind methods
  call defaultAction, passing their arguments
  to defaultAction's corresponding parameters.

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
  implementation in this class will be to call the visitUnknown method.  A new type kind visitor class
  will also be introduced to correspond to the new language level;
  this visitor will have different default behavior for the visit
  method in question.  When the new visitor is introduced, all or
  portions of this visitor may be deprecated.

  Note that adding a default implementation of a new visit method
  in a visitor class will occur instead of adding a default
  method directly in the visitor interface since a Java SE 8
  language feature cannot be used to this version of the API since
  this version is required to be runnable on Java SE 7
  implementations.  Future versions of the API that are only required
  to run on Java SE 8 and later may take advantage of default methods
  in this situation."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.util TypeKindVisitor6]))

(defn visit-primitive-as-long
  "Visits a LONG primitive type by calling
   defaultAction.

  t - the type to visit - `javax.lang.model.type.PrimitiveType`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^TypeKindVisitor6 this ^javax.lang.model.type.PrimitiveType t p]
    (-> this (.visitPrimitiveAsLong t p))))

(defn visit-no-type-as-package
  "Visits a PACKAGE pseudo-type by calling
   defaultAction.

  t - the type to visit - `javax.lang.model.type.NoType`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^TypeKindVisitor6 this ^javax.lang.model.type.NoType t p]
    (-> this (.visitNoTypeAsPackage t p))))

(defn visit-primitive-as-float
  "Visits a FLOAT primitive type by calling
   defaultAction.

  t - the type to visit - `javax.lang.model.type.PrimitiveType`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^TypeKindVisitor6 this ^javax.lang.model.type.PrimitiveType t p]
    (-> this (.visitPrimitiveAsFloat t p))))

(defn visit-no-type-as-none
  "Visits a NONE pseudo-type by calling
   defaultAction.

  t - the type to visit - `javax.lang.model.type.NoType`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^TypeKindVisitor6 this ^javax.lang.model.type.NoType t p]
    (-> this (.visitNoTypeAsNone t p))))

(defn visit-primitive-as-int
  "Visits an INT primitive type by calling
   defaultAction.

  t - the type to visit - `javax.lang.model.type.PrimitiveType`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^TypeKindVisitor6 this ^javax.lang.model.type.PrimitiveType t p]
    (-> this (.visitPrimitiveAsInt t p))))

(defn visit-primitive-as-boolean
  "Visits a BOOLEAN primitive type by calling
   defaultAction.

  t - the type to visit - `javax.lang.model.type.PrimitiveType`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^TypeKindVisitor6 this ^javax.lang.model.type.PrimitiveType t p]
    (-> this (.visitPrimitiveAsBoolean t p))))

(defn visit-primitive-as-byte
  "Visits a BYTE primitive type by calling
   defaultAction.

  t - the type to visit - `javax.lang.model.type.PrimitiveType`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^TypeKindVisitor6 this ^javax.lang.model.type.PrimitiveType t p]
    (-> this (.visitPrimitiveAsByte t p))))

(defn visit-no-type
  "Visits a NoType instance, dispatching to the visit method for
   the specific javax.lang.model.type.kind of pseudo-type:
   VOID, PACKAGE, or NONE.

  t - the type to visit - `javax.lang.model.type.NoType`
  p - a visitor-specified parameter - `P`

  returns: the result of the kind-specific visit method - `R`"
  ([^TypeKindVisitor6 this ^javax.lang.model.type.NoType t p]
    (-> this (.visitNoType t p))))

(defn visit-primitive
  "Visits a primitive type, dispatching to the visit method for
   the specific javax.lang.model.type.kind of primitive type:
   BOOLEAN, BYTE, etc.

  t - the type to visit - `javax.lang.model.type.PrimitiveType`
  p - a visitor-specified parameter - `P`

  returns: the result of the kind-specific visit method - `R`"
  ([^TypeKindVisitor6 this ^javax.lang.model.type.PrimitiveType t p]
    (-> this (.visitPrimitive t p))))

(defn visit-no-type-as-void
  "Visits a VOID pseudo-type by calling
   defaultAction.

  t - the type to visit - `javax.lang.model.type.NoType`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^TypeKindVisitor6 this ^javax.lang.model.type.NoType t p]
    (-> this (.visitNoTypeAsVoid t p))))

(defn visit-primitive-as-char
  "Visits a CHAR primitive type by calling
   defaultAction.

  t - the type to visit - `javax.lang.model.type.PrimitiveType`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^TypeKindVisitor6 this ^javax.lang.model.type.PrimitiveType t p]
    (-> this (.visitPrimitiveAsChar t p))))

(defn visit-primitive-as-short
  "Visits a SHORT primitive type by calling
   defaultAction.

  t - the type to visit - `javax.lang.model.type.PrimitiveType`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^TypeKindVisitor6 this ^javax.lang.model.type.PrimitiveType t p]
    (-> this (.visitPrimitiveAsShort t p))))

(defn visit-primitive-as-double
  "Visits a DOUBLE primitive type by calling
   defaultAction.

  t - the type to visit - `javax.lang.model.type.PrimitiveType`
  p - a visitor-specified parameter - `P`

  returns: the result of defaultAction - `R`"
  ([^TypeKindVisitor6 this ^javax.lang.model.type.PrimitiveType t p]
    (-> this (.visitPrimitiveAsDouble t p))))

