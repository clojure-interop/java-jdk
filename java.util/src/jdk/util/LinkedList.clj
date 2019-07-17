(ns jdk.util.LinkedList
  "Doubly-linked list implementation of the List and Deque
  interfaces.  Implements all optional list operations, and permits all
  elements (including null).

  All of the operations perform as could be expected for a doubly-linked
  list.  Operations that index into the list will traverse the list from
  the beginning or the end, whichever is closer to the specified index.

  Note that this implementation is not synchronized.
  If multiple threads access a linked list concurrently, and at least
  one of the threads modifies the list structurally, it must be
  synchronized externally.  (A structural modification is any operation
  that adds or deletes one or more elements; merely setting the value of
  an element is not a structural modification.)  This is typically
  accomplished by synchronizing on some object that naturally
  encapsulates the list.

  If no such object exists, the list should be `wrapped` using the
  Collections.synchronizedList
  method.  This is best done at creation time, to prevent accidental
  unsynchronized access to the list:

    List list = Collections.synchronizedList(new LinkedList(...));

  The iterators returned by this class's iterator and
  listIterator methods are fail-fast: if the list is
  structurally modified at any time after the iterator is created, in
  any way except through the Iterator's own remove or
  add methods, the iterator will throw a ConcurrentModificationException.  Thus, in the face of concurrent
  modification, the iterator fails quickly and cleanly, rather than
  risking arbitrary, non-deterministic behavior at an undetermined
  time in the future.

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
  (:import [java.util LinkedList]))

(defn ->linked-list
  "Constructor.

  Constructs a list containing the elements of the specified
   collection, in the order they are returned by the collection's
   iterator.

  c - the collection whose elements are to be placed into this list - `LinkedList.E>`

  throws: java.lang.NullPointerException - if the specified collection is null"
  ([^LinkedList.E> c]
    (new LinkedList c))
  ([]
    (new LinkedList )))

(defn add-all
  "Inserts all of the elements in the specified collection into this
   list, starting at the specified position.  Shifts the element
   currently at that position (if any) and any subsequent elements to
   the right (increases their indices).  The new elements will appear
   in the list in the order that they are returned by the
   specified collection's iterator.

  index - index at which to insert the first element from the specified collection - `int`
  c - collection containing elements to be added to this list - `LinkedList.E>`

  returns: true if this list changed as a result of the call - `boolean`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())"
  (^Boolean [^java.util.LinkedList this ^Integer index ^LinkedList.E> c]
    (-> this (.addAll index c)))
  (^Boolean [^java.util.LinkedList this ^LinkedList.E> c]
    (-> this (.addAll c))))

(defn peek
  "Retrieves, but does not remove, the head (first element) of this list.

  returns: the head of this list, or null if this list is empty - `LinkedList.E`"
  (^LinkedList.E [^java.util.LinkedList this]
    (-> this (.peek))))

(defn offer-first
  "Inserts the specified element at the front of this list.

  e - the element to insert - `LinkedList.E`

  returns: true (as specified by Deque.offerFirst(E)) - `boolean`"
  (^Boolean [^java.util.LinkedList this ^LinkedList.E e]
    (-> this (.offerFirst e))))

(defn get-first
  "Returns the first element in this list.

  returns: the first element in this list - `LinkedList.E`

  throws: java.util.NoSuchElementException - if this list is empty"
  (^LinkedList.E [^java.util.LinkedList this]
    (-> this (.getFirst))))

(defn spliterator
  "Creates a late-binding
   and fail-fast Spliterator over the elements in this
   list.

   The Spliterator reports Spliterator.SIZED and
   Spliterator.ORDERED.  Overriding implementations should document
   the reporting of additional characteristic values.

  returns: a Spliterator over the elements in this list - `java.util.Spliterator<LinkedList.E>`"
  (^java.util.Spliterator [^java.util.LinkedList this]
    (-> this (.spliterator))))

(defn peek-first
  "Retrieves, but does not remove, the first element of this list,
   or returns null if this list is empty.

  returns: the first element of this list, or null
           if this list is empty - `LinkedList.E`"
  (^LinkedList.E [^java.util.LinkedList this]
    (-> this (.peekFirst))))

(defn remove-first-occurrence
  "Removes the first occurrence of the specified element in this
   list (when traversing the list from head to tail).  If the list
   does not contain the element, it is unchanged.

  o - element to be removed from this list, if present - `java.lang.Object`

  returns: true if the list contained the specified element - `boolean`"
  (^Boolean [^java.util.LinkedList this ^java.lang.Object o]
    (-> this (.removeFirstOccurrence o))))

(defn offer
  "Adds the specified element as the tail (last element) of this list.

  e - the element to add - `LinkedList.E`

  returns: true (as specified by Queue.offer(E)) - `boolean`"
  (^Boolean [^java.util.LinkedList this ^LinkedList.E e]
    (-> this (.offer e))))

