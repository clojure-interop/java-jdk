(ns javax.security.auth.callback.UnsupportedCallbackException
  "Signals that a CallbackHandler does not
  recognize a particular Callback."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.callback UnsupportedCallbackException]))

(defn ->unsupported-callback-exception
  "Constructor.

  Constructs a UnsupportedCallbackException with the specified detail
   message.  A detail message is a String that describes this particular
   exception.

  callback - the unrecognized Callback. - `javax.security.auth.callback.Callback`
  msg - the detail message. - `java.lang.String`"
  ([callback msg]
    (new UnsupportedCallbackException callback msg))
  ([callback]
    (new UnsupportedCallbackException callback)))

(defn get-callback
  "Get the unrecognized Callback.

  returns: the unrecognized Callback. - `javax.security.auth.callback.Callback`"
  ([this]
    (-> this (.getCallback))))

