(ns javax.management.relation.MBeanServerNotificationFilter
  "Filter for MBeanServerNotification.
  This filter filters MBeanServerNotification notifications by
  selecting the ObjectNames of interest and the operations (registration,
  unregistration, both) of interest (corresponding to notification
  types).

  The serialVersionUID of this class is 2605900539589789736L."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation MBeanServerNotificationFilter]))

(defn ->m-bean-server-notification-filter
  "Constructor.

  Creates a filter selecting all MBeanServerNotification notifications for
   all ObjectNames."
  ([]
    (new MBeanServerNotificationFilter )))

(defn disable-all-object-names
  "Disables any MBeanServerNotification (all ObjectNames are
   deselected)."
  ([this]
    (-> this (.disableAllObjectNames))))

(defn disable-object-name
  "Disables MBeanServerNotifications concerning given ObjectName.

  object-name - ObjectName no longer of interest - `javax.management.ObjectName`

  throws: java.lang.IllegalArgumentException - if the given ObjectName is null"
  ([this object-name]
    (-> this (.disableObjectName object-name))))

(defn enable-all-object-names
  "Enables all MBeanServerNotifications (all ObjectNames are selected)."
  ([this]
    (-> this (.enableAllObjectNames))))

(defn enable-object-name
  "Enables MBeanServerNotifications concerning given ObjectName.

  object-name - ObjectName of interest - `javax.management.ObjectName`

  throws: java.lang.IllegalArgumentException - if the given ObjectName is null"
  ([this object-name]
    (-> this (.enableObjectName object-name))))

(defn get-enabled-object-names
  "Gets all the ObjectNames enabled.

  returns: Vector of ObjectNames:
   - null means all ObjectNames are implicitly selected, except the
   ObjectNames explicitly deselected
   - empty means all ObjectNames are deselected, i.e. no ObjectName
   selected. - `java.util.Vector<javax.management.ObjectName>`"
  ([this]
    (-> this (.getEnabledObjectNames))))

(defn get-disabled-object-names
  "Gets all the ObjectNames disabled.

  returns: Vector of ObjectNames:
   - null means all ObjectNames are implicitly deselected, except the
   ObjectNames explicitly selected
   - empty means all ObjectNames are selected, i.e. no ObjectName
   deselected. - `java.util.Vector<javax.management.ObjectName>`"
  ([this]
    (-> this (.getDisabledObjectNames))))

(defn notification-enabled?
  "Invoked before sending the specified notification to the listener.
   If:
   - the ObjectName of the concerned MBean is selected (explicitly OR
   (implicitly and not explicitly deselected))
   AND
   - the type of the operation (registration or unregistration) is
   selected
   then the notification is sent to the listener.

  notif - The notification to be sent. - `javax.management.Notification`

  returns: true if the notification has to be sent to the listener, false
   otherwise. - `boolean`

  throws: java.lang.IllegalArgumentException - if null parameter"
  ([this notif]
    (-> this (.isNotificationEnabled notif))))

