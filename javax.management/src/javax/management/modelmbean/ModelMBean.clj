(ns javax.management.modelmbean.ModelMBean
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
  (:import [javax.management.modelmbean ModelMBean]))

(defn set-model-m-bean-info
  "Initializes a ModelMBean object using ModelMBeanInfo passed in.
   This method makes it possible to set a customized ModelMBeanInfo on
   the ModelMBean as long as it is not registered with the MBeanServer.

   Once the ModelMBean's ModelMBeanInfo (with Descriptors) are
   customized and set on the ModelMBean, the  ModelMBean can be
   registered with the MBeanServer.

   If the ModelMBean is currently registered, this method throws
   a RuntimeOperationsException wrapping an
   IllegalStateException

  in-model-m-bean-info - The ModelMBeanInfo object to be used by the ModelMBean. - `javax.management.modelmbean.ModelMBeanInfo`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  ([this in-model-m-bean-info]
    (-> this (.setModelMBeanInfo in-model-m-bean-info))))

(defn set-managed-resource
  "Sets the instance handle of the object against which to
   execute all methods in this ModelMBean management interface
   (MBeanInfo and Descriptors).

  mr - Object that is the managed resource - `java.lang.Object`
  mr-type - The type of reference for the managed resource. Can be: ObjectReference, Handle, IOR, EJBHandle, RMIReference. If the MBeanServer cannot process the mr_type passed in, an InvalidTargetTypeException will be thrown. - `java.lang.String`

  throws: javax.management.MBeanException - The initializer of the object has thrown an exception."
  ([this mr mr-type]
    (-> this (.setManagedResource mr mr-type))))

