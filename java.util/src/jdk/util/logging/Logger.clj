(ns jdk.util.logging.Logger
  "A Logger object is used to log messages for a specific
  system or application component.  Loggers are normally named,
  using a hierarchical dot-separated namespace.  Logger names
  can be arbitrary strings, but they should normally be based on
  the package name or class name of the logged component, such
  as java.net or javax.swing.  In addition it is possible to create
  `anonymous` Loggers that are not stored in the Logger namespace.

  Logger objects may be obtained by calls on one of the getLogger
  factory methods.  These will either create a new Logger or
  return a suitable existing Logger. It is important to note that
  the Logger returned by one of the getLogger factory methods
  may be garbage collected at any time if a strong reference to the
  Logger is not kept.

  Logging messages will be forwarded to registered Handler
  objects, which can forward the messages to a variety of
  destinations, including consoles, files, OS logs, etc.

  Each Logger keeps track of a `parent` Logger, which is its
  nearest existing ancestor in the Logger namespace.

  Each Logger has a `Level` associated with it.  This reflects
  a minimum Level that this logger cares about.  If a Logger's
  level is set to null, then its effective level is inherited
  from its parent, which may in turn obtain it recursively from its
  parent, and so on up the tree.

  The log level can be configured based on the properties from the
  logging configuration file, as described in the description
  of the LogManager class.  However it may also be dynamically changed
  by calls on the Logger.setLevel method.  If a logger's level is
  changed the change may also affect child loggers, since any child
  logger that has null as its level will inherit its
  effective level from its parent.

  On each logging call the Logger initially performs a cheap
  check of the request level (e.g., SEVERE or FINE) against the
  effective log level of the logger.  If the request level is
  lower than the log level, the logging call returns immediately.

  After passing this initial (cheap) test, the Logger will allocate
  a LogRecord to describe the logging message.  It will then call a
  Filter (if present) to do a more detailed check on whether the
  record should be published.  If that passes it will then publish
  the LogRecord to its output Handlers.  By default, loggers also
  publish to their parent's Handlers, recursively up the tree.

  Each Logger may have a ResourceBundle associated with it.
  The ResourceBundle may be specified by name, using the
  getLogger(java.lang.String, java.lang.String) factory
  method, or by value - using the setResourceBundle method.
  This bundle will be used for localizing logging messages.
  If a Logger does not have its own ResourceBundle or resource bundle
  name, then it will inherit the ResourceBundle or resource bundle name
  from its parent, recursively up the tree.

  Most of the logger output methods take a `msg` argument.  This
  msg argument may be either a raw value or a localization key.
  During formatting, if the logger has (or inherits) a localization
  ResourceBundle and if the ResourceBundle has a mapping for
  the msg string, then the msg string is replaced by the localized value.
  Otherwise the original msg string is used.  Typically, formatters use
  java.text.MessageFormat style formatting to format parameters, so
  for example a format string `{0} {1}` would format two parameters
  as strings.

  A set of methods alternatively take a `msgSupplier` instead of a `msg`
  argument.  These methods take a Supplier<String> function
  which is invoked to construct the desired log message only when the message
  actually is to be logged based on the effective log level thus eliminating
  unnecessary message construction. For example, if the developer wants to
  log system health status for diagnosis, with the String-accepting version,
  the code would look like:


    class DiagnosisMessages {
      static String systemHealthStatus() {
        // collect system health information
        ...
      }
    }
    ...
    logger.log(Level.FINER, DiagnosisMessages.systemHealthStatus());
  With the above code, the health status is collected unnecessarily even when
  the log level FINER is disabled. With the Supplier-accepting version as
  below, the status will only be collected when the log level FINER is
  enabled.


    logger.log(Level.FINER, DiagnosisMessages::systemHealthStatus);

  When looking for a ResourceBundle, the logger will first look at
  whether a bundle was specified using setResourceBundle, and then
  only whether a resource bundle name was specified through the getLogger factory method.
  If no ResourceBundle or no resource bundle name is found,
  then it will use the nearest ResourceBundle or resource bundle
  name inherited from its parent tree.
  When a ResourceBundle was inherited or specified through the
  setResourceBundle method, then
  that ResourceBundle will be used. Otherwise if the logger only
  has or inherited a resource bundle name, then that resource bundle name
  will be mapped to a ResourceBundle object, using the default Locale
  at the time of logging.
  When mapping resource bundle names to
  ResourceBundle objects, the logger will first try to use the
  Thread's context class
  loader to map the given resource bundle name to a ResourceBundle.
  If the thread context class loader is null, it will try the
  system class loader
  instead.  If the ResourceBundle is still not found, it will use the
  class loader of the first caller of the getLogger factory method.

  Formatting (including localization) is the responsibility of
  the output Handler, which will typically call a Formatter.

  Note that formatting need not occur synchronously.  It may be delayed
  until a LogRecord is actually written to an external sink.

  The logging methods are grouped in five main categories:


      There are a set of `log` methods that take a log level, a message
      string, and optionally some parameters to the message string.

      There are a set of `logp` methods (for `log precise`) that are
      like the `log` methods, but also take an explicit source class name
      and method name.

      There are a set of `logrb` method (for `log with resource bundle`)
      that are like the `logp` method, but also take an explicit resource
      bundle object for use in localizing the log message.

      There are convenience methods for tracing method entries (the
      `entering` methods), method returns (the `exiting` methods) and
      throwing exceptions (the `throwing` methods).

      Finally, there are a set of convenience methods for use in the
      very simplest cases, when a developer simply wants to log a
      simple string at a given log level.  These methods are named
      after the standard Level names (`severe`, `warning`, `info`, etc.)
      and take a single argument, a message string.


  For the methods that do not take an explicit source name and
  method name, the Logging framework will make a `best effort`
  to determine which class and method called into the logging method.
  However, it is important to realize that this automatically inferred
  information may only be approximate (or may even be quite wrong!).
  Virtual machines are allowed to do extensive optimizations when
  JITing and may entirely remove stack frames, making it impossible
  to reliably locate the calling class and method.

  All methods on Logger are multi-thread safe.

  Subclassing Information: Note that a LogManager class may
  provide its own implementation of named Loggers for any point in
  the namespace.  Therefore, any subclasses of Logger (unless they
  are implemented in conjunction with a new LogManager class) should
  take care to obtain a Logger instance from the LogManager class and
  should delegate operations such as `isLoggable` and `log(LogRecord)`
  to that instance.  Note that in order to intercept all logging
  output, subclasses need only override the log(LogRecord) method.
  All the other logging methods are implemented as calls on this
  log(LogRecord) method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.logging Logger]))

