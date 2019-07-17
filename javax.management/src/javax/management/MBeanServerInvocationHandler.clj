(ns javax.management.MBeanServerInvocationHandler
  "InvocationHandler that forwards methods in an MBean's
  management interface through the MBean server to the MBean.

  Given an MBeanServerConnection, the ObjectName
  of an MBean within that MBean server, and a Java interface
  Intf that describes the management interface of the
  MBean using the patterns for a Standard MBean or an MXBean, this
  class can be used to construct a proxy for the MBean.  The proxy
  implements the interface Intf such that all of its
  methods are forwarded through the MBean server to the MBean.

  If the InvocationHandler is for an MXBean, then the parameters of
  a method are converted from the type declared in the MXBean
  interface into the corresponding mapped type, and the return value
  is converted from the mapped type into the declared type.  For
  example, with the method

  public List<String> reverse(List<String> list);

  and given that the mapped type for List<String> is String[], a call to proxy.reverse(someList) will convert
  someList from a List<String> to a String[],
  call the MBean operation reverse, then convert the returned
  String[] into a List<String>.

  The method Object.toString(), Object.hashCode(), or
  Object.equals(Object), when invoked on a proxy using this
  invocation handler, is forwarded to the MBean server as a method on
  the proxied MBean only if it appears in one of the proxy's
  interfaces.  For a proxy created with JMX.newMBeanProxy or JMX.newMXBeanProxy, this means that the method must appear in the
  Standard MBean or MXBean interface.  Otherwise these methods have
  the following behavior:

  toString() returns a string representation of the proxy
  hashCode() returns a hash code for the proxy such
  that two equal proxies have the same hash code
  equals(Object)
  returns true if and only if the Object argument is of the same
  proxy class as this proxy, with an MBeanServerInvocationHandler
  that has the same MBeanServerConnection and ObjectName; if one
  of the MBeanServerInvocationHandlers was constructed with
  a Class argument then the other must have been constructed
  with the same Class for equals to return true."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management MBeanServerInvocationHandler]))

(defn ->m-bean-server-invocation-handler
  "Constructor.

  Invocation handler that can forward methods through an MBean
   server to a Standard MBean or MXBean.  This constructor may be called
   instead of relying on JMX.newMXBeanProxy, for instance if you need to supply a
   different ClassLoader to Proxy.newProxyInstance.

  connection - the MBean server connection through which all methods of a proxy using this handler will be forwarded. - `javax.management.MBeanServerConnection`
  object-name - the name of the MBean within the MBean server to which methods will be forwarded. - `javax.management.ObjectName`
  is-mx-bean - if true, the proxy is for an MXBean, and appropriate mappings will be applied to method parameters and return values. - `boolean`"
  ([^javax.management.MBeanServerConnection connection ^javax.management.ObjectName object-name ^Boolean is-mx-bean]
    (new MBeanServerInvocationHandler connection object-name is-mx-bean))
  ([^javax.management.MBeanServerConnection connection ^javax.management.ObjectName object-name]
    (new MBeanServerInvocationHandler connection object-name)))

(defn *new-proxy-instance
  "Return a proxy that implements the given interface by
   forwarding its methods through the given MBean server to the
   named MBean.  As of 1.6, the methods JMX.newMBeanProxy(MBeanServerConnection, ObjectName, Class) and
   JMX.newMBeanProxy(MBeanServerConnection, ObjectName, Class,
   boolean) are preferred to this method.

   This method is equivalent to Proxy.newProxyInstance(interfaceClass.getClassLoader(),
   interfaces, handler).  Here handler is the
   result of new
   MBeanServerInvocationHandler(connection, objectName), and
   interfaces is an array that has one element if
   notificationBroadcaster is false and two if it is
   true.  The first element of interfaces is
   interfaceClass and the second, if present, is
   NotificationEmitter.class.

  connection - the MBean server to forward to. - `javax.management.MBeanServerConnection`
  object-name - the name of the MBean within connection to forward to. - `javax.management.ObjectName`
  interface-class - the management interface that the MBean exports, which will also be implemented by the returned proxy. - `java.lang.Class<T>`
  notification-broadcaster - make the returned proxy implement NotificationEmitter by forwarding its methods via connection. A call to NotificationBroadcaster.addNotificationListener(javax.management.NotificationListener, javax.management.NotificationFilter, java.lang.Object) on the proxy will result in a call to MBeanServerConnection.addNotificationListener(ObjectName, NotificationListener, NotificationFilter, Object), and likewise for the other methods of NotificationBroadcaster and NotificationEmitter. - `boolean`

  returns: the new proxy instance. - `<T> T`"
  ([^javax.management.MBeanServerConnection connection ^javax.management.ObjectName object-name ^java.lang.Class interface-class ^Boolean notification-broadcaster]
    (MBeanServerInvocationHandler/newProxyInstance connection object-name interface-class notification-broadcaster)))

(defn get-m-bean-server-connection
  "The MBean server connection through which the methods of
   a proxy using this handler are forwarded.

  returns: the MBean server connection. - `javax.management.MBeanServerConnection`"
  (^javax.management.MBeanServerConnection [^javax.management.MBeanServerInvocationHandler this]
    (-> this (.getMBeanServerConnection))))

(defn get-object-name
  "The name of the MBean within the MBean server to which methods
   are forwarded.

  returns: the object name. - `javax.management.ObjectName`"
  (^javax.management.ObjectName [^javax.management.MBeanServerInvocationHandler this]
    (-> this (.getObjectName))))

(defn mx-bean?
  "If true, the proxy is for an MXBean, and appropriate mappings
   are applied to method parameters and return values.

  returns: whether the proxy is for an MXBean. - `boolean`"
  (^Boolean [^javax.management.MBeanServerInvocationHandler this]
    (-> this (.isMXBean))))

(defn invoke
  "Description copied from interface: InvocationHandler

  proxy - the proxy instance that the method was invoked on - `java.lang.Object`
  method - the Method instance corresponding to the interface method invoked on the proxy instance. The declaring class of the Method object will be the interface that the method was declared in, which may be a superinterface of the proxy interface that the proxy class inherits the method through. - `java.lang.reflect.Method`
  args - an array of objects containing the values of the arguments passed in the method invocation on the proxy instance, or null if interface method takes no arguments. Arguments of primitive types are wrapped in instances of the appropriate primitive wrapper class, such as java.lang.Integer or java.lang.Boolean. - `java.lang.Object[]`

  returns: the value to return from the method invocation on the
   proxy instance.  If the declared return type of the interface
   method is a primitive type, then the value returned by
   this method must be an instance of the corresponding primitive
   wrapper class; otherwise, it must be a type assignable to the
   declared return type.  If the value returned by this method is
   null and the interface method's return type is
   primitive, then a NullPointerException will be
   thrown by the method invocation on the proxy instance.  If the
   value returned by this method is otherwise not compatible with
   the interface method's declared return type as described above,
   a ClassCastException will be thrown by the method
   invocation on the proxy instance. - `java.lang.Object`

  throws: java.lang.Throwable - the exception to throw from the method invocation on the proxy instance. The exception's type must be assignable either to any of the exception types declared in the throws clause of the interface method or to the unchecked exception types java.lang.RuntimeException or java.lang.Error. If a checked exception is thrown by this method that is not assignable to any of the exception types declared in the throws clause of the interface method, then an UndeclaredThrowableException containing the exception that was thrown by this method will be thrown by the method invocation on the proxy instance."
  (^java.lang.Object [^javax.management.MBeanServerInvocationHandler this ^java.lang.Object proxy ^java.lang.reflect.Method method args]
    (-> this (.invoke proxy method args))))

