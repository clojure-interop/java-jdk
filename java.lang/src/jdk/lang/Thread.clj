(ns jdk.lang.Thread
  "A thread is a thread of execution in a program. The Java
  Virtual Machine allows an application to have multiple threads of
  execution running concurrently.

  Every thread has a priority. Threads with higher priority are
  executed in preference to threads with lower priority. Each thread
  may or may not also be marked as a daemon. When code running in
  some thread creates a new Thread object, the new
  thread has its priority initially set equal to the priority of the
  creating thread, and is a daemon thread if and only if the
  creating thread is a daemon.

  When a Java Virtual Machine starts up, there is usually a single
  non-daemon thread (which typically calls the method named
  main of some designated class). The Java Virtual
  Machine continues to execute threads until either of the following
  occurs:

  The exit method of class Runtime has been
      called and the security manager has permitted the exit operation
      to take place.
  All threads that are not daemon threads have died, either by
      returning from the call to the run method or by
      throwing an exception that propagates beyond the run
      method.


  There are two ways to create a new thread of execution. One is to
  declare a class to be a subclass of Thread. This
  subclass should override the run method of class
  Thread. An instance of the subclass can then be
  allocated and started. For example, a thread that computes primes
  larger than a stated value could be written as follows:


      class PrimeThread extends Thread {
          long minPrime;
          PrimeThread(long minPrime) {
              this.minPrime = minPrime;
          }

          public void run() {
              // compute primes larger than minPrime
               . . .
          }
      }

  The following code would then create a thread and start it running:


      PrimeThread p = new PrimeThread(143);
      p.start();

  The other way to create a thread is to declare a class that
  implements the Runnable interface. That class then
  implements the run method. An instance of the class can
  then be allocated, passed as an argument when creating
  Thread, and started. The same example in this other
  style looks like the following:


      class PrimeRun implements Runnable {
          long minPrime;
          PrimeRun(long minPrime) {
              this.minPrime = minPrime;
          }

          public void run() {
              // compute primes larger than minPrime
               . . .
          }
      }

  The following code would then create a thread and start it running:


      PrimeRun p = new PrimeRun(143);
      new Thread(p).start();

  Every thread has a name for identification purposes. More than
  one thread may have the same name. If a name is not specified when
  a thread is created, a new name is generated for it.

  Unless otherwise noted, passing a null argument to a constructor
  or method in this class will cause a NullPointerException to be
  thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Thread]))

