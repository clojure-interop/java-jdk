(ns javax.management.NotificationBroadcaster
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

  New code should use the NotificationEmitter interface
  instead.

  Implementations of this interface and of NotificationEmitter
  should be careful about synchronization.  In particular, it is not a good
  idea for an implementation to hold any locks while it is calling a
  listener.  To deal with the possibility that the list of listeners might
  change while a notification is being dispatched, a good strategy is to
  use a CopyOnWriteArrayList for this list."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management NotificationBroadcaster]))

(defn add-notification-listener
  "Adds a listener to this MBean.

  listener - The listener object which will handle the notifications emitted by the broadcaster. - `javax.management.NotificationListener`
  filter - The filter object. If filter is null, no filtering will be performed before handling notifications. - `javax.management.NotificationFilter`
  handback - An opaque object to be sent back to the listener when a notification is emitted. This object cannot be used by the Notification broadcaster object. It should be resent unchanged with the notification to the listener. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - Listener parameter is null."
  ([^. this ^javax.management.NotificationListener listener ^javax.management.NotificationFilter filter ^java.lang.Object handback]
    (-> this (.addNotificationListener listener filter handback))))

(defn remove-notification-listener
  "Removes a listener from this MBean.  If the listener
   has been registered with different handback objects or
   notification filters, all entries corresponding to the listener
   will be removed.

  listener - A listener that was previously added to this MBean. - `javax.management.NotificationListener`

  throws: javax.management.ListenerNotFoundException - The listener is not registered with the MBean."
  ([^. this ^javax.management.NotificationListener listener]
    (-> this (.removeNotificationListener listener))))

(defn get-notification-info
  "Returns an array indicating, for each notification this
   MBean may send, the name of the Java class of the notification
   and the notification type.

   It is not illegal for the MBean to send notifications not
   described in this array.  However, some clients of the MBean
   server may depend on the array being complete for their correct
   functioning.

  returns: the array of possible notifications. - `javax.management.MBeanNotificationInfo[]`"
  ([^. this]
    (-> this (.getNotificationInfo))))

