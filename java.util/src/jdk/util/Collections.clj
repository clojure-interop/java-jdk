(ns jdk.util.Collections
  "This class consists exclusively of static methods that operate on or return
  collections.  It contains polymorphic algorithms that operate on
  collections, `wrappers`, which return a new collection backed by a
  specified collection, and a few other odds and ends.

  The methods of this class all throw a NullPointerException
  if the collections or class objects provided to them are null.

  The documentation for the polymorphic algorithms contained in this class
  generally includes a brief description of the implementation.  Such
  descriptions should be regarded as implementation notes, rather than
  parts of the specification.  Implementors should feel free to
  substitute other algorithms, so long as the specification itself is adhered
  to.  (For example, the algorithm used by sort does not have to be
  a mergesort, but it does have to be stable.)

  The `destructive` algorithms contained in this class, that is, the
  algorithms that modify the collection on which they operate, are specified
  to throw UnsupportedOperationException if the collection does not
  support the appropriate mutation primitive(s), such as the set
  method.  These algorithms may, but are not required to, throw this
  exception if an invocation would have no effect on the collection.  For
  example, invoking the sort method on an unmodifiable list that is
  already sorted may or may not throw UnsupportedOperationException.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Collections]))

(def *-empty-set
  "Static Constant.

  The empty set (immutable).  This set is serializable.

  type: java.util.Set"
  Collections/EMPTY_SET)

(def *-empty-list
  "Static Constant.

  The empty list (immutable).  This list is serializable.

  type: java.util.List"
  Collections/EMPTY_LIST)

(def *-empty-map
  "Static Constant.

  The empty map (immutable).  This map is serializable.

  type: java.util.Map"
  Collections/EMPTY_MAP)

(defn *add-all
  "Adds all of the specified elements to the specified collection.
   Elements to be added may be specified individually or as an array.
   The behavior of this convenience method is identical to that of
   c.addAll(Arrays.asList(elements)), but this method is likely
   to run significantly faster under most implementations.

   When elements are specified individually, this method provides a
   convenient way to add a few elements to an existing collection:


       Collections.addAll(flavors, `Peaches 'n Plutonium`, `Rocky Racoon`);

  c - the collection into which elements are to be inserted - `java.util.Collection`
  elements - the elements to insert into c - `T`

  returns: true if the collection changed as a result of the call - `<T> boolean`

  throws: java.lang.UnsupportedOperationException - if c does not support the add operation"
  ([^java.util.Collection c elements]
    (Collections/addAll c elements)))

(defn *checked-sorted-map
  "Returns a dynamically typesafe view of the specified sorted map.
   Any attempt to insert a mapping whose key or value have the wrong
   type will result in an immediate ClassCastException.
   Similarly, any attempt to modify the value currently associated with
   a key will result in an immediate ClassCastException,
   whether the modification is attempted directly through the map
   itself, or through a Map.Entry instance obtained from the
   map's entry set view.

   Assuming a map contains no incorrectly typed keys or values
   prior to the time a dynamically typesafe view is generated, and
   that all subsequent access to the map takes place through the view
   (or one of its collection views), it is guaranteed that the
   map cannot contain an incorrectly typed key or value.

   A discussion of the use of dynamically typesafe views may be
   found in the documentation for the checkedCollection method.

   The returned map will be serializable if the specified map is
   serializable.

   Since null is considered to be a value of any reference
   type, the returned map permits insertion of null keys or values
   whenever the backing map does.

  m - the map for which a dynamically typesafe view is to be returned - `java.util.SortedMap`
  key-type - the type of key that m is permitted to hold - `java.lang.Class`
  value-type - the type of value that m is permitted to hold - `java.lang.Class`

  returns: a dynamically typesafe view of the specified map - `<K,V> java.util.SortedMap<K,V>`"
  ([^java.util.SortedMap m ^java.lang.Class key-type ^java.lang.Class value-type]
    (Collections/checkedSortedMap m key-type value-type)))

(defn *synchronized-sorted-set
  "Returns a synchronized (thread-safe) sorted set backed by the specified
   sorted set.  In order to guarantee serial access, it is critical that
   all access to the backing sorted set is accomplished
   through the returned sorted set (or its views).

   It is imperative that the user manually synchronize on the returned
   sorted set when iterating over it or any of its subSet,
   headSet, or tailSet views.


    SortedSet s = Collections.synchronizedSortedSet(new TreeSet());
        ...
    synchronized (s) {
        Iterator i = s.iterator(); // Must be in the synchronized block
        while (i.hasNext())
            foo(i.next());
    }
   or:


    SortedSet s = Collections.synchronizedSortedSet(new TreeSet());
    SortedSet s2 = s.headSet(foo);
        ...
    synchronized (s) {  // Note: s, not s2!!!
        Iterator i = s2.iterator(); // Must be in the synchronized block
        while (i.hasNext())
            foo(i.next());
    }
   Failure to follow this advice may result in non-deterministic behavior.

   The returned sorted set will be serializable if the specified
   sorted set is serializable.

  s - the sorted set to be `wrapped` in a synchronized sorted set. - `java.util.SortedSet`

  returns: a synchronized view of the specified sorted set. - `<T> java.util.SortedSet<T>`"
  ([^java.util.SortedSet s]
    (Collections/synchronizedSortedSet s)))

(defn *singleton
  "Returns an immutable set containing only the specified object.
   The returned set is serializable.

  o - the sole object to be stored in the returned set. - `T`

  returns: an immutable set containing only the specified object. - `<T> java.util.Set<T>`"
  ([o]
    (Collections/singleton o)))

(defn *checked-set
  "Returns a dynamically typesafe view of the specified set.
   Any attempt to insert an element of the wrong type will result in
   an immediate ClassCastException.  Assuming a set contains
   no incorrectly typed elements prior to the time a dynamically typesafe
   view is generated, and that all subsequent access to the set
   takes place through the view, it is guaranteed that the
   set cannot contain an incorrectly typed element.

   A discussion of the use of dynamically typesafe views may be
   found in the documentation for the checkedCollection method.

   The returned set will be serializable if the specified set is
   serializable.

   Since null is considered to be a value of any reference
   type, the returned set permits insertion of null elements whenever
   the backing set does.

  s - the set for which a dynamically typesafe view is to be returned - `java.util.Set`
  type - the type of element that s is permitted to hold - `java.lang.Class`

  returns: a dynamically typesafe view of the specified set - `<E> java.util.Set<E>`"
  ([^java.util.Set s ^java.lang.Class type]
    (Collections/checkedSet s type)))

