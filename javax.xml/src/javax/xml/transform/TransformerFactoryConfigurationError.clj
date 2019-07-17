(ns javax.xml.transform.TransformerFactoryConfigurationError
  "Thrown when a problem with configuration with the Transformer Factories
  exists. This error will typically be thrown when the class of a
  transformation factory specified in the system properties cannot be found
  or instantiated."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.transform TransformerFactoryConfigurationError]))

(defn ->transformer-factory-configuration-error
  "Constructor.

  Create a new TransformerFactoryConfigurationError with the
   given Exception base cause and detail message.

  e - The exception to be encapsulated in a TransformerFactoryConfigurationError - `java.lang.Exception`
  msg - The detail message. - `java.lang.String`"
  ([^java.lang.Exception e ^java.lang.String msg]
    (new TransformerFactoryConfigurationError e msg))
  ([^java.lang.String msg]
    (new TransformerFactoryConfigurationError msg))
  ([]
    (new TransformerFactoryConfigurationError )))

(defn get-message
  "Return the message (if any) for this error . If there is no
   message for the exception and there is an encapsulated
   exception then the message of that exception will be returned.

  returns: The error message. - `java.lang.String`"
  (^java.lang.String [^javax.xml.transform.TransformerFactoryConfigurationError this]
    (-> this (.getMessage))))

(defn get-exception
  "Return the actual exception (if any) that caused this exception to
   be raised.

  returns: The encapsulated exception, or null if there is none. - `java.lang.Exception`"
  (^java.lang.Exception [^javax.xml.transform.TransformerFactoryConfigurationError this]
    (-> this (.getException))))

(defn get-cause
  "use the exception chaining mechanism of JDK1.4

  returns: the cause of this throwable or null if the
            cause is nonexistent or unknown. - `java.lang.Throwable`"
  (^java.lang.Throwable [^javax.xml.transform.TransformerFactoryConfigurationError this]
    (-> this (.getCause))))

