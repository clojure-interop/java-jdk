(ns javax.management.timer.TimerMBean
  "Exposes the management interface of the timer MBean."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.timer TimerMBean]))

(defn stop
  "Stops the timer."
  ([^. this]
    (-> this (.stop))))

(defn active?
  "Tests whether the timer MBean is active.
   A timer MBean is marked active when the start method is called.
   It becomes inactive when the stop method is called.

  returns: true if the timer MBean is active, false otherwise. - `boolean`"
  ([^. this]
    (-> this (.isActive))))

(defn get-notification-type
  "Gets the timer notification type corresponding to the specified identifier.

  id - The timer notification identifier. - `java.lang.Integer`

  returns: The timer notification type or null if the identifier is not mapped to any
   timer notification registered for this timer MBean. - `java.lang.String`"
  ([^. this ^java.lang.Integer id]
    (-> this (.getNotificationType id))))

(defn get-notification-i-ds
  "Gets all the identifiers of timer notifications corresponding to the specified type.

  type - The timer notification type. - `java.lang.String`

  returns: A vector of Integer objects containing all the identifiers of
   timer notifications with the specified type.
   The vector is empty if there is no timer notifications registered for this timer MBean
   with the specified type. - `java.util.Vector<java.lang.Integer>`"
  ([^. this ^java.lang.String type]
    (-> this (.getNotificationIDs type))))

(defn set-send-past-notifications
  "Sets the flag indicating whether the timer sends past notifications or not.

  value - The past notifications sending on/off flag value. - `boolean`"
  ([^. this ^Boolean value]
    (-> this (.setSendPastNotifications value))))

(defn get-period
  "Gets a copy of the period (in milliseconds) associated to a timer notification.

  id - The timer notification identifier. - `java.lang.Integer`

  returns: A copy of the period or null if the identifier is not mapped to any
   timer notification registered for this timer MBean. - `java.lang.Long`"
  ([^. this ^java.lang.Integer id]
    (-> this (.getPeriod id))))

(defn get-fixed-rate?
  "Gets a copy of the flag indicating whether a periodic notification is
   executed at fixed-delay or at fixed-rate.

  id - The timer notification identifier. - `java.lang.Integer`

  returns: A copy of the flag indicating whether a periodic notification is
           executed at fixed-delay or at fixed-rate. - `java.lang.Boolean`"
  ([^. this ^java.lang.Integer id]
    (-> this (.getFixedRate id))))

(defn get-nb-occurences
  "Gets a copy of the remaining number of occurrences associated to a timer notification.

  id - The timer notification identifier. - `java.lang.Integer`

  returns: A copy of the remaining number of occurrences or null if the identifier is not mapped to any
   timer notification registered for this timer MBean. - `java.lang.Long`"
  ([^. this ^java.lang.Integer id]
    (-> this (.getNbOccurences id))))

(defn get-all-notification-i-ds
  "Gets all timer notification identifiers registered into the list of notifications.

  returns: A vector of Integer objects containing all the timer notification identifiers.
   The vector is empty if there is no timer notification registered for this timer MBean. - `java.util.Vector<java.lang.Integer>`"
  ([^. this]
    (-> this (.getAllNotificationIDs))))

(defn get-notification-user-data
  "Gets the timer notification user data object corresponding to the specified identifier.

  id - The timer notification identifier. - `java.lang.Integer`

  returns: The timer notification user data object or null if the identifier is not mapped to any
   timer notification registered for this timer MBean. - `java.lang.Object`"
  ([^. this ^java.lang.Integer id]
    (-> this (.getNotificationUserData id))))

(defn get-date
  "Gets a copy of the date associated to a timer notification.

  id - The timer notification identifier. - `java.lang.Integer`

  returns: A copy of the date or null if the identifier is not mapped to any
   timer notification registered for this timer MBean. - `java.util.Date`"
  ([^. this ^java.lang.Integer id]
    (-> this (.getDate id))))

(defn start
  "Starts the timer.

   If there is one or more timer notifications before the time in the list of notifications, the notification
   is sent according to the sendPastNotifications flag and then, updated
   according to its period and remaining number of occurrences.
   If the timer notification date remains earlier than the current date, this notification is just removed
   from the list of notifications."
  ([^. this]
    (-> this (.start))))

