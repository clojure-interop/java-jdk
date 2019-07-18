(ns javax.naming.ldap.UnsolicitedNotificationListener
  "This interface is for handling UnsolicitedNotificationEvent.
  `Unsolicited notification` is defined in
  RFC 2251.
  It allows the server to send unsolicited notifications to the client.
  A UnsolicitedNotificationListener must:

  Implement this interface and its method
  Implement NamingListener.namingExceptionThrown() so
  that it will be notified of exceptions thrown while attempting to
  collect unsolicited notification events.
  Register with the context using one of the addNamingListener()
  methods from EventContext or EventDirContext.
  Only the NamingListener argument of these methods are applicable;
  the rest are ignored for a UnsolicitedNotificationListener.
  (These arguments might be applicable to the listener if it implements
  other listener interfaces)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.ldap UnsolicitedNotificationListener]))

(defn notification-received
  "Called when an unsolicited notification has been received.

  evt - The non-null UnsolicitedNotificationEvent - `javax.naming.ldap.UnsolicitedNotificationEvent`"
  ([^UnsolicitedNotificationListener this ^javax.naming.ldap.UnsolicitedNotificationEvent evt]
    (-> this (.notificationReceived evt))))

