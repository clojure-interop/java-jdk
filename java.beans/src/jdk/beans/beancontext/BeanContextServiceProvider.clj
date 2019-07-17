(ns jdk.beans.beancontext.BeanContextServiceProvider
  " One of the primary functions of a BeanContext is to act a as rendezvous
  between JavaBeans, and BeanContextServiceProviders.


  A JavaBean nested within a BeanContext, may ask that BeanContext to
  provide an instance of a `service`, based upon a reference to a Java
  Class object that represents that service.


  If such a service has been registered with the context, or one of its
  nesting context's, in the case where a context delegate to its context
  to satisfy a service request, then the BeanContextServiceProvider associated with
  the service is asked to provide an instance of that service.


  The ServcieProvider may always return the same instance, or it may
  construct a new instance for each request."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans.beancontext BeanContextServiceProvider]))

(defn get-service
  "Invoked by BeanContextServices, this method
   requests an instance of a
   service from this BeanContextServiceProvider.

  bcs - The BeanContextServices associated with this particular request. This parameter enables the BeanContextServiceProvider to distinguish service requests from multiple sources. - `java.beans.beancontext.BeanContextServices`
  requestor - The object requesting the service - `java.lang.Object`
  service-class - The service requested - `java.lang.Class`
  service-selector - the service dependent parameter for a particular service, or null if not applicable. - `java.lang.Object`

  returns: a reference to the requested service - `java.lang.Object`"
  ([^java.beans.beancontext.BeanContextServiceProvider this ^java.beans.beancontext.BeanContextServices bcs ^java.lang.Object requestor ^java.lang.Class service-class ^java.lang.Object service-selector]
    (-> this (.getService bcs requestor service-class service-selector))))

(defn release-service
  "Invoked by BeanContextServices,
   this method releases a nested BeanContextChild's
   (or any arbitrary object associated with a
   BeanContextChild) reference to the specified service.

  bcs - the BeanContextServices associated with this particular release request - `java.beans.beancontext.BeanContextServices`
  requestor - the object requesting the service to be released - `java.lang.Object`
  service - the service that is to be released - `java.lang.Object`"
  ([^java.beans.beancontext.BeanContextServiceProvider this ^java.beans.beancontext.BeanContextServices bcs ^java.lang.Object requestor ^java.lang.Object service]
    (-> this (.releaseService bcs requestor service))))

(defn get-current-service-selectors
  "Invoked by BeanContextServices, this method
   gets the current service selectors for the specified service.
   A service selector is a service specific parameter,
   typical examples of which could include: a
   parameter to a constructor for the service implementation class,
   a value for a particular service's property, or a key into a
   map of existing implementations.

  bcs - the BeanContextServices for this request - `java.beans.beancontext.BeanContextServices`
  service-class - the specified service - `java.lang.Class`

  returns: the current service selectors for the specified serviceClass - `java.util.Iterator`"
  ([^java.beans.beancontext.BeanContextServiceProvider this ^java.beans.beancontext.BeanContextServices bcs ^java.lang.Class service-class]
    (-> this (.getCurrentServiceSelectors bcs service-class))))

