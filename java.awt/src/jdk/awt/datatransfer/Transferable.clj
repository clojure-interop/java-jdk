(ns jdk.awt.datatransfer.Transferable
  "Defines the interface for classes that can be used to provide data
  for a transfer operation.

  For information on using data transfer with Swing, see

  How to Use Drag and Drop and Data Transfer,
  a section in The Java Tutorial, for more information."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.datatransfer Transferable]))

(defn get-transfer-data-flavors
  "Returns an array of DataFlavor objects indicating the flavors the data
   can be provided in.  The array should be ordered according to preference
   for providing the data (from most richly descriptive to least descriptive).

  returns: an array of data flavors in which this data can be transferred - `java.awt.datatransfer.DataFlavor[]`"
  ([^. this]
    (-> this (.getTransferDataFlavors))))

(defn data-flavor-supported?
  "Returns whether or not the specified data flavor is supported for
   this object.

  flavor - the requested flavor for the data - `java.awt.datatransfer.DataFlavor`

  returns: boolean indicating whether or not the data flavor is supported - `boolean`"
  ([^. this ^java.awt.datatransfer.DataFlavor flavor]
    (-> this (.isDataFlavorSupported flavor))))

(defn get-transfer-data
  "Returns an object which represents the data to be transferred.  The class
   of the object returned is defined by the representation class of the flavor.

  flavor - the requested flavor for the data - `java.awt.datatransfer.DataFlavor`

  returns: `java.lang.Object`

  throws: java.io.IOException - if the data is no longer available in the requested flavor."
  ([^. this ^java.awt.datatransfer.DataFlavor flavor]
    (-> this (.getTransferData flavor))))

