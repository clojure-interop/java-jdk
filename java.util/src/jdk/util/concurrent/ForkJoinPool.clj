(ns jdk.util.concurrent.ForkJoinPool
  "An ExecutorService for running ForkJoinTasks.
  A ForkJoinPool provides the entry point for submissions
  from non-ForkJoinTask clients, as well as management and
  monitoring operations.

  A ForkJoinPool differs from other kinds of ExecutorService mainly by virtue of employing
  work-stealing: all threads in the pool attempt to find and
  execute tasks submitted to the pool and/or created by other active
  tasks (eventually blocking waiting for work if none exist). This
  enables efficient processing when most tasks spawn other subtasks
  (as do most ForkJoinTasks), as well as when many small
  tasks are submitted to the pool from external clients.  Especially
  when setting asyncMode to true in constructors, ForkJoinPools may also be appropriate for use with event-style
  tasks that are never joined.

  A static commonPool() is available and appropriate for
  most applications. The common pool is used by any ForkJoinTask that
  is not explicitly submitted to a specified pool. Using the common
  pool normally reduces resource usage (its threads are slowly
  reclaimed during periods of non-use, and reinstated upon subsequent
  use).

  For applications that require separate or custom pools, a ForkJoinPool may be constructed with a given target parallelism
  level; by default, equal to the number of available processors.
  The pool attempts to maintain enough active (or available) threads
  by dynamically adding, suspending, or resuming internal worker
  threads, even if some tasks are stalled waiting to join others.
  However, no such adjustments are guaranteed in the face of blocked
  I/O or other unmanaged synchronization. The nested ForkJoinPool.ManagedBlocker interface enables extension of the kinds of
  synchronization accommodated.

  In addition to execution and lifecycle control methods, this
  class provides status check methods (for example
  getStealCount()) that are intended to aid in developing,
  tuning, and monitoring fork/join applications. Also, method
  toString() returns indications of pool state in a
  convenient form for informal monitoring.

  As is the case with other ExecutorServices, there are three
  main task execution methods summarized in the following table.
  These are designed to be used primarily by clients not already
  engaged in fork/join computations in the current pool.  The main
  forms of these methods accept instances of ForkJoinTask,
  but overloaded forms also allow mixed execution of plain Runnable- or Callable- based activities as well.  However,
  tasks that are already executing in a pool should normally instead
  use the within-computation forms listed in the table unless using
  async event-style tasks that are not usually joined, in which case
  there is little difference among choice of methods.


  Summary of task execution methods


      Call from non-fork/join clients
      Call from within fork/join computations


      Arrange async execution
      execute(ForkJoinTask)
      ForkJoinTask.fork()


      Await and obtain result
      invoke(ForkJoinTask)
      ForkJoinTask.invoke()


      Arrange exec and obtain Future
      submit(ForkJoinTask)
      ForkJoinTask.fork() (ForkJoinTasks are Futures)



  The common pool is by default constructed with default
  parameters, but these may be controlled by setting three
  system properties:

  java.util.concurrent.ForkJoinPool.common.parallelism
  - the parallelism level, a non-negative integer
  java.util.concurrent.ForkJoinPool.common.threadFactory
  - the class name of a ForkJoinPool.ForkJoinWorkerThreadFactory
  java.util.concurrent.ForkJoinPool.common.exceptionHandler
  - the class name of a Thread.UncaughtExceptionHandler

  If a SecurityManager is present and no factory is
  specified, then the default pool uses a factory supplying
  threads that have no Permissions enabled.
  The system class loader is used to load these classes.
  Upon any error in establishing these settings, default parameters
  are used. It is possible to disable or limit the use of threads in
  the common pool by setting the parallelism property to zero, and/or
  using a factory that may return null. However doing so may
  cause unjoined tasks to never be executed.

  Implementation notes: This implementation restricts the
  maximum number of running threads to 32767. Attempts to create
  pools with greater than the maximum number result in
  IllegalArgumentException.

  This implementation rejects submitted tasks (that is, by throwing
  RejectedExecutionException) only when the pool is shut down
  or internal resources have been exhausted."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ForkJoinPool]))

(defn ->fork-join-pool
  "Constructor.

  Creates a ForkJoinPool with the given parameters.

  parallelism - the parallelism level. For default value, use Runtime.availableProcessors(). - `int`
  factory - the factory for creating new threads. For default value, use defaultForkJoinWorkerThreadFactory. - `java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory`
  handler - the handler for internal worker threads that terminate due to unrecoverable errors encountered while executing tasks. For default value, use null. - `java.lang.Thread.UncaughtExceptionHandler`
  async-mode - if true, establishes local first-in-first-out scheduling mode for forked tasks that are never joined. This mode may be more appropriate than default locally stack-based mode in applications in which worker threads only process event-style asynchronous tasks. For default value, use false. - `boolean`

  throws: java.lang.IllegalArgumentException - if parallelism less than or equal to zero, or greater than implementation limit"
  ([^Integer parallelism ^java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory factory ^java.lang.Thread.UncaughtExceptionHandler handler ^Boolean async-mode]
    (new ForkJoinPool parallelism factory handler async-mode))
  ([^Integer parallelism]
    (new ForkJoinPool parallelism))
  ([]
    (new ForkJoinPool )))

(def *-default-fork-join-worker-thread-factory
  "Static Constant.

  Creates a new ForkJoinWorkerThread. This factory is used unless
   overridden in ForkJoinPool constructors.

  type: java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory"
  ForkJoinPool/defaultForkJoinWorkerThreadFactory)

(defn *common-pool
  "Returns the common pool instance. This pool is statically
   constructed; its run state is unaffected by attempts to shutdown() or shutdownNow(). However this pool and any
   ongoing processing are automatically terminated upon program
   System.exit(int).  Any program that relies on asynchronous
   task processing to complete before program termination should
   invoke commonPool().awaitQuiescence,
   before exit.

  returns: the common pool instance - `java.util.concurrent.ForkJoinPool`"
  ([]
    (ForkJoinPool/commonPool )))

(defn *get-common-pool-parallelism
  "Returns the targeted parallelism level of the common pool.

  returns: the targeted parallelism level of the common pool - `int`"
  ([]
    (ForkJoinPool/getCommonPoolParallelism )))

(defn *managed-block
  "Runs the given possibly blocking task.  When running in a ForkJoinPool, this
   method possibly arranges for a spare thread to be activated if
   necessary to ensure sufficient parallelism while the current
   thread is blocked in blocker.block().

   This method repeatedly calls blocker.isReleasable() and
   blocker.block() until either method returns true.
   Every call to blocker.block() is preceded by a call to
   blocker.isReleasable() that returned false.

   If not running in a ForkJoinPool, this method is
   behaviorally equivalent to


   while (!blocker.isReleasable())
     if (blocker.block())
       break;

   If running in a ForkJoinPool, the pool may first be expanded to
   ensure sufficient parallelism available during the call to
   blocker.block().

  blocker - the blocker task - `java.util.concurrent.ForkJoinPool.ManagedBlocker`

  throws: java.lang.InterruptedException - if blocker.block() did so"
  ([^java.util.concurrent.ForkJoinPool.ManagedBlocker blocker]
    (ForkJoinPool/managedBlock blocker)))

(defn invoke
  "Performs the given task, returning its result upon completion.
   If the computation encounters an unchecked Exception or Error,
   it is rethrown as the outcome of this invocation.  Rethrown
   exceptions behave in the same way as regular exceptions, but,
   when possible, contain stack traces (as displayed for example
   using ex.printStackTrace()) of both the current thread
   as well as the thread actually encountering the exception;
   minimally only the latter.

  task - the task - `java.util.concurrent.ForkJoinTask<T>`

  returns: the task's result - `<T> T`

  throws: java.lang.NullPointerException - if the task is null"
  ([^java.util.concurrent.ForkJoinPool this ^java.util.concurrent.ForkJoinTask task]
    (-> this (.invoke task))))

(defn has-queued-submissions?
  "Returns true if there are any tasks submitted to this
   pool that have not yet begun executing.

  returns: true if there are any queued submissions - `boolean`"
  ([^java.util.concurrent.ForkJoinPool this]
    (-> this (.hasQueuedSubmissions))))

(defn quiescent?
  "Returns true if all worker threads are currently idle.
   An idle worker is one that cannot obtain a task to execute
   because none are available to steal from other threads, and
   there are no pending submissions to the pool. This method is
   conservative; it might not return true immediately upon
   idleness of all threads, but will eventually become true if
   threads remain inactive.

  returns: true if all threads are currently idle - `boolean`"
  ([^java.util.concurrent.ForkJoinPool this]
    (-> this (.isQuiescent))))

(defn get-queued-task-count
  "Returns an estimate of the total number of tasks currently held
   in queues by worker threads (but not including tasks submitted
   to the pool that have not begun executing). This value is only
   an approximation, obtained by iterating across all threads in
   the pool. This method may be useful for tuning task
   granularities.

  returns: the number of queued tasks - `long`"
  ([^java.util.concurrent.ForkJoinPool this]
    (-> this (.getQueuedTaskCount))))

(defn invoke-all
  "Description copied from interface: ExecutorService

  tasks - the collection of tasks - `java.util.concurrent.Callable<T>>`

  returns: a list of Futures representing the tasks, in the same
           sequential order as produced by the iterator for the
           given task list, each of which has completed - `<T> java.util.List<java.util.concurrent.Future<T>>`

  throws: java.lang.NullPointerException - if tasks or any of its elements are null"
  ([^java.util.concurrent.ForkJoinPool this ^java.util.concurrent.Callable> tasks]
    (-> this (.invokeAll tasks))))

(defn get-uncaught-exception-handler
  "Returns the handler for internal worker threads that terminate
   due to unrecoverable errors encountered while executing tasks.

  returns: the handler, or null if none - `java.lang.Thread.UncaughtExceptionHandler`"
  ([^java.util.concurrent.ForkJoinPool this]
    (-> this (.getUncaughtExceptionHandler))))

(defn to-string
  "Returns a string identifying this pool, as well as its state,
   including indications of run state, parallelism level, and
   worker and task counts.

  returns: a string identifying this pool, as well as its state - `java.lang.String`"
  ([^java.util.concurrent.ForkJoinPool this]
    (-> this (.toString))))

(defn get-queued-submission-count
  "Returns an estimate of the number of tasks submitted to this
   pool that have not yet begun executing.  This method may take
   time proportional to the number of submissions.

  returns: the number of queued submissions - `int`"
  ([^java.util.concurrent.ForkJoinPool this]
    (-> this (.getQueuedSubmissionCount))))

(defn shutdown?
  "Returns true if this pool has been shut down.

  returns: true if this pool has been shut down - `boolean`"
  ([^java.util.concurrent.ForkJoinPool this]
    (-> this (.isShutdown))))

(defn await-termination
  "Blocks until all tasks have completed execution after a
   shutdown request, or the timeout occurs, or the current thread
   is interrupted, whichever happens first. Because the commonPool() never terminates until program shutdown, when
   applied to the common pool, this method is equivalent to awaitQuiescence(long, TimeUnit) but always returns false.

  timeout - the maximum time to wait - `long`
  unit - the time unit of the timeout argument - `java.util.concurrent.TimeUnit`

  returns: true if this executor terminated and
           false if the timeout elapsed before termination - `boolean`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^java.util.concurrent.ForkJoinPool this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.awaitTermination timeout unit))))

