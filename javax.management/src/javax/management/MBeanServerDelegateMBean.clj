(ns javax.management.MBeanServerDelegateMBean
  "Defines the management interface  of an object of class MBeanServerDelegate."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management MBeanServerDelegateMBean]))

(defn get-m-bean-server-id
  "Returns the MBean server agent identity.

  returns: the agent identity. - `java.lang.String`"
  (^java.lang.String [^MBeanServerDelegateMBean this]
    (-> this (.getMBeanServerId))))

(defn get-specification-name
  "Returns the full name of the JMX specification implemented
   by this product.

  returns: the specification name. - `java.lang.String`"
  (^java.lang.String [^MBeanServerDelegateMBean this]
    (-> this (.getSpecificationName))))

(defn get-specification-version
  "Returns the version of the JMX specification implemented
   by this product.

  returns: the specification version. - `java.lang.String`"
  (^java.lang.String [^MBeanServerDelegateMBean this]
    (-> this (.getSpecificationVersion))))

(defn get-specification-vendor
  "Returns the vendor of the JMX specification implemented
   by this product.

  returns: the specification vendor. - `java.lang.String`"
  (^java.lang.String [^MBeanServerDelegateMBean this]
    (-> this (.getSpecificationVendor))))

(defn get-implementation-name
  "Returns the JMX implementation name (the name of this product).

  returns: the implementation name. - `java.lang.String`"
  (^java.lang.String [^MBeanServerDelegateMBean this]
    (-> this (.getImplementationName))))

(defn get-implementation-version
  "Returns the JMX implementation version (the version of this product).

  returns: the implementation version. - `java.lang.String`"
  (^java.lang.String [^MBeanServerDelegateMBean this]
    (-> this (.getImplementationVersion))))

(defn get-implementation-vendor
  "Returns the JMX implementation vendor (the vendor of this product).

  returns: the implementation vendor. - `java.lang.String`"
  (^java.lang.String [^MBeanServerDelegateMBean this]
    (-> this (.getImplementationVendor))))

