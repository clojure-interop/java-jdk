(ns jdk.util.TreeSet
  "A NavigableSet implementation based on a TreeMap.
  The elements are ordered using their java.lang.natural
  ordering, or by a Comparator provided at set creation
  time, depending on which constructor is used.

  This implementation provides guaranteed log(n) time cost for the basic
  operations (add, remove and contains).

  Note that the ordering maintained by a set (whether or not an explicit
  comparator is provided) must be consistent with equals if it is to
  correctly implement the Set interface.  (See Comparable
  or Comparator for a precise definition of consistent with
  equals.)  This is so because the Set interface is defined in
  terms of the equals operation, but a TreeSet instance
  performs all element comparisons using its compareTo (or
  compare) method, so two elements that are deemed equal by this method
  are, from the standpoint of the set, equal.  The behavior of a set
  is well-defined even if its ordering is inconsistent with equals; it
  just fails to obey the general contract of the Set interface.

  Note that this implementation is not synchronized.
  If multiple threads access a tree set concurrently, and at least one
  of the threads modifies the set, it must be synchronized
  externally.  This is typically accomplished by synchronizing on some
  object that naturally encapsulates the set.
  If no such object exists, the set should be \"wrapped\" using the
  Collections.synchronizedSortedSet
  method.  This is best done at creation time, to prevent accidental
  unsynchronized access to the set:

    SortedSet s = Collections.synchronizedSortedSet(new TreeSet(...));

  The iterators returned by this class's iterator method are
  fail-fast: if the set is modified at any time after the iterator is
  created, in any way except through the iterator's own remove
  method, the iterator will throw a ConcurrentModificationException.
  Thus, in the face of concurrent modification, the iterator fails quickly
  and cleanly, rather than risking arbitrary, non-deterministic behavior at
  an undetermined time in the future.

  Note that the fail-fast behavior of an iterator cannot be guaranteed
  as it is, generally speaking, impossible to make any hard guarantees in the
  presence of unsynchronized concurrent modification.  Fail-fast iterators
  throw ConcurrentModificationException on a best-effort basis.
  Therefore, it would be wrong to write a program that depended on this
  exception for its correctness:   the fail-fast behavior of iterators
  should be used only to detect bugs.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util TreeSet]))

(defn ->tree-set
  "Constructor.

  Constructs a new, empty tree set, sorted according to the specified
   comparator.  All elements inserted into the set must be mutually
   comparable by the specified comparator: comparator.compare(e1,
   e2) must not throw a ClassCastException for any elements
   e1 and e2 in the set.  If the user attempts to add
   an element to the set that violates this constraint, the
   add call will throw a ClassCastException.

  comparator - the comparator that will be used to order this set. If null, the java.lang.natural ordering of the elements will be used. - `java.util.Comparator`"
  (^TreeSet [^java.util.Comparator comparator]
    (new TreeSet comparator))
  (^TreeSet []
    (new TreeSet )))

(defn add-all
  "Adds all of the elements in the specified collection to this set.

  c - collection containing elements to be added to this set - `java.util.Collection`

  returns: true if this set changed as a result of the call - `boolean`

  throws: java.lang.ClassCastException - if the elements provided cannot be compared with the elements currently in the set"
  (^Boolean [^TreeSet this ^java.util.Collection c]
    (-> this (.addAll c))))

(defn floor
  "Description copied from interface: NavigableSet

  e - the value to match - `E`

  returns: the greatest element less than or equal to e,
           or null if there is no such element - `E`

  throws: java.lang.ClassCastException - if the specified element cannot be compared with the elements currently in the set"
  ([^TreeSet this e]
    (-> this (.floor e))))

(defn spliterator
  "Creates a late-binding
   and fail-fast Spliterator over the elements in this
   set.

   The Spliterator reports Spliterator.SIZED,
   Spliterator.DISTINCT, Spliterator.SORTED, and
   Spliterator.ORDERED.  Overriding implementations should document
   the reporting of additional characteristic values.

   The spliterator's comparator (see
   Spliterator.getComparator()) is null if
   the tree set's comparator (see comparator()) is null.
   Otherwise, the spliterator's comparator is the same as or imposes the
   same total ordering as the tree set's comparator.

  returns: a Spliterator over the elements in this set - `java.util.Spliterator<E>`"
  (^java.util.Spliterator [^TreeSet this]
    (-> this (.spliterator))))