(defn shutdown
  "Possibly initiates an orderly shutdown in which previously
   submitted tasks are executed, but no new tasks will be
   accepted. Invocation has no effect on execution state if this
   is the commonPool(), and no additional effect if
   already shut down.  Tasks that are in the process of being
   submitted concurrently during the course of this method may or
   may not be rejected.

  throws: java.lang.SecurityException - if a security manager exists and the caller is not permitted to modify threads because it does not hold RuntimePermission(`modifyThread`)"
  ([^java.util.concurrent.ForkJoinPool this]
    (-> this (.shutdown))))

(defn get-steal-count
  "Returns an estimate of the total number of tasks stolen from
   one thread's work queue by another. The reported value
   underestimates the actual total number of steals when the pool
   is not quiescent. This value may be useful for monitoring and
   tuning fork/join programs: in general, steal counts should be
   high enough to keep threads busy, but low enough to avoid
   overhead and contention across threads.

  returns: the number of steals - `long`"
  ([^java.util.concurrent.ForkJoinPool this]
    (-> this (.getStealCount))))

(defn get-factory
  "Returns the factory used for constructing new workers.

  returns: the factory used for constructing new workers - `java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory`"
  ([^java.util.concurrent.ForkJoinPool this]
    (-> this (.getFactory))))

