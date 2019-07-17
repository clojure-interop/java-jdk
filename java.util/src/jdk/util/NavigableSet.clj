(ns jdk.util.NavigableSet
  "A SortedSet extended with navigation methods reporting
  closest matches for given search targets. Methods lower,
  floor, ceiling, and higher return elements
  respectively less than, less than or equal, greater than or equal,
  and greater than a given element, returning null if there
  is no such element.  A NavigableSet may be accessed and
  traversed in either ascending or descending order.  The descendingSet method returns a view of the set with the senses of
  all relational and directional methods inverted. The performance of
  ascending operations and views is likely to be faster than that of
  descending ones.  This interface additionally defines methods
  pollFirst and pollLast that return and remove the
  lowest and highest element, if one exists, else returning null.  Methods subSet, headSet,
  and tailSet differ from the like-named SortedSet methods in accepting additional arguments describing
  whether lower and upper bounds are inclusive versus exclusive.
  Subsets of any NavigableSet must implement the NavigableSet interface.

   The return values of navigation methods may be ambiguous in
  implementations that permit null elements. However, even
  in this case the result can be disambiguated by checking
  contains(null). To avoid such issues, implementations of
  this interface are encouraged to not permit insertion of
  null elements. (Note that sorted sets of Comparable elements intrinsically do not permit null.)

  Methods
  subSet(E, E),
  headSet(E), and
  tailSet(E)
  are specified to return SortedSet to allow existing
  implementations of SortedSet to be compatibly retrofitted to
  implement NavigableSet, but extensions and implementations
  of this interface are encouraged to override these methods to return
  NavigableSet.

  This interface is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util NavigableSet]))

(defn floor
  "Returns the greatest element in this set less than or equal to
   the given element, or null if there is no such element.

  e - the value to match - `NavigableSet.E`

  returns: the greatest element less than or equal to e,
           or null if there is no such element - `NavigableSet.E`

  throws: java.lang.ClassCastException - if the specified element cannot be compared with the elements currently in the set"
  ([^java.util.NavigableSet this ^NavigableSet.E e]
    (-> this (.floor e))))

(defn tail-set
  "Returns a view of the portion of this set whose elements are greater
   than (or equal to, if inclusive is true) fromElement.
   The returned set is backed by this set, so changes in the returned set
   are reflected in this set, and vice-versa.  The returned set supports
   all optional set operations that this set supports.

   The returned set will throw an IllegalArgumentException
   on an attempt to insert an element outside its range.

  from-element - low endpoint of the returned set - `NavigableSet.E`
  inclusive - true if the low endpoint is to be included in the returned view - `boolean`

  returns: a view of the portion of this set whose elements are greater
           than or equal to fromElement - `java.util.NavigableSet<NavigableSet.E>`

  throws: java.lang.ClassCastException - if fromElement is not compatible with this set's comparator (or, if the set has no comparator, if fromElement does not implement Comparable). Implementations may, but are not required to, throw this exception if fromElement cannot be compared to elements currently in the set."
  ([^java.util.NavigableSet this ^NavigableSet.E from-element ^Boolean inclusive]
    (-> this (.tailSet from-element inclusive)))
  ([^java.util.NavigableSet this ^NavigableSet.E from-element]
    (-> this (.tailSet from-element))))

(defn iterator
  "Returns an iterator over the elements in this set, in ascending order.

  returns: an iterator over the elements in this set, in ascending order - `java.util.Iterator<NavigableSet.E>`"
  ([^java.util.NavigableSet this]
    (-> this (.iterator))))

