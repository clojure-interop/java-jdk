(ns javax.management.NotificationBroadcasterSupport
  "Provides an implementation of NotificationEmitter
  interface.  This can be used as the super class of an MBean that
  sends notifications.

  By default, the notification dispatch model is synchronous.
  That is, when a thread calls sendNotification, the
  NotificationListener.handleNotification method of each listener
  is called within that thread. You can override this default
  by overriding handleNotification in a subclass, or by passing an
  Executor to the constructor.

  If the method call of a filter or listener throws an Exception,
  then that exception does not prevent other listeners from being invoked.  However,
  if the method call of a filter or of Executor.execute or of
  handleNotification (when no Excecutor is specified) throws an
  Error, then that Error is propagated to the caller of
  sendNotification.

  Remote listeners added using the JMX Remote API (see JMXConnector) are not
  usually called synchronously.  That is, when sendNotification returns, it is
  not guaranteed that any remote listeners have yet received the notification."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management NotificationBroadcasterSupport]))

(defn ->notification-broadcaster-support
  "Constructor.

  Constructs a NotificationBroadcasterSupport with information about the notifications that may be sent,
   and where each listener is invoked using the given Executor.

   When sendNotification is called, a
   listener is selected if it was added with a null NotificationFilter, or if isNotificationEnabled
   returns true for the notification being sent. The call to
   NotificationFilter.isNotificationEnabled takes
   place in the thread that called
   sendNotification. Then, for each selected
   listener, executor.execute is called
   with a command that calls the handleNotification
   method.

   If the info array is not empty, then it is
   cloned by the constructor as if by info.clone(), and
   each call to getNotificationInfo() returns a new
   clone.

  executor - an executor used by the method sendNotification to send each notification. If it is null, the thread calling sendNotification will invoke the handleNotification method itself. - `java.util.concurrent.Executor`
  info - an array indicating, for each notification this MBean may send, the name of the Java class of the notification and the notification type. Can be null, which is equivalent to an empty array. - `javax.management.MBeanNotificationInfo`"
  ([^java.util.concurrent.Executor executor ^javax.management.MBeanNotificationInfo info]
    (new NotificationBroadcasterSupport executor info))
  ([^java.util.concurrent.Executor executor]
    (new NotificationBroadcasterSupport executor))
  ([]
    (new NotificationBroadcasterSupport )))

(defn add-notification-listener
  "Adds a listener.

  listener - The listener to receive notifications. - `javax.management.NotificationListener`
  filter - The filter object. If filter is null, no filtering will be performed before handling notifications. - `javax.management.NotificationFilter`
  handback - An opaque object to be sent back to the listener when a notification is emitted. This object cannot be used by the Notification broadcaster object. It should be resent unchanged with the notification to the listener. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - thrown if the listener is null."
  ([^javax.management.NotificationBroadcasterSupport this ^javax.management.NotificationListener listener ^javax.management.NotificationFilter filter ^java.lang.Object handback]
    (-> this (.addNotificationListener listener filter handback))))

(defn remove-notification-listener
  "Description copied from interface: NotificationEmitter

  listener - A listener that was previously added to this MBean. - `javax.management.NotificationListener`
  filter - The filter that was specified when the listener was added. - `javax.management.NotificationFilter`
  handback - The handback that was specified when the listener was added. - `java.lang.Object`

  throws: javax.management.ListenerNotFoundException - The listener is not registered with the MBean, or it is not registered with the given filter and handback."
  ([^javax.management.NotificationBroadcasterSupport this ^javax.management.NotificationListener listener ^javax.management.NotificationFilter filter ^java.lang.Object handback]
    (-> this (.removeNotificationListener listener filter handback)))
  ([^javax.management.NotificationBroadcasterSupport this ^javax.management.NotificationListener listener]
    (-> this (.removeNotificationListener listener))))

(defn get-notification-info
  "Description copied from interface: NotificationBroadcaster

  returns: the array of possible notifications. - `javax.management.MBeanNotificationInfo[]`"
  ([^javax.management.NotificationBroadcasterSupport this]
    (-> this (.getNotificationInfo))))

(defn send-notification
  "Sends a notification.

   If an Executor was specified in the constructor, it will be given one
   task per selected listener to deliver the notification to that listener.

  notification - The notification to send. - `javax.management.Notification`"
  ([^javax.management.NotificationBroadcasterSupport this ^javax.management.Notification notification]
    (-> this (.sendNotification notification))))

