(ns javax.xml.crypto.dsig.keyinfo.PGPData
  "A representation of the XML PGPData element as defined in
  the
  W3C Recommendation for XML-Signature Syntax and Processing. A
  PGPData object is used to convey information related to
  PGP public key pairs and signatures on such keys. The XML Schema Definition
  is defined as:



     <element name=`PGPData` type=`ds:PGPDataType`/>
     <complexType name=`PGPDataType`>
       <choice>
         <sequence>
           <element name=`PGPKeyID` type=`base64Binary`/>
           <element name=`PGPKeyPacket` type=`base64Binary` minOccurs=`0`/>
           <any namespace=`##other` processContents=`lax` minOccurs=`0`
            maxOccurs=`unbounded`/>
         </sequence>
         <sequence>
           <element name=`PGPKeyPacket` type=`base64Binary`/>
           <any namespace=`##other` processContents=`lax` minOccurs=`0`
            maxOccurs=`unbounded`/>
         </sequence>
       </choice>
     </complexType>

  A PGPData instance may be created by invoking one of the
  newPGPData methods of the KeyInfoFactory class, and passing it
  byte arrays representing the contents of the PGP public key
  identifier and/or PGP key material packet, and an optional list of
  elements from an external namespace."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig.keyinfo PGPData]))

(defn get-key-id
  "Returns the PGP public key identifier of this PGPData as
   defined in RFC 2440,
   section 11.2.

  returns: the PGP public key identifier (may be null if
      not specified). Each invocation of this method returns a new clone
      to protect against subsequent modification. - `byte[]`"
  ([^PGPData this]
    (-> this (.getKeyId))))

(defn get-key-packet
  "Returns the PGP key material packet of this PGPData as
   defined in RFC 2440,
   section 5.5.

  returns: the PGP key material packet (may be null if not
      specified). Each invocation of this method returns a new clone to
      protect against subsequent modification. - `byte[]`"
  ([^PGPData this]
    (-> this (.getKeyPacket))))

(defn get-external-elements
  "Returns an unmodifiable list
   of XMLStructures representing elements from an external
   namespace.

  returns: an unmodifiable list of XMLStructures (may be
      empty, but never null) - `java.util.List`"
  (^java.util.List [^PGPData this]
    (-> this (.getExternalElements))))