(defn ->thread
  "Constructor.

  Allocates a new Thread object so that it has target
   as its run object, has the specified name as its name,
   and belongs to the thread group referred to by group, and has
   the specified stack size.

   This constructor is identical to Thread(ThreadGroup,Runnable,String) with the exception of the fact
   that it allows the thread stack size to be specified.  The stack size
   is the approximate number of bytes of address space that the virtual
   machine is to allocate for this thread's stack.  The effect of the
   stackSize parameter, if any, is highly platform dependent.

   On some platforms, specifying a higher value for the
   stackSize parameter may allow a thread to achieve greater
   recursion depth before throwing a StackOverflowError.
   Similarly, specifying a lower value may allow a greater number of
   threads to exist concurrently without throwing an OutOfMemoryError (or other internal error).  The details of
   the relationship between the value of the stackSize parameter
   and the maximum recursion depth and concurrency level are
   platform-dependent.  On some platforms, the value of the
   stackSize parameter may have no effect whatsoever.

   The virtual machine is free to treat the stackSize
   parameter as a suggestion.  If the specified value is unreasonably low
   for the platform, the virtual machine may instead use some
   platform-specific minimum value; if the specified value is unreasonably
   high, the virtual machine may instead use some platform-specific
   maximum.  Likewise, the virtual machine is free to round the specified
   value up or down as it sees fit (or to ignore it completely).

   Specifying a value of zero for the stackSize parameter will
   cause this constructor to behave exactly like the
   Thread(ThreadGroup, Runnable, String) constructor.

   Due to the platform-dependent nature of the behavior of this
   constructor, extreme care should be exercised in its use.
   The thread stack size necessary to perform a given computation will
   likely vary from one JRE implementation to another.  In light of this
   variation, careful tuning of the stack size parameter may be required,
   and the tuning may need to be repeated for each JRE implementation on
   which an application is to run.

   Implementation note: Java platform implementers are encouraged to
   document their implementation's behavior with respect to the
   stackSize parameter.

  group - the thread group. If null and there is a security manager, the group is determined by SecurityManager.getThreadGroup(). If there is not a security manager or SecurityManager.getThreadGroup() returns null, the group is set to the current thread's thread group. - `java.lang.ThreadGroup`
  target - the object whose run method is invoked when this thread is started. If null, this thread's run method is invoked. - `java.lang.Runnable`
  name - the name of the new thread - `java.lang.String`
  stack-size - the desired stack size for the new thread, or zero to indicate that this parameter is to be ignored. - `long`

  throws: java.lang.SecurityException - if the current thread cannot create a thread in the specified thread group"
  ([^java.lang.ThreadGroup group ^java.lang.Runnable target ^java.lang.String name ^Long stack-size]
    (new Thread group target name stack-size))
  ([^java.lang.ThreadGroup group ^java.lang.Runnable target ^java.lang.String name]
    (new Thread group target name))
  ([^java.lang.ThreadGroup group ^java.lang.Runnable target]
    (new Thread group target))
  ([^java.lang.Runnable target]
    (new Thread target))
  ([]
    (new Thread )))

(def *-min-priority
  "Static Constant.

  The minimum priority that a thread can have.

  type: int"
  Thread/MIN_PRIORITY)

(def *-norm-priority
  "Static Constant.

  The default priority that is assigned to a thread.

  type: int"
  Thread/NORM_PRIORITY)

(def *-max-priority
  "Static Constant.

  The maximum priority that a thread can have.

  type: int"
  Thread/MAX_PRIORITY)

(defn *get-all-stack-traces
  "Returns a map of stack traces for all live threads.
   The map keys are threads and each map value is an array of
   StackTraceElement that represents the stack dump
   of the corresponding Thread.
   The returned stack traces are in the format specified for
   the getStackTrace method.

   The threads may be executing while this method is called.
   The stack trace of each thread only represents a snapshot and
   each stack trace may be obtained at different time.  A zero-length
   array will be returned in the map value if the virtual machine has
   no stack trace information about a thread.

   If there is a security manager, then the security manager's
   checkPermission method is called with a
   RuntimePermission(`getStackTrace`) permission as well as
   RuntimePermission(`modifyThreadGroup`) permission
   to see if it is ok to get the stack trace of all threads.

  returns: a Map from Thread to an array of
   StackTraceElement that represents the stack trace of
   the corresponding thread. - `java.util.Map<java.lang.Thread,java.lang.StackTraceElement[]>`

  throws: java.lang.SecurityException - if a security manager exists and its checkPermission method doesn't allow getting the stack trace of thread."
  ([]
    (Thread/getAllStackTraces )))

(defn *yield
  "A hint to the scheduler that the current thread is willing to yield
   its current use of a processor. The scheduler is free to ignore this
   hint.

    Yield is a heuristic attempt to improve relative progression
   between threads that would otherwise over-utilise a CPU. Its use
   should be combined with detailed profiling and benchmarking to
   ensure that it actually has the desired effect.

    It is rarely appropriate to use this method. It may be useful
   for debugging or testing purposes, where it may help to reproduce
   bugs due to race conditions. It may also be useful when designing
   concurrency control constructs such as the ones in the
   java.util.concurrent.locks package."
  ([]
    (Thread/yield )))

(defn *dump-stack
  "Prints a stack trace of the current thread to the standard error stream.
   This method is used only for debugging."
  ([]
    (Thread/dumpStack )))

