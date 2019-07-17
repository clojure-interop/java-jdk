(ns javax.xml.stream.FactoryConfigurationError
  "An error class for reporting factory configuration errors."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream FactoryConfigurationError]))

(defn ->factory-configuration-error
  "Constructor.

  Construct an exception with a nested inner exception
   and a message

  e - the exception to nest - `java.lang.Exception`
  msg - the message to report - `java.lang.String`"
  ([e msg]
    (new FactoryConfigurationError e msg))
  ([e]
    (new FactoryConfigurationError e))
  ([]
    (new FactoryConfigurationError )))

(defn get-exception
  "Return the nested exception (if any)

  returns: the nested exception or null - `java.lang.Exception`"
  ([this]
    (-> this (.getException))))

(defn get-cause
  "use the exception chaining mechanism of JDK1.4

  returns: the cause of this throwable or null if the
            cause is nonexistent or unknown. - `java.lang.Throwable`"
  ([this]
    (-> this (.getCause))))

(defn get-message
  "Report the message associated with this error

  returns: the string value of the message - `java.lang.String`"
  ([this]
    (-> this (.getMessage))))

