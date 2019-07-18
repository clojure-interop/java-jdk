(ns javax.xml.bind.helpers.ValidationEventImpl
  "Default implementation of the ValidationEvent interface.


  JAXB providers are allowed to use whatever class that implements
  the ValidationEvent interface. This class is just provided for a
  convenience."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind.helpers ValidationEventImpl]))

(defn ->validation-event-impl
  "Constructor.

  Create a new ValidationEventImpl.

  severity - The severity value for this event. Must be one of ValidationEvent.WARNING, ValidationEvent.ERROR, or ValidationEvent.FATAL_ERROR - `int`
  message - The text message for this event - may be null. - `java.lang.String`
  locator - The locator object for this event - may be null. - `javax.xml.bind.ValidationEventLocator`
  linked-exception - An optional linked exception that may provide additional information about the event - may be null. - `java.lang.Throwable`

  throws: java.lang.IllegalArgumentException - if an illegal severity field is supplied"
  (^ValidationEventImpl [^Integer severity ^java.lang.String message ^javax.xml.bind.ValidationEventLocator locator ^java.lang.Throwable linked-exception]
    (new ValidationEventImpl severity message locator linked-exception))
  (^ValidationEventImpl [^Integer severity ^java.lang.String message ^javax.xml.bind.ValidationEventLocator locator]
    (new ValidationEventImpl severity message locator)))

(defn get-linked-exception
  "Description copied from interface: ValidationEvent

  returns: the linked exception for this warning/error or null if one
           wasn't set - `java.lang.Throwable`"
  (^java.lang.Throwable [^ValidationEventImpl this]
    (-> this (.getLinkedException))))

(defn set-locator
  "Set the locator object for this event.

  locator - The locator - may be null. - `javax.xml.bind.ValidationEventLocator`"
  ([^ValidationEventImpl this ^javax.xml.bind.ValidationEventLocator locator]
    (-> this (.setLocator locator))))

(defn get-severity
  "Description copied from interface: ValidationEvent

  returns: the severity code for this warning/error - `int`"
  (^Integer [^ValidationEventImpl this]
    (-> this (.getSeverity))))

(defn to-string
  "Returns a string representation of this object in a format
   helpful to debugging.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^ValidationEventImpl this]
    (-> this (.toString))))

(defn set-severity
  "Set the severity field of this event.

  severity - Must be one of ValidationEvent.WARNING, ValidationEvent.ERROR, or ValidationEvent.FATAL_ERROR. - `int`

  throws: java.lang.IllegalArgumentException - if an illegal severity field is supplied"
  ([^ValidationEventImpl this ^Integer severity]
    (-> this (.setSeverity severity))))

(defn set-linked-exception
  "Set the linked exception field of this event.

  linked-exception - Optional linked exception - may be null. - `java.lang.Throwable`"
  ([^ValidationEventImpl this ^java.lang.Throwable linked-exception]
    (-> this (.setLinkedException linked-exception))))

(defn get-locator
  "Description copied from interface: ValidationEvent

  returns: the locator that indicates where the warning/error occurred - `javax.xml.bind.ValidationEventLocator`"
  (^javax.xml.bind.ValidationEventLocator [^ValidationEventImpl this]
    (-> this (.getLocator))))

(defn get-message
  "Description copied from interface: ValidationEvent

  returns: the text message for this warning/error or null if one wasn't set - `java.lang.String`"
  (^java.lang.String [^ValidationEventImpl this]
    (-> this (.getMessage))))

(defn set-message
  "Set the message field of this event.

  message - String message - may be null. - `java.lang.String`"
  ([^ValidationEventImpl this ^java.lang.String message]
    (-> this (.setMessage message))))

