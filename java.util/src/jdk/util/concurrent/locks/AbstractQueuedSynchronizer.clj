(ns jdk.util.concurrent.locks.AbstractQueuedSynchronizer
  "Provides a framework for implementing blocking locks and related
  synchronizers (semaphores, events, etc) that rely on
  first-in-first-out (FIFO) wait queues.  This class is designed to
  be a useful basis for most kinds of synchronizers that rely on a
  single atomic int value to represent state. Subclasses
  must define the protected methods that change this state, and which
  define what that state means in terms of this object being acquired
  or released.  Given these, the other methods in this class carry
  out all queuing and blocking mechanics. Subclasses can maintain
  other state fields, but only the atomically updated int
  value manipulated using methods getState(), setState(int) and compareAndSetState(int, int) is tracked with respect
  to synchronization.

  Subclasses should be defined as non-public internal helper
  classes that are used to implement the synchronization properties
  of their enclosing class.  Class
  AbstractQueuedSynchronizer does not implement any
  synchronization interface.  Instead it defines methods such as
  acquireInterruptibly(int) that can be invoked as
  appropriate by concrete locks and related synchronizers to
  implement their public methods.

  This class supports either or both a default exclusive
  mode and a shared mode. When acquired in exclusive mode,
  attempted acquires by other threads cannot succeed. Shared mode
  acquires by multiple threads may (but need not) succeed. This class
  does not \"understand\" these differences except in the
  mechanical sense that when a shared mode acquire succeeds, the next
  waiting thread (if one exists) must also determine whether it can
  acquire as well. Threads waiting in the different modes share the
  same FIFO queue. Usually, implementation subclasses support only
  one of these modes, but both can come into play for example in a
  ReadWriteLock. Subclasses that support only exclusive or
  only shared modes need not define the methods supporting the unused mode.

  This class defines a nested AbstractQueuedSynchronizer.ConditionObject class that
  can be used as a Condition implementation by subclasses
  supporting exclusive mode for which method isHeldExclusively() reports whether synchronization is exclusively
  held with respect to the current thread, method release(int)
  invoked with the current getState() value fully releases
  this object, and acquire(int), given this saved state value,
  eventually restores this object to its previous acquired state.  No
  AbstractQueuedSynchronizer method otherwise creates such a
  condition, so if this constraint cannot be met, do not use it.  The
  behavior of AbstractQueuedSynchronizer.ConditionObject depends of course on the
  semantics of its synchronizer implementation.

  This class provides inspection, instrumentation, and monitoring
  methods for the internal queue, as well as similar methods for
  condition objects. These can be exported as desired into classes
  using an AbstractQueuedSynchronizer for their
  synchronization mechanics.

  Serialization of this class stores only the underlying atomic
  integer maintaining state, so deserialized objects have empty
  thread queues. Typical subclasses requiring serializability will
  define a readObject method that restores this to a known
  initial state upon deserialization.

  Usage

  To use this class as the basis of a synchronizer, redefine the
  following methods, as applicable, by inspecting and/or modifying
  the synchronization state using getState(), setState(int) and/or compareAndSetState(int, int):


   tryAcquire(int)
   tryRelease(int)
   tryAcquireShared(int)
   tryReleaseShared(int)
   isHeldExclusively()


  Each of these methods by default throws UnsupportedOperationException.  Implementations of these methods
  must be internally thread-safe, and should in general be short and
  not block. Defining these methods is the only supported
  means of using this class. All other methods are declared
  final because they cannot be independently varied.

  You may also find the inherited methods from AbstractOwnableSynchronizer useful to keep track of the thread
  owning an exclusive synchronizer.  You are encouraged to use them
  -- this enables monitoring and diagnostic tools to assist users in
  determining which threads hold locks.

  Even though this class is based on an internal FIFO queue, it
  does not automatically enforce FIFO acquisition policies.  The core
  of exclusive synchronization takes the form:



  Acquire:
      while (!tryAcquire(arg)) {
         enqueue thread if it is not already queued;
         possibly block current thread;
      }

  Release:
      if (tryRelease(arg))
         unblock the first queued thread;

  (Shared mode is similar but may involve cascading signals.)

  Because checks in acquire are invoked before
  enqueuing, a newly acquiring thread may barge ahead of
  others that are blocked and queued.  However, you can, if desired,
  define tryAcquire and/or tryAcquireShared to
  disable barging by internally invoking one or more of the inspection
  methods, thereby providing a fair FIFO acquisition order.
  In particular, most fair synchronizers can define tryAcquire
  to return false if hasQueuedPredecessors() (a method
  specifically designed to be used by fair synchronizers) returns
  true.  Other variations are possible.

  Throughput and scalability are generally highest for the
  default barging (also known as greedy,
  renouncement, and convoy-avoidance) strategy.
  While this is not guaranteed to be fair or starvation-free, earlier
  queued threads are allowed to recontend before later queued
  threads, and each recontention has an unbiased chance to succeed
  against incoming threads.  Also, while acquires do not
  \"spin\" in the usual sense, they may perform multiple
  invocations of tryAcquire interspersed with other
  computations before blocking.  This gives most of the benefits of
  spins when exclusive synchronization is only briefly held, without
  most of the liabilities when it isn't. If so desired, you can
  augment this by preceding calls to acquire methods with
  \"fast-path\" checks, possibly prechecking hasContended()
  and/or hasQueuedThreads() to only do so if the synchronizer
  is likely not to be contended.

  This class provides an efficient and scalable basis for
  synchronization in part by specializing its range of use to
  synchronizers that can rely on int state, acquire, and
  release parameters, and an internal FIFO wait queue. When this does
  not suffice, you can build synchronizers from a lower level using
  atomic classes, your own custom
  Queue classes, and LockSupport blocking
  support.

  Usage Examples

  Here is a non-reentrant mutual exclusion lock class that uses
  the value zero to represent the unlocked state, and one to
  represent the locked state. While a non-reentrant lock
  does not strictly require recording of the current owner
  thread, this class does so anyway to make usage easier to monitor.
  It also supports conditions and exposes
  one of the instrumentation methods:



  class Mutex implements Lock, java.io.Serializable {

    // Our internal helper class
    private static class Sync extends AbstractQueuedSynchronizer {
      // Reports whether in locked state
      protected boolean isHeldExclusively() {
        return getState() == 1;
      }

      // Acquires the lock if state is zero
      public boolean tryAcquire(int acquires) {
        assert acquires == 1; // Otherwise unused
        if (compareAndSetState(0, 1)) {
          setExclusiveOwnerThread(Thread.currentThread());
          return true;
        }
        return false;
      }

      // Releases the lock by setting state to zero
      protected boolean tryRelease(int releases) {
        assert releases == 1; // Otherwise unused
        if (getState() == 0) throw new IllegalMonitorStateException();
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
      }

      // Provides a Condition
      Condition newCondition() { return new ConditionObject(); }

      // Deserializes properly
      private void readObject(ObjectInputStream s)
          throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        setState(0); // reset to unlocked state
      }
    }

    // The sync object does all the hard work. We just forward to it.
    private final Sync sync = new Sync();

    public void lock()                { sync.acquire(1); }
    public boolean tryLock()          { return sync.tryAcquire(1); }
    public void unlock()              { sync.release(1); }
    public Condition newCondition()   { return sync.newCondition(); }
    public boolean isLocked()         { return sync.isHeldExclusively(); }
    public boolean hasQueuedThreads() { return sync.hasQueuedThreads(); }
    public void lockInterruptibly() throws InterruptedException {
      sync.acquireInterruptibly(1);
    }
    public boolean tryLock(long timeout, TimeUnit unit)
        throws InterruptedException {
      return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }
  }

  Here is a latch class that is like a
  CountDownLatch
  except that it only requires a single signal to
  fire. Because a latch is non-exclusive, it uses the shared
  acquire and release methods.



  class BooleanLatch {

    private static class Sync extends AbstractQueuedSynchronizer {
      boolean isSignalled() { return getState() != 0; }

      protected int tryAcquireShared(int ignore) {
        return isSignalled() ? 1 : -1;
      }

      protected boolean tryReleaseShared(int ignore) {
        setState(1);
        return true;
      }
    }

    private final Sync sync = new Sync();
    public boolean isSignalled() { return sync.isSignalled(); }
    public void signal()         { sync.releaseShared(1); }
    public void await() throws InterruptedException {
      sync.acquireSharedInterruptibly(1);
    }
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent.locks AbstractQueuedSynchronizer]))

