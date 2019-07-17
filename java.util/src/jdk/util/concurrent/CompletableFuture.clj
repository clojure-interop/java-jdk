(ns jdk.util.concurrent.CompletableFuture
  "A Future that may be explicitly completed (setting its
  value and status), and may be used as a CompletionStage,
  supporting dependent functions and actions that trigger upon its
  completion.

  When two or more threads attempt to
  complete,
  completeExceptionally, or
  cancel
  a CompletableFuture, only one of them succeeds.

  In addition to these and related methods for directly
  manipulating status and results, CompletableFuture implements
  interface CompletionStage with the following policies:

  Actions supplied for dependent completions of
  non-async methods may be performed by the thread that
  completes the current CompletableFuture, or by any other caller of
  a completion method.

  All async methods without an explicit Executor
  argument are performed using the ForkJoinPool.commonPool()
  (unless it does not support a parallelism level of at least two, in
  which case, a new Thread is created to run each task).  To simplify
  monitoring, debugging, and tracking, all generated asynchronous
  tasks are instances of the marker interface CompletableFuture.AsynchronousCompletionTask.

  All CompletionStage methods are implemented independently of
  other public methods, so the behavior of one method is not impacted
  by overrides of others in subclasses.

  CompletableFuture also implements Future with the following
  policies:

  Since (unlike FutureTask) this class has no direct
  control over the computation that causes it to be completed,
  cancellation is treated as just another form of exceptional
  completion.  Method cancel has the same effect as
  completeExceptionally(new CancellationException()). Method
  isCompletedExceptionally() can be used to determine if a
  CompletableFuture completed in any exceptional fashion.

  In case of exceptional completion with a CompletionException,
  methods get() and get(long, TimeUnit) throw an
  ExecutionException with the same cause as held in the
  corresponding CompletionException.  To simplify usage in most
  contexts, this class also defines methods join() and
  getNow(T) that instead throw the CompletionException directly
  in these cases."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent CompletableFuture]))

(defn ->completable-future
  "Constructor.

  Creates a new incomplete CompletableFuture."
  ([]
    (new CompletableFuture )))

(defn *supply-async
  "Returns a new CompletableFuture that is asynchronously completed
   by a task running in the given executor with the value obtained
   by calling the given Supplier.

  supplier - a function returning the value to be used to complete the returned CompletableFuture - `java.util.function.Supplier<U>`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletableFuture - `<U> java.util.concurrent.CompletableFuture<U>`"
  ([^java.util.function.Supplier supplier ^java.util.concurrent.Executor executor]
    (CompletableFuture/supplyAsync supplier executor))
  ([^java.util.function.Supplier supplier]
    (CompletableFuture/supplyAsync supplier)))

(defn *run-async
  "Returns a new CompletableFuture that is asynchronously completed
   by a task running in the given executor after it runs the given
   action.

  runnable - the action to run before completing the returned CompletableFuture - `java.lang.Runnable`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletableFuture - `java.util.concurrent.CompletableFuture<java.lang.Void>`"
  ([^java.lang.Runnable runnable ^java.util.concurrent.Executor executor]
    (CompletableFuture/runAsync runnable executor))
  ([^java.lang.Runnable runnable]
    (CompletableFuture/runAsync runnable)))

(defn *completed-future
  "Returns a new CompletableFuture that is already completed with
   the given value.

  value - the value - `U`

  returns: the completed CompletableFuture - `<U> java.util.concurrent.CompletableFuture<U>`"
  ([value]
    (CompletableFuture/completedFuture value)))

