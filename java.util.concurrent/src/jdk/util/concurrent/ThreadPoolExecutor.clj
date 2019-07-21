(ns jdk.util.concurrent.ThreadPoolExecutor
  "An ExecutorService that executes each submitted task using
  one of possibly several pooled threads, normally configured
  using Executors factory methods.

  Thread pools address two different problems: they usually
  provide improved performance when executing large numbers of
  asynchronous tasks, due to reduced per-task invocation overhead,
  and they provide a means of bounding and managing the resources,
  including threads, consumed when executing a collection of tasks.
  Each ThreadPoolExecutor also maintains some basic
  statistics, such as the number of completed tasks.

  To be useful across a wide range of contexts, this class
  provides many adjustable parameters and extensibility
  hooks. However, programmers are urged to use the more convenient
  Executors factory methods Executors.newCachedThreadPool() (unbounded thread pool, with
  automatic thread reclamation), Executors.newFixedThreadPool(int)
  (fixed size thread pool) and Executors.newSingleThreadExecutor() (single background thread), that
  preconfigure settings for the most common usage
  scenarios. Otherwise, use the following guide when manually
  configuring and tuning this class:



  Core and maximum pool sizes

  A ThreadPoolExecutor will automatically adjust the
  pool size (see getPoolSize())
  according to the bounds set by
  corePoolSize (see getCorePoolSize()) and
  maximumPoolSize (see getMaximumPoolSize()).

  When a new task is submitted in method execute(Runnable),
  and fewer than corePoolSize threads are running, a new thread is
  created to handle the request, even if other worker threads are
  idle.  If there are more than corePoolSize but less than
  maximumPoolSize threads running, a new thread will be created only
  if the queue is full.  By setting corePoolSize and maximumPoolSize
  the same, you create a fixed-size thread pool. By setting
  maximumPoolSize to an essentially unbounded value such as Integer.MAX_VALUE, you allow the pool to accommodate an arbitrary
  number of concurrent tasks. Most typically, core and maximum pool
  sizes are set only upon construction, but they may also be changed
  dynamically using setCorePoolSize(int) and setMaximumPoolSize(int).

  On-demand construction

  By default, even core threads are initially created and
  started only when new tasks arrive, but this can be overridden
  dynamically using method prestartCoreThread() or prestartAllCoreThreads().  You probably want to prestart threads if
  you construct the pool with a non-empty queue.

  Creating new threads

  New threads are created using a ThreadFactory.  If not
  otherwise specified, a Executors.defaultThreadFactory() is
  used, that creates threads to all be in the same ThreadGroup and with the same NORM_PRIORITY priority and
  non-daemon status. By supplying a different ThreadFactory, you can
  alter the thread's name, thread group, priority, daemon status,
  etc. If a ThreadFactory fails to create a thread when asked
  by returning null from newThread, the executor will
  continue, but might not be able to execute any tasks. Threads
  should possess the \"modifyThread\" RuntimePermission. If
  worker threads or other threads using the pool do not possess this
  permission, service may be degraded: configuration changes may not
  take effect in a timely manner, and a shutdown pool may remain in a
  state in which termination is possible but not completed.

  Keep-alive times

  If the pool currently has more than corePoolSize threads,
  excess threads will be terminated if they have been idle for more
  than the keepAliveTime (see getKeepAliveTime(TimeUnit)).
  This provides a means of reducing resource consumption when the
  pool is not being actively used. If the pool becomes more active
  later, new threads will be constructed. This parameter can also be
  changed dynamically using method setKeepAliveTime(long,
  TimeUnit).  Using a value of Long.MAX_VALUE TimeUnit.NANOSECONDS effectively disables idle threads from ever
  terminating prior to shut down. By default, the keep-alive policy
  applies only when there are more than corePoolSize threads. But
  method allowCoreThreadTimeOut(boolean) can be used to
  apply this time-out policy to core threads as well, so long as the
  keepAliveTime value is non-zero.

  Queuing

  Any BlockingQueue may be used to transfer and hold
  submitted tasks.  The use of this queue interacts with pool sizing:



   If fewer than corePoolSize threads are running, the Executor
  always prefers adding a new thread
  rather than queuing.

   If corePoolSize or more threads are running, the Executor
  always prefers queuing a request rather than adding a new
  thread.

   If a request cannot be queued, a new thread is created unless
  this would exceed maximumPoolSize, in which case, the task will be
  rejected.



  There are three general strategies for queuing:


    Direct handoffs. A good default choice for a work
  queue is a SynchronousQueue that hands off tasks to threads
  without otherwise holding them. Here, an attempt to queue a task
  will fail if no threads are immediately available to run it, so a
  new thread will be constructed. This policy avoids lockups when
  handling sets of requests that might have internal dependencies.
  Direct handoffs generally require unbounded maximumPoolSizes to
  avoid rejection of new submitted tasks. This in turn admits the
  possibility of unbounded thread growth when commands continue to
  arrive on average faster than they can be processed.

   Unbounded queues. Using an unbounded queue (for
  example a LinkedBlockingQueue without a predefined
  capacity) will cause new tasks to wait in the queue when all
  corePoolSize threads are busy. Thus, no more than corePoolSize
  threads will ever be created. (And the value of the maximumPoolSize
  therefore doesn't have any effect.)  This may be appropriate when
  each task is completely independent of others, so tasks cannot
  affect each others execution; for example, in a web page server.
  While this style of queuing can be useful in smoothing out
  transient bursts of requests, it admits the possibility of
  unbounded work queue growth when commands continue to arrive on
  average faster than they can be processed.

  Bounded queues. A bounded queue (for example, an
  ArrayBlockingQueue) helps prevent resource exhaustion when
  used with finite maximumPoolSizes, but can be more difficult to
  tune and control.  Queue sizes and maximum pool sizes may be traded
  off for each other: Using large queues and small pools minimizes
  CPU usage, OS resources, and context-switching overhead, but can
  lead to artificially low throughput.  If tasks frequently block (for
  example if they are I/O bound), a system may be able to schedule
  time for more threads than you otherwise allow. Use of small queues
  generally requires larger pool sizes, which keeps CPUs busier but
  may encounter unacceptable scheduling overhead, which also
  decreases throughput.





  Rejected tasks

  New tasks submitted in method execute(Runnable) will be
  rejected when the Executor has been shut down, and also when
  the Executor uses finite bounds for both maximum threads and work queue
  capacity, and is saturated.  In either case, the execute method
  invokes the RejectedExecutionHandler.rejectedExecution(Runnable, ThreadPoolExecutor)
  method of its RejectedExecutionHandler.  Four predefined handler
  policies are provided:



   In the default ThreadPoolExecutor.AbortPolicy, the
  handler throws a runtime RejectedExecutionException upon
  rejection.

   In ThreadPoolExecutor.CallerRunsPolicy, the thread
  that invokes execute itself runs the task. This provides a
  simple feedback control mechanism that will slow down the rate that
  new tasks are submitted.

   In ThreadPoolExecutor.DiscardPolicy, a task that
  cannot be executed is simply dropped.

  In ThreadPoolExecutor.DiscardOldestPolicy, if the
  executor is not shut down, the task at the head of the work queue
  is dropped, and then execution is retried (which can fail again,
  causing this to be repeated.)



  It is possible to define and use other kinds of RejectedExecutionHandler classes. Doing so requires some care
  especially when policies are designed to work only under particular
  capacity or queuing policies.

  Hook methods

  This class provides protected overridable
  beforeExecute(Thread, Runnable) and
  afterExecute(Runnable, Throwable) methods that are called
  before and after execution of each task.  These can be used to
  manipulate the execution environment; for example, reinitializing
  ThreadLocals, gathering statistics, or adding log entries.
  Additionally, method terminated() can be overridden to perform
  any special processing that needs to be done once the Executor has
  fully terminated.

  If hook or callback methods throw exceptions, internal worker
  threads may in turn fail and abruptly terminate.

  Queue maintenance

  Method getQueue() allows access to the work queue
  for purposes of monitoring and debugging.  Use of this method for
  any other purpose is strongly discouraged.  Two supplied methods,
  remove(Runnable) and purge() are available to
  assist in storage reclamation when large numbers of queued tasks
  become cancelled.

  Finalization

  A pool that is no longer referenced in a program AND
  has no remaining threads will be shutdown automatically. If
  you would like to ensure that unreferenced pools are reclaimed even
  if users forget to call shutdown(), then you must arrange
  that unused threads eventually die, by setting appropriate
  keep-alive times, using a lower bound of zero core threads and/or
  setting allowCoreThreadTimeOut(boolean).



  Extension example. Most extensions of this class
  override one or more of the protected hook methods. For example,
  here is a subclass that adds a simple pause/resume feature:



  class PausableThreadPoolExecutor extends ThreadPoolExecutor {
    private boolean isPaused;
    private ReentrantLock pauseLock = new ReentrantLock();
    private Condition unpaused = pauseLock.newCondition();

    public PausableThreadPoolExecutor(...) { super(...); }

    protected void beforeExecute(Thread t, Runnable r) {
      super.beforeExecute(t, r);
      pauseLock.lock();
      try {
        while (isPaused) unpaused.await();
      } catch (InterruptedException ie) {
        t.interrupt();
      } finally {
        pauseLock.unlock();
      }
    }

    public void pause() {
      pauseLock.lock();
      try {
        isPaused = true;
      } finally {
        pauseLock.unlock();
      }
    }

    public void resume() {
      pauseLock.lock();
      try {
        isPaused = false;
        unpaused.signalAll();
      } finally {
        pauseLock.unlock();
      }
    }
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ThreadPoolExecutor]))

