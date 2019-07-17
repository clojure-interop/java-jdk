(ns jdk.net.CacheRequest
  "Represents channels for storing resources in the
  ResponseCache. Instances of such a class provide an
  OutputStream object which is called by protocol handlers to
  store the resource data into the cache, and also an abort() method
  which allows a cache store operation to be interrupted and
  abandoned. If an IOException is encountered while reading the
  response or writing to the cache, the current cache store operation
  will be aborted."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net CacheRequest]))

(defn ->cache-request
  "Constructor."
  ([]
    (new CacheRequest )))

(defn get-body
  "Returns an OutputStream to which the response body can be
   written.

  returns: an OutputStream to which the response body can
           be written - `java.io.OutputStream`

  throws: java.io.IOException - if an I/O error occurs while writing the response body"
  ([^java.net.CacheRequest this]
    (-> this (.getBody))))

(defn abort
  "Aborts the attempt to cache the response. If an IOException is
   encountered while reading the response or writing to the cache,
   the current cache store operation will be abandoned."
  ([^java.net.CacheRequest this]
    (-> this (.abort))))

