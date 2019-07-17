(ns jdk.util.Timer
  "A facility for threads to schedule tasks for future execution in a
  background thread.  Tasks may be scheduled for one-time execution, or for
  repeated execution at regular intervals.

  Corresponding to each Timer object is a single background
  thread that is used to execute all of the timer's tasks, sequentially.
  Timer tasks should complete quickly.  If a timer task takes excessive time
  to complete, it `hogs` the timer's task execution thread.  This can, in
  turn, delay the execution of subsequent tasks, which may `bunch up` and
  execute in rapid succession when (and if) the offending task finally
  completes.

  After the last live reference to a Timer object goes away
  and all outstanding tasks have completed execution, the timer's task
  execution thread terminates gracefully (and becomes subject to garbage
  collection).  However, this can take arbitrarily long to occur.  By
  default, the task execution thread does not run as a daemon thread,
  so it is capable of keeping an application from terminating.  If a caller
  wants to terminate a timer's task execution thread rapidly, the caller
  should invoke the timer's cancel method.

  If the timer's task execution thread terminates unexpectedly, for
  example, because its stop method is invoked, any further
  attempt to schedule a task on the timer will result in an
  IllegalStateException, as if the timer's cancel
  method had been invoked.

  This class is thread-safe: multiple threads can share a single
  Timer object without the need for external synchronization.

  This class does not offer real-time guarantees: it schedules
  tasks using the Object.wait(long) method.

  Java 5.0 introduced the java.util.concurrent package and
  one of the concurrency utilities therein is the ScheduledThreadPoolExecutor which is a thread pool for repeatedly
  executing tasks at a given rate or delay.  It is effectively a more
  versatile replacement for the Timer/TimerTask
  combination, as it allows multiple service threads, accepts various
  time units, and doesn't require subclassing TimerTask (just
  implement Runnable).  Configuring ScheduledThreadPoolExecutor with one thread makes it equivalent to
  Timer.

  Implementation note: This class scales to large numbers of concurrently
  scheduled tasks (thousands should present no problem).  Internally,
  it uses a binary heap to represent its task queue, so the cost to schedule
  a task is O(log n), where n is the number of concurrently scheduled tasks.

  Implementation note: All constructors start a timer thread."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Timer]))

(defn ->timer
  "Constructor.

  Creates a new timer whose associated thread has the specified name,
   and may be specified to
   run as a daemon.

  name - the name of the associated thread - `java.lang.String`
  is-daemon - true if the associated thread should run as a daemon - `boolean`

  throws: java.lang.NullPointerException - if name is null"
  ([^java.lang.String name ^Boolean is-daemon]
    (new Timer name is-daemon))
  ([^Boolean is-daemon]
    (new Timer is-daemon))
  ([]
    (new Timer )))

(defn schedule
  "Schedules the specified task for repeated fixed-delay execution,
   beginning after the specified delay.  Subsequent executions take place
   at approximately regular intervals separated by the specified period.

   In fixed-delay execution, each execution is scheduled relative to
   the actual execution time of the previous execution.  If an execution
   is delayed for any reason (such as garbage collection or other
   background activity), subsequent executions will be delayed as well.
   In the long run, the frequency of execution will generally be slightly
   lower than the reciprocal of the specified period (assuming the system
   clock underlying Object.wait(long) is accurate).

   Fixed-delay execution is appropriate for recurring activities
   that require `smoothness.`  In other words, it is appropriate for
   activities where it is more important to keep the frequency accurate
   in the short run than in the long run.  This includes most animation
   tasks, such as blinking a cursor at regular intervals.  It also includes
   tasks wherein regular activity is performed in response to human
   input, such as automatically repeating a character as long as a key
   is held down.

  task - task to be scheduled. - `java.util.TimerTask`
  delay - delay in milliseconds before task is to be executed. - `long`
  period - time in milliseconds between successive task executions. - `long`

  throws: java.lang.IllegalArgumentException - if delay < 0, or delay System.currentTimeMillis() < 0, or period <= 0"
  ([^java.util.Timer this ^java.util.TimerTask task ^Long delay ^Long period]
    (-> this (.schedule task delay period)))
  ([^java.util.Timer this ^java.util.TimerTask task ^Long delay]
    (-> this (.schedule task delay))))

(defn schedule-at-fixed-rate
  "Schedules the specified task for repeated fixed-rate execution,
   beginning after the specified delay.  Subsequent executions take place
   at approximately regular intervals, separated by the specified period.

   In fixed-rate execution, each execution is scheduled relative to the
   scheduled execution time of the initial execution.  If an execution is
   delayed for any reason (such as garbage collection or other background
   activity), two or more executions will occur in rapid succession to
   `catch up.`  In the long run, the frequency of execution will be
   exactly the reciprocal of the specified period (assuming the system
   clock underlying Object.wait(long) is accurate).

   Fixed-rate execution is appropriate for recurring activities that
   are sensitive to absolute time, such as ringing a chime every
   hour on the hour, or running scheduled maintenance every day at a
   particular time.  It is also appropriate for recurring activities
   where the total time to perform a fixed number of executions is
   important, such as a countdown timer that ticks once every second for
   ten seconds.  Finally, fixed-rate execution is appropriate for
   scheduling multiple repeating timer tasks that must remain synchronized
   with respect to one another.

  task - task to be scheduled. - `java.util.TimerTask`
  delay - delay in milliseconds before task is to be executed. - `long`
  period - time in milliseconds between successive task executions. - `long`

  throws: java.lang.IllegalArgumentException - if delay < 0, or delay System.currentTimeMillis() < 0, or period <= 0"
  ([^java.util.Timer this ^java.util.TimerTask task ^Long delay ^Long period]
    (-> this (.scheduleAtFixedRate task delay period))))

(defn cancel
  "Terminates this timer, discarding any currently scheduled tasks.
   Does not interfere with a currently executing task (if it exists).
   Once a timer has been terminated, its execution thread terminates
   gracefully, and no more tasks may be scheduled on it.

   Note that calling this method from within the run method of a
   timer task that was invoked by this timer absolutely guarantees that
   the ongoing task execution is the last task execution that will ever
   be performed by this timer.

   This method may be called repeatedly; the second and subsequent
   calls have no effect."
  ([^java.util.Timer this]
    (-> this (.cancel))))

(defn purge
  "Removes all cancelled tasks from this timer's task queue.  Calling
   this method has no effect on the behavior of the timer, but
   eliminates the references to the cancelled tasks from the queue.
   If there are no external references to these tasks, they become
   eligible for garbage collection.

   Most programs will have no need to call this method.
   It is designed for use by the rare application that cancels a large
   number of tasks.  Calling this method trades time for space: the
   runtime of the method may be proportional to n  c log n, where n
   is the number of tasks in the queue and c is the number of cancelled
   tasks.

   Note that it is permissible to call this method from within a
   a task scheduled on this timer.

  returns: the number of tasks removed from the queue. - `int`"
  ([^java.util.Timer this]
    (-> this (.purge))))