(defn release
  "Releases in exclusive mode.  Implemented by unblocking one or
   more threads if tryRelease(int) returns true.
   This method can be used to implement method Lock.unlock().

  arg - the release argument. This value is conveyed to tryRelease(int) but is otherwise uninterpreted and can represent anything you like. - `int`

  returns: the value returned from tryRelease(int) - `boolean`"
  (^Boolean [^AbstractQueuedSynchronizer this ^Integer arg]
    (-> this (.release arg))))

(defn queued?
  "Returns true if the given thread is currently queued.

   This implementation traverses the queue to determine
   presence of the given thread.

  thread - the thread - `java.lang.Thread`

  returns: true if the given thread is on the queue - `boolean`

  throws: java.lang.NullPointerException - if the thread is null"
  (^Boolean [^AbstractQueuedSynchronizer this ^java.lang.Thread thread]
    (-> this (.isQueued thread))))

(defn get-queue-length
  "Returns an estimate of the number of threads waiting to
   acquire.  The value is only an estimate because the number of
   threads may change dynamically while this method traverses
   internal data structures.  This method is designed for use in
   monitoring system state, not for synchronization
   control.

  returns: the estimated number of threads waiting to acquire - `int`"
  (^Integer [^AbstractQueuedSynchronizer this]
    (-> this (.getQueueLength))))

