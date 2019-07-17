(ns javax.management.StandardEmitterMBean
  "An MBean whose management interface is determined by reflection
  on a Java interface, and that emits notifications.

  The following example shows how to use the public constructor
  StandardEmitterMBean(implementation, mbeanInterface, emitter) to
  create an MBean emitting notifications with any
  implementation class name Impl, with a management
  interface defined (as for current Standard MBeans) by any interface
  Intf, and with any implementation of the interface
  NotificationEmitter. The example uses the class
  NotificationBroadcasterSupport as an implementation
  of the interface NotificationEmitter.



      MBeanServer mbs;
      ...
      final String[] types = new String[] {`sun.disc.space`,`sun.disc.alarm`};
      final MBeanNotificationInfo info = new MBeanNotificationInfo(
                                           types,
                                           Notification.class.getName(),
                                           `Notification about disc info.`);
      final NotificationEmitter emitter =
                     new NotificationBroadcasterSupport(info);

      final Intf impl = new Impl(...);
      final Object mbean = new StandardEmitterMBean(
                                      impl, Intf.class, emitter);
      mbs.registerMBean(mbean, objectName);"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management StandardEmitterMBean]))

(defn ->standard-emitter-m-bean
  "Constructor.

  Make an MBean whose management interface is specified by
   mbeanInterface, with the given implementation and where
   notifications are handled by the given NotificationEmitter.  This constructor can be used to make
   either Standard MBeans or MXBeans.  The resultant MBean
   implements the NotificationEmitter interface by
   forwarding its methods to emitter.  It is legal and
   useful for implementation and emitter to be the
   same object.

   If emitter is an instance of NotificationBroadcasterSupport then the MBean's sendNotification method will call emitter.sendNotification.

   The array returned by getNotificationInfo() on the
   new MBean is a copy of the array returned by
   emitter.getNotificationInfo() at the time of construction.  If the array
   returned by emitter.getNotificationInfo() later changes,
   that will have no effect on this object's
   getNotificationInfo().

  implementation - the implementation of the MBean interface. - `T`
  mbean-interface - a Standard MBean interface. - `java.lang.Class<T>`
  is-mx-bean - If true, the mbeanInterface parameter names an MXBean interface and the resultant MBean is an MXBean. - `boolean`
  emitter - the object that will handle notifications. - `javax.management.NotificationEmitter`

  throws: java.lang.IllegalArgumentException - if the mbeanInterface does not follow JMX design patterns for Management Interfaces, or if the given implementation does not implement the specified interface, or if emitter is null."
  ([implementation mbean-interface is-mx-bean emitter]
    (new StandardEmitterMBean implementation mbean-interface is-mx-bean emitter))
  ([implementation mbean-interface emitter]
    (new StandardEmitterMBean implementation mbean-interface emitter)))

(defn remove-notification-listener
  "Description copied from interface: NotificationEmitter

  listener - A listener that was previously added to this MBean. - `javax.management.NotificationListener`
  filter - The filter that was specified when the listener was added. - `javax.management.NotificationFilter`
  handback - The handback that was specified when the listener was added. - `java.lang.Object`

  throws: javax.management.ListenerNotFoundException - The listener is not registered with the MBean, or it is not registered with the given filter and handback."
  ([this listener filter handback]
    (-> this (.removeNotificationListener listener filter handback)))
  ([this listener]
    (-> this (.removeNotificationListener listener))))

(defn add-notification-listener
  "Description copied from interface: NotificationBroadcaster

  listener - The listener object which will handle the notifications emitted by the broadcaster. - `javax.management.NotificationListener`
  filter - The filter object. If filter is null, no filtering will be performed before handling notifications. - `javax.management.NotificationFilter`
  handback - An opaque object to be sent back to the listener when a notification is emitted. This object cannot be used by the Notification broadcaster object. It should be resent unchanged with the notification to the listener. - `java.lang.Object`"
  ([this listener filter handback]
    (-> this (.addNotificationListener listener filter handback))))

(defn get-notification-info
  "Description copied from interface: NotificationBroadcaster

  returns: the array of possible notifications. - `javax.management.MBeanNotificationInfo[]`"
  ([this]
    (-> this (.getNotificationInfo))))

(defn send-notification
  "Sends a notification.

   If the emitter parameter to the constructor was an
   instance of NotificationBroadcasterSupport then this
   method will call emitter.sendNotification.

  n - the notification to send. - `javax.management.Notification`

  throws: java.lang.ClassCastException - if the emitter parameter to the constructor was not a NotificationBroadcasterSupport."
  ([this n]
    (-> this (.sendNotification n))))

