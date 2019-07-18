(ns jdk.lang.management.BufferPoolMXBean
  "The management interface for a buffer pool, for example a pool of
  direct or mapped buffers.

   A class implementing this interface is an
  MXBean. A Java
  virtual machine has one or more implementations of this interface. The getPlatformMXBeans
  method can be used to obtain the list of BufferPoolMXBean objects
  representing the management interfaces for pools of buffers as follows:


      List<BufferPoolMXBean> pools = ManagementFactory.getPlatformMXBeans(BufferPoolMXBean.class);

   The management interfaces are also registered with the platform MBeanServer. The ObjectName that uniquely identifies the
  management interface within the MBeanServer takes the form:


      java.nio:type=BufferPool,name=pool name
  where pool name is the name of the buffer pool."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.management BufferPoolMXBean]))

(defn get-name
  "Returns the name representing this buffer pool.

  returns: The name of this buffer pool. - `java.lang.String`"
  (^java.lang.String [^BufferPoolMXBean this]
    (-> this (.getName))))

(defn get-count
  "Returns an estimate of the number of buffers in the pool.

  returns: An estimate of the number of buffers in this pool - `long`"
  (^Long [^BufferPoolMXBean this]
    (-> this (.getCount))))

(defn get-total-capacity
  "Returns an estimate of the total capacity of the buffers in this pool.
   A buffer's capacity is the number of elements it contains and the value
   returned by this method is an estimate of the total capacity of buffers
   in the pool in bytes.

  returns: An estimate of the total capacity of the buffers in this pool
            in bytes - `long`"
  (^Long [^BufferPoolMXBean this]
    (-> this (.getTotalCapacity))))

(defn get-memory-used
  "Returns an estimate of the memory that the Java virtual machine is using
   for this buffer pool. The value returned by this method may differ
   from the estimate of the total capacity of
   the buffers in this pool. This difference is explained by alignment,
   memory allocator, and other implementation specific reasons.

  returns: An estimate of the memory that the Java virtual machine is using
            for this buffer pool in bytes, or -1L if an estimate of
            the memory usage is not available - `long`"
  (^Long [^BufferPoolMXBean this]
    (-> this (.getMemoryUsed))))

