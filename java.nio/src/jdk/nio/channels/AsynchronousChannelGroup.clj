(ns jdk.nio.channels.AsynchronousChannelGroup
  "A grouping of asynchronous channels for the purpose of resource sharing.

   An asynchronous channel group encapsulates the mechanics required to
  handle the completion of I/O operations initiated by asynchronous channels that are bound to the group. A group has an associated
  thread pool to which tasks are submitted to handle I/O events and dispatch to
  completion-handlers that consume the result of
  asynchronous operations performed on channels in the group. In addition to
  handling I/O events, the pooled threads may also execute other tasks required
  to support the execution of asynchronous I/O operations.

   An asynchronous channel group is created by invoking the withFixedThreadPool or withCachedThreadPool methods defined here. Channels are bound to a group by
  specifying the group when constructing the channel. The associated thread
  pool is owned by the group; termination of the group results in the
  shutdown of the associated thread pool.

   In addition to groups created explicitly, the Java virtual machine
  maintains a system-wide default group that is constructed
  automatically. Asynchronous channels that do not specify a group at
  construction time are bound to the default group. The default group has an
  associated thread pool that creates new threads as needed. The default group
  may be configured by means of system properties defined in the table below.
  Where the ThreadFactory for the
  default group is not configured then the pooled threads of the default group
  are daemon threads.



      System property
      Description


       java.nio.channels.DefaultThreadPool.threadFactory
       The value of this property is taken to be the fully-qualified name
      of a concrete ThreadFactory
      class. The class is loaded using the system class loader and instantiated.
      The factory's newThread method is invoked to create each thread for the default
      group's thread pool. If the process to load and instantiate the value
      of the property fails then an unspecified error is thrown during the
      construction of the default group.


       java.nio.channels.DefaultThreadPool.initialSize
       The value of the initialSize parameter for the default
      group (see withCachedThreadPool).
      The value of the property is taken to be the String
      representation of an Integer that is the initial size parameter.
      If the value cannot be parsed as an Integer it causes an
      unspecified error to be thrown during the construction of the default
      group.



  Threading

   The completion handler for an I/O operation initiated on a channel bound
  to a group is guaranteed to be invoked by one of the pooled threads in the
  group. This ensures that the completion handler is run by a thread with the
  expected identity.

   Where an I/O operation completes immediately, and the initiating thread
  is one of the pooled threads in the group then the completion handler may
  be invoked directly by the initiating thread. To avoid stack overflow, an
  implementation may impose a limit as to the number of activations on the
  thread stack. Some I/O operations may prohibit invoking the completion
  handler directly by the initiating thread (see accept).

  Shutdown and Termination

   The shutdown method is used to initiate an orderly
  shutdown of a group. An orderly shutdown marks the group as shutdown;
  further attempts to construct a channel that binds to the group will throw
  ShutdownChannelGroupException. Whether or not a group is shutdown can
  be tested using the isShutdown method. Once shutdown,
  the group terminates when all asynchronous channels that are bound to
  the group are closed, all actively executing completion handlers have run to
  completion, and resources used by the group are released. No attempt is made
  to stop or interrupt threads that are executing completion handlers. The
  isTerminated method is used to test if the group has
  terminated, and the awaitTermination method can be
  used to block until the group has terminated.

   The shutdownNow method can be used to initiate a
  forceful shutdown of the group. In addition to the actions performed
  by an orderly shutdown, the shutdownNow method closes all open channels
  in the group as if by invoking the close
  method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels AsynchronousChannelGroup]))

(defn *with-fixed-thread-pool
  "Creates an asynchronous channel group with a fixed thread pool.

    The resulting asynchronous channel group reuses a fixed number of
   threads. At any point, at most nThreads threads will be active
   processing tasks that are submitted to handle I/O events and dispatch
   completion results for operations initiated on asynchronous channels in
   the group.

    The group is created by invoking the openAsynchronousChannelGroup(int,ThreadFactory) method of the system-wide
   default AsynchronousChannelProvider object.

  n-threads - The number of threads in the pool - `int`
  thread-factory - The factory to use when creating new threads - `java.util.concurrent.ThreadFactory`

  returns: A new asynchronous channel group - `java.nio.channels.AsynchronousChannelGroup`

  throws: java.lang.IllegalArgumentException - If nThreads <= 0"
  (^java.nio.channels.AsynchronousChannelGroup [^Integer n-threads ^java.util.concurrent.ThreadFactory thread-factory]
    (AsynchronousChannelGroup/withFixedThreadPool n-threads thread-factory)))

