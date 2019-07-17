(ns jdk.net.CookieStore
  "A CookieStore object represents a storage for cookie. Can store and retrieve
  cookies.

  CookieManager will call CookieStore.add to save cookies
  for every incoming HTTP response, and call CookieStore.get to
  retrieve cookie for every outgoing HTTP request. A CookieStore
  is responsible for removing HttpCookie instances which have expired."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net CookieStore]))

(defn add
  "Adds one HTTP cookie to the store. This is called for every
   incoming HTTP response.

   A cookie to store may or may not be associated with an URI. If it
   is not associated with an URI, the cookie's domain and path attribute
   will indicate where it comes from. If it is associated with an URI and
   its domain and path attribute are not specified, given URI will indicate
   where this cookie comes from.

   If a cookie corresponding to the given URI already exists,
   then it is replaced with the new one.

  uri - the uri this cookie associated with. if null, this cookie will not be associated with an URI - `java.net.URI`
  cookie - the cookie to store - `java.net.HttpCookie`

  throws: java.lang.NullPointerException - if cookie is null"
  ([^java.net.CookieStore this ^java.net.URI uri ^java.net.HttpCookie cookie]
    (-> this (.add uri cookie))))

(defn get
  "Retrieve cookies associated with given URI, or whose domain matches the
   given URI. Only cookies that have not expired are returned.
   This is called for every outgoing HTTP request.

  uri - the uri associated with the cookies to be returned - `java.net.URI`

  returns: an immutable list of HttpCookie,
                    return empty list if no cookies match the given URI - `java.util.List<java.net.HttpCookie>`

  throws: java.lang.NullPointerException - if uri is null"
  (^java.util.List [^java.net.CookieStore this ^java.net.URI uri]
    (-> this (.get uri))))

(defn get-cookies
  "Get all not-expired cookies in cookie store.

  returns: an immutable list of http cookies;
                    return empty list if there's no http cookie in store - `java.util.List<java.net.HttpCookie>`"
  (^java.util.List [^java.net.CookieStore this]
    (-> this (.getCookies))))

(defn get-ur-is
  "Get all URIs which identify the cookies in this cookie store.

  returns: an immutable list of URIs;
                    return empty list if no cookie in this cookie store
                    is associated with an URI - `java.util.List<java.net.URI>`"
  (^java.util.List [^java.net.CookieStore this]
    (-> this (.getURIs))))

(defn remove
  "Remove a cookie from store.

  uri - the uri this cookie associated with. if null, the cookie to be removed is not associated with an URI when added; if not null, the cookie to be removed is associated with the given URI when added. - `java.net.URI`
  cookie - the cookie to remove - `java.net.HttpCookie`

  returns: true if this store contained the specified cookie - `boolean`

  throws: java.lang.NullPointerException - if cookie is null"
  (^Boolean [^java.net.CookieStore this ^java.net.URI uri ^java.net.HttpCookie cookie]
    (-> this (.remove uri cookie))))

(defn remove-all
  "Remove all cookies in this cookie store.

  returns: true if this store changed as a result of the call - `boolean`"
  (^Boolean [^java.net.CookieStore this]
    (-> this (.removeAll))))