(defn acquire-shared
  "Acquires in shared mode, ignoring interrupts.  Implemented by
   first invoking at least once tryAcquireShared(int),
   returning on success.  Otherwise the thread is queued, possibly
   repeatedly blocking and unblocking, invoking tryAcquireShared(int) until success.

  arg - the acquire argument. This value is conveyed to tryAcquireShared(int) but is otherwise uninterpreted and can represent anything you like. - `int`"
  ([^AbstractQueuedSynchronizer this ^Integer arg]
    (-> this (.acquireShared arg))))

(defn get-first-queued-thread
  "Returns the first (longest-waiting) thread in the queue, or
   null if no threads are currently queued.

   In this implementation, this operation normally returns in
   constant time, but may iterate upon contention if other threads are
   concurrently modifying the queue.

  returns: the first (longest-waiting) thread in the queue, or
           null if no threads are currently queued - `java.lang.Thread`"
  (^java.lang.Thread [^AbstractQueuedSynchronizer this]
    (-> this (.getFirstQueuedThread))))

(defn has-waiters?
  "Queries whether any threads are waiting on the given condition
   associated with this synchronizer. Note that because timeouts
   and interrupts may occur at any time, a true return
   does not guarantee that a future signal will awaken
   any threads.  This method is designed primarily for use in
   monitoring of the system state.

  condition - the condition - `java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject`

  returns: true if there are any waiting threads - `boolean`

  throws: java.lang.IllegalMonitorStateException - if exclusive synchronization is not held"
  (^Boolean [^AbstractQueuedSynchronizer this ^java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject condition]
    (-> this (.hasWaiters condition))))

(defn to-string
  "Returns a string identifying this synchronizer, as well as its state.
   The state, in brackets, includes the String \"State =\"
   followed by the current value of getState(), and either
   \"nonempty\" or \"empty\" depending on whether the
   queue is empty.

  returns: a string identifying this synchronizer, as well as its state - `java.lang.String`"
  (^java.lang.String [^AbstractQueuedSynchronizer this]
    (-> this (.toString))))

