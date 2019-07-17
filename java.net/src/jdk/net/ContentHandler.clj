(ns jdk.net.ContentHandler
  "The abstract class ContentHandler is the superclass
  of all classes that read an Object from a
  URLConnection.

  An application does not generally call the
  getContent method in this class directly. Instead, an
  application calls the getContent method in class
  URL or in URLConnection.
  The application's content handler factory (an instance of a class that
  implements the interface ContentHandlerFactory set
  up by a call to setContentHandler) is
  called with a String giving the MIME type of the
  object being received on the socket. The factory returns an
  instance of a subclass of ContentHandler, and its
  getContent method is called to create the object.

  If no content handler could be found, URLConnection will
  look for a content handler in a user-defineable set of places.
  By default it looks in sun.net.www.content, but users can define a
  vertical-bar delimited set of class prefixes to search through in
  addition by defining the java.content.handler.pkgs property.
  The class name must be of the form:


      {package-prefix}.{major}.{minor}
  e.g.
      YoyoDyne.experimental.text.plain
  If the loading of the content handler class would be performed by
  a classloader that is outside of the delegation chain of the caller,
  the JVM will need the RuntimePermission `getClassLoader`."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net ContentHandler]))

(defn ->content-handler
  "Constructor."
  ([]
    (new ContentHandler )))

(defn get-content
  "Given a URL connect stream positioned at the beginning of the
   representation of an object, this method reads that stream and
   creates an object that matches one of the types specified.

   The default implementation of this method should call getContent()
   and screen the return type for a match of the suggested types.

  urlc - a URL connection. - `java.net.URLConnection`
  classes - an array of types requested - `java.lang.Class[]`

  returns: the object read by the ContentHandler that is
                   the first match of the suggested types.
                   null if none of the requested  are supported. - `java.lang.Object`

  throws: java.io.IOException - if an I/O error occurs while reading the object."
  (^java.lang.Object [^java.net.ContentHandler this ^java.net.URLConnection urlc classes]
    (-> this (.getContent urlc classes)))
  (^java.lang.Object [^java.net.ContentHandler this ^java.net.URLConnection urlc]
    (-> this (.getContent urlc))))

