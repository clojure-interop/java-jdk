(ns jdk.lang.reflect.Constructor
  "Constructor provides information about, and access to, a single
  constructor for a class.

  Constructor permits widening conversions to occur when matching the
  actual parameters to newInstance() with the underlying
  constructor's formal parameters, but throws an
  IllegalArgumentException if a narrowing conversion would occur."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect Constructor]))

(defn new-instance
  "Uses the constructor represented by this Constructor object to
   create and initialize a new instance of the constructor's
   declaring class, with the specified initialization parameters.
   Individual parameters are automatically unwrapped to match
   primitive formal parameters, and both primitive and reference
   parameters are subject to method invocation conversions as necessary.

   If the number of formal parameters required by the underlying constructor
   is 0, the supplied initargs array may be of length 0 or null.

   If the constructor's declaring class is an inner class in a
   non-static context, the first argument to the constructor needs
   to be the enclosing instance; see section 15.9.3 of
   The Java™ Language Specification.

   If the required access and argument checks succeed and the
   instantiation will proceed, the constructor's declaring class
   is initialized if it has not already been initialized.

   If the constructor completes normally, returns the newly
   created and initialized instance.

  initargs - array of objects to be passed as arguments to the constructor call; values of primitive types are wrapped in a wrapper object of the appropriate type (e.g. a float in a Float) - `java.lang.Object`

  returns: a new object created by calling the constructor
   this object represents - `Constructor.T`

  throws: java.lang.IllegalAccessException - if this Constructor object is enforcing Java language access control and the underlying constructor is inaccessible."
  (^Constructor.T [^java.lang.reflect.Constructor this ^java.lang.Object initargs]
    (-> this (.newInstance initargs))))

(defn var-args?
  "Returns true if this executable was declared to take a
   variable number of arguments; returns false otherwise.

  returns: true if an only if this executable was declared
   to take a variable number of arguments. - `boolean`"
  (^Boolean [^java.lang.reflect.Constructor this]
    (-> this (.isVarArgs))))

(defn to-generic-string
  "Returns a string describing this Constructor,
   including type parameters.  The string is formatted as the
   constructor access modifiers, if any, followed by an
   angle-bracketed comma separated list of the constructor's type
   parameters, if any, followed by the fully-qualified name of the
   declaring class, followed by a parenthesized, comma-separated
   list of the constructor's generic formal parameter types.

   If this constructor was declared to take a variable number of
   arguments, instead of denoting the last parameter as
   `Type[]`, it is denoted as
   `Type...`.

   A space is used to separate access modifiers from one another
   and from the type parameters or return type.  If there are no
   type parameters, the type parameter list is elided; if the type
   parameter list is present, a space separates the list from the
   class name.  If the constructor is declared to throw
   exceptions, the parameter list is followed by a space, followed
   by the word `throws` followed by a
   comma-separated list of the thrown exception types.

   The only possible modifiers for constructors are the access
   modifiers public, protected or
   private.  Only one of these may appear, or none if the
   constructor has default (package) access.

  returns: a string describing this Constructor,
   include type parameters - `java.lang.String`"
  (^java.lang.String [^java.lang.reflect.Constructor this]
    (-> this (.toGenericString))))

(defn get-modifiers
  "Returns the Java language java.lang.reflect.modifiers for
   the executable represented by this object.

  returns: the Java language modifiers for the underlying member - `int`"
  (^Integer [^java.lang.reflect.Constructor this]
    (-> this (.getModifiers))))

(defn get-parameter-count
  "Returns the number of formal parameters (whether explicitly
   declared or implicitly declared or neither) for the executable
   represented by this object.

  returns: The number of formal parameters for the executable this
   object represents - `int`"
  (^Integer [^java.lang.reflect.Constructor this]
    (-> this (.getParameterCount))))

(defn get-exception-types
  "Returns an array of Class objects that represent the
   types of exceptions declared to be thrown by the underlying
   executable represented by this object.  Returns an array of
   length 0 if the executable declares no exceptions in its throws clause.

  returns: the exception types declared as being thrown by the
   executable this object represents - `java.lang.Class<?>[]`"
  ([^java.lang.reflect.Constructor this]
    (-> this (.getExceptionTypes))))

