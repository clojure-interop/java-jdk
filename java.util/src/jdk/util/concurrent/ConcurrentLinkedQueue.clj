(ns jdk.util.concurrent.ConcurrentLinkedQueue
  "An unbounded thread-safe java.util.queue based on linked nodes.
  This queue orders elements FIFO (first-in-first-out).
  The head of the queue is that element that has been on the
  queue the longest time.
  The tail of the queue is that element that has been on the
  queue the shortest time. New elements
  are inserted at the tail of the queue, and the queue retrieval
  operations obtain elements at the head of the queue.
  A ConcurrentLinkedQueue is an appropriate choice when
  many threads will share access to a common collection.
  Like most other concurrent collection implementations, this class
  does not permit the use of null elements.

  This implementation employs an efficient non-blocking
  algorithm based on one described in  Simple,
  Fast, and Practical Non-Blocking and Blocking Concurrent Queue
  Algorithms by Maged M. Michael and Michael L. Scott.

  Iterators are weakly consistent, returning elements
  reflecting the state of the queue at some point at or since the
  creation of the iterator.  They do not throw ConcurrentModificationException, and may proceed concurrently
  with other operations.  Elements contained in the queue since the creation
  of the iterator will be returned exactly once.

  Beware that, unlike in most collections, the size method
  is NOT a constant-time operation. Because of the
  asynchronous nature of these queues, determining the current number
  of elements requires a traversal of the elements, and so may report
  inaccurate results if this collection is modified during traversal.
  Additionally, the bulk operations addAll,
  removeAll, retainAll, containsAll,
  equals, and toArray are not guaranteed
  to be performed atomically. For example, an iterator operating
  concurrently with an addAll operation might view only some
  of the added elements.

  This class and its iterator implement all of the optional
  methods of the Queue and Iterator interfaces.

  Memory consistency effects: As with other concurrent
  collections, actions in a thread prior to placing an object into a
  ConcurrentLinkedQueue
  happen-before
  actions subsequent to the access or removal of that element from
  the ConcurrentLinkedQueue in another thread.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ConcurrentLinkedQueue]))

(defn ->concurrent-linked-queue
  "Constructor.

  Creates a ConcurrentLinkedQueue
   initially containing the elements of the given collection,
   added in traversal order of the collection's iterator.

  c - the collection of elements to initially contain - `java.util.Collection`

  throws: java.lang.NullPointerException - if the specified collection or any of its elements are null"
  (^ConcurrentLinkedQueue [^java.util.Collection c]
    (new ConcurrentLinkedQueue c))
  (^ConcurrentLinkedQueue []
    (new ConcurrentLinkedQueue )))

(defn add-all
  "Appends all of the elements in the specified collection to the end of
   this queue, in the order that they are returned by the specified
   collection's iterator.  Attempts to addAll of a queue to
   itself result in IllegalArgumentException.

  c - the elements to be inserted into this queue - `java.util.Collection`

  returns: true if this queue changed as a result of the call - `boolean`

  throws: java.lang.NullPointerException - if the specified collection or any of its elements are null"
  (^Boolean [^ConcurrentLinkedQueue this ^java.util.Collection c]
    (-> this (.addAll c))))

(defn peek
  "Description copied from interface: Queue

  returns: the head of this queue, or null if this queue is empty - `E`"
  ([^ConcurrentLinkedQueue this]
    (-> this (.peek))))

(defn spliterator
  "Returns a Spliterator over the elements in this queue.

   The returned spliterator is
   weakly consistent.

   The Spliterator reports Spliterator.CONCURRENT,
   Spliterator.ORDERED, and Spliterator.NONNULL.

  returns: a Spliterator over the elements in this queue - `java.util.Spliterator<E>`"
  (^java.util.Spliterator [^ConcurrentLinkedQueue this]
    (-> this (.spliterator))))

(defn offer
  "Inserts the specified element at the tail of this queue.
   As the queue is unbounded, this method will never return false.

  e - the element to add - `E`

  returns: true (as specified by Queue.offer(E)) - `boolean`

  throws: java.lang.NullPointerException - if the specified element is null"
  (^Boolean [^ConcurrentLinkedQueue this e]
    (-> this (.offer e))))

