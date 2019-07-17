(ns jdk.util.concurrent.DelayQueue
  "An unbounded java.util.concurrent.blocking queue of
  Delayed elements, in which an element can only be taken
  when its delay has expired.  The head of the queue is that
  Delayed element whose delay expired furthest in the
  past.  If no delay has expired there is no head and poll
  will return null. Expiration occurs when an element's
  getDelay(TimeUnit.NANOSECONDS) method returns a value less
  than or equal to zero.  Even though unexpired elements cannot be
  removed using take or poll, they are otherwise
  treated as normal elements. For example, the size method
  returns the count of both expired and unexpired elements.
  This queue does not permit null elements.

  This class and its iterator implement all of the
  optional methods of the Collection and Iterator interfaces.  The Iterator provided in method iterator() is not guaranteed to traverse the elements of
  the DelayQueue in any particular order.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent DelayQueue]))

(defn ->delay-queue
  "Constructor.

  Creates a DelayQueue initially containing the elements of the
   given collection of Delayed instances.

  c - the collection of elements to initially contain - `DelayQueue.E>`

  throws: java.lang.NullPointerException - if the specified collection or any of its elements are null"
  ([^DelayQueue.E> c]
    (new DelayQueue c))
  ([]
    (new DelayQueue )))

(defn peek
  "Retrieves, but does not remove, the head of this queue, or
   returns null if this queue is empty.  Unlike
   poll, if no expired elements are available in the queue,
   this method returns the element that will expire next,
   if one exists.

  returns: the head of this queue, or null if this
           queue is empty - `DelayQueue.E`"
  (^DelayQueue.E [^java.util.concurrent.DelayQueue this]
    (-> this (.peek))))

(defn offer
  "Inserts the specified element into this delay queue. As the queue is
   unbounded this method will never block.

  e - the element to add - `DelayQueue.E`
  timeout - This parameter is ignored as the method never blocks - `long`
  unit - This parameter is ignored as the method never blocks - `java.util.concurrent.TimeUnit`

  returns: true - `boolean`

  throws: java.lang.NullPointerException - if the specified element is null"
  (^Boolean [^java.util.concurrent.DelayQueue this ^DelayQueue.E e ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.offer e timeout unit)))
  (^Boolean [^java.util.concurrent.DelayQueue this ^DelayQueue.E e]
    (-> this (.offer e))))

(defn put
  "Inserts the specified element into this delay queue. As the queue is
   unbounded this method will never block.

  e - the element to add - `DelayQueue.E`

  throws: java.lang.NullPointerException - if the specified element is null"
  ([^java.util.concurrent.DelayQueue this ^DelayQueue.E e]
    (-> this (.put e))))

(defn take
  "Retrieves and removes the head of this queue, waiting if necessary
   until an element with an expired delay is available on this queue.

  returns: the head of this queue - `DelayQueue.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  (^DelayQueue.E [^java.util.concurrent.DelayQueue this]
    (-> this (.take))))

(defn iterator
  "Returns an iterator over all the elements (both expired and
   unexpired) in this queue. The iterator does not return the
   elements in any particular order.

   The returned iterator is
   weakly consistent.

  returns: an iterator over the elements in this queue - `java.util.Iterator<DelayQueue.E>`"
  (^java.util.Iterator [^java.util.concurrent.DelayQueue this]
    (-> this (.iterator))))

(defn remove
  "Removes a single instance of the specified element from this
   queue, if it is present, whether or not it has expired.

  o - element to be removed from this collection, if present - `java.lang.Object`

  returns: true if an element was removed as a result of this call - `boolean`"
  (^Boolean [^java.util.concurrent.DelayQueue this ^java.lang.Object o]
    (-> this (.remove o))))

(defn drain-to
  "Description copied from interface: BlockingQueue

  c - the collection to transfer elements into - `DelayQueue.E>`
  max-elements - the maximum number of elements to transfer - `int`

  returns: the number of elements transferred - `int`

  throws: java.lang.UnsupportedOperationException - if addition of elements is not supported by the specified collection"
  (^Integer [^java.util.concurrent.DelayQueue this ^DelayQueue.E> c ^Integer max-elements]
    (-> this (.drainTo c max-elements)))
  (^Integer [^java.util.concurrent.DelayQueue this ^DelayQueue.E> c]
    (-> this (.drainTo c))))

(defn poll
  "Retrieves and removes the head of this queue, waiting if necessary
   until an element with an expired delay is available on this queue,
   or the specified wait time expires.

  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: the head of this queue, or null if the
           specified waiting time elapses before an element with
           an expired delay becomes available - `DelayQueue.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  (^DelayQueue.E [^java.util.concurrent.DelayQueue this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.poll timeout unit)))
  (^DelayQueue.E [^java.util.concurrent.DelayQueue this]
    (-> this (.poll))))

(defn remaining-capacity
  "Always returns Integer.MAX_VALUE because
   a DelayQueue is not capacity constrained.

  returns: Integer.MAX_VALUE - `int`"
  (^Integer [^java.util.concurrent.DelayQueue this]
    (-> this (.remainingCapacity))))

(defn add
  "Inserts the specified element into this delay queue.

  e - the element to add - `DelayQueue.E`

  returns: true (as specified by Collection.add(E)) - `boolean`

  throws: java.lang.NullPointerException - if the specified element is null"
  (^Boolean [^java.util.concurrent.DelayQueue this ^DelayQueue.E e]
    (-> this (.add e))))

(defn size
  "Description copied from interface: Collection

  returns: the number of elements in this collection - `int`"
  (^Integer [^java.util.concurrent.DelayQueue this]
    (-> this (.size))))

(defn clear
  "Atomically removes all of the elements from this delay queue.
   The queue will be empty after this call returns.
   Elements with an unexpired delay are not waited for; they are
   simply discarded from the queue."
  ([^java.util.concurrent.DelayQueue this]
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

   The following code can be used to dump a delay queue into a newly
   allocated array of Delayed:



    Delayed[] a = q.toArray(new Delayed[0]);

   Note that toArray(new Object[0]) is identical in function to
   toArray().

  a - the array into which the elements of the queue are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose - `T[]`

  returns: an array containing all of the elements in this queue - `<T> T[]`

  throws: java.lang.ArrayStoreException - if the runtime type of the specified array is not a supertype of the runtime type of every element in this queue"
  ([^java.util.concurrent.DelayQueue this a]
    (-> this (.toArray a)))
  ([^java.util.concurrent.DelayQueue this]
    (-> this (.toArray))))

