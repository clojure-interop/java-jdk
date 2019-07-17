(ns javax.management.monitor.GaugeMonitorMBean
  "Exposes the remote management interface of the gauge monitor MBean."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.monitor GaugeMonitorMBean]))

(defn set-notify-high
  "Sets the high notification's on/off switch value.

  value - The high notification's on/off switch value. - `boolean`"
  ([^javax.management.monitor.GaugeMonitorMBean this ^Boolean value]
    (-> this (.setNotifyHigh value))))

(defn set-notify-low
  "Sets the low notification's on/off switch value.

  value - The low notification's on/off switch value. - `boolean`"
  ([^javax.management.monitor.GaugeMonitorMBean this ^Boolean value]
    (-> this (.setNotifyLow value))))

(defn get-derived-gauge-time-stamp
  "Gets the derived gauge timestamp for the specified MBean.

  object - the MBean for which the derived gauge timestamp is to be returned - `javax.management.ObjectName`

  returns: The derived gauge timestamp for the specified MBean if this MBean
           is in the set of observed MBeans, or null otherwise. - `long`"
  ([^javax.management.monitor.GaugeMonitorMBean this ^javax.management.ObjectName object]
    (-> this (.getDerivedGaugeTimeStamp object)))
  ([^javax.management.monitor.GaugeMonitorMBean this]
    (-> this (.getDerivedGaugeTimeStamp))))

(defn set-difference-mode
  "Sets the difference mode flag value.

  value - The difference mode flag value. - `boolean`"
  ([^javax.management.monitor.GaugeMonitorMBean this ^Boolean value]
    (-> this (.setDifferenceMode value))))

(defn get-notify-low?
  "Gets the low notification's on/off switch value.

  returns: true if the gauge monitor notifies when
   exceeding the low threshold, false otherwise. - `boolean`"
  ([^javax.management.monitor.GaugeMonitorMBean this]
    (-> this (.getNotifyLow))))

(defn get-high-threshold
  "Gets the high threshold value.

  returns: The high threshold value. - `java.lang.Number`"
  ([^javax.management.monitor.GaugeMonitorMBean this]
    (-> this (.getHighThreshold))))

(defn get-low-threshold
  "Gets the low threshold value.

  returns: The low threshold value. - `java.lang.Number`"
  ([^javax.management.monitor.GaugeMonitorMBean this]
    (-> this (.getLowThreshold))))

(defn set-thresholds
  "Sets the high and the low threshold values.

  high-value - The high threshold value. - `java.lang.Number`
  low-value - The low threshold value. - `java.lang.Number`

  throws: java.lang.IllegalArgumentException - The specified high/low threshold is null or the low threshold is greater than the high threshold or the high threshold and the low threshold are not of the same type."
  ([^javax.management.monitor.GaugeMonitorMBean this ^java.lang.Number high-value ^java.lang.Number low-value]
    (-> this (.setThresholds high-value low-value))))

(defn get-notify-high?
  "Gets the high notification's on/off switch value.

  returns: true if the gauge monitor notifies when
   exceeding the high threshold, false otherwise. - `boolean`"
  ([^javax.management.monitor.GaugeMonitorMBean this]
    (-> this (.getNotifyHigh))))

(defn get-difference-mode?
  "Gets the difference mode flag value.

  returns: true if the difference mode is used,
   false otherwise. - `boolean`"
  ([^javax.management.monitor.GaugeMonitorMBean this]
    (-> this (.getDifferenceMode))))

(defn get-derived-gauge
  "Gets the derived gauge for the specified MBean.

  object - the MBean for which the derived gauge is to be returned - `javax.management.ObjectName`

  returns: The derived gauge for the specified MBean if this MBean is in the
           set of observed MBeans, or null otherwise. - `java.lang.Number`"
  ([^javax.management.monitor.GaugeMonitorMBean this ^javax.management.ObjectName object]
    (-> this (.getDerivedGauge object)))
  ([^javax.management.monitor.GaugeMonitorMBean this]
    (-> this (.getDerivedGauge))))

