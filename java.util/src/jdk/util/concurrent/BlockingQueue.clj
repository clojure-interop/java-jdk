(ns jdk.util.concurrent.BlockingQueue
  "A Queue that additionally supports operations
  that wait for the queue to become non-empty when retrieving an
  element, and wait for space to become available in the queue when
  storing an element.

  BlockingQueue methods come in four forms, with different ways
  of handling operations that cannot be satisfied immediately, but may be
  satisfied at some point in the future:
  one throws an exception, the second returns a special value (either
  null or false, depending on the operation), the third
  blocks the current thread indefinitely until the operation can succeed,
  and the fourth blocks for only a given maximum time limit before giving
  up.  These methods are summarized in the following table:


  Summary of BlockingQueue methods


     Throws exception
     Special value
     Blocks
     Times out


     Insert
     add(e)
     offer(e)
     put(e)
     offer(e, time, unit)


     Remove
     remove()
     poll()
     take()
     poll(time, unit)


     Examine
     element()
     peek()
     not applicable
     not applicable



  A BlockingQueue does not accept null elements.
  Implementations throw NullPointerException on attempts
  to add, put or offer a null.  A
  null is used as a sentinel value to indicate failure of
  poll operations.

  A BlockingQueue may be capacity bounded. At any given
  time it may have a remainingCapacity beyond which no
  additional elements can be put without blocking.
  A BlockingQueue without any intrinsic capacity constraints always
  reports a remaining capacity of Integer.MAX_VALUE.

  BlockingQueue implementations are designed to be used
  primarily for producer-consumer queues, but additionally support
  the Collection interface.  So, for example, it is
  possible to remove an arbitrary element from a queue using
  remove(x). However, such operations are in general
  not performed very efficiently, and are intended for only
  occasional use, such as when a queued message is cancelled.

  BlockingQueue implementations are thread-safe.  All
  queuing methods achieve their effects atomically using internal
  locks or other forms of concurrency control. However, the
  bulk Collection operations addAll,
  containsAll, retainAll and removeAll are
  not necessarily performed atomically unless specified
  otherwise in an implementation. So it is possible, for example, for
  addAll(c) to fail (throwing an exception) after adding
  only some of the elements in c.

  A BlockingQueue does not intrinsically support
  any kind of `close` or `shutdown` operation to
  indicate that no more items will be added.  The needs and usage of
  such features tend to be implementation-dependent. For example, a
  common tactic is for producers to insert special
  end-of-stream or poison objects, that are
  interpreted accordingly when taken by consumers.


  Usage example, based on a typical producer-consumer scenario.
  Note that a BlockingQueue can safely be used with multiple
  producers and multiple consumers.


  class Producer implements Runnable {
    private final BlockingQueue queue;
    Producer(BlockingQueue q) { queue = q; }
    public void run() {
      try {
        while (true) { queue.put(produce()); }
      } catch (InterruptedException ex) { ... handle ...}
    }
    Object produce() { ... }
  }

  class Consumer implements Runnable {
    private final BlockingQueue queue;
    Consumer(BlockingQueue q) { queue = q; }
    public void run() {
      try {
        while (true) { consume(queue.take()); }
      } catch (InterruptedException ex) { ... handle ...}
    }
    void consume(Object x) { ... }
  }

  class Setup {
    void main() {
      BlockingQueue q = new SomeQueueImplementation();
      Producer p = new Producer(q);
      Consumer c1 = new Consumer(q);
      Consumer c2 = new Consumer(q);
      new Thread(p).start();
      new Thread(c1).start();
      new Thread(c2).start();
    }
  }

  Memory consistency effects: As with other concurrent
  collections, actions in a thread prior to placing an object into a
  BlockingQueue
  happen-before
  actions subsequent to the access or removal of that element from
  the BlockingQueue in another thread.

  This interface is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent BlockingQueue]))

(defn offer
  "Inserts the specified element into this queue, waiting up to the
   specified wait time if necessary for space to become available.

  e - the element to add - `BlockingQueue.E`
  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: true if successful, or false if
           the specified waiting time elapses before space is available - `boolean`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  (^Boolean [^java.util.concurrent.BlockingQueue this ^BlockingQueue.E e ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.offer e timeout unit)))
  (^Boolean [^java.util.concurrent.BlockingQueue this ^BlockingQueue.E e]
    (-> this (.offer e))))

