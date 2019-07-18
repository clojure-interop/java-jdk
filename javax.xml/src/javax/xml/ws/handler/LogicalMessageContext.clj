(ns javax.xml.ws.handler.LogicalMessageContext
  "The LogicalMessageContext interface extends
   MessageContext to
   provide access to a the contained message as a protocol neutral
   LogicalMessage"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws.handler LogicalMessageContext]))

(defn get-message
  "Gets the message from this message context

  returns: The contained message; returns null if no
            message is present in this message context - `javax.xml.ws.LogicalMessage`"
  (^javax.xml.ws.LogicalMessage [^LogicalMessageContext this]
    (-> this (.getMessage))))