(defn get-running-thread-count
  "Returns an estimate of the number of worker threads that are
   not blocked waiting to join tasks or for other managed
   synchronization. This method may overestimate the
   number of running threads.

  returns: the number of worker threads - `int`"
  ([^java.util.concurrent.ForkJoinPool this]
    (-> this (.getRunningThreadCount))))

(defn submit
  "Description copied from interface: ExecutorService

  task - the task to submit - `java.lang.Runnable`
  result - the result to return - `T`

  returns: a Future representing pending completion of the task - `<T> java.util.concurrent.ForkJoinTask<T>`

  throws: java.lang.NullPointerException - if the task is null"
  ([^java.util.concurrent.ForkJoinPool this ^java.lang.Runnable task result]
    (-> this (.submit task result)))
  ([^java.util.concurrent.ForkJoinPool this ^java.util.concurrent.ForkJoinTask task]
    (-> this (.submit task))))

(defn await-quiescence
  "If called by a ForkJoinTask operating in this pool, equivalent
   in effect to ForkJoinTask.helpQuiesce(). Otherwise,
   waits and/or attempts to assist performing tasks until this
   pool isQuiescent() or the indicated timeout elapses.

  timeout - the maximum time to wait - `long`
  unit - the time unit of the timeout argument - `java.util.concurrent.TimeUnit`

  returns: true if quiescent; false if the
   timeout elapsed. - `boolean`"
  ([^java.util.concurrent.ForkJoinPool this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.awaitQuiescence timeout unit))))