(defn *all-of
  "Returns a new CompletableFuture that is completed when all of
   the given CompletableFutures complete.  If any of the given
   CompletableFutures complete exceptionally, then the returned
   CompletableFuture also does so, with a CompletionException
   holding this exception as its cause.  Otherwise, the results,
   if any, of the given CompletableFutures are not reflected in
   the returned CompletableFuture, but may be obtained by
   inspecting them individually. If no CompletableFutures are
   provided, returns a CompletableFuture completed with the value
   null.

   Among the applications of this method is to await completion
   of a set of independent CompletableFutures before continuing a
   program, as in: CompletableFuture.allOf(c1, c2,
   c3).join();.

  cfs - the CompletableFutures - `java.util.concurrent.CompletableFuture<?>`

  returns: a new CompletableFuture that is completed when all of the
   given CompletableFutures complete - `java.util.concurrent.CompletableFuture<java.lang.Void>`

  throws: java.lang.NullPointerException - if the array or any of its elements are null"
  ([^java.util.concurrent.CompletableFuture cfs]
    (CompletableFuture/allOf cfs)))

(defn *any-of
  "Returns a new CompletableFuture that is completed when any of
   the given CompletableFutures complete, with the same result.
   Otherwise, if it completed exceptionally, the returned
   CompletableFuture also does so, with a CompletionException
   holding this exception as its cause.  If no CompletableFutures
   are provided, returns an incomplete CompletableFuture.

  cfs - the CompletableFutures - `java.util.concurrent.CompletableFuture<?>`

  returns: a new CompletableFuture that is completed with the
   result or exception of any of the given CompletableFutures when
   one completes - `java.util.concurrent.CompletableFuture<java.lang.Object>`

  throws: java.lang.NullPointerException - if the array or any of its elements are null"
  ([^java.util.concurrent.CompletableFuture cfs]
    (CompletableFuture/anyOf cfs)))

(defn run-after-either-async
  "Description copied from interface: CompletionStage

  other - the other CompletionStage - `java.util.concurrent.CompletionStage<?>`
  action - the action to perform before completing the returned CompletionStage - `java.lang.Runnable`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletionStage - `java.util.concurrent.CompletableFuture<java.lang.Void>`"
  ([^java.util.concurrent.CompletableFuture this ^java.util.concurrent.CompletionStage other ^java.lang.Runnable action ^java.util.concurrent.Executor executor]
    (-> this (.runAfterEitherAsync other action executor)))
  ([^java.util.concurrent.CompletableFuture this ^java.util.concurrent.CompletionStage other ^java.lang.Runnable action]
    (-> this (.runAfterEitherAsync other action))))

(defn handle
  "Description copied from interface: CompletionStage

  fn - the function to use to compute the value of the returned CompletionStage - `U>`

  returns: the new CompletionStage - `<U> java.util.concurrent.CompletableFuture<U>`"
  ([^java.util.concurrent.CompletableFuture this fn]
    (-> this (.handle fn))))

(defn accept-either
  "Description copied from interface: CompletionStage

  other - the other CompletionStage - `CompletableFuture.T>`
  action - the action to perform before completing the returned CompletionStage - `CompletableFuture.T>`

  returns: the new CompletionStage - `java.util.concurrent.CompletableFuture<java.lang.Void>`"
  ([^java.util.concurrent.CompletableFuture this ^CompletableFuture.T> other ^CompletableFuture.T> action]
    (-> this (.acceptEither other action))))

(defn run-after-both
  "Description copied from interface: CompletionStage

  other - the other CompletionStage - `java.util.concurrent.CompletionStage<?>`
  action - the action to perform before completing the returned CompletionStage - `java.lang.Runnable`

  returns: the new CompletionStage - `java.util.concurrent.CompletableFuture<java.lang.Void>`"
  ([^java.util.concurrent.CompletableFuture this ^java.util.concurrent.CompletionStage other ^java.lang.Runnable action]
    (-> this (.runAfterBoth other action))))

(defn when-complete-async
  "Description copied from interface: CompletionStage

  action - the action to perform - `java.lang.Throwable>`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletionStage - `java.util.concurrent.CompletableFuture<CompletableFuture.T>`"
  ([^java.util.concurrent.CompletableFuture this ^java.lang.Throwable> action ^java.util.concurrent.Executor executor]
    (-> this (.whenCompleteAsync action executor)))
  ([^java.util.concurrent.CompletableFuture this ^java.lang.Throwable> action]
    (-> this (.whenCompleteAsync action))))

