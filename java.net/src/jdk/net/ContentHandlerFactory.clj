(ns jdk.net.ContentHandlerFactory
  "This interface defines a factory for content handlers. An
  implementation of this interface should map a MIME type into an
  instance of ContentHandler.

  This interface is used by the URLStreamHandler class
  to create a ContentHandler for a MIME type."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net ContentHandlerFactory]))

(defn create-content-handler
  "Creates a new ContentHandler to read an object from
   a URLStreamHandler.

  mimetype - the MIME type for which a content handler is desired. - `java.lang.String`

  returns: a new ContentHandler to read an object from a
            URLStreamHandler. - `java.net.ContentHandler`"
  ([^java.net.ContentHandlerFactory this ^java.lang.String mimetype]
    (-> this (.createContentHandler mimetype))))

