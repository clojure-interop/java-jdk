(ns jdk.util.concurrent.locks.LockSupport
  "Basic thread blocking primitives for creating locks and other
  synchronization classes.

  This class associates, with each thread that uses it, a permit
  (in the sense of the Semaphore class). A call to park will return immediately
  if the permit is available, consuming it in the process; otherwise
  it may block.  A call to unpark makes the permit
  available, if it was not already available. (Unlike with Semaphores
  though, permits do not accumulate. There is at most one.)

  Methods park and unpark provide efficient
  means of blocking and unblocking threads that do not encounter the
  problems that cause the deprecated methods Thread.suspend
  and Thread.resume to be unusable for such purposes: Races
  between one thread invoking park and another thread trying
  to unpark it will preserve liveness, due to the
  permit. Additionally, park will return if the caller's
  thread was interrupted, and timeout versions are supported. The
  park method may also return at any other time, for `no
  reason`, so in general must be invoked within a loop that rechecks
  conditions upon return. In this sense park serves as an
  optimization of a `busy wait` that does not waste as much time
  spinning, but must be paired with an unpark to be
  effective.

  The three forms of park each also support a
  blocker object parameter. This object is recorded while
  the thread is blocked to permit monitoring and diagnostic tools to
  identify the reasons that threads are blocked. (Such tools may
  access blockers using method getBlocker(Thread).)
  The use of these forms rather than the original forms without this
  parameter is strongly encouraged. The normal argument to supply as
  a blocker within a lock implementation is this.

  These methods are designed to be used as tools for creating
  higher-level synchronization utilities, and are not in themselves
  useful for most concurrency control applications.  The park
  method is designed for use only in constructions of the form:



  while (!canProceed()) { ... LockSupport.park(this); }

  where neither canProceed nor any other actions prior to the
  call to park entail locking or blocking.  Because only one
  permit is associated with each thread, any intermediary uses of
  park could interfere with its intended effects.

  Sample Usage. Here is a sketch of a first-in-first-out
  non-reentrant lock class:


  class FIFOMutex {
    private final AtomicBoolean locked = new AtomicBoolean(false);
    private final Queue<Thread> waiters
      = new ConcurrentLinkedQueue<Thread>();

    public void lock() {
      boolean wasInterrupted = false;
      Thread current = Thread.currentThread();
      waiters.add(current);

      // Block while not first in queue or cannot acquire lock
      while (waiters.peek() != current ||
             !locked.compareAndSet(false, true)) {
        LockSupport.park(this);
        if (Thread.interrupted()) // ignore interrupts while waiting
          wasInterrupted = true;
      }

      waiters.remove();
      if (wasInterrupted)          // reassert interrupt status on exit
        current.interrupt();
    }

    public void unlock() {
      locked.set(false);
      LockSupport.unpark(waiters.peek());
    }
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent.locks LockSupport]))

(defn *unpark
  "Makes available the permit for the given thread, if it
   was not already available.  If the thread was blocked on
   park then it will unblock.  Otherwise, its next call
   to park is guaranteed not to block. This operation
   is not guaranteed to have any effect at all if the given
   thread has not been started.

  thread - the thread to unpark, or null, in which case this operation has no effect - `java.lang.Thread`"
  ([^java.lang.Thread thread]
    (LockSupport/unpark thread)))

(defn *park
  "Disables the current thread for thread scheduling purposes unless the
   permit is available.

   If the permit is available then it is consumed and the call returns
   immediately; otherwise
   the current thread becomes disabled for thread scheduling
   purposes and lies dormant until one of three things happens:


   Some other thread invokes unpark with the
   current thread as the target; or

   Some other thread interrupts
   the current thread; or

   The call spuriously (that is, for no reason) returns.


   This method does not report which of these caused the
   method to return. Callers should re-check the conditions which caused
   the thread to park in the first place. Callers may also determine,
   for example, the interrupt status of the thread upon return.

  blocker - the synchronization object responsible for this thread parking - `java.lang.Object`"
  ([^java.lang.Object blocker]
    (LockSupport/park blocker))
  ([]
    (LockSupport/park )))

(defn *park-nanos
  "Disables the current thread for thread scheduling purposes, for up to
   the specified waiting time, unless the permit is available.

   If the permit is available then it is consumed and the call
   returns immediately; otherwise the current thread becomes disabled
   for thread scheduling purposes and lies dormant until one of four
   things happens:


   Some other thread invokes unpark with the
   current thread as the target; or

   Some other thread interrupts
   the current thread; or

   The specified waiting time elapses; or

   The call spuriously (that is, for no reason) returns.


   This method does not report which of these caused the
   method to return. Callers should re-check the conditions which caused
   the thread to park in the first place. Callers may also determine,
   for example, the interrupt status of the thread, or the elapsed time
   upon return.

  blocker - the synchronization object responsible for this thread parking - `java.lang.Object`
  nanos - the maximum number of nanoseconds to wait - `long`"
  ([^java.lang.Object blocker ^Long nanos]
    (LockSupport/parkNanos blocker nanos))
  ([^Long nanos]
    (LockSupport/parkNanos nanos)))

(defn *park-until
  "Disables the current thread for thread scheduling purposes, until
   the specified deadline, unless the permit is available.

   If the permit is available then it is consumed and the call
   returns immediately; otherwise the current thread becomes disabled
   for thread scheduling purposes and lies dormant until one of four
   things happens:


   Some other thread invokes unpark with the
   current thread as the target; or

   Some other thread interrupts the
   current thread; or

   The specified deadline passes; or

   The call spuriously (that is, for no reason) returns.


   This method does not report which of these caused the
   method to return. Callers should re-check the conditions which caused
   the thread to park in the first place. Callers may also determine,
   for example, the interrupt status of the thread, or the current time
   upon return.

  blocker - the synchronization object responsible for this thread parking - `java.lang.Object`
  deadline - the absolute time, in milliseconds from the Epoch, to wait until - `long`"
  ([^java.lang.Object blocker ^Long deadline]
    (LockSupport/parkUntil blocker deadline))
  ([^Long deadline]
    (LockSupport/parkUntil deadline)))

(defn *get-blocker
  "Returns the blocker object supplied to the most recent
   invocation of a park method that has not yet unblocked, or null
   if not blocked.  The value returned is just a momentary
   snapshot -- the thread may have since unblocked or blocked on a
   different blocker object.

  t - the thread - `java.lang.Thread`

  returns: the blocker - `java.lang.Object`

  throws: java.lang.NullPointerException - if argument is null"
  (^java.lang.Object [^java.lang.Thread t]
    (LockSupport/getBlocker t)))

