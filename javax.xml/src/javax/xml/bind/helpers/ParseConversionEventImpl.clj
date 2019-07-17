(ns javax.xml.bind.helpers.ParseConversionEventImpl
  "Default implementation of the ParseConversionEvent interface.


  JAXB providers are allowed to use whatever class that implements
  the ValidationEvent interface. This class is just provided for a
  convenience."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind.helpers ParseConversionEventImpl]))

(defn ->parse-conversion-event-impl
  "Constructor.

  Create a new ParseConversionEventImpl.

  severity - The severity value for this event. Must be one of ValidationEvent.WARNING, ValidationEvent.ERROR, or ValidationEvent.FATAL_ERROR - `int`
  message - The text message for this event - may be null. - `java.lang.String`
  locator - The locator object for this event - may be null. - `javax.xml.bind.ValidationEventLocator`
  linked-exception - An optional linked exception that may provide additional information about the event - may be null. - `java.lang.Throwable`

  throws: java.lang.IllegalArgumentException - if an illegal severity field is supplied"
  ([^Integer severity ^java.lang.String message ^javax.xml.bind.ValidationEventLocator locator ^java.lang.Throwable linked-exception]
    (new ParseConversionEventImpl severity message locator linked-exception))
  ([^Integer severity ^java.lang.String message ^javax.xml.bind.ValidationEventLocator locator]
    (new ParseConversionEventImpl severity message locator)))

