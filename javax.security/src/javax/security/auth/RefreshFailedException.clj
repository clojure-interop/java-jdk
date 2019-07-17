(ns javax.security.auth.RefreshFailedException
  "Signals that a refresh operation failed.

   This exception is thrown by credentials implementing
  the Refreshable interface when the refresh
  method fails."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth RefreshFailedException]))

(defn ->refresh-failed-exception
  "Constructor.

  Constructs a RefreshFailedException with the specified detail
   message.  A detail message is a String that describes this particular
   exception.

  msg - the detail message. - `java.lang.String`"
  ([msg]
    (new RefreshFailedException msg))
  ([]
    (new RefreshFailedException )))

