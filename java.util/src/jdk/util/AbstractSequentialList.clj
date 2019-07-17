(ns jdk.util.AbstractSequentialList
  "This class provides a skeletal implementation of the List
  interface to minimize the effort required to implement this interface
  backed by a `sequential access` data store (such as a linked list).  For
  random access data (such as an array), AbstractList should be used
  in preference to this class.

  This class is the opposite of the AbstractList class in the sense
  that it implements the `random access` methods (get(int index),
  set(int index, E element), add(int index, E element) and
  remove(int index)) on top of the list's list iterator, instead of
  the other way around.

  To implement a list the programmer needs only to extend this class and
  provide implementations for the listIterator and size
  methods.  For an unmodifiable list, the programmer need only implement the
  list iterator's hasNext, next, hasPrevious,
  previous and index methods.

  For a modifiable list the programmer should additionally implement the list
  iterator's set method.  For a variable-size list the programmer
  should additionally implement the list iterator's remove and
  add methods.

  The programmer should generally provide a void (no argument) and collection
  constructor, as per the recommendation in the Collection interface
  specification.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util AbstractSequentialList]))

(defn get
  "Returns the element at the specified position in this list.

   This implementation first gets a list iterator pointing to the
   indexed element (with listIterator(index)).  Then, it gets
   the element using ListIterator.next and returns it.

  index - index of the element to return - `int`

  returns: the element at the specified position in this list - `AbstractSequentialList.E`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())"
  ([^java.util.AbstractSequentialList this ^Integer index]
    (-> this (.get index))))

(defn set
  "Replaces the element at the specified position in this list with the
   specified element (optional operation).

   This implementation first gets a list iterator pointing to the
   indexed element (with listIterator(index)).  Then, it gets
   the current element using ListIterator.next and replaces it
   with ListIterator.set.

   Note that this implementation will throw an
   UnsupportedOperationException if the list iterator does not
   implement the set operation.

  index - index of the element to replace - `int`
  element - element to be stored at the specified position - `AbstractSequentialList.E`

  returns: the element previously at the specified position - `AbstractSequentialList.E`

  throws: java.lang.UnsupportedOperationException - if the set operation is not supported by this list"
  ([^java.util.AbstractSequentialList this ^Integer index ^AbstractSequentialList.E element]
    (-> this (.set index element))))

(defn add
  "Inserts the specified element at the specified position in this list
   (optional operation).  Shifts the element currently at that position
   (if any) and any subsequent elements to the right (adds one to their
   indices).

   This implementation first gets a list iterator pointing to the
   indexed element (with listIterator(index)).  Then, it
   inserts the specified element with ListIterator.add.

   Note that this implementation will throw an
   UnsupportedOperationException if the list iterator does not
   implement the add operation.

  index - index at which the specified element is to be inserted - `int`
  element - element to be inserted - `AbstractSequentialList.E`

  throws: java.lang.UnsupportedOperationException - if the add operation is not supported by this list"
  ([^java.util.AbstractSequentialList this ^Integer index ^AbstractSequentialList.E element]
    (-> this (.add index element))))

(defn remove
  "Removes the element at the specified position in this list (optional
   operation).  Shifts any subsequent elements to the left (subtracts one
   from their indices).  Returns the element that was removed from the
   list.

   This implementation first gets a list iterator pointing to the
   indexed element (with listIterator(index)).  Then, it removes
   the element with ListIterator.remove.

   Note that this implementation will throw an
   UnsupportedOperationException if the list iterator does not
   implement the remove operation.

  index - the index of the element to be removed - `int`

  returns: the element previously at the specified position - `AbstractSequentialList.E`

  throws: java.lang.UnsupportedOperationException - if the remove operation is not supported by this list"
  ([^java.util.AbstractSequentialList this ^Integer index]
    (-> this (.remove index))))

(defn add-all
  "Inserts all of the elements in the specified collection into this
   list at the specified position (optional operation).  Shifts the
   element currently at that position (if any) and any subsequent
   elements to the right (increases their indices).  The new elements
   will appear in this list in the order that they are returned by the
   specified collection's iterator.  The behavior of this operation is
   undefined if the specified collection is modified while the
   operation is in progress.  (Note that this will occur if the specified
   collection is this list, and it's nonempty.)

   This implementation gets an iterator over the specified collection and
   a list iterator over this list pointing to the indexed element (with
   listIterator(index)).  Then, it iterates over the specified
   collection, inserting the elements obtained from the iterator into this
   list, one at a time, using ListIterator.add followed by
   ListIterator.next (to skip over the added element).

   Note that this implementation will throw an
   UnsupportedOperationException if the list iterator returned by
   the listIterator method does not implement the add
   operation.

  index - index at which to insert the first element from the specified collection - `int`
  c - collection containing elements to be added to this list - `AbstractSequentialList.E>`

  returns: true if this list changed as a result of the call - `boolean`

  throws: java.lang.UnsupportedOperationException - if the addAll operation is not supported by this list"
  ([^java.util.AbstractSequentialList this ^Integer index ^AbstractSequentialList.E> c]
    (-> this (.addAll index c))))

(defn iterator
  "Returns an iterator over the elements in this list (in proper
   sequence).

   This implementation merely returns a list iterator over the list.

  returns: an iterator over the elements in this list (in proper sequence) - `java.util.Iterator<AbstractSequentialList.E>`"
  ([^java.util.AbstractSequentialList this]
    (-> this (.iterator))))

(defn list-iterator
  "Returns a list iterator over the elements in this list (in proper
   sequence).

  index - index of first element to be returned from the list iterator (by a call to the next method) - `int`

  returns: a list iterator over the elements in this list (in proper
           sequence) - `java.util.ListIterator<AbstractSequentialList.E>`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())"
  ([^java.util.AbstractSequentialList this ^Integer index]
    (-> this (.listIterator index))))

