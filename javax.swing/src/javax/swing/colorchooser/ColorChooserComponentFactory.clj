(ns javax.swing.colorchooser.ColorChooserComponentFactory
  "A class designed to produce preconfigured `accessory` objects to
  insert into color choosers.


  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.colorchooser ColorChooserComponentFactory]))

(defn *get-default-chooser-panels
  "returns: `javax.swing.colorchooser.AbstractColorChooserPanel[]`"
  ([]
    (ColorChooserComponentFactory/getDefaultChooserPanels )))

(defn *get-preview-panel
  "returns: `javax.swing.JComponent`"
  ([]
    (ColorChooserComponentFactory/getPreviewPanel )))

