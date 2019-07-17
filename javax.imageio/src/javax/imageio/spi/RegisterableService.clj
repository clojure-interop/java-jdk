(ns javax.imageio.spi.RegisterableService
  "An optional interface that may be provided by service provider
  objects that will be registered with a
  ServiceRegistry.  If this interface is present,
  notification of registration and deregistration will be performed."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.spi RegisterableService]))

(defn on-registration
  "Called when an object implementing this interface is added to
   the given category of the given
   registry.  The object may already be registered
   under another category or categories.

  registry - a ServiceRegistry where this object has been registered. - `javax.imageio.spi.ServiceRegistry`
  category - a Class object indicating the registry category under which this object has been registered. - `java.lang.Class<?>`"
  ([this registry category]
    (-> this (.onRegistration registry category))))

(defn on-deregistration
  "Called when an object implementing this interface is removed
   from the given category of the given
   registry.  The object may still be registered
   under another category or categories.

  registry - a ServiceRegistry from which this object is being (wholly or partially) deregistered. - `javax.imageio.spi.ServiceRegistry`
  category - a Class object indicating the registry category from which this object is being deregistered. - `java.lang.Class<?>`"
  ([this registry category]
    (-> this (.onDeregistration registry category))))

