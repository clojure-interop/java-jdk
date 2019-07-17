(ns jdk.util.concurrent.CopyOnWriteArrayList
  "A thread-safe variant of ArrayList in which all mutative
  operations (add, set, and so on) are implemented by
  making a fresh copy of the underlying array.

  This is ordinarily too costly, but may be more efficient
  than alternatives when traversal operations vastly outnumber
  mutations, and is useful when you cannot or don't want to
  synchronize traversals, yet need to preclude interference among
  concurrent threads.  The `snapshot` style iterator method uses a
  reference to the state of the array at the point that the iterator
  was created. This array never changes during the lifetime of the
  iterator, so interference is impossible and the iterator is
  guaranteed not to throw ConcurrentModificationException.
  The iterator will not reflect additions, removals, or changes to
  the list since the iterator was created.  Element-changing
  operations on iterators themselves (remove, set, and
  add) are not supported. These methods throw
  UnsupportedOperationException.

  All elements are permitted, including null.

  Memory consistency effects: As with other concurrent
  collections, actions in a thread prior to placing an object into a
  CopyOnWriteArrayList
  happen-before
  actions subsequent to the access or removal of that element from
  the CopyOnWriteArrayList in another thread.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent CopyOnWriteArrayList]))

(defn ->copy-on-write-array-list
  "Constructor.

  Creates a list containing the elements of the specified
   collection, in the order they are returned by the collection's
   iterator.

  c - the collection of initially held elements - `CopyOnWriteArrayList.E>`

  throws: java.lang.NullPointerException - if the specified collection is null"
  ([^CopyOnWriteArrayList.E> c]
    (new CopyOnWriteArrayList c))
  ([]
    (new CopyOnWriteArrayList )))

(defn add-all
  "Inserts all of the elements in the specified collection into this
   list, starting at the specified position.  Shifts the element
   currently at that position (if any) and any subsequent elements to
   the right (increases their indices).  The new elements will appear
   in this list in the order that they are returned by the
   specified collection's iterator.

  index - index at which to insert the first element from the specified collection - `int`
  c - collection containing elements to be added to this list - `CopyOnWriteArrayList.E>`

  returns: true if this list changed as a result of the call - `boolean`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())"
  (^Boolean [^java.util.concurrent.CopyOnWriteArrayList this ^Integer index ^CopyOnWriteArrayList.E> c]
    (-> this (.addAll index c)))
  (^Boolean [^java.util.concurrent.CopyOnWriteArrayList this ^CopyOnWriteArrayList.E> c]
    (-> this (.addAll c))))

(defn spliterator
  "Returns a Spliterator over the elements in this list.

   The Spliterator reports Spliterator.IMMUTABLE,
   Spliterator.ORDERED, Spliterator.SIZED, and
   Spliterator.SUBSIZED.

   The spliterator provides a snapshot of the state of the list
   when the spliterator was constructed. No synchronization is needed while
   operating on the spliterator.

  returns: a Spliterator over the elements in this list - `java.util.Spliterator<CopyOnWriteArrayList.E>`"
  (^java.util.Spliterator [^java.util.concurrent.CopyOnWriteArrayList this]
    (-> this (.spliterator))))

(defn for-each
  "Description copied from interface: Iterable

  action - The action to be performed for each element - `CopyOnWriteArrayList.E>`"
  ([^java.util.concurrent.CopyOnWriteArrayList this ^CopyOnWriteArrayList.E> action]
    (-> this (.forEach action))))

(defn replace-all
  "Description copied from interface: List

  operator - the operator to apply to each element - `java.util.function.UnaryOperator<CopyOnWriteArrayList.E>`"
  ([^java.util.concurrent.CopyOnWriteArrayList this ^java.util.function.UnaryOperator operator]
    (-> this (.replaceAll operator))))

(defn remove-if
  "Description copied from interface: Collection

  filter - a predicate which returns true for elements to be removed - `CopyOnWriteArrayList.E>`

  returns: true if any elements were removed - `boolean`"
  (^Boolean [^java.util.concurrent.CopyOnWriteArrayList this ^CopyOnWriteArrayList.E> filter]
    (-> this (.removeIf filter))))

