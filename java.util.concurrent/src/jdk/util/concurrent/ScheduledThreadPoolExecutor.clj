(ns jdk.util.concurrent.ScheduledThreadPoolExecutor
  "A ThreadPoolExecutor that can additionally schedule
  commands to run after a given delay, or to execute
  periodically. This class is preferable to Timer
  when multiple worker threads are needed, or when the additional
  flexibility or capabilities of ThreadPoolExecutor (which
  this class extends) are required.

  Delayed tasks execute no sooner than they are enabled, but
  without any real-time guarantees about when, after they are
  enabled, they will commence. Tasks scheduled for exactly the same
  execution time are enabled in first-in-first-out (FIFO) order of
  submission.

  When a submitted task is cancelled before it is run, execution
  is suppressed. By default, such a cancelled task is not
  automatically removed from the work queue until its delay
  elapses. While this enables further inspection and monitoring, it
  may also cause unbounded retention of cancelled tasks. To avoid
  this, set setRemoveOnCancelPolicy(boolean) to true, which
  causes tasks to be immediately removed from the work queue at
  time of cancellation.

  Successive executions of a task scheduled via
  scheduleAtFixedRate or
  scheduleWithFixedDelay do not overlap. While different
  executions may be performed by different threads, the effects of
  prior executions happen-before
  those of subsequent ones.

  While this class inherits from ThreadPoolExecutor, a few
  of the inherited tuning methods are not useful for it. In
  particular, because it acts as a fixed-sized pool using
  corePoolSize threads and an unbounded queue, adjustments
  to maximumPoolSize have no useful effect. Additionally, it
  is almost never a good idea to set corePoolSize to zero or
  use allowCoreThreadTimeOut because this may leave the pool
  without threads to handle tasks once they become eligible to run.

  Extension notes: This class overrides the
  execute and
  submit
  methods to generate internal ScheduledFuture objects to
  control per-task delays and scheduling.  To preserve
  functionality, any further overrides of these methods in
  subclasses must invoke superclass versions, which effectively
  disables additional task customization.  However, this class
  provides alternative protected extension method
  decorateTask (one version each for Runnable and
  Callable) that can be used to customize the concrete task
  types used to execute commands entered via execute,
  submit, schedule, scheduleAtFixedRate,
  and scheduleWithFixedDelay.  By default, a
  ScheduledThreadPoolExecutor uses a task type extending
  FutureTask. However, this may be modified or replaced using
  subclasses of the form:



  public class CustomScheduledExecutor extends ScheduledThreadPoolExecutor {

    static class CustomTask<V> implements RunnableScheduledFuture<V> { ... }

    protected <V> RunnableScheduledFuture<V> decorateTask(
                 Runnable r, RunnableScheduledFuture<V> task) {
        return new CustomTask<V>(r, task);
    }

    protected <V> RunnableScheduledFuture<V> decorateTask(
                 Callable<V> c, RunnableScheduledFuture<V> task) {
        return new CustomTask<V>(c, task);
    }
    // ... add constructors, etc.
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ScheduledThreadPoolExecutor]))

(defn ->scheduled-thread-pool-executor
  "Constructor.

  Creates a new ScheduledThreadPoolExecutor with the given
   initial parameters.

  core-pool-size - the number of threads to keep in the pool, even if they are idle, unless allowCoreThreadTimeOut is set - `int`
  thread-factory - the factory to use when the executor creates a new thread - `java.util.concurrent.ThreadFactory`
  handler - the handler to use when execution is blocked because the thread bounds and queue capacities are reached - `java.util.concurrent.RejectedExecutionHandler`

  throws: java.lang.IllegalArgumentException - if corePoolSize < 0"
  ([core-pool-size thread-factory handler]
    (new ScheduledThreadPoolExecutor core-pool-size thread-factory handler))
  ([core-pool-size thread-factory]
    (new ScheduledThreadPoolExecutor core-pool-size thread-factory))
  ([core-pool-size]
    (new ScheduledThreadPoolExecutor core-pool-size)))

