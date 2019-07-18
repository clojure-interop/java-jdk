(ns jdk.net.URLStreamHandlerFactory
  "This interface defines a factory for URL stream
  protocol handlers.

  It is used by the URL class to create a
  URLStreamHandler for a specific protocol."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net URLStreamHandlerFactory]))

(defn create-url-stream-handler
  "Creates a new URLStreamHandler instance with the specified
   protocol.

  protocol - the protocol (`ftp`, `http`, `nntp`, etc.). - `java.lang.String`

  returns: a URLStreamHandler for the specific protocol. - `java.net.URLStreamHandler`"
  (^java.net.URLStreamHandler [^URLStreamHandlerFactory this ^java.lang.String protocol]
    (-> this (.createURLStreamHandler protocol))))

