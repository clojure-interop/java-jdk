(ns javax.xml.ws.ProtocolException
  "The ProtocolException class is a
   base class for exceptions related to a specific protocol binding. Subclasses
   are used to communicate protocol level fault information to clients and may
   be used on the server to control the protocol specific fault representation."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws ProtocolException]))

(defn ->protocol-exception
  "Constructor.

  Constructs a new runtime exception with the specified detail message and
   cause.

   Note that the detail message associated with  cause is not automatically
   incorporated in  this runtime exception's detail message.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  ([message cause]
    (new ProtocolException message cause))
  ([message]
    (new ProtocolException message))
  ([]
    (new ProtocolException )))

