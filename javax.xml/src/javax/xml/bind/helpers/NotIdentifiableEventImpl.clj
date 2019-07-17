(ns javax.xml.bind.helpers.NotIdentifiableEventImpl
  "Default implementation of the NotIdentifiableEvent interface.


  JAXB providers are allowed to use whatever class that implements
  the ValidationEvent interface. This class is just provided for a
  convenience."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind.helpers NotIdentifiableEventImpl]))

(defn ->not-identifiable-event-impl
  "Constructor.

  Create a new NotIdentifiableEventImpl.

  severity - The severity value for this event. Must be one of ValidationEvent.WARNING, ValidationEvent.ERROR, or ValidationEvent.FATAL_ERROR - `int`
  message - The text message for this event - may be null. - `java.lang.String`
  locator - The locator object for this event - may be null. - `javax.xml.bind.ValidationEventLocator`
  linked-exception - An optional linked exception that may provide additional information about the event - may be null. - `java.lang.Throwable`

  throws: java.lang.IllegalArgumentException - if an illegal severity field is supplied"
  ([severity message locator linked-exception]
    (new NotIdentifiableEventImpl severity message locator linked-exception))
  ([severity message locator]
    (new NotIdentifiableEventImpl severity message locator)))