(defn cancel
  "If not already completed, completes this CompletableFuture with
   a CancellationException. Dependent CompletableFutures
   that have not already completed will also complete
   exceptionally, with a CompletionException caused by
   this CancellationException.

  may-interrupt-if-running - this value has no effect in this implementation because interrupts are not used to control processing. - `boolean`

  returns: true if this task is now cancelled - `boolean`"
  ([^java.util.concurrent.CompletableFuture this ^Boolean may-interrupt-if-running]
    (-> this (.cancel may-interrupt-if-running))))

(defn obtrude-exception
  "Forcibly causes subsequent invocations of method get()
   and related methods to throw the given exception, whether or
   not already completed. This method is designed for use only in
   error recovery actions, and even in such situations may result
   in ongoing dependent completions using established versus
   overwritten outcomes.

  ex - the exception - `java.lang.Throwable`

  throws: java.lang.NullPointerException - if the exception is null"
  ([^java.util.concurrent.CompletableFuture this ^java.lang.Throwable ex]
    (-> this (.obtrudeException ex))))

(defn then-accept-async
  "Description copied from interface: CompletionStage

  action - the action to perform before completing the returned CompletionStage - `CompletableFuture.T>`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletionStage - `java.util.concurrent.CompletableFuture<java.lang.Void>`"
  ([^java.util.concurrent.CompletableFuture this ^CompletableFuture.T> action ^java.util.concurrent.Executor executor]
    (-> this (.thenAcceptAsync action executor)))
  ([^java.util.concurrent.CompletableFuture this ^CompletableFuture.T> action]
    (-> this (.thenAcceptAsync action))))

(defn to-completable-future
  "Returns this CompletableFuture.

  returns: this CompletableFuture - `java.util.concurrent.CompletableFuture<CompletableFuture.T>`"
  ([^java.util.concurrent.CompletableFuture this]
    (-> this (.toCompletableFuture))))

(defn cancelled?
  "Returns true if this CompletableFuture was cancelled
   before it completed normally.

  returns: true if this CompletableFuture was cancelled
   before it completed normally - `boolean`"
  ([^java.util.concurrent.CompletableFuture this]
    (-> this (.isCancelled))))

(defn obtrude-value
  "Forcibly sets or resets the value subsequently returned by
   method get() and related methods, whether or not
   already completed. This method is designed for use only in
   error recovery actions, and even in such situations may result
   in ongoing dependent completions using established versus
   overwritten outcomes.

  value - the completion value - `CompletableFuture.T`"
  ([^java.util.concurrent.CompletableFuture this ^CompletableFuture.T value]
    (-> this (.obtrudeValue value))))

(defn then-accept-both
  "Description copied from interface: CompletionStage

  other - the other CompletionStage - `U>`
  action - the action to perform before completing the returned CompletionStage - `U>`

  returns: the new CompletionStage - `<U> java.util.concurrent.CompletableFuture<java.lang.Void>`"
  ([^java.util.concurrent.CompletableFuture this other action]
    (-> this (.thenAcceptBoth other action))))

(defn then-run-async
  "Description copied from interface: CompletionStage

  action - the action to perform before completing the returned CompletionStage - `java.lang.Runnable`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletionStage - `java.util.concurrent.CompletableFuture<java.lang.Void>`"
  ([^java.util.concurrent.CompletableFuture this ^java.lang.Runnable action ^java.util.concurrent.Executor executor]
    (-> this (.thenRunAsync action executor)))
  ([^java.util.concurrent.CompletableFuture this ^java.lang.Runnable action]
    (-> this (.thenRunAsync action))))

(defn apply-to-either
  "Description copied from interface: CompletionStage

  other - the other CompletionStage - `CompletableFuture.T>`
  fn - the function to use to compute the value of the returned CompletionStage - `CompletableFuture.T,U>`

  returns: the new CompletionStage - `<U> java.util.concurrent.CompletableFuture<U>`"
  ([^java.util.concurrent.CompletableFuture this ^CompletableFuture.T> other ^CompletableFuture.T,U> fn]
    (-> this (.applyToEither other fn))))

