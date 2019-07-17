(ns javax.xml.ws.Response
  "The Response interface provides methods used to obtain the
   payload and context of a message sent in response to an operation
   invocation.

   For asynchronous operation invocations it provides additional methods
   to check the status of the request. The get(...) methods may
   throw the standard
   set of exceptions and their cause may be a RemoteException or a
   WebServiceException that represents the error that occured during the
   asynchronous method invocation."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws Response]))

(defn get-context
  "Gets the contained response context.

  returns: The contained response context. May be null if a
   response is not yet available. - `java.util.Map<java.lang.String,java.lang.Object>`"
  ([^. this]
    (-> this (.getContext))))

