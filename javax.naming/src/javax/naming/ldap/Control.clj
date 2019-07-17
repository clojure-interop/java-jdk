(ns javax.naming.ldap.Control
  "This interface represents an LDAPv3 control as defined in
  RFC 2251.

  The LDAPv3 protocol uses controls to send and receive additional data
  to affect the behavior of predefined operations.
  Controls can be sent along with any LDAP operation to the server.
  These are referred to as request controls. For example, a
  `sort` control can be sent with an LDAP search operation to
  request that the results be returned in a particular order.
  Solicited and unsolicited controls can also be returned with
  responses from the server. Such controls are referred to as
  response controls. For example, an LDAP server might
  define a special control to return change notifications.

  This interface is used to represent both request and response controls."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.ldap Control]))

(defn get-id
  "Retrieves the object identifier assigned for the LDAP control.

  returns: The non-null object identifier string. - `java.lang.String`"
  (^java.lang.String [^javax.naming.ldap.Control this]
    (-> this (.getID))))

(defn critical?
  "Determines the criticality of the LDAP control.
   A critical control must not be ignored by the server.
   In other words, if the server receives a critical control
   that it does not support, regardless of whether the control
   makes sense for the operation, the operation will not be performed
   and an OperationNotSupportedException will be thrown.

  returns: true if this control is critical; false otherwise. - `boolean`"
  (^Boolean [^javax.naming.ldap.Control this]
    (-> this (.isCritical))))

(defn get-encoded-value
  "Retrieves the ASN.1 BER encoded value of the LDAP control.
   The result is the raw BER bytes including the tag and length of
   the control's value. It does not include the controls OID or criticality.

   Null is returned if the value is absent.

  returns: A possibly null byte array representing the ASN.1 BER encoded
           value of the LDAP control. - `byte[]`"
  ([^javax.naming.ldap.Control this]
    (-> this (.getEncodedValue))))

