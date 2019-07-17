(ns javax.management.NotificationFilter
  "To be implemented by a any class acting as a notification filter.
  It allows a registered notification listener to filter the notifications of interest."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management NotificationFilter]))

(defn notification-enabled?
  "Invoked before sending the specified notification to the listener.

  notification - The notification to be sent. - `javax.management.Notification`

  returns: true if the notification has to be sent to the listener, false otherwise. - `boolean`"
  (^Boolean [^javax.management.NotificationFilter this ^javax.management.Notification notification]
    (-> this (.isNotificationEnabled notification))))

