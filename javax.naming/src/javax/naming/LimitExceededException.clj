(ns javax.naming.LimitExceededException
  "This exception is thrown when a method
  terminates abnormally due to a user or system specified limit.
  This is different from a InsufficientResourceException in that
  LimitExceededException is due to a user/system specified limit.
  For example, running out of memory to complete the request would
  be an insufficient resource. The client asking for 10 answers and
  getting back 11 is a size limit exception.

  Examples of these limits include client and server configuration
  limits such as size, time, number of hops, etc.

  Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming LimitExceededException]))

(defn ->limit-exceeded-exception
  "Constructor.

  Constructs a new instance of LimitExceededException using an
   explanation. All other fields default to null.

  explanation - Possibly null detail about this exception. - `java.lang.String`"
  (^LimitExceededException [^java.lang.String explanation]
    (new LimitExceededException explanation))
  (^LimitExceededException []
    (new LimitExceededException )))

