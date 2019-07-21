(ns jdk.util.logging.Formatter
  "A Formatter provides support for formatting LogRecords.

  Typically each logging Handler will have a Formatter associated
  with it.  The Formatter takes a LogRecord and converts it to
  a string.

  Some formatters (such as the XMLFormatter) need to wrap head
  and tail strings around a set of formatted records. The getHeader
  and getTail methods can be used to obtain these strings."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.logging Formatter]))

(defn format
  "Format the given log record and return the formatted string.

   The resulting formatted String will normally include a
   localized and formatted version of the LogRecord's message field.
   It is recommended to use the formatMessage(java.util.logging.LogRecord)
   convenience method to localize and format the message field.

  record - the log record to be formatted. - `java.util.logging.LogRecord`

  returns: the formatted log record - `java.lang.String`"
  (^java.lang.String [^Formatter this ^java.util.logging.LogRecord record]
    (-> this (.format record))))

(defn get-head
  "Return the header string for a set of formatted records.

   This base class returns an empty string, but this may be
   overridden by subclasses.

  h - The target handler (can be null) - `java.util.logging.Handler`

  returns: header string - `java.lang.String`"
  (^java.lang.String [^Formatter this ^java.util.logging.Handler h]
    (-> this (.getHead h))))

(defn get-tail
  "Return the tail string for a set of formatted records.

   This base class returns an empty string, but this may be
   overridden by subclasses.

  h - The target handler (can be null) - `java.util.logging.Handler`

  returns: tail string - `java.lang.String`"
  (^java.lang.String [^Formatter this ^java.util.logging.Handler h]
    (-> this (.getTail h))))

(defn format-message
  "Localize and format the message string from a log record.  This
   method is provided as a convenience for Formatter subclasses to
   use when they are performing formatting.

   The message string is first localized to a format string using
   the record's ResourceBundle.  (If there is no ResourceBundle,
   or if the message key is not found, then the key is used as the
   format string.)  The format String uses java.text style
   formatting.

   If there are no parameters, no formatter is used.
   Otherwise, if the string contains \"{0\" then
       java.text.MessageFormat  is used to format the string.
   Otherwise no formatting is performed.

  record - the log record containing the raw message - `java.util.logging.LogRecord`

  returns: a localized and formatted message - `java.lang.String`"
  (^java.lang.String [^Formatter this ^java.util.logging.LogRecord record]
    (-> this (.formatMessage record))))