(defn *min
  "Returns the minimum element of the given collection, according to the
   order induced by the specified comparator.  All elements in the
   collection must be mutually comparable by the specified
   comparator (that is, comp.compare(e1, e2) must not throw a
   ClassCastException for any elements e1 and
   e2 in the collection).

   This method iterates over the entire collection, hence it requires
   time proportional to the size of the collection.

  coll - the collection whose minimum element is to be determined. - `java.util.Collection`
  comp - the comparator with which to determine the minimum element. A null value indicates that the elements' natural ordering should be used. - `java.util.Comparator`

  returns: the minimum element of the given collection, according
           to the specified comparator. - `<T> T`

  throws: java.lang.ClassCastException - if the collection contains elements that are not mutually comparable using the specified comparator."
  ([^java.util.Collection coll ^java.util.Comparator comp]
    (Collections/min coll comp))
  ([^java.util.Collection coll]
    (Collections/min coll)))

(defn *list
  "Returns an array list containing the elements returned by the
   specified enumeration in the order they are returned by the
   enumeration.  This method provides interoperability between
   legacy APIs that return enumerations and new APIs that require
   collections.

  e - enumeration providing elements for the returned array list - `java.util.Enumeration`

  returns: an array list containing the elements returned
           by the specified enumeration. - `<T> java.util.ArrayList<T>`"
  ([^java.util.Enumeration e]
    (Collections/list e)))

(defn *unmodifiable-navigable-map
  "Returns an unmodifiable view of the specified navigable map.  This method
   allows modules to provide users with `read-only` access to internal
   navigable maps.  Query operations on the returned navigable map `read
   through` to the specified navigable map.  Attempts to modify the returned
   navigable map, whether direct, via its collection views, or via its
   subMap, headMap, or tailMap views, result in
   an UnsupportedOperationException.

   The returned navigable map will be serializable if the specified
   navigable map is serializable.

  m - the navigable map for which an unmodifiable view is to be returned - `java.util.NavigableMap`

  returns: an unmodifiable view of the specified navigable map - `<K,V> java.util.NavigableMap<K,V>`"
  ([^java.util.NavigableMap m]
    (Collections/unmodifiableNavigableMap m)))

(defn *replace-all
  "Replaces all occurrences of one specified value in a list with another.
   More formally, replaces with newVal each element e
   in list such that
   (oldVal==null ? e==null : oldVal.equals(e)).
   (This method has no effect on the size of the list.)

  list - the list in which replacement is to occur. - `java.util.List`
  old-val - the old value to be replaced. - `T`
  new-val - the new value with which oldVal is to be replaced. - `T`

  returns: true if list contained one or more elements
           e such that
           (oldVal==null ?  e==null : oldVal.equals(e)). - `<T> boolean`

  throws: java.lang.UnsupportedOperationException - if the specified list or its list-iterator does not support the set operation."
  ([^java.util.List list old-val new-val]
    (Collections/replaceAll list old-val new-val)))

(defn *copy
  "Copies all of the elements from one list into another.  After the
   operation, the index of each copied element in the destination list
   will be identical to its index in the source list.  The destination
   list must be at least as long as the source list.  If it is longer, the
   remaining elements in the destination list are unaffected.

   This method runs in linear time.

  dest - The destination list. - `java.util.List`
  src - The source list. - `java.util.List`

  returns: `<T> void`

  throws: java.lang.IndexOutOfBoundsException - if the destination list is too small to contain the entire source List."
  ([^java.util.List dest ^java.util.List src]
    (Collections/copy dest src)))

(defn *as-lifo-queue
  "Returns a view of a Deque as a Last-in-first-out (Lifo)
   Queue. Method add is mapped to push,
   remove is mapped to pop and so on. This
   view can be useful when you would like to use a method
   requiring a Queue but you need Lifo ordering.

   Each method invocation on the queue returned by this method
   results in exactly one method invocation on the backing deque, with
   one exception.  The addAll method is
   implemented as a sequence of addFirst
   invocations on the backing deque.

  deque - the deque - `java.util.Deque`

  returns: the queue - `<T> java.util.Queue<T>`"
  ([^java.util.Deque deque]
    (Collections/asLifoQueue deque)))

(defn *unmodifiable-collection
  "Returns an unmodifiable view of the specified collection.  This method
   allows modules to provide users with `read-only` access to internal
   collections.  Query operations on the returned collection `read through`
   to the specified collection, and attempts to modify the returned
   collection, whether direct or via its iterator, result in an
   UnsupportedOperationException.

   The returned collection does not pass the hashCode and equals
   operations through to the backing collection, but relies on
   Object's equals and hashCode methods.  This
   is necessary to preserve the contracts of these operations in the case
   that the backing collection is a set or a list.

   The returned collection will be serializable if the specified collection
   is serializable.

  c - the collection for which an unmodifiable view is to be returned. - `java.util.Collection`

  returns: an unmodifiable view of the specified collection. - `<T> java.util.Collection<T>`"
  ([^java.util.Collection c]
    (Collections/unmodifiableCollection c)))

(defn *checked-list
  "Returns a dynamically typesafe view of the specified list.
   Any attempt to insert an element of the wrong type will result in
   an immediate ClassCastException.  Assuming a list contains
   no incorrectly typed elements prior to the time a dynamically typesafe
   view is generated, and that all subsequent access to the list
   takes place through the view, it is guaranteed that the
   list cannot contain an incorrectly typed element.

   A discussion of the use of dynamically typesafe views may be
   found in the documentation for the checkedCollection method.

   The returned list will be serializable if the specified list
   is serializable.

   Since null is considered to be a value of any reference
   type, the returned list permits insertion of null elements whenever
   the backing list does.

  list - the list for which a dynamically typesafe view is to be returned - `java.util.List`
  type - the type of element that list is permitted to hold - `java.lang.Class`

  returns: a dynamically typesafe view of the specified list - `<E> java.util.List<E>`"
  ([^java.util.List list ^java.lang.Class type]
    (Collections/checkedList list type)))

(defn *reverse
  "Reverses the order of the elements in the specified list.

   This method runs in linear time.

  list - the list whose elements are to be reversed. - `java.util.List`

  throws: java.lang.UnsupportedOperationException - if the specified list or its list-iterator does not support the set operation."
  ([^java.util.List list]
    (Collections/reverse list)))

