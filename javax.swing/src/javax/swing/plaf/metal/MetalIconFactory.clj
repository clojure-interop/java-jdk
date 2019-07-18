(ns javax.swing.plaf.metal.MetalIconFactory
  "Factory object that vends Icons for
  the Java™ look and feel (Metal).
  These icons are used extensively in Metal via the defaults mechanism.
  While other look and feels often use GIFs for icons, creating icons
  in code facilitates switching to other themes.


  Each method in this class returns
  either an Icon or null,
  where null implies that there is no default icon.


  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalIconFactory]))

(defn ->metal-icon-factory
  "Constructor."
  (^MetalIconFactory []
    (new MetalIconFactory )))

(def *-dark
  "Static Constant.

  type: boolean"
  MetalIconFactory/DARK)

(def *-light
  "Static Constant.

  type: boolean"
  MetalIconFactory/LIGHT)

(defn *get-radio-button-menu-item-icon
  "returns: `javax.swing.Icon`"
  (^javax.swing.Icon []
    (MetalIconFactory/getRadioButtonMenuItemIcon )))

(defn *get-vertical-slider-thumb-icon
  "returns: `javax.swing.Icon`"
  (^javax.swing.Icon []
    (MetalIconFactory/getVerticalSliderThumbIcon )))

(defn *get-internal-frame-alt-maximize-icon
  "size - `int`

  returns: `javax.swing.Icon`"
  (^javax.swing.Icon [^Integer size]
    (MetalIconFactory/getInternalFrameAltMaximizeIcon size)))

(defn *get-internal-frame-close-icon
  "size - `int`

  returns: `javax.swing.Icon`"
  (^javax.swing.Icon [^Integer size]
    (MetalIconFactory/getInternalFrameCloseIcon size)))

(defn *get-horizontal-slider-thumb-icon
  "returns: `javax.swing.Icon`"
  (^javax.swing.Icon []
    (MetalIconFactory/getHorizontalSliderThumbIcon )))

(defn *get-file-chooser-list-view-icon
  "returns: `javax.swing.Icon`"
  (^javax.swing.Icon []
    (MetalIconFactory/getFileChooserListViewIcon )))

(defn *get-internal-frame-default-menu-icon
  "returns: `javax.swing.Icon`"
  (^javax.swing.Icon []
    (MetalIconFactory/getInternalFrameDefaultMenuIcon )))

(defn *get-file-chooser-home-folder-icon
  "returns: `javax.swing.Icon`"
  (^javax.swing.Icon []
    (MetalIconFactory/getFileChooserHomeFolderIcon )))

(defn *get-radio-button-icon
  "returns: `javax.swing.Icon`"
  (^javax.swing.Icon []
    (MetalIconFactory/getRadioButtonIcon )))

(defn *get-check-box-menu-item-icon
  "returns: `javax.swing.Icon`"
  (^javax.swing.Icon []
    (MetalIconFactory/getCheckBoxMenuItemIcon )))

(defn *get-tree-control-icon
  "is-collapsed - `boolean`

  returns: `javax.swing.Icon`"
  (^javax.swing.Icon [^Boolean is-collapsed]
    (MetalIconFactory/getTreeControlIcon is-collapsed)))

(defn *get-menu-arrow-icon
  "returns: `javax.swing.Icon`"
  (^javax.swing.Icon []
    (MetalIconFactory/getMenuArrowIcon )))

(defn *get-tree-folder-icon
  "returns: `javax.swing.Icon`"
  (^javax.swing.Icon []
    (MetalIconFactory/getTreeFolderIcon )))

(defn *get-menu-item-check-icon
  "Returns an icon to be used by JCheckBoxMenuItem.

  returns: the default icon for check box menu items,
           or null if no default exists - `javax.swing.Icon`"
  (^javax.swing.Icon []
    (MetalIconFactory/getMenuItemCheckIcon )))

(defn *get-internal-frame-minimize-icon
  "size - `int`

  returns: `javax.swing.Icon`"
  (^javax.swing.Icon [^Integer size]
    (MetalIconFactory/getInternalFrameMinimizeIcon size)))

(defn *get-menu-item-arrow-icon
  "returns: `javax.swing.Icon`"
  (^javax.swing.Icon []
    (MetalIconFactory/getMenuItemArrowIcon )))

(defn *get-internal-frame-maximize-icon
  "size - `int`

  returns: `javax.swing.Icon`"
  (^javax.swing.Icon [^Integer size]
    (MetalIconFactory/getInternalFrameMaximizeIcon size)))

(defn *get-file-chooser-up-folder-icon
  "returns: `javax.swing.Icon`"
  (^javax.swing.Icon []
    (MetalIconFactory/getFileChooserUpFolderIcon )))

(defn *get-tree-floppy-drive-icon
  "returns: `javax.swing.Icon`"
  (^javax.swing.Icon []
    (MetalIconFactory/getTreeFloppyDriveIcon )))

(defn *get-check-box-icon
  "Returns a checkbox icon.

  returns: `javax.swing.Icon`"
  (^javax.swing.Icon []
    (MetalIconFactory/getCheckBoxIcon )))

(defn *get-file-chooser-new-folder-icon
  "returns: `javax.swing.Icon`"
  (^javax.swing.Icon []
    (MetalIconFactory/getFileChooserNewFolderIcon )))

(defn *get-file-chooser-detail-view-icon
  "returns: `javax.swing.Icon`"
  (^javax.swing.Icon []
    (MetalIconFactory/getFileChooserDetailViewIcon )))

(defn *get-tree-leaf-icon
  "returns: `javax.swing.Icon`"
  (^javax.swing.Icon []
    (MetalIconFactory/getTreeLeafIcon )))

(defn *get-tree-computer-icon
  "returns: `javax.swing.Icon`"
  (^javax.swing.Icon []
    (MetalIconFactory/getTreeComputerIcon )))

(defn *get-tree-hard-drive-icon
  "returns: `javax.swing.Icon`"
  (^javax.swing.Icon []
    (MetalIconFactory/getTreeHardDriveIcon )))

