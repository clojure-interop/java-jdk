(ns jdk.net.HttpURLConnection
  "A URLConnection with support for HTTP-specific features. See
   the spec  for
  details.


  Each HttpURLConnection instance is used to make a single request
  but the underlying network connection to the HTTP server may be
  transparently shared by other instances. Calling the close() methods
  on the InputStream or OutputStream of an HttpURLConnection
  after a request may free network resources associated with this
  instance but has no effect on any shared persistent connection.
  Calling the disconnect() method may close the underlying socket
  if a persistent connection is otherwise idle at that time.

  The HTTP protocol handler has a few settings that can be accessed through
  System Properties. This covers
  Proxy settings as well as
   various other settings.


  Security permissions

  If a security manager is installed, and if a method is called which results in an
  attempt to open a connection, the caller must possess either:-
  a `connect` SocketPermission to the host/port combination of the
  destination URL or
  a URLPermission that permits this request.

  If automatic redirection is enabled, and this request is redirected to another
  destination, then the caller must also have permission to connect to the
  redirected host/URL."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net HttpURLConnection]))

(def *-http-ok
  "Static Constant.

  HTTP Status-Code 200: OK.

  type: int"
  HttpURLConnection/HTTP_OK)

(def *-http-created
  "Static Constant.

  HTTP Status-Code 201: Created.

  type: int"
  HttpURLConnection/HTTP_CREATED)

(def *-http-accepted
  "Static Constant.

  HTTP Status-Code 202: Accepted.

  type: int"
  HttpURLConnection/HTTP_ACCEPTED)

(def *-http-not-authoritative
  "Static Constant.

  HTTP Status-Code 203: Non-Authoritative Information.

  type: int"
  HttpURLConnection/HTTP_NOT_AUTHORITATIVE)

(def *-http-no-content
  "Static Constant.

  HTTP Status-Code 204: No Content.

  type: int"
  HttpURLConnection/HTTP_NO_CONTENT)

(def *-http-reset
  "Static Constant.

  HTTP Status-Code 205: Reset Content.

  type: int"
  HttpURLConnection/HTTP_RESET)

(def *-http-partial
  "Static Constant.

  HTTP Status-Code 206: Partial Content.

  type: int"
  HttpURLConnection/HTTP_PARTIAL)

(def *-http-mult-choice
  "Static Constant.

  HTTP Status-Code 300: Multiple Choices.

  type: int"
  HttpURLConnection/HTTP_MULT_CHOICE)

(def *-http-moved-perm
  "Static Constant.

  HTTP Status-Code 301: Moved Permanently.

  type: int"
  HttpURLConnection/HTTP_MOVED_PERM)

(def *-http-moved-temp
  "Static Constant.

  HTTP Status-Code 302: Temporary Redirect.

  type: int"
  HttpURLConnection/HTTP_MOVED_TEMP)

(def *-http-see-other
  "Static Constant.

  HTTP Status-Code 303: See Other.

  type: int"
  HttpURLConnection/HTTP_SEE_OTHER)

(def *-http-not-modified
  "Static Constant.

  HTTP Status-Code 304: Not Modified.

  type: int"
  HttpURLConnection/HTTP_NOT_MODIFIED)

(def *-http-use-proxy
  "Static Constant.

  HTTP Status-Code 305: Use Proxy.

  type: int"
  HttpURLConnection/HTTP_USE_PROXY)

(def *-http-bad-request
  "Static Constant.

  HTTP Status-Code 400: Bad Request.

  type: int"
  HttpURLConnection/HTTP_BAD_REQUEST)

(def *-http-unauthorized
  "Static Constant.

  HTTP Status-Code 401: Unauthorized.

  type: int"
  HttpURLConnection/HTTP_UNAUTHORIZED)

(def *-http-payment-required
  "Static Constant.

  HTTP Status-Code 402: Payment Required.

  type: int"
  HttpURLConnection/HTTP_PAYMENT_REQUIRED)

(def *-http-forbidden
  "Static Constant.

  HTTP Status-Code 403: Forbidden.

  type: int"
  HttpURLConnection/HTTP_FORBIDDEN)

(def *-http-not-found
  "Static Constant.

  HTTP Status-Code 404: Not Found.

  type: int"
  HttpURLConnection/HTTP_NOT_FOUND)

(def *-http-bad-method
  "Static Constant.

  HTTP Status-Code 405: Method Not Allowed.

  type: int"
  HttpURLConnection/HTTP_BAD_METHOD)

(def *-http-not-acceptable
  "Static Constant.

  HTTP Status-Code 406: Not Acceptable.

  type: int"
  HttpURLConnection/HTTP_NOT_ACCEPTABLE)

(def *-http-proxy-auth
  "Static Constant.

  HTTP Status-Code 407: Proxy Authentication Required.

  type: int"
  HttpURLConnection/HTTP_PROXY_AUTH)

(def *-http-client-timeout
  "Static Constant.

  HTTP Status-Code 408: Request Time-Out.

  type: int"
  HttpURLConnection/HTTP_CLIENT_TIMEOUT)

(def *-http-conflict
  "Static Constant.

  HTTP Status-Code 409: Conflict.

  type: int"
  HttpURLConnection/HTTP_CONFLICT)

(def *-http-gone
  "Static Constant.

  HTTP Status-Code 410: Gone.

  type: int"
  HttpURLConnection/HTTP_GONE)

(def *-http-length-required
  "Static Constant.

  HTTP Status-Code 411: Length Required.

  type: int"
  HttpURLConnection/HTTP_LENGTH_REQUIRED)

(def *-http-precon-failed
  "Static Constant.

  HTTP Status-Code 412: Precondition Failed.

  type: int"
  HttpURLConnection/HTTP_PRECON_FAILED)

(def *-http-entity-too-large
  "Static Constant.

  HTTP Status-Code 413: Request Entity Too Large.

  type: int"
  HttpURLConnection/HTTP_ENTITY_TOO_LARGE)

(def *-http-req-too-long
  "Static Constant.

  HTTP Status-Code 414: Request-URI Too Large.

  type: int"
  HttpURLConnection/HTTP_REQ_TOO_LONG)

(def *-http-unsupported-type
  "Static Constant.

  HTTP Status-Code 415: Unsupported Media Type.

  type: int"
  HttpURLConnection/HTTP_UNSUPPORTED_TYPE)

(def *-http-server-error
  "Static Constant.

  Deprecated. it is misplaced and shouldn't have existed.

  type: int"
  HttpURLConnection/HTTP_SERVER_ERROR)

(def *-http-internal-error
  "Static Constant.

  HTTP Status-Code 500: Internal Server Error.

  type: int"
  HttpURLConnection/HTTP_INTERNAL_ERROR)

(def *-http-not-implemented
  "Static Constant.

  HTTP Status-Code 501: Not Implemented.

  type: int"
  HttpURLConnection/HTTP_NOT_IMPLEMENTED)

(def *-http-bad-gateway
  "Static Constant.

  HTTP Status-Code 502: Bad Gateway.

  type: int"
  HttpURLConnection/HTTP_BAD_GATEWAY)

(def *-http-unavailable
  "Static Constant.

  HTTP Status-Code 503: Service Unavailable.

  type: int"
  HttpURLConnection/HTTP_UNAVAILABLE)

(def *-http-gateway-timeout
  "Static Constant.

  HTTP Status-Code 504: Gateway Timeout.

  type: int"
  HttpURLConnection/HTTP_GATEWAY_TIMEOUT)

(def *-http-version
  "Static Constant.

  HTTP Status-Code 505: HTTP Version Not Supported.

  type: int"
  HttpURLConnection/HTTP_VERSION)

(defn *set-follow-redirects
  "Sets whether HTTP redirects  (requests with response code 3xx) should
   be automatically followed by this class.  True by default.  Applets
   cannot change this variable.

   If there is a security manager, this method first calls
   the security manager's checkSetFactory method
   to ensure the operation is allowed.
   This could result in a SecurityException.

  set - a boolean indicating whether or not to follow HTTP redirects. - `boolean`

  throws: java.lang.SecurityException - if a security manager exists and its checkSetFactory method doesn't allow the operation."
  ([^Boolean set]
    (HttpURLConnection/setFollowRedirects set)))

(defn *get-follow-redirects?
  "Returns a boolean indicating
   whether or not HTTP redirects (3xx) should
   be automatically followed.

  returns: true if HTTP redirects should
   be automatically followed, false if not. - `boolean`"
  (^Boolean []
    (HttpURLConnection/getFollowRedirects )))

(defn get-header-field
  "Returns the value for the nth header field.
   Some implementations may treat the 0th
   header field as special, i.e. as the status line returned by the HTTP
   server.

   This method can be used in conjunction with the
   getHeaderFieldKey method to iterate through all
   the headers in the message.

  n - an index, where n>=0. - `int`

  returns: the value of the nth header field,
            or null if the value does not exist. - `java.lang.String`"
  (^java.lang.String [^HttpURLConnection this ^Integer n]
    (-> this (.getHeaderField n))))

(defn using-proxy
  "Indicates if the connection is going through a proxy.

  returns: a boolean indicating if the connection is
   using a proxy. - `boolean`"
  (^Boolean [^HttpURLConnection this]
    (-> this (.usingProxy))))

(defn get-header-field-key
  "Returns the key for the nth header field.
   Some implementations may treat the 0th
   header field as special, i.e. as the status line returned by the HTTP
   server. In this case, getHeaderField(0) returns the status
   line, but getHeaderFieldKey(0) returns null.

  n - an index, where n >=0. - `int`

  returns: the key for the nth header field,
            or null if the key does not exist. - `java.lang.String`"
  (^java.lang.String [^HttpURLConnection this ^Integer n]
    (-> this (.getHeaderFieldKey n))))

(defn disconnect
  "Indicates that other requests to the server
   are unlikely in the near future. Calling disconnect()
   should not imply that this HttpURLConnection
   instance can be reused for other requests."
  ([^HttpURLConnection this]
    (-> this (.disconnect))))

(defn get-response-code
  "Gets the status code from an HTTP response message.
   For example, in the case of the following status lines:


   HTTP/1.0 200 OK
   HTTP/1.0 401 Unauthorized
   It will return 200 and 401 respectively.
   Returns -1 if no code can be discerned
   from the response (i.e., the response is not valid HTTP).

  returns: the HTTP Status-Code, or -1 - `int`

  throws: java.io.IOException - if an error occurred connecting to the server."
  (^Integer [^HttpURLConnection this]
    (-> this (.getResponseCode))))

(defn set-fixed-length-streaming-mode
  "This method is used to enable streaming of a HTTP request body
   without internal buffering, when the content length is known in
   advance.

   An exception will be thrown if the application
   attempts to write more data than the indicated
   content-length, or if the application closes the OutputStream
   before writing the indicated amount.

   When output streaming is enabled, authentication
   and redirection cannot be handled automatically.
   A HttpRetryException will be thrown when reading
   the response if authentication or redirection are required.
   This exception can be queried for the details of the error.

   This method must be called before the URLConnection is connected.

   NOTE: setFixedLengthStreamingMode(long) is recommended
   instead of this method as it allows larger content lengths to be set.

  content-length - The number of bytes which will be written to the OutputStream. - `int`

  throws: java.lang.IllegalStateException - if URLConnection is already connected or if a different streaming mode is already enabled."
  ([^HttpURLConnection this ^Integer content-length]
    (-> this (.setFixedLengthStreamingMode content-length))))

(defn get-header-field-date
  "Description copied from class: URLConnection

  name - the name of the header field. - `java.lang.String`
  default - a default value. - `long`

  returns: the value of the field, parsed as a date. The value of the
            Default argument is returned if the field is
            missing or malformed. - `long`"
  (^Long [^HttpURLConnection this ^java.lang.String name ^Long default]
    (-> this (.getHeaderFieldDate name default))))

(defn set-instance-follow-redirects
  "Sets whether HTTP redirects (requests with response code 3xx) should
   be automatically followed by this HttpURLConnection
   instance.

   The default value comes from followRedirects, which defaults to
   true.

  follow-redirects - a boolean indicating whether or not to follow HTTP redirects. - `boolean`"
  ([^HttpURLConnection this ^Boolean follow-redirects]
    (-> this (.setInstanceFollowRedirects follow-redirects))))

(defn set-chunked-streaming-mode
  "This method is used to enable streaming of a HTTP request body
   without internal buffering, when the content length is not
   known in advance. In this mode, chunked transfer encoding
   is used to send the request body. Note, not all HTTP servers
   support this mode.

   When output streaming is enabled, authentication
   and redirection cannot be handled automatically.
   A HttpRetryException will be thrown when reading
   the response if authentication or redirection are required.
   This exception can be queried for the details of the error.

   This method must be called before the URLConnection is connected.

  chunklen - The number of bytes to write in each chunk. If chunklen is less than or equal to zero, a default value will be used. - `int`

  throws: java.lang.IllegalStateException - if URLConnection is already connected or if a different streaming mode is already enabled."
  ([^HttpURLConnection this ^Integer chunklen]
    (-> this (.setChunkedStreamingMode chunklen))))

(defn get-error-stream
  "Returns the error stream if the connection failed
   but the server sent useful data nonetheless. The
   typical example is when an HTTP server responds
   with a 404, which will cause a FileNotFoundException
   to be thrown in connect, but the server sent an HTML
   help page with suggestions as to what to do.

   This method will not cause a connection to be initiated.  If
   the connection was not connected, or if the server did not have
   an error while connecting or if the server had an error but
   no error data was sent, this method will return null. This is
   the default.

  returns: an error stream if any, null if there have been no
   errors, the connection is not connected or the server sent no
   useful data. - `java.io.InputStream`"
  (^java.io.InputStream [^HttpURLConnection this]
    (-> this (.getErrorStream))))

(defn set-request-method
  "Set the method for the URL request, one of:

    GET
    POST
    HEAD
    OPTIONS
    PUT
    DELETE
    TRACE
    are legal, subject to protocol restrictions.  The default
   method is GET.

  method - the HTTP method - `java.lang.String`

  throws: java.net.ProtocolException - if the method cannot be reset or if the requested method isn't valid for HTTP."
  ([^HttpURLConnection this ^java.lang.String method]
    (-> this (.setRequestMethod method))))

(defn get-request-method
  "Get the request method.

  returns: the HTTP request method - `java.lang.String`"
  (^java.lang.String [^HttpURLConnection this]
    (-> this (.getRequestMethod))))

(defn get-permission
  "Returns a SocketPermission object representing the
   permission necessary to connect to the destination host and port.

  returns: a SocketPermission object representing the
           permission necessary to connect to the destination
           host and port. - `java.security.Permission`

  throws: java.io.IOException - if an error occurs while computing the permission."
  (^java.security.Permission [^HttpURLConnection this]
    (-> this (.getPermission))))

(defn get-instance-follow-redirects?
  "Returns the value of this HttpURLConnection's
   instanceFollowRedirects field.

  returns: the value of this HttpURLConnection's
            instanceFollowRedirects field. - `boolean`"
  (^Boolean [^HttpURLConnection this]
    (-> this (.getInstanceFollowRedirects))))

(defn get-response-message
  "Gets the HTTP response message, if any, returned along with the
   response code from a server.  From responses like:


   HTTP/1.0 200 OK
   HTTP/1.0 404 Not Found
   Extracts the Strings `OK` and `Not Found` respectively.
   Returns null if none could be discerned from the responses
   (the result was not valid HTTP).

  returns: the HTTP response message, or null - `java.lang.String`

  throws: java.io.IOException - if an error occurred connecting to the server."
  (^java.lang.String [^HttpURLConnection this]
    (-> this (.getResponseMessage))))

