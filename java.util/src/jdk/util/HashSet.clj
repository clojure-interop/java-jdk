(ns jdk.util.HashSet
  "This class implements the Set interface, backed by a hash table
  (actually a HashMap instance).  It makes no guarantees as to the
  iteration order of the set; in particular, it does not guarantee that the
  order will remain constant over time.  This class permits the null
  element.

  This class offers constant time performance for the basic operations
  (add, remove, contains and size),
  assuming the hash function disperses the elements properly among the
  buckets.  Iterating over this set requires time proportional to the sum of
  the HashSet instance's size (the number of elements) plus the
  `capacity` of the backing HashMap instance (the number of
  buckets).  Thus, it's very important not to set the initial capacity too
  high (or the load factor too low) if iteration performance is important.

  Note that this implementation is not synchronized.
  If multiple threads access a hash set concurrently, and at least one of
  the threads modifies the set, it must be synchronized externally.
  This is typically accomplished by synchronizing on some object that
  naturally encapsulates the set.

  If no such object exists, the set should be `wrapped` using the
  Collections.synchronizedSet
  method.  This is best done at creation time, to prevent accidental
  unsynchronized access to the set:

    Set s = Collections.synchronizedSet(new HashSet(...));

  The iterators returned by this class's iterator method are
  fail-fast: if the set is modified at any time after the iterator is
  created, in any way except through the iterator's own remove
  method, the Iterator throws a ConcurrentModificationException.
  Thus, in the face of concurrent modification, the iterator fails quickly
  and cleanly, rather than risking arbitrary, non-deterministic behavior at
  an undetermined time in the future.

  Note that the fail-fast behavior of an iterator cannot be guaranteed
  as it is, generally speaking, impossible to make any hard guarantees in the
  presence of unsynchronized concurrent modification.  Fail-fast iterators
  throw ConcurrentModificationException on a best-effort basis.
  Therefore, it would be wrong to write a program that depended on this
  exception for its correctness: the fail-fast behavior of iterators
  should be used only to detect bugs.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util HashSet]))

(defn ->hash-set
  "Constructor.

  Constructs a new, empty set; the backing HashMap instance has
   the specified initial capacity and the specified load factor.

  initial-capacity - the initial capacity of the hash map - `int`
  load-factor - the load factor of the hash map - `float`

  throws: java.lang.IllegalArgumentException - if the initial capacity is less than zero, or if the load factor is nonpositive"
  ([^Integer initial-capacity ^Float load-factor]
    (new HashSet initial-capacity load-factor))
  ([^HashSet.E> c]
    (new HashSet c))
  ([]
    (new HashSet )))

(defn spliterator
  "Creates a late-binding
   and fail-fast Spliterator over the elements in this
   set.

   The Spliterator reports Spliterator.SIZED and
   Spliterator.DISTINCT.  Overriding implementations should document
   the reporting of additional characteristic values.

  returns: a Spliterator over the elements in this set - `java.util.Spliterator<HashSet.E>`"
  (^java.util.Spliterator [^java.util.HashSet this]
    (-> this (.spliterator))))

(defn contains
  "Returns true if this set contains the specified element.
   More formally, returns true if and only if this set
   contains an element e such that
   (o==null ? e==null : o.equals(e)).

  o - element whose presence in this set is to be tested - `java.lang.Object`

  returns: true if this set contains the specified element - `boolean`"
  (^Boolean [^java.util.HashSet this ^java.lang.Object o]
    (-> this (.contains o))))

(defn iterator
  "Returns an iterator over the elements in this set.  The elements
   are returned in no particular order.

  returns: an Iterator over the elements in this set - `java.util.Iterator<HashSet.E>`"
  (^java.util.Iterator [^java.util.HashSet this]
    (-> this (.iterator))))

(defn remove
  "Removes the specified element from this set if it is present.
   More formally, removes an element e such that
   (o==null ? e==null : o.equals(e)),
   if this set contains such an element.  Returns true if
   this set contained the element (or equivalently, if this set
   changed as a result of the call).  (This set will not contain the
   element once the call returns.)

  o - object to be removed from this set, if present - `java.lang.Object`

  returns: true if the set contained the specified element - `boolean`"
  (^Boolean [^java.util.HashSet this ^java.lang.Object o]
    (-> this (.remove o))))

(defn clone
  "Returns a shallow copy of this HashSet instance: the elements
   themselves are not cloned.

  returns: a shallow copy of this set - `java.lang.Object`"
  (^java.lang.Object [^java.util.HashSet this]
    (-> this (.clone))))

(defn add
  "Adds the specified element to this set if it is not already present.
   More formally, adds the specified element e to this set if
   this set contains no element e2 such that
   (e==null ? e2==null : e.equals(e2)).
   If this set already contains the element, the call leaves the set
   unchanged and returns false.

  e - element to be added to this set - `HashSet.E`

  returns: true if this set did not already contain the specified
   element - `boolean`"
  (^Boolean [^java.util.HashSet this ^HashSet.E e]
    (-> this (.add e))))

(defn empty?
  "Returns true if this set contains no elements.

  returns: true if this set contains no elements - `boolean`"
  (^Boolean [^java.util.HashSet this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of elements in this set (its cardinality).

  returns: the number of elements in this set (its cardinality) - `int`"
  (^Integer [^java.util.HashSet this]
    (-> this (.size))))

(defn clear
  "Removes all of the elements from this set.
   The set will be empty after this call returns."
  ([^java.util.HashSet this]
    (-> this (.clear))))

