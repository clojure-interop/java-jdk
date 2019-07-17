(ns javax.management.NotificationListener
  "Should be implemented by an object that wants to receive notifications."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management NotificationListener]))

(defn handle-notification
  "Invoked when a JMX notification occurs.
   The implementation of this method should return as soon as possible, to avoid
   blocking its notification broadcaster.

  notification - The notification. - `javax.management.Notification`
  handback - An opaque object which helps the listener to associate information regarding the MBean emitter. This object is passed to the addNotificationListener call and resent, without modification, to the listener. - `java.lang.Object`"
  ([^. this ^javax.management.Notification notification ^java.lang.Object handback]
    (-> this (.handleNotification notification handback))))

