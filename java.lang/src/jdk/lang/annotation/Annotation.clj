(ns jdk.lang.annotation.Annotation
  "The common interface extended by all annotation types.  Note that an
  interface that manually extends this one does not define
  an annotation type.  Also note that this interface does not itself
  define an annotation type.

  More information about annotation types can be found in section 9.6 of
  The Java™ Language Specification.

  The AnnotatedElement interface discusses
  compatibility concerns when evolving an annotation type from being
  non-repeatable to being repeatable."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.annotation Annotation]))

(defn equals
  "Returns true if the specified object represents an annotation
   that is logically equivalent to this one.  In other words,
   returns true if the specified object is an instance of the same
   annotation type as this instance, all of whose members are equal
   to the corresponding member of this annotation, as defined below:

      Two corresponding primitive typed members whose values are
      x and y are considered equal if x == y,
      unless their type is float or double.

      Two corresponding float members whose values
      are x and y are considered equal if
      Float.valueOf(x).equals(Float.valueOf(y)).
      (Unlike the == operator, NaN is considered equal
      to itself, and 0.0f unequal to -0.0f.)

      Two corresponding double members whose values
      are x and y are considered equal if
      Double.valueOf(x).equals(Double.valueOf(y)).
      (Unlike the == operator, NaN is considered equal
      to itself, and 0.0 unequal to -0.0.)

      Two corresponding String, Class, enum, or
      annotation typed members whose values are x and y
      are considered equal if x.equals(y).  (Note that this
      definition is recursive for annotation typed members.)

      Two corresponding array typed members x and y
      are considered equal if Arrays.equals(x, y), for the
      appropriate overloading of Arrays.equals(long[], long[]).

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if the specified object represents an annotation
       that is logically equivalent to this one, otherwise false - `boolean`"
  ([^java.lang.annotation.Annotation this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the hash code of this annotation, as defined below:

   The hash code of an annotation is the sum of the hash codes
   of its members (including those with default values), as defined
   below:

   The hash code of an annotation member is (127 times the hash code
   of the member-name as computed by String.hashCode()) XOR
   the hash code of the member-value, as defined below:

   The hash code of a member-value depends on its type:

   The hash code of a primitive value v is equal to
       WrapperType.valueOf(v).hashCode(), where
       WrapperType is the wrapper type corresponding
       to the primitive type of v (Byte,
       Character, Double, Float, Integer,
       Long, Short, or Boolean).

   The hash code of a string, enum, class, or annotation member-value
       I     v is computed as by calling
       v.hashCode().  (In the case of annotation
       member values, this is a recursive definition.)

   The hash code of an array member-value is computed by calling
       the appropriate overloading of
       Arrays.hashCode
       on the value.  (There is one overloading for each primitive
       type, and one for object reference types.)

  returns: the hash code of this annotation - `int`"
  ([^java.lang.annotation.Annotation this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a string representation of this annotation.  The details
   of the representation are implementation-dependent, but the following
   may be regarded as typical:


     @com.acme.util.Name(first=Alfred, middle=E., last=Neuman)

  returns: a string representation of this annotation - `java.lang.String`"
  ([^java.lang.annotation.Annotation this]
    (-> this (.toString))))

(defn annotation-type
  "Returns the annotation type of this annotation.

  returns: the annotation type of this annotation - `java.lang.Class<? extends java.lang.annotation.Annotation>`"
  ([^java.lang.annotation.Annotation this]
    (-> this (.annotationType))))

