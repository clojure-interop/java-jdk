(ns javax.management.PersistentMBean
  "This class is the interface to be implemented by MBeans that are meant to be
   persistent.  MBeans supporting this interface should call the load method during
   construction in order to prime the MBean from the persistent store.
   In the case of a ModelMBean, the store method should be called by the MBeanServer based on the descriptors in
   the ModelMBean or by the MBean itself during normal processing of the ModelMBean."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management PersistentMBean]))

(defn load
  "Instantiates thisMBean instance with the data found for
   the MBean in the persistent store.  The data loaded could include
   attribute and operation values.

   This method should be called during construction or initialization of this instance,
   and before the MBean is registered with the MBeanServer.

  throws: javax.management.MBeanException - Wraps another exception or persistence is not supported"
  ([^PersistentMBean this]
    (-> this (.load))))

(defn store
  "Captures the current state of this MBean instance and
   writes it out to the persistent store.  The state stored could include
   attribute and operation values. If one of these methods of persistence is
   not supported a \"serviceNotFound\" exception will be thrown.

   Persistence policy from the MBean and attribute descriptor is used to guide execution
   of this method. The MBean should be stored if 'persistPolicy' field is:


    != \"never\"
     = \"always\"
     = \"onTimer\" and now > 'lastPersistTime'  'persistPeriod'
     = \"NoMoreOftenThan\" and now > 'lastPersistTime'  'persistPeriod'
     = \"onUnregister\"

   Do not store the MBean if 'persistPolicy' field is:


      = \"never\"
      = \"onUpdate\"
      = \"onTimer\" && now < 'lastPersistTime'  'persistPeriod'

  throws: javax.management.MBeanException - Wraps another exception or persistence is not supported"
  ([^PersistentMBean this]
    (-> this (.store))))

