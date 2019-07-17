(ns javax.security.auth.DestroyFailedException
  "Signals that a destroy operation failed.

   This exception is thrown by credentials implementing
  the Destroyable interface when the destroy
  method fails."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth DestroyFailedException]))

(defn ->destroy-failed-exception
  "Constructor.

  Constructs a DestroyFailedException with the specified detail
   message.  A detail message is a String that describes this particular
   exception.

  msg - the detail message. - `java.lang.String`"
  ([msg]
    (new DestroyFailedException msg))
  ([]
    (new DestroyFailedException )))