(defn peek-last
  "Retrieves, but does not remove, the last element of this list,
   or returns null if this list is empty.

  returns: the last element of this list, or null
           if this list is empty - `LinkedList.E`"
  (^LinkedList.E [^java.util.LinkedList this]
    (-> this (.peekLast))))

(defn pop
  "Pops an element from the stack represented by this list.  In other
   words, removes and returns the first element of this list.

   This method is equivalent to removeFirst().

  returns: the element at the front of this list (which is the top
           of the stack represented by this list) - `LinkedList.E`

  throws: java.util.NoSuchElementException - if this list is empty"
  (^LinkedList.E [^java.util.LinkedList this]
    (-> this (.pop))))

(defn contains
  "Returns true if this list contains the specified element.
   More formally, returns true if and only if this list contains
   at least one element e such that
   (o==null ? e==null : o.equals(e)).

  o - element whose presence in this list is to be tested - `java.lang.Object`

  returns: true if this list contains the specified element - `boolean`"
  (^Boolean [^java.util.LinkedList this ^java.lang.Object o]
    (-> this (.contains o))))

(defn push
  "Pushes an element onto the stack represented by this list.  In other
   words, inserts the element at the front of this list.

   This method is equivalent to addFirst(E).

  e - the element to push - `LinkedList.E`"
  ([^java.util.LinkedList this ^LinkedList.E e]
    (-> this (.push e))))

(defn get-last
  "Returns the last element in this list.

  returns: the last element in this list - `LinkedList.E`

  throws: java.util.NoSuchElementException - if this list is empty"
  (^LinkedList.E [^java.util.LinkedList this]
    (-> this (.getLast))))

(defn list-iterator
  "Returns a list-iterator of the elements in this list (in proper
   sequence), starting at the specified position in the list.
   Obeys the general contract of List.listIterator(int).

   The list-iterator is fail-fast: if the list is structurally
   modified at any time after the Iterator is created, in any way except
   through the list-iterator's own remove or add
   methods, the list-iterator will throw a
   ConcurrentModificationException.  Thus, in the face of
   concurrent modification, the iterator fails quickly and cleanly, rather
   than risking arbitrary, non-deterministic behavior at an undetermined
   time in the future.

  index - index of the first element to be returned from the list-iterator (by a call to next) - `int`

  returns: a ListIterator of the elements in this list (in proper
           sequence), starting at the specified position in the list - `java.util.ListIterator<LinkedList.E>`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())"
  (^java.util.ListIterator [^java.util.LinkedList this ^Integer index]
    (-> this (.listIterator index))))

(defn element
  "Retrieves, but does not remove, the head (first element) of this list.

  returns: the head of this list - `LinkedList.E`

  throws: java.util.NoSuchElementException - if this list is empty"
  (^LinkedList.E [^java.util.LinkedList this]
    (-> this (.element))))

(defn remove-first
  "Removes and returns the first element from this list.

  returns: the first element from this list - `LinkedList.E`

  throws: java.util.NoSuchElementException - if this list is empty"
  (^LinkedList.E [^java.util.LinkedList this]
    (-> this (.removeFirst))))

(defn last-index-of
  "Returns the index of the last occurrence of the specified element
   in this list, or -1 if this list does not contain the element.
   More formally, returns the highest index i such that
   (o==null ? get(i)==null : o.equals(get(i))),
   or -1 if there is no such index.

  o - element to search for - `java.lang.Object`

  returns: the index of the last occurrence of the specified element in
           this list, or -1 if this list does not contain the element - `int`"
  (^Integer [^java.util.LinkedList this ^java.lang.Object o]
    (-> this (.lastIndexOf o))))

(defn remove
  "Removes the first occurrence of the specified element from this list,
   if it is present.  If this list does not contain the element, it is
   unchanged.  More formally, removes the element with the lowest index
   i such that
   (o==null ? get(i)==null : o.equals(get(i)))
   (if such an element exists).  Returns true if this list
   contained the specified element (or equivalently, if this list
   changed as a result of the call).

  o - element to be removed from this list, if present - `java.lang.Object`

  returns: true if this list contained the specified element - `boolean`"
  (^Boolean [^java.util.LinkedList this ^java.lang.Object o]
    (-> this (.remove o)))
  (^LinkedList.E [^java.util.LinkedList this]
    (-> this (.remove))))

(defn poll-last
  "Retrieves and removes the last element of this list,
   or returns null if this list is empty.

  returns: the last element of this list, or null if
       this list is empty - `LinkedList.E`"
  (^LinkedList.E [^java.util.LinkedList this]
    (-> this (.pollLast))))

(defn poll
  "Retrieves and removes the head (first element) of this list.

  returns: the head of this list, or null if this list is empty - `LinkedList.E`"
  (^LinkedList.E [^java.util.LinkedList this]
    (-> this (.poll))))

(defn offer-last
  "Inserts the specified element at the end of this list.

  e - the element to insert - `LinkedList.E`

  returns: true (as specified by Deque.offerLast(E)) - `boolean`"
  (^Boolean [^java.util.LinkedList this ^LinkedList.E e]
    (-> this (.offerLast e))))

