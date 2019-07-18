(ns jdk.security.AuthProvider
  "This class defines login and logout methods for a provider.

   While callers may invoke login directly,
  the provider may also invoke login on behalf of callers
  if it determines that a login must be performed
  prior to certain operations."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security AuthProvider]))

(defn login
  "Log in to this provider.

    The provider relies on a CallbackHandler
   to obtain authentication information from the caller
   (a PIN, for example).  If the caller passes a null
   handler to this method, the provider uses the handler set in the
   setCallbackHandler method.
   If no handler was set in that method, the provider queries the
   auth.login.defaultCallbackHandler security property
   for the fully qualified class name of a default handler implementation.
   If the security property is not set,
   the provider is assumed to have alternative means
   for obtaining authentication information.

  subject - the Subject which may contain principals/credentials used for authentication, or may be populated with additional principals/credentials after successful authentication has completed. This parameter may be null. - `javax.security.auth.Subject`
  handler - the CallbackHandler used by this provider to obtain authentication information from the caller, which may be null - `javax.security.auth.callback.CallbackHandler`

  throws: javax.security.auth.login.LoginException - if the login operation fails"
  ([^AuthProvider this ^javax.security.auth.Subject subject ^javax.security.auth.callback.CallbackHandler handler]
    (-> this (.login subject handler))))

(defn logout
  "Log out from this provider.

  throws: javax.security.auth.login.LoginException - if the logout operation fails"
  ([^AuthProvider this]
    (-> this (.logout))))

(defn set-callback-handler
  "Set a CallbackHandler.

    The provider uses this handler if one is not passed to the
   login method.  The provider also uses this handler
   if it invokes login on behalf of callers.
   In either case if a handler is not set via this method,
   the provider queries the
   auth.login.defaultCallbackHandler security property
   for the fully qualified class name of a default handler implementation.
   If the security property is not set,
   the provider is assumed to have alternative means
   for obtaining authentication information.

  handler - a CallbackHandler for obtaining authentication information, which may be null - `javax.security.auth.callback.CallbackHandler`

  throws: java.lang.SecurityException - if the caller does not pass a security check for SecurityPermission(`authProvider.name`), where name is the value returned by this provider's getName method"
  ([^AuthProvider this ^javax.security.auth.callback.CallbackHandler handler]
    (-> this (.setCallbackHandler handler))))

