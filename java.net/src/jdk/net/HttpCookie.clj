(ns jdk.net.HttpCookie
  "An HttpCookie object represents an HTTP cookie, which carries state
  information between server and user agent. Cookie is widely adopted
  to create stateful sessions.

   There are 3 HTTP cookie specifications:

    Netscape draft
    RFC 2109 -
  http://www.ietf.org/rfc/rfc2109.txt
    RFC 2965 -
  http://www.ietf.org/rfc/rfc2965.txt


   HttpCookie class can accept all these 3 forms of syntax."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net HttpCookie]))

(defn ->http-cookie
  "Constructor.

  Constructs a cookie with a specified name and value.

    The name must conform to RFC 2965. That means it can contain
   only ASCII alphanumeric characters and cannot contain commas,
   semicolons, or white space or begin with a $ character. The cookie's
   name cannot be changed after creation.

    The value can be anything the server chooses to send. Its
   value is probably of interest only to the server. The cookie's
   value can be changed after creation with the
   setValue method.

    By default, cookies are created according to the RFC 2965
   cookie specification. The version can be changed with the
   setVersion method.

  name - a String specifying the name of the cookie - `java.lang.String`
  value - a String specifying the value of the cookie - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the cookie name contains illegal characters"
  ([^java.lang.String name ^java.lang.String value]
    (new HttpCookie name value)))

(defn *parse
  "Constructs cookies from set-cookie or set-cookie2 header string.
   RFC 2965 section 3.2.2 set-cookie2 syntax indicates that one header line
   may contain more than one cookie definitions, so this is a static
   utility method instead of another constructor.

  header - a String specifying the set-cookie header. The header should start with `set-cookie`, or `set-cookie2` token; or it should have no leading token at all. - `java.lang.String`

  returns: a List of cookie parsed from header line string - `java.util.List<java.net.HttpCookie>`

  throws: java.lang.IllegalArgumentException - if header string violates the cookie specification's syntax or the cookie name contains illegal characters."
  (^java.util.List [^java.lang.String header]
    (HttpCookie/parse header)))

(defn *domain-matches
  "The utility method to check whether a host name is in a domain or not.

    This concept is described in the cookie specification.
   To understand the concept, some terminologies need to be defined first:

   effective host name = hostname if host name contains dot

        or = hostname.local if not

   Host A's name domain-matches host B's if:

     their host name strings string-compare equal; or
     A is a HDN string and has the form NB, where N is a non-empty
     name string, B has the form .B', and B' is a HDN string.  (So,
     x.y.com domain-matches .Y.com but not Y.com.)


   A host isn't in a domain (RFC 2965 sec. 3.3.2) if:

     The value for the Domain attribute contains no embedded dots,
     and the value is not .local.
     The effective host name that derives from the request-host does
     not domain-match the Domain attribute.
     The request-host is a HDN (not IP address) and has the form HD,
     where D is the value of the Domain attribute, and H is a string
     that contains one or more dots.


   Examples:

     A Set-Cookie2 from request-host y.x.foo.com for Domain=.foo.com
     would be rejected, because H is y.x and contains a dot.
     A Set-Cookie2 from request-host x.foo.com for Domain=.foo.com
     would be accepted.
     A Set-Cookie2 with Domain=.com or Domain=.com., will always be
     rejected, because there is no embedded dot.
     A Set-Cookie2 from request-host example for Domain=.local will
     be accepted, because the effective host name for the request-
     host is example.local, and example.local domain-matches .local.

  domain - the domain name to check host name with - `java.lang.String`
  host - the host name in question - `java.lang.String`

  returns: true if they domain-matches; false if not - `boolean`"
  (^Boolean [^java.lang.String domain ^java.lang.String host]
    (HttpCookie/domainMatches domain host)))

(defn set-http-only
  "Indicates whether the cookie should be considered HTTP Only. If set to
   true it means the cookie should not be accessible to scripting
   engines like javascript.

  http-only - if true make the cookie HTTP only, i.e. only visible as part of an HTTP request. - `boolean`"
  ([^java.net.HttpCookie this ^Boolean http-only]
    (-> this (.setHttpOnly http-only))))

(defn set-version
  "Sets the version of the cookie protocol this cookie complies
   with. Version 0 complies with the original Netscape cookie
   specification. Version 1 complies with RFC 2965/2109.

  v - 0 if the cookie should comply with the original Netscape specification; 1 if the cookie should comply with RFC 2965/2109 - `int`

  throws: java.lang.IllegalArgumentException - if v is neither 0 nor 1"
  ([^java.net.HttpCookie this ^Integer v]
    (-> this (.setVersion v))))

(defn set-secure
  "Indicates whether the cookie should only be sent using a secure protocol,
   such as HTTPS or SSL.

    The default value is false.

  flag - If true, the cookie can only be sent over a secure protocol like HTTPS. If false, it can be sent over any protocol. - `boolean`"
  ([^java.net.HttpCookie this ^Boolean flag]
    (-> this (.setSecure flag))))

(defn http-only?
  "Returns true if this cookie contains the HttpOnly
   attribute. This means that the cookie should not be accessible to
   scripting engines, like javascript.

  returns: true if this cookie should be considered HTTPOnly - `boolean`"
  (^Boolean [^java.net.HttpCookie this]
    (-> this (.isHttpOnly))))

(defn set-comment
  "Specifies a comment that describes a cookie's purpose.
   The comment is useful if the browser presents the cookie
   to the user. Comments are not supported by Netscape Version 0 cookies.

  purpose - a String specifying the comment to display to the user - `java.lang.String`"
  ([^java.net.HttpCookie this ^java.lang.String purpose]
    (-> this (.setComment purpose))))

(defn set-comment-url
  "Specifies a comment URL that describes a cookie's purpose.
   The comment URL is useful if the browser presents the cookie
   to the user. Comment URL is RFC 2965 only.

  purpose - a String specifying the comment URL to display to the user - `java.lang.String`"
  ([^java.net.HttpCookie this ^java.lang.String purpose]
    (-> this (.setCommentURL purpose))))

(defn set-portlist
  "Specify the portlist of the cookie, which restricts the port(s)
   to which a cookie may be sent back in a Cookie header.

  ports - a String specify the port list, which is comma separated series of digits - `java.lang.String`"
  ([^java.net.HttpCookie this ^java.lang.String ports]
    (-> this (.setPortlist ports))))

(defn set-path
  "Specifies a path for the cookie to which the client should return
   the cookie.

    The cookie is visible to all the pages in the directory
   you specify, and all the pages in that directory's subdirectories.
   A cookie's path must include the servlet that set the cookie,
   for example, /catalog, which makes the cookie
   visible to all directories on the server under /catalog.

    Consult RFC 2965 (available on the Internet) for more
   information on setting path names for cookies.

  uri - a String specifying a path - `java.lang.String`"
  ([^java.net.HttpCookie this ^java.lang.String uri]
    (-> this (.setPath uri))))

(defn has-expired?
  "Reports whether this HTTP cookie has expired or not.

  returns: true to indicate this HTTP cookie has expired;
            otherwise, false - `boolean`"
  (^Boolean [^java.net.HttpCookie this]
    (-> this (.hasExpired))))

(defn to-string
  "Constructs a cookie header string representation of this cookie,
   which is in the format defined by corresponding cookie specification,
   but without the leading `Cookie:` token.

  returns: a string form of the cookie. The string has the defined format - `java.lang.String`"
  (^java.lang.String [^java.net.HttpCookie this]
    (-> this (.toString))))

(defn get-path
  "Returns the path on the server to which the browser returns this cookie.
   The cookie is visible to all subpaths on the server.

  returns: a String specifying a path that contains a servlet name,
            for example, /catalog - `java.lang.String`"
  (^java.lang.String [^java.net.HttpCookie this]
    (-> this (.getPath))))

(defn get-value
  "Returns the value of the cookie.

  returns: a String containing the cookie's present value - `java.lang.String`"
  (^java.lang.String [^java.net.HttpCookie this]
    (-> this (.getValue))))

(defn get-name
  "Returns the name of the cookie. The name cannot be changed after
   creation.

  returns: a String specifying the cookie's name - `java.lang.String`"
  (^java.lang.String [^java.net.HttpCookie this]
    (-> this (.getName))))

(defn get-comment-url
  "Returns the comment URL describing the purpose of this cookie, or
   null if the cookie has no comment URL.

  returns: a String containing the comment URL, or null
            if none - `java.lang.String`"
  (^java.lang.String [^java.net.HttpCookie this]
    (-> this (.getCommentURL))))

(defn get-version
  "Returns the version of the protocol this cookie complies with. Version 1
   complies with RFC 2965/2109, and version 0 complies with the original
   cookie specification drafted by Netscape. Cookies provided by a browser
   use and identify the browser's cookie version.

  returns: 0 if the cookie complies with the original Netscape
            specification; 1 if the cookie complies with RFC 2965/2109 - `int`"
  (^Integer [^java.net.HttpCookie this]
    (-> this (.getVersion))))

(defn get-comment
  "Returns the comment describing the purpose of this cookie, or
   null if the cookie has no comment.

  returns: a String containing the comment, or null if none - `java.lang.String`"
  (^java.lang.String [^java.net.HttpCookie this]
    (-> this (.getComment))))

(defn set-value
  "Assigns a new value to a cookie after the cookie is created.
   If you use a binary value, you may want to use BASE64 encoding.

    With Version 0 cookies, values should not contain white space,
   brackets, parentheses, equals signs, commas, double quotes, slashes,
   question marks, at signs, colons, and semicolons. Empty values may not
   behave the same way on all browsers.

  new-value - a String specifying the new value - `java.lang.String`"
  ([^java.net.HttpCookie this ^java.lang.String new-value]
    (-> this (.setValue new-value))))

(defn get-domain
  "Returns the domain name set for this cookie. The form of the domain name
   is set by RFC 2965.

  returns: a String containing the domain name - `java.lang.String`"
  (^java.lang.String [^java.net.HttpCookie this]
    (-> this (.getDomain))))

(defn clone
  "Create and return a copy of this object.

  returns: a clone of this HTTP cookie - `java.lang.Object`"
  (^java.lang.Object [^java.net.HttpCookie this]
    (-> this (.clone))))

(defn hash-code
  "Returns the hash code of this HTTP cookie. The result is the sum of
   hash code value of three significant components of this cookie: name,
   domain, and path. That is, the hash code is the value of the expression:

   getName().toLowerCase().hashCode()
    getDomain().toLowerCase().hashCode()
    getPath().hashCode()

  returns: this HTTP cookie's hash code - `int`"
  (^Integer [^java.net.HttpCookie this]
    (-> this (.hashCode))))

(defn set-discard
  "Specify whether user agent should discard the cookie unconditionally.
   This is RFC 2965 only attribute.

  discard - true indicates to discard cookie unconditionally - `boolean`"
  ([^java.net.HttpCookie this ^Boolean discard]
    (-> this (.setDiscard discard))))

(defn set-domain
  "Specifies the domain within which this cookie should be presented.

    The form of the domain name is specified by RFC 2965. A domain
   name begins with a dot (.foo.com) and means that
   the cookie is visible to servers in a specified Domain Name System
   (DNS) zone (for example, www.foo.com, but not
   a.b.foo.com). By default, cookies are only returned
   to the server that sent them.

  pattern - a String containing the domain name within which this cookie is visible; form is according to RFC 2965 - `java.lang.String`"
  ([^java.net.HttpCookie this ^java.lang.String pattern]
    (-> this (.setDomain pattern))))

(defn get-discard?
  "Returns the discard attribute of the cookie

  returns: a boolean to represent this cookie's discard attribute - `boolean`"
  (^Boolean [^java.net.HttpCookie this]
    (-> this (.getDiscard))))

(defn set-max-age
  "Sets the maximum age of the cookie in seconds.

    A positive value indicates that the cookie will expire
   after that many seconds have passed. Note that the value is
   the maximum age when the cookie will expire, not the cookie's
   current age.

    A negative value means that the cookie is not stored persistently
   and will be deleted when the Web browser exits. A zero value causes the
   cookie to be deleted.

  expiry - an integer specifying the maximum age of the cookie in seconds; if zero, the cookie should be discarded immediately; otherwise, the cookie's max age is unspecified. - `long`"
  ([^java.net.HttpCookie this ^Long expiry]
    (-> this (.setMaxAge expiry))))

(defn equals
  "Test the equality of two HTTP cookies.

    The result is true only if two cookies come from same domain
   (case-insensitive), have same name (case-insensitive), and have same path
   (case-sensitive).

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if two HTTP cookies equal to each other;
            otherwise, false - `boolean`"
  (^Boolean [^java.net.HttpCookie this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn get-portlist
  "Returns the port list attribute of the cookie

  returns: a String contains the port list or null if none - `java.lang.String`"
  (^java.lang.String [^java.net.HttpCookie this]
    (-> this (.getPortlist))))

(defn get-secure?
  "Returns true if sending this cookie should be restricted to a
   secure protocol, or false if the it can be sent using any
   protocol.

  returns: false if the cookie can be sent over any standard
            protocol; otherwise, true - `boolean`"
  (^Boolean [^java.net.HttpCookie this]
    (-> this (.getSecure))))

(defn get-max-age
  "Returns the maximum age of the cookie, specified in seconds. By default,
   -1 indicating the cookie will persist until browser shutdown.

  returns: an integer specifying the maximum age of the cookie in seconds - `long`"
  (^Long [^java.net.HttpCookie this]
    (-> this (.getMaxAge))))