(defn *synchronized-navigable-set
  "Returns a synchronized (thread-safe) navigable set backed by the
   specified navigable set.  In order to guarantee serial access, it is
   critical that all access to the backing navigable set is
   accomplished through the returned navigable set (or its views).

   It is imperative that the user manually synchronize on the returned
   navigable set when iterating over it or any of its subSet,
   headSet, or tailSet views.


    NavigableSet s = Collections.synchronizedNavigableSet(new TreeSet());
        ...
    synchronized (s) {
        Iterator i = s.iterator(); // Must be in the synchronized block
        while (i.hasNext())
            foo(i.next());
    }
   or:


    NavigableSet s = Collections.synchronizedNavigableSet(new TreeSet());
    NavigableSet s2 = s.headSet(foo, true);
        ...
    synchronized (s) {  // Note: s, not s2!!!
        Iterator i = s2.iterator(); // Must be in the synchronized block
        while (i.hasNext())
            foo(i.next());
    }
   Failure to follow this advice may result in non-deterministic behavior.

   The returned navigable set will be serializable if the specified
   navigable set is serializable.

  s - the navigable set to be `wrapped` in a synchronized navigable set - `java.util.NavigableSet`

  returns: a synchronized view of the specified navigable set - `<T> java.util.NavigableSet<T>`"
  ([^java.util.NavigableSet s]
    (Collections/synchronizedNavigableSet s)))

(defn *synchronized-sorted-map
  "Returns a synchronized (thread-safe) sorted map backed by the specified
   sorted map.  In order to guarantee serial access, it is critical that
   all access to the backing sorted map is accomplished
   through the returned sorted map (or its views).

   It is imperative that the user manually synchronize on the returned
   sorted map when iterating over any of its collection views, or the
   collections views of any of its subMap, headMap or
   tailMap views.


    SortedMap m = Collections.synchronizedSortedMap(new TreeMap());
        ...
    Set s = m.keySet();  // Needn't be in synchronized block
        ...
    synchronized (m) {  // Synchronizing on m, not s!
        Iterator i = s.iterator(); // Must be in synchronized block
        while (i.hasNext())
            foo(i.next());
    }
   or:


    SortedMap m = Collections.synchronizedSortedMap(new TreeMap());
    SortedMap m2 = m.subMap(foo, bar);
        ...
    Set s2 = m2.keySet();  // Needn't be in synchronized block
        ...
    synchronized (m) {  // Synchronizing on m, not m2 or s2!
        Iterator i = s.iterator(); // Must be in synchronized block
        while (i.hasNext())
            foo(i.next());
    }
   Failure to follow this advice may result in non-deterministic behavior.

   The returned sorted map will be serializable if the specified
   sorted map is serializable.

  m - the sorted map to be `wrapped` in a synchronized sorted map. - `java.util.SortedMap`

  returns: a synchronized view of the specified sorted map. - `<K,V> java.util.SortedMap<K,V>`"
  ([^java.util.SortedMap m]
    (Collections/synchronizedSortedMap m)))

(defn *max
  "Returns the maximum element of the given collection, according to the
   order induced by the specified comparator.  All elements in the
   collection must be mutually comparable by the specified
   comparator (that is, comp.compare(e1, e2) must not throw a
   ClassCastException for any elements e1 and
   e2 in the collection).

   This method iterates over the entire collection, hence it requires
   time proportional to the size of the collection.

  coll - the collection whose maximum element is to be determined. - `java.util.Collection`
  comp - the comparator with which to determine the maximum element. A null value indicates that the elements' natural ordering should be used. - `java.util.Comparator`

  returns: the maximum element of the given collection, according
           to the specified comparator. - `<T> T`

  throws: java.lang.ClassCastException - if the collection contains elements that are not mutually comparable using the specified comparator."
  ([^java.util.Collection coll ^java.util.Comparator comp]
    (Collections/max coll comp))
  ([^java.util.Collection coll]
    (Collections/max coll)))

(defn *index-of-sub-list
  "Returns the starting position of the first occurrence of the specified
   target list within the specified source list, or -1 if there is no
   such occurrence.  More formally, returns the lowest index i
   such that source.subList(i, i+target.size()).equals(target),
   or -1 if there is no such index.  (Returns -1 if
   target.size() > source.size())

   This implementation uses the `brute force` technique of scanning
   over the source list, looking for a match with the target at each
   location in turn.

  source - the list in which to search for the first occurrence of target. - `java.util.List`
  target - the list to search for as a subList of source. - `java.util.List`

  returns: the starting position of the first occurrence of the specified
           target list within the specified source list, or -1 if there
           is no such occurrence. - `int`"
  (^Integer [^java.util.List source ^java.util.List target]
    (Collections/indexOfSubList source target)))

(defn *unmodifiable-sorted-set
  "Returns an unmodifiable view of the specified sorted set.  This method
   allows modules to provide users with `read-only` access to internal
   sorted sets.  Query operations on the returned sorted set `read
   through` to the specified sorted set.  Attempts to modify the returned
   sorted set, whether direct, via its iterator, or via its
   subSet, headSet, or tailSet views, result in
   an UnsupportedOperationException.

   The returned sorted set will be serializable if the specified sorted set
   is serializable.

  s - the sorted set for which an unmodifiable view is to be returned. - `java.util.SortedSet`

  returns: an unmodifiable view of the specified sorted set. - `<T> java.util.SortedSet<T>`"
  ([^java.util.SortedSet s]
    (Collections/unmodifiableSortedSet s)))

(defn *empty-sorted-map
  "Returns an empty sorted map (immutable).  This map is serializable.

   This example illustrates the type-safe way to obtain an empty map:


       SortedMap<String, Date> s = Collections.emptySortedMap();

  returns: an empty sorted map - `<K,V> java.util.SortedMap<K,V>`"
  ([]
    (Collections/emptySortedMap )))

(defn *empty-navigable-map
  "Returns an empty navigable map (immutable).  This map is serializable.

   This example illustrates the type-safe way to obtain an empty map:


       NavigableMap<String, Date> s = Collections.emptyNavigableMap();

  returns: an empty navigable map - `<K,V> java.util.NavigableMap<K,V>`"
  ([]
    (Collections/emptyNavigableMap )))

(defn *synchronized-set
  "Returns a synchronized (thread-safe) set backed by the specified
   set.  In order to guarantee serial access, it is critical that
   all access to the backing set is accomplished
   through the returned set.

   It is imperative that the user manually synchronize on the returned
   set when iterating over it:


    Set s = Collections.synchronizedSet(new HashSet());
        ...
    synchronized (s) {
        Iterator i = s.iterator(); // Must be in the synchronized block
        while (i.hasNext())
            foo(i.next());
    }
   Failure to follow this advice may result in non-deterministic behavior.

   The returned set will be serializable if the specified set is
   serializable.

  s - the set to be `wrapped` in a synchronized set. - `java.util.Set`

  returns: a synchronized view of the specified set. - `<T> java.util.Set<T>`"
  ([^java.util.Set s]
    (Collections/synchronizedSet s)))

