(ns javax.management.monitor.StringMonitor
  "Defines a monitor MBean designed to observe the values of a string
  attribute.

  A string monitor sends notifications as follows:

   if the attribute value matches the string to compare value,
       a match notification is sent.
       The notify match flag must be set to true.
       Subsequent matchings of the string to compare values do not
       cause further notifications unless
       the attribute value differs from the string to compare value.
   if the attribute value differs from the string to compare value,
       a differ notification is sent.
       The notify differ flag must be set to true.
       Subsequent differences from the string to compare value do
       not cause further notifications unless
       the attribute value matches the string to compare value."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.monitor StringMonitor]))

(defn ->string-monitor
  "Constructor.

  Default constructor."
  (^StringMonitor []
    (new StringMonitor )))

(defn stop
  "Stops the string monitor."
  ([^StringMonitor this]
    (-> this (.stop))))

(defn set-notify-differ
  "Sets the differing notification's on/off switch value common to
   all observed MBeans.

  value - The differing notification's on/off switch value. - `boolean`"
  ([^StringMonitor this ^Boolean value]
    (-> this (.setNotifyDiffer value))))

(defn get-derived-gauge-time-stamp
  "Gets the derived gauge timestamp of the specified object, if
   this object is contained in the set of observed MBeans, or
   0 otherwise.

  object - the name of the object whose derived gauge timestamp is to be returned. - `javax.management.ObjectName`

  returns: The derived gauge timestamp of the specified object. - `long`"
  (^Long [^StringMonitor this ^javax.management.ObjectName object]
    (-> this (.getDerivedGaugeTimeStamp object)))
  (^Long [^StringMonitor this]
    (-> this (.getDerivedGaugeTimeStamp))))

(defn get-notification-info
  "Returns a NotificationInfo object containing the name of
   the Java class of the notification and the notification types sent by
   the string monitor.

  returns: the array of possible notifications. - `javax.management.MBeanNotificationInfo[]`"
  ([^StringMonitor this]
    (-> this (.getNotificationInfo))))

(defn get-notify-match?
  "Gets the matching notification's on/off switch value common to
   all observed MBeans.

  returns: true if the string monitor notifies when
   matching the string to compare, false otherwise. - `boolean`"
  (^Boolean [^StringMonitor this]
    (-> this (.getNotifyMatch))))

(defn get-notify-differ?
  "Gets the differing notification's on/off switch value common to
   all observed MBeans.

  returns: true if the string monitor notifies when
   differing from the string to compare, false otherwise. - `boolean`"
  (^Boolean [^StringMonitor this]
    (-> this (.getNotifyDiffer))))

(defn set-notify-match
  "Sets the matching notification's on/off switch value common to
   all observed MBeans.

  value - The matching notification's on/off switch value. - `boolean`"
  ([^StringMonitor this ^Boolean value]
    (-> this (.setNotifyMatch value))))

(defn start
  "Starts the string monitor."
  ([^StringMonitor this]
    (-> this (.start))))

(defn set-string-to-compare
  "Sets the string to compare with the observed attribute common
   to all observed MBeans.

  value - The string value. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - The specified string to compare is null."
  ([^StringMonitor this ^java.lang.String value]
    (-> this (.setStringToCompare value))))

(defn get-string-to-compare
  "Gets the string to compare with the observed attribute common
   to all observed MBeans.

  returns: The string value. - `java.lang.String`"
  (^java.lang.String [^StringMonitor this]
    (-> this (.getStringToCompare))))

(defn get-derived-gauge
  "Gets the derived gauge of the specified object, if this object is
   contained in the set of observed MBeans, or null otherwise.

  object - the name of the MBean whose derived gauge is required. - `javax.management.ObjectName`

  returns: The derived gauge of the specified object. - `java.lang.String`"
  (^java.lang.String [^StringMonitor this ^javax.management.ObjectName object]
    (-> this (.getDerivedGauge object)))
  (^java.lang.String [^StringMonitor this]
    (-> this (.getDerivedGauge))))

