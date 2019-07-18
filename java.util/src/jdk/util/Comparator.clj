(ns jdk.util.Comparator
  "A comparison function, which imposes a total ordering on some
  collection of objects.  Comparators can be passed to a sort method (such
  as Collections.sort or Arrays.sort) to allow precise control
  over the sort order.  Comparators can also be used to control the order of
  certain data structures (such as sorted sets or sorted maps), or to provide an ordering for collections of
  objects that don't have a natural ordering.

  The ordering imposed by a comparator c on a set of elements
  S is said to be consistent with equals if and only if
  c.compare(e1, e2)==0 has the same boolean value as
  e1.equals(e2) for every e1 and e2 in
  S.

  Caution should be exercised when using a comparator capable of imposing an
  ordering inconsistent with equals to order a sorted set (or sorted map).
  Suppose a sorted set (or sorted map) with an explicit comparator c
  is used with elements (or keys) drawn from a set S.  If the
  ordering imposed by c on S is inconsistent with equals,
  the sorted set (or sorted map) will behave `strangely.`  In particular the
  sorted set (or sorted map) will violate the general contract for set (or
  map), which is defined in terms of equals.

  For example, suppose one adds two elements a and b such that
  (a.equals(b) && c.compare(a, b) != 0)
  to an empty TreeSet with comparator c.
  The second add operation will return
  true (and the size of the tree set will increase) because a and
  b are not equivalent from the tree set's perspective, even though
  this is contrary to the specification of the
  Set.add method.

  Note: It is generally a good idea for comparators to also implement
  java.io.Serializable, as they may be used as ordering methods in
  serializable data structures (like TreeSet, TreeMap).  In
  order for the data structure to serialize successfully, the comparator (if
  provided) must implement Serializable.

  For the mathematically inclined, the relation that defines the
  imposed ordering that a given comparator c imposes on a
  given set of objects S is:

        {(x, y) such that c.compare(x, y) <= 0}. The quotient for this total order is:

        {(x, y) such that c.compare(x, y) == 0}.

  It follows immediately from the contract for compare that the
  quotient is an equivalence relation on S, and that the
  imposed ordering is a total order on S.  When we say that
  the ordering imposed by c on S is consistent with
  equals, we mean that the quotient for the ordering is the equivalence
  relation defined by the objects' equals(Object) method(s):

      {(x, y) such that x.equals(y)}.

  Unlike Comparable, a comparator may optionally permit
  comparison of null arguments, while maintaining the requirements for
  an equivalence relation.

  This interface is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Comparator]))

(defn compare
  "Compares its two arguments for order.  Returns a negative integer,
   zero, or a positive integer as the first argument is less than, equal
   to, or greater than the second.

   In the foregoing description, the notation
   sgn(expression) designates the mathematical
   signum function, which is defined to return one of -1,
   0, or 1 according to whether the value of
   expression is negative, zero or positive.

   The implementor must ensure that sgn(compare(x, y)) ==
   -sgn(compare(y, x)) for all x and y.  (This
   implies that compare(x, y) must throw an exception if and only
   if compare(y, x) throws an exception.)

   The implementor must also ensure that the relation is transitive:
   ((compare(x, y)>0) && (compare(y, z)>0)) implies
   compare(x, z)>0.

   Finally, the implementor must ensure that compare(x, y)==0
   implies that sgn(compare(x, z))==sgn(compare(y, z)) for all
   z.

   It is generally the case, but not strictly required that
   (compare(x, y)==0) == (x.equals(y)).  Generally speaking,
   any comparator that violates this condition should clearly indicate
   this fact.  The recommended language is `Note: this comparator
   imposes orderings that are inconsistent with equals.`

  o-1 - the first object to be compared. - `T`
  o-2 - the second object to be compared. - `T`

  returns: a negative integer, zero, or a positive integer as the
           first argument is less than, equal to, or greater than the
           second. - `int`

  throws: java.lang.NullPointerException - if an argument is null and this comparator does not permit null arguments"
  (^Integer [^Comparator this o-1 o-2]
    (-> this (.compare o-1 o-2))))

