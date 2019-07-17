(ns jdk.lang.Runtime
  "Every Java application has a single instance of class
  Runtime that allows the application to interface with
  the environment in which the application is running. The current
  runtime can be obtained from the getRuntime method.

  An application cannot create its own instance of this class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Runtime]))

(defn *get-runtime
  "Returns the runtime object associated with the current Java application.
   Most of the methods of class Runtime are instance
   methods and must be invoked with respect to the current runtime object.

  returns: the Runtime object associated with the current
            Java application. - `java.lang.Runtime`"
  (^java.lang.Runtime []
    (Runtime/getRuntime )))

(defn *run-finalizers-on-exit
  "Deprecated. This method is inherently unsafe.  It may result in
        finalizers being called on live objects while other threads are
        concurrently manipulating those objects, resulting in erratic
        behavior or deadlock.

  value - true to enable finalization on exit, false to disable - `boolean`

  returns: `java.lang.   void`

  throws: java.lang.SecurityException - if a security manager exists and its checkExit method doesn't allow the exit."
  ([^Boolean value]
    (Runtime/runFinalizersOnExit value)))

(defn add-shutdown-hook
  "Registers a new virtual-machine shutdown hook.

    The Java virtual machine shuts down in response to two kinds
   of events:



      The program exits normally, when the last non-daemon
     thread exits or when the exit (equivalently,
     System.exit) method is invoked, or

      The virtual machine is terminated in response to a
     user interrupt, such as typing ^C, or a system-wide event,
     such as user logoff or system shutdown.



    A shutdown hook is simply an initialized but unstarted
   thread.  When the virtual machine begins its shutdown sequence it will
   start all registered shutdown hooks in some unspecified order and let
   them run concurrently.  When all the hooks have finished it will then
   run all uninvoked finalizers if finalization-on-exit has been enabled.
   Finally, the virtual machine will halt.  Note that daemon threads will
   continue to run during the shutdown sequence, as will non-daemon threads
   if shutdown was initiated by invoking the exit
   method.

    Once the shutdown sequence has begun it can be stopped only by
   invoking the halt method, which forcibly
   terminates the virtual machine.

    Once the shutdown sequence has begun it is impossible to register a
   new shutdown hook or de-register a previously-registered hook.
   Attempting either of these operations will cause an
   IllegalStateException to be thrown.

    Shutdown hooks run at a delicate time in the life cycle of a virtual
   machine and should therefore be coded defensively.  They should, in
   particular, be written to be thread-safe and to avoid deadlocks insofar
   as possible.  They should also not rely blindly upon services that may
   have registered their own shutdown hooks and therefore may themselves in
   the process of shutting down.  Attempts to use other thread-based
   services such as the AWT event-dispatch thread, for example, may lead to
   deadlocks.

    Shutdown hooks should also finish their work quickly.  When a
   program invokes exit the expectation is
   that the virtual machine will promptly shut down and exit.  When the
   virtual machine is terminated due to user logoff or system shutdown the
   underlying operating system may only allow a fixed amount of time in
   which to shut down and exit.  It is therefore inadvisable to attempt any
   user interaction or to perform a long-running computation in a shutdown
   hook.

    Uncaught exceptions are handled in shutdown hooks just as in any
   other thread, by invoking the uncaughtException method of the thread's ThreadGroup object.  The default implementation of this method
   prints the exception's stack trace to System.err and
   terminates the thread; it does not cause the virtual machine to exit or
   halt.

    In rare circumstances the virtual machine may abort, that is,
   stop running without shutting down cleanly.  This occurs when the
   virtual machine is terminated externally, for example with the
   SIGKILL signal on Unix or the TerminateProcess call on
   Microsoft Windows.  The virtual machine may also abort if a native
   method goes awry by, for example, corrupting internal data structures or
   attempting to access nonexistent memory.  If the virtual machine aborts
   then no guarantee can be made about whether or not any shutdown hooks
   will be run.

  hook - An initialized but unstarted Thread object - `java.lang.Thread`

  throws: java.lang.IllegalArgumentException - If the specified hook has already been registered, or if it can be determined that the hook is already running or has already been run"
  ([^java.lang.Runtime this ^java.lang.Thread hook]
    (-> this (.addShutdownHook hook))))

