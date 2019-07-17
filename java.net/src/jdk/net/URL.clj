(ns jdk.net.URL
  "Class URL represents a Uniform Resource
  Locator, a pointer to a `resource` on the World
  Wide Web. A resource can be something as simple as a file or a
  directory, or it can be a reference to a more complicated object,
  such as a query to a database or to a search engine. More
  information on the types of URLs and their formats can be found at:

  Types of URL

  In general, a URL can be broken into several parts. Consider the
  following example:


      http://www.example.com/docs/resource1.html

  The URL above indicates that the protocol to use is
  http (HyperText Transfer Protocol) and that the
  information resides on a host machine named
  www.example.com. The information on that host
  machine is named /docs/resource1.html. The exact
  meaning of this name on the host machine is both protocol
  dependent and host dependent. The information normally resides in
  a file, but it could be generated on the fly. This component of
  the URL is called the path component.

  A URL can optionally specify a `port`, which is the
  port number to which the TCP connection is made on the remote host
  machine. If the port is not specified, the default port for
  the protocol is used instead. For example, the default port for
  http is 80. An alternative port could be
  specified as:


      http://www.example.com:1080/docs/resource1.html

  The syntax of URL is defined by  RFC 2396: Uniform
  Resource Identifiers (URI): Generic Syntax, amended by RFC 2732: Format for
  Literal IPv6 Addresses in URLs. The Literal IPv6 address format
  also supports scope_ids. The syntax and usage of scope_ids is described
  here.

  A URL may have appended to it a `fragment`, also known
  as a `ref` or a `reference`. The fragment is indicated by the sharp
  sign character `#` followed by more characters. For example,


      http://java.sun.com/index.html#chapter1

  This fragment is not technically part of the URL. Rather, it
  indicates that after the specified resource is retrieved, the
  application is specifically interested in that part of the
  document that has the tag chapter1 attached to it. The
  meaning of a tag is resource specific.

  An application can also specify a `relative URL`,
  which contains only enough information to reach the resource
  relative to another URL. Relative URLs are frequently used within
  HTML pages. For example, if the contents of the URL:


      http://java.sun.com/index.html
  contained within it the relative URL:


      FAQ.html
  it would be a shorthand for:


      http://java.sun.com/FAQ.html

  The relative URL need not specify all the components of a URL. If
  the protocol, host name, or port number is missing, the value is
  inherited from the fully specified URL. The file component must be
  specified. The optional fragment is not inherited.

  The URL class does not itself encode or decode any URL components
  according to the escaping mechanism defined in RFC2396. It is the
  responsibility of the caller to encode any fields, which need to be
  escaped prior to calling URL, and also to decode any escaped fields,
  that are returned from URL. Furthermore, because URL has no knowledge
  of URL escaping, it does not recognise equivalence between the encoded
  or decoded form of the same URL. For example, the two URLs:


     http://foo.com/hello world/ and http://foo.com/hello%20world
  would be considered not equal to each other.

  Note, the URI class does perform escaping of its
  component fields in certain circumstances. The recommended way
  to manage the encoding and decoding of URLs is to use URI,
  and to convert between these two classes using toURI() and
  URI.toURL().

  The URLEncoder and URLDecoder classes can also be
  used, but only for HTML form encoding, which is not the same
  as the encoding scheme defined in RFC2396."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net URL]))

(defn ->url
  "Constructor.

  Creates a URL object from the specified
   protocol, host, port
   number, file, and handler. Specifying
   a port number of -1 indicates that
   the URL should use the default port for the protocol. Specifying
   a handler of null indicates that the URL
   should use a default stream handler for the protocol, as outlined
   for:
       java.net.URL#URL(java.lang.String, java.lang.String, int,
                        java.lang.String)

   If the handler is not null and there is a security manager,
   the security manager's checkPermission
   method is called with a
   NetPermission(`specifyStreamHandler`) permission.
   This may result in a SecurityException.

   No validation of the inputs is performed by this constructor.

  protocol - the name of the protocol to use. - `java.lang.String`
  host - the name of the host. - `java.lang.String`
  port - the port number on the host. - `int`
  file - the file on the host - `java.lang.String`
  handler - the stream handler for the URL. - `java.net.URLStreamHandler`

  throws: java.net.MalformedURLException - if an unknown protocol is specified."
  ([protocol host port file handler]
    (new URL protocol host port file handler))
  ([protocol host port file]
    (new URL protocol host port file))
  ([protocol host file]
    (new URL protocol host file))
  ([context spec]
    (new URL context spec))
  ([spec]
    (new URL spec)))

(defn *set-url-stream-handler-factory
  "Sets an application's URLStreamHandlerFactory.
   This method can be called at most once in a given Java Virtual
   Machine.

   The URLStreamHandlerFactory instance is used to
  construct a stream protocol handler from a protocol name.

    If there is a security manager, this method first calls
   the security manager's checkSetFactory method
   to ensure the operation is allowed.
   This could result in a SecurityException.

  fac - the desired factory. - `java.net.URLStreamHandlerFactory`

  throws: java.lang.Error - if the application has already set a factory."
  ([fac]
    (URL/setURLStreamHandlerFactory fac)))

(defn get-default-port
  "Gets the default port number of the protocol associated
   with this URL. If the URL scheme or the URLStreamHandler
   for the URL do not define a default port number,
   then -1 is returned.

  returns: the port number - `int`"
  ([this]
    (-> this (.getDefaultPort))))

(defn get-authority
  "Gets the authority part of this URL.

  returns: the authority part of this URL - `java.lang.String`"
  ([this]
    (-> this (.getAuthority))))

