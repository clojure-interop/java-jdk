(ns jdk.net.CookieHandler
  "A CookieHandler object provides a callback mechanism to hook up a
  HTTP state management policy implementation into the HTTP protocol
  handler. The HTTP state management mechanism specifies a way to
  create a stateful session with HTTP requests and responses.

  A system-wide CookieHandler that to used by the HTTP protocol
  handler can be registered by doing a
  CookieHandler.setDefault(CookieHandler). The currently registered
  CookieHandler can be retrieved by calling
  CookieHandler.getDefault().

  For more information on HTTP state management, see RFC 2965: HTTP
  State Management Mechanism"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net CookieHandler]))

(defn ->cookie-handler
  "Constructor."
  (^CookieHandler []
    (new CookieHandler )))

(defn *get-default
  "Gets the system-wide cookie handler.

  returns: the system-wide cookie handler; A null return means
          there is no system-wide cookie handler currently set. - `java.net.CookieHandler`

  throws: java.lang.SecurityException - If a security manager has been installed and it denies NetPermission(`getCookieHandler`)"
  (^java.net.CookieHandler []
    (CookieHandler/getDefault )))

(defn *set-default
  "Sets (or unsets) the system-wide cookie handler.

   Note: non-standard http protocol handlers may ignore this setting.

  c-handler - The HTTP cookie handler, or null to unset. - `java.net.CookieHandler`

  throws: java.lang.SecurityException - If a security manager has been installed and it denies NetPermission(`setCookieHandler`)"
  ([^java.net.CookieHandler c-handler]
    (CookieHandler/setDefault c-handler)))

(defn get
  "Gets all the applicable cookies from a cookie cache for the
   specified uri in the request header.

   The URI passed as an argument specifies the intended use for
   the cookies. In particular the scheme should reflect whether the cookies
   will be sent over http, https or used in another context like javascript.
   The host part should reflect either the destination of the cookies or
   their origin in the case of javascript.
   It is up to the implementation to take into account the URI and
   the cookies attributes and security settings to determine which ones
   should be returned.

   HTTP protocol implementers should make sure that this method is
   called after all request headers related to choosing cookies
   are added, and before the request is sent.

  uri - a URI representing the intended use for the cookies - `java.net.URI`
  request-headers - - a Map from request header field names to lists of field values representing the current request headers - `java.util.Map`

  returns: an immutable map from state management headers, with
              field names `Cookie` or `Cookie2` to a list of
              cookies containing state information - `java.util.Map<java.lang.String,java.util.List<java.lang.String>>`

  throws: java.io.IOException - if an I/O error occurs"
  (^java.util.Map [^CookieHandler this ^java.net.URI uri ^java.util.Map request-headers]
    (-> this (.get uri request-headers))))

(defn put
  "Sets all the applicable cookies, examples are response header
   fields that are named Set-Cookie2, present in the response
   headers into a cookie cache.

  uri - a URI where the cookies come from - `java.net.URI`
  response-headers - an immutable map from field names to lists of field values representing the response header fields returned - `java.util.Map`

  throws: java.io.IOException - if an I/O error occurs"
  ([^CookieHandler this ^java.net.URI uri ^java.util.Map response-headers]
    (-> this (.put uri response-headers))))