(defn *get-default-uncaught-exception-handler
  "Returns the default handler invoked when a thread abruptly terminates
   due to an uncaught exception. If the returned value is null,
   there is no default.

  returns: the default uncaught exception handler for all threads - `java.lang.Thread.UncaughtExceptionHandler`"
  (^java.lang.Thread.UncaughtExceptionHandler []
    (Thread/getDefaultUncaughtExceptionHandler )))

(defn *set-default-uncaught-exception-handler
  "Set the default handler invoked when a thread abruptly terminates
   due to an uncaught exception, and no other handler has been defined
   for that thread.

   Uncaught exception handling is controlled first by the thread, then
   by the thread's ThreadGroup object and finally by the default
   uncaught exception handler. If the thread does not have an explicit
   uncaught exception handler set, and the thread's thread group
   (including parent thread groups)  does not specialize its
   uncaughtException method, then the default handler's
   uncaughtException method will be invoked.
   By setting the default uncaught exception handler, an application
   can change the way in which uncaught exceptions are handled (such as
   logging to a specific device, or file) for those threads that would
   already accept whatever `default` behavior the system
   provided.

   Note that the default uncaught exception handler should not usually
   defer to the thread's ThreadGroup object, as that could cause
   infinite recursion.

  eh - the object to use as the default uncaught exception handler. If null then there is no default handler. - `java.lang.Thread.UncaughtExceptionHandler`

  throws: java.lang.SecurityException - if a security manager is present and it denies RuntimePermission (`setDefaultUncaughtExceptionHandler`)"
  ([^java.lang.Thread.UncaughtExceptionHandler eh]
    (Thread/setDefaultUncaughtExceptionHandler eh)))

(defn *sleep
  "Causes the currently executing thread to sleep (temporarily cease
   execution) for the specified number of milliseconds plus the specified
   number of nanoseconds, subject to the precision and accuracy of system
   timers and schedulers. The thread does not lose ownership of any
   monitors.

  millis - the length of time to sleep in milliseconds - `long`
  nanos - 0-999999 additional nanoseconds to sleep - `int`

  throws: java.lang.IllegalArgumentException - if the value of millis is negative, or the value of nanos is not in the range 0-999999"
  ([^Long millis ^Integer nanos]
    (Thread/sleep millis nanos))
  ([^Long millis]
    (Thread/sleep millis)))

(defn *interrupted
  "Tests whether the current thread has been interrupted.  The
   interrupted status of the thread is cleared by this method.  In
   other words, if this method were to be called twice in succession, the
   second call would return false (unless the current thread were
   interrupted again, after the first call had cleared its interrupted
   status and before the second call had examined it).

   A thread interruption ignored because a thread was not alive
   at the time of the interrupt will be reflected by this method
   returning false.

  returns: true if the current thread has been interrupted;
            false otherwise. - `boolean`"
  (^Boolean []
    (Thread/interrupted )))

(defn *enumerate
  "Copies into the specified array every active thread in the current
   thread's thread group and its subgroups. This method simply
   invokes the ThreadGroup.enumerate(Thread[])
   method of the current thread's thread group.

    An application might use the activeCount
   method to get an estimate of how big the array should be, however
   if the array is too short to hold all the threads, the extra threads
   are silently ignored.  If it is critical to obtain every active
   thread in the current thread's thread group and its subgroups, the
   invoker should verify that the returned int value is strictly less
   than the length of tarray.

    Due to the inherent race condition in this method, it is recommended
   that the method only be used for debugging and monitoring purposes.

  tarray - an array into which to put the list of threads - `java.lang.Thread[]`

  returns: the number of threads put into the array - `int`

  throws: java.lang.SecurityException - if ThreadGroup.checkAccess() determines that the current thread cannot access its thread group"
  (^Integer [tarray]
    (Thread/enumerate tarray)))

