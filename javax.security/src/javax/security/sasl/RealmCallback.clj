(ns javax.security.sasl.RealmCallback
  "This callback is used by SaslClient and SaslServer
  to retrieve realm information."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.sasl RealmCallback]))

(defn ->realm-callback
  "Constructor.

  Constructs a RealmCallback with a prompt and default
   realm information.

  prompt - The non-null prompt to use to request the realm information. - `java.lang.String`
  default-realm-info - The non-null default realm information to use. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - If prompt is null or the empty string, or if defaultRealm is empty or null."
  (^RealmCallback [^java.lang.String prompt ^java.lang.String default-realm-info]
    (new RealmCallback prompt default-realm-info))
  (^RealmCallback [^java.lang.String prompt]
    (new RealmCallback prompt)))

