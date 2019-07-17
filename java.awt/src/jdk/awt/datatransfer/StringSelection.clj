(ns jdk.awt.datatransfer.StringSelection
  "A Transferable which implements the capability required
  to transfer a String.

  This Transferable properly supports
  DataFlavor.stringFlavor
  and all equivalent flavors. Support for
  DataFlavor.plainTextFlavor
  and all equivalent flavors is deprecated. No other
  DataFlavors are supported."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.datatransfer StringSelection]))

(defn ->string-selection
  "Constructor.

  Creates a Transferable capable of transferring
   the specified String.

  data - `java.lang.String`"
  ([^java.lang.String data]
    (new StringSelection data)))

(defn get-transfer-data-flavors
  "Returns an array of flavors in which this Transferable
   can provide the data. DataFlavor.stringFlavor
   is properly supported.
   Support for DataFlavor.plainTextFlavor is
   deprecated.

  returns: an array of length two, whose elements are DataFlavor.
           stringFlavor and DataFlavor.plainTextFlavor - `java.awt.datatransfer.DataFlavor[]`"
  ([^java.awt.datatransfer.StringSelection this]
    (-> this (.getTransferDataFlavors))))

(defn data-flavor-supported?
  "Returns whether the requested flavor is supported by this
   Transferable.

  flavor - the requested flavor for the data - `java.awt.datatransfer.DataFlavor`

  returns: true if flavor is equal to
     DataFlavor.stringFlavor or
     DataFlavor.plainTextFlavor; false if flavor
     is not one of the above flavors - `boolean`

  throws: java.lang.NullPointerException - if flavor is null"
  (^Boolean [^java.awt.datatransfer.StringSelection this ^java.awt.datatransfer.DataFlavor flavor]
    (-> this (.isDataFlavorSupported flavor))))

(defn get-transfer-data
  "Returns the Transferable's data in the requested
   DataFlavor if possible. If the desired flavor is
   DataFlavor.stringFlavor, or an equivalent flavor,
   the String representing the selection is
   returned. If the desired flavor is
   DataFlavor.plainTextFlavor,
   or an equivalent flavor, a Reader is returned.
   Note: The behavior of this method for
   DataFlavor.plainTextFlavor
   and equivalent DataFlavors is inconsistent with the
   definition of DataFlavor.plainTextFlavor.

  flavor - the requested flavor for the data - `java.awt.datatransfer.DataFlavor`

  returns: the data in the requested flavor, as outlined above - `java.lang.Object`

  throws: java.awt.datatransfer.UnsupportedFlavorException - if the requested data flavor is not equivalent to either DataFlavor.stringFlavor or DataFlavor.plainTextFlavor"
  (^java.lang.Object [^java.awt.datatransfer.StringSelection this ^java.awt.datatransfer.DataFlavor flavor]
    (-> this (.getTransferData flavor))))

(defn lost-ownership
  "Description copied from interface: ClipboardOwner

  clipboard - the clipboard that is no longer owned - `java.awt.datatransfer.Clipboard`
  contents - the contents which this owner had placed on the clipboard - `java.awt.datatransfer.Transferable`"
  ([^java.awt.datatransfer.StringSelection this ^java.awt.datatransfer.Clipboard clipboard ^java.awt.datatransfer.Transferable contents]
    (-> this (.lostOwnership clipboard contents))))

