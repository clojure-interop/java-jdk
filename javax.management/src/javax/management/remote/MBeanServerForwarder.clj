(ns javax.management.remote.MBeanServerForwarder
  "An object of this class implements the MBeanServer interface and
  wraps another object that also implements that interface.
  Typically, an implementation of this interface performs some action
  in some or all methods of the MBeanServer interface
  before and/or after forwarding the method to the wrapped object.
  Examples include security checking and logging."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote MBeanServerForwarder]))

(defn get-m-bean-server
  "Returns the MBeanServer object to which requests will be forwarded.

  returns: the MBeanServer object to which requests will be forwarded,
   or null if there is none. - `javax.management.MBeanServer`"
  (^javax.management.MBeanServer [^MBeanServerForwarder this]
    (-> this (.getMBeanServer))))

(defn set-m-bean-server
  "Sets the MBeanServer object to which requests will be forwarded
   after treatment by this object.

  mbs - the MBeanServer object to which requests will be forwarded. - `javax.management.MBeanServer`

  throws: java.lang.IllegalArgumentException - if this object is already forwarding to an MBeanServer object or if mbs is null or if mbs is identical to this object."
  ([^MBeanServerForwarder this ^javax.management.MBeanServer mbs]
    (-> this (.setMBeanServer mbs))))