(defn tail-set
  "Description copied from interface: NavigableSet

  from-element - low endpoint of the returned set - `E`
  inclusive - true if the low endpoint is to be included in the returned view - `boolean`

  returns: a view of the portion of this set whose elements are greater
           than or equal to fromElement - `java.util.NavigableSet<E>`

  throws: java.lang.ClassCastException - if fromElement is not compatible with this set's comparator (or, if the set has no comparator, if fromElement does not implement Comparable). Implementations may, but are not required to, throw this exception if fromElement cannot be compared to elements currently in the set."
  (^java.util.NavigableSet [^TreeSet this from-element ^Boolean inclusive]
    (-> this (.tailSet from-element inclusive)))
  (^java.util.SortedSet [^TreeSet this from-element]
    (-> this (.tailSet from-element))))

(defn contains
  "Returns true if this set contains the specified element.
   More formally, returns true if and only if this set
   contains an element e such that
   (o==null ? e==null : o.equals(e)).

  o - object to be checked for containment in this set - `java.lang.Object`

  returns: true if this set contains the specified element - `boolean`

  throws: java.lang.ClassCastException - if the specified object cannot be compared with the elements currently in the set"
  (^Boolean [^TreeSet this ^java.lang.Object o]
    (-> this (.contains o))))

(defn iterator
  "Returns an iterator over the elements in this set in ascending order.

  returns: an iterator over the elements in this set in ascending order - `java.util.Iterator<E>`"
  (^java.util.Iterator [^TreeSet this]
    (-> this (.iterator))))

(defn descending-set
  "Description copied from interface: NavigableSet

  returns: a reverse order view of this set - `java.util.NavigableSet<E>`"
  (^java.util.NavigableSet [^TreeSet this]
    (-> this (.descendingSet))))

(defn sub-set
  "Description copied from interface: NavigableSet

  from-element - low endpoint of the returned set - `E`
  from-inclusive - true if the low endpoint is to be included in the returned view - `boolean`
  to-element - high endpoint of the returned set - `E`
  to-inclusive - true if the high endpoint is to be included in the returned view - `boolean`

  returns: a view of the portion of this set whose elements range from
           fromElement, inclusive, to toElement, exclusive - `java.util.NavigableSet<E>`

  throws: java.lang.ClassCastException - if fromElement and toElement cannot be compared to one another using this set's comparator (or, if the set has no comparator, using natural ordering). Implementations may, but are not required to, throw this exception if fromElement or toElement cannot be compared to elements currently in the set."
  (^java.util.NavigableSet [^TreeSet this from-element ^Boolean from-inclusive to-element ^Boolean to-inclusive]
    (-> this (.subSet from-element from-inclusive to-element to-inclusive)))
  (^java.util.SortedSet [^TreeSet this from-element to-element]
    (-> this (.subSet from-element to-element))))

(defn remove
  "Removes the specified element from this set if it is present.
   More formally, removes an element e such that
   (o==null ? e==null : o.equals(e)),
   if this set contains such an element.  Returns true if
   this set contained the element (or equivalently, if this set
   changed as a result of the call).  (This set will not contain the
   element once the call returns.)

  o - object to be removed from this set, if present - `java.lang.Object`

  returns: true if this set contained the specified element - `boolean`

  throws: java.lang.ClassCastException - if the specified object cannot be compared with the elements currently in this set"
  (^Boolean [^TreeSet this ^java.lang.Object o]
    (-> this (.remove o))))

(defn poll-last
  "Description copied from interface: NavigableSet

  returns: the last element, or null if this set is empty - `E`"
  ([^TreeSet this]
    (-> this (.pollLast))))

(defn comparator
  "Description copied from interface: SortedSet

  returns: the comparator used to order the elements in this set,
           or null if this set uses the natural ordering
           of its elements - `java.util.Comparator<? super E>`"
  ([^TreeSet this]
    (-> this (.comparator))))