(defn ->thread-pool-executor
  "Constructor.

  Creates a new ThreadPoolExecutor with the given initial
   parameters.

  core-pool-size - the number of threads to keep in the pool, even if they are idle, unless allowCoreThreadTimeOut is set - `int`
  maximum-pool-size - the maximum number of threads to allow in the pool - `int`
  keep-alive-time - when the number of threads is greater than the core, this is the maximum time that excess idle threads will wait for new tasks before terminating. - `long`
  unit - the time unit for the keepAliveTime argument - `java.util.concurrent.TimeUnit`
  work-queue - the queue to use for holding tasks before they are executed. This queue will hold only the Runnable tasks submitted by the execute method. - `java.util.concurrent.BlockingQueue`
  thread-factory - the factory to use when the executor creates a new thread - `java.util.concurrent.ThreadFactory`
  handler - the handler to use when execution is blocked because the thread bounds and queue capacities are reached - `java.util.concurrent.RejectedExecutionHandler`

  throws: java.lang.IllegalArgumentException - if one of the following holds: corePoolSize < 0 keepAliveTime < 0 maximumPoolSize <= 0 maximumPoolSize < corePoolSize"
  (^ThreadPoolExecutor [^Integer core-pool-size ^Integer maximum-pool-size ^Long keep-alive-time ^java.util.concurrent.TimeUnit unit ^java.util.concurrent.BlockingQueue work-queue ^java.util.concurrent.ThreadFactory thread-factory ^java.util.concurrent.RejectedExecutionHandler handler]
    (new ThreadPoolExecutor core-pool-size maximum-pool-size keep-alive-time unit work-queue thread-factory handler))
  (^ThreadPoolExecutor [^Integer core-pool-size ^Integer maximum-pool-size ^Long keep-alive-time ^java.util.concurrent.TimeUnit unit ^java.util.concurrent.BlockingQueue work-queue ^java.util.concurrent.ThreadFactory thread-factory]
    (new ThreadPoolExecutor core-pool-size maximum-pool-size keep-alive-time unit work-queue thread-factory))
  (^ThreadPoolExecutor [^Integer core-pool-size ^Integer maximum-pool-size ^Long keep-alive-time ^java.util.concurrent.TimeUnit unit ^java.util.concurrent.BlockingQueue work-queue]
    (new ThreadPoolExecutor core-pool-size maximum-pool-size keep-alive-time unit work-queue)))

