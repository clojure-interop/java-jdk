(ns jdk.util.concurrent.Future
  "A Future represents the result of an asynchronous
  computation.  Methods are provided to check if the computation is
  complete, to wait for its completion, and to retrieve the result of
  the computation.  The result can only be retrieved using method
  get when the computation has completed, blocking if
  necessary until it is ready.  Cancellation is performed by the
  cancel method.  Additional methods are provided to
  determine if the task completed normally or was cancelled. Once a
  computation has completed, the computation cannot be cancelled.
  If you would like to use a Future for the sake
  of cancellability but not provide a usable result, you can
  declare types of the form Future<?> and
  return null as a result of the underlying task.


  Sample Usage (Note that the following classes are all
  made-up.)


  interface ArchiveSearcher { String search(String target); }
  class App {
    ExecutorService executor = ...
    ArchiveSearcher searcher = ...
    void showSearch(final String target)
        throws InterruptedException {
      Future<String> future
        = executor.submit(new Callable<String>() {
          public String call() {
              return searcher.search(target);
          }});
      displayOtherThings(); // do other things while searching
      try {
        displayText(future.get()); // use future
      } catch (ExecutionException ex) { cleanup(); return; }
    }
  }

  The FutureTask class is an implementation of Future that
  implements Runnable, and so may be executed by an Executor.
  For example, the above construction with submit could be replaced by:


  FutureTask<String> future =
    new FutureTask<String>(new Callable<String>() {
      public String call() {
        return searcher.search(target);
    }});
  executor.execute(future);

  Memory consistency effects: Actions taken by the asynchronous computation
   happen-before
  actions following the corresponding Future.get() in another thread."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent Future]))

(defn cancel
  "Attempts to cancel execution of this task.  This attempt will
   fail if the task has already completed, has already been cancelled,
   or could not be cancelled for some other reason. If successful,
   and this task has not started when cancel is called,
   this task should never run.  If the task has already started,
   then the mayInterruptIfRunning parameter determines
   whether the thread executing this task should be interrupted in
   an attempt to stop the task.

   After this method returns, subsequent calls to isDone() will
   always return true.  Subsequent calls to isCancelled()
   will always return true if this method returned true.

  may-interrupt-if-running - true if the thread executing this task should be interrupted; otherwise, in-progress tasks are allowed to complete - `boolean`

  returns: false if the task could not be cancelled,
   typically because it has already completed normally;
   true otherwise - `boolean`"
  ([^java.util.concurrent.Future this ^Boolean may-interrupt-if-running]
    (-> this (.cancel may-interrupt-if-running))))

(defn cancelled?
  "Returns true if this task was cancelled before it completed
   normally.

  returns: true if this task was cancelled before it completed - `boolean`"
  ([^java.util.concurrent.Future this]
    (-> this (.isCancelled))))

(defn done?
  "Returns true if this task completed.

   Completion may be due to normal termination, an exception, or
   cancellation -- in all of these cases, this method will return
   true.

  returns: true if this task completed - `boolean`"
  ([^java.util.concurrent.Future this]
    (-> this (.isDone))))

(defn get
  "Waits if necessary for at most the given time for the computation
   to complete, and then retrieves its result, if available.

  timeout - the maximum time to wait - `long`
  unit - the time unit of the timeout argument - `java.util.concurrent.TimeUnit`

  returns: the computed result - `Future.V`

  throws: java.util.concurrent.CancellationException - if the computation was cancelled"
  ([^java.util.concurrent.Future this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.get timeout unit)))
  ([^java.util.concurrent.Future this]
    (-> this (.get))))

