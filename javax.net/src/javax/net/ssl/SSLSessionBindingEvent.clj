(ns javax.net.ssl.SSLSessionBindingEvent
  "This event is propagated to a SSLSessionBindingListener.
  When a listener object is bound or unbound to an SSLSession by
  SSLSession.putValue(String, Object)
  or SSLSession.removeValue(String), objects which
  implement the SSLSessionBindingListener will be receive an
  event of this type.  The event's name field is the
  key in which the listener is being bound or unbound."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl SSLSessionBindingEvent]))

(defn ->ssl-session-binding-event
  "Constructor.

  Constructs a new SSLSessionBindingEvent.

  session - the SSLSession acting as the source of the event - `javax.net.ssl.SSLSession`
  name - the name to which the object is being bound or unbound - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if session is null."
  ([^javax.net.ssl.SSLSession session ^java.lang.String name]
    (new SSLSessionBindingEvent session name)))

(defn get-name
  "Returns the name to which the object is being bound, or the name
   from which the object is being unbound.

  returns: the name to which the object is being bound or unbound - `java.lang.String`"
  ([^javax.net.ssl.SSLSessionBindingEvent this]
    (-> this (.getName))))

(defn get-session
  "Returns the SSLSession into which the listener is being bound or
   from which the listener is being unbound.

  returns: the SSLSession - `javax.net.ssl.SSLSession`"
  ([^javax.net.ssl.SSLSessionBindingEvent this]
    (-> this (.getSession))))

