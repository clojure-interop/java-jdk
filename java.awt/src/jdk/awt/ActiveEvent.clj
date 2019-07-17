(ns jdk.awt.ActiveEvent
  "An interface for events that know how to dispatch themselves.
  By implementing this interface an event can be placed upon the event
  queue and its dispatch() method will be called when the event
  is dispatched, using the EventDispatchThread.

  This is a very useful mechanism for avoiding deadlocks. If
  a thread is executing in a critical section (i.e., it has entered
  one or more monitors), calling other synchronized code may
  cause deadlocks. To avoid the potential deadlocks, an
  ActiveEvent can be created to run the second section of
  code at later time. If there is contention on the monitor,
  the second thread will simply block until the first thread
  has finished its work and exited its monitors.

  For security reasons, it is often desirable to use an ActiveEvent
  to avoid calling untrusted code from a critical thread. For
  instance, peer implementations can use this facility to avoid
  making calls into user code from a system thread. Doing so avoids
  potential deadlocks and denial-of-service attacks."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt ActiveEvent]))

(defn dispatch
  "Dispatch the event to its target, listeners of the events source,
   or do whatever it is this event is supposed to do."
  ([this]
    (-> this (.dispatch))))

