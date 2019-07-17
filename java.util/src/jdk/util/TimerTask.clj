(ns jdk.util.TimerTask
  "A task that can be scheduled for one-time or repeated execution by a Timer."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util TimerTask]))

(defn run
  "The action to be performed by this timer task."
  ([^java.util.TimerTask this]
    (-> this (.run))))

(defn cancel
  "Cancels this timer task.  If the task has been scheduled for one-time
   execution and has not yet run, or has not yet been scheduled, it will
   never run.  If the task has been scheduled for repeated execution, it
   will never run again.  (If the task is running when this call occurs,
   the task will run to completion, but will never run again.)

   Note that calling this method from within the run method of
   a repeating timer task absolutely guarantees that the timer task will
   not run again.

   This method may be called repeatedly; the second and subsequent
   calls have no effect.

  returns: true if this task is scheduled for one-time execution and has
           not yet run, or this task is scheduled for repeated execution.
           Returns false if the task was scheduled for one-time execution
           and has already run, or if the task was never scheduled, or if
           the task was already cancelled.  (Loosely speaking, this method
           returns true if it prevents one or more scheduled
           executions from taking place.) - `boolean`"
  (^Boolean [^java.util.TimerTask this]
    (-> this (.cancel))))

(defn scheduled-execution-time
  "Returns the scheduled execution time of the most recent
   actual execution of this task.  (If this method is invoked
   while task execution is in progress, the return value is the scheduled
   execution time of the ongoing task execution.)

   This method is typically invoked from within a task's run method, to
   determine whether the current execution of the task is sufficiently
   timely to warrant performing the scheduled activity:


     public void run() {
         if (System.currentTimeMillis() - scheduledExecutionTime() >=
             MAX_TARDINESS)
                 return;  // Too late; skip this execution.
         // Perform the task
     }
   This method is typically not used in conjunction with
   fixed-delay execution repeating tasks, as their scheduled
   execution times are allowed to drift over time, and so are not terribly
   significant.

  returns: the time at which the most recent execution of this task was
           scheduled to occur, in the format returned by Date.getTime().
           The return value is undefined if the task has yet to commence
           its first execution. - `long`"
  (^Long [^java.util.TimerTask this]
    (-> this (.scheduledExecutionTime))))

