(ns javax.swing.TransferHandler$DropLocation
  "Represents a location where dropped data should be inserted.
  This is a base class that only encapsulates a point.
  Components supporting drop may provide subclasses of this
  containing more information.

  Developers typically shouldn't create instances of, or extend, this
  class. Instead, these are something provided by the DnD
  implementation by TransferSupport instances and by
  components with a getDropLocation() method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing TransferHandler$DropLocation]))

(defn get-drop-point
  "Returns the drop point, representing the mouse's
   current location within the component.

  returns: the drop point. - `java.awt.Point`"
  ([^javax.swing.TransferHandler$DropLocation this]
    (-> this (.getDropPoint))))

(defn to-string
  "Returns a string representation of this drop location.
   This method is intended to be used for debugging purposes,
   and the content and format of the returned string may vary
   between implementations.

  returns: a string representation of this drop location - `java.lang.String`"
  ([^javax.swing.TransferHandler$DropLocation this]
    (-> this (.toString))))