(defn set-remove-on-cancel-policy
  "Sets the policy on whether cancelled tasks should be immediately
   removed from the work queue at time of cancellation.  This value is
   by default false.

  value - if true, remove on cancellation, else don't - `boolean`"
  ([this value]
    (-> this (.setRemoveOnCancelPolicy value))))

(defn set-execute-existing-delayed-tasks-after-shutdown-policy
  "Sets the policy on whether to execute existing delayed
   tasks even when this executor has been shutdown.
   In this case, these tasks will only terminate upon
   shutdownNow, or after setting the policy to
   false when already shutdown.
   This value is by default true.

  value - if true, execute after shutdown, else don't - `boolean`"
  ([this value]
    (-> this (.setExecuteExistingDelayedTasksAfterShutdownPolicy value))))

(defn get-execute-existing-delayed-tasks-after-shutdown-policy?
  "Gets the policy on whether to execute existing delayed
   tasks even when this executor has been shutdown.
   In this case, these tasks will only terminate upon
   shutdownNow, or after setting the policy to
   false when already shutdown.
   This value is by default true.

  returns: true if will execute after shutdown - `boolean`"
  ([this]
    (-> this (.getExecuteExistingDelayedTasksAfterShutdownPolicy))))

(defn schedule
  "Description copied from interface: ScheduledExecutorService

  command - the task to execute - `java.lang.Runnable`
  delay - the time from now to delay execution - `long`
  unit - the time unit of the delay parameter - `java.util.concurrent.TimeUnit`

  returns: a ScheduledFuture representing pending completion of
           the task and whose get() method will return
           null upon completion - `java.util.concurrent.ScheduledFuture<?>`

  throws: java.util.concurrent.RejectedExecutionException - if the task cannot be scheduled for execution"
  ([this command delay unit]
    (-> this (.schedule command delay unit))))

(defn shutdown
  "Initiates an orderly shutdown in which previously submitted
   tasks are executed, but no new tasks will be accepted.
   Invocation has no additional effect if already shut down.

   This method does not wait for previously submitted tasks to
   complete execution.  Use awaitTermination
   to do that.

   If the ExecuteExistingDelayedTasksAfterShutdownPolicy
   has been set false, existing delayed tasks whose delays
   have not yet elapsed are cancelled.  And unless the ContinueExistingPeriodicTasksAfterShutdownPolicy has been set
   true, future executions of existing periodic tasks will
   be cancelled.

  throws: java.lang.SecurityException - if a security manager exists and shutting down this ExecutorService may manipulate threads that the caller is not permitted to modify because it does not hold RuntimePermission(`modifyThread`), or the security manager's checkAccess method denies access."
  ([this]
    (-> this (.shutdown))))

(defn submit
  "Description copied from interface: ExecutorService

  task - the task to submit - `java.lang.Runnable`
  result - the result to return - `T`

  returns: a Future representing pending completion of the task - `<T> java.util.concurrent.Future<T>`

  throws: java.util.concurrent.RejectedExecutionException - if the task cannot be scheduled for execution"
  ([this task result]
    (-> this (.submit task result)))
  ([this task]
    (-> this (.submit task))))

(defn schedule-with-fixed-delay
  "Description copied from interface: ScheduledExecutorService

  command - the task to execute - `java.lang.Runnable`
  initial-delay - the time to delay first execution - `long`
  delay - the delay between the termination of one execution and the commencement of the next - `long`
  unit - the time unit of the initialDelay and delay parameters - `java.util.concurrent.TimeUnit`

  returns: a ScheduledFuture representing pending completion of
           the task, and whose get() method will throw an
           exception upon cancellation - `java.util.concurrent.ScheduledFuture<?>`

  throws: java.util.concurrent.RejectedExecutionException - if the task cannot be scheduled for execution"
  ([this command initial-delay delay unit]
    (-> this (.scheduleWithFixedDelay command initial-delay delay unit))))

