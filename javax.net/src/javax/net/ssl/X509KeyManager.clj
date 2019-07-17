(ns javax.net.ssl.X509KeyManager
  "Instances of this interface manage which X509 certificate-based
  key pairs are used to authenticate the local side of a secure
  socket.

  During secure socket negotiations, implentations
  call methods in this interface to:

   determine the set of aliases that are available for negotiations
       based on the criteria presented,
   select the  best alias based on
       the criteria presented, and
   obtain the corresponding key material for given aliases.


  Note: the X509ExtendedKeyManager should be used in favor of this
  class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl X509KeyManager]))

(defn get-client-aliases
  "Get the matching aliases for authenticating the client side of a secure
   socket given the public key type and the list of
   certificate issuer authorities recognized by the peer (if any).

  key-type - the key algorithm type name - `java.lang.String`
  issuers - the list of acceptable CA issuer subject names, or null if it does not matter which issuers are used. - `java.security.Principal[]`

  returns: an array of the matching alias names, or null if there
            were no matches. - `java.lang.String[]`"
  ([^javax.net.ssl.X509KeyManager this ^java.lang.String key-type issuers]
    (-> this (.getClientAliases key-type issuers))))

(defn choose-client-alias
  "Choose an alias to authenticate the client side of a secure
   socket given the public key type and the list of
   certificate issuer authorities recognized by the peer (if any).

  key-type - the key algorithm type name(s), ordered with the most-preferred key type first. - `java.lang.String[]`
  issuers - the list of acceptable CA issuer subject names or null if it does not matter which issuers are used. - `java.security.Principal[]`
  socket - the socket to be used for this connection. This parameter can be null, which indicates that implementations are free to select an alias applicable to any socket. - `java.net.Socket`

  returns: the alias name for the desired key, or null if there
            are no matches. - `java.lang.String`"
  (^java.lang.String [^javax.net.ssl.X509KeyManager this key-type issuers ^java.net.Socket socket]
    (-> this (.chooseClientAlias key-type issuers socket))))

(defn get-server-aliases
  "Get the matching aliases for authenticating the server side of a secure
   socket given the public key type and the list of
   certificate issuer authorities recognized by the peer (if any).

  key-type - the key algorithm type name - `java.lang.String`
  issuers - the list of acceptable CA issuer subject names or null if it does not matter which issuers are used. - `java.security.Principal[]`

  returns: an array of the matching alias names, or null
            if there were no matches. - `java.lang.String[]`"
  ([^javax.net.ssl.X509KeyManager this ^java.lang.String key-type issuers]
    (-> this (.getServerAliases key-type issuers))))

(defn choose-server-alias
  "Choose an alias to authenticate the server side of a secure
   socket given the public key type and the list of
   certificate issuer authorities recognized by the peer (if any).

  key-type - the key algorithm type name. - `java.lang.String`
  issuers - the list of acceptable CA issuer subject names or null if it does not matter which issuers are used. - `java.security.Principal[]`
  socket - the socket to be used for this connection. This parameter can be null, which indicates that implementations are free to select an alias applicable to any socket. - `java.net.Socket`

  returns: the alias name for the desired key, or null if there
            are no matches. - `java.lang.String`"
  (^java.lang.String [^javax.net.ssl.X509KeyManager this ^java.lang.String key-type issuers ^java.net.Socket socket]
    (-> this (.chooseServerAlias key-type issuers socket))))

(defn get-certificate-chain
  "Returns the certificate chain associated with the given alias.

  alias - the alias name - `java.lang.String`

  returns: the certificate chain (ordered with the user's certificate first
            and the root certificate authority last), or null
            if the alias can't be found. - `java.security.cert.X509Certificate[]`"
  ([^javax.net.ssl.X509KeyManager this ^java.lang.String alias]
    (-> this (.getCertificateChain alias))))

(defn get-private-key
  "Returns the key associated with the given alias.

  alias - the alias name - `java.lang.String`

  returns: the requested key, or null if the alias can't be found. - `java.security.PrivateKey`"
  (^java.security.PrivateKey [^javax.net.ssl.X509KeyManager this ^java.lang.String alias]
    (-> this (.getPrivateKey alias))))

