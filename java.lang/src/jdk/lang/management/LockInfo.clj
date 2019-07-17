(ns jdk.lang.management.LockInfo
  "Information about a lock.  A lock can be a built-in object monitor,
  an ownable synchronizer, or the Condition
  object associated with synchronizers.

  An ownable synchronizer is
  a synchronizer that may be exclusively owned by a thread and uses
  AbstractOwnableSynchronizer
  (or its subclass) to implement its synchronization property.
  ReentrantLock and
  ReentrantReadWriteLock are
  two examples of ownable synchronizers provided by the platform.

  MXBean Mapping
  LockInfo is mapped to a CompositeData
  as specified in the from method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.management LockInfo]))

(defn ->lock-info
  "Constructor.

  Constructs a LockInfo object.

  class-name - the fully qualified name of the class of the lock object. - `java.lang.String`
  identity-hash-code - the identity hash code of the lock object. - `int`"
  ([class-name identity-hash-code]
    (new LockInfo class-name identity-hash-code)))

(defn *from
  "Returns a LockInfo object represented by the
   given CompositeData.
   The given CompositeData must contain the following attributes:



     Attribute Name
     Type


     className
     java.lang.String


     identityHashCode
     java.lang.Integer

  cd - CompositeData representing a LockInfo - `javax.management.openmbean.CompositeData`

  returns: a LockInfo object represented
           by cd if cd is not null;
           null otherwise. - `java.lang.management.LockInfo`

  throws: java.lang.IllegalArgumentException - if cd does not represent a LockInfo with the attributes described above."
  ([cd]
    (LockInfo/from cd)))

(defn get-class-name
  "Returns the fully qualified name of the class of the lock object.

  returns: the fully qualified name of the class of the lock object. - `java.lang.String`"
  ([this]
    (-> this (.getClassName))))

(defn get-identity-hash-code
  "Returns the identity hash code of the lock object
   returned from the System.identityHashCode(java.lang.Object) method.

  returns: the identity hash code of the lock object. - `int`"
  ([this]
    (-> this (.getIdentityHashCode))))

(defn to-string
  "Returns a string representation of a lock.  The returned
   string representation consists of the name of the class of the
   lock object, the at-sign character `@', and the unsigned
   hexadecimal representation of the identity hash code
   of the object.  This method returns a string equals to the value of:



   lock.getClass().getName()  '@'  Integer.toHexString(System.identityHashCode(lock))
   where lock is the lock object.

  returns: the string representation of a lock. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

