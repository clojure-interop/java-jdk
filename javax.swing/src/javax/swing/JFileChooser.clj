(ns javax.swing.JFileChooser
  "JFileChooser provides a simple mechanism for the user to
  choose a file.
  For information about using JFileChooser, see
  How to Use File Choosers,
  a section in The Java Tutorial.



  The following code pops up a file chooser for the user's home directory that
  sees only .jpg and .gif images:


     JFileChooser chooser = new JFileChooser();
     FileNameExtensionFilter filter = new FileNameExtensionFilter(
         `JPG & GIF Images`, `jpg`, `gif`);
     chooser.setFileFilter(filter);
     int returnVal = chooser.showOpenDialog(parent);
     if(returnVal == JFileChooser.APPROVE_OPTION) {
        System.out.println(`You chose to open this file: `
             chooser.getSelectedFile().getName());
     }

  Warning: Swing is not thread safe. For more
  information see Swing's Threading
  Policy."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JFileChooser]))

(defn ->j-file-chooser
  "Constructor.

  Constructs a JFileChooser using the given current directory
   and FileSystemView.

  current-directory - `java.io.File`
  fsv - `javax.swing.filechooser.FileSystemView`"
  ([^java.io.File current-directory ^javax.swing.filechooser.FileSystemView fsv]
    (new JFileChooser current-directory fsv))
  ([^java.lang.String current-directory-path]
    (new JFileChooser current-directory-path))
  ([]
    (new JFileChooser )))

(def *-open-dialog
  "Static Constant.

  Type value indicating that the JFileChooser supports an
   `Open` file operation.

  type: int"
  JFileChooser/OPEN_DIALOG)

(def *-save-dialog
  "Static Constant.

  Type value indicating that the JFileChooser supports a
   `Save` file operation.

  type: int"
  JFileChooser/SAVE_DIALOG)

(def *-custom-dialog
  "Static Constant.

  Type value indicating that the JFileChooser supports a
   developer-specified file operation.

  type: int"
  JFileChooser/CUSTOM_DIALOG)

(def *-cancel-option
  "Static Constant.

  Return value if cancel is chosen.

  type: int"
  JFileChooser/CANCEL_OPTION)

(def *-approve-option
  "Static Constant.

  Return value if approve (yes, ok) is chosen.

  type: int"
  JFileChooser/APPROVE_OPTION)

(def *-error-option
  "Static Constant.

  Return value if an error occurred.

  type: int"
  JFileChooser/ERROR_OPTION)

(def *-files-only
  "Static Constant.

  Instruction to display only files.

  type: int"
  JFileChooser/FILES_ONLY)

(def *-directories-only
  "Static Constant.

  Instruction to display only directories.

  type: int"
  JFileChooser/DIRECTORIES_ONLY)

(def *-files-and-directories
  "Static Constant.

  Instruction to display both files and directories.

  type: int"
  JFileChooser/FILES_AND_DIRECTORIES)

(def *-cancel-selection
  "Static Constant.

  Instruction to cancel the current selection.

  type: java.lang.String"
  JFileChooser/CANCEL_SELECTION)

(def *-approve-selection
  "Static Constant.

  Instruction to approve the current selection
   (same as pressing yes or ok).

  type: java.lang.String"
  JFileChooser/APPROVE_SELECTION)

(def *-approve-button-text-changed-property
  "Static Constant.

  Identifies change in the text on the approve (yes, ok) button.

  type: java.lang.String"
  JFileChooser/APPROVE_BUTTON_TEXT_CHANGED_PROPERTY)

(def *-approve-button-tool-tip-text-changed-property
  "Static Constant.

  Identifies change in the tooltip text for the approve (yes, ok)
   button.

  type: java.lang.String"
  JFileChooser/APPROVE_BUTTON_TOOL_TIP_TEXT_CHANGED_PROPERTY)

(def *-approve-button-mnemonic-changed-property
  "Static Constant.

  Identifies change in the mnemonic for the approve (yes, ok) button.

  type: java.lang.String"
  JFileChooser/APPROVE_BUTTON_MNEMONIC_CHANGED_PROPERTY)

(def *-control-buttons-are-shown-changed-property
  "Static Constant.

  Instruction to display the control buttons.

  type: java.lang.String"
  JFileChooser/CONTROL_BUTTONS_ARE_SHOWN_CHANGED_PROPERTY)

(def *-directory-changed-property
  "Static Constant.

  Identifies user's directory change.

  type: java.lang.String"
  JFileChooser/DIRECTORY_CHANGED_PROPERTY)

(def *-selected-file-changed-property
  "Static Constant.

  Identifies change in user's single-file selection.

  type: java.lang.String"
  JFileChooser/SELECTED_FILE_CHANGED_PROPERTY)

(def *-selected-files-changed-property
  "Static Constant.

  Identifies change in user's multiple-file selection.

  type: java.lang.String"
  JFileChooser/SELECTED_FILES_CHANGED_PROPERTY)

(def *-multi-selection-enabled-changed-property
  "Static Constant.

  Enables multiple-file selections.

  type: java.lang.String"
  JFileChooser/MULTI_SELECTION_ENABLED_CHANGED_PROPERTY)

(def *-file-system-view-changed-property
  "Static Constant.

  Says that a different object is being used to find available drives
   on the system.

  type: java.lang.String"
  JFileChooser/FILE_SYSTEM_VIEW_CHANGED_PROPERTY)

(def *-file-view-changed-property
  "Static Constant.

  Says that a different object is being used to retrieve file
   information.

  type: java.lang.String"
  JFileChooser/FILE_VIEW_CHANGED_PROPERTY)

(def *-file-hiding-changed-property
  "Static Constant.

  Identifies a change in the display-hidden-files property.

  type: java.lang.String"
  JFileChooser/FILE_HIDING_CHANGED_PROPERTY)

(def *-file-filter-changed-property
  "Static Constant.

  User changed the kind of files to display.

  type: java.lang.String"
  JFileChooser/FILE_FILTER_CHANGED_PROPERTY)

(def *-file-selection-mode-changed-property
  "Static Constant.

  Identifies a change in the kind of selection (single,
   multiple, etc.).

  type: java.lang.String"
  JFileChooser/FILE_SELECTION_MODE_CHANGED_PROPERTY)

(def *-accessory-changed-property
  "Static Constant.

  Says that a different accessory component is in use
   (for example, to preview files).

  type: java.lang.String"
  JFileChooser/ACCESSORY_CHANGED_PROPERTY)

(def *-accept-all-file-filter-used-changed-property
  "Static Constant.

  Identifies whether a the AcceptAllFileFilter is used or not.

  type: java.lang.String"
  JFileChooser/ACCEPT_ALL_FILE_FILTER_USED_CHANGED_PROPERTY)

(def *-dialog-title-changed-property
  "Static Constant.

  Identifies a change in the dialog title.

  type: java.lang.String"
  JFileChooser/DIALOG_TITLE_CHANGED_PROPERTY)

(def *-dialog-type-changed-property
  "Static Constant.

  Identifies a change in the type of files displayed (files only,
   directories only, or both files and directories).

  type: java.lang.String"
  JFileChooser/DIALOG_TYPE_CHANGED_PROPERTY)

(def *-choosable-file-filter-changed-property
  "Static Constant.

  Identifies a change in the list of predefined file filters
   the user can choose from.

  type: java.lang.String"
  JFileChooser/CHOOSABLE_FILE_FILTER_CHANGED_PROPERTY)

(defn set-approve-button-tool-tip-text
  "Sets the tooltip text used in the ApproveButton.
   If null, the UI object will determine the button's text.

  tool-tip-text - the tooltip text for the approve button - `java.lang.String`"
  ([^javax.swing.JFileChooser this ^java.lang.String tool-tip-text]
    (-> this (.setApproveButtonToolTipText tool-tip-text))))

(defn get-type-description
  "Returns the file type.

  f - the File - `java.io.File`

  returns: the String containing the file type description for
            f - `java.lang.String`"
  ([^javax.swing.JFileChooser this ^java.io.File f]
    (-> this (.getTypeDescription f))))

(defn multi-selection-enabled?
  "Returns true if multiple files can be selected.

  returns: true if multiple files can be selected - `boolean`"
  ([^javax.swing.JFileChooser this]
    (-> this (.isMultiSelectionEnabled))))

(defn set-dialog-title
  "Sets the string that goes in the JFileChooser window's
   title bar.

  dialog-title - the new String for the title bar - `java.lang.String`"
  ([^javax.swing.JFileChooser this ^java.lang.String dialog-title]
    (-> this (.setDialogTitle dialog-title))))

(defn get-control-buttons-are-shown?
  "Returns the value of the controlButtonsAreShown
   property.

  returns: the value of the controlButtonsAreShown
       property - `boolean`"
  ([^javax.swing.JFileChooser this]
    (-> this (.getControlButtonsAreShown))))

(defn get-file-system-view
  "Returns the file system view.

  returns: the FileSystemView object - `javax.swing.filechooser.FileSystemView`"
  ([^javax.swing.JFileChooser this]
    (-> this (.getFileSystemView))))

(defn set-approve-button-mnemonic
  "Sets the approve button's mnemonic using a numeric keycode.

  mnemonic - an integer value for the mnemonic key - `int`"
  ([^javax.swing.JFileChooser this ^Integer mnemonic]
    (-> this (.setApproveButtonMnemonic mnemonic))))

(defn set-accept-all-file-filter-used
  "Determines whether the AcceptAll FileFilter is used
   as an available choice in the choosable filter list.
   If false, the AcceptAll file filter is removed from
   the list of available file filters.
   If true, the AcceptAll file filter will become the
   the actively used file filter.

  b - `boolean`"
  ([^javax.swing.JFileChooser this ^Boolean b]
    (-> this (.setAcceptAllFileFilterUsed b))))

(defn get-approve-button-text
  "Returns the text used in the ApproveButton in the
   FileChooserUI.
   If null, the UI object will determine the button's text.

   Typically, this would be `Open` or `Save`.

  returns: the text used in the ApproveButton - `java.lang.String`"
  ([^javax.swing.JFileChooser this]
    (-> this (.getApproveButtonText))))

(defn accept-all-file-filter-used?
  "Returns whether the AcceptAll FileFilter is used.

  returns: true if the AcceptAll FileFilter is used - `boolean`"
  ([^javax.swing.JFileChooser this]
    (-> this (.isAcceptAllFileFilterUsed))))

(defn directory-selection-enabled?
  "Convenience call that determines if directories are selectable based
   on the current file selection mode.

  returns: `boolean`"
  ([^javax.swing.JFileChooser this]
    (-> this (.isDirectorySelectionEnabled))))

(defn get-icon
  "Returns the icon for this file or type of file, depending
   on the system.

  f - the File - `java.io.File`

  returns: the Icon for this file, or type of file - `javax.swing.Icon`"
  ([^javax.swing.JFileChooser this ^java.io.File f]
    (-> this (.getIcon f))))

(defn get-file-filter
  "Returns the currently selected file filter.

  returns: the current file filter - `javax.swing.filechooser.FileFilter`"
  ([^javax.swing.JFileChooser this]
    (-> this (.getFileFilter))))

(defn get-accept-all-file-filter
  "Returns the AcceptAll file filter.
   For example, on Microsoft Windows this would be All Files (*.*).

  returns: `javax.swing.filechooser.FileFilter`"
  ([^javax.swing.JFileChooser this]
    (-> this (.getAcceptAllFileFilter))))

(defn add-choosable-file-filter
  "Adds a filter to the list of user choosable file filters.
   For information on setting the file selection mode, see
   setFileSelectionMode.

  filter - the FileFilter to add to the choosable file filter list - `javax.swing.filechooser.FileFilter`"
  ([^javax.swing.JFileChooser this ^javax.swing.filechooser.FileFilter filter]
    (-> this (.addChoosableFileFilter filter))))

(defn add-action-listener
  "Adds an ActionListener to the file chooser.

  l - the listener to be added - `java.awt.event.ActionListener`"
  ([^javax.swing.JFileChooser this ^java.awt.event.ActionListener l]
    (-> this (.addActionListener l))))

(defn get-ui-class-id
  "Returns a string that specifies the name of the L&F class
   that renders this component.

  returns: the string `FileChooserUI` - `java.lang.String`"
  ([^javax.swing.JFileChooser this]
    (-> this (.getUIClassID))))

(defn set-file-filter
  "Sets the current file filter. The file filter is used by the
   file chooser to filter out files from the user's view.

  filter - the new current file filter to use - `javax.swing.filechooser.FileFilter`"
  ([^javax.swing.JFileChooser this ^javax.swing.filechooser.FileFilter filter]
    (-> this (.setFileFilter filter))))

(defn get-approve-button-tool-tip-text
  "Returns the tooltip text used in the ApproveButton.
   If null, the UI object will determine the button's text.

  returns: the tooltip text used for the approve button - `java.lang.String`"
  ([^javax.swing.JFileChooser this]
    (-> this (.getApproveButtonToolTipText))))

(defn set-file-selection-mode
  "Sets the JFileChooser to allow the user to just
   select files, just select
   directories, or select both files and directories.  The default is
   JFilesChooser.FILES_ONLY.

  mode - the type of files to be displayed: JFileChooser.FILES_ONLY JFileChooser.DIRECTORIES_ONLY JFileChooser.FILES_AND_DIRECTORIES - `int`

  throws: java.lang.IllegalArgumentException - if mode is an illegal file selection mode"
  ([^javax.swing.JFileChooser this ^Integer mode]
    (-> this (.setFileSelectionMode mode))))

(defn get-name
  "Returns the filename.

  f - the File - `java.io.File`

  returns: the String containing the filename for
            f - `java.lang.String`"
  ([^javax.swing.JFileChooser this ^java.io.File f]
    (-> this (.getName f))))

(defn set-file-hiding-enabled
  "Sets file hiding on or off. If true, hidden files are not shown
   in the file chooser. The job of determining which files are
   shown is done by the FileView.

  b - the boolean value that determines whether file hiding is turned on - `boolean`"
  ([^javax.swing.JFileChooser this ^Boolean b]
    (-> this (.setFileHidingEnabled b))))

(defn show-save-dialog
  "Pops up a `Save File` file chooser dialog. Note that the
   text that appears in the approve button is determined by
   the L&F.

  parent - the parent component of the dialog, can be null; see showDialog for details - `java.awt.Component`

  returns: the return state of the file chooser on popdown:

   JFileChooser.CANCEL_OPTION
   JFileChooser.APPROVE_OPTION
   JFileChooser.ERROR_OPTION if an error occurs or the
                    dialog is dismissed - `int`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true."
  ([^javax.swing.JFileChooser this ^java.awt.Component parent]
    (-> this (.showSaveDialog parent))))

(defn show-dialog
  "Pops a custom file chooser dialog with a custom approve button.
   For example, the following code
   pops up a file chooser with a `Run Application` button
   (instead of the normal `Save` or `Open` button):


   filechooser.showDialog(parentFrame, `Run Application`);

   Alternatively, the following code does the same thing:


      JFileChooser chooser = new JFileChooser(null);
      chooser.setApproveButtonText(`Run Application`);
      chooser.showDialog(parentFrame, null);

   PENDING(jeff) - the following method should be added to the api:
        showDialog(Component parent);
   PENDING(kwalrath) - should specify modality and what
        `depends` means.



   The parent argument determines two things:
   the frame on which the open dialog depends and
   the component whose position the look and feel
   should consider when placing the dialog.  If the parent
   is a Frame object (such as a JFrame)
   then the dialog depends on the frame and
   the look and feel positions the dialog
   relative to the frame (for example, centered over the frame).
   If the parent is a component, then the dialog
   depends on the frame containing the component,
   and is positioned relative to the component
   (for example, centered over the component).
   If the parent is null, then the dialog depends on
   no visible window, and it's placed in a
   look-and-feel-dependent position
   such as the center of the screen.

  parent - the parent component of the dialog; can be null - `java.awt.Component`
  approve-button-text - the text of the ApproveButton - `java.lang.String`

  returns: the return state of the file chooser on popdown:

   JFileChooser.CANCEL_OPTION
   JFileChooser.APPROVE_OPTION
   JFileChooser.ERROR_OPTION if an error occurs or the
                    dialog is dismissed - `int`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true."
  ([^javax.swing.JFileChooser this ^java.awt.Component parent ^java.lang.String approve-button-text]
    (-> this (.showDialog parent approve-button-text))))

(defn set-file-view
  "Sets the file view to used to retrieve UI information, such as
   the icon that represents a file or the type description of a file.

  file-view - `javax.swing.filechooser.FileView`"
  ([^javax.swing.JFileChooser this ^javax.swing.filechooser.FileView file-view]
    (-> this (.setFileView file-view))))

(defn accept
  "Returns true if the file should be displayed.

  f - the File - `java.io.File`

  returns: true if the file should be displayed, otherwise false - `boolean`"
  ([^javax.swing.JFileChooser this ^java.io.File f]
    (-> this (.accept f))))

(defn traversable?
  "Returns true if the file (directory) can be visited.
   Returns false if the directory cannot be traversed.

  f - the File - `java.io.File`

  returns: true if the file/directory can be traversed, otherwise false - `boolean`"
  ([^javax.swing.JFileChooser this ^java.io.File f]
    (-> this (.isTraversable f))))

(defn get-dialog-title
  "Gets the string that goes in the JFileChooser's titlebar.

  returns: `java.lang.String`"
  ([^javax.swing.JFileChooser this]
    (-> this (.getDialogTitle))))

(defn ensure-file-is-visible
  "Makes sure that the specified file is viewable, and
   not hidden.

  f - a File object - `java.io.File`"
  ([^javax.swing.JFileChooser this ^java.io.File f]
    (-> this (.ensureFileIsVisible f))))

(defn get-description
  "Returns the file description.

  f - the File - `java.io.File`

  returns: the String containing the file description for
            f - `java.lang.String`"
  ([^javax.swing.JFileChooser this ^java.io.File f]
    (-> this (.getDescription f))))

(defn file-selection-enabled?
  "Convenience call that determines if files are selectable based on the
   current file selection mode.

  returns: `boolean`"
  ([^javax.swing.JFileChooser this]
    (-> this (.isFileSelectionEnabled))))

(defn get-choosable-file-filters
  "Gets the list of user choosable file filters.

  returns: a FileFilter array containing all the choosable
           file filters - `javax.swing.filechooser.FileFilter[]`"
  ([^javax.swing.JFileChooser this]
    (-> this (.getChoosableFileFilters))))

(defn set-drag-enabled
  "Sets the dragEnabled property,
   which must be true to enable
   automatic drag handling (the first part of drag and drop)
   on this component.
   The transferHandler property needs to be set
   to a non-null value for the drag to do
   anything.  The default value of the dragEnabled
   property
   is false.



   When automatic drag handling is enabled,
   most look and feels begin a drag-and-drop operation
   whenever the user presses the mouse button over an item
   and then moves the mouse a few pixels.
   Setting this property to true
   can therefore have a subtle effect on
   how selections behave.



   Some look and feels might not support automatic drag and drop;
   they will ignore this property.  You can work around such
   look and feels by modifying the component
   to directly call the exportAsDrag method of a
   TransferHandler.

  b - the value to set the dragEnabled property to - `boolean`

  throws: java.awt.HeadlessException - if b is true and GraphicsEnvironment.isHeadless() returns true"
  ([^javax.swing.JFileChooser this ^Boolean b]
    (-> this (.setDragEnabled b))))

(defn get-dialog-type
  "Returns the type of this dialog.  The default is
   JFileChooser.OPEN_DIALOG.

  returns: the type of dialog to be displayed:

   JFileChooser.OPEN_DIALOG
   JFileChooser.SAVE_DIALOG
   JFileChooser.CUSTOM_DIALOG - `int`"
  ([^javax.swing.JFileChooser this]
    (-> this (.getDialogType))))

(defn set-multi-selection-enabled
  "Sets the file chooser to allow multiple file selections.

  b - true if multiple files may be selected - `boolean`"
  ([^javax.swing.JFileChooser this ^Boolean b]
    (-> this (.setMultiSelectionEnabled b))))

(defn get-ui
  "Gets the UI object which implements the L&F for this component.

  returns: the FileChooserUI object that implements the FileChooserUI L&F - `javax.swing.plaf.FileChooserUI`"
  ([^javax.swing.JFileChooser this]
    (-> this (.getUI))))

(defn get-action-listeners
  "Returns an array of all the action listeners
   registered on this file chooser.

  returns: all of this file chooser's ActionListeners
           or an empty
           array if no action listeners are currently registered - `java.awt.event.ActionListener[]`"
  ([^javax.swing.JFileChooser this]
    (-> this (.getActionListeners))))

(defn reset-choosable-file-filters
  "Resets the choosable file filter list to its starting state. Normally,
   this removes all added file filters while leaving the
   AcceptAll file filter."
  ([^javax.swing.JFileChooser this]
    (-> this (.resetChoosableFileFilters))))

(defn set-selected-file
  "Sets the selected file. If the file's parent directory is
   not the current directory, changes the current directory
   to be the file's parent directory.

  file - the selected file - `java.io.File`"
  ([^javax.swing.JFileChooser this ^java.io.File file]
    (-> this (.setSelectedFile file))))

(defn set-control-buttons-are-shown
  "Sets the property
   that indicates whether the approve and cancel
   buttons are shown in the file chooser.  This property
   is true by default.  Look and feels
   that always show these buttons will ignore the value
   of this property.
   This method fires a property-changed event,
   using the string value of
   CONTROL_BUTTONS_ARE_SHOWN_CHANGED_PROPERTY
   as the name of the property.

  b - false if control buttons should not be shown; otherwise, true - `boolean`"
  ([^javax.swing.JFileChooser this ^Boolean b]
    (-> this (.setControlButtonsAreShown b))))

(defn get-selected-file
  "Returns the selected file. This can be set either by the
   programmer via setSelectedFile or by a user action, such as
   either typing the filename into the UI or selecting the
   file from a list in the UI.

  returns: the selected file - `java.io.File`"
  ([^javax.swing.JFileChooser this]
    (-> this (.getSelectedFile))))

(defn get-file-selection-mode
  "Returns the current file-selection mode.  The default is
   JFilesChooser.FILES_ONLY.

  returns: the type of files to be displayed, one of the following:

   JFileChooser.FILES_ONLY
   JFileChooser.DIRECTORIES_ONLY
   JFileChooser.FILES_AND_DIRECTORIES - `int`"
  ([^javax.swing.JFileChooser this]
    (-> this (.getFileSelectionMode))))

(defn rescan-current-directory
  "Tells the UI to rescan its files list from the current directory."
  ([^javax.swing.JFileChooser this]
    (-> this (.rescanCurrentDirectory))))

(defn show-open-dialog
  "Pops up an `Open File` file chooser dialog. Note that the
   text that appears in the approve button is determined by
   the L&F.

  parent - the parent component of the dialog, can be null; see showDialog for details - `java.awt.Component`

  returns: the return state of the file chooser on popdown:

   JFileChooser.CANCEL_OPTION
   JFileChooser.APPROVE_OPTION
   JFileChooser.ERROR_OPTION if an error occurs or the
                    dialog is dismissed - `int`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true."
  ([^javax.swing.JFileChooser this ^java.awt.Component parent]
    (-> this (.showOpenDialog parent))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JFileChooser.
   For file choosers, the AccessibleContext takes the form of an
   AccessibleJFileChooser.
   A new AccessibleJFileChooser instance is created if necessary.

  returns: an AccessibleJFileChooser that serves as the
           AccessibleContext of this JFileChooser - `javax.accessibility.AccessibleContext`"
  ([^javax.swing.JFileChooser this]
    (-> this (.getAccessibleContext))))

(defn remove-choosable-file-filter
  "Removes a filter from the list of user choosable file filters. Returns
   true if the file filter was removed.

  f - `javax.swing.filechooser.FileFilter`

  returns: `boolean`"
  ([^javax.swing.JFileChooser this ^javax.swing.filechooser.FileFilter f]
    (-> this (.removeChoosableFileFilter f))))

(defn set-file-system-view
  "Sets the file system view that the JFileChooser uses for
   accessing and creating file system resources, such as finding
   the floppy drive and getting a list of root drives.

  fsv - the new FileSystemView - `javax.swing.filechooser.FileSystemView`"
  ([^javax.swing.JFileChooser this ^javax.swing.filechooser.FileSystemView fsv]
    (-> this (.setFileSystemView fsv))))

(defn set-accessory
  "Sets the accessory component. An accessory is often used to show a
   preview image of the selected file; however, it can be used for anything
   that the programmer wishes, such as extra custom file chooser controls.


   Note: if there was a previous accessory, you should unregister
   any listeners that the accessory might have registered with the
   file chooser.

  new-accessory - `javax.swing.JComponent`"
  ([^javax.swing.JFileChooser this ^javax.swing.JComponent new-accessory]
    (-> this (.setAccessory new-accessory))))

(defn get-drag-enabled?
  "Gets the value of the dragEnabled property.

  returns: the value of the dragEnabled property - `boolean`"
  ([^javax.swing.JFileChooser this]
    (-> this (.getDragEnabled))))

(defn remove-action-listener
  "Removes an ActionListener from the file chooser.

  l - the listener to be removed - `java.awt.event.ActionListener`"
  ([^javax.swing.JFileChooser this ^java.awt.event.ActionListener l]
    (-> this (.removeActionListener l))))

(defn file-hiding-enabled?
  "Returns true if hidden files are not shown in the file chooser;
   otherwise, returns false.

  returns: the status of the file hiding property - `boolean`"
  ([^javax.swing.JFileChooser this]
    (-> this (.isFileHidingEnabled))))

(defn set-selected-files
  "Sets the list of selected files if the file chooser is
   set to allow multiple selection.

  selected-files - `java.io.File[]`"
  ([^javax.swing.JFileChooser this ^java.io.File[] selected-files]
    (-> this (.setSelectedFiles selected-files))))

(defn get-approve-button-mnemonic
  "Returns the approve button's mnemonic.

  returns: an integer value for the mnemonic key - `int`"
  ([^javax.swing.JFileChooser this]
    (-> this (.getApproveButtonMnemonic))))

(defn get-accessory
  "Returns the accessory component.

  returns: this JFileChooser's accessory component, or null - `javax.swing.JComponent`"
  ([^javax.swing.JFileChooser this]
    (-> this (.getAccessory))))

(defn get-current-directory
  "Returns the current directory.

  returns: the current directory - `java.io.File`"
  ([^javax.swing.JFileChooser this]
    (-> this (.getCurrentDirectory))))

(defn get-selected-files
  "Returns a list of selected files if the file chooser is
   set to allow multiple selection.

  returns: `java.io.File[]`"
  ([^javax.swing.JFileChooser this]
    (-> this (.getSelectedFiles))))

(defn set-dialog-type
  "Sets the type of this dialog. Use OPEN_DIALOG when you
   want to bring up a file chooser that the user can use to open a file.
   Likewise, use SAVE_DIALOG for letting the user choose
   a file for saving.
   Use CUSTOM_DIALOG when you want to use the file
   chooser in a context other than `Open` or `Save`.
   For instance, you might want to bring up a file chooser that allows
   the user to choose a file to execute. Note that you normally would not
   need to set the JFileChooser to use
   CUSTOM_DIALOG
   since a call to setApproveButtonText does this for you.
   The default dialog type is JFileChooser.OPEN_DIALOG.

  dialog-type - the type of dialog to be displayed: JFileChooser.OPEN_DIALOG JFileChooser.SAVE_DIALOG JFileChooser.CUSTOM_DIALOG - `int`

  throws: java.lang.IllegalArgumentException - if dialogType is not legal"
  ([^javax.swing.JFileChooser this ^Integer dialog-type]
    (-> this (.setDialogType dialog-type))))

(defn approve-selection
  "Called by the UI when the user hits the Approve button
   (labeled `Open` or `Save`, by default). This can also be
   called by the programmer.
   This method causes an action event to fire
   with the command string equal to
   APPROVE_SELECTION."
  ([^javax.swing.JFileChooser this]
    (-> this (.approveSelection))))

(defn set-current-directory
  "Sets the current directory. Passing in null sets the
   file chooser to point to the user's default directory.
   This default depends on the operating system. It is
   typically the `My Documents` folder on Windows, and the user's
   home directory on Unix.

   If the file passed in as currentDirectory is not a
   directory, the parent of the file will be used as the currentDirectory.
   If the parent is not traversable, then it will walk up the parent tree
   until it finds a traversable directory, or hits the root of the
   file system.

  dir - the current directory to point to - `java.io.File`"
  ([^javax.swing.JFileChooser this ^java.io.File dir]
    (-> this (.setCurrentDirectory dir))))

(defn update-ui
  "Resets the UI property to a value from the current look and feel."
  ([^javax.swing.JFileChooser this]
    (-> this (.updateUI))))

(defn get-file-view
  "Returns the current file view.

  returns: `javax.swing.filechooser.FileView`"
  ([^javax.swing.JFileChooser this]
    (-> this (.getFileView))))

(defn cancel-selection
  "Called by the UI when the user chooses the Cancel button.
   This can also be called by the programmer.
   This method causes an action event to fire
   with the command string equal to
   CANCEL_SELECTION."
  ([^javax.swing.JFileChooser this]
    (-> this (.cancelSelection))))

(defn set-approve-button-text
  "Sets the text used in the ApproveButton in the
   FileChooserUI.

  approve-button-text - the text used in the ApproveButton - `java.lang.String`"
  ([^javax.swing.JFileChooser this ^java.lang.String approve-button-text]
    (-> this (.setApproveButtonText approve-button-text))))

(defn change-to-parent-directory
  "Changes the directory to be set to the parent of the
   current directory."
  ([^javax.swing.JFileChooser this]
    (-> this (.changeToParentDirectory))))

