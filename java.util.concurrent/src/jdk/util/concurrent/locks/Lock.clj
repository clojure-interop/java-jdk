(ns jdk.util.concurrent.locks.Lock
  "Lock implementations provide more extensive locking
  operations than can be obtained using synchronized methods
  and statements.  They allow more flexible structuring, may have
  quite different properties, and may support multiple associated
  Condition objects.

  A lock is a tool for controlling access to a shared resource by
  multiple threads. Commonly, a lock provides exclusive access to a
  shared resource: only one thread at a time can acquire the lock and
  all access to the shared resource requires that the lock be
  acquired first. However, some locks may allow concurrent access to
  a shared resource, such as the read lock of a ReadWriteLock.

  The use of synchronized methods or statements provides
  access to the implicit monitor lock associated with every object, but
  forces all lock acquisition and release to occur in a block-structured way:
  when multiple locks are acquired they must be released in the opposite
  order, and all locks must be released in the same lexical scope in which
  they were acquired.

  While the scoping mechanism for synchronized methods
  and statements makes it much easier to program with monitor locks,
  and helps avoid many common programming errors involving locks,
  there are occasions where you need to work with locks in a more
  flexible way. For example, some algorithms for traversing
  concurrently accessed data structures require the use of
  `hand-over-hand` or `chain locking`: you
  acquire the lock of node A, then node B, then release A and acquire
  C, then release B and acquire D and so on.  Implementations of the
  Lock interface enable the use of such techniques by
  allowing a lock to be acquired and released in different scopes,
  and allowing multiple locks to be acquired and released in any
  order.

  With this increased flexibility comes additional
  responsibility. The absence of block-structured locking removes the
  automatic release of locks that occurs with synchronized
  methods and statements. In most cases, the following idiom
  should be used:



  Lock l = ...;
  l.lock();
  try {
    // access the resource protected by this lock
  } finally {
    l.unlock();
  }

  When locking and unlocking occur in different scopes, care must be
  taken to ensure that all code that is executed while the lock is
  held is protected by try-finally or try-catch to ensure that the
  lock is released when necessary.

  Lock implementations provide additional functionality
  over the use of synchronized methods and statements by
  providing a non-blocking attempt to acquire a lock (tryLock()), an attempt to acquire the lock that can be
  interrupted (lockInterruptibly(), and an attempt to acquire
  the lock that can timeout (tryLock(long, TimeUnit)).

  A Lock class can also provide behavior and semantics
  that is quite different from that of the implicit monitor lock,
  such as guaranteed ordering, non-reentrant usage, or deadlock
  detection. If an implementation provides such specialized semantics
  then the implementation must document those semantics.

  Note that Lock instances are just normal objects and can
  themselves be used as the target in a synchronized statement.
  Acquiring the
  monitor lock of a Lock instance has no specified relationship
  with invoking any of the lock() methods of that instance.
  It is recommended that to avoid confusion you never use Lock
  instances in this way, except within their own implementation.

  Except where noted, passing a null value for any
  parameter will result in a NullPointerException being
  thrown.

  Memory Synchronization

  All Lock implementations must enforce the same
  memory synchronization semantics as provided by the built-in monitor
  lock, as described in

  The Java Language Specification (17.4 Memory Model):

  A successful lock operation has the same memory
  synchronization effects as a successful Lock action.
  A successful unlock operation has the same
  memory synchronization effects as a successful Unlock action.


  Unsuccessful locking and unlocking operations, and reentrant
  locking/unlocking operations, do not require any memory
  synchronization effects.

  Implementation Considerations

  The three forms of lock acquisition (interruptible,
  non-interruptible, and timed) may differ in their performance
  characteristics, ordering guarantees, or other implementation
  qualities.  Further, the ability to interrupt the ongoing
  acquisition of a lock may not be available in a given Lock
  class.  Consequently, an implementation is not required to define
  exactly the same guarantees or semantics for all three forms of
  lock acquisition, nor is it required to support interruption of an
  ongoing lock acquisition.  An implementation is required to clearly
  document the semantics and guarantees provided by each of the
  locking methods. It must also obey the interruption semantics as
  defined in this interface, to the extent that interruption of lock
  acquisition is supported: which is either totally, or only on
  method entry.

  As interruption generally implies cancellation, and checks for
  interruption are often infrequent, an implementation can favor responding
  to an interrupt over normal method return. This is true even if it can be
  shown that the interrupt occurred after another action may have unblocked
  the thread. An implementation should document this behavior."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent.locks Lock]))

(defn lock
  "Acquires the lock.

   If the lock is not available then the current thread becomes
   disabled for thread scheduling purposes and lies dormant until the
   lock has been acquired.

   Implementation Considerations

   A Lock implementation may be able to detect erroneous use
   of the lock, such as an invocation that would cause deadlock, and
   may throw an (unchecked) exception in such circumstances.  The
   circumstances and the exception type must be documented by that
   Lock implementation."
  ([^java.util.concurrent.locks.Lock this]
    (-> this (.lock))))

(defn lock-interruptibly
  "Acquires the lock unless the current thread is
   interrupted.

   Acquires the lock if it is available and returns immediately.

   If the lock is not available then the current thread becomes
   disabled for thread scheduling purposes and lies dormant until
   one of two things happens:


   The lock is acquired by the current thread; or
   Some other thread interrupts the
   current thread, and interruption of lock acquisition is supported.


   If the current thread:

   has its interrupted status set on entry to this method; or
   is interrupted while acquiring the
   lock, and interruption of lock acquisition is supported,

   then InterruptedException is thrown and the current thread's
   interrupted status is cleared.

   Implementation Considerations

   The ability to interrupt a lock acquisition in some
   implementations may not be possible, and if possible may be an
   expensive operation.  The programmer should be aware that this
   may be the case. An implementation should document when this is
   the case.

   An implementation can favor responding to an interrupt over
   normal method return.

   A Lock implementation may be able to detect
   erroneous use of the lock, such as an invocation that would
   cause deadlock, and may throw an (unchecked) exception in such
   circumstances.  The circumstances and the exception type must
   be documented by that Lock implementation.

  throws: java.lang.InterruptedException - if the current thread is interrupted while acquiring the lock (and interruption of lock acquisition is supported)"
  ([^java.util.concurrent.locks.Lock this]
    (-> this (.lockInterruptibly))))

(defn try-lock
  "Acquires the lock if it is free within the given waiting time and the
   current thread has not been interrupted.

   If the lock is available this method returns immediately
   with the value true.
   If the lock is not available then
   the current thread becomes disabled for thread scheduling
   purposes and lies dormant until one of three things happens:

   The lock is acquired by the current thread; or
   Some other thread interrupts the
   current thread, and interruption of lock acquisition is supported; or
   The specified waiting time elapses


   If the lock is acquired then the value true is returned.

   If the current thread:

   has its interrupted status set on entry to this method; or
   is interrupted while acquiring
   the lock, and interruption of lock acquisition is supported,

   then InterruptedException is thrown and the current thread's
   interrupted status is cleared.

   If the specified waiting time elapses then the value false
   is returned.
   If the time is
   less than or equal to zero, the method will not wait at all.

   Implementation Considerations

   The ability to interrupt a lock acquisition in some implementations
   may not be possible, and if possible may
   be an expensive operation.
   The programmer should be aware that this may be the case. An
   implementation should document when this is the case.

   An implementation can favor responding to an interrupt over normal
   method return, or reporting a timeout.

   A Lock implementation may be able to detect
   erroneous use of the lock, such as an invocation that would cause
   deadlock, and may throw an (unchecked) exception in such circumstances.
   The circumstances and the exception type must be documented by that
   Lock implementation.

  time - the maximum time to wait for the lock - `long`
  unit - the time unit of the time argument - `java.util.concurrent.TimeUnit`

  returns: true if the lock was acquired and false
           if the waiting time elapsed before the lock was acquired - `boolean`

  throws: java.lang.InterruptedException - if the current thread is interrupted while acquiring the lock (and interruption of lock acquisition is supported)"
  (^Boolean [^java.util.concurrent.locks.Lock this ^Long time ^java.util.concurrent.TimeUnit unit]
    (-> this (.tryLock time unit)))
  (^Boolean [^java.util.concurrent.locks.Lock this]
    (-> this (.tryLock))))

(defn unlock
  "Releases the lock.

   Implementation Considerations

   A Lock implementation will usually impose
   restrictions on which thread can release a lock (typically only the
   holder of the lock can release it) and may throw
   an (unchecked) exception if the restriction is violated.
   Any restrictions and the exception
   type must be documented by that Lock implementation."
  ([^java.util.concurrent.locks.Lock this]
    (-> this (.unlock))))

(defn new-condition
  "Returns a new Condition instance that is bound to this
   Lock instance.

   Before waiting on the condition the lock must be held by the
   current thread.
   A call to Condition.await() will atomically release the lock
   before waiting and re-acquire the lock before the wait returns.

   Implementation Considerations

   The exact operation of the Condition instance depends on
   the Lock implementation and must be documented by that
   implementation.

  returns: A new Condition instance for this Lock instance - `java.util.concurrent.locks.Condition`

  throws: java.lang.UnsupportedOperationException - if this Lock implementation does not support conditions"
  (^java.util.concurrent.locks.Condition [^java.util.concurrent.locks.Lock this]
    (-> this (.newCondition))))