(defn *shuffle
  "Randomly permute the specified list using the specified source of
   randomness.  All permutations occur with equal likelihood
   assuming that the source of randomness is fair.

   This implementation traverses the list backwards, from the last element
   up to the second, repeatedly swapping a randomly selected element into
   the `current position`.  Elements are randomly selected from the
   portion of the list that runs from the first element to the current
   position, inclusive.

   This method runs in linear time.  If the specified list does not
   implement the RandomAccess interface and is large, this
   implementation dumps the specified list into an array before shuffling
   it, and dumps the shuffled array back into the list.  This avoids the
   quadratic behavior that would result from shuffling a `sequential
   access` list in place.

  list - the list to be shuffled. - `java.util.List`
  rnd - the source of randomness to use to shuffle the list. - `java.util.Random`

  throws: java.lang.UnsupportedOperationException - if the specified list or its list-iterator does not support the set operation."
  ([^java.util.List list ^java.util.Random rnd]
    (Collections/shuffle list rnd))
  ([^java.util.List list]
    (Collections/shuffle list)))

(defn *empty-navigable-set
  "Returns an empty navigable set (immutable).  This set is serializable.

   This example illustrates the type-safe way to obtain an empty
   navigable set:


       NavigableSet<String> s = Collections.emptyNavigableSet();

  returns: the empty navigable set - `<E> java.util.NavigableSet<E>`"
  ([]
    (Collections/emptyNavigableSet )))

(defn *sort
  "Sorts the specified list according to the order induced by the
   specified comparator.  All elements in the list must be mutually
   comparable using the specified comparator (that is,
   c.compare(e1, e2) must not throw a ClassCastException
   for any elements e1 and e2 in the list).

   This sort is guaranteed to be stable:  equal elements will
   not be reordered as a result of the sort.

   The specified list must be modifiable, but need not be resizable.

  list - the list to be sorted. - `java.util.List`
  c - the comparator to determine the order of the list. A null value indicates that the elements' natural ordering should be used. - `java.util.Comparator`

  returns: `<T> void`

  throws: java.lang.ClassCastException - if the list contains elements that are not mutually comparable using the specified comparator."
  ([^java.util.List list ^java.util.Comparator c]
    (Collections/sort list c))
  ([^java.util.List list]
    (Collections/sort list)))

(defn *empty-map
  "Returns an empty map (immutable).  This map is serializable.

   This example illustrates the type-safe way to obtain an empty map:


       Map<String, Date> s = Collections.emptyMap();

  returns: an empty map - `<K,V> java.util.Map<K,V>`"
  ([]
    (Collections/emptyMap )))

(defn *binary-search
  "Searches the specified list for the specified object using the binary
   search algorithm.  The list must be sorted into ascending order
   according to the specified comparator (as by the
   sort(List, Comparator)
   method), prior to making this call.  If it is
   not sorted, the results are undefined.  If the list contains multiple
   elements equal to the specified object, there is no guarantee which one
   will be found.

   This method runs in log(n) time for a `random access` list (which
   provides near-constant-time positional access).  If the specified list
   does not implement the RandomAccess interface and is large,
   this method will do an iterator-based binary search that performs
   O(n) link traversals and O(log n) element comparisons.

  list - the list to be searched. - `java.util.List`
  key - the key to be searched for. - `T`
  c - the comparator by which the list is ordered. A null value indicates that the elements' java.lang.natural ordering should be used. - `java.util.Comparator`

  returns: the index of the search key, if it is contained in the list;
           otherwise, (-(insertion point) - 1).  The
           insertion point is defined as the point at which the
           key would be inserted into the list: the index of the first
           element greater than the key, or list.size() if all
           elements in the list are less than the specified key.  Note
           that this guarantees that the return value will be >= 0 if
           and only if the key is found. - `<T> int`

  throws: java.lang.ClassCastException - if the list contains elements that are not mutually comparable using the specified comparator, or the search key is not mutually comparable with the elements of the list using this comparator."
  ([^java.util.List list key ^java.util.Comparator c]
    (Collections/binarySearch list key c))
  ([^java.util.List list key]
    (Collections/binarySearch list key)))

(defn *checked-navigable-set
  "Returns a dynamically typesafe view of the specified navigable set.
   Any attempt to insert an element of the wrong type will result in an
   immediate ClassCastException.  Assuming a navigable set
   contains no incorrectly typed elements prior to the time a
   dynamically typesafe view is generated, and that all subsequent
   access to the navigable set takes place through the view, it is
   guaranteed that the navigable set cannot contain an incorrectly
   typed element.

   A discussion of the use of dynamically typesafe views may be
   found in the documentation for the checkedCollection method.

   The returned navigable set will be serializable if the specified
   navigable set is serializable.

   Since null is considered to be a value of any reference
   type, the returned navigable set permits insertion of null elements
   whenever the backing sorted set does.

  s - the navigable set for which a dynamically typesafe view is to be returned - `java.util.NavigableSet`
  type - the type of element that s is permitted to hold - `java.lang.Class`

  returns: a dynamically typesafe view of the specified navigable set - `<E> java.util.NavigableSet<E>`"
  ([^java.util.NavigableSet s ^java.lang.Class type]
    (Collections/checkedNavigableSet s type)))

(defn *synchronized-navigable-map
  "Returns a synchronized (thread-safe) navigable map backed by the
   specified navigable map.  In order to guarantee serial access, it is
   critical that all access to the backing navigable map is
   accomplished through the returned navigable map (or its views).

   It is imperative that the user manually synchronize on the returned
   navigable map when iterating over any of its collection views, or the
   collections views of any of its subMap, headMap or
   tailMap views.


    NavigableMap m = Collections.synchronizedNavigableMap(new TreeMap());
        ...
    Set s = m.keySet();  // Needn't be in synchronized block
        ...
    synchronized (m) {  // Synchronizing on m, not s!
        Iterator i = s.iterator(); // Must be in synchronized block
        while (i.hasNext())
            foo(i.next());
    }
   or:


    NavigableMap m = Collections.synchronizedNavigableMap(new TreeMap());
    NavigableMap m2 = m.subMap(foo, true, bar, false);
        ...
    Set s2 = m2.keySet();  // Needn't be in synchronized block
        ...
    synchronized (m) {  // Synchronizing on m, not m2 or s2!
        Iterator i = s.iterator(); // Must be in synchronized block
        while (i.hasNext())
            foo(i.next());
    }
   Failure to follow this advice may result in non-deterministic behavior.

   The returned navigable map will be serializable if the specified
   navigable map is serializable.

  m - the navigable map to be `wrapped` in a synchronized navigable map - `java.util.NavigableMap`

  returns: a synchronized view of the specified navigable map. - `<K,V> java.util.NavigableMap<K,V>`"
  ([^java.util.NavigableMap m]
    (Collections/synchronizedNavigableMap m)))

