(ns javax.management.remote.NotificationResult
  "Result of a query for buffered notifications.  Notifications in
  a notification buffer have positive, monotonically increasing
  sequence numbers.  The result of a notification query contains the
  following elements:



  The sequence number of the earliest notification still in
  the buffer.

  The sequence number of the next notification available for
  querying.  This will be the starting sequence number for the next
  notification query.

  An array of (Notification,listenerID) pairs corresponding to
  the returned notifications and the listeners they correspond to.



  It is possible for the nextSequenceNumber to be less
  than the earliestSequenceNumber.  This signifies that
  notifications between the two might have been lost."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote NotificationResult]))

(defn ->notification-result
  "Constructor.

  Constructs a notification query result.

  earliest-sequence-number - the sequence number of the earliest notification still in the buffer. - `long`
  next-sequence-number - the sequence number of the next notification available for querying. - `long`
  targeted-notifications - the notifications resulting from the query, and the listeners they correspond to. This array can be empty. - `javax.management.remote.TargetedNotification[]`

  throws: java.lang.IllegalArgumentException - if targetedNotifications is null or if earliestSequenceNumber or nextSequenceNumber is negative."
  ([^Long earliest-sequence-number ^Long next-sequence-number ^javax.management.remote.TargetedNotification[] targeted-notifications]
    (new NotificationResult earliest-sequence-number next-sequence-number targeted-notifications)))

(defn get-earliest-sequence-number
  "Returns the sequence number of the earliest notification still
   in the buffer.

  returns: the sequence number of the earliest notification still
   in the buffer. - `long`"
  ([^javax.management.remote.NotificationResult this]
    (-> this (.getEarliestSequenceNumber))))

(defn get-next-sequence-number
  "Returns the sequence number of the next notification available
   for querying.

  returns: the sequence number of the next notification available
   for querying. - `long`"
  ([^javax.management.remote.NotificationResult this]
    (-> this (.getNextSequenceNumber))))

(defn get-targeted-notifications
  "Returns the notifications resulting from the query, and the
   listeners they correspond to.

  returns: the notifications resulting from the query, and the
   listeners they correspond to.  This array can be empty. - `javax.management.remote.TargetedNotification[]`"
  ([^javax.management.remote.NotificationResult this]
    (-> this (.getTargetedNotifications))))

(defn to-string
  "Returns a string representation of the object.  The result
   should be a concise but informative representation that is easy
   for a person to read.

  returns: a string representation of the object. - `java.lang.String`"
  ([^javax.management.remote.NotificationResult this]
    (-> this (.toString))))

