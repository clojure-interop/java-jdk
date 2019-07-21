(ns jdk.util.ArrayList
  "Resizable-array implementation of the List interface.  Implements
  all optional list operations, and permits all elements, including
  null.  In addition to implementing the List interface,
  this class provides methods to manipulate the size of the array that is
  used internally to store the list.  (This class is roughly equivalent to
  Vector, except that it is unsynchronized.)

  The size, isEmpty, get, set,
  iterator, and listIterator operations run in constant
  time.  The add operation runs in amortized constant time,
  that is, adding n elements requires O(n) time.  All of the other operations
  run in linear time (roughly speaking).  The constant factor is low compared
  to that for the LinkedList implementation.

  Each ArrayList instance has a capacity.  The capacity is
  the size of the array used to store the elements in the list.  It is always
  at least as large as the list size.  As elements are added to an ArrayList,
  its capacity grows automatically.  The details of the growth policy are not
  specified beyond the fact that adding an element has constant amortized
  time cost.

  An application can increase the capacity of an ArrayList instance
  before adding a large number of elements using the ensureCapacity
  operation.  This may reduce the amount of incremental reallocation.

  Note that this implementation is not synchronized.
  If multiple threads access an ArrayList instance concurrently,
  and at least one of the threads modifies the list structurally, it
  must be synchronized externally.  (A structural modification is
  any operation that adds or deletes one or more elements, or explicitly
  resizes the backing array; merely setting the value of an element is not
  a structural modification.)  This is typically accomplished by
  synchronizing on some object that naturally encapsulates the list.

  If no such object exists, the list should be \"wrapped\" using the
  Collections.synchronizedList
  method.  This is best done at creation time, to prevent accidental
  unsynchronized access to the list:

    List list = Collections.synchronizedList(new ArrayList(...));


  The iterators returned by this class's iterator and
  listIterator methods are fail-fast:
  if the list is structurally modified at any time after the iterator is
  created, in any way except through the iterator's own
  remove or
  add methods, the iterator will throw a
  ConcurrentModificationException.  Thus, in the face of
  concurrent modification, the iterator fails quickly and cleanly, rather
  than risking arbitrary, non-deterministic behavior at an undetermined
  time in the future.

  Note that the fail-fast behavior of an iterator cannot be guaranteed
  as it is, generally speaking, impossible to make any hard guarantees in the
  presence of unsynchronized concurrent modification.  Fail-fast iterators
  throw ConcurrentModificationException on a best-effort basis.
  Therefore, it would be wrong to write a program that depended on this
  exception for its correctness:  the fail-fast behavior of iterators
  should be used only to detect bugs.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util ArrayList]))

(defn ->array-list
  "Constructor.

  Constructs an empty list with the specified initial capacity.

  initial-capacity - the initial capacity of the list - `int`

  throws: java.lang.IllegalArgumentException - if the specified initial capacity is negative"
  (^ArrayList [^Integer initial-capacity]
    (new ArrayList initial-capacity))
  (^ArrayList []
    (new ArrayList )))

(defn add-all
  "Inserts all of the elements in the specified collection into this
   list, starting at the specified position.  Shifts the element
   currently at that position (if any) and any subsequent elements to
   the right (increases their indices).  The new elements will appear
   in the list in the order that they are returned by the
   specified collection's iterator.

  index - index at which to insert the first element from the specified collection - `int`
  c - collection containing elements to be added to this list - `java.util.Collection`

  returns: true if this list changed as a result of the call - `boolean`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())"
  (^Boolean [^ArrayList this ^Integer index ^java.util.Collection c]
    (-> this (.addAll index c)))
  (^Boolean [^ArrayList this ^java.util.Collection c]
    (-> this (.addAll c))))

(defn spliterator
  "Creates a late-binding
   and fail-fast Spliterator over the elements in this
   list.

   The Spliterator reports Spliterator.SIZED,
   Spliterator.SUBSIZED, and Spliterator.ORDERED.
   Overriding implementations should document the reporting of additional
   characteristic values.

  returns: a Spliterator over the elements in this list - `java.util.Spliterator<E>`"
  (^java.util.Spliterator [^ArrayList this]
    (-> this (.spliterator))))

(defn for-each
  "Description copied from interface: Iterable

  action - The action to be performed for each element - `java.util.function.Consumer`"
  ([^ArrayList this ^java.util.function.Consumer action]
    (-> this (.forEach action))))

