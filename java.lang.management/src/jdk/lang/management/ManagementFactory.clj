(ns jdk.lang.management.ManagementFactory
  "The ManagementFactory class is a factory class for getting
  managed beans for the Java platform.
  This class consists of static methods each of which returns
  one or more platform MXBeans representing
  the management interface of a component of the Java virtual
  machine.

  Platform MXBeans

  A platform MXBean is a managed bean that
  conforms to the JMX
  Instrumentation Specification and only uses a set of basic data types.
  A JMX management application and the platform MBeanServer
  can interoperate without requiring classes for MXBean specific
  data types.
  The data types being transmitted between the JMX connector
  server and the connector client are
  javax.management.openmbean.open types
  and this allows interoperation across versions.
  See
  the specification of MXBeans for details.


  Each platform MXBean is a PlatformManagedObject
  and it has a unique
  ObjectName for
  registration in the platform MBeanServer as returned by
  by the getObjectName
  method.


  An application can access a platform MXBean in the following ways:
  1. Direct access to an MXBean interface


      Get an MXBean instance by calling the
          getPlatformMXBean or
          getPlatformMXBeans method
          and access the MXBean locally in the running
          virtual machine.

      Construct an MXBean proxy instance that forwards the
          method calls to a given MBeanServer by calling
          the getPlatformMXBean(MBeanServerConnection, Class) or
          getPlatformMXBeans(MBeanServerConnection, Class) method.
          The newPlatformMXBeanProxy method
          can also be used to construct an MXBean proxy instance of
          a given ObjectName.
          A proxy is typically constructed to remotely access
          an MXBean of another running virtual machine.


  2. Indirect access to an MXBean interface via MBeanServer

      Go through the platform MBeanServer to access MXBeans
          locally or a specific MBeanServerConnection to access
          MXBeans remotely.
          The attributes and operations of an MXBean use only
          JMX open types which include basic data types,
          CompositeData,
          and TabularData
          defined in
          OpenType.
          The mapping is specified in
          the javax.management.MXBean specification
          for details.





  The getPlatformManagementInterfaces
  method returns all management interfaces supported in the Java virtual machine
  including the standard management interfaces listed in the tables
  below as well as the management interfaces extended by the JDK implementation.

  A Java virtual machine has a single instance of the following management
  interfaces:




  Management Interface
  ObjectName


   ClassLoadingMXBean
   java.lang:type=ClassLoading


   MemoryMXBean
   java.lang:type=Memory


   ThreadMXBean
   java.lang:type=Threading


   RuntimeMXBean
   java.lang:type=Runtime


   OperatingSystemMXBean
   java.lang:type=OperatingSystem


   PlatformLoggingMXBean
   java.util.logging:type=Logging





  A Java virtual machine has zero or a single instance of
  the following management interfaces.




  Management Interface
  ObjectName


   CompilationMXBean
   java.lang:type=Compilation





  A Java virtual machine may have one or more instances of the following
  management interfaces.



  Management Interface
  ObjectName


   GarbageCollectorMXBean
   java.lang:type=GarbageCollector,name=collector's name


   MemoryManagerMXBean
   java.lang:type=MemoryManager,name=manager's name


   MemoryPoolMXBean
   java.lang:type=MemoryPool,name=pool's name


   BufferPoolMXBean
   java.nio:type=BufferPool,name=pool name"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.management ManagementFactory]))

(def *-class-loading-mxbean-name
  "Static Constant.

  String representation of the
   ObjectName for the ClassLoadingMXBean.

  type: java.lang.String"
  ManagementFactory/CLASS_LOADING_MXBEAN_NAME)

(def *-compilation-mxbean-name
  "Static Constant.

  String representation of the
   ObjectName for the CompilationMXBean.

  type: java.lang.String"
  ManagementFactory/COMPILATION_MXBEAN_NAME)

(def *-memory-mxbean-name
  "Static Constant.

  String representation of the
   ObjectName for the MemoryMXBean.

  type: java.lang.String"
  ManagementFactory/MEMORY_MXBEAN_NAME)

(def *-operating-system-mxbean-name
  "Static Constant.

  String representation of the
   ObjectName for the OperatingSystemMXBean.

  type: java.lang.String"
  ManagementFactory/OPERATING_SYSTEM_MXBEAN_NAME)

(def *-runtime-mxbean-name
  "Static Constant.

  String representation of the
   ObjectName for the RuntimeMXBean.

  type: java.lang.String"
  ManagementFactory/RUNTIME_MXBEAN_NAME)

(def *-thread-mxbean-name
  "Static Constant.

  String representation of the
   ObjectName for the ThreadMXBean.

  type: java.lang.String"
  ManagementFactory/THREAD_MXBEAN_NAME)

(def *-garbage-collector-mxbean-domain-type
  "Static Constant.

  The domain name and the type key property in
   the ObjectName for a GarbageCollectorMXBean.
   The unique ObjectName for a GarbageCollectorMXBean
   can be formed by appending this string with
   `,name=collector's name`.

  type: java.lang.String"
  ManagementFactory/GARBAGE_COLLECTOR_MXBEAN_DOMAIN_TYPE)

(def *-memory-manager-mxbean-domain-type
  "Static Constant.

  The domain name and the type key property in
   the ObjectName for a MemoryManagerMXBean.
   The unique ObjectName for a MemoryManagerMXBean
   can be formed by appending this string with
   `,name=manager's name`.

  type: java.lang.String"
  ManagementFactory/MEMORY_MANAGER_MXBEAN_DOMAIN_TYPE)

(def *-memory-pool-mxbean-domain-type
  "Static Constant.

  The domain name and the type key property in
   the ObjectName for a MemoryPoolMXBean.
   The unique ObjectName for a MemoryPoolMXBean
   can be formed by appending this string with
   ,name=pool's name.

  type: java.lang.String"
  ManagementFactory/MEMORY_POOL_MXBEAN_DOMAIN_TYPE)

(defn *get-memory-mx-bean
  "Returns the managed bean for the memory system of
   the Java virtual machine.

  returns: a MemoryMXBean object for the Java virtual machine. - `java.lang.management.MemoryMXBean`"
  (^java.lang.management.MemoryMXBean []
    (ManagementFactory/getMemoryMXBean )))

(defn *new-platform-mx-bean-proxy
  "Returns a proxy for a platform MXBean interface of a
   given MXBean name
   that forwards its method calls through the given
   MBeanServerConnection.

   This method is equivalent to:

   Proxy.newProxyInstance(mxbeanInterface.getClassLoader(),
          new Class[] { mxbeanInterface }, handler)


   where handler is an InvocationHandler to which method invocations to the MXBean interface
   are dispatched. This handler converts an input parameter
   from an MXBean data type to its mapped open type before forwarding
   to the MBeanServer and converts a return value from
   an MXBean method call through the MBeanServer
   from an open type to the corresponding return type declared in
   the MXBean interface.


   If the MXBean is a notification emitter (i.e.,
   it implements
   NotificationEmitter),
   both the mxbeanInterface and NotificationEmitter
   will be implemented by this proxy.


   Notes:

   Using an MXBean proxy is a convenience remote access to
   a platform MXBean of a running virtual machine.  All method
   calls to the MXBean proxy are forwarded to an
   MBeanServerConnection where
   IOException may be thrown
   when the communication problem occurs with the connector server.
   An application remotely accesses the platform MXBeans using
   proxy should prepare to catch IOException as if
   accessing with the MBeanServerConnector interface.

   When a client application is designed to remotely access MXBeans
   for a running virtual machine whose version is different than
   the version on which the application is running,
   it should prepare to catch
   InvalidObjectException
   which is thrown when an MXBean proxy receives a name of an
   enum constant which is missing in the enum class loaded in
   the client application.

   MBeanServerInvocationHandler or its
   newProxyInstance method cannot be used to create
   a proxy for a platform MXBean. The proxy object created
   by MBeanServerInvocationHandler does not handle
   the properties of the platform MXBeans described in
   the class specification.

  connection - the MBeanServerConnection to forward to. - `javax.management.MBeanServerConnection`
  mxbean-name - the name of a platform MXBean within connection to forward to. mxbeanName must be in the format of ObjectName. - `java.lang.String`
  mxbean-interface - the MXBean interface to be implemented by the proxy. - `java.lang.Class`

  returns: a proxy for a platform MXBean interface of a
   given MXBean name
   that forwards its method calls through the given
   MBeanServerConnection, or null if not exist. - `<T> T`

  throws: java.lang.IllegalArgumentException - if mxbeanName is not with a valid ObjectName format, or the named MXBean in the connection is not a MXBean provided by the platform, or the named MXBean is not registered in the MBeanServerConnection, or the named MXBean is not an instance of the given mxbeanInterface"
  ([^javax.management.MBeanServerConnection connection ^java.lang.String mxbean-name ^java.lang.Class mxbean-interface]
    (ManagementFactory/newPlatformMXBeanProxy connection mxbean-name mxbean-interface)))

(defn *get-platform-m-bean-server
  "Returns the platform MBeanServer.
   On the first call to this method, it first creates the platform
   MBeanServer by calling the
   MBeanServerFactory.createMBeanServer
   method and registers each platform MXBean in this platform
   MBeanServer with its
   ObjectName.
   This method, in subsequent calls, will simply return the
   initially created platform MBeanServer.

   MXBeans that get created and destroyed dynamically, for example,
   memory pools and
   managers,
   will automatically be registered and deregistered into the platform
   MBeanServer.

   If the system property javax.management.builder.initial
   is set, the platform MBeanServer creation will be done
   by the specified MBeanServerBuilder.

   It is recommended that this platform MBeanServer also be used
   to register other application managed beans
   besides the platform MXBeans.
   This will allow all MBeans to be published through the same
   MBeanServer and hence allow for easier network publishing
   and discovery.
   Name conflicts with the platform MXBeans should be avoided.

  returns: the platform MBeanServer; the platform
           MXBeans are registered into the platform MBeanServer
           at the first time this method is called. - `javax.management.MBeanServer`

  throws: java.lang.SecurityException - if there is a security manager and the caller does not have the permission required by MBeanServerFactory.createMBeanServer()."
  (^javax.management.MBeanServer []
    (ManagementFactory/getPlatformMBeanServer )))

(defn *get-compilation-mx-bean
  "Returns the managed bean for the compilation system of
   the Java virtual machine.  This method returns null
   if the Java virtual machine has no compilation system.

  returns: a CompilationMXBean object for the Java virtual
     machine or null if the Java virtual machine has
     no compilation system. - `java.lang.management.CompilationMXBean`"
  (^java.lang.management.CompilationMXBean []
    (ManagementFactory/getCompilationMXBean )))

(defn *get-garbage-collector-mx-beans
  "Returns a list of GarbageCollectorMXBean objects
   in the Java virtual machine.
   The Java virtual machine may have one or more
   GarbageCollectorMXBean objects.
   It may add or remove GarbageCollectorMXBean
   during execution.

  returns: a list of GarbageCollectorMXBean objects. - `java.util.List<java.lang.management.GarbageCollectorMXBean>`"
  (^java.util.List []
    (ManagementFactory/getGarbageCollectorMXBeans )))

(defn *get-platform-management-interfaces
  "Returns the set of Class objects, subinterface of
   PlatformManagedObject, representing
   all management interfaces for
   monitoring and managing the Java platform.

  returns: the set of Class objects, subinterface of
   PlatformManagedObject representing
   the management interfaces for
   monitoring and managing the Java platform. - `java.util.Set<java.lang.Class<? extends java.lang.management.PlatformManagedObject>>`"
  ([]
    (ManagementFactory/getPlatformManagementInterfaces )))

(defn *get-memory-pool-mx-beans
  "Returns a list of MemoryPoolMXBean objects in the
   Java virtual machine.
   The Java virtual machine can have one or more memory pools.
   It may add or remove memory pools during execution.

  returns: a list of MemoryPoolMXBean objects. - `java.util.List<java.lang.management.MemoryPoolMXBean>`"
  (^java.util.List []
    (ManagementFactory/getMemoryPoolMXBeans )))

(defn *get-operating-system-mx-bean
  "Returns the managed bean for the operating system on which
   the Java virtual machine is running.

  returns: an OperatingSystemMXBean object for
   the Java virtual machine. - `java.lang.management.OperatingSystemMXBean`"
  (^java.lang.management.OperatingSystemMXBean []
    (ManagementFactory/getOperatingSystemMXBean )))

(defn *get-runtime-mx-bean
  "Returns the managed bean for the runtime system of
   the Java virtual machine.

  returns: a RuntimeMXBean object for the Java virtual machine. - `java.lang.management.RuntimeMXBean`"
  (^java.lang.management.RuntimeMXBean []
    (ManagementFactory/getRuntimeMXBean )))

(defn *get-class-loading-mx-bean
  "Returns the managed bean for the class loading system of
   the Java virtual machine.

  returns: a ClassLoadingMXBean object for
   the Java virtual machine. - `java.lang.management.ClassLoadingMXBean`"
  (^java.lang.management.ClassLoadingMXBean []
    (ManagementFactory/getClassLoadingMXBean )))

(defn *get-thread-mx-bean
  "Returns the managed bean for the thread system of
   the Java virtual machine.

  returns: a ThreadMXBean object for the Java virtual machine. - `java.lang.management.ThreadMXBean`"
  (^java.lang.management.ThreadMXBean []
    (ManagementFactory/getThreadMXBean )))

(defn *get-memory-manager-mx-beans
  "Returns a list of MemoryManagerMXBean objects
   in the Java virtual machine.
   The Java virtual machine can have one or more memory managers.
   It may add or remove memory managers during execution.

  returns: a list of MemoryManagerMXBean objects. - `java.util.List<java.lang.management.MemoryManagerMXBean>`"
  (^java.util.List []
    (ManagementFactory/getMemoryManagerMXBeans )))

(defn *get-platform-mx-bean
  "Returns the platform MXBean proxy for
   mxbeanInterface which is specified to have one single
   instance in a Java virtual machine and the proxy will
   forward the method calls through the given MBeanServerConnection.
   This method may return null if the management interface
   is not implemented in the Java virtual machine being monitored
   (for example, a Java virtual machine with no compilation system
   does not implement CompilationMXBean);
   otherwise, this method is equivalent to calling:


       getPlatformMXBeans(connection, mxbeanInterface).get(0);

  connection - the MBeanServerConnection to forward to. - `javax.management.MBeanServerConnection`
  mxbean-interface - a management interface for a platform MXBean with one single instance in the Java virtual machine being monitored, if implemented. - `java.lang.Class`

  returns: the platform MXBean proxy for
   forwarding the method calls of the mxbeanInterface
   through the given MBeanServerConnection,
   or null if not exist. - `<T extends java.lang.management.PlatformManagedObject> T`

  throws: java.lang.IllegalArgumentException - if mxbeanInterface is not a platform management interface or not a singleton platform MXBean."
  ([^javax.management.MBeanServerConnection connection ^java.lang.Class mxbean-interface]
    (ManagementFactory/getPlatformMXBean connection mxbean-interface))
  ([^java.lang.Class mxbean-interface]
    (ManagementFactory/getPlatformMXBean mxbean-interface)))

(defn *get-platform-mx-beans
  "Returns the list of the platform MXBean proxies for
   forwarding the method calls of the mxbeanInterface
   through the given MBeanServerConnection.
   The returned list may contain zero, one, or more instances.
   The number of instances in the returned list is defined
   in the specification of the given management interface.
   The order is undefined and there is no guarantee that
   the list returned is in the same order as previous invocations.

  connection - the MBeanServerConnection to forward to. - `javax.management.MBeanServerConnection`
  mxbean-interface - a management interface for a platform MXBean - `java.lang.Class`

  returns: the list of platform MXBean proxies for
   forwarding the method calls of the mxbeanInterface
   through the given MBeanServerConnection. - `<T extends java.lang.management.PlatformManagedObject> java.util.List<T>`

  throws: java.lang.IllegalArgumentException - if mxbeanInterface is not a platform management interface."
  ([^javax.management.MBeanServerConnection connection ^java.lang.Class mxbean-interface]
    (ManagementFactory/getPlatformMXBeans connection mxbean-interface))
  ([^java.lang.Class mxbean-interface]
    (ManagementFactory/getPlatformMXBeans mxbean-interface)))

