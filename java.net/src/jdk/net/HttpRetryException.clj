(ns jdk.net.HttpRetryException
  "Thrown to indicate that a HTTP request needs to be retried
  but cannot be retried automatically, due to streaming mode
  being enabled."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net HttpRetryException]))

(defn ->http-retry-exception
  "Constructor.

  Constructs a new HttpRetryException with detail message
   responseCode and the contents of the Location response header field.

  detail - the detail message. - `java.lang.String`
  code - the HTTP response code from server. - `int`
  location - the URL to be redirected to - `java.lang.String`"
  ([detail code location]
    (new HttpRetryException detail code location))
  ([detail code]
    (new HttpRetryException detail code)))

(defn response-code
  "Returns the http response code

  returns: The http response code. - `int`"
  ([this]
    (-> this (.responseCode))))

(defn get-reason
  "Returns a string explaining why the http request could
   not be retried.

  returns: The reason string - `java.lang.String`"
  ([this]
    (-> this (.getReason))))

(defn get-location
  "Returns the value of the Location header field if the
   error resulted from redirection.

  returns: The location string - `java.lang.String`"
  ([this]
    (-> this (.getLocation))))