(defn reversed
  "Returns a comparator that imposes the reverse ordering of this
   comparator.

  returns: a comparator that imposes the reverse ordering of this
           comparator. - `default java.util.Comparator<T>`"
  ([^Comparator this]
    (-> this (.reversed))))

(defn *nulls-first
  "Returns a null-friendly comparator that considers null to be
   less than non-null. When both are null, they are considered
   equal. If both are non-null, the specified Comparator is used
   to determine the order. If the specified comparator is null,
   then the returned comparator considers all non-null values to be equal.

   The returned comparator is serializable if the specified comparator
   is serializable.

  comparator - a Comparator for comparing non-null values - `java.util.Comparator`

  returns: a comparator that considers null to be less than
           non-null, and compares non-null objects with the supplied
           Comparator. - `<T> java.util.Comparator<T>`"
  ([^java.util.Comparator comparator]
    (Comparator/nullsFirst comparator)))

(defn then-comparing-long
  "Returns a lexicographic-order comparator with a function that
   extracts a long sort key.

  key-extractor - the function used to extract the long sort key - `java.util.function.ToLongFunction`

  returns: a lexicographic-order comparator composed of this and then the
           long sort key - `default java.util.Comparator<T>`

  throws: java.lang.NullPointerException - if the argument is null."
  ([^Comparator this ^java.util.function.ToLongFunction key-extractor]
    (-> this (.thenComparingLong key-extractor))))

(defn then-comparing-int
  "Returns a lexicographic-order comparator with a function that
   extracts a int sort key.

  key-extractor - the function used to extract the integer sort key - `java.util.function.ToIntFunction`

  returns: a lexicographic-order comparator composed of this and then the
           int sort key - `default java.util.Comparator<T>`

  throws: java.lang.NullPointerException - if the argument is null."
  ([^Comparator this ^java.util.function.ToIntFunction key-extractor]
    (-> this (.thenComparingInt key-extractor))))

(defn *comparing-double
  "Accepts a function that extracts a double sort key from a type
   T, and returns a Comparator<T> that compares by that
   sort key.

   The returned comparator is serializable if the specified function
   is also serializable.

  key-extractor - the function used to extract the double sort key - `java.util.function.ToDoubleFunction`

  returns: a comparator that compares by an extracted key - `<T> java.util.Comparator<T>`

  throws: java.lang.NullPointerException - if the argument is null"
  ([^java.util.function.ToDoubleFunction key-extractor]
    (Comparator/comparingDouble key-extractor)))

(defn then-comparing
  "Returns a lexicographic-order comparator with a function that
   extracts a key to be compared with the given Comparator.

  key-extractor - the function used to extract the sort key - `java.util.function.Function`
  key-comparator - the Comparator used to compare the sort key - `java.util.Comparator`

  returns: a lexicographic-order comparator composed of this comparator
           and then comparing on the key extracted by the keyExtractor function - `default <U> java.util.Comparator<T>`

  throws: java.lang.NullPointerException - if either argument is null."
  ([^Comparator this ^java.util.function.Function key-extractor ^java.util.Comparator key-comparator]
    (-> this (.thenComparing key-extractor key-comparator)))
  ([^Comparator this ^java.util.Comparator other]
    (-> this (.thenComparing other))))

(defn *natural-order
  "Returns a comparator that compares Comparable objects in natural
   order.

   The returned comparator is serializable and throws NullPointerException when comparing null.

  returns: a comparator that imposes the natural ordering on Comparable objects. - `<T extends java.lang.Comparable<? super T>> java.util.Comparator<T>`"
  ([]
    (Comparator/naturalOrder )))

