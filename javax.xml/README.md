# Bindings for javax.xml

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/javax.xml "1.0.0"]
```

## Class Members Naming Conventions

| Class Member | Java | Clojure |
|:--|:--|:--|
| constructor | new File() | (->file) |
| instance method | getAnyValue() | (get-any-value) |
| instance field | instanceField | -instance-field |
| static method | staticMethod() | (*static-method) |
| static field | ANY_STATIC_FIELD | *-any-static-field |
| boolean field/method | isExists(), canUse() | (exists?), (can-use?) |

## Classes

- class **javax.xml.XMLConstants**
- class **javax.xml.bind.Binder**
- class **javax.xml.bind.DataBindingException**
- class **javax.xml.bind.DatatypeConverter**
- interface **javax.xml.bind.DatatypeConverterInterface**
- interface **javax.xml.bind.Element**
- class **javax.xml.bind.JAXB**
- class **javax.xml.bind.JAXBContext**
- class **javax.xml.bind.JAXBElement$GlobalScope**
- class **javax.xml.bind.JAXBElement**
- class **javax.xml.bind.JAXBException**
- class **javax.xml.bind.JAXBIntrospector**
- class **javax.xml.bind.JAXBPermission**
- class **javax.xml.bind.MarshalException**
- class **javax.xml.bind.Marshaller$Listener**
- interface **javax.xml.bind.Marshaller**
- interface **javax.xml.bind.NotIdentifiableEvent**
- interface **javax.xml.bind.ParseConversionEvent**
- interface **javax.xml.bind.PrintConversionEvent**
- class **javax.xml.bind.PropertyException**
- class **javax.xml.bind.SchemaOutputResolver**
- class **javax.xml.bind.TypeConstraintException**
- class **javax.xml.bind.UnmarshalException**
- class **javax.xml.bind.Unmarshaller$Listener**
- interface **javax.xml.bind.Unmarshaller**
- interface **javax.xml.bind.UnmarshallerHandler**
- interface **javax.xml.bind.ValidationEvent**
- interface **javax.xml.bind.ValidationEventHandler**
- interface **javax.xml.bind.ValidationEventLocator**
- class **javax.xml.bind.ValidationException**
- interface **javax.xml.bind.Validator**
- interface **javax.xml.bind.annotation.DomHandler**
- class **javax.xml.bind.annotation.W3CDomHandler**
- enum **javax.xml.bind.annotation.XmlAccessOrder**
- enum **javax.xml.bind.annotation.XmlAccessType**
- annotation **javax.xml.bind.annotation.XmlAccessorOrder**
- annotation **javax.xml.bind.annotation.XmlAccessorType**
- annotation **javax.xml.bind.annotation.XmlAnyAttribute**
- annotation **javax.xml.bind.annotation.XmlAnyElement**
- annotation **javax.xml.bind.annotation.XmlAttachmentRef**
- annotation **javax.xml.bind.annotation.XmlAttribute**
- class **javax.xml.bind.annotation.XmlElement$DEFAULT**
- annotation **javax.xml.bind.annotation.XmlElement**
- class **javax.xml.bind.annotation.XmlElementDecl$GLOBAL**
- annotation **javax.xml.bind.annotation.XmlElementDecl**
- class **javax.xml.bind.annotation.XmlElementRef$DEFAULT**
- annotation **javax.xml.bind.annotation.XmlElementRef**
- annotation **javax.xml.bind.annotation.XmlElementRefs**
- annotation **javax.xml.bind.annotation.XmlElementWrapper**
- annotation **javax.xml.bind.annotation.XmlElements**
- annotation **javax.xml.bind.annotation.XmlEnum**
- annotation **javax.xml.bind.annotation.XmlEnumValue**
- annotation **javax.xml.bind.annotation.XmlID**
- annotation **javax.xml.bind.annotation.XmlIDREF**
- annotation **javax.xml.bind.annotation.XmlInlineBinaryData**
- annotation **javax.xml.bind.annotation.XmlList**
- annotation **javax.xml.bind.annotation.XmlMimeType**
- annotation **javax.xml.bind.annotation.XmlMixed**
- annotation **javax.xml.bind.annotation.XmlNs**
- enum **javax.xml.bind.annotation.XmlNsForm**
- annotation **javax.xml.bind.annotation.XmlRegistry**
- annotation **javax.xml.bind.annotation.XmlRootElement**
- annotation **javax.xml.bind.annotation.XmlSchema**
- class **javax.xml.bind.annotation.XmlSchemaType$DEFAULT**
- annotation **javax.xml.bind.annotation.XmlSchemaType**
- annotation **javax.xml.bind.annotation.XmlSchemaTypes**
- annotation **javax.xml.bind.annotation.XmlSeeAlso**
- annotation **javax.xml.bind.annotation.XmlTransient**
- class **javax.xml.bind.annotation.XmlType$DEFAULT**
- annotation **javax.xml.bind.annotation.XmlType**
- annotation **javax.xml.bind.annotation.XmlValue**
- class **javax.xml.bind.annotation.adapters.CollapsedStringAdapter**
- class **javax.xml.bind.annotation.adapters.HexBinaryAdapter**
- class **javax.xml.bind.annotation.adapters.NormalizedStringAdapter**
- class **javax.xml.bind.annotation.adapters.XmlAdapter**
- class **javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter$DEFAULT**
- annotation **javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter**
- annotation **javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters**
- class **javax.xml.bind.attachment.AttachmentMarshaller**
- class **javax.xml.bind.attachment.AttachmentUnmarshaller**
- class **javax.xml.bind.helpers.AbstractMarshallerImpl**
- class **javax.xml.bind.helpers.AbstractUnmarshallerImpl**
- class **javax.xml.bind.helpers.DefaultValidationEventHandler**
- class **javax.xml.bind.helpers.NotIdentifiableEventImpl**
- class **javax.xml.bind.helpers.ParseConversionEventImpl**
- class **javax.xml.bind.helpers.PrintConversionEventImpl**
- class **javax.xml.bind.helpers.ValidationEventImpl**
- class **javax.xml.bind.helpers.ValidationEventLocatorImpl**
- class **javax.xml.bind.util.JAXBResult**
- class **javax.xml.bind.util.JAXBSource**
- class **javax.xml.bind.util.ValidationEventCollector**
- interface **javax.xml.crypto.AlgorithmMethod**
- interface **javax.xml.crypto.Data**
- class **javax.xml.crypto.KeySelector$Purpose**
- class **javax.xml.crypto.KeySelector**
- class **javax.xml.crypto.KeySelectorException**
- interface **javax.xml.crypto.KeySelectorResult**
- class **javax.xml.crypto.MarshalException**
- class **javax.xml.crypto.NoSuchMechanismException**
- interface **javax.xml.crypto.NodeSetData**
- class **javax.xml.crypto.OctetStreamData**
- interface **javax.xml.crypto.URIDereferencer**
- interface **javax.xml.crypto.URIReference**
- class **javax.xml.crypto.URIReferenceException**
- interface **javax.xml.crypto.XMLCryptoContext**
- interface **javax.xml.crypto.XMLStructure**
- class **javax.xml.crypto.dom.DOMCryptoContext**
- class **javax.xml.crypto.dom.DOMStructure**
- interface **javax.xml.crypto.dom.DOMURIReference**
- interface **javax.xml.crypto.dsig.CanonicalizationMethod**
- interface **javax.xml.crypto.dsig.DigestMethod**
- interface **javax.xml.crypto.dsig.Manifest**
- interface **javax.xml.crypto.dsig.Reference**
- interface **javax.xml.crypto.dsig.SignatureMethod**
- interface **javax.xml.crypto.dsig.SignatureProperties**
- interface **javax.xml.crypto.dsig.SignatureProperty**
- interface **javax.xml.crypto.dsig.SignedInfo**
- interface **javax.xml.crypto.dsig.Transform**
- class **javax.xml.crypto.dsig.TransformException**
- class **javax.xml.crypto.dsig.TransformService**
- interface **javax.xml.crypto.dsig.XMLObject**
- interface **javax.xml.crypto.dsig.XMLSignContext**
- interface **javax.xml.crypto.dsig.XMLSignature$SignatureValue**
- interface **javax.xml.crypto.dsig.XMLSignature**
- class **javax.xml.crypto.dsig.XMLSignatureException**
- class **javax.xml.crypto.dsig.XMLSignatureFactory**
- interface **javax.xml.crypto.dsig.XMLValidateContext**
- class **javax.xml.crypto.dsig.dom.DOMSignContext**
- class **javax.xml.crypto.dsig.dom.DOMValidateContext**
- interface **javax.xml.crypto.dsig.keyinfo.KeyInfo**
- class **javax.xml.crypto.dsig.keyinfo.KeyInfoFactory**
- interface **javax.xml.crypto.dsig.keyinfo.KeyName**
- interface **javax.xml.crypto.dsig.keyinfo.KeyValue**
- interface **javax.xml.crypto.dsig.keyinfo.PGPData**
- interface **javax.xml.crypto.dsig.keyinfo.RetrievalMethod**
- interface **javax.xml.crypto.dsig.keyinfo.X509Data**
- interface **javax.xml.crypto.dsig.keyinfo.X509IssuerSerial**
- interface **javax.xml.crypto.dsig.spec.C14NMethodParameterSpec**
- interface **javax.xml.crypto.dsig.spec.DigestMethodParameterSpec**
- class **javax.xml.crypto.dsig.spec.ExcC14NParameterSpec**
- class **javax.xml.crypto.dsig.spec.HMACParameterSpec**
- interface **javax.xml.crypto.dsig.spec.SignatureMethodParameterSpec**
- interface **javax.xml.crypto.dsig.spec.TransformParameterSpec**
- class **javax.xml.crypto.dsig.spec.XPathFilter2ParameterSpec**
- class **javax.xml.crypto.dsig.spec.XPathFilterParameterSpec**
- class **javax.xml.crypto.dsig.spec.XPathType$Filter**
- class **javax.xml.crypto.dsig.spec.XPathType**
- class **javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec**
- class **javax.xml.datatype.DatatypeConfigurationException**
- class **javax.xml.datatype.DatatypeConstants$Field**
- class **javax.xml.datatype.DatatypeConstants**
- class **javax.xml.datatype.DatatypeFactory**
- class **javax.xml.datatype.Duration**
- class **javax.xml.datatype.XMLGregorianCalendar**
- interface **javax.xml.namespace.NamespaceContext**
- class **javax.xml.namespace.QName**
- class **javax.xml.parsers.DocumentBuilder**
- class **javax.xml.parsers.DocumentBuilderFactory**
- class **javax.xml.parsers.FactoryConfigurationError**
- class **javax.xml.parsers.ParserConfigurationException**
- class **javax.xml.parsers.SAXParser**
- class **javax.xml.parsers.SAXParserFactory**
- class **javax.xml.soap.AttachmentPart**
- interface **javax.xml.soap.Detail**
- interface **javax.xml.soap.DetailEntry**
- class **javax.xml.soap.MessageFactory**
- class **javax.xml.soap.MimeHeader**
- class **javax.xml.soap.MimeHeaders**
- interface **javax.xml.soap.Name**
- interface **javax.xml.soap.Node**
- class **javax.xml.soap.SAAJMetaFactory**
- class **javax.xml.soap.SAAJResult**
- interface **javax.xml.soap.SOAPBody**
- interface **javax.xml.soap.SOAPBodyElement**
- class **javax.xml.soap.SOAPConnection**
- class **javax.xml.soap.SOAPConnectionFactory**
- interface **javax.xml.soap.SOAPConstants**
- interface **javax.xml.soap.SOAPElement**
- class **javax.xml.soap.SOAPElementFactory**
- interface **javax.xml.soap.SOAPEnvelope**
- class **javax.xml.soap.SOAPException**
- class **javax.xml.soap.SOAPFactory**
- interface **javax.xml.soap.SOAPFault**
- interface **javax.xml.soap.SOAPFaultElement**
- interface **javax.xml.soap.SOAPHeader**
- interface **javax.xml.soap.SOAPHeaderElement**
- class **javax.xml.soap.SOAPMessage**
- class **javax.xml.soap.SOAPPart**
- interface **javax.xml.soap.Text**
- interface **javax.xml.stream.EventFilter**
- class **javax.xml.stream.FactoryConfigurationError**
- interface **javax.xml.stream.Location**
- interface **javax.xml.stream.StreamFilter**
- class **javax.xml.stream.XMLEventFactory**
- interface **javax.xml.stream.XMLEventReader**
- interface **javax.xml.stream.XMLEventWriter**
- class **javax.xml.stream.XMLInputFactory**
- class **javax.xml.stream.XMLOutputFactory**
- interface **javax.xml.stream.XMLReporter**
- interface **javax.xml.stream.XMLResolver**
- interface **javax.xml.stream.XMLStreamConstants**
- class **javax.xml.stream.XMLStreamException**
- interface **javax.xml.stream.XMLStreamReader**
- interface **javax.xml.stream.XMLStreamWriter**
- interface **javax.xml.stream.events.Attribute**
- interface **javax.xml.stream.events.Characters**
- interface **javax.xml.stream.events.Comment**
- interface **javax.xml.stream.events.DTD**
- interface **javax.xml.stream.events.EndDocument**
- interface **javax.xml.stream.events.EndElement**
- interface **javax.xml.stream.events.EntityDeclaration**
- interface **javax.xml.stream.events.EntityReference**
- interface **javax.xml.stream.events.Namespace**
- interface **javax.xml.stream.events.NotationDeclaration**
- interface **javax.xml.stream.events.ProcessingInstruction**
- interface **javax.xml.stream.events.StartDocument**
- interface **javax.xml.stream.events.StartElement**
- interface **javax.xml.stream.events.XMLEvent**
- class **javax.xml.stream.util.EventReaderDelegate**
- class **javax.xml.stream.util.StreamReaderDelegate**
- interface **javax.xml.stream.util.XMLEventAllocator**
- interface **javax.xml.stream.util.XMLEventConsumer**
- interface **javax.xml.transform.ErrorListener**
- class **javax.xml.transform.OutputKeys**
- interface **javax.xml.transform.Result**
- interface **javax.xml.transform.Source**
- interface **javax.xml.transform.SourceLocator**
- interface **javax.xml.transform.Templates**
- class **javax.xml.transform.Transformer**
- class **javax.xml.transform.TransformerConfigurationException**
- class **javax.xml.transform.TransformerException**
- class **javax.xml.transform.TransformerFactory**
- class **javax.xml.transform.TransformerFactoryConfigurationError**
- interface **javax.xml.transform.URIResolver**
- interface **javax.xml.transform.dom.DOMLocator**
- class **javax.xml.transform.dom.DOMResult**
- class **javax.xml.transform.dom.DOMSource**
- class **javax.xml.transform.sax.SAXResult**
- class **javax.xml.transform.sax.SAXSource**
- class **javax.xml.transform.sax.SAXTransformerFactory**
- interface **javax.xml.transform.sax.TemplatesHandler**
- interface **javax.xml.transform.sax.TransformerHandler**
- class **javax.xml.transform.stax.StAXResult**
- class **javax.xml.transform.stax.StAXSource**
- class **javax.xml.transform.stream.StreamResult**
- class **javax.xml.transform.stream.StreamSource**
- class **javax.xml.validation.Schema**
- class **javax.xml.validation.SchemaFactory**
- class **javax.xml.validation.SchemaFactoryConfigurationError**
- class **javax.xml.validation.SchemaFactoryLoader**
- class **javax.xml.validation.TypeInfoProvider**
- class **javax.xml.validation.Validator**
- class **javax.xml.validation.ValidatorHandler**
- annotation **javax.xml.ws.Action**
- interface **javax.xml.ws.AsyncHandler**
- interface **javax.xml.ws.Binding**
- interface **javax.xml.ws.BindingProvider**
- annotation **javax.xml.ws.BindingType**
- interface **javax.xml.ws.Dispatch**
- class **javax.xml.ws.Endpoint**
- class **javax.xml.ws.EndpointContext**
- class **javax.xml.ws.EndpointReference**
- annotation **javax.xml.ws.FaultAction**
- class **javax.xml.ws.Holder**
- interface **javax.xml.ws.LogicalMessage**
- class **javax.xml.ws.ProtocolException**
- interface **javax.xml.ws.Provider**
- annotation **javax.xml.ws.RequestWrapper**
- annotation **javax.xml.ws.RespectBinding**
- class **javax.xml.ws.RespectBindingFeature**
- interface **javax.xml.ws.Response**
- annotation **javax.xml.ws.ResponseWrapper**
- enum **javax.xml.ws.Service$Mode**
- class **javax.xml.ws.Service**
- annotation **javax.xml.ws.ServiceMode**
- annotation **javax.xml.ws.WebEndpoint**
- annotation **javax.xml.ws.WebFault**
- annotation **javax.xml.ws.WebServiceClient**
- interface **javax.xml.ws.WebServiceContext**
- class **javax.xml.ws.WebServiceException**
- class **javax.xml.ws.WebServiceFeature**
- class **javax.xml.ws.WebServicePermission**
- annotation **javax.xml.ws.WebServiceProvider**
- annotation **javax.xml.ws.WebServiceRef**
- annotation **javax.xml.ws.WebServiceRefs**
- interface **javax.xml.ws.handler.Handler**
- interface **javax.xml.ws.handler.HandlerResolver**
- interface **javax.xml.ws.handler.LogicalHandler**
- interface **javax.xml.ws.handler.LogicalMessageContext**
- enum **javax.xml.ws.handler.MessageContext$Scope**
- interface **javax.xml.ws.handler.MessageContext**
- interface **javax.xml.ws.handler.PortInfo**
- interface **javax.xml.ws.handler.soap.SOAPHandler**
- interface **javax.xml.ws.handler.soap.SOAPMessageContext**
- interface **javax.xml.ws.http.HTTPBinding**
- class **javax.xml.ws.http.HTTPException**
- annotation **javax.xml.ws.soap.Addressing**
- enum **javax.xml.ws.soap.AddressingFeature$Responses**
- class **javax.xml.ws.soap.AddressingFeature**
- annotation **javax.xml.ws.soap.MTOM**
- class **javax.xml.ws.soap.MTOMFeature**
- interface **javax.xml.ws.soap.SOAPBinding**
- class **javax.xml.ws.soap.SOAPFaultException**
- class **javax.xml.ws.spi.Invoker**
- class **javax.xml.ws.spi.Provider**
- class **javax.xml.ws.spi.ServiceDelegate**
- annotation **javax.xml.ws.spi.WebServiceFeatureAnnotation**
- class **javax.xml.ws.spi.http.HttpContext**
- class **javax.xml.ws.spi.http.HttpExchange**
- class **javax.xml.ws.spi.http.HttpHandler**
- class **javax.xml.ws.wsaddressing.W3CEndpointReference**
- class **javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder**
- interface **javax.xml.xpath.XPath**
- class **javax.xml.xpath.XPathConstants**
- class **javax.xml.xpath.XPathException**
- interface **javax.xml.xpath.XPathExpression**
- class **javax.xml.xpath.XPathExpressionException**
- class **javax.xml.xpath.XPathFactory**
- class **javax.xml.xpath.XPathFactoryConfigurationException**
- interface **javax.xml.xpath.XPathFunction**
- class **javax.xml.xpath.XPathFunctionException**
- interface **javax.xml.xpath.XPathFunctionResolver**
- interface **javax.xml.xpath.XPathVariableResolver**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
