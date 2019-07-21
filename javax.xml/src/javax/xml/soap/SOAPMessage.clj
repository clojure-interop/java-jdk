(ns javax.xml.soap.SOAPMessage
  "The root class for all SOAP messages. As transmitted on the \"wire\", a SOAP
  message is an XML document or a MIME message whose first body part is an
  XML/SOAP document.

  A SOAPMessage object consists of a SOAP part and optionally
  one or more attachment parts. The SOAP part for a SOAPMessage
  object is a SOAPPart object, which contains information used
  for message routing and identification, and which can contain
  application-specific content. All data in the SOAP Part of a message must be
  in XML format.

  A new SOAPMessage object contains the following by default:

    A SOAPPart object
    A SOAPEnvelope object
    A SOAPBody object
    A SOAPHeader object

  The SOAP part of a message can be retrieved by calling the method SOAPMessage.getSOAPPart().
  The SOAPEnvelope object is retrieved from the SOAPPart
  object, and the SOAPEnvelope object is used to retrieve the
  SOAPBody and SOAPHeader objects.



      SOAPPart sp = message.getSOAPPart();
      SOAPEnvelope se = sp.getEnvelope();
      SOAPBody sb = se.getBody();
      SOAPHeader sh = se.getHeader();


  In addition to the mandatory SOAPPart object, a SOAPMessage
  object may contain zero or more AttachmentPart objects, each
  of which contains application-specific data. The SOAPMessage
  interface provides methods for creating AttachmentPart
  objects and also for adding them to a SOAPMessage object. A
  party that has received a SOAPMessage object can examine its
  contents by retrieving individual attachment parts.

  Unlike the rest of a SOAP message, an attachment is not required to be in
  XML format and can therefore be anything from simple text to an image file.
  Consequently, any message content that is not in XML format must be in an
  AttachmentPart object.

  A MessageFactory object may create SOAPMessage
  objects with behavior that is specialized to a particular implementation or
  application of SAAJ. For instance, a MessageFactory object
  may produce SOAPMessage objects that conform to a particular
  Profile such as ebXML. In this case a MessageFactory object
  might produce SOAPMessage objects that are initialized with
  ebXML headers.

  In order to ensure backward source compatibility, methods that are added to
  this class after version 1.1 of the SAAJ specification are all concrete
  instead of abstract and they all have default implementations. Unless
  otherwise noted in the JavaDocs for those methods the default
  implementations simply throw an UnsupportedOperationException
  and the SAAJ implementation code must override them with methods that
  provide the specified behavior. Legacy client code does not have this
  restriction, however, so long as there is no claim made that it conforms to
  some later version of the specification than it was originally written for.
  A legacy class that extends the SOAPMessage class can be compiled and/or run
  against succeeding versions of the SAAJ API without modification. If such a
  class was correctly implemented then it will continue to behave correctly
  relative to the version of the specification against which it was written."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.soap SOAPMessage]))

(defn ->soap-message
  "Constructor."
  (^SOAPMessage []
    (new SOAPMessage )))

(def *-character-set-encoding
  "Static Constant.

  Specifies the character type encoding for the SOAP Message. Valid values
   include \"utf-8\" and \"utf-16\". See vendor documentation for additional
   supported values. The default is \"utf-8\".

  type: java.lang.String"
  SOAPMessage/CHARACTER_SET_ENCODING)

(def *-write-xml-declaration
  "Static Constant.

  Specifies whether the SOAP Message will contain an XML declaration when
   it is sent. The only valid values are \"true\" and \"false\". The default is
   \"false\".

  type: java.lang.String"
  SOAPMessage/WRITE_XML_DECLARATION)

(defn count-attachments
  "Gets a count of the number of attachments in this message. This count
   does not include the SOAP part.

  returns: the number of AttachmentPart objects that are
           part of this SOAPMessage object - `int`"
  (^Integer [^SOAPMessage this]
    (-> this (.countAttachments))))

(defn get-attachment
  "Returns an AttachmentPart object that is associated with an
   attachment that is referenced by this SOAPElement or
   null if no such attachment exists. References can be made
   via an href attribute as described in
   SOAP Messages with Attachments,
   or via a single Text child node containing a URI as
   described in the WS-I Attachments Profile 1.0 for elements of schema
   type ref:swaRef.  These two mechanisms must be supported.
   The support for references via href attribute also implies that
   this method should also be supported on an element that is an
   xop:Include element (
   XOP).
   other reference mechanisms may be supported by individual
   implementations of this standard. Contact your vendor for details.

  element - The SOAPElement containing the reference to an Attachment - `javax.xml.soap.SOAPElement`

  returns: the referenced AttachmentPart or null if no such
            AttachmentPart exists or no reference can be
            found in this SOAPElement. - `javax.xml.soap.AttachmentPart`

  throws: javax.xml.soap.SOAPException - if there is an error in the attempt to access the attachment"
  (^javax.xml.soap.AttachmentPart [^SOAPMessage this ^javax.xml.soap.SOAPElement element]
    (-> this (.getAttachment element))))

(defn set-content-description
  "Sets the description of this SOAPMessage object's
   content with the given description.

  description - a String describing the content of this message - `java.lang.String`"
  ([^SOAPMessage this ^java.lang.String description]
    (-> this (.setContentDescription description))))

(defn get-soap-body
  "Gets the SOAP Body contained in this SOAPMessage object.

  returns: the SOAPBody object contained by this SOAPMessage
           object - `javax.xml.soap.SOAPBody`

  throws: javax.xml.soap.SOAPException - if the SOAP Body does not exist or cannot be retrieved"
  (^javax.xml.soap.SOAPBody [^SOAPMessage this]
    (-> this (.getSOAPBody))))

(defn remove-all-attachments
  "Removes all AttachmentPart objects that have been added
   to this SOAPMessage object.

   This method does not touch the SOAP part."
  ([^SOAPMessage this]
    (-> this (.removeAllAttachments))))

(defn get-mime-headers
  "Returns all the transport-specific MIME headers for this SOAPMessage
   object in a transport-independent fashion.

  returns: a MimeHeaders object containing the MimeHeader
           objects - `javax.xml.soap.MimeHeaders`"
  (^javax.xml.soap.MimeHeaders [^SOAPMessage this]
    (-> this (.getMimeHeaders))))

(defn write-to
  "Writes this SOAPMessage object to the given output
   stream. The externalization format is as defined by the SOAP 1.1 with
   Attachments specification.

   If there are no attachments, just an XML stream is written out. For
   those messages that have attachments, writeTo writes a
   MIME-encoded byte stream.

   Note that this method does not write the transport-specific MIME Headers
   of the Message

  out - the OutputStream object to which this SOAPMessage object will be written - `java.io.OutputStream`

  throws: java.io.IOException - if an I/O error occurs"
  ([^SOAPMessage this ^java.io.OutputStream out]
    (-> this (.writeTo out))))

(defn get-attachments
  "Retrieves all the AttachmentPart objects that have header
   entries that match the specified headers. Note that a returned
   attachment could have headers in addition to those specified.

  headers - a MimeHeaders object containing the MIME headers for which to search - `javax.xml.soap.MimeHeaders`

  returns: an iterator over all attachments that have a header that matches
           one of the given headers - `java.util.Iterator`"
  (^java.util.Iterator [^SOAPMessage this ^javax.xml.soap.MimeHeaders headers]
    (-> this (.getAttachments headers)))
  (^java.util.Iterator [^SOAPMessage this]
    (-> this (.getAttachments))))

(defn save-required
  "Indicates whether this SOAPMessage object needs to have
   the method saveChanges called on it.

  returns: true if saveChanges needs to be
           called; false otherwise. - `boolean`"
  (^Boolean [^SOAPMessage this]
    (-> this (.saveRequired))))

(defn get-property
  "Retrieves value of the specified property.

  property - the name of the property to retrieve - `java.lang.String`

  returns: the value associated with the named property or null
           if no such property exists. - `java.lang.Object`

  throws: javax.xml.soap.SOAPException - if the property name is not recognized."
  (^java.lang.Object [^SOAPMessage this ^java.lang.String property]
    (-> this (.getProperty property))))

(defn get-soap-part
  "Gets the SOAP part of this SOAPMessage object.

   SOAPMessage object contains one or more attachments, the
   SOAP Part must be the first MIME body part in the message.

  returns: the SOAPPart object for this SOAPMessage
           object - `javax.xml.soap.SOAPPart`"
  (^javax.xml.soap.SOAPPart [^SOAPMessage this]
    (-> this (.getSOAPPart))))

(defn get-soap-header
  "Gets the SOAP Header contained in this SOAPMessage
   object.

  returns: the SOAPHeader object contained by this SOAPMessage
           object - `javax.xml.soap.SOAPHeader`

  throws: javax.xml.soap.SOAPException - if the SOAP Header does not exist or cannot be retrieved"
  (^javax.xml.soap.SOAPHeader [^SOAPMessage this]
    (-> this (.getSOAPHeader))))

(defn add-attachment-part
  "Adds the given AttachmentPart object to this SOAPMessage
   object. An AttachmentPart object must be created before
   it can be added to a message.

  attachment-part - an AttachmentPart object that is to become part of this SOAPMessage object - `javax.xml.soap.AttachmentPart`

  throws: java.lang.IllegalArgumentException"
  ([^SOAPMessage this ^javax.xml.soap.AttachmentPart attachment-part]
    (-> this (.addAttachmentPart attachment-part))))

(defn remove-attachments
  "Removes all the AttachmentPart objects that have header
   entries that match the specified headers. Note that the removed
   attachment could have headers in addition to those specified.

  headers - a MimeHeaders object containing the MIME headers for which to search - `javax.xml.soap.MimeHeaders`"
  ([^SOAPMessage this ^javax.xml.soap.MimeHeaders headers]
    (-> this (.removeAttachments headers))))

(defn set-property
  "Associates the specified value with the specified property. If there was
   already a value associated with this property, the old value is
   replaced.

   The valid property names include
   WRITE_XML_DECLARATION  and
   CHARACTER_SET_ENCODING. All of these standard SAAJ
   properties are prefixed by \"javax.xml.soap\". Vendors may also add
   implementation specific properties. These properties must be prefixed
   with package names that are unique to the vendor.

   Setting the property WRITE_XML_DECLARATION to \"true\"
   will cause an XML Declaration to be written out at the start of the SOAP
   message. The default value of \"false\" suppresses this declaration.

   The property CHARACTER_SET_ENCODING defaults to the value
   \"utf-8\" which causes the SOAP message to be encoded using
   UTF-8. Setting CHARACTER_SET_ENCODING to \"utf-16\"
   causes the SOAP message to be encoded using UTF-16.

   Some implementations may allow encodings in addition to UTF-8 and
   UTF-16. Refer to your vendor's documentation for details.

  property - the property with which the specified value is to be associated. - `java.lang.String`
  value - the value to be associated with the specified property - `java.lang.Object`

  throws: javax.xml.soap.SOAPException - if the property name is not recognized."
  ([^SOAPMessage this ^java.lang.String property ^java.lang.Object value]
    (-> this (.setProperty property value))))

(defn get-content-description
  "Retrieves a description of this SOAPMessage object's
   content.

  returns: a String describing the content of this
           message or null if no description has been set - `java.lang.String`"
  (^java.lang.String [^SOAPMessage this]
    (-> this (.getContentDescription))))

(defn save-changes
  "Updates this SOAPMessage object with all the changes that
   have been made to it. This method is called automatically when
   writeTo(OutputStream) is  called. However, if
   changes are made to a message that was received or to one that has
   already been sent, the method saveChanges needs to be
   called explicitly in order to save the changes. The method saveChanges
   also generates any changes that can be read back (for example, a
   MessageId in profiles that support a message id). All MIME headers in a
   message that is created for sending purposes are guaranteed to have
   valid values only after saveChanges has been called.

   In addition, this method marks the point at which the data from all
   constituent AttachmentPart objects are pulled into the
   message.

  throws: SOAPException - if there was a problem saving changes to this message."
  ([^SOAPMessage this]
    (-> this (.saveChanges))))

(defn create-attachment-part
  "Creates an AttachmentPart object and populates it with
   the specified data of the specified content type. The type of the
   Object should correspond to the value given for the
   Content-Type.

  content - an Object containing the content for the AttachmentPart object to be created - `java.lang.Object`
  content-type - a String object giving the type of content; examples are \"text/xml\", \"text/plain\", and \"image/jpeg\" - `java.lang.String`

  returns: a new AttachmentPart object that contains the
           given data - `javax.xml.soap.AttachmentPart`

  throws: java.lang.IllegalArgumentException - may be thrown if the contentType does not match the type of the content object, or if there was no DataContentHandler object for the given content object"
  (^javax.xml.soap.AttachmentPart [^SOAPMessage this ^java.lang.Object content ^java.lang.String content-type]
    (-> this (.createAttachmentPart content content-type)))
  (^javax.xml.soap.AttachmentPart [^SOAPMessage this ^javax.activation.DataHandler data-handler]
    (-> this (.createAttachmentPart data-handler)))
  (^javax.xml.soap.AttachmentPart [^SOAPMessage this]
    (-> this (.createAttachmentPart))))

