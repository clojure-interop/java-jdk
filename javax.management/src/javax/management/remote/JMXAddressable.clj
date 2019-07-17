(ns javax.management.remote.JMXAddressable
  "Implemented by objects that can have a JMXServiceURL address.
  All JMXConnectorServer objects implement this interface.
  Depending on the connector implementation, a JMXConnector
  object may implement this interface too.  JMXConnector
  objects for the RMI Connector are instances of
  RMIConnector which
  implements this interface.

  An object implementing this interface might not have an address
  at a given moment.  This is indicated by a null return value from
  getAddress()."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote JMXAddressable]))

(defn get-address
  "The address of this object.

  returns: the address of this object, or null if it
   does not have one. - `javax.management.remote.JMXServiceURL`"
  ([this]
    (-> this (.getAddress))))

