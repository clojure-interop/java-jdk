(ns jdk.lang.management.MonitorInfo
  "Information about an object monitor lock.  An object monitor is locked
  when entering a synchronization block or method on that object.

  MXBean Mapping
  MonitorInfo is mapped to a CompositeData
  with attributes as specified in
  the from method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.management MonitorInfo]))

(defn ->monitor-info
  "Constructor.

  Construct a MonitorInfo object.

  class-name - the fully qualified name of the class of the lock object. - `java.lang.String`
  identity-hash-code - the identity hash code of the lock object. - `int`
  stack-depth - the depth in the stack trace where the object monitor was locked. - `int`
  stack-frame - the stack frame that locked the object monitor. - `java.lang.StackTraceElement`

  throws: java.lang.IllegalArgumentException - if stackDepth ≥ 0 but stackFrame is null, or stackDepth < 0 but stackFrame is not null."
  (^MonitorInfo [^java.lang.String class-name ^Integer identity-hash-code ^Integer stack-depth ^java.lang.StackTraceElement stack-frame]
    (new MonitorInfo class-name identity-hash-code stack-depth stack-frame)))

(defn *from
  "Returns a MonitorInfo object represented by the
   given CompositeData.
   The given CompositeData must contain the following attributes
   as well as the attributes specified in the

   mapped type for the LockInfo class:



     Attribute Name
     Type


     lockedStackFrame
     CompositeData as specified in the
         stackTrace
         attribute defined in the ThreadInfo.from method.



     lockedStackDepth
     java.lang.Integer

  cd - CompositeData representing a MonitorInfo - `javax.management.openmbean.CompositeData`

  returns: a MonitorInfo object represented
           by cd if cd is not null;
           null otherwise. - `java.lang.management.MonitorInfo`

  throws: java.lang.IllegalArgumentException - if cd does not represent a MonitorInfo with the attributes described above."
  (^java.lang.management.MonitorInfo [^javax.management.openmbean.CompositeData cd]
    (MonitorInfo/from cd)))

(defn get-locked-stack-depth
  "Returns the depth in the stack trace where the object monitor
   was locked.  The depth is the index to the StackTraceElement
   array returned in the ThreadInfo.getStackTrace() method.

  returns: the depth in the stack trace where the object monitor
           was locked, or a negative number if not available. - `int`"
  (^Integer [^MonitorInfo this]
    (-> this (.getLockedStackDepth))))

(defn get-locked-stack-frame
  "Returns the stack frame that locked the object monitor.

  returns: StackTraceElement that locked the object monitor,
           or null if not available. - `java.lang.StackTraceElement`"
  (^java.lang.StackTraceElement [^MonitorInfo this]
    (-> this (.getLockedStackFrame))))

