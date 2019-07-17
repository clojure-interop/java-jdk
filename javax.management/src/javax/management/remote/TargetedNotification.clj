(ns javax.management.remote.TargetedNotification
  "A (Notification, Listener ID) pair.
  This class is used to associate an emitted notification
     with the listener ID to which it is targeted."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote TargetedNotification]))

(defn ->targeted-notification
  "Constructor.

  Constructs a TargetedNotification object.  The
   object contains a pair (Notification, Listener ID).
   The Listener ID identifies the client listener to which that
   notification is targeted. The client listener ID is one
   previously returned by the connector server in response to an
   addNotificationListener request.

  notification - Notification emitted from the MBean server. - `javax.management.Notification`
  listener-id - The ID of the listener to which this notification is targeted. - `java.lang.Integer`

  throws: java.lang.IllegalArgumentException - if the listenerID or notification is null."
  ([^javax.management.Notification notification ^java.lang.Integer listener-id]
    (new TargetedNotification notification listener-id)))

(defn get-notification
  "The emitted notification.

  returns: The notification. - `javax.management.Notification`"
  ([^javax.management.remote.TargetedNotification this]
    (-> this (.getNotification))))

(defn get-listener-id
  "The ID of the listener to which the notification is
      targeted.

  returns: The listener ID. - `java.lang.Integer`"
  ([^javax.management.remote.TargetedNotification this]
    (-> this (.getListenerID))))

(defn to-string
  "Returns a textual representation of this Targeted Notification.

  returns: a String representation of this Targeted Notification. - `java.lang.String`"
  ([^javax.management.remote.TargetedNotification this]
    (-> this (.toString))))

