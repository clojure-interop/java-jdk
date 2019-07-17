(ns jdk.lang.management.ClassLoadingMXBean
  "The management interface for the class loading system of
  the Java virtual machine.

   A Java virtual machine has a single instance of the implementation
  class of this interface.  This instance implementing this interface is
  an MXBean
  that can be obtained by calling
  the ManagementFactory.getClassLoadingMXBean() method or
  from the platform MBeanServer.

  The ObjectName for uniquely identifying the MXBean for
  the class loading system within an MBeanServer is:

  java.lang:type=ClassLoading


  It can be obtained by calling the
  PlatformManagedObject.getObjectName() method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.management ClassLoadingMXBean]))

(defn get-total-loaded-class-count
  "Returns the total number of classes that have been loaded since
   the Java virtual machine has started execution.

  returns: the total number of classes loaded. - `long`"
  ([this]
    (-> this (.getTotalLoadedClassCount))))

(defn get-loaded-class-count
  "Returns the number of classes that are currently loaded in the
   Java virtual machine.

  returns: the number of currently loaded classes. - `int`"
  ([this]
    (-> this (.getLoadedClassCount))))

(defn get-unloaded-class-count
  "Returns the total number of classes unloaded since the Java virtual machine
   has started execution.

  returns: the total number of unloaded classes. - `long`"
  ([this]
    (-> this (.getUnloadedClassCount))))

(defn verbose?
  "Tests if the verbose output for the class loading system is enabled.

  returns: true if the verbose output for the class loading
   system is enabled; false otherwise. - `boolean`"
  ([this]
    (-> this (.isVerbose))))

(defn set-verbose
  "Enables or disables the verbose output for the class loading
   system.  The verbose output information and the output stream
   to which the verbose information is emitted are implementation
   dependent.  Typically, a Java virtual machine implementation
   prints a message each time a class file is loaded.

   This method can be called by multiple threads concurrently.
   Each invocation of this method enables or disables the verbose
   output globally.

  value - true to enable the verbose output; false to disable. - `boolean`

  throws: java.lang.SecurityException - if a security manager exists and the caller does not have ManagementPermission(`control`)."
  ([this value]
    (-> this (.setVerbose value))))

