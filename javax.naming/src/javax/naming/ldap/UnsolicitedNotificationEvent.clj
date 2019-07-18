(ns javax.naming.ldap.UnsolicitedNotificationEvent
  "This class represents an event fired in response to an unsolicited
  notification sent by the LDAP server."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.ldap UnsolicitedNotificationEvent]))

(defn ->unsolicited-notification-event
  "Constructor.

  Constructs a new instance of UnsolicitedNotificationEvent.

  src - The non-null source that fired the event. - `java.lang.Object`
  notice - The non-null unsolicited notification. - `javax.naming.ldap.UnsolicitedNotification`"
  (^UnsolicitedNotificationEvent [^java.lang.Object src ^javax.naming.ldap.UnsolicitedNotification notice]
    (new UnsolicitedNotificationEvent src notice)))

(defn get-notification
  "Returns the unsolicited notification.

  returns: The non-null unsolicited notification that caused this
   event to be fired. - `javax.naming.ldap.UnsolicitedNotification`"
  (^javax.naming.ldap.UnsolicitedNotification [^UnsolicitedNotificationEvent this]
    (-> this (.getNotification))))

(defn dispatch
  "Invokes the notificationReceived() method on
   a listener using this event.

  listener - The non-null listener on which to invoke notificationReceived. - `javax.naming.ldap.UnsolicitedNotificationListener`"
  ([^UnsolicitedNotificationEvent this ^javax.naming.ldap.UnsolicitedNotificationListener listener]
    (-> this (.dispatch listener))))