(defn put
  "Inserts the specified element into this queue, waiting if necessary
   for space to become available.

  e - the element to add - `BlockingQueue.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^java.util.concurrent.BlockingQueue this ^BlockingQueue.E e]
    (-> this (.put e))))

(defn contains
  "Returns true if this queue contains the specified element.
   More formally, returns true if and only if this queue contains
   at least one element e such that o.equals(e).

  o - object to be checked for containment in this queue - `java.lang.Object`

  returns: true if this queue contains the specified element - `boolean`

  throws: java.lang.ClassCastException - if the class of the specified element is incompatible with this queue (optional)"
  (^Boolean [^java.util.concurrent.BlockingQueue this ^java.lang.Object o]
    (-> this (.contains o))))

(defn take
  "Retrieves and removes the head of this queue, waiting if necessary
   until an element becomes available.

  returns: the head of this queue - `BlockingQueue.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  (^BlockingQueue.E [^java.util.concurrent.BlockingQueue this]
    (-> this (.take))))

(defn remove
  "Removes a single instance of the specified element from this queue,
   if it is present.  More formally, removes an element e such
   that o.equals(e), if this queue contains one or more such
   elements.
   Returns true if this queue contained the specified element
   (or equivalently, if this queue changed as a result of the call).

  o - element to be removed from this queue, if present - `java.lang.Object`

  returns: true if this queue changed as a result of the call - `boolean`

  throws: java.lang.ClassCastException - if the class of the specified element is incompatible with this queue (optional)"
  (^Boolean [^java.util.concurrent.BlockingQueue this ^java.lang.Object o]
    (-> this (.remove o))))

(defn drain-to
  "Removes at most the given number of available elements from
   this queue and adds them to the given collection.  A failure
   encountered while attempting to add elements to
   collection c may result in elements being in neither,
   either or both collections when the associated exception is
   thrown.  Attempts to drain a queue to itself result in
   IllegalArgumentException. Further, the behavior of
   this operation is undefined if the specified collection is
   modified while the operation is in progress.

  c - the collection to transfer elements into - `BlockingQueue.E>`
  max-elements - the maximum number of elements to transfer - `int`

  returns: the number of elements transferred - `int`

  throws: java.lang.UnsupportedOperationException - if addition of elements is not supported by the specified collection"
  (^Integer [^java.util.concurrent.BlockingQueue this ^BlockingQueue.E> c ^Integer max-elements]
    (-> this (.drainTo c max-elements)))
  (^Integer [^java.util.concurrent.BlockingQueue this ^BlockingQueue.E> c]
    (-> this (.drainTo c))))

(defn poll
  "Retrieves and removes the head of this queue, waiting up to the
   specified wait time if necessary for an element to become available.

  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: the head of this queue, or null if the
           specified waiting time elapses before an element is available - `BlockingQueue.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  (^BlockingQueue.E [^java.util.concurrent.BlockingQueue this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.poll timeout unit))))

(defn remaining-capacity
  "Returns the number of additional elements that this queue can ideally
   (in the absence of memory or resource constraints) accept without
   blocking, or Integer.MAX_VALUE if there is no intrinsic
   limit.

   Note that you cannot always tell if an attempt to insert
   an element will succeed by inspecting remainingCapacity
   because it may be the case that another thread is about to
   insert or remove an element.

  returns: the remaining capacity - `int`"
  (^Integer [^java.util.concurrent.BlockingQueue this]
    (-> this (.remainingCapacity))))

(defn add
  "Inserts the specified element into this queue if it is possible to do
   so immediately without violating capacity restrictions, returning
   true upon success and throwing an
   IllegalStateException if no space is currently available.
   When using a capacity-restricted queue, it is generally preferable to
   use offer.

  e - the element to add - `BlockingQueue.E`

  returns: true (as specified by Collection.add(E)) - `boolean`

  throws: java.lang.IllegalStateException - if the element cannot be added at this time due to capacity restrictions"
  (^Boolean [^java.util.concurrent.BlockingQueue this ^BlockingQueue.E e]
    (-> this (.add e))))

