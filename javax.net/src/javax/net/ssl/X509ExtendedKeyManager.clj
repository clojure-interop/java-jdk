(ns javax.net.ssl.X509ExtendedKeyManager
  "Abstract class that provides for extension of the X509KeyManager
  interface.

  Methods in this class should be overriden to provide actual
  implementations."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl X509ExtendedKeyManager]))

(defn choose-engine-client-alias
  "Choose an alias to authenticate the client side of an
   SSLEngine connection given the public key type
   and the list of certificate issuer authorities recognized by
   the peer (if any).

   The default implementation returns null.

  key-type - the key algorithm type name(s), ordered with the most-preferred key type first. - `java.lang.String[]`
  issuers - the list of acceptable CA issuer subject names or null if it does not matter which issuers are used. - `java.security.Principal[]`
  engine - the SSLEngine to be used for this connection. This parameter can be null, which indicates that implementations of this interface are free to select an alias applicable to any engine. - `javax.net.ssl.SSLEngine`

  returns: the alias name for the desired key, or null if there
            are no matches. - `java.lang.String`"
  (^java.lang.String [^javax.net.ssl.X509ExtendedKeyManager this key-type issuers ^javax.net.ssl.SSLEngine engine]
    (-> this (.chooseEngineClientAlias key-type issuers engine))))

(defn choose-engine-server-alias
  "Choose an alias to authenticate the server side of an
   SSLEngine connection given the public key type
   and the list of certificate issuer authorities recognized by
   the peer (if any).

   The default implementation returns null.

  key-type - the key algorithm type name. - `java.lang.String`
  issuers - the list of acceptable CA issuer subject names or null if it does not matter which issuers are used. - `java.security.Principal[]`
  engine - the SSLEngine to be used for this connection. This parameter can be null, which indicates that implementations of this interface are free to select an alias applicable to any engine. - `javax.net.ssl.SSLEngine`

  returns: the alias name for the desired key, or null if there
            are no matches. - `java.lang.String`"
  (^java.lang.String [^javax.net.ssl.X509ExtendedKeyManager this ^java.lang.String key-type issuers ^javax.net.ssl.SSLEngine engine]
    (-> this (.chooseEngineServerAlias key-type issuers engine))))

