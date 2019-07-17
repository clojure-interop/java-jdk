(ns javax.lang.model.type.DeclaredType
  "Represents a declared type, either a class type or an interface type.
  This includes parameterized types such as java.util.Set<String>
  as well as raw types.

   While a TypeElement represents a class or interface
  element, a DeclaredType represents a class
  or interface type, the latter being a use
  (or invocation) of the former.
  See TypeElement for more on this distinction.

   The supertypes (both class and interface types) of a declared
  type may be found using the Types.directSupertypes(TypeMirror) method.  This returns the
  supertypes with any type arguments substituted in."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.type DeclaredType]))

(defn as-element
  "Returns the element corresponding to this type.

  returns: the element corresponding to this type - `javax.lang.model.element.Element`"
  (^javax.lang.model.element.Element [^javax.lang.model.type.DeclaredType this]
    (-> this (.asElement))))

(defn get-enclosing-type
  "Returns the type of the innermost enclosing instance or a
   NoType of kind NONE if there is no enclosing
   instance.  Only types corresponding to inner classes have an
   enclosing instance.

  returns: a type mirror for the enclosing type - `javax.lang.model.type.TypeMirror`"
  (^javax.lang.model.type.TypeMirror [^javax.lang.model.type.DeclaredType this]
    (-> this (.getEnclosingType))))

(defn get-type-arguments
  "Returns the actual type arguments of this type.
   For a type nested within a parameterized type
   (such as Outer<String>.Inner<Number>), only the type
   arguments of the innermost type are included.

  returns: the actual type arguments of this type, or an empty list
             if none - `java.util.List<? extends javax.lang.model.type.TypeMirror>`"
  ([^javax.lang.model.type.DeclaredType this]
    (-> this (.getTypeArguments))))