(def *-global-logger-name
  "Static Constant.

  GLOBAL_LOGGER_NAME is a name for the global logger.

  type: java.lang.String"
  Logger/GLOBAL_LOGGER_NAME)

(def *-global
  "Static Constant.

  Deprecated. Initialization of this field is prone to deadlocks.
   The field must be initialized by the Logger class initialization
   which may cause deadlocks with the LogManager class initialization.
   In such cases two class initialization wait for each other to complete.
   The preferred way to get the global logger object is via the call
   Logger.getGlobal().
   For compatibility with old JDK versions where the
   Logger.getGlobal() is not available use the call
   Logger.getLogger(Logger.GLOBAL_LOGGER_NAME)
   or Logger.getLogger(`global`).

  type: java.lang.    java.util.logging.Logger"
  Logger/global)

(defn *get-global
  "Return global logger object with the name Logger.GLOBAL_LOGGER_NAME.

  returns: global logger object - `java.util.logging.Logger`"
  (^java.util.logging.Logger []
    (Logger/getGlobal )))

(defn *get-logger
  "Find or create a logger for a named subsystem.  If a logger has
   already been created with the given name it is returned.  Otherwise
   a new logger is created.

   If a new logger is created its log level will be configured
   based on the LogManager and it will configured to also send logging
   output to its parent's Handlers.  It will be registered in
   the LogManager global namespace.

   Note: The LogManager may only retain a weak reference to the newly
   created Logger. It is important to understand that a previously
   created Logger with the given name may be garbage collected at any
   time if there is no strong reference to the Logger. In particular,
   this means that two back-to-back calls like
   getLogger(`MyLogger`, ...).log(...) may use different Logger
   objects named `MyLogger` if there is no strong reference to the
   Logger named `MyLogger` elsewhere in the program.

   If the named Logger already exists and does not yet have a
   localization resource bundle then the given resource bundle
   name is used.  If the named Logger already exists and has
   a different resource bundle name then an IllegalArgumentException
   is thrown.

  name - A name for the logger. This should be a dot-separated name and should normally be based on the package name or class name of the subsystem, such as java.net or javax.swing - `java.lang.String`
  resource-bundle-name - name of ResourceBundle to be used for localizing messages for this logger. May be null if none of the messages require localization. - `java.lang.String`

  returns: a suitable Logger - `java.util.logging.Logger`

  throws: java.util.MissingResourceException - if the resourceBundleName is non-null and no corresponding resource can be found."
  (^java.util.logging.Logger [^java.lang.String name ^java.lang.String resource-bundle-name]
    (Logger/getLogger name resource-bundle-name))
  (^java.util.logging.Logger [^java.lang.String name]
    (Logger/getLogger name)))

