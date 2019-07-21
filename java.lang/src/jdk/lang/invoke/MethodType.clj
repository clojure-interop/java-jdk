(ns jdk.lang.invoke.MethodType
  "A method type represents the arguments and return type accepted and
  returned by a method handle, or the arguments and return type passed
  and expected  by a method handle caller.  Method types must be properly
  matched between a method handle and all its callers,
  and the JVM's operations enforce this matching at, specifically
  during calls to MethodHandle.invokeExact
  and MethodHandle.invoke, and during execution
  of invokedynamic instructions.

  The structure is a return type accompanied by any number of parameter types.
  The types (primitive, void, and reference) are represented by Class objects.
  (For ease of exposition, we treat void as if it were a type.
  In fact, it denotes the absence of a return type.)

  All instances of MethodType are immutable.
  Two instances are completely interchangeable if they compare equal.
  Equality depends on pairwise correspondence of the return and parameter types and on nothing else.

  This type can be created only by factory methods.
  All factory methods may cache values, though caching is not guaranteed.
  Some factory methods are static, while others are virtual methods which
  modify precursor method types, e.g., by changing a selected parameter.

  Factory methods which operate on groups of parameter types
  are systematically presented in two versions, so that both Java arrays and
  Java lists can be used to work with groups of parameter types.
  The query methods parameterArray and parameterList
  also provide a choice between arrays and lists.

  MethodType objects are sometimes derived from bytecode instructions
  such as invokedynamic, specifically from the type descriptor strings associated
  with the instructions in a class file's constant pool.

  Like classes and strings, method types can also be represented directly
  in a class file's constant pool as constants.
  A method type may be loaded by an ldc instruction which refers
  to a suitable CONSTANT_MethodType constant pool entry.
  The entry refers to a CONSTANT_Utf8 spelling for the descriptor string.
  (For full details on method type constants,
  see sections 4.4.8 and 5.4.3.5 of the Java Virtual Machine Specification.)

  When the JVM materializes a MethodType from a descriptor string,
  all classes named in the descriptor must be accessible, and will be loaded.
  (But the classes need not be initialized, as is the case with a CONSTANT_Class.)
  This loading may occur at any time before the MethodType object is first derived."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.invoke MethodType]))

(defn *method-type
  "Finds or creates a method type with the given components.
   Convenience method for methodType.
   The leading parameter type is prepended to the remaining array.

  rtype - the return type - `java.lang.Class`
  ptype-0 - the first parameter type - `java.lang.Class`
  ptypes - the remaining parameter types - `java.lang.Class`

  returns: a method type with the given components - `java.lang.invoke.MethodType`

  throws: java.lang.NullPointerException - if rtype or ptype0 or ptypes or any element of ptypes is null"
  (^java.lang.invoke.MethodType [^java.lang.Class rtype ^java.lang.Class ptype-0 ^java.lang.Class ptypes]
    (MethodType/methodType rtype ptype-0 ptypes))
  (^java.lang.invoke.MethodType [^java.lang.Class rtype ptypes]
    (MethodType/methodType rtype ptypes))
  (^java.lang.invoke.MethodType [^java.lang.Class rtype]
    (MethodType/methodType rtype)))

(defn *generic-method-type
  "Finds or creates a method type whose components are Object with an optional trailing Object[] array.
   Convenience method for methodType.
   All parameters and the return type will be Object,
   except the final array parameter if any, which will be Object[].

  object-arg-count - number of parameters (excluding the final array parameter if any) - `int`
  final-array - whether there will be a trailing array parameter, of type Object[] - `boolean`

  returns: a generally applicable method type, for all calls of the given fixed argument count and a collected array of further arguments - `java.lang.invoke.MethodType`

  throws: java.lang.IllegalArgumentException - if objectArgCount is negative or greater than 255 (or 254, if finalArray is true)"
  (^java.lang.invoke.MethodType [^Integer object-arg-count ^Boolean final-array]
    (MethodType/genericMethodType object-arg-count final-array))
  (^java.lang.invoke.MethodType [^Integer object-arg-count]
    (MethodType/genericMethodType object-arg-count)))

(defn *from-method-descriptor-string
  "Finds or creates an instance of a method type, given the spelling of its bytecode descriptor.
   Convenience method for methodType.
   Any class or interface name embedded in the descriptor string
   will be resolved by calling ClassLoader.loadClass(java.lang.String)
   on the given loader (or if it is null, on the system class loader).

   Note that it is possible to encounter method types which cannot be
   constructed by this method, because their component types are
   not all reachable from a common class loader.

   This method is included for the benefit of applications that must
   generate bytecodes that process method handles and invokedynamic.

  descriptor - a bytecode-level type descriptor string \"(T...)T\" - `java.lang.String`
  loader - the class loader in which to look up the types - `java.lang.ClassLoader`

  returns: a method type matching the bytecode-level type descriptor - `java.lang.invoke.MethodType`

  throws: java.lang.NullPointerException - if the string is null"
  (^java.lang.invoke.MethodType [^java.lang.String descriptor ^java.lang.ClassLoader loader]
    (MethodType/fromMethodDescriptorString descriptor loader)))

(defn drop-parameter-types
  "Finds or creates a method type with some parameter types omitted.
   Convenience method for methodType.

  start - the index (zero-based) of the first parameter type to remove - `int`
  end - the index (greater than start) of the first parameter type after not to remove - `int`

  returns: the same type, except with the selected parameter(s) removed - `java.lang.invoke.MethodType`

  throws: java.lang.IndexOutOfBoundsException - if start is negative or greater than parameterCount() or if end is negative or greater than parameterCount() or if start is greater than end"
  (^java.lang.invoke.MethodType [^MethodType this ^Integer start ^Integer end]
    (-> this (.dropParameterTypes start end))))

(defn generic
  "Converts all types, both reference and primitive, to Object.
   Convenience method for genericMethodType.
   The expression type.wrap().erase() produces the same value
   as type.generic().

  returns: a version of the original type with all types replaced - `java.lang.invoke.MethodType`"
  (^java.lang.invoke.MethodType [^MethodType this]
    (-> this (.generic))))

(defn change-parameter-type
  "Finds or creates a method type with a single different parameter type.
   Convenience method for methodType.

  num - the index (zero-based) of the parameter type to change - `int`
  nptype - a new parameter type to replace the old one with - `java.lang.Class`

  returns: the same type, except with the selected parameter changed - `java.lang.invoke.MethodType`

  throws: java.lang.IndexOutOfBoundsException - if num is not a valid index into parameterArray()"
  (^java.lang.invoke.MethodType [^MethodType this ^Integer num ^java.lang.Class nptype]
    (-> this (.changeParameterType num nptype))))

(defn append-parameter-types
  "Finds or creates a method type with additional parameter types.
   Convenience method for methodType.

  ptypes-to-insert - zero or more new parameter types to insert after the end of the parameter list - `java.lang.Class`

  returns: the same type, except with the selected parameter(s) appended - `java.lang.invoke.MethodType`

  throws: java.lang.IllegalArgumentException - if any element of ptypesToInsert is void.class or if the resulting method type would have more than 255 parameter slots"
  (^java.lang.invoke.MethodType [^MethodType this ^java.lang.Class ptypes-to-insert]
    (-> this (.appendParameterTypes ptypes-to-insert))))

(defn insert-parameter-types
  "Finds or creates a method type with additional parameter types.
   Convenience method for methodType.

  num - the position (zero-based) of the inserted parameter type(s) - `int`
  ptypes-to-insert - zero or more new parameter types to insert into the parameter list - `java.lang.Class`

  returns: the same type, except with the selected parameter(s) inserted - `java.lang.invoke.MethodType`

  throws: java.lang.IndexOutOfBoundsException - if num is negative or greater than parameterCount()"
  (^java.lang.invoke.MethodType [^MethodType this ^Integer num ^java.lang.Class ptypes-to-insert]
    (-> this (.insertParameterTypes num ptypes-to-insert))))

(defn parameter-type
  "Returns the parameter type at the specified index, within this method type.

  num - the index (zero-based) of the desired parameter type - `int`

  returns: the selected parameter type - `java.lang.Class<?>`

  throws: java.lang.IndexOutOfBoundsException - if num is not a valid index into parameterArray()"
  (^java.lang.Class [^MethodType this ^Integer num]
    (-> this (.parameterType num))))

(defn parameter-count
  "Returns the number of parameter types in this method type.

  returns: the number of parameter types - `int`"
  (^Integer [^MethodType this]
    (-> this (.parameterCount))))

(defn return-type
  "Returns the return type of this method type.

  returns: the return type - `java.lang.Class<?>`"
  (^java.lang.Class [^MethodType this]
    (-> this (.returnType))))

(defn parameter-list
  "Presents the parameter types as a list (a convenience method).
   The list will be immutable.

  returns: the parameter types (as an immutable list) - `java.util.List<java.lang.Class<?>>`"
  (^java.util.List [^MethodType this]
    (-> this (.parameterList))))

(defn to-string
  "Returns a string representation of the method type,
   of the form \"(PT0,PT1...)RT\".
   The string representation of a method type is a
   parenthesis enclosed, comma separated list of type names,
   followed immediately by the return type.

   Each type is represented by its
   simple name.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^MethodType this]
    (-> this (.toString))))