(defn schedule-at-fixed-rate
  "Description copied from interface: ScheduledExecutorService

  command - the task to execute - `java.lang.Runnable`
  initial-delay - the time to delay first execution - `long`
  period - the period between successive executions - `long`
  unit - the time unit of the initialDelay and period parameters - `java.util.concurrent.TimeUnit`

  returns: a ScheduledFuture representing pending completion of
           the task, and whose get() method will throw an
           exception upon cancellation - `java.util.concurrent.ScheduledFuture<?>`

  throws: java.util.concurrent.RejectedExecutionException - if the task cannot be scheduled for execution"
  ([this command initial-delay period unit]
    (-> this (.scheduleAtFixedRate command initial-delay period unit))))

(defn get-continue-existing-periodic-tasks-after-shutdown-policy?
  "Gets the policy on whether to continue executing existing
   periodic tasks even when this executor has been shutdown.
   In this case, these tasks will only terminate upon
   shutdownNow or after setting the policy to
   false when already shutdown.
   This value is by default false.

  returns: true if will continue after shutdown - `boolean`"
  ([this]
    (-> this (.getContinueExistingPeriodicTasksAfterShutdownPolicy))))

(defn execute
  "Executes command with zero required delay.
   This has effect equivalent to
   schedule(command, 0, anyUnit).
   Note that inspections of the queue and of the list returned by
   shutdownNow will access the zero-delayed
   ScheduledFuture, not the command itself.

   A consequence of the use of ScheduledFuture objects is
   that afterExecute is always
   called with a null second Throwable argument, even if the
   command terminated abruptly.  Instead, the Throwable
   thrown by such a task can be obtained via Future.get().

  command - the task to execute - `java.lang.Runnable`

  throws: java.util.concurrent.RejectedExecutionException - at discretion of RejectedExecutionHandler, if the task cannot be accepted for execution because the executor has been shut down"
  ([this command]
    (-> this (.execute command))))

(defn set-continue-existing-periodic-tasks-after-shutdown-policy
  "Sets the policy on whether to continue executing existing
   periodic tasks even when this executor has been shutdown.
   In this case, these tasks will only terminate upon
   shutdownNow or after setting the policy to
   false when already shutdown.
   This value is by default false.

  value - if true, continue after shutdown, else don't - `boolean`"
  ([this value]
    (-> this (.setContinueExistingPeriodicTasksAfterShutdownPolicy value))))

(defn get-queue
  "Returns the task queue used by this executor.  Each element of
   this queue is a ScheduledFuture, including those
   tasks submitted using execute which are for scheduling
   purposes used as the basis of a zero-delay
   ScheduledFuture.  Iteration over this queue is
   not guaranteed to traverse tasks in the order in
   which they will execute.

  returns: the task queue - `java.util.concurrent.BlockingQueue<java.lang.Runnable>`"
  ([this]
    (-> this (.getQueue))))

(defn shutdown-now
  "Attempts to stop all actively executing tasks, halts the
   processing of waiting tasks, and returns a list of the tasks
   that were awaiting execution.

   This method does not wait for actively executing tasks to
   terminate.  Use awaitTermination to
   do that.

   There are no guarantees beyond best-effort attempts to stop
   processing actively executing tasks.  This implementation
   cancels tasks via Thread.interrupt(), so any task that
   fails to respond to interrupts may never terminate.

  returns: list of tasks that never commenced execution.
           Each element of this list is a ScheduledFuture,
           including those tasks submitted using execute,
           which are for scheduling purposes used as the basis of a
           zero-delay ScheduledFuture. - `java.util.List<java.lang.Runnable>`

  throws: java.lang.SecurityException - if a security manager exists and shutting down this ExecutorService may manipulate threads that the caller is not permitted to modify because it does not hold RuntimePermission(`modifyThread`), or the security manager's checkAccess method denies access."
  ([this]
    (-> this (.shutdownNow))))

(defn get-remove-on-cancel-policy?
  "Gets the policy on whether cancelled tasks should be immediately
   removed from the work queue at time of cancellation.  This value is
   by default false.

  returns: true if cancelled tasks are immediately removed
           from the queue - `boolean`"
  ([this]
    (-> this (.getRemoveOnCancelPolicy))))

