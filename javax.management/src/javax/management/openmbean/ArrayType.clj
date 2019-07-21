(ns javax.management.openmbean.ArrayType
  "The ArrayType class is the open type class whose instances describe
  all open data values which are n-dimensional arrays of open data values.

  Examples of valid ArrayType instances are:


  // 2-dimension array of java.lang.String
  ArrayType<String[][]> a1 = new ArrayType<String[][]>(2, SimpleType.STRING);

  // 1-dimension array of int
  ArrayType<int[]> a2 = new ArrayType<int[]>(SimpleType.INTEGER, true);

  // 1-dimension array of java.lang.Integer
  ArrayType<Integer[]> a3 = new ArrayType<Integer[]>(SimpleType.INTEGER, false);

  // 4-dimension array of int
  ArrayType<int[][][][]> a4 = new ArrayType<int[][][][]>(3, a2);

  // 4-dimension array of java.lang.Integer
  ArrayType<Integer[][][][]> a5 = new ArrayType<Integer[][][][]>(3, a3);

  // 1-dimension array of java.lang.String
  ArrayType<String[]> a6 = new ArrayType<String[]>(SimpleType.STRING, false);

  // 1-dimension array of long
  ArrayType<long[]> a7 = new ArrayType<long[]>(SimpleType.LONG, true);

  // 1-dimension array of java.lang.Integer
  ArrayType<Integer[]> a8 = ArrayType.getArrayType(SimpleType.INTEGER);

  // 2-dimension array of java.lang.Integer
  ArrayType<Integer[][]> a9 = ArrayType.getArrayType(a8);

  // 2-dimension array of int
  ArrayType<int[][]> a10 = ArrayType.getPrimitiveArrayType(int[][].class);

  // 3-dimension array of int
  ArrayType<int[][][]> a11 = ArrayType.getArrayType(a10);

  // 1-dimension array of float
  ArrayType<float[]> a12 = ArrayType.getPrimitiveArrayType(float[].class);

  // 2-dimension array of float
  ArrayType<float[][]> a13 = ArrayType.getArrayType(a12);

  // 1-dimension array of javax.management.ObjectName
  ArrayType<ObjectName[]> a14 = ArrayType.getArrayType(SimpleType.OBJECTNAME);

  // 2-dimension array of javax.management.ObjectName
  ArrayType<ObjectName[][]> a15 = ArrayType.getArrayType(a14);

  // 3-dimension array of java.lang.String
  ArrayType<String[][][]> a16 = new ArrayType<String[][][]>(3, SimpleType.STRING);

  // 1-dimension array of java.lang.String
  ArrayType<String[]> a17 = new ArrayType<String[]>(1, SimpleType.STRING);

  // 2-dimension array of java.lang.String
  ArrayType<String[][]> a18 = new ArrayType<String[][]>(1, a17);

  // 3-dimension array of java.lang.String
  ArrayType<String[][][]> a19 = new ArrayType<String[][][]>(1, a18);"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean ArrayType]))

(defn ->array-type
  "Constructor.

  Constructs an ArrayType instance describing open data values which are
   arrays with dimension dimension of elements whose open type is elementType.

   When invoked on an ArrayType instance, the getClassName method
   returns the class name of the array instances it describes (following the rules defined by the
   getName method of java.lang.Class), not the class name of the array elements
   (which is returned by a call to getElementOpenType().getClassName()).

   The internal field corresponding to the type name of this ArrayType instance is also set to
   the class name of the array instances it describes.
   In other words, the methods getClassName and getTypeName return the same string value.
   The internal field corresponding to the description of this ArrayType instance is set to a string value
   which follows the following template:

   if non-primitive array: <dimension>-dimension array of <element_class_name>
   if primitive array: <dimension>-dimension array of <primitive_type_of_the_element_class_name>


   As an example, the following piece of code:


   ArrayType<String[][][]> t = new ArrayType<String[][][]>(3, SimpleType.STRING);
   System.out.println(\"array class name       = \"  t.getClassName());
   System.out.println(\"element class name     = \"  t.getElementOpenType().getClassName());
   System.out.println(\"array type name        = \"  t.getTypeName());
   System.out.println(\"array type description = \"  t.getDescription());
   would produce the following output:


   array class name       = [[[Ljava.lang.String;
   element class name     = java.lang.String
   array type name        = [[[Ljava.lang.String;
   array type description = 3-dimension array of java.lang.String
   And the following piece of code which is equivalent to the one listed
   above would also produce the same output:


   ArrayType<String[]> t1 = new ArrayType<String[]>(1, SimpleType.STRING);
   ArrayType<String[][]> t2 = new ArrayType<String[][]>(1, t1);
   ArrayType<String[][][]> t3 = new ArrayType<String[][][]>(1, t2);
   System.out.println(\"array class name       = \"  t3.getClassName());
   System.out.println(\"element class name     = \"  t3.getElementOpenType().getClassName());
   System.out.println(\"array type name        = \"  t3.getTypeName());
   System.out.println(\"array type description = \"  t3.getDescription());

  dimension - the dimension of arrays described by this ArrayType instance; must be greater than or equal to 1. - `int`
  element-type - the open type of element values contained in the arrays described by this ArrayType instance; must be an instance of either SimpleType, CompositeType, TabularType or another ArrayType with a SimpleType, CompositeType or TabularType as its elementType. - `javax.management.openmbean.OpenType`

  throws: java.lang.IllegalArgumentException - if dimension is not a positive integer."
  (^ArrayType [^Integer dimension ^javax.management.openmbean.OpenType element-type]
    (new ArrayType dimension element-type)))

(defn *get-array-type
  "Create an ArrayType instance in a type-safe manner.

   Multidimensional arrays can be built up by calling this method as many
   times as necessary.

   Calling this method twice with the same parameters may return the same
   object or two equal but not identical objects.

   As an example, the following piece of code:


   ArrayType<String[]> t1 = ArrayType.getArrayType(SimpleType.STRING);
   ArrayType<String[][]> t2 = ArrayType.getArrayType(t1);
   ArrayType<String[][][]> t3 = ArrayType.getArrayType(t2);
   System.out.println(\"array class name       = \"  t3.getClassName());
   System.out.println(\"element class name     = \"  t3.getElementOpenType().getClassName());
   System.out.println(\"array type name        = \"  t3.getTypeName());
   System.out.println(\"array type description = \"  t3.getDescription());
   would produce the following output:


   array class name       = [[[Ljava.lang.String;
   element class name     = java.lang.String
   array type name        = [[[Ljava.lang.String;
   array type description = 3-dimension array of java.lang.String

  element-type - the open type of element values contained in the arrays described by this ArrayType instance; must be an instance of either SimpleType, CompositeType, TabularType or another ArrayType with a SimpleType, CompositeType or TabularType as its elementType. - `javax.management.openmbean.OpenType`

  returns: `<E> javax.management.openmbean.ArrayType<E[]>`

  throws: javax.management.openmbean.OpenDataException - if elementType's className is not one of the allowed Java class names for open data."
  ([^javax.management.openmbean.OpenType element-type]
    (ArrayType/getArrayType element-type)))

(defn *get-primitive-array-type
  "Create an ArrayType instance in a type-safe manner.

   Calling this method twice with the same parameters may return the
   same object or two equal but not identical objects.

   As an example, the following piece of code:


   ArrayType<int[][][]> t = ArrayType.getPrimitiveArrayType(int[][][].class);
   System.out.println(\"array class name       = \"  t.getClassName());
   System.out.println(\"element class name     = \"  t.getElementOpenType().getClassName());
   System.out.println(\"array type name        = \"  t.getTypeName());
   System.out.println(\"array type description = \"  t.getDescription());
   would produce the following output:


   array class name       = [[[I
   element class name     = java.lang.Integer
   array type name        = [[[I
   array type description = 3-dimension array of int

  array-class - a primitive array class such as int[].class, boolean[][].class, etc. The getElementOpenType() method of the returned ArrayType returns the SimpleType corresponding to the wrapper type of the primitive type of the array. - `java.lang.Class`

  returns: `<T> javax.management.openmbean.ArrayType<T>`

  throws: java.lang.IllegalArgumentException - if arrayClass is not a primitive array."
  ([^java.lang.Class array-class]
    (ArrayType/getPrimitiveArrayType array-class)))

(defn get-dimension
  "Returns the dimension of arrays described by this ArrayType instance.

  returns: the dimension. - `int`"
  (^Integer [^ArrayType this]
    (-> this (.getDimension))))

(defn get-element-open-type
  "Returns the open type of element values contained in the arrays described by this ArrayType instance.

  returns: the element type. - `javax.management.openmbean.OpenType<?>`"
  (^javax.management.openmbean.OpenType [^ArrayType this]
    (-> this (.getElementOpenType))))

(defn primitive-array?
  "Returns true if the open data values this open
   type describes are primitive arrays, false otherwise.

  returns: true if this is a primitive array type. - `boolean`"
  (^Boolean [^ArrayType this]
    (-> this (.isPrimitiveArray))))

(defn value?
  "Tests whether obj is a value for this ArrayType
   instance.

   This method returns true if and only if obj
   is not null, obj is an array and any one of the following
   is true:


   if this ArrayType instance describes an array of
   SimpleType elements or their corresponding primitive types,
   obj's class name is the same as the className field defined
   for this ArrayType instance (i.e. the class name returned
   by the getClassName method, which
   includes the dimension information),
   if this ArrayType instance describes an array of
   classes implementing the TabularData interface or the
   CompositeData interface, obj is assignable to
   such a declared array, and each element contained in {obj
   is either null or a valid value for the element's open type specified
   by this ArrayType instance.

  obj - the object to be tested. - `java.lang.Object`

  returns: true if obj is a value for this
   ArrayType instance. - `boolean`"
  (^Boolean [^ArrayType this ^java.lang.Object obj]
    (-> this (.isValue obj))))

(defn equals
  "Compares the specified obj parameter with this
   ArrayType instance for equality.

   Two ArrayType instances are equal if and only if they
   describe array instances which have the same dimension, elements'
   open type and primitive array flag.

  obj - the object to be compared for equality with this ArrayType instance; if obj is null or is not an instance of the class ArrayType this method returns false. - `java.lang.Object`

  returns: true if the specified object is equal to
           this ArrayType instance. - `boolean`"
  (^Boolean [^ArrayType this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the hash code value for this ArrayType instance.

   The hash code of an ArrayType instance is the sum of the
   hash codes of all the elements of information used in equals
   comparisons (i.e. dimension, elements' open type and primitive array flag).
   The hashcode for a primitive value is the hashcode of the corresponding boxed
   object (e.g. the hashcode for true is Boolean.TRUE.hashCode()).
   This ensures that  t1.equals(t2)  implies that
    t1.hashCode()==t2.hashCode()  for any two
   ArrayType instances t1 and t2,
   as required by the general contract of the method
   Object.hashCode().

   As ArrayType instances are immutable, the hash
   code for this instance is calculated once, on the first call
   to hashCode, and then the same value is returned
   for subsequent calls.

  returns: the hash code value for this ArrayType instance - `int`"
  (^Integer [^ArrayType this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a string representation of this ArrayType instance.

   The string representation consists of the name of this class (i.e.
   javax.management.openmbean.ArrayType), the type name,
   the dimension, the elements' open type and the primitive array flag
   defined for this instance.

   As ArrayType instances are immutable, the
   string representation for this instance is calculated
   once, on the first call to toString, and
   then the same value is returned for subsequent calls.

  returns: a string representation of this ArrayType instance - `java.lang.String`"
  (^java.lang.String [^ArrayType this]
    (-> this (.toString))))

