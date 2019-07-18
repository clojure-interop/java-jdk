(ns javax.naming.ServiceUnavailableException
  "This exception is thrown when attempting to communicate with a
  directory or naming service and that service is not available.
  It might be unavailable for different reasons. For example,
  the server might be too busy to service the request, or the server
  might not be registered to service any requests, etc.

  Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming ServiceUnavailableException]))

(defn ->service-unavailable-exception
  "Constructor.

  Constructs a new instance of ServiceUnavailableException using an
   explanation. All other fields default to null.

  explanation - Possibly null additional detail about this exception. - `java.lang.String`"
  (^ServiceUnavailableException [^java.lang.String explanation]
    (new ServiceUnavailableException explanation))
  (^ServiceUnavailableException []
    (new ServiceUnavailableException )))

