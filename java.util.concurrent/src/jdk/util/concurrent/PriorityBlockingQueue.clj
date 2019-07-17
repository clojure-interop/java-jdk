(ns jdk.util.concurrent.PriorityBlockingQueue
  "An unbounded java.util.concurrent.blocking queue that uses
  the same ordering rules as class PriorityQueue and supplies
  blocking retrieval operations.  While this queue is logically
  unbounded, attempted additions may fail due to resource exhaustion
  (causing OutOfMemoryError). This class does not permit
  null elements.  A priority queue relying on java.lang.natural ordering also does not permit insertion of
  non-comparable objects (doing so results in
  ClassCastException).

  This class and its iterator implement all of the
  optional methods of the Collection and Iterator interfaces.  The Iterator provided in method iterator() is not guaranteed to traverse the elements of
  the PriorityBlockingQueue in any particular order. If you need
  ordered traversal, consider using
  Arrays.sort(pq.toArray()).  Also, method drainTo
  can be used to remove some or all elements in priority
  order and place them in another collection.

  Operations on this class make no guarantees about the ordering
  of elements with equal priority. If you need to enforce an
  ordering, you can define custom classes or comparators that use a
  secondary key to break ties in primary priority values.  For
  example, here is a class that applies first-in-first-out
  tie-breaking to comparable elements. To use it, you would insert a
  new FIFOEntry(anEntry) instead of a plain entry object.



  class FIFOEntry<E extends Comparable<? super E>>
      implements Comparable<FIFOEntry<E>> {
    static final AtomicLong seq = new AtomicLong(0);
    final long seqNum;
    final E entry;
    public FIFOEntry(E entry) {
      seqNum = seq.getAndIncrement();
      this.entry = entry;
    }
    public E getEntry() { return entry; }
    public int compareTo(FIFOEntry<E> other) {
      int res = entry.compareTo(other.entry);
      if (res == 0 && other.entry != this.entry)
        res = (seqNum < other.seqNum ? -1 : 1);
      return res;
    }
  }

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent PriorityBlockingQueue]))

(defn ->priority-blocking-queue
  "Constructor.

  Creates a PriorityBlockingQueue with the specified initial
   capacity that orders its elements according to the specified
   comparator.

  initial-capacity - the initial capacity for this priority queue - `int`
  comparator - the comparator that will be used to order this priority queue. If null, the java.lang.natural ordering of the elements will be used. - `PriorityBlockingQueue.E>`

  throws: java.lang.IllegalArgumentException - if initialCapacity is less than 1"
  ([^Integer initial-capacity ^PriorityBlockingQueue.E> comparator]
    (new PriorityBlockingQueue initial-capacity comparator))
  ([^Integer initial-capacity]
    (new PriorityBlockingQueue initial-capacity))
  ([]
    (new PriorityBlockingQueue )))

(defn peek
  "Description copied from interface: Queue

  returns: the head of this queue, or null if this queue is empty - `PriorityBlockingQueue.E`"
  (^PriorityBlockingQueue.E [^java.util.concurrent.PriorityBlockingQueue this]
    (-> this (.peek))))

(defn spliterator
  "Returns a Spliterator over the elements in this queue.

   The returned spliterator is
   weakly consistent.

   The Spliterator reports Spliterator.SIZED and
   Spliterator.NONNULL.

  returns: a Spliterator over the elements in this queue - `java.util.Spliterator<PriorityBlockingQueue.E>`"
  (^java.util.Spliterator [^java.util.concurrent.PriorityBlockingQueue this]
    (-> this (.spliterator))))

(defn offer
  "Inserts the specified element into this priority queue.
   As the queue is unbounded, this method will never block or
   return false.

  e - the element to add - `PriorityBlockingQueue.E`
  timeout - This parameter is ignored as the method never blocks - `long`
  unit - This parameter is ignored as the method never blocks - `java.util.concurrent.TimeUnit`

  returns: true (as specified by
    BlockingQueue.offer) - `boolean`

  throws: java.lang.ClassCastException - if the specified element cannot be compared with elements currently in the priority queue according to the priority queue's ordering"
  (^Boolean [^java.util.concurrent.PriorityBlockingQueue this ^PriorityBlockingQueue.E e ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.offer e timeout unit)))
  (^Boolean [^java.util.concurrent.PriorityBlockingQueue this ^PriorityBlockingQueue.E e]
    (-> this (.offer e))))

(defn put
  "Inserts the specified element into this priority queue.
   As the queue is unbounded, this method will never block.

  e - the element to add - `PriorityBlockingQueue.E`

  throws: java.lang.ClassCastException - if the specified element cannot be compared with elements currently in the priority queue according to the priority queue's ordering"
  ([^java.util.concurrent.PriorityBlockingQueue this ^PriorityBlockingQueue.E e]
    (-> this (.put e))))

