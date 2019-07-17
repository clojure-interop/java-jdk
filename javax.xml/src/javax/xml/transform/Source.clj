(ns javax.xml.transform.Source
  "An object that implements this interface contains the information
  needed to act as source input (XML source or transformation instructions)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.transform Source]))

(defn set-system-id
  "Set the system identifier for this Source.

   The system identifier is optional if the source does not
   get its data from a URL, but it may still be useful to provide one.
   The application can use a system identifier, for example, to resolve
   relative URIs and to include in error messages and warnings.

  system-id - The system identifier as a URL string. - `java.lang.String`"
  ([this system-id]
    (-> this (.setSystemId system-id))))

(defn get-system-id
  "Get the system identifier that was set with setSystemId.

  returns: The system identifier that was set with setSystemId, or null
   if setSystemId was not called. - `java.lang.String`"
  ([this]
    (-> this (.getSystemId))))

