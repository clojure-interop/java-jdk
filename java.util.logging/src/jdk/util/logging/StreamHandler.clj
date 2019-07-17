(ns jdk.util.logging.StreamHandler
  "Stream based logging Handler.

  This is primarily intended as a base class or support class to
  be used in implementing other logging Handlers.

  LogRecords are published to a given java.io.OutputStream.

  Configuration:
  By default each StreamHandler is initialized using the following
  LogManager configuration properties where <handler-name>
  refers to the fully-qualified class name of the handler.
  If properties are not defined
  (or have invalid values) then the specified default values are used.

     <handler-name>.level
         specifies the default level for the Handler
         (defaults to Level.INFO).
     <handler-name>.filter
         specifies the name of a Filter class to use
          (defaults to no Filter).
     <handler-name>.formatter
         specifies the name of a Formatter class to use
         (defaults to java.util.logging.SimpleFormatter).
     <handler-name>.encoding
         the name of the character set encoding to use (defaults to
         the default platform encoding).


  For example, the properties for StreamHandler would be:

     java.util.logging.StreamHandler.level=INFO
     java.util.logging.StreamHandler.formatter=java.util.logging.SimpleFormatter


  For a custom handler, e.g. com.foo.MyHandler, the properties would be:

     com.foo.MyHandler.level=INFO
     com.foo.MyHandler.formatter=java.util.logging.SimpleFormatter"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.logging StreamHandler]))

(defn ->stream-handler
  "Constructor.

  Create a StreamHandler with a given Formatter
   and output stream.

  out - the target output stream - `java.io.OutputStream`
  formatter - Formatter to be used to format output - `java.util.logging.Formatter`"
  ([^java.io.OutputStream out ^java.util.logging.Formatter formatter]
    (new StreamHandler out formatter))
  ([]
    (new StreamHandler )))

(defn set-encoding
  "Set (or change) the character encoding used by this Handler.

   The encoding should be set before any LogRecords are written
   to the Handler.

  encoding - The name of a supported character encoding. May be null, to indicate the default platform encoding. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and if the caller does not have LoggingPermission(`control`)."
  ([^java.util.logging.StreamHandler this ^java.lang.String encoding]
    (-> this (.setEncoding encoding))))

(defn publish
  "Format and publish a LogRecord.

   The StreamHandler first checks if there is an OutputStream
   and if the given LogRecord has at least the required log level.
   If not it silently returns.  If so, it calls any associated
   Filter to check if the record should be published.  If so,
   it calls its Formatter to format the record and then writes
   the result to the current output stream.

   If this is the first LogRecord to be written to a given
   OutputStream, the Formatter's `head` string is
   written to the stream before the LogRecord is written.

  record - description of the log event. A null record is silently ignored and is not published - `java.util.logging.LogRecord`"
  ([^java.util.logging.StreamHandler this ^java.util.logging.LogRecord record]
    (-> this (.publish record))))

(defn loggable?
  "Check if this Handler would actually log a given LogRecord.

   This method checks if the LogRecord has an appropriate level and
   whether it satisfies any Filter.  It will also return false if
   no output stream has been assigned yet or the LogRecord is null.

  record - a LogRecord - `java.util.logging.LogRecord`

  returns: true if the LogRecord would be logged. - `boolean`"
  ([^java.util.logging.StreamHandler this ^java.util.logging.LogRecord record]
    (-> this (.isLoggable record))))

(defn flush
  "Flush any buffered messages."
  ([^java.util.logging.StreamHandler this]
    (-> this (.flush))))

(defn close
  "Close the current output stream.

   The Formatter's `tail` string is written to the stream before it
   is closed.  In addition, if the Formatter's `head` string has not
   yet been written to the stream, it will be written before the
   `tail` string.

  throws: java.lang.SecurityException - if a security manager exists and if the caller does not have LoggingPermission(`control`)."
  ([^java.util.logging.StreamHandler this]
    (-> this (.close))))

