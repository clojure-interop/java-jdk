(ns jdk.beans.beancontext.BeanContextServiceAvailableEvent
  " This event type is used by the BeanContextServicesListener in order to
  identify the service being registered."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans.beancontext BeanContextServiceAvailableEvent]))

(defn ->bean-context-service-available-event
  "Constructor.

  Construct a BeanContextAvailableServiceEvent.

  bcs - The context in which the service has become available - `java.beans.beancontext.BeanContextServices`
  sc - A Class reference to the newly available service - `java.lang.Class`"
  ([bcs sc]
    (new BeanContextServiceAvailableEvent bcs sc)))

(defn get-source-as-bean-context-services
  "Gets the source as a reference of type BeanContextServices.

  returns: The context in which the service has become available - `java.beans.beancontext.BeanContextServices`"
  ([this]
    (-> this (.getSourceAsBeanContextServices))))

(defn get-service-class
  "Gets the service class that is the subject of this notification.

  returns: A Class reference to the newly available service - `java.lang.Class`"
  ([this]
    (-> this (.getServiceClass))))

(defn get-current-service-selectors
  "Gets the list of service dependent selectors.

  returns: the current selectors available from the service - `java.util.Iterator`"
  ([this]
    (-> this (.getCurrentServiceSelectors))))

