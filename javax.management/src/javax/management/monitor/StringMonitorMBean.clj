(ns javax.management.monitor.StringMonitorMBean
  "Exposes the remote management interface of the string monitor MBean."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.monitor StringMonitorMBean]))

(defn get-derived-gauge
  "Gets the derived gauge for the specified MBean.

  object - the MBean for which the derived gauge is to be returned - `javax.management.ObjectName`

  returns: The derived gauge for the specified MBean if this MBean is in the
           set of observed MBeans, or null otherwise. - `java.lang.String`"
  ([this object]
    (-> this (.getDerivedGauge object)))
  ([this]
    (-> this (.getDerivedGauge))))

(defn get-derived-gauge-time-stamp
  "Gets the derived gauge timestamp for the specified MBean.

  object - the MBean for which the derived gauge timestamp is to be returned - `javax.management.ObjectName`

  returns: The derived gauge timestamp for the specified MBean if this MBean
           is in the set of observed MBeans, or null otherwise. - `long`"
  ([this object]
    (-> this (.getDerivedGaugeTimeStamp object)))
  ([this]
    (-> this (.getDerivedGaugeTimeStamp))))

(defn get-string-to-compare
  "Gets the string to compare with the observed attribute.

  returns: The string value. - `java.lang.String`"
  ([this]
    (-> this (.getStringToCompare))))

(defn set-string-to-compare
  "Sets the string to compare with the observed attribute.

  value - The string value. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - The specified string to compare is null."
  ([this value]
    (-> this (.setStringToCompare value))))

(defn get-notify-match?
  "Gets the matching notification's on/off switch value.

  returns: true if the string monitor notifies when
   matching, false otherwise. - `boolean`"
  ([this]
    (-> this (.getNotifyMatch))))

(defn set-notify-match
  "Sets the matching notification's on/off switch value.

  value - The matching notification's on/off switch value. - `boolean`"
  ([this value]
    (-> this (.setNotifyMatch value))))

(defn get-notify-differ?
  "Gets the differing notification's on/off switch value.

  returns: true if the string monitor notifies when
   differing, false otherwise. - `boolean`"
  ([this]
    (-> this (.getNotifyDiffer))))

(defn set-notify-differ
  "Sets the differing notification's on/off switch value.

  value - The differing notification's on/off switch value. - `boolean`"
  ([this value]
    (-> this (.setNotifyDiffer value))))

