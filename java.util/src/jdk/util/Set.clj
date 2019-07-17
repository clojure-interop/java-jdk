(ns jdk.util.Set
  "A collection that contains no duplicate elements.  More formally, sets
  contain no pair of elements e1 and e2 such that
  e1.equals(e2), and at most one null element.  As implied by
  its name, this interface models the mathematical set abstraction.

  The Set interface places additional stipulations, beyond those
  inherited from the Collection interface, on the contracts of all
  constructors and on the contracts of the add, equals and
  hashCode methods.  Declarations for other inherited methods are
  also included here for convenience.  (The specifications accompanying these
  declarations have been tailored to the Set interface, but they do
  not contain any additional stipulations.)

  The additional stipulation on constructors is, not surprisingly,
  that all constructors must create a set that contains no duplicate elements
  (as defined above).

  Note: Great care must be exercised if mutable objects are used as set
  elements.  The behavior of a set is not specified if the value of an object
  is changed in a manner that affects equals comparisons while the
  object is an element in the set.  A special case of this prohibition is
  that it is not permissible for a set to contain itself as an element.

  Some set implementations have restrictions on the elements that
  they may contain.  For example, some implementations prohibit null elements,
  and some have restrictions on the types of their elements.  Attempting to
  add an ineligible element throws an unchecked exception, typically
  NullPointerException or ClassCastException.  Attempting
  to query the presence of an ineligible element may throw an exception,
  or it may simply return false; some implementations will exhibit the former
  behavior and some will exhibit the latter.  More generally, attempting an
  operation on an ineligible element whose completion would not result in
  the insertion of an ineligible element into the set may throw an
  exception or it may succeed, at the option of the implementation.
  Such exceptions are marked as `optional` in the specification for this
  interface.

  This interface is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Set]))

(defn add-all
  "Adds all of the elements in the specified collection to this set if
   they're not already present (optional operation).  If the specified
   collection is also a set, the addAll operation effectively
   modifies this set so that its value is the union of the two
   sets.  The behavior of this operation is undefined if the specified
   collection is modified while the operation is in progress.

  c - collection containing elements to be added to this set - `Set.E>`

  returns: true if this set changed as a result of the call - `boolean`

  throws: java.lang.UnsupportedOperationException - if the addAll operation is not supported by this set"
  ([^java.util.Set this ^Set.E> c]
    (-> this (.addAll c))))

(defn spliterator
  "Creates a Spliterator over the elements in this set.

   The Spliterator reports Spliterator.DISTINCT.
   Implementations should document the reporting of additional
   characteristic values.

  returns: a Spliterator over the elements in this set - `default java.util.Spliterator<Set.E>`"
  ([^java.util.Set this]
    (-> this (.spliterator))))

(defn contains
  "Returns true if this set contains the specified element.
   More formally, returns true if and only if this set
   contains an element e such that
   (o==null ? e==null : o.equals(e)).

  o - element whose presence in this set is to be tested - `java.lang.Object`

  returns: true if this set contains the specified element - `boolean`

  throws: java.lang.ClassCastException - if the type of the specified element is incompatible with this set (optional)"
  ([^java.util.Set this ^java.lang.Object o]
    (-> this (.contains o))))

(defn iterator
  "Returns an iterator over the elements in this set.  The elements are
   returned in no particular order (unless this set is an instance of some
   class that provides a guarantee).

  returns: an iterator over the elements in this set - `java.util.Iterator<Set.E>`"
  ([^java.util.Set this]
    (-> this (.iterator))))

(defn remove
  "Removes the specified element from this set if it is present
   (optional operation).  More formally, removes an element e
   such that
   (o==null ? e==null : o.equals(e)), if
   this set contains such an element.  Returns true if this set
   contained the element (or equivalently, if this set changed as a
   result of the call).  (This set will not contain the element once the
   call returns.)

  o - object to be removed from this set, if present - `java.lang.Object`

  returns: true if this set contained the specified element - `boolean`

  throws: java.lang.ClassCastException - if the type of the specified element is incompatible with this set (optional)"
  ([^java.util.Set this ^java.lang.Object o]
    (-> this (.remove o))))

(defn hash-code
  "Returns the hash code value for this set.  The hash code of a set is
   defined to be the sum of the hash codes of the elements in the set,
   where the hash code of a null element is defined to be zero.
   This ensures that s1.equals(s2) implies that
   s1.hashCode()==s2.hashCode() for any two sets s1
   and s2, as required by the general contract of
   Object.hashCode().

  returns: the hash code value for this set - `int`"
  ([^java.util.Set this]
    (-> this (.hashCode))))

