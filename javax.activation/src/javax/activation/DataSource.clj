(ns javax.activation.DataSource
  "The DataSource interface provides the JavaBeans Activation Framework
  with an abstraction of an arbitrary collection of data.  It
  provides a type for that data as well as access
  to it in the form of InputStreams and
  OutputStreams where appropriate."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.activation DataSource]))

(defn get-input-stream
  "This method returns an InputStream representing
   the data and throws the appropriate exception if it can
   not do so.  Note that a new InputStream object must be
   returned each time this method is called, and the stream must be
   positioned at the beginning of the data.

  returns: an InputStream - `java.io.InputStream`

  throws: java.io.IOException"
  (^java.io.InputStream [^javax.activation.DataSource this]
    (-> this (.getInputStream))))

(defn get-output-stream
  "This method returns an OutputStream where the
   data can be written and throws the appropriate exception if it can
   not do so.  Note that a new OutputStream object must
   be returned each time this method is called, and the stream must
   be positioned at the location the data is to be written.

  returns: an OutputStream - `java.io.OutputStream`

  throws: java.io.IOException"
  (^java.io.OutputStream [^javax.activation.DataSource this]
    (-> this (.getOutputStream))))

(defn get-content-type
  "This method returns the MIME type of the data in the form of a
   string. It should always return a valid type. It is suggested
   that getContentType return `application/octet-stream` if the
   DataSource implementation can not determine the data type.

  returns: the MIME Type - `java.lang.String`"
  (^java.lang.String [^javax.activation.DataSource this]
    (-> this (.getContentType))))

(defn get-name
  "Return the name of this object where the name of the object
   is dependant on the nature of the underlying objects. DataSources
   encapsulating files may choose to return the filename of the object.
   (Typically this would be the last component of the filename, not an
   entire pathname.)

  returns: the name of the object. - `java.lang.String`"
  (^java.lang.String [^javax.activation.DataSource this]
    (-> this (.getName))))