(defn contains
  "Returns true if this list contains the specified element.
   More formally, returns true if and only if this list contains
   at least one element e such that
   (o==null ? e==null : o.equals(e)).

  o - element whose presence in this list is to be tested - `java.lang.Object`

  returns: true if this list contains the specified element - `boolean`"
  (^Boolean [^java.util.concurrent.CopyOnWriteArrayList this ^java.lang.Object o]
    (-> this (.contains o))))

(defn to-string
  "Returns a string representation of this list.  The string
   representation consists of the string representations of the list's
   elements in the order they are returned by its iterator, enclosed in
   square brackets (`[]`).  Adjacent elements are separated by
   the characters `, ` (comma and space).  Elements are
   converted to strings as by String.valueOf(Object).

  returns: a string representation of this list - `java.lang.String`"
  (^java.lang.String [^java.util.concurrent.CopyOnWriteArrayList this]
    (-> this (.toString))))

(defn list-iterator
  "Returns a list iterator over the elements in this list (in proper
   sequence), starting at the specified position in the list.
   The specified index indicates the first element that would be
   returned by an initial call to next.
   An initial call to previous would
   return the element with the specified index minus one.

   The returned iterator provides a snapshot of the state of the list
   when the iterator was constructed. No synchronization is needed while
   traversing the iterator. The iterator does NOT support the
   remove, set or add methods.

  index - index of the first element to be returned from the list iterator (by a call to next) - `int`

  returns: a list iterator over the elements in this list (in proper
           sequence), starting at the specified position in the list - `java.util.ListIterator<CopyOnWriteArrayList.E>`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())"
  (^java.util.ListIterator [^java.util.concurrent.CopyOnWriteArrayList this ^Integer index]
    (-> this (.listIterator index)))
  (^java.util.ListIterator [^java.util.concurrent.CopyOnWriteArrayList this]
    (-> this (.listIterator))))

(defn sort
  "Description copied from interface: List

  c - the Comparator used to compare list elements. A null value indicates that the elements' java.lang.natural ordering should be used - `CopyOnWriteArrayList.E>`"
  ([^java.util.concurrent.CopyOnWriteArrayList this ^CopyOnWriteArrayList.E> c]
    (-> this (.sort c))))

(defn iterator
  "Returns an iterator over the elements in this list in proper sequence.

   The returned iterator provides a snapshot of the state of the list
   when the iterator was constructed. No synchronization is needed while
   traversing the iterator. The iterator does NOT support the
   remove method.

  returns: an iterator over the elements in this list in proper sequence - `java.util.Iterator<CopyOnWriteArrayList.E>`"
  (^java.util.Iterator [^java.util.concurrent.CopyOnWriteArrayList this]
    (-> this (.iterator))))

(defn add-if-absent
  "Appends the element, if not present.

  e - element to be added to this list, if absent - `CopyOnWriteArrayList.E`

  returns: true if the element was added - `boolean`"
  (^Boolean [^java.util.concurrent.CopyOnWriteArrayList this ^CopyOnWriteArrayList.E e]
    (-> this (.addIfAbsent e))))

(defn sub-list
  "Returns a view of the portion of this list between
   fromIndex, inclusive, and toIndex, exclusive.
   The returned list is backed by this list, so changes in the
   returned list are reflected in this list.

   The semantics of the list returned by this method become
   undefined if the backing list (i.e., this list) is modified in
   any way other than via the returned list.

  from-index - low endpoint (inclusive) of the subList - `int`
  to-index - high endpoint (exclusive) of the subList - `int`

  returns: a view of the specified range within this list - `java.util.List<CopyOnWriteArrayList.E>`

  throws: java.lang.IndexOutOfBoundsException - for an illegal endpoint index value (fromIndex < 0 || toIndex > size || fromIndex > toIndex)"
  (^java.util.List [^java.util.concurrent.CopyOnWriteArrayList this ^Integer from-index ^Integer to-index]
    (-> this (.subList from-index to-index))))

