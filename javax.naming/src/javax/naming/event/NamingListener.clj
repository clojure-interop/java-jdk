(ns javax.naming.event.NamingListener
  "This interface is the root of listener interfaces that
  handle NamingEvents.
  It does not make sense for a listener to implement just this interface.
  A listener typically implements a subinterface of NamingListener,
  such as ObjectChangeListener or NamespaceChangeListener.

  This interface contains a single method, namingExceptionThrown(),
  that must be implemented so that the listener can be notified of
  exceptions that are thrown (by the service provider) while gathering
  information about the events that they're interested in.
  When this method is invoked, the listener has been automatically deregistered
  from the EventContext with which it has registered.

  For example, suppose a listener implements ObjectChangeListener and
  registers with a EventContext.
  Then, if the connection to the server is subsequently broken,
  the listener will receive a NamingExceptionEvent and may
  take some corrective action, such as notifying the user of the application."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.event NamingListener]))

(defn naming-exception-thrown
  "Called when a naming exception is thrown while attempting
   to fire a NamingEvent.

  evt - The nonnull event. - `javax.naming.event.NamingExceptionEvent`"
  ([this evt]
    (-> this (.namingExceptionThrown evt))))

