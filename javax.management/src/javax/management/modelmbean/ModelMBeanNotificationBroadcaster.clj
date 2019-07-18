(ns javax.management.modelmbean.ModelMBeanNotificationBroadcaster
  "This interface must be implemented by the ModelMBeans. An implementation of this interface
  must be shipped with every JMX Agent.

  Java resources wishing to be manageable instantiate the ModelMBean using the MBeanServer's
  createMBean method.  The resource then sets the ModelMBeanInfo (with Descriptors) for the ModelMBean
  instance. The attributes and operations exposed via the ModelMBeanInfo for the ModelMBean are accessible
  from MBeans, connectors/adaptors like other MBeans. Through the ModelMBeanInfo Descriptors, values and methods in
  the managed application can be defined and mapped to attributes and operations of the ModelMBean.
  This mapping can be defined during development in an XML formatted file or dynamically and
  programmatically at runtime.

  Every ModelMBean which is instantiated in the MBeanServer becomes manageable:
  its attributes and operations
  become remotely accessible through the connectors/adaptors connected to that MBeanServer.
  A Java object cannot be registered in the MBeanServer unless it is a JMX compliant MBean.
  By instantiating a ModelMBean, resources are guaranteed that the MBean is valid.

  MBeanException and RuntimeOperationsException must be thrown on every public method.  This allows
  for wrapping exceptions from distributed communications (RMI, EJB, etc.).  These exceptions do
  not have to be thrown by the implementation except in the scenarios described in the specification
  and javadoc."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.modelmbean ModelMBeanNotificationBroadcaster]))

(defn send-notification
  "Sends a Notification which is passed in to the registered
   Notification listeners on the ModelMBean as a
   jmx.modelmbean.generic notification.

  ntfy-obj - The notification which is to be passed to the 'handleNotification' method of the listener object. - `javax.management.Notification`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  ([^ModelMBeanNotificationBroadcaster this ^javax.management.Notification ntfy-obj]
    (-> this (.sendNotification ntfy-obj))))

(defn send-attribute-change-notification
  "Sends an attributeChangeNotification which contains the old value and new value for the
   attribute to the registered AttributeChangeNotification listeners on the ModelMBean.

  old-value - The original value for the Attribute - `javax.management.Attribute`
  new-value - The current value for the Attribute The constructed attributeChangeNotification will be: type `jmx.attribute.change` source this ModelMBean instance sequence 1 attributeName oldValue.getName() attributeType oldValue's class attributeOldValue oldValue.getValue() attributeNewValue newValue.getValue() - `javax.management.Attribute`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  ([^ModelMBeanNotificationBroadcaster this ^javax.management.Attribute old-value ^javax.management.Attribute new-value]
    (-> this (.sendAttributeChangeNotification old-value new-value)))
  ([^ModelMBeanNotificationBroadcaster this ^javax.management.AttributeChangeNotification notification]
    (-> this (.sendAttributeChangeNotification notification))))

(defn add-attribute-change-notification-listener
  "Registers an object which implements the NotificationListener interface as a listener.  This
   object's 'handleNotification()' method will be invoked when any attributeChangeNotification is issued through
   or by the ModelMBean.  This does not include other Notifications.  They must be registered
   for independently. An AttributeChangeNotification will be generated for this attributeName.

  listener - The listener object which will handles notifications emitted by the registered MBean. - `javax.management.NotificationListener`
  attribute-name - The name of the ModelMBean attribute for which to receive change notifications. If null, then all attribute changes will cause an attributeChangeNotification to be issued. - `java.lang.String`
  handback - The context to be sent to the listener with the notification when a notification is emitted. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - The listener cannot be null."
  ([^ModelMBeanNotificationBroadcaster this ^javax.management.NotificationListener listener ^java.lang.String attribute-name ^java.lang.Object handback]
    (-> this (.addAttributeChangeNotificationListener listener attribute-name handback))))

(defn remove-attribute-change-notification-listener
  "Removes a listener for attributeChangeNotifications from the RequiredModelMBean.

  listener - The listener name which was handling notifications emitted by the registered MBean. This method will remove all information related to this listener. - `javax.management.NotificationListener`
  attribute-name - The attribute for which the listener no longer wants to receive attributeChangeNotifications. If null the listener will be removed for all attributeChangeNotifications. - `java.lang.String`

  throws: javax.management.ListenerNotFoundException - The listener is not registered in the MBean or is null."
  ([^ModelMBeanNotificationBroadcaster this ^javax.management.NotificationListener listener ^java.lang.String attribute-name]
    (-> this (.removeAttributeChangeNotificationListener listener attribute-name))))