(defn descending-set
  "Returns a reverse order view of the elements contained in this set.
   The descending set is backed by this set, so changes to the set are
   reflected in the descending set, and vice-versa.  If either set is
   modified while an iteration over either set is in progress (except
   through the iterator's own remove operation), the results of
   the iteration are undefined.

   The returned set has an ordering equivalent to
   Collections.reverseOrder(comparator()).
   The expression s.descendingSet().descendingSet() returns a
   view of s essentially equivalent to s.

  returns: a reverse order view of this set - `java.util.NavigableSet<NavigableSet.E>`"
  ([^java.util.NavigableSet this]
    (-> this (.descendingSet))))

(defn sub-set
  "Returns a view of the portion of this set whose elements range from
   fromElement to toElement.  If fromElement and
   toElement are equal, the returned set is empty unless fromInclusive and toInclusive are both true.  The returned set
   is backed by this set, so changes in the returned set are reflected in
   this set, and vice-versa.  The returned set supports all optional set
   operations that this set supports.

   The returned set will throw an IllegalArgumentException
   on an attempt to insert an element outside its range.

  from-element - low endpoint of the returned set - `NavigableSet.E`
  from-inclusive - true if the low endpoint is to be included in the returned view - `boolean`
  to-element - high endpoint of the returned set - `NavigableSet.E`
  to-inclusive - true if the high endpoint is to be included in the returned view - `boolean`

  returns: a view of the portion of this set whose elements range from
           fromElement, inclusive, to toElement, exclusive - `java.util.NavigableSet<NavigableSet.E>`

  throws: java.lang.ClassCastException - if fromElement and toElement cannot be compared to one another using this set's comparator (or, if the set has no comparator, using natural ordering). Implementations may, but are not required to, throw this exception if fromElement or toElement cannot be compared to elements currently in the set."
  ([^java.util.NavigableSet this ^NavigableSet.E from-element ^Boolean from-inclusive ^NavigableSet.E to-element ^Boolean to-inclusive]
    (-> this (.subSet from-element from-inclusive to-element to-inclusive)))
  ([^java.util.NavigableSet this ^NavigableSet.E from-element ^NavigableSet.E to-element]
    (-> this (.subSet from-element to-element))))

(defn poll-last
  "Retrieves and removes the last (highest) element,
   or returns null if this set is empty.

  returns: the last element, or null if this set is empty - `NavigableSet.E`"
  ([^java.util.NavigableSet this]
    (-> this (.pollLast))))

(defn poll-first
  "Retrieves and removes the first (lowest) element,
   or returns null if this set is empty.

  returns: the first element, or null if this set is empty - `NavigableSet.E`"
  ([^java.util.NavigableSet this]
    (-> this (.pollFirst))))

(defn higher
  "Returns the least element in this set strictly greater than the
   given element, or null if there is no such element.

  e - the value to match - `NavigableSet.E`

  returns: the least element greater than e,
           or null if there is no such element - `NavigableSet.E`

  throws: java.lang.ClassCastException - if the specified element cannot be compared with the elements currently in the set"
  ([^java.util.NavigableSet this ^NavigableSet.E e]
    (-> this (.higher e))))

(defn lower
  "Returns the greatest element in this set strictly less than the
   given element, or null if there is no such element.

  e - the value to match - `NavigableSet.E`

  returns: the greatest element less than e,
           or null if there is no such element - `NavigableSet.E`

  throws: java.lang.ClassCastException - if the specified element cannot be compared with the elements currently in the set"
  ([^java.util.NavigableSet this ^NavigableSet.E e]
    (-> this (.lower e))))

(defn descending-iterator
  "Returns an iterator over the elements in this set, in descending order.
   Equivalent in effect to descendingSet().iterator().

  returns: an iterator over the elements in this set, in descending order - `java.util.Iterator<NavigableSet.E>`"
  ([^java.util.NavigableSet this]
    (-> this (.descendingIterator))))

(defn head-set
  "Returns a view of the portion of this set whose elements are less than
   (or equal to, if inclusive is true) toElement.  The
   returned set is backed by this set, so changes in the returned set are
   reflected in this set, and vice-versa.  The returned set supports all
   optional set operations that this set supports.

   The returned set will throw an IllegalArgumentException
   on an attempt to insert an element outside its range.

  to-element - high endpoint of the returned set - `NavigableSet.E`
  inclusive - true if the high endpoint is to be included in the returned view - `boolean`

  returns: a view of the portion of this set whose elements are less than
           (or equal to, if inclusive is true) toElement - `java.util.NavigableSet<NavigableSet.E>`

  throws: java.lang.ClassCastException - if toElement is not compatible with this set's comparator (or, if the set has no comparator, if toElement does not implement Comparable). Implementations may, but are not required to, throw this exception if toElement cannot be compared to elements currently in the set."
  ([^java.util.NavigableSet this ^NavigableSet.E to-element ^Boolean inclusive]
    (-> this (.headSet to-element inclusive)))
  ([^java.util.NavigableSet this ^NavigableSet.E to-element]
    (-> this (.headSet to-element))))

(defn ceiling
  "Returns the least element in this set greater than or equal to
   the given element, or null if there is no such element.

  e - the value to match - `NavigableSet.E`

  returns: the least element greater than or equal to e,
           or null if there is no such element - `NavigableSet.E`

  throws: java.lang.ClassCastException - if the specified element cannot be compared with the elements currently in the set"
  ([^java.util.NavigableSet this ^NavigableSet.E e]
    (-> this (.ceiling e))))

