(ns jdk.lang.reflect.Method
  "A Method provides information about, and access to, a single method
  on a class or interface.  The reflected method may be a class method
  or an instance method (including an abstract method).

  A Method permits widening conversions to occur when matching the
  actual parameters to invoke with the underlying method's formal
  parameters, but it throws an IllegalArgumentException if a
  narrowing conversion would occur."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect Method]))

(defn invoke
  "Invokes the underlying method represented by this Method
   object, on the specified object with the specified parameters.
   Individual parameters are automatically unwrapped to match
   primitive formal parameters, and both primitive and reference
   parameters are subject to method invocation conversions as
   necessary.

   If the underlying method is static, then the specified obj
   argument is ignored. It may be null.

   If the number of formal parameters required by the underlying method is
   0, the supplied args array may be of length 0 or null.

   If the underlying method is an instance method, it is invoked
   using dynamic method lookup as documented in The Java Language
   Specification, Second Edition, section 15.12.4.4; in particular,
   overriding based on the runtime type of the target object will occur.

   If the underlying method is static, the class that declared
   the method is initialized if it has not already been initialized.

   If the method completes normally, the value it returns is
   returned to the caller of invoke; if the value has a primitive
   type, it is first appropriately wrapped in an object. However,
   if the value has the type of an array of a primitive type, the
   elements of the array are not wrapped in objects; in
   other words, an array of primitive type is returned.  If the
   underlying method return type is void, the invocation returns
   null.

  obj - the object the underlying method is invoked from - `java.lang.Object`
  args - the arguments used for the method call - `java.lang.Object`

  returns: the result of dispatching the method represented by
   this object on obj with parameters
   args - `java.lang.Object`

  throws: java.lang.IllegalAccessException - if this Method object is enforcing Java language access control and the underlying method is inaccessible."
  (^java.lang.Object [^java.lang.reflect.Method this ^java.lang.Object obj ^java.lang.Object args]
    (-> this (.invoke obj args))))

(defn get-generic-return-type
  "Returns a Type object that represents the formal return
   type of the method represented by this Method object.

   If the return type is a parameterized type,
   the Type object returned must accurately reflect
   the actual type parameters used in the source code.

   If the return type is a type variable or a parameterized type, it
   is created. Otherwise, it is resolved.

  returns: a Type object that represents the formal return
       type of the underlying  method - `java.lang.reflect.Type`

  throws: java.lang.reflect.GenericSignatureFormatError - if the generic method signature does not conform to the format specified in The Java™ Virtual Machine Specification"
  (^java.lang.reflect.Type [^java.lang.reflect.Method this]
    (-> this (.getGenericReturnType))))

(defn var-args?
  "Returns true if this executable was declared to take a
   variable number of arguments; returns false otherwise.

  returns: true if an only if this executable was declared
   to take a variable number of arguments. - `boolean`"
  (^Boolean [^java.lang.reflect.Method this]
    (-> this (.isVarArgs))))

(defn to-generic-string
  "Returns a string describing this Method, including
   type parameters.  The string is formatted as the method access
   modifiers, if any, followed by an angle-bracketed
   comma-separated list of the method's type parameters, if any,
   followed by the method's generic return type, followed by a
   space, followed by the class declaring the method, followed by
   a period, followed by the method name, followed by a
   parenthesized, comma-separated list of the method's generic
   formal parameter types.

   If this method was declared to take a variable number of
   arguments, instead of denoting the last parameter as
   `Type[]`, it is denoted as
   `Type...`.

   A space is used to separate access modifiers from one another
   and from the type parameters or return type.  If there are no
   type parameters, the type parameter list is elided; if the type
   parameter list is present, a space separates the list from the
   class name.  If the method is declared to throw exceptions, the
   parameter list is followed by a space, followed by the word
   throws followed by a comma-separated list of the generic thrown
   exception types.

   The access modifiers are placed in canonical order as
   specified by `The Java Language Specification`.  This is
   public, protected or private first,
   and then other modifiers in the following order:
   abstract, default, static, final,
   synchronized, native, strictfp.

  returns: a string describing this Method,
   include type parameters - `java.lang.String`"
  (^java.lang.String [^java.lang.reflect.Method this]
    (-> this (.toGenericString))))

(defn get-modifiers
  "Returns the Java language java.lang.reflect.modifiers for
   the executable represented by this object.

  returns: the Java language modifiers for the underlying member - `int`"
  (^Integer [^java.lang.reflect.Method this]
    (-> this (.getModifiers))))

(defn get-parameter-count
  "Returns the number of formal parameters (whether explicitly
   declared or implicitly declared or neither) for the executable
   represented by this object.

  returns: The number of formal parameters for the executable this
   object represents - `int`"
  (^Integer [^java.lang.reflect.Method this]
    (-> this (.getParameterCount))))

