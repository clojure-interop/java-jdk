(ns javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder
  "This class is used to build W3CEndpointReference
  instances. The intended use of this clsss is for
  an application component, for example a factory component,
  to create an W3CEndpointReference for a
  web service endpoint published by the same
  Java EE application. It can also be used to create
  W3CEndpointReferences for an Java SE based
  endpoint by providing the address property.

  When creating a W3CEndpointReference for an
  endpoint that is not published by the same Java EE application,
  the address property MUST be specified.

  When creating a W3CEndpointReference for an endpoint
  published by the same Java EE application, the address
  property MAY be null but then the serviceName
  and endpointName MUST specify an endpoint published by
  the same Java EE application.

  When the wsdlDocumentLocation is specified it MUST refer
  to a valid WSDL document and the serviceName and
  endpointName (if specified) MUST match a service and port
  in the WSDL document."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws.wsaddressing W3CEndpointReferenceBuilder]))

(defn ->w-3-c-endpoint-reference-builder
  "Constructor.

  Creates a new W3CEndpointReferenceBuilder instance."
  (^W3CEndpointReferenceBuilder []
    (new W3CEndpointReferenceBuilder )))

(defn reference-parameter
  "Adds the referenceParameter to the
   W3CEndpointReference instance
   wsa:ReferenceParameters element.

  reference-parameter - The element to be added to the wsa:ReferenceParameters element. - `org.w3c.dom.Element`

  returns: A W3CEndpointReferenceBuilder instance with
     the referenceParameter added to the
     wsa:ReferenceParameters element. - `javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder`

  throws: java.lang.IllegalArgumentException - if referenceParameter is null."
  (^javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder [^W3CEndpointReferenceBuilder this ^org.w3c.dom.Element reference-parameter]
    (-> this (.referenceParameter reference-parameter))))

(defn attribute
  "Adds an extension attribute to the
   W3CEndpointReference instance's
   wsa:EndpointReference element.

  name - The name of the extension attribute to be added to the W3CEndpointReference - `javax.xml.namespace.QName`
  value - extension attribute value - `java.lang.String`

  returns: A W3CEndpointReferenceBuilder instance with
     the extension attribute added to the W3CEndpointReference
     instance. - `javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder`

  throws: java.lang.IllegalArgumentException - if name or value is null."
  (^javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder [^W3CEndpointReferenceBuilder this ^javax.xml.namespace.QName name ^java.lang.String value]
    (-> this (.attribute name value))))

(defn interface-name
  "Sets the interfaceName as the
   wsam:InterfaceName element in the
   wsa:Metadata element.

   See
   2.1 Referencing WSDL Metadata from an EPR for more details.

  interface-name - The port type name of the endpoint to be targeted by the returned W3CEndpointReference. - `javax.xml.namespace.QName`

  returns: A W3CEndpointReferenceBuilder instance with
     the interfaceName as wsam:InterfaceName
     element added to the wsa:Metadata element - `javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder`"
  (^javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder [^W3CEndpointReferenceBuilder this ^javax.xml.namespace.QName interface-name]
    (-> this (.interfaceName interface-name))))

(defn element
  "Adds an extension element to the
   W3CEndpointReference instance's
   wsa:EndpointReference element.

  element - The extension element to be added to the W3CEndpointReference - `org.w3c.dom.Element`

  returns: A W3CEndpointReferenceBuilder instance with
     the extension element added to the
      W3CEndpointReference instance. - `javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder`

  throws: java.lang.IllegalArgumentException - if element is null."
  (^javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder [^W3CEndpointReferenceBuilder this ^org.w3c.dom.Element element]
    (-> this (.element element))))

(defn address
  "Sets the address to the
   W3CEndpointReference instance's
   wsa:Address.

   The address MUST be set to a non-null
   value when building a W3CEndpointReference for a
   web service endpoint that is not published by the same
   Java EE application or when running on Java SE.

  address - The address of the endpoint to be targeted by the returned W3CEndpointReference. - `java.lang.String`

  returns: A W3CEndpointReferenceBuilder instance with
     the address set to the wsa:Address. - `javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder`"
  (^javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder [^W3CEndpointReferenceBuilder this ^java.lang.String address]
    (-> this (.address address))))

(defn build
  "Builds a W3CEndpointReference from the accumulated
   properties set on this W3CEndpointReferenceBuilder
   instance.

   This method can be used to create a W3CEndpointReference
   for any endpoint by specifying the address property along
   with any other desired properties.  This method
   can also be used to create a W3CEndpointReference for
   an endpoint that is published by the same Java EE application.
   This method can automatically determine the address of
   an endpoint published by the same Java EE application that is identified by the
   serviceName and
   endpointName properties.  If the address is
   null and the serviceName and
   endpointName
   do not identify an endpoint published by the same Java EE application, a
   java.lang.IllegalStateException MUST be thrown.

  returns: W3CEndpointReference from the accumulated
   properties set on this W3CEndpointReferenceBuilder
   instance. This method never returns null. - `javax.xml.ws.wsaddressing.W3CEndpointReference`

  throws: java.lang.IllegalStateException - If the address, serviceName and endpointName are all null. If the serviceName service is null and the endpointName is NOT null. If the address property is null and the serviceName and endpointName do not specify a valid endpoint published by the same Java EE application. If the serviceName is NOT null and is not present in the specified WSDL. If the endpointName port is not null and it is not present in serviceName service in the WSDL. If the wsdlDocumentLocation is NOT null and does not represent a valid WSDL."
  (^javax.xml.ws.wsaddressing.W3CEndpointReference [^W3CEndpointReferenceBuilder this]
    (-> this (.build))))

(defn service-name
  "Sets the serviceName as the
   wsam:ServiceName element in the
   wsa:Metadata element.

   See
   2.1 Referencing WSDL Metadata from an EPR for more details.

  service-name - The service name of the endpoint to be targeted by the returned W3CEndpointReference. This property may also be used with the endpointName (portName) property to lookup the address of a web service endpoint that is published by the same Java EE application. - `javax.xml.namespace.QName`

  returns: A W3CEndpointReferenceBuilder instance with
     the serviceName as wsam:ServiceName
     element added to the wsa:Metadata element - `javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder`"
  (^javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder [^W3CEndpointReferenceBuilder this ^javax.xml.namespace.QName service-name]
    (-> this (.serviceName service-name))))

(defn metadata
  "Adds the metadataElement to the
   W3CEndpointReference instance's
   wsa:Metadata element.

  metadata-element - The element to be added to the wsa:Metadata element. - `org.w3c.dom.Element`

  returns: A W3CEndpointReferenceBuilder instance with
     the metadataElement added to the
      wsa:Metadata element. - `javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder`

  throws: java.lang.IllegalArgumentException - if metadataElement is null."
  (^javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder [^W3CEndpointReferenceBuilder this ^org.w3c.dom.Element metadata-element]
    (-> this (.metadata metadata-element))))

(defn endpoint-name
  "Sets the endpointName as
   wsam:ServiceName/@EndpointName in the
   wsa:Metadata element. This method can only be called
   after the serviceName method has been called.

   See
   2.1 Referencing WSDL Metadata from an EPR for more details.

  endpoint-name - The name of the endpoint to be targeted by the returned W3CEndpointReference. The endpointName (portName) property may also be used with the serviceName property to lookup the address of a web service endpoint published by the same Java EE application. - `javax.xml.namespace.QName`

  returns: A W3CEndpointReferenceBuilder instance with
     the endpointName as
   wsam:ServiceName/@EndpointName in the
   wsa:Metadata element. - `javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder`

  throws: IllegalStateException, - if the serviceName has not been set."
  (^javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder [^W3CEndpointReferenceBuilder this ^javax.xml.namespace.QName endpoint-name]
    (-> this (.endpointName endpoint-name))))

(defn wsdl-document-location
  "Sets the wsdlDocumentLocation that will be referenced
   as wsa:Metadata/@wsdli:wsdlLocation. The namespace name
   for the wsdli:wsdlLocation's value can be taken from the WSDL itself.


   See
   2.1 Referencing WSDL Metadata from an EPR for more details.

  wsdl-document-location - The location of the WSDL document to be referenced in the wsa:Metadata of the W3CEndpointReference. - `java.lang.String`

  returns: A W3CEndpointReferenceBuilder instance with
     the wsdlDocumentLocation that is to be referenced. - `javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder`"
  (^javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder [^W3CEndpointReferenceBuilder this ^java.lang.String wsdl-document-location]
    (-> this (.wsdlDocumentLocation wsdl-document-location))))

