(ns jdk.util.concurrent.locks.ReentrantLock
  "A reentrant mutual exclusion Lock with the same basic
  behavior and semantics as the implicit monitor lock accessed using
  synchronized methods and statements, but with extended
  capabilities.

  A ReentrantLock is owned by the thread last
  successfully locking, but not yet unlocking it. A thread invoking
  lock will return, successfully acquiring the lock, when
  the lock is not owned by another thread. The method will return
  immediately if the current thread already owns the lock. This can
  be checked using methods isHeldByCurrentThread(), and getHoldCount().

  The constructor for this class accepts an optional
  fairness parameter.  When set true, under
  contention, locks favor granting access to the longest-waiting
  thread.  Otherwise this lock does not guarantee any particular
  access order.  Programs using fair locks accessed by many threads
  may display lower overall throughput (i.e., are slower; often much
  slower) than those using the default setting, but have smaller
  variances in times to obtain locks and guarantee lack of
  starvation. Note however, that fairness of locks does not guarantee
  fairness of thread scheduling. Thus, one of many threads using a
  fair lock may obtain it multiple times in succession while other
  active threads are not progressing and not currently holding the
  lock.
  Also note that the untimed tryLock() method does not
  honor the fairness setting. It will succeed if the lock
  is available even if other threads are waiting.

  It is recommended practice to always immediately
  follow a call to lock with a try block, most
  typically in a before/after construction such as:



  class X {
    private final ReentrantLock lock = new ReentrantLock();
    // ...

    public void m() {
      lock.lock();  // block until condition holds
      try {
        // ... method body
      } finally {
        lock.unlock()
      }
    }
  }

  In addition to implementing the Lock interface, this
  class defines a number of public and protected
  methods for inspecting the state of the lock.  Some of these
  methods are only useful for instrumentation and monitoring.

  Serialization of this class behaves in the same way as built-in
  locks: a deserialized lock is in the unlocked state, regardless of
  its state when serialized.

  This lock supports a maximum of 2147483647 recursive locks by
  the same thread. Attempts to exceed this limit result in
  Error throws from locking methods."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent.locks ReentrantLock]))

(defn ->reentrant-lock
  "Constructor.

  Creates an instance of ReentrantLock with the
   given fairness policy.

  fair - true if this lock should use a fair ordering policy - `boolean`"
  ([fair]
    (new ReentrantLock fair))
  ([]
    (new ReentrantLock )))

(defn locked?
  "Queries if this lock is held by any thread. This method is
   designed for use in monitoring of the system state,
   not for synchronization control.

  returns: true if any thread holds this lock and
           false otherwise - `boolean`"
  ([this]
    (-> this (.isLocked))))

(defn fair?
  "Returns true if this lock has fairness set true.

  returns: true if this lock has fairness set true - `boolean`"
  ([this]
    (-> this (.isFair))))

(defn try-lock
  "Acquires the lock if it is not held by another thread within the given
   waiting time and the current thread has not been
   interrupted.

   Acquires the lock if it is not held by another thread and returns
   immediately with the value true, setting the lock hold count
   to one. If this lock has been set to use a fair ordering policy then
   an available lock will not be acquired if any other threads
   are waiting for the lock. This is in contrast to the tryLock()
   method. If you want a timed tryLock that does permit barging on
   a fair lock then combine the timed and un-timed forms together:



   if (lock.tryLock() ||
       lock.tryLock(timeout, unit)) {
     ...
   }

   If the current thread
   already holds this lock then the hold count is incremented by one and
   the method returns true.

   If the lock is held by another thread then the
   current thread becomes disabled for thread scheduling
   purposes and lies dormant until one of three things happens:



   The lock is acquired by the current thread; or

   Some other thread interrupts
   the current thread; or

   The specified waiting time elapses



   If the lock is acquired then the value true is returned and
   the lock hold count is set to one.

   If the current thread:



   has its interrupted status set on entry to this method; or

   is interrupted while
   acquiring the lock,


   then InterruptedException is thrown and the current thread's
   interrupted status is cleared.

   If the specified waiting time elapses then the value false
   is returned.  If the time is less than or equal to zero, the method
   will not wait at all.

   In this implementation, as this method is an explicit
   interruption point, preference is given to responding to the
   interrupt over normal or reentrant acquisition of the lock, and
   over reporting the elapse of the waiting time.

  timeout - the time to wait for the lock - `long`
  unit - the time unit of the timeout argument - `java.util.concurrent.TimeUnit`

  returns: true if the lock was free and was acquired by the
           current thread, or the lock was already held by the current
           thread; and false if the waiting time elapsed before
           the lock could be acquired - `boolean`

  throws: java.lang.InterruptedException - if the current thread is interrupted"
  ([this timeout unit]
    (-> this (.tryLock timeout unit)))
  ([this]
    (-> this (.tryLock))))

(defn get-queue-length
  "Returns an estimate of the number of threads waiting to
   acquire this lock.  The value is only an estimate because the number of
   threads may change dynamically while this method traverses
   internal data structures.  This method is designed for use in
   monitoring of the system state, not for synchronization
   control.

  returns: the estimated number of threads waiting for this lock - `int`"
  ([this]
    (-> this (.getQueueLength))))

(defn unlock
  "Attempts to release this lock.

   If the current thread is the holder of this lock then the hold
   count is decremented.  If the hold count is now zero then the lock
   is released.  If the current thread is not the holder of this
   lock then IllegalMonitorStateException is thrown.

  throws: java.lang.IllegalMonitorStateException - if the current thread does not hold this lock"
  ([this]
    (-> this (.unlock))))

(defn has-waiters?
  "Queries whether any threads are waiting on the given condition
   associated with this lock. Note that because timeouts and
   interrupts may occur at any time, a true return does
   not guarantee that a future signal will awaken any
   threads.  This method is designed primarily for use in
   monitoring of the system state.

  condition - the condition - `java.util.concurrent.locks.Condition`

  returns: true if there are any waiting threads - `boolean`

  throws: java.lang.IllegalMonitorStateException - if this lock is not held"
  ([this condition]
    (-> this (.hasWaiters condition))))

(defn new-condition
  "Returns a Condition instance for use with this
   Lock instance.

   The returned Condition instance supports the same
   usages as do the Object monitor methods (wait, notify, and notifyAll) when used with the built-in
   monitor lock.



   If this lock is not held when any of the Condition
   waiting or signalling methods are called, then an IllegalMonitorStateException is thrown.

   When the condition waiting
   methods are called the lock is released and, before they
   return, the lock is reacquired and the lock hold count restored
   to what it was when the method was called.

   If a thread is interrupted
   while waiting then the wait will terminate, an InterruptedException will be thrown, and the thread's
   interrupted status will be cleared.

    Waiting threads are signalled in FIFO order.

   The ordering of lock reacquisition for threads returning
   from waiting methods is the same as for threads initially
   acquiring the lock, which is in the default case not specified,
   but for fair locks favors those threads that have been
   waiting the longest.

  returns: the Condition object - `java.util.concurrent.locks.Condition`"
  ([this]
    (-> this (.newCondition))))

(defn to-string
  "Returns a string identifying this lock, as well as its lock state.
   The state, in brackets, includes either the String `Unlocked`
   or the String `Locked by` followed by the
   name of the owning thread.

  returns: a string identifying this lock, as well as its lock state - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn lock-interruptibly
  "Acquires the lock unless the current thread is
   interrupted.

   Acquires the lock if it is not held by another thread and returns
   immediately, setting the lock hold count to one.

   If the current thread already holds this lock then the hold count
   is incremented by one and the method returns immediately.

   If the lock is held by another thread then the
   current thread becomes disabled for thread scheduling
   purposes and lies dormant until one of two things happens:



   The lock is acquired by the current thread; or

   Some other thread interrupts the
   current thread.



   If the lock is acquired by the current thread then the lock hold
   count is set to one.

   If the current thread:



   has its interrupted status set on entry to this method; or

   is interrupted while acquiring
   the lock,



   then InterruptedException is thrown and the current thread's
   interrupted status is cleared.

   In this implementation, as this method is an explicit
   interruption point, preference is given to responding to the
   interrupt over normal or reentrant acquisition of the lock.

  throws: java.lang.InterruptedException - if the current thread is interrupted"
  ([this]
    (-> this (.lockInterruptibly))))

(defn has-queued-threads?
  "Queries whether any threads are waiting to acquire this lock. Note that
   because cancellations may occur at any time, a true
   return does not guarantee that any other thread will ever
   acquire this lock.  This method is designed primarily for use in
   monitoring of the system state.

  returns: true if there may be other threads waiting to
           acquire the lock - `boolean`"
  ([this]
    (-> this (.hasQueuedThreads))))

(defn lock
  "Acquires the lock.

   Acquires the lock if it is not held by another thread and returns
   immediately, setting the lock hold count to one.

   If the current thread already holds the lock then the hold
   count is incremented by one and the method returns immediately.

   If the lock is held by another thread then the
   current thread becomes disabled for thread scheduling
   purposes and lies dormant until the lock has been acquired,
   at which time the lock hold count is set to one."
  ([this]
    (-> this (.lock))))

(defn has-queued-thread?
  "Queries whether the given thread is waiting to acquire this
   lock. Note that because cancellations may occur at any time, a
   true return does not guarantee that this thread
   will ever acquire this lock.  This method is designed primarily for use
   in monitoring of the system state.

  thread - the thread - `java.lang.Thread`

  returns: true if the given thread is queued waiting for this lock - `boolean`

  throws: java.lang.NullPointerException - if the thread is null"
  ([this thread]
    (-> this (.hasQueuedThread thread))))

(defn get-wait-queue-length
  "Returns an estimate of the number of threads waiting on the
   given condition associated with this lock. Note that because
   timeouts and interrupts may occur at any time, the estimate
   serves only as an upper bound on the actual number of waiters.
   This method is designed for use in monitoring of the system
   state, not for synchronization control.

  condition - the condition - `java.util.concurrent.locks.Condition`

  returns: the estimated number of waiting threads - `int`

  throws: java.lang.IllegalMonitorStateException - if this lock is not held"
  ([this condition]
    (-> this (.getWaitQueueLength condition))))

(defn held-by-current-thread?
  "Queries if this lock is held by the current thread.

   Analogous to the Thread.holdsLock(Object) method for
   built-in monitor locks, this method is typically used for
   debugging and testing. For example, a method that should only be
   called while a lock is held can assert that this is the case:



   class X {
     ReentrantLock lock = new ReentrantLock();
     // ...

     public void m() {
         assert lock.isHeldByCurrentThread();
         // ... method body
     }
   }

   It can also be used to ensure that a reentrant lock is used
   in a non-reentrant manner, for example:



   class X {
     ReentrantLock lock = new ReentrantLock();
     // ...

     public void m() {
         assert !lock.isHeldByCurrentThread();
         lock.lock();
         try {
             // ... method body
         } finally {
             lock.unlock();
         }
     }
   }

  returns: true if current thread holds this lock and
           false otherwise - `boolean`"
  ([this]
    (-> this (.isHeldByCurrentThread))))

(defn get-hold-count
  "Queries the number of holds on this lock by the current thread.

   A thread has a hold on a lock for each lock action that is not
   matched by an unlock action.

   The hold count information is typically only used for testing and
   debugging purposes. For example, if a certain section of code should
   not be entered with the lock already held then we can assert that
   fact:



   class X {
     ReentrantLock lock = new ReentrantLock();
     // ...
     public void m() {
       assert lock.getHoldCount() == 0;
       lock.lock();
       try {
         // ... method body
       } finally {
         lock.unlock();
       }
     }
   }

  returns: the number of holds on this lock by the current thread,
           or zero if this lock is not held by the current thread - `int`"
  ([this]
    (-> this (.getHoldCount))))

