(ns jdk.security.cert.Extension
  "This interface represents an X.509 extension.


  Extensions provide a means of associating additional attributes with users
  or public keys and for managing a certification hierarchy.  The extension
  format also allows communities to define private extensions to carry
  information unique to those communities.


  Each extension contains an object identifier, a criticality setting
  indicating whether it is a critical or a non-critical extension, and
  and an ASN.1 DER-encoded value. Its ASN.1 definition is:



      Extension ::= SEQUENCE {
          extnId        OBJECT IDENTIFIER,
          critical      BOOLEAN DEFAULT FALSE,
          extnValue     OCTET STRING
                  -- contains a DER encoding of a value
                  -- of the type registered for use with
                  -- the extnId object identifier value
      }


  This interface is designed to provide access to a single extension,
  unlike X509Extension which is more suitable
  for accessing a set of extensions."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert Extension]))

(defn get-id
  "Gets the extensions's object identifier.

  returns: the object identifier as a String - `java.lang.String`"
  ([this]
    (-> this (.getId))))

(defn critical?
  "Gets the extension's criticality setting.

  returns: true if this is a critical extension. - `boolean`"
  ([this]
    (-> this (.isCritical))))

(defn get-value
  "Gets the extensions's DER-encoded value. Note, this is the bytes
   that are encoded as an OCTET STRING. It does not include the OCTET
   STRING tag and length.

  returns: a copy of the extension's value, or null if no
      extension value is present. - `byte[]`"
  ([this]
    (-> this (.getValue))))

(defn encode
  "Generates the extension's DER encoding and writes it to the output
   stream.

  out - the output stream - `java.io.OutputStream`

  throws: java.io.IOException - on encoding or output error."
  ([this out]
    (-> this (.encode out))))

