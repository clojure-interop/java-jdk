(ns javax.management.loading.PrivateClassLoader
  "Marker interface indicating that a ClassLoader should not be added
  to the ClassLoaderRepository.  When a ClassLoader is
  registered as an MBean in the MBean server, it is added to the
  MBean server's ClassLoaderRepository unless it implements this
  interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.loading PrivateClassLoader]))

