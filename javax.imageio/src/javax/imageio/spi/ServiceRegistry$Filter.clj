(ns javax.imageio.spi.ServiceRegistry$Filter
  "A simple filter interface used by
  ServiceRegistry.getServiceProviders to select
  providers matching an arbitrary criterion.  Classes that
  implement this interface should be defined in order to make use
  of the getServiceProviders method of
  ServiceRegistry that takes a Filter."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.spi ServiceRegistry$Filter]))

(defn filter
  "Returns true if the given
   provider object matches the criterion defined
   by this Filter.

  provider - a service provider Object. - `java.lang.Object`

  returns: true if the provider matches the criterion. - `boolean`"
  ([^. this ^java.lang.Object provider]
    (-> this (.filter provider))))

