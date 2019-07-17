(ns jdk.sql.Driver
  "The interface that every driver class must implement.
  The Java SQL framework allows for multiple database drivers.

  Each driver should supply a class that implements
  the Driver interface.

  The DriverManager will try to load as many drivers as it can
  find and then for any given connection request, it will ask each
  driver in turn to try to connect to the target URL.

  It is strongly recommended that each Driver class should be
  small and standalone so that the Driver class can be loaded and
  queried without bringing in vast quantities of supporting code.

  When a Driver class is loaded, it should create an instance of
  itself and register it with the DriverManager. This means that a
  user can load and register a driver by calling:

  Class.forName(`foo.bah.Driver`)

  A JDBC driver may create a java.sql.DriverAction implementation in order
  to receive notifications when DriverManager.deregisterDriver(java.sql.Driver) has
  been called."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql Driver]))

(defn connect
  "Attempts to make a database connection to the given URL.
   The driver should return `null` if it realizes it is the wrong kind
   of driver to connect to the given URL.  This will be common, as when
   the JDBC driver manager is asked to connect to a given URL it passes
   the URL to each loaded driver in turn.

   The driver should throw an SQLException if it is the right
   driver to connect to the given URL but has trouble connecting to
   the database.

   The Properties argument can be used to pass
   arbitrary string tag/value pairs as connection arguments.
   Normally at least `user` and `password` properties should be
   included in the Properties object.

   Note: If a property is specified as part of the url and
   is also specified in the Properties object, it is
   implementation-defined as to which value will take precedence. For
   maximum portability, an application should only specify a property once.

  url - the URL of the database to which to connect - `java.lang.String`
  info - a list of arbitrary string tag/value pairs as connection arguments. Normally at least a `user` and `password` property should be included. - `java.util.Properties`

  returns: a Connection object that represents a
           connection to the URL - `java.sql.Connection`

  throws: java.sql.SQLException - if a database access error occurs or the url is null"
  ([this url info]
    (-> this (.connect url info))))

(defn accepts-url
  "Retrieves whether the driver thinks that it can open a connection
   to the given URL.  Typically drivers will return true if they
   understand the sub-protocol specified in the URL and false if
   they do not.

  url - the URL of the database - `java.lang.String`

  returns: true if this driver understands the given URL;
           false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs or the url is null"
  ([this url]
    (-> this (.acceptsURL url))))

(defn get-property-info
  "Gets information about the possible properties for this driver.

   The getPropertyInfo method is intended to allow a generic
   GUI tool to discover what properties it should prompt
   a human for in order to get
   enough information to connect to a database.  Note that depending on
   the values the human has supplied so far, additional values may become
   necessary, so it may be necessary to iterate though several calls
   to the getPropertyInfo method.

  url - the URL of the database to which to connect - `java.lang.String`
  info - a proposed list of tag/value pairs that will be sent on connect open - `java.util.Properties`

  returns: an array of DriverPropertyInfo objects describing
            possible properties.  This array may be an empty array if
            no properties are required. - `java.sql.DriverPropertyInfo[]`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this url info]
    (-> this (.getPropertyInfo url info))))

(defn get-major-version
  "Retrieves the driver's major version number. Initially this should be 1.

  returns: this driver's major version number - `int`"
  ([this]
    (-> this (.getMajorVersion))))

(defn get-minor-version
  "Gets the driver's minor version number. Initially this should be 0.

  returns: this driver's minor version number - `int`"
  ([this]
    (-> this (.getMinorVersion))))

(defn jdbc-compliant
  "Reports whether this driver is a genuine JDBC
   Compliant™ driver.
   A driver may only report true here if it passes the JDBC
   compliance tests; otherwise it is required to return false.

   JDBC compliance requires full support for the JDBC API and full support
   for SQL 92 Entry Level.  It is expected that JDBC compliant drivers will
   be available for all the major commercial databases.

   This method is not intended to encourage the development of non-JDBC
   compliant drivers, but is a recognition of the fact that some vendors
   are interested in using the JDBC API and framework for lightweight
   databases that do not support full database functionality, or for
   special databases such as document information retrieval where a SQL
   implementation may not be feasible.

  returns: true if this driver is JDBC Compliant; false
           otherwise - `boolean`"
  ([this]
    (-> this (.jdbcCompliant))))

(defn get-parent-logger
  "Return the parent Logger of all the Loggers used by this driver. This
   should be the Logger farthest from the root Logger that is
   still an ancestor of all of the Loggers used by this driver. Configuring
   this Logger will affect all of the log messages generated by the driver.
   In the worst case, this may be the root Logger.

  returns: the parent Logger for this driver - `java.util.logging.Logger`

  throws: java.sql.SQLFeatureNotSupportedException - if the driver does not use java.util.logging."
  ([this]
    (-> this (.getParentLogger))))

