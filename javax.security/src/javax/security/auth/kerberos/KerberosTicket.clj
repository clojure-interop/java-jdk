(ns javax.security.auth.kerberos.KerberosTicket
  "This class encapsulates a Kerberos ticket and associated
  information as viewed from the client's point of view. It captures all
  information that the Key Distribution Center (KDC) sends to the client
  in the reply message KDC-REP defined in the Kerberos Protocol
  Specification (RFC 4120).

  All Kerberos JAAS login modules that authenticate a user to a KDC should
  use this class. Where available, the login module might even read this
  information from a ticket cache in the operating system instead of
  directly communicating with the KDC. During the commit phase of the JAAS
  authentication process, the JAAS login module should instantiate this
  class and store the instance in the private credential set of a
  Subject.

  It might be necessary for the application to be granted a
  PrivateCredentialPermission if it needs to access a KerberosTicket
  instance from a Subject. This permission is not needed when the
  application depends on the default JGSS Kerberos mechanism to access the
  KerberosTicket. In that case, however, the application will need an
  appropriate
  ServicePermission.

  Note that this class is applicable to both ticket granting tickets and
  other regular service tickets. A ticket granting ticket is just a
  special case of a more generalized service ticket."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.kerberos KerberosTicket]))

(defn ->kerberos-ticket
  "Constructor.

  Constructs a KerberosTicket using credentials information that a
   client either receives from a KDC or reads from a cache.

  asn-1-encoding - the ASN.1 encoding of the ticket as defined by the Kerberos protocol specification. - `byte[]`
  client - the client that owns this service ticket - `javax.security.auth.kerberos.KerberosPrincipal`
  server - the service that this ticket is for - `javax.security.auth.kerberos.KerberosPrincipal`
  session-key - the raw bytes for the session key that must be used to encrypt the authenticator that will be sent to the server - `byte[]`
  key-type - the key type for the session key as defined by the Kerberos protocol specification. - `int`
  flags - the ticket flags. Each element in this array indicates the value for the corresponding bit in the ASN.1 BitString that represents the ticket flags. If the number of elements in this array is less than the number of flags used by the Kerberos protocol, then the missing flags will be filled in with false. - `boolean[]`
  auth-time - the time of initial authentication for the client - `java.util.Date`
  start-time - the time after which the ticket will be valid. This may be null in which case the value of authTime is treated as the startTime. - `java.util.Date`
  end-time - the time after which the ticket will no longer be valid - `java.util.Date`
  renew-till - an absolute expiration time for the ticket, including all renewal that might be possible. This field may be null for tickets that are not renewable. - `java.util.Date`
  client-addresses - the addresses from where the ticket may be used by the client. This field may be null when the ticket is usable from any address. - `java.net.InetAddress[]`"
  ([asn-1-encoding ^javax.security.auth.kerberos.KerberosPrincipal client ^javax.security.auth.kerberos.KerberosPrincipal server session-key ^Integer key-type flags ^java.util.Date auth-time ^java.util.Date start-time ^java.util.Date end-time ^java.util.Date renew-till client-addresses]
    (new KerberosTicket asn-1-encoding client server session-key key-type flags auth-time start-time end-time renew-till client-addresses)))

(defn initial?
  "Determines if this ticket was issued using the Kerberos AS-Exchange
   protocol, and not issued based on some ticket-granting ticket.

  returns: true if this ticket was issued using the Kerberos AS-Exchange
   protocol, false if not. - `boolean`"
  (^Boolean [^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.isInitial))))

(defn renewable?
  "Determines is this ticket is renewable. If so, the refresh method can be called, assuming the validity period for
   renewing is not already over.

  returns: true if this ticket is renewable, false if not. - `boolean`"
  (^Boolean [^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.isRenewable))))

(defn get-session-key-type
  "Returns the key type of the session key associated with this
   ticket as defined by the Kerberos Protocol Specification.

  returns: the key type of the session key associated with this
   ticket. - `int`"
  (^Integer [^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.getSessionKeyType))))

(defn get-client
  "Returns the client principal associated with this ticket.

  returns: the client principal. - `javax.security.auth.kerberos.KerberosPrincipal`"
  (^javax.security.auth.kerberos.KerberosPrincipal [^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.getClient))))

(defn get-client-addresses
  "Returns a list of addresses from where the ticket can be used.

  returns: ths list of addresses or null, if the field was not
   provided. - `java.net.InetAddress[]`"
  ([^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.getClientAddresses))))

(defn get-start-time
  "Returns the start time for this ticket's validity period.

  returns: the start time for this ticket's validity period
           or null if not set. - `java.util.Date`"
  (^java.util.Date [^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.getStartTime))))

