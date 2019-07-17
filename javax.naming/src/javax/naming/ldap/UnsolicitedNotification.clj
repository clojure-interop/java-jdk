(ns javax.naming.ldap.UnsolicitedNotification
  "This interface represents an unsolicited notification as defined in
  RFC 2251.
  An unsolicited notification is sent by the LDAP server to the LDAP
  client without any provocation from the client.
  Its format is that of an extended response (ExtendedResponse)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.ldap UnsolicitedNotification]))

(defn get-referrals
  "Retrieves the referral(s) sent by the server.

  returns: A possibly null array of referrals, each of which is represented
   by a URL string. If null, no referral was sent by the server. - `java.lang.String[]`"
  ([^javax.naming.ldap.UnsolicitedNotification this]
    (-> this (.getReferrals))))

(defn get-exception
  "Retrieves the exception as constructed using information
   sent by the server.

  returns: A possibly null exception as constructed using information
   sent by the server. If null, a `success` status was indicated by
   the server. - `javax.naming.NamingException`"
  ([^javax.naming.ldap.UnsolicitedNotification this]
    (-> this (.getException))))

