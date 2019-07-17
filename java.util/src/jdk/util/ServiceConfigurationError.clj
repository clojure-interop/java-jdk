(ns jdk.util.ServiceConfigurationError
  "Error thrown when something goes wrong while loading a service provider.

   This error will be thrown in the following situations:



     The format of a provider-configuration file violates the specification;

     An IOException occurs while reading a
    provider-configuration file;

     A concrete provider class named in a provider-configuration file
    cannot be found;

     A concrete provider class is not a subclass of the service class;


     A concrete provider class cannot be instantiated; or

     Some other kind of error occurs."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util ServiceConfigurationError]))

(defn ->service-configuration-error
  "Constructor.

  Constructs a new instance with the specified message and cause.

  msg - The message, or null if there is no message - `java.lang.String`
  cause - The cause, or null if the cause is nonexistent or unknown - `java.lang.Throwable`"
  ([msg cause]
    (new ServiceConfigurationError msg cause))
  ([msg]
    (new ServiceConfigurationError msg)))

