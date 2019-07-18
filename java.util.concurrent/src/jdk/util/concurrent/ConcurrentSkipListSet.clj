(ns jdk.util.concurrent.ConcurrentSkipListSet
  "A scalable concurrent NavigableSet implementation based on
  a ConcurrentSkipListMap.  The elements of the set are kept
  sorted according to their java.lang.natural ordering,
  or by a Comparator provided at set creation time, depending
  on which constructor is used.

  This implementation provides expected average log(n) time
  cost for the contains, add, and remove
  operations and their variants.  Insertion, removal, and access
  operations safely execute concurrently by multiple threads.

  Iterators and spliterators are
  weakly consistent.

  Ascending ordered views and their iterators are faster than
  descending ones.

  Beware that, unlike in most collections, the size
  method is not a constant-time operation. Because of the
  asynchronous nature of these sets, determining the current number
  of elements requires a traversal of the elements, and so may report
  inaccurate results if this collection is modified during traversal.
  Additionally, the bulk operations addAll,
  removeAll, retainAll, containsAll,
  equals, and toArray are not guaranteed
  to be performed atomically. For example, an iterator operating
  concurrently with an addAll operation might view only some
  of the added elements.

  This class and its iterators implement all of the
  optional methods of the Set and Iterator
  interfaces. Like most other concurrent collection implementations,
  this class does not permit the use of null elements,
  because null arguments and return values cannot be reliably
  distinguished from the absence of elements.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ConcurrentSkipListSet]))

(defn ->concurrent-skip-list-set
  "Constructor.

  Constructs a new, empty set that orders its elements according to
   the specified comparator.

  comparator - the comparator that will be used to order this set. If null, the java.lang.natural ordering of the elements will be used. - `java.util.Comparator`"
  (^ConcurrentSkipListSet [^java.util.Comparator comparator]
    (new ConcurrentSkipListSet comparator))
  (^ConcurrentSkipListSet []
    (new ConcurrentSkipListSet )))

(defn floor
  "Description copied from interface: NavigableSet

  e - the value to match - `E`

  returns: the greatest element less than or equal to e,
           or null if there is no such element - `E`

  throws: java.lang.ClassCastException - if the specified element cannot be compared with the elements currently in the set"
  ([^ConcurrentSkipListSet this e]
    (-> this (.floor e))))

(defn spliterator
  "Returns a Spliterator over the elements in this set.

   The Spliterator reports Spliterator.CONCURRENT,
   Spliterator.NONNULL, Spliterator.DISTINCT,
   Spliterator.SORTED and Spliterator.ORDERED, with an
   encounter order that is ascending order.  Overriding implementations
   should document the reporting of additional characteristic values.

   The spliterator's comparator (see
   Spliterator.getComparator()) is null if
   the set's comparator (see comparator()) is null.
   Otherwise, the spliterator's comparator is the same as or imposes the
   same total ordering as the set's comparator.

  returns: a Spliterator over the elements in this set - `java.util.Spliterator<E>`"
  (^java.util.Spliterator [^ConcurrentSkipListSet this]
    (-> this (.spliterator))))

(defn tail-set
  "Description copied from interface: NavigableSet

  from-element - low endpoint of the returned set - `E`
  inclusive - true if the low endpoint is to be included in the returned view - `boolean`

  returns: a view of the portion of this set whose elements are greater
           than or equal to fromElement - `java.util.NavigableSet<E>`

  throws: java.lang.ClassCastException - if fromElement is not compatible with this set's comparator (or, if the set has no comparator, if fromElement does not implement Comparable). Implementations may, but are not required to, throw this exception if fromElement cannot be compared to elements currently in the set."
  (^java.util.NavigableSet [^ConcurrentSkipListSet this from-element ^Boolean inclusive]
    (-> this (.tailSet from-element inclusive)))
  (^java.util.NavigableSet [^ConcurrentSkipListSet this from-element]
    (-> this (.tailSet from-element))))

