(ns jdk.util.logging.XMLFormatter
  "Format a LogRecord into a standard XML format.

  The DTD specification is provided as Appendix A to the
  Java Logging APIs specification.

  The XMLFormatter can be used with arbitrary character encodings,
  but it is recommended that it normally be used with UTF-8.  The
  character encoding can be set on the output Handler."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.logging XMLFormatter]))

(defn ->xml-formatter
  "Constructor."
  ([]
    (new XMLFormatter )))

(defn format
  "Format the given message to XML.

   This method can be overridden in a subclass.
   It is recommended to use the Formatter.formatMessage(java.util.logging.LogRecord)
   convenience method to localize and format the message field.

  record - the log record to be formatted. - `java.util.logging.LogRecord`

  returns: a formatted log record - `java.lang.String`"
  ([^java.util.logging.XMLFormatter this ^java.util.logging.LogRecord record]
    (-> this (.format record))))

(defn get-head
  "Return the header string for a set of XML formatted records.

  h - The target handler (can be null) - `java.util.logging.Handler`

  returns: a valid XML string - `java.lang.String`"
  ([^java.util.logging.XMLFormatter this ^java.util.logging.Handler h]
    (-> this (.getHead h))))

(defn get-tail
  "Return the tail string for a set of XML formatted records.

  h - The target handler (can be null) - `java.util.logging.Handler`

  returns: a valid XML string - `java.lang.String`"
  ([^java.util.logging.XMLFormatter this ^java.util.logging.Handler h]
    (-> this (.getTail h))))