(defn total-memory
  "Returns the total amount of memory in the Java virtual machine.
   The value returned by this method may vary over time, depending on
   the host environment.

   Note that the amount of memory required to hold an object of any
   given type may be implementation-dependent.

  returns: the total amount of memory currently available for current
            and future objects, measured in bytes. - `long`"
  (^Long [^java.lang.Runtime this]
    (-> this (.totalMemory))))

(defn trace-instructions
  "Enables/Disables tracing of instructions.
   If the boolean argument is true, this
   method suggests that the Java virtual machine emit debugging
   information for each instruction in the virtual machine as it
   is executed. The format of this information, and the file or other
   output stream to which it is emitted, depends on the host environment.
   The virtual machine may ignore this request if it does not support
   this feature. The destination of the trace output is system
   dependent.

   If the boolean argument is false, this
   method causes the virtual machine to stop performing the
   detailed instruction trace it is performing.

  on - true to enable instruction tracing; false to disable this feature. - `boolean`"
  ([^java.lang.Runtime this ^Boolean on]
    (-> this (.traceInstructions on))))

(defn max-memory
  "Returns the maximum amount of memory that the Java virtual machine will
   attempt to use.  If there is no inherent limit then the value Long.MAX_VALUE will be returned.

  returns: the maximum amount of memory that the virtual machine will
            attempt to use, measured in bytes - `long`"
  (^Long [^java.lang.Runtime this]
    (-> this (.maxMemory))))

(defn load
  "Loads the native library specified by the filename argument.  The filename
   argument must be an absolute path name.
   (for example
   Runtime.getRuntime().load(`/home/avh/lib/libX11.so`);).

   If the filename argument, when stripped of any platform-specific library
   prefix, path, and file extension, indicates a library whose name is,
   for example, L, and a native library called L is statically linked
   with the VM, then the JNI_OnLoad_L function exported by the library
   is invoked rather than attempting to load a dynamic library.
   A filename matching the argument does not have to exist in the file
   system. See the JNI Specification for more details.

   Otherwise, the filename argument is mapped to a native library image in
   an implementation-dependent manner.

   First, if there is a security manager, its checkLink
   method is called with the filename as its argument.
   This may result in a security exception.

   This is similar to the method loadLibrary(String), but it
   accepts a general file name as an argument rather than just a library
   name, allowing any file of native code to be loaded.

   The method System.load(String) is the conventional and
   convenient means of invoking this method.

  filename - the file to load. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and its checkLink method doesn't allow loading of the specified dynamic library"
  ([^java.lang.Runtime this ^java.lang.String filename]
    (-> this (.load filename))))

(defn halt
  "Forcibly terminates the currently running Java virtual machine.  This
   method never returns normally.

    This method should be used with extreme caution.  Unlike the
   exit method, this method does not cause shutdown
   hooks to be started and does not run uninvoked finalizers if
   finalization-on-exit has been enabled.  If the shutdown sequence has
   already been initiated then this method does not wait for any running
   shutdown hooks or finalizers to finish their work.

  status - Termination status. By convention, a nonzero status code indicates abnormal termination. If the exit (equivalently, System.exit) method has already been invoked then this status code will override the status code passed to that method. - `int`

  throws: java.lang.SecurityException - If a security manager is present and its checkExit method does not permit an exit with the specified status"
  ([^java.lang.Runtime this ^Integer status]
    (-> this (.halt status))))