(defn get-send-past-notifications?
  "Gets the flag indicating whether or not the timer sends past notifications.

  returns: The past notifications sending on/off flag value. - `boolean`"
  ([^. this]
    (-> this (.getSendPastNotifications))))

(defn get-nb-notifications
  "Gets the number of timer notifications registered into the list of notifications.

  returns: The number of timer notifications. - `int`"
  ([^. this]
    (-> this (.getNbNotifications))))

(defn get-notification-message
  "Gets the timer notification detailed message corresponding to the specified identifier.

  id - The timer notification identifier. - `java.lang.Integer`

  returns: The timer notification detailed message or null if the identifier is not mapped to any
   timer notification registered for this timer MBean. - `java.lang.String`"
  ([^. this ^java.lang.Integer id]
    (-> this (.getNotificationMessage id))))

(defn add-notification
  "Creates a new timer notification with the specified type, message
   and userData and inserts it into the list of notifications with a given date,
   period and number of occurrences.

   If the timer notification to be inserted has a date that is before the current date,
   the method behaves as if the specified date were the current date.
   For once-off notifications, the notification is delivered immediately.
   For periodic notifications, the first notification is delivered immediately and the
   subsequent ones are spaced as specified by the period parameter.

   Note that once the timer notification has been added into the list of notifications,
   its associated date, period and number of occurrences cannot be updated.

   In the case of a periodic notification, the value of parameter fixedRate is used to
   specify the execution scheme, as specified in Timer.

  type - The timer notification type. - `java.lang.String`
  message - The timer notification detailed message. - `java.lang.String`
  user-data - The timer notification user data object. - `java.lang.Object`
  date - The date when the notification occurs. - `java.util.Date`
  period - The period of the timer notification (in milliseconds). - `long`
  nb-occurences - The total number the timer notification will be emitted. - `long`
  fixed-rate - If true and if the notification is periodic, the notification is scheduled with a fixed-rate execution scheme. If false and if the notification is periodic, the notification is scheduled with a fixed-delay execution scheme. Ignored if the notification is not periodic. - `boolean`

  returns: The identifier of the new created timer notification. - `java.lang.Integer`

  throws: java.lang.IllegalArgumentException - The date is null or the period or the number of occurrences is negative."
  ([^. this ^java.lang.String type ^java.lang.String message ^java.lang.Object user-data ^java.util.Date date ^Long period ^Long nb-occurences ^Boolean fixed-rate]
    (-> this (.addNotification type message user-data date period nb-occurences fixed-rate)))
  ([^. this ^java.lang.String type ^java.lang.String message ^java.lang.Object user-data ^java.util.Date date ^Long period ^Long nb-occurences]
    (-> this (.addNotification type message user-data date period nb-occurences)))
  ([^. this ^java.lang.String type ^java.lang.String message ^java.lang.Object user-data ^java.util.Date date ^Long period]
    (-> this (.addNotification type message user-data date period)))
  ([^. this ^java.lang.String type ^java.lang.String message ^java.lang.Object user-data ^java.util.Date date]
    (-> this (.addNotification type message user-data date))))

(defn remove-all-notifications
  "Removes all the timer notifications from the list of notifications
   and resets the counter used to update the timer notification identifiers."
  ([^. this]
    (-> this (.removeAllNotifications))))

(defn remove-notification
  "Removes the timer notification corresponding to the specified identifier from the list of notifications.

  id - The timer notification identifier. - `java.lang.Integer`

  throws: javax.management.InstanceNotFoundException - The specified identifier does not correspond to any timer notification in the list of notifications of this timer MBean."
  ([^. this ^java.lang.Integer id]
    (-> this (.removeNotification id))))

(defn empty?
  "Tests whether the list of timer notifications is empty.

  returns: true if the list of timer notifications is empty, false otherwise. - `boolean`"
  ([^. this]
    (-> this (.isEmpty))))

(defn remove-notifications
  "Removes all the timer notifications corresponding to the specified type from the list of notifications.

  type - The timer notification type. - `java.lang.String`

  throws: javax.management.InstanceNotFoundException - The specified type does not correspond to any timer notification in the list of notifications of this timer MBean."
  ([^. this ^java.lang.String type]
    (-> this (.removeNotifications type))))

