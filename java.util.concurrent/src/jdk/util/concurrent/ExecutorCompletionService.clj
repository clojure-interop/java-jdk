(ns jdk.util.concurrent.ExecutorCompletionService
  "A CompletionService that uses a supplied Executor
  to execute tasks.  This class arranges that submitted tasks are,
  upon completion, placed on a queue accessible using take.
  The class is lightweight enough to be suitable for transient use
  when processing groups of tasks.



  Usage Examples.

  Suppose you have a set of solvers for a certain problem, each
  returning a value of some type Result, and would like to
  run them concurrently, processing the results of each of them that
  return a non-null value, in some method use(Result r). You
  could write this as:



  void solve(Executor e,
             Collection<Callable<Result>> solvers)
      throws InterruptedException, ExecutionException {
      CompletionService<Result> ecs
          = new ExecutorCompletionService<Result>(e);
      for (Callable<Result> s : solvers)
          ecs.submit(s);
      int n = solvers.size();
      for (int i = 0; i < n; +i) {
          Result r = ecs.take().get();
          if (r != null)
              use(r);
      }
  }

  Suppose instead that you would like to use the first non-null result
  of the set of tasks, ignoring any that encounter exceptions,
  and cancelling all other tasks when the first one is ready:



  void solve(Executor e,
             Collection<Callable<Result>> solvers)
      throws InterruptedException {
      CompletionService<Result> ecs
          = new ExecutorCompletionService<Result>(e);
      int n = solvers.size();
      List<Future<Result>> futures
          = new ArrayList<Future<Result>>(n);
      Result result = null;
      try {
          for (Callable<Result> s : solvers)
              futures.add(ecs.submit(s));
          for (int i = 0; i < n; +i) {
              try {
                  Result r = ecs.take().get();
                  if (r != null) {
                      result = r;
                      break;
                  }
              } catch (ExecutionException ignore) {}
          }
      }
      finally {
          for (Future<Result> f : futures)
              f.cancel(true);
      }

      if (result != null)
          use(result);
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ExecutorCompletionService]))

(defn ->executor-completion-service
  "Constructor.

  Creates an ExecutorCompletionService using the supplied
   executor for base task execution and the supplied queue as its
   completion queue.

  executor - the executor to use - `java.util.concurrent.Executor`
  completion-queue - the queue to use as the completion queue normally one dedicated for use by this service. This queue is treated as unbounded -- failed attempted Queue.add operations for completed tasks cause them not to be retrievable. - `java.util.concurrent.BlockingQueue<java.util.concurrent.Future<ExecutorCompletionService.V>>`

  throws: java.lang.NullPointerException - if executor or completionQueue are null"
  ([^java.util.concurrent.Executor executor ^java.util.concurrent.BlockingQueue> completion-queue]
    (new ExecutorCompletionService executor completion-queue))
  ([^java.util.concurrent.Executor executor]
    (new ExecutorCompletionService executor)))

(defn submit
  "Description copied from interface: CompletionService

  task - the task to submit - `java.lang.Runnable`
  result - the result to return upon successful completion - `ExecutorCompletionService.V`

  returns: a Future representing pending completion of the task,
           and whose get() method will return the given
           result value upon completion - `java.util.concurrent.Future<ExecutorCompletionService.V>`"
  ([^java.util.concurrent.ExecutorCompletionService this ^java.lang.Runnable task ^ExecutorCompletionService.V result]
    (-> this (.submit task result)))
  ([^java.util.concurrent.ExecutorCompletionService this ^java.util.concurrent.Callable task]
    (-> this (.submit task))))

(defn take
  "Description copied from interface: CompletionService

  returns: the Future representing the next completed task - `java.util.concurrent.Future<ExecutorCompletionService.V>`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^java.util.concurrent.ExecutorCompletionService this]
    (-> this (.take))))

(defn poll
  "Description copied from interface: CompletionService

  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: the Future representing the next completed task or
           null if the specified waiting time elapses
           before one is present - `java.util.concurrent.Future<ExecutorCompletionService.V>`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^java.util.concurrent.ExecutorCompletionService this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.poll timeout unit)))
  ([^java.util.concurrent.ExecutorCompletionService this]
    (-> this (.poll))))