(defn exec
  "Executes the specified string command in a separate process with the
   specified environment and working directory.

   This is a convenience method.  An invocation of the form
   exec(command, envp, dir)
   behaves in exactly the same way as the invocation
   exec(cmdarray, envp, dir),
   where cmdarray is an array of all the tokens in
   command.

   More precisely, the command string is broken
   into tokens using a StringTokenizer created by the call
   new StringTokenizer(command) with no
   further modification of the character categories.  The tokens
   produced by the tokenizer are then placed in the new string
   array cmdarray, in the same order.

  command - a specified system command. - `java.lang.String`
  envp - array of strings, each element of which has environment variable settings in the format name=value, or null if the subprocess should inherit the environment of the current process. - `java.lang.String[]`
  dir - the working directory of the subprocess, or null if the subprocess should inherit the working directory of the current process. - `java.io.File`

  returns: A new Process object for managing the subprocess - `java.lang.Process`

  throws: java.lang.SecurityException - If a security manager exists and its checkExec method doesn't allow creation of the subprocess"
  (^java.lang.Process [^java.lang.Runtime this ^java.lang.String command envp ^java.io.File dir]
    (-> this (.exec command envp dir)))
  (^java.lang.Process [^java.lang.Runtime this ^java.lang.String command envp]
    (-> this (.exec command envp)))
  (^java.lang.Process [^java.lang.Runtime this ^java.lang.String command]
    (-> this (.exec command))))

(defn load-library
  "Loads the native library specified by the libname
   argument.  The libname argument must not contain any platform
   specific prefix, file extension or path. If a native library
   called libname is statically linked with the VM, then the
   JNI_OnLoad_libname function exported by the library is invoked.
   See the JNI Specification for more details.

   Otherwise, the libname argument is loaded from a system library
   location and mapped to a native library image in an implementation-
   dependent manner.

   First, if there is a security manager, its checkLink
   method is called with the libname as its argument.
   This may result in a security exception.

   The method System.loadLibrary(String) is the conventional
   and convenient means of invoking this method. If native
   methods are to be used in the implementation of a class, a standard
   strategy is to put the native code in a library file (call it
   LibFile) and then to put a static initializer:


   static { System.loadLibrary(`LibFile`); }
   within the class declaration. When the class is loaded and
   initialized, the necessary native code implementation for the native
   methods will then be loaded as well.

   If this method is called more than once with the same library
   name, the second and subsequent calls are ignored.

  libname - the name of the library. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and its checkLink method doesn't allow loading of the specified dynamic library"
  ([^java.lang.Runtime this ^java.lang.String libname]
    (-> this (.loadLibrary libname))))

(defn get-localized-output-stream
  "Deprecated. As of JDK 1.1, the preferred way to translate a
   Unicode character stream into a byte stream in the local encoding is via
   the OutputStreamWriter, BufferedWriter, and
   PrintWriter classes.

  out - OutputStream to localize - `java.io.OutputStream`

  returns: a localized output stream - `java.lang.  java.io.OutputStream`"
  ([^java.lang.Runtime this ^java.io.OutputStream out]
    (-> this (.getLocalizedOutputStream out))))

(defn available-processors
  "Returns the number of processors available to the Java virtual machine.

    This value may change during a particular invocation of the virtual
   machine.  Applications that are sensitive to the number of available
   processors should therefore occasionally poll this property and adjust
   their resource usage appropriately.

  returns: the maximum number of processors available to the virtual
            machine; never smaller than one - `int`"
  (^Integer [^java.lang.Runtime this]
    (-> this (.availableProcessors))))

(defn free-memory
  "Returns the amount of free memory in the Java Virtual Machine.
   Calling the
   gc method may result in increasing the value returned
   by freeMemory.

  returns: an approximation to the total amount of memory currently
            available for future allocated objects, measured in bytes. - `long`"
  (^Long [^java.lang.Runtime this]
    (-> this (.freeMemory))))

