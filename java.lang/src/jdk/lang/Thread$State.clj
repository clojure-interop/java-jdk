(ns jdk.lang.Thread$State
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Thread$State]))

(def NEW
  "Enum Constant.

  Thread state for a thread which has not yet started.

  type: java.lang.Thread.State"
  Thread$State/NEW)

(def RUNNABLE
  "Enum Constant.

  Thread state for a runnable thread.  A thread in the runnable
   state is executing in the Java virtual machine but it may
   be waiting for other resources from the operating system
   such as processor.

  type: java.lang.Thread.State"
  Thread$State/RUNNABLE)

(def BLOCKED
  "Enum Constant.

  Thread state for a thread blocked waiting for a monitor lock.
   A thread in the blocked state is waiting for a monitor lock
   to enter a synchronized block/method or
   reenter a synchronized block/method after calling
   Object.wait.

  type: java.lang.Thread.State"
  Thread$State/BLOCKED)

(def WAITING
  "Enum Constant.

  Thread state for a waiting thread.
   A thread is in the waiting state due to calling one of the
   following methods:

     Object.wait with no timeout
     Thread.join with no timeout
     LockSupport.park


   A thread in the waiting state is waiting for another thread to
   perform a particular action.

   For example, a thread that has called Object.wait()
   on an object is waiting for another thread to call
   Object.notify() or Object.notifyAll() on
   that object. A thread that has called Thread.join()
   is waiting for a specified thread to terminate.

  type: java.lang.Thread.State"
  Thread$State/WAITING)

(def TIMED_WAITING
  "Enum Constant.

  Thread state for a waiting thread with a specified waiting time.
   A thread is in the timed waiting state due to calling one of
   the following methods with a specified positive waiting time:

     Thread.sleep
     Object.wait with timeout
     Thread.join with timeout
     LockSupport.parkNanos
     LockSupport.parkUntil

  type: java.lang.Thread.State"
  Thread$State/TIMED_WAITING)

(def TERMINATED
  "Enum Constant.

  Thread state for a terminated thread.
   The thread has completed execution.

  type: java.lang.Thread.State"
  Thread$State/TERMINATED)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (Thread.State c : Thread.State.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.lang.Thread.State[]`"
  ([]
    (Thread$State/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.lang.Thread.State`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (Thread$State/valueOf name)))

