(ns javax.xml.datatype.DatatypeConfigurationException
  "Indicates a serious configuration error."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.datatype DatatypeConfigurationException]))

(defn ->datatype-configuration-exception
  "Constructor.

  Create a new DatatypeConfigurationException with
   the specified detail message and cause.

  message - The detail message. - `java.lang.String`
  cause - The cause. A null value is permitted, and indicates that the cause is nonexistent or unknown. - `java.lang.Throwable`"
  ([message cause]
    (new DatatypeConfigurationException message cause))
  ([message]
    (new DatatypeConfigurationException message))
  ([]
    (new DatatypeConfigurationException )))

