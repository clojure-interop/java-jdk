(ns javax.naming.event.NamingExceptionEvent
  "This class represents an event fired when the procedures/processes
  used to collect information for notifying listeners of
  NamingEvents threw a NamingException.
  This can happen, for example, if the server which the listener is using
  aborts subsequent to the addNamingListener() call."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.event NamingExceptionEvent]))

(defn ->naming-exception-event
  "Constructor.

  Constructs an instance of NamingExceptionEvent using
   the context in which the NamingException was thrown and the exception
   that was thrown.

  source - The non-null context in which the exception was thrown. - `javax.naming.event.EventContext`
  exc - The non-null NamingException that was thrown. - `javax.naming.NamingException`"
  ([^javax.naming.event.EventContext source ^javax.naming.NamingException exc]
    (new NamingExceptionEvent source exc)))

(defn get-exception
  "Retrieves the exception that was thrown.

  returns: The exception that was thrown. - `javax.naming.NamingException`"
  (^javax.naming.NamingException [^javax.naming.event.NamingExceptionEvent this]
    (-> this (.getException))))

(defn get-event-context
  "Retrieves the EventContext that fired this event.
   This returns the same object as EventObject.getSource().

  returns: The non-null EventContext that fired this event. - `javax.naming.event.EventContext`"
  (^javax.naming.event.EventContext [^javax.naming.event.NamingExceptionEvent this]
    (-> this (.getEventContext))))

(defn dispatch
  "Invokes the namingExceptionThrown() method on
   a listener using this event.

  listener - The non-null naming listener on which to invoke the method. - `javax.naming.event.NamingListener`"
  ([^javax.naming.event.NamingExceptionEvent this ^javax.naming.event.NamingListener listener]
    (-> this (.dispatch listener))))

