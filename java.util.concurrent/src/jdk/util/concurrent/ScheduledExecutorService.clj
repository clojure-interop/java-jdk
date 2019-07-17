(ns jdk.util.concurrent.ScheduledExecutorService
  "An ExecutorService that can schedule commands to run after a given
  delay, or to execute periodically.

  The schedule methods create tasks with various delays
  and return a task object that can be used to cancel or check
  execution. The scheduleAtFixedRate and
  scheduleWithFixedDelay methods create and execute tasks
  that run periodically until cancelled.

  Commands submitted using the Executor.execute(Runnable)
  and ExecutorService submit methods are scheduled
  with a requested delay of zero. Zero and negative delays (but not
  periods) are also allowed in schedule methods, and are
  treated as requests for immediate execution.

  All schedule methods accept relative delays and
  periods as arguments, not absolute times or dates. It is a simple
  matter to transform an absolute time represented as a Date to the required form. For example, to schedule at
  a certain future date, you can use: schedule(task,
  date.getTime() - System.currentTimeMillis(),
  TimeUnit.MILLISECONDS). Beware however that expiration of a
  relative delay need not coincide with the current Date at
  which the task is enabled due to network time synchronization
  protocols, clock drift, or other factors.

  The Executors class provides convenient factory methods for
  the ScheduledExecutorService implementations provided in this package.

  Usage Example

  Here is a class with a method that sets up a ScheduledExecutorService
  to beep every ten seconds for an hour:



  import static java.util.concurrent.TimeUnit.*;
  class BeeperControl {
    private final ScheduledExecutorService scheduler =
      Executors.newScheduledThreadPool(1);

    public void beepForAnHour() {
      final Runnable beeper = new Runnable() {
        public void run() { System.out.println(`beep`); }
      };
      final ScheduledFuture<?> beeperHandle =
        scheduler.scheduleAtFixedRate(beeper, 10, 10, SECONDS);
      scheduler.schedule(new Runnable() {
        public void run() { beeperHandle.cancel(true); }
      }, 60 * 60, SECONDS);
    }
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ScheduledExecutorService]))

(defn schedule
  "Creates and executes a one-shot action that becomes enabled
   after the given delay.

  command - the task to execute - `java.lang.Runnable`
  delay - the time from now to delay execution - `long`
  unit - the time unit of the delay parameter - `java.util.concurrent.TimeUnit`

  returns: a ScheduledFuture representing pending completion of
           the task and whose get() method will return
           null upon completion - `java.util.concurrent.ScheduledFuture<?>`

  throws: java.util.concurrent.RejectedExecutionException - if the task cannot be scheduled for execution"
  (^java.util.concurrent.ScheduledFuture [^java.util.concurrent.ScheduledExecutorService this ^java.lang.Runnable command ^Long delay ^java.util.concurrent.TimeUnit unit]
    (-> this (.schedule command delay unit))))

(defn schedule-at-fixed-rate
  "Creates and executes a periodic action that becomes enabled first
   after the given initial delay, and subsequently with the given
   period; that is executions will commence after
   initialDelay then initialDelay+period, then
   initialDelay  2 * period, and so on.
   If any execution of the task
   encounters an exception, subsequent executions are suppressed.
   Otherwise, the task will only terminate via cancellation or
   termination of the executor.  If any execution of this task
   takes longer than its period, then subsequent executions
   may start late, but will not concurrently execute.

  command - the task to execute - `java.lang.Runnable`
  initial-delay - the time to delay first execution - `long`
  period - the period between successive executions - `long`
  unit - the time unit of the initialDelay and period parameters - `java.util.concurrent.TimeUnit`

  returns: a ScheduledFuture representing pending completion of
           the task, and whose get() method will throw an
           exception upon cancellation - `java.util.concurrent.ScheduledFuture<?>`

  throws: java.util.concurrent.RejectedExecutionException - if the task cannot be scheduled for execution"
  (^java.util.concurrent.ScheduledFuture [^java.util.concurrent.ScheduledExecutorService this ^java.lang.Runnable command ^Long initial-delay ^Long period ^java.util.concurrent.TimeUnit unit]
    (-> this (.scheduleAtFixedRate command initial-delay period unit))))

(defn schedule-with-fixed-delay
  "Creates and executes a periodic action that becomes enabled first
   after the given initial delay, and subsequently with the
   given delay between the termination of one execution and the
   commencement of the next.  If any execution of the task
   encounters an exception, subsequent executions are suppressed.
   Otherwise, the task will only terminate via cancellation or
   termination of the executor.

  command - the task to execute - `java.lang.Runnable`
  initial-delay - the time to delay first execution - `long`
  delay - the delay between the termination of one execution and the commencement of the next - `long`
  unit - the time unit of the initialDelay and delay parameters - `java.util.concurrent.TimeUnit`

  returns: a ScheduledFuture representing pending completion of
           the task, and whose get() method will throw an
           exception upon cancellation - `java.util.concurrent.ScheduledFuture<?>`

  throws: java.util.concurrent.RejectedExecutionException - if the task cannot be scheduled for execution"
  (^java.util.concurrent.ScheduledFuture [^java.util.concurrent.ScheduledExecutorService this ^java.lang.Runnable command ^Long initial-delay ^Long delay ^java.util.concurrent.TimeUnit unit]
    (-> this (.scheduleWithFixedDelay command initial-delay delay unit))))

