(ns jdk.util.concurrent.ForkJoinTask
  "Abstract base class for tasks that run within a ForkJoinPool.
  A ForkJoinTask is a thread-like entity that is much
  lighter weight than a normal thread.  Huge numbers of tasks and
  subtasks may be hosted by a small number of actual threads in a
  ForkJoinPool, at the price of some usage limitations.

  A `main` ForkJoinTask begins execution when it is
  explicitly submitted to a ForkJoinPool, or, if not already
  engaged in a ForkJoin computation, commenced in the ForkJoinPool.commonPool() via fork(), invoke(), or
  related methods.  Once started, it will usually in turn start other
  subtasks.  As indicated by the name of this class, many programs
  using ForkJoinTask employ only methods fork() and
  join(), or derivatives such as invokeAll.  However, this class also
  provides a number of other methods that can come into play in
  advanced usages, as well as extension mechanics that allow support
  of new forms of fork/join processing.

  A ForkJoinTask is a lightweight form of Future.
  The efficiency of ForkJoinTasks stems from a set of
  restrictions (that are only partially statically enforceable)
  reflecting their main use as computational tasks calculating pure
  functions or operating on purely isolated objects.  The primary
  coordination mechanisms are fork(), that arranges
  asynchronous execution, and join(), that doesn't proceed
  until the task's result has been computed.  Computations should
  ideally avoid synchronized methods or blocks, and should
  minimize other blocking synchronization apart from joining other
  tasks or using synchronizers such as Phasers that are advertised to
  cooperate with fork/join scheduling. Subdividable tasks should also
  not perform blocking I/O, and should ideally access variables that
  are completely independent of those accessed by other running
  tasks. These guidelines are loosely enforced by not permitting
  checked exceptions such as IOExceptions to be
  thrown. However, computations may still encounter unchecked
  exceptions, that are rethrown to callers attempting to join
  them. These exceptions may additionally include RejectedExecutionException stemming from internal resource
  exhaustion, such as failure to allocate internal task
  queues. Rethrown exceptions behave in the same way as regular
  exceptions, but, when possible, contain stack traces (as displayed
  for example using ex.printStackTrace()) of both the thread
  that initiated the computation as well as the thread actually
  encountering the exception; minimally only the latter.

  It is possible to define and use ForkJoinTasks that may block,
  but doing do requires three further considerations: (1) Completion
  of few if any other tasks should be dependent on a task
  that blocks on external synchronization or I/O. Event-style async
  tasks that are never joined (for example, those subclassing CountedCompleter) often fall into this category.  (2) To minimize
  resource impact, tasks should be small; ideally performing only the
  (possibly) blocking action. (3) Unless the ForkJoinPool.ManagedBlocker API is used, or the number of possibly
  blocked tasks is known to be less than the pool's ForkJoinPool.getParallelism() level, the pool cannot guarantee that
  enough threads will be available to ensure progress or good
  performance.

  The primary method for awaiting completion and extracting
  results of a task is join(), but there are several variants:
  The Future.get() methods support interruptible and/or timed
  waits for completion and report results using Future
  conventions. Method invoke() is semantically
  equivalent to fork(); join() but always attempts to begin
  execution in the current thread. The `quiet` forms of
  these methods do not extract results or report exceptions. These
  may be useful when a set of tasks are being executed, and you need
  to delay processing of results or exceptions until all complete.
  Method invokeAll (available in multiple versions)
  performs the most common form of parallel invocation: forking a set
  of tasks and joining them all.

  In the most typical usages, a fork-join pair act like a call
  (fork) and return (join) from a parallel recursive function. As is
  the case with other forms of recursive calls, returns (joins)
  should be performed innermost-first. For example, a.fork();
  b.fork(); b.join(); a.join(); is likely to be substantially more
  efficient than joining a before b.

  The execution status of tasks may be queried at several levels
  of detail: isDone() is true if a task completed in any way
  (including the case where a task was cancelled without executing);
  isCompletedNormally() is true if a task completed without
  cancellation or encountering an exception; isCancelled() is
  true if the task was cancelled (in which case getException()
  returns a CancellationException); and
  isCompletedAbnormally() is true if a task was either
  cancelled or encountered an exception, in which case getException() will return either the encountered exception or
  CancellationException.

  The ForkJoinTask class is not usually directly subclassed.
  Instead, you subclass one of the abstract classes that support a
  particular style of fork/join processing, typically RecursiveAction for most computations that do not return results,
  RecursiveTask for those that do, and CountedCompleter for those in which completed actions trigger
  other actions.  Normally, a concrete ForkJoinTask subclass declares
  fields comprising its parameters, established in a constructor, and
  then defines a compute method that somehow uses the control
  methods supplied by this base class.

  Method join() and its variants are appropriate for use
  only when completion dependencies are acyclic; that is, the
  parallel computation can be described as a directed acyclic graph
  (DAG). Otherwise, executions may encounter a form of deadlock as
  tasks cyclically wait for each other.  However, this framework
  supports other methods and techniques (for example the use of
  Phaser, helpQuiesce(), and complete(V)) that
  may be of use in constructing custom subclasses for problems that
  are not statically structured as DAGs. To support such usages, a
  ForkJoinTask may be atomically tagged with a short
  value using setForkJoinTaskTag(short) or compareAndSetForkJoinTaskTag(short, short) and checked using getForkJoinTaskTag(). The ForkJoinTask implementation does not use
  these protected methods or tags for any purpose, but they
  may be of use in the construction of specialized subclasses.  For
  example, parallel graph traversals can use the supplied methods to
  avoid revisiting nodes/tasks that have already been processed.
  (Method names for tagging are bulky in part to encourage definition
  of methods that reflect their usage patterns.)

  Most base support methods are final, to prevent
  overriding of implementations that are intrinsically tied to the
  underlying lightweight task scheduling framework.  Developers
  creating new basic styles of fork/join processing should minimally
  implement protected methods exec(), setRawResult(V), and getRawResult(), while also introducing
  an abstract computational method that can be implemented in its
  subclasses, possibly relying on other protected methods
  provided by this class.

  ForkJoinTasks should perform relatively small amounts of
  computation. Large tasks should be split into smaller subtasks,
  usually via recursive decomposition. As a very rough rule of thumb,
  a task should perform more than 100 and less than 10000 basic
  computational steps, and should avoid indefinite looping. If tasks
  are too big, then parallelism cannot improve throughput. If too
  small, then memory and internal task maintenance overhead may
  overwhelm processing.

  This class provides adapt methods for Runnable
  and Callable, that may be of use when mixing execution of
  ForkJoinTasks with other kinds of tasks. When all tasks are
  of this form, consider using a pool constructed in asyncMode.

  ForkJoinTasks are Serializable, which enables them to be
  used in extensions such as remote execution frameworks. It is
  sensible to serialize tasks only before or after, but not during,
  execution. Serialization is not relied on during execution itself."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ForkJoinTask]))

(defn ->fork-join-task
  "Constructor."
  ([]
    (new ForkJoinTask )))

(defn *invoke-all
  "Forks the given tasks, returning when isDone holds for
   each task or an (unchecked) exception is encountered, in which
   case the exception is rethrown. If more than one task
   encounters an exception, then this method throws any one of
   these exceptions. If any task encounters an exception, the
   other may be cancelled. However, the execution status of
   individual tasks is not guaranteed upon exceptional return. The
   status of each task may be obtained using getException() and related methods to check if they have been
   cancelled, completed normally or exceptionally, or left
   unprocessed.

  t-1 - the first task - `java.util.concurrent.ForkJoinTask<?>`
  t-2 - the second task - `java.util.concurrent.ForkJoinTask<?>`

  throws: java.lang.NullPointerException - if any task is null"
  ([t-1 t-2]
    (ForkJoinTask/invokeAll t-1 t-2))
  ([tasks]
    (ForkJoinTask/invokeAll tasks)))

(defn *help-quiesce
  "Possibly executes tasks until the pool hosting the current task
   is quiescent. This method may
   be of use in designs in which many tasks are forked, but none
   are explicitly joined, instead executing them until all are
   processed."
  ([]
    (ForkJoinTask/helpQuiesce )))

(defn *get-pool
  "Returns the pool hosting the current task execution, or null
   if this task is executing outside of any ForkJoinPool.

  returns: the pool, or null if none - `java.util.concurrent.ForkJoinPool`"
  ([]
    (ForkJoinTask/getPool )))

(defn *in-fork-join-pool
  "Returns true if the current thread is a ForkJoinWorkerThread executing as a ForkJoinPool computation.

  returns: true if the current thread is a ForkJoinWorkerThread executing as a ForkJoinPool computation,
   or false otherwise - `boolean`"
  ([]
    (ForkJoinTask/inForkJoinPool )))

(defn *get-queued-task-count
  "Returns an estimate of the number of tasks that have been
   forked by the current worker thread but not yet executed. This
   value may be useful for heuristic decisions about whether to
   fork other tasks.

  returns: the number of tasks - `int`"
  ([]
    (ForkJoinTask/getQueuedTaskCount )))

(defn *get-surplus-queued-task-count
  "Returns an estimate of how many more locally queued tasks are
   held by the current worker thread than there are other worker
   threads that might steal them, or zero if this thread is not
   operating in a ForkJoinPool. This value may be useful for
   heuristic decisions about whether to fork other tasks. In many
   usages of ForkJoinTasks, at steady state, each worker should
   aim to maintain a small constant surplus (for example, 3) of
   tasks, and to process computations locally if this threshold is
   exceeded.

  returns: the surplus number of tasks, which may be negative - `int`"
  ([]
    (ForkJoinTask/getSurplusQueuedTaskCount )))

(defn *adapt
  "Returns a new ForkJoinTask that performs the run
   method of the given Runnable as its action, and returns
   the given result upon join().

  runnable - the runnable action - `java.lang.Runnable`
  result - the result upon completion - `T`

  returns: the task - `<T> java.util.concurrent.ForkJoinTask<T>`"
  ([runnable result]
    (ForkJoinTask/adapt runnable result))
  ([runnable]
    (ForkJoinTask/adapt runnable)))

(defn compare-and-set-fork-join-task-tag
  "Atomically conditionally sets the tag value for this task.
   Among other applications, tags can be used as visit markers
   in tasks operating on graphs, as in methods that check: if (task.compareAndSetForkJoinTaskTag((short)0, (short)1))
   before processing, otherwise exiting because the node has
   already been visited.

  e - the expected tag value - `short`
  tag - the new tag value - `short`

  returns: true if successful; i.e., the current value was
   equal to e and is now tag. - `boolean`"
  ([this e tag]
    (-> this (.compareAndSetForkJoinTaskTag e tag))))

(defn invoke
  "Commences performing this task, awaits its completion if
   necessary, and returns its result, or throws an (unchecked)
   RuntimeException or Error if the underlying
   computation did so.

  returns: the computed result - `ForkJoinTask.V`"
  ([this]
    (-> this (.invoke))))

(defn quietly-invoke
  "Commences performing this task and awaits its completion if
   necessary, without returning its result or throwing its
   exception."
  ([this]
    (-> this (.quietlyInvoke))))

(defn try-unfork
  "Tries to unschedule this task for execution. This method will
   typically (but is not guaranteed to) succeed if this task is
   the most recently forked task by the current thread, and has
   not commenced executing in another thread.  This method may be
   useful when arranging alternative local processing of tasks
   that could have been, but were not, stolen.

  returns: true if unforked - `boolean`"
  ([this]
    (-> this (.tryUnfork))))

(defn cancel
  "Attempts to cancel execution of this task. This attempt will
   fail if the task has already completed or could not be
   cancelled for some other reason. If successful, and this task
   has not started when cancel is called, execution of
   this task is suppressed. After this method returns
   successfully, unless there is an intervening call to reinitialize(), subsequent calls to isCancelled(),
   isDone(), and cancel will return true
   and calls to join() and related methods will result in
   CancellationException.

   This method may be overridden in subclasses, but if so, must
   still ensure that these properties hold. In particular, the
   cancel method itself must not throw exceptions.

   This method is designed to be invoked by other
   tasks. To terminate the current task, you can just return or
   throw an unchecked exception from its computation method, or
   invoke completeExceptionally(Throwable).

  may-interrupt-if-running - this value has no effect in the default implementation because interrupts are not used to control cancellation. - `boolean`

  returns: true if this task is now cancelled - `boolean`"
  ([this may-interrupt-if-running]
    (-> this (.cancel may-interrupt-if-running))))

(defn cancelled?
  "Description copied from interface: Future

  returns: true if this task was cancelled before it completed - `boolean`"
  ([this]
    (-> this (.isCancelled))))

(defn complete
  "Completes this task, and if not already aborted or cancelled,
   returning the given value as the result of subsequent
   invocations of join and related operations. This method
   may be used to provide results for asynchronous tasks, or to
   provide alternative handling for tasks that would not otherwise
   complete normally. Its use in other situations is
   discouraged. This method is overridable, but overridden
   versions must invoke super implementation to maintain
   guarantees.

  value - the result value for this task - `ForkJoinTask.V`"
  ([this value]
    (-> this (.complete value))))

(defn get-fork-join-task-tag
  "Returns the tag for this task.

  returns: the tag for this task - `short`"
  ([this]
    (-> this (.getForkJoinTaskTag))))

(defn complete-exceptionally
  "Completes this task abnormally, and if not already aborted or
   cancelled, causes it to throw the given exception upon
   join and related operations. This method may be used
   to induce exceptions in asynchronous tasks, or to force
   completion of tasks that would not otherwise complete.  Its use
   in other situations is discouraged.  This method is
   overridable, but overridden versions must invoke super
   implementation to maintain guarantees.

  ex - the exception to throw. If this exception is not a RuntimeException or Error, the actual exception thrown will be a RuntimeException with cause ex. - `java.lang.Throwable`"
  ([this ex]
    (-> this (.completeExceptionally ex))))

(defn completed-abnormally?
  "Returns true if this task threw an exception or was cancelled.

  returns: true if this task threw an exception or was cancelled - `boolean`"
  ([this]
    (-> this (.isCompletedAbnormally))))

(defn reinitialize
  "Resets the internal bookkeeping state of this task, allowing a
   subsequent fork. This method allows repeated reuse of
   this task, but only if reuse occurs when this task has either
   never been forked, or has been forked, then completed and all
   outstanding joins of this task have also completed. Effects
   under any other usage conditions are not guaranteed.
   This method may be useful when executing
   pre-constructed trees of subtasks in loops.

   Upon completion of this method, isDone() reports
   false, and getException() reports null. However, the value returned by getRawResult is
   unaffected. To clear this value, you can invoke setRawResult(null)."
  ([this]
    (-> this (.reinitialize))))

(defn get-exception
  "Returns the exception thrown by the base computation, or a
   CancellationException if cancelled, or null if
   none or if the method has not yet completed.

  returns: the exception, or null if none - `java.lang.Throwable`"
  ([this]
    (-> this (.getException))))

(defn get-raw-result
  "Returns the result that would be returned by join(), even
   if this task completed abnormally, or null if this task
   is not known to have been completed.  This method is designed
   to aid debugging, as well as to support extensions. Its use in
   any other context is discouraged.

  returns: the result, or null if not completed - `ForkJoinTask.V`"
  ([this]
    (-> this (.getRawResult))))

(defn set-fork-join-task-tag
  "Atomically sets the tag value for this task.

  tag - the tag value - `short`

  returns: the previous value of the tag - `short`"
  ([this tag]
    (-> this (.setForkJoinTaskTag tag))))

(defn completed-normally?
  "Returns true if this task completed without throwing an
   exception and was not cancelled.

  returns: true if this task completed without throwing an
   exception and was not cancelled - `boolean`"
  ([this]
    (-> this (.isCompletedNormally))))

(defn join
  "Returns the result of the computation when it is
   done.  This method differs from get() in that
   abnormal completion results in RuntimeException or
   Error, not ExecutionException, and that
   interrupts of the calling thread do not cause the
   method to abruptly return by throwing InterruptedException.

  returns: the computed result - `ForkJoinTask.V`"
  ([this]
    (-> this (.join))))

(defn done?
  "Description copied from interface: Future

  returns: true if this task completed - `boolean`"
  ([this]
    (-> this (.isDone))))

(defn fork
  "Arranges to asynchronously execute this task in the pool the
   current task is running in, if applicable, or using the ForkJoinPool.commonPool() if not inForkJoinPool().  While
   it is not necessarily enforced, it is a usage error to fork a
   task more than once unless it has completed and been
   reinitialized.  Subsequent modifications to the state of this
   task or any data it operates on are not necessarily
   consistently observable by any thread other than the one
   executing it unless preceded by a call to join() or
   related methods, or a call to isDone() returning true.

  returns: this, to simplify usage - `java.util.concurrent.ForkJoinTask<ForkJoinTask.V>`"
  ([this]
    (-> this (.fork))))

(defn quietly-join
  "Joins this task, without returning its result or throwing its
   exception. This method may be useful when processing
   collections of tasks when some have been cancelled or otherwise
   known to have aborted."
  ([this]
    (-> this (.quietlyJoin))))

(defn quietly-complete
  "Completes this task normally without setting a value. The most
   recent value established by setRawResult(V) (or null by default) will be returned as the result of subsequent
   invocations of join and related operations."
  ([this]
    (-> this (.quietlyComplete))))

(defn get
  "Waits if necessary for at most the given time for the computation
   to complete, and then retrieves its result, if available.

  timeout - the maximum time to wait - `long`
  unit - the time unit of the timeout argument - `java.util.concurrent.TimeUnit`

  returns: the computed result - `ForkJoinTask.V`

  throws: java.util.concurrent.CancellationException - if the computation was cancelled"
  ([this timeout unit]
    (-> this (.get timeout unit)))
  ([this]
    (-> this (.get))))

