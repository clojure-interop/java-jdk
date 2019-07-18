(ns javax.swing.plaf.basic.BasicInternalFrameTitlePane
  "The class that manages a basic title bar

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicInternalFrameTitlePane]))

(defn ->basic-internal-frame-title-pane
  "Constructor.

  f - `javax.swing.JInternalFrame`"
  (^BasicInternalFrameTitlePane [^javax.swing.JInternalFrame f]
    (new BasicInternalFrameTitlePane f)))

(defn paint-component
  "Description copied from class: JComponent

  g - the Graphics object to protect - `java.awt.Graphics`"
  ([^BasicInternalFrameTitlePane this ^java.awt.Graphics g]
    (-> this (.paintComponent g))))

