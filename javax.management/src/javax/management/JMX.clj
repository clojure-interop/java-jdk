(ns javax.management.JMX
  "Static methods from the JMX API.  There are no instances of this class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management JMX]))

(def *-default-value-field
  "Static Constant.

  The name of the defaultValue field.

  type: java.lang.String"
  JMX/DEFAULT_VALUE_FIELD)

(def *-immutable-info-field
  "Static Constant.

  The name of the immutableInfo field.

  type: java.lang.String"
  JMX/IMMUTABLE_INFO_FIELD)

(def *-interface-class-name-field
  "Static Constant.

  The name of the interfaceClassName field.

  type: java.lang.String"
  JMX/INTERFACE_CLASS_NAME_FIELD)

(def *-legal-values-field
  "Static Constant.

  The name of the legalValues field.

  type: java.lang.String"
  JMX/LEGAL_VALUES_FIELD)

(def *-max-value-field
  "Static Constant.

  The name of the maxValue field.

  type: java.lang.String"
  JMX/MAX_VALUE_FIELD)

(def *-min-value-field
  "Static Constant.

  The name of the minValue field.

  type: java.lang.String"
  JMX/MIN_VALUE_FIELD)

(def *-mxbean-field
  "Static Constant.

  The name of the mxbean field.

  type: java.lang.String"
  JMX/MXBEAN_FIELD)

(def *-open-type-field
  "Static Constant.

  The name of the openType field.

  type: java.lang.String"
  JMX/OPEN_TYPE_FIELD)

(def *-original-type-field
  "Static Constant.

  The name of the originalType field.

  type: java.lang.String"
  JMX/ORIGINAL_TYPE_FIELD)

(defn *new-m-bean-proxy
  "Make a proxy for a Standard MBean in a local or remote MBean
   Server that may also support the methods of NotificationEmitter.

   This method behaves the same as newMBeanProxy(MBeanServerConnection, ObjectName, Class), but
   additionally, if notificationEmitter is true, then the MBean is assumed to be a NotificationBroadcaster or NotificationEmitter and the
   returned proxy will implement NotificationEmitter as
   well as interfaceClass.  A call to NotificationBroadcaster.addNotificationListener(javax.management.NotificationListener, javax.management.NotificationFilter, java.lang.Object) on the proxy
   will result in a call to MBeanServerConnection.addNotificationListener(ObjectName,
   NotificationListener, NotificationFilter, Object), and
   likewise for the other methods of NotificationBroadcaster and NotificationEmitter.

  connection - the MBean server to forward to. - `javax.management.MBeanServerConnection`
  object-name - the name of the MBean within connection to forward to. - `javax.management.ObjectName`
  interface-class - the management interface that the MBean exports, which will also be implemented by the returned proxy. - `java.lang.Class<T>`
  notification-emitter - make the returned proxy implement NotificationEmitter by forwarding its methods via connection. - `boolean`

  returns: the new proxy instance. - `<T> T`

  throws: java.lang.IllegalArgumentException - if interfaceClass is not a compliant MBean interface"
  ([^javax.management.MBeanServerConnection connection ^javax.management.ObjectName object-name ^java.lang.Class interface-class ^Boolean notification-emitter]
    (JMX/newMBeanProxy connection object-name interface-class notification-emitter))
  ([^javax.management.MBeanServerConnection connection ^javax.management.ObjectName object-name ^java.lang.Class interface-class]
    (JMX/newMBeanProxy connection object-name interface-class)))

(defn *new-mx-bean-proxy
  "Make a proxy for an MXBean in a local or remote MBean
   Server that may also support the methods of NotificationEmitter.

   This method behaves the same as newMXBeanProxy(MBeanServerConnection, ObjectName, Class), but
   additionally, if notificationEmitter is true, then the MXBean is assumed to be a NotificationBroadcaster or NotificationEmitter and the
   returned proxy will implement NotificationEmitter as
   well as interfaceClass.  A call to NotificationBroadcaster.addNotificationListener(javax.management.NotificationListener, javax.management.NotificationFilter, java.lang.Object) on the proxy
   will result in a call to MBeanServerConnection.addNotificationListener(ObjectName,
   NotificationListener, NotificationFilter, Object), and
   likewise for the other methods of NotificationBroadcaster and NotificationEmitter.

  connection - the MBean server to forward to. - `javax.management.MBeanServerConnection`
  object-name - the name of the MBean within connection to forward to. - `javax.management.ObjectName`
  interface-class - the MXBean interface, which will also be implemented by the returned proxy. - `java.lang.Class<T>`
  notification-emitter - make the returned proxy implement NotificationEmitter by forwarding its methods via connection. - `boolean`

  returns: the new proxy instance. - `<T> T`

  throws: java.lang.IllegalArgumentException - if interfaceClass is not a compliant MXBean interface"
  ([^javax.management.MBeanServerConnection connection ^javax.management.ObjectName object-name ^java.lang.Class interface-class ^Boolean notification-emitter]
    (JMX/newMXBeanProxy connection object-name interface-class notification-emitter))
  ([^javax.management.MBeanServerConnection connection ^javax.management.ObjectName object-name ^java.lang.Class interface-class]
    (JMX/newMXBeanProxy connection object-name interface-class)))

(defn *mx-bean-interface?
  "Test whether an interface is an MXBean interface.
   An interface is an MXBean interface if it is public,
   annotated @MXBean or @MXBean(true)
   or if it does not have an @MXBean annotation
   and its name ends with `MXBean`.

  interface-class - The candidate interface. - `java.lang.Class<?>`

  returns: true if interfaceClass is a
   compliant MXBean interface - `boolean`

  throws: java.lang.NullPointerException - if interfaceClass is null."
  (^Boolean [^java.lang.Class interface-class]
    (JMX/isMXBeanInterface interface-class)))

