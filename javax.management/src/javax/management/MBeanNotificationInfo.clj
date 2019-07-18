(ns javax.management.MBeanNotificationInfo
  "The MBeanNotificationInfo class is used to describe the
  characteristics of the different notification instances
  emitted by an MBean, for a given Java class of notification.
  If an MBean emits notifications that can be instances of different Java classes,
  then the metadata for that MBean should provide an MBeanNotificationInfo
  object for each of these notification Java classes.

  Instances of this class are immutable.  Subclasses may be
  mutable but this is not recommended.

  This class extends javax.management.MBeanFeatureInfo
  and thus provides name and description fields.
  The name field should be the fully qualified Java class name of
  the notification objects described by this class.

  The getNotifTypes method returns an array of
  strings containing the notification types that the MBean may
  emit. The notification type is a dot-notation string which
  describes what the emitted notification is about, not the Java
  class of the notification.  A single generic notification class can
  be used to send notifications of several types.  All of these types
  are returned in the string array result of the
  getNotifTypes method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management MBeanNotificationInfo]))

(defn ->m-bean-notification-info
  "Constructor.

  Constructs an MBeanNotificationInfo object.

  notif-types - The array of strings (in dot notation) containing the notification types that the MBean may emit. This may be null with the same effect as a zero-length array. - `java.lang.String[]`
  name - The fully qualified Java class name of the described notifications. - `java.lang.String`
  description - A human readable description of the data. - `java.lang.String`
  descriptor - The descriptor for the notifications. This may be null which is equivalent to an empty descriptor. - `javax.management.Descriptor`"
  (^MBeanNotificationInfo [notif-types ^java.lang.String name ^java.lang.String description ^javax.management.Descriptor descriptor]
    (new MBeanNotificationInfo notif-types name description descriptor))
  (^MBeanNotificationInfo [notif-types ^java.lang.String name ^java.lang.String description]
    (new MBeanNotificationInfo notif-types name description)))

(defn clone
  "Returns a shallow clone of this instance.
   The clone is obtained by simply calling super.clone(),
   thus calling the default native shallow cloning mechanism
   implemented by Object.clone().
   No deeper cloning of any internal field is made.

  returns: a clone of this instance. - `java.lang.Object`"
  (^java.lang.Object [^MBeanNotificationInfo this]
    (-> this (.clone))))

(defn get-notif-types
  "Returns the array of strings (in dot notation) containing the
   notification types that the MBean may emit.

  returns: the array of strings.  Changing the returned array has no
   effect on this MBeanNotificationInfo. - `java.lang.String[]`"
  ([^MBeanNotificationInfo this]
    (-> this (.getNotifTypes))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^MBeanNotificationInfo this]
    (-> this (.toString))))

(defn equals
  "Compare this MBeanNotificationInfo to another.

  o - the object to compare to. - `java.lang.Object`

  returns: true if and only if o is an MBeanNotificationInfo
   such that its MBeanFeatureInfo.getName(), MBeanFeatureInfo.getDescription(),
   MBeanFeatureInfo.getDescriptor(),
   and getNotifTypes() values are equal (not necessarily
   identical) to those of this MBeanNotificationInfo.  Two
   notification type arrays are equal if their corresponding
   elements are equal.  They are not equal if they have the same
   elements but in a different order. - `boolean`"
  (^Boolean [^MBeanNotificationInfo this ^java.lang.Object o]
    (-> this (.equals o))))

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  (^Integer [^MBeanNotificationInfo this]
    (-> this (.hashCode))))

