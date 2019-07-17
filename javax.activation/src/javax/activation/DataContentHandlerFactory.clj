(ns javax.activation.DataContentHandlerFactory
  "This interface defines a factory for DataContentHandlers. An
  implementation of this interface should map a MIME type into an
  instance of DataContentHandler. The design pattern for classes implementing
  this interface is the same as for the ContentHandler mechanism used in
  java.net.URL."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.activation DataContentHandlerFactory]))

(defn create-data-content-handler
  "Creates a new DataContentHandler object for the MIME type.

  mime-type - the MIME type to create the DataContentHandler for. - `java.lang.String`

  returns: The new DataContentHandler, or null
   if none are found. - `javax.activation.DataContentHandler`"
  ([^javax.activation.DataContentHandlerFactory this ^java.lang.String mime-type]
    (-> this (.createDataContentHandler mime-type))))