(defn get-maximum-pool-size
  "Returns the maximum allowed number of threads.

  returns: the maximum allowed number of threads - `int`"
  (^Integer [^ThreadPoolExecutor this]
    (-> this (.getMaximumPoolSize))))

(defn set-maximum-pool-size
  "Sets the maximum allowed number of threads. This overrides any
   value set in the constructor. If the new value is smaller than
   the current value, excess existing threads will be
   terminated when they next become idle.

  maximum-pool-size - the new maximum - `int`

  throws: java.lang.IllegalArgumentException - if the new maximum is less than or equal to zero, or less than the core pool size"
  ([^ThreadPoolExecutor this ^Integer maximum-pool-size]
    (-> this (.setMaximumPoolSize maximum-pool-size))))

(defn allows-core-thread-time-out
  "Returns true if this pool allows core threads to time out and
   terminate if no tasks arrive within the keepAlive time, being
   replaced if needed when new tasks arrive. When true, the same
   keep-alive policy applying to non-core threads applies also to
   core threads. When false (the default), core threads are never
   terminated due to lack of incoming tasks.

  returns: true if core threads are allowed to time out,
           else false - `boolean`"
  (^Boolean [^ThreadPoolExecutor this]
    (-> this (.allowsCoreThreadTimeOut))))

