(ns jdk.util.concurrent.locks.ReentrantReadWriteLock$WriteLock
  "The lock returned by method ReentrantReadWriteLock.writeLock()."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent.locks ReentrantReadWriteLock$WriteLock]))

(defn lock
  "Acquires the write lock.

   Acquires the write lock if neither the read nor write lock
   are held by another thread
   and returns immediately, setting the write lock hold count to
   one.

   If the current thread already holds the write lock then the
   hold count is incremented by one and the method returns
   immediately.

   If the lock is held by another thread then the current
   thread becomes disabled for thread scheduling purposes and
   lies dormant until the write lock has been acquired, at which
   time the write lock hold count is set to one."
  ([^java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock this]
    (-> this (.lock))))

(defn lock-interruptibly
  "Acquires the write lock unless the current thread is
   interrupted.

   Acquires the write lock if neither the read nor write lock
   are held by another thread
   and returns immediately, setting the write lock hold count to
   one.

   If the current thread already holds this lock then the
   hold count is incremented by one and the method returns
   immediately.

   If the lock is held by another thread then the current
   thread becomes disabled for thread scheduling purposes and
   lies dormant until one of two things happens:



   The write lock is acquired by the current thread; or

   Some other thread interrupts
   the current thread.



   If the write lock is acquired by the current thread then the
   lock hold count is set to one.

   If the current thread:



   has its interrupted status set on entry to this method;
   or

   is interrupted while
   acquiring the write lock,



   then InterruptedException is thrown and the current
   thread's interrupted status is cleared.

   In this implementation, as this method is an explicit
   interruption point, preference is given to responding to
   the interrupt over normal or reentrant acquisition of the
   lock.

  throws: java.lang.InterruptedException - if the current thread is interrupted"
  ([^java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock this]
    (-> this (.lockInterruptibly))))

(defn try-lock
  "Acquires the write lock if it is not held by another thread
   within the given waiting time and the current thread has
   not been interrupted.

   Acquires the write lock if neither the read nor write lock
   are held by another thread
   and returns immediately with the value true,
   setting the write lock hold count to one. If this lock has been
   set to use a fair ordering policy then an available lock
   will not be acquired if any other threads are
   waiting for the write lock. This is in contrast to the tryLock() method. If you want a timed tryLock
   that does permit barging on a fair lock then combine the
   timed and un-timed forms together:



   if (lock.tryLock() ||
       lock.tryLock(timeout, unit)) {
     ...
   }

   If the current thread already holds this lock then the
   hold count is incremented by one and the method returns
   true.

   If the lock is held by another thread then the current
   thread becomes disabled for thread scheduling purposes and
   lies dormant until one of three things happens:



   The write lock is acquired by the current thread; or

   Some other thread interrupts
   the current thread; or

   The specified waiting time elapses



   If the write lock is acquired then the value true is
   returned and the write lock hold count is set to one.

   If the current thread:



   has its interrupted status set on entry to this method;
   or

   is interrupted while
   acquiring the write lock,



   then InterruptedException is thrown and the current
   thread's interrupted status is cleared.

   If the specified waiting time elapses then the value
   false is returned.  If the time is less than or
   equal to zero, the method will not wait at all.

   In this implementation, as this method is an explicit
   interruption point, preference is given to responding to
   the interrupt over normal or reentrant acquisition of the
   lock, and over reporting the elapse of the waiting time.

  timeout - the time to wait for the write lock - `long`
  unit - the time unit of the timeout argument - `java.util.concurrent.TimeUnit`

  returns: true if the lock was free and was acquired
   by the current thread, or the write lock was already held by the
   current thread; and false if the waiting time
   elapsed before the lock could be acquired. - `boolean`

  throws: java.lang.InterruptedException - if the current thread is interrupted"
  ([^java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.tryLock timeout unit)))
  ([^java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock this]
    (-> this (.tryLock))))

(defn unlock
  "Attempts to release this lock.

   If the current thread is the holder of this lock then
   the hold count is decremented. If the hold count is now
   zero then the lock is released.  If the current thread is
   not the holder of this lock then IllegalMonitorStateException is thrown.

  throws: java.lang.IllegalMonitorStateException - if the current thread does not hold this lock"
  ([^java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock this]
    (-> this (.unlock))))

(defn new-condition
  "Returns a Condition instance for use with this
   Lock instance.
   The returned Condition instance supports the same
   usages as do the Object monitor methods (wait, notify, and notifyAll) when used with the built-in
   monitor lock.



   If this write lock is not held when any Condition method is called then an IllegalMonitorStateException is thrown.  (Read locks are
   held independently of write locks, so are not checked or
   affected. However it is essentially always an error to
   invoke a condition waiting method when the current thread
   has also acquired read locks, since other threads that
   could unblock it will not be able to acquire the write
   lock.)

   When the condition waiting
   methods are called the write lock is released and, before
   they return, the write lock is reacquired and the lock hold
   count restored to what it was when the method was called.

   If a thread is interrupted while
   waiting then the wait will terminate, an InterruptedException will be thrown, and the thread's
   interrupted status will be cleared.

    Waiting threads are signalled in FIFO order.

   The ordering of lock reacquisition for threads returning
   from waiting methods is the same as for threads initially
   acquiring the lock, which is in the default case not specified,
   but for fair locks favors those threads that have been
   waiting the longest.

  returns: the Condition object - `java.util.concurrent.locks.Condition`"
  ([^java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock this]
    (-> this (.newCondition))))

(defn to-string
  "Returns a string identifying this lock, as well as its lock
   state.  The state, in brackets includes either the String
   `Unlocked` or the String `Locked by`
   followed by the name of the owning thread.

  returns: a string identifying this lock, as well as its lock state - `java.lang.String`"
  ([^java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock this]
    (-> this (.toString))))

(defn held-by-current-thread?
  "Queries if this write lock is held by the current thread.
   Identical in effect to ReentrantReadWriteLock.isWriteLockedByCurrentThread().

  returns: true if the current thread holds this lock and
           false otherwise - `boolean`"
  ([^java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock this]
    (-> this (.isHeldByCurrentThread))))

(defn get-hold-count
  "Queries the number of holds on this write lock by the current
   thread.  A thread has a hold on a lock for each lock action
   that is not matched by an unlock action.  Identical in effect
   to ReentrantReadWriteLock.getWriteHoldCount().

  returns: the number of holds on this lock by the current thread,
           or zero if this lock is not held by the current thread - `int`"
  ([^java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock this]
    (-> this (.getHoldCount))))

