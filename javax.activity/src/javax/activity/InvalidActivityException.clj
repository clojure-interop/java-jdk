(ns javax.activity.InvalidActivityException
  "This exception may be thrown on any method for which Activity context
  is accessed and indicates that the attempted invocation or the Activity
  context associated with the attempted invocation is incompatible with
  the Activity's current state. It may also be thrown by a container if
  Activity context is received on a method for which Activity context is
  forbidden. This exception will be propagated across J2EE Activity Service
  ORB boundaries via an org.omg.CORBA.INVALID_ACTIVITY system exception.
  An application should handle this error by attempting to complete the
  Activity."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.activity InvalidActivityException]))

(defn ->invalid-activity-exception
  "Constructor.

  Constructs a new throwable with the specified detail message and cause.

  message - the detail message. - `java.lang.String`
  cause - a chained exception of type Throwable. - `java.lang.Throwable`"
  ([message cause]
    (new InvalidActivityException message cause))
  ([message]
    (new InvalidActivityException message))
  ([]
    (new InvalidActivityException )))

