(ns jdk.time.zone.ZoneRulesException
  "Thrown to indicate a problem with time-zone configuration.

  This exception is used to indicate a problems with the configured
  time-zone rules."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.zone ZoneRulesException]))

(defn ->zone-rules-exception
  "Constructor.

  Constructs a new date-time exception with the specified message and cause.

  message - the message to use for this exception, may be null - `java.lang.String`
  cause - the cause of the exception, may be null - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.Throwable cause]
    (new ZoneRulesException message cause))
  ([^java.lang.String message]
    (new ZoneRulesException message)))

