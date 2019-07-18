(ns jdk.util.concurrent.ExecutorService
  "An Executor that provides methods to manage termination and
  methods that can produce a Future for tracking progress of
  one or more asynchronous tasks.

  An ExecutorService can be shut down, which will cause
  it to reject new tasks.  Two different methods are provided for
  shutting down an ExecutorService. The shutdown()
  method will allow previously submitted tasks to execute before
  terminating, while the shutdownNow() method prevents waiting
  tasks from starting and attempts to stop currently executing tasks.
  Upon termination, an executor has no tasks actively executing, no
  tasks awaiting execution, and no new tasks can be submitted.  An
  unused ExecutorService should be shut down to allow
  reclamation of its resources.

  Method submit extends base method Executor.execute(Runnable) by creating and returning a Future
  that can be used to cancel execution and/or wait for completion.
  Methods invokeAny and invokeAll perform the most
  commonly useful forms of bulk execution, executing a collection of
  tasks and then waiting for at least one, or all, to
  complete. (Class ExecutorCompletionService can be used to
  write customized variants of these methods.)

  The Executors class provides factory methods for the
  executor services provided in this package.

  Usage Examples

  Here is a sketch of a network service in which threads in a thread
  pool service incoming requests. It uses the preconfigured Executors.newFixedThreadPool(int) factory method:



  class NetworkService implements Runnable {
    private final ServerSocket serverSocket;
    private final ExecutorService pool;

    public NetworkService(int port, int poolSize)
        throws IOException {
      serverSocket = new ServerSocket(port);
      pool = Executors.newFixedThreadPool(poolSize);
    }

    public void run() { // run the service
      try {
        for (;;) {
          pool.execute(new Handler(serverSocket.accept()));
        }
      } catch (IOException ex) {
        pool.shutdown();
      }
    }
  }

  class Handler implements Runnable {
    private final Socket socket;
    Handler(Socket socket) { this.socket = socket; }
    public void run() {
      // read and service request on socket
    }
  }

  The following method shuts down an ExecutorService in two phases,
  first by calling shutdown to reject incoming tasks, and then
  calling shutdownNow, if necessary, to cancel any lingering tasks:



  void shutdownAndAwaitTermination(ExecutorService pool) {
    pool.shutdown(); // Disable new tasks from being submitted
    try {
      // Wait a while for existing tasks to terminate
      if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
        pool.shutdownNow(); // Cancel currently executing tasks
        // Wait a while for tasks to respond to being cancelled
        if (!pool.awaitTermination(60, TimeUnit.SECONDS))
            System.err.println(`Pool did not terminate`);
      }
    } catch (InterruptedException ie) {
      // (Re-)Cancel if current thread also interrupted
      pool.shutdownNow();
      // Preserve interrupt status
      Thread.currentThread().interrupt();
    }
  }

  Memory consistency effects: Actions in a thread prior to the
  submission of a Runnable or Callable task to an
  ExecutorService
  happen-before
  any actions taken by that task, which in turn happen-before the
  result is retrieved via Future.get()."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ExecutorService]))

(defn shutdown
  "Initiates an orderly shutdown in which previously submitted
   tasks are executed, but no new tasks will be accepted.
   Invocation has no additional effect if already shut down.

   This method does not wait for previously submitted tasks to
   complete execution.  Use awaitTermination
   to do that.

  throws: java.lang.SecurityException - if a security manager exists and shutting down this ExecutorService may manipulate threads that the caller is not permitted to modify because it does not hold RuntimePermission(`modifyThread`), or the security manager's checkAccess method denies access."
  ([^ExecutorService this]
    (-> this (.shutdown))))

