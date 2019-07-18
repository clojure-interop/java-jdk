(ns jdk.util.concurrent.locks.AbstractQueuedLongSynchronizer
  "A version of AbstractQueuedSynchronizer in
  which synchronization state is maintained as a long.
  This class has exactly the same structure, properties, and methods
  as AbstractQueuedSynchronizer with the exception
  that all state-related parameters and results are defined
  as long rather than int. This class
  may be useful when creating synchronizers such as
  multilevel locks and barriers that require
  64 bits of state.

  See AbstractQueuedSynchronizer for usage
  notes and examples."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent.locks AbstractQueuedLongSynchronizer]))

(defn release
  "Releases in exclusive mode.  Implemented by unblocking one or
   more threads if tryRelease(long) returns true.
   This method can be used to implement method Lock.unlock().

  arg - the release argument. This value is conveyed to tryRelease(long) but is otherwise uninterpreted and can represent anything you like. - `long`

  returns: the value returned from tryRelease(long) - `boolean`"
  (^Boolean [^AbstractQueuedLongSynchronizer this ^Long arg]
    (-> this (.release arg))))

(defn queued?
  "Returns true if the given thread is currently queued.

   This implementation traverses the queue to determine
   presence of the given thread.

  thread - the thread - `java.lang.Thread`

  returns: true if the given thread is on the queue - `boolean`

  throws: java.lang.NullPointerException - if the thread is null"
  (^Boolean [^AbstractQueuedLongSynchronizer this ^java.lang.Thread thread]
    (-> this (.isQueued thread))))

(defn get-queue-length
  "Returns an estimate of the number of threads waiting to
   acquire.  The value is only an estimate because the number of
   threads may change dynamically while this method traverses
   internal data structures.  This method is designed for use in
   monitoring system state, not for synchronization
   control.

  returns: the estimated number of threads waiting to acquire - `int`"
  (^Integer [^AbstractQueuedLongSynchronizer this]
    (-> this (.getQueueLength))))

(defn acquire-shared
  "Acquires in shared mode, ignoring interrupts.  Implemented by
   first invoking at least once tryAcquireShared(long),
   returning on success.  Otherwise the thread is queued, possibly
   repeatedly blocking and unblocking, invoking tryAcquireShared(long) until success.

  arg - the acquire argument. This value is conveyed to tryAcquireShared(long) but is otherwise uninterpreted and can represent anything you like. - `long`"
  ([^AbstractQueuedLongSynchronizer this ^Long arg]
    (-> this (.acquireShared arg))))

(defn get-first-queued-thread
  "Returns the first (longest-waiting) thread in the queue, or
   null if no threads are currently queued.

   In this implementation, this operation normally returns in
   constant time, but may iterate upon contention if other threads are
   concurrently modifying the queue.

  returns: the first (longest-waiting) thread in the queue, or
           null if no threads are currently queued - `java.lang.Thread`"
  (^java.lang.Thread [^AbstractQueuedLongSynchronizer this]
    (-> this (.getFirstQueuedThread))))

(defn has-waiters?
  "Queries whether any threads are waiting on the given condition
   associated with this synchronizer. Note that because timeouts
   and interrupts may occur at any time, a true return
   does not guarantee that a future signal will awaken
   any threads.  This method is designed primarily for use in
   monitoring of the system state.

  condition - the condition - `java.util.concurrent.locks.AbstractQueuedLongSynchronizer$ConditionObject`

  returns: true if there are any waiting threads - `boolean`

  throws: java.lang.IllegalMonitorStateException - if exclusive synchronization is not held"
  (^Boolean [^AbstractQueuedLongSynchronizer this ^java.util.concurrent.locks.AbstractQueuedLongSynchronizer$ConditionObject condition]
    (-> this (.hasWaiters condition))))

(defn to-string
  "Returns a string identifying this synchronizer, as well as its state.
   The state, in brackets, includes the String `State =`
   followed by the current value of getState(), and either
   `nonempty` or `empty` depending on whether the
   queue is empty.

  returns: a string identifying this synchronizer, as well as its state - `java.lang.String`"
  (^java.lang.String [^AbstractQueuedLongSynchronizer this]
    (-> this (.toString))))

(defn acquire-interruptibly
  "Acquires in exclusive mode, aborting if interrupted.
   Implemented by first checking interrupt status, then invoking
   at least once tryAcquire(long), returning on
   success.  Otherwise the thread is queued, possibly repeatedly
   blocking and unblocking, invoking tryAcquire(long)
   until success or the thread is interrupted.  This method can be
   used to implement method Lock.lockInterruptibly().

  arg - the acquire argument. This value is conveyed to tryAcquire(long) but is otherwise uninterpreted and can represent anything you like. - `long`

  throws: java.lang.InterruptedException - if the current thread is interrupted"
  ([^AbstractQueuedLongSynchronizer this ^Long arg]
    (-> this (.acquireInterruptibly arg))))

(defn try-acquire-nanos
  "Attempts to acquire in exclusive mode, aborting if interrupted,
   and failing if the given timeout elapses.  Implemented by first
   checking interrupt status, then invoking at least once tryAcquire(long), returning on success.  Otherwise, the thread is
   queued, possibly repeatedly blocking and unblocking, invoking
   tryAcquire(long) until success or the thread is interrupted
   or the timeout elapses.  This method can be used to implement
   method Lock.tryLock(long, TimeUnit).

  arg - the acquire argument. This value is conveyed to tryAcquire(long) but is otherwise uninterpreted and can represent anything you like. - `long`
  nanos-timeout - the maximum number of nanoseconds to wait - `long`

  returns: true if acquired; false if timed out - `boolean`

  throws: java.lang.InterruptedException - if the current thread is interrupted"
  (^Boolean [^AbstractQueuedLongSynchronizer this ^Long arg ^Long nanos-timeout]
    (-> this (.tryAcquireNanos arg nanos-timeout))))

(defn get-shared-queued-threads
  "Returns a collection containing threads that may be waiting to
   acquire in shared mode. This has the same properties
   as getQueuedThreads() except that it only returns
   those threads waiting due to a shared acquire.

  returns: the collection of threads - `java.util.Collection<java.lang.Thread>`"
  (^java.util.Collection [^AbstractQueuedLongSynchronizer this]
    (-> this (.getSharedQueuedThreads))))

(defn release-shared
  "Releases in shared mode.  Implemented by unblocking one or more
   threads if tryReleaseShared(long) returns true.

  arg - the release argument. This value is conveyed to tryReleaseShared(long) but is otherwise uninterpreted and can represent anything you like. - `long`

  returns: the value returned from tryReleaseShared(long) - `boolean`"
  (^Boolean [^AbstractQueuedLongSynchronizer this ^Long arg]
    (-> this (.releaseShared arg))))

(defn get-queued-threads
  "Returns a collection containing threads that may be waiting to
   acquire.  Because the actual set of threads may change
   dynamically while constructing this result, the returned
   collection is only a best-effort estimate.  The elements of the
   returned collection are in no particular order.  This method is
   designed to facilitate construction of subclasses that provide
   more extensive monitoring facilities.

  returns: the collection of threads - `java.util.Collection<java.lang.Thread>`"
  (^java.util.Collection [^AbstractQueuedLongSynchronizer this]
    (-> this (.getQueuedThreads))))

(defn acquire-shared-interruptibly
  "Acquires in shared mode, aborting if interrupted.  Implemented
   by first checking interrupt status, then invoking at least once
   tryAcquireShared(long), returning on success.  Otherwise the
   thread is queued, possibly repeatedly blocking and unblocking,
   invoking tryAcquireShared(long) until success or the thread
   is interrupted.

  arg - the acquire argument. This value is conveyed to tryAcquireShared(long) but is otherwise uninterpreted and can represent anything you like. - `long`

  throws: java.lang.InterruptedException - if the current thread is interrupted"
  ([^AbstractQueuedLongSynchronizer this ^Long arg]
    (-> this (.acquireSharedInterruptibly arg))))

(defn get-exclusive-queued-threads
  "Returns a collection containing threads that may be waiting to
   acquire in exclusive mode. This has the same properties
   as getQueuedThreads() except that it only returns
   those threads waiting due to an exclusive acquire.

  returns: the collection of threads - `java.util.Collection<java.lang.Thread>`"
  (^java.util.Collection [^AbstractQueuedLongSynchronizer this]
    (-> this (.getExclusiveQueuedThreads))))

(defn has-queued-threads?
  "Queries whether any threads are waiting to acquire. Note that
   because cancellations due to interrupts and timeouts may occur
   at any time, a true return does not guarantee that any
   other thread will ever acquire.

   In this implementation, this operation returns in
   constant time.

  returns: true if there may be other threads waiting to acquire - `boolean`"
  (^Boolean [^AbstractQueuedLongSynchronizer this]
    (-> this (.hasQueuedThreads))))

(defn get-waiting-threads
  "Returns a collection containing those threads that may be
   waiting on the given condition associated with this
   synchronizer.  Because the actual set of threads may change
   dynamically while constructing this result, the returned
   collection is only a best-effort estimate. The elements of the
   returned collection are in no particular order.

  condition - the condition - `java.util.concurrent.locks.AbstractQueuedLongSynchronizer$ConditionObject`

  returns: the collection of threads - `java.util.Collection<java.lang.Thread>`

  throws: java.lang.IllegalMonitorStateException - if exclusive synchronization is not held"
  (^java.util.Collection [^AbstractQueuedLongSynchronizer this ^java.util.concurrent.locks.AbstractQueuedLongSynchronizer$ConditionObject condition]
    (-> this (.getWaitingThreads condition))))

(defn try-acquire-shared-nanos
  "Attempts to acquire in shared mode, aborting if interrupted, and
   failing if the given timeout elapses.  Implemented by first
   checking interrupt status, then invoking at least once tryAcquireShared(long), returning on success.  Otherwise, the
   thread is queued, possibly repeatedly blocking and unblocking,
   invoking tryAcquireShared(long) until success or the thread
   is interrupted or the timeout elapses.

  arg - the acquire argument. This value is conveyed to tryAcquireShared(long) but is otherwise uninterpreted and can represent anything you like. - `long`
  nanos-timeout - the maximum number of nanoseconds to wait - `long`

  returns: true if acquired; false if timed out - `boolean`

  throws: java.lang.InterruptedException - if the current thread is interrupted"
  (^Boolean [^AbstractQueuedLongSynchronizer this ^Long arg ^Long nanos-timeout]
    (-> this (.tryAcquireSharedNanos arg nanos-timeout))))

(defn get-wait-queue-length
  "Returns an estimate of the number of threads waiting on the
   given condition associated with this synchronizer. Note that
   because timeouts and interrupts may occur at any time, the
   estimate serves only as an upper bound on the actual number of
   waiters.  This method is designed for use in monitoring of the
   system state, not for synchronization control.

  condition - the condition - `java.util.concurrent.locks.AbstractQueuedLongSynchronizer$ConditionObject`

  returns: the estimated number of waiting threads - `int`

  throws: java.lang.IllegalMonitorStateException - if exclusive synchronization is not held"
  (^Integer [^AbstractQueuedLongSynchronizer this ^java.util.concurrent.locks.AbstractQueuedLongSynchronizer$ConditionObject condition]
    (-> this (.getWaitQueueLength condition))))

(defn has-queued-predecessors?
  "Queries whether any threads have been waiting to acquire longer
   than the current thread.

   An invocation of this method is equivalent to (but may be
   more efficient than):


   getFirstQueuedThread() != Thread.currentThread() &&
   hasQueuedThreads()

   Note that because cancellations due to interrupts and
   timeouts may occur at any time, a true return does not
   guarantee that some other thread will acquire before the current
   thread.  Likewise, it is possible for another thread to win a
   race to enqueue after this method has returned false,
   due to the queue being empty.

   This method is designed to be used by a fair synchronizer to
   avoid barging.
   Such a synchronizer's tryAcquire(long) method should return
   false, and its tryAcquireShared(long) method should
   return a negative value, if this method returns true
   (unless this is a reentrant acquire).  For example, the tryAcquire method for a fair, reentrant, exclusive mode
   synchronizer might look like this:



   protected boolean tryAcquire(int arg) {
     if (isHeldExclusively()) {
       // A reentrant acquire; increment hold count
       return true;
     } else if (hasQueuedPredecessors()) {
       return false;
     } else {
       // try to acquire normally
     }
   }

  returns: true if there is a queued thread preceding the
           current thread, and false if the current thread
           is at the head of the queue or the queue is empty - `boolean`"
  (^Boolean [^AbstractQueuedLongSynchronizer this]
    (-> this (.hasQueuedPredecessors))))

(defn owns
  "Queries whether the given ConditionObject
   uses this synchronizer as its lock.

  condition - the condition - `java.util.concurrent.locks.AbstractQueuedLongSynchronizer$ConditionObject`

  returns: true if owned - `boolean`

  throws: java.lang.NullPointerException - if the condition is null"
  (^Boolean [^AbstractQueuedLongSynchronizer this ^java.util.concurrent.locks.AbstractQueuedLongSynchronizer$ConditionObject condition]
    (-> this (.owns condition))))

(defn acquire
  "Acquires in exclusive mode, ignoring interrupts.  Implemented
   by invoking at least once tryAcquire(long),
   returning on success.  Otherwise the thread is queued, possibly
   repeatedly blocking and unblocking, invoking tryAcquire(long) until success.  This method can be used
   to implement method Lock.lock().

  arg - the acquire argument. This value is conveyed to tryAcquire(long) but is otherwise uninterpreted and can represent anything you like. - `long`"
  ([^AbstractQueuedLongSynchronizer this ^Long arg]
    (-> this (.acquire arg))))

(defn has-contended?
  "Queries whether any threads have ever contended to acquire this
   synchronizer; that is if an acquire method has ever blocked.

   In this implementation, this operation returns in
   constant time.

  returns: true if there has ever been contention - `boolean`"
  (^Boolean [^AbstractQueuedLongSynchronizer this]
    (-> this (.hasContended))))

