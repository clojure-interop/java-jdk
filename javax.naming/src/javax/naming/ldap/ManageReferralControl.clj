(ns javax.naming.ldap.ManageReferralControl
  "Requests that referral and other special LDAP objects be manipulated
  as normal LDAP objects. It enables the requestor to interrogate or
  update such objects.

  This class implements the LDAPv3 Request Control for ManageDsaIT
  as defined in
  RFC 3296.

  The control has no control value."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.ldap ManageReferralControl]))

(defn ->manage-referral-control
  "Constructor.

  Constructs a ManageReferral control.

  criticality - The control's criticality setting. - `boolean`"
  ([criticality]
    (new ManageReferralControl criticality))
  ([]
    (new ManageReferralControl )))

(def *-oid
  "Static Constant.

  The ManageReferral control's assigned object identifier
   is 2.16.840.1.113730.3.4.2.

  type: java.lang.String"
  ManageReferralControl/OID)

