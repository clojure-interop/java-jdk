(ns javax.naming.event.ObjectChangeListener
  "Specifies the method that a listener of a NamingEvent
  with event type of OBJECT_CHANGED must implement.

  An OBJECT_CHANGED event type is fired when (the contents of)
  an object has changed. This might mean that its attributes have been modified,
  added, or removed, and/or that the object itself has been replaced.
  How the object has changed can be determined by examining the
  NamingEvent's old and new bindings.

  A listener interested in OBJECT_CHANGED event types must:


 Implement this interface and its method (objectChanged())
 Implement NamingListener.namingExceptionThrown() so that
  it will be notified of exceptions thrown while attempting to
  collect information about the events.
 Register with the source using the source's addNamingListener()
     method.

  A listener that wants to be notified of namespace change events
  should also implement the NamespaceChangeListener
  interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.event ObjectChangeListener]))

(defn object-changed
  "Called when an object has been changed.

   The binding of the changed object can be obtained using
   evt.getNewBinding(). Its old binding (before the change)
   can be obtained using evt.getOldBinding().

  evt - The nonnull naming event. - `javax.naming.event.NamingEvent`"
  ([^ObjectChangeListener this ^javax.naming.event.NamingEvent evt]
    (-> this (.objectChanged evt))))

