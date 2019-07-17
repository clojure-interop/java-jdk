(ns jdk.util.logging.SocketHandler
  "Simple network logging Handler.

  LogRecords are published to a network stream connection.  By default
  the XMLFormatter class is used for formatting.

  Configuration:
  By default each SocketHandler is initialized using the following
  LogManager configuration properties where <handler-name>
  refers to the fully-qualified class name of the handler.
  If properties are not defined
  (or have invalid values) then the specified default values are used.

     <handler-name>.level
         specifies the default level for the Handler
         (defaults to Level.ALL).
     <handler-name>.filter
         specifies the name of a Filter class to use
         (defaults to no Filter).
     <handler-name>.formatter
         specifies the name of a Formatter class to use
         (defaults to java.util.logging.XMLFormatter).
     <handler-name>.encoding
         the name of the character set encoding to use (defaults to
         the default platform encoding).
     <handler-name>.host
         specifies the target host name to connect to (no default).
     <handler-name>.port
         specifies the target TCP port to use (no default).


  For example, the properties for SocketHandler would be:

     java.util.logging.SocketHandler.level=INFO
     java.util.logging.SocketHandler.formatter=java.util.logging.SimpleFormatter


  For a custom handler, e.g. com.foo.MyHandler, the properties would be:

     com.foo.MyHandler.level=INFO
     com.foo.MyHandler.formatter=java.util.logging.SimpleFormatter


  The output IO stream is buffered, but is flushed after each
  LogRecord is written."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.logging SocketHandler]))

(defn ->socket-handler
  "Constructor.

  Construct a SocketHandler using a specified host and port.

   The SocketHandler is configured based on LogManager
   properties (or their default values) except that the given target host
   and port arguments are used. If the host argument is empty, but not
   null String then the localhost is used.

  host - target host. - `java.lang.String`
  port - target port. - `int`

  throws: java.lang.IllegalArgumentException - if the host or port are invalid."
  ([^java.lang.String host ^Integer port]
    (new SocketHandler host port))
  ([]
    (new SocketHandler )))

(defn close
  "Close this output stream.

  throws: java.lang.SecurityException - if a security manager exists and if the caller does not have LoggingPermission(`control`)."
  ([^java.util.logging.SocketHandler this]
    (-> this (.close))))

(defn publish
  "Format and publish a LogRecord.

  record - description of the log event. A null record is silently ignored and is not published - `java.util.logging.LogRecord`"
  ([^java.util.logging.SocketHandler this ^java.util.logging.LogRecord record]
    (-> this (.publish record))))