(defn add
  "Adds the specified element to this set if it is not already present
   (optional operation).  More formally, adds the specified element
   e to this set if the set contains no element e2
   such that
   (e==null ? e2==null : e.equals(e2)).
   If this set already contains the element, the call leaves the set
   unchanged and returns false.  In combination with the
   restriction on constructors, this ensures that sets never contain
   duplicate elements.

   The stipulation above does not imply that sets must accept all
   elements; sets may refuse to add any particular element, including
   null, and throw an exception, as described in the
   specification for Collection.add.
   Individual set implementations should clearly document any
   restrictions on the elements that they may contain.

  e - element to be added to this set - `Set.E`

  returns: true if this set did not already contain the specified
           element - `boolean`

  throws: java.lang.UnsupportedOperationException - if the add operation is not supported by this set"
  ([^java.util.Set this ^Set.E e]
    (-> this (.add e))))

(defn empty?
  "Returns true if this set contains no elements.

  returns: true if this set contains no elements - `boolean`"
  ([^java.util.Set this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of elements in this set (its cardinality).  If this
   set contains more than Integer.MAX_VALUE elements, returns
   Integer.MAX_VALUE.

  returns: the number of elements in this set (its cardinality) - `int`"
  ([^java.util.Set this]
    (-> this (.size))))

(defn retain-all
  "Retains only the elements in this set that are contained in the
   specified collection (optional operation).  In other words, removes
   from this set all of its elements that are not contained in the
   specified collection.  If the specified collection is also a set, this
   operation effectively modifies this set so that its value is the
   intersection of the two sets.

  c - collection containing elements to be retained in this set - `java.util.Collection<?>`

  returns: true if this set changed as a result of the call - `boolean`

  throws: java.lang.UnsupportedOperationException - if the retainAll operation is not supported by this set"
  ([^java.util.Set this ^java.util.Collection c]
    (-> this (.retainAll c))))

(defn clear
  "Removes all of the elements from this set (optional operation).
   The set will be empty after this call returns.

  throws: java.lang.UnsupportedOperationException - if the clear method is not supported by this set"
  ([^java.util.Set this]
    (-> this (.clear))))

(defn to-array
  "Returns an array containing all of the elements in this set; the
   runtime type of the returned array is that of the specified array.
   If the set fits in the specified array, it is returned therein.
   Otherwise, a new array is allocated with the runtime type of the
   specified array and the size of this set.

   If this set fits in the specified array with room to spare
   (i.e., the array has more elements than this set), the element in
   the array immediately following the end of the set is set to
   null.  (This is useful in determining the length of this
   set only if the caller knows that this set does not contain
   any null elements.)

   If this set makes any guarantees as to what order its elements
   are returned by its iterator, this method must return the elements
   in the same order.

   Like the toArray() method, this method acts as bridge between
   array-based and collection-based APIs.  Further, this method allows
   precise control over the runtime type of the output array, and may,
   under certain circumstances, be used to save allocation costs.

   Suppose x is a set known to contain only strings.
   The following code can be used to dump the set into a newly allocated
   array of String:



       String[] y = x.toArray(new String[0]);

   Note that toArray(new Object[0]) is identical in function to
   toArray().

  a - the array into which the elements of this set are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose. - `T[]`

  returns: an array containing all the elements in this set - `<T> T[]`

  throws: java.lang.ArrayStoreException - if the runtime type of the specified array is not a supertype of the runtime type of every element in this set"
  ([^java.util.Set this a]
    (-> this (.toArray a)))
  ([^java.util.Set this]
    (-> this (.toArray))))

(defn remove-all
  "Removes from this set all of its elements that are contained in the
   specified collection (optional operation).  If the specified
   collection is also a set, this operation effectively modifies this
   set so that its value is the asymmetric set difference of
   the two sets.

  c - collection containing elements to be removed from this set - `java.util.Collection<?>`

  returns: true if this set changed as a result of the call - `boolean`

  throws: java.lang.UnsupportedOperationException - if the removeAll operation is not supported by this set"
  ([^java.util.Set this ^java.util.Collection c]
    (-> this (.removeAll c))))

(defn equals
  "Compares the specified object with this set for equality.  Returns
   true if the specified object is also a set, the two sets
   have the same size, and every member of the specified set is
   contained in this set (or equivalently, every member of this set is
   contained in the specified set).  This definition ensures that the
   equals method works properly across different implementations of the
   set interface.

  o - object to be compared for equality with this set - `java.lang.Object`

  returns: true if the specified object is equal to this set - `boolean`"
  ([^java.util.Set this ^java.lang.Object o]
    (-> this (.equals o))))

(defn contains-all
  "Returns true if this set contains all of the elements of the
   specified collection.  If the specified collection is also a set, this
   method returns true if it is a subset of this set.

  c - collection to be checked for containment in this set - `java.util.Collection<?>`

  returns: true if this set contains all of the elements of the
           specified collection - `boolean`

  throws: java.lang.ClassCastException - if the types of one or more elements in the specified collection are incompatible with this set (optional)"
  ([^java.util.Set this ^java.util.Collection c]
    (-> this (.containsAll c))))

