(ns jdk.net.URI
  "Represents a Uniform Resource Identifier (URI) reference.

   Aside from some minor deviations noted below, an instance of this
  class represents a URI reference as defined by
  RFC 2396: Uniform
  Resource Identifiers (URI): Generic Syntax, amended by RFC 2732: Format for
  Literal IPv6 Addresses in URLs. The Literal IPv6 address format
  also supports scope_ids. The syntax and usage of scope_ids is described
  here.
  This class provides constructors for creating URI instances from
  their components or by parsing their string forms, methods for accessing the
  various components of an instance, and methods for normalizing, resolving,
  and relativizing URI instances.  Instances of this class are immutable.


   URI syntax and components

  At the highest level a URI reference (hereinafter simply `URI`) in string
  form has the syntax


  [scheme:]scheme-specific-part[#fragment]


  where square brackets [...] delineate optional components and the characters
  : and # stand for themselves.

   An absolute URI specifies a scheme; a URI that is not absolute is
  said to be relative.  URIs are also classified according to whether
  they are opaque or hierarchical.

   An opaque URI is an absolute URI whose scheme-specific part does
  not begin with a slash character ('/').  Opaque URIs are not
  subject to further parsing.  Some examples of opaque URIs are:


  mailto:java-net@java.sun.com
  news:comp.lang.java
  urn:isbn:096139210x


   A hierarchical URI is either an absolute URI whose
  scheme-specific part begins with a slash character, or a relative URI, that
  is, a URI that does not specify a scheme.  Some examples of hierarchical
  URIs are:


  http://java.sun.com/j2se/1.3/
  docs/guide/collections/designfaq.html#28
  ../../../demo/jfc/SwingSet2/src/SwingSet2.java
  file:///~/calendar


   A hierarchical URI is subject to further parsing according to the syntax


  [scheme:][//authority][path][?query][#fragment]


  where the characters :, /,
  ?, and # stand for themselves.  The
  scheme-specific part of a hierarchical URI consists of the characters
  between the scheme and fragment components.

   The authority component of a hierarchical URI is, if specified, either
  server-based or registry-based.  A server-based authority
  parses according to the familiar syntax


  [user-info@]host[:port]


  where the characters @ and : stand for
  themselves.  Nearly all URI schemes currently in use are server-based.  An
  authority component that does not parse in this way is considered to be
  registry-based.

   The path component of a hierarchical URI is itself said to be absolute
  if it begins with a slash character ('/'); otherwise it is
  relative.  The path of a hierarchical URI that is either absolute or
  specifies an authority is always absolute.

   All told, then, a URI instance has the following nine components:


  ComponentType
  schemeString
  scheme-specific-part    String
  authorityString
  user-infoString
  hostString
  portint
  pathString
  queryString
  fragmentString


  In a given instance any particular component is either undefined or
  defined with a distinct value.  Undefined string components are
  represented by null, while undefined integer components are
  represented by -1.  A string component may be defined to have the
  empty string as its value; this is not equivalent to that component being
  undefined.

   Whether a particular component is or is not defined in an instance
  depends upon the type of the URI being represented.  An absolute URI has a
  scheme component.  An opaque URI has a scheme, a scheme-specific part, and
  possibly a fragment, but has no other components.  A hierarchical URI always
  has a path (though it may be empty) and a scheme-specific-part (which at
  least contains the path), and may have any of the other components.  If the
  authority component is present and is server-based then the host component
  will be defined and the user-information and port components may be defined.


   Operations on URI instances

  The key operations supported by this class are those of
  normalization, resolution, and relativization.

   Normalization is the process of removing unnecessary `.`
  and `..` segments from the path component of a hierarchical URI.
  Each `.` segment is simply removed.  A `..` segment is
  removed only if it is preceded by a non-`..` segment.
  Normalization has no effect upon opaque URIs.

   Resolution is the process of resolving one URI against another,
  base URI.  The resulting URI is constructed from components of both
  URIs in the manner specified by RFC 2396, taking components from the
  base URI for those not specified in the original.  For hierarchical URIs,
  the path of the original is resolved against the path of the base and then
  normalized.  The result, for example, of resolving


  docs/guide/collections/designfaq.html#28

      (1)


  against the base URI http://java.sun.com/j2se/1.3/ is the result
  URI


  https://docs.oracle.com/javase/1.3/docs/guide/collections/designfaq.html#28


  Resolving the relative URI


  ../../../demo/jfc/SwingSet2/src/SwingSet2.java    (2)


  against this result yields, in turn,


  http://java.sun.com/j2se/1.3/demo/jfc/SwingSet2/src/SwingSet2.java


  Resolution of both absolute and relative URIs, and of both absolute and
  relative paths in the case of hierarchical URIs, is supported.  Resolving
  the URI file:///~calendar against any other URI simply yields the
  original URI, since it is absolute.  Resolving the relative URI (2) above
  against the relative base URI (1) yields the normalized, but still relative,
  URI


  demo/jfc/SwingSet2/src/SwingSet2.java


   Relativization, finally, is the inverse of resolution: For any
  two normalized URIs u and v,


    u.relativize(u.resolve(v)).equals(v)  and
    u.resolve(u.relativize(v)).equals(v)  .


  This operation is often useful when constructing a document containing URIs
  that must be made relative to the base URI of the document wherever
  possible.  For example, relativizing the URI


  https://docs.oracle.com/javase/1.3/docs/guide/index.html


  against the base URI


  http://java.sun.com/j2se/1.3


  yields the relative URI docs/guide/index.html.


   Character categories

  RFC 2396 specifies precisely which characters are permitted in the
  various components of a URI reference.  The following categories, most of
  which are taken from that specification, are used below to describe these
  constraints:


    alpha
        The US-ASCII alphabetic characters,
         'A' through 'Z'
         and 'a' through 'z'
    digit
        The US-ASCII decimal digit characters,
        '0' through '9'
    alphanum
        All alpha and digit characters
    unreserved
        All alphanum characters together with those in the string
         `_-!.~'()*`
    punct
        The characters in the string `,;:$&+=`
    reserved
        All punct characters together with those in the string
         `?/[]@`
    escaped
        Escaped octets, that is, triplets consisting of the percent
            character ('%') followed by two hexadecimal digits
            ('0'-'9', 'A'-'F', and
            'a'-'f')
    other
        The Unicode characters that are not in the US-ASCII character set,
            are not control characters (according to the Character.isISOControl
            method), and are not space characters (according to the Character.isSpaceChar
            method)  (Deviation from RFC 2396, which is
            limited to US-ASCII)


   The set of all legal URI characters consists of
  the unreserved, reserved, escaped, and other
  characters.


   Escaped octets, quotation, encoding, and decoding

  RFC 2396 allows escaped octets to appear in the user-info, path, query, and
  fragment components.  Escaping serves two purposes in URIs:



     To encode non-US-ASCII characters when a URI is required to
    conform strictly to RFC 2396 by not containing any other
    characters.

     To quote characters that are otherwise illegal in a
    component.  The user-info, path, query, and fragment components differ
    slightly in terms of which characters are considered legal and illegal.




  These purposes are served in this class by three related operations:



     A character is encoded by replacing it
    with the sequence of escaped octets that represent that character in the
    UTF-8 character set.  The Euro currency symbol ('\u20AC'),
    for example, is encoded as `%E2%82%AC`.  (Deviation from
    RFC 2396, which does not specify any particular character
    set.)

     An illegal character is quoted simply by
    encoding it.  The space character, for example, is quoted by replacing it
    with `%20`.  UTF-8 contains US-ASCII, hence for US-ASCII
    characters this transformation has exactly the effect required by
    RFC 2396.


    A sequence of escaped octets is decoded by
    replacing it with the sequence of characters that it represents in the
    UTF-8 character set.  UTF-8 contains US-ASCII, hence decoding has the
    effect of de-quoting any quoted US-ASCII characters as well as that of
    decoding any encoded non-US-ASCII characters.  If a decoding error occurs
    when decoding the escaped octets then the erroneous octets are replaced by
    '\uFFFD', the Unicode replacement character.



  These operations are exposed in the constructors and methods of this class
  as follows:



     The single-argument
    constructor requires any illegal characters in its argument to be
    quoted and preserves any escaped octets and other characters that
    are present.

     The multi-argument constructors quote illegal characters as
    required by the components in which they appear.  The percent character
    ('%') is always quoted by these constructors.  Any other
    characters are preserved.

     The getRawUserInfo, getRawPath, getRawQuery, getRawFragment, getRawAuthority, and getRawSchemeSpecificPart methods return the
    values of their corresponding components in raw form, without interpreting
    any escaped octets.  The strings returned by these methods may contain
    both escaped octets and other characters, and will not contain any
    illegal characters.

     The getUserInfo, getPath, getQuery, getFragment, getAuthority, and getSchemeSpecificPart methods decode any escaped
    octets in their corresponding components.  The strings returned by these
    methods may contain both other characters and illegal characters,
    and will not contain any escaped octets.

     The toString method returns a URI string with
    all necessary quotation but which may contain other characters.


     The toASCIIString method returns a fully
    quoted and encoded URI string that does not contain any other
    characters.




   Identities

  For any URI u, it is always the case that


  new URI(u.toString()).equals(u) .


  For any URI u that does not contain redundant syntax such as two
  slashes before an empty authority (as in file:///tmp/ ) or a
  colon following a host name but no port (as in
  http://java.sun.com: ), and that does not encode characters
  except those that must be quoted, the following identities also hold:


      new URI(u.getScheme(),
              u.getSchemeSpecificPart(),
              u.getFragment())
      .equals(u)
  in all cases,


      new URI(u.getScheme(),
              u.getUserInfo(), u.getAuthority(),
              u.getPath(), u.getQuery(),
              u.getFragment())
      .equals(u)
  if u is hierarchical, and


      new URI(u.getScheme(),
              u.getUserInfo(), u.getHost(), u.getPort(),
              u.getPath(), u.getQuery(),
              u.getFragment())
      .equals(u)
  if u is hierarchical and has either no authority or a server-based
  authority.


   URIs, URLs, and URNs

  A URI is a uniform resource identifier while a URL is a uniform
  resource locator.  Hence every URL is a URI, abstractly speaking, but
  not every URI is a URL.  This is because there is another subcategory of
  URIs, uniform resource names (URNs), which name resources but do not
  specify how to locate them.  The mailto, news, and
  isbn URIs shown above are examples of URNs.

   The conceptual distinction between URIs and URLs is reflected in the
  differences between this class and the URL class.

   An instance of this class represents a URI reference in the syntactic
  sense defined by RFC 2396.  A URI may be either absolute or relative.
  A URI string is parsed according to the generic syntax without regard to the
  scheme, if any, that it specifies.  No lookup of the host, if any, is
  performed, and no scheme-dependent stream handler is constructed.  Equality,
  hashing, and comparison are defined strictly in terms of the character
  content of the instance.  In other words, a URI instance is little more than
  a structured string that supports the syntactic, scheme-independent
  operations of comparison, normalization, resolution, and relativization.

   An instance of the URL class, by contrast, represents the
  syntactic components of a URL together with some of the information required
  to access the resource that it describes.  A URL must be absolute, that is,
  it must always specify a scheme.  A URL string is parsed according to its
  scheme.  A stream handler is always established for a URL, and in fact it is
  impossible to create a URL instance for a scheme for which no handler is
  available.  Equality and hashing depend upon both the scheme and the
  Internet address of the host, if any; comparison is not defined.  In other
  words, a URL is a structured string that supports the syntactic operation of
  resolution as well as the network I/O operations of looking up the host and
  opening a connection to the specified resource."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net URI]))

(defn ->uri
  "Constructor.

  Constructs a hierarchical URI from the given components.

    If a scheme is given then the path, if also given, must either be
   empty or begin with a slash character ('/').  Otherwise a
   component of the new URI may be left undefined by passing null
   for the corresponding parameter or, in the case of the port
   parameter, by passing -1.

    This constructor first builds a URI string from the given components
   according to the rules specified in RFC 2396,
   section 5.2, step 7:



      Initially, the result string is empty.

      If a scheme is given then it is appended to the result,
     followed by a colon character (':').

      If user information, a host, or a port are given then the
     string `//` is appended.

      If user information is given then it is appended, followed by
     a commercial-at character ('@').  Any character not in the
     unreserved, punct, escaped, or other
     categories is quoted.

      If a host is given then it is appended.  If the host is a
     literal IPv6 address but is not enclosed in square brackets
     ('[' and ']') then the square brackets are added.


      If a port number is given then a colon character
     (':') is appended, followed by the port number in decimal.


      If a path is given then it is appended.  Any character not in
     the unreserved, punct, escaped, or other
     categories, and not equal to the slash character ('/') or the
     commercial-at character ('@'), is quoted.

      If a query is given then a question-mark character
     ('?') is appended, followed by the query.  Any character that
     is not a legal URI character is quoted.


      Finally, if a fragment is given then a hash character
     ('#') is appended, followed by the fragment.  Any character
     that is not a legal URI character is quoted.



    The resulting URI string is then parsed as if by invoking the URI(String) constructor and then invoking the parseServerAuthority() method upon the result; this may cause a URISyntaxException to be thrown.

  scheme - Scheme name - `java.lang.String`
  user-info - User name and authorization information - `java.lang.String`
  host - Host name - `java.lang.String`
  port - Port number - `int`
  path - Path - `java.lang.String`
  query - Query - `java.lang.String`
  fragment - Fragment - `java.lang.String`

  throws: java.net.URISyntaxException - If both a scheme and a path are given but the path is relative, if the URI string constructed from the given components violates RFC 2396, or if the authority component of the string is present but cannot be parsed as a server-based authority"
  ([^java.lang.String scheme ^java.lang.String user-info ^java.lang.String host ^Integer port ^java.lang.String path ^java.lang.String query ^java.lang.String fragment]
    (new URI scheme user-info host port path query fragment))
  ([^java.lang.String scheme ^java.lang.String authority ^java.lang.String path ^java.lang.String query ^java.lang.String fragment]
    (new URI scheme authority path query fragment))
  ([^java.lang.String scheme ^java.lang.String host ^java.lang.String path ^java.lang.String fragment]
    (new URI scheme host path fragment))
  ([^java.lang.String scheme ^java.lang.String ssp ^java.lang.String fragment]
    (new URI scheme ssp fragment))
  ([^java.lang.String str]
    (new URI str)))

(defn *create
  "Creates a URI by parsing the given string.

    This convenience factory method works as if by invoking the URI(String) constructor; any URISyntaxException thrown by the
   constructor is caught and wrapped in a new IllegalArgumentException object, which is then thrown.

    This method is provided for use in situations where it is known that
   the given string is a legal URI, for example for URI constants declared
   within in a program, and so it would be considered a programming error
   for the string not to parse as such.  The constructors, which throw
   URISyntaxException directly, should be used situations where a
   URI is being constructed from user input or from some other source that
   may be prone to errors.

  str - The string to be parsed into a URI - `java.lang.String`

  returns: The new URI - `java.net.URI`

  throws: java.lang.NullPointerException - If str is null"
  (^java.net.URI [^java.lang.String str]
    (URI/create str)))

(defn opaque?
  "Tells whether or not this URI is opaque.

    A URI is opaque if, and only if, it is absolute and its
   scheme-specific part does not begin with a slash character ('/').
   An opaque URI has a scheme, a scheme-specific part, and possibly
   a fragment; all other components are undefined.

  returns: true if, and only if, this URI is opaque - `boolean`"
  (^Boolean [^java.net.URI this]
    (-> this (.isOpaque))))

(defn get-raw-query
  "Returns the raw query component of this URI.

    The query component of a URI, if defined, only contains legal URI
   characters.

  returns: The raw query component of this URI,
            or null if the query is undefined - `java.lang.String`"
  (^java.lang.String [^java.net.URI this]
    (-> this (.getRawQuery))))

(defn get-raw-path
  "Returns the raw path component of this URI.

    The path component of a URI, if defined, only contains the slash
   character ('/'), the commercial-at character ('@'),
   and characters in the unreserved, punct, escaped,
   and other categories.

  returns: The path component of this URI,
            or null if the path is undefined - `java.lang.String`"
  (^java.lang.String [^java.net.URI this]
    (-> this (.getRawPath))))

(defn normalize
  "Normalizes this URI's path.

    If this URI is opaque, or if its path is already in normal form,
   then this URI is returned.  Otherwise a new URI is constructed that is
   identical to this URI except that its path is computed by normalizing
   this URI's path in a manner consistent with RFC 2396,
   section 5.2, step 6, sub-steps c through f; that is:




      All `.` segments are removed.

      If a `..` segment is preceded by a non-`..`
     segment then both of these segments are removed.  This step is
     repeated until it is no longer applicable.

      If the path is relative, and if its first segment contains a
     colon character (':'), then a `.` segment is
     prepended.  This prevents a relative URI with a path such as
     `a:b/c/d` from later being re-parsed as an opaque URI with a
     scheme of `a` and a scheme-specific part of `b/c/d`.
     (Deviation from RFC 2396)



    A normalized path will begin with one or more `..` segments
   if there were insufficient non-`..` segments preceding them to
   allow their removal.  A normalized path will begin with a `.`
   segment if one was inserted by step 3 above.  Otherwise, a normalized
   path will not contain any `.` or `..` segments.

  returns: A URI equivalent to this URI,
            but whose path is in normal form - `java.net.URI`"
  (^java.net.URI [^java.net.URI this]
    (-> this (.normalize))))

(defn get-authority
  "Returns the decoded authority component of this URI.

    The string returned by this method is equal to that returned by the
   getRawAuthority method except that all
   sequences of escaped octets are decoded.

  returns: The decoded authority component of this URI,
            or null if the authority is undefined - `java.lang.String`"
  (^java.lang.String [^java.net.URI this]
    (-> this (.getAuthority))))

(defn resolve
  "Resolves the given URI against this URI.

    If the given URI is already absolute, or if this URI is opaque, then
   the given URI is returned.

    If the given URI's fragment component is
   defined, its path component is empty, and its scheme, authority, and
   query components are undefined, then a URI with the given fragment but
   with all other components equal to those of this URI is returned.  This
   allows a URI representing a standalone fragment reference, such as
   `#foo`, to be usefully resolved against a base URI.

    Otherwise this method constructs a new hierarchical URI in a manner
   consistent with RFC 2396,
   section 5.2; that is:



      A new URI is constructed with this URI's scheme and the given
     URI's query and fragment components.

      If the given URI has an authority component then the new URI's
     authority and path are taken from the given URI.

      Otherwise the new URI's authority component is copied from
     this URI, and its path is computed as follows:



        If the given URI's path is absolute then the new URI's path
       is taken from the given URI.

        Otherwise the given URI's path is relative, and so the new
       URI's path is computed by resolving the path of the given URI
       against the path of this URI.  This is done by concatenating all but
       the last segment of this URI's path, if any, with the given URI's
       path and then normalizing the result as if by invoking the normalize method.





    The result of this method is absolute if, and only if, either this
   URI is absolute or the given URI is absolute.

  uri - The URI to be resolved against this URI - `java.net.URI`

  returns: The resulting URI - `java.net.URI`

  throws: java.lang.NullPointerException - If uri is null"
  (^java.net.URI [^java.net.URI this ^java.net.URI uri]
    (-> this (.resolve uri))))

(defn get-fragment
  "Returns the decoded fragment component of this URI.

    The string returned by this method is equal to that returned by the
   getRawFragment method except that all
   sequences of escaped octets are decoded.

  returns: The decoded fragment component of this URI,
            or null if the fragment is undefined - `java.lang.String`"
  (^java.lang.String [^java.net.URI this]
    (-> this (.getFragment))))

(defn get-scheme-specific-part
  "Returns the decoded scheme-specific part of this URI.

    The string returned by this method is equal to that returned by the
   getRawSchemeSpecificPart method
   except that all sequences of escaped octets are decoded.

  returns: The decoded scheme-specific part of this URI
            (never null) - `java.lang.String`"
  (^java.lang.String [^java.net.URI this]
    (-> this (.getSchemeSpecificPart))))

(defn to-string
  "Returns the content of this URI as a string.

    If this URI was created by invoking one of the constructors in this
   class then a string equivalent to the original input string, or to the
   string computed from the originally-given components, as appropriate, is
   returned.  Otherwise this URI was created by normalization, resolution,
   or relativization, and so a string is constructed from this URI's
   components according to the rules specified in RFC 2396,
   section 5.2, step 7.

  returns: The string form of this URI - `java.lang.String`"
  (^java.lang.String [^java.net.URI this]
    (-> this (.toString))))

(defn get-user-info
  "Returns the decoded user-information component of this URI.

    The string returned by this method is equal to that returned by the
   getRawUserInfo method except that all
   sequences of escaped octets are decoded.

  returns: The decoded user-information component of this URI,
            or null if the user information is undefined - `java.lang.String`"
  (^java.lang.String [^java.net.URI this]
    (-> this (.getUserInfo))))

(defn to-ascii-string
  "Returns the content of this URI as a US-ASCII string.

    If this URI does not contain any characters in the other
   category then an invocation of this method will return the same value as
   an invocation of the toString method.  Otherwise
   this method works as if by invoking that method and then encoding the result.

  returns: The string form of this URI, encoded as needed
            so that it only contains characters in the US-ASCII
            charset - `java.lang.String`"
  (^java.lang.String [^java.net.URI this]
    (-> this (.toASCIIString))))

(defn get-path
  "Returns the decoded path component of this URI.

    The string returned by this method is equal to that returned by the
   getRawPath method except that all sequences of
   escaped octets are decoded.

  returns: The decoded path component of this URI,
            or null if the path is undefined - `java.lang.String`"
  (^java.lang.String [^java.net.URI this]
    (-> this (.getPath))))

(defn get-query
  "Returns the decoded query component of this URI.

    The string returned by this method is equal to that returned by the
   getRawQuery method except that all sequences of
   escaped octets are decoded.

  returns: The decoded query component of this URI,
            or null if the query is undefined - `java.lang.String`"
  (^java.lang.String [^java.net.URI this]
    (-> this (.getQuery))))

(defn get-raw-authority
  "Returns the raw authority component of this URI.

    The authority component of a URI, if defined, only contains the
   commercial-at character ('@') and characters in the
   unreserved, punct, escaped, and other
   categories.  If the authority is server-based then it is further
   constrained to have valid user-information, host, and port
   components.

  returns: The raw authority component of this URI,
            or null if the authority is undefined - `java.lang.String`"
  (^java.lang.String [^java.net.URI this]
    (-> this (.getRawAuthority))))

(defn get-scheme
  "Returns the scheme component of this URI.

    The scheme component of a URI, if defined, only contains characters
   in the alphanum category and in the string `-.+`.  A
   scheme always starts with an alpha character.

   The scheme component of a URI cannot contain escaped octets, hence this
   method does not perform any decoding.

  returns: The scheme component of this URI,
            or null if the scheme is undefined - `java.lang.String`"
  (^java.lang.String [^java.net.URI this]
    (-> this (.getScheme))))

(defn get-raw-user-info
  "Returns the raw user-information component of this URI.

    The user-information component of a URI, if defined, only contains
   characters in the unreserved, punct, escaped, and
   other categories.

  returns: The raw user-information component of this URI,
            or null if the user information is undefined - `java.lang.String`"
  (^java.lang.String [^java.net.URI this]
    (-> this (.getRawUserInfo))))

(defn parse-server-authority
  "Attempts to parse this URI's authority component, if defined, into
   user-information, host, and port components.

    If this URI's authority component has already been recognized as
   being server-based then it will already have been parsed into
   user-information, host, and port components.  In this case, or if this
   URI has no authority component, this method simply returns this URI.

    Otherwise this method attempts once more to parse the authority
   component into user-information, host, and port components, and throws
   an exception describing why the authority component could not be parsed
   in that way.

    This method is provided because the generic URI syntax specified in
   RFC 2396
   cannot always distinguish a malformed server-based authority from a
   legitimate registry-based authority.  It must therefore treat some
   instances of the former as instances of the latter.  The authority
   component in the URI string `//foo:bar`, for example, is not a
   legal server-based authority but it is legal as a registry-based
   authority.

    In many common situations, for example when working URIs that are
   known to be either URNs or URLs, the hierarchical URIs being used will
   always be server-based.  They therefore must either be parsed as such or
   treated as an error.  In these cases a statement such as


   URI u= new URI(str).parseServerAuthority();


    can be used to ensure that u always refers to a URI that, if
   it has an authority component, has a server-based authority with proper
   user-information, host, and port components.  Invoking this method also
   ensures that if the authority could not be parsed in that way then an
   appropriate diagnostic message can be issued based upon the exception
   that is thrown.

  returns: A URI whose authority field has been parsed
            as a server-based authority - `java.net.URI`

  throws: java.net.URISyntaxException - If the authority component of this URI is defined but cannot be parsed as a server-based authority according to RFC 2396"
  (^java.net.URI [^java.net.URI this]
    (-> this (.parseServerAuthority))))

(defn get-raw-fragment
  "Returns the raw fragment component of this URI.

    The fragment component of a URI, if defined, only contains legal URI
   characters.

  returns: The raw fragment component of this URI,
            or null if the fragment is undefined - `java.lang.String`"
  (^java.lang.String [^java.net.URI this]
    (-> this (.getRawFragment))))

(defn get-port
  "Returns the port number of this URI.

    The port component of a URI, if defined, is a non-negative
   integer.

  returns: The port component of this URI,
            or -1 if the port is undefined - `int`"
  (^Integer [^java.net.URI this]
    (-> this (.getPort))))

(defn hash-code
  "Returns a hash-code value for this URI.  The hash code is based upon all
   of the URI's components, and satisfies the general contract of the
   Object.hashCode method.

  returns: A hash-code value for this URI - `int`"
  (^Integer [^java.net.URI this]
    (-> this (.hashCode))))

(defn get-host
  "Returns the host component of this URI.

    The host component of a URI, if defined, will have one of the
   following forms:



      A domain name consisting of one or more labels
     separated by period characters ('.'), optionally followed by
     a period character.  Each label consists of alphanum characters
     as well as hyphen characters ('-'), though hyphens never
     occur as the first or last characters in a label. The rightmost
     label of a domain name consisting of two or more labels, begins
     with an alpha character.

      A dotted-quad IPv4 address of the form
     digit+.digit+.digit+.digit+,
     where no digit sequence is longer than three characters and no
     sequence has a value larger than 255.

      An IPv6 address enclosed in square brackets ('[' and
     ']') and consisting of hexadecimal digits, colon characters
     (':'), and possibly an embedded IPv4 address.  The full
     syntax of IPv6 addresses is specified in RFC 2373: IPv6
     Addressing Architecture.



   The host component of a URI cannot contain escaped octets, hence this
   method does not perform any decoding.

  returns: The host component of this URI,
            or null if the host is undefined - `java.lang.String`"
  (^java.lang.String [^java.net.URI this]
    (-> this (.getHost))))

(defn compare-to
  "Compares this URI to another object, which must be a URI.

    When comparing corresponding components of two URIs, if one
   component is undefined but the other is defined then the first is
   considered to be less than the second.  Unless otherwise noted, string
   components are ordered according to their natural, case-sensitive
   ordering as defined by the String.compareTo method.  String components that are subject to
   encoding are compared by comparing their raw forms rather than their
   encoded forms.

    The ordering of URIs is defined as follows:



      Two URIs with different schemes are ordered according the
     ordering of their schemes, without regard to case.

      A hierarchical URI is considered to be less than an opaque URI
     with an identical scheme.

      Two opaque URIs with identical schemes are ordered according
     to the ordering of their scheme-specific parts.

      Two opaque URIs with identical schemes and scheme-specific
     parts are ordered according to the ordering of their
     fragments.

      Two hierarchical URIs with identical schemes are ordered
     according to the ordering of their authority components:



        If both authority components are server-based then the URIs
       are ordered according to their user-information components; if these
       components are identical then the URIs are ordered according to the
       ordering of their hosts, without regard to case; if the hosts are
       identical then the URIs are ordered according to the ordering of
       their ports.

        If one or both authority components are registry-based then
       the URIs are ordered according to the ordering of their authority
       components.



      Finally, two hierarchical URIs with identical schemes and
     authority components are ordered according to the ordering of their
     paths; if their paths are identical then they are ordered according to
     the ordering of their queries; if the queries are identical then they
     are ordered according to the order of their fragments.



    This method satisfies the general contract of the Comparable.compareTo
   method.

  that - The object to which this URI is to be compared - `java.net.URI`

  returns: A negative integer, zero, or a positive integer as this URI is
            less than, equal to, or greater than the given URI - `int`

  throws: java.lang.ClassCastException - If the given object is not a URI"
  (^Integer [^java.net.URI this ^java.net.URI that]
    (-> this (.compareTo that))))

(defn get-raw-scheme-specific-part
  "Returns the raw scheme-specific part of this URI.  The scheme-specific
   part is never undefined, though it may be empty.

    The scheme-specific part of a URI only contains legal URI
   characters.

  returns: The raw scheme-specific part of this URI
            (never null) - `java.lang.String`"
  (^java.lang.String [^java.net.URI this]
    (-> this (.getRawSchemeSpecificPart))))

(defn relativize
  "Relativizes the given URI against this URI.

    The relativization of the given URI against this URI is computed as
   follows:



      If either this URI or the given URI are opaque, or if the
     scheme and authority components of the two URIs are not identical, or
     if the path of this URI is not a prefix of the path of the given URI,
     then the given URI is returned.

      Otherwise a new relative hierarchical URI is constructed with
     query and fragment components taken from the given URI and with a path
     component computed by removing this URI's path from the beginning of
     the given URI's path.

  uri - The URI to be relativized against this URI - `java.net.URI`

  returns: The resulting URI - `java.net.URI`

  throws: java.lang.NullPointerException - If uri is null"
  (^java.net.URI [^java.net.URI this ^java.net.URI uri]
    (-> this (.relativize uri))))

(defn equals
  "Tests this URI for equality with another object.

    If the given object is not a URI then this method immediately
   returns false.

    For two URIs to be considered equal requires that either both are
   opaque or both are hierarchical.  Their schemes must either both be
   undefined or else be equal without regard to case. Their fragments
   must either both be undefined or else be equal.

    For two opaque URIs to be considered equal, their scheme-specific
   parts must be equal.

    For two hierarchical URIs to be considered equal, their paths must
   be equal and their queries must either both be undefined or else be
   equal.  Their authorities must either both be undefined, or both be
   registry-based, or both be server-based.  If their authorities are
   defined and are registry-based, then they must be equal.  If their
   authorities are defined and are server-based, then their hosts must be
   equal without regard to case, their port numbers must be equal, and
   their user-information components must be equal.

    When testing the user-information, path, query, fragment, authority,
   or scheme-specific parts of two URIs for equality, the raw forms rather
   than the encoded forms of these components are compared and the
   hexadecimal digits of escaped octets are compared without regard to
   case.

    This method satisfies the general contract of the Object.equals method.

  ob - The object to which this object is to be compared - `java.lang.Object`

  returns: true if, and only if, the given object is a URI that
            is identical to this URI - `boolean`"
  (^Boolean [^java.net.URI this ^java.lang.Object ob]
    (-> this (.equals ob))))

(defn to-url
  "Constructs a URL from this URI.

    This convenience method works as if invoking it were equivalent to
   evaluating the expression new URL(this.toString()) after
   first checking that this URI is absolute.

  returns: A URL constructed from this URI - `java.net.URL`

  throws: java.lang.IllegalArgumentException - If this URL is not absolute"
  (^java.net.URL [^java.net.URI this]
    (-> this (.toURL))))

(defn absolute?
  "Tells whether or not this URI is absolute.

    A URI is absolute if, and only if, it has a scheme component.

  returns: true if, and only if, this URI is absolute - `boolean`"
  (^Boolean [^java.net.URI this]
    (-> this (.isAbsolute))))

