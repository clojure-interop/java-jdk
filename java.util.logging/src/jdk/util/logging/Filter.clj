(ns jdk.util.logging.Filter
  "A Filter can be used to provide fine grain control over
  what is logged, beyond the control provided by log levels.

  Each Logger and each Handler can have a filter associated with it.
  The Logger or Handler will call the isLoggable method to check
  if a given LogRecord should be published.  If isLoggable returns
  false, the LogRecord will be discarded."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.logging Filter]))

(defn loggable?
  "Check if a given log record should be published.

  record - a LogRecord - `java.util.logging.LogRecord`

  returns: true if the log record should be published. - `boolean`"
  ([^. this ^java.util.logging.LogRecord record]
    (-> this (.isLoggable record))))

