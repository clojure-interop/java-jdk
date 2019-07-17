(ns jdk.nio.file.Watchable
  "An object that may be registered with a watch service so that it can be
  watched for changes and events.

   This interface defines the register method to register
  the object with a WatchService returning a WatchKey to
  represent the registration. An object may be registered with more than one
  watch service. Registration with a watch service is cancelled by invoking the
  key's cancel method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file Watchable]))

(defn register
  "Registers an object with a watch service.

    If the file system object identified by this object is currently
   registered with the watch service then the watch key, representing that
   registration, is returned after changing the event set or modifiers to
   those specified by the events and modifiers parameters.
   Changing the event set does not cause pending events for the object to be
   discarded. Objects are automatically registered for the OVERFLOW event. This event is not
   required to be present in the array of events.

    Otherwise the file system object has not yet been registered with the
   given watch service, so it is registered and the resulting new key is
   returned.

    Implementations of this interface should specify the events they
   support.

  watcher - the watch service to which this object is to be registered - `java.nio.file.WatchService`
  events - the events for which this object should be registered - `java.nio.file.WatchEvent.Kind<?>[]`
  modifiers - the modifiers, if any, that modify how the object is registered - `java.nio.file.WatchEvent.Modifier`

  returns: a key representing the registration of this object with the
            given watch service - `java.nio.file.WatchKey`

  throws: java.lang.UnsupportedOperationException - if unsupported events or modifiers are specified"
  ([^. this ^java.nio.file.WatchService watcher ^java.nio.file.WatchEvent.Kind[] events ^java.nio.file.WatchEvent.Modifier modifiers]
    (-> this (.register watcher events modifiers)))
  ([^. this ^java.nio.file.WatchService watcher ^java.nio.file.WatchEvent.Kind events]
    (-> this (.register watcher events))))

