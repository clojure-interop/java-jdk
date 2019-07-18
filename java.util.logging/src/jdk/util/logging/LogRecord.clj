(ns jdk.util.logging.LogRecord
  "LogRecord objects are used to pass logging requests between
  the logging framework and individual log Handlers.

  When a LogRecord is passed into the logging framework it
  logically belongs to the framework and should no longer be
  used or updated by the client application.

  Note that if the client application has not specified an
  explicit source method name and source class name, then the
  LogRecord class will infer them automatically when they are
  first accessed (due to a call on getSourceMethodName or
  getSourceClassName) by analyzing the call stack.  Therefore,
  if a logging Handler wants to pass off a LogRecord to another
  thread, or to transmit it over RMI, and if it wishes to subsequently
  obtain method name or class name information it should call
  one of getSourceClassName or getSourceMethodName to force
  the values to be filled in.

   Serialization notes:

  The LogRecord class is serializable.

   Because objects in the parameters array may not be serializable,
  during serialization all objects in the parameters array are
  written as the corresponding Strings (using Object.toString).

   The ResourceBundle is not transmitted as part of the serialized
  form, but the resource bundle name is, and the recipient object's
  readObject method will attempt to locate a suitable resource bundle."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.logging LogRecord]))

(defn ->log-record
  "Constructor.

  Construct a LogRecord with the given level and message values.

   The sequence property will be initialized with a new unique value.
   These sequence values are allocated in increasing order within a VM.

   The millis property will be initialized to the current time.

   The thread ID property will be initialized with a unique ID for
   the current thread.

   All other properties will be initialized to `null`.

  level - a logging level value - `java.util.logging.Level`
  msg - the raw non-localized logging message (may be null) - `java.lang.String`"
  (^LogRecord [^java.util.logging.Level level ^java.lang.String msg]
    (new LogRecord level msg)))

(defn get-source-class-name
  "Get the  name of the class that (allegedly) issued the logging request.

   Note that this sourceClassName is not verified and may be spoofed.
   This information may either have been provided as part of the
   logging call, or it may have been inferred automatically by the
   logging framework.  In the latter case, the information may only
   be approximate and may in fact describe an earlier call on the
   stack frame.

   May be null if no information could be obtained.

  returns: the source class name - `java.lang.String`"
  (^java.lang.String [^LogRecord this]
    (-> this (.getSourceClassName))))

(defn set-parameters
  "Set the parameters to the log message.

  parameters - the log message parameters. (may be null) - `java.lang.Object[]`"
  ([^LogRecord this parameters]
    (-> this (.setParameters parameters))))

(defn set-thrown
  "Set a throwable associated with the log event.

  thrown - a throwable (may be null) - `java.lang.Throwable`"
  ([^LogRecord this ^java.lang.Throwable thrown]
    (-> this (.setThrown thrown))))

(defn set-source-class-name
  "Set the name of the class that (allegedly) issued the logging request.

  source-class-name - the source class name (may be null) - `java.lang.String`"
  ([^LogRecord this ^java.lang.String source-class-name]
    (-> this (.setSourceClassName source-class-name))))

(defn get-resource-bundle-name
  "Get the localization resource bundle name

   This is the name for the ResourceBundle that should be
   used to localize the message string before formatting it.
   The result may be null if the message is not localizable.

  returns: the localization resource bundle name - `java.lang.String`"
  (^java.lang.String [^LogRecord this]
    (-> this (.getResourceBundleName))))

(defn set-sequence-number
  "Set the sequence number.

   Sequence numbers are normally assigned in the LogRecord constructor,
   so it should not normally be necessary to use this method.

  seq - the sequence number - `long`"
  ([^LogRecord this ^Long seq]
    (-> this (.setSequenceNumber seq))))

(defn get-parameters
  "Get the parameters to the log message.

  returns: the log message parameters.  May be null if
                    there are no parameters. - `java.lang.Object[]`"
  ([^LogRecord this]
    (-> this (.getParameters))))

(defn get-resource-bundle
  "Get the localization resource bundle

   This is the ResourceBundle that should be used to localize
   the message string before formatting it.  The result may
   be null if the message is not localizable, or if no suitable
   ResourceBundle is available.

  returns: the localization resource bundle - `java.util.ResourceBundle`"
  (^java.util.ResourceBundle [^LogRecord this]
    (-> this (.getResourceBundle))))

(defn set-source-method-name
  "Set the name of the method that (allegedly) issued the logging request.

  source-method-name - the source method name (may be null) - `java.lang.String`"
  ([^LogRecord this ^java.lang.String source-method-name]
    (-> this (.setSourceMethodName source-method-name))))

(defn get-millis
  "Get event time in milliseconds since 1970.

  returns: event time in millis since 1970 - `long`"
  (^Long [^LogRecord this]
    (-> this (.getMillis))))

(defn set-resource-bundle
  "Set the localization resource bundle.

  bundle - localization bundle (may be null) - `java.util.ResourceBundle`"
  ([^LogRecord this ^java.util.ResourceBundle bundle]
    (-> this (.setResourceBundle bundle))))

(defn set-resource-bundle-name
  "Set the localization resource bundle name.

  name - localization bundle name (may be null) - `java.lang.String`"
  ([^LogRecord this ^java.lang.String name]
    (-> this (.setResourceBundleName name))))

(defn get-thrown
  "Get any throwable associated with the log record.

   If the event involved an exception, this will be the
   exception object. Otherwise null.

  returns: a throwable - `java.lang.Throwable`"
  (^java.lang.Throwable [^LogRecord this]
    (-> this (.getThrown))))

(defn get-source-method-name
  "Get the  name of the method that (allegedly) issued the logging request.

   Note that this sourceMethodName is not verified and may be spoofed.
   This information may either have been provided as part of the
   logging call, or it may have been inferred automatically by the
   logging framework.  In the latter case, the information may only
   be approximate and may in fact describe an earlier call on the
   stack frame.

   May be null if no information could be obtained.

  returns: the source method name - `java.lang.String`"
  (^java.lang.String [^LogRecord this]
    (-> this (.getSourceMethodName))))

(defn get-level
  "Get the logging message level, for example Level.SEVERE.

  returns: the logging message level - `java.util.logging.Level`"
  (^java.util.logging.Level [^LogRecord this]
    (-> this (.getLevel))))

(defn get-thread-id
  "Get an identifier for the thread where the message originated.

   This is a thread identifier within the Java VM and may or
   may not map to any operating system ID.

  returns: thread ID - `int`"
  (^Integer [^LogRecord this]
    (-> this (.getThreadID))))

(defn get-logger-name
  "Get the source Logger's name.

  returns: source logger name (may be null) - `java.lang.String`"
  (^java.lang.String [^LogRecord this]
    (-> this (.getLoggerName))))

(defn set-level
  "Set the logging message level, for example Level.SEVERE.

  level - the logging message level - `java.util.logging.Level`"
  ([^LogRecord this ^java.util.logging.Level level]
    (-> this (.setLevel level))))

(defn set-logger-name
  "Set the source Logger's name.

  name - the source logger name (may be null) - `java.lang.String`"
  ([^LogRecord this ^java.lang.String name]
    (-> this (.setLoggerName name))))

(defn set-thread-id
  "Set an identifier for the thread where the message originated.

  thread-id - the thread ID - `int`"
  ([^LogRecord this ^Integer thread-id]
    (-> this (.setThreadID thread-id))))

(defn get-message
  "Get the `raw` log message, before localization or formatting.

   May be null, which is equivalent to the empty string ``.

   This message may be either the final text or a localization key.

   During formatting, if the source logger has a localization
   ResourceBundle and if that ResourceBundle has an entry for
   this message string, then the message string is replaced
   with the localized value.

  returns: the raw message string - `java.lang.String`"
  (^java.lang.String [^LogRecord this]
    (-> this (.getMessage))))

(defn set-millis
  "Set event time.

  millis - event time in millis since 1970 - `long`"
  ([^LogRecord this ^Long millis]
    (-> this (.setMillis millis))))

(defn set-message
  "Set the `raw` log message, before localization or formatting.

  message - the raw message string (may be null) - `java.lang.String`"
  ([^LogRecord this ^java.lang.String message]
    (-> this (.setMessage message))))

(defn get-sequence-number
  "Get the sequence number.

   Sequence numbers are normally assigned in the LogRecord
   constructor, which assigns unique sequence numbers to
   each new LogRecord in increasing order.

  returns: the sequence number - `long`"
  (^Long [^LogRecord this]
    (-> this (.getSequenceNumber))))

