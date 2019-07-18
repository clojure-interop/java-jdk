(ns javax.xml.bind.util.ValidationEventCollector
  "ValidationEventHandler
  implementation that collects all events.


  To use this class, create a new instance and pass it to the setEventHandler
  method of the Validator, Unmarshaller, Marshaller class.  After the call to
  validate or unmarshal completes, call the getEvents method to retrieve all
  the reported errors and warnings."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind.util ValidationEventCollector]))

(defn ->validation-event-collector
  "Constructor."
  (^ValidationEventCollector []
    (new ValidationEventCollector )))

(defn get-events
  "Return an array of ValidationEvent objects containing a copy of each of
   the collected errors and warnings.

  returns: a copy of all the collected errors and warnings or an empty array
        if there weren't any - `javax.xml.bind.ValidationEvent[]`"
  ([^ValidationEventCollector this]
    (-> this (.getEvents))))

(defn reset
  "Clear all collected errors and warnings."
  ([^ValidationEventCollector this]
    (-> this (.reset))))

(defn has-events?
  "Returns true if this event collector contains at least one
   ValidationEvent.

  returns: true if this event collector contains at least one
           ValidationEvent, false otherwise - `boolean`"
  (^Boolean [^ValidationEventCollector this]
    (-> this (.hasEvents))))

(defn handle-event
  "Description copied from interface: ValidationEventHandler

  event - the encapsulated validation event information. It is a provider error if this parameter is null. - `javax.xml.bind.ValidationEvent`

  returns: true if the JAXB Provider should attempt to continue the current
           unmarshal, validate, or marshal operation after handling this
           warning/error, false if the provider should terminate the current
           operation with the appropriate UnmarshalException,
           ValidationException, or MarshalException. - `boolean`"
  (^Boolean [^ValidationEventCollector this ^javax.xml.bind.ValidationEvent event]
    (-> this (.handleEvent event))))

