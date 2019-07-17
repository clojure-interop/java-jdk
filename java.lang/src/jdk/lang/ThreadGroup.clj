(ns jdk.lang.ThreadGroup
  "A thread group represents a set of threads. In addition, a thread
  group can also include other thread groups. The thread groups form
  a tree in which every thread group except the initial thread group
  has a parent.

  A thread is allowed to access information about its own thread
  group, but not to access information about its thread group's
  parent thread group or any other thread groups."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang ThreadGroup]))

(defn ->thread-group
  "Constructor.

  Creates a new thread group. The parent of this new group is the
   specified thread group.

   The checkAccess method of the parent thread group is
   called with no arguments; this may result in a security exception.

  parent - the parent thread group. - `java.lang.ThreadGroup`
  name - the name of the new thread group. - `java.lang.String`

  throws: java.lang.NullPointerException - if the thread group argument is null."
  ([parent name]
    (new ThreadGroup parent name))
  ([name]
    (new ThreadGroup name)))

(defn stop
  "Deprecated. This method is inherently unsafe.  See
       Thread.stop() for details.

  returns: `java.lang.   void`

  throws: java.lang.SecurityException - if the current thread is not allowed to access this thread group or any of the threads in the thread group."
  ([this]
    (-> this (.stop))))

(defn list
  "Prints information about this thread group to the standard
   output. This method is useful only for debugging."
  ([this]
    (-> this (.list))))

(defn allow-thread-suspension
  "Deprecated. The definition of this call depends on suspend(),
               which is deprecated.  Further, the behavior of this call
               was never specified.

  b - boolean to allow or disallow suspension - `boolean`

  returns: true on success - `java.lang.  boolean`"
  ([this b]
    (-> this (.allowThreadSuspension b))))

(defn suspend
  "Deprecated. This method is inherently deadlock-prone.  See
       Thread.suspend() for details.

  returns: `java.lang.   void`

  throws: java.lang.SecurityException - if the current thread is not allowed to access this thread group or any of the threads in the thread group."
  ([this]
    (-> this (.suspend))))

(defn parent-of
  "Tests if this thread group is either the thread group
   argument or one of its ancestor thread groups.

  g - a thread group. - `java.lang.ThreadGroup`

  returns: true if this thread group is the thread group
            argument or one of its ancestor thread groups;
            false otherwise. - `boolean`"
  ([this g]
    (-> this (.parentOf g))))

(defn to-string
  "Returns a string representation of this Thread group.

  returns: a string representation of this thread group. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn uncaught-exception
  "Called by the Java Virtual Machine when a thread in this
   thread group stops because of an uncaught exception, and the thread
   does not have a specific Thread.UncaughtExceptionHandler
   installed.

   The uncaughtException method of
   ThreadGroup does the following:

   If this thread group has a parent thread group, the
       uncaughtException method of that parent is called
       with the same two arguments.
   Otherwise, this method checks to see if there is a
       default
       uncaught exception handler installed, and if so, its
       uncaughtException method is called with the same
       two arguments.
   Otherwise, this method determines if the Throwable
       argument is an instance of ThreadDeath. If so, nothing
       special is done. Otherwise, a message containing the
       thread's name, as returned from the thread's getName method, and a stack backtrace,
       using the Throwable's printStackTrace method, is
       printed to the standard error stream.


   Applications can override this method in subclasses of
   ThreadGroup to provide alternative handling of
   uncaught exceptions.

  t - the thread that is about to exit. - `java.lang.Thread`
  e - the uncaught exception. - `java.lang.Throwable`"
  ([this t e]
    (-> this (.uncaughtException t e))))

(defn check-access
  "Determines if the currently running thread has permission to
   modify this thread group.

   If there is a security manager, its checkAccess method
   is called with this thread group as its argument. This may result
   in throwing a SecurityException.

  throws: java.lang.SecurityException - if the current thread is not allowed to access this thread group."
  ([this]
    (-> this (.checkAccess))))

(defn get-name
  "Returns the name of this thread group.

  returns: the name of this thread group. - `java.lang.String`"
  ([this]
    (-> this (.getName))))

(defn enumerate
  "Copies into the specified array every active thread in this
   thread group. If recurse is true,
   this method recursively enumerates all subgroups of this
   thread group and references to every active thread in these
   subgroups are also included. If the array is too short to
   hold all the threads, the extra threads are silently ignored.

    An application might use the activeCount
   method to get an estimate of how big the array should be, however
   if the array is too short to hold all the threads, the extra threads
   are silently ignored.  If it is critical to obtain every active
   thread in this thread group, the caller should verify that the returned
   int value is strictly less than the length of list.

    Due to the inherent race condition in this method, it is recommended
   that the method only be used for debugging and monitoring purposes.

  list - an array into which to put the list of threads - `java.lang.Thread[]`
  recurse - if true, recursively enumerate all subgroups of this thread group - `boolean`

  returns: the number of threads put into the array - `int`

  throws: java.lang.SecurityException - if checkAccess determines that the current thread cannot access this thread group"
  ([this list recurse]
    (-> this (.enumerate list recurse)))
  ([this list]
    (-> this (.enumerate list))))

(defn destroy
  "Destroys this thread group and all of its subgroups. This thread
   group must be empty, indicating that all threads that had been in
   this thread group have since stopped.

   First, the checkAccess method of this thread group is
   called with no arguments; this may result in a security exception.

  throws: java.lang.IllegalThreadStateException - if the thread group is not empty or if the thread group has already been destroyed."
  ([this]
    (-> this (.destroy))))

(defn get-parent
  "Returns the parent of this thread group.

   First, if the parent is not null, the
   checkAccess method of the parent thread group is
   called with no arguments; this may result in a security exception.

  returns: the parent of this thread group. The top-level thread group
            is the only thread group whose parent is null. - `java.lang.ThreadGroup`

  throws: java.lang.SecurityException - if the current thread cannot modify this thread group."
  ([this]
    (-> this (.getParent))))

(defn set-max-priority
  "Sets the maximum priority of the group. Threads in the thread
   group that already have a higher priority are not affected.

   First, the checkAccess method of this thread group is
   called with no arguments; this may result in a security exception.

   If the pri argument is less than
   Thread.MIN_PRIORITY or greater than
   Thread.MAX_PRIORITY, the maximum priority of the group
   remains unchanged.

   Otherwise, the priority of this ThreadGroup object is set to the
   smaller of the specified pri and the maximum permitted
   priority of the parent of this thread group. (If this thread group
   is the system thread group, which has no parent, then its maximum
   priority is simply set to pri.) Then this method is
   called recursively, with pri as its argument, for
   every thread group that belongs to this thread group.

  pri - the new priority of the thread group. - `int`

  throws: java.lang.SecurityException - if the current thread cannot modify this thread group."
  ([this pri]
    (-> this (.setMaxPriority pri))))

(defn get-max-priority
  "Returns the maximum priority of this thread group. Threads that are
   part of this group cannot have a higher priority than the maximum
   priority.

  returns: the maximum priority that a thread in this thread group
            can have. - `int`"
  ([this]
    (-> this (.getMaxPriority))))

(defn active-count
  "Returns an estimate of the number of active threads in this thread
   group and its subgroups. Recursively iterates over all subgroups in
   this thread group.

    The value returned is only an estimate because the number of
   threads may change dynamically while this method traverses internal
   data structures, and might be affected by the presence of certain
   system threads. This method is intended primarily for debugging
   and monitoring purposes.

  returns: an estimate of the number of active threads in this thread
            group and in any other thread group that has this thread
            group as an ancestor - `int`"
  ([this]
    (-> this (.activeCount))))

(defn interrupt
  "Interrupts all threads in this thread group.

   First, the checkAccess method of this thread group is
   called with no arguments; this may result in a security exception.

   This method then calls the interrupt method on all the
   threads in this thread group and in all of its subgroups.

  throws: java.lang.SecurityException - if the current thread is not allowed to access this thread group or any of the threads in the thread group."
  ([this]
    (-> this (.interrupt))))

(defn daemon?
  "Tests if this thread group is a daemon thread group. A
   daemon thread group is automatically destroyed when its last
   thread is stopped or its last thread group is destroyed.

  returns: true if this thread group is a daemon thread group;
            false otherwise. - `boolean`"
  ([this]
    (-> this (.isDaemon))))

(defn set-daemon
  "Changes the daemon status of this thread group.

   First, the checkAccess method of this thread group is
   called with no arguments; this may result in a security exception.

   A daemon thread group is automatically destroyed when its last
   thread is stopped or its last thread group is destroyed.

  daemon - if true, marks this thread group as a daemon thread group; otherwise, marks this thread group as normal. - `boolean`

  throws: java.lang.SecurityException - if the current thread cannot modify this thread group."
  ([this daemon]
    (-> this (.setDaemon daemon))))

(defn active-group-count
  "Returns an estimate of the number of active groups in this
   thread group and its subgroups. Recursively iterates over
   all subgroups in this thread group.

    The value returned is only an estimate because the number of
   thread groups may change dynamically while this method traverses
   internal data structures. This method is intended primarily for
   debugging and monitoring purposes.

  returns: the number of active thread groups with this thread group as
            an ancestor - `int`"
  ([this]
    (-> this (.activeGroupCount))))

(defn destroyed?
  "Tests if this thread group has been destroyed.

  returns: true if this object is destroyed - `boolean`"
  ([this]
    (-> this (.isDestroyed))))

(defn resume
  "Deprecated. This method is used solely in conjunction with
        Thread.suspend and ThreadGroup.suspend,
         both of which have been deprecated, as they are inherently
         deadlock-prone.  See Thread.suspend() for details.

  returns: `java.lang.   void`

  throws: java.lang.SecurityException - if the current thread is not allowed to access this thread group or any of the threads in the thread group."
  ([this]
    (-> this (.resume))))

