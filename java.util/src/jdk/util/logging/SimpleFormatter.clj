(ns jdk.util.logging.SimpleFormatter
  "Print a brief summary of the LogRecord in a human readable
  format.  The summary will typically be 1 or 2 lines.



  Configuration:
  The SimpleFormatter is initialized with the
  format string
  specified in the java.util.logging.SimpleFormatter.format
  property to format the log messages.
  This property can be defined
  in the logging properties
  configuration file
  or as a system property.  If this property is set in both
  the logging properties and system properties,
  the format string specified in the system property will be used.
  If this property is not defined or the given format string
  is java.util.illegal,
  the default format is implementation-specific."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.logging SimpleFormatter]))

(defn ->simple-formatter
  "Constructor."
  (^SimpleFormatter []
    (new SimpleFormatter )))

(defn format
  "Format the given LogRecord.

   The formatting can be customized by specifying the
   format string
   in the
   java.util.logging.SimpleFormatter.format property.
   The given LogRecord will be formatted as if by calling:


      String.format(format, date, source, logger, level, message, thrown);
   where the arguments are:

   format - the java.util.Formatter format string specified in the
       java.util.logging.SimpleFormatter.format property
       or the default format.
   date - a Date object representing
       event time of the log record.
   source - a string representing the caller, if available;
       otherwise, the logger's name.
   logger - the logger's name.
   level - the log level.
   message - the formatted log message
       returned from the Formatter.formatMessage(LogRecord)
       method.  It uses java.text
       formatting and does not use the java.util.Formatter
       format argument.
   thrown - a string representing
       the throwable
       associated with the log record and its backtrace
       beginning with a newline character, if any;
       otherwise, an empty string.


   Some example formats:

    java.util.logging.SimpleFormatter.format=\"%4$s: %5$s [%1$tc]%n\"
       This prints 1 line with the log level (4$),
       the log message (5$) and the timestamp (1$) in
       a square bracket.


       WARNING: warning message [Tue Mar 22 13:11:31 PDT 2011]
    java.util.logging.SimpleFormatter.format=\"%1$tc %2$s%n%4$s: %5$s%6$s%n\"
       This prints 2 lines where the first line includes
       the timestamp (1$) and the source (2$);
       the second line includes the log level (4$) and
       the log message (5$) followed with the throwable
       and its backtrace (6$), if any:


       Tue Mar 22 13:11:31 PDT 2011 MyClass fatal
       SEVERE: several message with an exception
       java.lang.IllegalArgumentException: invalid argument
               at MyClass.mash(MyClass.java:9)
               at MyClass.crunch(MyClass.java:6)
               at MyClass.main(MyClass.java:3)
    java.util.logging.SimpleFormatter.format=\"%1$tb %1$td, %1$tY %1$tl:%1$tM:%1$tS %1$Tp %2$s%n%4$s: %5$s%n\"
        This prints 2 lines similar to the example above
           with a different date/time formatting and does not print
           the throwable and its backtrace:


       Mar 22, 2011 1:11:31 PM MyClass fatal
       SEVERE: several message with an exception

   This method can also be overridden in a subclass.
   It is recommended to use the Formatter.formatMessage(java.util.logging.LogRecord)
   convenience method to localize and format the message field.

  record - the log record to be formatted. - `java.util.logging.LogRecord`

  returns: a formatted log record - `java.lang.String`"
  (^java.lang.String [^SimpleFormatter this ^java.util.logging.LogRecord record]
    (-> this (.format record))))

