(ns jdk.util.concurrent.LinkedBlockingQueue
  "An optionally-bounded java.util.concurrent.blocking queue based on
  linked nodes.
  This queue orders elements FIFO (first-in-first-out).
  The head of the queue is that element that has been on the
  queue the longest time.
  The tail of the queue is that element that has been on the
  queue the shortest time. New elements
  are inserted at the tail of the queue, and the queue retrieval
  operations obtain elements at the head of the queue.
  Linked queues typically have higher throughput than array-based queues but
  less predictable performance in most concurrent applications.

  The optional capacity bound constructor argument serves as a
  way to prevent excessive queue expansion. The capacity, if unspecified,
  is equal to Integer.MAX_VALUE.  Linked nodes are
  dynamically created upon each insertion unless this would bring the
  queue above capacity.

  This class and its iterator implement all of the
  optional methods of the Collection and Iterator interfaces.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent LinkedBlockingQueue]))

(defn ->linked-blocking-queue
  "Constructor.

  Creates a LinkedBlockingQueue with the given (fixed) capacity.

  capacity - the capacity of this queue - `int`

  throws: java.lang.IllegalArgumentException - if capacity is not greater than zero"
  (^LinkedBlockingQueue [^Integer capacity]
    (new LinkedBlockingQueue capacity))
  (^LinkedBlockingQueue []
    (new LinkedBlockingQueue )))

(defn peek
  "Description copied from interface: Queue

  returns: the head of this queue, or null if this queue is empty - `E`"
  ([^LinkedBlockingQueue this]
    (-> this (.peek))))

(defn spliterator
  "Returns a Spliterator over the elements in this queue.

   The returned spliterator is
   weakly consistent.

   The Spliterator reports Spliterator.CONCURRENT,
   Spliterator.ORDERED, and Spliterator.NONNULL.

  returns: a Spliterator over the elements in this queue - `java.util.Spliterator<E>`"
  (^java.util.Spliterator [^LinkedBlockingQueue this]
    (-> this (.spliterator))))

(defn offer
  "Inserts the specified element at the tail of this queue, waiting if
   necessary up to the specified wait time for space to become available.

  e - the element to add - `E`
  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: true if successful, or false if
           the specified waiting time elapses before space is available - `boolean`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  (^Boolean [^LinkedBlockingQueue this e ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.offer e timeout unit)))
  (^Boolean [^LinkedBlockingQueue this e]
    (-> this (.offer e))))

(defn put
  "Inserts the specified element at the tail of this queue, waiting if
   necessary for space to become available.

  e - the element to add - `E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^LinkedBlockingQueue this e]
    (-> this (.put e))))

(defn contains
  "Returns true if this queue contains the specified element.
   More formally, returns true if and only if this queue contains
   at least one element e such that o.equals(e).

  o - object to be checked for containment in this queue - `java.lang.Object`

  returns: true if this queue contains the specified element - `boolean`"
  (^Boolean [^LinkedBlockingQueue this ^java.lang.Object o]
    (-> this (.contains o))))

(defn to-string
  "Description copied from class: AbstractCollection

  returns: a string representation of this collection - `java.lang.String`"
  (^java.lang.String [^LinkedBlockingQueue this]
    (-> this (.toString))))

(defn take
  "Description copied from interface: BlockingQueue

  returns: the head of this queue - `E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^LinkedBlockingQueue this]
    (-> this (.take))))

(defn iterator
  "Returns an iterator over the elements in this queue in proper sequence.
   The elements will be returned in order from first (head) to last (tail).

   The returned iterator is
   weakly consistent.

  returns: an iterator over the elements in this queue in proper sequence - `java.util.Iterator<E>`"
  (^java.util.Iterator [^LinkedBlockingQueue this]
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
  (^Boolean [^LinkedBlockingQueue this ^java.lang.Object o]
    (-> this (.remove o))))

(defn drain-to
  "Description copied from interface: BlockingQueue

  c - the collection to transfer elements into - `java.util.Collection`
  max-elements - the maximum number of elements to transfer - `int`

  returns: the number of elements transferred - `int`

  throws: java.lang.UnsupportedOperationException - if addition of elements is not supported by the specified collection"
  (^Integer [^LinkedBlockingQueue this ^java.util.Collection c ^Integer max-elements]
    (-> this (.drainTo c max-elements)))
  (^Integer [^LinkedBlockingQueue this ^java.util.Collection c]
    (-> this (.drainTo c))))

(defn poll
  "Description copied from interface: BlockingQueue

  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: the head of this queue, or null if the
           specified waiting time elapses before an element is available - `E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^LinkedBlockingQueue this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.poll timeout unit)))
  ([^LinkedBlockingQueue this]
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
  (^Integer [^LinkedBlockingQueue this]
    (-> this (.remainingCapacity))))

(defn size
  "Returns the number of elements in this queue.

  returns: the number of elements in this queue - `int`"
  (^Integer [^LinkedBlockingQueue this]
    (-> this (.size))))

(defn clear
  "Atomically removes all of the elements from this queue.
   The queue will be empty after this call returns."
  ([^LinkedBlockingQueue this]
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
  ([^LinkedBlockingQueue this a]
    (-> this (.toArray a)))
  ([^LinkedBlockingQueue this]
    (-> this (.toArray))))

