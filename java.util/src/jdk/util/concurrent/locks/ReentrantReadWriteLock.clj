(ns jdk.util.concurrent.locks.ReentrantReadWriteLock
  "An implementation of ReadWriteLock supporting similar
  semantics to ReentrantLock.
  This class has the following properties:


  Acquisition order

  This class does not impose a reader or writer preference
  ordering for lock access.  However, it does support an optional
  fairness policy.


  Non-fair mode (default)
  When constructed as non-fair (the default), the order of entry
  to the read and write lock is unspecified, subject to reentrancy
  constraints.  A nonfair lock that is continuously contended may
  indefinitely postpone one or more reader or writer threads, but
  will normally have higher throughput than a fair lock.

  Fair mode
  When constructed as fair, threads contend for entry using an
  approximately arrival-order policy. When the currently held lock
  is released, either the longest-waiting single writer thread will
  be assigned the write lock, or if there is a group of reader threads
  waiting longer than all waiting writer threads, that group will be
  assigned the read lock.

  A thread that tries to acquire a fair read lock (non-reentrantly)
  will block if either the write lock is held, or there is a waiting
  writer thread. The thread will not acquire the read lock until
  after the oldest currently waiting writer thread has acquired and
  released the write lock. Of course, if a waiting writer abandons
  its wait, leaving one or more reader threads as the longest waiters
  in the queue with the write lock free, then those readers will be
  assigned the read lock.

  A thread that tries to acquire a fair write lock (non-reentrantly)
  will block unless both the read lock and write lock are free (which
  implies there are no waiting threads).  (Note that the non-blocking
  ReentrantReadWriteLock.ReadLock.tryLock() and ReentrantReadWriteLock.WriteLock.tryLock() methods
  do not honor this fair setting and will immediately acquire the lock
  if it is possible, regardless of waiting threads.)



  Reentrancy

  This lock allows both readers and writers to reacquire read or
  write locks in the style of a ReentrantLock. Non-reentrant
  readers are not allowed until all write locks held by the writing
  thread have been released.

  Additionally, a writer can acquire the read lock, but not
  vice-versa.  Among other applications, reentrancy can be useful
  when write locks are held during calls or callbacks to methods that
  perform reads under read locks.  If a reader tries to acquire the
  write lock it will never succeed.

  Lock downgrading
  Reentrancy also allows downgrading from the write lock to a read lock,
  by acquiring the write lock, then the read lock and then releasing the
  write lock. However, upgrading from a read lock to the write lock is
  not possible.

  Interruption of lock acquisition
  The read lock and write lock both support interruption during lock
  acquisition.

  Condition support
  The write lock provides a Condition implementation that
  behaves in the same way, with respect to the write lock, as the
  Condition implementation provided by
  ReentrantLock.newCondition() does for ReentrantLock.
  This Condition can, of course, only be used with the write lock.

  The read lock does not support a Condition and
  readLock().newCondition() throws
  UnsupportedOperationException.

  Instrumentation
  This class supports methods to determine whether locks
  are held or contended. These methods are designed for monitoring
  system state, not for synchronization control.


  Serialization of this class behaves in the same way as built-in
  locks: a deserialized lock is in the unlocked state, regardless of
  its state when serialized.

  Sample usages. Here is a code sketch showing how to perform
  lock downgrading after updating a cache (exception handling is
  particularly tricky when handling multiple locks in a non-nested
  fashion):



  class CachedData {
    Object data;
    volatile boolean cacheValid;
    final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    void processCachedData() {
      rwl.readLock().lock();
      if (!cacheValid) {
        // Must release read lock before acquiring write lock
        rwl.readLock().unlock();
        rwl.writeLock().lock();
        try {
          // Recheck state because another thread might have
          // acquired write lock and changed state before we did.
          if (!cacheValid) {
            data = ...
            cacheValid = true;
          }
          // Downgrade by acquiring read lock before releasing write lock
          rwl.readLock().lock();
        } finally {
          rwl.writeLock().unlock(); // Unlock write, still hold read
        }
      }

      try {
        use(data);
      } finally {
        rwl.readLock().unlock();
      }
    }
  }

  ReentrantReadWriteLocks can be used to improve concurrency in some
  uses of some kinds of Collections. This is typically worthwhile
  only when the collections are expected to be large, accessed by
  more reader threads than writer threads, and entail operations with
  overhead that outweighs synchronization overhead. For example, here
  is a class using a TreeMap that is expected to be large and
  concurrently accessed.



  class RWDictionary {
    private final Map<String, Data> m = new TreeMap<String, Data>();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    public Data get(String key) {
      r.lock();
      try { return m.get(key); }
      finally { r.unlock(); }
    }
    public String[] allKeys() {
      r.lock();
      try { return m.keySet().toArray(); }
      finally { r.unlock(); }
    }
    public Data put(String key, Data value) {
      w.lock();
      try { return m.put(key, value); }
      finally { w.unlock(); }
    }
    public void clear() {
      w.lock();
      try { m.clear(); }
      finally { w.unlock(); }
    }
  }

  Implementation Notes

  This lock supports a maximum of 65535 recursive write locks
  and 65535 read locks. Attempts to exceed these limits result in
  Error throws from locking methods."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent.locks ReentrantReadWriteLock]))

(defn ->reentrant-read-write-lock
  "Constructor.

  Creates a new ReentrantReadWriteLock with
   the given fairness policy.

  fair - true if this lock should use a fair ordering policy - `boolean`"
  ([fair]
    (new ReentrantReadWriteLock fair))
  ([]
    (new ReentrantReadWriteLock )))

(defn write-lock
  "Description copied from interface: ReadWriteLock

  returns: the lock used for writing - `java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock`"
  ([this]
    (-> this (.writeLock))))

(defn fair?
  "Returns true if this lock has fairness set true.

  returns: true if this lock has fairness set true - `boolean`"
  ([this]
    (-> this (.isFair))))

(defn get-queue-length
  "Returns an estimate of the number of threads waiting to acquire
   either the read or write lock.  The value is only an estimate
   because the number of threads may change dynamically while this
   method traverses internal data structures.  This method is
   designed for use in monitoring of the system state, not for
   synchronization control.

  returns: the estimated number of threads waiting for this lock - `int`"
  ([this]
    (-> this (.getQueueLength))))

(defn has-waiters?
  "Queries whether any threads are waiting on the given condition
   associated with the write lock. Note that because timeouts and
   interrupts may occur at any time, a true return does
   not guarantee that a future signal will awaken any
   threads.  This method is designed primarily for use in
   monitoring of the system state.

  condition - the condition - `java.util.concurrent.locks.Condition`

  returns: true if there are any waiting threads - `boolean`

  throws: java.lang.IllegalMonitorStateException - if this lock is not held"
  ([this condition]
    (-> this (.hasWaiters condition))))

(defn get-write-hold-count
  "Queries the number of reentrant write holds on this lock by the
   current thread.  A writer thread has a hold on a lock for
   each lock action that is not matched by an unlock action.

  returns: the number of holds on the write lock by the current thread,
           or zero if the write lock is not held by the current thread - `int`"
  ([this]
    (-> this (.getWriteHoldCount))))

(defn to-string
  "Returns a string identifying this lock, as well as its lock state.
   The state, in brackets, includes the String `Write locks =`
   followed by the number of reentrantly held write locks, and the
   String `Read locks =` followed by the number of held
   read locks.

  returns: a string identifying this lock, as well as its lock state - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn write-locked-by-current-thread?
  "Queries if the write lock is held by the current thread.

  returns: true if the current thread holds the write lock and
           false otherwise - `boolean`"
  ([this]
    (-> this (.isWriteLockedByCurrentThread))))

(defn get-read-lock-count
  "Queries the number of read locks held for this lock. This
   method is designed for use in monitoring system state, not for
   synchronization control.

  returns: the number of read locks held - `int`"
  ([this]
    (-> this (.getReadLockCount))))

(defn has-queued-threads?
  "Queries whether any threads are waiting to acquire the read or
   write lock. Note that because cancellations may occur at any
   time, a true return does not guarantee that any other
   thread will ever acquire a lock.  This method is designed
   primarily for use in monitoring of the system state.

  returns: true if there may be other threads waiting to
           acquire the lock - `boolean`"
  ([this]
    (-> this (.hasQueuedThreads))))

(defn has-queued-thread?
  "Queries whether the given thread is waiting to acquire either
   the read or write lock. Note that because cancellations may
   occur at any time, a true return does not guarantee
   that this thread will ever acquire a lock.  This method is
   designed primarily for use in monitoring of the system state.

  thread - the thread - `java.lang.Thread`

  returns: true if the given thread is queued waiting for this lock - `boolean`

  throws: java.lang.NullPointerException - if the thread is null"
  ([this thread]
    (-> this (.hasQueuedThread thread))))

(defn write-locked?
  "Queries if the write lock is held by any thread. This method is
   designed for use in monitoring system state, not for
   synchronization control.

  returns: true if any thread holds the write lock and
           false otherwise - `boolean`"
  ([this]
    (-> this (.isWriteLocked))))

(defn get-read-hold-count
  "Queries the number of reentrant read holds on this lock by the
   current thread.  A reader thread has a hold on a lock for
   each lock action that is not matched by an unlock action.

  returns: the number of holds on the read lock by the current thread,
           or zero if the read lock is not held by the current thread - `int`"
  ([this]
    (-> this (.getReadHoldCount))))

(defn get-wait-queue-length
  "Returns an estimate of the number of threads waiting on the
   given condition associated with the write lock. Note that because
   timeouts and interrupts may occur at any time, the estimate
   serves only as an upper bound on the actual number of waiters.
   This method is designed for use in monitoring of the system
   state, not for synchronization control.

  condition - the condition - `java.util.concurrent.locks.Condition`

  returns: the estimated number of waiting threads - `int`

  throws: java.lang.IllegalMonitorStateException - if this lock is not held"
  ([this condition]
    (-> this (.getWaitQueueLength condition))))

(defn read-lock
  "Description copied from interface: ReadWriteLock

  returns: the lock used for reading - `java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock`"
  ([this]
    (-> this (.readLock))))

