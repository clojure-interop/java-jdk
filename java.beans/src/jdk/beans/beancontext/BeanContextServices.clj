(ns jdk.beans.beancontext.BeanContextServices
  " The BeanContextServices interface provides a mechanism for a BeanContext
  to expose generic `services` to the BeanContextChild objects within."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans.beancontext BeanContextServices]))

(defn get-service
  "A BeanContextChild, or any arbitrary object
   associated with a BeanContextChild, may obtain
   a reference to a currently registered service from its
   nesting BeanContextServices
   via invocation of this method. When invoked, this method
   gets the service by calling the getService() method on the
   underlying BeanContextServiceProvider.

  child - the BeanContextChild associated with this request - `java.beans.beancontext.BeanContextChild`
  requestor - the object requesting the service - `java.lang.Object`
  service-class - class of the requested service - `java.lang.Class`
  service-selector - the service dependent parameter - `java.lang.Object`
  bcsrl - the BeanContextServiceRevokedListener to notify if the service should later become revoked - `java.beans.beancontext.BeanContextServiceRevokedListener`

  returns: a reference to this context's named
   Service as requested or null - `java.lang.Object`

  throws: java.util.TooManyListenersException - if there are too many listeners"
  ([^. this ^java.beans.beancontext.BeanContextChild child ^java.lang.Object requestor ^java.lang.Class service-class ^java.lang.Object service-selector ^java.beans.beancontext.BeanContextServiceRevokedListener bcsrl]
    (-> this (.getService child requestor service-class service-selector bcsrl))))

(defn release-service
  "Releases a BeanContextChild's
   (or any arbitrary object associated with a BeanContextChild)
   reference to the specified service by calling releaseService()
   on the underlying BeanContextServiceProvider.

  child - the BeanContextChild - `java.beans.beancontext.BeanContextChild`
  requestor - the requestor - `java.lang.Object`
  service - the service - `java.lang.Object`"
  ([^. this ^java.beans.beancontext.BeanContextChild child ^java.lang.Object requestor ^java.lang.Object service]
    (-> this (.releaseService child requestor service))))

(defn has-service?
  "Reports whether or not a given service is
   currently available from this context.

  service-class - the service in question - `java.lang.Class`

  returns: true if the service is available - `boolean`"
  ([^. this ^java.lang.Class service-class]
    (-> this (.hasService service-class))))

(defn revoke-service
  "BeanContextServiceProviders wishing to remove
   a currently registered service from this context
   may do so via invocation of this method. Upon revocation of
   the service, the BeanContextServices fires a
   BeanContextServiceRevokedEvent to its
   list of currently registered
   BeanContextServiceRevokedListeners and
   BeanContextServicesListeners.

  service-class - the service to revoke from this BeanContextServices - `java.lang.Class`
  service-provider - the BeanContextServiceProvider associated with this particular service that is being revoked - `java.beans.beancontext.BeanContextServiceProvider`
  revoke-current-services-now - a value of true indicates an exceptional circumstance where the BeanContextServiceProvider or BeanContextServices wishes to immediately terminate service to all currently outstanding references to the specified service. - `boolean`"
  ([^. this ^java.lang.Class service-class ^java.beans.beancontext.BeanContextServiceProvider service-provider ^Boolean revoke-current-services-now]
    (-> this (.revokeService service-class service-provider revoke-current-services-now))))

(defn add-service
  "Adds a service to this BeanContext.
   BeanContextServiceProviders call this method
   to register a particular service with this context.
   If the service has not previously been added, the
   BeanContextServices associates
   the service with the BeanContextServiceProvider and
   fires a BeanContextServiceAvailableEvent to all
   currently registered BeanContextServicesListeners.
   The method then returns true, indicating that
   the addition of the service was successful.
   If the given service has already been added, this method
   simply returns false.

  service-class - the service to add - `java.lang.Class`
  service-provider - the BeanContextServiceProvider associated with the service - `java.beans.beancontext.BeanContextServiceProvider`

  returns: true if the service was successful added, false otherwise - `boolean`"
  ([^. this ^java.lang.Class service-class ^java.beans.beancontext.BeanContextServiceProvider service-provider]
    (-> this (.addService service-class service-provider))))

(defn get-current-service-selectors
  "Gets the list of service dependent service parameters
   (Service Selectors) for the specified service, by
   calling getCurrentServiceSelectors() on the
   underlying BeanContextServiceProvider.

  service-class - the specified service - `java.lang.Class`

  returns: the currently available service selectors
   for the named serviceClass - `java.util.Iterator`"
  ([^. this ^java.lang.Class service-class]
    (-> this (.getCurrentServiceSelectors service-class))))

(defn add-bean-context-services-listener
  "Adds a BeanContextServicesListener to this BeanContext

  bcsl - the BeanContextServicesListener to add - `java.beans.beancontext.BeanContextServicesListener`"
  ([^. this ^java.beans.beancontext.BeanContextServicesListener bcsl]
    (-> this (.addBeanContextServicesListener bcsl))))

(defn remove-bean-context-services-listener
  "Removes a BeanContextServicesListener
   from this BeanContext

  bcsl - the BeanContextServicesListener to remove from this context - `java.beans.beancontext.BeanContextServicesListener`"
  ([^. this ^java.beans.beancontext.BeanContextServicesListener bcsl]
    (-> this (.removeBeanContextServicesListener bcsl))))

(defn get-current-service-classes
  "Gets the currently available services for this context.

  returns: an Iterator consisting of the
   currently available services - `java.util.Iterator`"
  ([^. this]
    (-> this (.getCurrentServiceClasses))))

