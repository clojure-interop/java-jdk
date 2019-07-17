(ns jdk.lang.management.MemoryUsage
  "A MemoryUsage object represents a snapshot of memory usage.
  Instances of the MemoryUsage class are usually constructed
  by methods that are used to obtain memory usage
  information about individual memory pool of the Java virtual machine or
  the heap or non-heap memory of the Java virtual machine as a whole.

   A MemoryUsage object contains four values:


   init
   represents the initial amount of memory (in bytes) that
       the Java virtual machine requests from the operating system
       for memory management during startup.  The Java virtual machine
       may request additional memory from the operating system and
       may also release memory to the system over time.
       The value of init may be undefined.



   used
   represents the amount of memory currently used (in bytes).



   committed
   represents the amount of memory (in bytes) that is
       guaranteed to be available for use by the Java virtual machine.
       The amount of committed memory may change over time (increase
       or decrease).  The Java virtual machine may release memory to
       the system and committed could be less than init.
       committed will always be greater than
       or equal to used.



   max
   represents the maximum amount of memory (in bytes)
       that can be used for memory management. Its value may be undefined.
       The maximum amount of memory may change over time if defined.
       The amount of used and committed memory will always be less than
       or equal to max if max is defined.
       A memory allocation may fail if it attempts to increase the
       used memory such that used > committed even
       if used <= max would still be true (for example,
       when the system is low on virtual memory).




  Below is a picture showing an example of a memory pool:



         ----------------------------------------------+
         ////////////////           |
         ////////////////           |
         ----------------------------------------------+

         |--------|
            init
         |---------------|
                used
         |---------------------------|
                   committed
         |----------------------------------------------|
                             max

  MXBean Mapping
  MemoryUsage is mapped to a CompositeData
  with attributes as specified in the from method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.management MemoryUsage]))

(defn ->memory-usage
  "Constructor.

  Constructs a MemoryUsage object.

  init - the initial amount of memory in bytes that the Java virtual machine allocates; or -1 if undefined. - `long`
  used - the amount of used memory in bytes. - `long`
  committed - the amount of committed memory in bytes. - `long`
  max - the maximum amount of memory in bytes that can be used; or -1 if undefined. - `long`

  throws: java.lang.IllegalArgumentException - if the value of init or max is negative but not -1; or the value of used or committed is negative; or used is greater than the value of committed; or committed is greater than the value of max max if defined."
  ([^Long init ^Long used ^Long committed ^Long max]
    (new MemoryUsage init used committed max)))

(defn *from
  "Returns a MemoryUsage object represented by the
   given CompositeData. The given CompositeData
   must contain the following attributes:




     Attribute Name
     Type


     init
     java.lang.Long


     used
     java.lang.Long


     committed
     java.lang.Long


     max
     java.lang.Long

  cd - CompositeData representing a MemoryUsage - `javax.management.openmbean.CompositeData`

  returns: a MemoryUsage object represented by cd
           if cd is not null;
           null otherwise. - `java.lang.management.MemoryUsage`

  throws: java.lang.IllegalArgumentException - if cd does not represent a MemoryUsage with the attributes described above."
  ([^javax.management.openmbean.CompositeData cd]
    (MemoryUsage/from cd)))

(defn get-init
  "Returns the amount of memory in bytes that the Java virtual machine
   initially requests from the operating system for memory management.
   This method returns -1 if the initial memory size is undefined.

  returns: the initial size of memory in bytes;
   -1 if undefined. - `long`"
  ([^java.lang.management.MemoryUsage this]
    (-> this (.getInit))))

(defn get-used
  "Returns the amount of used memory in bytes.

  returns: the amount of used memory in bytes. - `long`"
  ([^java.lang.management.MemoryUsage this]
    (-> this (.getUsed))))

(defn get-committed
  "Returns the amount of memory in bytes that is committed for
   the Java virtual machine to use.  This amount of memory is
   guaranteed for the Java virtual machine to use.

  returns: the amount of committed memory in bytes. - `long`"
  ([^java.lang.management.MemoryUsage this]
    (-> this (.getCommitted))))

(defn get-max
  "Returns the maximum amount of memory in bytes that can be
   used for memory management.  This method returns -1
   if the maximum memory size is undefined.

    This amount of memory is not guaranteed to be available
   for memory management if it is greater than the amount of
   committed memory.  The Java virtual machine may fail to allocate
   memory even if the amount of used memory does not exceed this
   maximum size.

  returns: the maximum amount of memory in bytes;
   -1 if undefined. - `long`"
  ([^java.lang.management.MemoryUsage this]
    (-> this (.getMax))))

(defn to-string
  "Returns a descriptive representation of this memory usage.

  returns: a string representation of the object. - `java.lang.String`"
  ([^java.lang.management.MemoryUsage this]
    (-> this (.toString))))

