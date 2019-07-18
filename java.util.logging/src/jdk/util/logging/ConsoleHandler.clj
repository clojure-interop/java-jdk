(ns jdk.util.logging.ConsoleHandler
  "This Handler publishes log records to System.err.
  By default the SimpleFormatter is used to generate brief summaries.

  Configuration:
  By default each ConsoleHandler is initialized using the following
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


  For example, the properties for ConsoleHandler would be:

     java.util.logging.ConsoleHandler.level=INFO
     java.util.logging.ConsoleHandler.formatter=java.util.logging.SimpleFormatter


  For a custom handler, e.g. com.foo.MyHandler, the properties would be:

     com.foo.MyHandler.level=INFO
     com.foo.MyHandler.formatter=java.util.logging.SimpleFormatter"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.logging ConsoleHandler]))

(defn ->console-handler
  "Constructor.

  Create a ConsoleHandler for System.err.

   The ConsoleHandler is configured based on
   LogManager properties (or their default values)."
  (^ConsoleHandler []
    (new ConsoleHandler )))

(defn publish
  "Publish a LogRecord.

   The logging request was made initially to a Logger object,
   which initialized the LogRecord and forwarded it here.

  record - description of the log event. A null record is silently ignored and is not published - `java.util.logging.LogRecord`"
  ([^ConsoleHandler this ^java.util.logging.LogRecord record]
    (-> this (.publish record))))

(defn close
  "Override StreamHandler.close to do a flush but not
   to close the output stream.  That is, we do not
   close System.err."
  ([^ConsoleHandler this]
    (-> this (.close))))