(defn then-comparing-double
  "Returns a lexicographic-order comparator with a function that
   extracts a double sort key.

  key-extractor - the function used to extract the double sort key - `java.util.function.ToDoubleFunction`

  returns: a lexicographic-order comparator composed of this and then the
           double sort key - `default java.util.Comparator<T>`

  throws: java.lang.NullPointerException - if the argument is null."
  ([^Comparator this ^java.util.function.ToDoubleFunction key-extractor]
    (-> this (.thenComparingDouble key-extractor))))

(defn *reverse-order
  "Returns a comparator that imposes the reverse of the natural
   ordering.

   The returned comparator is serializable and throws NullPointerException when comparing null.

  returns: a comparator that imposes the reverse of the natural
           ordering on Comparable objects. - `<T extends java.lang.Comparable<? super T>> java.util.Comparator<T>`"
  ([]
    (Comparator/reverseOrder )))

(defn *comparing-long
  "Accepts a function that extracts a long sort key from a type
   T, and returns a Comparator<T> that compares by that
   sort key.

   The returned comparator is serializable if the specified function is
   also serializable.

  key-extractor - the function used to extract the long sort key - `java.util.function.ToLongFunction`

  returns: a comparator that compares by an extracted key - `<T> java.util.Comparator<T>`

  throws: java.lang.NullPointerException - if the argument is null"
  ([^java.util.function.ToLongFunction key-extractor]
    (Comparator/comparingLong key-extractor)))

(defn *comparing
  "Accepts a function that extracts a sort key from a type T, and
   returns a Comparator<T> that compares by that sort key using
   the specified Comparator.

   The returned comparator is serializable if the specified function
   and comparator are both serializable.

  key-extractor - the function used to extract the sort key - `java.util.function.Function`
  key-comparator - the Comparator used to compare the sort key - `java.util.Comparator`

  returns: a comparator that compares by an extracted key using the
           specified Comparator - `<T,U> java.util.Comparator<T>`

  throws: java.lang.NullPointerException - if either argument is null"
  ([^java.util.function.Function key-extractor ^java.util.Comparator key-comparator]
    (Comparator/comparing key-extractor key-comparator))
  ([^java.util.function.Function key-extractor]
    (Comparator/comparing key-extractor)))

(defn *comparing-int
  "Accepts a function that extracts an int sort key from a type
   T, and returns a Comparator<T> that compares by that
   sort key.

   The returned comparator is serializable if the specified function
   is also serializable.

  key-extractor - the function used to extract the integer sort key - `java.util.function.ToIntFunction`

  returns: a comparator that compares by an extracted key - `<T> java.util.Comparator<T>`

  throws: java.lang.NullPointerException - if the argument is null"
  ([^java.util.function.ToIntFunction key-extractor]
    (Comparator/comparingInt key-extractor)))

(defn equals
  "Indicates whether some other object is `equal to` this
   comparator.  This method must obey the general contract of
   Object.equals(Object).  Additionally, this method can return
   true only if the specified object is also a comparator
   and it imposes the same ordering as this comparator.  Thus,
   comp1.equals(comp2) implies that sgn(comp1.compare(o1,
   o2))==sgn(comp2.compare(o1, o2)) for every object reference
   o1 and o2.

   Note that it is always safe not to override
   Object.equals(Object).  However, overriding this method may,
   in some cases, improve performance by allowing programs to determine
   that two distinct comparators impose the same order.

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true only if the specified object is also
            a comparator and it imposes the same ordering as this
            comparator. - `boolean`"
  (^Boolean [^Comparator this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn *nulls-last
  "Returns a null-friendly comparator that considers null to be
   greater than non-null. When both are null, they are considered
   equal. If both are non-null, the specified Comparator is used
   to determine the order. If the specified comparator is null,
   then the returned comparator considers all non-null values to be equal.

   The returned comparator is serializable if the specified comparator
   is serializable.

  comparator - a Comparator for comparing non-null values - `java.util.Comparator`

  returns: a comparator that considers null to be greater than
           non-null, and compares non-null objects with the supplied
           Comparator. - `<T> java.util.Comparator<T>`"
  ([^java.util.Comparator comparator]
    (Comparator/nullsLast comparator)))

