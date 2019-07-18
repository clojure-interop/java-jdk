(ns jdk.lang.management.MemoryNotificationInfo
  "The information about a memory notification.


  A memory notification is emitted by MemoryMXBean
  when the Java virtual machine detects that the memory usage
  of a memory pool is exceeding a threshold value.
  The notification emitted will contain the memory notification
  information about the detected condition:

    The name of the memory pool.
    The memory usage of the memory pool when the notification
        was constructed.
    The number of times that the memory usage has crossed
        a threshold when the notification was constructed.
        For usage threshold notifications, this count will be the
        usage threshold
        count.  For collection threshold notifications,
        this count will be the
        collection usage threshold count.




  A CompositeData representing
  the MemoryNotificationInfo object
  is stored in the
  user data
  of a notification.
  The from method is provided to convert from
  a CompositeData to a MemoryNotificationInfo
  object. For example:



       Notification notif;

       // receive the notification emitted by MemoryMXBean and set to notif
       ...

       String notifType = notif.getType();
       if (notifType.equals(MemoryNotificationInfo.MEMORY_THRESHOLD_EXCEEDED) ||
           notifType.equals(MemoryNotificationInfo.MEMORY_COLLECTION_THRESHOLD_EXCEEDED)) {
           // retrieve the memory notification information
           CompositeData cd = (CompositeData) notif.getUserData();
           MemoryNotificationInfo info = MemoryNotificationInfo.from(cd);
           ....
       }


  The types of notifications emitted by MemoryMXBean are:

    A usage threshold exceeded notification.
        This notification will be emitted when
        the memory usage of a memory pool is increased and has reached
        or exceeded its
         usage threshold value.
        Subsequent crossing of the usage threshold value does not cause
        further notification until the memory usage has returned
        to become less than the usage threshold value.

    A collection usage threshold exceeded notification.
        This notification will be emitted when
        the memory usage of a memory pool is greater than or equal to its

        collection usage threshold after the Java virtual machine
        has expended effort in recycling unused objects in that
        memory pool."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.management MemoryNotificationInfo]))

(defn ->memory-notification-info
  "Constructor.

  Constructs a MemoryNotificationInfo object.

  pool-name - The name of the memory pool which triggers this notification. - `java.lang.String`
  usage - Memory usage of the memory pool. - `java.lang.management.MemoryUsage`
  count - The threshold crossing count. - `long`"
  (^MemoryNotificationInfo [^java.lang.String pool-name ^java.lang.management.MemoryUsage usage ^Long count]
    (new MemoryNotificationInfo pool-name usage count)))

(def *-memory-threshold-exceeded
  "Static Constant.

  Notification type denoting that
   the memory usage of a memory pool has
   reached or exceeded its
    usage threshold value.
   This notification is emitted by MemoryMXBean.
   Subsequent crossing of the usage threshold value does not cause
   further notification until the memory usage has returned
   to become less than the usage threshold value.
   The value of this notification type is
   java.management.memory.threshold.exceeded.

  type: java.lang.String"
  MemoryNotificationInfo/MEMORY_THRESHOLD_EXCEEDED)

(def *-memory-collection-threshold-exceeded
  "Static Constant.

  Notification type denoting that
   the memory usage of a memory pool is greater than or equal to its

   collection usage threshold after the Java virtual machine
   has expended effort in recycling unused objects in that
   memory pool.
   This notification is emitted by MemoryMXBean.
   The value of this notification type is
   java.management.memory.collection.threshold.exceeded.

  type: java.lang.String"
  MemoryNotificationInfo/MEMORY_COLLECTION_THRESHOLD_EXCEEDED)

(defn *from
  "Returns a MemoryNotificationInfo object represented by the
   given CompositeData.
   The given CompositeData must contain
   the following attributes:



     Attribute Name
     Type


     poolName
     java.lang.String


     usage
     javax.management.openmbean.CompositeData


     count
     java.lang.Long

  cd - CompositeData representing a MemoryNotificationInfo - `javax.management.openmbean.CompositeData`

  returns: a MemoryNotificationInfo object represented
           by cd if cd is not null;
           null otherwise. - `java.lang.management.MemoryNotificationInfo`

  throws: java.lang.IllegalArgumentException - if cd does not represent a MemoryNotificationInfo object."
  (^java.lang.management.MemoryNotificationInfo [^javax.management.openmbean.CompositeData cd]
    (MemoryNotificationInfo/from cd)))

(defn get-pool-name
  "Returns the name of the memory pool that triggers this notification.
   The memory pool usage has crossed a threshold.

  returns: the name of the memory pool that triggers this notification. - `java.lang.String`"
  (^java.lang.String [^MemoryNotificationInfo this]
    (-> this (.getPoolName))))

(defn get-usage
  "Returns the memory usage of the memory pool
   when this notification was constructed.

  returns: the memory usage of the memory pool
   when this notification was constructed. - `java.lang.management.MemoryUsage`"
  (^java.lang.management.MemoryUsage [^MemoryNotificationInfo this]
    (-> this (.getUsage))))

(defn get-count
  "Returns the number of times that the memory usage has crossed
   a threshold when the notification was constructed.
   For usage threshold notifications, this count will be the
   threshold
   count.  For collection threshold notifications,
   this count will be the
   collection usage threshold count.

  returns: the number of times that the memory usage has crossed
   a threshold when the notification was constructed. - `long`"
  (^Long [^MemoryNotificationInfo this]
    (-> this (.getCount))))