(defn *n-copies
  "Returns an immutable list consisting of n copies of the
   specified object.  The newly allocated data object is tiny (it contains
   a single reference to the data object).  This method is useful in
   combination with the List.addAll method to grow lists.
   The returned list is serializable.

  n - the number of elements in the returned list. - `int`
  o - the element to appear repeatedly in the returned list. - `T`

  returns: an immutable list consisting of n copies of the
           specified object. - `<T> java.util.List<T>`

  throws: java.lang.IllegalArgumentException - if n < 0"
  ([^Integer n o]
    (Collections/nCopies n o)))

(defn *unmodifiable-list
  "Returns an unmodifiable view of the specified list.  This method allows
   modules to provide users with `read-only` access to internal
   lists.  Query operations on the returned list `read through` to the
   specified list, and attempts to modify the returned list, whether
   direct or via its iterator, result in an
   UnsupportedOperationException.

   The returned list will be serializable if the specified list
   is serializable. Similarly, the returned list will implement
   RandomAccess if the specified list does.

  list - the list for which an unmodifiable view is to be returned. - `java.util.List`

  returns: an unmodifiable view of the specified list. - `<T> java.util.List<T>`"
  ([^java.util.List list]
    (Collections/unmodifiableList list)))

(defn *singleton-list
  "Returns an immutable list containing only the specified object.
   The returned list is serializable.

  o - the sole object to be stored in the returned list. - `T`

  returns: an immutable list containing only the specified object. - `<T> java.util.List<T>`"
  ([o]
    (Collections/singletonList o)))

(defn *checked-navigable-map
  "Returns a dynamically typesafe view of the specified navigable map.
   Any attempt to insert a mapping whose key or value have the wrong
   type will result in an immediate ClassCastException.
   Similarly, any attempt to modify the value currently associated with
   a key will result in an immediate ClassCastException,
   whether the modification is attempted directly through the map
   itself, or through a Map.Entry instance obtained from the
   map's entry set view.

   Assuming a map contains no incorrectly typed keys or values
   prior to the time a dynamically typesafe view is generated, and
   that all subsequent access to the map takes place through the view
   (or one of its collection views), it is guaranteed that the
   map cannot contain an incorrectly typed key or value.

   A discussion of the use of dynamically typesafe views may be
   found in the documentation for the checkedCollection method.

   The returned map will be serializable if the specified map is
   serializable.

   Since null is considered to be a value of any reference
   type, the returned map permits insertion of null keys or values
   whenever the backing map does.

  m - the map for which a dynamically typesafe view is to be returned - `java.util.NavigableMap`
  key-type - the type of key that m is permitted to hold - `java.lang.Class`
  value-type - the type of value that m is permitted to hold - `java.lang.Class`

  returns: a dynamically typesafe view of the specified map - `<K,V> java.util.NavigableMap<K,V>`"
  ([^java.util.NavigableMap m ^java.lang.Class key-type ^java.lang.Class value-type]
    (Collections/checkedNavigableMap m key-type value-type)))

(defn *empty-set
  "Returns an empty set (immutable).  This set is serializable.
   Unlike the like-named field, this method is parameterized.

   This example illustrates the type-safe way to obtain an empty set:


       Set<String> s = Collections.emptySet();

  returns: the empty set - `<T> java.util.Set<T>`"
  ([]
    (Collections/emptySet )))

(defn *reverse-order
  "Returns a comparator that imposes the reverse ordering of the specified
   comparator.  If the specified comparator is null, this method is
   equivalent to reverseOrder() (in other words, it returns a
   comparator that imposes the reverse of the natural ordering on
   a collection of objects that implement the Comparable interface).

   The returned comparator is serializable (assuming the specified
   comparator is also serializable or null).

  cmp - a comparator who's ordering is to be reversed by the returned comparator or null - `java.util.Comparator`

  returns: A comparator that imposes the reverse ordering of the
           specified comparator. - `<T> java.util.Comparator<T>`"
  ([^java.util.Comparator cmp]
    (Collections/reverseOrder cmp))
  ([]
    (Collections/reverseOrder )))

(defn *fill
  "Replaces all of the elements of the specified list with the specified
   element.

   This method runs in linear time.

  list - the list to be filled with the specified element. - `java.util.List`
  obj - The element with which to fill the specified list. - `T`

  returns: `<T> void`

  throws: java.lang.UnsupportedOperationException - if the specified list or its list-iterator does not support the set operation."
  ([^java.util.List list obj]
    (Collections/fill list obj)))

(defn *enumeration
  "Returns an enumeration over the specified collection.  This provides
   interoperability with legacy APIs that require an enumeration
   as input.

  c - the collection for which an enumeration is to be returned. - `java.util.Collection`

  returns: an enumeration over the specified collection. - `<T> java.util.Enumeration<T>`"
  ([^java.util.Collection c]
    (Collections/enumeration c)))

(defn *empty-list-iterator
  "Returns a list iterator that has no elements.  More precisely,


   hasNext and hasPrevious always return false.
   next and previous always throw NoSuchElementException.
   remove and set always throw IllegalStateException.
   add always throws UnsupportedOperationException.
   nextIndex always returns
   0.
   previousIndex always
   returns -1.


   Implementations of this method are permitted, but not
   required, to return the same object from multiple invocations.

  returns: an empty list iterator - `<T> java.util.ListIterator<T>`"
  ([]
    (Collections/emptyListIterator )))

(defn *unmodifiable-map
  "Returns an unmodifiable view of the specified map.  This method
   allows modules to provide users with `read-only` access to internal
   maps.  Query operations on the returned map `read through`
   to the specified map, and attempts to modify the returned
   map, whether direct or via its collection views, result in an
   UnsupportedOperationException.

   The returned map will be serializable if the specified map
   is serializable.

  m - the map for which an unmodifiable view is to be returned. - `java.util.Map`

  returns: an unmodifiable view of the specified map. - `<K,V> java.util.Map<K,V>`"
  ([^java.util.Map m]
    (Collections/unmodifiableMap m)))

