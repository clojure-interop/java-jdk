(ns javax.naming.ldap.Rdn
  "This class represents a relative distinguished name, or RDN, which is a
  component of a distinguished name as specified by
  RFC 2253.
  An example of an RDN is `OU=Sales+CN=J.Smith`. In this example,
  the RDN consist of multiple attribute type/value pairs. The
  RDN is parsed as described in the class description for
  LdapName.

  The Rdn class represents an RDN as attribute type/value mappings,
  which can be viewed using
  Attributes.
  In addition, it contains convenience methods that allow easy retrieval
  of type and value when the Rdn consist of a single type/value pair,
  which is how it appears in a typical usage.
  It also contains helper methods that allow escaping of the unformatted
  attribute value and unescaping of the value formatted according to the
  escaping syntax defined in RFC2253. For methods that take or return
  attribute value as an Object, the value is either a String
  (in unescaped form) or a byte array.

  Rdn will properly parse all valid RDNs, but
  does not attempt to detect all possible violations when parsing
  invalid RDNs. It is `generous` in accepting invalid RDNs.
  The `validity` of a name is determined ultimately when it
  is supplied to an LDAP server, which may accept or
  reject the name based on factors such as its schema information
  and interoperability considerations.


  The following code example shows how to construct an Rdn using the
  constructor that takes type and value as arguments:


       Rdn rdn = new Rdn(`cn`, `Juicy, Fruit`);
       System.out.println(rdn.toString());
  The last line will print cn=Juicy\, Fruit. The
  unescapeValue() method can be
  used to unescape the escaped comma resulting in the original
  value `Juicy, Fruit`. The escapeValue() method adds the escape back preceding the comma.

  This class can be instantiated by a string representation
  of the RDN defined in RFC 2253 as shown in the following code example:


       Rdn rdn = new Rdn(`cn=Juicy\\, Fruit`);
       System.out.println(rdn.toString());
  The last line will print cn=Juicy\, Fruit.

  Concurrent multithreaded read-only access of an instance of
  Rdn need not be synchronized.

  Unless otherwise noted, the behavior of passing a null argument
  to a constructor or method in this class will cause NullPointerException
  to be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.ldap Rdn]))

(defn ->rdn
  "Constructor.

  Constructs an Rdn from the given attribute type and
   value.
   The string attribute values are not interpreted as
   RFC 2253
   formatted RDN strings. That is, the values are used
   literally (not parsed) and assumed to be unescaped.

  type - The non-null and non-empty string attribute type. - `java.lang.String`
  value - The non-null and non-empty attribute value. - `java.lang.Object`

  throws: javax.naming.InvalidNameException - If type/value cannot be used to construct a valid RDN."
  (^Rdn [^java.lang.String type ^java.lang.Object value]
    (new Rdn type value))
  (^Rdn [^javax.naming.directory.Attributes attr-set]
    (new Rdn attr-set)))

(defn *escape-value
  "Given the value of an attribute, returns a string escaped according
   to the rules specified in
   RFC 2253.

   For example, if the val is `Sue, Grabbit and Runn`, the escaped
   value returned by this method is `Sue\, Grabbit and Runn`.

   A string value is represented as a String and binary value
   as a byte array.

  val - The non-null object to be escaped. - `java.lang.Object`

  returns: Escaped string value. - `java.lang.String`

  throws: java.lang.ClassCastException - if val is is not a String or byte array."
  (^java.lang.String [^java.lang.Object val]
    (Rdn/escapeValue val)))

(defn *unescape-value
  "Given an attribute value string formated according to the rules
   specified in
   RFC 2253,
   returns the unformated value.  Escapes and quotes are
   stripped away, and hex-encoded UTF-8 is converted to equivalent
   UTF-16 characters. Returns a string value as a String, and a
   binary value as a byte array.

   Legal and illegal values are defined in RFC 2253.
   This method is generous in accepting the values and does not
   catch all illegal values.
   Therefore, passing in an illegal value might not necessarily
   trigger an IllegalArgumentException.

  val - The non-null string to be unescaped. - `java.lang.String`

  returns: Unescaped value. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - When an Illegal value is provided."
  (^java.lang.Object [^java.lang.String val]
    (Rdn/unescapeValue val)))