(defn synthetic?
  "Returns true if this executable is a synthetic
   construct; returns false otherwise.

  returns: true if and only if this executable is a synthetic
   construct as defined by
   The Java™ Language Specification. - `boolean`"
  (^Boolean [^java.lang.reflect.Constructor this]
    (-> this (.isSynthetic))))

(defn get-generic-parameter-types
  "Returns an array of Type objects that represent the formal
   parameter types, in declaration order, of the executable represented by
   this object. Returns an array of length 0 if the
   underlying executable takes no parameters.

   If a formal parameter type is a parameterized type,
   the Type object returned for it must accurately reflect
   the actual type parameters used in the source code.

   If a formal parameter type is a type variable or a parameterized
   type, it is created. Otherwise, it is resolved.

  returns: an array of Types that represent the formal
       parameter types of the underlying executable, in declaration order - `java.lang.reflect.Type[]`

  throws: java.lang.reflect.GenericSignatureFormatError - if the generic method signature does not conform to the format specified in The Java™ Virtual Machine Specification"
  ([^java.lang.reflect.Constructor this]
    (-> this (.getGenericParameterTypes))))

(defn to-string
  "Returns a string describing this Constructor.  The string is
   formatted as the constructor access modifiers, if any,
   followed by the fully-qualified name of the declaring class,
   followed by a parenthesized, comma-separated list of the
   constructor's formal parameter types.  For example:


      public java.util.Hashtable(int,float)

   The only possible modifiers for constructors are the access
   modifiers public, protected or
   private.  Only one of these may appear, or none if the
   constructor has default (package) access.

  returns: a string describing this Constructor - `java.lang.String`"
  (^java.lang.String [^java.lang.reflect.Constructor this]
    (-> this (.toString))))

(defn get-annotation
  "Returns this element's annotation for the specified type if
   such an annotation is present, else null.

  annotation-class - the Class object corresponding to the annotation type - `java.lang.Class<T>`

  returns: this element's annotation for the specified annotation type if
       present on this element, else null - `<T extends java.lang.annotation.Annotation> T`

  throws: java.lang.NullPointerException - if the given annotation class is null"
  ([^java.lang.reflect.Constructor this ^java.lang.Class annotation-class]
    (-> this (.getAnnotation annotation-class))))

(defn get-declared-annotations
  "Returns annotations that are directly present on this element.
   This method ignores inherited annotations.

   If there are no annotations directly present on this element,
   the return value is an array of length 0.

   The caller of this method is free to modify the returned array; it will
   have no effect on the arrays returned to other callers.

  returns: annotations directly present on this element - `java.lang.annotation.Annotation[]`"
  ([^java.lang.reflect.Constructor this]
    (-> this (.getDeclaredAnnotations))))

(defn get-name
  "Returns the name of this constructor, as a string.  This is
   the binary name of the constructor's declaring class.

  returns: the simple name of the underlying member - `java.lang.String`"
  (^java.lang.String [^java.lang.reflect.Constructor this]
    (-> this (.getName))))

(defn get-generic-exception-types
  "Returns an array of Type objects that represent the
   exceptions declared to be thrown by this executable object.
   Returns an array of length 0 if the underlying executable declares
   no exceptions in its throws clause.

   If an exception type is a type variable or a parameterized
   type, it is created. Otherwise, it is resolved.

  returns: an array of Types that represent the exception types
       thrown by the underlying executable - `java.lang.reflect.Type[]`

  throws: java.lang.reflect.GenericSignatureFormatError - if the generic method signature does not conform to the format specified in The Java™ Virtual Machine Specification"
  ([^java.lang.reflect.Constructor this]
    (-> this (.getGenericExceptionTypes))))

(defn get-type-parameters
  "Returns an array of TypeVariable objects that represent the
   type variables declared by the generic declaration represented by this
   GenericDeclaration object, in declaration order.  Returns an
   array of length 0 if the underlying generic declaration declares no type
   variables.

  returns: an array of TypeVariable objects that represent
       the type variables declared by this generic declaration - `java.lang.reflect.TypeVariable<java.lang.reflect.Constructor<Constructor.T>>[]`

  throws: java.lang.reflect.GenericSignatureFormatError - if the generic signature of this generic declaration does not conform to the format specified in The Java™ Virtual Machine Specification"
  ([^java.lang.reflect.Constructor this]
    (-> this (.getTypeParameters))))

