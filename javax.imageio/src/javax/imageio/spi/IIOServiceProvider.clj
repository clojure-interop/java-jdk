(ns javax.imageio.spi.IIOServiceProvider
  "A superinterface for functionality common to all Image I/O service
  provider interfaces (SPIs).  For more information on service
  provider classes, see the class comment for the
  IIORegistry class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.spi IIOServiceProvider]))

(defn ->iio-service-provider
  "Constructor.

  Constructs an IIOServiceProvider with a given
   vendor name and version identifier.

  vendor-name - the vendor name. - `java.lang.String`
  version - a version identifier. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if version is null."
  ([^java.lang.String vendor-name ^java.lang.String version]
    (new IIOServiceProvider vendor-name version))
  ([]
    (new IIOServiceProvider )))

(defn on-registration
  "A callback that will be called exactly once after the Spi class
   has been instantiated and registered in a
   ServiceRegistry.  This may be used to verify that
   the environment is suitable for this service, for example that
   native libraries can be loaded.  If the service cannot function
   in the environment where it finds itself, it should deregister
   itself from the registry.

    Only the registry should call this method.

    The default implementation does nothing.

  registry - a ServiceRegistry where this object has been registered. - `javax.imageio.spi.ServiceRegistry`
  category - a Class object indicating the registry category under which this object has been registered. - `java.lang.Class<?>`"
  ([^javax.imageio.spi.IIOServiceProvider this ^javax.imageio.spi.ServiceRegistry registry ^java.lang.Class category]
    (-> this (.onRegistration registry category))))

(defn on-deregistration
  "A callback that will be whenever the Spi class has been
   deregistered from a ServiceRegistry.

    Only the registry should call this method.

    The default implementation does nothing.

  registry - a ServiceRegistry from which this object is being (wholly or partially) deregistered. - `javax.imageio.spi.ServiceRegistry`
  category - a Class object indicating the registry category from which this object is being deregistered. - `java.lang.Class<?>`"
  ([^javax.imageio.spi.IIOServiceProvider this ^javax.imageio.spi.ServiceRegistry registry ^java.lang.Class category]
    (-> this (.onDeregistration registry category))))

(defn get-vendor-name
  "Returns the name of the vendor responsible for creating this
   service provider and its associated implementation.  Because
   the vendor name may be used to select a service provider,
   it is not localized.

    The default implementation returns the value of the
   vendorName instance variable.

  returns: a non-null String containing
   the name of the vendor. - `java.lang.String`"
  ([^javax.imageio.spi.IIOServiceProvider this]
    (-> this (.getVendorName))))

(defn get-version
  "Returns a string describing the version
   number of this service provider and its associated
   implementation.  Because the version may be used by transcoders
   to identify the service providers they understand, this method
   is not localized.

    The default implementation returns the value of the
   version instance variable.

  returns: a non-null String containing
   the version of this service provider. - `java.lang.String`"
  ([^javax.imageio.spi.IIOServiceProvider this]
    (-> this (.getVersion))))

(defn get-description
  "Returns a brief, human-readable description of this service
   provider and its associated implementation.  The resulting
   string should be localized for the supplied
   Locale, if possible.

  locale - a Locale for which the return value should be localized. - `java.util.Locale`

  returns: a String containing a description of this
   service provider. - `java.lang.String`"
  ([^javax.imageio.spi.IIOServiceProvider this ^java.util.Locale locale]
    (-> this (.getDescription locale))))

