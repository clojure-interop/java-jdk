(ns javax.management.monitor.Monitor
  "Defines the part common to all monitor MBeans.
  A monitor MBean monitors values of an attribute common to a set of observed
  MBeans. The observed attribute is monitored at intervals specified by the
  granularity period. A gauge value (derived gauge) is derived from the values
  of the observed attribute."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.monitor Monitor]))

(defn ->monitor
  "Constructor."
  ([]
    (new Monitor )))

(defn stop
  "Stops the monitor."
  ([this]
    (-> this (.stop))))

(defn set-observed-attribute
  "Sets the attribute to observe.
   The observed attribute is not initialized by default (set to null).

  attribute - The attribute to observe. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - The specified attribute is null."
  ([this attribute]
    (-> this (.setObservedAttribute attribute))))

(defn active?
  "Tests whether the monitor MBean is active.  A monitor MBean is
   marked active when the start method is called.
   It becomes inactive when the stop method is
   called.

  returns: true if the monitor MBean is active,
   false otherwise. - `boolean`"
  ([this]
    (-> this (.isActive))))

(defn remove-observed-object
  "Removes the specified object from the set of observed MBeans.

  object - The object to remove. - `javax.management.ObjectName`"
  ([this object]
    (-> this (.removeObservedObject object))))

(defn contains-observed-object
  "Tests whether the specified object is in the set of observed MBeans.

  object - The object to check. - `javax.management.ObjectName`

  returns: true if the specified object is present,
   false otherwise. - `boolean`"
  ([this object]
    (-> this (.containsObservedObject object))))

(defn add-observed-object
  "Adds the specified object in the set of observed MBeans, if this object
   is not already present.

  object - The object to observe. - `javax.management.ObjectName`

  throws: java.lang.IllegalArgumentException - The specified object is null."
  ([this object]
    (-> this (.addObservedObject object))))

(defn post-deregister
  "Allows the monitor MBean to perform any operations needed after
   having been unregistered by the MBean server.

   Not used in this context."
  ([this]
    (-> this (.postDeregister))))

(defn get-observed-object
  "Deprecated. As of JMX 1.2, replaced by getObservedObjects()

  returns: The object being observed. - `java.lang.  javax.management.ObjectName`"
  ([this]
    (-> this (.getObservedObject))))

(defn pre-deregister
  "Allows the monitor MBean to perform any operations it needs
   before being unregistered by the MBean server.

   Stops the monitor.

  throws: java.lang.Exception"
  ([this]
    (-> this (.preDeregister))))

(defn get-observed-attribute
  "Gets the attribute being observed.
   The observed attribute is not initialized by default (set to null).

  returns: The attribute being observed. - `java.lang.String`"
  ([this]
    (-> this (.getObservedAttribute))))

(defn set-observed-object
  "Deprecated. As of JMX 1.2, replaced by addObservedObject(javax.management.ObjectName)

  object - The object to observe. - `javax.management.ObjectName`

  returns: `java.lang.  void`

  throws: java.lang.IllegalArgumentException - The specified object is null."
  ([this object]
    (-> this (.setObservedObject object))))

(defn post-register
  "Allows the monitor MBean to perform any operations needed after
   having been registered in the MBean server or after the
   registration has failed.

   Not used in this context.

  registration-done - Indicates whether or not the MBean has been successfully registered in the MBean server. The value false means that the registration phase has failed. - `java.lang.Boolean`"
  ([this registration-done]
    (-> this (.postRegister registration-done))))

(defn start
  "Starts the monitor."
  ([this]
    (-> this (.start))))

(defn get-observed-objects
  "Returns an array containing the objects being observed.

  returns: The objects being observed. - `javax.management.ObjectName[]`"
  ([this]
    (-> this (.getObservedObjects))))

(defn get-granularity-period
  "Gets the granularity period (in milliseconds).
   The default value of the granularity period is 10 seconds.

  returns: The granularity period value. - `long`"
  ([this]
    (-> this (.getGranularityPeriod))))

(defn pre-register
  "Allows the monitor MBean to perform any operations it needs
   before being registered in the MBean server.

   Initializes the reference to the MBean server.

  server - The MBean server in which the monitor MBean will be registered. - `javax.management.MBeanServer`
  name - The object name of the monitor MBean. - `javax.management.ObjectName`

  returns: The name of the monitor MBean registered. - `javax.management.ObjectName`

  throws: java.lang.Exception"
  ([this server name]
    (-> this (.preRegister server name))))

(defn set-granularity-period
  "Sets the granularity period (in milliseconds).
   The default value of the granularity period is 10 seconds.

  period - The granularity period value. - `long`

  throws: java.lang.IllegalArgumentException - The granularity period is less than or equal to zero."
  ([this period]
    (-> this (.setGranularityPeriod period))))