(defn contains
  "Returns true if this set contains the specified element.
   More formally, returns true if and only if this set
   contains an element e such that o.equals(e).

  o - object to be checked for containment in this set - `java.lang.Object`

  returns: true if this set contains the specified element - `boolean`

  throws: java.lang.ClassCastException - if the specified element cannot be compared with the elements currently in this set"
  (^Boolean [^ConcurrentSkipListSet this ^java.lang.Object o]
    (-> this (.contains o))))

(defn iterator
  "Returns an iterator over the elements in this set in ascending order.

  returns: an iterator over the elements in this set in ascending order - `java.util.Iterator<E>`"
  (^java.util.Iterator [^ConcurrentSkipListSet this]
    (-> this (.iterator))))

(defn descending-set
  "Returns a reverse order view of the elements contained in this set.
   The descending set is backed by this set, so changes to the set are
   reflected in the descending set, and vice-versa.

   The returned set has an ordering equivalent to
   Collections.reverseOrder(comparator()).
   The expression s.descendingSet().descendingSet() returns a
   view of s essentially equivalent to s.

  returns: a reverse order view of this set - `java.util.NavigableSet<E>`"
  (^java.util.NavigableSet [^ConcurrentSkipListSet this]
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
  (^java.util.NavigableSet [^ConcurrentSkipListSet this from-element ^Boolean from-inclusive to-element ^Boolean to-inclusive]
    (-> this (.subSet from-element from-inclusive to-element to-inclusive)))
  (^java.util.NavigableSet [^ConcurrentSkipListSet this from-element to-element]
    (-> this (.subSet from-element to-element))))

(defn remove
  "Removes the specified element from this set if it is present.
   More formally, removes an element e such that
   o.equals(e), if this set contains such an element.
   Returns true if this set contained the element (or
   equivalently, if this set changed as a result of the call).
   (This set will not contain the element once the call returns.)

  o - object to be removed from this set, if present - `java.lang.Object`

  returns: true if this set contained the specified element - `boolean`

  throws: java.lang.ClassCastException - if o cannot be compared with the elements currently in this set"
  (^Boolean [^ConcurrentSkipListSet this ^java.lang.Object o]
    (-> this (.remove o))))

(defn poll-last
  "Description copied from interface: NavigableSet

  returns: the last element, or null if this set is empty - `E`"
  ([^ConcurrentSkipListSet this]
    (-> this (.pollLast))))

(defn comparator
  "Description copied from interface: SortedSet

  returns: the comparator used to order the elements in this set,
           or null if this set uses the natural ordering
           of its elements - `java.util.Comparator<? super E>`"
  ([^ConcurrentSkipListSet this]
    (-> this (.comparator))))

(defn last
  "Description copied from interface: SortedSet

  returns: the last (highest) element currently in this set - `E`

  throws: java.util.NoSuchElementException - if this set is empty"
  ([^ConcurrentSkipListSet this]
    (-> this (.last))))

(defn poll-first
  "Description copied from interface: NavigableSet

  returns: the first element, or null if this set is empty - `E`"
  ([^ConcurrentSkipListSet this]
    (-> this (.pollFirst))))

(defn higher
  "Description copied from interface: NavigableSet

  e - the value to match - `E`

  returns: the least element greater than e,
           or null if there is no such element - `E`

  throws: java.lang.ClassCastException - if the specified element cannot be compared with the elements currently in the set"
  ([^ConcurrentSkipListSet this e]
    (-> this (.higher e))))

(defn clone
  "Returns a shallow copy of this ConcurrentSkipListSet
   instance. (The elements themselves are not cloned.)

  returns: a shallow copy of this set - `java.util.concurrent.ConcurrentSkipListSet<E>`"
  (^java.util.concurrent.ConcurrentSkipListSet [^ConcurrentSkipListSet this]
    (-> this (.clone))))

(defn lower
  "Description copied from interface: NavigableSet

  e - the value to match - `E`

  returns: the greatest element less than e,
           or null if there is no such element - `E`

  throws: java.lang.ClassCastException - if the specified element cannot be compared with the elements currently in the set"
  ([^ConcurrentSkipListSet this e]
    (-> this (.lower e))))

(defn add
  "Adds the specified element to this set if it is not already present.
   More formally, adds the specified element e to this set if
   the set contains no element e2 such that e.equals(e2).
   If this set already contains the element, the call leaves the set
   unchanged and returns false.

  e - element to be added to this set - `E`

  returns: true if this set did not already contain the
           specified element - `boolean`

  throws: java.lang.ClassCastException - if e cannot be compared with the elements currently in this set"
  (^Boolean [^ConcurrentSkipListSet this e]
    (-> this (.add e))))

(defn descending-iterator
  "Returns an iterator over the elements in this set in descending order.

  returns: an iterator over the elements in this set in descending order - `java.util.Iterator<E>`"
  (^java.util.Iterator [^ConcurrentSkipListSet this]
    (-> this (.descendingIterator))))

(defn empty?
  "Returns true if this set contains no elements.

  returns: true if this set contains no elements - `boolean`"
  (^Boolean [^ConcurrentSkipListSet this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of elements in this set.  If this set
   contains more than Integer.MAX_VALUE elements, it
   returns Integer.MAX_VALUE.

   Beware that, unlike in most collections, this method is
   NOT a constant-time operation. Because of the
   asynchronous nature of these sets, determining the current
   number of elements requires traversing them all to count them.
   Additionally, it is possible for the size to change during
   execution of this method, in which case the returned result
   will be inaccurate. Thus, this method is typically not very
   useful in concurrent applications.

  returns: the number of elements in this set - `int`"
  (^Integer [^ConcurrentSkipListSet this]
    (-> this (.size))))

(defn head-set
  "Description copied from interface: NavigableSet

  to-element - high endpoint of the returned set - `E`
  inclusive - true if the high endpoint is to be included in the returned view - `boolean`

  returns: a view of the portion of this set whose elements are less than
           (or equal to, if inclusive is true) toElement - `java.util.NavigableSet<E>`

  throws: java.lang.ClassCastException - if toElement is not compatible with this set's comparator (or, if the set has no comparator, if toElement does not implement Comparable). Implementations may, but are not required to, throw this exception if toElement cannot be compared to elements currently in the set."
  (^java.util.NavigableSet [^ConcurrentSkipListSet this to-element ^Boolean inclusive]
    (-> this (.headSet to-element inclusive)))
  (^java.util.NavigableSet [^ConcurrentSkipListSet this to-element]
    (-> this (.headSet to-element))))

(defn clear
  "Removes all of the elements from this set."
  ([^ConcurrentSkipListSet this]
    (-> this (.clear))))

(defn ceiling
  "Description copied from interface: NavigableSet

  e - the value to match - `E`

  returns: the least element greater than or equal to e,
           or null if there is no such element - `E`

  throws: java.lang.ClassCastException - if the specified element cannot be compared with the elements currently in the set"
  ([^ConcurrentSkipListSet this e]
    (-> this (.ceiling e))))

(defn remove-all
  "Removes from this set all of its elements that are contained in
   the specified collection.  If the specified collection is also
   a set, this operation effectively modifies this set so that its
   value is the asymmetric set difference of the two sets.

  c - collection containing elements to be removed from this set - `java.util.Collection`

  returns: true if this set changed as a result of the call - `boolean`

  throws: java.lang.ClassCastException - if the types of one or more elements in this set are incompatible with the specified collection"
  (^Boolean [^ConcurrentSkipListSet this ^java.util.Collection c]
    (-> this (.removeAll c))))

(defn equals
  "Compares the specified object with this set for equality.  Returns
   true if the specified object is also a set, the two sets
   have the same size, and every member of the specified set is
   contained in this set (or equivalently, every member of this set is
   contained in the specified set).  This definition ensures that the
   equals method works properly across different implementations of the
   set interface.

  o - the object to be compared for equality with this set - `java.lang.Object`

  returns: true if the specified object is equal to this set - `boolean`"
  (^Boolean [^ConcurrentSkipListSet this ^java.lang.Object o]
    (-> this (.equals o))))

(defn first
  "Description copied from interface: SortedSet

  returns: the first (lowest) element currently in this set - `E`

  throws: java.util.NoSuchElementException - if this set is empty"
  ([^ConcurrentSkipListSet this]
    (-> this (.first))))

