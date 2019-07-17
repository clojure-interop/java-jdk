(ns jdk.net.URLPermission
  "Represents permission to access a resource or set of resources defined by a
  given url, and for a given set of user-settable request methods
  and request headers. The name of the permission is the url string.
  The actions string is a concatenation of the request methods and headers.
  The range of method and header names is not restricted by this class.
  The url
  The url string has the following expected structure.


      scheme : // authority [ / path ]
  scheme will typically be http or https, but is not restricted by this
  class.
  authority is specified as:


      authority = [ userinfo @ ] hostrange [ : portrange ]
      portrange = portnumber | -portnumber | portnumber-[portnumber] | *
      hostrange = ([*.] dnsname) | IPv4address | IPv6address
  dnsname is a standard DNS host or domain name, ie. one or more labels
  separated by `.`. IPv4address is a standard literal IPv4 address and
  IPv6address is as defined in
  RFC 2732. Literal IPv6 addresses must however, be enclosed in '[]' characters.
  The dnsname specification can be preceded by `*.` which means
  the name will match any hostname whose right-most domain labels are the same as
  this name. For example, `*.oracle.com` matches `foo.bar.oracle.com`

  portrange is used to specify a port number, or a bounded or unbounded range of ports
  that this permission applies to. If portrange is absent or invalid, then a default
  port number is assumed if the scheme is http (default 80) or https
  (default 443). No default is assumed for other schemes. A wildcard may be specified
  which means all ports.

  userinfo is optional. A userinfo component if present, is ignored when
  creating a URLPermission, and has no effect on any other methods defined by this class.

  The path component comprises a sequence of path segments,
  separated by '/' characters. path may also be empty. The path is specified
  in a similar way to the path in FilePermission. There are
  three different ways as the following examples show:

  URL Examples
  Example urlDescription
  http://www.oracle.com/a/b/c.html
    A url which identifies a specific (single) resource

  http://www.oracle.com/a/b/*
    The '*' character refers to all resources in the same `directory` - in
        other words all resources with the same number of path components, and
        which only differ in the final path component, represented by the '*'.


  http://www.oracle.com/a/b/-
    The '-' character refers to all resources recursively below the
        preceding path (eg. http://www.oracle.com/a/b/c/d/e.html matches this
        example).




  The '*' and '-' may only be specified in the final segment of a path and must be
  the only character in that segment. Any query or fragment components of the
  url are ignored when constructing URLPermissions.

  As a special case, urls of the form, `scheme:*` are accepted to
  mean any url of the given scheme.

  The scheme and authority components of the url string are handled
  without regard to case. This means equals(Object),
  hashCode() and implies(Permission) are case insensitive with respect
  to these components. If the authority contains a literal IP address,
  then the address is normalized for comparison. The path component is case sensitive.
  The actions string
  The actions string of a URLPermission is a concatenation of the method list
  and the request headers list. These are lists of the permitted request
  methods and permitted request headers of the permission (respectively). The two lists
  are separated by a colon ':' character and elements of each list are comma separated.
  Some examples are:


          `POST,GET,DELETE`
          `GET:X-Foo-Request,X-Bar-Request`
          `POST,GET:Header1,Header2`
  The first example specifies the methods: POST, GET and DELETE, but no request headers.
  The second example specifies one request method and two headers. The third
  example specifies two request methods, and two headers.

  The colon separator need not be present if the request headers list is empty.
  No white-space is permitted in the actions string. The action strings supplied to
  the URLPermission constructors are case-insensitive and are normalized by converting
  method names to upper-case and header names to the form defines in RFC2616 (lower case
  with initial letter of each word capitalized). Either list can contain a wild-card '*'
  character which signifies all request methods or headers respectively.

  Note. Depending on the context of use, some request methods and headers may be permitted
  at all times, and others may not be permitted at any time. For example, the
  HTTP protocol handler might disallow certain headers such as Content-Length
  from being set by application code, regardless of whether the security policy
  in force, permits it."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net URLPermission]))

(defn ->url-permission
  "Constructor.

  Creates a new URLPermission from a url string and which permits the given
   request methods and user-settable request headers.
   The name of the permission is the url string it was created with. Only the scheme,
   authority and path components of the url are used internally. Any fragment or query
   components are ignored. The permissions action string is as specified above.

  url - the url string - `java.lang.String`
  actions - the actions string - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if url is invalid or if actions contains white-space."
  ([^java.lang.String url ^java.lang.String actions]
    (new URLPermission url actions))
  ([^java.lang.String url]
    (new URLPermission url)))

(defn get-actions
  "Returns the normalized method list and request
   header list, in the form:


        `method-names : header-names`

   where method-names is the list of methods separated by commas
   and header-names is the list of permitted headers separated by commas.
   There is no white space in the returned String. If header-names is empty
   then the colon separator will not be present.

  returns: the actions of this Permission. - `java.lang.String`"
  ([^java.net.URLPermission this]
    (-> this (.getActions))))

(defn implies
  "Checks if this URLPermission implies the given permission.
   Specifically, the following checks are done as if in the
   following sequence:

   if 'p' is not an instance of URLPermission return false
   if any of p's methods are not in this's method list, and if
       this's method list is not equal to `*`, then return false.
   if any of p's headers are not in this's request header list, and if
       this's request header list is not equal to `*`, then return false.
   if this's url scheme is not equal to p's url scheme return false
   if the scheme specific part of this's url is '*' return true
   if the set of hosts defined by p's url hostrange is not a subset of
       this's url hostrange then return false. For example, `*.foo.oracle.com`
       is a subset of `*.oracle.com`. `foo.bar.oracle.com` is not
       a subset of `*.foo.oracle.com`
   if the portrange defined by p's url is not a subset of the
       portrange defined by this's url then return false.
   if the path or paths specified by p's url are contained in the
       set of paths specified by this's url, then return true
   otherwise, return false

   Some examples of how paths are matched are shown below:

   Examples of Path Matching
   this's pathp's pathmatch
   /a/b/a/byes
   /a/b/*/a/b/cyes
   /a/b/*/a/b/c/dno
   /a/b/-/a/b/c/dyes
   /a/b/-/a/b/c/d/eyes
   /a/b/-/a/b/c/*yes
   /a/b/*/a/b/c/-no

  p - the permission to check against. - `java.security.Permission`

  returns: true if the specified permission is implied by this object,
   false if not. - `boolean`"
  ([^java.net.URLPermission this ^java.security.Permission p]
    (-> this (.implies p))))

(defn equals
  "Returns true if, this.getActions().equals(p.getActions())
   and p's url equals this's url.  Returns false otherwise.

  p - the object we are testing for equality with this object. - `java.lang.Object`

  returns: true if both Permission objects are equivalent. - `boolean`"
  ([^java.net.URLPermission this ^java.lang.Object p]
    (-> this (.equals p))))

(defn hash-code
  "Returns a hashcode calculated from the hashcode of the
   actions String and the url string.

  returns: a hash code value for this object. - `int`"
  ([^java.net.URLPermission this]
    (-> this (.hashCode))))

