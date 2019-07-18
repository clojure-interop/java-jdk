(ns javax.swing.plaf.metal.MetalIconFactory$TreeFolderIcon
  " Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalIconFactory$TreeFolderIcon]))

(defn ->tree-folder-icon
  "Constructor."
  (^MetalIconFactory$TreeFolderIcon []
    (new MetalIconFactory$TreeFolderIcon )))

(defn get-shift
  "returns: `int`"
  (^Integer [^MetalIconFactory$TreeFolderIcon this]
    (-> this (.getShift))))

(defn get-additional-height
  "returns: `int`"
  (^Integer [^MetalIconFactory$TreeFolderIcon this]
    (-> this (.getAdditionalHeight))))

