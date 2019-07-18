(ns javax.xml.transform.Result
  "An object that implements this interface contains the information
  needed to build a transformation result tree."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.transform Result]))

(defn set-system-id
  "Set the system identifier for this Result.

   If the Result is not to be written to a file, the system identifier is optional.
   The application may still want to provide one, however, for use in error messages
   and warnings, or to resolve relative output identifiers.

  system-id - The system identifier as a URI string. - `java.lang.String`"
  ([^Result this ^java.lang.String system-id]
    (-> this (.setSystemId system-id))))

(defn get-system-id
  "Get the system identifier that was set with setSystemId.

  returns: The system identifier that was set with setSystemId,
   or null if setSystemId was not called. - `java.lang.String`"
  (^java.lang.String [^Result this]
    (-> this (.getSystemId))))

