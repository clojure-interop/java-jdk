(ns javax.management.openmbean.OpenDataException
  "This checked exception is thrown when an open type, an open data  or an open MBean metadata info instance
  could not be constructed because one or more validity constraints were not met."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean OpenDataException]))

(defn ->open-data-exception
  "Constructor.

  An OpenDataException with a detail message.

  msg - the detail message. - `java.lang.String`"
  ([msg]
    (new OpenDataException msg))
  ([]
    (new OpenDataException )))

