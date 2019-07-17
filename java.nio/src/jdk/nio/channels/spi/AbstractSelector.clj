(ns jdk.nio.channels.spi.AbstractSelector
  "Base implementation class for selectors.

   This class encapsulates the low-level machinery required to implement
  the interruption of selection operations.  A concrete selector class must
  invoke the begin and end methods before and
  after, respectively, invoking an I/O operation that might block
  indefinitely.  In order to ensure that the end method is always
  invoked, these methods should be used within a
  try ... finally block:



  try {
      begin();
      // Perform blocking I/O operation here
      ...
  } finally {
      end();
  }

   This class also defines methods for maintaining a selector's
  cancelled-key set and for removing a key from its channel's key set, and
  declares the abstract register method that is invoked by a
  selectable channel's register
  method in order to perform the actual work of registering a channel."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels.spi AbstractSelector]))

(defn close
  "Closes this selector.

    If the selector has already been closed then this method returns
   immediately.  Otherwise it marks the selector as closed and then invokes
   the implCloseSelector method in order to
   complete the close operation.

  throws: java.io.IOException - If an I/O error occurs"
  ([this]
    (-> this (.close))))

(defn open?
  "Description copied from class: Selector

  returns: true if, and only if, this selector is open - `boolean`"
  ([this]
    (-> this (.isOpen))))

(defn provider
  "Returns the provider that created this channel.

  returns: The provider that created this channel - `java.nio.channels.spi.SelectorProvider`"
  ([this]
    (-> this (.provider))))

