(ns jdk.lang.management.ThreadMXBean
  "The management interface for the thread system of
  the Java virtual machine.

   A Java virtual machine has a single instance of the implementation
  class of this interface.  This instance implementing this interface is
  an MXBean
  that can be obtained by calling
  the ManagementFactory.getThreadMXBean() method or
  from the platform MBeanServer method.

  The ObjectName for uniquely identifying the MXBean for
  the thread system within an MBeanServer is:

     java.lang:type=Threading


  It can be obtained by calling the
  PlatformManagedObject.getObjectName() method.

  Thread ID
  Thread ID is a positive long value returned by calling the
  Thread.getId() method for a thread.
  The thread ID is unique during its lifetime.  When a thread
  is terminated, this thread ID may be reused.

   Some methods in this interface take a thread ID or an array
  of thread IDs as the input parameter and return per-thread information.

  Thread CPU time
  A Java virtual machine implementation may support measuring
  the CPU time for the current thread, for any thread, or for no threads.


  The isThreadCpuTimeSupported() method can be used to determine
  if a Java virtual machine supports measuring of the CPU time for any
  thread.  The isCurrentThreadCpuTimeSupported() method can
  be used to determine if a Java virtual machine supports measuring of
  the CPU time for the current  thread.
  A Java virtual machine implementation that supports CPU time measurement
  for any thread will also support that for the current thread.

   The CPU time provided by this interface has nanosecond precision
  but not necessarily nanosecond accuracy.


  A Java virtual machine may disable CPU time measurement
  by default.
  The isThreadCpuTimeEnabled() and setThreadCpuTimeEnabled(boolean)
  methods can be used to test if CPU time measurement is enabled
  and to enable/disable this support respectively.
  Enabling thread CPU measurement could be expensive in some
  Java virtual machine implementations.

  Thread Contention Monitoring
  Some Java virtual machines may support thread contention monitoring.
  When thread contention monitoring is enabled, the accumulated elapsed
  time that the thread has blocked for synchronization or waited for
  notification will be collected and returned in the
  ThreadInfo object.

  The isThreadContentionMonitoringSupported() method can be used to
  determine if a Java virtual machine supports thread contention monitoring.
  The thread contention monitoring is disabled by default.  The
  setThreadContentionMonitoringEnabled(boolean) method can be used to enable
  thread contention monitoring.

  Synchronization Information and Deadlock Detection
  Some Java virtual machines may support monitoring of
  object monitor usage and
  ownable synchronizer usage.
  The getThreadInfo(long[], boolean, boolean) and
  dumpAllThreads(boolean, boolean) methods can be used to obtain the thread stack trace
  and synchronization information including which
  lock a thread is blocked to
  acquire or waiting on and which locks the thread currently owns.

  The ThreadMXBean interface provides the
  findMonitorDeadlockedThreads() and
  findDeadlockedThreads() methods to find deadlocks in
  the running application."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.management ThreadMXBean]))

(defn find-monitor-deadlocked-threads
  "Finds cycles of threads that are in deadlock waiting to acquire
   object monitors. That is, threads that are blocked waiting to enter a
   synchronization block or waiting to reenter a synchronization block
   after an Object.wait call,
   where each thread owns one monitor while
   trying to obtain another monitor already held by another thread
   in a cycle.

   More formally, a thread is monitor deadlocked if it is
   part of a cycle in the relation \"is waiting for an object monitor
   owned by\".  In the simplest case, thread A is blocked waiting
   for a monitor owned by thread B, and thread B is blocked waiting
   for a monitor owned by thread A.

   This method is designed for troubleshooting use, but not for
   synchronization control.  It might be an expensive operation.

   This method finds deadlocks involving only object monitors.
   To find deadlocks involving both object monitors and
   ownable synchronizers,
   the findDeadlockedThreads method
   should be used.

  returns: an array of IDs of the threads that are monitor
   deadlocked, if any; null otherwise. - `long[]`

  throws: java.lang.SecurityException - if a security manager exists and the caller does not have ManagementPermission(\"monitor\")."
  ([^ThreadMXBean this]
    (-> this (.findMonitorDeadlockedThreads))))

(defn get-peak-thread-count
  "Returns the peak live thread count since the Java virtual machine
   started or peak was reset.

  returns: the peak live thread count. - `int`"
  (^Integer [^ThreadMXBean this]
    (-> this (.getPeakThreadCount))))

(defn get-current-thread-user-time
  "Returns the CPU time that the current thread has executed
   in user mode in nanoseconds.
   The returned value is of nanoseconds precision but
   not necessarily nanoseconds accuracy.


   This is a convenient method for local management use and is
   equivalent to calling:


     getThreadUserTime(Thread.currentThread().getId());

  returns: the user-level CPU time for the current thread if CPU time
   measurement is enabled; -1 otherwise. - `long`

  throws: java.lang.UnsupportedOperationException - if the Java virtual machine does not support CPU time measurement for the current thread."
  (^Long [^ThreadMXBean this]
    (-> this (.getCurrentThreadUserTime))))

(defn synchronizer-usage-supported?
  "Tests if the Java virtual machine supports monitoring of

   ownable synchronizer usage.

  returns: true
       if the Java virtual machine supports monitoring of ownable
       synchronizer usage;
     false otherwise. - `boolean`"
  (^Boolean [^ThreadMXBean this]
    (-> this (.isSynchronizerUsageSupported))))

(defn reset-peak-thread-count
  "Resets the peak thread count to the current number of
   live threads.

  throws: java.lang.SecurityException - if a security manager exists and the caller does not have ManagementPermission(\"control\")."
  ([^ThreadMXBean this]
    (-> this (.resetPeakThreadCount))))

(defn find-deadlocked-threads
  "Finds cycles of threads that are in deadlock waiting to acquire
   object monitors or
   ownable synchronizers.

   Threads are deadlocked in a cycle waiting for a lock of
   these two types if each thread owns one lock while
   trying to acquire another lock already held
   by another thread in the cycle.

   This method is designed for troubleshooting use, but not for
   synchronization control.  It might be an expensive operation.

  returns: an array of IDs of the threads that are
   deadlocked waiting for object monitors or ownable synchronizers, if any;
   null otherwise. - `long[]`

  throws: java.lang.SecurityException - if a security manager exists and the caller does not have ManagementPermission(\"monitor\")."
  ([^ThreadMXBean this]
    (-> this (.findDeadlockedThreads))))

(defn current-thread-cpu-time-supported?
  "Tests if the Java virtual machine supports CPU time
   measurement for the current thread.
   This method returns true if isThreadCpuTimeSupported()
   returns true.

  returns: true
       if the Java virtual machine supports CPU time
       measurement for current thread;
     false otherwise. - `boolean`"
  (^Boolean [^ThreadMXBean this]
    (-> this (.isCurrentThreadCpuTimeSupported))))

(defn get-thread-user-time
  "Returns the CPU time that a thread of the specified ID
   has executed in user mode in nanoseconds.
   The returned value is of nanoseconds precision but
   not necessarily nanoseconds accuracy.


   If the thread of the specified ID is not alive or does not exist,
   this method returns -1. If CPU time measurement
   is disabled, this method returns -1.
   A thread is alive if it has been started and has not yet died.

   If CPU time measurement is enabled after the thread has started,
   the Java virtual machine implementation may choose any time up to
   and including the time that the capability is enabled as the point
   where CPU time measurement starts.

  id - the thread ID of a thread - `long`

  returns: the user-level CPU time for a thread of the specified ID
   if the thread of the specified ID exists, the thread is alive,
   and CPU time measurement is enabled;
   -1 otherwise. - `long`

  throws: java.lang.IllegalArgumentException - if id <= 0."
  (^Long [^ThreadMXBean this ^Long id]
    (-> this (.getThreadUserTime id))))

(defn set-thread-cpu-time-enabled
  "Enables or disables thread CPU time measurement.  The default
   is platform dependent.

  enable - true to enable; false to disable. - `boolean`

  throws: java.lang.UnsupportedOperationException - if the Java virtual machine does not support CPU time measurement for any threads nor for the current thread."
  ([^ThreadMXBean this ^Boolean enable]
    (-> this (.setThreadCpuTimeEnabled enable))))

(defn thread-cpu-time-supported?
  "Tests if the Java virtual machine implementation supports CPU time
   measurement for any thread.
   A Java virtual machine implementation that supports CPU time
   measurement for any thread will also support CPU time
   measurement for the current thread.

  returns: true
       if the Java virtual machine supports CPU time
       measurement for any thread;
     false otherwise. - `boolean`"
  (^Boolean [^ThreadMXBean this]
    (-> this (.isThreadCpuTimeSupported))))

(defn thread-contention-monitoring-supported?
  "Tests if the Java virtual machine supports thread contention monitoring.

  returns: true
       if the Java virtual machine supports thread contention monitoring;
     false otherwise. - `boolean`"
  (^Boolean [^ThreadMXBean this]
    (-> this (.isThreadContentionMonitoringSupported))))

(defn get-total-started-thread-count
  "Returns the total number of threads created and also started
   since the Java virtual machine started.

  returns: the total number of threads started. - `long`"
  (^Long [^ThreadMXBean this]
    (-> this (.getTotalStartedThreadCount))))

(defn get-thread-info
  "Returns the thread info for each thread
   whose ID is in the input array ids, with stack trace
   and synchronization information.


   This method obtains a snapshot of the thread information
   for each thread including:

      the entire stack trace,
      the object monitors currently locked by the thread
          if lockedMonitors is true, and
      the
          ownable synchronizers currently locked by the thread
          if lockedSynchronizers is true.


   This method returns an array of the ThreadInfo objects,
   each is the thread information about the thread with the same index
   as in the ids array.
   If a thread of the given ID is not alive or does not exist,
   null will be set in the corresponding element
   in the returned array.  A thread is alive if
   it has been started and has not yet died.

   If a thread does not lock any object monitor or lockedMonitors
   is false, the returned ThreadInfo object will have an
   empty MonitorInfo array.  Similarly, if a thread does not
   lock any synchronizer or lockedSynchronizers is false,
   the returned ThreadInfo object
   will have an empty LockInfo array.


   When both lockedMonitors and lockedSynchronizers
   parameters are false, it is equivalent to calling:


       getThreadInfo(ids, Integer.MAX_VALUE)


   This method is designed for troubleshooting use, but not for
   synchronization control.  It might be an expensive operation.


   MBeanServer access:
   The mapped type of ThreadInfo is
   CompositeData with attributes as specified in the
   ThreadInfo.from method.

  ids - an array of thread IDs. - `long[]`
  locked-monitors - if true, retrieves all locked monitors. - `boolean`
  locked-synchronizers - if true, retrieves all locked ownable synchronizers. - `boolean`

  returns: an array of the ThreadInfo objects, each containing
   information about a thread whose ID is in the corresponding
   element of the input array of IDs. - `java.lang.management.ThreadInfo[]`

  throws: java.lang.SecurityException - if a security manager exists and the caller does not have ManagementPermission(\"monitor\")."
  ([^ThreadMXBean this ids ^Boolean locked-monitors ^Boolean locked-synchronizers]
    (-> this (.getThreadInfo ids locked-monitors locked-synchronizers)))
  (^java.lang.management.ThreadInfo [^ThreadMXBean this ^Long id ^Integer max-depth]
    (-> this (.getThreadInfo id max-depth)))
  (^java.lang.management.ThreadInfo [^ThreadMXBean this ^Long id]
    (-> this (.getThreadInfo id))))

(defn get-thread-cpu-time
  "Returns the total CPU time for a thread of the specified ID in nanoseconds.
   The returned value is of nanoseconds precision but
   not necessarily nanoseconds accuracy.
   If the implementation distinguishes between user mode time and system
   mode time, the returned CPU time is the amount of time that
   the thread has executed in user mode or system mode.


   If the thread of the specified ID is not alive or does not exist,
   this method returns -1. If CPU time measurement
   is disabled, this method returns -1.
   A thread is alive if it has been started and has not yet died.

   If CPU time measurement is enabled after the thread has started,
   the Java virtual machine implementation may choose any time up to
   and including the time that the capability is enabled as the point
   where CPU time measurement starts.

  id - the thread ID of a thread - `long`

  returns: the total CPU time for a thread of the specified ID
   if the thread of the specified ID exists, the thread is alive,
   and CPU time measurement is enabled;
   -1 otherwise. - `long`

  throws: java.lang.IllegalArgumentException - if id <= 0."
  (^Long [^ThreadMXBean this ^Long id]
    (-> this (.getThreadCpuTime id))))

(defn dump-all-threads
  "Returns the thread info for all live threads with stack trace
   and synchronization information.
   Some threads included in the returned array
   may have been terminated when this method returns.


   This method returns an array of ThreadInfo objects
   as specified in the getThreadInfo(long[], boolean, boolean)
   method.

  locked-monitors - if true, dump all locked monitors. - `boolean`
  locked-synchronizers - if true, dump all locked ownable synchronizers. - `boolean`

  returns: an array of ThreadInfo for all live threads. - `java.lang.management.ThreadInfo[]`

  throws: java.lang.SecurityException - if a security manager exists and the caller does not have ManagementPermission(\"monitor\")."
  ([^ThreadMXBean this ^Boolean locked-monitors ^Boolean locked-synchronizers]
    (-> this (.dumpAllThreads locked-monitors locked-synchronizers))))

(defn get-thread-count
  "Returns the current number of live threads including both
   daemon and non-daemon threads.

  returns: the current number of live threads. - `int`"
  (^Integer [^ThreadMXBean this]
    (-> this (.getThreadCount))))

(defn get-current-thread-cpu-time
  "Returns the total CPU time for the current thread in nanoseconds.
   The returned value is of nanoseconds precision but
   not necessarily nanoseconds accuracy.
   If the implementation distinguishes between user mode time and system
   mode time, the returned CPU time is the amount of time that
   the current thread has executed in user mode or system mode.


   This is a convenient method for local management use and is
   equivalent to calling:


     getThreadCpuTime(Thread.currentThread().getId());

  returns: the total CPU time for the current thread if CPU time
   measurement is enabled; -1 otherwise. - `long`

  throws: java.lang.UnsupportedOperationException - if the Java virtual machine does not support CPU time measurement for the current thread."
  (^Long [^ThreadMXBean this]
    (-> this (.getCurrentThreadCpuTime))))

(defn thread-contention-monitoring-enabled?
  "Tests if thread contention monitoring is enabled.

  returns: true if thread contention monitoring is enabled;
           false otherwise. - `boolean`

  throws: java.lang.UnsupportedOperationException - if the Java virtual machine does not support thread contention monitoring."
  (^Boolean [^ThreadMXBean this]
    (-> this (.isThreadContentionMonitoringEnabled))))

(defn get-all-thread-ids
  "Returns all live thread IDs.
   Some threads included in the returned array
   may have been terminated when this method returns.

  returns: an array of long, each is a thread ID. - `long[]`

  throws: java.lang.SecurityException - if a security manager exists and the caller does not have ManagementPermission(\"monitor\")."
  ([^ThreadMXBean this]
    (-> this (.getAllThreadIds))))

(defn object-monitor-usage-supported?
  "Tests if the Java virtual machine supports monitoring of
   object monitor usage.

  returns: true
       if the Java virtual machine supports monitoring of
       object monitor usage;
     false otherwise. - `boolean`"
  (^Boolean [^ThreadMXBean this]
    (-> this (.isObjectMonitorUsageSupported))))

(defn set-thread-contention-monitoring-enabled
  "Enables or disables thread contention monitoring.
   Thread contention monitoring is disabled by default.

  enable - true to enable; false to disable. - `boolean`

  throws: java.lang.UnsupportedOperationException - if the Java virtual machine does not support thread contention monitoring."
  ([^ThreadMXBean this ^Boolean enable]
    (-> this (.setThreadContentionMonitoringEnabled enable))))

(defn get-daemon-thread-count
  "Returns the current number of live daemon threads.

  returns: the current number of live daemon threads. - `int`"
  (^Integer [^ThreadMXBean this]
    (-> this (.getDaemonThreadCount))))

(defn thread-cpu-time-enabled?
  "Tests if thread CPU time measurement is enabled.

  returns: true if thread CPU time measurement is enabled;
           false otherwise. - `boolean`

  throws: java.lang.UnsupportedOperationException - if the Java virtual machine does not support CPU time measurement for other threads nor for the current thread."
  (^Boolean [^ThreadMXBean this]
    (-> this (.isThreadCpuTimeEnabled))))

