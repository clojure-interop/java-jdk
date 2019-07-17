(ns javax.sql.StatementEvent
  "A StatementEvent is sent to all StatementEventListeners which were
  registered with a PooledConnection. This occurs when the driver determines that a
  PreparedStatement that is associated with the PooledConnection has been closed or the driver determines
  is invalid."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql StatementEvent]))

(defn ->statement-event
  "Constructor.

  Constructs a StatementEvent with the specified PooledConnection,
   PreparedStatement and SQLException

  con - The PooledConnection that the closed or invalid PreparedStatement is associated with. - `javax.sql.PooledConnection`
  statement - The PreparedStatement that is being closed or is invalid - `java.sql.PreparedStatement`
  exception - The SQLException the driver is about to throw to the application - `java.sql.SQLException`

  throws: java.lang.IllegalArgumentException - if con is null."
  ([con statement exception]
    (new StatementEvent con statement exception))
  ([con statement]
    (new StatementEvent con statement)))

(defn get-statement
  "Returns the PreparedStatement that is being closed or is invalid

  returns: The PreparedStatement that is being closed or is invalid - `java.sql.PreparedStatement`"
  ([this]
    (-> this (.getStatement))))

(defn get-sql-exception
  "Returns the SQLException the driver is about to throw

  returns: The SQLException the driver is about to throw - `java.sql.SQLException`"
  ([this]
    (-> this (.getSQLException))))

