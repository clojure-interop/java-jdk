(ns javax.xml.parsers.FactoryConfigurationError
  "Thrown when a problem with configuration with the Parser Factories
  exists. This error will typically be thrown when the class of a
  parser factory specified in the system properties cannot be found
  or instantiated."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.parsers FactoryConfigurationError]))

(defn ->factory-configuration-error
  "Constructor.

  Create a new FactoryConfigurationError with the
   given Exception base cause and detail message.

  e - The exception to be encapsulated in a FactoryConfigurationError - `java.lang.Exception`
  msg - The detail message. - `java.lang.String`"
  ([^java.lang.Exception e ^java.lang.String msg]
    (new FactoryConfigurationError e msg))
  ([^java.lang.String msg]
    (new FactoryConfigurationError msg))
  ([]
    (new FactoryConfigurationError )))

(defn get-message
  "Return the message (if any) for this error . If there is no
   message for the exception and there is an encapsulated
   exception then the message of that exception, if it exists will be
   returned. Else the name of the encapsulated exception will be
   returned.

  returns: The error message. - `java.lang.String`"
  (^java.lang.String [^javax.xml.parsers.FactoryConfigurationError this]
    (-> this (.getMessage))))

(defn get-exception
  "Return the actual exception (if any) that caused this exception to
   be raised.

  returns: The encapsulated exception, or null if there is none. - `java.lang.Exception`"
  (^java.lang.Exception [^javax.xml.parsers.FactoryConfigurationError this]
    (-> this (.getException))))

(defn get-cause
  "use the exception chaining mechanism of JDK1.4

  returns: the cause of this throwable or null if the
            cause is nonexistent or unknown. - `java.lang.Throwable`"
  (^java.lang.Throwable [^javax.xml.parsers.FactoryConfigurationError this]
    (-> this (.getCause))))