(defn acquire-interruptibly
  "Acquires in exclusive mode, aborting if interrupted.
   Implemented by first checking interrupt status, then invoking
   at least once tryAcquire(int), returning on
   success.  Otherwise the thread is queued, possibly repeatedly
   blocking and unblocking, invoking tryAcquire(int)
   until success or the thread is interrupted.  This method can be
   used to implement method Lock.lockInterruptibly().

  arg - the acquire argument. This value is conveyed to tryAcquire(int) but is otherwise uninterpreted and can represent anything you like. - `int`

  throws: java.lang.InterruptedException - if the current thread is interrupted"
  ([^AbstractQueuedSynchronizer this ^Integer arg]
    (-> this (.acquireInterruptibly arg))))

(defn try-acquire-nanos
  "Attempts to acquire in exclusive mode, aborting if interrupted,
   and failing if the given timeout elapses.  Implemented by first
   checking interrupt status, then invoking at least once tryAcquire(int), returning on success.  Otherwise, the thread is
   queued, possibly repeatedly blocking and unblocking, invoking
   tryAcquire(int) until success or the thread is interrupted
   or the timeout elapses.  This method can be used to implement
   method Lock.tryLock(long, TimeUnit).

  arg - the acquire argument. This value is conveyed to tryAcquire(int) but is otherwise uninterpreted and can represent anything you like. - `int`
  nanos-timeout - the maximum number of nanoseconds to wait - `long`

  returns: true if acquired; false if timed out - `boolean`

  throws: java.lang.InterruptedException - if the current thread is interrupted"
  (^Boolean [^AbstractQueuedSynchronizer this ^Integer arg ^Long nanos-timeout]
    (-> this (.tryAcquireNanos arg nanos-timeout))))

(defn get-shared-queued-threads
  "Returns a collection containing threads that may be waiting to
   acquire in shared mode. This has the same properties
   as getQueuedThreads() except that it only returns
   those threads waiting due to a shared acquire.

  returns: the collection of threads - `java.util.Collection<java.lang.Thread>`"
  (^java.util.Collection [^AbstractQueuedSynchronizer this]
    (-> this (.getSharedQueuedThreads))))

