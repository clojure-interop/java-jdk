(ns javax.sql.DataSource
  "A factory for connections to the physical data source that this
  DataSource object represents.  An alternative to the
  DriverManager facility, a DataSource object
  is the preferred means of getting a connection. An object that implements
  the DataSource interface will typically be
  registered with a naming service based on the
  Java™ Naming and Directory (JNDI) API.

  The DataSource interface is implemented by a driver vendor.
  There are three types of implementations:

    Basic implementation -- produces a standard Connection
        object
    Connection pooling implementation -- produces a Connection
        object that will automatically participate in connection pooling.  This
        implementation works with a middle-tier connection pooling manager.
    Distributed transaction implementation -- produces a
        Connection object that may be used for distributed
        transactions and almost always participates in connection pooling.
        This implementation works with a middle-tier
        transaction manager and almost always with a connection
        pooling manager.


  A DataSource object has properties that can be modified
  when necessary.  For example, if the data source is moved to a different
  server, the property for the server can be changed.  The benefit is that
  because the data source's properties can be changed, any code accessing
  that data source does not need to be changed.

  A driver that is accessed via a DataSource object does not
  register itself with the DriverManager.  Rather, a
  DataSource object is retrieved though a lookup operation
  and then used to create a Connection object.  With a basic
  implementation, the connection obtained through a DataSource
  object is identical to a connection obtained through the
  DriverManager facility.

  An implementation of DataSource must include a public no-arg
  constructor."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql DataSource]))

(defn get-connection
  "Attempts to establish a connection with the data source that
   this DataSource object represents.

  username - the database user on whose behalf the connection is being made - `java.lang.String`
  password - the user's password - `java.lang.String`

  returns: a connection to the data source - `java.sql.Connection`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^javax.sql.DataSource this ^java.lang.String username ^java.lang.String password]
    (-> this (.getConnection username password)))
  ([^javax.sql.DataSource this]
    (-> this (.getConnection))))