(defn complete
  "If not already completed, sets the value returned by get() and related methods to the given value.

  value - the result value - `CompletableFuture.T`

  returns: true if this invocation caused this CompletableFuture
   to transition to a completed state, else false - `boolean`"
  ([^java.util.concurrent.CompletableFuture this ^CompletableFuture.T value]
    (-> this (.complete value))))

(defn then-apply
  "Description copied from interface: CompletionStage

  fn - the function to use to compute the value of the returned CompletionStage - `U>`

  returns: the new CompletionStage - `<U> java.util.concurrent.CompletableFuture<U>`"
  ([^java.util.concurrent.CompletableFuture this fn]
    (-> this (.thenApply fn))))

(defn run-after-both-async
  "Description copied from interface: CompletionStage

  other - the other CompletionStage - `java.util.concurrent.CompletionStage<?>`
  action - the action to perform before completing the returned CompletionStage - `java.lang.Runnable`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletionStage - `java.util.concurrent.CompletableFuture<java.lang.Void>`"
  ([^java.util.concurrent.CompletableFuture this ^java.util.concurrent.CompletionStage other ^java.lang.Runnable action ^java.util.concurrent.Executor executor]
    (-> this (.runAfterBothAsync other action executor)))
  ([^java.util.concurrent.CompletableFuture this ^java.util.concurrent.CompletionStage other ^java.lang.Runnable action]
    (-> this (.runAfterBothAsync other action))))

(defn accept-either-async
  "Description copied from interface: CompletionStage

  other - the other CompletionStage - `CompletableFuture.T>`
  action - the action to perform before completing the returned CompletionStage - `CompletableFuture.T>`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletionStage - `java.util.concurrent.CompletableFuture<java.lang.Void>`"
  ([^java.util.concurrent.CompletableFuture this ^CompletableFuture.T> other ^CompletableFuture.T> action ^java.util.concurrent.Executor executor]
    (-> this (.acceptEitherAsync other action executor)))
  ([^java.util.concurrent.CompletableFuture this ^CompletableFuture.T> other ^CompletableFuture.T> action]
    (-> this (.acceptEitherAsync other action))))

(defn to-string
  "Returns a string identifying this CompletableFuture, as well as
   its completion state.  The state, in brackets, contains the
   String `Completed Normally` or the String `Completed Exceptionally`, or the String `Not
   completed` followed by the number of CompletableFutures
   dependent upon its completion, if any.

  returns: a string identifying this CompletableFuture, as well as its state - `java.lang.String`"
  ([^java.util.concurrent.CompletableFuture this]
    (-> this (.toString))))

(defn exceptionally
  "Returns a new CompletableFuture that is completed when this
   CompletableFuture completes, with the result of the given
   function of the exception triggering this CompletableFuture's
   completion when it completes exceptionally; otherwise, if this
   CompletableFuture completes normally, then the returned
   CompletableFuture also completes normally with the same value.
   Note: More flexible versions of this functionality are
   available using methods whenComplete and handle.

  fn - the function to use to compute the value of the returned CompletableFuture if this CompletableFuture completed exceptionally - `CompletableFuture.T>`

  returns: the new CompletableFuture - `java.util.concurrent.CompletableFuture<CompletableFuture.T>`"
  ([^java.util.concurrent.CompletableFuture this ^CompletableFuture.T> fn]
    (-> this (.exceptionally fn))))

(defn apply-to-either-async
  "Description copied from interface: CompletionStage

  other - the other CompletionStage - `CompletableFuture.T>`
  fn - the function to use to compute the value of the returned CompletionStage - `CompletableFuture.T,U>`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletionStage - `<U> java.util.concurrent.CompletableFuture<U>`"
  ([^java.util.concurrent.CompletableFuture this ^CompletableFuture.T> other ^CompletableFuture.T,U> fn ^java.util.concurrent.Executor executor]
    (-> this (.applyToEitherAsync other fn executor)))
  ([^java.util.concurrent.CompletableFuture this ^CompletableFuture.T> other ^CompletableFuture.T,U> fn]
    (-> this (.applyToEitherAsync other fn))))