(defn *holds-lock
  "Returns true if and only if the current thread holds the
   monitor lock on the specified object.

   This method is designed to allow a program to assert that
   the current thread already holds a specified lock:


       assert Thread.holdsLock(obj);

  obj - the object on which to test lock ownership - `java.lang.Object`

  returns: true if the current thread holds the monitor lock on
           the specified object. - `boolean`

  throws: java.lang.NullPointerException - if obj is null"
  (^Boolean [^java.lang.Object obj]
    (Thread/holdsLock obj)))

(defn *active-count
  "Returns an estimate of the number of active threads in the current
   thread's java.lang.thread group and its
   subgroups. Recursively iterates over all subgroups in the current
   thread's thread group.

    The value returned is only an estimate because the number of
   threads may change dynamically while this method traverses internal
   data structures, and might be affected by the presence of certain
   system threads. This method is intended primarily for debugging
   and monitoring purposes.

  returns: an estimate of the number of active threads in the current
            thread's thread group and in any other thread group that
            has the current thread's thread group as an ancestor - `int`"
  (^Integer []
    (Thread/activeCount )))

(defn *current-thread
  "Returns a reference to the currently executing thread object.

  returns: the currently executing thread. - `java.lang.Thread`"
  (^java.lang.Thread []
    (Thread/currentThread )))

(defn set-context-class-loader
  "Sets the context ClassLoader for this Thread. The context
   ClassLoader can be set when a thread is created, and allows
   the creator of the thread to provide the appropriate class loader,
   through getContextClassLoader, to code running in the thread
   when loading classes and resources.

   If a security manager is present, its checkPermission
   method is invoked with a RuntimePermission(`setContextClassLoader`) permission to see if setting the context
   ClassLoader is permitted.

  cl - the context ClassLoader for this Thread, or null indicating the system class loader (or, failing that, the bootstrap class loader) - `java.lang.ClassLoader`

  throws: java.lang.SecurityException - if the current thread cannot set the context ClassLoader"
  ([^java.lang.Thread this ^java.lang.ClassLoader cl]
    (-> this (.setContextClassLoader cl))))

(defn stop
  "Deprecated. This method is inherently unsafe.  Stopping a thread with
         Thread.stop causes it to unlock all of the monitors that it
         has locked (as a natural consequence of the unchecked
         ThreadDeath exception propagating up the stack).  If
         any of the objects previously protected by these monitors were in
         an inconsistent state, the damaged objects become visible to
         other threads, potentially resulting in arbitrary behavior.  Many
         uses of stop should be replaced by code that simply
         modifies some variable to indicate that the target thread should
         stop running.  The target thread should check this variable
         regularly, and return from its run method in an orderly fashion
         if the variable indicates that it is to stop running.  If the
         target thread waits for long periods (on a condition variable,
         for example), the interrupt method should be used to
         interrupt the wait.
         For more information, see
         Why
         are Thread.stop, Thread.suspend and Thread.resume Deprecated?.

  returns: `java.lang.   void`

  throws: java.lang.SecurityException - if the current thread cannot modify this thread."
  ([^java.lang.Thread this]
    (-> this (.stop)))
  ([^java.lang.Thread this ^java.lang.Throwable obj]
    (-> this (.stop obj))))

(defn get-stack-trace
  "Returns an array of stack trace elements representing the stack dump
   of this thread.  This method will return a zero-length array if
   this thread has not started, has started but has not yet been
   scheduled to run by the system, or has terminated.
   If the returned array is of non-zero length then the first element of
   the array represents the top of the stack, which is the most recent
   method invocation in the sequence.  The last element of the array
   represents the bottom of the stack, which is the least recent method
   invocation in the sequence.

   If there is a security manager, and this thread is not
   the current thread, then the security manager's
   checkPermission method is called with a
   RuntimePermission(`getStackTrace`) permission
   to see if it's ok to get the stack trace.

   Some virtual machines may, under some circumstances, omit one
   or more stack frames from the stack trace.  In the extreme case,
   a virtual machine that has no stack trace information concerning
   this thread is permitted to return a zero-length array from this
   method.

  returns: an array of StackTraceElement,
   each represents one stack frame. - `java.lang.StackTraceElement[]`

  throws: java.lang.SecurityException - if a security manager exists and its checkPermission method doesn't allow getting the stack trace of thread."
  ([^java.lang.Thread this]
    (-> this (.getStackTrace))))