(defn release-shared
  "Releases in shared mode.  Implemented by unblocking one or more
   threads if tryReleaseShared(int) returns true.

  arg - the release argument. This value is conveyed to tryReleaseShared(int) but is otherwise uninterpreted and can represent anything you like. - `int`

  returns: the value returned from tryReleaseShared(int) - `boolean`"
  (^Boolean [^AbstractQueuedSynchronizer this ^Integer arg]
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
  (^java.util.Collection [^AbstractQueuedSynchronizer this]
    (-> this (.getQueuedThreads))))

(defn acquire-shared-interruptibly
  "Acquires in shared mode, aborting if interrupted.  Implemented
   by first checking interrupt status, then invoking at least once
   tryAcquireShared(int), returning on success.  Otherwise the
   thread is queued, possibly repeatedly blocking and unblocking,
   invoking tryAcquireShared(int) until success or the thread
   is interrupted.

  arg - the acquire argument. This value is conveyed to tryAcquireShared(int) but is otherwise uninterpreted and can represent anything you like. - `int`

  throws: java.lang.InterruptedException - if the current thread is interrupted"
  ([^AbstractQueuedSynchronizer this ^Integer arg]
    (-> this (.acquireSharedInterruptibly arg))))

(defn get-exclusive-queued-threads
  "Returns a collection containing threads that may be waiting to
   acquire in exclusive mode. This has the same properties
   as getQueuedThreads() except that it only returns
   those threads waiting due to an exclusive acquire.

  returns: the collection of threads - `java.util.Collection<java.lang.Thread>`"
  (^java.util.Collection [^AbstractQueuedSynchronizer this]
    (-> this (.getExclusiveQueuedThreads))))

(defn has-queued-threads?
  "Queries whether any threads are waiting to acquire. Note that
   because cancellations due to interrupts and timeouts may occur
   at any time, a true return does not guarantee that any
   other thread will ever acquire.

   In this implementation, this operation returns in
   constant time.

  returns: true if there may be other threads waiting to acquire - `boolean`"
  (^Boolean [^AbstractQueuedSynchronizer this]
    (-> this (.hasQueuedThreads))))

(defn get-waiting-threads
  "Returns a collection containing those threads that may be
   waiting on the given condition associated with this
   synchronizer.  Because the actual set of threads may change
   dynamically while constructing this result, the returned
   collection is only a best-effort estimate. The elements of the
   returned collection are in no particular order.

  condition - the condition - `java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject`

  returns: the collection of threads - `java.util.Collection<java.lang.Thread>`

  throws: java.lang.IllegalMonitorStateException - if exclusive synchronization is not held"
  (^java.util.Collection [^AbstractQueuedSynchronizer this ^java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject condition]
    (-> this (.getWaitingThreads condition))))

(defn try-acquire-shared-nanos
  "Attempts to acquire in shared mode, aborting if interrupted, and
   failing if the given timeout elapses.  Implemented by first
   checking interrupt status, then invoking at least once tryAcquireShared(int), returning on success.  Otherwise, the
   thread is queued, possibly repeatedly blocking and unblocking,
   invoking tryAcquireShared(int) until success or the thread
   is interrupted or the timeout elapses.

  arg - the acquire argument. This value is conveyed to tryAcquireShared(int) but is otherwise uninterpreted and can represent anything you like. - `int`
  nanos-timeout - the maximum number of nanoseconds to wait - `long`

  returns: true if acquired; false if timed out - `boolean`

  throws: java.lang.InterruptedException - if the current thread is interrupted"
  (^Boolean [^AbstractQueuedSynchronizer this ^Integer arg ^Long nanos-timeout]
    (-> this (.tryAcquireSharedNanos arg nanos-timeout))))

(defn get-wait-queue-length
  "Returns an estimate of the number of threads waiting on the
   given condition associated with this synchronizer. Note that
   because timeouts and interrupts may occur at any time, the
   estimate serves only as an upper bound on the actual number of
   waiters.  This method is designed for use in monitoring of the
   system state, not for synchronization control.

  condition - the condition - `java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject`

  returns: the estimated number of waiting threads - `int`

  throws: java.lang.IllegalMonitorStateException - if exclusive synchronization is not held"
  (^Integer [^AbstractQueuedSynchronizer this ^java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject condition]
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
   Such a synchronizer's tryAcquire(int) method should return
   false, and its tryAcquireShared(int) method should
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
  (^Boolean [^AbstractQueuedSynchronizer this]
    (-> this (.hasQueuedPredecessors))))

(defn owns
  "Queries whether the given ConditionObject
   uses this synchronizer as its lock.

  condition - the condition - `java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject`

  returns: true if owned - `boolean`

  throws: java.lang.NullPointerException - if the condition is null"
  (^Boolean [^AbstractQueuedSynchronizer this ^java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject condition]
    (-> this (.owns condition))))

(defn acquire
  "Acquires in exclusive mode, ignoring interrupts.  Implemented
   by invoking at least once tryAcquire(int),
   returning on success.  Otherwise the thread is queued, possibly
   repeatedly blocking and unblocking, invoking tryAcquire(int) until success.  This method can be used
   to implement method Lock.lock().

  arg - the acquire argument. This value is conveyed to tryAcquire(int) but is otherwise uninterpreted and can represent anything you like. - `int`"
  ([^AbstractQueuedSynchronizer this ^Integer arg]
    (-> this (.acquire arg))))

(defn has-contended?
  "Queries whether any threads have ever contended to acquire this
   synchronizer; that is if an acquire method has ever blocked.

   In this implementation, this operation returns in
   constant time.

  returns: true if there has ever been contention - `boolean`"
  (^Boolean [^AbstractQueuedSynchronizer this]
    (-> this (.hasContended))))