(defn complete-exceptionally
  "If not already completed, causes invocations of get()
   and related methods to throw the given exception.

  ex - the exception - `java.lang.Throwable`

  returns: true if this invocation caused this CompletableFuture
   to transition to a completed state, else false - `boolean`"
  ([^java.util.concurrent.CompletableFuture this ^java.lang.Throwable ex]
    (-> this (.completeExceptionally ex))))

(defn completed-exceptionally?
  "Returns true if this CompletableFuture completed
   exceptionally, in any way. Possible causes include
   cancellation, explicit invocation of completeExceptionally, and abrupt termination of a
   CompletionStage action.

  returns: true if this CompletableFuture completed
   exceptionally - `boolean`"
  ([^java.util.concurrent.CompletableFuture this]
    (-> this (.isCompletedExceptionally))))

(defn when-complete
  "Description copied from interface: CompletionStage

  action - the action to perform - `java.lang.Throwable>`

  returns: the new CompletionStage - `java.util.concurrent.CompletableFuture<CompletableFuture.T>`"
  ([^java.util.concurrent.CompletableFuture this ^java.lang.Throwable> action]
    (-> this (.whenComplete action))))

(defn get-now
  "Returns the result value (or throws any encountered exception)
   if completed, else returns the given valueIfAbsent.

  value-if-absent - the value to return if not completed - `CompletableFuture.T`

  returns: the result value, if completed, else the given valueIfAbsent - `CompletableFuture.T`

  throws: java.util.concurrent.CancellationException - if the computation was cancelled"
  ([^java.util.concurrent.CompletableFuture this ^CompletableFuture.T value-if-absent]
    (-> this (.getNow value-if-absent))))

(defn run-after-either
  "Description copied from interface: CompletionStage

  other - the other CompletionStage - `java.util.concurrent.CompletionStage<?>`
  action - the action to perform before completing the returned CompletionStage - `java.lang.Runnable`

  returns: the new CompletionStage - `java.util.concurrent.CompletableFuture<java.lang.Void>`"
  ([^java.util.concurrent.CompletableFuture this ^java.util.concurrent.CompletionStage other ^java.lang.Runnable action]
    (-> this (.runAfterEither other action))))

(defn get-number-of-dependents
  "Returns the estimated number of CompletableFutures whose
   completions are awaiting completion of this CompletableFuture.
   This method is designed for use in monitoring system state, not
   for synchronization control.

  returns: the number of dependent CompletableFutures - `int`"
  ([^java.util.concurrent.CompletableFuture this]
    (-> this (.getNumberOfDependents))))

(defn then-accept
  "Description copied from interface: CompletionStage

  action - the action to perform before completing the returned CompletionStage - `CompletableFuture.T>`

  returns: the new CompletionStage - `java.util.concurrent.CompletableFuture<java.lang.Void>`"
  ([^java.util.concurrent.CompletableFuture this ^CompletableFuture.T> action]
    (-> this (.thenAccept action))))

(defn join
  "Returns the result value when complete, or throws an
   (unchecked) exception if completed exceptionally. To better
   conform with the use of common functional forms, if a
   computation involved in the completion of this
   CompletableFuture threw an exception, this method throws an
   (unchecked) CompletionException with the underlying
   exception as its cause.

  returns: the result value - `CompletableFuture.T`

  throws: java.util.concurrent.CancellationException - if the computation was cancelled"
  ([^java.util.concurrent.CompletableFuture this]
    (-> this (.join))))

(defn then-compose-async
  "Description copied from interface: CompletionStage

  fn - the function returning a new CompletionStage - `java.util.concurrent.CompletionStage<U>>`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the CompletionStage - `<U> java.util.concurrent.CompletableFuture<U>`"
  ([^java.util.concurrent.CompletableFuture this ^java.util.concurrent.CompletionStage> fn ^java.util.concurrent.Executor executor]
    (-> this (.thenComposeAsync fn executor)))
  ([^java.util.concurrent.CompletableFuture this ^java.util.concurrent.CompletionStage> fn]
    (-> this (.thenComposeAsync fn))))

