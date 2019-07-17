(ns javax.net.ssl.SNIHostName
  "Instances of this class represent a server name of type
  host_name in a Server Name
  Indication (SNI) extension.

  As described in section 3, `Server Name Indication`, of
  TLS Extensions (RFC 6066),
  `HostName` contains the fully qualified DNS hostname of the server, as
  understood by the client.  The encoded server name value of a hostname is
  represented as a byte string using ASCII encoding without a trailing dot.
  This allows the support of Internationalized Domain Names (IDN) through
  the use of A-labels (the ASCII-Compatible Encoding (ACE) form of a valid
  string of Internationalized Domain Names for Applications (IDNA)) defined
  in RFC 5890.

  Note that SNIHostName objects are immutable."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl SNIHostName]))

(defn ->sni-host-name
  "Constructor.

  Creates an SNIHostName using the specified hostname.

   Note that per RFC 6066,
   the encoded server name value of a hostname is
   StandardCharsets.US_ASCII-compliant.  In this method,
   hostname can be a user-friendly Internationalized Domain Name
   (IDN).  IDN.toASCII(String, int) is used to enforce the
   restrictions on ASCII characters in hostnames (see
   RFC 3490,
   RFC 1122,
   RFC 1123) and
   translate the hostname into ASCII Compatible Encoding (ACE), as:


       IDN.toASCII(hostname, IDN.USE_STD3_ASCII_RULES);

   The hostname argument is illegal if it:

    hostname is empty,
    hostname ends with a trailing dot,
    hostname is not a valid Internationalized
        Domain Name (IDN) compliant with the RFC 3490 specification.

  hostname - the hostname of this server name - `java.lang.String`

  throws: java.lang.NullPointerException - if hostname is null"
  ([hostname]
    (new SNIHostName hostname)))

(defn *create-sni-matcher
  "Creates an SNIMatcher object for SNIHostNames.

   This method can be used by a server to verify the acceptable
   SNIHostNames.  For example,


       SNIMatcher matcher =
           SNIHostName.createSNIMatcher(`www\\.example\\.com`);
   will accept the hostname `www.example.com`.


       SNIMatcher matcher =
           SNIHostName.createSNIMatcher(`www\\.example\\.(com|org)`);
   will accept hostnames `www.example.com` and `www.example.org`.

  regex - the regular expression pattern representing the hostname(s) to match - `java.lang.String`

  returns: a SNIMatcher object for SNIHostNames - `javax.net.ssl.SNIMatcher`

  throws: java.lang.NullPointerException - if regex is null"
  ([regex]
    (SNIHostName/createSNIMatcher regex)))

(defn get-ascii-name
  "Returns the StandardCharsets.US_ASCII-compliant hostname of
   this SNIHostName object.

   Note that, per
   RFC 6066, the
   returned hostname may be an internationalized domain name that
   contains A-labels. See
   RFC 5890
   for more information about the detailed A-label specification.

  returns: the StandardCharsets.US_ASCII-compliant hostname
           of this SNIHostName object - `java.lang.String`"
  ([this]
    (-> this (.getAsciiName))))

(defn equals
  "Compares this server name to the specified object.

   Per RFC 6066, DNS
   hostnames are case-insensitive.  Two server hostnames are equal if,
   and only if, they have the same name type, and the hostnames are
   equal in a case-independent comparison.

  other - the other server name object to compare with. - `java.lang.Object`

  returns: true if, and only if, the other is considered
           equal to this instance - `boolean`"
  ([this other]
    (-> this (.equals other))))

(defn hash-code
  "Returns a hash code value for this SNIHostName.

   The hash code value is generated using the case-insensitive hostname
   of this SNIHostName.

  returns: a hash code value for this SNIHostName. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a string representation of the object, including the DNS
   hostname in this SNIHostName object.

   The exact details of the representation are unspecified and subject
   to change, but the following may be regarded as typical:


       `type=host_name (0), value= <hostname>`
   The `<hostname>` is an ASCII representation of the hostname,
   which may contains A-labels.  For example, a returned value of an pseudo
   hostname may look like:


       `type=host_name (0), value=www.example.com`
   or


       `type=host_name (0), value=xn--fsqu00a.xn--0zwm56d`

   Please NOTE that the exact details of the representation are unspecified
   and subject to change.

  returns: a string representation of the object. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