(defn get-value
  "Retrieves one of this Rdn's value.
   This is a convenience method for obtaining the value,
   when the RDN contains a single type and value mapping,
   which is the common RDN usage.

   For a multi-valued RDN, this method returns value corresponding
   to the type returned by getType() method.

  returns: The non-null attribute value. - `java.lang.Object`"
  (^java.lang.Object [^Rdn this]
    (-> this (.getValue))))

(defn get-type
  "Retrieves one of this Rdn's type.
   This is a convenience method for obtaining the type,
   when the RDN contains a single type and value mapping,
   which is the common RDN usage.

   For a multi-valued RDN, the type/value pairs have
   no specific order defined on them. In that case, this method
   returns type of one of the type/value pairs.
   The getValue() method returns the
   value corresponding to the type returned by this method.

  returns: The non-null attribute type. - `java.lang.String`"
  (^java.lang.String [^Rdn this]
    (-> this (.getType))))

(defn to-string
  "Returns this Rdn as a string represented in a format defined by
   RFC 2253 and described
   in the class description for LdapName.

  returns: The string representation of the Rdn. - `java.lang.String`"
  (^java.lang.String [^Rdn this]
    (-> this (.toString))))

(defn compare-to
  "Compares this Rdn with the specified Object for order.
   Returns a negative integer, zero, or a positive integer as this
   Rdn is less than, equal to, or greater than the given Object.

   If obj is null or not an instance of Rdn, ClassCastException
   is thrown.

   The attribute type and value pairs of the RDNs are lined up
   against each other and compared lexicographically. The order of
   components in multi-valued Rdns (such as `ou=Sales+cn=Bob`) is not
   significant.

  obj - The non-null object to compare against. - `java.lang.Object`

  returns: A negative integer, zero, or a positive integer as this Rdn
            is less than, equal to, or greater than the given Object. - `int`

  throws: java.lang.ClassCastException - if obj is null or not a Rdn."
  (^Integer [^Rdn this ^java.lang.Object obj]
    (-> this (.compareTo obj))))

(defn equals
  "Compares the specified Object with this Rdn for equality.
   Returns true if the given object is also a Rdn and the two Rdns
   represent the same attribute type and value mappings. The order of
   components in multi-valued Rdns (such as `ou=Sales+cn=Bob`) is not
   significant.

   Type and value equality matching is done as below:

    The types are compared for equality with their case ignored.
    String values with different but equivalent usage of quoting,
   escaping, or UTF8-hex-encoding are considered equal.
   The case of the values is ignored during the comparison.


   If obj is null or not an instance of Rdn, false is returned.

  obj - object to be compared for equality with this Rdn. - `java.lang.Object`

  returns: true if the specified object is equal to this Rdn. - `boolean`"
  (^Boolean [^Rdn this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the hash code of this RDN. Two RDNs that are
   equal (according to the equals method) will have the same
   hash code.

  returns: An int representing the hash code of this Rdn. - `int`"
  (^Integer [^Rdn this]
    (-> this (.hashCode))))

(defn to-attributes
  "Retrieves the Attributes
   view of the type/value mappings contained in this Rdn.

  returns: The non-null attributes containing the type/value
            mappings of this Rdn. - `javax.naming.directory.Attributes`"
  (^javax.naming.directory.Attributes [^Rdn this]
    (-> this (.toAttributes))))

(defn size
  "Retrieves the number of attribute type/value pairs in this Rdn.

  returns: The non-negative number of type/value pairs in this Rdn. - `int`"
  (^Integer [^Rdn this]
    (-> this (.size))))

