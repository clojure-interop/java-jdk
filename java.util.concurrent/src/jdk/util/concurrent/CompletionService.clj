(ns jdk.util.concurrent.CompletionService
  "A service that decouples the production of new asynchronous tasks
  from the consumption of the results of completed tasks.  Producers
  submit tasks for execution. Consumers take
  completed tasks and process their results in the order they
  complete.  A CompletionService can for example be used to
  manage asynchronous I/O, in which tasks that perform reads are
  submitted in one part of a program or system, and then acted upon
  in a different part of the program when the reads complete,
  possibly in a different order than they were requested.

  Typically, a CompletionService relies on a separate
  Executor to actually execute the tasks, in which case the
  CompletionService only manages an internal completion
  queue. The ExecutorCompletionService class provides an
  implementation of this approach.

  Memory consistency effects: Actions in a thread prior to
  submitting a task to a CompletionService
  happen-before
  actions taken by that task, which in turn happen-before
  actions following a successful return from the corresponding take()."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent CompletionService]))

(defn submit
  "Submits a Runnable task for execution and returns a Future
   representing that task.  Upon completion, this task may be
   taken or polled.

  task - the task to submit - `java.lang.Runnable`
  result - the result to return upon successful completion - `CompletionService.V`

  returns: a Future representing pending completion of the task,
           and whose get() method will return the given
           result value upon completion - `java.util.concurrent.Future<CompletionService.V>`

  throws: java.util.concurrent.RejectedExecutionException - if the task cannot be scheduled for execution"
  ([^java.util.concurrent.CompletionService this ^java.lang.Runnable task ^CompletionService.V result]
    (-> this (.submit task result)))
  ([^java.util.concurrent.CompletionService this ^java.util.concurrent.Callable task]
    (-> this (.submit task))))

(defn take
  "Retrieves and removes the Future representing the next
   completed task, waiting if none are yet present.

  returns: the Future representing the next completed task - `java.util.concurrent.Future<CompletionService.V>`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^java.util.concurrent.CompletionService this]
    (-> this (.take))))

(defn poll
  "Retrieves and removes the Future representing the next
   completed task, waiting if necessary up to the specified wait
   time if none are yet present.

  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: the Future representing the next completed task or
           null if the specified waiting time elapses
           before one is present - `java.util.concurrent.Future<CompletionService.V>`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^java.util.concurrent.CompletionService this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.poll timeout unit)))
  ([^java.util.concurrent.CompletionService this]
    (-> this (.poll))))

