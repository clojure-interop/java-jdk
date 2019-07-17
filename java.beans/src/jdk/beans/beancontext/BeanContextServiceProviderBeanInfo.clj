(ns jdk.beans.beancontext.BeanContextServiceProviderBeanInfo
  "A BeanContextServiceProvider implementor who wishes to provide explicit
  information about the services their bean may provide shall implement a
  BeanInfo class that implements this BeanInfo subinterface and provides
  explicit information about the methods, properties, events, etc, of their
  services."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans.beancontext BeanContextServiceProviderBeanInfo]))

(defn get-services-bean-info
  "Gets a BeanInfo array, one for each
   service class or interface statically available
   from this ServiceProvider.

  returns: the BeanInfo array - `java.beans.BeanInfo[]`"
  ([this]
    (-> this (.getServicesBeanInfo))))