(defn *with-cached-thread-pool
  "Creates an asynchronous channel group with a given thread pool that
   creates new threads as needed.

    The executor parameter is an ExecutorService that
   creates new threads as needed to execute tasks that are submitted to
   handle I/O events and dispatch completion results for operations initiated
   on asynchronous channels in the group. It may reuse previously constructed
   threads when they are available.

    The initialSize parameter may be used by the implementation
   as a hint as to the initial number of tasks it may submit. For
   example, it may be used to indicate the initial number of threads that
   wait on I/O events.

    The executor is intended to be used exclusively by the resulting
   asynchronous channel group. Termination of the group results in the
   orderly  shutdown of the executor
   service. Shutting down the executor service by other means results in
   unspecified behavior.

    The group is created by invoking the openAsynchronousChannelGroup(ExecutorService,int) method of the system-wide
   default AsynchronousChannelProvider object.

  executor - The thread pool for the resulting group - `java.util.concurrent.ExecutorService`
  initial-size - A value >=0 or a negative value for implementation specific default - `int`

  returns: A new asynchronous channel group - `java.nio.channels.AsynchronousChannelGroup`

  throws: java.io.IOException - If an I/O error occurs"
  (^java.nio.channels.AsynchronousChannelGroup [^java.util.concurrent.ExecutorService executor ^Integer initial-size]
    (AsynchronousChannelGroup/withCachedThreadPool executor initial-size)))

(defn *with-thread-pool
  "Creates an asynchronous channel group with a given thread pool.

    The executor parameter is an ExecutorService that
   executes tasks submitted to dispatch completion results for operations
   initiated on asynchronous channels in the group.

    Care should be taken when configuring the executor service. It
   should support direct handoff or unbounded queuing of
   submitted tasks, and the thread that invokes the execute method should never invoke the task
   directly. An implementation may mandate additional constraints.

    The executor is intended to be used exclusively by the resulting
   asynchronous channel group. Termination of the group results in the
   orderly  shutdown of the executor
   service. Shutting down the executor service by other means results in
   unspecified behavior.

    The group is created by invoking the openAsynchronousChannelGroup(ExecutorService,int) method of the system-wide
   default AsynchronousChannelProvider object with an initialSize of 0.

  executor - The thread pool for the resulting group - `java.util.concurrent.ExecutorService`

  returns: A new asynchronous channel group - `java.nio.channels.AsynchronousChannelGroup`

  throws: java.io.IOException - If an I/O error occurs"
  (^java.nio.channels.AsynchronousChannelGroup [^java.util.concurrent.ExecutorService executor]
    (AsynchronousChannelGroup/withThreadPool executor)))

(defn provider
  "Returns the provider that created this channel group.

  returns: The provider that created this channel group - `java.nio.channels.spi.AsynchronousChannelProvider`"
  (^java.nio.channels.spi.AsynchronousChannelProvider [^AsynchronousChannelGroup this]
    (-> this (.provider))))

(defn shutdown?
  "Tells whether or not this asynchronous channel group is shutdown.

  returns: true if this asynchronous channel group is shutdown or
            has been marked for shutdown. - `boolean`"
  (^Boolean [^AsynchronousChannelGroup this]
    (-> this (.isShutdown))))

(defn terminated?
  "Tells whether or not this group has terminated.

    Where this method returns true, then the associated thread
   pool has also terminated.

  returns: true if this group has terminated - `boolean`"
  (^Boolean [^AsynchronousChannelGroup this]
    (-> this (.isTerminated))))

(defn shutdown
  "Initiates an orderly shutdown of the group.

    This method marks the group as shutdown. Further attempts to construct
   channel that binds to this group will throw ShutdownChannelGroupException.
   The group terminates when all asynchronous channels in the group are
   closed, all actively executing completion handlers have run to completion,
   and all resources have been released. This method has no effect if the
   group is already shutdown."
  ([^AsynchronousChannelGroup this]
    (-> this (.shutdown))))

(defn shutdown-now
  "Shuts down the group and closes all open channels in the group.

    In addition to the actions performed by the shutdown
   method, this method invokes the close
   method on all open channels in the group. This method does not attempt to
   stop or interrupt threads that are executing completion handlers. The
   group terminates when all actively executing completion handlers have run
   to completion and all resources have been released. This method may be
   invoked at any time. If some other thread has already invoked it, then
   another invocation will block until the first invocation is complete,
   after which it will return without effect.

  throws: java.io.IOException - If an I/O error occurs"
  ([^AsynchronousChannelGroup this]
    (-> this (.shutdownNow))))

(defn await-termination
  "Awaits termination of the group.

    This method blocks until the group has terminated, or the timeout
   occurs, or the current thread is interrupted, whichever happens first.

  timeout - The maximum time to wait, or zero or less to not wait - `long`
  unit - The time unit of the timeout argument - `java.util.concurrent.TimeUnit`

  returns: true if the group has terminated; false if the
            timeout elapsed before termination - `boolean`

  throws: java.lang.InterruptedException - If interrupted while waiting"
  (^Boolean [^AsynchronousChannelGroup this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.awaitTermination timeout unit))))

