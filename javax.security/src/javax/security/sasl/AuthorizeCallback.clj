(ns javax.security.sasl.AuthorizeCallback
  "This callback is used by SaslServer to determine whether
  one entity (identified by an authenticated authentication id)
  can act on
  behalf of another entity (identified by an authorization id)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.sasl AuthorizeCallback]))

(defn ->authorize-callback
  "Constructor.

  Constructs an instance of AuthorizeCallback.

  authn-id - The (authenticated) authentication id. - `java.lang.String`
  authz-id - The authorization id. - `java.lang.String`"
  ([^java.lang.String authn-id ^java.lang.String authz-id]
    (new AuthorizeCallback authn-id authz-id)))

(defn get-authentication-id
  "Returns the authentication id to check.

  returns: The authentication id to check. - `java.lang.String`"
  (^java.lang.String [^javax.security.sasl.AuthorizeCallback this]
    (-> this (.getAuthenticationID))))

(defn get-authorization-id
  "Returns the authorization id to check.

  returns: The authentication id to check. - `java.lang.String`"
  (^java.lang.String [^javax.security.sasl.AuthorizeCallback this]
    (-> this (.getAuthorizationID))))

(defn authorized?
  "Determines whether the authentication id is allowed to
   act on behalf of the authorization id.

  returns: true if authorization is allowed; false otherwise - `boolean`"
  (^Boolean [^javax.security.sasl.AuthorizeCallback this]
    (-> this (.isAuthorized))))

(defn set-authorized
  "Sets whether the authorization is allowed.

  ok - true if authorization is allowed; false otherwise - `boolean`"
  ([^javax.security.sasl.AuthorizeCallback this ^Boolean ok]
    (-> this (.setAuthorized ok))))

(defn get-authorized-id
  "Returns the id of the authorized user.

  returns: The id of the authorized user. null means the
   authorization failed. - `java.lang.String`"
  (^java.lang.String [^javax.security.sasl.AuthorizeCallback this]
    (-> this (.getAuthorizedID))))

(defn set-authorized-id
  "Sets the id of the authorized entity. Called by handler only when the id
   is different from getAuthorizationID(). For example, the id
   might need to be canonicalized for the environment in which it
   will be used.

  id - The id of the authorized user. - `java.lang.String`"
  ([^javax.security.sasl.AuthorizeCallback this ^java.lang.String id]
    (-> this (.setAuthorizedID id))))

