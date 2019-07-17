(ns javax.management.DescriptorRead
  "Interface to read the Descriptor of a management interface element
  such as an MBeanInfo."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management DescriptorRead]))

(defn get-descriptor
  "Returns a copy of Descriptor.

  returns: Descriptor associated with the component implementing this interface.
   The return value is never null, but the returned descriptor may be empty. - `javax.management.Descriptor`"
  ([^javax.management.DescriptorRead this]
    (-> this (.getDescriptor))))

