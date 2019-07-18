(ns jdk.util.AbstractList
  "This class provides a skeletal implementation of the List
  interface to minimize the effort required to implement this interface
  backed by a `random access` data store (such as an array).  For sequential
  access data (such as a linked list), AbstractSequentialList should
  be used in preference to this class.

  To implement an unmodifiable list, the programmer needs only to extend
  this class and provide implementations for the get(int) and
  size() methods.

  To implement a modifiable list, the programmer must additionally
  override the set(int, E) method (which otherwise
  throws an UnsupportedOperationException).  If the list is
  variable-size the programmer must additionally override the
  add(int, E) and remove(int) methods.

  The programmer should generally provide a void (no argument) and collection
  constructor, as per the recommendation in the Collection interface
  specification.

  Unlike the other abstract collection implementations, the programmer does
  not have to provide an iterator implementation; the iterator and
  list iterator are implemented by this class, on top of the `random access`
  methods:
  get(int),
  set(int, E),
  add(int, E) and
  remove(int).

  The documentation for each non-abstract method in this class describes its
  implementation in detail.  Each of these methods may be overridden if the
  collection being implemented admits a more efficient implementation.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util AbstractList]))

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

   This implementation gets an iterator over the specified collection
   and iterates over it, inserting the elements obtained from the
   iterator into this list at the appropriate position, one at a time,
   using add(int, E).
   Many implementations will override this method for efficiency.

   Note that this implementation throws an
   UnsupportedOperationException unless
   add(int, E) is overridden.

  index - index at which to insert the first element from the specified collection - `int`
  c - collection containing elements to be added to this list - `java.util.Collection`

  returns: true if this list changed as a result of the call - `boolean`

  throws: java.lang.UnsupportedOperationException - if the addAll operation is not supported by this list"
  (^Boolean [^AbstractList this ^Integer index ^java.util.Collection c]
    (-> this (.addAll index c))))

(defn list-iterator
  "Returns a list iterator over the elements in this list (in proper
   sequence), starting at the specified position in the list.
   The specified index indicates the first element that would be
   returned by an initial call to next.
   An initial call to previous would
   return the element with the specified index minus one.

   This implementation returns a straightforward implementation of the
   ListIterator interface that extends the implementation of the
   Iterator interface returned by the iterator() method.
   The ListIterator implementation relies on the backing list's
   get(int), set(int, E), add(int, E)
   and remove(int) methods.

   Note that the list iterator returned by this implementation will
   throw an UnsupportedOperationException in response to its
   remove, set and add methods unless the
   list's remove(int), set(int, E), and
   add(int, E) methods are overridden.

   This implementation can be made to throw runtime exceptions in the
   face of concurrent modification, as described in the specification for
   the (protected) modCount field.

  index - index of the first element to be returned from the list iterator (by a call to next) - `int`

  returns: a list iterator over the elements in this list (in proper
           sequence), starting at the specified position in the list - `java.util.ListIterator<E>`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())"
  (^java.util.ListIterator [^AbstractList this ^Integer index]
    (-> this (.listIterator index)))
  (^java.util.ListIterator [^AbstractList this]
    (-> this (.listIterator))))

(defn iterator
  "Returns an iterator over the elements in this list in proper sequence.

   This implementation returns a straightforward implementation of the
   iterator interface, relying on the backing list's size(),
   get(int), and remove(int) methods.

   Note that the iterator returned by this method will throw an
   UnsupportedOperationException in response to its
   remove method unless the list's remove(int) method is
   overridden.

   This implementation can be made to throw runtime exceptions in the
   face of concurrent modification, as described in the specification
   for the (protected) modCount field.

  returns: an iterator over the elements in this list in proper sequence - `java.util.Iterator<E>`"
  (^java.util.Iterator [^AbstractList this]
    (-> this (.iterator))))

(defn sub-list
  "Returns a view of the portion of this list between the specified
   fromIndex, inclusive, and toIndex, exclusive.  (If
   fromIndex and toIndex are equal, the returned list is
   empty.)  The returned list is backed by this list, so non-structural
   changes in the returned list are reflected in this list, and vice-versa.
   The returned list supports all of the optional list operations supported
   by this list.

   This method eliminates the need for explicit range operations (of
   the sort that commonly exist for arrays).  Any operation that expects
   a list can be used as a range operation by passing a subList view
   instead of a whole list.  For example, the following idiom
   removes a range of elements from a list:


        list.subList(from, to).clear();
   Similar idioms may be constructed for indexOf and
   lastIndexOf, and all of the algorithms in the
   Collections class can be applied to a subList.

   The semantics of the list returned by this method become undefined if
   the backing list (i.e., this list) is structurally modified in
   any way other than via the returned list.  (Structural modifications are
   those that change the size of this list, or otherwise perturb it in such
   a fashion that iterations in progress may yield incorrect results.)

   This implementation returns a list that subclasses
   AbstractList.  The subclass stores, in private fields, the
   offset of the subList within the backing list, the size of the subList
   (which can change over its lifetime), and the expected
   modCount value of the backing list.  There are two variants
   of the subclass, one of which implements RandomAccess.
   If this list implements RandomAccess the returned list will
   be an instance of the subclass that implements RandomAccess.

   The subclass's set(int, E), get(int),
   add(int, E), remove(int), addAll(int,
   Collection) and removeRange(int, int) methods all
   delegate to the corresponding methods on the backing abstract list,
   after bounds-checking the index and adjusting for the offset.  The
   addAll(Collection c) method merely returns addAll(size,
   c).

   The listIterator(int) method returns a `wrapper object`
   over a list iterator on the backing list, which is created with the
   corresponding method on the backing list.  The iterator method
   merely returns listIterator(), and the size method
   merely returns the subclass's size field.

   All methods first check to see if the actual modCount of
   the backing list is equal to its expected value, and throw a
   ConcurrentModificationException if it is not.

  from-index - low endpoint (inclusive) of the subList - `int`
  to-index - high endpoint (exclusive) of the subList - `int`

  returns: a view of the specified range within this list - `java.util.List<E>`

  throws: java.lang.IndexOutOfBoundsException - if an endpoint index value is out of range (fromIndex < 0 || toIndex > size)"
  (^java.util.List [^AbstractList this ^Integer from-index ^Integer to-index]
    (-> this (.subList from-index to-index))))

