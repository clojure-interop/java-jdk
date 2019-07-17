(ns jdk.util.concurrent.ArrayBlockingQueue
  "A bounded java.util.concurrent.blocking queue backed by an
  array.  This queue orders elements FIFO (first-in-first-out).  The
  head of the queue is that element that has been on the
  queue the longest time.  The tail of the queue is that
  element that has been on the queue the shortest time. New elements
  are inserted at the tail of the queue, and the queue retrieval
  operations obtain elements at the head of the queue.

  This is a classic `bounded buffer`, in which a
  fixed-sized array holds elements inserted by producers and
  extracted by consumers.  Once created, the capacity cannot be
  changed.  Attempts to put an element into a full queue
  will result in the operation blocking; attempts to take an
  element from an empty queue will similarly block.

  This class supports an optional fairness policy for ordering
  waiting producer and consumer threads.  By default, this ordering
  is not guaranteed. However, a queue constructed with fairness set
  to true grants threads access in FIFO order. Fairness
  generally decreases throughput but reduces variability and avoids
  starvation.

  This class and its iterator implement all of the
  optional methods of the Collection and Iterator interfaces.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ArrayBlockingQueue]))

(defn ->array-blocking-queue
  "Constructor.

  Creates an ArrayBlockingQueue with the given (fixed)
   capacity, the specified access policy and initially containing the
   elements of the given collection,
   added in traversal order of the collection's iterator.

  capacity - the capacity of this queue - `int`
  fair - if true then queue accesses for threads blocked on insertion or removal, are processed in FIFO order; if false the access order is unspecified. - `boolean`
  c - the collection of elements to initially contain - `ArrayBlockingQueue.E>`

  throws: java.lang.IllegalArgumentException - if capacity is less than c.size(), or less than 1."
  ([^Integer capacity ^Boolean fair ^ArrayBlockingQueue.E> c]
    (new ArrayBlockingQueue capacity fair c))
  ([^Integer capacity ^Boolean fair]
    (new ArrayBlockingQueue capacity fair))
  ([^Integer capacity]
    (new ArrayBlockingQueue capacity)))

(defn peek
  "Description copied from interface: Queue

  returns: the head of this queue, or null if this queue is empty - `ArrayBlockingQueue.E`"
  ([^java.util.concurrent.ArrayBlockingQueue this]
    (-> this (.peek))))

(defn spliterator
  "Returns a Spliterator over the elements in this queue.

   The returned spliterator is
   weakly consistent.

   The Spliterator reports Spliterator.CONCURRENT,
   Spliterator.ORDERED, and Spliterator.NONNULL.

  returns: a Spliterator over the elements in this queue - `java.util.Spliterator<ArrayBlockingQueue.E>`"
  ([^java.util.concurrent.ArrayBlockingQueue this]
    (-> this (.spliterator))))

(defn offer
  "Inserts the specified element at the tail of this queue, waiting
   up to the specified wait time for space to become available if
   the queue is full.

  e - the element to add - `ArrayBlockingQueue.E`
  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: true if successful, or false if
           the specified waiting time elapses before space is available - `boolean`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^java.util.concurrent.ArrayBlockingQueue this ^ArrayBlockingQueue.E e ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.offer e timeout unit)))
  ([^java.util.concurrent.ArrayBlockingQueue this ^ArrayBlockingQueue.E e]
    (-> this (.offer e))))

(defn put
  "Inserts the specified element at the tail of this queue, waiting
   for space to become available if the queue is full.

  e - the element to add - `ArrayBlockingQueue.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^java.util.concurrent.ArrayBlockingQueue this ^ArrayBlockingQueue.E e]
    (-> this (.put e))))

(defn contains
  "Returns true if this queue contains the specified element.
   More formally, returns true if and only if this queue contains
   at least one element e such that o.equals(e).

  o - object to be checked for containment in this queue - `java.lang.Object`

  returns: true if this queue contains the specified element - `boolean`"
  ([^java.util.concurrent.ArrayBlockingQueue this ^java.lang.Object o]
    (-> this (.contains o))))

(defn to-string
  "Description copied from class: AbstractCollection

  returns: a string representation of this collection - `java.lang.String`"
  ([^java.util.concurrent.ArrayBlockingQueue this]
    (-> this (.toString))))

(defn take
  "Description copied from interface: BlockingQueue

  returns: the head of this queue - `ArrayBlockingQueue.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^java.util.concurrent.ArrayBlockingQueue this]
    (-> this (.take))))