(defn contains
  "Returns true if this queue contains the specified element.
   More formally, returns true if and only if this queue contains
   at least one element e such that o.equals(e).

  o - object to be checked for containment in this queue - `java.lang.Object`

  returns: true if this queue contains the specified element - `boolean`"
  (^Boolean [^ConcurrentLinkedQueue this ^java.lang.Object o]
    (-> this (.contains o))))

(defn iterator
  "Returns an iterator over the elements in this queue in proper sequence.
   The elements will be returned in order from first (head) to last (tail).

   The returned iterator is
   weakly consistent.

  returns: an iterator over the elements in this queue in proper sequence - `java.util.Iterator<E>`"
  (^java.util.Iterator [^ConcurrentLinkedQueue this]
    (-> this (.iterator))))

(defn remove
  "Removes a single instance of the specified element from this queue,
   if it is present.  More formally, removes an element e such
   that o.equals(e), if this queue contains one or more such
   elements.
   Returns true if this queue contained the specified element
   (or equivalently, if this queue changed as a result of the call).

  o - element to be removed from this queue, if present - `java.lang.Object`

  returns: true if this queue changed as a result of the call - `boolean`"
  (^Boolean [^ConcurrentLinkedQueue this ^java.lang.Object o]
    (-> this (.remove o))))

(defn poll
  "Description copied from interface: Queue

  returns: the head of this queue, or null if this queue is empty - `E`"
  ([^ConcurrentLinkedQueue this]
    (-> this (.poll))))

(defn add
  "Inserts the specified element at the tail of this queue.
   As the queue is unbounded, this method will never throw
   IllegalStateException or return false.

  e - the element to add - `E`

  returns: true (as specified by Collection.add(E)) - `boolean`

  throws: java.lang.NullPointerException - if the specified element is null"
  (^Boolean [^ConcurrentLinkedQueue this e]
    (-> this (.add e))))

(defn empty?
  "Returns true if this queue contains no elements.

  returns: true if this queue contains no elements - `boolean`"
  (^Boolean [^ConcurrentLinkedQueue this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of elements in this queue.  If this queue
   contains more than Integer.MAX_VALUE elements, returns
   Integer.MAX_VALUE.

   Beware that, unlike in most collections, this method is
   NOT a constant-time operation. Because of the
   asynchronous nature of these queues, determining the current
   number of elements requires an O(n) traversal.
   Additionally, if elements are added or removed during execution
   of this method, the returned result may be inaccurate.  Thus,
   this method is typically not very useful in concurrent
   applications.

  returns: the number of elements in this queue - `int`"
  (^Integer [^ConcurrentLinkedQueue this]
    (-> this (.size))))

(defn to-array
  "Returns an array containing all of the elements in this queue, in
   proper sequence; the runtime type of the returned array is that of
   the specified array.  If the queue fits in the specified array, it
   is returned therein.  Otherwise, a new array is allocated with the
   runtime type of the specified array and the size of this queue.

   If this queue fits in the specified array with room to spare
   (i.e., the array has more elements than this queue), the element in
   the array immediately following the end of the queue is set to
   null.

   Like the toArray() method, this method acts as bridge between
   array-based and collection-based APIs.  Further, this method allows
   precise control over the runtime type of the output array, and may,
   under certain circumstances, be used to save allocation costs.

   Suppose x is a queue known to contain only strings.
   The following code can be used to dump the queue into a newly
   allocated array of String:



    String[] y = x.toArray(new String[0]);

   Note that toArray(new Object[0]) is identical in function to
   toArray().

  a - the array into which the elements of the queue are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose - `T[]`

  returns: an array containing all of the elements in this queue - `<T> T[]`

  throws: java.lang.ArrayStoreException - if the runtime type of the specified array is not a supertype of the runtime type of every element in this queue"
  ([^ConcurrentLinkedQueue this a]
    (-> this (.toArray a)))
  ([^ConcurrentLinkedQueue this]
    (-> this (.toArray))))

