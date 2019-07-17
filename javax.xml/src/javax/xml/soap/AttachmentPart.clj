(ns javax.xml.soap.AttachmentPart
  "A single attachment to a SOAPMessage object. A SOAPMessage
  object may contain zero, one, or many AttachmentPart objects.
  Each AttachmentPart object consists of two parts,
  application-specific content and associated MIME headers. The
  MIME headers consists of name/value pairs that can be used to
  identify and describe the content.

  An AttachmentPart object must conform to certain standards.

  It must conform to
      MIME [RFC2045] standards
  It MUST contain content
  The header portion MUST include the following header:

    Content-Type
        This header identifies the type of data in the content of an
        AttachmentPart object and MUST conform to [RFC2045].
        The following is an example of a Content-Type header:


        Content-Type:  application/xml
        The following line of code, in which ap is an
        AttachmentPart object, sets the header shown in
        the previous example.


        ap.setMimeHeader(`Content-Type`, `application/xml`);




  There are no restrictions on the content portion of an
  AttachmentPart object. The content may be anything from a
  simple plain text object to a complex XML document or image file.


  An AttachmentPart object is created with the method
  SOAPMessage.createAttachmentPart. After setting its MIME headers,
   the AttachmentPart object is added to the message
  that created it with the method SOAPMessage.addAttachmentPart.


  The following code fragment, in which m is a
  SOAPMessage object and contentStringl is a
  String, creates an instance of AttachmentPart,
  sets the AttachmentPart object with some content and
  header information, and adds the AttachmentPart object to
  the SOAPMessage object.


      AttachmentPart ap1 = m.createAttachmentPart();
      ap1.setContent(contentString1, `text/plain`);
      m.addAttachmentPart(ap1);



  The following code fragment creates and adds a second
  AttachmentPart instance to the same message. jpegData
  is a binary byte buffer representing the jpeg file.


      AttachmentPart ap2 = m.createAttachmentPart();
      byte[] jpegData =  ...;
      ap2.setContent(new ByteArrayInputStream(jpegData), `image/jpeg`);
      m.addAttachmentPart(ap2);

  The getContent method retrieves the contents and header from
  an AttachmentPart object. Depending on the
  DataContentHandler objects present, the returned
  Object can either be a typed Java object corresponding
  to the MIME type or an InputStream object that contains the
  content as bytes.


      String content1 = ap1.getContent();
      java.io.InputStream content2 = ap2.getContent();

  The method clearContent removes all the content from an
  AttachmentPart object but does not affect its header information.


      ap1.clearContent();"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.soap AttachmentPart]))

(defn ->attachment-part
  "Constructor."
  ([]
    (new AttachmentPart )))

(defn add-mime-header
  "Adds a MIME header with the specified name and value to this
   AttachmentPart object.

   Note that RFC822 headers can contain only US-ASCII characters.

  name - a String giving the name of the header to be added - `java.lang.String`
  value - a String giving the value of the header to be added - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if there was a problem with the specified mime header name or value"
  ([^javax.xml.soap.AttachmentPart this ^java.lang.String name ^java.lang.String value]
    (-> this (.addMimeHeader name value))))

(defn set-content-type
  "Sets the MIME header whose name is `Content-Type` with the given value.

  content-type - a String giving the value of the `Content-Type` header - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if there was a problem with the specified content type"
  ([^javax.xml.soap.AttachmentPart this ^java.lang.String content-type]
    (-> this (.setContentType content-type))))

(defn get-data-handler
  "Gets the DataHandler object for this AttachmentPart
   object.

  returns: the DataHandler object associated with this
           AttachmentPart object - `javax.activation.DataHandler`

  throws: javax.xml.soap.SOAPException - if there is no data in this AttachmentPart object"
  ([^javax.xml.soap.AttachmentPart this]
    (-> this (.getDataHandler))))

(defn set-base-64-content
  "Sets the content of this attachment part from the Base64 source
   InputStream  and sets the value of the
   Content-Type header to the value contained in
   contentType, This method would first decode the base64
   input and write the resulting raw bytes to the attachment.

    A subsequent call to getSize() may not be an exact measure
    of the content size.

  content - the base64 encoded data to add to the attachment part - `java.io.InputStream`
  content-type - the value to set into the Content-Type header - `java.lang.String`

  throws: javax.xml.soap.SOAPException - if an there is an error in setting the content"
  ([^javax.xml.soap.AttachmentPart this ^java.io.InputStream content ^java.lang.String content-type]
    (-> this (.setBase64Content content content-type))))

(defn set-content-id
  "Sets the MIME header whose name is `Content-ID` with the given value.

  content-id - a String giving the value of the `Content-ID` header - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if there was a problem with the specified contentId value"
  ([^javax.xml.soap.AttachmentPart this ^java.lang.String content-id]
    (-> this (.setContentId content-id))))

(defn get-raw-content
  "Gets the content of this AttachmentPart object as an
   InputStream as if a call had been made to getContent and no
   DataContentHandler had been registered for the
   content-type of this AttachmentPart.

   Note that reading from the returned InputStream would result in consuming
   the data in the stream. It is the responsibility of the caller to reset
   the InputStream appropriately before calling a Subsequent API. If a copy
   of the raw attachment content is required then the getRawContentBytes() API
   should be used instead.

  returns: an InputStream from which the raw data contained by
        the AttachmentPart can be accessed. - `java.io.InputStream`

  throws: javax.xml.soap.SOAPException - if there is no content set into this AttachmentPart object or if there was a data transformation error."
  ([^javax.xml.soap.AttachmentPart this]
    (-> this (.getRawContent))))

(defn get-content-location
  "Gets the value of the MIME header whose name is `Content-Location`.

  returns: a String giving the value of the
            `Content-Location` header or null if there
            is none - `java.lang.String`"
  ([^javax.xml.soap.AttachmentPart this]
    (-> this (.getContentLocation))))

(defn remove-all-mime-headers
  "Removes all the MIME header entries."
  ([^javax.xml.soap.AttachmentPart this]
    (-> this (.removeAllMimeHeaders))))

(defn get-non-matching-mime-headers
  "Retrieves all MimeHeader objects whose name does
   not match a name in the given array.

  names - a String array with the name(s) of the MIME headers not to be returned - `java.lang.String[]`

  returns: all of the MIME headers in this AttachmentPart object
            except those that match one of the names in the
             given array.  The nonmatching MIME headers are returned as an
             Iterator object. - `java.util.Iterator`"
  ([^javax.xml.soap.AttachmentPart this ^java.lang.String[] names]
    (-> this (.getNonMatchingMimeHeaders names))))

(defn get-content-type
  "Gets the value of the MIME header whose name is `Content-Type`.

  returns: a String giving the value of the
            `Content-Type` header or null if there
            is none - `java.lang.String`"
  ([^javax.xml.soap.AttachmentPart this]
    (-> this (.getContentType))))

(defn set-raw-content-bytes
  "Sets the content of this attachment part to that contained by the
   byte[] array content and sets the value of the
   Content-Type header to the value contained in
   contentType.

  content - the raw data to add to the attachment part - `byte[]`
  offset - the offset in the byte array of the content - `int`
  len - the number of bytes that form the content - `int`
  content-type - the value to set into the Content-Type header - `java.lang.String`

  throws: javax.xml.soap.SOAPException - if an there is an error in setting the content or content is null"
  ([^javax.xml.soap.AttachmentPart this content ^Integer offset ^Integer len ^java.lang.String content-type]
    (-> this (.setRawContentBytes content offset len content-type))))

(defn clear-content
  "Clears out the content of this AttachmentPart object.
   The MIME header portion is left untouched."
  ([^javax.xml.soap.AttachmentPart this]
    (-> this (.clearContent))))

(defn get-base-64-content
  "Returns an InputStream which can be used to obtain the
   content of AttachmentPart  as Base64 encoded
   character data, this method would base64 encode the raw bytes
   of the attachment and return.

  returns: an InputStream from which the Base64 encoded
         AttachmentPart can be read. - `java.io.InputStream`

  throws: javax.xml.soap.SOAPException - if there is no content set into this AttachmentPart object or if there was a data transformation error."
  ([^javax.xml.soap.AttachmentPart this]
    (-> this (.getBase64Content))))

(defn set-raw-content
  "Sets the content of this attachment part to that contained by the
   InputStream content and sets the value of the
   Content-Type header to the value contained in
   contentType.

    A subsequent call to getSize() may not be an exact measure
    of the content size.

  content - the raw data to add to the attachment part - `java.io.InputStream`
  content-type - the value to set into the Content-Type header - `java.lang.String`

  throws: javax.xml.soap.SOAPException - if an there is an error in setting the content"
  ([^javax.xml.soap.AttachmentPart this ^java.io.InputStream content ^java.lang.String content-type]
    (-> this (.setRawContent content content-type))))

(defn get-raw-content-bytes
  "Gets the content of this AttachmentPart object as a
   byte[] array as if a call had been made to getContent and no
   DataContentHandler had been registered for the
   content-type of this AttachmentPart.

  returns: a byte[] array containing the raw data of the
        AttachmentPart. - `byte[]`

  throws: javax.xml.soap.SOAPException - if there is no content set into this AttachmentPart object or if there was a data transformation error."
  ([^javax.xml.soap.AttachmentPart this]
    (-> this (.getRawContentBytes))))

(defn set-data-handler
  "Sets the given DataHandler object as the data handler
   for this AttachmentPart object. Typically, on an incoming
   message, the data handler is automatically set. When
   a message is being created and populated with content, the
   setDataHandler method can be used to get data from
   various data sources into the message.

  data-handler - the DataHandler object to be set - `javax.activation.DataHandler`

  throws: java.lang.IllegalArgumentException - if there was a problem with the specified DataHandler object"
  ([^javax.xml.soap.AttachmentPart this ^javax.activation.DataHandler data-handler]
    (-> this (.setDataHandler data-handler))))

(defn remove-mime-header
  "Removes all MIME headers that match the given name.

  header - the string name of the MIME header/s to be removed - `java.lang.String`"
  ([^javax.xml.soap.AttachmentPart this ^java.lang.String header]
    (-> this (.removeMimeHeader header))))

(defn set-content-location
  "Sets the MIME header whose name is `Content-Location` with the given value.

  content-location - a String giving the value of the `Content-Location` header - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if there was a problem with the specified content location"
  ([^javax.xml.soap.AttachmentPart this ^java.lang.String content-location]
    (-> this (.setContentLocation content-location))))

(defn get-mime-header
  "Gets all the values of the header identified by the given
   String.

  name - the name of the header; example: `Content-Type` - `java.lang.String`

  returns: a String array giving the value for the
           specified header - `java.lang.String[]`"
  ([^javax.xml.soap.AttachmentPart this ^java.lang.String name]
    (-> this (.getMimeHeader name))))

(defn get-matching-mime-headers
  "Retrieves all MimeHeader objects that match a name in
   the given array.

  names - a String array with the name(s) of the MIME headers to be returned - `java.lang.String[]`

  returns: all of the MIME headers that match one of the names in the
             given array as an Iterator object - `java.util.Iterator`"
  ([^javax.xml.soap.AttachmentPart this ^java.lang.String[] names]
    (-> this (.getMatchingMimeHeaders names))))

(defn get-all-mime-headers
  "Retrieves all the headers for this AttachmentPart object
   as an iterator over the MimeHeader objects.

  returns: an Iterator object with all of the Mime
            headers for this AttachmentPart object - `java.util.Iterator`"
  ([^javax.xml.soap.AttachmentPart this]
    (-> this (.getAllMimeHeaders))))

(defn get-size
  "Returns the number of bytes in this AttachmentPart
   object.

  returns: the size of this AttachmentPart object in bytes
           or -1 if the size cannot be determined - `int`

  throws: javax.xml.soap.SOAPException - if the content of this attachment is corrupted of if there was an exception while trying to determine the size."
  ([^javax.xml.soap.AttachmentPart this]
    (-> this (.getSize))))

(defn set-content
  "Sets the content of this attachment part to that of the given
   Object and sets the value of the Content-Type
   header to the given type. The type of the
   Object should correspond to the value given for the
   Content-Type. This depends on the particular
   set of DataContentHandler objects in use.

  object - the Java object that makes up the content for this attachment part - `java.lang.Object`
  content-type - the MIME string that specifies the type of the content - `java.lang.String`

  throws: java.lang.IllegalArgumentException - may be thrown if the contentType does not match the type of the content object, or if there was no DataContentHandler object for this content object"
  ([^javax.xml.soap.AttachmentPart this ^java.lang.Object object ^java.lang.String content-type]
    (-> this (.setContent object content-type))))

(defn set-mime-header
  "Changes the first header entry that matches the given name
   to the given value, adding a new header if no existing header
   matches. This method also removes all matching headers but the first.

   Note that RFC822 headers can only contain US-ASCII characters.

  name - a String giving the name of the header for which to search - `java.lang.String`
  value - a String giving the value to be set for the header whose name matches the given name - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if there was a problem with the specified mime header name or value"
  ([^javax.xml.soap.AttachmentPart this ^java.lang.String name ^java.lang.String value]
    (-> this (.setMimeHeader name value))))

(defn get-content
  "Gets the content of this AttachmentPart object as a Java
   object. The type of the returned Java object depends on (1) the
   DataContentHandler object that is used to interpret the bytes
   and (2) the Content-Type given in the header.

   For the MIME content types `text/plain`, `text/html` and `text/xml`, the
   DataContentHandler object does the conversions to and
   from the Java types corresponding to the MIME types.
   For other MIME types,the DataContentHandler object
   can return an InputStream object that contains the content data
   as raw bytes.

   A SAAJ-compliant implementation must, as a minimum, return a
   java.lang.String object corresponding to any content
   stream with a Content-Type value of
   text/plain, a
   javax.xml.transform.stream.StreamSource object corresponding to a
   content stream with a Content-Type value of
   text/xml, a java.awt.Image object
   corresponding to a content stream with a
   Content-Type value of image/gif or
   image/jpeg.  For those content types that an
   installed DataContentHandler object does not understand, the
   DataContentHandler object is required to return a
   java.io.InputStream object with the raw bytes.

  returns: a Java object with the content of this AttachmentPart
           object - `java.lang.Object`

  throws: javax.xml.soap.SOAPException - if there is no content set into this AttachmentPart object or if there was a data transformation error"
  ([^javax.xml.soap.AttachmentPart this]
    (-> this (.getContent))))

(defn get-content-id
  "Gets the value of the MIME header whose name is `Content-ID`.

  returns: a String giving the value of the
            `Content-ID` header or null if there
            is none - `java.lang.String`"
  ([^javax.xml.soap.AttachmentPart this]
    (-> this (.getContentId))))

