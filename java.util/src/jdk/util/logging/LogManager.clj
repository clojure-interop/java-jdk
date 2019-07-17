(ns jdk.util.logging.LogManager
  "There is a single global LogManager object that is used to
  maintain a set of shared state about Loggers and log services.

  This LogManager object:

   Manages a hierarchical namespace of Logger objects.  All
       named Loggers are stored in this namespace.
   Manages a set of logging control properties.  These are
       simple key-value pairs that can be used by Handlers and
       other logging objects to configure themselves.


  The global LogManager object can be retrieved using LogManager.getLogManager().
  The LogManager object is created during class initialization and
  cannot subsequently be changed.

  At startup the LogManager class is located using the
  java.util.logging.manager system property.

  The LogManager defines two optional system properties that allow control over
  the initial configuration:

  `java.util.logging.config.class`
  `java.util.logging.config.file`

  These two properties may be specified on the command line to the `java`
  command, or as system property definitions passed to JNI_CreateJavaVM.

  If the `java.util.logging.config.class` property is set, then the
  property value is treated as a class name.  The given class will be
  loaded, an object will be instantiated, and that object's constructor
  is responsible for reading in the initial configuration.  (That object
  may use other system properties to control its configuration.)  The
  alternate configuration class can use readConfiguration(InputStream)
  to define properties in the LogManager.

  If `java.util.logging.config.class` property is not set,
  then the `java.util.logging.config.file` system property can be used
  to specify a properties file (in java.util.Properties format). The
  initial logging configuration will be read from this file.

  If neither of these properties is defined then the LogManager uses its
  default configuration. The default configuration is typically loaded from the
  properties file `lib/logging.properties` in the Java installation
  directory.

  The properties for loggers and Handlers will have names starting
  with the dot-separated name for the handler or logger.

  The global logging properties may include:

  A property `handlers`.  This defines a whitespace or comma separated
  list of class names for handler classes to load and register as
  handlers on the root Logger (the Logger named ``).  Each class
  name must be for a Handler class which has a default constructor.
  Note that these Handlers may be created lazily, when they are
  first used.

  A property `<logger>.handlers`. This defines a whitespace or
  comma separated list of class names for handlers classes to
  load and register as handlers to the specified logger. Each class
  name must be for a Handler class which has a default constructor.
  Note that these Handlers may be created lazily, when they are
  first used.

  A property `<logger>.useParentHandlers`. This defines a boolean
  value. By default every logger calls its parent in addition to
  handling the logging message itself, this often result in messages
  being handled by the root logger as well. When setting this property
  to false a Handler needs to be configured for this logger otherwise
  no logging messages are delivered.

  A property `config`.  This property is intended to allow
  arbitrary configuration code to be run.  The property defines a
  whitespace or comma separated list of class names.  A new instance will be
  created for each named class.  The default constructor of each class
  may execute arbitrary code to update the logging configuration, such as
  setting logger levels, adding handlers, adding filters, etc.


  Note that all classes loaded during LogManager configuration are
  first searched on the system class path before any user class path.
  That includes the LogManager class, any config classes, and any
  handler classes.

  Loggers are organized into a naming hierarchy based on their
  dot separated names.  Thus `a.b.c` is a child of `a.b`, but
  `a.b1` and a.b2` are peers.

  All properties whose names end with `.level` are assumed to define
  log levels for Loggers.  Thus `foo.level` defines a log level for
  the logger called `foo` and (recursively) for any of its children
  in the naming hierarchy.  Log Levels are applied in the order they
  are defined in the properties file.  Thus level settings for child
  nodes in the tree should come after settings for their parents.
  The property name `.level` can be used to set the level for the
  root of the tree.

  All methods on the LogManager object are multi-thread safe."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.logging LogManager]))

(def *-logging-mxbean-name
  "Static Constant.

  String representation of the
   ObjectName for the management interface
   for the logging facility.

  type: java.lang.String"
  LogManager/LOGGING_MXBEAN_NAME)

(defn *get-log-manager
  "Returns the global LogManager object.

  returns: the global LogManager object - `java.util.logging.LogManager`"
  ([]
    (LogManager/getLogManager )))

(defn *get-logging-mx-bean
  "Returns LoggingMXBean for managing loggers.
   An alternative way to manage loggers is through the
   PlatformLoggingMXBean interface
   that can be obtained by calling:


       PlatformLoggingMXBean logging = ManagementFactory.getPlatformMXBean(PlatformLoggingMXBean.class);

  returns: a LoggingMXBean object. - `java.util.logging.LoggingMXBean`"
  ([]
    (LogManager/getLoggingMXBean )))

(defn reset
  "Reset the logging configuration.

   For all named loggers, the reset operation removes and closes
   all Handlers and (except for the root logger) sets the level
   to null.  The root logger's level is set to Level.INFO.

  throws: java.lang.SecurityException - if a security manager exists and if the caller does not have LoggingPermission(`control`)."
  ([this]
    (-> this (.reset))))

(defn check-access
  "Check that the current context is trusted to modify the logging
   configuration.  This requires LoggingPermission(`control`).

   If the check fails we throw a SecurityException, otherwise
   we return normally.

  throws: java.lang.SecurityException - if a security manager exists and if the caller does not have LoggingPermission(`control`)."
  ([this]
    (-> this (.checkAccess))))

(defn remove-property-change-listener
  "Deprecated. The dependency on PropertyChangeListener creates a
               significant impediment to future modularization of the Java
               platform. This method will be removed in a future release.
               The global LogManager can detect changes to the
               logging configuration by overridding the readConfiguration method.

  l - event listener (can be null) - `java.beans.PropertyChangeListener`

  returns: `java.lang.  void`

  throws: java.lang.SecurityException - if a security manager exists and if the caller does not have LoggingPermission(`control`)."
  ([this l]
    (-> this (.removePropertyChangeListener l))))

(defn get-logger-names
  "Get an enumeration of known logger names.

   Note:  Loggers may be added dynamically as new classes are loaded.
   This method only reports on the loggers that are currently registered.
   It is also important to note that this method only returns the name
   of a Logger, not a strong reference to the Logger itself.
   The returned String does nothing to prevent the Logger from being
   garbage collected. In particular, if the returned name is passed
   to LogManager.getLogger(), then the caller must check the
   return value from LogManager.getLogger() for null to properly
   handle the case where the Logger has been garbage collected in the
   time since its name was returned by this method.

  returns: enumeration of logger name strings - `java.util.Enumeration<java.lang.String>`"
  ([this]
    (-> this (.getLoggerNames))))

(defn get-property
  "Get the value of a logging property.
   The method returns null if the property is not found.

  name - property name - `java.lang.String`

  returns: property value - `java.lang.String`"
  ([this name]
    (-> this (.getProperty name))))

(defn add-logger
  "Add a named logger.  This does nothing and returns false if a logger
   with the same name is already registered.

   The Logger factory methods call this method to register each
   newly created Logger.

   The application should retain its own reference to the Logger
   object to avoid it being garbage collected.  The LogManager
   may only retain a weak reference.

  logger - the new logger. - `java.util.logging.Logger`

  returns: true if the argument logger was registered successfully,
            false if a logger of that name already exists. - `boolean`

  throws: java.lang.NullPointerException - if the logger name is null."
  ([this logger]
    (-> this (.addLogger logger))))

(defn read-configuration
  "Reinitialize the logging properties and reread the logging configuration
   from the given stream, which should be in java.util.Properties format.
   A PropertyChangeEvent will be fired after the properties are read.

   Any log level definitions in the new configuration file will be
   applied using Logger.setLevel(), if the target Logger exists.

  ins - stream to read properties from - `java.io.InputStream`

  throws: java.lang.SecurityException - if a security manager exists and if the caller does not have LoggingPermission(`control`)."
  ([this ins]
    (-> this (.readConfiguration ins)))
  ([this]
    (-> this (.readConfiguration))))

(defn add-property-change-listener
  "Deprecated. The dependency on PropertyChangeListener creates a
               significant impediment to future modularization of the Java
               platform. This method will be removed in a future release.
               The global LogManager can detect changes to the
               logging configuration by overridding the readConfiguration method.

  l - event listener - `java.beans.PropertyChangeListener`

  returns: `java.lang.  void`

  throws: java.lang.SecurityException - if a security manager exists and if the caller does not have LoggingPermission(`control`)."
  ([this l]
    (-> this (.addPropertyChangeListener l))))

(defn get-logger
  "Method to find a named logger.

   Note that since untrusted code may create loggers with
   arbitrary names this method should not be relied on to
   find Loggers for security sensitive logging.
   It is also important to note that the Logger associated with the
   String name may be garbage collected at any time if there
   is no strong reference to the Logger. The caller of this method
   must check the return value for null in order to properly handle
   the case where the Logger has been garbage collected.

  name - name of the logger - `java.lang.String`

  returns: matching logger or null if none is found - `java.util.logging.Logger`"
  ([this name]
    (-> this (.getLogger name))))

