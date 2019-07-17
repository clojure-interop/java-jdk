(ns jdk.security.KeyStore$CallbackHandlerProtection
  "A ProtectionParameter encapsulating a CallbackHandler."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security KeyStore$CallbackHandlerProtection]))

(defn ->callback-handler-protection
  "Constructor.

  Constructs a new CallbackHandlerProtection from a
   CallbackHandler.

  handler - the CallbackHandler - `javax.security.auth.callback.CallbackHandler`

  throws: java.lang.NullPointerException - if handler is null"
  ([handler]
    (new KeyStore$CallbackHandlerProtection handler)))

(defn get-callback-handler
  "Returns the CallbackHandler.

  returns: the CallbackHandler. - `javax.security.auth.callback.CallbackHandler`"
  ([this]
    (-> this (.getCallbackHandler))))

