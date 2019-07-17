(ns javax.xml.validation.SchemaFactoryConfigurationError
  "Thrown when a problem with configuration with the Schema Factories
  exists. This error will typically be thrown when the class of a
  schema factory specified in the system properties cannot be found
  or instantiated."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.validation SchemaFactoryConfigurationError]))

(defn ->schema-factory-configuration-error
  "Constructor.

  Create a new SchemaFactoryConfigurationError with the
   given Throwable base cause and detail message.

  message - The detail message. - `java.lang.String`
  cause - The exception or error to be encapsulated in a SchemaFactoryConfigurationError. - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.Throwable cause]
    (new SchemaFactoryConfigurationError message cause))
  ([^java.lang.String message]
    (new SchemaFactoryConfigurationError message))
  ([]
    (new SchemaFactoryConfigurationError )))

