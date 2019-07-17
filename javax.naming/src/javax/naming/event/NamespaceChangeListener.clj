(ns javax.naming.event.NamespaceChangeListener
  "Specifies the methods that a listener interested in namespace changes
  must implement.
  Specifically, the listener is interested in NamingEvents
  with event types of OBJECT_ADDED, OBJECT_RENAMED, or
  OBJECT_REMOVED.

  Such a listener must:

 Implement this interface and its methods.
 Implement NamingListener.namingExceptionThrown() so that
  it will be notified of exceptions thrown while attempting to
  collect information about the events.
 Register with the source using the source's addNamingListener()
     method.

  A listener that wants to be notified of OBJECT_CHANGED event types
  should also implement the ObjectChangeListener
  interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.event NamespaceChangeListener]))

(defn object-added
  "Called when an object has been added.

   The binding of the newly added object can be obtained using
   evt.getNewBinding().

  evt - The nonnull event. - `javax.naming.event.NamingEvent`"
  ([^. this ^javax.naming.event.NamingEvent evt]
    (-> this (.objectAdded evt))))

(defn object-removed
  "Called when an object has been removed.

   The binding of the newly removed object can be obtained using
   evt.getOldBinding().

  evt - The nonnull event. - `javax.naming.event.NamingEvent`"
  ([^. this ^javax.naming.event.NamingEvent evt]
    (-> this (.objectRemoved evt))))

(defn object-renamed
  "Called when an object has been renamed.

   The binding of the renamed object can be obtained using
   evt.getNewBinding(). Its old binding (before the rename)
   can be obtained using evt.getOldBinding().
   One of these may be null if the old/new binding was outside the
   scope in which the listener has registered interest.

  evt - The nonnull event. - `javax.naming.event.NamingEvent`"
  ([^. this ^javax.naming.event.NamingEvent evt]
    (-> this (.objectRenamed evt))))

