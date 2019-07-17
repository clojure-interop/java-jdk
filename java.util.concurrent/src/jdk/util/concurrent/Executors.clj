(ns jdk.util.concurrent.Executors
  "Factory and utility methods for Executor, ExecutorService, ScheduledExecutorService, ThreadFactory, and Callable classes defined in this
  package. This class supports the following kinds of methods:


     Methods that create and return an ExecutorService
         set up with commonly useful configuration settings.
     Methods that create and return a ScheduledExecutorService
         set up with commonly useful configuration settings.
     Methods that create and return a `wrapped` ExecutorService, that
         disables reconfiguration by making implementation-specific methods
         inaccessible.
     Methods that create and return a ThreadFactory
         that sets newly created threads to a known state.
     Methods that create and return a Callable
         out of other closure-like forms, so they can be used
         in execution methods requiring Callable."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent Executors]))

(defn *unconfigurable-executor-service
  "Returns an object that delegates all defined ExecutorService methods to the given executor, but not any
   other methods that might otherwise be accessible using
   casts. This provides a way to safely `freeze` configuration and
   disallow tuning of a given concrete implementation.

  executor - the underlying implementation - `java.util.concurrent.ExecutorService`

  returns: an ExecutorService instance - `java.util.concurrent.ExecutorService`

  throws: java.lang.NullPointerException - if executor null"
  ([executor]
    (Executors/unconfigurableExecutorService executor)))

(defn *privileged-callable-using-current-class-loader
  "Returns a Callable object that will, when called,
   execute the given callable under the current access
   control context, with the current context class loader as the
   context class loader. This method should normally be invoked
   within an
   AccessController.doPrivileged
   action to create callables that will, if possible, execute
   under the selected permission settings holding within that
   action; or if not possible, throw an associated AccessControlException.

  callable - the underlying task - `java.util.concurrent.Callable<T>`

  returns: a callable object - `<T> java.util.concurrent.Callable<T>`

  throws: java.lang.NullPointerException - if callable null"
  ([callable]
    (Executors/privilegedCallableUsingCurrentClassLoader callable)))

(defn *default-thread-factory
  "Returns a default thread factory used to create new threads.
   This factory creates all new threads used by an Executor in the
   same ThreadGroup. If there is a SecurityManager, it uses the group of System.getSecurityManager(), else the group of the thread
   invoking this defaultThreadFactory method. Each new
   thread is created as a non-daemon thread with priority set to
   the smaller of Thread.NORM_PRIORITY and the maximum
   priority permitted in the thread group.  New threads have names
   accessible via Thread.getName() of
   pool-N-thread-M, where N is the sequence
   number of this factory, and M is the sequence number
   of the thread created by this factory.

  returns: a thread factory - `java.util.concurrent.ThreadFactory`"
  ([]
    (Executors/defaultThreadFactory )))

(defn *new-scheduled-thread-pool
  "Creates a thread pool that can schedule commands to run after a
   given delay, or to execute periodically.

  core-pool-size - the number of threads to keep in the pool, even if they are idle - `int`
  thread-factory - the factory to use when the executor creates a new thread - `java.util.concurrent.ThreadFactory`

  returns: a newly created scheduled thread pool - `java.util.concurrent.ScheduledExecutorService`

  throws: java.lang.IllegalArgumentException - if corePoolSize < 0"
  ([core-pool-size thread-factory]
    (Executors/newScheduledThreadPool core-pool-size thread-factory))
  ([core-pool-size]
    (Executors/newScheduledThreadPool core-pool-size)))

(defn *new-cached-thread-pool
  "Creates a thread pool that creates new threads as needed, but
   will reuse previously constructed threads when they are
   available, and uses the provided
   ThreadFactory to create new threads when needed.

  thread-factory - the factory to use when creating new threads - `java.util.concurrent.ThreadFactory`

  returns: the newly created thread pool - `java.util.concurrent.ExecutorService`

  throws: java.lang.NullPointerException - if threadFactory is null"
  ([thread-factory]
    (Executors/newCachedThreadPool thread-factory))
  ([]
    (Executors/newCachedThreadPool )))

(defn *unconfigurable-scheduled-executor-service
  "Returns an object that delegates all defined ScheduledExecutorService methods to the given executor, but
   not any other methods that might otherwise be accessible using
   casts. This provides a way to safely `freeze` configuration and
   disallow tuning of a given concrete implementation.

  executor - the underlying implementation - `java.util.concurrent.ScheduledExecutorService`

  returns: a ScheduledExecutorService instance - `java.util.concurrent.ScheduledExecutorService`

  throws: java.lang.NullPointerException - if executor null"
  ([executor]
    (Executors/unconfigurableScheduledExecutorService executor)))

(defn *callable
  "Returns a Callable object that, when
   called, runs the given task and returns the given result.  This
   can be useful when applying methods requiring a
   Callable to an otherwise resultless action.

  task - the task to run - `java.lang.Runnable`
  result - the result to return - `T`

  returns: a callable object - `<T> java.util.concurrent.Callable<T>`

  throws: java.lang.NullPointerException - if task null"
  ([task result]
    (Executors/callable task result))
  ([task]
    (Executors/callable task)))

(defn *privileged-callable
  "Returns a Callable object that will, when called,
   execute the given callable under the current access
   control context. This method should normally be invoked within
   an AccessController.doPrivileged
   action to create callables that will, if possible, execute
   under the selected permission settings holding within that
   action; or if not possible, throw an associated AccessControlException.

  callable - the underlying task - `java.util.concurrent.Callable<T>`

  returns: a callable object - `<T> java.util.concurrent.Callable<T>`

  throws: java.lang.NullPointerException - if callable null"
  ([callable]
    (Executors/privilegedCallable callable)))

(defn *privileged-thread-factory
  "Returns a thread factory used to create new threads that
   have the same permissions as the current thread.
   This factory creates threads with the same settings as defaultThreadFactory(), additionally setting the
   AccessControlContext and contextClassLoader of new threads to
   be the same as the thread invoking this
   privilegedThreadFactory method.  A new
   privilegedThreadFactory can be created within an
   AccessController.doPrivileged
   action setting the current thread's access control context to
   create threads with the selected permission settings holding
   within that action.

   Note that while tasks running within such threads will have
   the same access control and class loader settings as the
   current thread, they need not have the same ThreadLocal or InheritableThreadLocal values. If necessary,
   particular values of thread locals can be set or reset before
   any task runs in ThreadPoolExecutor subclasses using
   ThreadPoolExecutor.beforeExecute(Thread, Runnable).
   Also, if it is necessary to initialize worker threads to have
   the same InheritableThreadLocal settings as some other
   designated thread, you can create a custom ThreadFactory in
   which that thread waits for and services requests to create
   others that will inherit its values.

  returns: a thread factory - `java.util.concurrent.ThreadFactory`

  throws: java.security.AccessControlException - if the current access control context does not have permission to both get and set context class loader"
  ([]
    (Executors/privilegedThreadFactory )))

(defn *new-fixed-thread-pool
  "Creates a thread pool that reuses a fixed number of threads
   operating off a shared unbounded queue, using the provided
   ThreadFactory to create new threads when needed.  At any point,
   at most nThreads threads will be active processing
   tasks.  If additional tasks are submitted when all threads are
   active, they will wait in the queue until a thread is
   available.  If any thread terminates due to a failure during
   execution prior to shutdown, a new one will take its place if
   needed to execute subsequent tasks.  The threads in the pool will
   exist until it is explicitly shutdown.

  n-threads - the number of threads in the pool - `int`
  thread-factory - the factory to use when creating new threads - `java.util.concurrent.ThreadFactory`

  returns: the newly created thread pool - `java.util.concurrent.ExecutorService`

  throws: java.lang.NullPointerException - if threadFactory is null"
  ([n-threads thread-factory]
    (Executors/newFixedThreadPool n-threads thread-factory))
  ([n-threads]
    (Executors/newFixedThreadPool n-threads)))

(defn *new-single-thread-executor
  "Creates an Executor that uses a single worker thread operating
   off an unbounded queue, and uses the provided ThreadFactory to
   create a new thread when needed. Unlike the otherwise
   equivalent newFixedThreadPool(1, threadFactory) the
   returned executor is guaranteed not to be reconfigurable to use
   additional threads.

  thread-factory - the factory to use when creating new threads - `java.util.concurrent.ThreadFactory`

  returns: the newly created single-threaded Executor - `java.util.concurrent.ExecutorService`

  throws: java.lang.NullPointerException - if threadFactory is null"
  ([thread-factory]
    (Executors/newSingleThreadExecutor thread-factory))
  ([]
    (Executors/newSingleThreadExecutor )))

(defn *new-single-thread-scheduled-executor
  "Creates a single-threaded executor that can schedule commands
   to run after a given delay, or to execute periodically.  (Note
   however that if this single thread terminates due to a failure
   during execution prior to shutdown, a new one will take its
   place if needed to execute subsequent tasks.)  Tasks are
   guaranteed to execute sequentially, and no more than one task
   will be active at any given time. Unlike the otherwise
   equivalent newScheduledThreadPool(1, threadFactory)
   the returned executor is guaranteed not to be reconfigurable to
   use additional threads.

  thread-factory - the factory to use when creating new threads - `java.util.concurrent.ThreadFactory`

  returns: a newly created scheduled executor - `java.util.concurrent.ScheduledExecutorService`

  throws: java.lang.NullPointerException - if threadFactory is null"
  ([thread-factory]
    (Executors/newSingleThreadScheduledExecutor thread-factory))
  ([]
    (Executors/newSingleThreadScheduledExecutor )))

(defn *new-work-stealing-pool
  "Creates a thread pool that maintains enough threads to support
   the given parallelism level, and may use multiple queues to
   reduce contention. The parallelism level corresponds to the
   maximum number of threads actively engaged in, or available to
   engage in, task processing. The actual number of threads may
   grow and shrink dynamically. A work-stealing pool makes no
   guarantees about the order in which submitted tasks are
   executed.

  parallelism - the targeted parallelism level - `int`

  returns: the newly created thread pool - `java.util.concurrent.ExecutorService`

  throws: java.lang.IllegalArgumentException - if parallelism <= 0"
  ([parallelism]
    (Executors/newWorkStealingPool parallelism))
  ([]
    (Executors/newWorkStealingPool )))

