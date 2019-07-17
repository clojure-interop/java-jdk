(ns javax.xml.ws.spi.http.HttpExchange
  "This class encapsulates a HTTP request received and a
  response to be generated in one exchange. It provides methods
  for examining the request from the client, and for building and
  sending the response.

  A HttpExchange must be closed to free or reuse
  underlying resources. The effect of failing to close an exchange
  is undefined."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws.spi.http HttpExchange]))

(defn ->http-exchange
  "Constructor."
  ([]
    (new HttpExchange )))

(def *-request-cipher-suite
  "Static Constant.

  Standard property: cipher suite value when the request is received
   over HTTPS
   Type: String

  type: java.lang.String"
  HttpExchange/REQUEST_CIPHER_SUITE)

(def *-request-key-size
  "Static Constant.

  Standard property: bit size of the algorithm when the request is
   received over HTTPS
   Type: Integer

  type: java.lang.String"
  HttpExchange/REQUEST_KEY_SIZE)

(def *-request-x-509-certificate
  "Static Constant.

  Standard property: A SSL certificate, if any, associated with the request

   Type: java.security.cert.X509Certificate[]
   The order of this array is defined as being in ascending order of trust.
   The first certificate in the chain is the one set by the client, the next
   is the one used to authenticate the first, and so on.

  type: java.lang.String"
  HttpExchange/REQUEST_X509CERTIFICATE)

(defn get-path-info
  "Returns the extra path information that follows the web service
   path but precedes the query string in the request URI and will start
   with a `/` character.


   This can be used for MessageContext.PATH_INFO

  returns: decoded extra path information of web service.
           It is the path that comes
           after the web service path but before the query string in the
           request URI
           null if there is no extra path in the request URI - `java.lang.String`"
  (^java.lang.String [^javax.xml.ws.spi.http.HttpExchange this]
    (-> this (.getPathInfo))))

(defn get-request-header
  "Returns the value of the specified request header. If the request
   did not include a header of the specified name, this method returns
   null. If there are multiple headers with the same name, this method
   returns the first header in the request. The header name is
   case-insensitive. This is a convienence method to get a header
   (instead of using the getRequestHeaders()).

  name - the name of the request header - `java.lang.String`

  returns: returns the value of the requested header,
           or null if the request does not have a header of that name - `java.lang.String`"
  (^java.lang.String [^javax.xml.ws.spi.http.HttpExchange this ^java.lang.String name]
    (-> this (.getRequestHeader name))))

(defn get-remote-address
  "Returns the unresolved address of the remote entity invoking
   this request.

  returns: the InetSocketAddress of the caller - `java.net.InetSocketAddress`"
  (^java.net.InetSocketAddress [^javax.xml.ws.spi.http.HttpExchange this]
    (-> this (.getRemoteAddress))))

(defn add-response-header
  "Adds a response header with the given name and value. This method
   allows a response header to have multiple values. This is a
   convenience method to add a response header(instead of using the
   getResponseHeaders()).

  name - the name of the header - `java.lang.String`
  value - the additional header value. If it contains octet string, it should be encoded according to RFC 2047 (http://www.ietf.org/rfc/rfc2047.txt) - `java.lang.String`"
  ([^javax.xml.ws.spi.http.HttpExchange this ^java.lang.String name ^java.lang.String value]
    (-> this (.addResponseHeader name value))))

(defn get-attribute
  "Returns an attribute that is associated with this
   HttpExchange. JAX-WS handlers and endpoints may then
   access the attribute via MessageContext.

   Servlet containers must expose MessageContext.SERVLET_CONTEXT,
   MessageContext.SERVLET_REQUEST, and
   MessageContext.SERVLET_RESPONSE
   as attributes.

   If the request has been received by the container using HTTPS, the
   following information must be exposed as attributes. These attributes
   are REQUEST_CIPHER_SUITE, and REQUEST_KEY_SIZE.
   If there is a SSL certificate associated with the request, it must
   be exposed using REQUEST_X509CERTIFICATE

  name - attribute name - `java.lang.String`

  returns: the attribute value, or null if the attribute doesn't
           exist - `java.lang.Object`"
  (^java.lang.Object [^javax.xml.ws.spi.http.HttpExchange this ^java.lang.String name]
    (-> this (.getAttribute name))))

(defn get-context-path
  "Returns the context path of all the endpoints in an application.
   This path is the portion of the request URI that indicates the
   context of the request. The context path always comes first in a
   request URI. The path starts with a `/` character but does not
   end with a `/` character. If this method returns ``, the request
   is for default context. The container does not decode this string.


   Context path is used in computing the endpoint address. See
   HttpContext.getPath()

  returns: context path of all the endpoints in an application - `java.lang.String`"
  (^java.lang.String [^javax.xml.ws.spi.http.HttpExchange this]
    (-> this (.getContextPath))))

(defn user-in-role?
  "Indicates whether an authenticated user is included in the specified
   logical `role`.

  role - specifies the name of the role - `java.lang.String`

  returns: true if the user making this request belongs to a
           given role - `boolean`"
  (^Boolean [^javax.xml.ws.spi.http.HttpExchange this ^java.lang.String role]
    (-> this (.isUserInRole role))))

(defn get-request-body
  "Returns a stream from which the request body can be read.
   Multiple calls to this method will return the same stream.

  returns: the stream from which the request body can be read. - `java.io.InputStream`

  throws: java.io.IOException - if any i/o error during request processing"
  (^java.io.InputStream [^javax.xml.ws.spi.http.HttpExchange this]
    (-> this (.getRequestBody))))

(defn get-scheme
  "Returns the name of the scheme used to make this request,
   for example: http, or https.

  returns: name of the scheme used to make this request - `java.lang.String`"
  (^java.lang.String [^javax.xml.ws.spi.http.HttpExchange this]
    (-> this (.getScheme))))

(defn get-query-string
  "Returns the query string that is contained in the request URI
   after the path.


   This can be used for MessageContext.QUERY_STRING

  returns: undecoded query string of request URI, or
           null if the request URI doesn't have one - `java.lang.String`"
  (^java.lang.String [^javax.xml.ws.spi.http.HttpExchange this]
    (-> this (.getQueryString))))

(defn get-local-address
  "Returns the unresolved local address on which the request was received.

  returns: the InetSocketAddress of the local interface - `java.net.InetSocketAddress`"
  (^java.net.InetSocketAddress [^javax.xml.ws.spi.http.HttpExchange this]
    (-> this (.getLocalAddress))))

(defn get-response-headers
  "Returns a mutable Map into which the HTTP response headers can be stored
   and which will be transmitted as part of this response. The keys in the
   Map will be the header names, while the values must be a List of Strings
   containing each value that should be included multiple times
   (in the order that they should be included).

   The keys in Map are case-insensitive.

  returns: a mutable Map which can be used to set response headers. - `java.util.Map<java.lang.String,java.util.List<java.lang.String>>`"
  (^java.util.Map> [^javax.xml.ws.spi.http.HttpExchange this]
    (-> this (.getResponseHeaders))))

(defn get-request-uri
  "Returns the part of the request's URI from the protocol
   name up to the query string in the first line of the HTTP request.
   Container doesn't decode this string.

  returns: the request URI - `java.lang.String`"
  (^java.lang.String [^javax.xml.ws.spi.http.HttpExchange this]
    (-> this (.getRequestURI))))

(defn close
  "This must be called to end an exchange. Container takes care of
   closing request and response streams. This must be called so that
   the container can free or reuse underlying resources.

  throws: java.io.IOException - if any i/o error"
  ([^javax.xml.ws.spi.http.HttpExchange this]
    (-> this (.close))))

(defn get-request-headers
  "Returns an immutable Map containing the HTTP headers that were
   included with this request. The keys in this Map will be the header
   names, while the values will be a List of Strings containing each value
   that was included (either for a header that was listed several times,
   or one that accepts a comma-delimited list of values on a single line).
   In either of these cases, the values for the header name will be
   presented in the order that they were included in the request.

   The keys in Map are case-insensitive.

  returns: an immutable Map which can be used to access request headers - `java.util.Map<java.lang.String,java.util.List<java.lang.String>>`"
  (^java.util.Map> [^javax.xml.ws.spi.http.HttpExchange this]
    (-> this (.getRequestHeaders))))

(defn get-user-principal
  "Returns the Principal that represents the authenticated
   user for this HttpExchange.

  returns: Principal for an authenticated user, or
           null if not authenticated - `java.security.Principal`"
  (^java.security.Principal [^javax.xml.ws.spi.http.HttpExchange this]
    (-> this (.getUserPrincipal))))

(defn get-http-context
  "Returns a HttpContext for this exchange.
   Container matches the request with the associated Endpoint's HttpContext

  returns: the HttpContext for this exchange - `javax.xml.ws.spi.http.HttpContext`"
  (^javax.xml.ws.spi.http.HttpContext [^javax.xml.ws.spi.http.HttpExchange this]
    (-> this (.getHttpContext))))

(defn get-protocol
  "Returns the protocol string from the request in the form
   protocol/majorVersion.minorVersion. For example,
   `HTTP/1.1`

  returns: the protocol string from the request - `java.lang.String`"
  (^java.lang.String [^javax.xml.ws.spi.http.HttpExchange this]
    (-> this (.getProtocol))))

(defn get-request-method
  "Get the HTTP request method

  returns: the request method - `java.lang.String`"
  (^java.lang.String [^javax.xml.ws.spi.http.HttpExchange this]
    (-> this (.getRequestMethod))))

(defn get-response-body
  "Returns a stream to which the response body must be
   written. setStatus(int)) must be called prior to calling
   this method. Multiple calls to this method (for the same exchange)
   will return the same stream.

  returns: the stream to which the response body is written - `java.io.OutputStream`

  throws: java.io.IOException - if any i/o error during response processing"
  (^java.io.OutputStream [^javax.xml.ws.spi.http.HttpExchange this]
    (-> this (.getResponseBody))))

(defn get-attribute-names
  "Gives all the attribute names that are associated with
   this HttpExchange.

  returns: set of all attribute names - `java.util.Set<java.lang.String>`"
  (^java.util.Set [^javax.xml.ws.spi.http.HttpExchange this]
    (-> this (.getAttributeNames))))

(defn set-status
  "Sets the HTTP status code for the response.


   This method must be called prior to calling getResponseBody().

  status - the response code to send - `int`"
  ([^javax.xml.ws.spi.http.HttpExchange this ^Integer status]
    (-> this (.setStatus status))))

