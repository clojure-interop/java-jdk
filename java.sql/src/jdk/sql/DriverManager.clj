(ns jdk.sql.DriverManager
  "The basic service for managing a set of JDBC drivers.
  NOTE: The DataSource interface, new in the
  JDBC 2.0 API, provides another way to connect to a data source.
  The use of a DataSource object is the preferred means of
  connecting to a data source.

  As part of its initialization, the DriverManager class will
  attempt to load the driver classes referenced in the `jdbc.drivers`
  system property. This allows a user to customize the JDBC Drivers
  used by their applications. For example in your
  ~/.hotjava/properties file you might specify:


  jdbc.drivers=foo.bah.Driver:wombat.sql.Driver:bad.taste.ourDriver
  The DriverManager methods getConnection and
  getDrivers have been enhanced to support the Java Standard Edition
  Service Provider mechanism. JDBC 4.0 Drivers must
  include the file META-INF/services/java.sql.Driver. This file contains the name of the JDBC drivers
  implementation of java.sql.Driver.  For example, to load the my.sql.Driver class,
  the META-INF/services/java.sql.Driver file would contain the entry:


  my.sql.Driver

  Applications no longer need to explicitly load JDBC drivers using Class.forName(). Existing programs
  which currently load JDBC drivers using Class.forName() will continue to work without
  modification.

  When the method getConnection is called,
  the DriverManager will attempt to
  locate a suitable driver from amongst those loaded at
  initialization and those loaded explicitly using the same classloader
  as the current applet or application.


  Starting with the Java 2 SDK, Standard Edition, version 1.3, a
  logging stream can be set only if the proper
  permission has been granted.  Normally this will be done with
  the tool PolicyTool, which can be used to grant permission
  java.sql.SQLPermission `setLog`."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql DriverManager]))

(defn *register-driver
  "Registers the given driver with the DriverManager.
   A newly-loaded driver class should call
   the method registerDriver to make itself
   known to the DriverManager. If the driver is currently
   registered, no action is taken.

  driver - the new JDBC Driver that is to be registered with the DriverManager - `java.sql.Driver`
  da - the DriverAction implementation to be used when DriverManager#deregisterDriver is called - `java.sql.DriverAction`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.Driver driver ^java.sql.DriverAction da]
    (DriverManager/registerDriver driver da))
  ([^java.sql.Driver driver]
    (DriverManager/registerDriver driver)))

(defn *println
  "Prints a message to the current JDBC log stream.

  message - a log or tracing message - `java.lang.String`"
  ([^java.lang.String message]
    (DriverManager/println message)))

(defn *set-login-timeout
  "Sets the maximum time in seconds that a driver will wait
   while attempting to connect to a database once the driver has
   been identified.

  seconds - the login time limit in seconds; zero means there is no limit - `int`"
  ([^Integer seconds]
    (DriverManager/setLoginTimeout seconds)))

(defn *set-log-stream
  "Deprecated. Use setLogWriter

  out - the new logging/tracing PrintStream; to disable, set to null - `java.io.PrintStream`

  throws: java.lang.SecurityException - if a security manager exists and its checkPermission method denies setting the log stream"
  ([^java.io.PrintStream out]
    (DriverManager/setLogStream out)))

(defn *set-log-writer
  "Sets the logging/tracing PrintWriter object
   that is used by the DriverManager and all drivers.

   There is a minor versioning problem created by the introduction
   of the method setLogWriter.  The
   method setLogWriter cannot create a PrintStream object
   that will be returned by getLogStream---the Java platform does
   not provide a backward conversion.  As a result, a new application
   that uses setLogWriter and also uses a JDBC 1.0 driver that uses
   getLogStream will likely not see debugging information written
   by that driver.

   Starting with the Java 2 SDK, Standard Edition, version 1.3 release, this method checks
   to see that there is an SQLPermission object before setting
   the logging stream.  If a SecurityManager exists and its
   checkPermission method denies setting the log writer, this
   method throws a java.lang.SecurityException.

  out - the new logging/tracing PrintStream object; null to disable logging and tracing - `java.io.PrintWriter`

  throws: java.lang.SecurityException - if a security manager exists and its checkPermission method denies setting the log writer"
  ([^java.io.PrintWriter out]
    (DriverManager/setLogWriter out)))

(defn *get-log-writer
  "Retrieves the log writer.

   The getLogWriter and setLogWriter
   methods should be used instead
   of the get/setlogStream methods, which are deprecated.

  returns: a java.io.PrintWriter object - `java.io.PrintWriter`"
  (^java.io.PrintWriter []
    (DriverManager/getLogWriter )))

(defn *get-connection
  "Attempts to establish a connection to the given database URL.
   The DriverManager attempts to select an appropriate driver from
   the set of registered JDBC drivers.

   Note: If the user or password property are
   also specified as part of the url, it is
   implementation-defined as to which value will take precedence.
   For maximum portability, an application should only specify a
   property once.

  url - a database url of the form jdbc:subprotocol:subname - `java.lang.String`
  user - the database user on whose behalf the connection is being made - `java.lang.String`
  password - the user's password - `java.lang.String`

  returns: a connection to the URL - `java.sql.Connection`

  throws: java.sql.SQLException - if a database access error occurs or the url is null"
  (^java.sql.Connection [^java.lang.String url ^java.lang.String user ^java.lang.String password]
    (DriverManager/getConnection url user password))
  (^java.sql.Connection [^java.lang.String url ^java.util.Properties info]
    (DriverManager/getConnection url info))
  (^java.sql.Connection [^java.lang.String url]
    (DriverManager/getConnection url)))

(defn *get-log-stream
  "Deprecated. Use getLogWriter

  returns: the logging/tracing PrintStream; if disabled, is null - `java.io.PrintStream`"
  (^java.io.PrintStream []
    (DriverManager/getLogStream )))

(defn *get-drivers
  "Retrieves an Enumeration with all of the currently loaded JDBC drivers
   to which the current caller has access.

   Note: The classname of a driver can be found using
   d.getClass().getName()

  returns: the list of JDBC Drivers loaded by the caller's class loader - `java.util.Enumeration<java.sql.Driver>`"
  (^java.util.Enumeration []
    (DriverManager/getDrivers )))

(defn *deregister-driver
  "Removes the specified driver from the DriverManager's list of
   registered drivers.

   If a null value is specified for the driver to be removed, then no
   action is taken.

   If a security manager exists and its checkPermission denies
   permission, then a SecurityException will be thrown.

   If the specified driver is not found in the list of registered drivers,
   then no action is taken.  If the driver was found, it will be removed
   from the list of registered drivers.

   If a DriverAction instance was specified when the JDBC driver was
   registered, its deregister method will be called
   prior to the driver being removed from the list of registered drivers.

  driver - the JDBC Driver to remove - `java.sql.Driver`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.Driver driver]
    (DriverManager/deregisterDriver driver)))

(defn *get-driver
  "Attempts to locate a driver that understands the given URL.
   The DriverManager attempts to select an appropriate driver from
   the set of registered JDBC drivers.

  url - a database URL of the form jdbc:subprotocol:subname - `java.lang.String`

  returns: a Driver object representing a driver
   that can connect to the given URL - `java.sql.Driver`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.Driver [^java.lang.String url]
    (DriverManager/getDriver url)))

(defn *get-login-timeout
  "Gets the maximum time in seconds that a driver can wait
   when attempting to log in to a database.

  returns: the driver login time limit in seconds - `int`"
  (^Integer []
    (DriverManager/getLoginTimeout )))