(defn last-index-of
  "Returns the index of the last occurrence of the specified element in
   this list, searching backwards from index, or returns -1 if
   the element is not found.
   More formally, returns the highest index i such that
   (i <= index && (e==null ? get(i)==null : e.equals(get(i)))),
   or -1 if there is no such index.

  e - element to search for - `CopyOnWriteArrayList.E`
  index - index to start searching backwards from - `int`

  returns: the index of the last occurrence of the element at position
           less than or equal to index in this list;
           -1 if the element is not found. - `int`

  throws: java.lang.IndexOutOfBoundsException - if the specified index is greater than or equal to the current size of this list"
  (^Integer [^java.util.concurrent.CopyOnWriteArrayList this ^CopyOnWriteArrayList.E e ^Integer index]
    (-> this (.lastIndexOf e index)))
  (^Integer [^java.util.concurrent.CopyOnWriteArrayList this ^java.lang.Object o]
    (-> this (.lastIndexOf o))))

(defn remove
  "Removes the element at the specified position in this list.
   Shifts any subsequent elements to the left (subtracts one from their
   indices).  Returns the element that was removed from the list.

  index - the index of the element to be removed - `int`

  returns: the element previously at the specified position - `CopyOnWriteArrayList.E`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())"
  (^CopyOnWriteArrayList.E [^java.util.concurrent.CopyOnWriteArrayList this ^Integer index]
    (-> this (.remove index))))

(defn clone
  "Returns a shallow copy of this list.  (The elements themselves
   are not copied.)

  returns: a clone of this list - `java.lang.Object`"
  (^java.lang.Object [^java.util.concurrent.CopyOnWriteArrayList this]
    (-> this (.clone))))

(defn hash-code
  "Returns the hash code value for this list.

   This implementation uses the definition in List.hashCode().

  returns: the hash code value for this list - `int`"
  (^Integer [^java.util.concurrent.CopyOnWriteArrayList this]
    (-> this (.hashCode))))

(defn add
  "Inserts the specified element at the specified position in this
   list. Shifts the element currently at that position (if any) and
   any subsequent elements to the right (adds one to their indices).

  index - index at which the specified element is to be inserted - `int`
  element - element to be inserted - `CopyOnWriteArrayList.E`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())"
  ([^java.util.concurrent.CopyOnWriteArrayList this ^Integer index ^CopyOnWriteArrayList.E element]
    (-> this (.add index element)))
  (^Boolean [^java.util.concurrent.CopyOnWriteArrayList this ^CopyOnWriteArrayList.E e]
    (-> this (.add e))))

(defn set
  "Replaces the element at the specified position in this list with the
   specified element.

  index - index of the element to replace - `int`
  element - element to be stored at the specified position - `CopyOnWriteArrayList.E`

  returns: the element previously at the specified position - `CopyOnWriteArrayList.E`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())"
  (^CopyOnWriteArrayList.E [^java.util.concurrent.CopyOnWriteArrayList this ^Integer index ^CopyOnWriteArrayList.E element]
    (-> this (.set index element))))

