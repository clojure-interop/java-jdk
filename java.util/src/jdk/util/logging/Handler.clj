(ns jdk.util.logging.Handler
  "A Handler object takes log messages from a Logger and
  exports them.  It might for example, write them to a console
  or write them to a file, or send them to a network logging service,
  or forward them to an OS log, or whatever.

  A Handler can be disabled by doing a setLevel(Level.OFF)
  and can  be re-enabled by doing a setLevel with an appropriate level.

  Handler classes typically use LogManager properties to set
  default values for the Handler's Filter, Formatter,
  and Level.  See the specific documentation for each concrete
  Handler class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.logging Handler]))

(defn get-encoding
  "Return the character encoding for this Handler.

  returns: The encoding name.  May be null, which indicates the
            default encoding should be used. - `java.lang.String`"
  ([this]
    (-> this (.getEncoding))))

(defn set-encoding
  "Set the character encoding used by this Handler.

   The encoding should be set before any LogRecords are written
   to the Handler.

  encoding - The name of a supported character encoding. May be null, to indicate the default platform encoding. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and if the caller does not have LoggingPermission(`control`)."
  ([this encoding]
    (-> this (.setEncoding encoding))))

(defn flush
  "Flush any buffered output."
  ([this]
    (-> this (.flush))))

(defn set-error-manager
  "Define an ErrorManager for this Handler.

   The ErrorManager's `error` method will be invoked if any
   errors occur while using this Handler.

  em - the new ErrorManager - `java.util.logging.ErrorManager`

  throws: java.lang.SecurityException - if a security manager exists and if the caller does not have LoggingPermission(`control`)."
  ([this em]
    (-> this (.setErrorManager em))))

(defn loggable?
  "Check if this Handler would actually log a given LogRecord.

   This method checks if the LogRecord has an appropriate
   Level and  whether it satisfies any Filter.  It also
   may make other Handler specific checks that might prevent a
   handler from logging the LogRecord. It will return false if
   the LogRecord is null.

  record - a LogRecord - `java.util.logging.LogRecord`

  returns: true if the LogRecord would be logged. - `boolean`"
  ([this record]
    (-> this (.isLoggable record))))

(defn get-formatter
  "Return the Formatter for this Handler.

  returns: the Formatter (may be null). - `java.util.logging.Formatter`"
  ([this]
    (-> this (.getFormatter))))

(defn get-filter
  "Get the current Filter for this Handler.

  returns: a Filter object (may be null) - `java.util.logging.Filter`"
  ([this]
    (-> this (.getFilter))))

(defn publish
  "Publish a LogRecord.

   The logging request was made initially to a Logger object,
   which initialized the LogRecord and forwarded it here.

   The Handler  is responsible for formatting the message, when and
   if necessary.  The formatting should include localization.

  record - description of the log event. A null record is silently ignored and is not published - `java.util.logging.LogRecord`"
  ([this record]
    (-> this (.publish record))))

(defn set-formatter
  "Set a Formatter.  This Formatter will be used
   to format LogRecords for this Handler.

   Some Handlers may not use Formatters, in
   which case the Formatter will be remembered, but not used.

  new-formatter - the Formatter to use (may not be null) - `java.util.logging.Formatter`

  throws: java.lang.SecurityException - if a security manager exists and if the caller does not have LoggingPermission(`control`)."
  ([this new-formatter]
    (-> this (.setFormatter new-formatter))))

(defn get-level
  "Get the log level specifying which messages will be
   logged by this Handler.  Message levels lower
   than this level will be discarded.

  returns: the level of messages being logged. - `java.util.logging.Level`"
  ([this]
    (-> this (.getLevel))))

(defn close
  "Close the Handler and free all associated resources.

   The close method will perform a flush and then close the
   Handler.   After close has been called this Handler
   should no longer be used.  Method calls may either be silently
   ignored or may throw runtime exceptions.

  throws: java.lang.SecurityException - if a security manager exists and if the caller does not have LoggingPermission(`control`)."
  ([this]
    (-> this (.close))))

(defn set-filter
  "Set a Filter to control output on this Handler.

   For each call of publish the Handler will call
   this Filter (if it is non-null) to check if the
   LogRecord should be published or discarded.

  new-filter - a Filter object (may be null) - `java.util.logging.Filter`

  throws: java.lang.SecurityException - if a security manager exists and if the caller does not have LoggingPermission(`control`)."
  ([this new-filter]
    (-> this (.setFilter new-filter))))

(defn set-level
  "Set the log level specifying which message levels will be
   logged by this Handler.  Message levels lower than this
   value will be discarded.

   The intention is to allow developers to turn on voluminous
   logging, but to limit the messages that are sent to certain
   Handlers.

  new-level - the new value for the log level - `java.util.logging.Level`

  throws: java.lang.SecurityException - if a security manager exists and if the caller does not have LoggingPermission(`control`)."
  ([this new-level]
    (-> this (.setLevel new-level))))

(defn get-error-manager
  "Retrieves the ErrorManager for this Handler.

  returns: the ErrorManager for this Handler - `java.util.logging.ErrorManager`

  throws: java.lang.SecurityException - if a security manager exists and if the caller does not have LoggingPermission(`control`)."
  ([this]
    (-> this (.getErrorManager))))

