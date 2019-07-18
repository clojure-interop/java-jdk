(ns jdk.lang.management.RuntimeMXBean
  "The management interface for the runtime system of
  the Java virtual machine.

   A Java virtual machine has a single instance of the implementation
  class of this interface.  This instance implementing this interface is
  an MXBean
  that can be obtained by calling
  the ManagementFactory.getRuntimeMXBean() method or
  from the platform MBeanServer method.

  The ObjectName for uniquely identifying the MXBean for
  the runtime system within an MBeanServer is:

     java.lang:type=Runtime


  It can be obtained by calling the
  PlatformManagedObject.getObjectName() method.

   This interface defines several convenient methods for accessing
  system properties about the Java virtual machine."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.management RuntimeMXBean]))

(defn get-boot-class-path
  "Returns the boot class path that is used by the bootstrap class loader
   to search for class files.

    Multiple paths in the boot class path are separated by the
   path separator character of the platform on which the Java
   virtual machine is running.

   A Java virtual machine implementation may not support
   the boot class path mechanism for the bootstrap class loader
   to search for class files.
   The isBootClassPathSupported() method can be used
   to determine if the Java virtual machine supports this method.

  returns: the boot class path. - `java.lang.String`

  throws: java.lang.UnsupportedOperationException - if the Java virtual machine does not support this operation."
  (^java.lang.String [^RuntimeMXBean this]
    (-> this (.getBootClassPath))))

(defn get-input-arguments
  "Returns the input arguments passed to the Java virtual machine
   which does not include the arguments to the main method.
   This method returns an empty list if there is no input argument
   to the Java virtual machine.

   Some Java virtual machine implementations may take input arguments
   from multiple different sources: for examples, arguments passed from
   the application that launches the Java virtual machine such as
   the 'java' command, environment variables, configuration files, etc.

   Typically, not all command-line options to the 'java' command
   are passed to the Java virtual machine.
   Thus, the returned input arguments may not
   include all command-line options.


   MBeanServer access:
   The mapped type of List<String> is String[].

  returns: a list of String objects; each element
   is an argument passed to the Java virtual machine. - `java.util.List<java.lang.String>`

  throws: java.lang.SecurityException - if a security manager exists and the caller does not have ManagementPermission(`monitor`)."
  (^java.util.List [^RuntimeMXBean this]
    (-> this (.getInputArguments))))

(defn get-vm-name
  "Returns the Java virtual machine implementation name.
   This method is equivalent to System.getProperty(`java.vm.name`).

  returns: the Java virtual machine implementation name. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and its checkPropertiesAccess method doesn't allow access to this system property."
  (^java.lang.String [^RuntimeMXBean this]
    (-> this (.getVmName))))

(defn get-vm-version
  "Returns the Java virtual machine implementation version.
   This method is equivalent to System.getProperty(`java.vm.version`).

  returns: the Java virtual machine implementation version. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and its checkPropertiesAccess method doesn't allow access to this system property."
  (^java.lang.String [^RuntimeMXBean this]
    (-> this (.getVmVersion))))

(defn get-management-spec-version
  "Returns the version of the specification for the management interface
   implemented by the running Java virtual machine.

  returns: the version of the specification for the management interface
   implemented by the running Java virtual machine. - `java.lang.String`"
  (^java.lang.String [^RuntimeMXBean this]
    (-> this (.getManagementSpecVersion))))

(defn get-start-time
  "Returns the start time of the Java virtual machine in milliseconds.
   This method returns the approximate time when the Java virtual
   machine started.

  returns: start time of the Java virtual machine in milliseconds. - `long`"
  (^Long [^RuntimeMXBean this]
    (-> this (.getStartTime))))

(defn get-uptime
  "Returns the uptime of the Java virtual machine in milliseconds.

  returns: uptime of the Java virtual machine in milliseconds. - `long`"
  (^Long [^RuntimeMXBean this]
    (-> this (.getUptime))))

(defn get-name
  "Returns the name representing the running Java virtual machine.
   The returned name string can be any arbitrary string and
   a Java virtual machine implementation can choose
   to embed platform-specific useful information in the
   returned name string.  Each running virtual machine could have
   a different name.

  returns: the name representing the running Java virtual machine. - `java.lang.String`"
  (^java.lang.String [^RuntimeMXBean this]
    (-> this (.getName))))

(defn get-library-path
  "Returns the Java library path.
   This method is equivalent to System.getProperty(`java.library.path`).

    Multiple paths in the Java library path are separated by the
   path separator character of the platform of the Java virtual machine
   being monitored.

  returns: the Java library path. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and its checkPropertiesAccess method doesn't allow access to this system property."
  (^java.lang.String [^RuntimeMXBean this]
    (-> this (.getLibraryPath))))

(defn get-class-path
  "Returns the Java class path that is used by the system class loader
   to search for class files.
   This method is equivalent to System.getProperty(`java.class.path`).

    Multiple paths in the Java class path are separated by the
   path separator character of the platform of the Java virtual machine
   being monitored.

  returns: the Java class path. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and its checkPropertiesAccess method doesn't allow access to this system property."
  (^java.lang.String [^RuntimeMXBean this]
    (-> this (.getClassPath))))

(defn get-spec-name
  "Returns the Java virtual machine specification name.
   This method is equivalent to System.getProperty(`java.vm.specification.name`).

  returns: the Java virtual machine specification name. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and its checkPropertiesAccess method doesn't allow access to this system property."
  (^java.lang.String [^RuntimeMXBean this]
    (-> this (.getSpecName))))

(defn get-spec-version
  "Returns the Java virtual machine specification version.
   This method is equivalent to System.getProperty(`java.vm.specification.version`).

  returns: the Java virtual machine specification version. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and its checkPropertiesAccess method doesn't allow access to this system property."
  (^java.lang.String [^RuntimeMXBean this]
    (-> this (.getSpecVersion))))

(defn get-spec-vendor
  "Returns the Java virtual machine specification vendor.
   This method is equivalent to System.getProperty(`java.vm.specification.vendor`).

  returns: the Java virtual machine specification vendor. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and its checkPropertiesAccess method doesn't allow access to this system property."
  (^java.lang.String [^RuntimeMXBean this]
    (-> this (.getSpecVendor))))

(defn boot-class-path-supported?
  "Tests if the Java virtual machine supports the boot class path
   mechanism used by the bootstrap class loader to search for class
   files.

  returns: true if the Java virtual machine supports the
   class path mechanism; false otherwise. - `boolean`"
  (^Boolean [^RuntimeMXBean this]
    (-> this (.isBootClassPathSupported))))

(defn get-vm-vendor
  "Returns the Java virtual machine implementation vendor.
   This method is equivalent to System.getProperty(`java.vm.vendor`).

  returns: the Java virtual machine implementation vendor. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and its checkPropertiesAccess method doesn't allow access to this system property."
  (^java.lang.String [^RuntimeMXBean this]
    (-> this (.getVmVendor))))

(defn get-system-properties
  "Returns a map of names and values of all system properties.
   This method calls System.getProperties() to get all
   system properties.  Properties whose name or value is not
   a String are omitted.


   MBeanServer access:
   The mapped type of Map<String,String> is
   TabularData
   with two items in each row as follows:



     Item Name
     Item Type


     key
     String


     value
     String

  returns: a map of names and values of all system properties. - `java.util.Map<java.lang.String,java.lang.String>`

  throws: java.lang.SecurityException - if a security manager exists and its checkPropertiesAccess method doesn't allow access to the system properties."
  (^java.util.Map [^RuntimeMXBean this]
    (-> this (.getSystemProperties))))

