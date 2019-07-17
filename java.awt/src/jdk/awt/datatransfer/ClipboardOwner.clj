(ns jdk.awt.datatransfer.ClipboardOwner
  "Defines the interface for classes that will provide data to
  a clipboard. An instance of this interface becomes the owner
  of the contents of a clipboard (clipboard owner) if it is
  passed as an argument to
  Clipboard.setContents(java.awt.datatransfer.Transferable, java.awt.datatransfer.ClipboardOwner) method of
  the clipboard and this method returns successfully.
  The instance remains the clipboard owner until another application
  or another object within this application asserts ownership
  of this clipboard."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.datatransfer ClipboardOwner]))

(defn lost-ownership
  "Notifies this object that it is no longer the clipboard owner.
   This method will be called when another application or another
   object within this application asserts ownership of the clipboard.

  clipboard - the clipboard that is no longer owned - `java.awt.datatransfer.Clipboard`
  contents - the contents which this owner had placed on the clipboard - `java.awt.datatransfer.Transferable`"
  ([^. this ^java.awt.datatransfer.Clipboard clipboard ^java.awt.datatransfer.Transferable contents]
    (-> this (.lostOwnership clipboard contents))))

