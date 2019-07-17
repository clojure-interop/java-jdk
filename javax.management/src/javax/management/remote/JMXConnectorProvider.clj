(ns javax.management.remote.JMXConnectorProvider
  "A provider for creating JMX API connector clients using a given
  protocol.  Instances of this interface are created by JMXConnectorFactory as part of its newJMXConnector method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote JMXConnectorProvider]))

(defn new-jmx-connector
  "Creates a new connector client that is ready to connect
   to the connector server at the given address.  Each successful
   call to this method produces a different
   JMXConnector object.

  service-url - the address of the connector server to connect to. - `javax.management.remote.JMXServiceURL`
  environment - a read-only Map containing named attributes to determine how the connection is made. Keys in this map must be Strings. The appropriate type of each associated value depends on the attribute. - `java.util.Map<java.lang.String,?>`

  returns: a JMXConnector representing the new
   connector client.  Each successful call to this method produces
   a different object. - `javax.management.remote.JMXConnector`

  throws: java.lang.NullPointerException - if serviceURL or environment is null."
  (^javax.management.remote.JMXConnector [^javax.management.remote.JMXConnectorProvider this ^javax.management.remote.JMXServiceURL service-url ^java.util.Map environment]
    (-> this (.newJMXConnector service-url environment))))

