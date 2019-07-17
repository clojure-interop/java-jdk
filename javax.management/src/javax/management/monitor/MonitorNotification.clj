(ns javax.management.monitor.MonitorNotification
  "Provides definitions of the notifications sent by monitor MBeans.

  The notification source and a set of parameters concerning the monitor MBean's state
  need to be specified when creating a new object of this class.

  The list of notifications fired by the monitor MBeans is the following:


  Common to all kind of monitors:

      The observed object is not registered in the MBean server.
      The observed attribute is not contained in the observed object.
      The type of the observed attribute is not correct.
      Any exception (except the cases described above) occurs when trying to get the value of the observed attribute.

  Common to the counter and the gauge monitors:

      The threshold high or threshold low are not of the same type as the gauge (gauge monitors).
      The threshold or the offset or the modulus are not of the same type as the counter (counter monitors).

  Counter monitors only:

      The observed attribute has reached the threshold value.

  Gauge monitors only:

      The observed attribute has exceeded the threshold high value.
      The observed attribute has exceeded the threshold low value.

  String monitors only:

      The observed attribute has matched the `string to compare` value.
      The observed attribute has differed from the `string to compare` value."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.monitor MonitorNotification]))

(def *-observed-object-error
  "Static Constant.

  Notification type denoting that the observed object is not registered in the MBean server.
   This notification is fired by all kinds of monitors.
   The value of this notification type is jmx.monitor.error.mbean.

  type: java.lang.String"
  MonitorNotification/OBSERVED_OBJECT_ERROR)

(def *-observed-attribute-error
  "Static Constant.

  Notification type denoting that the observed attribute is not contained in the observed object.
   This notification is fired by all kinds of monitors.
   The value of this notification type is jmx.monitor.error.attribute.

  type: java.lang.String"
  MonitorNotification/OBSERVED_ATTRIBUTE_ERROR)

(def *-observed-attribute-type-error
  "Static Constant.

  Notification type denoting that the type of the observed attribute is not correct.
   This notification is fired by all kinds of monitors.
   The value of this notification type is jmx.monitor.error.type.

  type: java.lang.String"
  MonitorNotification/OBSERVED_ATTRIBUTE_TYPE_ERROR)

(def *-threshold-error
  "Static Constant.

  Notification type denoting that the type of the thresholds, offset or modulus is not correct.
   This notification is fired by counter and gauge monitors.
   The value of this notification type is jmx.monitor.error.threshold.

  type: java.lang.String"
  MonitorNotification/THRESHOLD_ERROR)

(def *-runtime-error
  "Static Constant.

  Notification type denoting that a non-predefined error type has occurred when trying to get the value of the observed attribute.
   This notification is fired by all kinds of monitors.
   The value of this notification type is jmx.monitor.error.runtime.

  type: java.lang.String"
  MonitorNotification/RUNTIME_ERROR)

(def *-threshold-value-exceeded
  "Static Constant.

  Notification type denoting that the observed attribute has reached the threshold value.
   This notification is only fired by counter monitors.
   The value of this notification type is jmx.monitor.counter.threshold.

  type: java.lang.String"
  MonitorNotification/THRESHOLD_VALUE_EXCEEDED)

(def *-threshold-high-value-exceeded
  "Static Constant.

  Notification type denoting that the observed attribute has exceeded the threshold high value.
   This notification is only fired by gauge monitors.
   The value of this notification type is jmx.monitor.gauge.high.

  type: java.lang.String"
  MonitorNotification/THRESHOLD_HIGH_VALUE_EXCEEDED)

(def *-threshold-low-value-exceeded
  "Static Constant.

  Notification type denoting that the observed attribute has exceeded the threshold low value.
   This notification is only fired by gauge monitors.
   The value of this notification type is jmx.monitor.gauge.low.

  type: java.lang.String"
  MonitorNotification/THRESHOLD_LOW_VALUE_EXCEEDED)

(def *-string-to-compare-value-matched
  "Static Constant.

  Notification type denoting that the observed attribute has matched the `string to compare` value.
   This notification is only fired by string monitors.
   The value of this notification type is jmx.monitor.string.matches.

  type: java.lang.String"
  MonitorNotification/STRING_TO_COMPARE_VALUE_MATCHED)

(def *-string-to-compare-value-differed
  "Static Constant.

  Notification type denoting that the observed attribute has differed from the `string to compare` value.
   This notification is only fired by string monitors.
   The value of this notification type is jmx.monitor.string.differs.

  type: java.lang.String"
  MonitorNotification/STRING_TO_COMPARE_VALUE_DIFFERED)

(defn get-observed-object
  "Gets the observed object of this monitor notification.

  returns: The observed object. - `javax.management.ObjectName`"
  (^javax.management.ObjectName [^javax.management.monitor.MonitorNotification this]
    (-> this (.getObservedObject))))

(defn get-observed-attribute
  "Gets the observed attribute of this monitor notification.

  returns: The observed attribute. - `java.lang.String`"
  (^java.lang.String [^javax.management.monitor.MonitorNotification this]
    (-> this (.getObservedAttribute))))

(defn get-derived-gauge
  "Gets the derived gauge of this monitor notification.

  returns: The derived gauge. - `java.lang.Object`"
  (^java.lang.Object [^javax.management.monitor.MonitorNotification this]
    (-> this (.getDerivedGauge))))

(defn get-trigger
  "Gets the threshold/string (depending on the monitor type) that triggered off this monitor notification.

  returns: The trigger. - `java.lang.Object`"
  (^java.lang.Object [^javax.management.monitor.MonitorNotification this]
    (-> this (.getTrigger))))

