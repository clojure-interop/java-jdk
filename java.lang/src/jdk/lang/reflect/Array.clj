(ns jdk.lang.reflect.Array
  "The Array class provides static methods to dynamically create and
  access Java arrays.

  Array permits widening conversions to occur during a get or set
  operation, but throws an IllegalArgumentException if a narrowing
  conversion would occur."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect Array]))

(defn *get-byte
  "Returns the value of the indexed component in the specified
   array object, as a byte.

  array - the array - `java.lang.Object`
  index - the index - `int`

  returns: the value of the indexed component in the specified array - `byte`

  throws: java.lang.NullPointerException - If the specified object is null"
  (^Byte [^java.lang.Object array ^Integer index]
    (Array/getByte array index)))

(defn *new-instance
  "Creates a new array with the specified component type and
   length.
   Invoking this method is equivalent to creating an array
   as follows:



   int[] x = {length};
   Array.newInstance(componentType, x);


   The number of dimensions of the new array must not
   exceed 255.

  component-type - the Class object representing the component type of the new array - `java.lang.Class<?>`
  length - the length of the new array - `int`

  returns: the new array - `java.lang.Object`

  throws: java.lang.NullPointerException - if the specified componentType parameter is null"
  (^java.lang.Object [^java.lang.Class component-type ^Integer length]
    (Array/newInstance component-type length)))

(defn *set-boolean
  "Sets the value of the indexed component of the specified array
   object to the specified boolean value.

  array - the array - `java.lang.Object`
  index - the index into the array - `int`
  z - the new value of the indexed component - `boolean`

  throws: java.lang.NullPointerException - If the specified object argument is null"
  ([^java.lang.Object array ^Integer index ^Boolean z]
    (Array/setBoolean array index z)))

(defn *get-short
  "Returns the value of the indexed component in the specified
   array object, as a short.

  array - the array - `java.lang.Object`
  index - the index - `int`

  returns: the value of the indexed component in the specified array - `short`

  throws: java.lang.NullPointerException - If the specified object is null"
  (^Short [^java.lang.Object array ^Integer index]
    (Array/getShort array index)))

(defn *get-long
  "Returns the value of the indexed component in the specified
   array object, as a long.

  array - the array - `java.lang.Object`
  index - the index - `int`

  returns: the value of the indexed component in the specified array - `long`

  throws: java.lang.NullPointerException - If the specified object is null"
  (^Long [^java.lang.Object array ^Integer index]
    (Array/getLong array index)))

(defn *set-double
  "Sets the value of the indexed component of the specified array
   object to the specified double value.

  array - the array - `java.lang.Object`
  index - the index into the array - `int`
  d - the new value of the indexed component - `double`

  throws: java.lang.NullPointerException - If the specified object argument is null"
  ([^java.lang.Object array ^Integer index ^Double d]
    (Array/setDouble array index d)))

(defn *get-int
  "Returns the value of the indexed component in the specified
   array object, as an int.

  array - the array - `java.lang.Object`
  index - the index - `int`

  returns: the value of the indexed component in the specified array - `int`

  throws: java.lang.NullPointerException - If the specified object is null"
  (^Integer [^java.lang.Object array ^Integer index]
    (Array/getInt array index)))

(defn *set-long
  "Sets the value of the indexed component of the specified array
   object to the specified long value.

  array - the array - `java.lang.Object`
  index - the index into the array - `int`
  l - the new value of the indexed component - `long`

  throws: java.lang.NullPointerException - If the specified object argument is null"
  ([^java.lang.Object array ^Integer index ^Long l]
    (Array/setLong array index l)))

(defn *get-char
  "Returns the value of the indexed component in the specified
   array object, as a char.

  array - the array - `java.lang.Object`
  index - the index - `int`

  returns: the value of the indexed component in the specified array - `char`

  throws: java.lang.NullPointerException - If the specified object is null"
  (^Character [^java.lang.Object array ^Integer index]
    (Array/getChar array index)))

(defn *get-length
  "Returns the length of the specified array object, as an int.

  array - the array - `java.lang.Object`

  returns: the length of the array - `int`

  throws: java.lang.IllegalArgumentException - if the object argument is not an array"
  (^Integer [^java.lang.Object array]
    (Array/getLength array)))

(defn *set-byte
  "Sets the value of the indexed component of the specified array
   object to the specified byte value.

  array - the array - `java.lang.Object`
  index - the index into the array - `int`
  b - the new value of the indexed component - `byte`

  throws: java.lang.NullPointerException - If the specified object argument is null"
  ([^java.lang.Object array ^Integer index ^Byte b]
    (Array/setByte array index b)))

(defn *set-short
  "Sets the value of the indexed component of the specified array
   object to the specified short value.

  array - the array - `java.lang.Object`
  index - the index into the array - `int`
  s - the new value of the indexed component - `short`

  throws: java.lang.NullPointerException - If the specified object argument is null"
  ([^java.lang.Object array ^Integer index ^Short s]
    (Array/setShort array index s)))

(defn *set-int
  "Sets the value of the indexed component of the specified array
   object to the specified int value.

  array - the array - `java.lang.Object`
  index - the index into the array - `int`
  i - the new value of the indexed component - `int`

  throws: java.lang.NullPointerException - If the specified object argument is null"
  ([^java.lang.Object array ^Integer index ^Integer i]
    (Array/setInt array index i)))

(defn *set
  "Sets the value of the indexed component of the specified array
   object to the specified new value.  The new value is first
   automatically unwrapped if the array has a primitive component
   type.

  array - the array - `java.lang.Object`
  index - the index into the array - `int`
  value - the new value of the indexed component - `java.lang.Object`

  throws: java.lang.NullPointerException - If the specified object argument is null"
  ([^java.lang.Object array ^Integer index ^java.lang.Object value]
    (Array/set array index value)))

(defn *get-boolean?
  "Returns the value of the indexed component in the specified
   array object, as a boolean.

  array - the array - `java.lang.Object`
  index - the index - `int`

  returns: the value of the indexed component in the specified array - `boolean`

  throws: java.lang.NullPointerException - If the specified object is null"
  (^Boolean [^java.lang.Object array ^Integer index]
    (Array/getBoolean array index)))

(defn *get-float
  "Returns the value of the indexed component in the specified
   array object, as a float.

  array - the array - `java.lang.Object`
  index - the index - `int`

  returns: the value of the indexed component in the specified array - `float`

  throws: java.lang.NullPointerException - If the specified object is null"
  (^Float [^java.lang.Object array ^Integer index]
    (Array/getFloat array index)))

(defn *get-double
  "Returns the value of the indexed component in the specified
   array object, as a double.

  array - the array - `java.lang.Object`
  index - the index - `int`

  returns: the value of the indexed component in the specified array - `double`

  throws: java.lang.NullPointerException - If the specified object is null"
  (^Double [^java.lang.Object array ^Integer index]
    (Array/getDouble array index)))

(defn *get
  "Returns the value of the indexed component in the specified
   array object.  The value is automatically wrapped in an object
   if it has a primitive type.

  array - the array - `java.lang.Object`
  index - the index - `int`

  returns: the (possibly wrapped) value of the indexed component in
   the specified array - `java.lang.Object`

  throws: java.lang.NullPointerException - If the specified object is null"
  (^java.lang.Object [^java.lang.Object array ^Integer index]
    (Array/get array index)))

(defn *set-float
  "Sets the value of the indexed component of the specified array
   object to the specified float value.

  array - the array - `java.lang.Object`
  index - the index into the array - `int`
  f - the new value of the indexed component - `float`

  throws: java.lang.NullPointerException - If the specified object argument is null"
  ([^java.lang.Object array ^Integer index ^Float f]
    (Array/setFloat array index f)))

(defn *set-char
  "Sets the value of the indexed component of the specified array
   object to the specified char value.

  array - the array - `java.lang.Object`
  index - the index into the array - `int`
  c - the new value of the indexed component - `char`

  throws: java.lang.NullPointerException - If the specified object argument is null"
  ([^java.lang.Object array ^Integer index ^Character c]
    (Array/setChar array index c)))