(defn *checked-map
  "Returns a dynamically typesafe view of the specified map.
   Any attempt to insert a mapping whose key or value have the wrong
   type will result in an immediate ClassCastException.
   Similarly, any attempt to modify the value currently associated with
   a key will result in an immediate ClassCastException,
   whether the modification is attempted directly through the map
   itself, or through a Map.Entry instance obtained from the
   map's entry set view.

   Assuming a map contains no incorrectly typed keys or values
   prior to the time a dynamically typesafe view is generated, and
   that all subsequent access to the map takes place through the view
   (or one of its collection views), it is guaranteed that the
   map cannot contain an incorrectly typed key or value.

   A discussion of the use of dynamically typesafe views may be
   found in the documentation for the checkedCollection method.

   The returned map will be serializable if the specified map is
   serializable.

   Since null is considered to be a value of any reference
   type, the returned map permits insertion of null keys or values
   whenever the backing map does.

  m - the map for which a dynamically typesafe view is to be returned - `java.util.Map`
  key-type - the type of key that m is permitted to hold - `java.lang.Class`
  value-type - the type of value that m is permitted to hold - `java.lang.Class`

  returns: a dynamically typesafe view of the specified map - `<K,V> java.util.Map<K,V>`"
  ([^java.util.Map m ^java.lang.Class key-type ^java.lang.Class value-type]
    (Collections/checkedMap m key-type value-type)))

(defn *checked-sorted-set
  "Returns a dynamically typesafe view of the specified sorted set.
   Any attempt to insert an element of the wrong type will result in an
   immediate ClassCastException.  Assuming a sorted set
   contains no incorrectly typed elements prior to the time a
   dynamically typesafe view is generated, and that all subsequent
   access to the sorted set takes place through the view, it is
   guaranteed that the sorted set cannot contain an incorrectly
   typed element.

   A discussion of the use of dynamically typesafe views may be
   found in the documentation for the checkedCollection method.

   The returned sorted set will be serializable if the specified sorted
   set is serializable.

   Since null is considered to be a value of any reference
   type, the returned sorted set permits insertion of null elements
   whenever the backing sorted set does.

  s - the sorted set for which a dynamically typesafe view is to be returned - `java.util.SortedSet`
  type - the type of element that s is permitted to hold - `java.lang.Class`

  returns: a dynamically typesafe view of the specified sorted set - `<E> java.util.SortedSet<E>`"
  ([^java.util.SortedSet s ^java.lang.Class type]
    (Collections/checkedSortedSet s type)))

(defn *disjoint
  "Returns true if the two specified collections have no
   elements in common.

   Care must be exercised if this method is used on collections that
   do not comply with the general contract for Collection.
   Implementations may elect to iterate over either collection and test
   for containment in the other collection (or to perform any equivalent
   computation).  If either collection uses a nonstandard equality test
   (as does a SortedSet whose ordering is not compatible with
   equals, or the key set of an IdentityHashMap), both
   collections must use the same nonstandard equality test, or the
   result of this method is undefined.

   Care must also be exercised when using collections that have
   restrictions on the elements that they may contain. Collection
   implementations are allowed to throw exceptions for any operation
   involving elements they deem ineligible. For absolute safety the
   specified collections should contain only elements which are
   eligible elements for both collections.

   Note that it is permissible to pass the same collection in both
   parameters, in which case the method will return true if and
   only if the collection is empty.

  c-1 - a collection - `java.util.Collection`
  c-2 - a collection - `java.util.Collection`

  returns: true if the two specified collections have no
   elements in common. - `boolean`

  throws: java.lang.NullPointerException - if one collection contains a null element and null is not an eligible element for the other collection. (optional)"
  (^Boolean [^java.util.Collection c-1 ^java.util.Collection c-2]
    (Collections/disjoint c-1 c-2)))

(defn *last-index-of-sub-list
  "Returns the starting position of the last occurrence of the specified
   target list within the specified source list, or -1 if there is no such
   occurrence.  More formally, returns the highest index i
   such that source.subList(i, i+target.size()).equals(target),
   or -1 if there is no such index.  (Returns -1 if
   target.size() > source.size())

   This implementation uses the `brute force` technique of iterating
   over the source list, looking for a match with the target at each
   location in turn.

  source - the list in which to search for the last occurrence of target. - `java.util.List`
  target - the list to search for as a subList of source. - `java.util.List`

  returns: the starting position of the last occurrence of the specified
           target list within the specified source list, or -1 if there
           is no such occurrence. - `int`"
  (^Integer [^java.util.List source ^java.util.List target]
    (Collections/lastIndexOfSubList source target)))

(defn *synchronized-list
  "Returns a synchronized (thread-safe) list backed by the specified
   list.  In order to guarantee serial access, it is critical that
   all access to the backing list is accomplished
   through the returned list.

   It is imperative that the user manually synchronize on the returned
   list when iterating over it:


    List list = Collections.synchronizedList(new ArrayList());
        ...
    synchronized (list) {
        Iterator i = list.iterator(); // Must be in synchronized block
        while (i.hasNext())
            foo(i.next());
    }
   Failure to follow this advice may result in non-deterministic behavior.

   The returned list will be serializable if the specified list is
   serializable.

  list - the list to be `wrapped` in a synchronized list. - `java.util.List`

  returns: a synchronized view of the specified list. - `<T> java.util.List<T>`"
  ([^java.util.List list]
    (Collections/synchronizedList list)))

(defn *empty-iterator
  "Returns an iterator that has no elements.  More precisely,


   hasNext always returns false.
   next always throws NoSuchElementException.
   remove always throws IllegalStateException.


   Implementations of this method are permitted, but not
   required, to return the same object from multiple invocations.

  returns: an empty iterator - `<T> java.util.Iterator<T>`"
  ([]
    (Collections/emptyIterator )))

(defn *singleton-map
  "Returns an immutable map, mapping only the specified key to the
   specified value.  The returned map is serializable.

  key - the sole key to be stored in the returned map. - `K`
  value - the value to which the returned map maps key. - `V`

  returns: an immutable map containing only the specified key-value
           mapping. - `<K,V> java.util.Map<K,V>`"
  ([key value]
    (Collections/singletonMap key value)))

