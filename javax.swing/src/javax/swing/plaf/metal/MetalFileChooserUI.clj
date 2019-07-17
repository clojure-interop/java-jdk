(ns javax.swing.plaf.metal.MetalFileChooserUI
  "Metal L&F implementation of a FileChooser."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalFileChooserUI]))

(defn ->metal-file-chooser-ui
  "Constructor.

  filechooser - `javax.swing.JFileChooser`"
  ([filechooser]
    (new MetalFileChooserUI filechooser)))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  ([c]
    (MetalFileChooserUI/createUI c)))

(defn install-ui
  "Description copied from class: ComponentUI

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([this c]
    (-> this (.installUI c))))

(defn install-components
  "fc - `javax.swing.JFileChooser`"
  ([this fc]
    (-> this (.installComponents fc))))

(defn get-minimum-size
  "Returns the minimum size of the JFileChooser.

  c - a JFileChooser - `javax.swing.JComponent`

  returns: a Dimension specifying the minimum
             width and height of the file chooser - `java.awt.Dimension`"
  ([this c]
    (-> this (.getMinimumSize c))))

(defn get-file-name
  "returns: `java.lang.String`"
  ([this]
    (-> this (.getFileName))))

(defn get-maximum-size
  "Returns the maximum size of the JFileChooser.

  c - a JFileChooser - `javax.swing.JComponent`

  returns: a Dimension specifying the maximum
             width and height of the file chooser - `java.awt.Dimension`"
  ([this c]
    (-> this (.getMaximumSize c))))

(defn set-file-name
  "filename - `java.lang.String`"
  ([this filename]
    (-> this (.setFileName filename))))

(defn create-property-change-listener
  "fc - `javax.swing.JFileChooser`

  returns: `java.beans.PropertyChangeListener`"
  ([this fc]
    (-> this (.createPropertyChangeListener fc))))

(defn uninstall-ui
  "Description copied from class: ComponentUI

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([this c]
    (-> this (.uninstallUI c))))

(defn set-directory-name
  "dirname - `java.lang.String`"
  ([this dirname]
    (-> this (.setDirectoryName dirname))))

(defn get-directory-name
  "returns: `java.lang.String`"
  ([this]
    (-> this (.getDirectoryName))))

(defn ensure-file-is-visible
  "fc - `javax.swing.JFileChooser`
  f - `java.io.File`"
  ([this fc f]
    (-> this (.ensureFileIsVisible fc f))))

(defn value-changed
  "e - `javax.swing.event.ListSelectionEvent`"
  ([this e]
    (-> this (.valueChanged e))))

(defn rescan-current-directory
  "fc - `javax.swing.JFileChooser`"
  ([this fc]
    (-> this (.rescanCurrentDirectory fc))))

(defn create-list-selection-listener
  "Creates a selection listener for the list of files and directories.

  fc - a JFileChooser - `javax.swing.JFileChooser`

  returns: a ListSelectionListener - `javax.swing.event.ListSelectionListener`"
  ([this fc]
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
  ([this c]
    (-> this (.getPreferredSize c))))

(defn uninstall-components
  "fc - `javax.swing.JFileChooser`"
  ([this fc]
    (-> this (.uninstallComponents fc))))

