(ns jdk.util.logging.MemoryHandler
  "Handler that buffers requests in a circular buffer in memory.

  Normally this Handler simply stores incoming LogRecords
  into its memory buffer and discards earlier records.  This buffering
  is very cheap and avoids formatting costs.  On certain trigger
  conditions, the MemoryHandler will push out its current buffer
  contents to a target Handler, which will typically publish
  them to the outside world.

  There are three main models for triggering a push of the buffer:


  An incoming LogRecord has a type that is greater than
  a pre-defined level, the pushLevel.

  An external class calls the push method explicitly.

  A subclass overrides the log method and scans each incoming
  LogRecord and calls push if a record matches some
  desired criteria.


  Configuration:
  By default each MemoryHandler is initialized using the following
  LogManager configuration properties where <handler-name>
  refers to the fully-qualified class name of the handler.
  If properties are not defined
  (or have invalid values) then the specified default values are used.
  If no default value is defined then a RuntimeException is thrown.

     <handler-name>.level
         specifies the level for the Handler
         (defaults to Level.ALL).
     <handler-name>.filter
         specifies the name of a Filter class to use
         (defaults to no Filter).
     <handler-name>.size
         defines the buffer size (defaults to 1000).
     <handler-name>.push
         defines the pushLevel (defaults to level.SEVERE).
     <handler-name>.target
         specifies the name of the target Handler  class.
         (no default).


  For example, the properties for MemoryHandler would be:

     java.util.logging.MemoryHandler.level=INFO
     java.util.logging.MemoryHandler.formatter=java.util.logging.SimpleFormatter


  For a custom handler, e.g. com.foo.MyHandler, the properties would be:

     com.foo.MyHandler.level=INFO
     com.foo.MyHandler.formatter=java.util.logging.SimpleFormatter"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.logging MemoryHandler]))

(defn ->memory-handler
  "Constructor.

  Create a MemoryHandler.

   The MemoryHandler is configured based on LogManager
   properties (or their default values) except that the given pushLevel
   argument and buffer size argument are used.

  target - the Handler to which to publish output. - `java.util.logging.Handler`
  size - the number of log records to buffer (must be greater than zero) - `int`
  push-level - message level to push on - `java.util.logging.Level`

  throws: java.lang.IllegalArgumentException - if size is <= 0"
  (^MemoryHandler [^java.util.logging.Handler target ^Integer size ^java.util.logging.Level push-level]
    (new MemoryHandler target size push-level))
  (^MemoryHandler []
    (new MemoryHandler )))

(defn publish
  "Store a LogRecord in an internal buffer.

   If there is a Filter, its isLoggable
   method is called to check if the given log record is loggable.
   If not we return.  Otherwise the given record is copied into
   an internal circular buffer.  Then the record's level property is
   compared with the pushLevel. If the given level is
   greater than or equal to the pushLevel then push
   is called to write all buffered records to the target output
   Handler.

  record - description of the log event. A null record is silently ignored and is not published - `java.util.logging.LogRecord`"
  ([^MemoryHandler this ^java.util.logging.LogRecord record]
    (-> this (.publish record))))

(defn push
  "Push any buffered output to the target Handler.

   The buffer is then cleared."
  ([^MemoryHandler this]
    (-> this (.push))))

(defn flush
  "Causes a flush on the target Handler.

   Note that the current contents of the MemoryHandler
   buffer are not written out.  That requires a \"push\"."
  ([^MemoryHandler this]
    (-> this (.flush))))

(defn close
  "Close the Handler and free all associated resources.
   This will also close the target Handler.

  throws: java.lang.SecurityException - if a security manager exists and if the caller does not have LoggingPermission(\"control\")."
  ([^MemoryHandler this]
    (-> this (.close))))

(defn set-push-level
  "Set the pushLevel.  After a LogRecord is copied
   into our internal buffer, if its level is greater than or equal to
   the pushLevel, then push will be called.

  new-level - the new value of the pushLevel - `java.util.logging.Level`

  throws: java.lang.SecurityException - if a security manager exists and if the caller does not have LoggingPermission(\"control\")."
  ([^MemoryHandler this ^java.util.logging.Level new-level]
    (-> this (.setPushLevel new-level))))

(defn get-push-level
  "Get the pushLevel.

  returns: the value of the pushLevel - `java.util.logging.Level`"
  (^java.util.logging.Level [^MemoryHandler this]
    (-> this (.getPushLevel))))

(defn loggable?
  "Check if this Handler would actually log a given
   LogRecord into its internal buffer.

   This method checks if the LogRecord has an appropriate level and
   whether it satisfies any Filter.  However it does not
   check whether the LogRecord would result in a \"push\" of the
   buffer contents. It will return false if the LogRecord is null.

  record - a LogRecord - `java.util.logging.LogRecord`

  returns: true if the LogRecord would be logged. - `boolean`"
  (^Boolean [^MemoryHandler this ^java.util.logging.LogRecord record]
    (-> this (.isLoggable record))))

