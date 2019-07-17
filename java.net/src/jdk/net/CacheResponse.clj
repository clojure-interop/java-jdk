(ns jdk.net.CacheResponse
  "Represent channels for retrieving resources from the
  ResponseCache. Instances of such a class provide an
  InputStream that returns the entity body, and also a
  getHeaders() method which returns the associated response headers."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net CacheResponse]))

(defn ->cache-response
  "Constructor."
  ([]
    (new CacheResponse )))

(defn get-headers
  "Returns the response headers as a Map.

  returns: An immutable Map from response header field names to
           lists of field values. The status line has null as its
           field name. - `java.util.Map<java.lang.String,java.util.List<java.lang.String>>`

  throws: java.io.IOException - if an I/O error occurs while getting the response headers"
  (^java.util.Map> [^java.net.CacheResponse this]
    (-> this (.getHeaders))))

(defn get-body
  "Returns the response body as an InputStream.

  returns: an InputStream from which the response body can
           be accessed - `java.io.InputStream`

  throws: java.io.IOException - if an I/O error occurs while getting the response body"
  (^java.io.InputStream [^java.net.CacheResponse this]
    (-> this (.getBody))))

