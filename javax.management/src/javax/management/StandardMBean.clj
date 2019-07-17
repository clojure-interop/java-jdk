(ns javax.management.StandardMBean
  "An MBean whose management interface is determined by reflection
  on a Java interface.

  This class brings more flexibility to the notion of Management
  Interface in the use of Standard MBeans.  Straightforward use of
  the patterns for Standard MBeans described in the JMX Specification
  means that there is a fixed relationship between the implementation
  class of an MBean and its management interface (i.e., if the
  implementation class is Thing, the management interface must be
  ThingMBean).  This class makes it possible to keep the convenience
  of specifying the management interface with a Java interface,
  without requiring that there be any naming relationship between the
  implementation and interface classes.

  By making a DynamicMBean out of an MBean, this class makes
  it possible to select any interface implemented by the MBean as its
  management interface, provided that it complies with JMX patterns
  (i.e., attributes defined by getter/setter etc...).

   This class also provides hooks that make it possible to supply
  custom descriptions and names for the MBeanInfo returned by
  the DynamicMBean interface.

  Using this class, an MBean can be created with any
  implementation class name Impl and with a management
  interface defined (as for current Standard MBeans) by any interface
  Intf, in one of two general ways:



  Using the public constructor
      StandardMBean(impl,interface):


      MBeanServer mbs;
      ...
      Impl impl = new Impl(...);
      StandardMBean mbean = new StandardMBean(impl, Intf.class, false);
      mbs.registerMBean(mbean, objectName);

  Subclassing StandardMBean:


      public class Impl extends StandardMBean implements Intf {
         public Impl() {
           super(Intf.class, false);
        }
        // implement methods of Intf
      }

      [...]

      MBeanServer mbs;
      ....
      Impl impl = new Impl();
      mbs.registerMBean(impl, objectName);



  In either case, the class Impl must implement the
  interface Intf.

  Standard MBeans based on the naming relationship between
  implementation and interface classes are of course still
  available.

  This class may also be used to construct MXBeans.  The usage
  is exactly the same as for Standard MBeans except that in the
  examples above, the false parameter to the constructor or
  super(...) invocation is instead true."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management StandardMBean]))

(defn ->standard-m-bean
  "Constructor.

  Make a DynamicMBean out of the object
   implementation, using the specified
   mbeanInterface class, and choosing whether the
   resultant MBean is an MXBean.  This constructor can be used
   to make either Standard MBeans or MXBeans.  Unlike the
   constructor StandardMBean(Object, Class), it
   does not throw NotCompliantMBeanException.

  implementation - The implementation of this MBean. - `T`
  mbean-interface - The Management Interface exported by this MBean's implementation. If null, then this object will use standard JMX design pattern to determine the management interface associated with the given implementation. - `java.lang.Class<T>`
  is-mx-bean - If true, the mbeanInterface parameter names an MXBean interface and the resultant MBean is an MXBean. - `boolean`

  throws: java.lang.IllegalArgumentException - if the given implementation is null, or if the mbeanInterface does not follow JMX design patterns for Management Interfaces, or if the given implementation does not implement the specified interface."
  ([implementation ^java.lang.Class mbean-interface ^Boolean is-mx-bean]
    (new StandardMBean implementation mbean-interface is-mx-bean))
  ([implementation ^java.lang.Class mbean-interface]
    (new StandardMBean implementation mbean-interface)))

(defn invoke
  "Description copied from interface: DynamicMBean

  action-name - The name of the action to be invoked. - `java.lang.String`
  params - An array containing the parameters to be set when the action is invoked. - `java.lang.Object[]`
  signature - An array containing the signature of the action. The class objects will be loaded through the same class loader as the one used for loading the MBean on which the action is invoked. - `java.lang.String[]`

  returns: The object returned by the action, which represents the result of
   invoking the action on the MBean specified. - `java.lang.Object`

  throws: javax.management.MBeanException - Wraps a java.lang.Exception thrown by the MBean's invoked method."
  (^java.lang.Object [^javax.management.StandardMBean this ^java.lang.String action-name params signature]
    (-> this (.invoke action-name params signature))))

(defn set-implementation
  "Replace the implementation object wrapped in this object.

  implementation - The new implementation of this Standard MBean (or MXBean). The implementation object must implement the Standard MBean (or MXBean) interface that was supplied when this StandardMBean was constructed. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if the given implementation is null."
  ([^javax.management.StandardMBean this ^java.lang.Object implementation]
    (-> this (.setImplementation implementation))))

(defn post-deregister
  "Allows the MBean to perform any operations needed after having been
   unregistered in the MBean server.

   The default implementation of this method does nothing for
   Standard MBeans.  For MXBeans, it removes any information that
   was recorded by the preRegister method.

   It is good practice for a subclass that overrides this method
   to call the overridden method via super.postRegister(...).
   This is necessary if this object is an MXBean that is referenced
   by attributes or operations in other MXBeans."
  ([^javax.management.StandardMBean this]
    (-> this (.postDeregister))))

(defn pre-deregister
  "Allows the MBean to perform any operations it needs before
   being unregistered by the MBean server.

   The default implementation of this method does nothing.

   It is good practice for a subclass that overrides this method
   to call the overridden method via super.preDeregister(...).

  throws: java.lang.Exception - no checked exceptions are throw by this method but Exception is declared so that subclasses can override this method and throw their own exceptions."
  ([^javax.management.StandardMBean this]
    (-> this (.preDeregister))))

(defn get-attribute
  "Description copied from interface: DynamicMBean

  attribute - The name of the attribute to be retrieved - `java.lang.String`

  returns: The value of the attribute retrieved. - `java.lang.Object`

  throws: javax.management.AttributeNotFoundException"
  (^java.lang.Object [^javax.management.StandardMBean this ^java.lang.String attribute]
    (-> this (.getAttribute attribute))))

(defn get-implementation
  "Get the implementation of this Standard MBean (or MXBean).

  returns: The implementation of this Standard MBean (or MXBean). - `java.lang.Object`"
  (^java.lang.Object [^javax.management.StandardMBean this]
    (-> this (.getImplementation))))

(defn get-m-bean-info
  "Get the MBeanInfo for this MBean.

   This method implements
   DynamicMBean.getMBeanInfo().

   This method first calls getCachedMBeanInfo() in order to
   retrieve the cached MBeanInfo for this MBean, if any. If the
   MBeanInfo returned by getCachedMBeanInfo() is not null,
   then it is returned.
   Otherwise, this method builds a default MBeanInfo for this MBean,
   using the Management Interface specified for this MBean.

   While building the MBeanInfo, this method calls the customization
   hooks that make it possible for subclasses to supply their custom
   descriptions, parameter names, etc...
   Finally, it calls cacheMBeanInfo() in order to cache the new MBeanInfo.

  returns: The cached MBeanInfo for that MBean, if not null, or a
           newly built MBeanInfo if none was cached. - `javax.management.MBeanInfo`"
  (^javax.management.MBeanInfo [^javax.management.StandardMBean this]
    (-> this (.getMBeanInfo))))

(defn post-register
  "Allows the MBean to perform any operations needed after having been
   registered in the MBean server or after the registration has failed.

   The default implementation of this method does nothing for
   Standard MBeans.  For MXBeans, it undoes any work done by
   preRegister if registration fails.

   It is good practice for a subclass that overrides this method
   to call the overridden method via super.postRegister(...).
   This is necessary if this object is an MXBean that is referenced
   by attributes or operations in other MXBeans.

  registration-done - Indicates whether or not the MBean has been successfully registered in the MBean server. The value false means that the registration phase has failed. - `java.lang.Boolean`"
  ([^javax.management.StandardMBean this ^java.lang.Boolean registration-done]
    (-> this (.postRegister registration-done))))

(defn set-attribute
  "Description copied from interface: DynamicMBean

  attribute - The identification of the attribute to be set and the value it is to be set to. - `javax.management.Attribute`

  throws: javax.management.AttributeNotFoundException"
  ([^javax.management.StandardMBean this ^javax.management.Attribute attribute]
    (-> this (.setAttribute attribute))))

(defn get-implementation-class
  "Get the class of the implementation of this Standard MBean (or MXBean).

  returns: The class of the implementation of this Standard MBean (or MXBean). - `java.lang.Class<?>`"
  (^java.lang.Class [^javax.management.StandardMBean this]
    (-> this (.getImplementationClass))))

(defn get-m-bean-interface
  "Get the Management Interface of this Standard MBean (or MXBean).

  returns: The management interface of this Standard MBean (or MXBean). - `java.lang.Class<?>`"
  (^java.lang.Class [^javax.management.StandardMBean this]
    (-> this (.getMBeanInterface))))

(defn set-attributes
  "Description copied from interface: DynamicMBean

  attributes - A list of attributes: The identification of the attributes to be set and the values they are to be set to. - `javax.management.AttributeList`

  returns: The list of attributes that were set, with their new values. - `javax.management.AttributeList`"
  (^javax.management.AttributeList [^javax.management.StandardMBean this ^javax.management.AttributeList attributes]
    (-> this (.setAttributes attributes))))

(defn pre-register
  "Allows the MBean to perform any operations it needs before
   being registered in the MBean server.  If the name of the MBean
   is not specified, the MBean can provide a name for its
   registration.  If any exception is raised, the MBean will not be
   registered in the MBean server.

   The default implementation of this method returns the name
   parameter.  It does nothing else for
   Standard MBeans.  For MXBeans, it records the MBeanServer
   and ObjectName parameters so they can be used to translate
   inter-MXBean references.

   It is good practice for a subclass that overrides this method
   to call the overridden method via super.preRegister(...).
   This is necessary if this object is an MXBean that is referenced
   by attributes or operations in other MXBeans.

  server - The MBean server in which the MBean will be registered. - `javax.management.MBeanServer`
  name - The object name of the MBean. This name is null if the name parameter to one of the createMBean or registerMBean methods in the MBeanServer interface is null. In that case, this method must return a non-null ObjectName for the new MBean. - `javax.management.ObjectName`

  returns: The name under which the MBean is to be registered.
   This value must not be null.  If the name
   parameter is not null, it will usually but not necessarily be
   the returned value. - `javax.management.ObjectName`

  throws: java.lang.IllegalArgumentException - if this is an MXBean and name is null."
  (^javax.management.ObjectName [^javax.management.StandardMBean this ^javax.management.MBeanServer server ^javax.management.ObjectName name]
    (-> this (.preRegister server name))))

(defn get-attributes
  "Description copied from interface: DynamicMBean

  attributes - A list of the attributes to be retrieved. - `java.lang.String[]`

  returns: The list of attributes retrieved. - `javax.management.AttributeList`"
  (^javax.management.AttributeList [^javax.management.StandardMBean this attributes]
    (-> this (.getAttributes attributes))))

