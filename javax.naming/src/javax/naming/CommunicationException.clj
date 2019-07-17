(ns javax.naming.CommunicationException
  "This exception is thrown when the client is
  unable to communicate with the directory or naming service.
  The inability to communicate with the service might be a result
  of many factors, such as network partitioning, hardware or interface problems,
  failures on either the client or server side.
  This exception is meant to be used to capture such communication problems.

  Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming CommunicationException]))

(defn ->communication-exception
  "Constructor.

  Constructs a new instance of CommunicationException using the
   arguments supplied.

  explanation - Additional detail about this exception. - `java.lang.String`"
  ([explanation]
    (new CommunicationException explanation))
  ([]
    (new CommunicationException )))

