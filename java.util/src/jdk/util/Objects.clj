(ns jdk.util.Objects
  "This class consists of static utility methods for operating
  on objects.  These utilities include null-safe or null-tolerant methods for computing the hash code of an object,
  returning a string for an object, and comparing two objects."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Objects]))

(defn *compare
  "Returns 0 if the arguments are identical and c.compare(a, b) otherwise.
   Consequently, if both arguments are null 0
   is returned.

   Note that if one of the arguments is null, a NullPointerException may or may not be thrown depending on
   what ordering policy, if any, the Comparator
   chooses to have for null values.

  a - an object - `T`
  b - an object to be compared with a - `T`
  c - the Comparator to compare the first two arguments - `java.util.Comparator`

  returns: 0 if the arguments are identical and c.compare(a, b) otherwise. - `<T> int`"
  ([a b ^java.util.Comparator c]
    (Objects/compare a b c)))

(defn *null?
  "Returns true if the provided reference is null otherwise
   returns false.

  obj - a reference to be checked against null - `java.lang.Object`

  returns: true if the provided reference is null otherwise
   false - `boolean`"
  (^Boolean [^java.lang.Object obj]
    (Objects/isNull obj)))

(defn *hash
  "Generates a hash code for a sequence of input values. The hash
   code is generated as if all the input values were placed into an
   array, and that array were hashed by calling Arrays.hashCode(Object[]).

   This method is useful for implementing Object.hashCode() on objects containing multiple fields. For
   example, if an object that has three fields, x, y, and z, one could write:



   @Override public int hashCode() {
       return Objects.hash(x, y, z);
   }

   Warning: When a single object reference is supplied, the returned
   value does not equal the hash code of that object reference. This
   value can be computed by calling hashCode(Object).

  values - the values to be hashed - `java.lang.Object`

  returns: a hash value of the sequence of input values - `int`"
  (^Integer [^java.lang.Object values]
    (Objects/hash values)))

(defn *deep-equals
  "Returns true if the arguments are deeply equal to each other
   and false otherwise.

   Two null values are deeply equal.  If both arguments are
   arrays, the algorithm in Arrays.deepEquals is used to determine equality.
   Otherwise, equality is determined by using the equals method of the first argument.

  a - an object - `java.lang.Object`
  b - an object to be compared with a for deep equality - `java.lang.Object`

  returns: true if the arguments are deeply equal to each other
   and false otherwise - `boolean`"
  (^Boolean [^java.lang.Object a ^java.lang.Object b]
    (Objects/deepEquals a b)))

(defn *to-string
  "Returns the result of calling toString on the first
   argument if the first argument is not null and returns
   the second argument otherwise.

  o - an object - `java.lang.Object`
  null-default - string to return if the first argument is null - `java.lang.String`

  returns: the result of calling toString on the first
   argument if it is not null and the second argument
   otherwise. - `java.lang.String`"
  (^java.lang.String [^java.lang.Object o ^java.lang.String null-default]
    (Objects/toString o null-default))
  (^java.lang.String [^java.lang.Object o]
    (Objects/toString o)))

(defn *require-non-null
  "Checks that the specified object reference is not null and
   throws a customized NullPointerException if it is. This method
   is designed primarily for doing parameter validation in methods and
   constructors with multiple parameters, as demonstrated below:


   public Foo(Bar bar, Baz baz) {
       this.bar = Objects.requireNonNull(bar, `bar must not be null`);
       this.baz = Objects.requireNonNull(baz, `baz must not be null`);
   }

  obj - the object reference to check for nullity - `T`
  message - detail message to be used in the event that a NullPointerException is thrown - `java.lang.String`

  returns: obj if not null - `<T> T`

  throws: java.lang.NullPointerException - if obj is null"
  ([obj ^java.lang.String message]
    (Objects/requireNonNull obj message))
  ([obj]
    (Objects/requireNonNull obj)))

(defn *non-null
  "Returns true if the provided reference is non-null
   otherwise returns false.

  obj - a reference to be checked against null - `java.lang.Object`

  returns: true if the provided reference is non-null
   otherwise false - `boolean`"
  (^Boolean [^java.lang.Object obj]
    (Objects/nonNull obj)))

(defn *hash-code
  "Returns the hash code of a non-null argument and 0 for
   a null argument.

  o - an object - `java.lang.Object`

  returns: the hash code of a non-null argument and 0 for
   a null argument - `int`"
  (^Integer [^java.lang.Object o]
    (Objects/hashCode o)))

(defn *equals
  "Returns true if the arguments are equal to each other
   and false otherwise.
   Consequently, if both arguments are null, true
   is returned and if exactly one argument is null, false is returned.  Otherwise, equality is determined by using
   the equals method of the first
   argument.

  a - an object - `java.lang.Object`
  b - an object to be compared with a for equality - `java.lang.Object`

  returns: true if the arguments are equal to each other
   and false otherwise - `boolean`"
  (^Boolean [^java.lang.Object a ^java.lang.Object b]
    (Objects/equals a b)))

