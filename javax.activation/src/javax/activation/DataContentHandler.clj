(ns javax.activation.DataContentHandler
  "The DataContentHandler interface is implemented by objects that can
  be used to extend the capabilities of the DataHandler's implementation
  of the Transferable interface. Through DataContentHandlers
  the framework can be extended to convert streams in to objects, and
  to write objects to streams.

  Applications don't generally call the methods in DataContentHandlers
  directly. Instead, an application calls the equivalent methods in
  DataHandler. The DataHandler will attempt to find an appropriate
  DataContentHandler that corresponds to its MIME type using the
  current DataContentHandlerFactory. The DataHandler then calls
  through to the methods in the DataContentHandler."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.activation DataContentHandler]))

(defn get-transfer-data-flavors
  "Returns an array of DataFlavor objects indicating the flavors the
   data can be provided in. The array should be ordered according to
   preference for providing the data (from most richly descriptive to
   least descriptive).

  returns: The DataFlavors. - `java.awt.datatransfer.DataFlavor[]`"
  ([^. this]
    (-> this (.getTransferDataFlavors))))

(defn get-transfer-data
  "Returns an object which represents the data to be transferred.
   The class of the object returned is defined by the representation class
   of the flavor.

  df - The DataFlavor representing the requested type. - `java.awt.datatransfer.DataFlavor`
  ds - The DataSource representing the data to be converted. - `javax.activation.DataSource`

  returns: The constructed Object. - `java.lang.Object`

  throws: java.awt.datatransfer.UnsupportedFlavorException - if the handler doesn't support the requested flavor"
  ([^. this ^java.awt.datatransfer.DataFlavor df ^javax.activation.DataSource ds]
    (-> this (.getTransferData df ds))))

(defn get-content
  "Return an object representing the data in its most preferred form.
   Generally this will be the form described by the first DataFlavor
   returned by the getTransferDataFlavors method.

  ds - The DataSource representing the data to be converted. - `javax.activation.DataSource`

  returns: The constructed Object. - `java.lang.Object`

  throws: java.io.IOException - if the data can't be accessed"
  ([^. this ^javax.activation.DataSource ds]
    (-> this (.getContent ds))))

(defn write-to
  "Convert the object to a byte stream of the specified MIME type
   and write it to the output stream.

  obj - The object to be converted. - `java.lang.Object`
  mime-type - The requested MIME type of the resulting byte stream. - `java.lang.String`
  os - The output stream into which to write the converted byte stream. - `java.io.OutputStream`

  throws: java.io.IOException - errors writing to the stream"
  ([^. this ^java.lang.Object obj ^java.lang.String mime-type ^java.io.OutputStream os]
    (-> this (.writeTo obj mime-type os))))

