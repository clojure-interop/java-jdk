(ns jdk.util.PriorityQueue
  "An unbounded priority java.util.queue based on a priority heap.
  The elements of the priority queue are ordered according to their
  java.lang.natural ordering, or by a Comparator
  provided at queue construction time, depending on which constructor is
  used.  A priority queue does not permit null elements.
  A priority queue relying on natural ordering also does not permit
  insertion of non-comparable objects (doing so may result in
  ClassCastException).

  The head of this queue is the least element
  with respect to the specified ordering.  If multiple elements are
  tied for least value, the head is one of those elements -- ties are
  broken arbitrarily.  The queue retrieval operations poll,
  remove, peek, and element access the
  element at the head of the queue.

  A priority queue is unbounded, but has an internal
  capacity governing the size of an array used to store the
  elements on the queue.  It is always at least as large as the queue
  size.  As elements are added to a priority queue, its capacity
  grows automatically.  The details of the growth policy are not
  specified.

  This class and its iterator implement all of the
  optional methods of the Collection and Iterator interfaces.  The Iterator provided in method iterator() is not guaranteed to traverse the elements of
  the priority queue in any particular order. If you need ordered
  traversal, consider using Arrays.sort(pq.toArray()).

  Note that this implementation is not synchronized.
  Multiple threads should not access a PriorityQueue
  instance concurrently if any of the threads modifies the queue.
  Instead, use the thread-safe PriorityBlockingQueue class.

  Implementation note: this implementation provides
  O(log(n)) time for the enqueuing and dequeuing methods
  (offer, poll, remove() and add);
  linear time for the remove(Object) and contains(Object)
  methods; and constant time for the retrieval methods
  (peek, element, and size).

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util PriorityQueue]))

(defn ->priority-queue
  "Constructor.

  Creates a PriorityQueue with the specified initial capacity
   that orders its elements according to the specified comparator.

  initial-capacity - the initial capacity for this priority queue - `int`
  comparator - the comparator that will be used to order this priority queue. If null, the java.lang.natural ordering of the elements will be used. - `java.util.Comparator`

  throws: java.lang.IllegalArgumentException - if initialCapacity is less than 1"
  (^PriorityQueue [^Integer initial-capacity ^java.util.Comparator comparator]
    (new PriorityQueue initial-capacity comparator))
  (^PriorityQueue [^Integer initial-capacity]
    (new PriorityQueue initial-capacity))
  (^PriorityQueue []
    (new PriorityQueue )))

(defn peek
  "Description copied from interface: Queue

  returns: the head of this queue, or null if this queue is empty - `E`"
  ([^PriorityQueue this]
    (-> this (.peek))))

(defn spliterator
  "Creates a late-binding
   and fail-fast Spliterator over the elements in this
   queue.

   The Spliterator reports Spliterator.SIZED,
   Spliterator.SUBSIZED, and Spliterator.NONNULL.
   Overriding implementations should document the reporting of additional
   characteristic values.

  returns: a Spliterator over the elements in this queue - `java.util.Spliterator<E>`"
  (^java.util.Spliterator [^PriorityQueue this]
    (-> this (.spliterator))))

(defn offer
  "Inserts the specified element into this priority queue.

  e - the element to add - `E`

  returns: true (as specified by Queue.offer(E)) - `boolean`

  throws: java.lang.ClassCastException - if the specified element cannot be compared with elements currently in this priority queue according to the priority queue's ordering"
  (^Boolean [^PriorityQueue this e]
    (-> this (.offer e))))

(defn contains
  "Returns true if this queue contains the specified element.
   More formally, returns true if and only if this queue contains
   at least one element e such that o.equals(e).

  o - object to be checked for containment in this queue - `java.lang.Object`

  returns: true if this queue contains the specified element - `boolean`"
  (^Boolean [^PriorityQueue this ^java.lang.Object o]
    (-> this (.contains o))))

(defn iterator
  "Returns an iterator over the elements in this queue. The iterator
   does not return the elements in any particular order.

  returns: an iterator over the elements in this queue - `java.util.Iterator<E>`"
  (^java.util.Iterator [^PriorityQueue this]
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
  (^Boolean [^PriorityQueue this ^java.lang.Object o]
    (-> this (.remove o))))

(defn comparator
  "Returns the comparator used to order the elements in this
   queue, or null if this queue is sorted according to
   the java.lang.natural ordering of its elements.

  returns: the comparator used to order this queue, or
           null if this queue is sorted according to the
           natural ordering of its elements - `java.util.Comparator<? super E>`"
  ([^PriorityQueue this]
    (-> this (.comparator))))

(defn poll
  "Description copied from interface: Queue

  returns: the head of this queue, or null if this queue is empty - `E`"
  ([^PriorityQueue this]
    (-> this (.poll))))

(defn add
  "Inserts the specified element into this priority queue.

  e - the element to add - `E`

  returns: true (as specified by Collection.add(E)) - `boolean`

  throws: java.lang.ClassCastException - if the specified element cannot be compared with elements currently in this priority queue according to the priority queue's ordering"
  (^Boolean [^PriorityQueue this e]
    (-> this (.add e))))

(defn size
  "Description copied from interface: Collection

  returns: the number of elements in this collection - `int`"
  (^Integer [^PriorityQueue this]
    (-> this (.size))))

(defn clear
  "Removes all of the elements from this priority queue.
   The queue will be empty after this call returns."
  ([^PriorityQueue this]
    (-> this (.clear))))

(defn to-array
  "Returns an array containing all of the elements in this queue; the
   runtime type of the returned array is that of the specified array.
   The returned array elements are in no particular order.
   If the queue fits in the specified array, it is returned therein.
   Otherwise, a new array is allocated with the runtime type of the
   specified array and the size of this queue.

   If the queue fits in the specified array with room to spare
   (i.e., the array has more elements than the queue), the element in
   the array immediately following the end of the collection is set to
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

  a - the array into which the elements of the queue are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose. - `T[]`

  returns: an array containing all of the elements in this queue - `<T> T[]`

  throws: java.lang.ArrayStoreException - if the runtime type of the specified array is not a supertype of the runtime type of every element in this queue"
  ([^PriorityQueue this a]
    (-> this (.toArray a)))
  ([^PriorityQueue this]
    (-> this (.toArray))))

