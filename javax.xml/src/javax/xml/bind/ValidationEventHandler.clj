(ns javax.xml.bind.ValidationEventHandler
  "A basic event handler interface for validation errors.


  If an application needs to implement customized event handling, it must
  implement this interface and then register it with either the
  Unmarshaller,
  the Validator, or
  the Marshaller.
  The JAXB Provider will then report validation errors and warnings encountered
  during the unmarshal, marshal, and validate operations to these event
  handlers.


  If the handleEvent method throws an unchecked runtime exception,
  the JAXB Provider must treat that as if the method returned false, effectively
  terminating whatever operation was in progress at the time (unmarshal,
  validate, or marshal).


  Modifying the Java content tree within your event handler is undefined
  by the specification and may result in unexpected behaviour.


  Failing to return false from the handleEvent method after
  encountering a fatal error is undefined by the specification and may result
  in unexpected behavior.


  Default Event Handler

     See: Validator javadocs"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind ValidationEventHandler]))

(defn handle-event
  "Receive notification of a validation warning or error.

   The ValidationEvent will have a
   ValidationEventLocator embedded in it that
   indicates where the error or warning occurred.


   If an unchecked runtime exception is thrown from this method, the JAXB
   provider will treat it as if the method returned false and interrupt
   the current unmarshal, validate, or marshal operation.

  event - the encapsulated validation event information. It is a provider error if this parameter is null. - `javax.xml.bind.ValidationEvent`

  returns: true if the JAXB Provider should attempt to continue the current
           unmarshal, validate, or marshal operation after handling this
           warning/error, false if the provider should terminate the current
           operation with the appropriate UnmarshalException,
           ValidationException, or MarshalException. - `boolean`

  throws: java.lang.IllegalArgumentException - if the event object is null."
  ([^javax.xml.bind.ValidationEventHandler this ^javax.xml.bind.ValidationEvent event]
    (-> this (.handleEvent event))))

