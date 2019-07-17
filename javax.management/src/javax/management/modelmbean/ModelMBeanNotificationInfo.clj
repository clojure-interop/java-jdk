(ns javax.management.modelmbean.ModelMBeanNotificationInfo
  "The ModelMBeanNotificationInfo object describes a notification emitted
  by a ModelMBean.
  It is a subclass of MBeanNotificationInfo with the addition of an
  associated Descriptor and an implementation of the Descriptor interface.


  The fields in the descriptor are defined, but not limited to, the following.
  Note that when the Type in this table is Number, a String that is the decimal
  representation of a Long can also be used.


  NameTypeMeaning
  nameString
      Notification name.
  descriptorTypeString
      Must be `notification`.
  severityNumber
      0-6 where 0: unknown; 1: non-recoverable;
          2: critical, failure; 3: major, severe;
          4: minor, marginal, error; 5: warning;
          6: normal, cleared, informative
  messageIDString
      Unique key for message text (to allow translation, analysis).
  messageTextString
      Text of notification.
  logString
      T - log message, F - do not log message.
  logfileString
      fully qualified file name appropriate for operating system.
  visibilityNumber
      1-4 where 1: always visible 4: rarely visible.
  presentationStringString
      XML formatted string to allow presentation of data.


  The default descriptor contains the name, descriptorType,
  displayName and severity(=6) fields.  The default value of the name
  and displayName fields is the name of the Notification class (as
  specified by the name parameter of the
  ModelMBeanNotificationInfo constructor).

  The serialVersionUID of this class is -7445681389570207141L."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.modelmbean ModelMBeanNotificationInfo]))

(defn ->model-m-bean-notification-info
  "Constructor.

  Constructs a ModelMBeanNotificationInfo object.

  notif-types - The array of strings (in dot notation) containing the notification types that may be emitted. - `java.lang.String[]`
  name - The name of the Notification class. - `java.lang.String`
  description - A human readable description of the Notification. Optional. - `java.lang.String`
  descriptor - An instance of Descriptor containing the appropriate metadata for this instance of the MBeanNotificationInfo. If it is null a default descriptor will be created. If the descriptor does not contain the fields `displayName` or `severity`, the missing ones are added with their default values. - `javax.management.Descriptor`

  throws: javax.management.RuntimeOperationsException - Wraps an IllegalArgumentException. The descriptor is invalid, or descriptor field `name` is not equal to parameter name, or descriptor field `descriptorType` is not equal to `notification`."
  ([notif-types ^java.lang.String name ^java.lang.String description ^javax.management.Descriptor descriptor]
    (new ModelMBeanNotificationInfo notif-types name description descriptor))
  ([notif-types ^java.lang.String name ^java.lang.String description]
    (new ModelMBeanNotificationInfo notif-types name description))
  ([^javax.management.modelmbean.ModelMBeanNotificationInfo in-info]
    (new ModelMBeanNotificationInfo in-info)))

(defn clone
  "Creates and returns a new ModelMBeanNotificationInfo which is a
   duplicate of this ModelMBeanNotificationInfo.

  returns: a clone of this instance. - `java.lang.Object`"
  (^java.lang.Object [^javax.management.modelmbean.ModelMBeanNotificationInfo this]
    (-> this (.clone))))

(defn get-descriptor
  "Returns a copy of the associated Descriptor for the
   ModelMBeanNotificationInfo.

  returns: Descriptor associated with the
   ModelMBeanNotificationInfo object. - `javax.management.Descriptor`"
  (^javax.management.Descriptor [^javax.management.modelmbean.ModelMBeanNotificationInfo this]
    (-> this (.getDescriptor))))

(defn set-descriptor
  "Sets associated Descriptor (full replace) for the
   ModelMBeanNotificationInfo If the new Descriptor is null,
   then the associated Descriptor reverts to a default
   descriptor.  The Descriptor is validated before it is
   assigned.  If the new Descriptor is invalid, then a
   RuntimeOperationsException wrapping an
   IllegalArgumentException is thrown.

  in-descriptor - replaces the Descriptor associated with the ModelMBeanNotification interface - `javax.management.Descriptor`

  throws: javax.management.RuntimeOperationsException - Wraps an IllegalArgumentException for invalid Descriptor."
  ([^javax.management.modelmbean.ModelMBeanNotificationInfo this ^javax.management.Descriptor in-descriptor]
    (-> this (.setDescriptor in-descriptor))))

(defn to-string
  "Returns a human readable string containing
   ModelMBeanNotificationInfo.

  returns: a string describing this object. - `java.lang.String`"
  (^java.lang.String [^javax.management.modelmbean.ModelMBeanNotificationInfo this]
    (-> this (.toString))))

