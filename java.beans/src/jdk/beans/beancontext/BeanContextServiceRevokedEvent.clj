(ns jdk.beans.beancontext.BeanContextServiceRevokedEvent
  " This event type is used by the
  BeanContextServiceRevokedListener in order to
  identify the service being revoked."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans.beancontext BeanContextServiceRevokedEvent]))

(defn ->bean-context-service-revoked-event
  "Constructor.

  Construct a BeanContextServiceEvent.

  bcs - the BeanContextServices from which this service is being revoked - `java.beans.beancontext.BeanContextServices`
  sc - the service that is being revoked - `java.lang.Class`
  invalidate - true for immediate revocation - `boolean`"
  ([^java.beans.beancontext.BeanContextServices bcs ^java.lang.Class sc ^Boolean invalidate]
    (new BeanContextServiceRevokedEvent bcs sc invalidate)))

(defn get-source-as-bean-context-services
  "Gets the source as a reference of type BeanContextServices

  returns: the BeanContextServices from which
   this service is being revoked - `java.beans.beancontext.BeanContextServices`"
  (^java.beans.beancontext.BeanContextServices [^java.beans.beancontext.BeanContextServiceRevokedEvent this]
    (-> this (.getSourceAsBeanContextServices))))

(defn get-service-class
  "Gets the service class that is the subject of this notification

  returns: A Class reference to the
   service that is being revoked - `java.lang.Class`"
  (^java.lang.Class [^java.beans.beancontext.BeanContextServiceRevokedEvent this]
    (-> this (.getServiceClass))))

(defn service-class?
  "Checks this event to determine whether or not
   the service being revoked is of a particular class.

  service - the service of interest (should be non-null) - `java.lang.Class`

  returns: true if the service being revoked is of the
   same class as the specified service - `boolean`"
  (^Boolean [^java.beans.beancontext.BeanContextServiceRevokedEvent this ^java.lang.Class service]
    (-> this (.isServiceClass service))))

(defn current-service-invalid-now?
  "Reports if the current service is being forcibly revoked,
   in which case the references are now invalidated and unusable.

  returns: true if current service is being forcibly revoked - `boolean`"
  (^Boolean [^java.beans.beancontext.BeanContextServiceRevokedEvent this]
    (-> this (.isCurrentServiceInvalidNow))))

