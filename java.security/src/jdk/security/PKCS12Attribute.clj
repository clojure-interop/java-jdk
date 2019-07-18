(ns jdk.security.PKCS12Attribute
  "An attribute associated with a PKCS12 keystore entry.
  The attribute name is an ASN.1 Object Identifier and the attribute
  value is a set of ASN.1 types."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security PKCS12Attribute]))

(defn ->pkcs-12-attribute
  "Constructor.

  Constructs a PKCS12 attribute from its name and value.
   The name is an ASN.1 Object Identifier represented as a list of
   dot-separated integers.
   A string value is represented as the string itself.
   A binary value is represented as a string of colon-separated
   pairs of hexadecimal digits.
   Multi-valued attributes are represented as a comma-separated
   list of values, enclosed in square brackets. See
   Arrays.toString(java.lang.Object[]).

   A string value will be DER-encoded as an ASN.1 UTF8String and a
   binary value will be DER-encoded as an ASN.1 Octet String.

  name - the attribute's identifier - `java.lang.String`
  value - the attribute's value - `java.lang.String`

  throws: java.lang.NullPointerException - if name or value is null"
  (^PKCS12Attribute [^java.lang.String name ^java.lang.String value]
    (new PKCS12Attribute name value))
  (^PKCS12Attribute [encoded]
    (new PKCS12Attribute encoded)))

(defn get-name
  "Returns the attribute's ASN.1 Object Identifier represented as a
   list of dot-separated integers.

  returns: the attribute's identifier - `java.lang.String`"
  (^java.lang.String [^PKCS12Attribute this]
    (-> this (.getName))))

(defn get-value
  "Returns the attribute's ASN.1 DER-encoded value as a string.
   An ASN.1 DER-encoded value is returned in one of the following
   String formats:

    the DER encoding of a basic ASN.1 type that has a natural
        string representation is returned as the string itself.
        Such types are currently limited to BOOLEAN, INTEGER,
        OBJECT IDENTIFIER, UTCTime, GeneralizedTime and the
        following six ASN.1 string types: UTF8String,
        PrintableString, T61String, IA5String, BMPString and
        GeneralString.
    the DER encoding of any other ASN.1 type is not decoded but
        returned as a binary string of colon-separated pairs of
        hexadecimal digits.

   Multi-valued attributes are represented as a comma-separated
   list of values, enclosed in square brackets. See
   Arrays.toString(java.lang.Object[]).

  returns: the attribute value's string encoding - `java.lang.String`"
  (^java.lang.String [^PKCS12Attribute this]
    (-> this (.getValue))))

(defn get-encoded
  "Returns the attribute's ASN.1 DER encoding.

  returns: a clone of the attribute's DER encoding - `byte[]`"
  ([^PKCS12Attribute this]
    (-> this (.getEncoded))))

(defn equals
  "Compares this PKCS12Attribute and a specified object for
   equality.

  obj - the comparison object - `java.lang.Object`

  returns: true if obj is a PKCS12Attribute and
   their DER encodings are equal. - `boolean`"
  (^Boolean [^PKCS12Attribute this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the hashcode for this PKCS12Attribute.
   The hash code is computed from its DER encoding.

  returns: the hash code - `int`"
  (^Integer [^PKCS12Attribute this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a string representation of this PKCS12Attribute.

  returns: a name/value pair separated by an 'equals' symbol - `java.lang.String`"
  (^java.lang.String [^PKCS12Attribute this]
    (-> this (.toString))))

