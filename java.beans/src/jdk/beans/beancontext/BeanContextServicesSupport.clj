(ns jdk.beans.beancontext.BeanContextServicesSupport
  " This helper class provides a utility implementation of the
  java.beans.beancontext.BeanContextServices interface.


  Since this class directly implements the BeanContextServices interface,
  the class can, and is intended to be used either by subclassing this
  implementation, or via delegation of an instance of this class
  from another through the BeanContextProxy interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans.beancontext BeanContextServicesSupport]))

(defn ->bean-context-services-support
  "Constructor.

  Construct a BeanContextServicesSupport instance

  peer - The peer BeanContext we are supplying an implementation for, if null the this object is its own peer - `java.beans.beancontext.BeanContextServices`
  lcle - The current Locale for this BeanContext. - `java.util.Locale`
  d-time - The initial state, true if in design mode, false if runtime. - `boolean`
  visible - The initial visibility. - `boolean`"
  ([peer lcle d-time visible]
    (new BeanContextServicesSupport peer lcle d-time visible))
  ([peer lcle dtime]
    (new BeanContextServicesSupport peer lcle dtime))
  ([peer lcle]
    (new BeanContextServicesSupport peer lcle))
  ([peer]
    (new BeanContextServicesSupport peer))
  ([]
    (new BeanContextServicesSupport )))

(defn get-service
  "obtain a service which may be delegated

  child - the BeanContextChild associated with this request - `java.beans.beancontext.BeanContextChild`
  requestor - the object requesting the service - `java.lang.Object`
  service-class - class of the requested service - `java.lang.Class`
  service-selector - the service dependent parameter - `java.lang.Object`
  bcsrl - the BeanContextServiceRevokedListener to notify if the service should later become revoked - `java.beans.beancontext.BeanContextServiceRevokedListener`

  returns: a reference to this context's named
   Service as requested or null - `java.lang.Object`

  throws: java.util.TooManyListenersException - if there are too many listeners"
  ([this child requestor service-class service-selector bcsrl]
    (-> this (.getService child requestor service-class service-selector bcsrl))))

(defn release-service
  "release a service

  child - the BeanContextChild - `java.beans.beancontext.BeanContextChild`
  requestor - the requestor - `java.lang.Object`
  service - the service - `java.lang.Object`"
  ([this child requestor service]
    (-> this (.releaseService child requestor service))))

(defn has-service?
  "has a service, which may be delegated

  service-class - the service in question - `java.lang.Class`

  returns: true if the service is available - `boolean`"
  ([this service-class]
    (-> this (.hasService service-class))))

(defn revoke-service
  "remove a service

  service-class - the service class - `java.lang.Class`
  bcsp - the service provider - `java.beans.beancontext.BeanContextServiceProvider`
  revoke-current-services-now - whether or not to revoke the service - `boolean`"
  ([this service-class bcsp revoke-current-services-now]
    (-> this (.revokeService service-class bcsp revoke-current-services-now))))

(defn get-bean-context-services-peer
  "Gets the BeanContextServices associated with this
   BeanContextServicesSupport.

  returns: the instance of BeanContext
   this object is providing the implementation for. - `java.beans.beancontext.BeanContextServices`"
  ([this]
    (-> this (.getBeanContextServicesPeer))))

(defn add-service
  "add a service

  service-class - the service class - `java.lang.Class`
  bcsp - the service provider - `java.beans.beancontext.BeanContextServiceProvider`

  returns: true if the service was successful added, false otherwise - `boolean`"
  ([this service-class bcsp]
    (-> this (.addService service-class bcsp))))

(defn get-current-service-selectors
  "Description copied from interface: BeanContextServices

  service-class - the specified service - `java.lang.Class`

  returns: an iterator for all the currently available service selectors
   (if any) available for the specified service. - `java.util.Iterator`"
  ([this service-class]
    (-> this (.getCurrentServiceSelectors service-class))))

(defn initialize
  "called by BeanContextSupport superclass during construction and
   deserialization to initialize subclass transient state.

   subclasses may envelope this method, but should not override it or
   call it directly."
  ([this]
    (-> this (.initialize))))

(defn add-bean-context-services-listener
  "add a BeanContextServicesListener

  bcsl - the BeanContextServicesListener to add - `java.beans.beancontext.BeanContextServicesListener`

  throws: java.lang.NullPointerException - if the argument is null"
  ([this bcsl]
    (-> this (.addBeanContextServicesListener bcsl))))

(defn remove-bean-context-services-listener
  "remove a BeanContextServicesListener

  bcsl - the BeanContextServicesListener to remove from this context - `java.beans.beancontext.BeanContextServicesListener`"
  ([this bcsl]
    (-> this (.removeBeanContextServicesListener bcsl))))

(defn service-available
  "BeanContextServicesListener callback, propagates event to all
   currently registered listeners and BeanContextServices children,
   if this BeanContextService does not already implement this service
   itself.

   subclasses may override or envelope this method to implement their
   own propagation semantics.

  bcssae - The BeanContextServiceAvailableEvent fired as a result of a service becoming available - `java.beans.beancontext.BeanContextServiceAvailableEvent`"
  ([this bcssae]
    (-> this (.serviceAvailable bcssae))))

(defn service-revoked
  "BeanContextServicesListener callback, propagates event to all
   currently registered listeners and BeanContextServices children,
   if this BeanContextService does not already implement this service
   itself.

   subclasses may override or envelope this method to implement their
   own propagation semantics.

  bcssre - The BeanContextServiceRevokedEvent fired as a result of a service being revoked - `java.beans.beancontext.BeanContextServiceRevokedEvent`"
  ([this bcssre]
    (-> this (.serviceRevoked bcssre))))

(defn get-current-service-classes
  "Description copied from interface: BeanContextServices

  returns: an iterator for all the currently registered service classes. - `java.util.Iterator`"
  ([this]
    (-> this (.getCurrentServiceClasses))))

