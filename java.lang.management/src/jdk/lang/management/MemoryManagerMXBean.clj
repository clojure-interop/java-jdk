(ns jdk.lang.management.MemoryManagerMXBean
  "The management interface for a memory manager.
  A memory manager manages one or more memory pools of the
  Java virtual machine.

   A Java virtual machine has one or more memory managers.
  An instance implementing this interface is
  an MXBean
  that can be obtained by calling
  the ManagementFactory.getMemoryManagerMXBeans() method or
  from the platform MBeanServer method.

  The ObjectName for uniquely identifying the MXBean for
  a memory manager within an MBeanServer is:

    java.lang:type=MemoryManager,name=manager's name


  It can be obtained by calling the
  PlatformManagedObject.getObjectName() method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.management MemoryManagerMXBean]))

(defn get-name
  "Returns the name representing this memory manager.

  returns: the name of this memory manager. - `java.lang.String`"
  ([^. this]
    (-> this (.getName))))

(defn valid?
  "Tests if this memory manager is valid in the Java virtual
   machine.  A memory manager becomes invalid once the Java virtual
   machine removes it from the memory system.

  returns: true if the memory manager is valid in the
                 Java virtual machine;
           false otherwise. - `boolean`"
  ([^. this]
    (-> this (.isValid))))

(defn get-memory-pool-names
  "Returns the name of memory pools that this memory manager manages.

  returns: an array of String objects, each is
   the name of a memory pool that this memory manager manages. - `java.lang.String[]`"
  ([^. this]
    (-> this (.getMemoryPoolNames))))

