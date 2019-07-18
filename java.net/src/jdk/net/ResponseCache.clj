(ns jdk.net.ResponseCache
  "Represents implementations of URLConnection caches. An instance of
  such a class can be registered with the system by doing
  ResponseCache.setDefault(ResponseCache), and the system will call
  this object in order to:

     store resource data which has been retrieved from an
             external source into the cache
          try to fetch a requested resource that may have been
             stored in the cache


  The ResponseCache implementation decides which resources
  should be cached, and for how long they should be cached. If a
  request resource cannot be retrieved from the cache, then the
  protocol handlers will fetch the resource from its original
  location.

  The settings for URLConnection#useCaches controls whether the
  protocol is allowed to use a cached response.

  For more information on HTTP caching, see RFC 2616: Hypertext
  Transfer Protocol -- HTTP/1.1"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net ResponseCache]))

(defn ->response-cache
  "Constructor."
  (^ResponseCache []
    (new ResponseCache )))

(defn *get-default
  "Gets the system-wide response cache.

  returns: the system-wide ResponseCache - `java.net.ResponseCache`

  throws: java.lang.SecurityException - If a security manager has been installed and it denies NetPermission(`getResponseCache`)"
  (^java.net.ResponseCache []
    (ResponseCache/getDefault )))

(defn *set-default
  "Sets (or unsets) the system-wide cache.

   Note: non-standard procotol handlers may ignore this setting.

  response-cache - The response cache, or null to unset the cache. - `java.net.ResponseCache`

  throws: java.lang.SecurityException - If a security manager has been installed and it denies NetPermission(`setResponseCache`)"
  ([^java.net.ResponseCache response-cache]
    (ResponseCache/setDefault response-cache)))

(defn get
  "Retrieve the cached response based on the requesting uri,
   request method and request headers. Typically this method is
   called by the protocol handler before it sends out the request
   to get the network resource. If a cached response is returned,
   that resource is used instead.

  uri - a URI used to reference the requested network resource - `java.net.URI`
  rqst-method - a String representing the request method - `java.lang.String`
  rqst-headers - - a Map from request header field names to lists of field values representing the current request headers - `java.util.Map`

  returns: a CacheResponse instance if available
            from cache, or null otherwise - `java.net.CacheResponse`

  throws: java.io.IOException - if an I/O error occurs"
  (^java.net.CacheResponse [^ResponseCache this ^java.net.URI uri ^java.lang.String rqst-method ^java.util.Map rqst-headers]
    (-> this (.get uri rqst-method rqst-headers))))

(defn put
  "The protocol handler calls this method after a resource has
   been retrieved, and the ResponseCache must decide whether or
   not to store the resource in its cache. If the resource is to
   be cached, then put() must return a CacheRequest object which
   contains an OutputStream that the protocol handler will
   use to write the resource into the cache. If the resource is
   not to be cached, then put must return null.

  uri - a URI used to reference the requested network resource - `java.net.URI`
  conn - - a URLConnection instance that is used to fetch the response to be cached - `java.net.URLConnection`

  returns: a CacheRequest for recording the
              response to be cached. Null return indicates that
              the caller does not intend to cache the response. - `java.net.CacheRequest`

  throws: java.io.IOException - if an I/O error occurs"
  (^java.net.CacheRequest [^ResponseCache this ^java.net.URI uri ^java.net.URLConnection conn]
    (-> this (.put uri conn))))

