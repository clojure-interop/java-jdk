(ns javax.lang.model.element.TypeElement
  "Represents a class or interface program element.  Provides access
  to information about the type and its members.  Note that an enum
  type is a kind of class and an annotation type is a kind of
  interface.


  While a TypeElement represents a class or interface
  element, a DeclaredType represents a class
  or interface type, the latter being a use
  (or invocation) of the former.
  The distinction is most apparent with generic types,
  for which a single element can define a whole
  family of types.  For example, the element
  java.util.Set corresponds to the parameterized types
  java.util.Set<String> and java.util.Set<Number>
  (and many others), and to the raw type java.util.Set.

   Each method of this interface that returns a list of elements
  will return them in the order that is natural for the underlying
  source of program information.  For example, if the underlying
  source of information is Java source code, then the elements will be
  returned in source code order."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.element TypeElement]))

(defn get-enclosed-elements
  "Returns the fields, methods, constructors, and member types
   that are directly declared in this class or interface.

   This includes any (implicit) default constructor and
   the implicit values and valueOf methods of an
   enum type.

    Note that as a particular instance of the general accuracy requirements and the
   ordering behavior required of this interface, the list of
   enclosed elements will be returned in the natural order for the
   originating source of information about the type.  For example,
   if the information about the type is originating from a source
   file, the elements will be returned in source code order.
   (However, in that case the the ordering of synthesized
   elements, such as a default constructor, is not specified.)

  returns: the enclosed elements in proper order, or an empty list if none - `java.util.List<? extends javax.lang.model.element.Element>`"
  ([this]
    (-> this (.getEnclosedElements))))

(defn get-nesting-kind
  "Returns the nesting kind of this type element.

  returns: the nesting kind of this type element - `javax.lang.model.element.NestingKind`"
  ([this]
    (-> this (.getNestingKind))))

(defn get-qualified-name
  "Returns the fully qualified name of this type element.
   More precisely, it returns the canonical name.
   For local and anonymous classes, which do not have canonical names,
   an empty name is returned.

   The name of a generic type does not include any reference
   to its formal type parameters.
   For example, the fully qualified name of the interface
   java.util.Set<E> is `java.util.Set`.
   Nested types use `.` as a separator, as in
   `java.util.Map.Entry`.

  returns: the fully qualified name of this class or interface, or
   an empty name if none - `javax.lang.model.element.Name`"
  ([this]
    (-> this (.getQualifiedName))))

(defn get-simple-name
  "Returns the simple name of this type element.

   For an anonymous class, an empty name is returned.

  returns: the simple name of this class or interface,
   an empty name for an anonymous class - `javax.lang.model.element.Name`"
  ([this]
    (-> this (.getSimpleName))))

(defn get-superclass
  "Returns the direct superclass of this type element.
   If this type element represents an interface or the class
   java.lang.Object, then a NoType
   with kind NONE is returned.

  returns: the direct superclass, or a NoType if there is none - `javax.lang.model.type.TypeMirror`"
  ([this]
    (-> this (.getSuperclass))))

(defn get-interfaces
  "Returns the interface types directly implemented by this class
   or extended by this interface.

  returns: the interface types directly implemented by this class
   or extended by this interface, or an empty list if there are none - `java.util.List<? extends javax.lang.model.type.TypeMirror>`"
  ([this]
    (-> this (.getInterfaces))))

(defn get-type-parameters
  "Returns the formal type parameters of this type element
   in declaration order.

  returns: the formal type parameters, or an empty list
   if there are none - `java.util.List<? extends javax.lang.model.element.TypeParameterElement>`"
  ([this]
    (-> this (.getTypeParameters))))

(defn get-enclosing-element
  "Returns the package of a top-level type and returns the
   immediately lexically enclosing element for a nested type.

  returns: the package of a top-level type, the immediately
   lexically enclosing element for a nested type - `javax.lang.model.element.Element`"
  ([this]
    (-> this (.getEnclosingElement))))

