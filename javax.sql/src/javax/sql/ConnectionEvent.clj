(ns javax.sql.ConnectionEvent
  "An Event object that provides information about the
  source of a connection-related event.  ConnectionEvent
  objects are generated when an application closes a pooled connection
  and when an error occurs.  The ConnectionEvent object
  contains two kinds of information:

    The pooled connection closed by the application
    In the case of an error event, the SQLException
        about to be thrown to the application"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql ConnectionEvent]))

(defn ->connection-event
  "Constructor.

  Constructs a ConnectionEvent object initialized with
   the given PooledConnection object and
   SQLException object.

  con - the pooled connection that is the source of the event - `javax.sql.PooledConnection`
  ex - the SQLException about to be thrown to the application - `java.sql.SQLException`

  throws: java.lang.IllegalArgumentException - if con is null."
  ([con ex]
    (new ConnectionEvent con ex))
  ([con]
    (new ConnectionEvent con)))

(defn get-sql-exception
  "Retrieves the SQLException for this
   ConnectionEvent object. May be null.

  returns: the SQLException about to be thrown or null - `java.sql.SQLException`"
  ([this]
    (-> this (.getSQLException))))

