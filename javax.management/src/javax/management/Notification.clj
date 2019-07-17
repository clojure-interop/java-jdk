(ns javax.management.Notification
  "The Notification class represents a notification emitted by an
  MBean.  It contains a reference to the source MBean: if the
  notification has been forwarded through the MBean server, and the
  original source of the notification was a reference to the emitting
  MBean object, then the MBean server replaces it by the MBean's
  ObjectName.  If the listener has registered directly with the
  MBean, this is either the object name or a direct reference to the
  MBean.

  It is strongly recommended that notification senders use the
  object name rather than a reference to the MBean object as the
  source.

  The serialVersionUID of this class is -7516092053498031989L."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management Notification]))

(defn ->notification
  "Constructor.

  Creates a Notification object.

  type - The notification type. - `java.lang.String`
  source - The notification source. - `java.lang.Object`
  sequence-number - The notification sequence number within the source object. - `long`
  time-stamp - The notification emission date. - `long`
  message - The detailed message. - `java.lang.String`"
  ([^java.lang.String type ^java.lang.Object source ^Long sequence-number ^Long time-stamp ^java.lang.String message]
    (new Notification type source sequence-number time-stamp message))
  ([^java.lang.String type ^java.lang.Object source ^Long sequence-number ^java.lang.String message]
    (new Notification type source sequence-number message))
  ([^java.lang.String type ^java.lang.Object source ^Long sequence-number]
    (new Notification type source sequence-number)))

(defn get-type
  "Get the notification type.

  returns: The notification type. It's a string expressed in a dot notation
   similar to Java properties. It is recommended that the notification type
   should follow the reverse-domain-name convention used by Java package
   names.  An example of a notification type is com.example.alarm.router. - `java.lang.String`"
  (^java.lang.String [^javax.management.Notification this]
    (-> this (.getType))))

(defn get-user-data
  "Get the user data.

  returns: The user data object. It is used for whatever data
   the notification source wishes to communicate to its consumers. - `java.lang.Object`"
  (^java.lang.Object [^javax.management.Notification this]
    (-> this (.getUserData))))

(defn set-sequence-number
  "Set the notification sequence number.

  sequence-number - The notification sequence number within the source object. It is a serial number identifying a particular instance of notification in the context of the notification source. - `long`"
  ([^javax.management.Notification this ^Long sequence-number]
    (-> this (.setSequenceNumber sequence-number))))

(defn set-time-stamp
  "Set the notification timestamp.

  time-stamp - The notification timestamp. It indicates when the notification was generated. - `long`"
  ([^javax.management.Notification this ^Long time-stamp]
    (-> this (.setTimeStamp time-stamp))))

(defn to-string
  "Returns a String representation of this notification.

  returns: A String representation of this notification. - `java.lang.String`"
  (^java.lang.String [^javax.management.Notification this]
    (-> this (.toString))))

(defn get-time-stamp
  "Get the notification timestamp.

  returns: The notification timestamp. - `long`"
  (^Long [^javax.management.Notification this]
    (-> this (.getTimeStamp))))

(defn get-message
  "Get the notification message.

  returns: The message string of this notification object. - `java.lang.String`"
  (^java.lang.String [^javax.management.Notification this]
    (-> this (.getMessage))))

(defn set-user-data
  "Set the user data.

  user-data - The user data object. It is used for whatever data the notification source wishes to communicate to its consumers. - `java.lang.Object`"
  ([^javax.management.Notification this ^java.lang.Object user-data]
    (-> this (.setUserData user-data))))

(defn set-source
  "Sets the source.

  source - the new source for this object. - `java.lang.Object`"
  ([^javax.management.Notification this ^java.lang.Object source]
    (-> this (.setSource source))))

(defn get-sequence-number
  "Get the notification sequence number.

  returns: The notification sequence number within the source object. It's a serial number
   identifying a particular instance of notification in the context of the notification source.
   The notification model does not assume that notifications will be received in the same order
   that they are sent. The sequence number helps listeners to sort received notifications. - `long`"
  (^Long [^javax.management.Notification this]
    (-> this (.getSequenceNumber))))