(defn shutdown-now
  "Attempts to stop all actively executing tasks, halts the
   processing of waiting tasks, and returns a list of the tasks
   that were awaiting execution.

   This method does not wait for actively executing tasks to
   terminate.  Use awaitTermination to
   do that.

   There are no guarantees beyond best-effort attempts to stop
   processing actively executing tasks.  For example, typical
   implementations will cancel via Thread.interrupt(), so any
   task that fails to respond to interrupts may never terminate.

  returns: list of tasks that never commenced execution - `java.util.List<java.lang.Runnable>`

  throws: java.lang.SecurityException - if a security manager exists and shutting down this ExecutorService may manipulate threads that the caller is not permitted to modify because it does not hold RuntimePermission(`modifyThread`), or the security manager's checkAccess method denies access."
  (^java.util.List [^ExecutorService this]
    (-> this (.shutdownNow))))

(defn shutdown?
  "Returns true if this executor has been shut down.

  returns: true if this executor has been shut down - `boolean`"
  (^Boolean [^ExecutorService this]
    (-> this (.isShutdown))))

(defn terminated?
  "Returns true if all tasks have completed following shut down.
   Note that isTerminated is never true unless
   either shutdown or shutdownNow was called first.

  returns: true if all tasks have completed following shut down - `boolean`"
  (^Boolean [^ExecutorService this]
    (-> this (.isTerminated))))

(defn await-termination
  "Blocks until all tasks have completed execution after a shutdown
   request, or the timeout occurs, or the current thread is
   interrupted, whichever happens first.

  timeout - the maximum time to wait - `long`
  unit - the time unit of the timeout argument - `java.util.concurrent.TimeUnit`

  returns: true if this executor terminated and
           false if the timeout elapsed before termination - `boolean`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  (^Boolean [^ExecutorService this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.awaitTermination timeout unit))))

(defn submit
  "Submits a Runnable task for execution and returns a Future
   representing that task. The Future's get method will
   return the given result upon successful completion.

  task - the task to submit - `java.lang.Runnable`
  result - the result to return - `T`

  returns: a Future representing pending completion of the task - `<T> java.util.concurrent.Future<T>`

  throws: java.util.concurrent.RejectedExecutionException - if the task cannot be scheduled for execution"
  ([^ExecutorService this ^java.lang.Runnable task result]
    (-> this (.submit task result)))
  ([^ExecutorService this ^java.util.concurrent.Callable task]
    (-> this (.submit task))))

(defn invoke-all
  "Executes the given tasks, returning a list of Futures holding
   their status and results
   when all complete or the timeout expires, whichever happens first.
   Future.isDone() is true for each
   element of the returned list.
   Upon return, tasks that have not completed are cancelled.
   Note that a completed task could have
   terminated either normally or by throwing an exception.
   The results of this method are undefined if the given
   collection is modified while this operation is in progress.

  tasks - the collection of tasks - `java.util.Collection`
  timeout - the maximum time to wait - `long`
  unit - the time unit of the timeout argument - `java.util.concurrent.TimeUnit`

  returns: a list of Futures representing the tasks, in the same
           sequential order as produced by the iterator for the
           given task list. If the operation did not time out,
           each task will have completed. If it did time out, some
           of these tasks will not have completed. - `<T> java.util.List<java.util.concurrent.Future<T>>`

  throws: java.lang.InterruptedException - if interrupted while waiting, in which case unfinished tasks are cancelled"
  ([^ExecutorService this ^java.util.Collection tasks ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.invokeAll tasks timeout unit)))
  ([^ExecutorService this ^java.util.Collection tasks]
    (-> this (.invokeAll tasks))))

(defn invoke-any
  "Executes the given tasks, returning the result
   of one that has completed successfully (i.e., without throwing
   an exception), if any do before the given timeout elapses.
   Upon normal or exceptional return, tasks that have not
   completed are cancelled.
   The results of this method are undefined if the given
   collection is modified while this operation is in progress.

  tasks - the collection of tasks - `java.util.Collection`
  timeout - the maximum time to wait - `long`
  unit - the time unit of the timeout argument - `java.util.concurrent.TimeUnit`

  returns: the result returned by one of the tasks - `<T> T`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^ExecutorService this ^java.util.Collection tasks ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.invokeAny tasks timeout unit)))
  ([^ExecutorService this ^java.util.Collection tasks]
    (-> this (.invokeAny tasks))))

