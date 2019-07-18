(ns jdk.lang.invoke.MethodHandles
  "This class consists exclusively of static methods that operate on or return
  method handles. They fall into several categories:

  Lookup methods which help create method handles for methods and fields.
  Combinator methods, which combine or transform pre-existing method handles into new ones.
  Other factory methods to create method handles that emulate other common JVM operations or control flow patterns."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.invoke MethodHandles]))

(defn *collect-arguments
  "Adapts a target method handle by pre-processing
   a sub-sequence of its arguments with a filter (another method handle).
   The pre-processed arguments are replaced by the result (if any) of the
   filter function.
   The target is then called on the modified (usually shortened) argument list.

   If the filter returns a value, the target must accept that value as
   its argument in position pos, preceded and/or followed by
   any arguments not passed to the filter.
   If the filter returns void, the target must accept all arguments
   not passed to the filter.
   No arguments are reordered, and a result returned from the filter
   replaces (in order) the whole subsequence of arguments originally
   passed to the adapter.

   The argument types (if any) of the filter
   replace zero or one argument types of the target, at position pos,
   in the resulting adapted method handle.
   The return type of the filter (if any) must be identical to the
   argument type of the target at position pos, and that target argument
   is supplied by the return value of the filter.

   In all cases, pos must be greater than or equal to zero, and
   pos must also be less than or equal to the target's arity.
   Example:


  import static java.lang.invoke.MethodHandles.*;
  import static java.lang.invoke.MethodType.*;
  ...
  MethodHandle deepToString = publicLookup()
    .findStatic(Arrays.class, `deepToString`, methodType(String.class, Object[].class));

  MethodHandle ts1 = deepToString.asCollector(String[].class, 1);
  assertEquals(`[strange]`, (String) ts1.invokeExact(`strange`));

  MethodHandle ts2 = deepToString.asCollector(String[].class, 2);
  assertEquals(`[up, down]`, (String) ts2.invokeExact(`up`, `down`));

  MethodHandle ts3 = deepToString.asCollector(String[].class, 3);
  MethodHandle ts3_ts2 = collectArguments(ts3, 1, ts2);
  assertEquals(`[top, [up, down], strange]`,
               (String) ts3_ts2.invokeExact(`top`, `up`, `down`, `strange`));

  MethodHandle ts3_ts2_ts1 = collectArguments(ts3_ts2, 3, ts1);
  assertEquals(`[top, [up, down], [strange]]`,
               (String) ts3_ts2_ts1.invokeExact(`top`, `up`, `down`, `strange`));

  MethodHandle ts3_ts2_ts3 = collectArguments(ts3_ts2, 1, ts3);
  assertEquals(`[top, [[up, down, strange], charm], bottom]`,
               (String) ts3_ts2_ts3.invokeExact(`top`, `up`, `down`, `strange`, `charm`, `bottom`));
    Here is pseudocode for the resulting adapter:


   T target(A...,V,C...);
   V filter(B...);
   T adapter(A... a,B... b,C... c) {
     V v = filter(b...);
     return target(a...,v,c...);
   }
   // and if the filter has no arguments:
   T target2(A...,V,C...);
   V filter2();
   T adapter2(A... a,C... c) {
     V v = filter2();
     return target2(a...,v,c...);
   }
   // and if the filter has a void return:
   T target3(A...,C...);
   void filter3(B...);
   void adapter3(A... a,B... b,C... c) {
     filter3(b...);
     return target3(a...,c...);
   }

   A collection adapter collectArguments(mh, 0, coll) is equivalent to
   one which first `folds` the affected arguments, and then drops them, in separate
   steps as follows:


   mh = MethodHandles.dropArguments(mh, 1, coll.type().parameterList()); //step 2
   mh = MethodHandles.foldArguments(mh, coll); //step 1
   If the target method handle consumes no arguments besides than the result
   (if any) of the filter coll, then collectArguments(mh, 0, coll)
   is equivalent to filterReturnValue(coll, mh).
   If the filter method handle coll consumes one argument and produces
   a non-void result, then collectArguments(mh, N, coll)
   is equivalent to filterArguments(mh, N, coll).
   Other equivalences are possible but would require argument permutation.

  target - the method handle to invoke after filtering the subsequence of arguments - `java.lang.invoke.MethodHandle`
  pos - the position of the first adapter argument to pass to the filter, and/or the target argument which receives the result of the filter - `int`
  filter - method handle to call on the subsequence of arguments - `java.lang.invoke.MethodHandle`

  returns: method handle which incorporates the specified argument subsequence filtering logic - `java.lang.invoke.MethodHandle`

  throws: java.lang.NullPointerException - if either argument is null"
  (^java.lang.invoke.MethodHandle [^java.lang.invoke.MethodHandle target ^Integer pos ^java.lang.invoke.MethodHandle filter]
    (MethodHandles/collectArguments target pos filter)))

(defn *reflect-as
  "Performs an unchecked `crack` of a
   direct method handle.
   The result is as if the user had obtained a lookup object capable enough
   to crack the target method handle, called
   Lookup.revealDirect
   on the target to obtain its symbolic reference, and then called
   MethodHandleInfo.reflectAs
   to resolve the symbolic reference to a member.

   If there is a security manager, its checkPermission method
   is called with a ReflectPermission(`suppressAccessChecks`) permission.

  expected - a class object representing the desired result type T - `java.lang.Class`
  target - a direct method handle to crack into symbolic reference components - `java.lang.invoke.MethodHandle`

  returns: a reference to the method, constructor, or field object - `<T extends java.lang.reflect.Member> T`

  throws: java.lang.SecurityException - if the caller is not privileged to call setAccessible"
  ([^java.lang.Class expected ^java.lang.invoke.MethodHandle target]
    (MethodHandles/reflectAs expected target)))

(defn *permute-arguments
  "Produces a method handle which adapts the calling sequence of the
   given method handle to a new type, by reordering the arguments.
   The resulting method handle is guaranteed to report a type
   which is equal to the desired new type.

   The given array controls the reordering.
   Call #I the number of incoming parameters (the value
   newType.parameterCount(), and call #O the number
   of outgoing parameters (the value target.type().parameterCount()).
   Then the length of the reordering array must be #O,
   and each element must be a non-negative number less than #I.
   For every N less than #O, the N-th
   outgoing argument will be taken from the I-th incoming
   argument, where I is reorder[N].

   No argument or return value conversions are applied.
   The type of each incoming argument, as determined by newType,
   must be identical to the type of the corresponding outgoing parameter
   or parameters in the target method handle.
   The return type of newType must be identical to the return
   type of the original target.

   The reordering array need not specify an actual permutation.
   An incoming argument will be duplicated if its index appears
   more than once in the array, and an incoming argument will be dropped
   if its index does not appear in the array.
   As in the case of dropArguments,
   incoming arguments which are not mentioned in the reordering array
   are may be any type, as determined only by newType.


  import static java.lang.invoke.MethodHandles.*;
  import static java.lang.invoke.MethodType.*;
  ...
  MethodType intfn1 = methodType(int.class, int.class);
  MethodType intfn2 = methodType(int.class, int.class, int.class);
  MethodHandle sub = ... (int x, int y) -> (x-y) ...;
  assert(sub.type().equals(intfn2));
  MethodHandle sub1 = permuteArguments(sub, intfn2, 0, 1);
  MethodHandle rsub = permuteArguments(sub, intfn2, 1, 0);
  assert((int)rsub.invokeExact(1, 100) == 99);
  MethodHandle add = ... (int x, int y) -> (x+y) ...;
  assert(add.type().equals(intfn2));
  MethodHandle twice = permuteArguments(add, intfn1, 0, 0);
  assert(twice.type().equals(intfn1));
  assert((int)twice.invokeExact(21) == 42);

  target - the method handle to invoke after arguments are reordered - `java.lang.invoke.MethodHandle`
  new-type - the expected type of the new method handle - `java.lang.invoke.MethodType`
  reorder - an index array which controls the reordering - `int`

  returns: a method handle which delegates to the target after it
             drops unused arguments and moves and/or duplicates the other arguments - `java.lang.invoke.MethodHandle`

  throws: java.lang.NullPointerException - if any argument is null"
  (^java.lang.invoke.MethodHandle [^java.lang.invoke.MethodHandle target ^java.lang.invoke.MethodType new-type ^Integer reorder]
    (MethodHandles/permuteArguments target new-type reorder)))

(defn *guard-with-test
  "Makes a method handle which adapts a target method handle,
   by guarding it with a test, a boolean-valued method handle.
   If the guard fails, a fallback handle is called instead.
   All three method handles must have the same corresponding
   argument and return types, except that the return type
   of the test must be boolean, and the test is allowed
   to have fewer arguments than the other two method handles.
    Here is pseudocode for the resulting adapter:


   boolean test(A...);
   T target(A...,B...);
   T fallback(A...,B...);
   T adapter(A... a,B... b) {
     if (test(a...))
       return target(a..., b...);
     else
       return fallback(a..., b...);
   }
   Note that the test arguments (a... in the pseudocode) cannot
   be modified by execution of the test, and so are passed unchanged
   from the caller to the target or fallback as appropriate.

  test - method handle used for test, must return boolean - `java.lang.invoke.MethodHandle`
  target - method handle to call if test passes - `java.lang.invoke.MethodHandle`
  fallback - method handle to call if test fails - `java.lang.invoke.MethodHandle`

  returns: method handle which incorporates the specified if/then/else logic - `java.lang.invoke.MethodHandle`

  throws: java.lang.NullPointerException - if any argument is null"
  (^java.lang.invoke.MethodHandle [^java.lang.invoke.MethodHandle test ^java.lang.invoke.MethodHandle target ^java.lang.invoke.MethodHandle fallback]
    (MethodHandles/guardWithTest test target fallback)))

(defn *catch-exception
  "Makes a method handle which adapts a target method handle,
   by running it inside an exception handler.
   If the target returns normally, the adapter returns that value.
   If an exception matching the specified type is thrown, the fallback
   handle is called instead on the exception, plus the original arguments.

   The target and handler must have the same corresponding
   argument and return types, except that handler may omit trailing arguments
   (similarly to the predicate in guardWithTest).
   Also, the handler must have an extra leading parameter of exType or a supertype.
    Here is pseudocode for the resulting adapter:


   T target(A..., B...);
   T handler(ExType, A...);
   T adapter(A... a, B... b) {
     try {
       return target(a..., b...);
     } catch (ExType ex) {
       return handler(ex, a...);
     }
   }
   Note that the saved arguments (a... in the pseudocode) cannot
   be modified by execution of the target, and so are passed unchanged
   from the caller to the handler, if the handler is invoked.

   The target and handler must return the same type, even if the handler
   always throws.  (This might happen, for instance, because the handler
   is simulating a finally clause).
   To create such a throwing handler, compose the handler creation logic
   with throwException,
   in order to create a method handle of the correct return type.

  target - method handle to call - `java.lang.invoke.MethodHandle`
  ex-type - the type of exception which the handler will catch - `java.lang.Class`
  handler - method handle to call if a matching exception is thrown - `java.lang.invoke.MethodHandle`

  returns: method handle which incorporates the specified try/catch logic - `java.lang.invoke.MethodHandle`

  throws: java.lang.NullPointerException - if any argument is null"
  (^java.lang.invoke.MethodHandle [^java.lang.invoke.MethodHandle target ^java.lang.Class ex-type ^java.lang.invoke.MethodHandle handler]
    (MethodHandles/catchException target ex-type handler)))

(defn *constant
  "Produces a method handle of the requested return type which returns the given
   constant value every time it is invoked.

   Before the method handle is returned, the passed-in value is converted to the requested type.
   If the requested type is primitive, widening primitive conversions are attempted,
   else reference conversions are attempted.
   The returned method handle is equivalent to identity(type).bindTo(value).

  type - the return type of the desired method handle - `java.lang.Class`
  value - the value to return - `java.lang.Object`

  returns: a method handle of the given return type and no arguments, which always returns the given value - `java.lang.invoke.MethodHandle`

  throws: java.lang.NullPointerException - if the type argument is null"
  (^java.lang.invoke.MethodHandle [^java.lang.Class type ^java.lang.Object value]
    (MethodHandles/constant type value)))

(defn *array-element-setter
  "Produces a method handle giving write access to elements of an array.
   The type of the method handle will have a void return type.
   Its last argument will be the array's element type.
   The first and second arguments will be the array type and int.

  array-class - the class of an array - `java.lang.Class`

  returns: a method handle which can store values into the array type - `java.lang.invoke.MethodHandle`

  throws: java.lang.NullPointerException - if the argument is null"
  (^java.lang.invoke.MethodHandle [^java.lang.Class array-class]
    (MethodHandles/arrayElementSetter array-class)))

(defn *spread-invoker
  "Produces a method handle which will invoke any method handle of the
   given type, with a given number of trailing arguments replaced by
   a single trailing Object[] array.
   The resulting invoker will be a method handle with the following
   arguments:

   a single MethodHandle target
   zero or more leading values (counted by leadingArgCount)
   an Object[] array containing trailing arguments


   The invoker will invoke its target like a call to invoke with
   the indicated type.
   That is, if the target is exactly of the given type, it will behave
   like invokeExact; otherwise it behave as if asType
   is used to convert the target to the required type.

   The type of the returned invoker will not be the given type, but rather
   will have all parameters except the first leadingArgCount
   replaced by a single array of type Object[], which will be
   the final parameter.

   Before invoking its target, the invoker will spread the final array, apply
   reference casts as necessary, and unbox and widen primitive arguments.
   If, when the invoker is called, the supplied array argument does
   not have the correct number of elements, the invoker will throw
   an IllegalArgumentException instead of invoking the target.

   This method is equivalent to the following code (though it may be more efficient):


  MethodHandle invoker = MethodHandles.invoker(type);
  int spreadArgCount = type.parameterCount() - leadingArgCount;
  invoker = invoker.asSpreader(Object[].class, spreadArgCount);
  return invoker;
   This method throws no reflective or security exceptions.

  type - the desired target type - `java.lang.invoke.MethodType`
  leading-arg-count - number of fixed arguments, to be passed unchanged to the target - `int`

  returns: a method handle suitable for invoking any method handle of the given type - `java.lang.invoke.MethodHandle`

  throws: java.lang.NullPointerException - if type is null"
  (^java.lang.invoke.MethodHandle [^java.lang.invoke.MethodType type ^Integer leading-arg-count]
    (MethodHandles/spreadInvoker type leading-arg-count)))

(defn *array-element-getter
  "Produces a method handle giving read access to elements of an array.
   The type of the method handle will have a return type of the array's
   element type.  Its first argument will be the array type,
   and the second will be int.

  array-class - an array type - `java.lang.Class`

  returns: a method handle which can load values from the given array type - `java.lang.invoke.MethodHandle`

  throws: java.lang.NullPointerException - if the argument is null"
  (^java.lang.invoke.MethodHandle [^java.lang.Class array-class]
    (MethodHandles/arrayElementGetter array-class)))

(defn *filter-return-value
  "Adapts a target method handle by post-processing
   its return value (if any) with a filter (another method handle).
   The result of the filter is returned from the adapter.

   If the target returns a value, the filter must accept that value as
   its only argument.
   If the target returns void, the filter must accept no arguments.

   The return type of the filter
   replaces the return type of the target
   in the resulting adapted method handle.
   The argument type of the filter (if any) must be identical to the
   return type of the target.
   Example:


  import static java.lang.invoke.MethodHandles.*;
  import static java.lang.invoke.MethodType.*;
  ...
  MethodHandle cat = lookup().findVirtual(String.class,
    `concat`, methodType(String.class, String.class));
  MethodHandle length = lookup().findVirtual(String.class,
    `length`, methodType(int.class));
  System.out.println((String) cat.invokeExact(`x`, `y`)); // xy
  MethodHandle f0 = filterReturnValue(cat, length);
  System.out.println((int) f0.invokeExact(`x`, `y`)); // 2
    Here is pseudocode for the resulting adapter:


   V target(A...);
   T filter(V);
   T adapter(A... a) {
     V v = target(a...);
     return filter(v);
   }
   // and if the target has a void return:
   void target2(A...);
   T filter2();
   T adapter2(A... a) {
     target2(a...);
     return filter2();
   }
   // and if the filter has a void return:
   V target3(A...);
   void filter3(V);
   void adapter3(A... a) {
     V v = target3(a...);
     filter3(v);
   }

  target - the method handle to invoke before filtering the return value - `java.lang.invoke.MethodHandle`
  filter - method handle to call on the return value - `java.lang.invoke.MethodHandle`

  returns: method handle which incorporates the specified return value filtering logic - `java.lang.invoke.MethodHandle`

  throws: java.lang.NullPointerException - if either argument is null"
  (^java.lang.invoke.MethodHandle [^java.lang.invoke.MethodHandle target ^java.lang.invoke.MethodHandle filter]
    (MethodHandles/filterReturnValue target filter)))

(defn *lookup
  "Returns a lookup object with
   full capabilities to emulate all supported bytecode behaviors of the caller.
   These capabilities include private access to the caller.
   Factory methods on the lookup object can create
   direct method handles
   for any member that the caller has access to via bytecodes,
   including protected and private fields and methods.
   This lookup object is a capability which may be delegated to trusted agents.
   Do not store it in place where untrusted code can access it.

   This method is caller sensitive, which means that it may return different
   values to different callers.

   For any given caller class C, the lookup object returned by this call
   has equivalent capabilities to any lookup object
   supplied by the JVM to the bootstrap method of an
   invokedynamic instruction
   executing in the same caller class C.

  returns: a lookup object for the caller of this method, with private access - `java.lang.invoke.MethodHandles$Lookup`"
  (^java.lang.invoke.MethodHandles$Lookup []
    (MethodHandles/lookup )))

(defn *public-lookup
  "Returns a lookup object which is trusted minimally.
   It can only be used to create method handles to
   publicly accessible fields and methods.

   As a matter of pure convention, the lookup class
   of this lookup object will be Object.


   Discussion:
   The lookup class can be changed to any other class C using an expression of the form
   publicLookup().in(C.class).
   Since all classes have equal access to public names,
   such a change would confer no new access rights.
   A public lookup object is always subject to
   security manager checks.
   Also, it cannot access
   caller sensitive methods.

  returns: a lookup object which is trusted minimally - `java.lang.invoke.MethodHandles$Lookup Lookup`"
  ([]
    (MethodHandles/publicLookup )))

(defn *invoker
  "Produces a special invoker method handle which can be used to
   invoke any method handle compatible with the given type, as if by invoke.
   The resulting invoker will have a type which is
   exactly equal to the desired type, except that it will accept
   an additional leading argument of type MethodHandle.

   Before invoking its target, if the target differs from the expected type,
   the invoker will apply reference casts as
   necessary and box, unbox, or widen primitive values, as if by asType.
   Similarly, the return value will be converted as necessary.
   If the target is a variable arity method handle,
   the required arity conversion will be made, again as if by asType.

   This method is equivalent to the following code (though it may be more efficient):
   publicLookup().findVirtual(MethodHandle.class, `invoke`, type)

   Discussion:
   A general method type is one which
   mentions only Object arguments and return values.
   An invoker for such a type is capable of calling any method handle
   of the same arity as the general type.

   (Note:  The invoker method is not available via the Core Reflection API.
   An attempt to call java.lang.reflect.Method.invoke
   on the declared invokeExact or invoke method will raise an
   UnsupportedOperationException.)

   This method throws no reflective or security exceptions.

  type - the desired target type - `java.lang.invoke.MethodType`

  returns: a method handle suitable for invoking any method handle convertible to the given type - `java.lang.invoke.MethodHandle`

  throws: java.lang.IllegalArgumentException - if the resulting method handle's type would have too many parameters"
  (^java.lang.invoke.MethodHandle [^java.lang.invoke.MethodType type]
    (MethodHandles/invoker type)))

(defn *drop-arguments
  "Produces a method handle which will discard some dummy arguments
   before calling some other specified target method handle.
   The type of the new method handle will be the same as the target's type,
   except it will also include the dummy argument types,
   at some given position.

   The pos argument may range between zero and N,
   where N is the arity of the target.
   If pos is zero, the dummy arguments will precede
   the target's real arguments; if pos is N
   they will come after.

   Example:


  import static java.lang.invoke.MethodHandles.*;
  import static java.lang.invoke.MethodType.*;
  ...
  MethodHandle cat = lookup().findVirtual(String.class,
    `concat`, methodType(String.class, String.class));
  assertEquals(`xy`, (String) cat.invokeExact(`x`, `y`));
  MethodType bigType = cat.type().insertParameterTypes(0, int.class, String.class);
  MethodHandle d0 = dropArguments(cat, 0, bigType.parameterList().subList(0,2));
  assertEquals(bigType, d0.type());
  assertEquals(`yz`, (String) d0.invokeExact(123, `x`, `y`, `z`));

   This method is also equivalent to the following code:


   dropArguments (target, pos, valueTypes.toArray(new Class[0]))

  target - the method handle to invoke after the arguments are dropped - `java.lang.invoke.MethodHandle`
  pos - position of first argument to drop (zero for the leftmost) - `int`
  value-types - the type(s) of the argument(s) to drop - `java.util.List`

  returns: a method handle which drops arguments of the given types,
           before calling the original method handle - `java.lang.invoke.MethodHandle`

  throws: java.lang.NullPointerException - if the target is null, or if the valueTypes list or any of its elements is null"
  (^java.lang.invoke.MethodHandle [^java.lang.invoke.MethodHandle target ^Integer pos ^java.util.List value-types]
    (MethodHandles/dropArguments target pos value-types)))

(defn *identity
  "Produces a method handle which returns its sole argument when invoked.

  type - the type of the sole parameter and return value of the desired method handle - `java.lang.Class`

  returns: a unary method handle which accepts and returns the given type - `java.lang.invoke.MethodHandle`

  throws: java.lang.NullPointerException - if the argument is null"
  (^java.lang.invoke.MethodHandle [^java.lang.Class type]
    (MethodHandles/identity type)))

(defn *fold-arguments
  "Adapts a target method handle by pre-processing
   some of its arguments, and then calling the target with
   the result of the pre-processing, inserted into the original
   sequence of arguments.

   The pre-processing is performed by combiner, a second method handle.
   Of the arguments passed to the adapter, the first N arguments
   are copied to the combiner, which is then called.
   (Here, N is defined as the parameter count of the combiner.)
   After this, control passes to the target, with any result
   from the combiner inserted before the original N incoming
   arguments.

   If the combiner returns a value, the first parameter type of the target
   must be identical with the return type of the combiner, and the next
   N parameter types of the target must exactly match the parameters
   of the combiner.

   If the combiner has a void return, no result will be inserted,
   and the first N parameter types of the target
   must exactly match the parameters of the combiner.

   The resulting adapter is the same type as the target, except that the
   first parameter type is dropped,
   if it corresponds to the result of the combiner.

   (Note that dropArguments can be used to remove any arguments
   that either the combiner or the target does not wish to receive.
   If some of the incoming arguments are destined only for the combiner,
   consider using asCollector instead, since those
   arguments will not need to be live on the stack on entry to the
   target.)
   Example:


  import static java.lang.invoke.MethodHandles.*;
  import static java.lang.invoke.MethodType.*;
  ...
  MethodHandle trace = publicLookup().findVirtual(java.io.PrintStream.class,
    `println`, methodType(void.class, String.class))
      .bindTo(System.out);
  MethodHandle cat = lookup().findVirtual(String.class,
    `concat`, methodType(String.class, String.class));
  assertEquals(`boojum`, (String) cat.invokeExact(`boo`, `jum`));
  MethodHandle catTrace = foldArguments(cat, trace);
  // also prints `boo`:
  assertEquals(`boojum`, (String) catTrace.invokeExact(`boo`, `jum`));
    Here is pseudocode for the resulting adapter:


   // there are N arguments in A...
   T target(V, A[N]..., B...);
   V combiner(A...);
   T adapter(A... a, B... b) {
     V v = combiner(a...);
     return target(v, a..., b...);
   }
   // and if the combiner has a void return:
   T target2(A[N]..., B...);
   void combiner2(A...);
   T adapter2(A... a, B... b) {
     combiner2(a...);
     return target2(a..., b...);
   }

  target - the method handle to invoke after arguments are combined - `java.lang.invoke.MethodHandle`
  combiner - method handle to call initially on the incoming arguments - `java.lang.invoke.MethodHandle`

  returns: method handle which incorporates the specified argument folding logic - `java.lang.invoke.MethodHandle`

  throws: java.lang.NullPointerException - if either argument is null"
  (^java.lang.invoke.MethodHandle [^java.lang.invoke.MethodHandle target ^java.lang.invoke.MethodHandle combiner]
    (MethodHandles/foldArguments target combiner)))

(defn *throw-exception
  "Produces a method handle which will throw exceptions of the given exType.
   The method handle will accept a single argument of exType,
   and immediately throw it as an exception.
   The method type will nominally specify a return of returnType.
   The return type may be anything convenient:  It doesn't matter to the
   method handle's behavior, since it will never return normally.

  return-type - the return type of the desired method handle - `java.lang.Class`
  ex-type - the parameter type of the desired method handle - `java.lang.Class`

  returns: method handle which can throw the given exceptions - `java.lang.invoke.MethodHandle`

  throws: java.lang.NullPointerException - if either argument is null"
  (^java.lang.invoke.MethodHandle [^java.lang.Class return-type ^java.lang.Class ex-type]
    (MethodHandles/throwException return-type ex-type)))

(defn *exact-invoker
  "Produces a special invoker method handle which can be used to
   invoke any method handle of the given type, as if by invokeExact.
   The resulting invoker will have a type which is
   exactly equal to the desired type, except that it will accept
   an additional leading argument of type MethodHandle.

   This method is equivalent to the following code (though it may be more efficient):
   publicLookup().findVirtual(MethodHandle.class, `invokeExact`, type)


   Discussion:
   Invoker method handles can be useful when working with variable method handles
   of unknown types.
   For example, to emulate an invokeExact call to a variable method
   handle M, extract its type T,
   look up the invoker method X for T,
   and call the invoker method, as X.invoke(T, A...).
   (It would not work to call X.invokeExact, since the type T
   is unknown.)
   If spreading, collecting, or other argument transformations are required,
   they can be applied once to the invoker X and reused on many M
   method handle values, as long as they are compatible with the type of X.

   (Note:  The invoker method is not available via the Core Reflection API.
   An attempt to call java.lang.reflect.Method.invoke
   on the declared invokeExact or invoke method will raise an
   UnsupportedOperationException.)

   This method throws no reflective or security exceptions.

  type - the desired target type - `java.lang.invoke.MethodType`

  returns: a method handle suitable for invoking any method handle of the given type - `java.lang.invoke.MethodHandle`

  throws: java.lang.IllegalArgumentException - if the resulting method handle's type would have too many parameters"
  (^java.lang.invoke.MethodHandle [^java.lang.invoke.MethodType type]
    (MethodHandles/exactInvoker type)))

(defn *explicit-cast-arguments
  "Produces a method handle which adapts the type of the
   given method handle to a new type by pairwise argument and return type conversion.
   The original type and new type must have the same number of arguments.
   The resulting method handle is guaranteed to report a type
   which is equal to the desired new type.

   If the original type and new type are equal, returns target.

   The same conversions are allowed as for MethodHandle.asType,
   and some additional conversions are also applied if those conversions fail.
   Given types T0, T1, one of the following conversions is applied
   if possible, before or instead of any conversions done by asType:

   If T0 and T1 are references, and T1 is an interface type,
       then the value of type T0 is passed as a T1 without a cast.
       (This treatment of interfaces follows the usage of the bytecode verifier.)
   If T0 is boolean and T1 is another primitive,
       the boolean is converted to a byte value, 1 for true, 0 for false.
       (This treatment follows the usage of the bytecode verifier.)
   If T1 is boolean and T0 is another primitive,
       T0 is converted to byte via Java casting conversion (JLS 5.5),
       and the low order bit of the result is tested, as if by (x & 1) != 0.
   If T0 and T1 are primitives other than boolean,
       then a Java casting conversion (JLS 5.5) is applied.
       (Specifically, T0 will convert to T1 by
       widening and/or narrowing.)
   If T0 is a reference and T1 a primitive, an unboxing
       conversion will be applied at runtime, possibly followed
       by a Java casting conversion (JLS 5.5) on the primitive value,
       possibly followed by a conversion from byte to boolean by testing
       the low-order bit.
   If T0 is a reference and T1 a primitive,
       and if the reference is null at runtime, a zero value is introduced.

  target - the method handle to invoke after arguments are retyped - `java.lang.invoke.MethodHandle`
  new-type - the expected type of the new method handle - `java.lang.invoke.MethodType`

  returns: a method handle which delegates to the target after performing
             any necessary argument conversions, and arranges for any
             necessary return value conversions - `java.lang.invoke.MethodHandle`

  throws: java.lang.NullPointerException - if either argument is null"
  (^java.lang.invoke.MethodHandle [^java.lang.invoke.MethodHandle target ^java.lang.invoke.MethodType new-type]
    (MethodHandles/explicitCastArguments target new-type)))

(defn *insert-arguments
  "Provides a target method handle with one or more bound arguments
   in advance of the method handle's invocation.
   The formal parameters to the target corresponding to the bound
   arguments are called bound parameters.
   Returns a new method handle which saves away the bound arguments.
   When it is invoked, it receives arguments for any non-bound parameters,
   binds the saved arguments to their corresponding parameters,
   and calls the original target.

   The type of the new method handle will drop the types for the bound
   parameters from the original target type, since the new method handle
   will no longer require those arguments to be supplied by its callers.

   Each given argument object must match the corresponding bound parameter type.
   If a bound parameter type is a primitive, the argument object
   must be a wrapper, and will be unboxed to produce the primitive value.

   The pos argument selects which parameters are to be bound.
   It may range between zero and N-L (inclusively),
   where N is the arity of the target method handle
   and L is the length of the values array.

  target - the method handle to invoke after the argument is inserted - `java.lang.invoke.MethodHandle`
  pos - where to insert the argument (zero for the first) - `int`
  values - the series of arguments to insert - `java.lang.Object`

  returns: a method handle which inserts an additional argument,
           before calling the original method handle - `java.lang.invoke.MethodHandle`

  throws: java.lang.NullPointerException - if the target or the values array is null"
  (^java.lang.invoke.MethodHandle [^java.lang.invoke.MethodHandle target ^Integer pos ^java.lang.Object values]
    (MethodHandles/insertArguments target pos values)))

(defn *filter-arguments
  "Adapts a target method handle by pre-processing
   one or more of its arguments, each with its own unary filter function,
   and then calling the target with each pre-processed argument
   replaced by the result of its corresponding filter function.

   The pre-processing is performed by one or more method handles,
   specified in the elements of the filters array.
   The first element of the filter array corresponds to the pos
   argument of the target, and so on in sequence.

   Null arguments in the array are treated as identity functions,
   and the corresponding arguments left unchanged.
   (If there are no non-null elements in the array, the original target is returned.)
   Each filter is applied to the corresponding argument of the adapter.

   If a filter F applies to the Nth argument of
   the target, then F must be a method handle which
   takes exactly one argument.  The type of F's sole argument
   replaces the corresponding argument type of the target
   in the resulting adapted method handle.
   The return type of F must be identical to the corresponding
   parameter type of the target.

   It is an error if there are elements of filters
   (null or not)
   which do not correspond to argument positions in the target.
   Example:


  import static java.lang.invoke.MethodHandles.*;
  import static java.lang.invoke.MethodType.*;
  ...
  MethodHandle cat = lookup().findVirtual(String.class,
    `concat`, methodType(String.class, String.class));
  MethodHandle upcase = lookup().findVirtual(String.class,
    `toUpperCase`, methodType(String.class));
  assertEquals(`xy`, (String) cat.invokeExact(`x`, `y`));
  MethodHandle f0 = filterArguments(cat, 0, upcase);
  assertEquals(`Xy`, (String) f0.invokeExact(`x`, `y`)); // Xy
  MethodHandle f1 = filterArguments(cat, 1, upcase);
  assertEquals(`xY`, (String) f1.invokeExact(`x`, `y`)); // xY
  MethodHandle f2 = filterArguments(cat, 0, upcase, upcase);
  assertEquals(`XY`, (String) f2.invokeExact(`x`, `y`)); // XY
    Here is pseudocode for the resulting adapter:


   V target(P... p, A[i]... a[i], B... b);
   A[i] filter[i](V[i]);
   T adapter(P... p, V[i]... v[i], B... b) {
     return target(p..., f[i](v[i])..., b...);
   }

  target - the method handle to invoke after arguments are filtered - `java.lang.invoke.MethodHandle`
  pos - the position of the first argument to filter - `int`
  filters - method handles to call initially on filtered arguments - `java.lang.invoke.MethodHandle`

  returns: method handle which incorporates the specified argument filtering logic - `java.lang.invoke.MethodHandle`

  throws: java.lang.NullPointerException - if the target is null or if the filters array is null"
  (^java.lang.invoke.MethodHandle [^java.lang.invoke.MethodHandle target ^Integer pos ^java.lang.invoke.MethodHandle filters]
    (MethodHandles/filterArguments target pos filters)))