(defn replace-all
  "Description copied from interface: List

  operator - the operator to apply to each element - `java.util.function.UnaryOperator`"
  ([^ArrayList this ^java.util.function.UnaryOperator operator]
    (-> this (.replaceAll operator))))

(defn remove-if
  "Description copied from interface: Collection

  filter - a predicate which returns true for elements to be removed - `java.util.function.Predicate`

  returns: true if any elements were removed - `boolean`"
  (^Boolean [^ArrayList this ^java.util.function.Predicate filter]
    (-> this (.removeIf filter))))

(defn contains
  "Returns true if this list contains the specified element.
   More formally, returns true if and only if this list contains
   at least one element e such that
   (o==null ? e==null : o.equals(e)).

  o - element whose presence in this list is to be tested - `java.lang.Object`

  returns: true if this list contains the specified element - `boolean`"
  (^Boolean [^ArrayList this ^java.lang.Object o]
    (-> this (.contains o))))

(defn list-iterator
  "Returns a list iterator over the elements in this list (in proper
   sequence), starting at the specified position in the list.
   The specified index indicates the first element that would be
   returned by an initial call to next.
   An initial call to previous would
   return the element with the specified index minus one.

   The returned list iterator is fail-fast.

  index - index of the first element to be returned from the list iterator (by a call to next) - `int`

  returns: a list iterator over the elements in this list (in proper
           sequence), starting at the specified position in the list - `java.util.ListIterator<E>`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())"
  (^java.util.ListIterator [^ArrayList this ^Integer index]
    (-> this (.listIterator index)))
  (^java.util.ListIterator [^ArrayList this]
    (-> this (.listIterator))))

(defn sort
  "Description copied from interface: List

  c - the Comparator used to compare list elements. A null value indicates that the elements' java.lang.natural ordering should be used - `java.util.Comparator`"
  ([^ArrayList this ^java.util.Comparator c]
    (-> this (.sort c))))

(defn iterator
  "Returns an iterator over the elements in this list in proper sequence.

   The returned iterator is fail-fast.

  returns: an iterator over the elements in this list in proper sequence - `java.util.Iterator<E>`"
  (^java.util.Iterator [^ArrayList this]
    (-> this (.iterator))))

(defn sub-list
  "Returns a view of the portion of this list between the specified
   fromIndex, inclusive, and toIndex, exclusive.  (If
   fromIndex and toIndex are equal, the returned list is
   empty.)  The returned list is backed by this list, so non-structural
   changes in the returned list are reflected in this list, and vice-versa.
   The returned list supports all of the optional list operations.

   This method eliminates the need for explicit range operations (of
   the sort that commonly exist for arrays).  Any operation that expects
   a list can be used as a range operation by passing a subList view
   instead of a whole list.  For example, the following idiom
   removes a range of elements from a list:


        list.subList(from, to).clear();
   Similar idioms may be constructed for indexOf(Object) and
   lastIndexOf(Object), and all of the algorithms in the
   Collections class can be applied to a subList.

   The semantics of the list returned by this method become undefined if
   the backing list (i.e., this list) is structurally modified in
   any way other than via the returned list.  (Structural modifications are
   those that change the size of this list, or otherwise perturb it in such
   a fashion that iterations in progress may yield incorrect results.)

  from-index - low endpoint (inclusive) of the subList - `int`
  to-index - high endpoint (exclusive) of the subList - `int`

  returns: a view of the specified range within this list - `java.util.List<E>`

  throws: java.lang.IndexOutOfBoundsException - if an endpoint index value is out of range (fromIndex < 0 || toIndex > size)"
  (^java.util.List [^ArrayList this ^Integer from-index ^Integer to-index]
    (-> this (.subList from-index to-index))))

(defn last-index-of
  "Returns the index of the last occurrence of the specified element
   in this list, or -1 if this list does not contain the element.
   More formally, returns the highest index i such that
   (o==null ? get(i)==null : o.equals(get(i))),
   or -1 if there is no such index.

  o - element to search for - `java.lang.Object`

  returns: the index of the last occurrence of the specified element in
           this list, or -1 if this list does not contain the element - `int`"
  (^Integer [^ArrayList this ^java.lang.Object o]
    (-> this (.lastIndexOf o))))

(defn remove
  "Removes the element at the specified position in this list.
   Shifts any subsequent elements to the left (subtracts one from their
   indices).

  index - the index of the element to be removed - `int`

  returns: the element that was removed from the list - `E`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())"
  ([^ArrayList this ^Integer index]
    (-> this (.remove index))))

