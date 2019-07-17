(ns jdk.lang.invoke.MethodHandleInfo
  "A symbolic reference obtained by cracking a direct method handle
  into its consitutent symbolic parts.
  To crack a direct method handle, call Lookup.revealDirect.
  Direct Method Handles
  A direct method handle represents a method, constructor, or field without
  any intervening argument bindings or other transformations.
  The method, constructor, or field referred to by a direct method handle is called
  its underlying member.
  Direct method handles may be obtained in any of these ways:

  By executing an ldc instruction on a CONSTANT_MethodHandle constant.
      (See the Java Virtual Machine Specification, sections 4.4.8 and 5.4.3.)
  By calling one of the Lookup Factory Methods,
      such as Lookup.findVirtual,
      to resolve a symbolic reference into a method handle.
      A symbolic reference consists of a class, name string, and type.
  By calling the factory method Lookup.unreflect
      or Lookup.unreflectSpecial
      to convert a Method into a method handle.
  By calling the factory method Lookup.unreflectConstructor
      to convert a Constructor into a method handle.
  By calling the factory method Lookup.unreflectGetter
      or Lookup.unreflectSetter
      to convert a Field into a method handle.


  Restrictions on Cracking
  Given a suitable Lookup object, it is possible to crack any direct method handle
  to recover a symbolic reference for the underlying method, constructor, or field.
  Cracking must be done via a Lookup object equivalent to that which created
  the target method handle, or which has enough access permissions to recreate
  an equivalent method handle.

  If the underlying method is caller sensitive,
  the direct method handle will have been `bound` to a particular caller class, the
  lookup class
  of the lookup object used to create it.
  Cracking this method handle with a different lookup class will fail
  even if the underlying method is public (like Class.forName).

  The requirement of lookup object matching provides a `fast fail` behavior
  for programs which may otherwise trust erroneous revelation of a method
  handle with symbolic information (or caller binding) from an unexpected scope.
  Use MethodHandles.reflectAs(java.lang.Class<T>, java.lang.invoke.MethodHandle) to override this limitation.

  Reference kinds
  The Lookup Factory Methods
  correspond to all major use cases for methods, constructors, and fields.
  These use cases may be distinguished using small integers as follows:

  reference kinddescriptive namescopememberbehavior

      1REF_getFieldclass
      FT f;(T) this.f;


      2REF_getStaticclass or interface
      staticFT f;(T) C.f;


      3REF_putFieldclass
      FT f;this.f = x;


      4REF_putStaticclass
      staticFT f;C.f = arg;


      5REF_invokeVirtualclass
      T m(A*);(T) this.m(arg*);


      6REF_invokeStaticclass or interface
      staticT m(A*);(T) C.m(arg*);


      7REF_invokeSpecialclass or interface
      T m(A*);(T) super.m(arg*);


      8REF_newInvokeSpecialclass
      C(A*);new C(arg*);


      9REF_invokeInterfaceinterface
      T m(A*);(T) this.m(arg*);"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.invoke MethodHandleInfo]))

(defn *reference-kind-to-string
  "Returns the descriptive name of the given reference kind,
   as defined in the table above.
   The conventional prefix `REF_` is omitted.

  reference-kind - an integer code for a kind of reference used to access a class member - `int`

  returns: a mixed-case string such as `getField` - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the argument is not a valid reference kind number"
  (^java.lang.String [^Integer reference-kind]
    (MethodHandleInfo/referenceKindToString reference-kind)))

(defn reflect-as
  "Reflects the underlying member as a method, constructor, or field object.
   If the underlying member is public, it is reflected as if by
   getMethod, getConstructor, or getField.
   Otherwise, it is reflected as if by
   getDeclaredMethod, getDeclaredConstructor, or getDeclaredField.
   The underlying member must be accessible to the given lookup object.

  expected - a class object representing the desired result type T - `java.lang.Class<T>`
  lookup - the lookup object that created this MethodHandleInfo, or one with equivalent access privileges - `java.lang.invoke.MethodHandles.Lookup`

  returns: a reference to the method, constructor, or field object - `<T extends java.lang.reflect.Member> T`

  throws: java.lang.ClassCastException - if the member is not of the expected type"
  ([^java.lang.invoke.MethodHandleInfo this ^java.lang.Class expected ^java.lang.invoke.MethodHandles.Lookup lookup]
    (-> this (.reflectAs expected lookup))))

(defn is-var-args
  "Determines if the underlying member was a variable arity method or constructor.
   Such members are represented by method handles that are varargs collectors.

  returns: true if and only if the underlying member was declared with variable arity. - `default boolean`"
  ([^java.lang.invoke.MethodHandleInfo this]
    (-> this (.isVarArgs))))

(defn get-modifiers
  "Returns the access modifiers of the underlying member.

  returns: the Java language modifiers for underlying member,
           or -1 if the member cannot be accessed - `int`"
  (^Integer [^java.lang.invoke.MethodHandleInfo this]
    (-> this (.getModifiers))))

(defn *to-string
  "Returns a string representation for a MethodHandleInfo,
   given the four parts of its symbolic reference.
   This is defined to be of the form `RK C.N:MT`, where RK is the
   reference kind string for kind,
   C is the name of defc
   N is the name, and
   MT is the type.
   These four values may be obtained from the
   reference kind,
   declaring class,
   member name,
   and method type
   of a MethodHandleInfo object.

  kind - the reference kind part of the symbolic reference - `int`
  defc - the declaring class part of the symbolic reference - `java.lang.Class<?>`
  name - the member name part of the symbolic reference - `java.lang.String`
  type - the method type part of the symbolic reference - `java.lang.invoke.MethodType`

  returns: a string of the form `RK C.N:MT` - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the first argument is not a valid reference kind number"
  (^java.lang.String [^Integer kind ^java.lang.Class defc ^java.lang.String name ^java.lang.invoke.MethodType type]
    (MethodHandleInfo/toString kind defc name type)))

(defn get-name
  "Returns the name of the cracked method handle's underlying member.
   This is `<init>` if the underlying member was a constructor,
   else it is a simple method name or field name.

  returns: the simple name of the underlying member - `java.lang.String`"
  (^java.lang.String [^java.lang.invoke.MethodHandleInfo this]
    (-> this (.getName))))

(defn get-method-type
  "Returns the nominal type of the cracked symbolic reference, expressed as a method type.
   If the reference is to a constructor, the return type will be void.
   If it is to a non-static method, the method type will not mention the this parameter.
   If it is to a field and the requested access is to read the field,
   the method type will have no parameters and return the field type.
   If it is to a field and the requested access is to write the field,
   the method type will have one parameter of the field type and return void.

   Note that original direct method handle may include a leading this parameter,
   or (in the case of a constructor) will replace the void return type
   with the constructed class.
   The nominal type does not include any this parameter,
   and (in the case of a constructor) will return void.

  returns: the type of the underlying member, expressed as a method type - `java.lang.invoke.MethodType`"
  (^java.lang.invoke.MethodType [^java.lang.invoke.MethodHandleInfo this]
    (-> this (.getMethodType))))

(defn get-reference-kind
  "Returns the reference kind of the cracked method handle, which in turn
   determines whether the method handle's underlying member was a constructor, method, or field.
   See the table above for definitions.

  returns: the integer code for the kind of reference used to access the underlying member - `int`"
  (^Integer [^java.lang.invoke.MethodHandleInfo this]
    (-> this (.getReferenceKind))))

(defn get-declaring-class
  "Returns the class in which the cracked method handle's underlying member was defined.

  returns: the declaring class of the underlying member - `java.lang.Class<?>`"
  (^java.lang.Class [^java.lang.invoke.MethodHandleInfo this]
    (-> this (.getDeclaringClass))))

