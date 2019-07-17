(ns javax.xml.bind.ValidationEvent
  "This event indicates that a problem was encountered while validating the
  incoming XML data during an unmarshal operation, while performing
  on-demand validation of the Java content tree, or while marshalling the
  Java content tree back to XML data."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind ValidationEvent]))

(defn get-severity
  "Retrieve the severity code for this warning/error.


   Must be one of ValidationError.WARNING,
   ValidationError.ERROR, or ValidationError.FATAL_ERROR.

  returns: the severity code for this warning/error - `int`"
  ([^. this]
    (-> this (.getSeverity))))

(defn get-message
  "Retrieve the text message for this warning/error.

  returns: the text message for this warning/error or null if one wasn't set - `java.lang.String`"
  ([^. this]
    (-> this (.getMessage))))

(defn get-linked-exception
  "Retrieve the linked exception for this warning/error.

  returns: the linked exception for this warning/error or null if one
           wasn't set - `java.lang.Throwable`"
  ([^. this]
    (-> this (.getLinkedException))))

(defn get-locator
  "Retrieve the locator for this warning/error.

  returns: the locator that indicates where the warning/error occurred - `javax.xml.bind.ValidationEventLocator`"
  ([^. this]
    (-> this (.getLocator))))