(defn empty?
  "Returns true if this list contains no elements.

  returns: true if this list contains no elements - `boolean`"
  (^Boolean [^java.util.concurrent.CopyOnWriteArrayList this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of elements in this list.

  returns: the number of elements in this list - `int`"
  (^Integer [^java.util.concurrent.CopyOnWriteArrayList this]
    (-> this (.size))))

(defn retain-all
  "Retains only the elements in this list that are contained in the
   specified collection.  In other words, removes from this list all of
   its elements that are not contained in the specified collection.

  c - collection containing elements to be retained in this list - `java.util.Collection<?>`

  returns: true if this list changed as a result of the call - `boolean`

  throws: java.lang.ClassCastException - if the class of an element of this list is incompatible with the specified collection (optional)"
  (^Boolean [^java.util.concurrent.CopyOnWriteArrayList this ^java.util.Collection c]
    (-> this (.retainAll c))))

(defn clear
  "Removes all of the elements from this list.
   The list will be empty after this call returns."
  ([^java.util.concurrent.CopyOnWriteArrayList this]
    (-> this (.clear))))

(defn index-of
  "Returns the index of the first occurrence of the specified element in
   this list, searching forwards from index, or returns -1 if
   the element is not found.
   More formally, returns the lowest index i such that
   (i >= index && (e==null ? get(i)==null : e.equals(get(i)))),
   or -1 if there is no such index.

  e - element to search for - `CopyOnWriteArrayList.E`
  index - index to start searching from - `int`

  returns: the index of the first occurrence of the element in
           this list at position index or later in the list;
           -1 if the element is not found. - `int`

  throws: java.lang.IndexOutOfBoundsException - if the specified index is negative"
  (^Integer [^java.util.concurrent.CopyOnWriteArrayList this ^CopyOnWriteArrayList.E e ^Integer index]
    (-> this (.indexOf e index)))
  (^Integer [^java.util.concurrent.CopyOnWriteArrayList this ^java.lang.Object o]
    (-> this (.indexOf o))))

(defn to-array
  "Returns an array containing all of the elements in this list in
   proper sequence (from first to last element); the runtime type of
   the returned array is that of the specified array.  If the list fits
   in the specified array, it is returned therein.  Otherwise, a new
   array is allocated with the runtime type of the specified array and
   the size of this list.

   If this list fits in the specified array with room to spare
   (i.e., the array has more elements than this list), the element in
   the array immediately following the end of the list is set to
   null.  (This is useful in determining the length of this
   list only if the caller knows that this list does not contain
   any null elements.)

   Like the toArray() method, this method acts as bridge between
   array-based and collection-based APIs.  Further, this method allows
   precise control over the runtime type of the output array, and may,
   under certain circumstances, be used to save allocation costs.

   Suppose x is a list known to contain only strings.
   The following code can be used to dump the list into a newly
   allocated array of String:



    String[] y = x.toArray(new String[0]);

   Note that toArray(new Object[0]) is identical in function to
   toArray().

  a - the array into which the elements of the list are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose. - `T[]`

  returns: an array containing all the elements in this list - `<T> T[]`

  throws: java.lang.ArrayStoreException - if the runtime type of the specified array is not a supertype of the runtime type of every element in this list"
  ([^java.util.concurrent.CopyOnWriteArrayList this a]
    (-> this (.toArray a)))
  ([^java.util.concurrent.CopyOnWriteArrayList this]
    (-> this (.toArray))))

(defn add-all-absent
  "Appends all of the elements in the specified collection that
   are not already contained in this list, to the end of
   this list, in the order that they are returned by the
   specified collection's iterator.

  c - collection containing elements to be added to this list - `CopyOnWriteArrayList.E>`

  returns: the number of elements added - `int`

  throws: java.lang.NullPointerException - if the specified collection is null"
  (^Integer [^java.util.concurrent.CopyOnWriteArrayList this ^CopyOnWriteArrayList.E> c]
    (-> this (.addAllAbsent c))))

(defn remove-all
  "Removes from this list all of its elements that are contained in
   the specified collection. This is a particularly expensive operation
   in this class because of the need for an internal temporary array.

  c - collection containing elements to be removed from this list - `java.util.Collection<?>`

  returns: true if this list changed as a result of the call - `boolean`

  throws: java.lang.ClassCastException - if the class of an element of this list is incompatible with the specified collection (optional)"
  (^Boolean [^java.util.concurrent.CopyOnWriteArrayList this ^java.util.Collection c]
    (-> this (.removeAll c))))

(defn get
  "Returns the element at the specified position in this list.

  index - index of the element to return - `int`

  returns: the element at the specified position in this list - `CopyOnWriteArrayList.E`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())"
  (^CopyOnWriteArrayList.E [^java.util.concurrent.CopyOnWriteArrayList this ^Integer index]
    (-> this (.get index))))

(defn equals
  "Compares the specified object with this list for equality.
   Returns true if the specified object is the same object
   as this object, or if it is also a List and the sequence
   of elements returned by an iterator
   over the specified list is the same as the sequence returned by
   an iterator over this list.  The two sequences are considered to
   be the same if they have the same length and corresponding
   elements at the same position in the sequence are equal.
   Two elements e1 and e2 are considered
   equal if (e1==null ? e2==null : e1.equals(e2)).

  o - the object to be compared for equality with this list - `java.lang.Object`

  returns: true if the specified object is equal to this list - `boolean`"
  (^Boolean [^java.util.concurrent.CopyOnWriteArrayList this ^java.lang.Object o]
    (-> this (.equals o))))

(defn contains-all
  "Returns true if this list contains all of the elements of the
   specified collection.

  c - collection to be checked for containment in this list - `java.util.Collection<?>`

  returns: true if this list contains all of the elements of the
           specified collection - `boolean`

  throws: java.lang.NullPointerException - if the specified collection is null"
  (^Boolean [^java.util.concurrent.CopyOnWriteArrayList this ^java.util.Collection c]
    (-> this (.containsAll c))))