(defn get-parameter-types
  "Returns an array of Class objects that represent the formal
   parameter types, in declaration order, of the executable
   represented by this object.  Returns an array of length
   0 if the underlying executable takes no parameters.

  returns: the parameter types for the executable this object
   represents - `java.lang.Class<?>[]`"
  ([^java.lang.reflect.Constructor this]
    (-> this (.getParameterTypes))))

(defn get-annotated-receiver-type
  "Returns an AnnotatedType object that represents the use of a
   type to specify the receiver type of the method/constructor represented
   by this Executable object. The receiver type of a method/constructor is
   available only if the method/constructor has a receiver
   parameter (JLS 8.4.1).

   If this Executable object represents a constructor or instance
   method that does not have a receiver parameter, or has a receiver
   parameter with no annotations on its type, then the return value is an
   AnnotatedType object representing an element with no
   annotations.

   If this Executable object represents a static method, then the
   return value is null.

  returns: an object representing the receiver type of the method or
   constructor represented by this Executable - `java.lang.reflect.AnnotatedType`"
  (^java.lang.reflect.AnnotatedType [^java.lang.reflect.Constructor this]
    (-> this (.getAnnotatedReceiverType))))

(defn get-annotated-return-type
  "Returns an AnnotatedType object that represents the use of a type to
   specify the return type of the method/constructor represented by this
   Executable.

   If this Executable object represents a constructor, the AnnotatedType object represents the type of the constructed object.

   If this Executable object represents a method, the AnnotatedType object represents the use of a type to specify the return
   type of the method.

  returns: an object representing the return type of the method
   or constructor represented by this Executable - `java.lang.reflect.AnnotatedType`"
  (^java.lang.reflect.AnnotatedType [^java.lang.reflect.Constructor this]
    (-> this (.getAnnotatedReturnType))))

(defn get-declaring-class
  "Returns the Class object representing the class or interface
   that declares the executable represented by this object.

  returns: an object representing the declaring class of the
   underlying member - `java.lang.Class<Constructor.T>`"
  (^java.lang.Class [^java.lang.reflect.Constructor this]
    (-> this (.getDeclaringClass))))

(defn hash-code
  "Returns a hashcode for this Constructor. The hashcode is
   the same as the hashcode for the underlying constructor's
   declaring class name.

  returns: a hash code value for this object. - `int`"
  (^Integer [^java.lang.reflect.Constructor this]
    (-> this (.hashCode))))

(defn get-parameter-annotations
  "Returns an array of arrays of Annotations that
   represent the annotations on the formal parameters, in
   declaration order, of the Executable represented by
   this object.  Synthetic and mandated parameters (see
   explanation below), such as the outer `this` parameter to an
   inner class constructor will be represented in the returned
   array.  If the executable has no parameters (meaning no formal,
   no synthetic, and no mandated parameters), a zero-length array
   will be returned.  If the Executable has one or more
   parameters, a nested array of length zero is returned for each
   parameter with no annotations. The annotation objects contained
   in the returned arrays are serializable.  The caller of this
   method is free to modify the returned arrays; it will have no
   effect on the arrays returned to other callers.

   A compiler may add extra parameters that are implicitly
   declared in source (`mandated`), as well as parameters that
   are neither implicitly nor explicitly declared in source
   (`synthetic`) to the parameter list for a method.  See Parameter for more information.

  returns: an array of arrays that represent the annotations on
      the formal and implicit parameters, in declaration order, of
      the executable represented by this object - `java.lang.annotation.Annotation[][]`"
  ([^java.lang.reflect.Constructor this]
    (-> this (.getParameterAnnotations))))

(defn equals
  "Compares this Constructor against the specified object.
   Returns true if the objects are the same.  Two Constructor objects are
   the same if they were declared by the same class and have the
   same formal parameter types.

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  (^Boolean [^java.lang.reflect.Constructor this ^java.lang.Object obj]
    (-> this (.equals obj))))