(defn get-thread-group
  "Returns the thread group to which this thread belongs.
   This method returns null if this thread has died
   (been stopped).

  returns: this thread's thread group. - `java.lang.ThreadGroup`"
  (^java.lang.ThreadGroup [^java.lang.Thread this]
    (-> this (.getThreadGroup))))

(defn alive?
  "Tests if this thread is alive. A thread is alive if it has
   been started and has not yet died.

  returns: true if this thread is alive;
            false otherwise. - `boolean`"
  (^Boolean [^java.lang.Thread this]
    (-> this (.isAlive))))

(defn suspend
  "Deprecated. This method has been deprecated, as it is
     inherently deadlock-prone.  If the target thread holds a lock on the
     monitor protecting a critical system resource when it is suspended, no
     thread can access this resource until the target thread is resumed. If
     the thread that would resume the target thread attempts to lock this
     monitor prior to calling resume, deadlock results.  Such
     deadlocks typically manifest themselves as `frozen` processes.
     For more information, see
     Why
     are Thread.stop, Thread.suspend and Thread.resume Deprecated?.

  returns: `java.lang.   void`

  throws: java.lang.SecurityException - if the current thread cannot modify this thread."
  ([^java.lang.Thread this]
    (-> this (.suspend))))

(defn set-name
  "Changes the name of this thread to be equal to the argument
   name.

   First the checkAccess method of this thread is called
   with no arguments. This may result in throwing a
   SecurityException.

  name - the new name for this thread. - `java.lang.String`

  throws: java.lang.SecurityException - if the current thread cannot modify this thread."
  ([^java.lang.Thread this ^java.lang.String name]
    (-> this (.setName name))))

(defn run
  "If this thread was constructed using a separate
   Runnable run object, then that
   Runnable object's run method is called;
   otherwise, this method does nothing and returns.

   Subclasses of Thread should override this method."
  ([^java.lang.Thread this]
    (-> this (.run))))

(defn get-uncaught-exception-handler
  "Returns the handler invoked when this thread abruptly terminates
   due to an uncaught exception. If this thread has not had an
   uncaught exception handler explicitly set then this thread's
   ThreadGroup object is returned, unless this thread
   has terminated, in which case null is returned.

  returns: the uncaught exception handler for this thread - `java.lang.Thread.UncaughtExceptionHandler`"
  (^java.lang.Thread.UncaughtExceptionHandler [^java.lang.Thread this]
    (-> this (.getUncaughtExceptionHandler))))

(defn to-string
  "Returns a string representation of this thread, including the
   thread's name, priority, and thread group.

  returns: a string representation of this thread. - `java.lang.String`"
  (^java.lang.String [^java.lang.Thread this]
    (-> this (.toString))))

(defn check-access
  "Determines if the currently running thread has permission to
   modify this thread.

   If there is a security manager, its checkAccess method
   is called with this thread as its argument. This may result in
   throwing a SecurityException.

  throws: java.lang.SecurityException - if the current thread is not allowed to access this thread."
  ([^java.lang.Thread this]
    (-> this (.checkAccess))))

(defn get-name
  "Returns this thread's name.

  returns: this thread's name. - `java.lang.String`"
  (^java.lang.String [^java.lang.Thread this]
    (-> this (.getName))))

(defn get-state
  "Returns the state of this thread.
   This method is designed for use in monitoring of the system state,
   not for synchronization control.

  returns: this thread's state. - `java.lang.Thread.State`"
  (^java.lang.Thread.State [^java.lang.Thread this]
    (-> this (.getState))))

