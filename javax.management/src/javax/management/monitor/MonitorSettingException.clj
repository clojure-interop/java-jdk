(ns javax.management.monitor.MonitorSettingException
  "Exception thrown by the monitor when a monitor setting becomes invalid while the monitor is running.

  As the monitor attributes may change at runtime, a check is performed before each observation.
  If a monitor attribute has become invalid, a monitor setting exception is thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.monitor MonitorSettingException]))

(defn ->monitor-setting-exception
  "Constructor.

  Constructor that allows an error message to be specified.

  message - The specific error message. - `java.lang.String`"
  ([^java.lang.String message]
    (new MonitorSettingException message))
  ([]
    (new MonitorSettingException )))

