(ns javax.xml.ws.http.HTTPException
  "The HTTPException exception represents a
   XML/HTTP fault.

   Since there is no standard format for faults or exceptions
   in XML/HTTP messaging, only the HTTP status code is captured."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws.http HTTPException]))

(defn ->http-exception
  "Constructor.

  Constructor for the HTTPException

  status-code - int for the HTTP status code - `int`"
  (^HTTPException [^Integer status-code]
    (new HTTPException status-code)))

(defn get-status-code
  "Gets the HTTP status code.

  returns: HTTP status code - `int`"
  (^Integer [^HTTPException this]
    (-> this (.getStatusCode))))

