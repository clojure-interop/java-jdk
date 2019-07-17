(ns javax.management.MBeanServerDelegate
  "Represents  the MBean server from the management point of view.
  The MBeanServerDelegate MBean emits the MBeanServerNotifications when
  an MBean is registered/unregistered in the MBean server."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management MBeanServerDelegate]))

(defn ->m-bean-server-delegate
  "Constructor.

  Create a MBeanServerDelegate object."
  ([]
    (new MBeanServerDelegate )))

(def *-delegate-name
  "Static Constant.

  Defines the default ObjectName of the MBeanServerDelegate.

  type: javax.management.ObjectName"
  MBeanServerDelegate/DELEGATE_NAME)

(defn get-notification-info
  "Description copied from interface: NotificationBroadcaster

  returns: the array of possible notifications. - `javax.management.MBeanNotificationInfo[]`"
  ([^javax.management.MBeanServerDelegate this]
    (-> this (.getNotificationInfo))))

(defn remove-notification-listener
  "Description copied from interface: NotificationEmitter

  listener - A listener that was previously added to this MBean. - `javax.management.NotificationListener`
  filter - The filter that was specified when the listener was added. - `javax.management.NotificationFilter`
  handback - The handback that was specified when the listener was added. - `java.lang.Object`

  throws: javax.management.ListenerNotFoundException - The listener is not registered with the MBean, or it is not registered with the given filter and handback."
  ([^javax.management.MBeanServerDelegate this ^javax.management.NotificationListener listener ^javax.management.NotificationFilter filter ^java.lang.Object handback]
    (-> this (.removeNotificationListener listener filter handback)))
  ([^javax.management.MBeanServerDelegate this ^javax.management.NotificationListener listener]
    (-> this (.removeNotificationListener listener))))

(defn get-m-bean-server-id
  "Returns the MBean server agent identity.

  returns: the identity. - `java.lang.String`"
  ([^javax.management.MBeanServerDelegate this]
    (-> this (.getMBeanServerId))))

(defn get-implementation-version
  "Returns the JMX implementation version (the version of this product).

  returns: the implementation version. - `java.lang.String`"
  ([^javax.management.MBeanServerDelegate this]
    (-> this (.getImplementationVersion))))

(defn get-implementation-vendor
  "Returns the JMX implementation vendor (the vendor of this product).

  returns: the implementation vendor. - `java.lang.String`"
  ([^javax.management.MBeanServerDelegate this]
    (-> this (.getImplementationVendor))))

(defn get-specification-vendor
  "Returns the vendor of the JMX specification implemented
   by this product.

  returns: the specification vendor. - `java.lang.String`"
  ([^javax.management.MBeanServerDelegate this]
    (-> this (.getSpecificationVendor))))

(defn add-notification-listener
  "Description copied from interface: NotificationBroadcaster

  listener - The listener object which will handle the notifications emitted by the broadcaster. - `javax.management.NotificationListener`
  filter - The filter object. If filter is null, no filtering will be performed before handling notifications. - `javax.management.NotificationFilter`
  handback - An opaque object to be sent back to the listener when a notification is emitted. This object cannot be used by the Notification broadcaster object. It should be resent unchanged with the notification to the listener. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - Listener parameter is null."
  ([^javax.management.MBeanServerDelegate this ^javax.management.NotificationListener listener ^javax.management.NotificationFilter filter ^java.lang.Object handback]
    (-> this (.addNotificationListener listener filter handback))))

(defn send-notification
  "Enables the MBean server to send a notification.
   If the passed notification has a sequence number lesser
   or equal to 0, then replace it with the delegate's own sequence
   number.

  notification - The notification to send. - `javax.management.Notification`"
  ([^javax.management.MBeanServerDelegate this ^javax.management.Notification notification]
    (-> this (.sendNotification notification))))

(defn get-specification-version
  "Returns the version of the JMX specification implemented
   by this product.

  returns: the specification version. - `java.lang.String`"
  ([^javax.management.MBeanServerDelegate this]
    (-> this (.getSpecificationVersion))))

(defn get-implementation-name
  "Returns the JMX implementation name (the name of this product).

  returns: the implementation name. - `java.lang.String`"
  ([^javax.management.MBeanServerDelegate this]
    (-> this (.getImplementationName))))

(defn get-specification-name
  "Returns the full name of the JMX specification implemented
   by this product.

  returns: the specification name. - `java.lang.String`"
  ([^javax.management.MBeanServerDelegate this]
    (-> this (.getSpecificationName))))

