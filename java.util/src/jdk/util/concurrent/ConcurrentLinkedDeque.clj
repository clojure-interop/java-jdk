(ns jdk.util.concurrent.ConcurrentLinkedDeque
  "An unbounded concurrent java.util.deque based on linked nodes.
  Concurrent insertion, removal, and access operations execute safely
  across multiple threads.
  A ConcurrentLinkedDeque is an appropriate choice when
  many threads will share access to a common collection.
  Like most other concurrent collection implementations, this class
  does not permit the use of null elements.

  Iterators and spliterators are
  weakly consistent.

  Beware that, unlike in most collections, the size method
  is NOT a constant-time operation. Because of the
  asynchronous nature of these deques, determining the current number
  of elements requires a traversal of the elements, and so may report
  inaccurate results if this collection is modified during traversal.
  Additionally, the bulk operations addAll,
  removeAll, retainAll, containsAll,
  equals, and toArray are not guaranteed
  to be performed atomically. For example, an iterator operating
  concurrently with an addAll operation might view only some
  of the added elements.

  This class and its iterator implement all of the optional
  methods of the Deque and Iterator interfaces.

  Memory consistency effects: As with other concurrent collections,
  actions in a thread prior to placing an object into a
  ConcurrentLinkedDeque
  happen-before
  actions subsequent to the access or removal of that element from
  the ConcurrentLinkedDeque in another thread.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ConcurrentLinkedDeque]))

(defn ->concurrent-linked-deque
  "Constructor.

  Constructs a deque initially containing the elements of
   the given collection, added in traversal order of the
   collection's iterator.

  c - the collection of elements to initially contain - `java.util.Collection`

  throws: java.lang.NullPointerException - if the specified collection or any of its elements are null"
  (^ConcurrentLinkedDeque [^java.util.Collection c]
    (new ConcurrentLinkedDeque c))
  (^ConcurrentLinkedDeque []
    (new ConcurrentLinkedDeque )))

(defn add-all
  "Appends all of the elements in the specified collection to the end of
   this deque, in the order that they are returned by the specified
   collection's iterator.  Attempts to addAll of a deque to
   itself result in IllegalArgumentException.

  c - the elements to be inserted into this deque - `java.util.Collection`

  returns: true if this deque changed as a result of the call - `boolean`

  throws: java.lang.NullPointerException - if the specified collection or any of its elements are null"
  (^Boolean [^ConcurrentLinkedDeque this ^java.util.Collection c]
    (-> this (.addAll c))))

(defn peek
  "Description copied from interface: Deque

  returns: the head of the queue represented by this deque, or
           null if this deque is empty - `E`"
  ([^ConcurrentLinkedDeque this]
    (-> this (.peek))))

(defn offer-first
  "Inserts the specified element at the front of this deque.
   As the deque is unbounded, this method will never return false.

  e - the element to add - `E`

  returns: true (as specified by Deque.offerFirst(E)) - `boolean`

  throws: java.lang.NullPointerException - if the specified element is null"
  (^Boolean [^ConcurrentLinkedDeque this e]
    (-> this (.offerFirst e))))

(defn get-first
  "Description copied from interface: Deque

  returns: the head of this deque - `E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  ([^ConcurrentLinkedDeque this]
    (-> this (.getFirst))))

(defn spliterator
  "Returns a Spliterator over the elements in this deque.

   The returned spliterator is
   weakly consistent.

   The Spliterator reports Spliterator.CONCURRENT,
   Spliterator.ORDERED, and Spliterator.NONNULL.

  returns: a Spliterator over the elements in this deque - `java.util.Spliterator<E>`"
  (^java.util.Spliterator [^ConcurrentLinkedDeque this]
    (-> this (.spliterator))))

(defn peek-first
  "Description copied from interface: Deque

  returns: the head of this deque, or null if this deque is empty - `E`"
  ([^ConcurrentLinkedDeque this]
    (-> this (.peekFirst))))

(defn remove-first-occurrence
  "Removes the first element e such that
   o.equals(e), if such an element exists in this deque.
   If the deque does not contain the element, it is unchanged.

  o - element to be removed from this deque, if present - `java.lang.Object`

  returns: true if the deque contained the specified element - `boolean`

  throws: java.lang.NullPointerException - if the specified element is null"
  (^Boolean [^ConcurrentLinkedDeque this ^java.lang.Object o]
    (-> this (.removeFirstOccurrence o))))

(defn offer
  "Inserts the specified element at the tail of this deque.
   As the deque is unbounded, this method will never return false.

  e - the element to add - `E`

  returns: true (as specified by Queue.offer(E)) - `boolean`

  throws: java.lang.NullPointerException - if the specified element is null"
  (^Boolean [^ConcurrentLinkedDeque this e]
    (-> this (.offer e))))

(defn peek-last
  "Description copied from interface: Deque

  returns: the tail of this deque, or null if this deque is empty - `E`"
  ([^ConcurrentLinkedDeque this]
    (-> this (.peekLast))))

(defn pop
  "Description copied from interface: Deque

  returns: the element at the front of this deque (which is the top
           of the stack represented by this deque) - `E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  ([^ConcurrentLinkedDeque this]
    (-> this (.pop))))