(defn *new-set-from-map
  "Returns a set backed by the specified map.  The resulting set displays
   the same ordering, concurrency, and performance characteristics as the
   backing map.  In essence, this factory method provides a Set
   implementation corresponding to any Map implementation.  There
   is no need to use this method on a Map implementation that
   already has a corresponding Set implementation (such as HashMap or TreeMap).

   Each method invocation on the set returned by this method results in
   exactly one method invocation on the backing map or its keySet
   view, with one exception.  The addAll method is implemented
   as a sequence of put invocations on the backing map.

   The specified map must be empty at the time this method is invoked,
   and should not be accessed directly after this method returns.  These
   conditions are ensured if the map is created empty, passed directly
   to this method, and no reference to the map is retained, as illustrated
   in the following code fragment:


      Set<Object> weakHashSet = Collections.newSetFromMap(
          new WeakHashMap<Object, Boolean>());

  map - the backing map - `java.util.Map`

  returns: the set backed by the map - `<E> java.util.Set<E>`

  throws: java.lang.IllegalArgumentException - if map is not empty"
  ([^java.util.Map map]
    (Collections/newSetFromMap map)))

(defn *synchronized-collection
  "Returns a synchronized (thread-safe) collection backed by the specified
   collection.  In order to guarantee serial access, it is critical that
   all access to the backing collection is accomplished
   through the returned collection.

   It is imperative that the user manually synchronize on the returned
   collection when traversing it via Iterator, Spliterator
   or Stream:


    Collection c = Collections.synchronizedCollection(myCollection);
       ...
    synchronized (c) {
        Iterator i = c.iterator(); // Must be in the synchronized block
        while (i.hasNext())
           foo(i.next());
    }
   Failure to follow this advice may result in non-deterministic behavior.

   The returned collection does not pass the hashCode
   and equals operations through to the backing collection, but
   relies on Object's equals and hashCode methods.  This is
   necessary to preserve the contracts of these operations in the case
   that the backing collection is a set or a list.

   The returned collection will be serializable if the specified collection
   is serializable.

  c - the collection to be `wrapped` in a synchronized collection. - `java.util.Collection`

  returns: a synchronized view of the specified collection. - `<T> java.util.Collection<T>`"
  ([^java.util.Collection c]
    (Collections/synchronizedCollection c)))

(defn *checked-collection
  "Returns a dynamically typesafe view of the specified collection.
   Any attempt to insert an element of the wrong type will result in an
   immediate ClassCastException.  Assuming a collection
   contains no incorrectly typed elements prior to the time a
   dynamically typesafe view is generated, and that all subsequent
   access to the collection takes place through the view, it is
   guaranteed that the collection cannot contain an incorrectly
   typed element.

   The generics mechanism in the language provides compile-time
   (static) type checking, but it is possible to defeat this mechanism
   with unchecked casts.  Usually this is not a problem, as the compiler
   issues warnings on all such unchecked operations.  There are, however,
   times when static type checking alone is not sufficient.  For example,
   suppose a collection is passed to a third-party library and it is
   imperative that the library code not corrupt the collection by
   inserting an element of the wrong type.

   Another use of dynamically typesafe views is debugging.  Suppose a
   program fails with a ClassCastException, indicating that an
   incorrectly typed element was put into a parameterized collection.
   Unfortunately, the exception can occur at any time after the erroneous
   element is inserted, so it typically provides little or no information
   as to the real source of the problem.  If the problem is reproducible,
   one can quickly determine its source by temporarily modifying the
   program to wrap the collection with a dynamically typesafe view.
   For example, this declaration:


       Collection<String> c = new HashSet<>();
   may be replaced temporarily by this one:


       Collection<String> c = Collections.checkedCollection(
           new HashSet<>(), String.class);
   Running the program again will cause it to fail at the point where
   an incorrectly typed element is inserted into the collection, clearly
   identifying the source of the problem.  Once the problem is fixed, the
   modified declaration may be reverted back to the original.

   The returned collection does not pass the hashCode and equals
   operations through to the backing collection, but relies on
   Object's equals and hashCode methods.  This
   is necessary to preserve the contracts of these operations in the case
   that the backing collection is a set or a list.

   The returned collection will be serializable if the specified
   collection is serializable.

   Since null is considered to be a value of any reference
   type, the returned collection permits insertion of null elements
   whenever the backing collection does.

  c - the collection for which a dynamically typesafe view is to be returned - `java.util.Collection`
  type - the type of element that c is permitted to hold - `java.lang.Class`

  returns: a dynamically typesafe view of the specified collection - `<E> java.util.Collection<E>`"
  ([^java.util.Collection c ^java.lang.Class type]
    (Collections/checkedCollection c type)))

(defn *unmodifiable-sorted-map
  "Returns an unmodifiable view of the specified sorted map.  This method
   allows modules to provide users with `read-only` access to internal
   sorted maps.  Query operations on the returned sorted map `read through`
   to the specified sorted map.  Attempts to modify the returned
   sorted map, whether direct, via its collection views, or via its
   subMap, headMap, or tailMap views, result in
   an UnsupportedOperationException.

   The returned sorted map will be serializable if the specified sorted map
   is serializable.

  m - the sorted map for which an unmodifiable view is to be returned. - `java.util.SortedMap`

  returns: an unmodifiable view of the specified sorted map. - `<K,V> java.util.SortedMap<K,V>`"
  ([^java.util.SortedMap m]
    (Collections/unmodifiableSortedMap m)))

(defn *unmodifiable-navigable-set
  "Returns an unmodifiable view of the specified navigable set.  This method
   allows modules to provide users with `read-only` access to internal
   navigable sets.  Query operations on the returned navigable set `read
   through` to the specified navigable set.  Attempts to modify the returned
   navigable set, whether direct, via its iterator, or via its
   subSet, headSet, or tailSet views, result in
   an UnsupportedOperationException.

   The returned navigable set will be serializable if the specified
   navigable set is serializable.

  s - the navigable set for which an unmodifiable view is to be returned - `java.util.NavigableSet`

  returns: an unmodifiable view of the specified navigable set - `<T> java.util.NavigableSet<T>`"
  ([^java.util.NavigableSet s]
    (Collections/unmodifiableNavigableSet s)))

(defn *empty-enumeration
  "Returns an enumeration that has no elements.  More precisely,


   hasMoreElements always
   returns false.
    nextElement always throws
   NoSuchElementException.


   Implementations of this method are permitted, but not
   required, to return the same object from multiple invocations.

  returns: an empty enumeration - `<T> java.util.Enumeration<T>`"
  ([]
    (Collections/emptyEnumeration )))

