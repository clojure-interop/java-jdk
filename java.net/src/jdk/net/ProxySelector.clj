(ns jdk.net.ProxySelector
  "Selects the proxy server to use, if any, when connecting to the
  network resource referenced by a URL. A proxy selector is a
  concrete sub-class of this class and is registered by invoking the
  setDefault method. The
  currently registered proxy selector can be retrieved by calling
  getDefault method.

   When a proxy selector is registered, for instance, a subclass
  of URLConnection class should call the select
  method for each URL request so that the proxy selector can decide
  if a direct, or proxied connection should be used. The select method returns an iterator over a collection with
  the preferred connection approach.

   If a connection cannot be established to a proxy (PROXY or
  SOCKS) servers then the caller should call the proxy selector's
  connectFailed method to notify the proxy
  selector that the proxy server is unavailable.

  The default proxy selector does enforce a
  set of System Properties
  related to proxy settings."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net ProxySelector]))

(defn ->proxy-selector
  "Constructor."
  ([]
    (new ProxySelector )))

(defn *get-default
  "Gets the system-wide proxy selector.

  returns: the system-wide ProxySelector - `java.net.ProxySelector`

  throws: java.lang.SecurityException - If a security manager has been installed and it denies NetPermission(`getProxySelector`)"
  ([]
    (ProxySelector/getDefault )))

(defn *set-default
  "Sets (or unsets) the system-wide proxy selector.

   Note: non-standard protocol handlers may ignore this setting.

  ps - The HTTP proxy selector, or null to unset the proxy selector. - `java.net.ProxySelector`

  throws: java.lang.SecurityException - If a security manager has been installed and it denies NetPermission(`setProxySelector`)"
  ([^java.net.ProxySelector ps]
    (ProxySelector/setDefault ps)))

(defn select
  "Selects all the applicable proxies based on the protocol to
   access the resource with and a destination address to access
   the resource at.
   The format of the URI is defined as follow:

   http URI for http connections
   https URI for https connections
   socket://host:port
       for tcp client sockets connections

  uri - The URI that a connection is required to - `java.net.URI`

  returns: a List of Proxies. Each element in the
            the List is of type
            Proxy;
            when no proxy is available, the list will
            contain one element of type
            Proxy
            that represents a direct connection. - `java.util.List<java.net.Proxy>`

  throws: java.lang.IllegalArgumentException - if the argument is null"
  ([^java.net.ProxySelector this ^java.net.URI uri]
    (-> this (.select uri))))

(defn connect-failed
  "Called to indicate that a connection could not be established
   to a proxy/socks server. An implementation of this method can
   temporarily remove the proxies or reorder the sequence of
   proxies returned by select(URI), using the address
   and the IOException caught when trying to connect.

  uri - The URI that the proxy at sa failed to serve. - `java.net.URI`
  sa - The socket address of the proxy/SOCKS server - `java.net.SocketAddress`
  ioe - The I/O exception thrown when the connect failed. - `java.io.IOException`

  throws: java.lang.IllegalArgumentException - if either argument is null"
  ([^java.net.ProxySelector this ^java.net.URI uri ^java.net.SocketAddress sa ^java.io.IOException ioe]
    (-> this (.connectFailed uri sa ioe))))