(defn *get-anonymous-logger
  "Create an anonymous Logger.  The newly created Logger is not
   registered in the LogManager namespace.  There will be no
   access checks on updates to the logger.

   This factory method is primarily intended for use from applets.
   Because the resulting Logger is anonymous it can be kept private
   by the creating class.  This removes the need for normal security
   checks, which in turn allows untrusted applet code to update
   the control state of the Logger.  For example an applet can do
   a setLevel or an addHandler on an anonymous Logger.

   Even although the new logger is anonymous, it is configured
   to have the root logger (``) as its parent.  This means that
   by default it inherits its effective level and handlers
   from the root logger.  Changing its parent via the
   setParent method
   will still require the security permission specified by that method.

  resource-bundle-name - name of ResourceBundle to be used for localizing messages for this logger. May be null if none of the messages require localization. - `java.lang.String`

  returns: a newly created private Logger - `java.util.logging.Logger`

  throws: java.util.MissingResourceException - if the resourceBundleName is non-null and no corresponding resource can be found."
  (^java.util.logging.Logger [^java.lang.String resource-bundle-name]
    (Logger/getAnonymousLogger resource-bundle-name))
  (^java.util.logging.Logger []
    (Logger/getAnonymousLogger )))

(defn entering
  "Log a method entry, with one parameter.

   This is a convenience method that can be used to log entry
   to a method.  A LogRecord with message `ENTRY {0}`, log level
   FINER, and the given sourceMethod, sourceClass, and parameter
   is logged.

  source-class - name of class that issued the logging request - `java.lang.String`
  source-method - name of method that is being entered - `java.lang.String`
  param-1 - parameter to the method being entered - `java.lang.Object`"
  ([^java.util.logging.Logger this ^java.lang.String source-class ^java.lang.String source-method ^java.lang.Object param-1]
    (-> this (.entering source-class source-method param-1)))
  ([^java.util.logging.Logger this ^java.lang.String source-class ^java.lang.String source-method]
    (-> this (.entering source-class source-method))))

(defn severe
  "Log a SEVERE message.

   If the logger is currently enabled for the SEVERE message
   level then the given message is forwarded to all the
   registered output Handler objects.

  msg - The string message (or a key in the message catalog) - `java.lang.String`"
  ([^java.util.logging.Logger this ^java.lang.String msg]
    (-> this (.severe msg))))

(defn set-parent
  "Set the parent for this Logger.  This method is used by
   the LogManager to update a Logger when the namespace changes.

   It should not be called from application code.

  parent - the new parent logger - `java.util.logging.Logger`

  throws: java.lang.SecurityException - if a security manager exists and if the caller does not have LoggingPermission(`control`)."
  ([^java.util.logging.Logger this ^java.util.logging.Logger parent]
    (-> this (.setParent parent))))

(defn warning
  "Log a WARNING message.

   If the logger is currently enabled for the WARNING message
   level then the given message is forwarded to all the
   registered output Handler objects.

  msg - The string message (or a key in the message catalog) - `java.lang.String`"
  ([^java.util.logging.Logger this ^java.lang.String msg]
    (-> this (.warning msg))))

