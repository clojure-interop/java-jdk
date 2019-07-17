(ns jdk.awt.datatransfer.Clipboard
  "A class that implements a mechanism to transfer data using
  cut/copy/paste operations.

  FlavorListeners may be registered on an instance of the
  Clipboard class to be notified about changes to the set of
  DataFlavors available on this clipboard (see
  addFlavorListener(java.awt.datatransfer.FlavorListener))."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.datatransfer Clipboard]))

(defn ->clipboard
  "Constructor.

  Creates a clipboard object.

  name - `java.lang.String`"
  ([name]
    (new Clipboard name)))

(defn get-flavor-listeners
  "Returns an array of all the FlavorListeners currently
   registered on this Clipboard.

  returns: all of this clipboard's FlavorListeners or an empty
           array if no listeners are currently registered - `java.awt.datatransfer.FlavorListener[]`"
  ([this]
    (-> this (.getFlavorListeners))))

(defn data-flavor-available?
  "Returns whether or not the current contents of this clipboard can be
   provided in the specified DataFlavor.

  flavor - the requested DataFlavor for the contents - `java.awt.datatransfer.DataFlavor`

  returns: true if the current contents of this clipboard
           can be provided in the specified DataFlavor;
           false otherwise - `boolean`

  throws: java.lang.NullPointerException - if flavor is null"
  ([this flavor]
    (-> this (.isDataFlavorAvailable flavor))))

(defn get-data
  "Returns an object representing the current contents of this clipboard
   in the specified DataFlavor.
   The class of the object returned is defined by the representation
   class of flavor.

  flavor - the requested DataFlavor for the contents - `java.awt.datatransfer.DataFlavor`

  returns: an object representing the current contents of this clipboard
           in the specified DataFlavor - `java.lang.Object`

  throws: java.lang.NullPointerException - if flavor is null"
  ([this flavor]
    (-> this (.getData flavor))))

(defn set-contents
  "Sets the current contents of the clipboard to the specified
   transferable object and registers the specified clipboard owner
   as the owner of the new contents.

   If there is an existing owner different from the argument
   owner, that owner is notified that it no longer
   holds ownership of the clipboard contents via an invocation
   of ClipboardOwner.lostOwnership() on that owner.
   An implementation of setContents() is free not
   to invoke lostOwnership() directly from this method.
   For example, lostOwnership() may be invoked later on
   a different thread. The same applies to FlavorListeners
   registered on this clipboard.

   The method throws IllegalStateException if the clipboard
   is currently unavailable. For example, on some platforms, the system
   clipboard is unavailable while it is accessed by another application.

  contents - the transferable object representing the clipboard content - `java.awt.datatransfer.Transferable`
  owner - the object which owns the clipboard content - `java.awt.datatransfer.ClipboardOwner`

  throws: java.lang.IllegalStateException - if the clipboard is currently unavailable"
  ([this contents owner]
    (-> this (.setContents contents owner))))

(defn get-available-data-flavors
  "Returns an array of DataFlavors in which the current
   contents of this clipboard can be provided. If there are no
   DataFlavors available, this method returns a zero-length
   array.

  returns: an array of DataFlavors in which the current
           contents of this clipboard can be provided - `java.awt.datatransfer.DataFlavor[]`

  throws: java.lang.IllegalStateException - if this clipboard is currently unavailable"
  ([this]
    (-> this (.getAvailableDataFlavors))))

(defn add-flavor-listener
  "Registers the specified FlavorListener to receive
   FlavorEvents from this clipboard.
   If listener is null, no exception
   is thrown and no action is performed.

  listener - the listener to be added - `java.awt.datatransfer.FlavorListener`"
  ([this listener]
    (-> this (.addFlavorListener listener))))

(defn get-name
  "Returns the name of this clipboard object.

  returns: `java.lang.String`"
  ([this]
    (-> this (.getName))))

(defn remove-flavor-listener
  "Removes the specified FlavorListener so that it no longer
   receives FlavorEvents from this Clipboard.
   This method performs no function, nor does it throw an exception, if
   the listener specified by the argument was not previously added to this
   Clipboard.
   If listener is null, no exception
   is thrown and no action is performed.

  listener - the listener to be removed - `java.awt.datatransfer.FlavorListener`"
  ([this listener]
    (-> this (.removeFlavorListener listener))))

(defn get-contents
  "Returns a transferable object representing the current contents
   of the clipboard.  If the clipboard currently has no contents,
   it returns null. The parameter Object requestor is
   not currently used.  The method throws
   IllegalStateException if the clipboard is currently
   unavailable.  For example, on some platforms, the system clipboard is
   unavailable while it is accessed by another application.

  requestor - the object requesting the clip data (not used) - `java.lang.Object`

  returns: the current transferable object on the clipboard - `java.awt.datatransfer.Transferable`

  throws: java.lang.IllegalStateException - if the clipboard is currently unavailable"
  ([this requestor]
    (-> this (.getContents requestor))))

