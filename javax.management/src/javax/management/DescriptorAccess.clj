(ns javax.management.DescriptorAccess
  "This interface is used to gain access to descriptors of the Descriptor class
  which are associated with a JMX component, i.e. MBean, MBeanInfo,
  MBeanAttributeInfo, MBeanNotificationInfo,
  MBeanOperationInfo, MBeanParameterInfo.

  ModelMBeans make extensive use of this interface in ModelMBeanInfo classes."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management DescriptorAccess]))

(defn set-descriptor
  "Sets Descriptor (full replace).

  in-descriptor - replaces the Descriptor associated with the component implementing this interface. If the inDescriptor is invalid for the type of Info object it is being set for, an exception is thrown. If the inDescriptor is null, then the Descriptor will revert to its default value which should contain, at a minimum, the descriptor name and descriptorType. - `javax.management.Descriptor`"
  ([this in-descriptor]
    (-> this (.setDescriptor in-descriptor))))

