(ns javax.management.remote.JMXServiceURL
  "The address of a JMX API connector server.  Instances of this class
  are immutable.

  The address is an Abstract Service URL for SLP, as
  defined in RFC 2609 and amended by RFC 3111.  It must look like
  this:



  service:jmx:protocol:sap



  Here, protocol is the transport
  protocol to be used to connect to the connector server.  It is
  a string of one or more ASCII characters, each of which is a
  letter, a digit, or one of the characters + or
  -.  The first character must be a letter.
  Uppercase letters are converted into lowercase ones.

  sap is the address at which the connector
  server is found.  This address uses a subset of the syntax defined
  by RFC 2609 for IP-based protocols.  It is a subset because the
  user@host syntax is not supported.

  The other syntaxes defined by RFC 2609 are not currently
  supported by this class.

  The supported syntax is:



  //[host[:port]][url-path]



  Square brackets [] indicate optional parts of
  the address.  Not all protocols will recognize all optional
  parts.

  The host is a host name, an IPv4 numeric
  host address, or an IPv6 numeric address enclosed in square
  brackets.

  The port is a decimal port number.  0
  means a default or anonymous port, depending on the protocol.

  The host and port
  can be omitted.  The port cannot be supplied
  without a host.

  The url-path, if any, begins with a slash
  (/) or a semicolon (;) and continues to
  the end of the address.  It can contain attributes using the
  semicolon syntax specified in RFC 2609.  Those attributes are not
  parsed by this class and incorrect attribute syntax is not
  detected.

  Although it is legal according to RFC 2609 to have a
  url-path that begins with a semicolon, not
  all implementations of SLP allow it, so it is recommended to avoid
  that syntax.

  Case is not significant in the initial
  service:jmx:protocol string or in the host
  part of the address.  Depending on the protocol, case can be
  significant in the url-path."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote JMXServiceURL]))

(defn ->jmx-service-url
  "Constructor.

  Constructs a JMXServiceURL with the given parts.

  protocol - the protocol part of the URL. If null, defaults to jmxmp. - `java.lang.String`
  host - the host part of the URL. If null, defaults to the local host name, as determined by InetAddress.getLocalHost().getHostName(). If it is a numeric IPv6 address, it can optionally be enclosed in square brackets []. - `java.lang.String`
  port - the port part of the URL. - `int`
  url-path - the URL path part of the URL. If null, defaults to the empty string. - `java.lang.String`

  throws: java.net.MalformedURLException - if one of the parts is syntactically incorrect, or if host is null and it is not possible to find the local host name, or if port is negative."
  ([^java.lang.String protocol ^java.lang.String host ^Integer port ^java.lang.String url-path]
    (new JMXServiceURL protocol host port url-path))
  ([^java.lang.String protocol ^java.lang.String host ^Integer port]
    (new JMXServiceURL protocol host port))
  ([^java.lang.String service-url]
    (new JMXServiceURL service-url)))

(defn get-protocol
  "The protocol part of the Service URL.

  returns: the protocol part of the Service URL.  This is never null. - `java.lang.String`"
  ([^javax.management.remote.JMXServiceURL this]
    (-> this (.getProtocol))))

(defn get-host
  "The host part of the Service URL.  If the Service URL was
   constructed with the constructor that takes a URL string
   parameter, the result is the substring specifying the host in
   that URL.  If the Service URL was constructed with a
   constructor that takes a separate host parameter, the result is
   the string that was specified.  If that string was null, the
   result is
   InetAddress.getLocalHost().getHostName().

   In either case, if the host was specified using the
   [...] syntax for numeric IPv6 addresses, the
   square brackets are not included in the return value here.

  returns: the host part of the Service URL.  This is never null. - `java.lang.String`"
  ([^javax.management.remote.JMXServiceURL this]
    (-> this (.getHost))))

(defn get-port
  "The port of the Service URL.  If no port was
   specified, the returned value is 0.

  returns: the port of the Service URL, or 0 if none. - `int`"
  ([^javax.management.remote.JMXServiceURL this]
    (-> this (.getPort))))

(defn get-url-path
  "The URL Path part of the Service URL.  This is an empty
   string, or a string beginning with a slash (/), or
   a string beginning with a semicolon (;).

  returns: the URL Path part of the Service URL.  This is never
   null. - `java.lang.String`"
  ([^javax.management.remote.JMXServiceURL this]
    (-> this (.getURLPath))))

(defn to-string
  "The string representation of this Service URL.  If the value
   returned by this method is supplied to the
   JMXServiceURL constructor, the resultant object is
   equal to this one.

   The host part of the returned string
   is the value returned by getHost().  If that value
   specifies a numeric IPv6 address, it is surrounded by square
   brackets [].

   The port part of the returned string
   is the value returned by getPort() in its shortest
   decimal form.  If the value is zero, it is omitted.

  returns: the string representation of this Service URL. - `java.lang.String`"
  ([^javax.management.remote.JMXServiceURL this]
    (-> this (.toString))))

(defn equals
  "Indicates whether some other object is equal to this one.
   This method returns true if and only if obj is an
   instance of JMXServiceURL whose getProtocol(), getHost(), getPort(), and
   getURLPath() methods return the same values as for
   this object.  The values for getProtocol() and getHost() can differ in case without affecting equality.

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the
   obj argument; false otherwise. - `boolean`"
  ([^javax.management.remote.JMXServiceURL this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  ([^javax.management.remote.JMXServiceURL this]
    (-> this (.hashCode))))