(defn set-rejected-execution-handler
  "Sets a new handler for unexecutable tasks.

  handler - the new handler - `java.util.concurrent.RejectedExecutionHandler`

  throws: java.lang.NullPointerException - if handler is null"
  ([^ThreadPoolExecutor this ^java.util.concurrent.RejectedExecutionHandler handler]
    (-> this (.setRejectedExecutionHandler handler))))

(defn get-core-pool-size
  "Returns the core number of threads.

  returns: the core number of threads - `int`"
  (^Integer [^ThreadPoolExecutor this]
    (-> this (.getCorePoolSize))))

(defn purge
  "Tries to remove from the work queue all Future
   tasks that have been cancelled. This method can be useful as a
   storage reclamation operation, that has no other impact on
   functionality. Cancelled tasks are never executed, but may
   accumulate in work queues until worker threads can actively
   remove them. Invoking this method instead tries to remove them now.
   However, this method may fail to remove tasks in
   the presence of interference by other threads."
  ([^ThreadPoolExecutor this]
    (-> this (.purge))))

(defn get-keep-alive-time
  "Returns the thread keep-alive time, which is the amount of time
   that threads in excess of the core pool size may remain
   idle before being terminated.

  unit - the desired time unit of the result - `java.util.concurrent.TimeUnit`

  returns: the time limit - `long`"
  (^Long [^ThreadPoolExecutor this ^java.util.concurrent.TimeUnit unit]
    (-> this (.getKeepAliveTime unit))))

(defn to-string
  "Returns a string identifying this pool, as well as its state,
   including indications of run state and estimated worker and
   task counts.

  returns: a string identifying this pool, as well as its state - `java.lang.String`"
  (^java.lang.String [^ThreadPoolExecutor this]
    (-> this (.toString))))

(defn get-task-count
  "Returns the approximate total number of tasks that have ever been
   scheduled for execution. Because the states of tasks and
   threads may change dynamically during computation, the returned
   value is only an approximation.

  returns: the number of tasks - `long`"
  (^Long [^ThreadPoolExecutor this]
    (-> this (.getTaskCount))))

(defn get-active-count
  "Returns the approximate number of threads that are actively
   executing tasks.

  returns: the number of threads - `int`"
  (^Integer [^ThreadPoolExecutor this]
    (-> this (.getActiveCount))))

(defn prestart-core-thread
  "Starts a core thread, causing it to idly wait for work. This
   overrides the default policy of starting core threads only when
   new tasks are executed. This method will return false
   if all core threads have already been started.

  returns: true if a thread was started - `boolean`"
  (^Boolean [^ThreadPoolExecutor this]
    (-> this (.prestartCoreThread))))

