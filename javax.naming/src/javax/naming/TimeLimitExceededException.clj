(ns javax.naming.TimeLimitExceededException
  "This exception is thrown when a method
  does not terminate within the specified time limit.
  This can happen, for example, if the user specifies that
  the method should take no longer than 10 seconds, and the
  method fails to complete with 10 seconds.

   Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming TimeLimitExceededException]))

(defn ->time-limit-exceeded-exception
  "Constructor.

  Constructs a new instance of TimeLimitExceededException
   using the argument supplied.

  explanation - possibly null detail about this exception. - `java.lang.String`"
  ([explanation]
    (new TimeLimitExceededException explanation))
  ([]
    (new TimeLimitExceededException )))

