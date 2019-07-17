(ns jdk.util.concurrent.LinkedTransferQueue
  "An unbounded TransferQueue based on linked nodes.
  This queue orders elements FIFO (first-in-first-out) with respect
  to any given producer.  The head of the queue is that
  element that has been on the queue the longest time for some
  producer.  The tail of the queue is that element that has
  been on the queue the shortest time for some producer.

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

  This class and its iterator implement all of the
  optional methods of the Collection and Iterator interfaces.

  Memory consistency effects: As with other concurrent
  collections, actions in a thread prior to placing an object into a
  LinkedTransferQueue
  happen-before
  actions subsequent to the access or removal of that element from
  the LinkedTransferQueue in another thread.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent LinkedTransferQueue]))

(defn ->linked-transfer-queue
  "Constructor.

  Creates a LinkedTransferQueue
   initially containing the elements of the given collection,
   added in traversal order of the collection's iterator.

  c - the collection of elements to initially contain - `LinkedTransferQueue.E>`

  throws: java.lang.NullPointerException - if the specified collection or any of its elements are null"
  ([c]
    (new LinkedTransferQueue c))
  ([]
    (new LinkedTransferQueue )))

(defn peek
  "Description copied from interface: Queue

  returns: the head of this queue, or null if this queue is empty - `LinkedTransferQueue.E`"
  ([this]
    (-> this (.peek))))

(defn spliterator
  "Returns a Spliterator over the elements in this queue.

   The returned spliterator is
   weakly consistent.

   The Spliterator reports Spliterator.CONCURRENT,
   Spliterator.ORDERED, and Spliterator.NONNULL.

  returns: a Spliterator over the elements in this queue - `java.util.Spliterator<LinkedTransferQueue.E>`"
  ([this]
    (-> this (.spliterator))))

(defn try-transfer
  "Transfers the element to a consumer if it is possible to do so
   before the timeout elapses.

   More precisely, transfers the specified element immediately
   if there exists a consumer already waiting to receive it (in
   take() or timed poll),
   else inserts the specified element at the tail of this queue
   and waits until the element is received by a consumer,
   returning false if the specified wait time elapses
   before the element can be transferred.

  e - the element to transfer - `LinkedTransferQueue.E`
  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: true if successful, or false if
           the specified waiting time elapses before completion,
           in which case the element is not left enqueued - `boolean`

  throws: java.lang.NullPointerException - if the specified element is null"
  ([this e timeout unit]
    (-> this (.tryTransfer e timeout unit)))
  ([this e]
    (-> this (.tryTransfer e))))

(defn has-waiting-consumer?
  "Description copied from interface: TransferQueue

  returns: true if there is at least one waiting consumer - `boolean`"
  ([this]
    (-> this (.hasWaitingConsumer))))

(defn offer
  "Inserts the specified element at the tail of this queue.
   As the queue is unbounded, this method will never block or
   return false.

  e - the element to add - `LinkedTransferQueue.E`
  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: true (as specified by
    BlockingQueue.offer) - `boolean`

  throws: java.lang.NullPointerException - if the specified element is null"
  ([this e timeout unit]
    (-> this (.offer e timeout unit)))
  ([this e]
    (-> this (.offer e))))

(defn put
  "Inserts the specified element at the tail of this queue.
   As the queue is unbounded, this method will never block.

  e - the element to add - `LinkedTransferQueue.E`

  throws: java.lang.NullPointerException - if the specified element is null"
  ([this e]
    (-> this (.put e))))

(defn contains
  "Returns true if this queue contains the specified element.
   More formally, returns true if and only if this queue contains
   at least one element e such that o.equals(e).

  o - object to be checked for containment in this queue - `java.lang.Object`

  returns: true if this queue contains the specified element - `boolean`"
  ([this o]
    (-> this (.contains o))))

(defn take
  "Description copied from interface: BlockingQueue

  returns: the head of this queue - `LinkedTransferQueue.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([this]
    (-> this (.take))))

(defn iterator
  "Returns an iterator over the elements in this queue in proper sequence.
   The elements will be returned in order from first (head) to last (tail).

   The returned iterator is
   weakly consistent.

  returns: an iterator over the elements in this queue in proper sequence - `java.util.Iterator<LinkedTransferQueue.E>`"
  ([this]
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
  ([this o]
    (-> this (.remove o))))

(defn drain-to
  "Description copied from interface: BlockingQueue

  c - the collection to transfer elements into - `LinkedTransferQueue.E>`
  max-elements - the maximum number of elements to transfer - `int`

  returns: the number of elements transferred - `int`

  throws: java.lang.NullPointerException - if the specified collection is null"
  ([this c max-elements]
    (-> this (.drainTo c max-elements)))
  ([this c]
    (-> this (.drainTo c))))

(defn poll
  "Description copied from interface: BlockingQueue

  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: the head of this queue, or null if the
           specified waiting time elapses before an element is available - `LinkedTransferQueue.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([this timeout unit]
    (-> this (.poll timeout unit)))
  ([this]
    (-> this (.poll))))

(defn transfer
  "Transfers the element to a consumer, waiting if necessary to do so.

   More precisely, transfers the specified element immediately
   if there exists a consumer already waiting to receive it (in
   take() or timed poll),
   else inserts the specified element at the tail of this queue
   and waits until the element is received by a consumer.

  e - the element to transfer - `LinkedTransferQueue.E`

  throws: java.lang.NullPointerException - if the specified element is null"
  ([this e]
    (-> this (.transfer e))))

(defn remaining-capacity
  "Always returns Integer.MAX_VALUE because a
   LinkedTransferQueue is not capacity constrained.

  returns: Integer.MAX_VALUE (as specified by
           BlockingQueue.remainingCapacity) - `int`"
  ([this]
    (-> this (.remainingCapacity))))

(defn add
  "Inserts the specified element at the tail of this queue.
   As the queue is unbounded, this method will never throw
   IllegalStateException or return false.

  e - the element to add - `LinkedTransferQueue.E`

  returns: true (as specified by Collection.add(E)) - `boolean`

  throws: java.lang.NullPointerException - if the specified element is null"
  ([this e]
    (-> this (.add e))))

(defn empty?
  "Returns true if this queue contains no elements.

  returns: true if this queue contains no elements - `boolean`"
  ([this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of elements in this queue.  If this queue
   contains more than Integer.MAX_VALUE elements, returns
   Integer.MAX_VALUE.

   Beware that, unlike in most collections, this method is
   NOT a constant-time operation. Because of the
   asynchronous nature of these queues, determining the current
   number of elements requires an O(n) traversal.

  returns: the number of elements in this queue - `int`"
  ([this]
    (-> this (.size))))

(defn get-waiting-consumer-count
  "Description copied from interface: TransferQueue

  returns: the number of consumers waiting to receive elements - `int`"
  ([this]
    (-> this (.getWaitingConsumerCount))))

