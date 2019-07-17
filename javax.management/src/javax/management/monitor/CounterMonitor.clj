(ns javax.management.monitor.CounterMonitor
  "Defines a monitor MBean designed to observe the values of a counter
  attribute.

   A counter monitor sends a threshold
  notification when the value of the counter reaches or exceeds a
  threshold known as the comparison level.  The notify flag must be
  set to true.

   In addition, an offset mechanism enables particular counting
  intervals to be detected.  If the offset value is not zero,
  whenever the threshold is triggered by the counter value reaching a
  comparison level, that comparison level is incremented by the
  offset value.  This is regarded as taking place instantaneously,
  that is, before the count is incremented.  Thus, for each level,
  the threshold triggers an event notification every time the count
  increases by an interval equal to the offset value.

   If the counter can wrap around its maximum value, the modulus
  needs to be specified.  The modulus is the value at which the
  counter is reset to zero.

   If the counter difference mode is used, the value of the
  derived gauge is calculated as the difference between the observed
  counter values for two successive observations.  If this difference
  is negative, the value of the derived gauge is incremented by the
  value of the modulus.  The derived gauge value (V[t]) is calculated
  using the following method:


  if (counter[t] - counter[t-GP]) is positive then
  V[t] = counter[t] - counter[t-GP]
  if (counter[t] - counter[t-GP]) is negative then
  V[t] = counter[t] - counter[t-GP]  MODULUS


  This implementation of the counter monitor requires the observed
  attribute to be of the type integer (Byte,
  Integer, Short, Long)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.monitor CounterMonitor]))

(defn ->counter-monitor
  "Constructor.

  Default constructor."
  ([]
    (new CounterMonitor )))

(defn stop
  "Stops the counter monitor."
  ([^javax.management.monitor.CounterMonitor this]
    (-> this (.stop))))

(defn set-notify
  "Sets the notification's on/off switch value common to all
   observed MBeans.

  value - The notification's on/off switch value. - `boolean`"
  ([^javax.management.monitor.CounterMonitor this ^Boolean value]
    (-> this (.setNotify value))))

(defn get-derived-gauge-time-stamp
  "Gets the derived gauge timestamp of the specified object, if
   this object is contained in the set of observed MBeans, or
   0 otherwise.

  object - the name of the object whose derived gauge timestamp is to be returned. - `javax.management.ObjectName`

  returns: The derived gauge timestamp of the specified object. - `long`"
  ([^javax.management.monitor.CounterMonitor this ^javax.management.ObjectName object]
    (-> this (.getDerivedGaugeTimeStamp object)))
  ([^javax.management.monitor.CounterMonitor this]
    (-> this (.getDerivedGaugeTimeStamp))))

(defn set-difference-mode
  "Sets the difference mode flag value common to all observed MBeans.

  value - The difference mode flag value. - `boolean`"
  ([^javax.management.monitor.CounterMonitor this ^Boolean value]
    (-> this (.setDifferenceMode value))))

(defn get-notification-info
  "Returns a NotificationInfo object containing the
   name of the Java class of the notification and the notification
   types sent by the counter monitor.

  returns: the array of possible notifications. - `javax.management.MBeanNotificationInfo[]`"
  ([^javax.management.monitor.CounterMonitor this]
    (-> this (.getNotificationInfo))))

(defn get-offset
  "Gets the offset value common to all observed MBeans.

  returns: The offset value. - `java.lang.Number`"
  ([^javax.management.monitor.CounterMonitor this]
    (-> this (.getOffset))))

(defn start
  "Starts the counter monitor."
  ([^javax.management.monitor.CounterMonitor this]
    (-> this (.start))))

(defn set-modulus
  "Sets the modulus value common to all observed MBeans.

  value - The modulus value. - `java.lang.Number`

  throws: java.lang.IllegalArgumentException - The specified modulus is null or the modulus value is less than zero."
  ([^javax.management.monitor.CounterMonitor this ^java.lang.Number value]
    (-> this (.setModulus value))))

(defn get-init-threshold
  "Gets the initial threshold value common to all observed objects.

  returns: The initial threshold. - `java.lang.Number`"
  ([^javax.management.monitor.CounterMonitor this]
    (-> this (.getInitThreshold))))

(defn get-notify?
  "Gets the notification's on/off switch value common to all
   observed MBeans.

  returns: true if the counter monitor notifies when
   exceeding the threshold, false otherwise. - `boolean`"
  ([^javax.management.monitor.CounterMonitor this]
    (-> this (.getNotify))))

(defn get-modulus
  "Gets the modulus value common to all observed MBeans.

  returns: The modulus value. - `java.lang.Number`"
  ([^javax.management.monitor.CounterMonitor this]
    (-> this (.getModulus))))

(defn set-threshold
  "Deprecated. As of JMX 1.2, replaced by setInitThreshold(java.lang.Number)

  value - The initial threshold value. - `java.lang.Number`

  returns: `java.lang.  void`

  throws: java.lang.IllegalArgumentException - The specified threshold is null or the threshold value is less than zero."
  ([^javax.management.monitor.CounterMonitor this ^java.lang.Number value]
    (-> this (.setThreshold value))))

(defn get-threshold
  "Gets the current threshold value of the specified object, if
   this object is contained in the set of observed MBeans, or
   null otherwise.

  object - the name of the object whose threshold is to be returned. - `javax.management.ObjectName`

  returns: The threshold value of the specified object. - `java.lang.Number`"
  ([^javax.management.monitor.CounterMonitor this ^javax.management.ObjectName object]
    (-> this (.getThreshold object)))
  ([^javax.management.monitor.CounterMonitor this]
    (-> this (.getThreshold))))

(defn set-init-threshold
  "Sets the initial threshold value common to all observed objects.

   The current threshold of every object in the set of
   observed MBeans is updated consequently.

  value - The initial threshold value. - `java.lang.Number`

  throws: java.lang.IllegalArgumentException - The specified threshold is null or the threshold value is less than zero."
  ([^javax.management.monitor.CounterMonitor this ^java.lang.Number value]
    (-> this (.setInitThreshold value))))

(defn get-difference-mode?
  "Gets the difference mode flag value common to all observed MBeans.

  returns: true if the difference mode is used,
   false otherwise. - `boolean`"
  ([^javax.management.monitor.CounterMonitor this]
    (-> this (.getDifferenceMode))))

(defn set-offset
  "Sets the offset value common to all observed MBeans.

  value - The offset value. - `java.lang.Number`

  throws: java.lang.IllegalArgumentException - The specified offset is null or the offset value is less than zero."
  ([^javax.management.monitor.CounterMonitor this ^java.lang.Number value]
    (-> this (.setOffset value))))

(defn get-derived-gauge
  "Gets the derived gauge of the specified object, if this object is
   contained in the set of observed MBeans, or null otherwise.

  object - the name of the object whose derived gauge is to be returned. - `javax.management.ObjectName`

  returns: The derived gauge of the specified object. - `java.lang.Number`"
  ([^javax.management.monitor.CounterMonitor this ^javax.management.ObjectName object]
    (-> this (.getDerivedGauge object)))
  ([^javax.management.monitor.CounterMonitor this]
    (-> this (.getDerivedGauge))))

