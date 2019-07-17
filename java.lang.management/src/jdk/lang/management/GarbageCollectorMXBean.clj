(ns jdk.lang.management.GarbageCollectorMXBean
  "The management interface for the garbage collection of
  the Java virtual machine.  Garbage collection is the process
  that the Java virtual machine uses to find and reclaim unreachable
  objects to free up memory space.  A garbage collector is one type of
  memory manager.

   A Java virtual machine may have one or more instances of
  the implementation class of this interface.
  An instance implementing this interface is
  an MXBean
  that can be obtained by calling
  the ManagementFactory.getGarbageCollectorMXBeans() method or
  from the platform MBeanServer method.

  The ObjectName for uniquely identifying the MXBean for
  a garbage collector within an MBeanServer is:

    java.lang:type=GarbageCollector,name=collector's name


  It can be obtained by calling the
  PlatformManagedObject.getObjectName() method.

  A platform usually includes additional platform-dependent information
  specific to a garbage collection algorithm for monitoring."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.management GarbageCollectorMXBean]))

(defn get-collection-count
  "Returns the total number of collections that have occurred.
   This method returns -1 if the collection count is undefined for
   this collector.

  returns: the total number of collections that have occurred. - `long`"
  (^Long [^java.lang.management.GarbageCollectorMXBean this]
    (-> this (.getCollectionCount))))

(defn get-collection-time
  "Returns the approximate accumulated collection elapsed time
   in milliseconds.  This method returns -1 if the collection
   elapsed time is undefined for this collector.

   The Java virtual machine implementation may use a high resolution
   timer to measure the elapsed time.  This method may return the
   same value even if the collection count has been incremented
   if the collection elapsed time is very short.

  returns: the approximate accumulated collection elapsed time
   in milliseconds. - `long`"
  (^Long [^java.lang.management.GarbageCollectorMXBean this]
    (-> this (.getCollectionTime))))

