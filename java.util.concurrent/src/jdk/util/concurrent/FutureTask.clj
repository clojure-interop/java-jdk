(ns jdk.util.concurrent.FutureTask
  "A cancellable asynchronous computation.  This class provides a base
  implementation of Future, with methods to start and cancel
  a computation, query to see if the computation is complete, and
  retrieve the result of the computation.  The result can only be
  retrieved when the computation has completed; the get
  methods will block if the computation has not yet completed.  Once
  the computation has completed, the computation cannot be restarted
  or cancelled (unless the computation is invoked using
  runAndReset()).

  A FutureTask can be used to wrap a Callable or
  Runnable object.  Because FutureTask implements
  Runnable, a FutureTask can be submitted to an
  Executor for execution.

  In addition to serving as a standalone class, this class provides
  protected functionality that may be useful when creating
  customized task classes."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent FutureTask]))

(defn ->future-task
  "Constructor.

  Creates a FutureTask that will, upon running, execute the
   given Runnable, and arrange that get will return the
   given result on successful completion.

  runnable - the runnable task - `java.lang.Runnable`
  result - the result to return on successful completion. If you don't need a particular result, consider using constructions of the form: Future<?> f = new FutureTask<Void>(runnable, null) - `FutureTask.V`

  throws: java.lang.NullPointerException - if the runnable is null"
  ([^java.lang.Runnable runnable ^FutureTask.V result]
    (new FutureTask runnable result))
  ([^java.util.concurrent.Callable callable]
    (new FutureTask callable)))

(defn cancelled?
  "Description copied from interface: Future

  returns: true if this task was cancelled before it completed - `boolean`"
  (^Boolean [^java.util.concurrent.FutureTask this]
    (-> this (.isCancelled))))

(defn done?
  "Description copied from interface: Future

  returns: true if this task completed - `boolean`"
  (^Boolean [^java.util.concurrent.FutureTask this]
    (-> this (.isDone))))

(defn cancel
  "Description copied from interface: Future

  may-interrupt-if-running - true if the thread executing this task should be interrupted; otherwise, in-progress tasks are allowed to complete - `boolean`

  returns: false if the task could not be cancelled,
   typically because it has already completed normally;
   true otherwise - `boolean`"
  (^Boolean [^java.util.concurrent.FutureTask this ^Boolean may-interrupt-if-running]
    (-> this (.cancel may-interrupt-if-running))))

(defn get
  "Description copied from interface: Future

  timeout - the maximum time to wait - `long`
  unit - the time unit of the timeout argument - `java.util.concurrent.TimeUnit`

  returns: the computed result - `FutureTask.V`

  throws: java.util.concurrent.CancellationException - if the computation was cancelled"
  (^FutureTask.V [^java.util.concurrent.FutureTask this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.get timeout unit)))
  (^FutureTask.V [^java.util.concurrent.FutureTask this]
    (-> this (.get))))

(defn run
  "Description copied from interface: RunnableFuture"
  ([^java.util.concurrent.FutureTask this]
    (-> this (.run))))

