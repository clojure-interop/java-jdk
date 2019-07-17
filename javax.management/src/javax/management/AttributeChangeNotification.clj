(ns javax.management.AttributeChangeNotification
  "Provides definitions of the attribute change notifications sent by MBeans.

  It's up to the MBean owning the attribute of interest to create and send
  attribute change notifications when the attribute change occurs.
  So the NotificationBroadcaster interface has to be implemented
  by any MBean for which an attribute change is of interest.

  Example:
  If an MBean called myMbean needs to notify registered listeners
  when its attribute:

       String myString

  is modified, myMbean creates and emits the following notification:

  new AttributeChangeNotification(myMbean, sequenceNumber, timeStamp, msg,
                                  `myString`, `String`, oldValue, newValue);"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management AttributeChangeNotification]))

(defn ->attribute-change-notification
  "Constructor.

  Constructs an attribute change notification object.
   In addition to the information common to all notification, the caller must supply the name and type
   of the attribute, as well as its old and new values.

  source - The notification producer, that is, the MBean the attribute belongs to. - `java.lang.Object`
  sequence-number - The notification sequence number within the source object. - `long`
  time-stamp - The date at which the notification is being sent. - `long`
  msg - A String containing the message of the notification. - `java.lang.String`
  attribute-name - A String giving the name of the attribute. - `java.lang.String`
  attribute-type - A String containing the type of the attribute. - `java.lang.String`
  old-value - An object representing value of the attribute before the change. - `java.lang.Object`
  new-value - An object representing value of the attribute after the change. - `java.lang.Object`"
  ([^java.lang.Object source ^Long sequence-number ^Long time-stamp ^java.lang.String msg ^java.lang.String attribute-name ^java.lang.String attribute-type ^java.lang.Object old-value ^java.lang.Object new-value]
    (new AttributeChangeNotification source sequence-number time-stamp msg attribute-name attribute-type old-value new-value)))

(def *-attribute-change
  "Static Constant.

  Notification type which indicates that the observed MBean attribute value has changed.
   The value of this type string is jmx.attribute.change.

  type: java.lang.String"
  AttributeChangeNotification/ATTRIBUTE_CHANGE)

(defn get-attribute-name
  "Gets the name of the attribute which has changed.

  returns: A String containing the name of the attribute. - `java.lang.String`"
  ([^javax.management.AttributeChangeNotification this]
    (-> this (.getAttributeName))))

(defn get-attribute-type
  "Gets the type of the attribute which has changed.

  returns: A String containing the type of the attribute. - `java.lang.String`"
  ([^javax.management.AttributeChangeNotification this]
    (-> this (.getAttributeType))))

(defn get-old-value
  "Gets the old value of the attribute which has changed.

  returns: An Object containing the old value of the attribute. - `java.lang.Object`"
  ([^javax.management.AttributeChangeNotification this]
    (-> this (.getOldValue))))

(defn get-new-value
  "Gets the new value of the attribute which has changed.

  returns: An Object containing the new value of the attribute. - `java.lang.Object`"
  ([^javax.management.AttributeChangeNotification this]
    (-> this (.getNewValue))))

