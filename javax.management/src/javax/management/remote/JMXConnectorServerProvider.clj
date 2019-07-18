(ns javax.management.remote.JMXConnectorServerProvider
  "A provider for creating JMX API connector servers using a given
  protocol.  Instances of this interface are created by JMXConnectorServerFactory as part of its newJMXConnectorServer method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote JMXConnectorServerProvider]))

(defn new-jmx-connector-server
  "Creates a new connector server at the given address.  Each
   successful call to this method produces a different
   JMXConnectorServer object.

  service-url - the address of the new connector server. The actual address of the new connector server, as returned by its getAddress method, will not necessarily be exactly the same. For example, it might include a port number if the original address did not. - `javax.management.remote.JMXServiceURL`
  environment - a read-only Map containing named attributes to control the new connector server's behavior. Keys in this map must be Strings. The appropriate type of each associated value depends on the attribute. - `java.util.Map`
  mbean-server - the MBean server that this connector server is attached to. Null if this connector server will be attached to an MBean server by being registered in it. - `javax.management.MBeanServer`

  returns: a JMXConnectorServer representing the new
   connector server.  Each successful call to this method produces
   a different object. - `javax.management.remote.JMXConnectorServer`

  throws: java.lang.NullPointerException - if serviceURL or environment is null."
  (^javax.management.remote.JMXConnectorServer [^JMXConnectorServerProvider this ^javax.management.remote.JMXServiceURL service-url ^java.util.Map environment ^javax.management.MBeanServer mbean-server]
    (-> this (.newJMXConnectorServer service-url environment mbean-server))))

