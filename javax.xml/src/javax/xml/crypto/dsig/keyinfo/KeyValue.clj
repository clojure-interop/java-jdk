(ns javax.xml.crypto.dsig.keyinfo.KeyValue
  "A representation of the XML KeyValue element as defined
  in the
  W3C Recommendation for XML-Signature Syntax and Processing. A
  KeyValue object contains a single public key that may be
  useful in validating the signature. The XML schema definition is defined as:



     <element name=`KeyValue` type=`ds:KeyValueType`/>
     <complexType name=`KeyValueType` mixed=`true`>
       <choice>
         <element ref=`ds:DSAKeyValue`/>
         <element ref=`ds:RSAKeyValue`/>
         <any namespace=`##other` processContents=`lax`/>
       </choice>
     </complexType>

     <element name=`DSAKeyValue` type=`ds:DSAKeyValueType`/>
     <complexType name=`DSAKeyValueType`>
       <sequence>
         <sequence minOccurs=`0`>
           <element name=`P` type=`ds:CryptoBinary`/>
           <element name=`Q` type=`ds:CryptoBinary`/>
         </sequence>
         <element name=`G` type=`ds:CryptoBinary` minOccurs=`0`/>
         <element name=`Y` type=`ds:CryptoBinary`/>
         <element name=`J` type=`ds:CryptoBinary` minOccurs=`0`/>
         <sequence minOccurs=`0`>
           <element name=`Seed` type=`ds:CryptoBinary`/>
           <element name=`PgenCounter` type=`ds:CryptoBinary`/>
         </sequence>
       </sequence>
     </complexType>

     <element name=`RSAKeyValue` type=`ds:RSAKeyValueType`/>
     <complexType name=`RSAKeyValueType`>
       <sequence>
         <element name=`Modulus` type=`ds:CryptoBinary`/>
         <element name=`Exponent` type=`ds:CryptoBinary`/>
       </sequence>
     </complexType>
  A KeyValue instance may be created by invoking the
  newKeyValue method of the
  KeyInfoFactory class, and passing it a PublicKey representing the value of the public key. Here is
  an example of creating a KeyValue from a DSAPublicKey
  of a Certificate stored in a
  KeyStore:


  KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
  PublicKey dsaPublicKey = keyStore.getCertificate(`myDSASigningCert`).getPublicKey();
  KeyInfoFactory factory = KeyInfoFactory.getInstance(`DOM`);
  KeyValue keyValue = factory.newKeyValue(dsaPublicKey);

  This class returns the DSAKeyValue and
  RSAKeyValue elements as objects of type
  DSAPublicKey and RSAPublicKey, respectively. Note that not
  all of the fields in the schema are accessible as parameters of these
  types."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig.keyinfo KeyValue]))

(defn get-public-key
  "Returns the public key of this KeyValue.

  returns: the public key of this KeyValue - `java.security.PublicKey`

  throws: java.security.KeyException - if this KeyValue cannot be converted to a PublicKey"
  ([^javax.xml.crypto.dsig.keyinfo.KeyValue this]
    (-> this (.getPublicKey))))