(defn has-primitives?
  "Reports if this type contains a primitive argument or return value.
   The return type void counts as a primitive.

  returns: true if any of the types are primitives - `boolean`"
  (^Boolean [^MethodType this]
    (-> this (.hasPrimitives))))

(defn unwrap
  "Converts all wrapper types to their corresponding primitive types.
   Convenience method for methodType.
   All primitive types (including void) will remain unchanged.
   A return type of java.lang.Void is changed to void.

  returns: a version of the original type with all wrapper types replaced - `java.lang.invoke.MethodType`"
  (^java.lang.invoke.MethodType [^MethodType this]
    (-> this (.unwrap))))

(defn wrap
  "Converts all primitive types to their corresponding wrapper types.
   Convenience method for methodType.
   All reference types (including wrapper types) will remain unchanged.
   A void return type is changed to the type java.lang.Void.
   The expression type.wrap().erase() produces the same value
   as type.generic().

  returns: a version of the original type with all primitive types replaced - `java.lang.invoke.MethodType`"
  (^java.lang.invoke.MethodType [^MethodType this]
    (-> this (.wrap))))

(defn to-method-descriptor-string
  "Produces a bytecode descriptor representation of the method type.

   Note that this is not a strict inverse of fromMethodDescriptorString.
   Two distinct classes which share a common name but have different class loaders
   will appear identical when viewed within descriptor strings.

   This method is included for the benefit of applications that must
   generate bytecodes that process method handles and invokedynamic.
   fromMethodDescriptorString,
   because the latter requires a suitable class loader argument.

  returns: the bytecode type descriptor representation - `java.lang.String`"
  (^java.lang.String [^MethodType this]
    (-> this (.toMethodDescriptorString))))