(defn get-context-class-loader
  "Returns the context ClassLoader for this Thread. The context
   ClassLoader is provided by the creator of the thread for use
   by code running in this thread when loading classes and resources.
   If not set, the default is the
   ClassLoader context of the parent Thread. The context ClassLoader of the
   primordial thread is typically set to the class loader used to load the
   application.

   If a security manager is present, and the invoker's class loader is not
   null and is not the same as or an ancestor of the context class
   loader, then this method invokes the security manager's checkPermission
   method with a RuntimePermission(`getClassLoader`) permission to verify that retrieval of the context
   class loader is permitted.

  returns: the context ClassLoader for this Thread, or null
            indicating the system class loader (or, failing that, the
            bootstrap class loader) - `java.lang.ClassLoader`

  throws: java.lang.SecurityException - if the current thread cannot get the context ClassLoader"
  (^java.lang.ClassLoader [^java.lang.Thread this]
    (-> this (.getContextClassLoader))))

(defn destroy
  "Deprecated. This method was originally designed to destroy this
       thread without any cleanup. Any monitors it held would have
       remained locked. However, the method was never implemented.
       If if were to be implemented, it would be deadlock-prone in
       much the manner of suspend(). If the target thread held
       a lock protecting a critical system resource when it was
       destroyed, no thread could ever access this resource again.
       If another thread ever attempted to lock this resource, deadlock
       would result. Such deadlocks typically manifest themselves as
       `frozen` processes. For more information, see

       Why are Thread.stop, Thread.suspend and Thread.resume Deprecated?.

  returns: `java.lang.  void`

  throws: java.lang.NoSuchMethodError - always"
  ([^java.lang.Thread this]
    (-> this (.destroy))))

(defn interrupted?
  "Tests whether this thread has been interrupted.  The interrupted
   status of the thread is unaffected by this method.

   A thread interruption ignored because a thread was not alive
   at the time of the interrupt will be reflected by this method
   returning false.

  returns: true if this thread has been interrupted;
            false otherwise. - `boolean`"
  (^Boolean [^java.lang.Thread this]
    (-> this (.isInterrupted))))

(defn start
  "Causes this thread to begin execution; the Java Virtual Machine
   calls the run method of this thread.

   The result is that two threads are running concurrently: the
   current thread (which returns from the call to the
   start method) and the other thread (which executes its
   run method).

   It is never legal to start a thread more than once.
   In particular, a thread may not be restarted once it has completed
   execution.

  throws: java.lang.IllegalThreadStateException - if the thread was already started."
  ([^java.lang.Thread this]
    (-> this (.start))))

(defn count-stack-frames
  "Deprecated. The definition of this call depends on suspend(),
               which is deprecated.  Further, the results of this call
               were never well-defined.

  returns: the number of stack frames in this thread. - `java.lang.  int`

  throws: java.lang.IllegalThreadStateException - if this thread is not suspended."
  ([^java.lang.Thread this]
    (-> this (.countStackFrames))))

(defn set-priority
  "Changes the priority of this thread.

   First the checkAccess method of this thread is called
   with no arguments. This may result in throwing a
   SecurityException.

   Otherwise, the priority of this thread is set to the smaller of
   the specified newPriority and the maximum permitted
   priority of the thread's thread group.

  new-priority - priority to set this thread to - `int`

  throws: java.lang.IllegalArgumentException - If the priority is not in the range MIN_PRIORITY to MAX_PRIORITY."
  ([^java.lang.Thread this ^Integer new-priority]
    (-> this (.setPriority new-priority))))

(defn get-id
  "Returns the identifier of this Thread.  The thread ID is a positive
   long number generated when this thread was created.
   The thread ID is unique and remains unchanged during its lifetime.
   When a thread is terminated, this thread ID may be reused.

  returns: this thread's ID. - `long`"
  (^Long [^java.lang.Thread this]
    (-> this (.getId))))

