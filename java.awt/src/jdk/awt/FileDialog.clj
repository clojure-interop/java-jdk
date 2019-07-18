(ns jdk.awt.FileDialog
  "The FileDialog class displays a dialog window
  from which the user can select a file.

  Since it is a modal dialog, when the application calls
  its show method to display the dialog,
  it blocks the rest of the application until the user has
  chosen a file."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt FileDialog]))

(defn ->file-dialog
  "Constructor.

  Creates a file dialog window with the specified title for loading
   or saving a file.

   If the value of mode is LOAD, then the
   file dialog is finding a file to read, and the files shown are those
   in the current directory.   If the value of
   mode is SAVE, the file dialog is finding
   a place to write a file.

  parent - the owner of the dialog - `java.awt.Frame`
  title - the title of the dialog - `java.lang.String`
  mode - the mode of the dialog; either FileDialog.LOAD or FileDialog.SAVE - `int`

  throws: java.lang.IllegalArgumentException - if an illegal file dialog mode is supplied"
  (^FileDialog [^java.awt.Frame parent ^java.lang.String title ^Integer mode]
    (new FileDialog parent title mode))
  (^FileDialog [^java.awt.Frame parent ^java.lang.String title]
    (new FileDialog parent title))
  (^FileDialog [^java.awt.Frame parent]
    (new FileDialog parent)))

(def *-load
  "Static Constant.

  This constant value indicates that the purpose of the file
   dialog window is to locate a file from which to read.

  type: int"
  FileDialog/LOAD)

(def *-save
  "Static Constant.

  This constant value indicates that the purpose of the file
   dialog window is to locate a file to which to write.

  type: int"
  FileDialog/SAVE)

(defn get-mode
  "Indicates whether this file dialog box is for loading from a file
   or for saving to a file.

  returns: the mode of this file dialog window, either
                 FileDialog.LOAD or
                 FileDialog.SAVE - `int`"
  (^Integer [^FileDialog this]
    (-> this (.getMode))))

(defn get-files
  "Returns files that the user selects.

   If the user cancels the file dialog,
   then the method returns an empty array.

  returns: files that the user selects or an empty array
              if the user cancels the file dialog. - `java.io.File[]`"
  ([^FileDialog this]
    (-> this (.getFiles))))

(defn set-mode
  "Sets the mode of the file dialog.  If mode is not
   a legal value, an exception will be thrown and mode
   will not be set.

  mode - the mode for this file dialog, either FileDialog.LOAD or FileDialog.SAVE - `int`

  throws: java.lang.IllegalArgumentException - if an illegal file dialog mode is supplied"
  ([^FileDialog this ^Integer mode]
    (-> this (.setMode mode))))

(defn add-notify
  "Creates the file dialog's peer.  The peer allows us to change the look
   of the file dialog without changing its functionality."
  ([^FileDialog this]
    (-> this (.addNotify))))

(defn set-multiple-mode
  "Enables or disables multiple file selection for the file dialog.

  enable - if true, multiple file selection is enabled; false - disabled. - `boolean`"
  ([^FileDialog this ^Boolean enable]
    (-> this (.setMultipleMode enable))))

(defn multiple-mode?
  "Returns whether the file dialog allows the multiple file selection.

  returns: true if the file dialog allows the multiple
                    file selection; false otherwise. - `boolean`"
  (^Boolean [^FileDialog this]
    (-> this (.isMultipleMode))))

(defn set-file
  "Sets the selected file for this file dialog window to be the
   specified file. This file becomes the default file if it is set
   before the file dialog window is first shown.

   When the dialog is shown, the specified file is selected. The kind of
   selection depends on the file existence, the dialog type, and the native
   platform. E.g., the file could be highlighted in the file list, or a
   file name editbox could be populated with the file name.

   This method accepts either a full file path, or a file name with an
   extension if used together with the setDirectory method.

   Specifying `` as the file is exactly equivalent to specifying
   null as the file.

  file - the file being set - `java.lang.String`"
  ([^FileDialog this ^java.lang.String file]
    (-> this (.setFile file))))

(defn get-file
  "Gets the selected file of this file dialog.  If the user
   selected CANCEL, the returned file is null.

  returns: the currently selected file of this file dialog window,
                  or null if none is selected - `java.lang.String`"
  (^java.lang.String [^FileDialog this]
    (-> this (.getFile))))

(defn set-filename-filter
  "Sets the filename filter for this file dialog window to the
   specified filter.
   Filename filters do not function in Sun's reference
   implementation for Microsoft Windows.

  filter - the specified filter - `java.io.FilenameFilter`"
  ([^FileDialog this ^java.io.FilenameFilter filter]
    (-> this (.setFilenameFilter filter))))

(defn get-directory
  "Gets the directory of this file dialog.

  returns: the (potentially null or invalid)
            directory of this FileDialog - `java.lang.String`"
  (^java.lang.String [^FileDialog this]
    (-> this (.getDirectory))))

(defn set-directory
  "Sets the directory of this file dialog window to be the
   specified directory. Specifying a null or an
   invalid directory implies an implementation-defined default.
   This default will not be realized, however, until the user
   has selected a file. Until this point, getDirectory()
   will return the value passed into this method.

   Specifying `` as the directory is exactly equivalent to
   specifying null as the directory.

  dir - the specified directory - `java.lang.String`"
  ([^FileDialog this ^java.lang.String dir]
    (-> this (.setDirectory dir))))

(defn get-filename-filter
  "Determines this file dialog's filename filter. A filename filter
   allows the user to specify which files appear in the file dialog
   window.  Filename filters do not function in Sun's reference
   implementation for Microsoft Windows.

  returns: this file dialog's filename filter - `java.io.FilenameFilter`"
  (^java.io.FilenameFilter [^FileDialog this]
    (-> this (.getFilenameFilter))))

