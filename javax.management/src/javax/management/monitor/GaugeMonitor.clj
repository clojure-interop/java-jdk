(ns javax.management.monitor.GaugeMonitor
  "Defines a monitor MBean designed to observe the values of a gauge attribute.

   A gauge monitor observes an attribute that is continuously
  variable with time. A gauge monitor sends notifications as
  follows:



   if the attribute value is increasing and becomes equal to or
  greater than the high threshold value, a threshold high
  notification is sent. The notify high flag must be set to
  true.

  Subsequent crossings of the high threshold value do not cause
  further notifications unless the attribute value becomes equal to
  or less than the low threshold value.

   if the attribute value is decreasing and becomes equal to or
  less than the low threshold value, a threshold low
  notification is sent. The notify low flag must be set to
  true.

  Subsequent crossings of the low threshold value do not cause
  further notifications unless the attribute value becomes equal to
  or greater than the high threshold value.



  This provides a hysteresis mechanism to avoid repeated triggering
  of notifications when the attribute value makes small oscillations
  around the high or low threshold value.

   If the gauge difference mode is used, the value of the derived
  gauge is calculated as the difference between the observed gauge
  values for two successive observations.

  The derived gauge value (V[t]) is calculated using the following method:

  V[t] = gauge[t] - gauge[t-GP]


  This implementation of the gauge monitor requires the observed
  attribute to be of the type integer or floating-point
  (Byte, Integer, Short,
  Long, Float, Double)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.monitor GaugeMonitor]))

(defn ->gauge-monitor
  "Constructor.

  Default constructor."
  ([]
    (new GaugeMonitor )))

(defn stop
  "Stops the gauge monitor."
  ([this]
    (-> this (.stop))))

(defn set-notify-high
  "Sets the high notification's on/off switch value common to all
   observed MBeans.

  value - The high notification's on/off switch value. - `boolean`"
  ([this value]
    (-> this (.setNotifyHigh value))))

(defn set-notify-low
  "Sets the low notification's on/off switch value common to all
   observed MBeans.

  value - The low notification's on/off switch value. - `boolean`"
  ([this value]
    (-> this (.setNotifyLow value))))

(defn get-derived-gauge-time-stamp
  "Gets the derived gauge timestamp of the specified object, if
   this object is contained in the set of observed MBeans, or
   0 otherwise.

  object - the name of the object whose derived gauge timestamp is to be returned. - `javax.management.ObjectName`

  returns: The derived gauge timestamp of the specified object. - `long`"
  ([this object]
    (-> this (.getDerivedGaugeTimeStamp object)))
  ([this]
    (-> this (.getDerivedGaugeTimeStamp))))

(defn set-difference-mode
  "Sets the difference mode flag value common to all observed MBeans.

  value - The difference mode flag value. - `boolean`"
  ([this value]
    (-> this (.setDifferenceMode value))))

(defn get-notification-info
  "Returns a NotificationInfo object containing the
   name of the Java class of the notification and the notification
   types sent by the gauge monitor.

  returns: the array of possible notifications. - `javax.management.MBeanNotificationInfo[]`"
  ([this]
    (-> this (.getNotificationInfo))))

(defn get-notify-low?
  "Gets the low notification's on/off switch value common to all
   observed MBeans.

  returns: true if the gauge monitor notifies when
   exceeding the low threshold, false otherwise. - `boolean`"
  ([this]
    (-> this (.getNotifyLow))))

(defn get-high-threshold
  "Gets the high threshold value common to all observed MBeans.

  returns: The high threshold value. - `java.lang.Number`"
  ([this]
    (-> this (.getHighThreshold))))

(defn start
  "Starts the gauge monitor."
  ([this]
    (-> this (.start))))

(defn get-low-threshold
  "Gets the low threshold value common to all observed MBeans.

  returns: The low threshold value. - `java.lang.Number`"
  ([this]
    (-> this (.getLowThreshold))))

(defn set-thresholds
  "Sets the high and the low threshold values common to all
   observed MBeans.

  high-value - The high threshold value. - `java.lang.Number`
  low-value - The low threshold value. - `java.lang.Number`

  throws: java.lang.IllegalArgumentException - The specified high/low threshold is null or the low threshold is greater than the high threshold or the high threshold and the low threshold are not of the same type."
  ([this high-value low-value]
    (-> this (.setThresholds high-value low-value))))

(defn get-notify-high?
  "Gets the high notification's on/off switch value common to all
   observed MBeans.

  returns: true if the gauge monitor notifies when
   exceeding the high threshold, false otherwise. - `boolean`"
  ([this]
    (-> this (.getNotifyHigh))))

(defn get-difference-mode?
  "Gets the difference mode flag value common to all observed MBeans.

  returns: true if the difference mode is used,
   false otherwise. - `boolean`"
  ([this]
    (-> this (.getDifferenceMode))))

(defn get-derived-gauge
  "Gets the derived gauge of the specified object, if this object is
   contained in the set of observed MBeans, or null otherwise.

  object - the name of the MBean. - `javax.management.ObjectName`

  returns: The derived gauge of the specified object. - `java.lang.Number`"
  ([this object]
    (-> this (.getDerivedGauge object)))
  ([this]
    (-> this (.getDerivedGauge))))

