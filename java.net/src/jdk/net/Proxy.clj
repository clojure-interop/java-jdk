(ns jdk.net.Proxy
  "This class represents a proxy setting, typically a type (http, socks) and
  a socket address.
  A Proxy is an immutable object."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net Proxy]))

(defn ->proxy
  "Constructor.

  Creates an entry representing a PROXY connection.
   Certain combinations are illegal. For instance, for types Http, and
   Socks, a SocketAddress must be provided.

   Use the Proxy.NO_PROXY constant
   for representing a direct connection.

  type - the Type of the proxy - `java.net.Proxy.Type`
  sa - the SocketAddress for that proxy - `java.net.SocketAddress`

  throws: java.lang.IllegalArgumentException - when the type and the address are incompatible"
  ([type sa]
    (new Proxy type sa)))

(def *-no-proxy
  "Static Constant.

  A proxy setting that represents a DIRECT connection,
   basically telling the protocol handler not to use any proxying.
   Used, for instance, to create sockets bypassing any other global
   proxy settings (like SOCKS):

   Socket s = new Socket(Proxy.NO_PROXY);

  type: java.net.Proxy"
  Proxy/NO_PROXY)

(defn type
  "Returns the proxy type.

  returns: a Type representing the proxy type - `java.net.Proxy.Type`"
  ([this]
    (-> this (.type))))

(defn address
  "Returns the socket address of the proxy, or
   null if its a direct connection.

  returns: a SocketAddress representing the socket end
           point of the proxy - `java.net.SocketAddress`"
  ([this]
    (-> this (.address))))

(defn to-string
  "Constructs a string representation of this Proxy.
   This String is constructed by calling toString() on its type
   and concatenating ` @ ` and the toString() result from its address
   if its type is not DIRECT.

  returns: a string representation of this object. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn equals
  "Compares this object against the specified object.
   The result is true if and only if the argument is
   not null and it represents the same proxy as
   this object.

   Two instances of Proxy represent the same
   address if both the SocketAddresses and type are equal.

  obj - the object to compare against. - `java.lang.Object`

  returns: true if the objects are the same;
            false otherwise. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns a hashcode for this Proxy.

  returns: a hash code value for this Proxy. - `int`"
  ([this]
    (-> this (.hashCode))))

