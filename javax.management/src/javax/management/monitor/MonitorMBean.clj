(ns javax.management.monitor.MonitorMBean
  "Exposes the remote management interface of monitor MBeans."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.monitor MonitorMBean]))

(defn stop
  "Stops the monitor."
  ([^MonitorMBean this]
    (-> this (.stop))))

(defn set-observed-attribute
  "Sets the attribute to observe.

  attribute - The attribute to observe. - `java.lang.String`"
  ([^MonitorMBean this ^java.lang.String attribute]
    (-> this (.setObservedAttribute attribute))))

(defn active?
  "Tests if the monitor MBean is active.
   A monitor MBean is marked active when the start method is called.
   It becomes inactive when the stop method is called.

  returns: true if the monitor MBean is active, false otherwise. - `boolean`"
  (^Boolean [^MonitorMBean this]
    (-> this (.isActive))))

(defn remove-observed-object
  "Removes the specified object from the set of observed MBeans.

  object - The object to remove. - `javax.management.ObjectName`"
  ([^MonitorMBean this ^javax.management.ObjectName object]
    (-> this (.removeObservedObject object))))

(defn contains-observed-object
  "Tests whether the specified object is in the set of observed MBeans.

  object - The object to check. - `javax.management.ObjectName`

  returns: true if the specified object is in the set, false otherwise. - `boolean`"
  (^Boolean [^MonitorMBean this ^javax.management.ObjectName object]
    (-> this (.containsObservedObject object))))

(defn add-observed-object
  "Adds the specified object in the set of observed MBeans.

  object - The object to observe. - `javax.management.ObjectName`

  throws: java.lang.IllegalArgumentException - the specified object is null."
  ([^MonitorMBean this ^javax.management.ObjectName object]
    (-> this (.addObservedObject object))))

(defn get-observed-object
  "Deprecated. As of JMX 1.2, replaced by getObservedObjects()

  returns: The object being observed. - `javax.management.ObjectName`"
  (^javax.management.ObjectName [^MonitorMBean this]
    (-> this (.getObservedObject))))

(defn get-observed-attribute
  "Gets the attribute being observed.

  returns: The attribute being observed. - `java.lang.String`"
  (^java.lang.String [^MonitorMBean this]
    (-> this (.getObservedAttribute))))

(defn set-observed-object
  "Deprecated. As of JMX 1.2, replaced by addObservedObject(javax.management.ObjectName)

  object - The object to observe. - `javax.management.ObjectName`"
  ([^MonitorMBean this ^javax.management.ObjectName object]
    (-> this (.setObservedObject object))))

(defn start
  "Starts the monitor."
  ([^MonitorMBean this]
    (-> this (.start))))

(defn get-observed-objects
  "Returns an array containing the objects being observed.

  returns: The objects being observed. - `javax.management.ObjectName[]`"
  ([^MonitorMBean this]
    (-> this (.getObservedObjects))))

(defn get-granularity-period
  "Gets the granularity period (in milliseconds).

  returns: The granularity period. - `long`"
  (^Long [^MonitorMBean this]
    (-> this (.getGranularityPeriod))))

(defn set-granularity-period
  "Sets the granularity period (in milliseconds).

  period - The granularity period. - `long`

  throws: java.lang.IllegalArgumentException - The granularity period is less than or equal to zero."
  ([^MonitorMBean this ^Long period]
    (-> this (.setGranularityPeriod period))))

