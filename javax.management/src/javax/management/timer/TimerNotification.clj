(ns javax.management.timer.TimerNotification
  "This class provides definitions of the notifications sent by timer MBeans.
  It defines a timer notification identifier which allows to retrieve a timer notification
  from the list of notifications of a timer MBean.

  The timer notifications are created and handled by the timer MBean."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.timer TimerNotification]))

(defn ->timer-notification
  "Constructor.

  Creates a timer notification object.

  type - The notification type. - `java.lang.String`
  source - The notification producer. - `java.lang.Object`
  sequence-number - The notification sequence number within the source object. - `long`
  time-stamp - The notification emission date. - `long`
  msg - The notification message. - `java.lang.String`
  id - The notification identifier. - `java.lang.Integer`"
  ([^java.lang.String type ^java.lang.Object source ^Long sequence-number ^Long time-stamp ^java.lang.String msg ^java.lang.Integer id]
    (new TimerNotification type source sequence-number time-stamp msg id)))

(defn get-notification-id
  "Gets the identifier of this timer notification.

  returns: The identifier. - `java.lang.Integer`"
  ([^javax.management.timer.TimerNotification this]
    (-> this (.getNotificationID))))

