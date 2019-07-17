(ns jdk.beans.beancontext.BeanContextServiceRevokedListener
  "The listener interface for receiving
  BeanContextServiceRevokedEvent objects. A class that is
  interested in processing a BeanContextServiceRevokedEvent
  implements this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans.beancontext BeanContextServiceRevokedListener]))

(defn service-revoked
  "The service named has been revoked. getService requests for
   this service will no longer be satisfied.

  bcsre - the BeanContextServiceRevokedEvent received by this listener. - `java.beans.beancontext.BeanContextServiceRevokedEvent`"
  ([this bcsre]
    (-> this (.serviceRevoked bcsre))))

