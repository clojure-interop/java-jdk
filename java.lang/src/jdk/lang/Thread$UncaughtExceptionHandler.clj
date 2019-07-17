(ns jdk.lang.Thread$UncaughtExceptionHandler
  "Interface for handlers invoked when a Thread abruptly
  terminates due to an uncaught exception.
  When a thread is about to terminate due to an uncaught exception
  the Java Virtual Machine will query the thread for its
  UncaughtExceptionHandler using
  Thread.getUncaughtExceptionHandler() and will invoke the handler's
  uncaughtException method, passing the thread and the
  exception as arguments.
  If a thread has not had its UncaughtExceptionHandler
  explicitly set, then its ThreadGroup object acts as its
  UncaughtExceptionHandler. If the ThreadGroup object
  has no
  special requirements for dealing with the exception, it can forward
  the invocation to the default uncaught exception handler."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Thread$UncaughtExceptionHandler]))

(defn uncaught-exception
  "Method invoked when the given thread terminates due to the
   given uncaught exception.
   Any exception thrown by this method will be ignored by the
   Java Virtual Machine.

  t - the thread - `java.lang.Thread`
  e - the exception - `java.lang.Throwable`"
  ([this t e]
    (-> this (.uncaughtException t e))))

