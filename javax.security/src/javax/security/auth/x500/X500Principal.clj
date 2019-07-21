(ns javax.security.auth.x500.X500Principal
  " This class represents an X.500 Principal.
  X500Principals are represented by distinguished names such as
  \"CN=Duke, OU=JavaSoft, O=Sun Microsystems, C=US\".

   This class can be instantiated by using a string representation
  of the distinguished name, or by using the ASN.1 DER encoded byte
  representation of the distinguished name.  The current specification
  for the string representation of a distinguished name is defined in
  RFC 2253: Lightweight
  Directory Access Protocol (v3): UTF-8 String Representation of
  Distinguished Names. This class, however, accepts string formats from
  both RFC 2253 and RFC 1779:
  A String Representation of Distinguished Names, and also recognizes
  attribute type keywords whose OIDs (Object Identifiers) are defined in
  RFC 3280: Internet X.509
  Public Key Infrastructure Certificate and CRL Profile.

   The string representation for this X500Principal
  can be obtained by calling the getName methods.

   Note that the getSubjectX500Principal and
  getIssuerX500Principal methods of
  X509Certificate return X500Principals representing the
  issuer and subject fields of the certificate."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.x500 X500Principal]))

(defn ->x-500-principal
  "Constructor.

  Creates an X500Principal from a string representation of
   an X.500 distinguished name (ex:
   \"CN=Duke, OU=JavaSoft, O=Sun Microsystems, C=US\").
   The distinguished name must be specified using the grammar defined in
   RFC 1779 or RFC 2253 (either format is acceptable).

    This constructor recognizes the attribute type keywords specified
   in X500Principal(String) and also recognizes additional
   keywords that have entries in the keywordMap parameter.
   Keyword entries in the keywordMap take precedence over the default
   keywords recognized by X500Principal(String). Keywords
   MUST be specified in all upper-case, otherwise they will be ignored.
   Improperly specified keywords are ignored; however if a keyword in the
   name maps to an improperly specified Object Identifier (OID), an
   IllegalArgumentException is thrown. It is permissible to
   have 2 different keywords that map to the same OID.

   This implementation enforces a more restrictive OID syntax than
   defined in RFC 1779 and 2253. It uses the more correct syntax defined in
   RFC 4512, which
   specifies that OIDs contain at least 2 digits:

   numericoid = number 1*( DOT number )

  name - an X.500 distinguished name in RFC 1779 or RFC 2253 format - `java.lang.String`
  keyword-map - an attribute type keyword map, where each key is a keyword String that maps to a corresponding object identifier in String form (a sequence of nonnegative integers separated by periods). The map may be empty but never null. - `java.util.Map`

  throws: java.lang.NullPointerException - if name or keywordMap is null"
  (^X500Principal [^java.lang.String name ^java.util.Map keyword-map]
    (new X500Principal name keyword-map))
  (^X500Principal [^java.lang.String name]
    (new X500Principal name)))

(def *-rfc-1779
  "Static Constant.

  RFC 1779 String format of Distinguished Names.

  type: java.lang.String"
  X500Principal/RFC1779)

(def *-rfc-2253
  "Static Constant.

  RFC 2253 String format of Distinguished Names.

  type: java.lang.String"
  X500Principal/RFC2253)

(def *-canonical
  "Static Constant.

  Canonical String format of Distinguished Names.

  type: java.lang.String"
  X500Principal/CANONICAL)

(defn get-name
  "Returns a string representation of the X.500 distinguished name
   using the specified format. Valid values for the format are
   \"RFC1779\" and \"RFC2253\" (case insensitive). \"CANONICAL\" is not
   permitted and an IllegalArgumentException will be thrown.

   This method returns Strings in the format as specified in
   getName(String) and also emits additional attribute type
   keywords for OIDs that have entries in the oidMap
   parameter. OID entries in the oidMap take precedence over the default
   OIDs recognized by getName(String).
   Improperly specified OIDs are ignored; however if an OID
   in the name maps to an improperly specified keyword, an
   IllegalArgumentException is thrown.

    Additional standard formats may be introduced in the future.

    Warning: additional attribute type keywords may not be recognized
   by other implementations; therefore do not use this method if
   you are unsure if these keywords will be recognized by other
   implementations.

  format - the format to use - `java.lang.String`
  oid-map - an OID map, where each key is an object identifier in String form (a sequence of nonnegative integers separated by periods) that maps to a corresponding attribute type keyword String. The map may be empty but never null. - `java.util.Map`

  returns: a string representation of this X500Principal
            using the specified format - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the specified format is invalid, null, or an OID in the name maps to an improperly specified keyword"
  (^java.lang.String [^X500Principal this ^java.lang.String format ^java.util.Map oid-map]
    (-> this (.getName format oid-map)))
  (^java.lang.String [^X500Principal this ^java.lang.String format]
    (-> this (.getName format)))
  (^java.lang.String [^X500Principal this]
    (-> this (.getName))))

(defn get-encoded
  "Returns the distinguished name in ASN.1 DER encoded form. The ASN.1
   notation for this structure is supplied in the documentation for
   X500Principal(byte[] name).

   Note that the byte array returned is cloned to protect against
   subsequent modifications.

  returns: a byte array containing the distinguished name in ASN.1 DER
   encoded form - `byte[]`"
  ([^X500Principal this]
    (-> this (.getEncoded))))

(defn to-string
  "Return a user-friendly string representation of this
   X500Principal.

  returns: a string representation of this X500Principal - `java.lang.String`"
  (^java.lang.String [^X500Principal this]
    (-> this (.toString))))

(defn equals
  "Compares the specified Object with this
   X500Principal for equality.

    Specifically, this method returns true if
   the Object o is an X500Principal
   and if the respective canonical string representations
   (obtained via the getName(X500Principal.CANONICAL) method)
   of this object and o are equal.

    This implementation is compliant with the requirements of RFC 3280.

  o - Object to be compared for equality with this X500Principal - `java.lang.Object`

  returns: true if the specified Object is equal
            to this X500Principal, false otherwise - `boolean`"
  (^Boolean [^X500Principal this ^java.lang.Object o]
    (-> this (.equals o))))

(defn hash-code
  "Return a hash code for this X500Principal.

    The hash code is calculated via:
   getName(X500Principal.CANONICAL).hashCode()

  returns: a hash code for this X500Principal - `int`"
  (^Integer [^X500Principal this]
    (-> this (.hashCode))))

