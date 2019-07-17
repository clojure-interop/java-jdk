(ns javax.net.ssl.HandshakeCompletedListener
  "This interface is implemented by any class which wants to receive
  notifications about the completion of an SSL protocol handshake
  on a given SSL connection.

   When an SSL handshake completes, new security parameters will
  have been established.  Those parameters always include the security
  keys used to protect messages.  They may also include parameters
  associated with a new session such as authenticated
  peer identity and a new SSL cipher suite."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl HandshakeCompletedListener]))

(defn handshake-completed
  "This method is invoked on registered objects
   when a SSL handshake is completed.

  event - the event identifying when the SSL Handshake completed on a given SSL connection - `javax.net.ssl.HandshakeCompletedEvent`"
  ([this event]
    (-> this (.handshakeCompleted event))))

