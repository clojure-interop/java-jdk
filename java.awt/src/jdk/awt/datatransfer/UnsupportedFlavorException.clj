(ns jdk.awt.datatransfer.UnsupportedFlavorException
  "Signals that the requested data is not supported in this flavor."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.datatransfer UnsupportedFlavorException]))

(defn ->unsupported-flavor-exception
  "Constructor.

  Constructs an UnsupportedFlavorException.

  flavor - the flavor object which caused the exception. May be null. - `java.awt.datatransfer.DataFlavor`"
  ([^java.awt.datatransfer.DataFlavor flavor]
    (new UnsupportedFlavorException flavor)))

