(ns jdk.util.concurrent.locks.ReentrantReadWriteLock$ReadLock
  "The lock returned by method ReentrantReadWriteLock.readLock()."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent.locks ReentrantReadWriteLock$ReadLock]))

(defn lock
  "Acquires the read lock.

   Acquires the read lock if the write lock is not held by
   another thread and returns immediately.

   If the write lock is held by another thread then
   the current thread becomes disabled for thread scheduling
   purposes and lies dormant until the read lock has been acquired."
  ([^java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock this]
    (-> this (.lock))))

(defn lock-interruptibly
  "Acquires the read lock unless the current thread is
   interrupted.

   Acquires the read lock if the write lock is not held
   by another thread and returns immediately.

   If the write lock is held by another thread then the
   current thread becomes disabled for thread scheduling
   purposes and lies dormant until one of two things happens:



   The read lock is acquired by the current thread; or

   Some other thread interrupts
   the current thread.



   If the current thread:



   has its interrupted status set on entry to this method; or

   is interrupted while
   acquiring the read lock,



   then InterruptedException is thrown and the current
   thread's interrupted status is cleared.

   In this implementation, as this method is an explicit
   interruption point, preference is given to responding to
   the interrupt over normal or reentrant acquisition of the
   lock.

  throws: java.lang.InterruptedException - if the current thread is interrupted"
  ([^java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock this]
    (-> this (.lockInterruptibly))))

(defn try-lock
  "Acquires the read lock if the write lock is not held by
   another thread within the given waiting time and the
   current thread has not been interrupted.

   Acquires the read lock if the write lock is not held by
   another thread and returns immediately with the value
   true. If this lock has been set to use a fair
   ordering policy then an available lock will not be
   acquired if any other threads are waiting for the
   lock. This is in contrast to the tryLock()
   method. If you want a timed tryLock that does
   permit barging on a fair lock then combine the timed and
   un-timed forms together:



   if (lock.tryLock() ||
       lock.tryLock(timeout, unit)) {
     ...
   }

   If the write lock is held by another thread then the
   current thread becomes disabled for thread scheduling
   purposes and lies dormant until one of three things happens:



   The read lock is acquired by the current thread; or

   Some other thread interrupts
   the current thread; or

   The specified waiting time elapses.



   If the read lock is acquired then the value true is
   returned.

   If the current thread:



   has its interrupted status set on entry to this method; or

   is interrupted while
   acquiring the read lock,

    then InterruptedException is thrown and the
   current thread's interrupted status is cleared.

   If the specified waiting time elapses then the value
   false is returned.  If the time is less than or
   equal to zero, the method will not wait at all.

   In this implementation, as this method is an explicit
   interruption point, preference is given to responding to
   the interrupt over normal or reentrant acquisition of the
   lock, and over reporting the elapse of the waiting time.

  timeout - the time to wait for the read lock - `long`
  unit - the time unit of the timeout argument - `java.util.concurrent.TimeUnit`

  returns: true if the read lock was acquired - `boolean`

  throws: java.lang.InterruptedException - if the current thread is interrupted"
  (^Boolean [^java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.tryLock timeout unit)))
  (^Boolean [^java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock this]
    (-> this (.tryLock))))

(defn unlock
  "Attempts to release this lock.

   If the number of readers is now zero then the lock
   is made available for write lock attempts."
  ([^java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock this]
    (-> this (.unlock))))

(defn new-condition
  "Throws UnsupportedOperationException because
   ReadLocks do not support conditions.

  returns: A new Condition instance for this Lock instance - `java.util.concurrent.locks.Condition`

  throws: java.lang.UnsupportedOperationException - always"
  (^java.util.concurrent.locks.Condition [^java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock this]
    (-> this (.newCondition))))

(defn to-string
  "Returns a string identifying this lock, as well as its lock state.
   The state, in brackets, includes the String `Read locks =`
   followed by the number of held read locks.

  returns: a string identifying this lock, as well as its lock state - `java.lang.String`"
  (^java.lang.String [^java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock this]
    (-> this (.toString))))

