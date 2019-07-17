(ns javax.swing.plaf.basic.BasicFileChooserUI
  "Basic L&F implementation of a FileChooser."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicFileChooserUI]))

(defn ->basic-file-chooser-ui
  "Constructor.

  b - `javax.swing.JFileChooser`"
  ([^javax.swing.JFileChooser b]
    (new BasicFileChooserUI b)))

(defn *create-ui
  "Creates a BasicFileChooserUI implementation
   for the specified component. By default
   the BasicLookAndFeel class uses
   createUI methods of all basic UIs classes
   to instantiate UIs.

  c - the JFileChooser which needs a UI - `javax.swing.JComponent`

  returns: the BasicFileChooserUI object - `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (BasicFileChooserUI/createUI c)))

(defn install-ui
  "Description copied from class: ComponentUI

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicFileChooserUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn install-components
  "fc - `javax.swing.JFileChooser`"
  ([^javax.swing.plaf.basic.BasicFileChooserUI this ^javax.swing.JFileChooser fc]
    (-> this (.installComponents fc))))

(defn get-file-chooser
  "returns: `javax.swing.JFileChooser`"
  (^javax.swing.JFileChooser [^javax.swing.plaf.basic.BasicFileChooserUI this]
    (-> this (.getFileChooser))))

(defn get-file-name
  "returns: `java.lang.String`"
  (^java.lang.String [^javax.swing.plaf.basic.BasicFileChooserUI this]
    (-> this (.getFileName))))

(defn set-file-name
  "filename - `java.lang.String`"
  ([^javax.swing.plaf.basic.BasicFileChooserUI this ^java.lang.String filename]
    (-> this (.setFileName filename))))

(defn get-approve-selection-action
  "returns: `javax.swing.Action`"
  (^javax.swing.Action [^javax.swing.plaf.basic.BasicFileChooserUI this]
    (-> this (.getApproveSelectionAction))))

(defn get-new-folder-action
  "returns: `javax.swing.Action`"
  (^javax.swing.Action [^javax.swing.plaf.basic.BasicFileChooserUI this]
    (-> this (.getNewFolderAction))))

(defn create-property-change-listener
  "fc - `javax.swing.JFileChooser`

  returns: `java.beans.PropertyChangeListener`"
  (^java.beans.PropertyChangeListener [^javax.swing.plaf.basic.BasicFileChooserUI this ^javax.swing.JFileChooser fc]
    (-> this (.createPropertyChangeListener fc))))

(defn get-accessory-panel
  "returns: `javax.swing.JPanel`"
  (^javax.swing.JPanel [^javax.swing.plaf.basic.BasicFileChooserUI this]
    (-> this (.getAccessoryPanel))))

(defn get-approve-button-text
  "fc - `javax.swing.JFileChooser`

  returns: `java.lang.String`"
  (^java.lang.String [^javax.swing.plaf.basic.BasicFileChooserUI this ^javax.swing.JFileChooser fc]
    (-> this (.getApproveButtonText fc))))

(defn get-cancel-selection-action
  "returns: `javax.swing.Action`"
  (^javax.swing.Action [^javax.swing.plaf.basic.BasicFileChooserUI this]
    (-> this (.getCancelSelectionAction))))

(defn uninstall-ui
  "Description copied from class: ComponentUI

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicFileChooserUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn get-accept-all-file-filter
  "Returns the default accept all file filter

  fc - `javax.swing.JFileChooser`

  returns: `javax.swing.filechooser.FileFilter`"
  (^javax.swing.filechooser.FileFilter [^javax.swing.plaf.basic.BasicFileChooserUI this ^javax.swing.JFileChooser fc]
    (-> this (.getAcceptAllFileFilter fc))))

(defn get-approve-button-tool-tip-text
  "fc - `javax.swing.JFileChooser`

  returns: `java.lang.String`"
  (^java.lang.String [^javax.swing.plaf.basic.BasicFileChooserUI this ^javax.swing.JFileChooser fc]
    (-> this (.getApproveButtonToolTipText fc))))

(defn set-directory-name
  "dirname - `java.lang.String`"
  ([^javax.swing.plaf.basic.BasicFileChooserUI this ^java.lang.String dirname]
    (-> this (.setDirectoryName dirname))))

(defn get-directory-name
  "returns: `java.lang.String`"
  (^java.lang.String [^javax.swing.plaf.basic.BasicFileChooserUI this]
    (-> this (.getDirectoryName))))

(defn get-go-home-action
  "returns: `javax.swing.Action`"
  (^javax.swing.Action [^javax.swing.plaf.basic.BasicFileChooserUI this]
    (-> this (.getGoHomeAction))))

(defn get-dialog-title
  "Returns the title of this dialog

  fc - `javax.swing.JFileChooser`

  returns: `java.lang.String`"
  (^java.lang.String [^javax.swing.plaf.basic.BasicFileChooserUI this ^javax.swing.JFileChooser fc]
    (-> this (.getDialogTitle fc))))

(defn ensure-file-is-visible
  "fc - `javax.swing.JFileChooser`
  f - `java.io.File`"
  ([^javax.swing.plaf.basic.BasicFileChooserUI this ^javax.swing.JFileChooser fc ^java.io.File f]
    (-> this (.ensureFileIsVisible fc f))))

(defn rescan-current-directory
  "fc - `javax.swing.JFileChooser`"
  ([^javax.swing.plaf.basic.BasicFileChooserUI this ^javax.swing.JFileChooser fc]
    (-> this (.rescanCurrentDirectory fc))))

(defn create-list-selection-listener
  "fc - `javax.swing.JFileChooser`

  returns: `javax.swing.event.ListSelectionListener`"
  (^javax.swing.event.ListSelectionListener [^javax.swing.plaf.basic.BasicFileChooserUI this ^javax.swing.JFileChooser fc]
    (-> this (.createListSelectionListener fc))))

(defn get-default-button
  "Description copied from class: FileChooserUI

  fc - `javax.swing.JFileChooser`

  returns: `javax.swing.JButton`"
  (^javax.swing.JButton [^javax.swing.plaf.basic.BasicFileChooserUI this ^javax.swing.JFileChooser fc]
    (-> this (.getDefaultButton fc))))

(defn clear-icon-cache
  ""
  ([^javax.swing.plaf.basic.BasicFileChooserUI this]
    (-> this (.clearIconCache))))

(defn get-approve-button-mnemonic
  "fc - `javax.swing.JFileChooser`

  returns: `int`"
  (^Integer [^javax.swing.plaf.basic.BasicFileChooserUI this ^javax.swing.JFileChooser fc]
    (-> this (.getApproveButtonMnemonic fc))))

(defn get-model
  "returns: `javax.swing.plaf.basic.BasicDirectoryModel`"
  (^javax.swing.plaf.basic.BasicDirectoryModel [^javax.swing.plaf.basic.BasicFileChooserUI this]
    (-> this (.getModel))))

(defn get-change-to-parent-directory-action
  "returns: `javax.swing.Action`"
  (^javax.swing.Action [^javax.swing.plaf.basic.BasicFileChooserUI this]
    (-> this (.getChangeToParentDirectoryAction))))

(defn get-file-view
  "fc - `javax.swing.JFileChooser`

  returns: `javax.swing.filechooser.FileView`"
  (^javax.swing.filechooser.FileView [^javax.swing.plaf.basic.BasicFileChooserUI this ^javax.swing.JFileChooser fc]
    (-> this (.getFileView fc))))

(defn uninstall-components
  "fc - `javax.swing.JFileChooser`"
  ([^javax.swing.plaf.basic.BasicFileChooserUI this ^javax.swing.JFileChooser fc]
    (-> this (.uninstallComponents fc))))

(defn get-update-action
  "returns: `javax.swing.Action`"
  (^javax.swing.Action [^javax.swing.plaf.basic.BasicFileChooserUI this]
    (-> this (.getUpdateAction))))