(defn change-return-type
  "Finds or creates a method type with a different return type.
   Convenience method for methodType.

  nrtype - a return parameter type to replace the old one with - `java.lang.Class`

  returns: the same type, except with the return type change - `java.lang.invoke.MethodType`

  throws: java.lang.NullPointerException - if nrtype is null"
  (^java.lang.invoke.MethodType [^MethodType this ^java.lang.Class nrtype]
    (-> this (.changeReturnType nrtype))))

(defn erase
  "Erases all reference types to Object.
   Convenience method for methodType.
   All primitive types (including void) will remain unchanged.

  returns: a version of the original type with all reference types replaced - `java.lang.invoke.MethodType`"
  (^java.lang.invoke.MethodType [^MethodType this]
    (-> this (.erase))))

(defn hash-code
  "Returns the hash code value for this method type.
   It is defined to be the same as the hashcode of a List
   whose elements are the return type followed by the
   parameter types.

  returns: the hash code value for this method type - `int`"
  (^Integer [^MethodType this]
    (-> this (.hashCode))))

(defn equals
  "Compares the specified object with this type for equality.
   That is, it returns true if and only if the specified object
   is also a method type with exactly the same parameters and return type.

  x - object to compare - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  (^Boolean [^MethodType this ^java.lang.Object x]
    (-> this (.equals x))))

(defn has-wrappers?
  "Reports if this type contains a wrapper argument or return value.
   Wrappers are types which box primitive values, such as Integer.
   The reference type java.lang.Void counts as a wrapper,
   if it occurs as a return type.

  returns: true if any of the types are wrappers - `boolean`"
  (^Boolean [^MethodType this]
    (-> this (.hasWrappers))))

(defn parameter-array
  "Presents the parameter types as an array (a convenience method).
   Changes to the array will not result in changes to the type.

  returns: the parameter types (as a fresh copy if necessary) - `java.lang.Class<?>[]`"
  ([^MethodType this]
    (-> this (.parameterArray))))

