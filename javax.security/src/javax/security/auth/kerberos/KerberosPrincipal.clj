(ns javax.security.auth.kerberos.KerberosPrincipal
  "This class encapsulates a Kerberos principal."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.kerberos KerberosPrincipal]))

(defn ->kerberos-principal
  "Constructor.

  Constructs a KerberosPrincipal from the provided string and
   name type input.  The string is assumed to contain a name in the
   format that is specified in Section 2.1 (Mandatory Name Forms) of
   RFC 1964.
   Valid name types are specified in Section 6.2 (Principal Names) of
   RFC 4120.
   The input name must be consistent with the provided name type.
   (for example, duke@FOO.COM, is a valid input string for the
   name type, KRB_NT_PRINCIPAL where duke
   represents a principal, and FOO.COM represents a realm).

    If the input name does not contain a realm, the default realm
   is used. The default realm can be specified either in a Kerberos
   configuration file or via the java.security.krb5.realm
   system property. For more information, see

   Kerberos Requirements.

  name - the principal name - `java.lang.String`
  name-type - the name type of the principal - `int`

  throws: java.lang.IllegalArgumentException - if name is improperly formatted, if name is null, if the nameType is not supported, or if name does not contain the realm to use and the default realm is not specified in either a Kerberos configuration file or via the java.security.krb5.realm system property."
  ([name name-type]
    (new KerberosPrincipal name name-type))
  ([name]
    (new KerberosPrincipal name)))

(def *-krb-nt-unknown
  "Static Constant.

  unknown name type.

  type: int"
  KerberosPrincipal/KRB_NT_UNKNOWN)

(def *-krb-nt-principal
  "Static Constant.

  user principal name type.

  type: int"
  KerberosPrincipal/KRB_NT_PRINCIPAL)

(def *-krb-nt-srv-inst
  "Static Constant.

  service and other unique instance (krbtgt) name type.

  type: int"
  KerberosPrincipal/KRB_NT_SRV_INST)

(def *-krb-nt-srv-hst
  "Static Constant.

  service with host name as instance (telnet, rcommands) name type.

  type: int"
  KerberosPrincipal/KRB_NT_SRV_HST)

(def *-krb-nt-srv-xhst
  "Static Constant.

  service with host as remaining components name type.

  type: int"
  KerberosPrincipal/KRB_NT_SRV_XHST)

(def *-krb-nt-uid
  "Static Constant.

  unique ID name type.

  type: int"
  KerberosPrincipal/KRB_NT_UID)

(defn get-realm
  "Returns the realm component of this Kerberos principal.

  returns: the realm component of this Kerberos principal. - `java.lang.String`"
  ([this]
    (-> this (.getRealm))))

(defn hash-code
  "Returns a hashcode for this principal. The hash code is defined to
   be the result of the following  calculation:


    hashCode = getName().hashCode();

  returns: a hashCode() for the KerberosPrincipal - `int`"
  ([this]
    (-> this (.hashCode))))

(defn equals
  "Compares the specified Object with this Principal for equality.
   Returns true if the given object is also a
   KerberosPrincipal and the two
   KerberosPrincipal instances are equivalent.
   More formally two KerberosPrincipal instances are equal
   if the values returned by getName() are equal.

  other - the Object to compare to - `java.lang.Object`

  returns: true if the Object passed in represents the same principal
   as this one, false otherwise. - `boolean`"
  ([this other]
    (-> this (.equals other))))

(defn get-name
  "The returned string corresponds to the single-string
   representation of a Kerberos Principal name as specified in
   Section 2.1 of RFC 1964.

  returns: the principal name. - `java.lang.String`"
  ([this]
    (-> this (.getName))))

(defn get-name-type
  "Returns the name type of the KerberosPrincipal. Valid name types
   are specified in Section 6.2 of
    RFC4120.

  returns: the name type. - `int`"
  ([this]
    (-> this (.getNameType))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

