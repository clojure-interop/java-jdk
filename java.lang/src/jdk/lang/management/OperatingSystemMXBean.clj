(ns jdk.lang.management.OperatingSystemMXBean
  "The management interface for the operating system on which
  the Java virtual machine is running.

   A Java virtual machine has a single instance of the implementation
  class of this interface.  This instance implementing this interface is
  an MXBean
  that can be obtained by calling
  the ManagementFactory.getOperatingSystemMXBean() method or
  from the platform MBeanServer method.

  The ObjectName for uniquely identifying the MXBean for
  the operating system within an MBeanServer is:

     java.lang:type=OperatingSystem


  It can be obtained by calling the
  PlatformManagedObject.getObjectName() method.

   This interface defines several convenient methods for accessing
  system properties about the operating system on which the Java
  virtual machine is running."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.management OperatingSystemMXBean]))

(defn get-name
  "Returns the operating system name.
   This method is equivalent to System.getProperty(`os.name`).

  returns: the operating system name. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and its checkPropertiesAccess method doesn't allow access to this system property."
  ([^java.lang.management.OperatingSystemMXBean this]
    (-> this (.getName))))

(defn get-arch
  "Returns the operating system architecture.
   This method is equivalent to System.getProperty(`os.arch`).

  returns: the operating system architecture. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and its checkPropertiesAccess method doesn't allow access to this system property."
  ([^java.lang.management.OperatingSystemMXBean this]
    (-> this (.getArch))))

(defn get-version
  "Returns the operating system version.
   This method is equivalent to System.getProperty(`os.version`).

  returns: the operating system version. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and its checkPropertiesAccess method doesn't allow access to this system property."
  ([^java.lang.management.OperatingSystemMXBean this]
    (-> this (.getVersion))))

(defn get-available-processors
  "Returns the number of processors available to the Java virtual machine.
   This method is equivalent to the Runtime.availableProcessors()
   method.
    This value may change during a particular invocation of
   the virtual machine.

  returns: the number of processors available to the virtual
            machine; never smaller than one. - `int`"
  ([^java.lang.management.OperatingSystemMXBean this]
    (-> this (.getAvailableProcessors))))

(defn get-system-load-average
  "Returns the system load average for the last minute.
   The system load average is the sum of the number of runnable entities
   queued to the available processors
   and the number of runnable entities running on the available processors
   averaged over a period of time.
   The way in which the load average is calculated is operating system
   specific but is typically a damped time-dependent average.

   If the load average is not available, a negative value is returned.

   This method is designed to provide a hint about the system load
   and may be queried frequently.
   The load average may be unavailable on some platform where it is
   expensive to implement this method.

  returns: the system load average; or a negative value if not available. - `double`"
  ([^java.lang.management.OperatingSystemMXBean this]
    (-> this (.getSystemLoadAverage))))