(defn allow-core-thread-time-out
  "Sets the policy governing whether core threads may time out and
   terminate if no tasks arrive within the keep-alive time, being
   replaced if needed when new tasks arrive. When false, core
   threads are never terminated due to lack of incoming
   tasks. When true, the same keep-alive policy applying to
   non-core threads applies also to core threads. To avoid
   continual thread replacement, the keep-alive time must be
   greater than zero when setting true. This method
   should in general be called before the pool is actively used.

  value - true if should time out, else false - `boolean`

  throws: java.lang.IllegalArgumentException - if value is true and the current keep-alive time is not greater than zero"
  ([^ThreadPoolExecutor this ^Boolean value]
    (-> this (.allowCoreThreadTimeOut value))))

(defn get-thread-factory
  "Returns the thread factory used to create new threads.

  returns: the current thread factory - `java.util.concurrent.ThreadFactory`"
  (^java.util.concurrent.ThreadFactory [^ThreadPoolExecutor this]
    (-> this (.getThreadFactory))))

(defn shutdown?
  "Description copied from interface: ExecutorService

  returns: true if this executor has been shut down - `boolean`"
  (^Boolean [^ThreadPoolExecutor this]
    (-> this (.isShutdown))))

(defn get-rejected-execution-handler
  "Returns the current handler for unexecutable tasks.

  returns: the current handler - `java.util.concurrent.RejectedExecutionHandler`"
  (^java.util.concurrent.RejectedExecutionHandler [^ThreadPoolExecutor this]
    (-> this (.getRejectedExecutionHandler))))

(defn await-termination
  "Description copied from interface: ExecutorService

  timeout - the maximum time to wait - `long`
  unit - the time unit of the timeout argument - `java.util.concurrent.TimeUnit`

  returns: true if this executor terminated and
           false if the timeout elapsed before termination - `boolean`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  (^Boolean [^ThreadPoolExecutor this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.awaitTermination timeout unit))))

