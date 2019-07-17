(ns jdk.awt.event.InvocationEvent
  "An event which executes the run() method on a Runnable
   when dispatched by the AWT event dispatcher thread. This class can
  be used as a reference implementation of ActiveEvent rather
  than declaring a new class and defining dispatch().

  Instances of this class are placed on the EventQueue by calls
  to invokeLater and invokeAndWait. Client code
  can use this fact to write replacement functions for invokeLater
   and invokeAndWait without writing special-case code
  in any AWTEventListener objects.

  An unspecified behavior will be caused if the id parameter
  of any particular InvocationEvent instance is not
  in the range from INVOCATION_FIRST to INVOCATION_LAST."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event InvocationEvent]))

(defn ->invocation-event
  "Constructor.

  Constructs an InvocationEvent with the specified
   source which will execute the runnable's run
   method when dispatched.  If notifier is non-null,
   notifyAll() will be called on it
   immediately after run has returned or thrown an exception.
   An invocation of the form InvocationEvent(source,
   runnable, notifier, catchThrowables)
   behaves in exactly the same way as the invocation of
   InvocationEvent(source, InvocationEvent.INVOCATION_DEFAULT, runnable, notifier, catchThrowables).
   This method throws an IllegalArgumentException
   if source is null.

  source - The Object that originated the event - `java.lang.Object`
  runnable - The Runnable whose run method will be executed - `java.lang.Runnable`
  notifier - The Object whose notifyAll method will be called after Runnable.run has returned or thrown an exception or after the event was disposed - `java.lang.Object`
  catch-throwables - Specifies whether dispatch should catch Throwable when executing the Runnable's run method, or should instead propagate those Throwables to the EventDispatchThread's dispatch loop - `boolean`

  throws: java.lang.IllegalArgumentException - if source is null"
  ([^java.lang.Object source ^java.lang.Runnable runnable ^java.lang.Object notifier ^Boolean catch-throwables]
    (new InvocationEvent source runnable notifier catch-throwables))
  ([^java.lang.Object source ^java.lang.Runnable runnable]
    (new InvocationEvent source runnable)))

(def *-invocation-first
  "Static Constant.

  Marks the first integer id for the range of invocation event ids.

  type: int"
  InvocationEvent/INVOCATION_FIRST)

(def *-invocation-default
  "Static Constant.

  The default id for all InvocationEvents.

  type: int"
  InvocationEvent/INVOCATION_DEFAULT)

(def *-invocation-last
  "Static Constant.

  Marks the last integer id for the range of invocation event ids.

  type: int"
  InvocationEvent/INVOCATION_LAST)

(defn dispatch
  "Executes the Runnable's run() method and notifies the
   notifier (if any) when run() has returned or thrown an exception."
  ([^java.awt.event.InvocationEvent this]
    (-> this (.dispatch))))

(defn get-exception
  "Returns any Exception caught while executing the Runnable's run()
    method.

  returns: A reference to the Exception if one was thrown; null if no
            Exception was thrown or if this InvocationEvent does not
            catch exceptions - `java.lang.Exception`"
  (^java.lang.Exception [^java.awt.event.InvocationEvent this]
    (-> this (.getException))))

(defn get-throwable
  "Returns any Throwable caught while executing the Runnable's run()
    method.

  returns: A reference to the Throwable if one was thrown; null if no
            Throwable was thrown or if this InvocationEvent does not
            catch Throwables - `java.lang.Throwable`"
  (^java.lang.Throwable [^java.awt.event.InvocationEvent this]
    (-> this (.getThrowable))))

(defn get-when
  "Returns the timestamp of when this event occurred.

  returns: this event's timestamp - `long`"
  (^Long [^java.awt.event.InvocationEvent this]
    (-> this (.getWhen))))

(defn dispatched?
  "Returns true if the event is dispatched or any exception is
   thrown while dispatching, false otherwise. The method should
   be called by a waiting thread that calls the notifier.wait() method.
   Since spurious wakeups are possible (as explained in Object.wait()),
   this method should be used in a waiting loop to ensure that the event
   got dispatched:


       while (!event.isDispatched()) {
           notifier.wait();
       }
   If the waiting thread wakes up without dispatching the event,
   the isDispatched() method returns false, and
   the while loop executes once more, thus, causing
   the awakened thread to revert to the waiting mode.

   If the notifier.notifyAll() happens before the waiting thread
   enters the notifier.wait() method, the while loop ensures
   that the waiting thread will not enter the notifier.wait() method.
   Otherwise, there is no guarantee that the waiting thread will ever be woken
   from the wait.

  returns: true if the event has been dispatched, or any exception
   has been thrown while dispatching, false otherwise - `boolean`"
  (^Boolean [^java.awt.event.InvocationEvent this]
    (-> this (.isDispatched))))

(defn param-string
  "Returns a parameter string identifying this event.
   This method is useful for event-logging and for debugging.

  returns: A string identifying the event and its attributes - `java.lang.String`"
  (^java.lang.String [^java.awt.event.InvocationEvent this]
    (-> this (.paramString))))

