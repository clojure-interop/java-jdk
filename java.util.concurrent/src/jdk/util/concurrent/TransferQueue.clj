(ns jdk.util.concurrent.TransferQueue
  "A BlockingQueue in which producers may wait for consumers
  to receive elements.  A TransferQueue may be useful for
  example in message passing applications in which producers
  sometimes (using method transfer(E)) await receipt of
  elements by consumers invoking take or poll, while
  at other times enqueue elements (via method put) without
  waiting for receipt.
  Non-blocking and
  time-out versions of
  tryTransfer are also available.
  A TransferQueue may also be queried, via hasWaitingConsumer(), whether there are any threads waiting for
  items, which is a converse analogy to a peek operation.

  Like other blocking queues, a TransferQueue may be
  capacity bounded.  If so, an attempted transfer operation may
  initially block waiting for available space, and/or subsequently
  block waiting for reception by a consumer.  Note that in a queue
  with zero capacity, such as SynchronousQueue, put
  and transfer are effectively synonymous.

  This interface is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent TransferQueue]))

(defn try-transfer
  "Transfers the element to a consumer if it is possible to do so
   before the timeout elapses.

   More precisely, transfers the specified element immediately
   if there exists a consumer already waiting to receive it (in
   BlockingQueue.take() or timed poll),
   else waits until the element is received by a consumer,
   returning false if the specified wait time elapses
   before the element can be transferred.

  e - the element to transfer - `TransferQueue.E`
  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: true if successful, or false if
           the specified waiting time elapses before completion,
           in which case the element is not left enqueued - `boolean`

  throws: java.lang.InterruptedException - if interrupted while waiting, in which case the element is not left enqueued"
  ([^. this ^TransferQueue.E e ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.tryTransfer e timeout unit)))
  ([^. this ^TransferQueue.E e]
    (-> this (.tryTransfer e))))

(defn transfer
  "Transfers the element to a consumer, waiting if necessary to do so.

   More precisely, transfers the specified element immediately
   if there exists a consumer already waiting to receive it (in
   BlockingQueue.take() or timed poll),
   else waits until the element is received by a consumer.

  e - the element to transfer - `TransferQueue.E`

  throws: java.lang.InterruptedException - if interrupted while waiting, in which case the element is not left enqueued"
  ([^. this ^TransferQueue.E e]
    (-> this (.transfer e))))

(defn has-waiting-consumer?
  "Returns true if there is at least one consumer waiting
   to receive an element via BlockingQueue.take() or
   timed poll.
   The return value represents a momentary state of affairs.

  returns: true if there is at least one waiting consumer - `boolean`"
  ([^. this]
    (-> this (.hasWaitingConsumer))))

(defn get-waiting-consumer-count
  "Returns an estimate of the number of consumers waiting to
   receive elements via BlockingQueue.take() or timed
   poll.  The return value is an
   approximation of a momentary state of affairs, that may be
   inaccurate if consumers have completed or given up waiting.
   The value may be useful for monitoring and heuristics, but
   not for synchronization control.  Implementations of this
   method are likely to be noticeably slower than those for
   hasWaitingConsumer().

  returns: the number of consumers waiting to receive elements - `int`"
  ([^. this]
    (-> this (.getWaitingConsumerCount))))