(defn config
  "Log a CONFIG message.

   If the logger is currently enabled for the CONFIG message
   level then the given message is forwarded to all the
   registered output Handler objects.

  msg - The string message (or a key in the message catalog) - `java.lang.String`"
  ([^java.util.logging.Logger this ^java.lang.String msg]
    (-> this (.config msg))))

(defn fine
  "Log a FINE message.

   If the logger is currently enabled for the FINE message
   level then the given message is forwarded to all the
   registered output Handler objects.

  msg - The string message (or a key in the message catalog) - `java.lang.String`"
  ([^java.util.logging.Logger this ^java.lang.String msg]
    (-> this (.fine msg))))

(defn get-use-parent-handlers?
  "Discover whether or not this logger is sending its output
   to its parent logger.

  returns: true if output is to be sent to the logger's parent - `boolean`"
  (^Boolean [^java.util.logging.Logger this]
    (-> this (.getUseParentHandlers))))

(defn get-handlers
  "Get the Handlers associated with this logger.

  returns: an array of all registered Handlers - `java.util.logging.Handler[]`"
  ([^java.util.logging.Logger this]
    (-> this (.getHandlers))))

(defn get-resource-bundle-name
  "Retrieve the localization resource bundle name for this
   logger.
   This is either the name specified through the getLogger factory method,
   or the base name of the
   ResourceBundle set through setResourceBundle method.
   Note that if the result is null, then the Logger will use a resource
   bundle or resource bundle name inherited from its parent.

  returns: localization bundle name (may be null) - `java.lang.String`"
  (^java.lang.String [^java.util.logging.Logger this]
    (-> this (.getResourceBundleName))))

(defn add-handler
  "Add a log Handler to receive logging messages.

   By default, Loggers also send their output to their parent logger.
   Typically the root Logger is configured with a set of Handlers
   that essentially act as default handlers for all loggers.

  handler - a logging Handler - `java.util.logging.Handler`

  throws: java.lang.SecurityException - if a security manager exists, this logger is not anonymous, and the caller does not have LoggingPermission(`control`)."
  ([^java.util.logging.Logger this ^java.util.logging.Handler handler]
    (-> this (.addHandler handler))))

(defn info
  "Log an INFO message.

   If the logger is currently enabled for the INFO message
   level then the given message is forwarded to all the
   registered output Handler objects.

  msg - The string message (or a key in the message catalog) - `java.lang.String`"
  ([^java.util.logging.Logger this ^java.lang.String msg]
    (-> this (.info msg))))

(defn get-resource-bundle
  "Retrieve the localization resource bundle for this
   logger.
   This method will return a ResourceBundle that was either
   set by the setResourceBundle method or
   mapped from the
   the resource bundle name set via the getLogger factory
   method for the current default locale.
   Note that if the result is null, then the Logger will use a resource
   bundle or resource bundle name inherited from its parent.

  returns: localization bundle (may be null) - `java.util.ResourceBundle`"
  (^java.util.ResourceBundle [^java.util.logging.Logger this]
    (-> this (.getResourceBundle))))

(defn set-resource-bundle
  "Sets a resource bundle on this logger.
   All messages will be logged using the given resource bundle for its
   specific locale.

  bundle - The resource bundle that this logger shall use. - `java.util.ResourceBundle`

  throws: java.lang.NullPointerException - if the given bundle is null."
  ([^java.util.logging.Logger this ^java.util.ResourceBundle bundle]
    (-> this (.setResourceBundle bundle))))

(defn set-use-parent-handlers
  "Specify whether or not this logger should send its output
   to its parent Logger.  This means that any LogRecords will
   also be written to the parent's Handlers, and potentially
   to its parent, recursively up the namespace.

  use-parent-handlers - true if output is to be sent to the logger's parent. - `boolean`

  throws: java.lang.SecurityException - if a security manager exists, this logger is not anonymous, and the caller does not have LoggingPermission(`control`)."
  ([^java.util.logging.Logger this ^Boolean use-parent-handlers]
    (-> this (.setUseParentHandlers use-parent-handlers))))