(defn get-exception-types
  "Returns an array of Class objects that represent the
   types of exceptions declared to be thrown by the underlying
   executable represented by this object.  Returns an array of
   length 0 if the executable declares no exceptions in its throws clause.

  returns: the exception types declared as being thrown by the
   executable this object represents - `java.lang.Class<?>[]`"
  ([^java.lang.reflect.Method this]
    (-> this (.getExceptionTypes))))

(defn synthetic?
  "Returns true if this executable is a synthetic
   construct; returns false otherwise.

  returns: true if and only if this executable is a synthetic
   construct as defined by
   The Java™ Language Specification. - `boolean`"
  (^Boolean [^java.lang.reflect.Method this]
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
  ([^java.lang.reflect.Method this]
    (-> this (.getGenericParameterTypes))))

(defn to-string
  "Returns a string describing this Method.  The string is
   formatted as the method access modifiers, if any, followed by
   the method return type, followed by a space, followed by the
   class declaring the method, followed by a period, followed by
   the method name, followed by a parenthesized, comma-separated
   list of the method's formal parameter types. If the method
   throws checked exceptions, the parameter list is followed by a
   space, followed by the word throws followed by a
   comma-separated list of the thrown exception types.
   For example:


      public boolean java.lang.Object.equals(java.lang.Object)

   The access modifiers are placed in canonical order as
   specified by `The Java Language Specification`.  This is
   public, protected or private first,
   and then other modifiers in the following order:
   abstract, default, static, final,
   synchronized, native, strictfp.

  returns: a string describing this Method - `java.lang.String`"
  (^java.lang.String [^java.lang.reflect.Method this]
    (-> this (.toString))))

(defn get-annotation
  "Returns this element's annotation for the specified type if
   such an annotation is present, else null.

  annotation-class - the Class object corresponding to the annotation type - `java.lang.Class<T>`

  returns: this element's annotation for the specified annotation type if
       present on this element, else null - `<T extends java.lang.annotation.Annotation> T`

  throws: java.lang.NullPointerException - if the given annotation class is null"
  ([^java.lang.reflect.Method this ^java.lang.Class annotation-class]
    (-> this (.getAnnotation annotation-class))))

(defn get-default-value
  "Returns the default value for the annotation member represented by
   this Method instance.  If the member is of a primitive type,
   an instance of the corresponding wrapper type is returned. Returns
   null if no default is associated with the member, or if the method
   instance does not represent a declared member of an annotation type.

  returns: the default value for the annotation member represented
       by this Method instance. - `java.lang.Object`

  throws: java.lang.TypeNotPresentException - if the annotation is of type Class and no definition can be found for the default class value."
  (^java.lang.Object [^java.lang.reflect.Method this]
    (-> this (.getDefaultValue))))

(defn bridge?
  "Returns true if this method is a bridge
   method; returns false otherwise.

  returns: true if and only if this method is a bridge
   method as defined by the Java Language Specification. - `boolean`"
  (^Boolean [^java.lang.reflect.Method this]
    (-> this (.isBridge))))

(defn get-declared-annotations
  "Returns annotations that are directly present on this element.
   This method ignores inherited annotations.

   If there are no annotations directly present on this element,
   the return value is an array of length 0.

   The caller of this method is free to modify the returned array; it will
   have no effect on the arrays returned to other callers.

  returns: annotations directly present on this element - `java.lang.annotation.Annotation[]`"
  ([^java.lang.reflect.Method this]
    (-> this (.getDeclaredAnnotations))))

(defn get-name
  "Returns the name of the method represented by this Method
   object, as a String.

  returns: the simple name of the underlying member - `java.lang.String`"
  (^java.lang.String [^java.lang.reflect.Method this]
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
  ([^java.lang.reflect.Method this]
    (-> this (.getGenericExceptionTypes))))

(defn get-type-parameters
  "Returns an array of TypeVariable objects that represent the
   type variables declared by the generic declaration represented by this
   GenericDeclaration object, in declaration order.  Returns an
   array of length 0 if the underlying generic declaration declares no type
   variables.

  returns: an array of TypeVariable objects that represent
       the type variables declared by this generic declaration - `java.lang.reflect.TypeVariable<java.lang.reflect.Method>[]`

  throws: java.lang.reflect.GenericSignatureFormatError - if the generic signature of this generic declaration does not conform to the format specified in The Java™ Virtual Machine Specification"
  ([^java.lang.reflect.Method this]
    (-> this (.getTypeParameters))))

(defn get-parameter-types
  "Returns an array of Class objects that represent the formal
   parameter types, in declaration order, of the executable
   represented by this object.  Returns an array of length
   0 if the underlying executable takes no parameters.

  returns: the parameter types for the executable this object
   represents - `java.lang.Class<?>[]`"
  ([^java.lang.reflect.Method this]
    (-> this (.getParameterTypes))))

(defn get-return-type
  "Returns a Class object that represents the formal return type
   of the method represented by this Method object.

  returns: the return type for the method this object represents - `java.lang.Class<?>`"
  (^java.lang.Class [^java.lang.reflect.Method this]
    (-> this (.getReturnType))))

(defn get-annotated-return-type
  "Returns an AnnotatedType object that represents the use of a type to
   specify the return type of the method/constructor represented by this
   Executable.

   If this Executable object represents a constructor, the AnnotatedType object represents the type of the constructed object.

   If this Executable object represents a method, the AnnotatedType object represents the use of a type to specify the return
   type of the method.

  returns: an object representing the return type of the method
   or constructor represented by this Executable - `java.lang.reflect.AnnotatedType`"
  (^java.lang.reflect.AnnotatedType [^java.lang.reflect.Method this]
    (-> this (.getAnnotatedReturnType))))

(defn get-declaring-class
  "Returns the Class object representing the class or interface
   that declares the executable represented by this object.

  returns: an object representing the declaring class of the
   underlying member - `java.lang.Class<?>`"
  (^java.lang.Class [^java.lang.reflect.Method this]
    (-> this (.getDeclaringClass))))

(defn hash-code
  "Returns a hashcode for this Method.  The hashcode is computed
   as the exclusive-or of the hashcodes for the underlying
   method's declaring class name and the method's name.

  returns: a hash code value for this object. - `int`"
  (^Integer [^java.lang.reflect.Method this]
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
  ([^java.lang.reflect.Method this]
    (-> this (.getParameterAnnotations))))

(defn default?
  "Returns true if this method is a default
   method; returns false otherwise.

   A default method is a public non-abstract instance method, that
   is, a non-static method with a body, declared in an interface
   type.

  returns: true if and only if this method is a default
   method as defined by the Java Language Specification. - `boolean`"
  (^Boolean [^java.lang.reflect.Method this]
    (-> this (.isDefault))))

(defn equals
  "Compares this Method against the specified object.  Returns
   true if the objects are the same.  Two Methods are the same if
   they were declared by the same class and have the same name
   and formal parameter types and return type.

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  (^Boolean [^java.lang.reflect.Method this ^java.lang.Object obj]
    (-> this (.equals obj))))

