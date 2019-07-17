(ns jdk.util.EnumSet>
  "A specialized Set implementation for use with enum types.  All of
  the elements in an enum set must come from a single enum type that is
  specified, explicitly or implicitly, when the set is created.  Enum sets
  are represented internally as bit vectors.  This representation is
  extremely compact and efficient. The space and time performance of this
  class should be good enough to allow its use as a high-quality, typesafe
  alternative to traditional int-based `bit flags.`  Even bulk
  operations (such as containsAll and retainAll) should
  run very quickly if their argument is also an enum set.

  The iterator returned by the iterator method traverses the
  elements in their natural order (the order in which the enum
  constants are declared).  The returned iterator is weakly
  consistent: it will never throw ConcurrentModificationException
  and it may or may not show the effects of any modifications to the set that
  occur while the iteration is in progress.

  Null elements are not permitted.  Attempts to insert a null element
  will throw NullPointerException.  Attempts to test for the
  presence of a null element or to remove one will, however, function
  properly.

  Like most collection implementations, EnumSet is not
  synchronized.  If multiple threads access an enum set concurrently, and at
  least one of the threads modifies the set, it should be synchronized
  externally.  This is typically accomplished by synchronizing on some
  object that naturally encapsulates the enum set.  If no such object exists,
  the set should be `wrapped` using the Collections.synchronizedSet(java.util.Set<T>)
  method.  This is best done at creation time, to prevent accidental
  unsynchronized access:



  Set<MyEnum> s = Collections.synchronizedSet(EnumSet.noneOf(MyEnum.class));

  Implementation note: All basic operations execute in constant time.
  They are likely (though not guaranteed) to be much faster than their
  HashSet counterparts.  Even bulk operations execute in
  constant time if their argument is also an enum set.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util EnumSet>]))

(defn *none-of
  "Creates an empty enum set with the specified element type.

  element-type - the class object of the element type for this enum set - `java.lang.Class<E>`

  returns: An empty enum set of the specified type. - `<E extends java.lang.Enum<E>> java.util.EnumSet<E>`

  throws: java.lang.NullPointerException - if elementType is null"
  ([^java.lang.Class element-type]
    (EnumSet>/noneOf element-type)))

(defn *all-of
  "Creates an enum set containing all of the elements in the specified
   element type.

  element-type - the class object of the element type for this enum set - `java.lang.Class<E>`

  returns: An enum set containing all the elements in the specified type. - `<E extends java.lang.Enum<E>> java.util.EnumSet<E>`

  throws: java.lang.NullPointerException - if elementType is null"
  ([^java.lang.Class element-type]
    (EnumSet>/allOf element-type)))

(defn *copy-of
  "Creates an enum set with the same element type as the specified enum
   set, initially containing the same elements (if any).

  s - the enum set from which to initialize this enum set - `java.util.EnumSet<E>`

  returns: A copy of the specified enum set. - `<E extends java.lang.Enum<E>> java.util.EnumSet<E>`

  throws: java.lang.NullPointerException - if s is null"
  ([^java.util.EnumSet s]
    (EnumSet>/copyOf s)))

(defn *complement-of
  "Creates an enum set with the same element type as the specified enum
   set, initially containing all the elements of this type that are
   not contained in the specified set.

  s - the enum set from whose complement to initialize this enum set - `java.util.EnumSet<E>`

  returns: The complement of the specified set in this set - `<E extends java.lang.Enum<E>> java.util.EnumSet<E>`

  throws: java.lang.NullPointerException - if s is null"
  ([^java.util.EnumSet s]
    (EnumSet>/complementOf s)))

(defn *of
  "Creates an enum set initially containing the specified elements.

   Overloadings of this method exist to initialize an enum set with
   one through five elements.  A sixth overloading is provided that
   uses the varargs feature.  This overloading may be used to create
   an enum set initially containing an arbitrary number of elements, but
   is likely to run slower than the overloadings that do not use varargs.

  e-1 - an element that this set is to contain initially - `E`
  e-2 - another element that this set is to contain initially - `E`
  e-3 - another element that this set is to contain initially - `E`
  e-4 - another element that this set is to contain initially - `E`
  e-5 - another element that this set is to contain initially - `E`

  returns: an enum set initially containing the specified elements - `<E extends java.lang.Enum<E>> java.util.EnumSet<E>`

  throws: java.lang.NullPointerException - if any parameters are null"
  ([e-1 e-2 e-3 e-4 e-5]
    (EnumSet>/of e-1 e-2 e-3 e-4 e-5))
  ([e-1 e-2 e-3 e-4]
    (EnumSet>/of e-1 e-2 e-3 e-4))
  ([e-1 e-2 e-3]
    (EnumSet>/of e-1 e-2 e-3))
  ([e-1 e-2]
    (EnumSet>/of e-1 e-2))
  ([e]
    (EnumSet>/of e)))

(defn *range
  "Creates an enum set initially containing all of the elements in the
   range defined by the two specified endpoints.  The returned set will
   contain the endpoints themselves, which may be identical but must not
   be out of order.

  from - the first element in the range - `E`
  to - the last element in the range - `E`

  returns: an enum set initially containing all of the elements in the
           range defined by the two specified endpoints - `<E extends java.lang.Enum<E>> java.util.EnumSet<E>`

  throws: java.lang.NullPointerException - if from or to are null"
  ([from to]
    (EnumSet>/range from to)))

(defn clone
  "Returns a copy of this set.

  returns: a copy of this set - `java.util.EnumSet<EnumSet.E>`"
  (^java.util.EnumSet [^java.util.EnumSet> this]
    (-> this (.clone))))