(defn contains
  "Returns true if this deque contains at least one
   element e such that o.equals(e).

  o - element whose presence in this deque is to be tested - `java.lang.Object`

  returns: true if this deque contains the specified element - `boolean`"
  (^Boolean [^ConcurrentLinkedDeque this ^java.lang.Object o]
    (-> this (.contains o))))

(defn push
  "Description copied from interface: Deque

  e - the element to push - `E`

  throws: java.lang.NullPointerException - if the specified element is null and this deque does not permit null elements"
  ([^ConcurrentLinkedDeque this e]
    (-> this (.push e))))

(defn get-last
  "Description copied from interface: Deque

  returns: the tail of this deque - `E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  ([^ConcurrentLinkedDeque this]
    (-> this (.getLast))))

(defn iterator
  "Returns an iterator over the elements in this deque in proper sequence.
   The elements will be returned in order from first (head) to last (tail).

   The returned iterator is
   weakly consistent.

  returns: an iterator over the elements in this deque in proper sequence - `java.util.Iterator<E>`"
  (^java.util.Iterator [^ConcurrentLinkedDeque this]
    (-> this (.iterator))))

(defn element
  "Description copied from interface: Deque

  returns: the head of the queue represented by this deque - `E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  ([^ConcurrentLinkedDeque this]
    (-> this (.element))))

