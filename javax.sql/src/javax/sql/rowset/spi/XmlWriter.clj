(ns javax.sql.rowset.spi.XmlWriter
  "A specialized interface that facilitates an extension of the
  SyncProvider abstract class for XML orientated
  synchronization providers.

  SyncProvider  implementations that supply XML data writer
  capabilities such as output XML stream capabilities can implement this
  interface to provide standard XmlWriter objects to
  WebRowSet implementations.

  Writing a WebRowSet object includes printing the
  rowset's data, metadata, and properties, all with the
  appropriate XML tags."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset.spi XmlWriter]))

(defn write-xml
  "Writes the given WebRowSet object to the specified
   java.io.Writer output stream as an XML document.
   This document includes the rowset's data, metadata, and properties
   plus the appropriate XML tags.

   The caller parameter must be a WebRowSet
   object whose XmlWriter field contains a reference to
   this XmlWriter object.

  caller - the WebRowSet instance to be written, for which this XmlWriter object is the writer - `javax.sql.rowset.WebRowSet`
  writer - the java.io.Writer object that serves as the output stream for writing caller as an XML document - `java.io.Writer`

  throws: java.sql.SQLException - if a database access error occurs or this XmlWriter object is not the writer for the given WebRowSet object"
  ([this caller writer]
    (-> this (.writeXML caller writer))))

