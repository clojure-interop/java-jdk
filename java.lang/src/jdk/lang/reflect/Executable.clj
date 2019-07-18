(ns jdk.lang.reflect.Executable
  "A shared superclass for the common functionality of Method
  and Constructor."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect Executable]))

(defn get-annotated-exception-types
  "Returns an array of AnnotatedType objects that represent the use
   of types to specify the declared exceptions of the method/constructor
   represented by this Executable. The order of the objects in the array
   corresponds to the order of the exception types in the declaration of
   the method/constructor.

   Returns an array of length 0 if the method/constructor declares no
   exceptions.

  returns: an array of objects representing the declared
   exceptions of the method or constructor represented by this Executable - `java.lang.reflect.AnnotatedType[]`"
  ([^Executable this]
    (-> this (.getAnnotatedExceptionTypes))))

(defn var-args?
  "Returns true if this executable was declared to take a
   variable number of arguments; returns false otherwise.

  returns: true if an only if this executable was declared
   to take a variable number of arguments. - `boolean`"
  (^Boolean [^Executable this]
    (-> this (.isVarArgs))))

(defn to-generic-string
  "Returns a string describing this Executable, including
   any type parameters.

  returns: a string describing this Executable, including
   any type parameters - `java.lang.String`"
  (^java.lang.String [^Executable this]
    (-> this (.toGenericString))))

(defn get-modifiers
  "Returns the Java language java.lang.reflect.modifiers for
   the executable represented by this object.

  returns: the Java language modifiers for the underlying member - `int`"
  (^Integer [^Executable this]
    (-> this (.getModifiers))))

(defn get-parameter-count
  "Returns the number of formal parameters (whether explicitly
   declared or implicitly declared or neither) for the executable
   represented by this object.

  returns: The number of formal parameters for the executable this
   object represents - `int`"
  (^Integer [^Executable this]
    (-> this (.getParameterCount))))

(defn get-exception-types
  "Returns an array of Class objects that represent the
   types of exceptions declared to be thrown by the underlying
   executable represented by this object.  Returns an array of
   length 0 if the executable declares no exceptions in its throws clause.

  returns: the exception types declared as being thrown by the
   executable this object represents - `java.lang.Class<?>[]`"
  ([^Executable this]
    (-> this (.getExceptionTypes))))

(defn synthetic?
  "Returns true if this executable is a synthetic
   construct; returns false otherwise.

  returns: true if and only if this executable is a synthetic
   construct as defined by
   The Java™ Language Specification. - `boolean`"
  (^Boolean [^Executable this]
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
  ([^Executable this]
    (-> this (.getGenericParameterTypes))))

(defn get-annotation
  "Returns this element's annotation for the specified type if
   such an annotation is present, else null.

  annotation-class - the Class object corresponding to the annotation type - `java.lang.Class`

  returns: this element's annotation for the specified annotation type if
       present on this element, else null - `<T extends java.lang.annotation.Annotation> T`

  throws: java.lang.NullPointerException - if the given annotation class is null"
  ([^Executable this ^java.lang.Class annotation-class]
    (-> this (.getAnnotation annotation-class))))

(defn get-parameters
  "Returns an array of Parameter objects that represent
   all the parameters to the underlying executable represented by
   this object.  Returns an array of length 0 if the executable
   has no parameters.

   The parameters of the underlying executable do not necessarily
   have unique names, or names that are legal identifiers in the
   Java programming language (JLS 3.8).

  returns: an array of Parameter objects representing all
   the parameters to the executable this object represents. - `java.lang.reflect.Parameter[]`

  throws: java.lang.reflect.MalformedParametersException - if the class file contains a MethodParameters attribute that is improperly formatted."
  ([^Executable this]
    (-> this (.getParameters))))

(defn get-declared-annotations
  "Returns annotations that are directly present on this element.
   This method ignores inherited annotations.

   If there are no annotations directly present on this element,
   the return value is an array of length 0.

   The caller of this method is free to modify the returned array; it will
   have no effect on the arrays returned to other callers.

  returns: annotations directly present on this element - `java.lang.annotation.Annotation[]`"
  ([^Executable this]
    (-> this (.getDeclaredAnnotations))))

(defn get-name
  "Returns the name of the executable represented by this object.

  returns: the simple name of the underlying member - `java.lang.String`"
  (^java.lang.String [^Executable this]
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
  ([^Executable this]
    (-> this (.getGenericExceptionTypes))))

(defn get-type-parameters
  "Returns an array of TypeVariable objects that represent the
   type variables declared by the generic declaration represented by this
   GenericDeclaration object, in declaration order.  Returns an
   array of length 0 if the underlying generic declaration declares no type
   variables.

  returns: an array of TypeVariable objects that represent
       the type variables declared by this generic declaration - `java.lang.reflect.TypeVariable<?>[]`

  throws: java.lang.reflect.GenericSignatureFormatError - if the generic signature of this generic declaration does not conform to the format specified in The Java™ Virtual Machine Specification"
  ([^Executable this]
    (-> this (.getTypeParameters))))

(defn get-parameter-types
  "Returns an array of Class objects that represent the formal
   parameter types, in declaration order, of the executable
   represented by this object.  Returns an array of length
   0 if the underlying executable takes no parameters.

  returns: the parameter types for the executable this object
   represents - `java.lang.Class<?>[]`"
  ([^Executable this]
    (-> this (.getParameterTypes))))

(defn get-annotated-parameter-types
  "Returns an array of AnnotatedType objects that represent the use
   of types to specify formal parameter types of the method/constructor
   represented by this Executable. The order of the objects in the array
   corresponds to the order of the formal parameter types in the
   declaration of the method/constructor.

   Returns an array of length 0 if the method/constructor declares no
   parameters.

  returns: an array of objects representing the types of the
   formal parameters of the method or constructor represented by this
   Executable - `java.lang.reflect.AnnotatedType[]`"
  ([^Executable this]
    (-> this (.getAnnotatedParameterTypes))))

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
  (^java.lang.reflect.AnnotatedType [^Executable this]
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
  (^java.lang.reflect.AnnotatedType [^Executable this]
    (-> this (.getAnnotatedReturnType))))

(defn get-annotations-by-type
  "Returns annotations that are associated with this element.

   If there are no annotations associated with this element, the return
   value is an array of length 0.

   The difference between this method and AnnotatedElement.getAnnotation(Class)
   is that this method detects if its argument is a repeatable
   annotation type (JLS 9.6), and if so, attempts to find one or
   more annotations of that type by `looking through` a container
   annotation.

   The caller of this method is free to modify the returned array; it will
   have no effect on the arrays returned to other callers.

  annotation-class - the Class object corresponding to the annotation type - `java.lang.Class`

  returns: all this element's annotations for the specified annotation type if
       associated with this element, else an array of length zero - `<T extends java.lang.annotation.Annotation> T[]`

  throws: java.lang.NullPointerException - if the given annotation class is null"
  ([^Executable this ^java.lang.Class annotation-class]
    (-> this (.getAnnotationsByType annotation-class))))

(defn get-declaring-class
  "Returns the Class object representing the class or interface
   that declares the executable represented by this object.

  returns: an object representing the declaring class of the
   underlying member - `java.lang.Class<?>`"
  (^java.lang.Class [^Executable this]
    (-> this (.getDeclaringClass))))

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
  ([^Executable this]
    (-> this (.getParameterAnnotations))))

