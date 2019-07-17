(ns javax.xml.bind.attachment.AttachmentUnmarshaller
  "Enables JAXB unmarshalling of a root document containing optimized binary data formats.

  This API enables an efficient cooperative processing of optimized
  binary data formats between a JAXB 2.0 implementation and MIME-based package
  processor (MTOM/XOP and WS-I AP 1.0). JAXB unmarshals the body of a package, delegating the
  understanding of the packaging format being used to a MIME-based
  package processor that implements this abstract class.

  This abstract class identifies if a package requires XOP processing, isXOPPackage() and provides retrieval of binary content stored as attachments by content-id.

  Identifying the content-id, cid, to pass to getAttachment*(String cid)


  For XOP processing, the infoset representation of the cid is described
  in step 2a in
  Section 3.2 Interpreting XOP Packages


  For WS-I AP 1.0, the cid is identified as an element or attribute of
  type ref:swaRef  specified in
  Section 4.4 Referencing Attachments from the SOAP Envelope"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind.attachment AttachmentUnmarshaller]))

(defn ->attachment-unmarshaller
  "Constructor."
  ([]
    (new AttachmentUnmarshaller )))

(defn get-attachment-as-data-handler
  "Lookup MIME content by content-id, cid, and return as a DataHandler.

   The returned DataHandler instance must be configured
   to meet the following required mapping constaint.




         Required Mappings between MIME and Java Types


         MIME Type
         Java Type


         DataHandler.getContentType()
         instanceof DataHandler.getContent()




         image/gif
         java.awt.Image


         image/jpeg
         java.awt.Image


         text/xml  or application/xml
         javax.xml.transform.Source



   Note that it is allowable to support additional mappings.

  cid - It is expected to be a valid lexical form of the XML Schema xs:anyURI datatype. If isXOPPackage() ==true, it must be a valid URI per the cid: URI scheme (see RFC 2387) - `java.lang.String`

  returns: a DataHandler that represents the MIME attachment. - `javax.activation.DataHandler`

  throws: java.lang.IllegalArgumentException - if the attachment for the given cid is not found."
  (^javax.activation.DataHandler [^javax.xml.bind.attachment.AttachmentUnmarshaller this ^java.lang.String cid]
    (-> this (.getAttachmentAsDataHandler cid))))

(defn get-attachment-as-byte-array
  "Retrieve the attachment identified by content-id, cid,  as a byte[].

  cid - It is expected to be a valid lexical form of the XML Schema xs:anyURI datatype. If isXOPPackage() ==true, it must be a valid URI per the cid: URI scheme (see RFC 2387) - `java.lang.String`

  returns: byte[] representation of attachment identified by cid. - `byte[]`

  throws: java.lang.IllegalArgumentException - if the attachment for the given cid is not found."
  ([^javax.xml.bind.attachment.AttachmentUnmarshaller this ^java.lang.String cid]
    (-> this (.getAttachmentAsByteArray cid))))

(defn xop-package?
  "Read-only property that returns true if JAXB unmarshaller needs to perform XOP processing.

   This method returns true when the constraints specified
   in  Identifying XOP Documents are met.
   This value must not change during the unmarshalling process.

  returns: true when MIME context is a XOP Document. - `boolean`"
  (^Boolean [^javax.xml.bind.attachment.AttachmentUnmarshaller this]
    (-> this (.isXOPPackage))))

