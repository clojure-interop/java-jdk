(ns javax.management.remote.JMXProviderException
  "Exception thrown by JMXConnectorFactory and
  JMXConnectorServerFactory when a provider exists for
  the required protocol but cannot be used for some reason."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote JMXProviderException]))

(defn ->jmx-provider-exception
  "Constructor.

  Constructs a JMXProviderException with the
   specified detail message and nested exception.

  message - the detail message - `java.lang.String`
  cause - the nested exception - `java.lang.Throwable`"
  ([message cause]
    (new JMXProviderException message cause))
  ([message]
    (new JMXProviderException message))
  ([]
    (new JMXProviderException )))

(defn get-cause
  "Description copied from class: Throwable

  returns: the cause of this throwable or null if the
            cause is nonexistent or unknown. - `java.lang.Throwable`"
  ([this]
    (-> this (.getCause))))

