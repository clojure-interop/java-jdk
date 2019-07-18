(ns jdk.lang.InterruptedException
  "Thrown when a thread is waiting, sleeping, or otherwise occupied,
  and the thread is interrupted, either before or during the activity.
  Occasionally a method may wish to test whether the current
  thread has been interrupted, and if so, to immediately throw
  this exception.  The following code can be used to achieve
  this effect:


   if (Thread.interrupted())  // Clears interrupted status!
       throw new InterruptedException();"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang InterruptedException]))

(defn ->interrupted-exception
  "Constructor.

  Constructs an InterruptedException with the
   specified detail message.

  s - the detail message. - `java.lang.String`"
  (^InterruptedException [^java.lang.String s]
    (new InterruptedException s))
  (^InterruptedException []
    (new InterruptedException )))

