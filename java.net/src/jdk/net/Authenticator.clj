(ns jdk.net.Authenticator
  "The class Authenticator represents an object that knows how to obtain
  authentication for a network connection.  Usually, it will do this
  by prompting the user for information.

  Applications use this class by overriding getPasswordAuthentication() in a sub-class. This method will
  typically use the various getXXX() accessor methods to get information
  about the entity requesting authentication. It must then acquire a
  username and password either by interacting with the user or through
  some other non-interactive means. The credentials are then returned
  as a PasswordAuthentication return value.

  An instance of this concrete sub-class is then registered
  with the system by calling setDefault(Authenticator).
  When authentication is required, the system will invoke one of the
  requestPasswordAuthentication() methods which in turn will call the
  getPasswordAuthentication() method of the registered object.

  All methods that request authentication have a default implementation
  that fails."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net Authenticator]))

(defn ->authenticator
  "Constructor."
  (^Authenticator []
    (new Authenticator )))

(defn *set-default
  "Sets the authenticator that will be used by the networking code
   when a proxy or an HTTP server asks for authentication.

   First, if there is a security manager, its checkPermission
   method is called with a
   NetPermission(\"setDefaultAuthenticator\") permission.
   This may result in a java.lang.SecurityException.

  a - The authenticator to be set. If a is null then any previously set authenticator is removed. - `java.net.Authenticator`

  throws: java.lang.SecurityException - if a security manager exists and its checkPermission method doesn't allow setting the default authenticator."
  ([^java.net.Authenticator a]
    (Authenticator/setDefault a)))

(defn *request-password-authentication
  "Ask the authenticator that has been registered with the system
   for a password.

   First, if there is a security manager, its checkPermission
   method is called with a
   NetPermission(\"requestPasswordAuthentication\") permission.
   This may result in a java.lang.SecurityException.

  host - The hostname of the site requesting authentication. - `java.lang.String`
  addr - The InetAddress of the site requesting authorization, or null if not known. - `java.net.InetAddress`
  port - the port for the requested connection - `int`
  protocol - The protocol that's requesting the connection (getRequestingProtocol()) - `java.lang.String`
  prompt - A prompt string for the user - `java.lang.String`
  scheme - The authentication scheme - `java.lang.String`
  url - The requesting URL that caused the authentication - `java.net.URL`
  req-type - The type (server or proxy) of the entity requesting authentication. - `java.net.Authenticator$RequestorType`

  returns: The username/password, or null if one can't be gotten. - `java.net.PasswordAuthentication`

  throws: java.lang.SecurityException - if a security manager exists and its checkPermission method doesn't allow the password authentication request."
  (^java.net.PasswordAuthentication [^java.lang.String host ^java.net.InetAddress addr ^Integer port ^java.lang.String protocol ^java.lang.String prompt ^java.lang.String scheme ^java.net.URL url ^java.net.Authenticator$RequestorType req-type]
    (Authenticator/requestPasswordAuthentication host addr port protocol prompt scheme url req-type))
  (^java.net.PasswordAuthentication [^java.lang.String host ^java.net.InetAddress addr ^Integer port ^java.lang.String protocol ^java.lang.String prompt ^java.lang.String scheme]
    (Authenticator/requestPasswordAuthentication host addr port protocol prompt scheme))
  (^java.net.PasswordAuthentication [^java.net.InetAddress addr ^Integer port ^java.lang.String protocol ^java.lang.String prompt ^java.lang.String scheme]
    (Authenticator/requestPasswordAuthentication addr port protocol prompt scheme)))

