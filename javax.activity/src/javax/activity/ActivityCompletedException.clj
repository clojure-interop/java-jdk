(ns javax.activity.ActivityCompletedException
  "This exception may be thrown on any method for which Activity context is
  accessed and indicates that ongoing work within the Activity is not
  possible. This may be because the Activity has been instructed to complete
  with CompletionStatusFailOnly or has ended as a result of a timeout. This
  exception will be propagated across ORB boundaries via an
  org.omg.CORBA.ACTIVITY_COMPLETED system exception. An application should
  handle this error by attempting to complete the Activity."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.activity ActivityCompletedException]))

(defn ->activity-completed-exception
  "Constructor.

  Constructs a new throwable with the specified detail message and cause.

  message - the detail message. - `java.lang.String`
  cause - a chained exception of type Throwable. - `java.lang.Throwable`"
  ([message cause]
    (new ActivityCompletedException message cause))
  ([message]
    (new ActivityCompletedException message))
  ([]
    (new ActivityCompletedException )))