(defn remove-first
  "Description copied from interface: Deque

  returns: the head of this deque - `E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  ([^ConcurrentLinkedDeque this]
    (-> this (.removeFirst))))

(defn remove
  "Removes the first element e such that
   o.equals(e), if such an element exists in this deque.
   If the deque does not contain the element, it is unchanged.

  o - element to be removed from this deque, if present - `java.lang.Object`

  returns: true if the deque contained the specified element - `boolean`

  throws: java.lang.NullPointerException - if the specified element is null"
  (^Boolean [^ConcurrentLinkedDeque this ^java.lang.Object o]
    (-> this (.remove o)))
  ([^ConcurrentLinkedDeque this]
    (-> this (.remove))))

(defn poll-last
  "Description copied from interface: Deque

  returns: the tail of this deque, or null if this deque is empty - `E`"
  ([^ConcurrentLinkedDeque this]
    (-> this (.pollLast))))

(defn poll
  "Description copied from interface: Deque

  returns: the first element of this deque, or null if
           this deque is empty - `E`"
  ([^ConcurrentLinkedDeque this]
    (-> this (.poll))))

(defn offer-last
  "Inserts the specified element at the end of this deque.
   As the deque is unbounded, this method will never return false.

   This method is equivalent to add(E).

  e - the element to add - `E`

  returns: true (as specified by Deque.offerLast(E)) - `boolean`

  throws: java.lang.NullPointerException - if the specified element is null"
  (^Boolean [^ConcurrentLinkedDeque this e]
    (-> this (.offerLast e))))

(defn poll-first
  "Description copied from interface: Deque

  returns: the head of this deque, or null if this deque is empty - `E`"
  ([^ConcurrentLinkedDeque this]
    (-> this (.pollFirst))))

(defn add-last
  "Inserts the specified element at the end of this deque.
   As the deque is unbounded, this method will never throw
   IllegalStateException.

   This method is equivalent to add(E).

  e - the element to add - `E`

  throws: java.lang.NullPointerException - if the specified element is null"
  ([^ConcurrentLinkedDeque this e]
    (-> this (.addLast e))))

(defn remove-last-occurrence
  "Removes the last element e such that
   o.equals(e), if such an element exists in this deque.
   If the deque does not contain the element, it is unchanged.

  o - element to be removed from this deque, if present - `java.lang.Object`

  returns: true if the deque contained the specified element - `boolean`

  throws: java.lang.NullPointerException - if the specified element is null"
  (^Boolean [^ConcurrentLinkedDeque this ^java.lang.Object o]
    (-> this (.removeLastOccurrence o))))

(defn add
  "Inserts the specified element at the tail of this deque.
   As the deque is unbounded, this method will never throw
   IllegalStateException or return false.

  e - element whose presence in this collection is to be ensured - `E`

  returns: true (as specified by Collection.add(E)) - `boolean`

  throws: java.lang.NullPointerException - if the specified element is null"
  (^Boolean [^ConcurrentLinkedDeque this e]
    (-> this (.add e))))

(defn descending-iterator
  "Returns an iterator over the elements in this deque in reverse
   sequential order.  The elements will be returned in order from
   last (tail) to first (head).

   The returned iterator is
   weakly consistent.

  returns: an iterator over the elements in this deque in reverse order - `java.util.Iterator<E>`"
  (^java.util.Iterator [^ConcurrentLinkedDeque this]
    (-> this (.descendingIterator))))

(defn empty?
  "Returns true if this collection contains no elements.

  returns: true if this collection contains no elements - `boolean`"
  (^Boolean [^ConcurrentLinkedDeque this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of elements in this deque.  If this deque
   contains more than Integer.MAX_VALUE elements, it
   returns Integer.MAX_VALUE.

   Beware that, unlike in most collections, this method is
   NOT a constant-time operation. Because of the
   asynchronous nature of these deques, determining the current
   number of elements requires traversing them all to count them.
   Additionally, it is possible for the size to change during
   execution of this method, in which case the returned result
   will be inaccurate. Thus, this method is typically not very
   useful in concurrent applications.

  returns: the number of elements in this deque - `int`"
  (^Integer [^ConcurrentLinkedDeque this]
    (-> this (.size))))

(defn clear
  "Removes all of the elements from this deque."
  ([^ConcurrentLinkedDeque this]
    (-> this (.clear))))

(defn remove-last
  "Description copied from interface: Deque

  returns: the tail of this deque - `E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  ([^ConcurrentLinkedDeque this]
    (-> this (.removeLast))))

(defn add-first
  "Inserts the specified element at the front of this deque.
   As the deque is unbounded, this method will never throw
   IllegalStateException.

  e - the element to add - `E`

  throws: java.lang.NullPointerException - if the specified element is null"
  ([^ConcurrentLinkedDeque this e]
    (-> this (.addFirst e))))

(defn to-array
  "Returns an array containing all of the elements in this deque,
   in proper sequence (from first to last element); the runtime
   type of the returned array is that of the specified array.  If
   the deque fits in the specified array, it is returned therein.
   Otherwise, a new array is allocated with the runtime type of
   the specified array and the size of this deque.

   If this deque fits in the specified array with room to spare
   (i.e., the array has more elements than this deque), the element in
   the array immediately following the end of the deque is set to
   null.

   Like the toArray() method, this method acts as
   bridge between array-based and collection-based APIs.  Further,
   this method allows precise control over the runtime type of the
   output array, and may, under certain circumstances, be used to
   save allocation costs.

   Suppose x is a deque known to contain only strings.
   The following code can be used to dump the deque into a newly
   allocated array of String:



    String[] y = x.toArray(new String[0]);

   Note that toArray(new Object[0]) is identical in function to
   toArray().

  a - the array into which the elements of the deque are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose - `T[]`

  returns: an array containing all of the elements in this deque - `<T> T[]`

  throws: java.lang.ArrayStoreException - if the runtime type of the specified array is not a supertype of the runtime type of every element in this deque"
  ([^ConcurrentLinkedDeque this a]
    (-> this (.toArray a)))
  ([^ConcurrentLinkedDeque this]
    (-> this (.toArray))))

