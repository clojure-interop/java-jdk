(ns javax.swing.plaf.FileChooserUI
  "Pluggable look and feel interface for JFileChooser."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf FileChooserUI]))

(defn ->file-chooser-ui
  "Constructor."
  ([]
    (new FileChooserUI )))

(defn get-accept-all-file-filter
  "fc - `javax.swing.JFileChooser`

  returns: `javax.swing.filechooser.FileFilter`"
  ([^javax.swing.plaf.FileChooserUI this ^javax.swing.JFileChooser fc]
    (-> this (.getAcceptAllFileFilter fc))))

(defn get-file-view
  "fc - `javax.swing.JFileChooser`

  returns: `javax.swing.filechooser.FileView`"
  ([^javax.swing.plaf.FileChooserUI this ^javax.swing.JFileChooser fc]
    (-> this (.getFileView fc))))

(defn get-approve-button-text
  "fc - `javax.swing.JFileChooser`

  returns: `java.lang.String`"
  ([^javax.swing.plaf.FileChooserUI this ^javax.swing.JFileChooser fc]
    (-> this (.getApproveButtonText fc))))

(defn get-dialog-title
  "fc - `javax.swing.JFileChooser`

  returns: `java.lang.String`"
  ([^javax.swing.plaf.FileChooserUI this ^javax.swing.JFileChooser fc]
    (-> this (.getDialogTitle fc))))

(defn rescan-current-directory
  "fc - `javax.swing.JFileChooser`"
  ([^javax.swing.plaf.FileChooserUI this ^javax.swing.JFileChooser fc]
    (-> this (.rescanCurrentDirectory fc))))

(defn ensure-file-is-visible
  "fc - `javax.swing.JFileChooser`
  f - `java.io.File`"
  ([^javax.swing.plaf.FileChooserUI this ^javax.swing.JFileChooser fc ^java.io.File f]
    (-> this (.ensureFileIsVisible fc f))))

(defn get-default-button
  "Returns default button for current LookAndFeel.
   JFileChooser will use this button as default button
   for dialog windows.

  fc - `javax.swing.JFileChooser`

  returns: `javax.swing.JButton`"
  ([^javax.swing.plaf.FileChooserUI this ^javax.swing.JFileChooser fc]
    (-> this (.getDefaultButton fc))))