(defn done?
  "Returns true if completed in any fashion: normally,
   exceptionally, or via cancellation.

  returns: true if completed - `boolean`"
  ([^java.util.concurrent.CompletableFuture this]
    (-> this (.isDone))))

(defn then-combine-async
  "Description copied from interface: CompletionStage

  other - the other CompletionStage - `U>`
  fn - the function to use to compute the value of the returned CompletionStage - `V>`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletionStage - `<U,V> java.util.concurrent.CompletableFuture<V>`"
  ([^java.util.concurrent.CompletableFuture this other fn ^java.util.concurrent.Executor executor]
    (-> this (.thenCombineAsync other fn executor)))
  ([^java.util.concurrent.CompletableFuture this other fn]
    (-> this (.thenCombineAsync other fn))))

(defn then-accept-both-async
  "Description copied from interface: CompletionStage

  other - the other CompletionStage - `U>`
  action - the action to perform before completing the returned CompletionStage - `U>`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletionStage - `<U> java.util.concurrent.CompletableFuture<java.lang.Void>`"
  ([^java.util.concurrent.CompletableFuture this other action ^java.util.concurrent.Executor executor]
    (-> this (.thenAcceptBothAsync other action executor)))
  ([^java.util.concurrent.CompletableFuture this other action]
    (-> this (.thenAcceptBothAsync other action))))

(defn then-run
  "Description copied from interface: CompletionStage

  action - the action to perform before completing the returned CompletionStage - `java.lang.Runnable`

  returns: the new CompletionStage - `java.util.concurrent.CompletableFuture<java.lang.Void>`"
  ([^java.util.concurrent.CompletableFuture this ^java.lang.Runnable action]
    (-> this (.thenRun action))))

(defn get
  "Waits if necessary for at most the given time for this future
   to complete, and then returns its result, if available.

  timeout - the maximum time to wait - `long`
  unit - the time unit of the timeout argument - `java.util.concurrent.TimeUnit`

  returns: the result value - `CompletableFuture.T`

  throws: java.util.concurrent.CancellationException - if this future was cancelled"
  ([^java.util.concurrent.CompletableFuture this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.get timeout unit)))
  ([^java.util.concurrent.CompletableFuture this]
    (-> this (.get))))

(defn handle-async
  "Description copied from interface: CompletionStage

  fn - the function to use to compute the value of the returned CompletionStage - `U>`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletionStage - `<U> java.util.concurrent.CompletableFuture<U>`"
  ([^java.util.concurrent.CompletableFuture this fn ^java.util.concurrent.Executor executor]
    (-> this (.handleAsync fn executor)))
  ([^java.util.concurrent.CompletableFuture this fn]
    (-> this (.handleAsync fn))))

(defn then-compose
  "Description copied from interface: CompletionStage

  fn - the function returning a new CompletionStage - `java.util.concurrent.CompletionStage<U>>`

  returns: the CompletionStage - `<U> java.util.concurrent.CompletableFuture<U>`"
  ([^java.util.concurrent.CompletableFuture this ^java.util.concurrent.CompletionStage> fn]
    (-> this (.thenCompose fn))))

(defn then-apply-async
  "Description copied from interface: CompletionStage

  fn - the function to use to compute the value of the returned CompletionStage - `U>`
  executor - the executor to use for asynchronous execution - `java.util.concurrent.Executor`

  returns: the new CompletionStage - `<U> java.util.concurrent.CompletableFuture<U>`"
  ([^java.util.concurrent.CompletableFuture this fn ^java.util.concurrent.Executor executor]
    (-> this (.thenApplyAsync fn executor)))
  ([^java.util.concurrent.CompletableFuture this fn]
    (-> this (.thenApplyAsync fn))))

(defn then-combine
  "Description copied from interface: CompletionStage

  other - the other CompletionStage - `U>`
  fn - the function to use to compute the value of the returned CompletionStage - `V>`

  returns: the new CompletionStage - `<U,V> java.util.concurrent.CompletableFuture<V>`"
  ([^java.util.concurrent.CompletableFuture this other fn]
    (-> this (.thenCombine other fn))))