(defn log
  "Log a message, with one object parameter.

   If the logger is currently enabled for the given message
   level then a corresponding LogRecord is created and forwarded
   to all the registered output Handler objects.

  level - One of the message level identifiers, e.g., SEVERE - `java.util.logging.Level`
  msg - The string message (or a key in the message catalog) - `java.lang.String`
  param-1 - parameter to the message - `java.lang.Object`"
  ([^java.util.logging.Logger this ^java.util.logging.Level level ^java.lang.String msg ^java.lang.Object param-1]
    (-> this (.log level msg param-1)))
  ([^java.util.logging.Logger this ^java.util.logging.Level level ^java.lang.String msg]
    (-> this (.log level msg)))
  ([^java.util.logging.Logger this ^java.util.logging.LogRecord record]
    (-> this (.log record))))

(defn get-name
  "Get the name for this logger.

  returns: logger name.  Will be null for anonymous Loggers. - `java.lang.String`"
  (^java.lang.String [^java.util.logging.Logger this]
    (-> this (.getName))))

(defn logp
  "Log a message, specifying source class and method,
   with a single object parameter to the log message.

   If the logger is currently enabled for the given message
   level then a corresponding LogRecord is created and forwarded
   to all the registered output Handler objects.

  level - One of the message level identifiers, e.g., SEVERE - `java.util.logging.Level`
  source-class - name of class that issued the logging request - `java.lang.String`
  source-method - name of method that issued the logging request - `java.lang.String`
  msg - The string message (or a key in the message catalog) - `java.lang.String`
  param-1 - Parameter to the log message. - `java.lang.Object`"
  ([^java.util.logging.Logger this ^java.util.logging.Level level ^java.lang.String source-class ^java.lang.String source-method ^java.lang.String msg ^java.lang.Object param-1]
    (-> this (.logp level source-class source-method msg param-1)))
  ([^java.util.logging.Logger this ^java.util.logging.Level level ^java.lang.String source-class ^java.lang.String source-method ^java.lang.String msg]
    (-> this (.logp level source-class source-method msg))))

(defn loggable?
  "Check if a message of the given level would actually be logged
   by this logger.  This check is based on the Loggers effective level,
   which may be inherited from its parent.

  level - a message logging level - `java.util.logging.Level`

  returns: true if the given message level is currently being logged. - `boolean`"
  (^Boolean [^java.util.logging.Logger this ^java.util.logging.Level level]
    (-> this (.isLoggable level))))

(defn throwing
  "Log throwing an exception.

   This is a convenience method to log that a method is
   terminating by throwing an exception.  The logging is done
   using the FINER level.

   If the logger is currently enabled for the given message
   level then the given arguments are stored in a LogRecord
   which is forwarded to all registered output handlers.  The
   LogRecord's message is set to `THROW`.

   Note that the thrown argument is stored in the LogRecord thrown
   property, rather than the LogRecord parameters property.  Thus it is
   processed specially by output Formatters and is not treated
   as a formatting parameter to the LogRecord message property.

  source-class - name of class that issued the logging request - `java.lang.String`
  source-method - name of the method. - `java.lang.String`
  thrown - The Throwable that is being thrown. - `java.lang.Throwable`"
  ([^java.util.logging.Logger this ^java.lang.String source-class ^java.lang.String source-method ^java.lang.Throwable thrown]
    (-> this (.throwing source-class source-method thrown))))

(defn get-parent
  "Return the parent for this Logger.

   This method returns the nearest extant parent in the namespace.
   Thus if a Logger is called `a.b.c.d`, and a Logger called `a.b`
   has been created but no logger `a.b.c` exists, then a call of
   getParent on the Logger `a.b.c.d` will return the Logger `a.b`.

   The result will be null if it is called on the root Logger
   in the namespace.

  returns: nearest existing parent Logger - `java.util.logging.Logger`"
  (^java.util.logging.Logger [^java.util.logging.Logger this]
    (-> this (.getParent))))

(defn remove-handler
  "Remove a log Handler.

   Returns silently if the given Handler is not found or is null

  handler - a logging Handler - `java.util.logging.Handler`

  throws: java.lang.SecurityException - if a security manager exists, this logger is not anonymous, and the caller does not have LoggingPermission(`control`)."
  ([^java.util.logging.Logger this ^java.util.logging.Handler handler]
    (-> this (.removeHandler handler))))

(defn get-filter
  "Get the current filter for this Logger.

  returns: a filter object (may be null) - `java.util.logging.Filter`"
  (^java.util.logging.Filter [^java.util.logging.Logger this]
    (-> this (.getFilter))))