(defn shutdown
  "Initiates an orderly shutdown in which previously submitted
   tasks are executed, but no new tasks will be accepted.
   Invocation has no additional effect if already shut down.

   This method does not wait for previously submitted tasks to
   complete execution.  Use awaitTermination
   to do that.

  throws: java.lang.SecurityException - if a security manager exists and shutting down this ExecutorService may manipulate threads that the caller is not permitted to modify because it does not hold RuntimePermission(\"modifyThread\"), or the security manager's checkAccess method denies access."
  ([^ThreadPoolExecutor this]
    (-> this (.shutdown))))

(defn remove
  "Removes this task from the executor's internal queue if it is
   present, thus causing it not to be run if it has not already
   started.

   This method may be useful as one part of a cancellation
   scheme.  It may fail to remove tasks that have been converted
   into other forms before being placed on the internal queue. For
   example, a task entered using submit might be
   converted into a form that maintains Future status.
   However, in such cases, method purge() may be used to
   remove those Futures that have been cancelled.

  task - the task to remove - `java.lang.Runnable`

  returns: true if the task was removed - `boolean`"
  (^Boolean [^ThreadPoolExecutor this ^java.lang.Runnable task]
    (-> this (.remove task))))

(defn get-largest-pool-size
  "Returns the largest number of threads that have ever
   simultaneously been in the pool.

  returns: the number of threads - `int`"
  (^Integer [^ThreadPoolExecutor this]
    (-> this (.getLargestPoolSize))))

(defn execute
  "Executes the given task sometime in the future.  The task
   may execute in a new thread or in an existing pooled thread.

   If the task cannot be submitted for execution, either because this
   executor has been shutdown or because its capacity has been reached,
   the task is handled by the current RejectedExecutionHandler.

  command - the task to execute - `java.lang.Runnable`

  throws: java.util.concurrent.RejectedExecutionException - at discretion of RejectedExecutionHandler, if the task cannot be accepted for execution"
  ([^ThreadPoolExecutor this ^java.lang.Runnable command]
    (-> this (.execute command))))

(defn terminating?
  "Returns true if this executor is in the process of terminating
   after shutdown() or shutdownNow() but has not
   completely terminated.  This method may be useful for
   debugging. A return of true reported a sufficient
   period after shutdown may indicate that submitted tasks have
   ignored or suppressed interruption, causing this executor not
   to properly terminate.

  returns: true if terminating but not yet terminated - `boolean`"
  (^Boolean [^ThreadPoolExecutor this]
    (-> this (.isTerminating))))

(defn terminated?
  "Description copied from interface: ExecutorService

  returns: true if all tasks have completed following shut down - `boolean`"
  (^Boolean [^ThreadPoolExecutor this]
    (-> this (.isTerminated))))

(defn get-queue
  "Returns the task queue used by this executor. Access to the
   task queue is intended primarily for debugging and monitoring.
   This queue may be in active use.  Retrieving the task queue
   does not prevent queued tasks from executing.

  returns: the task queue - `java.util.concurrent.BlockingQueue<java.lang.Runnable>`"
  (^java.util.concurrent.BlockingQueue [^ThreadPoolExecutor this]
    (-> this (.getQueue))))

(defn prestart-all-core-threads
  "Starts all core threads, causing them to idly wait for work. This
   overrides the default policy of starting core threads only when
   new tasks are executed.

  returns: the number of threads started - `int`"
  (^Integer [^ThreadPoolExecutor this]
    (-> this (.prestartAllCoreThreads))))

(defn get-pool-size
  "Returns the current number of threads in the pool.

  returns: the number of threads - `int`"
  (^Integer [^ThreadPoolExecutor this]
    (-> this (.getPoolSize))))

(defn set-keep-alive-time
  "Sets the time limit for which threads may remain idle before
   being terminated.  If there are more than the core number of
   threads currently in the pool, after waiting this amount of
   time without processing a task, excess threads will be
   terminated.  This overrides any value set in the constructor.

  time - the time to wait. A time value of zero will cause excess threads to terminate immediately after executing tasks. - `long`
  unit - the time unit of the time argument - `java.util.concurrent.TimeUnit`

  throws: java.lang.IllegalArgumentException - if time less than zero or if time is zero and allowsCoreThreadTimeOut"
  ([^ThreadPoolExecutor this ^Long time ^java.util.concurrent.TimeUnit unit]
    (-> this (.setKeepAliveTime time unit))))

(defn set-thread-factory
  "Sets the thread factory used to create new threads.

  thread-factory - the new thread factory - `java.util.concurrent.ThreadFactory`

  throws: java.lang.NullPointerException - if threadFactory is null"
  ([^ThreadPoolExecutor this ^java.util.concurrent.ThreadFactory thread-factory]
    (-> this (.setThreadFactory thread-factory))))

(defn set-core-pool-size
  "Sets the core number of threads.  This overrides any value set
   in the constructor.  If the new value is smaller than the
   current value, excess existing threads will be terminated when
   they next become idle.  If larger, new threads will, if needed,
   be started to execute any queued tasks.

  core-pool-size - the new core size - `int`

  throws: java.lang.IllegalArgumentException - if corePoolSize < 0"
  ([^ThreadPoolExecutor this ^Integer core-pool-size]
    (-> this (.setCorePoolSize core-pool-size))))

(defn get-completed-task-count
  "Returns the approximate total number of tasks that have
   completed execution. Because the states of tasks and threads
   may change dynamically during computation, the returned value
   is only an approximation, but one that does not ever decrease
   across successive calls.

  returns: the number of tasks - `long`"
  (^Long [^ThreadPoolExecutor this]
    (-> this (.getCompletedTaskCount))))

(defn shutdown-now
  "Attempts to stop all actively executing tasks, halts the
   processing of waiting tasks, and returns a list of the tasks
   that were awaiting execution. These tasks are drained (removed)
   from the task queue upon return from this method.

   This method does not wait for actively executing tasks to
   terminate.  Use awaitTermination to
   do that.

   There are no guarantees beyond best-effort attempts to stop
   processing actively executing tasks.  This implementation
   cancels tasks via Thread.interrupt(), so any task that
   fails to respond to interrupts may never terminate.

  returns: list of tasks that never commenced execution - `java.util.List<java.lang.Runnable>`

  throws: java.lang.SecurityException - if a security manager exists and shutting down this ExecutorService may manipulate threads that the caller is not permitted to modify because it does not hold RuntimePermission(\"modifyThread\"), or the security manager's checkAccess method denies access."
  (^java.util.List [^ThreadPoolExecutor this]
    (-> this (.shutdownNow))))