(defn iterator
  "Returns an iterator over the elements in this queue in proper sequence.
   The elements will be returned in order from first (head) to last (tail).

   The returned iterator is
   weakly consistent.

  returns: an iterator over the elements in this queue in proper sequence - `java.util.Iterator<ArrayBlockingQueue.E>`"
  ([^java.util.concurrent.ArrayBlockingQueue this]
    (-> this (.iterator))))

(defn remove
  "Removes a single instance of the specified element from this queue,
   if it is present.  More formally, removes an element e such
   that o.equals(e), if this queue contains one or more such
   elements.
   Returns true if this queue contained the specified element
   (or equivalently, if this queue changed as a result of the call).

   Removal of interior elements in circular array based queues
   is an intrinsically slow and disruptive operation, so should
   be undertaken only in exceptional circumstances, ideally
   only when the queue is known not to be accessible by other
   threads.

  o - element to be removed from this queue, if present - `java.lang.Object`

  returns: true if this queue changed as a result of the call - `boolean`"
  ([^java.util.concurrent.ArrayBlockingQueue this ^java.lang.Object o]
    (-> this (.remove o))))

(defn drain-to
  "Description copied from interface: BlockingQueue

  c - the collection to transfer elements into - `ArrayBlockingQueue.E>`
  max-elements - the maximum number of elements to transfer - `int`

  returns: the number of elements transferred - `int`

  throws: java.lang.UnsupportedOperationException - if addition of elements is not supported by the specified collection"
  ([^java.util.concurrent.ArrayBlockingQueue this ^ArrayBlockingQueue.E> c ^Integer max-elements]
    (-> this (.drainTo c max-elements)))
  ([^java.util.concurrent.ArrayBlockingQueue this ^ArrayBlockingQueue.E> c]
    (-> this (.drainTo c))))

(defn poll
  "Description copied from interface: BlockingQueue

  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: the head of this queue, or null if the
           specified waiting time elapses before an element is available - `ArrayBlockingQueue.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^java.util.concurrent.ArrayBlockingQueue this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.poll timeout unit)))
  ([^java.util.concurrent.ArrayBlockingQueue this]
    (-> this (.poll))))

(defn remaining-capacity
  "Returns the number of additional elements that this queue can ideally
   (in the absence of memory or resource constraints) accept without
   blocking. This is always equal to the initial capacity of this queue
   less the current size of this queue.

   Note that you cannot always tell if an attempt to insert
   an element will succeed by inspecting remainingCapacity
   because it may be the case that another thread is about to
   insert or remove an element.

  returns: the remaining capacity - `int`"
  ([^java.util.concurrent.ArrayBlockingQueue this]
    (-> this (.remainingCapacity))))

(defn add
  "Inserts the specified element at the tail of this queue if it is
   possible to do so immediately without exceeding the queue's capacity,
   returning true upon success and throwing an
   IllegalStateException if this queue is full.

  e - the element to add - `ArrayBlockingQueue.E`

  returns: true (as specified by Collection.add(E)) - `boolean`

  throws: java.lang.IllegalStateException - if this queue is full"
  ([^java.util.concurrent.ArrayBlockingQueue this ^ArrayBlockingQueue.E e]
    (-> this (.add e))))

(defn size
  "Returns the number of elements in this queue.

  returns: the number of elements in this queue - `int`"
  ([^java.util.concurrent.ArrayBlockingQueue this]
    (-> this (.size))))

(defn clear
  "Atomically removes all of the elements from this queue.
   The queue will be empty after this call returns."
  ([^java.util.concurrent.ArrayBlockingQueue this]
    (-> this (.clear))))

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
  ([^java.util.concurrent.ArrayBlockingQueue this a]
    (-> this (.toArray a)))
  ([^java.util.concurrent.ArrayBlockingQueue this]
    (-> this (.toArray))))

