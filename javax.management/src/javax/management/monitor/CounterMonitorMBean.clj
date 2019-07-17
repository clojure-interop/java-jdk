(ns javax.management.monitor.CounterMonitorMBean
  "Exposes the remote management interface of the counter monitor MBean."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.monitor CounterMonitorMBean]))

(defn set-notify
  "Sets the notification's on/off switch value.

  value - The notification's on/off switch value. - `boolean`"
  ([^javax.management.monitor.CounterMonitorMBean this ^Boolean value]
    (-> this (.setNotify value))))

(defn get-derived-gauge-time-stamp
  "Gets the derived gauge timestamp for the specified MBean.

  object - the MBean for which the derived gauge timestamp is to be returned - `javax.management.ObjectName`

  returns: The derived gauge timestamp for the specified MBean if this MBean
           is in the set of observed MBeans, or null otherwise. - `long`"
  ([^javax.management.monitor.CounterMonitorMBean this ^javax.management.ObjectName object]
    (-> this (.getDerivedGaugeTimeStamp object)))
  ([^javax.management.monitor.CounterMonitorMBean this]
    (-> this (.getDerivedGaugeTimeStamp))))

(defn set-difference-mode
  "Sets the difference mode flag value.

  value - The difference mode flag value. - `boolean`"
  ([^javax.management.monitor.CounterMonitorMBean this ^Boolean value]
    (-> this (.setDifferenceMode value))))

(defn get-offset
  "Gets the offset value.

  returns: The offset value. - `java.lang.Number`"
  ([^javax.management.monitor.CounterMonitorMBean this]
    (-> this (.getOffset))))

(defn set-modulus
  "Sets the modulus value.

  value - The modulus value. - `java.lang.Number`

  throws: java.lang.IllegalArgumentException - The specified modulus is null or the modulus value is less than zero."
  ([^javax.management.monitor.CounterMonitorMBean this ^java.lang.Number value]
    (-> this (.setModulus value))))

(defn get-init-threshold
  "Gets the initial threshold value common to all observed objects.

  returns: The initial threshold value. - `java.lang.Number`"
  ([^javax.management.monitor.CounterMonitorMBean this]
    (-> this (.getInitThreshold))))

(defn get-notify?
  "Gets the notification's on/off switch value.

  returns: true if the counter monitor notifies when
   exceeding the threshold, false otherwise. - `boolean`"
  ([^javax.management.monitor.CounterMonitorMBean this]
    (-> this (.getNotify))))

(defn get-modulus
  "Gets the modulus value.

  returns: The modulus value. - `java.lang.Number`"
  ([^javax.management.monitor.CounterMonitorMBean this]
    (-> this (.getModulus))))

(defn set-threshold
  "Deprecated. As of JMX 1.2, replaced by setInitThreshold(java.lang.Number)

  value - The threshold value. - `java.lang.Number`

  returns: `java.lang. void`

  throws: java.lang.IllegalArgumentException - The specified threshold is null or the threshold value is less than zero."
  ([^javax.management.monitor.CounterMonitorMBean this ^java.lang.Number value]
    (-> this (.setThreshold value))))

(defn get-threshold
  "Gets the threshold value for the specified MBean.

  object - the MBean for which the threshold value is to be returned - `javax.management.ObjectName`

  returns: The threshold value for the specified MBean if this MBean
           is in the set of observed MBeans, or null otherwise. - `java.lang.Number`"
  ([^javax.management.monitor.CounterMonitorMBean this ^javax.management.ObjectName object]
    (-> this (.getThreshold object)))
  ([^javax.management.monitor.CounterMonitorMBean this]
    (-> this (.getThreshold))))

(defn set-init-threshold
  "Sets the initial threshold value common to all observed MBeans.

  value - The initial threshold value. - `java.lang.Number`

  throws: java.lang.IllegalArgumentException - The specified threshold is null or the threshold value is less than zero."
  ([^javax.management.monitor.CounterMonitorMBean this ^java.lang.Number value]
    (-> this (.setInitThreshold value))))

(defn get-difference-mode?
  "Gets the difference mode flag value.

  returns: true if the difference mode is used,
   false otherwise. - `boolean`"
  ([^javax.management.monitor.CounterMonitorMBean this]
    (-> this (.getDifferenceMode))))

(defn set-offset
  "Sets the offset value.

  value - The offset value. - `java.lang.Number`

  throws: java.lang.IllegalArgumentException - The specified offset is null or the offset value is less than zero."
  ([^javax.management.monitor.CounterMonitorMBean this ^java.lang.Number value]
    (-> this (.setOffset value))))

(defn get-derived-gauge
  "Gets the derived gauge for the specified MBean.

  object - the MBean for which the derived gauge is to be returned - `javax.management.ObjectName`

  returns: The derived gauge for the specified MBean if this MBean is in the
           set of observed MBeans, or null otherwise. - `java.lang.Number`"
  ([^javax.management.monitor.CounterMonitorMBean this ^javax.management.ObjectName object]
    (-> this (.getDerivedGauge object)))
  ([^javax.management.monitor.CounterMonitorMBean this]
    (-> this (.getDerivedGauge))))