(defn interrupt
  "Interrupts this thread.

    Unless the current thread is interrupting itself, which is
   always permitted, the checkAccess method
   of this thread is invoked, which may cause a SecurityException to be thrown.

    If this thread is blocked in an invocation of the wait(), wait(long), or wait(long, int) methods of the Object
   class, or of the join(), join(long), join(long, int), sleep(long), or sleep(long, int),
   methods of this class, then its interrupt status will be cleared and it
   will receive an InterruptedException.

    If this thread is blocked in an I/O operation upon an InterruptibleChannel
   then the channel will be closed, the thread's interrupt
   status will be set, and the thread will receive a ClosedByInterruptException.

    If this thread is blocked in a Selector
   then the thread's interrupt status will be set and it will return
   immediately from the selection operation, possibly with a non-zero
   value, just as if the selector's wakeup method were invoked.

    If none of the previous conditions hold then this thread's interrupt
   status will be set.

    Interrupting a thread that is not alive need not have any effect.

  throws: java.lang.SecurityException - if the current thread cannot modify this thread"
  ([^java.lang.Thread this]
    (-> this (.interrupt))))

(defn daemon?
  "Tests if this thread is a daemon thread.

  returns: true if this thread is a daemon thread;
            false otherwise. - `boolean`"
  (^Boolean [^java.lang.Thread this]
    (-> this (.isDaemon))))

(defn join
  "Waits at most millis milliseconds plus
   nanos nanoseconds for this thread to die.

    This implementation uses a loop of this.wait calls
   conditioned on this.isAlive. As a thread terminates the
   this.notifyAll method is invoked. It is recommended that
   applications not use wait, notify, or
   notifyAll on Thread instances.

  millis - the time to wait in milliseconds - `long`
  nanos - 0-999999 additional nanoseconds to wait - `int`

  throws: java.lang.IllegalArgumentException - if the value of millis is negative, or the value of nanos is not in the range 0-999999"
  ([^java.lang.Thread this ^Long millis ^Integer nanos]
    (-> this (.join millis nanos)))
  ([^java.lang.Thread this ^Long millis]
    (-> this (.join millis)))
  ([^java.lang.Thread this]
    (-> this (.join))))

(defn set-daemon
  "Marks this thread as either a daemon thread
   or a user thread. The Java Virtual Machine exits when the only
   threads running are all daemon threads.

    This method must be invoked before the thread is started.

  on - if true, marks this thread as a daemon thread - `boolean`

  throws: java.lang.IllegalThreadStateException - if this thread is alive"
  ([^java.lang.Thread this ^Boolean on]
    (-> this (.setDaemon on))))

(defn get-priority
  "Returns this thread's priority.

  returns: this thread's priority. - `int`"
  (^Integer [^java.lang.Thread this]
    (-> this (.getPriority))))

(defn set-uncaught-exception-handler
  "Set the handler invoked when this thread abruptly terminates
   due to an uncaught exception.
   A thread can take full control of how it responds to uncaught
   exceptions by having its uncaught exception handler explicitly set.
   If no such handler is set then the thread's ThreadGroup
   object acts as its handler.

  eh - the object to use as this thread's uncaught exception handler. If null then this thread has no explicit handler. - `java.lang.Thread.UncaughtExceptionHandler`

  throws: java.lang.SecurityException - if the current thread is not allowed to modify this thread."
  ([^java.lang.Thread this ^java.lang.Thread.UncaughtExceptionHandler eh]
    (-> this (.setUncaughtExceptionHandler eh))))

(defn resume
  "Deprecated. This method exists solely for use with suspend(),
       which has been deprecated because it is deadlock-prone.
       For more information, see
       Why
       are Thread.stop, Thread.suspend and Thread.resume Deprecated?.

  returns: `java.lang.   void`

  throws: java.lang.SecurityException - if the current thread cannot modify this thread."
  ([^java.lang.Thread this]
    (-> this (.resume))))

