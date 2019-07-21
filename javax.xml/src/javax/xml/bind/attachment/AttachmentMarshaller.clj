(ns javax.xml.bind.attachment.AttachmentMarshaller
  "Enable JAXB marshalling to optimize storage of binary data.

  This API enables an efficient cooperative creation of optimized
  binary data formats between a JAXB marshalling process and a MIME-based package
  processor. A JAXB implementation marshals the root body of a MIME-based package,
  delegating the creation of referenceable MIME parts to
  the MIME-based package processor that implements this abstraction.

  XOP processing is enabled when isXOPPackage() is true.
     See addMtomAttachment(DataHandler, String, String) for details.


  WS-I Attachment Profile 1.0 is supported by
  addSwaRefAttachment(DataHandler) being called by the
  marshaller for each JAXB property related to
  {http://ws-i.org/profiles/basic/1.1/xsd}swaRef."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind.attachment AttachmentMarshaller]))

(defn ->attachment-marshaller
  "Constructor."
  (^AttachmentMarshaller []
    (new AttachmentMarshaller )))

(defn add-mtom-attachment
  "Consider binary data for optimized binary storage as an attachment.

   Since content type is not known, the attachment's MIME content type must be set to \"application/octet-stream\".


   The elementNamespace and elementLocalName
   parameters provide the
   context that contains the binary data. This information could
   be used by the MIME-based package processor to determine if the
   binary data should be inlined or optimized as an attachment.

  data - represents the data to be attached. Must be non-null. The actual data region is specified by (data,offset,length) tuple. - `byte[]`
  offset - The offset within the array of the first byte to be read; must be non-negative and no larger than array.length - `int`
  length - The number of bytes to be read from the given array; must be non-negative and no larger than array.length - `int`
  mime-type - If the data has an associated MIME type known to JAXB, that is passed as this parameter. If none is known, \"application/octet-stream\". This parameter may never be null. - `java.lang.String`
  element-namespace - the namespace URI of the element that encloses the base64Binary data. Can be empty but never null. - `java.lang.String`
  element-local-name - The local name of the element. Always a non-null valid string. - `java.lang.String`

  returns: content-id URI, cid, to the attachment containing
           data or null if data should be inlined. - `java.lang.String`"
  (^java.lang.String [^AttachmentMarshaller this data ^Integer offset ^Integer length ^java.lang.String mime-type ^java.lang.String element-namespace ^java.lang.String element-local-name]
    (-> this (.addMtomAttachment data offset length mime-type element-namespace element-local-name)))
  (^java.lang.String [^AttachmentMarshaller this ^javax.activation.DataHandler data ^java.lang.String element-namespace ^java.lang.String element-local-name]
    (-> this (.addMtomAttachment data element-namespace element-local-name))))

(defn xop-package?
  "Read-only property that returns true if JAXB marshaller should enable XOP creation.

   This value must not change during the marshalling process. When this
   value is true, the addMtomAttachment(...) method
   is invoked when the appropriate binary datatypes are encountered by
   the marshal process.

   Marshaller.marshal() must throw IllegalStateException if this value is true
   and the XML content to be marshalled violates Step 1 in
   Creating XOP Pacakges
   http://www.w3.org/TR/2005/REC-xop10-20050125/#creating_xop_packages.
   \"Ensure the Original XML Infoset contains no element information item with a
   [namespace name] of \"http://www.w3.org/2004/08/xop/include\" and a [local name] of Include\"

   When this method returns true and during the marshal process
   at least one call to addMtomAttachment(...) returns
   a content-id, the MIME-based package processor must label the
   root part with the application/xop+xml media type as described in
   Step 5 of
   Creating XOP Pacakges.

  returns: true when MIME context is a XOP Package. - `boolean`"
  (^Boolean [^AttachmentMarshaller this]
    (-> this (.isXOPPackage))))

(defn add-swa-ref-attachment
  "Add MIME data as an attachment and return attachment's content-id, cid.


   This method is called by JAXB marshal process for each element/attribute typed as
   {http://ws-i.org/profiles/basic/1.1/xsd}swaRef. The MIME-based package processor
   implementing this method is responsible for attaching the specified data to a
   MIME attachment, and generating a content-id, cid, that uniquely identifies the attachment
   within the MIME-based package.

   Caller inserts the returned content-id, cid, into the XML content being marshalled.

  data - represents the data to be attached. Must be non-null. - `javax.activation.DataHandler`

  returns: must be a valid URI used as cid. Must satisfy Conformance Requirement R2928 from
         WS-I Attachments Profile Version 1.0. - `java.lang.String`"
  (^java.lang.String [^AttachmentMarshaller this ^javax.activation.DataHandler data]
    (-> this (.addSwaRefAttachment data))))

