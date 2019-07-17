(ns jdk.lang.management.PlatformLoggingMXBean
  "The management interface for the logging facility.

  There is a single global instance of the PlatformLoggingMXBean.
  The ManagementFactory.getPlatformMXBean method can be used to obtain
  the PlatformLoggingMXBean object as follows:


      PlatformLoggingMXBean logging = ManagementFactory.getPlatformMXBean(PlatformLoggingMXBean.class);
  The PlatformLoggingMXBean object is also registered with the
  platform MBeanServer.
  The ObjectName for uniquely
  identifying the PlatformLoggingMXBean within an MBeanServer is:


       java.util.logging:type=Logging

  The instance registered in the platform MBeanServer with
  this ObjectName implements all attributes defined by
  LoggingMXBean."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.management PlatformLoggingMXBean]))

(defn get-logger-names
  "Returns the list of the currently registered
   java.util.logging.logger names. This method
   calls LogManager.getLoggerNames() and
   returns a list of the logger names.

  returns: A list of String each of which is a
           currently registered Logger name. - `java.util.List<java.lang.String>`"
  (^java.util.List [^java.lang.management.PlatformLoggingMXBean this]
    (-> this (.getLoggerNames))))

(defn get-logger-level
  "Gets the name of the log level associated with the specified logger.
   If the specified logger does not exist, null
   is returned.
   This method first finds the logger of the given name and
   then returns the name of the log level by calling:

     Logger.getLevel().getName();



   If the Level of the specified logger is null,
   which means that this logger's effective level is inherited
   from its parent, an empty string will be returned.

  logger-name - The name of the Logger to be retrieved. - `java.lang.String`

  returns: The name of the log level of the specified logger; or
           an empty string if the log level of the specified logger
           is null.  If the specified logger does not
           exist, null is returned. - `java.lang.String`"
  (^java.lang.String [^java.lang.management.PlatformLoggingMXBean this ^java.lang.String logger-name]
    (-> this (.getLoggerLevel logger-name))))

(defn set-logger-level
  "Sets the specified logger to the specified new
   level.
   If the levelName is not null, the level
   of the specified logger is set to the parsed
   Level
   matching the levelName.
   If the levelName is null, the level
   of the specified logger is set to null and
   the effective level of the logger is inherited from
   its nearest ancestor with a specific (non-null) level value.

  logger-name - The name of the Logger to be set. Must be non-null. - `java.lang.String`
  level-name - The name of the level to set on the specified logger, or null if setting the level to inherit from its nearest ancestor. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the specified logger does not exist, or levelName is not a valid level name."
  ([^java.lang.management.PlatformLoggingMXBean this ^java.lang.String logger-name ^java.lang.String level-name]
    (-> this (.setLoggerLevel logger-name level-name))))

(defn get-parent-logger-name
  "Returns the name of the
   parent
   for the specified logger.
   If the specified logger does not exist, null is returned.
   If the specified logger is the root Logger in the namespace,
   the result will be an empty string.

  logger-name - The name of a Logger. - `java.lang.String`

  returns: the name of the nearest existing parent logger;
           an empty string if the specified logger is the root logger.
           If the specified logger does not exist, null
           is returned. - `java.lang.String`"
  (^java.lang.String [^java.lang.management.PlatformLoggingMXBean this ^java.lang.String logger-name]
    (-> this (.getParentLoggerName logger-name))))

