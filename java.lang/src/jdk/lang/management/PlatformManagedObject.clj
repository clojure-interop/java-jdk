(ns jdk.lang.management.PlatformManagedObject
  "A platform managed object is a javax.management.JMX MXBean
  for monitoring and managing a component in the Java platform.
  Each platform managed object has a unique
  object name
  for the platform MBeanServer access.
  All platform MXBeans will implement this interface.


  Note:
  The platform MXBean interfaces (i.e. all subinterfaces
  of PlatformManagedObject) are implemented
  by the Java platform only.  New methods may be added in these interfaces
  in future Java SE releases.
  In addition, this PlatformManagedObject interface is only
  intended for the management interfaces for the platform to extend but
  not for applications."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.management PlatformManagedObject]))

(defn get-object-name
  "Returns an ObjectName instance representing
   the object name of this platform managed object.

  returns: an ObjectName instance representing
   the object name of this platform managed object. - `javax.management.ObjectName`"
  ([^. this]
    (-> this (.getObjectName))))