(defn *rotate
  "Rotates the elements in the specified list by the specified distance.
   After calling this method, the element at index i will be
   the element previously at index (i - distance) mod
   list.size(), for all values of i between 0
   and list.size()-1, inclusive.  (This method has no effect on
   the size of the list.)

   For example, suppose list comprises [t, a, n, k, s].
   After invoking Collections.rotate(list, 1) (or
   Collections.rotate(list, -4)), list will comprise
   [s, t, a, n, k].

   Note that this method can usefully be applied to sublists to
   move one or more elements within a list while preserving the
   order of the remaining elements.  For example, the following idiom
   moves the element at index j forward to position
   k (which must be greater than or equal to j):


       Collections.rotate(list.subList(j, k+1), -1);
   To make this concrete, suppose list comprises
   [a, b, c, d, e].  To move the element at index 1
   (b) forward two positions, perform the following invocation:


       Collections.rotate(l.subList(1, 4), -1);
   The resulting list is [a, c, d, b, e].

   To move more than one element forward, increase the absolute value
   of the rotation distance.  To move elements backward, use a positive
   shift distance.

   If the specified list is small or implements the RandomAccess interface, this implementation exchanges the first
   element into the location it should go, and then repeatedly exchanges
   the displaced element into the location it should go until a displaced
   element is swapped into the first element.  If necessary, the process
   is repeated on the second and successive elements, until the rotation
   is complete.  If the specified list is large and doesn't implement the
   RandomAccess interface, this implementation breaks the
   list into two sublist views around index -distance mod size.
   Then the reverse(List) method is invoked on each sublist view,
   and finally it is invoked on the entire list.  For a more complete
   description of both algorithms, see Section 2.3 of Jon Bentley's
   Programming Pearls (Addison-Wesley, 1986).

  list - the list to be rotated. - `java.util.List`
  distance - the distance to rotate the list. There are no constraints on this value; it may be zero, negative, or greater than list.size(). - `int`

  throws: java.lang.UnsupportedOperationException - if the specified list or its list-iterator does not support the set operation."
  ([^java.util.List list ^Integer distance]
    (Collections/rotate list distance)))

(defn *empty-list
  "Returns an empty list (immutable).  This list is serializable.

   This example illustrates the type-safe way to obtain an empty list:


       List<String> s = Collections.emptyList();

  returns: an empty immutable list - `<T> java.util.List<T>`"
  ([]
    (Collections/emptyList )))

(defn *synchronized-map
  "Returns a synchronized (thread-safe) map backed by the specified
   map.  In order to guarantee serial access, it is critical that
   all access to the backing map is accomplished
   through the returned map.

   It is imperative that the user manually synchronize on the returned
   map when iterating over any of its collection views:


    Map m = Collections.synchronizedMap(new HashMap());
        ...
    Set s = m.keySet();  // Needn't be in synchronized block
        ...
    synchronized (m) {  // Synchronizing on m, not s!
        Iterator i = s.iterator(); // Must be in synchronized block
        while (i.hasNext())
            foo(i.next());
    }
   Failure to follow this advice may result in non-deterministic behavior.

   The returned map will be serializable if the specified map is
   serializable.

  m - the map to be `wrapped` in a synchronized map. - `java.util.Map`

  returns: a synchronized view of the specified map. - `<K,V> java.util.Map<K,V>`"
  ([^java.util.Map m]
    (Collections/synchronizedMap m)))

(defn *empty-sorted-set
  "Returns an empty sorted set (immutable).  This set is serializable.

   This example illustrates the type-safe way to obtain an empty
   sorted set:


       SortedSet<String> s = Collections.emptySortedSet();

  returns: the empty sorted set - `<E> java.util.SortedSet<E>`"
  ([]
    (Collections/emptySortedSet )))

(defn *checked-queue
  "Returns a dynamically typesafe view of the specified queue.
   Any attempt to insert an element of the wrong type will result in
   an immediate ClassCastException.  Assuming a queue contains
   no incorrectly typed elements prior to the time a dynamically typesafe
   view is generated, and that all subsequent access to the queue
   takes place through the view, it is guaranteed that the
   queue cannot contain an incorrectly typed element.

   A discussion of the use of dynamically typesafe views may be
   found in the documentation for the checkedCollection method.

   The returned queue will be serializable if the specified queue
   is serializable.

   Since null is considered to be a value of any reference
   type, the returned queue permits insertion of null elements
   whenever the backing queue does.

  queue - the queue for which a dynamically typesafe view is to be returned - `java.util.Queue`
  type - the type of element that queue is permitted to hold - `java.lang.Class`

  returns: a dynamically typesafe view of the specified queue - `<E> java.util.Queue<E>`"
  ([^java.util.Queue queue ^java.lang.Class type]
    (Collections/checkedQueue queue type)))

(defn *unmodifiable-set
  "Returns an unmodifiable view of the specified set.  This method allows
   modules to provide users with `read-only` access to internal sets.
   Query operations on the returned set `read through` to the specified
   set, and attempts to modify the returned set, whether direct or via its
   iterator, result in an UnsupportedOperationException.

   The returned set will be serializable if the specified set
   is serializable.

  s - the set for which an unmodifiable view is to be returned. - `java.util.Set`

  returns: an unmodifiable view of the specified set. - `<T> java.util.Set<T>`"
  ([^java.util.Set s]
    (Collections/unmodifiableSet s)))

(defn *swap
  "Swaps the elements at the specified positions in the specified list.
   (If the specified positions are equal, invoking this method leaves
   the list unchanged.)

  list - The list in which to swap elements. - `java.util.List`
  i - the index of one element to be swapped. - `int`
  j - the index of the other element to be swapped. - `int`

  throws: java.lang.IndexOutOfBoundsException - if either i or j is out of range (i < 0 || i >= list.size() || j < 0 || j >= list.size())."
  ([^java.util.List list ^Integer i ^Integer j]
    (Collections/swap list i j)))

(defn *frequency
  "Returns the number of elements in the specified collection equal to the
   specified object.  More formally, returns the number of elements
   e in the collection such that
   (o == null ? e == null : o.equals(e)).

  c - the collection in which to determine the frequency of o - `java.util.Collection`
  o - the object whose frequency is to be determined - `java.lang.Object`

  returns: the number of elements in c equal to o - `int`

  throws: java.lang.NullPointerException - if c is null"
  (^Integer [^java.util.Collection c ^java.lang.Object o]
    (Collections/frequency c o)))

