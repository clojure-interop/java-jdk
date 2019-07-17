(ns javax.net.ssl.SSLSessionBindingListener
  "This interface is implemented by objects which want to know when
  they are being bound or unbound from a SSLSession.  When either event
  occurs via SSLSession.putValue(String, Object)
  or SSLSession.removeValue(String), the event is communicated
  through a SSLSessionBindingEvent identifying the session."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl SSLSessionBindingListener]))

(defn value-bound
  "This is called to notify the listener that it is being bound into
   an SSLSession.

  event - the event identifying the SSLSession into which the listener is being bound. - `javax.net.ssl.SSLSessionBindingEvent`"
  ([this event]
    (-> this (.valueBound event))))

(defn value-unbound
  "This is called to notify the listener that it is being unbound
   from a SSLSession.

  event - the event identifying the SSLSession from which the listener is being unbound. - `javax.net.ssl.SSLSessionBindingEvent`"
  ([this event]
    (-> this (.valueUnbound event))))