(defn last
  "Description copied from interface: SortedSet

  returns: the last (highest) element currently in this set - `E`

  throws: java.util.NoSuchElementException - if this set is empty"
  ([^TreeSet this]
    (-> this (.last))))

(defn poll-first
  "Description copied from interface: NavigableSet

  returns: the first element, or null if this set is empty - `E`"
  ([^TreeSet this]
    (-> this (.pollFirst))))

(defn higher
  "Description copied from interface: NavigableSet

  e - the value to match - `E`

  returns: the least element greater than e,
           or null if there is no such element - `E`

  throws: java.lang.ClassCastException - if the specified element cannot be compared with the elements currently in the set"
  ([^TreeSet this e]
    (-> this (.higher e))))

(defn clone
  "Returns a shallow copy of this TreeSet instance. (The elements
   themselves are not cloned.)

  returns: a shallow copy of this set - `java.lang.Object`"
  (^java.lang.Object [^TreeSet this]
    (-> this (.clone))))

(defn lower
  "Description copied from interface: NavigableSet

  e - the value to match - `E`

  returns: the greatest element less than e,
           or null if there is no such element - `E`

  throws: java.lang.ClassCastException - if the specified element cannot be compared with the elements currently in the set"
  ([^TreeSet this e]
    (-> this (.lower e))))

(defn add
  "Adds the specified element to this set if it is not already present.
   More formally, adds the specified element e to this set if
   the set contains no element e2 such that
   (e==null ? e2==null : e.equals(e2)).
   If this set already contains the element, the call leaves the set
   unchanged and returns false.

  e - element to be added to this set - `E`

  returns: true if this set did not already contain the specified
           element - `boolean`

  throws: java.lang.ClassCastException - if the specified object cannot be compared with the elements currently in this set"
  (^Boolean [^TreeSet this e]
    (-> this (.add e))))

(defn descending-iterator
  "Returns an iterator over the elements in this set in descending order.

  returns: an iterator over the elements in this set in descending order - `java.util.Iterator<E>`"
  (^java.util.Iterator [^TreeSet this]
    (-> this (.descendingIterator))))

(defn empty?
  "Returns true if this set contains no elements.

  returns: true if this set contains no elements - `boolean`"
  (^Boolean [^TreeSet this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of elements in this set (its cardinality).

  returns: the number of elements in this set (its cardinality) - `int`"
  (^Integer [^TreeSet this]
    (-> this (.size))))

(defn head-set
  "Description copied from interface: NavigableSet

  to-element - high endpoint of the returned set - `E`
  inclusive - true if the high endpoint is to be included in the returned view - `boolean`

  returns: a view of the portion of this set whose elements are less than
           (or equal to, if inclusive is true) toElement - `java.util.NavigableSet<E>`

  throws: java.lang.ClassCastException - if toElement is not compatible with this set's comparator (or, if the set has no comparator, if toElement does not implement Comparable). Implementations may, but are not required to, throw this exception if toElement cannot be compared to elements currently in the set."
  (^java.util.NavigableSet [^TreeSet this to-element ^Boolean inclusive]
    (-> this (.headSet to-element inclusive)))
  (^java.util.SortedSet [^TreeSet this to-element]
    (-> this (.headSet to-element))))

(defn clear
  "Removes all of the elements from this set.
   The set will be empty after this call returns."
  ([^TreeSet this]
    (-> this (.clear))))

(defn ceiling
  "Description copied from interface: NavigableSet

  e - the value to match - `E`

  returns: the least element greater than or equal to e,
           or null if there is no such element - `E`

  throws: java.lang.ClassCastException - if the specified element cannot be compared with the elements currently in the set"
  ([^TreeSet this e]
    (-> this (.ceiling e))))

(defn first
  "Description copied from interface: SortedSet

  returns: the first (lowest) element currently in this set - `E`

  throws: java.util.NoSuchElementException - if this set is empty"
  ([^TreeSet this]
    (-> this (.first))))

