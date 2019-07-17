(ns javax.net.ssl.SNIMatcher
  "Instances of this class represent a matcher that performs match
  operations on an SNIServerName instance.

  Servers can use Server Name Indication (SNI) information to decide if
  specific SSLSocket or SSLEngine instances should accept
  a connection.  For example, when multiple `virtual` or `name-based`
  servers are hosted on a single underlying network address, the server
  application can use SNI information to determine whether this server is
  the exact server that the client wants to access.  Instances of this
  class can be used by a server to verify the acceptable server names of
  a particular type, such as host names.

  SNIMatcher objects are immutable.  Subclasses should not provide
  methods that can change the state of an instance once it has been created."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl SNIMatcher]))

(defn get-type
  "Returns the server name type of this SNIMatcher object.

  returns: the server name type of this SNIMatcher object. - `int`"
  (^Integer [^javax.net.ssl.SNIMatcher this]
    (-> this (.getType))))

(defn matches
  "Attempts to match the given SNIServerName.

  server-name - the SNIServerName instance on which this matcher performs match operations - `javax.net.ssl.SNIServerName`

  returns: true if, and only if, the matcher matches the
           given serverName - `boolean`

  throws: java.lang.NullPointerException - if serverName is null"
  (^Boolean [^javax.net.ssl.SNIMatcher this ^javax.net.ssl.SNIServerName server-name]
    (-> this (.matches server-name))))

