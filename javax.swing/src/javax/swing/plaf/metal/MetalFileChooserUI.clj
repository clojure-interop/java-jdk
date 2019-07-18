(ns javax.swing.plaf.metal.MetalFileChooserUI
  "Metal L&F implementation of a FileChooser."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalFileChooserUI]))

(defn ->metal-file-chooser-ui
  "Constructor.

  filechooser - `javax.swing.JFileChooser`"
  (^MetalFileChooserUI [^javax.swing.JFileChooser filechooser]
    (new MetalFileChooserUI filechooser)))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (MetalFileChooserUI/createUI c)))

(defn install-ui
  "Description copied from class: ComponentUI

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^MetalFileChooserUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn install-components
  "fc - `javax.swing.JFileChooser`"
  ([^MetalFileChooserUI this ^javax.swing.JFileChooser fc]
    (-> this (.installComponents fc))))

(defn get-minimum-size
  "Returns the minimum size of the JFileChooser.

  c - a JFileChooser - `javax.swing.JComponent`

  returns: a Dimension specifying the minimum
             width and height of the file chooser - `java.awt.Dimension`"
  (^java.awt.Dimension [^MetalFileChooserUI this ^javax.swing.JComponent c]
    (-> this (.getMinimumSize c))))

(defn get-file-name
  "returns: `java.lang.String`"
  (^java.lang.String [^MetalFileChooserUI this]
    (-> this (.getFileName))))

(defn get-maximum-size
  "Returns the maximum size of the JFileChooser.

  c - a JFileChooser - `javax.swing.JComponent`

  returns: a Dimension specifying the maximum
             width and height of the file chooser - `java.awt.Dimension`"
  (^java.awt.Dimension [^MetalFileChooserUI this ^javax.swing.JComponent c]
    (-> this (.getMaximumSize c))))

(defn set-file-name
  "filename - `java.lang.String`"
  ([^MetalFileChooserUI this ^java.lang.String filename]
    (-> this (.setFileName filename))))

(defn create-property-change-listener
  "fc - `javax.swing.JFileChooser`

  returns: `java.beans.PropertyChangeListener`"
  (^java.beans.PropertyChangeListener [^MetalFileChooserUI this ^javax.swing.JFileChooser fc]
    (-> this (.createPropertyChangeListener fc))))

(defn uninstall-ui
  "Description copied from class: ComponentUI

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^MetalFileChooserUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn set-directory-name
  "dirname - `java.lang.String`"
  ([^MetalFileChooserUI this ^java.lang.String dirname]
    (-> this (.setDirectoryName dirname))))

(defn get-directory-name
  "returns: `java.lang.String`"
  (^java.lang.String [^MetalFileChooserUI this]
    (-> this (.getDirectoryName))))

(defn ensure-file-is-visible
  "fc - `javax.swing.JFileChooser`
  f - `java.io.File`"
  ([^MetalFileChooserUI this ^javax.swing.JFileChooser fc ^java.io.File f]
    (-> this (.ensureFileIsVisible fc f))))

(defn value-changed
  "e - `javax.swing.event.ListSelectionEvent`"
  ([^MetalFileChooserUI this ^javax.swing.event.ListSelectionEvent e]
    (-> this (.valueChanged e))))

(defn rescan-current-directory
  "fc - `javax.swing.JFileChooser`"
  ([^MetalFileChooserUI this ^javax.swing.JFileChooser fc]
    (-> this (.rescanCurrentDirectory fc))))

(defn create-list-selection-listener
  "Creates a selection listener for the list of files and directories.

  fc - a JFileChooser - `javax.swing.JFileChooser`

  returns: a ListSelectionListener - `javax.swing.event.ListSelectionListener`"
  (^javax.swing.event.ListSelectionListener [^MetalFileChooserUI this ^javax.swing.JFileChooser fc]
    (-> this (.createListSelectionListener fc))))

(defn get-preferred-size
  "Returns the preferred size of the specified
   JFileChooser.
   The preferred size is at least as large,
   in both height and width,
   as the preferred size recommended
   by the file chooser's layout manager.

  c - a JFileChooser - `javax.swing.JComponent`

  returns: a Dimension specifying the preferred
             width and height of the file chooser - `java.awt.Dimension`"
  (^java.awt.Dimension [^MetalFileChooserUI this ^javax.swing.JComponent c]
    (-> this (.getPreferredSize c))))

(defn uninstall-components
  "fc - `javax.swing.JFileChooser`"
  ([^MetalFileChooserUI this ^javax.swing.JFileChooser fc]
    (-> this (.uninstallComponents fc))))

