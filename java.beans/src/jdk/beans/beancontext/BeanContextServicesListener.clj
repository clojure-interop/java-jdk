(ns jdk.beans.beancontext.BeanContextServicesListener
  "The listener interface for receiving
  BeanContextServiceAvailableEvent objects.
  A class that is interested in processing a
  BeanContextServiceAvailableEvent implements this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans.beancontext BeanContextServicesListener]))

(defn service-available
  "The service named has been registered. getService requests for
   this service may now be made.

  bcsae - the BeanContextServiceAvailableEvent - `java.beans.beancontext.BeanContextServiceAvailableEvent`"
  ([this bcsae]
    (-> this (.serviceAvailable bcsae))))