(defn get-ref
  "Gets the anchor (also known as the `reference`) of this
   URL.

  returns: the anchor (also known as the `reference`) of this
            URL, or null if one does not exist - `java.lang.String`"
  ([this]
    (-> this (.getRef))))

(defn open-stream
  "Opens a connection to this URL and returns an
   InputStream for reading from that connection. This
   method is a shorthand for:


       openConnection().getInputStream()

  returns: an input stream for reading from the URL connection. - `java.io.InputStream`

  throws: java.io.IOException - if an I/O exception occurs."
  ([this]
    (-> this (.openStream))))

(defn to-uri
  "Returns a URI equivalent to this URL.
   This method functions in the same way as new URI (this.toString()).
   Note, any URL instance that complies with RFC 2396 can be converted
   to a URI. However, some URLs that are not strictly in compliance
   can not be converted to a URI.

  returns: a URI instance equivalent to this URL. - `java.net.URI`

  throws: java.net.URISyntaxException - if this URL is not formatted strictly according to to RFC2396 and cannot be converted to a URI."
  ([this]
    (-> this (.toURI))))

(defn to-string
  "Constructs a string representation of this URL. The
   string is created by calling the toExternalForm
   method of the stream protocol handler for this object.

  returns: a string representation of this object. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn get-user-info
  "Gets the userInfo part of this URL.

  returns: the userInfo part of this URL, or
   null if one does not exist - `java.lang.String`"
  ([this]
    (-> this (.getUserInfo))))

(defn open-connection
  "Same as openConnection(), except that the connection will be
   made through the specified proxy; Protocol handlers that do not
   support proxing will ignore the proxy parameter and make a
   normal connection.

   Invoking this method preempts the system's default ProxySelector
   settings.

  proxy - the Proxy through which this connection will be made. If direct connection is desired, Proxy.NO_PROXY should be specified. - `java.net.Proxy`

  returns: a URLConnection to the URL. - `java.net.URLConnection`

  throws: java.io.IOException - if an I/O exception occurs."
  ([this proxy]
    (-> this (.openConnection proxy)))
  ([this]
    (-> this (.openConnection))))

(defn get-path
  "Gets the path part of this URL.

  returns: the path part of this URL, or an
   empty string if one does not exist - `java.lang.String`"
  ([this]
    (-> this (.getPath))))

(defn to-external-form
  "Constructs a string representation of this URL. The
   string is created by calling the toExternalForm
   method of the stream protocol handler for this object.

  returns: a string representation of this object. - `java.lang.String`"
  ([this]
    (-> this (.toExternalForm))))

(defn get-query
  "Gets the query part of this URL.

  returns: the query part of this URL,
   or null if one does not exist - `java.lang.String`"
  ([this]
    (-> this (.getQuery))))

(defn get-port
  "Gets the port number of this URL.

  returns: the port number, or -1 if the port is not set - `int`"
  ([this]
    (-> this (.getPort))))

(defn get-protocol
  "Gets the protocol name of this URL.

  returns: the protocol of this URL. - `java.lang.String`"
  ([this]
    (-> this (.getProtocol))))

(defn hash-code
  "Creates an integer suitable for hash table indexing.

   The hash code is based upon all the URL components relevant for URL
   comparison. As such, this operation is a blocking operation.

  returns: a hash code for this URL. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn get-file
  "Gets the file name of this URL.
   The returned file portion will be
   the same as getPath(), plus the concatenation of
   the value of getQuery(), if any. If there is
   no query portion, this method and getPath() will
   return identical results.

  returns: the file name of this URL,
   or an empty string if one does not exist - `java.lang.String`"
  ([this]
    (-> this (.getFile))))

(defn get-host
  "Gets the host name of this URL, if applicable.
   The format of the host conforms to RFC 2732, i.e. for a
   literal IPv6 address, this method will return the IPv6 address
   enclosed in square brackets ('[' and ']').

  returns: the host name of this URL. - `java.lang.String`"
  ([this]
    (-> this (.getHost))))

(defn equals
  "Compares this URL for equality with another object.

   If the given object is not a URL then this method immediately returns
   false.

   Two URL objects are equal if they have the same protocol, reference
   equivalent hosts, have the same port number on the host, and the same
   file and fragment of the file.

   Two hosts are considered equivalent if both host names can be resolved
   into the same IP addresses; else if either host name can't be
   resolved, the host names must be equal without regard to case; or both
   host names equal to null.

   Since hosts comparison requires name resolution, this operation is a
   blocking operation.

   Note: The defined behavior for equals is known to
   be inconsistent with virtual hosting in HTTP.

  obj - the URL to compare against. - `java.lang.Object`

  returns: true if the objects are the same;
            false otherwise. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn same-file
  "Compares two URLs, excluding the fragment component.

   Returns true if this URL and the
   other argument are equal without taking the
   fragment component into consideration.

  other - the URL to compare against. - `java.net.URL`

  returns: true if they reference the same remote object;
            false otherwise. - `boolean`"
  ([this other]
    (-> this (.sameFile other))))

(defn get-content
  "Gets the contents of this URL. This method is a shorthand for:


       openConnection().getContent(Class[])

  classes - an array of Java types - `java.lang.Class[]`

  returns: the content object of this URL that is the first match of
                 the types specified in the classes array.
                 null if none of the requested types are supported. - `java.lang.Object`

  throws: java.io.IOException - if an I/O exception occurs."
  ([this classes]
    (-> this (.getContent classes)))
  ([this]
    (-> this (.getContent))))

