(ns jdk.util.concurrent.SynchronousQueue
  "A java.util.concurrent.blocking queue in which each insert
  operation must wait for a corresponding remove operation by another
  thread, and vice versa.  A synchronous queue does not have any
  internal capacity, not even a capacity of one.  You cannot
  peek at a synchronous queue because an element is only
  present when you try to remove it; you cannot insert an element
  (using any method) unless another thread is trying to remove it;
  you cannot iterate as there is nothing to iterate.  The
  head of the queue is the element that the first queued
  inserting thread is trying to add to the queue; if there is no such
  queued thread then no element is available for removal and
  poll() will return null.  For purposes of other
  Collection methods (for example contains), a
  SynchronousQueue acts as an empty collection.  This queue
  does not permit null elements.

  Synchronous queues are similar to rendezvous channels used in
  CSP and Ada. They are well suited for handoff designs, in which an
  object running in one thread must sync up with an object running
  in another thread in order to hand it some information, event, or
  task.

  This class supports an optional fairness policy for ordering
  waiting producer and consumer threads.  By default, this ordering
  is not guaranteed. However, a queue constructed with fairness set
  to true grants threads access in FIFO order.

  This class and its iterator implement all of the
  optional methods of the Collection and Iterator interfaces.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent SynchronousQueue]))

(defn ->synchronous-queue
  "Constructor.

  Creates a SynchronousQueue with the specified fairness policy.

  fair - if true, waiting threads contend in FIFO order for access; otherwise the order is unspecified. - `boolean`"
  ([^Boolean fair]
    (new SynchronousQueue fair))
  ([]
    (new SynchronousQueue )))

(defn peek
  "Always returns null.
   A SynchronousQueue does not return elements
   unless actively waited on.

  returns: null - `SynchronousQueue.E`"
  ([^java.util.concurrent.SynchronousQueue this]
    (-> this (.peek))))

(defn spliterator
  "Returns an empty spliterator in which calls to
   Spliterator.trySplit() always return null.

  returns: an empty spliterator - `java.util.Spliterator<SynchronousQueue.E>`"
  ([^java.util.concurrent.SynchronousQueue this]
    (-> this (.spliterator))))

(defn offer
  "Inserts the specified element into this queue, waiting if necessary
   up to the specified wait time for another thread to receive it.

  e - the element to add - `SynchronousQueue.E`
  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: true if successful, or false if the
           specified waiting time elapses before a consumer appears - `boolean`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^java.util.concurrent.SynchronousQueue this ^SynchronousQueue.E e ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.offer e timeout unit)))
  ([^java.util.concurrent.SynchronousQueue this ^SynchronousQueue.E e]
    (-> this (.offer e))))

(defn put
  "Adds the specified element to this queue, waiting if necessary for
   another thread to receive it.

  e - the element to add - `SynchronousQueue.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^java.util.concurrent.SynchronousQueue this ^SynchronousQueue.E e]
    (-> this (.put e))))

(defn contains
  "Always returns false.
   A SynchronousQueue has no internal capacity.

  o - the element - `java.lang.Object`

  returns: false - `boolean`"
  ([^java.util.concurrent.SynchronousQueue this ^java.lang.Object o]
    (-> this (.contains o))))

(defn take
  "Retrieves and removes the head of this queue, waiting if necessary
   for another thread to insert it.

  returns: the head of this queue - `SynchronousQueue.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^java.util.concurrent.SynchronousQueue this]
    (-> this (.take))))

(defn iterator
  "Returns an empty iterator in which hasNext always returns
   false.

  returns: an empty iterator - `java.util.Iterator<SynchronousQueue.E>`"
  ([^java.util.concurrent.SynchronousQueue this]
    (-> this (.iterator))))

(defn remove
  "Always returns false.
   A SynchronousQueue has no internal capacity.

  o - the element to remove - `java.lang.Object`

  returns: false - `boolean`"
  ([^java.util.concurrent.SynchronousQueue this ^java.lang.Object o]
    (-> this (.remove o))))

(defn drain-to
  "Description copied from interface: BlockingQueue

  c - the collection to transfer elements into - `SynchronousQueue.E>`
  max-elements - the maximum number of elements to transfer - `int`

  returns: the number of elements transferred - `int`

  throws: java.lang.UnsupportedOperationException - if addition of elements is not supported by the specified collection"
  ([^java.util.concurrent.SynchronousQueue this ^SynchronousQueue.E> c ^Integer max-elements]
    (-> this (.drainTo c max-elements)))
  ([^java.util.concurrent.SynchronousQueue this ^SynchronousQueue.E> c]
    (-> this (.drainTo c))))

(defn poll
  "Retrieves and removes the head of this queue, waiting
   if necessary up to the specified wait time, for another thread
   to insert it.

  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: the head of this queue, or null if the
           specified waiting time elapses before an element is present - `SynchronousQueue.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^java.util.concurrent.SynchronousQueue this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.poll timeout unit)))
  ([^java.util.concurrent.SynchronousQueue this]
    (-> this (.poll))))

(defn remaining-capacity
  "Always returns zero.
   A SynchronousQueue has no internal capacity.

  returns: zero - `int`"
  ([^java.util.concurrent.SynchronousQueue this]
    (-> this (.remainingCapacity))))

(defn empty?
  "Always returns true.
   A SynchronousQueue has no internal capacity.

  returns: true - `boolean`"
  ([^java.util.concurrent.SynchronousQueue this]
    (-> this (.isEmpty))))

(defn size
  "Always returns zero.
   A SynchronousQueue has no internal capacity.

  returns: zero - `int`"
  ([^java.util.concurrent.SynchronousQueue this]
    (-> this (.size))))

(defn retain-all
  "Always returns false.
   A SynchronousQueue has no internal capacity.

  c - the collection - `java.util.Collection<?>`

  returns: false - `boolean`"
  ([^java.util.concurrent.SynchronousQueue this ^java.util.Collection c]
    (-> this (.retainAll c))))

(defn clear
  "Does nothing.
   A SynchronousQueue has no internal capacity."
  ([^java.util.concurrent.SynchronousQueue this]
    (-> this (.clear))))

(defn to-array
  "Sets the zeroeth element of the specified array to null
   (if the array has non-zero length) and returns it.

  a - the array - `T[]`

  returns: the specified array - `<T> T[]`

  throws: java.lang.NullPointerException - if the specified array is null"
  ([^java.util.concurrent.SynchronousQueue this a]
    (-> this (.toArray a)))
  ([^java.util.concurrent.SynchronousQueue this]
    (-> this (.toArray))))

(defn remove-all
  "Always returns false.
   A SynchronousQueue has no internal capacity.

  c - the collection - `java.util.Collection<?>`

  returns: false - `boolean`"
  ([^java.util.concurrent.SynchronousQueue this ^java.util.Collection c]
    (-> this (.removeAll c))))

(defn contains-all
  "Returns false unless the given collection is empty.
   A SynchronousQueue has no internal capacity.

  c - the collection - `java.util.Collection<?>`

  returns: false unless given collection is empty - `boolean`"
  ([^java.util.concurrent.SynchronousQueue this ^java.util.Collection c]
    (-> this (.containsAll c))))