(defn contains
  "Returns true if this queue contains the specified element.
   More formally, returns true if and only if this queue contains
   at least one element e such that o.equals(e).

  o - object to be checked for containment in this queue - `java.lang.Object`

  returns: true if this queue contains the specified element - `boolean`"
  (^Boolean [^java.util.concurrent.PriorityBlockingQueue this ^java.lang.Object o]
    (-> this (.contains o))))

(defn to-string
  "Description copied from class: AbstractCollection

  returns: a string representation of this collection - `java.lang.String`"
  (^java.lang.String [^java.util.concurrent.PriorityBlockingQueue this]
    (-> this (.toString))))

(defn take
  "Description copied from interface: BlockingQueue

  returns: the head of this queue - `PriorityBlockingQueue.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  (^PriorityBlockingQueue.E [^java.util.concurrent.PriorityBlockingQueue this]
    (-> this (.take))))

(defn iterator
  "Returns an iterator over the elements in this queue. The
   iterator does not return the elements in any particular order.

   The returned iterator is
   weakly consistent.

  returns: an iterator over the elements in this queue - `java.util.Iterator<PriorityBlockingQueue.E>`"
  (^java.util.Iterator [^java.util.concurrent.PriorityBlockingQueue this]
    (-> this (.iterator))))

(defn remove
  "Removes a single instance of the specified element from this queue,
   if it is present.  More formally, removes an element e such
   that o.equals(e), if this queue contains one or more such
   elements.  Returns true if and only if this queue contained
   the specified element (or equivalently, if this queue changed as a
   result of the call).

  o - element to be removed from this queue, if present - `java.lang.Object`

  returns: true if this queue changed as a result of the call - `boolean`"
  (^Boolean [^java.util.concurrent.PriorityBlockingQueue this ^java.lang.Object o]
    (-> this (.remove o))))

(defn comparator
  "Returns the comparator used to order the elements in this queue,
   or null if this queue uses the java.lang.natural ordering of its elements.

  returns: the comparator used to order the elements in this queue,
           or null if this queue uses the natural
           ordering of its elements - `java.util.Comparator<? super PriorityBlockingQueue.E>`"
  ([^java.util.concurrent.PriorityBlockingQueue this]
    (-> this (.comparator))))

(defn drain-to
  "Description copied from interface: BlockingQueue

  c - the collection to transfer elements into - `PriorityBlockingQueue.E>`
  max-elements - the maximum number of elements to transfer - `int`

  returns: the number of elements transferred - `int`

  throws: java.lang.UnsupportedOperationException - if addition of elements is not supported by the specified collection"
  (^Integer [^java.util.concurrent.PriorityBlockingQueue this ^PriorityBlockingQueue.E> c ^Integer max-elements]
    (-> this (.drainTo c max-elements)))
  (^Integer [^java.util.concurrent.PriorityBlockingQueue this ^PriorityBlockingQueue.E> c]
    (-> this (.drainTo c))))

(defn poll
  "Description copied from interface: BlockingQueue

  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: the head of this queue, or null if the
           specified waiting time elapses before an element is available - `PriorityBlockingQueue.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  (^PriorityBlockingQueue.E [^java.util.concurrent.PriorityBlockingQueue this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.poll timeout unit)))
  (^PriorityBlockingQueue.E [^java.util.concurrent.PriorityBlockingQueue this]
    (-> this (.poll))))

(defn remaining-capacity
  "Always returns Integer.MAX_VALUE because
   a PriorityBlockingQueue is not capacity constrained.

  returns: Integer.MAX_VALUE always - `int`"
  (^Integer [^java.util.concurrent.PriorityBlockingQueue this]
    (-> this (.remainingCapacity))))

(defn add
  "Inserts the specified element into this priority queue.

  e - the element to add - `PriorityBlockingQueue.E`

  returns: true (as specified by Collection.add(E)) - `boolean`

  throws: java.lang.ClassCastException - if the specified element cannot be compared with elements currently in the priority queue according to the priority queue's ordering"
  (^Boolean [^java.util.concurrent.PriorityBlockingQueue this ^PriorityBlockingQueue.E e]
    (-> this (.add e))))

(defn size
  "Description copied from interface: Collection

  returns: the number of elements in this collection - `int`"
  (^Integer [^java.util.concurrent.PriorityBlockingQueue this]
    (-> this (.size))))

(defn clear
  "Atomically removes all of the elements from this queue.
   The queue will be empty after this call returns."
  ([^java.util.concurrent.PriorityBlockingQueue this]
    (-> this (.clear))))

(defn to-array
  "Returns an array containing all of the elements in this queue; the
   runtime type of the returned array is that of the specified array.
   The returned array elements are in no particular order.
   If the queue fits in the specified array, it is returned therein.
   Otherwise, a new array is allocated with the runtime type of the
   specified array and the size of this queue.

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
  ([^java.util.concurrent.PriorityBlockingQueue this a]
    (-> this (.toArray a)))
  ([^java.util.concurrent.PriorityBlockingQueue this]
    (-> this (.toArray))))

