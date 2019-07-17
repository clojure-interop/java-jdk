(ns javax.sql.rowset.spi.XmlReader
  "A specialized interface that facilitates an extension of the
  SyncProvider abstract class for XML orientated
  synchronization providers.

  SyncProvider  implementations that supply XML data reader
  capabilities such as output XML stream capabilities can implement this
  interface to provide standard XmlReader objects to
  WebRowSet implementations.

  An XmlReader object is registered as the
  XML reader for a WebRowSet by being assigned to the
  rowset's xmlReader field. When the WebRowSet
  object's readXml method is invoked, it in turn invokes
  its XML reader's readXML method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset.spi XmlReader]))

(defn read-xml
  "Reads and parses the given WebRowSet object from the given
   input stream in XML format. The xmlReader field of the
   given WebRowSet object must contain this
   XmlReader object.

   If a parsing error occurs, the exception that is thrown will
   include information about the location of the error in the
   original XML document.

  caller - the WebRowSet object to be parsed, whose xmlReader field must contain a reference to this XmlReader object - `javax.sql.rowset.WebRowSet`
  reader - the java.io.Reader object from which caller will be read - `java.io.Reader`

  throws: java.sql.SQLException - if a database access error occurs or this XmlReader object is not the reader for the given rowset"
  ([^javax.sql.rowset.spi.XmlReader this ^javax.sql.rowset.WebRowSet caller ^java.io.Reader reader]
    (-> this (.readXML caller reader))))

