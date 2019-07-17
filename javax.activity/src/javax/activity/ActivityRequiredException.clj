(ns javax.activity.ActivityRequiredException
  "This exception is thrown by a container if Activity context is not received
  on a method for which Activity context is mandatory. This exception
  indicates a deployment or application configuration error. This exception
  will be propagated across ORB boundaries via an
  org.omg.CORBA.ACTIVITY_REQUIRED system exception."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.activity ActivityRequiredException]))

(defn ->activity-required-exception
  "Constructor.

  Constructs a new throwable with the specified detail message and cause.

  message - the detail message. - `java.lang.String`
  cause - a chained exception of type Throwable. - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.Throwable cause]
    (new ActivityRequiredException message cause))
  ([^java.lang.String message]
    (new ActivityRequiredException message))
  ([]
    (new ActivityRequiredException )))