(defn exit
  "Terminates the currently running Java virtual machine by initiating its
   shutdown sequence.  This method never returns normally.  The argument
   serves as a status code; by convention, a nonzero status code indicates
   abnormal termination.

    The virtual machine's shutdown sequence consists of two phases.  In
   the first phase all registered shutdown hooks,
   if any, are started in some unspecified order and allowed to run
   concurrently until they finish.  In the second phase all uninvoked
   finalizers are run if finalization-on-exit
   has been enabled.  Once this is done the virtual machine halts.

    If this method is invoked after the virtual machine has begun its
   shutdown sequence then if shutdown hooks are being run this method will
   block indefinitely.  If shutdown hooks have already been run and on-exit
   finalization has been enabled then this method halts the virtual machine
   with the given status code if the status is nonzero; otherwise, it
   blocks indefinitely.

    The System.exit method is the
   conventional and convenient means of invoking this method.

  status - Termination status. By convention, a nonzero status code indicates abnormal termination. - `int`

  throws: java.lang.SecurityException - If a security manager is present and its checkExit method does not permit exiting with the specified status"
  ([^java.lang.Runtime this ^Integer status]
    (-> this (.exit status))))

(defn trace-method-calls
  "Enables/Disables tracing of method calls.
   If the boolean argument is true, this
   method suggests that the Java virtual machine emit debugging
   information for each method in the virtual machine as it is
   called. The format of this information, and the file or other output
   stream to which it is emitted, depends on the host environment. The
   virtual machine may ignore this request if it does not support
   this feature.

   Calling this method with argument false suggests that the
   virtual machine cease emitting per-call debugging information.

  on - true to enable instruction tracing; false to disable this feature. - `boolean`"
  ([^java.lang.Runtime this ^Boolean on]
    (-> this (.traceMethodCalls on))))

(defn get-localized-input-stream
  "Deprecated. As of JDK 1.1, the preferred way to translate a byte
   stream in the local encoding into a character stream in Unicode is via
   the InputStreamReader and BufferedReader
   classes.

  in - InputStream to localize - `java.io.InputStream`

  returns: a localized input stream - `java.lang.  java.io.InputStream`"
  ([^java.lang.Runtime this ^java.io.InputStream in]
    (-> this (.getLocalizedInputStream in))))

(defn remove-shutdown-hook
  "De-registers a previously-registered virtual-machine shutdown hook.

  hook - the hook to remove - `java.lang.Thread`

  returns: true if the specified hook had previously been
   registered and was successfully de-registered, false
   otherwise. - `boolean`

  throws: java.lang.IllegalStateException - If the virtual machine is already in the process of shutting down"
  (^Boolean [^java.lang.Runtime this ^java.lang.Thread hook]
    (-> this (.removeShutdownHook hook))))

(defn run-finalization
  "Runs the finalization methods of any objects pending finalization.
   Calling this method suggests that the Java virtual machine expend
   effort toward running the finalize methods of objects
   that have been found to be discarded but whose finalize
   methods have not yet been run. When control returns from the
   method call, the virtual machine has made a best effort to
   complete all outstanding finalizations.

   The virtual machine performs the finalization process
   automatically as needed, in a separate thread, if the
   runFinalization method is not invoked explicitly.

   The method System.runFinalization() is the conventional
   and convenient means of invoking this method."
  ([^java.lang.Runtime this]
    (-> this (.runFinalization))))

(defn gc
  "Runs the garbage collector.
   Calling this method suggests that the Java virtual machine expend
   effort toward recycling unused objects in order to make the memory
   they currently occupy available for quick reuse. When control
   returns from the method call, the virtual machine has made
   its best effort to recycle all discarded objects.

   The name gc stands for `garbage
   collector`. The virtual machine performs this recycling
   process automatically as needed, in a separate thread, even if the
   gc method is not invoked explicitly.

   The method System.gc() is the conventional and convenient
   means of invoking this method."
  ([^java.lang.Runtime this]
    (-> this (.gc))))