(defn execute
  "Arranges for (asynchronous) execution of the given task.

  task - the task - `java.util.concurrent.ForkJoinTask<?>`

  throws: java.lang.NullPointerException - if the task is null"
  ([^java.util.concurrent.ForkJoinPool this ^java.util.concurrent.ForkJoinTask task]
    (-> this (.execute task))))

(defn terminating?
  "Returns true if the process of termination has
   commenced but not yet completed.  This method may be useful for
   debugging. A return of true reported a sufficient
   period after shutdown may indicate that submitted tasks have
   ignored or suppressed interruption, or are waiting for I/O,
   causing this executor not to properly terminate. (See the
   advisory notes for class ForkJoinTask stating that
   tasks should not normally entail blocking operations.  But if
   they do, they must abort them on interrupt.)

  returns: true if terminating but not yet terminated - `boolean`"
  ([^java.util.concurrent.ForkJoinPool this]
    (-> this (.isTerminating))))

(defn get-active-thread-count
  "Returns an estimate of the number of threads that are currently
   stealing or executing tasks. This method may overestimate the
   number of active threads.

  returns: the number of active threads - `int`"
  ([^java.util.concurrent.ForkJoinPool this]
    (-> this (.getActiveThreadCount))))

(defn terminated?
  "Returns true if all tasks have completed following shut down.

  returns: true if all tasks have completed following shut down - `boolean`"
  ([^java.util.concurrent.ForkJoinPool this]
    (-> this (.isTerminated))))

(defn get-async-mode?
  "Returns true if this pool uses local first-in-first-out
   scheduling mode for forked tasks that are never joined.

  returns: true if this pool uses async mode - `boolean`"
  ([^java.util.concurrent.ForkJoinPool this]
    (-> this (.getAsyncMode))))

(defn get-pool-size
  "Returns the number of worker threads that have started but not
   yet terminated.  The result returned by this method may differ
   from getParallelism() when threads are created to
   maintain parallelism when others are cooperatively blocked.

  returns: the number of worker threads - `int`"
  ([^java.util.concurrent.ForkJoinPool this]
    (-> this (.getPoolSize))))

(defn get-parallelism
  "Returns the targeted parallelism level of this pool.

  returns: the targeted parallelism level of this pool - `int`"
  ([^java.util.concurrent.ForkJoinPool this]
    (-> this (.getParallelism))))

(defn shutdown-now
  "Possibly attempts to cancel and/or stop all tasks, and reject
   all subsequently submitted tasks.  Invocation has no effect on
   execution state if this is the commonPool(), and no
   additional effect if already shut down. Otherwise, tasks that
   are in the process of being submitted or executed concurrently
   during the course of this method may or may not be
   rejected. This method cancels both existing and unexecuted
   tasks, in order to permit termination in the presence of task
   dependencies. So the method always returns an empty list
   (unlike the case for some other Executors).

  returns: an empty list - `java.util.List<java.lang.Runnable>`

  throws: java.lang.SecurityException - if a security manager exists and the caller is not permitted to modify threads because it does not hold RuntimePermission(`modifyThread`)"
  ([^java.util.concurrent.ForkJoinPool this]
    (-> this (.shutdownNow))))

