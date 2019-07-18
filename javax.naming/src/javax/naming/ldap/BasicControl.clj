(ns javax.naming.ldap.BasicControl
  "This class provides a basic implementation of the Control
  interface. It represents an LDAPv3 Control as defined in
  RFC 2251."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.ldap BasicControl]))

(defn ->basic-control
  "Constructor.

  Constructs a control using the supplied arguments.

  id - The control's object identifier string. - `java.lang.String`
  criticality - The control's criticality. - `boolean`
  value - The control's ASN.1 BER encoded value. It is not cloned - any changes to value will affect the contents of the control. It may be null. - `byte[]`"
  (^BasicControl [^java.lang.String id ^Boolean criticality value]
    (new BasicControl id criticality value))
  (^BasicControl [^java.lang.String id]
    (new BasicControl id)))

(defn get-id
  "Retrieves the control's object identifier string.

  returns: The non-null object identifier string. - `java.lang.String`"
  (^java.lang.String [^BasicControl this]
    (-> this (.getID))))

(defn critical?
  "Determines the control's criticality.

  returns: true if the control is critical; false otherwise. - `boolean`"
  (^Boolean [^BasicControl this]
    (-> this (.isCritical))))

(defn get-encoded-value
  "Retrieves the control's ASN.1 BER encoded value.
   The result includes the BER tag and length for the control's value but
   does not include the control's object identifier and criticality setting.

  returns: A possibly null byte array representing the control's
            ASN.1 BER encoded value. It is not cloned - any changes to the
            returned value will affect the contents of the control. - `byte[]`"
  ([^BasicControl this]
    (-> this (.getEncodedValue))))