(defn get-level
  "Get the log Level that has been specified for this Logger.
   The result may be null, which means that this logger's
   effective level will be inherited from its parent.

  returns: this Logger's level - `java.util.logging.Level`"
  (^java.util.logging.Level [^java.util.logging.Logger this]
    (-> this (.getLevel))))

(defn logrb
  "Log a message, specifying source class, method, and resource bundle,
   with an optional list of message parameters.

   If the logger is currently enabled for the given message
   level then a corresponding LogRecord is created and forwarded
   to all the registered output Handler objects.

   The msg string is localized using the given resource bundle.
   If the resource bundle is null, then the msg string is not
   localized.

  level - One of the message level identifiers, e.g., SEVERE - `java.util.logging.Level`
  source-class - Name of the class that issued the logging request - `java.lang.String`
  source-method - Name of the method that issued the logging request - `java.lang.String`
  bundle - Resource bundle to localize msg, can be null. - `java.util.ResourceBundle`
  msg - The string message (or a key in the message catalog) - `java.lang.String`
  params - Parameters to the message (optional, may be none). - `java.lang.Object`"
  ([^java.util.logging.Logger this ^java.util.logging.Level level ^java.lang.String source-class ^java.lang.String source-method ^java.util.ResourceBundle bundle ^java.lang.String msg ^java.lang.Object params]
    (-> this (.logrb level source-class source-method bundle msg params)))
  ([^java.util.logging.Logger this ^java.util.logging.Level level ^java.lang.String source-class ^java.lang.String source-method ^java.lang.String bundle-name ^java.lang.String msg]
    (-> this (.logrb level source-class source-method bundle-name msg))))

(defn finer
  "Log a FINER message.

   If the logger is currently enabled for the FINER message
   level then the given message is forwarded to all the
   registered output Handler objects.

  msg - The string message (or a key in the message catalog) - `java.lang.String`"
  ([^java.util.logging.Logger this ^java.lang.String msg]
    (-> this (.finer msg))))

(defn finest
  "Log a FINEST message.

   If the logger is currently enabled for the FINEST message
   level then the given message is forwarded to all the
   registered output Handler objects.

  msg - The string message (or a key in the message catalog) - `java.lang.String`"
  ([^java.util.logging.Logger this ^java.lang.String msg]
    (-> this (.finest msg))))

(defn exiting
  "Log a method return, with result object.

   This is a convenience method that can be used to log returning
   from a method.  A LogRecord with message `RETURN {0}`, log level
   FINER, and the gives sourceMethod, sourceClass, and result
   object is logged.

  source-class - name of class that issued the logging request - `java.lang.String`
  source-method - name of the method - `java.lang.String`
  result - Object that is being returned - `java.lang.Object`"
  ([^java.util.logging.Logger this ^java.lang.String source-class ^java.lang.String source-method ^java.lang.Object result]
    (-> this (.exiting source-class source-method result)))
  ([^java.util.logging.Logger this ^java.lang.String source-class ^java.lang.String source-method]
    (-> this (.exiting source-class source-method))))

(defn set-filter
  "Set a filter to control output on this Logger.

   After passing the initial `level` check, the Logger will
   call this Filter to check if a log record should really
   be published.

  new-filter - a filter object (may be null) - `java.util.logging.Filter`

  throws: java.lang.SecurityException - if a security manager exists, this logger is not anonymous, and the caller does not have LoggingPermission(`control`)."
  ([^java.util.logging.Logger this ^java.util.logging.Filter new-filter]
    (-> this (.setFilter new-filter))))

(defn set-level
  "Set the log level specifying which message levels will be
   logged by this logger.  Message levels lower than this
   value will be discarded.  The level value Level.OFF
   can be used to turn off logging.

   If the new level is null, it means that this node should
   inherit its level from its nearest ancestor with a specific
   (non-null) level value.

  new-level - the new value for the log level (may be null) - `java.util.logging.Level`

  throws: java.lang.SecurityException - if a security manager exists, this logger is not anonymous, and the caller does not have LoggingPermission(`control`)."
  ([^java.util.logging.Logger this ^java.util.logging.Level new-level]
    (-> this (.setLevel new-level))))

