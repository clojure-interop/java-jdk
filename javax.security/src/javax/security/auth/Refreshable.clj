(ns javax.security.auth.Refreshable
  "Objects such as credentials may optionally implement this
  interface to provide the capability to refresh itself.
  For example, a credential with a particular time-restricted lifespan
  may implement this interface to allow callers to refresh the time period
  for which it is valid."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth Refreshable]))

(defn current?
  "Determine if this Object is current.

  returns: true if this Object is currently current,
            false otherwise. - `boolean`"
  (^Boolean [^javax.security.auth.Refreshable this]
    (-> this (.isCurrent))))

(defn refresh
  "Update or extend the validity period for this
   Object.

  throws: java.lang.SecurityException - if the caller does not have permission to update or extend the validity period for this Object."
  ([^javax.security.auth.Refreshable this]
    (-> this (.refresh))))

