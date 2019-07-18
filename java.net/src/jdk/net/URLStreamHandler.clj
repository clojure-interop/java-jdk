(ns jdk.net.URLStreamHandler
  "The abstract class URLStreamHandler is the common
  superclass for all stream protocol handlers. A stream protocol
  handler knows how to make a connection for a particular protocol
  type, such as http or https.

  In most cases, an instance of a URLStreamHandler
  subclass is not created directly by an application. Rather, the
  first time a protocol name is encountered when constructing a
  URL, the appropriate stream protocol handler is
  automatically loaded."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net URLStreamHandler]))

(defn ->url-stream-handler
  "Constructor."
  (^URLStreamHandler []
    (new URLStreamHandler )))

