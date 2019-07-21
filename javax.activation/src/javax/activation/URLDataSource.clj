(ns javax.activation.URLDataSource
  "The URLDataSource class provides an object that wraps a URL
  object in a DataSource interface. URLDataSource simplifies the handling
  of data described by URLs within the JavaBeans Activation Framework
  because this class can be used to create new DataHandlers. NOTE: The
  DataHandler object creates a URLDataSource internally,
  when it is constructed with a URL."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.activation URLDataSource]))

(defn ->url-data-source
  "Constructor.

  URLDataSource constructor. The URLDataSource class will
   not open a connection to the URL until a method requiring it
   to do so is called.

  url - The URL to be encapsulated in this object. - `java.net.URL`"
  (^URLDataSource [^java.net.URL url]
    (new URLDataSource url)))

(defn get-content-type
  "Returns the value of the URL content-type header field.
   It calls the URL's URLConnection.getContentType method
   after retrieving a URLConnection object.
   Note: this method attempts to call the openConnection
   method on the URL. If this method fails, or if a content type is not
   returned from the URLConnection, getContentType returns
   \"application/octet-stream\" as the content type.

  returns: the content type. - `java.lang.String`"
  (^java.lang.String [^URLDataSource this]
    (-> this (.getContentType))))

(defn get-name
  "Calls the getFile method on the URL used to
   instantiate the object.

  returns: the result of calling the URL's getFile method. - `java.lang.String`"
  (^java.lang.String [^URLDataSource this]
    (-> this (.getName))))

(defn get-input-stream
  "The getInputStream method from the URL. Calls the
   openStream method on the URL.

  returns: the InputStream. - `java.io.InputStream`

  throws: java.io.IOException"
  (^java.io.InputStream [^URLDataSource this]
    (-> this (.getInputStream))))

(defn get-output-stream
  "The getOutputStream method from the URL. First an attempt is
   made to get the URLConnection object for the URL. If that
   succeeds, the getOutputStream method on the URLConnection
   is returned.

  returns: the OutputStream. - `java.io.OutputStream`

  throws: java.io.IOException"
  (^java.io.OutputStream [^URLDataSource this]
    (-> this (.getOutputStream))))

(defn get-url
  "Return the URL used to create this DataSource.

  returns: The URL. - `java.net.URL`"
  (^java.net.URL [^URLDataSource this]
    (-> this (.getURL))))

