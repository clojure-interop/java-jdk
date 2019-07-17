(ns jdk.lang.management.CompilationMXBean
  "The management interface for the compilation system of
  the Java virtual machine.

   A Java virtual machine has a single instance of the implementation
  class of this interface.  This instance implementing this interface is
  an MXBean
  that can be obtained by calling
  the ManagementFactory.getCompilationMXBean() method or
  from the platform MBeanServer method.

  The ObjectName for uniquely identifying the MXBean for
  the compilation system within an MBeanServer is:

   java.lang:type=Compilation


  It can be obtained by calling the
  PlatformManagedObject.getObjectName() method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.management CompilationMXBean]))

(defn get-name
  "Returns the name of the Just-in-time (JIT) compiler.

  returns: the name of the JIT compiler. - `java.lang.String`"
  (^java.lang.String [^java.lang.management.CompilationMXBean this]
    (-> this (.getName))))

(defn compilation-time-monitoring-supported?
  "Tests if the Java virtual machine supports the monitoring of
   compilation time.

  returns: true if the monitoring of compilation time is
   supported ; false otherwise. - `boolean`"
  (^Boolean [^java.lang.management.CompilationMXBean this]
    (-> this (.isCompilationTimeMonitoringSupported))))

(defn get-total-compilation-time
  "Returns the approximate accumulated elapsed time (in milliseconds)
   spent in compilation.
   If multiple threads are used for compilation, this value is
   summation of the approximate time that each thread spent in compilation.

   This method is optionally supported by the platform.
   A Java virtual machine implementation may not support the compilation
   time monitoring. The isCompilationTimeMonitoringSupported()
   method can be used to determine if the Java virtual machine
   supports this operation.

    This value does not indicate the level of performance of
   the Java virtual machine and is not intended for performance comparisons
   of different virtual machine implementations.
   The implementations may have different definitions and different
   measurements of the compilation time.

  returns: Compilation time in milliseconds - `long`

  throws: java.lang.UnsupportedOperationException - if the Java virtual machine does not support this operation."
  (^Long [^java.lang.management.CompilationMXBean this]
    (-> this (.getTotalCompilationTime))))

