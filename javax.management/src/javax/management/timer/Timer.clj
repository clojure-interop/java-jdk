(ns javax.management.timer.Timer
  "Provides the implementation of the timer MBean.
  The timer MBean sends out an alarm at a specified time
  that wakes up all the listeners registered to receive timer notifications.


  This class manages a list of dated timer notifications.
  A method allows users to add/remove as many notifications as required.
  When a timer notification is emitted by the timer and becomes obsolete,
  it is automatically removed from the list of timer notifications.
  Additional timer notifications can be added into regularly repeating notifications.


  Note:

  When sending timer notifications, the timer updates the notification sequence number
  irrespective of the notification type.
  The timer service relies on the system date of the host where the Timer class is loaded.
  Listeners may receive untimely notifications
  if their host has a different system date.
  To avoid such problems, synchronize the system date of all host machines where timing is needed.
  The default behavior for periodic notifications is fixed-delay execution, as
      specified in Timer. In order to use fixed-rate execution, use the
      overloaded addNotification(String, String, Object, Date, long, long, boolean) method.
  Notification listeners are potentially all executed in the same
  thread.  Therefore, they should execute rapidly to avoid holding up
  other listeners or perturbing the regularity of fixed-delay
  executions.  See NotificationBroadcasterSupport."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.timer Timer]))

(defn ->timer
  "Constructor.

  Default constructor."
  ([]
    (new Timer )))

(def *-one-second
  "Static Constant.

  Number of milliseconds in one second.
   Useful constant for the addNotification method.

  type: long"
  Timer/ONE_SECOND)

(def *-one-minute
  "Static Constant.

  Number of milliseconds in one minute.
   Useful constant for the addNotification method.

  type: long"
  Timer/ONE_MINUTE)

(def *-one-hour
  "Static Constant.

  Number of milliseconds in one hour.
   Useful constant for the addNotification method.

  type: long"
  Timer/ONE_HOUR)

(def *-one-day
  "Static Constant.

  Number of milliseconds in one day.
   Useful constant for the addNotification method.

  type: long"
  Timer/ONE_DAY)

(def *-one-week
  "Static Constant.

  Number of milliseconds in one week.
   Useful constant for the addNotification method.

  type: long"
  Timer/ONE_WEEK)

(defn stop
  "Stops the timer."
  ([^javax.management.timer.Timer this]
    (-> this (.stop))))

(defn active?
  "Tests whether the timer MBean is active.
   A timer MBean is marked active when the start method is called.
   It becomes inactive when the stop method is called.
   The default value of the active on/off flag is false.

  returns: true if the timer MBean is active, false otherwise. - `boolean`"
  ([^javax.management.timer.Timer this]
    (-> this (.isActive))))

(defn get-notification-type
  "Gets the timer notification type corresponding to the specified identifier.

  id - The timer notification identifier. - `java.lang.Integer`

  returns: The timer notification type or null if the identifier is not mapped to any
   timer notification registered for this timer MBean. - `java.lang.String`"
  ([^javax.management.timer.Timer this ^java.lang.Integer id]
    (-> this (.getNotificationType id))))

(defn get-notification-i-ds
  "Gets all the identifiers of timer notifications corresponding to the specified type.

  type - The timer notification type. - `java.lang.String`

  returns: A vector of Integer objects containing all the identifiers of
   timer notifications with the specified type.
   The vector is empty if there is no timer notifications registered for this timer MBean
   with the specified type. - `java.util.Vector<java.lang.Integer>`"
  ([^javax.management.timer.Timer this ^java.lang.String type]
    (-> this (.getNotificationIDs type))))

(defn set-send-past-notifications
  "Sets the flag indicating whether the timer sends past notifications or not.
   The default value of the past notifications sending on/off flag is false.

  value - The past notifications sending on/off flag value. - `boolean`"
  ([^javax.management.timer.Timer this ^Boolean value]
    (-> this (.setSendPastNotifications value))))

(defn get-period
  "Gets a copy of the period (in milliseconds) associated to a timer notification.

  id - The timer notification identifier. - `java.lang.Integer`

  returns: A copy of the period or null if the identifier is not mapped to any
   timer notification registered for this timer MBean. - `java.lang.Long`"
  ([^javax.management.timer.Timer this ^java.lang.Integer id]
    (-> this (.getPeriod id))))

(defn get-fixed-rate?
  "Gets a copy of the flag indicating whether a periodic notification is
   executed at fixed-delay or at fixed-rate.

  id - The timer notification identifier. - `java.lang.Integer`

  returns: A copy of the flag indicating whether a periodic notification is
           executed at fixed-delay or at fixed-rate. - `java.lang.Boolean`"
  ([^javax.management.timer.Timer this ^java.lang.Integer id]
    (-> this (.getFixedRate id))))

(defn get-nb-occurences
  "Gets a copy of the remaining number of occurrences associated to a timer notification.

  id - The timer notification identifier. - `java.lang.Integer`

  returns: A copy of the remaining number of occurrences or null if the identifier is not mapped to any
   timer notification registered for this timer MBean. - `java.lang.Long`"
  ([^javax.management.timer.Timer this ^java.lang.Integer id]
    (-> this (.getNbOccurences id))))

(defn get-all-notification-i-ds
  "Gets all timer notification identifiers registered into the list of notifications.

  returns: A vector of Integer objects containing all the timer notification identifiers.
   The vector is empty if there is no timer notification registered for this timer MBean. - `java.util.Vector<java.lang.Integer>`"
  ([^javax.management.timer.Timer this]
    (-> this (.getAllNotificationIDs))))

(defn get-notification-info
  "Description copied from interface: NotificationBroadcaster

  returns: the array of possible notifications. - `javax.management.MBeanNotificationInfo[]`"
  ([^javax.management.timer.Timer this]
    (-> this (.getNotificationInfo))))

(defn post-deregister
  "Allows the timer MBean to perform any operations needed after having been
   unregistered by the MBean server.

   Not used in this context."
  ([^javax.management.timer.Timer this]
    (-> this (.postDeregister))))

(defn pre-deregister
  "Allows the timer MBean to perform any operations it needs before being unregistered
   by the MBean server.

   Stops the timer.

  throws: java.lang.Exception"
  ([^javax.management.timer.Timer this]
    (-> this (.preDeregister))))

(defn get-notification-user-data
  "Gets the timer notification user data object corresponding to the specified identifier.

  id - The timer notification identifier. - `java.lang.Integer`

  returns: The timer notification user data object or null if the identifier is not mapped to any
   timer notification registered for this timer MBean. - `java.lang.Object`"
  ([^javax.management.timer.Timer this ^java.lang.Integer id]
    (-> this (.getNotificationUserData id))))

(defn get-date
  "Gets a copy of the date associated to a timer notification.

  id - The timer notification identifier. - `java.lang.Integer`

  returns: A copy of the date or null if the identifier is not mapped to any
   timer notification registered for this timer MBean. - `java.util.Date`"
  ([^javax.management.timer.Timer this ^java.lang.Integer id]
    (-> this (.getDate id))))

(defn post-register
  "Allows the timer MBean to perform any operations needed after having been
   registered in the MBean server or after the registration has failed.

   Not used in this context.

  registration-done - Indicates whether or not the MBean has been successfully registered in the MBean server. The value false means that the registration phase has failed. - `java.lang.Boolean`"
  ([^javax.management.timer.Timer this ^java.lang.Boolean registration-done]
    (-> this (.postRegister registration-done))))

(defn start
  "Starts the timer.

   If there is one or more timer notifications before the time in the list of notifications, the notification
   is sent according to the sendPastNotifications flag and then, updated
   according to its period and remaining number of occurrences.
   If the timer notification date remains earlier than the current date, this notification is just removed
   from the list of notifications."
  ([^javax.management.timer.Timer this]
    (-> this (.start))))

(defn get-send-past-notifications?
  "Gets the flag indicating whether or not the timer sends past notifications.
   The default value of the past notifications sending on/off flag is false.

  returns: The past notifications sending on/off flag value. - `boolean`"
  ([^javax.management.timer.Timer this]
    (-> this (.getSendPastNotifications))))

(defn get-nb-notifications
  "Gets the number of timer notifications registered into the list of notifications.

  returns: The number of timer notifications. - `int`"
  ([^javax.management.timer.Timer this]
    (-> this (.getNbNotifications))))

(defn get-notification-message
  "Gets the timer notification detailed message corresponding to the specified identifier.

  id - The timer notification identifier. - `java.lang.Integer`

  returns: The timer notification detailed message or null if the identifier is not mapped to any
   timer notification registered for this timer MBean. - `java.lang.String`"
  ([^javax.management.timer.Timer this ^java.lang.Integer id]
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
  ([^javax.management.timer.Timer this ^java.lang.String type ^java.lang.String message ^java.lang.Object user-data ^java.util.Date date ^Long period ^Long nb-occurences ^Boolean fixed-rate]
    (-> this (.addNotification type message user-data date period nb-occurences fixed-rate)))
  ([^javax.management.timer.Timer this ^java.lang.String type ^java.lang.String message ^java.lang.Object user-data ^java.util.Date date ^Long period ^Long nb-occurences]
    (-> this (.addNotification type message user-data date period nb-occurences)))
  ([^javax.management.timer.Timer this ^java.lang.String type ^java.lang.String message ^java.lang.Object user-data ^java.util.Date date ^Long period]
    (-> this (.addNotification type message user-data date period)))
  ([^javax.management.timer.Timer this ^java.lang.String type ^java.lang.String message ^java.lang.Object user-data ^java.util.Date date]
    (-> this (.addNotification type message user-data date))))

(defn remove-all-notifications
  "Removes all the timer notifications from the list of notifications
   and resets the counter used to update the timer notification identifiers."
  ([^javax.management.timer.Timer this]
    (-> this (.removeAllNotifications))))

(defn remove-notification
  "Removes the timer notification corresponding to the specified identifier from the list of notifications.

  id - The timer notification identifier. - `java.lang.Integer`

  throws: javax.management.InstanceNotFoundException - The specified identifier does not correspond to any timer notification in the list of notifications of this timer MBean."
  ([^javax.management.timer.Timer this ^java.lang.Integer id]
    (-> this (.removeNotification id))))

(defn empty?
  "Tests whether the list of timer notifications is empty.

  returns: true if the list of timer notifications is empty, false otherwise. - `boolean`"
  ([^javax.management.timer.Timer this]
    (-> this (.isEmpty))))

(defn remove-notifications
  "Removes all the timer notifications corresponding to the specified type from the list of notifications.

  type - The timer notification type. - `java.lang.String`

  throws: javax.management.InstanceNotFoundException - The specified type does not correspond to any timer notification in the list of notifications of this timer MBean."
  ([^javax.management.timer.Timer this ^java.lang.String type]
    (-> this (.removeNotifications type))))

(defn pre-register
  "Allows the timer MBean to perform any operations it needs before being registered
   in the MBean server.

   Not used in this context.

  server - The MBean server in which the timer MBean will be registered. - `javax.management.MBeanServer`
  name - The object name of the timer MBean. - `javax.management.ObjectName`

  returns: The name of the timer MBean registered. - `javax.management.ObjectName`

  throws: java.lang.Exception"
  ([^javax.management.timer.Timer this ^javax.management.MBeanServer server ^javax.management.ObjectName name]
    (-> this (.preRegister server name))))

