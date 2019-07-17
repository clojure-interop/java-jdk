(ns jdk.util.IdentityHashMap
  "This class implements the Map interface with a hash table, using
  reference-equality in place of object-equality when comparing keys (and
  values).  In other words, in an IdentityHashMap, two keys
  k1 and k2 are considered equal if and only if
  (k1==k2).  (In normal Map implementations (like
  HashMap) two keys k1 and k2 are considered equal
  if and only if (k1==null ? k2==null : k1.equals(k2)).)

  This class is not a general-purpose Map
  implementation!  While this class implements the Map interface, it
  intentionally violates Map's general contract, which mandates the
  use of the equals method when comparing objects.  This class is
  designed for use only in the rare cases wherein reference-equality
  semantics are required.

  A typical use of this class is topology-preserving object graph
  transformations, such as serialization or deep-copying.  To perform such
  a transformation, a program must maintain a `node table` that keeps track
  of all the object references that have already been processed.  The node
  table must not equate distinct objects even if they happen to be equal.
  Another typical use of this class is to maintain proxy objects.  For
  example, a debugging facility might wish to maintain a proxy object for
  each object in the program being debugged.

  This class provides all of the optional map operations, and permits
  null values and the null key.  This class makes no
  guarantees as to the order of the map; in particular, it does not guarantee
  that the order will remain constant over time.

  This class provides constant-time performance for the basic
  operations (get and put), assuming the system
  identity hash function (System.identityHashCode(Object))
  disperses elements properly among the buckets.

  This class has one tuning parameter (which affects performance but not
  semantics): expected maximum size.  This parameter is the maximum
  number of key-value mappings that the map is expected to hold.  Internally,
  this parameter is used to determine the number of buckets initially
  comprising the hash table.  The precise relationship between the expected
  maximum size and the number of buckets is unspecified.

  If the size of the map (the number of key-value mappings) sufficiently
  exceeds the expected maximum size, the number of buckets is increased.
  Increasing the number of buckets (`rehashing`) may be fairly expensive, so
  it pays to create identity hash maps with a sufficiently large expected
  maximum size.  On the other hand, iteration over collection views requires
  time proportional to the number of buckets in the hash table, so it
  pays not to set the expected maximum size too high if you are especially
  concerned with iteration performance or memory usage.

  Note that this implementation is not synchronized.
  If multiple threads access an identity hash map concurrently, and at
  least one of the threads modifies the map structurally, it must
  be synchronized externally.  (A structural modification is any operation
  that adds or deletes one or more mappings; merely changing the value
  associated with a key that an instance already contains is not a
  structural modification.)  This is typically accomplished by
  synchronizing on some object that naturally encapsulates the map.

  If no such object exists, the map should be `wrapped` using the
  Collections.synchronizedMap
  method.  This is best done at creation time, to prevent accidental
  unsynchronized access to the map:

    Map m = Collections.synchronizedMap(new IdentityHashMap(...));

  The iterators returned by the iterator method of the
  collections returned by all of this class's `collection view
  methods` are fail-fast: if the map is structurally modified
  at any time after the iterator is created, in any way except
  through the iterator's own remove method, the iterator
  will throw a ConcurrentModificationException.  Thus, in the
  face of concurrent modification, the iterator fails quickly and
  cleanly, rather than risking arbitrary, non-deterministic behavior
  at an undetermined time in the future.

  Note that the fail-fast behavior of an iterator cannot be guaranteed
  as it is, generally speaking, impossible to make any hard guarantees in the
  presence of unsynchronized concurrent modification.  Fail-fast iterators
  throw ConcurrentModificationException on a best-effort basis.
  Therefore, it would be wrong to write a program that depended on this
  exception for its correctness: fail-fast iterators should be used only
  to detect bugs.

  Implementation note: This is a simple linear-probe hash table,
  as described for example in texts by Sedgewick and Knuth.  The array
  alternates holding keys and values.  (This has better locality for large
  tables than does using separate arrays.)  For many JRE implementations
  and operation mixes, this class will yield better performance than
  HashMap (which uses chaining rather than linear-probing).

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util IdentityHashMap]))

(defn ->identity-hash-map
  "Constructor.

  Constructs a new, empty map with the specified expected maximum size.
   Putting more than the expected number of key-value mappings into
   the map may cause the internal data structure to grow, which may be
   somewhat time-consuming.

  expected-max-size - the expected maximum size of the map - `int`

  throws: java.lang.IllegalArgumentException - if expectedMaxSize is negative"
  ([expected-max-size]
    (new IdentityHashMap expected-max-size))
  ([]
    (new IdentityHashMap )))

(defn values
  "Returns a Collection view of the values contained in this map.
   The collection is backed by the map, so changes to the map are
   reflected in the collection, and vice-versa.  If the map is
   modified while an iteration over the collection is in progress,
   the results of the iteration are undefined.  The collection
   supports element removal, which removes the corresponding
   mapping from the map, via the Iterator.remove,
   Collection.remove, removeAll,
   retainAll and clear methods.  It does not
   support the add or addAll methods.

   While the object returned by this method implements the
   Collection interface, it does not obey
   Collection's general contract.  Like its backing map,
   the collection returned by this method defines element equality as
   reference-equality rather than object-equality.  This affects the
   behavior of its contains, remove and
   containsAll methods.

  returns: a collection view of the values contained in this map - `java.util.Collection<IdentityHashMap.V>`"
  ([this]
    (-> this (.values))))

(defn for-each
  "Description copied from interface: Map

  action - The action to be performed for each entry - `IdentityHashMap.V>`"
  ([this action]
    (-> this (.forEach action))))

(defn replace-all
  "Description copied from interface: Map

  function - the function to apply to each entry - `IdentityHashMap.V>`"
  ([this function]
    (-> this (.replaceAll function))))

(defn put-all
  "Copies all of the mappings from the specified map to this map.
   These mappings will replace any mappings that this map had for
   any of the keys currently in the specified map.

  m - mappings to be stored in this map - `IdentityHashMap.V>`

  throws: java.lang.NullPointerException - if the specified map is null"
  ([this m]
    (-> this (.putAll m))))

(defn put
  "Associates the specified value with the specified key in this identity
   hash map.  If the map previously contained a mapping for the key, the
   old value is replaced.

  key - the key with which the specified value is to be associated - `IdentityHashMap.K`
  value - the value to be associated with the specified key - `IdentityHashMap.V`

  returns: the previous value associated with key, or
           null if there was no mapping for key.
           (A null return can also indicate that the map
           previously associated null with key.) - `IdentityHashMap.V`"
  ([this key value]
    (-> this (.put key value))))

(defn entry-set
  "Returns a Set view of the mappings contained in this map.
   Each element in the returned set is a reference-equality-based
   Map.Entry.  The set is backed by the map, so changes
   to the map are reflected in the set, and vice-versa.  If the
   map is modified while an iteration over the set is in progress,
   the results of the iteration are undefined.  The set supports
   element removal, which removes the corresponding mapping from
   the map, via the Iterator.remove, Set.remove,
   removeAll, retainAll and clear
   methods.  It does not support the add or
   addAll methods.

   Like the backing map, the Map.Entry objects in the set
   returned by this method define key and value equality as
   reference-equality rather than object-equality.  This affects the
   behavior of the equals and hashCode methods of these
   Map.Entry objects.  A reference-equality based Map.Entry
   e is equal to an object o if and only if o is a
   Map.Entry and e.getKey()==o.getKey() &&
   e.getValue()==o.getValue().  To accommodate these equals
   semantics, the hashCode method returns
   System.identityHashCode(e.getKey()) ^
   System.identityHashCode(e.getValue()).

   Owing to the reference-equality-based semantics of the
   Map.Entry instances in the set returned by this method,
   it is possible that the symmetry and transitivity requirements of
   the Object.equals(Object) contract may be violated if any of
   the entries in the set is compared to a normal map entry, or if
   the set returned by this method is compared to a set of normal map
   entries (such as would be returned by a call to this method on a normal
   map).  However, the Object.equals contract is guaranteed to
   hold among identity-based map entries, and among sets of such entries.

  returns: a set view of the identity-mappings contained in this map - `java.util.Set<java.util.Map.Entry<IdentityHashMap.K,IdentityHashMap.V>>`"
  ([this]
    (-> this (.entrySet))))

(defn contains-value
  "Tests whether the specified object reference is a value in this identity
   hash map.

  value - value whose presence in this map is to be tested - `java.lang.Object`

  returns: true if this map maps one or more keys to the
           specified object reference - `boolean`"
  ([this value]
    (-> this (.containsValue value))))

(defn remove
  "Removes the mapping for this key from this map if present.

  key - key whose mapping is to be removed from the map - `java.lang.Object`

  returns: the previous value associated with key, or
           null if there was no mapping for key.
           (A null return can also indicate that the map
           previously associated null with key.) - `IdentityHashMap.V`"
  ([this key]
    (-> this (.remove key))))

(defn key-set
  "Returns an identity-based set view of the keys contained in this map.
   The set is backed by the map, so changes to the map are reflected in
   the set, and vice-versa.  If the map is modified while an iteration
   over the set is in progress, the results of the iteration are
   undefined.  The set supports element removal, which removes the
   corresponding mapping from the map, via the Iterator.remove,
   Set.remove, removeAll, retainAll, and
   clear methods.  It does not support the add or
   addAll methods.

   While the object returned by this method implements the
   Set interface, it does not obey Set's general
   contract.  Like its backing map, the set returned by this method
   defines element equality as reference-equality rather than
   object-equality.  This affects the behavior of its contains,
   remove, containsAll, equals, and
   hashCode methods.

   The equals method of the returned set returns true
   only if the specified object is a set containing exactly the same
   object references as the returned set.  The symmetry and transitivity
   requirements of the Object.equals contract may be violated if
   the set returned by this method is compared to a normal set.  However,
   the Object.equals contract is guaranteed to hold among sets
   returned by this method.

   The hashCode method of the returned set returns the sum of
   the identity hashcodes of the elements in the set, rather than
   the sum of their hashcodes.  This is mandated by the change in the
   semantics of the equals method, in order to enforce the
   general contract of the Object.hashCode method among sets
   returned by this method.

  returns: an identity-based set view of the keys contained in this map - `java.util.Set<IdentityHashMap.K>`"
  ([this]
    (-> this (.keySet))))

(defn clone
  "Returns a shallow copy of this identity hash map: the keys and values
   themselves are not cloned.

  returns: a shallow copy of this map - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

(defn hash-code
  "Returns the hash code value for this map.  The hash code of a map is
   defined to be the sum of the hash codes of each entry in the map's
   entrySet() view.  This ensures that m1.equals(m2)
   implies that m1.hashCode()==m2.hashCode() for any two
   IdentityHashMap instances m1 and m2, as
   required by the general contract of Object.hashCode().

   Owing to the reference-equality-based semantics of the
   Map.Entry instances in the set returned by this map's
   entrySet method, it is possible that the contractual
   requirement of Object.hashCode mentioned in the previous
   paragraph will be violated if one of the two objects being compared is
   an IdentityHashMap instance and the other is a normal map.

  returns: the hash code value for this map - `int`"
  ([this]
    (-> this (.hashCode))))

(defn empty?
  "Returns true if this identity hash map contains no key-value
   mappings.

  returns: true if this identity hash map contains no key-value
           mappings - `boolean`"
  ([this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of key-value mappings in this identity hash map.

  returns: the number of key-value mappings in this map - `int`"
  ([this]
    (-> this (.size))))

(defn clear
  "Removes all of the mappings from this map.
   The map will be empty after this call returns."
  ([this]
    (-> this (.clear))))

(defn contains-key
  "Tests whether the specified object reference is a key in this identity
   hash map.

  key - possible key - `java.lang.Object`

  returns: true if the specified object reference is a key
            in this map - `boolean`"
  ([this key]
    (-> this (.containsKey key))))

(defn get
  "Returns the value to which the specified key is mapped,
   or null if this map contains no mapping for the key.

   More formally, if this map contains a mapping from a key
   k to a value v such that (key == k),
   then this method returns v; otherwise it returns
   null.  (There can be at most one such mapping.)

   A return value of null does not necessarily
   indicate that the map contains no mapping for the key; it's also
   possible that the map explicitly maps the key to null.
   The containsKey operation may be used to
   distinguish these two cases.

  key - the key whose associated value is to be returned - `java.lang.Object`

  returns: the value to which the specified key is mapped, or
           null if this map contains no mapping for the key - `IdentityHashMap.V`"
  ([this key]
    (-> this (.get key))))

(defn equals
  "Compares the specified object with this map for equality.  Returns
   true if the given object is also a map and the two maps
   represent identical object-reference mappings.  More formally, this
   map is equal to another map m if and only if
   this.entrySet().equals(m.entrySet()).

   Owing to the reference-equality-based semantics of this map it is
   possible that the symmetry and transitivity requirements of the
   Object.equals contract may be violated if this map is compared
   to a normal map.  However, the Object.equals contract is
   guaranteed to hold among IdentityHashMap instances.

  o - object to be compared for equality with this map - `java.lang.Object`

  returns: true if the specified object is equal to this map - `boolean`"
  ([this o]
    (-> this (.equals o))))

