(ns javax.lang.model.element.Element
  "Represents a program element such as a package, class, or method.
  Each element represents a static, language-level construct
  (and not, for example, a runtime construct of the virtual machine).

   Elements should be compared using the equals(Object)
  method.  There is no guarantee that any particular element will
  always be represented by the same object.

   To implement operations based on the class of an Element object, either use a javax.lang.model.element.visitor or
  use the result of the getKind() method.  Using instanceof is not necessarily a reliable idiom for
  determining the effective class of an object in this modeling
  hierarchy since an implementation may choose to have a single object
  implement multiple Element subinterfaces."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.element Element]))

(defn get-enclosing-element
  "Returns the innermost element
   within which this element is, loosely speaking, enclosed.

    If this element is one whose declaration is lexically enclosed
   immediately within the declaration of another element, that other
   element is returned.

    If this is a top-level type, its package is returned.

    If this is a package, null is
   returned.

    If this is a type parameter,
   the
   generic element of the type parameter is returned.

    If this is a method or constructor
   parameter, javax.lang.model.element.the executable
   element which declares the parameter is returned.

  returns: the enclosing element, or null if there is none - `javax.lang.model.element.Element`"
  ([this]
    (-> this (.getEnclosingElement))))

(defn get-annotation-mirrors
  "Returns the annotations that are directly present on
   this construct.

    To get inherited annotations as well, use getAllAnnotationMirrors.

  returns: the annotations directly present on this
   construct; an empty list if there are none - `java.util.List<? extends javax.lang.model.element.AnnotationMirror>`"
  ([this]
    (-> this (.getAnnotationMirrors))))

(defn get-kind
  "Returns the kind of this element.

  returns: the kind of this element - `javax.lang.model.element.ElementKind`"
  ([this]
    (-> this (.getKind))))

(defn get-enclosed-elements
  "Returns the elements that are, loosely speaking, directly
   enclosed by this element.

   A class or
   interface is considered to enclose the fields, methods,
   constructors, and member types that it directly declares.

   A package
   encloses the top-level classes and interfaces within it, but is
   not considered to enclose subpackages.

   Other kinds of elements are not currently considered to enclose
   any elements; however, that may change as this API or the
   programming language evolves.

   Note that elements of certain kinds can be isolated using
   methods in ElementFilter.

  returns: the enclosed elements, or an empty list if none - `java.util.List<? extends javax.lang.model.element.Element>`"
  ([this]
    (-> this (.getEnclosedElements))))

(defn get-modifiers
  "Returns the modifiers of this element, excluding annotations.
   Implicit modifiers, such as the public and static
   modifiers of interface members, are included.

  returns: the modifiers of this element, or an empty set if there are none - `java.util.Set<javax.lang.model.element.Modifier>`"
  ([this]
    (-> this (.getModifiers))))

(defn as-type
  "Returns the type defined by this element.

    A generic element defines a family of types, not just one.
   If this is a generic element, a prototypical type is
   returned.  This is the element's invocation on the
   type variables corresponding to its own formal type parameters.
   For example,
   for the generic class element C<N extends Number>,
   the parameterized type C<N> is returned.
   The Types utility interface has more general methods
   for obtaining the full range of types defined by an element.

  returns: the type defined by this element - `javax.lang.model.type.TypeMirror`"
  ([this]
    (-> this (.asType))))

(defn get-annotation
  "Returns this construct's annotation of the specified type if
   such an annotation is present, else null.

    The annotation returned by this method could contain an element
   whose value is of type Class.
   This value cannot be returned directly:  information necessary to
   locate and load a class (such as the class loader to use) is
   not available, and the class might not be loadable at all.
   Attempting to read a Class object by invoking the relevant
   method on the returned annotation
   will result in a MirroredTypeException,
   from which the corresponding TypeMirror may be extracted.
   Similarly, attempting to read a Class[]-valued element
   will result in a MirroredTypesException.


   Note: This method is unlike others in this and related
   interfaces.  It operates on runtime reflective information —
   representations of annotation types currently loaded into the
   VM — rather than on the representations defined by and used
   throughout these interfaces.  Consequently, calling methods on
   the returned annotation object can throw many of the exceptions
   that can be thrown when calling methods on an annotation object
   returned by core reflection.  This method is intended for
   callers that are written to operate on a known, fixed set of
   annotation types.

  annotation-type - the Class object corresponding to the annotation type - `java.lang.Class<A>`

  returns: this construct's annotation for the specified
   annotation type if present, else null - `<A extends java.lang.annotation.Annotation> A`"
  ([this annotation-type]
    (-> this (.getAnnotation annotation-type))))

(defn accept
  "Applies a visitor to this element.

  v - the visitor operating on this element - `javax.lang.model.element.ElementVisitor<R,P>`
  p - additional parameter to the visitor - `P`

  returns: a visitor-specified result - `<R,P> R`"
  ([this v p]
    (-> this (.accept v p))))

(defn hash-code
  "Obeys the general contract of Object.hashCode.

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn get-simple-name
  "Returns the simple (unqualified) name of this element.  The
   name of a generic type does not include any reference to its
   formal type parameters.

   For example, the simple name of the type element java.util.Set<E> is `Set`.

   If this element represents an unnamed package, an empty name is
   returned.

   If it represents a constructor, the name `<init>` is returned.  If it
   represents a static
   initializer, the name `<clinit>` is returned.

   If it represents an anonymous class or instance initializer, an empty name is returned.

  returns: the simple name of this element - `javax.lang.model.element.Name`"
  ([this]
    (-> this (.getSimpleName))))

(defn equals
  "Returns true if the argument represents the same
   element as this, or false otherwise.

   Note that the identity of an element involves implicit state
   not directly accessible from the element's methods, including
   state about the presence of unrelated types.  Element objects
   created by different implementations of these interfaces should
   not be expected to be equal even if `the same`
   element is being modeled; this is analogous to the inequality
   of Class objects for the same class file loaded through
   different class loaders.

  obj - the object to be compared with this element - `java.lang.Object`

  returns: true if the specified object represents the same
            element as this - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

