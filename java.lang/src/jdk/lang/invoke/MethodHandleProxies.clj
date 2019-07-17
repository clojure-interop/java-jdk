(ns jdk.lang.invoke.MethodHandleProxies
  "This class consists exclusively of static methods that help adapt
  method handles to other JVM types, such as interfaces."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.invoke MethodHandleProxies]))

(defn *as-interface-instance
  "Produces an instance of the given single-method interface which redirects
   its calls to the given method handle.

   A single-method interface is an interface which declares a uniquely named method.
   When determining the uniquely named method of a single-method interface,
   the public Object methods (toString, equals, hashCode)
   are disregarded.  For example, Comparator is a single-method interface,
   even though it re-declares the Object.equals method.

   The interface must be public.  No additional access checks are performed.

   The resulting instance of the required type will respond to
   invocation of the type's uniquely named method by calling
   the given target on the incoming arguments,
   and returning or throwing whatever the target
   returns or throws.  The invocation will be as if by
   target.invoke.
   The target's type will be checked before the
   instance is created, as if by a call to asType,
   which may result in a WrongMethodTypeException.

   The uniquely named method is allowed to be multiply declared,
   with distinct type descriptors.  (E.g., it can be overloaded,
   or can possess bridge methods.)  All such declarations are
   connected directly to the target method handle.
   Argument and return types are adjusted by asType
   for each individual declaration.

   The wrapper instance will implement the requested interface
   and its super-types, but no other single-method interfaces.
   This means that the instance will not unexpectedly
   pass an instanceof test for any unrequested type.

   Implementation Note:
   Therefore, each instance must implement a unique single-method interface.
   Implementations may not bundle together
   multiple single-method interfaces onto single implementation classes
   in the style of AWTEventMulticaster.

   The method handle may throw an undeclared exception,
   which means any checked exception (or other checked throwable)
   not declared by the requested type's single abstract method.
   If this happens, the throwable will be wrapped in an instance of
   UndeclaredThrowableException
   and thrown in that wrapped form.

   Like Integer.valueOf,
   asInterfaceInstance is a factory method whose results are defined
   by their behavior.
   It is not guaranteed to return a new instance for every call.

   Because of the possibility of bridge methods
   and other corner cases, the interface may also have several abstract methods
   with the same name but having distinct descriptors (types of returns and parameters).
   In this case, all the methods are bound in common to the one given target.
   The type check and effective asType conversion is applied to each
   method type descriptor, and all abstract methods are bound to the target in common.
   Beyond this type check, no further checks are made to determine that the
   abstract methods are related in any way.

   Future versions of this API may accept additional types,
   such as abstract classes with single abstract methods.
   Future versions of this API may also equip wrapper instances
   with one or more additional public `marker` interfaces.

   If a security manager is installed, this method is caller sensitive.
   During any invocation of the target method handle via the returned wrapper,
   the original creator of the wrapper (the caller) will be visible
   to context checks requested by the security manager.

  intfc - a class object representing T - `java.lang.Class<T>`
  target - the method handle to invoke from the wrapper - `java.lang.invoke.MethodHandle`

  returns: a correctly-typed wrapper for the given target - `<T> T`

  throws: java.lang.NullPointerException - if either argument is null"
  ([^java.lang.Class intfc ^java.lang.invoke.MethodHandle target]
    (MethodHandleProxies/asInterfaceInstance intfc target)))

(defn *wrapper-instance?
  "Determines if the given object was produced by a call to asInterfaceInstance.

  x - any reference - `java.lang.Object`

  returns: true if the reference is not null and points to an object produced by asInterfaceInstance - `boolean`"
  (^Boolean [^java.lang.Object x]
    (MethodHandleProxies/isWrapperInstance x)))

(defn *wrapper-instance-target
  "Produces or recovers a target method handle which is behaviorally
   equivalent to the unique method of this wrapper instance.
   The object x must have been produced by a call to asInterfaceInstance.
   This requirement may be tested via isWrapperInstance.

  x - any reference - `java.lang.Object`

  returns: a method handle implementing the unique method - `java.lang.invoke.MethodHandle`

  throws: java.lang.IllegalArgumentException - if the reference x is not to a wrapper instance"
  (^java.lang.invoke.MethodHandle [^java.lang.Object x]
    (MethodHandleProxies/wrapperInstanceTarget x)))

(defn *wrapper-instance-type
  "Recovers the unique single-method interface type for which this wrapper instance was created.
   The object x must have been produced by a call to asInterfaceInstance.
   This requirement may be tested via isWrapperInstance.

  x - any reference - `java.lang.Object`

  returns: the single-method interface type for which the wrapper was created - `java.lang.Class<?>`

  throws: java.lang.IllegalArgumentException - if the reference x is not to a wrapper instance"
  (^java.lang.Class [^java.lang.Object x]
    (MethodHandleProxies/wrapperInstanceType x)))

