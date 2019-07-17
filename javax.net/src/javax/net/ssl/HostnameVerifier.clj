(ns javax.net.ssl.HostnameVerifier
  "This class is the base interface for hostname verification.

  During handshaking, if the URL's hostname and
  the server's identification hostname mismatch, the
  verification mechanism can call back to implementers of this
  interface to determine if this connection should be allowed.

  The policies can be certificate-based
  or may depend on other authentication schemes.

  These callbacks are used when the default rules for URL hostname
  verification fail."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl HostnameVerifier]))

(defn verify
  "Verify that the host name is an acceptable match with
   the server's authentication scheme.

  hostname - the host name - `java.lang.String`
  session - SSLSession used on the connection to host - `javax.net.ssl.SSLSession`

  returns: true if the host name is acceptable - `boolean`"
  (^Boolean [^javax.net.ssl.HostnameVerifier this ^java.lang.String hostname ^javax.net.ssl.SSLSession session]
    (-> this (.verify hostname session))))