(defn get-server
  "Returns the service principal associated with this ticket.

  returns: the service principal. - `javax.security.auth.kerberos.KerberosPrincipal`"
  (^javax.security.auth.kerberos.KerberosPrincipal [^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.getServer))))

(defn current?
  "Determines if this ticket is still current.

  returns: true if this Object is currently current,
            false otherwise. - `boolean`"
  (^Boolean [^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.isCurrent))))

(defn forwarded?
  "Determines if this ticket had been forwarded or was issued based on
   authentication involving a forwarded ticket-granting ticket.

  returns: true if this ticket had been forwarded or was issued based on
   authentication involving a forwarded ticket-granting ticket,
   false otherwise. - `boolean`"
  (^Boolean [^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.isForwarded))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.toString))))

(defn refresh
  "Extends the validity period of this ticket. The ticket will contain
   a new session key if the refresh operation succeeds. The refresh
   operation will fail if the ticket is not renewable or the latest
   allowable renew time has passed. Any other error returned by the
   KDC will also cause this method to fail.

   Note: This method is not synchronized with the the accessor
   methods of this object. Hence callers need to be aware of multiple
   threads that might access this and try to renew it at the same
   time.

  throws: javax.security.auth.RefreshFailedException - if the ticket is not renewable, or the latest allowable renew time has passed, or the KDC returns some error."
  ([^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.refresh))))

(defn postdated?
  "Determines is this ticket is post-dated.

  returns: true if this ticket is post-dated, false if not. - `boolean`"
  (^Boolean [^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.isPostdated))))

(defn get-flags
  "Returns the flags associated with this ticket. Each element in the
   returned array indicates the value for the corresponding bit in the
   ASN.1 BitString that represents the ticket flags.

  returns: the flags associated with this ticket. - `boolean[]`"
  ([^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.getFlags))))

(defn get-auth-time
  "Returns the time that the client was authenticated.

  returns: the time that the client was authenticated
           or null if not set. - `java.util.Date`"
  (^java.util.Date [^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.getAuthTime))))

(defn destroy
  "Destroys the ticket and destroys any sensitive information stored in
   it.

  throws: javax.security.auth.DestroyFailedException - if the destroy operation fails."
  ([^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.destroy))))

(defn get-session-key
  "Returns the session key associated with this ticket.

  returns: the session key. - `javax.crypto.SecretKey`"
  (^javax.crypto.SecretKey [^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.getSessionKey))))

(defn get-end-time
  "Returns the expiration time for this ticket's validity period.

  returns: the expiration time for this ticket's validity period. - `java.util.Date`"
  (^java.util.Date [^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.getEndTime))))

(defn forwardable?
  "Determines if this ticket is forwardable.

  returns: true if this ticket is forwardable, false if not. - `boolean`"
  (^Boolean [^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.isForwardable))))

(defn get-encoded
  "Returns an ASN.1 encoding of the entire ticket.

  returns: an ASN.1 encoding of the entire ticket. - `byte[]`"
  ([^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.getEncoded))))

(defn hash-code
  "Returns a hashcode for this KerberosTicket.

  returns: a hashCode() for the KerberosTicket - `int`"
  (^Integer [^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.hashCode))))

(defn proxiable?
  "Determines if this ticket is proxiable.

  returns: true if this ticket is proxiable, false if not. - `boolean`"
  (^Boolean [^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.isProxiable))))

(defn destroyed?
  "Determines if this ticket has been destroyed.

  returns: true if this Object has been destroyed,
            false otherwise. - `boolean`"
  (^Boolean [^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.isDestroyed))))

(defn equals
  "Compares the specified Object with this KerberosTicket for equality.
   Returns true if the given object is also a
   KerberosTicket and the two
   KerberosTicket instances are equivalent.

  other - the Object to compare to - `java.lang.Object`

  returns: true if the specified object is equal to this KerberosTicket,
   false otherwise. NOTE: Returns false if either of the KerberosTicket
   objects has been destroyed. - `boolean`"
  (^Boolean [^javax.security.auth.kerberos.KerberosTicket this ^java.lang.Object other]
    (-> this (.equals other))))

(defn proxy?
  "Determines is this ticket is a proxy-ticket.

  returns: true if this ticket is a proxy-ticket, false if not. - `boolean`"
  (^Boolean [^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.isProxy))))

(defn get-renew-till
  "Returns the latest expiration time for this ticket, including all
   renewals. This will return a null value for non-renewable tickets.

  returns: the latest expiration time for this ticket. - `java.util.Date`"
  (^java.util.Date [^javax.security.auth.kerberos.KerberosTicket this]
    (-> this (.getRenewTill))))