(defn last-index-of
  "Returns the index of the last occurrence of the specified element
   in this list, or -1 if this list does not contain the element.
   More formally, returns the highest index i such that
   (o==null ? get(i)==null : o.equals(get(i))),
   or -1 if there is no such index.

   This implementation first gets a list iterator that points to the end
   of the list (with listIterator(size())).  Then, it iterates
   backwards over the list until the specified element is found, or the
   beginning of the list is reached.

  o - element to search for - `java.lang.Object`

  returns: the index of the last occurrence of the specified element in
           this list, or -1 if this list does not contain the element - `int`

  throws: java.lang.ClassCastException - if the type of the specified element is incompatible with this list (optional)"
  (^Integer [^AbstractList this ^java.lang.Object o]
    (-> this (.lastIndexOf o))))

(defn remove
  "Removes the element at the specified position in this list (optional
   operation).  Shifts any subsequent elements to the left (subtracts one
   from their indices).  Returns the element that was removed from the
   list.

   This implementation always throws an
   UnsupportedOperationException.

  index - the index of the element to be removed - `int`

  returns: the element previously at the specified position - `E`

  throws: java.lang.UnsupportedOperationException - if the remove operation is not supported by this list"
  ([^AbstractList this ^Integer index]
    (-> this (.remove index))))

(defn hash-code
  "Returns the hash code value for this list.

   This implementation uses exactly the code that is used to define the
   list hash function in the documentation for the List.hashCode()
   method.

  returns: the hash code value for this list - `int`"
  (^Integer [^AbstractList this]
    (-> this (.hashCode))))

(defn add
  "Inserts the specified element at the specified position in this list
   (optional operation).  Shifts the element currently at that position
   (if any) and any subsequent elements to the right (adds one to their
   indices).

   This implementation always throws an
   UnsupportedOperationException.

  index - index at which the specified element is to be inserted - `int`
  element - element to be inserted - `E`

  throws: java.lang.UnsupportedOperationException - if the add operation is not supported by this list"
  ([^AbstractList this ^Integer index element]
    (-> this (.add index element)))
  (^Boolean [^AbstractList this e]
    (-> this (.add e))))

(defn set
  "Replaces the element at the specified position in this list with the
   specified element (optional operation).

   This implementation always throws an
   UnsupportedOperationException.

  index - index of the element to replace - `int`
  element - element to be stored at the specified position - `E`

  returns: the element previously at the specified position - `E`

  throws: java.lang.UnsupportedOperationException - if the set operation is not supported by this list"
  ([^AbstractList this ^Integer index element]
    (-> this (.set index element))))

(defn clear
  "Removes all of the elements from this list (optional operation).
   The list will be empty after this call returns.

   This implementation calls removeRange(0, size()).

   Note that this implementation throws an
   UnsupportedOperationException unless remove(int
   index) or removeRange(int fromIndex, int toIndex) is
   overridden.

  throws: java.lang.UnsupportedOperationException - if the clear operation is not supported by this list"
  ([^AbstractList this]
    (-> this (.clear))))

(defn index-of
  "Returns the index of the first occurrence of the specified element
   in this list, or -1 if this list does not contain the element.
   More formally, returns the lowest index i such that
   (o==null ? get(i)==null : o.equals(get(i))),
   or -1 if there is no such index.

   This implementation first gets a list iterator (with
   listIterator()).  Then, it iterates over the list until the
   specified element is found or the end of the list is reached.

  o - element to search for - `java.lang.Object`

  returns: the index of the first occurrence of the specified element in
           this list, or -1 if this list does not contain the element - `int`

  throws: java.lang.ClassCastException - if the type of the specified element is incompatible with this list (optional)"
  (^Integer [^AbstractList this ^java.lang.Object o]
    (-> this (.indexOf o))))

(defn get
  "Returns the element at the specified position in this list.

  index - index of the element to return - `int`

  returns: the element at the specified position in this list - `E`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())"
  ([^AbstractList this ^Integer index]
    (-> this (.get index))))

(defn equals
  "Compares the specified object with this list for equality.  Returns
   true if and only if the specified object is also a list, both
   lists have the same size, and all corresponding pairs of elements in
   the two lists are equal.  (Two elements e1 and
   e2 are equal if (e1==null ? e2==null :
   e1.equals(e2)).)  In other words, two lists are defined to be
   equal if they contain the same elements in the same order.

   This implementation first checks if the specified object is this
   list. If so, it returns true; if not, it checks if the
   specified object is a list. If not, it returns false; if so,
   it iterates over both lists, comparing corresponding pairs of elements.
   If any comparison returns false, this method returns
   false.  If either iterator runs out of elements before the
   other it returns false (as the lists are of unequal length);
   otherwise it returns true when the iterations complete.

  o - the object to be compared for equality with this list - `java.lang.Object`

  returns: true if the specified object is equal to this list - `boolean`"
  (^Boolean [^AbstractList this ^java.lang.Object o]
    (-> this (.equals o))))

