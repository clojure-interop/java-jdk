(ns javax.xml.ws.AsyncHandler
  "The AsyncHandler interface is implemented by
  clients that wish to receive callback notification of the completion of
  service endpoint operations invoked asynchronously."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws AsyncHandler]))

(defn handle-response
  "Called when the response to an asynchronous operation is available.

  res - The response to the operation invocation. - `javax.xml.ws.Response<AsyncHandler.T>`"
  ([this res]
    (-> this (.handleResponse res))))

