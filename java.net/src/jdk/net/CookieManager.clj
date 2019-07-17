(ns jdk.net.CookieManager
  "CookieManager provides a concrete implementation of CookieHandler,
  which separates the storage of cookies from the policy surrounding accepting
  and rejecting cookies. A CookieManager is initialized with a CookieStore
  which manages storage, and a CookiePolicy object, which makes
  policy decisions on cookie acceptance/rejection.

   The HTTP cookie management in java.net package looks like:



                   use
  CookieHandler <------- HttpURLConnection
        ^
        | impl
        |         use
  CookieManager -------> CookiePolicy
              |   use
              |--------> HttpCookie
              |              ^
              |              | use
              |   use        |
              |--------> CookieStore
                             ^
                             | impl
                             |
                   Internal in-memory implementation


      CookieHandler is at the core of cookie management. User can call
      CookieHandler.setDefault to set a concrete CookieHanlder implementation
      to be used.


      CookiePolicy.shouldAccept will be called by CookieManager.put to see whether
      or not one cookie should be accepted and put into cookie store. User can use
      any of three pre-defined CookiePolicy, namely ACCEPT_ALL, ACCEPT_NONE and
      ACCEPT_ORIGINAL_SERVER, or user can define his own CookiePolicy implementation
      and tell CookieManager to use it.


      CookieStore is the place where any accepted HTTP cookie is stored in.
      If not specified when created, a CookieManager instance will use an internal
      in-memory implementation. Or user can implements one and tell CookieManager
      to use it.


      Currently, only CookieStore.add(URI, HttpCookie) and CookieStore.get(URI)
      are used by CookieManager. Others are for completeness and might be needed
      by a more sophisticated CookieStore implementation, e.g. a NetscapeCookieSotre.




  There're various ways user can hook up his own HTTP cookie management behavior, e.g.


    Use CookieHandler.setDefault to set a brand new CookieHandler implementation
    Let CookieManager be the default CookieHandler implementation,
        but implement user's own CookieStore and CookiePolicy
        and tell default CookieManager to use them:


        // this should be done at the beginning of an HTTP session
        CookieHandler.setDefault(new CookieManager(new MyCookieStore(), new MyCookiePolicy()));
    Let CookieManager be the default CookieHandler implementation, but
        use customized CookiePolicy:


        // this should be done at the beginning of an HTTP session
        CookieHandler.setDefault(new CookieManager());
        // this can be done at any point of an HTTP session
        ((CookieManager)CookieHandler.getDefault()).setCookiePolicy(new MyCookiePolicy());



  The implementation conforms to RFC 2965, section 3.3."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net CookieManager]))

(defn ->cookie-manager
  "Constructor.

  Create a new cookie manager with specified cookie store and cookie policy.

  store - a CookieStore to be used by cookie manager. if null, cookie manager will use a default one, which is an in-memory CookieStore implementation. - `java.net.CookieStore`
  cookie-policy - a CookiePolicy instance to be used by cookie manager as policy callback. if null, ACCEPT_ORIGINAL_SERVER will be used. - `java.net.CookiePolicy`"
  ([^java.net.CookieStore store ^java.net.CookiePolicy cookie-policy]
    (new CookieManager store cookie-policy))
  ([]
    (new CookieManager )))

(defn set-cookie-policy
  "To set the cookie policy of this cookie manager.

    A instance of CookieManager will have
   cookie policy ACCEPT_ORIGINAL_SERVER by default. Users always
   can call this method to set another cookie policy.

  cookie-policy - the cookie policy. Can be null, which has no effects on current cookie policy. - `java.net.CookiePolicy`"
  ([^java.net.CookieManager this ^java.net.CookiePolicy cookie-policy]
    (-> this (.setCookiePolicy cookie-policy))))

(defn get-cookie-store
  "To retrieve current cookie store.

  returns: the cookie store currently used by cookie manager. - `java.net.CookieStore`"
  ([^java.net.CookieManager this]
    (-> this (.getCookieStore))))

(defn get
  "Description copied from class: CookieHandler

  uri - a URI representing the intended use for the cookies - `java.net.URI`
  request-headers - - a Map from request header field names to lists of field values representing the current request headers - `java.util.Map<java.lang.String,java.util.List<java.lang.String>>`

  returns: an immutable map from state management headers, with
              field names `Cookie` or `Cookie2` to a list of
              cookies containing state information - `java.util.Map<java.lang.String,java.util.List<java.lang.String>>`

  throws: java.io.IOException - if an I/O error occurs"
  ([^java.net.CookieManager this ^java.net.URI uri ^java.util.Map> request-headers]
    (-> this (.get uri request-headers))))

(defn put
  "Description copied from class: CookieHandler

  uri - a URI where the cookies come from - `java.net.URI`
  response-headers - an immutable map from field names to lists of field values representing the response header fields returned - `java.util.Map<java.lang.String,java.util.List<java.lang.String>>`

  throws: java.io.IOException - if an I/O error occurs"
  ([^java.net.CookieManager this ^java.net.URI uri ^java.util.Map> response-headers]
    (-> this (.put uri response-headers))))