(defn ensure-capacity
  "Increases the capacity of this ArrayList instance, if
   necessary, to ensure that it can hold at least the number of elements
   specified by the minimum capacity argument.

  min-capacity - the desired minimum capacity - `int`"
  ([^ArrayList this ^Integer min-capacity]
    (-> this (.ensureCapacity min-capacity))))

(defn clone
  "Returns a shallow copy of this ArrayList instance.  (The
   elements themselves are not copied.)

  returns: a clone of this ArrayList instance - `java.lang.Object`"
  (^java.lang.Object [^ArrayList this]
    (-> this (.clone))))

(defn add
  "Inserts the specified element at the specified position in this
   list. Shifts the element currently at that position (if any) and
   any subsequent elements to the right (adds one to their indices).

  index - index at which the specified element is to be inserted - `int`
  element - element to be inserted - `E`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())"
  ([^ArrayList this ^Integer index element]
    (-> this (.add index element)))
  (^Boolean [^ArrayList this e]
    (-> this (.add e))))

(defn set
  "Replaces the element at the specified position in this list with
   the specified element.

  index - index of the element to replace - `int`
  element - element to be stored at the specified position - `E`

  returns: the element previously at the specified position - `E`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())"
  ([^ArrayList this ^Integer index element]
    (-> this (.set index element))))

(defn empty?
  "Returns true if this list contains no elements.

  returns: true if this list contains no elements - `boolean`"
  (^Boolean [^ArrayList this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of elements in this list.

  returns: the number of elements in this list - `int`"
  (^Integer [^ArrayList this]
    (-> this (.size))))

(defn retain-all
  "Retains only the elements in this list that are contained in the
   specified collection.  In other words, removes from this list all
   of its elements that are not contained in the specified collection.

  c - collection containing elements to be retained in this list - `java.util.Collection`

  returns: true if this list changed as a result of the call - `boolean`

  throws: java.lang.ClassCastException - if the class of an element of this list is incompatible with the specified collection (optional)"
  (^Boolean [^ArrayList this ^java.util.Collection c]
    (-> this (.retainAll c))))

(defn clear
  "Removes all of the elements from this list.  The list will
   be empty after this call returns."
  ([^ArrayList this]
    (-> this (.clear))))

(defn index-of
  "Returns the index of the first occurrence of the specified element
   in this list, or -1 if this list does not contain the element.
   More formally, returns the lowest index i such that
   (o==null ? get(i)==null : o.equals(get(i))),
   or -1 if there is no such index.

  o - element to search for - `java.lang.Object`

  returns: the index of the first occurrence of the specified element in
           this list, or -1 if this list does not contain the element - `int`"
  (^Integer [^ArrayList this ^java.lang.Object o]
    (-> this (.indexOf o))))

(defn to-array
  "Returns an array containing all of the elements in this list in proper
   sequence (from first to last element); the runtime type of the returned
   array is that of the specified array.  If the list fits in the
   specified array, it is returned therein.  Otherwise, a new array is
   allocated with the runtime type of the specified array and the size of
   this list.

   If the list fits in the specified array with room to spare
   (i.e., the array has more elements than the list), the element in
   the array immediately following the end of the collection is set to
   null.  (This is useful in determining the length of the
   list only if the caller knows that the list does not contain
   any null elements.)

  a - the array into which the elements of the list are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose. - `T[]`

  returns: an array containing the elements of the list - `<T> T[]`

  throws: java.lang.ArrayStoreException - if the runtime type of the specified array is not a supertype of the runtime type of every element in this list"
  ([^ArrayList this a]
    (-> this (.toArray a)))
  ([^ArrayList this]
    (-> this (.toArray))))

(defn remove-all
  "Removes from this list all of its elements that are contained in the
   specified collection.

  c - collection containing elements to be removed from this list - `java.util.Collection`

  returns: true if this list changed as a result of the call - `boolean`

  throws: java.lang.ClassCastException - if the class of an element of this list is incompatible with the specified collection (optional)"
  (^Boolean [^ArrayList this ^java.util.Collection c]
    (-> this (.removeAll c))))

(defn get
  "Returns the element at the specified position in this list.

  index - index of the element to return - `int`

  returns: the element at the specified position in this list - `E`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())"
  ([^ArrayList this ^Integer index]
    (-> this (.get index))))

(defn trim-to-size
  "Trims the capacity of this ArrayList instance to be the
   list's current size.  An application can use this operation to minimize
   the storage of an ArrayList instance."
  ([^ArrayList this]
    (-> this (.trimToSize))))