(defn poll-first
  "Retrieves and removes the first element of this list,
   or returns null if this list is empty.

  returns: the first element of this list, or null if
       this list is empty - `LinkedList.E`"
  (^LinkedList.E [^java.util.LinkedList this]
    (-> this (.pollFirst))))

(defn add-last
  "Appends the specified element to the end of this list.

   This method is equivalent to add(E).

  e - the element to add - `LinkedList.E`"
  ([^java.util.LinkedList this ^LinkedList.E e]
    (-> this (.addLast e))))

(defn clone
  "Returns a shallow copy of this LinkedList. (The elements
   themselves are not cloned.)

  returns: a shallow copy of this LinkedList instance - `java.lang.Object`"
  (^java.lang.Object [^java.util.LinkedList this]
    (-> this (.clone))))

(defn remove-last-occurrence
  "Removes the last occurrence of the specified element in this
   list (when traversing the list from head to tail).  If the list
   does not contain the element, it is unchanged.

  o - element to be removed from this list, if present - `java.lang.Object`

  returns: true if the list contained the specified element - `boolean`"
  (^Boolean [^java.util.LinkedList this ^java.lang.Object o]
    (-> this (.removeLastOccurrence o))))

(defn add
  "Inserts the specified element at the specified position in this list.
   Shifts the element currently at that position (if any) and any
   subsequent elements to the right (adds one to their indices).

  index - index at which the specified element is to be inserted - `int`
  element - element to be inserted - `LinkedList.E`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())"
  ([^java.util.LinkedList this ^Integer index ^LinkedList.E element]
    (-> this (.add index element)))
  (^Boolean [^java.util.LinkedList this ^LinkedList.E e]
    (-> this (.add e))))

(defn descending-iterator
  "Description copied from interface: Deque

  returns: an iterator over the elements in this deque in reverse
   sequence - `java.util.Iterator<LinkedList.E>`"
  (^java.util.Iterator [^java.util.LinkedList this]
    (-> this (.descendingIterator))))

(defn set
  "Replaces the element at the specified position in this list with the
   specified element.

  index - index of the element to replace - `int`
  element - element to be stored at the specified position - `LinkedList.E`

  returns: the element previously at the specified position - `LinkedList.E`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())"
  (^LinkedList.E [^java.util.LinkedList this ^Integer index ^LinkedList.E element]
    (-> this (.set index element))))

(defn size
  "Returns the number of elements in this list.

  returns: the number of elements in this list - `int`"
  (^Integer [^java.util.LinkedList this]
    (-> this (.size))))

(defn clear
  "Removes all of the elements from this list.
   The list will be empty after this call returns."
  ([^java.util.LinkedList this]
    (-> this (.clear))))

(defn remove-last
  "Removes and returns the last element from this list.

  returns: the last element from this list - `LinkedList.E`

  throws: java.util.NoSuchElementException - if this list is empty"
  (^LinkedList.E [^java.util.LinkedList this]
    (-> this (.removeLast))))

(defn add-first
  "Inserts the specified element at the beginning of this list.

  e - the element to add - `LinkedList.E`"
  ([^java.util.LinkedList this ^LinkedList.E e]
    (-> this (.addFirst e))))

(defn index-of
  "Returns the index of the first occurrence of the specified element
   in this list, or -1 if this list does not contain the element.
   More formally, returns the lowest index i such that
   (o==null ? get(i)==null : o.equals(get(i))),
   or -1 if there is no such index.

  o - element to search for - `java.lang.Object`

  returns: the index of the first occurrence of the specified element in
           this list, or -1 if this list does not contain the element - `int`"
  (^Integer [^java.util.LinkedList this ^java.lang.Object o]
    (-> this (.indexOf o))))

(defn to-array
  "Returns an array containing all of the elements in this list in
   proper sequence (from first to last element); the runtime type of
   the returned array is that of the specified array.  If the list fits
   in the specified array, it is returned therein.  Otherwise, a new
   array is allocated with the runtime type of the specified array and
   the size of this list.

   If the list fits in the specified array with room to spare (i.e.,
   the array has more elements than the list), the element in the array
   immediately following the end of the list is set to null.
   (This is useful in determining the length of the list only if
   the caller knows that the list does not contain any null elements.)

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

  returns: an array containing the elements of the list - `<T> T[]`

  throws: java.lang.ArrayStoreException - if the runtime type of the specified array is not a supertype of the runtime type of every element in this list"
  ([^java.util.LinkedList this a]
    (-> this (.toArray a)))
  ([^java.util.LinkedList this]
    (-> this (.toArray))))

(defn get
  "Returns the element at the specified position in this list.

  index - index of the element to return - `int`

  returns: the element at the specified position in this list - `LinkedList.E`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())"
  (^LinkedList.E [^java.util.LinkedList this ^Integer index]
    (-> this (.get index))))

