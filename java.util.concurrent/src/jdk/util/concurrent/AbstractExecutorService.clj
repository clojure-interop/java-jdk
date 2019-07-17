(ns jdk.util.concurrent.AbstractExecutorService
  "Provides default implementations of ExecutorService
  execution methods. This class implements the submit,
  invokeAny and invokeAll methods using a
  RunnableFuture returned by newTaskFor, which defaults
  to the FutureTask class provided in this package.  For example,
  the implementation of submit(Runnable) creates an
  associated RunnableFuture that is executed and
  returned. Subclasses may override the newTaskFor methods
  to return RunnableFuture implementations other than
  FutureTask.

  Extension example. Here is a sketch of a class
  that customizes ThreadPoolExecutor to use
  a CustomTask class instead of the default FutureTask:


  public class CustomThreadPoolExecutor extends ThreadPoolExecutor {

    static class CustomTask<V> implements RunnableFuture<V> {...}

    protected <V> RunnableFuture<V> newTaskFor(Callable<V> c) {
        return new CustomTask<V>(c);
    }
    protected <V> RunnableFuture<V> newTaskFor(Runnable r, V v) {
        return new CustomTask<V>(r, v);
    }
    // ... add constructors, etc.
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent AbstractExecutorService]))

(defn ->abstract-executor-service
  "Constructor."
  ([]
    (new AbstractExecutorService )))

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

(defn invoke-any
  "Description copied from interface: ExecutorService

  tasks - the collection of tasks - `java.util.concurrent.Callable<T>>`
  timeout - the maximum time to wait - `long`
  unit - the time unit of the timeout argument - `java.util.concurrent.TimeUnit`

  returns: the result returned by one of the tasks - `<T> T`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([this tasks timeout unit]
    (-> this (.invokeAny tasks timeout unit)))
  ([this tasks]
    (-> this (.invokeAny tasks))))

(defn invoke-all
  "Description copied from interface: ExecutorService

  tasks - the collection of tasks - `java.util.concurrent.Callable<T>>`
  timeout - the maximum time to wait - `long`
  unit - the time unit of the timeout argument - `java.util.concurrent.TimeUnit`

  returns: a list of Futures representing the tasks, in the same
           sequential order as produced by the iterator for the
           given task list. If the operation did not time out,
           each task will have completed. If it did time out, some
           of these tasks will not have completed. - `<T> java.util.List<java.util.concurrent.Future<T>>`

  throws: java.lang.InterruptedException - if interrupted while waiting, in which case unfinished tasks are cancelled"
  ([this tasks timeout unit]
    (-> this (.invokeAll tasks timeout unit)))
  ([this tasks]
    (-> this (.invokeAll tasks))))

