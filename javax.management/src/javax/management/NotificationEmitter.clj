(ns javax.management.NotificationEmitter
  "Interface implemented by an MBean that emits Notifications. It
  allows a listener to be registered with the MBean as a notification
  listener.

  Notification dispatch

 When an MBean emits a notification, it considers each listener that has been
  added with addNotificationListener and not
  subsequently removed with removeNotificationListener.
  If a filter was provided with that listener, and if the filter's
  isNotificationEnabled method returns
  false, the listener is ignored.  Otherwise, the listener's
  handleNotification method is called with
  the notification, as well as the handback object that was provided to
  addNotificationListener.

  If the same listener is added more than once, it is considered as many times as it was
  added.  It is often useful to add the same listener with different filters or handback
  objects.

  Implementations of this interface can differ regarding the thread in which the methods
  of filters and listeners are called.

  If the method call of a filter or listener throws an Exception, then that
  exception should not prevent other listeners from being invoked.  However, if the method
  call throws an Error, then it is recommended that processing of the notification
  stop at that point, and if it is possible to propagate the Error to the sender of
  the notification, this should be done.

  This interface should be used by new code in preference to the
  NotificationBroadcaster interface.

  Implementations of this interface and of NotificationBroadcaster
  should be careful about synchronization.  In particular, it is not a good
  idea for an implementation to hold any locks while it is calling a
  listener.  To deal with the possibility that the list of listeners might
  change while a notification is being dispatched, a good strategy is to
  use a CopyOnWriteArrayList for this list."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management NotificationEmitter]))

(defn remove-notification-listener
  "Removes a listener from this MBean.  The MBean must have a
   listener that exactly matches the given listener,
   filter, and handback parameters.  If
   there is more than one such listener, only one is removed.

   The filter and handback parameters
   may be null if and only if they are null in a listener to be
   removed.

  listener - A listener that was previously added to this MBean. - `javax.management.NotificationListener`
  filter - The filter that was specified when the listener was added. - `javax.management.NotificationFilter`
  handback - The handback that was specified when the listener was added. - `java.lang.Object`

  throws: javax.management.ListenerNotFoundException - The listener is not registered with the MBean, or it is not registered with the given filter and handback."
  ([^NotificationEmitter this ^javax.management.NotificationListener listener ^javax.management.NotificationFilter filter ^java.lang.Object handback]
    (-> this (.removeNotificationListener listener filter handback))))

