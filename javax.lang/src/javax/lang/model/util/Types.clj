(ns javax.lang.model.util.Types
  "Utility methods for operating on types.

  Compatibility Note: Methods may be added to this interface
  in future releases of the platform."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.util Types]))

(defn assignable?
  "Tests whether one type is assignable to another.

  t-1 - the first type - `javax.lang.model.type.TypeMirror`
  t-2 - the second type - `javax.lang.model.type.TypeMirror`

  returns: true if and only if the first type is assignable
            to the second - `boolean`

  throws: java.lang.IllegalArgumentException - if given an executable or package type"
  ([^. this ^javax.lang.model.type.TypeMirror t-1 ^javax.lang.model.type.TypeMirror t-2]
    (-> this (.isAssignable t-1 t-2))))

(defn erasure
  "Returns the erasure of a type.

  t - the type to be erased - `javax.lang.model.type.TypeMirror`

  returns: the erasure of the given type - `javax.lang.model.type.TypeMirror`

  throws: java.lang.IllegalArgumentException - if given a package type"
  ([^. this ^javax.lang.model.type.TypeMirror t]
    (-> this (.erasure t))))

(defn get-declared-type
  "Returns the type corresponding to a type element
   and actual type arguments, given a
   containing type
   of which it is a member.
   The parameterized type Outer<String>.Inner<Number>,
   for example, may be constructed by first using
   getDeclaredType(TypeElement, TypeMirror...)
   to get the type Outer<String>, and then invoking
   this method.

    If the containing type is a parameterized type,
   the number of type arguments must equal the
   number of typeElem's formal type parameters.
   If it is not parameterized or if it is null, this method is
   equivalent to getDeclaredType(typeElem, typeArgs).

  containing - the containing type, or null if none - `javax.lang.model.type.DeclaredType`
  type-elem - the type element - `javax.lang.model.element.TypeElement`
  type-args - the actual type arguments - `javax.lang.model.type.TypeMirror`

  returns: the type corresponding to the type element and
            actual type arguments, contained within the given type - `javax.lang.model.type.DeclaredType`

  throws: java.lang.IllegalArgumentException - if too many or too few type arguments are given, or if an inappropriate type argument, type element, or containing type is provided"
  ([^. this ^javax.lang.model.type.DeclaredType containing ^javax.lang.model.element.TypeElement type-elem ^javax.lang.model.type.TypeMirror type-args]
    (-> this (.getDeclaredType containing type-elem type-args)))
  ([^. this ^javax.lang.model.element.TypeElement type-elem ^javax.lang.model.type.TypeMirror type-args]
    (-> this (.getDeclaredType type-elem type-args))))

(defn get-array-type
  "Returns an array type with the specified component type.

  component-type - the component type - `javax.lang.model.type.TypeMirror`

  returns: an array type with the specified component type. - `javax.lang.model.type.ArrayType`

  throws: java.lang.IllegalArgumentException - if the component type is not valid for an array"
  ([^. this ^javax.lang.model.type.TypeMirror component-type]
    (-> this (.getArrayType component-type))))

(defn contains
  "Tests whether one type argument contains another.

  t-1 - the first type - `javax.lang.model.type.TypeMirror`
  t-2 - the second type - `javax.lang.model.type.TypeMirror`

  returns: true if and only if the first type contains the second - `boolean`

  throws: java.lang.IllegalArgumentException - if given an executable or package type"
  ([^. this ^javax.lang.model.type.TypeMirror t-1 ^javax.lang.model.type.TypeMirror t-2]
    (-> this (.contains t-1 t-2))))

(defn subtype?
  "Tests whether one type is a subtype of another.
   Any type is considered to be a subtype of itself.

  t-1 - the first type - `javax.lang.model.type.TypeMirror`
  t-2 - the second type - `javax.lang.model.type.TypeMirror`

  returns: true if and only if the first type is a subtype
            of the second - `boolean`

  throws: java.lang.IllegalArgumentException - if given an executable or package type"
  ([^. this ^javax.lang.model.type.TypeMirror t-1 ^javax.lang.model.type.TypeMirror t-2]
    (-> this (.isSubtype t-1 t-2))))

(defn get-wildcard-type
  "Returns a new wildcard type argument.  Either of the wildcard's
   bounds may be specified, or neither, but not both.

  extends-bound - the extends (upper) bound, or null if none - `javax.lang.model.type.TypeMirror`
  super-bound - the super (lower) bound, or null if none - `javax.lang.model.type.TypeMirror`

  returns: a new wildcard - `javax.lang.model.type.WildcardType`

  throws: java.lang.IllegalArgumentException - if bounds are not valid"
  ([^. this ^javax.lang.model.type.TypeMirror extends-bound ^javax.lang.model.type.TypeMirror super-bound]
    (-> this (.getWildcardType extends-bound super-bound))))

(defn boxed-class
  "Returns the class of a boxed value of a given primitive type.
   That is, boxing conversion is applied.

  p - the primitive type to be converted - `javax.lang.model.type.PrimitiveType`

  returns: the class of a boxed value of type p - `javax.lang.model.element.TypeElement`"
  ([^. this ^javax.lang.model.type.PrimitiveType p]
    (-> this (.boxedClass p))))

(defn same-type?
  "Tests whether two TypeMirror objects represent the same type.

   Caveat: if either of the arguments to this method represents a
   wildcard, this method will return false.  As a consequence, a wildcard
   is not the same type as itself.  This might be surprising at first,
   but makes sense once you consider that an example like this must be
   rejected by the compiler:


      List<?> list = new ArrayList<Object>();
      list.add(list.get(0));

   Since annotations are only meta-data associated with a type,
   the set of annotations on either argument is not taken
   into account when computing whether or not two TypeMirror objects are the same type. In particular, two
   TypeMirror objects can have different annotations and
   still be considered the same.

  t-1 - the first type - `javax.lang.model.type.TypeMirror`
  t-2 - the second type - `javax.lang.model.type.TypeMirror`

  returns: true if and only if the two types are the same - `boolean`"
  ([^. this ^javax.lang.model.type.TypeMirror t-1 ^javax.lang.model.type.TypeMirror t-2]
    (-> this (.isSameType t-1 t-2))))

(defn unboxed-type
  "Returns the type (a primitive type) of unboxed values of a given type.
   That is, unboxing conversion is applied.

  t - the type to be unboxed - `javax.lang.model.type.TypeMirror`

  returns: the type of an unboxed value of type t - `javax.lang.model.type.PrimitiveType`

  throws: java.lang.IllegalArgumentException - if the given type has no unboxing conversion"
  ([^. this ^javax.lang.model.type.TypeMirror t]
    (-> this (.unboxedType t))))

(defn as-member-of
  "Returns the type of an element when that element is viewed as
   a member of, or otherwise directly contained by, a given type.
   For example,
   when viewed as a member of the parameterized type Set<String>,
   the Set.add method is an ExecutableType
   whose parameter is of type String.

  containing - the containing type - `javax.lang.model.type.DeclaredType`
  element - the element - `javax.lang.model.element.Element`

  returns: the type of the element as viewed from the containing type - `javax.lang.model.type.TypeMirror`

  throws: java.lang.IllegalArgumentException - if the element is not a valid one for the given type"
  ([^. this ^javax.lang.model.type.DeclaredType containing ^javax.lang.model.element.Element element]
    (-> this (.asMemberOf containing element))))

(defn get-null-type
  "Returns the null type.  This is the type of null.

  returns: the null type - `javax.lang.model.type.NullType`"
  ([^. this]
    (-> this (.getNullType))))

(defn get-primitive-type
  "Returns a primitive type.

  kind - the kind of primitive type to return - `javax.lang.model.type.TypeKind`

  returns: a primitive type - `javax.lang.model.type.PrimitiveType`

  throws: java.lang.IllegalArgumentException - if kind is not a primitive kind"
  ([^. this ^javax.lang.model.type.TypeKind kind]
    (-> this (.getPrimitiveType kind))))

(defn capture
  "Applies capture conversion to a type.

  t - the type to be converted - `javax.lang.model.type.TypeMirror`

  returns: the result of applying capture conversion - `javax.lang.model.type.TypeMirror`

  throws: java.lang.IllegalArgumentException - if given an executable or package type"
  ([^. this ^javax.lang.model.type.TypeMirror t]
    (-> this (.capture t))))

(defn subsignature?
  "Tests whether the signature of one method is a subsignature
   of another.

  m-1 - the first method - `javax.lang.model.type.ExecutableType`
  m-2 - the second method - `javax.lang.model.type.ExecutableType`

  returns: true if and only if the first signature is a
            subsignature of the second - `boolean`"
  ([^. this ^javax.lang.model.type.ExecutableType m-1 ^javax.lang.model.type.ExecutableType m-2]
    (-> this (.isSubsignature m-1 m-2))))

(defn as-element
  "Returns the element corresponding to a type.
   The type may be a DeclaredType or TypeVariable.
   Returns null if the type is not one with a
   corresponding element.

  t - the type to map to an element - `javax.lang.model.type.TypeMirror`

  returns: the element corresponding to the given type - `javax.lang.model.element.Element`"
  ([^. this ^javax.lang.model.type.TypeMirror t]
    (-> this (.asElement t))))

(defn direct-supertypes
  "Returns the direct supertypes of a type.  The interface types, if any,
   will appear last in the list.

  t - the type being examined - `javax.lang.model.type.TypeMirror`

  returns: the direct supertypes, or an empty list if none - `java.util.List<? extends javax.lang.model.type.TypeMirror>`

  throws: java.lang.IllegalArgumentException - if given an executable or package type"
  ([^. this ^javax.lang.model.type.TypeMirror t]
    (-> this (.directSupertypes t))))

(defn get-no-type
  "Returns a pseudo-type used where no actual type is appropriate.
   The kind of type to return may be either
   VOID or NONE.
   For packages, use
   Elements.getPackageElement(CharSequence).asType()
   instead.

  kind - the kind of type to return - `javax.lang.model.type.TypeKind`

  returns: a pseudo-type of kind VOID or NONE - `javax.lang.model.type.NoType`

  throws: java.lang.IllegalArgumentException - if kind is not valid"
  ([^. this ^javax.lang.model.type.TypeKind kind]
    (-> this (.getNoType kind))))

